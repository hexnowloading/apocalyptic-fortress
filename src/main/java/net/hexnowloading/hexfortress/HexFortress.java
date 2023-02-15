package net.hexnowloading.hexfortress;

import com.mojang.logging.LogUtils;
import net.hexnowloading.hexfortress.config.HFClientConfigs;
import net.hexnowloading.hexfortress.config.HFCommonConfigs;
import net.hexnowloading.hexfortress.event.ServerEvents;
import net.hexnowloading.hexfortress.registry.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

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
        eventBus.addListener(this::registerTab);

        GeckoLib.initialize();

        HFBlocks.BLOCKS.register(eventBus);
        HFBlockEntities.BLOCK_ENTITY_TYPES.register(eventBus);
        HFItems.ITEMS.register(eventBus);
        HFEntityTypes.ENTITY_TYPES.register(eventBus);
        HFMenuTypes.MENU_TYPES.register(eventBus);
        HFStructureTypes.STRUCTURE_TYPES.register(eventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HFClientConfigs.SPEC, "apocalyptic-fortress-mod-client.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, HFCommonConfigs.SPEC, "apocalyptic-fortress-mod-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ServerEvents());
    }



    private void setup(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
           HFEntityTypes.registerAdditionalEntityInformation();
        });
    }

    private void registerTab(CreativeModeTabEvent.Register event) {
        List<RegistryObject<Block>> blockBlackList = List.of(HFBlocks.BLAZE_CLUSTER);
        List<RegistryObject<Item>> itemBlackList = List.of(HFItems.OBSIDIAN_TEAR,HFItems.ENCHANTED_OBSIDIAN_TALISMAN,HFItems.WITHER_BOW,HFItems.ENCHANTED_OBSIDIAN_SWORD);
        event.registerCreativeModeTab(new ResourceLocation(MODID, "hexfortress"), builder -> {
                builder
                        .title(Component.translatable("itemgroup.hexfortress"))
                        .icon(() -> new ItemStack(HFBlocks.CHISELED_GOLDEN_HEAVY_NETHER_BRICKS.get()))
                        .displayItems((enableFlags, populator, hasPermissions) -> {
                            // Add Blocks
                            for (Field field : HFBlocks.class.getFields()) {
                                if (field.getType() != RegistryObject.class) continue;
                                try {
                                    RegistryObject<Block> block = (RegistryObject) field.get(null);
                                    if (!blockBlackList.contains(block)) populator.accept(new ItemStack(block.get()));
                                } catch (IllegalAccessException e) {
                                }
                            }
                            // Add Items
                            for (Field field : HFItems.class.getFields()) {
                                if (field.getType() != RegistryObject.class) continue;
                                try {
                                    RegistryObject<Item> item = (RegistryObject) field.get(null);
                                    if (!itemBlackList.contains(item)) populator.accept(new ItemStack(item.get()));
                                } catch (IllegalAccessException e) {
                                }
                            }
                        });
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
