package net.hexnowloading.hexfortress.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;

public class BlazeClusterBlock extends RodBlock {
    public BlazeClusterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.UP));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_53087_) {
        Direction direction = p_53087_.getClickedFace();
        BlockState blockstate = p_53087_.getLevel().getBlockState(p_53087_.getClickedPos().relative(direction.getOpposite()));
        return blockstate.is(this) && blockstate.getValue(FACING) == direction ? this.defaultBlockState().setValue(FACING, direction.getOpposite()) : this.defaultBlockState().setValue(FACING, direction);
    }

    @Override
    public void animateTick(BlockState p_221107_, Level p_221108_, BlockPos p_221109_, RandomSource p_221110_) {
        Direction direction = p_221107_.getValue(FACING);
        double d0 = (double)p_221109_.getX() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d1 = (double)p_221109_.getY() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d2 = (double)p_221109_.getZ() + 0.55D - (double)(p_221110_.nextFloat() * 0.1F);
        double d3 = (double)(0.4F - (p_221110_.nextFloat() + p_221110_.nextFloat()) * 0.4F);
        if (p_221110_.nextInt(5) == 0) {
            p_221108_.addParticle(ParticleTypes.FLAME, d0 + (double)direction.getStepX() * d3, d1 + (double)direction.getStepY() * d3, d2 + (double)direction.getStepZ() * d3, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D, p_221110_.nextGaussian() * 0.005D);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.NORMAL;
    }
}
