package net.hexnowloading.hexfortress.block.entity;

import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class LockedChestBlockEntity extends BlockEntity implements GeoBlockEntity {
    public static final String LOOT_TABLE_TAG = "LootTable";
    public static final String LOOT_TABLE_SEED_TAG = "LootTableSeed";
    protected ResourceLocation lootTable;
    protected long lootTableSeed;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
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

    public static final RawAnimation CLOSED = RawAnimation.begin().thenPlay("closed");

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController<>(this, state -> {
            return state.setAndContinue(CLOSED);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
