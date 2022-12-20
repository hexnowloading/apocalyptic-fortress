package net.hexnowloading.hexfortress.entity.client.renderer;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.WildfireEntity;
import net.hexnowloading.hexfortress.entity.client.model.WildfireModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class WildfireRenderer<T extends WildfireEntity> extends MobRenderer<T, WildfireModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(HexFortress.MODID, "textures/entity/wildfire.png");
    public WildfireRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WildfireModel<>(renderManager.bakeLayer(WildfireModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) { return 15; }

    @Override
    public ResourceLocation getTextureLocation(WildfireEntity instance) {
        return TEXTURE;
    }
}
