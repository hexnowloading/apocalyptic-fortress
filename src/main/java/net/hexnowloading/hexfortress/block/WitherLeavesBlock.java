package net.hexnowloading.hexfortress.block;

import net.hexnowloading.hexfortress.entity.FirestormEntity;
import net.hexnowloading.hexfortress.registry.HFItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.Nullable;

public class WitherLeavesBlock extends Block {
    public WitherLeavesBlock(Properties properties) {
        super(properties);
    }

    private boolean shouldDamage(LivingEntity livingEntity) {
        return !(livingEntity instanceof WitherSkeleton || livingEntity instanceof Blaze || livingEntity instanceof Ghast || livingEntity instanceof FirestormEntity || livingEntity instanceof Player);
    }

    private boolean shouldDamagePlayer(LivingEntity livingEntity, Level level) {
        return livingEntity instanceof Player && !level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL && !((Player) livingEntity).getAbilities().instabuild;
    };

    @Override
    @Deprecated
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (shouldDamage(livingEntity) || shouldDamagePlayer(livingEntity, level)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 40));
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (shouldDamage(livingEntity) || shouldDamagePlayer(livingEntity, level)) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 40));
            }
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(level, player, pos, state, blockEntity, stack);
        if (!level.isClientSide && level.getDifficulty() != Difficulty.PEACEFUL && !stack.is(HFItems.WITHERITE_SWORD.get()) && !stack.is(HFItems.WITHERITE_SHEARS.get())) {
            player.addEffect(new MobEffectInstance(MobEffects.WITHER, 40,4));
        }
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 0;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource source) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        for(int i = 0; i < 1; ++i) {
            if (source.nextBoolean()) {
                level.addParticle(ParticleTypes.SMOKE, d0 + source.nextDouble(), d1 + source.nextDouble(), d2 + source.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 0;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter getter, BlockPos pos, PathComputationType computationType) {
        return false;
    }
}
