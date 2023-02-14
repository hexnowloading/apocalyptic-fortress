package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.*;
import net.hexnowloading.hexfortress.misc.HFCreativeModeTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

public class HFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HexFortress.MODID);

    public static final RegistryObject<Block> NETHER_BRICK_PILLAR = registerBlock("nether_brick_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> STRIPED_NETHER_BRICKS = registerBlock("striped_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> FADED_NETHER_BRICKS = registerBlock("faded_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> MIXED_NETHER_BRICKS = registerBlock("mixed_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> NETHER_TILES = registerBlock("nether_tiles", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> NETHER_TILE_STAIRS = registerBlock("nether_tile_stairs", () -> new StairBlock(NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> NETHER_TILE_SLAB = registerBlock("nether_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> MIXED_NETHER_TILES = registerBlock("mixed_nether_tiles", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_NETHER_BRICKS = registerBlock("polished_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_NETHER_BRICK_SLAB = registerBlock("polished_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_NETHER_BRICK_STAIRS = registerBlock("polished_nether_brick_stairs", () -> new StairBlock(NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> MIXED_RED_NETHER_BRICKS = registerBlock("mixed_red_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> GILDED_NETHER_BRICKS = registerBlock("gilded_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> HEAVY_NETHER_BRICKS = registerBlock("heavy_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> HEAVY_NETHER_BRICK_PILLAR = registerBlock("heavy_nether_brick_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> HEAVY_NETHER_BRICK_STAIRS = registerBlock("heavy_nether_brick_stairs", () -> new StairBlock(NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> HEAVY_NETHER_BRICK_SLAB = registerBlock("heavy_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> HEAVY_NETHER_BRICK_WALL = registerBlock("heavy_nether_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(NETHER_BRICK_WALL)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> CHISELED_HEAVY_NETHER_BRICKS = registerBlock("chiseled_heavy_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> CHISELED_GOLDEN_HEAVY_NETHER_BRICKS = registerBlock("chiseled_golden_heavy_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_HEAVY_NETHER_BRICKS = registerBlock("polished_heavy_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_HEAVY_NETHER_BRICK_STAIRS = registerBlock("polished_heavy_nether_brick_stairs", () -> new StairBlock(NETHER_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_HEAVY_NETHER_BRICK_SLAB = registerBlock("polished_heavy_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POLISHED_HEAVY_NETHER_BRICK_WALL = registerBlock("polished_heavy_nether_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(NETHER_BRICK_WALL)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> CHISELED_POLISHED_HEAVY_NETHER_BRICKS = registerBlock("chiseled_polished_heavy_nether_bricks", () -> new Block(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> CHISELED_POLISHED_HEAVY_NETHER_BRICK_SLAB = registerBlock("chiseled_polished_heavy_nether_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NETHER_BRICKS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    //public static final RegistryObject<Block> MIXED_SOUL_SAND_NETHER_TILES_MODERATE = registerBlock("mixed_soul_sand_nether_tiles_moderate", () -> new SoulSandBlock(BlockBehaviour.Properties.copy(SOUL_SAND)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> MIXED_SOUL_SAND_NETHER_TILES_LIGHT = registerBlock("mixed_soul_sand_nether_tiles_light", () -> new SoulSandBlock(BlockBehaviour.Properties.copy(SOUL_SAND)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> MIXED_SOUL_SAND_NETHER_TILES_HEAVY = registerBlock("mixed_soul_sand_nether_tiles_heavy", () -> new SoulSandBlock(BlockBehaviour.Properties.copy(SOUL_SAND)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);

    /* Block that uses mod class */
    //public static final RegistryObject<Block> BLAZE_CLUSTER = registerBlock("blaze_cluster", () -> new BlazeClusterBlock(BlockBehaviour.Properties.copy(END_ROD).strength(6f).requiresCorrectToolForDrops().noOcclusion().lightLevel((lightlevel) -> {return 5;}).sound(SoundType.AMETHYST_CLUSTER)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> FORTRESS_POT = registerBlock("fortress_pot", () -> new PotBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.3f, 0.3f).noOcclusion().sound(SoundType.GLASS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> POT_OF_GREED = registerBlock("pot_of_greed", () -> new PotOfGreedBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(0.3f, 0.3f).noOcclusion().sound(SoundType.GLASS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> GOLD_INGOT_PILE = registerBlock("gold_ingot_pile", () -> new PileBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(3.0f, 6.0f).noOcclusion().sound(SoundType.METAL)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> WITHER_VINE = registerBlock("wither_vine", () -> new WitherVineBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).strength(0.2f).noOcclusion().sound(SoundType.VINE)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> WITHER_LEAVES = registerBlock("wither_leaves", () -> new WitherLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).strength(0.2F).noOcclusion().sound(SoundType.GRASS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> NETHER_BRICK_PILE = registerBlock("nether_brick_pile", () -> new PileBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(3.0f, 6.0f).noOcclusion().sound(SoundType.NETHER_BRICKS).requiresCorrectToolForDrops()), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> FORTRESS_EXPLOSIVE_BARREL = registerBlock("fortress_explosive_barrel", () -> new ExplosiveBarrelBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE).instabreak().noOcclusion().sound(SoundType.GRASS)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> FORTRESS_BOOK_PILE = registerBlock("fortress_book_pile", () -> new BookPileBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion().sound(SoundType.WOOL)), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);


    /* Block Entities */
    public static final RegistryObject<Block> LOCKED_CHEST = registerBlock("locked_chest", () -> new LockedChestBlock(Block.Properties.of(new Material.Builder(MaterialColor.WOOD).build()).strength(-1.0f, 3600000.0f).noOcclusion().sound(SoundType.WOOD)), false, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> DUNGEON_CHEST = registerBlock("dungeon_chest", () -> new DungeonChestBlock(Block.Properties.of(new Material.Builder(MaterialColor.WOOD).build()).strength(2.5f, 2.5f).noOcclusion().sound(SoundType.WOOD)), false, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);
    public static final RegistryObject<Block> RESISTANCE_CANCELER = registerBlock("resistance_canceler", () -> new ResistanceCancelerBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().strength(50.0f, 1200.0f).noOcclusion().lightLevel((lightlevel) -> {return 15;})), true, HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean createItem, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        if (createItem) {
            registerBlockItem(name, toReturn, tab);
        }
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return HFItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(HFCreativeModeTab.APOCALYPTIC_FORTRESS_TAB)));
    }
}
