package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.entity.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HexFortress.MODID);

    public static final RegistryObject<BlockEntityType<LockedChestBlockEntity>> LOCKED_CHEST = BLOCK_ENTITY_TYPES.register("locked_chest", () -> BlockEntityType.Builder.of(LockedChestBlockEntity::new, HFBlocks.LOCKED_CHEST.get()).build(null));
    public static final RegistryObject<BlockEntityType<DungeonChestBlockEntity>> DUNGEON_CHEST = BLOCK_ENTITY_TYPES.register("dungeon_chest", () -> BlockEntityType.Builder.of(DungeonChestBlockEntity::new, HFBlocks.DUNGEON_CHEST.get()).build(null));
    public static final RegistryObject<BlockEntityType<ResistanceCancelerBlockEntity>> RESISTANCE_CANCELER = BLOCK_ENTITY_TYPES.register("resistance_canceler", () -> BlockEntityType.Builder.of(ResistanceCancelerBlockEntity::new, HFBlocks.RESISTANCE_CANCELER.get()).build(null));
    public static final RegistryObject<BlockEntityType<PotOfGreedBlockEntity>> POT_OF_GREED = BLOCK_ENTITY_TYPES.register("pot_of_greed", () -> BlockEntityType.Builder.of(PotOfGreedBlockEntity::new, HFBlocks.POT_OF_GREED.get()).build(null));

}
