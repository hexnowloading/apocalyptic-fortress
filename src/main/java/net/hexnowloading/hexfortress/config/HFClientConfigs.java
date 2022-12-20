package net.hexnowloading.hexfortress.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class HFClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Config for Apocalyptic Fortress Mod");

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}