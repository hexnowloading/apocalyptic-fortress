package net.hexnowloading.hexfortress;

import com.mojang.logging.LogUtils;
import net.hexnowloading.hexfortress.config.HFClientConfigs;
import net.hexnowloading.hexfortress.config.HFCommonConfigs;
import net.hexnowloading.hexfortress.registry.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import software.bernie.geckolib3.GeckoLib;

import java.lang.reflect.Field;
import java.util.List;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(HexFortress.MODID)
@Mod.EventBusSubscriber(modid = HexFortress.MODID)
public class HexFortress {
    public static final String MODID = "hexfortress";
    private static final Logger LOGGER = LogUtils.getLogger();

    public HexFortress() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);

        GeckoLib.initialize();

        HFBlocks.BLOCKS.register(eventBus);
        HFBlockEntities.BLOCK_ENTITY_TYPES.register(eventBus);
        HFItems.ITEMS.register(eventBus);
        HFEnchantments.ENCHANTMENTS.register(eventBus);
        HFEntityTypes.ENTITY_TYPES.register(eventBus);
        HFMenuTypes.MENU_TYPES.register(eventBus);
        HFStructureTypes.STRUCTURE_TYPES.register(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HFClientConfigs.SPEC, "apocalyptic-fortress-mod-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HFCommonConfigs.SPEC, "apocalyptic-fortress-mod-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }



    private void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
           HFEntityTypes.registerAdditionalEntityInformation();
        });
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    /*
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            MenuScreens.register(HFMenuTypes.LOCKED_CHEST_MENU.get(), LockedChestScreen::new);
        }
    }

     */
}
