package net.hexnowloading.hexfortress.block.entity;

import net.hexnowloading.hexfortress.block.DungeonChestBlock;
import net.hexnowloading.hexfortress.block.property.ChestState;
import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.hexnowloading.hexfortress.registry.HFProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.easing.EasingType;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DungeonChestBlockEntity extends RandomizableContainerBlockEntity implements MenuProvider, IAnimatable {
    public static final EnumProperty<ChestState> CHEST_STATE = HFProperties.CHEST_STATE;
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    public DungeonChestBlockEntity(BlockPos pos, BlockState state) {
        super(HFBlockEntities.DUNGEON_CHEST.get(), pos, state);
    }

    public int getContainerSize() {
        return 27;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> itemStacks) {
        this.items = itemStacks;
    }

    private LazyOptional<IItemHandlerModifiable> chestHandler;

    @Override
    public Component getDefaultName() {
        return Component.translatable("block.hexfortress.dungeon_chest");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return ChestMenu.threeRows(id, inventory, this);
    }

    @Override
    public void setBlockState(BlockState state) {
        super.setBlockState(state);
        if (this.chestHandler != null) {
            net.minecraftforge.common.util.LazyOptional<?> oldHandler = this.chestHandler;
            this.chestHandler = null;
            oldHandler.invalidate();
        }
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (!this.remove && cap == ForgeCapabilities.ITEM_HANDLER) {
            if (this.chestHandler == null) {
                this.chestHandler = LazyOptional.of(this::createHandler);
            }
            return this.chestHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler() {
        BlockState state = this.getBlockState();
        if (!(state.getBlock() instanceof DungeonChestBlock)) {
            return new InvWrapper(this);
        }
        Container inv = DungeonChestBlock.getContainer((DungeonChestBlock) state.getBlock());
        return new InvWrapper(inv == null ? this : inv);
    }

    // Saves the nbt when player leaves the world.
    @Override
    protected void saveAdditional(CompoundTag nbt) {
        if (!this.trySaveLootTable(nbt)) {
            ContainerHelper.saveAllItems(nbt, this.items);
        }
        super.saveAdditional(nbt);
    }

    // Loads the nbt when player joins the world.
    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(nbt)) {
            ContainerHelper.loadAllItems(nbt, this.items);
        }
    }

    // Event on Chest State.
    // ---------------------

    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(Level level, BlockPos pos, BlockState state) {
            DungeonChestBlockEntity.this.playSound(level, pos, state, SoundEvents.CHEST_OPEN);
        }

        @Override
        protected void onClose(Level level, BlockPos pos, BlockState state) {
            DungeonChestBlockEntity.this.playSound(level, pos, state, SoundEvents.CHEST_CLOSE);
        }

        @Override
        protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            DungeonChestBlockEntity.this.signalOpenCount(level, pos, state, oldViewerCount, newViewerCount);
        }

        @Override
        protected boolean isOwnContainer(Player player) {
            if (player.containerMenu instanceof ChestMenu) {
                Container container = ((ChestMenu)player.containerMenu).getContainer();
                return container == DungeonChestBlockEntity.this;
            } else {
                return false;
            }
        }
    };

    protected void signalOpenCount(Level level, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        Block block = state.getBlock();
        level.blockEvent(pos, block, 1, newViewerCount);
        if(oldViewerCount != newViewerCount) {
            if (newViewerCount > 0) {
                level.setBlock(pos, state.setValue(HFProperties.CHEST_STATE, ChestState.OPENED), 3);
            } else {
                level.setBlock(pos, state.setValue(HFProperties.CHEST_STATE, ChestState.CLOSED), 3);
            }
        }
    }

    @Override
    public void startOpen(Player player) {
        if(!this.remove && !player.isSpectator()) {
            this.openersCounter.incrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(Player player) {
        if(!this.remove && !player.isSpectator()) {
            this.openersCounter.decrementOpeners(player, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }
    }

    // Play Sound
    // ----------
    static void playSound(Level level, BlockPos pos, BlockState state, SoundEvent soundEvent) {
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.5D;
        double d2 = (double)pos.getZ() + 0.5D;

        level.playSound((Player)null, d0, d1, d2, soundEvent, SoundSource.BLOCKS, 0.5F, level.random.nextFloat() * 0.1F + 0.9F);
    }

    // Animation Controls
    //-------------------
    public static final AnimationBuilder CLOSED = new AnimationBuilder().addAnimation("closed", false);
    public static final AnimationBuilder OPENED = new AnimationBuilder().addAnimation("opened", false);
    public ChestState getChestState() { return this.getBlockState().getValue(DungeonChestBlockEntity.CHEST_STATE); }

    private static final String CONTROLLER_NAME = "chestController";
    private final AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers (AnimationData data) {
        AnimationController controller = new AnimationController(this, CONTROLLER_NAME, 7, animationEvent -> {

            switch (getChestState()) {
                case CLOSED:
                    animationEvent.getController().easingType = EasingType.EaseOutSine;
                    animationEvent.getController().setAnimation(CLOSED);
                    break;
                case OPENED:
                    animationEvent.getController().easingType = EasingType.Linear;
                    animationEvent.getController().setAnimation(OPENED);
                    break;
                default:
                    break;
            }
            return PlayState.CONTINUE;
        });
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory () {
        return factory;
    }
}
