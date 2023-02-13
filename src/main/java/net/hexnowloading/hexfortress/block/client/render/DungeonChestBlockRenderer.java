package net.hexnowloading.hexfortress.block.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hexnowloading.hexfortress.block.client.model.DungeonChestBlockModel;
import net.hexnowloading.hexfortress.block.client.model.LockedChestBlockModel;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import net.hexnowloading.hexfortress.block.entity.LockedChestBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class DungeonChestBlockRenderer extends GeoBlockRenderer<DungeonChestBlockEntity> {

    public DungeonChestBlockRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
        super(rendererDispatcherIn, new DungeonChestBlockModel());
    }

    @Override
    public RenderType getRenderType(DungeonChestBlockEntity animatable, float partialTick, PoseStack poseStack, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, int packedLight, ResourceLocation texture) {
        return RenderType.entityCutoutNoCull(getTextureLocation(animatable), false);
    }
}
