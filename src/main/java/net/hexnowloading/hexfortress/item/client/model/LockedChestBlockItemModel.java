package net.hexnowloading.hexfortress.item.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.item.LockedChestBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LockedChestBlockItemModel extends AnimatedGeoModel<LockedChestBlockItem> {

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
}