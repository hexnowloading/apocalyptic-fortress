package net.hexnowloading.hexfortress.event;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.*;
import net.hexnowloading.hexfortress.registry.HFEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HexFortress.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(HFEntityTypes.MODIFIED_WITHER_SKELETON.get(), ModifiedWitherSkeletonEntity.createAttributes().build());
        event.put(HFEntityTypes.TEST_ENTITY.get(), TestEntity.createAttributes().build());
        event.put(HFEntityTypes.WILDFIRE.get(), WildfireEntity.createAttributes().build());
        event.put(HFEntityTypes.FORTRESS_WALKER.get(), FortressWalkerEntity.createAttributes().build());
    }
}
