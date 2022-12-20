package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.item.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class HFItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HexFortress.MODID);

    // Ingredients Items
    public static final RegistryObject<Item> BLAZE_KEY = ITEMS.register("blaze_key", () -> new Item(new Item.Properties()));


    // Weapon Items


    // Spawn Eggs

    // Block Items
    public static final RegistryObject<Item> LOCKED_CHEST_ITEM = ITEMS.register("locked_chest", () -> new LockedChestBlockItem(HFBlocks.LOCKED_CHEST.get(), new Item.Properties()));
    public static final RegistryObject<Item> DUNGEON_CHEST_ITEM = ITEMS.register("dungeon_chest", () -> new DungeonChestBlockItem(HFBlocks.DUNGEON_CHEST.get(), new Item.Properties()));

}
