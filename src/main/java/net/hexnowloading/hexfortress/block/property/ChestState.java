package net.hexnowloading.hexfortress.block.property;

import net.minecraft.util.StringRepresentable;

public enum ChestState implements StringRepresentable {

    OPEN("open"),
    OPENED("opened"),
    CLOSE("close"),
    CLOSED("closed");
    private final String name;

    private ChestState (String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
