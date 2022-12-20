package net.hexnowloading.hexfortress.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class HFCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue SPAWN_WITHER_SKELETON_WITH_BOW;
    public static final ForgeConfigSpec.BooleanValue DESTRUCTIVE_BARREL;
    static {
        BUILDER.push("Config for Apocalyptic Fortress Mod");

        SPAWN_WITHER_SKELETON_WITH_BOW = BUILDER.comment("Some wither skeleton spawns with a bow in its hand instead!")
                        .define("Spawn Wither Skeleton Archer", true);
        DESTRUCTIVE_BARREL = BUILDER.comment("Explosive barrel destroy blocks!")
                        .define("Destructive Barrel", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
