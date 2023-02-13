package net.hexnowloading.hexfortress.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class HFCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue DESTRUCTIVE_BARREL;
    public static final ForgeConfigSpec.BooleanValue WITHER_SKELETON_BOW;

    static {
        BUILDER.push("Config for Apocalyptic Fortress Mod");

        DESTRUCTIVE_BARREL = BUILDER.comment("Explosive barrel destroy blocks!")
                .define("Destructive Barrel", true);
        WITHER_SKELETON_BOW = BUILDER.comment("Spawn wither skeletons with bow!")
                .define("Wither Skeleton with Bow", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}