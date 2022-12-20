package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.world.structures.UnboundedJigsawStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HFStructureTypes {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, HexFortress.MODID);

    public static RegistryObject<StructureType<UnboundedJigsawStructure>> UNBOUNDED_JIGSAW_STRUCTURE = STRUCTURE_TYPES.register("unbounded_jigsaw_structure", () -> () -> UnboundedJigsawStructure.CODEC);
}
