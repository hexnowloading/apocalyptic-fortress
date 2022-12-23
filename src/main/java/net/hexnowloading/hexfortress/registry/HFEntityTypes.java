package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HFEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HexFortress.MODID);

    /*CREATURES*/
    public static final RegistryObject<EntityType<ModifiedWitherSkeletonEntity>> MODIFIED_WITHER_SKELETON = ENTITY_TYPES.register("modified_wither_skeleton", () -> EntityType.Builder.of(ModifiedWitherSkeletonEntity::new, MobCategory.MONSTER).fireImmune().immuneTo(Blocks.WITHER_ROSE).sized(0.7F, 2.4F).clientTrackingRange(8).build(new ResourceLocation(HexFortress.MODID, "modified_wither_skeleton").toString()));
    public static final RegistryObject<EntityType<TestEntity>> TEST_ENTITY = ENTITY_TYPES.register("test_entity", () -> EntityType.Builder.of(TestEntity::new, MobCategory.MONSTER).sized(0.3F, 0.3F).build(new ResourceLocation(HexFortress.MODID, "test").toString()));
    public static final RegistryObject<EntityType<WildfireEntity>> WILDFIRE = ENTITY_TYPES.register("wildfire", () -> EntityType.Builder.of(WildfireEntity::new, MobCategory.MONSTER).sized(1.3F, 3.1F).build(new ResourceLocation(HexFortress.MODID, "wildfire").toString()));
    public static final RegistryObject<EntityType<FortressWalkerEntity>> FORTRESS_WALKER = ENTITY_TYPES.register("fortress_walker", () -> EntityType.Builder.of(FortressWalkerEntity::new, MobCategory.MONSTER).sized(5.0F, 4.8F).build(new ResourceLocation(HexFortress.MODID, "fortress_walker").toString()));

    /*PROJECTILES*/
    //public static final RegistryObject<EntityType<StrongerFireballEntity>> STRONGER_FIREBALL = ENTITY_TYPES.register("stronger_fireball", () -> EntityType.Builder.of(StrongerFireballEntity::new, MobCategory.MISC).sized(0.3125F, 0.3125F).clientTrackingRange(4).updateInterval(10));

    public static void registerAdditionalEntityInformation() {
        registerEntitySpawnRestrictions();
    }
    private static void registerEntitySpawnRestrictions() {
        SpawnPlacements.register(MODIFIED_WITHER_SKELETON.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
        SpawnPlacements.register(WILDFIRE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkAnyLightMonsterSpawnRules);
    }
}
