package net.hexnowloading.hexfortress.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class HFCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue DESTRUCTIVE_BARREL;
    static {
        BUILDER.push("Config for Apocalyptic Fortress Mod");

        DESTRUCTIVE_BARREL = BUILDER.comment("Explosive barrel destroy blocks!")
                .define("Destructive Barrel", true);

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}