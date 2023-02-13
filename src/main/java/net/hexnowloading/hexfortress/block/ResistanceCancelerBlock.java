package net.hexnowloading.hexfortress.block;

import net.hexnowloading.hexfortress.block.entity.ResistanceCancelerBlockEntity;
import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.hexnowloading.hexfortress.registry.HFBlocks;
import net.hexnowloading.hexfortress.registry.HFItems;
import net.hexnowloading.hexfortress.registry.HFProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

public class ResistanceCancelerBlock extends BaseEntityBlock implements EntityBlock, SimpleWaterloggedBlock {
    private static final BooleanProperty LOCKED = HFProperties.LOCKED;
    private static final BooleanProperty ACTIVATED = HFProperties.ACTIVATED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final IntegerProperty RANGE = HFProperties.RANGE;

    public ResistanceCancelerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(LOCKED, Boolean.FALSE).setValue(ACTIVATED, Boolean.TRUE).setValue(WATERLOGGED, Boolean.FALSE).setValue(RANGE, Integer.valueOf(32)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(LOCKED).add(ACTIVATED).add(WATERLOGGED).add(RANGE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        FluidState fluidstate = ctx.getLevel().getFluidState(ctx.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public static boolean isKey(ItemStack itemStack) {
        return itemStack.is(HFItems.BLAZE_KEY.get());
    }

    public static boolean isLavaBucket(ItemStack itemStack) { return itemStack.is(Items.LAVA_BUCKET); }

    public static boolean isWaterBucket(ItemStack itemStack) { return itemStack.is(Items.WATER_BUCKET); }

    public static boolean isBlazePowder(ItemStack itemStack) { return itemStack.is(Items.BLAZE_POWDER); }

    public void unlockBlockState(BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos, state.setValue(HFProperties.LOCKED, false), 0);
    }

    public void lockBlockState(BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos, state.setValue(HFProperties.LOCKED, true), 0);
    }

    public void deactivateBlockState(BlockState state, Level level, BlockPos pos) {
        playSound(level, pos, state, SoundEvents.BEACON_DEACTIVATE);
        level.setBlock(pos, state.setValue(HFProperties.ACTIVATED, false), 0);
    }

    public void activateBlockState(BlockState state, Level level, BlockPos pos) {
        playSound(level, pos, state, SoundEvents.BEACON_ACTIVATE);
        level.setBlock(pos, state.setValue(HFProperties.ACTIVATED, true), 0);
    }

    public void increaseRange(Player player, BlockState state, Level level, BlockPos pos) {
        if (state.getValue(HFProperties.RANGE) < 64) {
            level.setBlock(pos, state.setValue(HFProperties.RANGE, state.getValue(HFProperties.RANGE) + 1), 0);
            player.displayClientMessage(Component.translatable("warning.hexfortress.resistance_canceler_increase_range", state.getValue(HFProperties.RANGE) + 1), true);
        } else {
            player.displayClientMessage(Component.translatable("warning.hexfortress.resistance_canceler_increase_range_cancel"), true);
        }
    }

    public void decreaseRange(Player player, BlockState state, Level level, BlockPos pos) {
        if (state.getValue(HFProperties.RANGE) > 1) {
            level.setBlock(pos, state.setValue(HFProperties.RANGE, state.getValue(HFProperties.RANGE) - 1), 0);
            player.displayClientMessage(Component.translatable("warning.hexfortress.resistance_canceler_decrease_range", state.getValue(HFProperties.RANGE) - 1), true);
        } else {
            player.displayClientMessage(Component.translatable("warning.hexfortress.resistance_canceler_decrease_range_cancel"), true);
        }
    }

    public void spawnReward(Level level, BlockState state, BlockPos pos) {
        RandomSource randomSource = level.getRandom();
        if (level instanceof  ServerLevel) {
            double d0 = (double) pos.getX() + 0.5D;
            double d1 = (double) pos.getY() + 0.5D;
            double d2 = (double) pos.getZ() + 0.5D;
            ((ServerLevel) level).sendParticles(ParticleTypes.SMOKE, d0, d1, d2, 5, 0.5D, 0.5D, 0.5D, 0.001D);
            if (randomSource.nextFloat() < 0.05F) {
                double x = pos.getX() + 0.5D;
                double y = pos.getY() + 0.8D;
                double z = pos.getZ() + 0.5D;

                double speed = randomSource.nextGaussian() * 0.2D;

                ((ServerLevel) level).sendParticles(ParticleTypes.FLAME, x, y, z, 20, 0, 0, 0, speed);

                playSound(level, pos, state, SoundEvents.FIRECHARGE_USE);
                popResource(level, pos, new ItemStack(HFItems.BLAZE_CORE.get(), 1));
                level.destroyBlock(pos, false);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            ItemStack itemStack = player.getItemInHand(hand);
            if (player.getAbilities().instabuild) {
                if (isKey(itemStack)) {
                    if (state.getValue(HFProperties.LOCKED)) {
                        unlockBlockState(state, level, pos);
                    } else {
                        lockBlockState(state, level, pos);
                    }
                } else {
                    if (state.getValue(HFProperties.ACTIVATED)) {
                        if (isLavaBucket(itemStack)) {
                            increaseRange(player, state, level, pos);
                        } else if (isWaterBucket(itemStack)) {
                            decreaseRange(player, state, level, pos);
                        } else if (isBlazePowder(itemStack)) {
                            playSound(level, pos, state, SoundEvents.FIRECHARGE_USE);
                            spawnReward(level, state, pos);
                            return InteractionResult.CONSUME;
                        } else {
                            deactivateBlockState(state, level, pos);
                        }
                    } else {
                        activateBlockState(state, level, pos);
                    }
                }
            } else {
                if (state.getValue(HFProperties.LOCKED)) {
                    if (isKey(itemStack)) {
                        playSound(level, pos, state, SoundEvents.ARROW_HIT_PLAYER);
                        itemStack.shrink(1);
                        unlockBlockState(state, level, pos);
                        return InteractionResult.CONSUME;
                    } else {
                        player.displayClientMessage(Component.translatable("warning.hexfortress.locked_resistance_canceler"), true);
                        playSound(level, pos, state, SoundEvents.NOTE_BLOCK_BASS);
                    }
                } else {
                    if (state.getValue(HFProperties.ACTIVATED)) {
                        if (isLavaBucket(itemStack)) {
                            increaseRange(player, state, level, pos);
                        } else if (isWaterBucket(itemStack)) {
                            decreaseRange(player, state, level, pos);
                        } else if (isBlazePowder(itemStack)) {
                            playSound(level, pos, state, SoundEvents.FIRECHARGE_USE);
                            itemStack.shrink(1);
                            spawnReward(level, state, pos);
                            return InteractionResult.CONSUME;
                        } else {
                            deactivateBlockState(state, level, pos);
                        }
                    } else {
                        activateBlockState(state, level, pos);
                    }
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, HFBlockEntities.RESISTANCE_CANCELER.get(), ResistanceCancelerBlockEntity::tick);
    }

    private void playSound(Level level, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.5D;

        level.playSound((Player)null, d0, d1, d2, soundEvent, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        if (state.getValue(ACTIVATED)) {
            for (int i = 0; i < 3; ++i) {
                if (source.nextBoolean()) {
                    level.addParticle(ParticleTypes.FLAME, d0 + source.nextDouble() * 1.5D, d1 + source.nextDouble() * 1.5D, d2 + source.nextDouble() * 1.5D, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ResistanceCancelerBlockEntity(pos, state);
    }
}
