package net.hexnowloading.hexfortress.block.client.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class DungeonChestAnimation {
    public static final AnimationDefinition CLOSE = AnimationDefinition.Builder.withLength(0.33333f)
            .addAnimation("lid",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3333f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition OPEN = AnimationDefinition.Builder.withLength(0.33333f)
            .addAnimation("lid",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3333f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition CLOSED = AnimationDefinition.Builder.withLength(0f)
            .addAnimation("lid",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition OPENED = AnimationDefinition.Builder.withLength(0f)
            .addAnimation("lid",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-90f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
