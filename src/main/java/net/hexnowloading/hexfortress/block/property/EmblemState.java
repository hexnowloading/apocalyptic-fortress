package net.hexnowloading.hexfortress.block.property;

import net.minecraft.util.StringRepresentable;

public enum EmblemState implements StringRepresentable {
    EMPTY("empty"),
    EMBEDDED("embedded");

    private final String name;

    private EmblemState (String name) { this.name = name; }

    @Override
    public String getSerializedName() { return this.name; }
}
