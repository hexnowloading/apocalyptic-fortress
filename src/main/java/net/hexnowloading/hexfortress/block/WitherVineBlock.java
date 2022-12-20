package net.hexnowloading.hexfortress.block;

import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.Ghast;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.Nullable;

public class WitherVineBlock extends MultifaceBlock implements BonemealableBlock {

    private final MultifaceSpreader spreader = new MultifaceSpreader(this);

    public WitherVineBlock(Properties properties) {
        super(properties);
    }


    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getZ();
        for(int i = 0; i < 1; ++i) {
            if (source.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, d0 + source.nextDouble(), (double)pos.getY() + (0.5D - source.nextDouble()), d1 + source.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    private boolean shouldDamage(LivingEntity livingEntity) {
        return !(livingEntity instanceof WitherSkeleton || livingEntity instanceof Blaze || livingEntity instanceof Ghast || livingEntity instanceof Player);
    }

    private boolean shouldDamagePlayer(LivingEntity livingEntity, Level level) {
        return livingEntity instanceof Player && !level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL && !((Player) livingEntity).getAbilities().instabuild;
    };

    @Override
    @Deprecated
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (shouldDamage(livingEntity) || shouldDamagePlayer(livingEntity, level)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 40));
            }
        }
    }

    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean moved) {
        return Direction.stream().anyMatch((direction) -> {
            return this.spreader.canSpreadInAnyDirection(state, getter, pos, direction.getOpposite());
        });
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState state, boolean b) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState state) {
        this.spreader.spreadFromRandomFaceTowardRandomDirection(state, serverLevel, pos, randomSource);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, blockEntity, stack);
        if (!level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL && !stack.is(HFItems.WITHERITE_SWORD.get()) && !stack.is(HFItems.WITHERITE_SHEARS.get())) {
            player.addEffect(new MobEffectInstance(MobEffects.WITHER, 40,1));
        }
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType computationType) {
        return false;
    }
}
