package net.hexnowloading.hexfortress.block.entity;

import net.hexnowloading.hexfortress.block.property.ChestState;
import net.hexnowloading.hexfortress.block.property.LockedState;
import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.hexnowloading.hexfortress.registry.HFProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.easing.EasingType;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class LockedChestBlockEntity extends BlockEntity implements IAnimatable {
    public static final String LOOT_TABLE_TAG = "LootTable";
    public static final String LOOT_TABLE_SEED_TAG = "LootTableSeed";
    protected ResourceLocation lootTable;
    protected long lootTableSeed;
    public LockedChestBlockEntity(BlockPos pos, BlockState state) {
        super(HFBlockEntities.LOCKED_CHEST.get(), pos, state);
    }

    // Saves the nbt when player leaves the world.
    @Override
    protected void saveAdditional(CompoundTag nbt) {
        this.trySaveLootTable(nbt);
        super.saveAdditional(nbt);
    }

    // Loads the nbt when player joins the world.
    @Override
    public void load(CompoundTag nbt) {
        this.tryLoadLootTable(nbt);
        super.load(nbt);
    }

    protected boolean tryLoadLootTable(CompoundTag nbt) {
        if (nbt.contains("LootTable", 8)) {
            this.lootTable = new ResourceLocation(nbt.getString("LootTable"));
            this.lootTableSeed = nbt.getLong("LootTableSeed");
            return true;
        } else {
            return false;
        }
    }

    protected boolean trySaveLootTable(CompoundTag nbt) {
        if (this.lootTable == null) {
            return false;
        } else {
            nbt.putString("LootTable", this.lootTable.toString());
            if (this.lootTableSeed != 0L) {
                nbt.putLong("LootTableSeed", this.lootTableSeed);
            }
            return true;
        }
    }

    public static final AnimationBuilder CLOSED = new AnimationBuilder().addAnimation("closed", false);
    private final AnimationFactory factory = new AnimationFactory(this);
    private static final String CONTROLLER_NAME = "chestController";

    @Override
    public void registerControllers (AnimationData data) {
        AnimationController controller = new AnimationController(this, CONTROLLER_NAME, 7, animationEvent -> {
            animationEvent.getController().easingType = EasingType.EaseOutSine;
            animationEvent.getController().setAnimation(CLOSED);
            return PlayState.CONTINUE;
        });
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory () {
        return factory;
    }
}
