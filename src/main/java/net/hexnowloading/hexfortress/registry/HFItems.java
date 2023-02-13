package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.item.*;
import net.hexnowloading.hexfortress.misc.HFCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class HFItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HexFortress.MODID);

    // Ingredients Items
    public static final RegistryObject<Item> BLAZE_KEY = ITEMS.register("blaze_key", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> BLAZE_CORE = ITEMS.register("blaze_core", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> BLAZE_PILLAR = ITEMS.register("blaze_pillar", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHER_PETAL = ITEMS.register("wither_petal", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHER_SKULL_FRAGMENT = ITEMS.register("wither_skull_fragment", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHERITE_BONE = ITEMS.register("witherite_bone", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));

    public static final RegistryObject<Item> FRAGMENT_OF_GREED = ITEMS.register("fragment_of_greed", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> CREST_OF_GREED = ITEMS.register("crest_of_greed", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> EMBLEM_OF_GREED = ITEMS.register("emblem_of_greed", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_TEAR = ITEMS.register("obsidian_tear", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_TALISMAN = ITEMS.register("obsidian_talisman", () -> new Item(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> ENCHANTED_OBSIDIAN_TALISMAN = ITEMS.register("enchanted_obsidian_talisman", () -> new EnchantedObsidianTalismanItem(new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));

    // Weapon Items
    public static final RegistryObject<Item> BLAZE_STAFF = ITEMS.register("blaze_staff", () -> new BlazeStaffItem(new Item.Properties().stacksTo(1).durability(100).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> FIRESTORM_STAFF = ITEMS.register("firestorm_staff", () -> new FirestormStaffItem(new Item.Properties().stacksTo(1).durability(300).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> BLAZE_ROD_SWORD = ITEMS.register("blaze_rod_sword", () -> new BlazeRodSwordItem(Tiers.NETHERITE, 4, -2.4F, (new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> FIRESTORM_SWORD = ITEMS.register("firestorm_sword", () -> new FirestormSwordItem(Tiers.NETHERITE, 5, -2.4F, (new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHERITE_SWORD = ITEMS.register("witherite_sword", () -> new WitheriteSwordItem(Tiers.NETHERITE, 4, -2.4F, (new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHER_BOW = ITEMS.register("wither_bow", () -> new WitherBowItem((new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB))));
    public static final RegistryObject<Item> REFINED_GOLDEN_SWORD = ITEMS.register("refined_golden_sword", () -> new RoyalGoldenSwordItem(Tiers.GOLD, 4, -2.2F, (new Item.Properties()).stacksTo(1).durability(64).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> REFORGED_GOLDEN_SWORD = ITEMS.register("reforged_golden_sword", () -> new RoyalGoldenSwordItem(Tiers.GOLD, 5, -2.0F, (new Item.Properties()).stacksTo(1).durability(128).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> ROYAL_GOLDEN_SWORD = ITEMS.register("royal_golden_sword", () -> new RoyalGoldenSwordItem(Tiers.GOLD, 6, -1.8F, (new Item.Properties()).stacksTo(1).durability(256).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> OBSIDIAN_SWORD = ITEMS.register("obsidian_sword", () -> new ObsidianSwordItem(Tiers.NETHERITE, 4, -2.4F, (new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> ENCHANTED_OBSIDIAN_SWORD = ITEMS.register("enchanted_obsidian_sword", () -> new EnchantedObsidianSwordItem(Tiers.NETHERITE, 4, -2.4F, (new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> WITHERITE_SHEARS = ITEMS.register("witherite_shears", () -> new WitheriteShearsItem((new Item.Properties()).stacksTo(1).durability(2031).tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));


    // Spawn Eggs
    public static final RegistryObject<Item> FIRESTORM_EGG = ITEMS.register("firestorm_spawn_egg", () -> new ForgeSpawnEggItem(HFEntityTypes.FIRESTORM, 0xF6B201, 0xA80E0E, new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));

    // Block Items
    public static final RegistryObject<Item> LOCKED_CHEST_ITEM = ITEMS.register("locked_chest", () -> new LockedChestBlockItem(HFBlocks.LOCKED_CHEST.get(), new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    public static final RegistryObject<Item> DUNGEON_CHEST_ITEM = ITEMS.register("dungeon_chest", () -> new DungeonChestBlockItem(HFBlocks.DUNGEON_CHEST.get(), new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));

}
