package net.hexnowloading.hexfortress.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import javax.annotation.Nullable;

public class ModifiedWitherSkeletonEntity extends AbstractSkeleton {
    public ModifiedWitherSkeletonEntity(EntityType<? extends AbstractSkeleton> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.LAVA, 8.0F);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractPiglin.class, true));
        super.registerGoals();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_34195_) {
        return SoundEvents.WITHER_SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_DEATH;
    }

    @Override
    protected SoundEvent getStepSound() {
        return SoundEvents.WITHER_SKELETON_STEP;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource p_34174_, int p_34175_, boolean p_34176_) {
        super.dropCustomDeathLoot(p_34174_, p_34175_, p_34176_);
        Entity entity = p_34174_.getEntity();
        if (entity instanceof Creeper creeper) {
            if (creeper.canDropMobsSkull()) {
                creeper.increaseDroppedSkulls();
                this.spawnAtLocation(Items.WITHER_SKELETON_SKULL);
            }
        }
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        super.populateDefaultEquipmentSlots(randomSource, difficultyInstance);
        if (randomSource.nextFloat() < 0.40F) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
        } else {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        }
    }

    @Override
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        SpawnGroupData spawngroupdata = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(4.0D);
        this.reassessWeaponGoal();
        return spawngroupdata;
    }

    /*
    @Override
    public boolean checkSpawnRules(LevelAccessor levelAccessor, MobSpawnType spawnReason) {
        return true;
    }
    */

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (!super.doHurtTarget(entity)) {
            return false;
        } else {
            if (entity instanceof LivingEntity) {
                ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.WITHER, 200), this);
            }
            return true;
        }
    }

    @Override
    protected AbstractArrow getArrow(ItemStack itemStack, float v) {
        AbstractArrow abstractarrow = super.getArrow(itemStack, v);
        abstractarrow.setSecondsOnFire(100);
        return abstractarrow;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance mobEffectInstance) {
        return mobEffectInstance.getEffect() == MobEffects.WITHER ? false : super.canBeAffected(mobEffectInstance);
    }
}
