package net.hexnowloading.hexfortress.block;

import net.hexnowloading.hexfortress.block.entity.LockedChestBlockEntity;
import net.hexnowloading.hexfortress.registry.HFBlocks;
import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LockedChestBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE_X = Block.box(1.5D, 0.0D, 1.0D, 14.5D, 14.0D, 15.0D);
    private static final VoxelShape SHAPE_Z = Block.box(1.0D, 0.0D, 1.5D, 15.0D, 14.0D, 14.5D);

    public LockedChestBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
        switch (state.getValue(FACING).getAxis()) {
            case X:
            default:
                return SHAPE_X;
            case Z:
                return SHAPE_Z;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction direction = ctx.getHorizontalDirection().getOpposite();
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(FACING, direction).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
    }

    // Makes the block waterlogged when placed in water.
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(FACING, WATERLOGGED);
    }

    public static boolean isKey(ItemStack itemStack) {
        return itemStack.is(HFItems.BLAZE_KEY.get());
    }

    private void unlockBlockState(BlockState state, Level level, BlockPos pos) {
        CompoundTag lootTable = level.getBlockEntity(pos).saveWithFullMetadata().copy();
        level.setBlock(pos, HFBlocks.DUNGEON_CHEST.get().withPropertiesOf(state), 0);
        BlockEntity chestEntity = level.getBlockEntity(pos);
        chestEntity.load(lootTable);
        chestEntity.setChanged();
    }

    private void playSound(Level level, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.5D;

        level.playSound((Player)null, d0, d1, d2, soundEvent, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (isKey(itemStack)) {
                LockedChestBlock.this.playSound(level, pos, state, SoundEvents.ARROW_HIT_PLAYER);
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                unlockBlockState(state, level, pos);
                return InteractionResult.CONSUME;
            } else {
                player.displayClientMessage(Component.translatable("warning.hexfortress.locked_chest"), true);
                this.playSound(level, pos, state, SoundEvents.CHEST_LOCKED);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LockedChestBlockEntity(pos, state);
    }
}
