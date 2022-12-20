package net.hexnowloading.hexfortress.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class EnchantedObsidianTalismanItem extends Item {

    public EnchantedObsidianTalismanItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFoil(ItemStack itemStack) { return true; }
}
