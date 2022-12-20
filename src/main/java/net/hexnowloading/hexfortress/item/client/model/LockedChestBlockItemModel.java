package net.hexnowloading.hexfortress.item.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.item.LockedChestBlockItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class LockedChestBlockItemModel extends DefaultedItemGeoModel<LockedChestBlockItem> {
    public LockedChestBlockItemModel() { super(new ResourceLocation(HexFortress.MODID, "locked_chest")); }

    @Override
    public ResourceLocation getTextureResource(LockedChestBlockItem object) {
        return new ResourceLocation("hexfortress", "textures/block/locked_chest.png");
    }

    @Override
    public ResourceLocation getModelResource(LockedChestBlockItem object) {
        return new ResourceLocation("hexfortress", "geo/locked_chest.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(LockedChestBlockItem object) {
        return new ResourceLocation("hexfortress", "animations/locked_chest.animation.json");
    }

    @Override
    public RenderType getRenderType(LockedChestBlockItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}