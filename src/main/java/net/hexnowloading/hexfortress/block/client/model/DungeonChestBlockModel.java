package net.hexnowloading.hexfortress.block.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;


public class DungeonChestBlockModel extends AnimatedGeoModel<DungeonChestBlockEntity> {

    @Override
    public ResourceLocation getTextureResource(DungeonChestBlockEntity object) {
        return new ResourceLocation("hexfortress", "textures/block/dungeon_chest.png");
    }

    @Override
    public ResourceLocation getModelResource(DungeonChestBlockEntity object) {
        return new ResourceLocation("hexfortress", "geo/dungeon_chest.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(DungeonChestBlockEntity object) {
        return new ResourceLocation("hexfortress", "animations/dungeon_chest.animation.json");
    }
}