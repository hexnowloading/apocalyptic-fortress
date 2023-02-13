package net.hexnowloading.hexfortress.item.client.model;

import net.hexnowloading.hexfortress.item.DungeonChestBlockItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DungeonChestBlockItemModel extends AnimatedGeoModel<DungeonChestBlockItem> {

    @Override
    public ResourceLocation getTextureResource(DungeonChestBlockItem object) {
        return new ResourceLocation("hexfortress", "textures/block/dungeon_chest.png");
    }

    @Override
    public ResourceLocation getModelResource(DungeonChestBlockItem object) {
        return new ResourceLocation("hexfortress", "geo/dungeon_chest.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(DungeonChestBlockItem object) {
        return new ResourceLocation("hexfortress", "animations/dungeon_chest.animation.json");
    }
}
