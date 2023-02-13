package net.hexnowloading.hexfortress.mixin;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeleton.class)
public class WitherSkeletonMixin {
    @Inject(method = "Lnet/minecraft/world/entity/monster/WitherSkeleton;populateDefaultEquipmentEnchantments(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/DifficultyInstance;)V", at = @At("HEAD"))
    public void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance, CallbackInfo ci) {
        WitherSkeleton witherSkeleton = (WitherSkeleton) (Object) this;
        if (randomSource.nextFloat() < 0.40F) {
            witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        } else {
            witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }
    }
}
