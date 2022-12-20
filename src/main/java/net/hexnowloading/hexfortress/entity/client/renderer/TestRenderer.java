package net.hexnowloading.hexfortress.entity.client.renderer;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.TestEntity;
import net.hexnowloading.hexfortress.entity.client.model.TestModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TestRenderer<T extends TestEntity> extends MobRenderer<T, TestModel<T>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(HexFortress.MODID, "textures/entity/test.png");
    public TestRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TestModel<>(renderManager.bakeLayer(TestModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(TestEntity instance) {
        return TEXTURE;
    }
}
