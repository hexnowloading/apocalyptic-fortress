package net.hexnowloading.hexfortress.item;

import net.hexnowloading.hexfortress.entity.projectile.FirestormFireballEntity;
import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.List;

public class FirestormStaffItem extends Item {
    public FirestormStaffItem(Properties properties) { super(properties); }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getDamageValue() == itemStack.getMaxDamage()) {
            return InteractionResultHolder.fail(player.getItemInHand(hand));
        } else {
            player.playSound(SoundEvents.BLAZE_SHOOT);

            if(!level.isClientSide()) {
                // Shoot Fireballs
                shootProjectile(level, player, 0.0F);
                shootProjectile(level, player, -10.0F);
                shootProjectile(level, player, 10.0F);
//                FirestormFireballEntity smallfireball = new FirestormFireballEntity(level, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);
//                FirestormFireballEntity smallfireballL = new FirestormFireballEntity(level, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);
//                FirestormFireballEntity smallfireballR = new FirestormFireballEntity(level, player, player.getLookAngle().x, player.getLookAngle().y, player.getLookAngle().z);
//                smallfireball.setFireballDamage(6.0F);
//                smallfireballL.setFireballDamage(6.0F);
//                smallfireballR.setFireballDamage(6.0F);
//                smallfireball.setPos(player.getX(), player.getEyeY(), player.getZ());
//                smallfireballL.setPos(player.getX(), player.getEyeY(), player.getZ());
//                smallfireballR.setPos(player.getX(), player.getEyeY(), player.getZ());
//                //smallfireball.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
//                //smallfireballL.shootFromRotation(player, player.getXRot(), player.getYRot()+10F, 0.0F, 1.5F, 1.0F);
//                //smallfireballR.shootFromRotation(player, player.getXRot(), player.getYRot()-10F, 0.0F, 1.5F, 1.0F);
//
//                Vec3 vec31 = player.getUpVector(1.0F);
//                Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(10F * ((float)Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
//                Vec3 vec3 = player.getViewVector(1.0F);
//                Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
//
//                smallfireballL.rotate(player.get);
//                level.addFreshEntity(smallfireball);
//                level.addFreshEntity(smallfireballL);
//                level.addFreshEntity(smallfireballR);

                itemStack.hurt(1, level.getRandom(), null);

                player.getCooldowns().addCooldown(this, 5);
            }
            return InteractionResultHolder.success(player.getItemInHand(hand));
        }
    }

    private static void shootProjectile(Level level, Player player, float angle) {
        if (!level.isClientSide) {
            Vec3 vec31 = player.getUpVector(1.0F);
            Quaternionf quaternionf = (new Quaternionf()).setAngleAxis((double)(angle * ((float)Math.PI / 180F)), vec31.x, vec31.y, vec31.z);
            Vec3 vec3 = player.getViewVector(1.0F);
            Vector3f vector3f = vec3.toVector3f().rotate(quaternionf);
            FirestormFireballEntity smallfireball = new FirestormFireballEntity(level, player,(double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z());
            smallfireball.setFireballDamage(6.0F);
            smallfireball.setPos(player.getX(), player.getEyeY() - (double)0.15F, player.getZ());
            smallfireball.shoot((double)vector3f.x(), (double)vector3f.y(), (double)vector3f.z(), 1.0F, 1.0F);
            level.addFreshEntity(smallfireball);
        }
    }


    @Override
    public boolean isValidRepairItem(ItemStack repairItem, ItemStack itemStack) {
        return itemStack.is(HFItems.BLAZE_PILLAR.get());
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
        tooltip.add(Component.translatable("item.hexfortress.firestorm_staff_charges", itemStack.getMaxDamage() - itemStack.getDamageValue()).withStyle(ChatFormatting.GRAY));
    }
}
