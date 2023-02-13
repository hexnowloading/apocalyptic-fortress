package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.client.render.DungeonChestBlockRenderer;
import net.hexnowloading.hexfortress.block.client.render.LockedChestBlockRenderer;
import net.hexnowloading.hexfortress.entity.client.model.FirestormModel;
import net.hexnowloading.hexfortress.entity.client.renderer.*;
import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.hexnowloading.hexfortress.registry.HFEntityTypes;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HexFortress.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(FirestormModel.LAYER_LOCATION, FirestormModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        // Entity
        event.registerEntityRenderer(HFEntityTypes.FIRESTORM.get(), FirestormRenderer::new);

        // Block
        event.registerBlockEntityRenderer(HFBlockEntities.DUNGEON_CHEST.get(), DungeonChestBlockRenderer::new);
        event.registerBlockEntityRenderer(HFBlockEntities.LOCKED_CHEST.get(), LockedChestBlockRenderer::new);
    }
}