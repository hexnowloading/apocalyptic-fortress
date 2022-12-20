package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.LockedChestBlock;
import net.hexnowloading.hexfortress.block.ResistanceCancelerBlock;
import net.hexnowloading.hexfortress.block.property.LockedState;
import net.hexnowloading.hexfortress.registry.HFProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.logging.Level;

@Mod.EventBusSubscriber(modid = HexFortress.MODID)
public class HandleBreak {


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
}
