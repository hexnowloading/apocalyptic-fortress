package net.hexnowloading.hexfortress.block;

import net.hexnowloading.hexfortress.config.HFCommonConfigs;
import net.hexnowloading.hexfortress.registry.HFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collection;

public class ExplosiveBarrelBlock extends FallingBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16,14);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public ExplosiveBarrelBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos blockPos, Block block, BlockPos signalPos, boolean moved) {
        if (level.hasNeighborSignal(blockPos)) {
            onCaughtFire(state, level, blockPos, null, null);
            this.explode(level, blockPos);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    public void explode(Level level, BlockPos pos) {
        if (level.getBlockState(pos.below()).is(HFBlocks.WITHER_LEAVES.get())) {
            AreaEffectCloud areaEffectCloud = new AreaEffectCloud(level, pos.getX(), pos.getY() - 1D, pos.getZ());
            areaEffectCloud.setRadius(5.0F);
            areaEffectCloud.setRadiusOnUse(-0.5F);
            areaEffectCloud.setWaitTime(10);
            areaEffectCloud.setDuration(areaEffectCloud.getDuration() / 2);
            areaEffectCloud.setRadiusPerTick(-areaEffectCloud.getRadius() / (float)areaEffectCloud.getDuration());
            areaEffectCloud.addEffect(new MobEffectInstance(MobEffects.WITHER, 40));
            level.addFreshEntity(areaEffectCloud);
        }
        level.removeBlock(pos, false);
        if (HFCommonConfigs.DESTRUCTIVE_BARREL.get()) {
            level.explode((Entity)null, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 4.0F, Level.ExplosionInteraction.TNT);
        } else {
            level.explode((Entity)null, pos.getX(), pos.getY() + 0.5D, pos.getZ(), 4.0F, Level.ExplosionInteraction.NONE);
        }
    }

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult blockHitResult, Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = blockHitResult.getBlockPos();
            Entity entity = projectile.getOwner();
            if (projectile.isOnFire() && projectile.mayInteract(level, blockpos)) {
                onCaughtFire(state, level, blockpos, null, entity instanceof LivingEntity ? (LivingEntity)entity : null);
                this.explode(level, blockpos);
            }
        }
    }

    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!itemstack.is(Items.FLINT_AND_STEEL) && !itemstack.is(Items.FIRE_CHARGE)) {
            return super.use(state, level, pos, player, hand, hitResult);
        } else {
            onCaughtFire(state, level, pos, hitResult.getDirection(), player);
            this.explode(level, pos);
            Item item = itemstack.getItem();
            if (!player.isCreative()) {
                if (itemstack.is(Items.FLINT_AND_STEEL)) {
                    itemstack.hurtAndBreak(1, player, (p_57425_) -> {
                        p_57425_.broadcastBreakEvent(hand);
                    });
                } else {
                    itemstack.shrink(1);
                }
            }

            player.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
    }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState state1, BlockState state2, FallingBlockEntity fallingBlockEntity) {
        this.explode(level, pos);
    }

    @Override
    public void onBlockExploded(BlockState state, Level level, BlockPos pos, Explosion explosion) {
        super.onBlockExploded(state, level, pos, explosion);
        FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, pos, state);
        this.falling(fallingblockentity);
    }

    @Override
    public boolean dropFromExplosion(Explosion explosion) {
        return false;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        for(int i = 0; i < 1; ++i) {
            if (source.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, d0 + 0.5D, d1 + 1.0D, d2 + 0.5D, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType computationType) {
        return false;
    }
}
