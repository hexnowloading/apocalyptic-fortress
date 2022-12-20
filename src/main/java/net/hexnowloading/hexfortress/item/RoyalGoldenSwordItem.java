package net.hexnowloading.hexfortress.item;

import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class RoyalGoldenSwordItem extends SwordItem {
    public RoyalGoldenSwordItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    /*
    @Override
    public void onCraftedBy(ItemStack itemStack, Level level, Player player) {
        super.onCraftedBy(itemStack, level, player);
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemStack);
        if (itemStack.is(HFItems.REFINED_GOLDEN_SWORD.get()) && !(EnchantmentHelper.getTagEnchantmentLevel(Enchantments.MOB_LOOTING, itemStack) > 0)) {
            map.put(Enchantments.MOB_LOOTING, 1);
        } else if (itemStack.is(HFItems.REFORGED_GOLDEN_SWORD.get()) && !(EnchantmentHelper.getTagEnchantmentLevel(Enchantments.MOB_LOOTING, itemStack) > 1)) {
            map.put(Enchantments.MOB_LOOTING, 2);
        } else if (itemStack.is(HFItems.ROYAL_GOLDEN_SWORD.get()) && !(EnchantmentHelper.getTagEnchantmentLevel(Enchantments.MOB_LOOTING, itemStack) > 2)) {
            map.put(Enchantments.MOB_LOOTING, 3);
        }
        EnchantmentHelper.setEnchantments(map, itemStack);
    }

     */
}
