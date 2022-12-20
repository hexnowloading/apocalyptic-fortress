package net.hexnowloading.hexfortress.block.property;

import net.minecraft.util.StringRepresentable;

public enum LockedState implements StringRepresentable {

    LOCKED("locked"),
    UNLOCKED("unlocked");
    private final String name;

    private LockedState(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}
