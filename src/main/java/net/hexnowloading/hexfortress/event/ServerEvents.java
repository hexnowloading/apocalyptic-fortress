package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.ResistanceCancelerBlock;
import net.hexnowloading.hexfortress.registry.HFProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HexFortress.MODID)
public class ServerEvents {


    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (!event.getLevel().isClientSide()) {
            if (!player.getAbilities().instabuild) {
                if (event.getState().getBlock() instanceof ResistanceCancelerBlock) {
                    if (event.getState().getValue(HFProperties.LOCKED)) {
                        player.displayClientMessage(Component.translatable("warning.hexfortress.cannot_break"), true);
                        event.setCanceled(true);
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onEntityJoinLevel(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof WitherSkeleton witherSkeleton && !event.getLevel().isClientSide && !event.loadedFromDisk()) {
            if (event.getLevel().getRandom().nextFloat() < 0.60F) {
                witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
            } else {
                witherSkeleton.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            }
        }
    }
}
