package net.hexnowloading.hexfortress.entity.client.renderer;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.FirestormEntity;
import net.hexnowloading.hexfortress.entity.client.model.FirestormModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

public class FirestormRenderer<T extends FirestormEntity> extends MobRenderer<T, FirestormModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(HexFortress.MODID, "textures/entity/firestorm.png");
    public FirestormRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FirestormModel<>(renderManager.bakeLayer(FirestormModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    protected int getBlockLightLevel(T entity, BlockPos blockPos) { return 15; }

    @Override
    public ResourceLocation getTextureLocation(FirestormEntity instance) {
        return TEXTURE;
    }
}
