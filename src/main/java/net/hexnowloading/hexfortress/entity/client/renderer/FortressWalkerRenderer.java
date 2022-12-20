package net.hexnowloading.hexfortress.entity.client.renderer;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.FortressWalkerEntity;
import net.hexnowloading.hexfortress.entity.client.model.FortressWalkerModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FortressWalkerRenderer<T extends FortressWalkerEntity> extends MobRenderer<T, FortressWalkerModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(HexFortress.MODID, "textures/entity/fortress_walker.png");
    public FortressWalkerRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FortressWalkerModel<>(renderManager.bakeLayer(FortressWalkerModel.LAYER_LOCATION)), 2.0F);
    }
    @Override
    public ResourceLocation getTextureLocation(FortressWalkerEntity instance) { return TEXTURE; }
}
