package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.client.render.DungeonChestBlockRenderer;
import net.hexnowloading.hexfortress.block.client.render.LockedChestBlockRenderer;
import net.hexnowloading.hexfortress.entity.client.renderer.ModifiedWitherSkeletonRenderer;
import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.hexnowloading.hexfortress.registry.HFEntityTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HexFortress.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {

    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity
        event.registerEntityRenderer(HFEntityTypes.MODIFIED_WITHER_SKELETON.get(), ModifiedWitherSkeletonRenderer::new);

        // Block
        event.registerBlockEntityRenderer(HFBlockEntities.DUNGEON_CHEST.get(), context -> new DungeonChestBlockRenderer());
        event.registerBlockEntityRenderer(HFBlockEntities.LOCKED_CHEST.get(), context -> new LockedChestBlockRenderer());
    }
}