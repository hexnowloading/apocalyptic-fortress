package net.hexnowloading.hexfortress.registry;

import net.hexnowloading.hexfortress.block.property.ChestState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class HFProperties {
    public static final EnumProperty<ChestState> CHEST_STATE = EnumProperty.create("chest_state", ChestState.class);
    //public static final EnumProperty<LockedState> LOCKED = EnumProperty.create("locked", LockedState.class);
    public static final IntegerProperty PILE = IntegerProperty.create("pile", 1, 4);
    public static final IntegerProperty RANGE = IntegerProperty.create("range", 1, 64);
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 3);
    public static final BooleanProperty ACTIVATED = BooleanProperty.create("activated");
    public static final BooleanProperty LOCKED = BooleanProperty.create("locked");

}
