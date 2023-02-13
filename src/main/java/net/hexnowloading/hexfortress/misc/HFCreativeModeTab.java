package net.hexnowloading.hexfortress.misc;

import net.hexnowloading.hexfortress.registry.HFBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public abstract class HFCreativeModeTab {
    public static final CreativeModeTab APOCALYPTIC_FORTRESS_TAB = new CreativeModeTab("itemgroup.hexfortress") {

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(HFBlocks.CHISELED_GOLDEN_HEAVY_NETHER_BRICKS.get());
        }
    };
}
