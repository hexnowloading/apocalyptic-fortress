package net.hexnowloading.hexfortress.item;

import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Properties;


public class BlazeStaffItem extends Item {

    public BlazeStaffItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getDamageValue() == itemStack.getMaxDamage()) {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        } else {
            player.playSound(SoundEvents.BLAZE_SHOOT);

            if(!level.isClientSide()) {
                // Shoot Fireballs
                SmallFireball smallfireball = new SmallFireball(level, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);
                smallfireball.setPos(player.getX(), player.getEyeY(), player.getZ());
                smallfireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
                level.addFreshEntity(smallfireball);

                itemStack.hurt(1, level.getRandom(), null);

                player.getCooldowns().addCooldown(this, 5);
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
    }

    @Override
    public boolean isValidRepairItem(ItemStack repairItem, ItemStack itemStack) {
        return itemStack.is(HFItems.BLAZE_CORE.get());
    }

    @Override
    public boolean isEnchantable(ItemStack itemStack) { return false; }

    @Override
    public boolean isBookEnchantable(ItemStack itemStack, ItemStack book) {
        return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack itemStack, Enchantment enchantment) {
        return false;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(itemStack, level, tooltip, flag);
        tooltip.add(Component.translatable("item.hexfortress.blaze_staff_charges", itemStack.getMaxDamage() - itemStack.getDamageValue()).withStyle(ChatFormatting.GRAY));
    }
}