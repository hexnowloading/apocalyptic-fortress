package net.hexnowloading.hexfortress.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
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

public class PotBlock extends FallingBlock implements SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 13,12);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public PotBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
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

    @Override
    public void onProjectileHit(Level level, BlockState state, BlockHitResult hitREsult, Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = hitREsult.getBlockPos();
            //Entity entity = projectile.getOwner();
            level.destroyBlock(blockpos, true);
        }
    }

    @Override
    public void onLand(Level level, BlockPos pos, BlockState state1, BlockState state2, FallingBlockEntity fallingBlockEntity) {
        level.destroyBlock(pos, true);
    }

    @Override
    protected void falling(FallingBlockEntity fallingBlockEntity) {
        fallingBlockEntity.setHurtsEntities(2.0F, 20);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType computationType) {
        return false;
    }
}
