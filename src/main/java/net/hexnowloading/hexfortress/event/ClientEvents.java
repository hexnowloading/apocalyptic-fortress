package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.client.render.DungeonChestBlockRenderer;
import net.hexnowloading.hexfortress.block.client.render.LockedChestBlockRenderer;
import net.hexnowloading.hexfortress.entity.client.model.FortressWalkerModel;
import net.hexnowloading.hexfortress.entity.client.model.FirestormModel;
import net.hexnowloading.hexfortress.entity.client.model.TestModel;
import net.hexnowloading.hexfortress.entity.client.renderer.*;
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
        event.registerLayerDefinition(TestModel.LAYER_LOCATION, TestModel::createBodyLayer);
        event.registerLayerDefinition(FirestormModel.LAYER_LOCATION, FirestormModel::createBodyLayer);
        event.registerLayerDefinition(FortressWalkerModel.LAYER_LOCATION, FortressWalkerModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // Entity
        event.registerEntityRenderer(HFEntityTypes.TEST_ENTITY.get(), TestRenderer::new);
        event.registerEntityRenderer(HFEntityTypes.FIRESTORM.get(), FirestormRenderer::new);
        event.registerEntityRenderer(HFEntityTypes.FORTRESS_WALKER.get(), FortressWalkerRenderer::new);

        // Block
        event.registerBlockEntityRenderer(HFBlockEntities.DUNGEON_CHEST.get(), context -> new DungeonChestBlockRenderer());
        event.registerBlockEntityRenderer(HFBlockEntities.LOCKED_CHEST.get(), context -> new LockedChestBlockRenderer());
    }
}