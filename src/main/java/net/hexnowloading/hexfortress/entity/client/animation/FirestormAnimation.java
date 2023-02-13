package net.hexnowloading.hexfortress.entity.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class FirestormAnimation {
    public static final AnimationDefinition FIRESTORM_ATTACK = AnimationDefinition.Builder.withLength(1f)
            .addAnimation("rod1",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(-5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod4",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 5f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();

    public static final AnimationDefinition FIRESTORM_ATTACK_REVERT = AnimationDefinition.Builder.withLength(1f)
            .addAnimation("rod1",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod2",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, -5f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod3",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(-5f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM)))
            .addAnimation("rod4",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 5f),
                                    AnimationChannel.Interpolations.CATMULLROM),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.CATMULLROM))).build();
}
