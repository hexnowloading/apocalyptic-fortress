package net.hexnowloading.hexfortress.mixin;

import net.hexnowloading.hexfortress.config.HFCommonConfigs;
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
    @Inject(method = "Lnet/minecraft/world/entity/monster/WitherSkeleton;populateDefaultEquipmentSlots(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/DifficultyInstance;)V", at = @At("TAIL"))
    public void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance, CallbackInfo ci) {
        WitherSkeleton witherSkeleton = (WitherSkeleton) (Object) this;
        if (HFCommonConfigs.WITHER_SKELETON_BOW.get()) {
            if (randomSource.nextFloat() < 0.40F) {
                witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
            } else {
                witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            }
        } else {
            witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        }
    }
}
