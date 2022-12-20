package net.hexnowloading.hexfortress.block.entity;

import net.hexnowloading.hexfortress.registry.HFBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;
import java.util.Optional;

public class PotOfGreedBlockEntity extends BlockEntity {
    private static final int MAX_GOLD_INGOT = 100;
    private ArrayList<Item> items = new ArrayList<>();
    private int goldCounter;
    public PotOfGreedBlockEntity(BlockPos pos, BlockState state) {
        super(HFBlockEntities.POT_OF_GREED.get(), pos, state);
    }

    public ArrayList<Item> getItems() { return this.items; }

    public boolean addGoldCounter(Player player, ItemStack itemStack) {
        if (player.getAbilities().instabuild) {
            return true;
        } else {
            if (itemStack.getCount() + goldCounter < MAX_GOLD_INGOT) {
                goldCounter+=itemStack.getCount();
                itemStack.shrink(itemStack.getCount());
            } else {
                itemStack.shrink(MAX_GOLD_INGOT - goldCounter);
                return true;
            }
        }
        return false;
    }
}
