package net.hexnowloading.hexfortress.item;

import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WitherRoseBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WitheriteShearsItem extends ShearsItem {
    public WitheriteShearsItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext useOnContext) {
        Level level = useOnContext.getLevel();
        BlockPos blockpos = useOnContext.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        Player player = useOnContext.getPlayer();
        if (block instanceof GrowingPlantHeadBlock growingplantheadblock) {
            if (!growingplantheadblock.isMaxAge(blockstate)) {
                ItemStack itemstack = useOnContext.getItemInHand();
                if (player instanceof ServerPlayer) {
                    CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
                }

                level.playSound(player, blockpos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.setBlockAndUpdate(blockpos, growingplantheadblock.getMaxAgeState(blockstate));
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, (p_186374_) -> {
                        p_186374_.broadcastBreakEvent(useOnContext.getHand());
                    });
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        if (block instanceof WitherRoseBlock) {
            useOnContext.getItemInHand().hurtAndBreak(1, player, (event) -> {
                event.broadcastBreakEvent(useOnContext.getHand());
            });
            Block.popResource(level, blockpos, new ItemStack(HFItems.WITHER_PETAL.get()));
            level.playSound(player, blockpos, SoundEvents.GROWING_PLANT_CROP, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlockAndUpdate(blockpos, Blocks.AIR.defaultBlockState());
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return super.useOn(useOnContext);
    }
}
