package net.hexnowloading.hexfortress.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class ComfortTouchEnchantment extends Enchantment {
    public ComfortTouchEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMinCost(int exp) {
        return 15 + (exp - 1) * 9;
    }

    @Override
    public int getMaxCost(int exp) {
        return super.getMinCost(exp) + 50;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public boolean canEnchant(ItemStack p_44689_) {
        return super.canEnchant(p_44689_);
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && enchantment != Enchantments.SILK_TOUCH && enchantment != Enchantments.BLOCK_FORTUNE;
    }
}
