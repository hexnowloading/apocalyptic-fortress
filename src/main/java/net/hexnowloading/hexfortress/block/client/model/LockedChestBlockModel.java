package net.hexnowloading.hexfortress.block.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import net.hexnowloading.hexfortress.block.entity.LockedChestBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LockedChestBlockModel extends AnimatedGeoModel<LockedChestBlockEntity> {

    @Override
    public ResourceLocation getTextureResource(LockedChestBlockEntity object) {
        return new ResourceLocation(HexFortress.MODID, "textures/block/locked_chest.png");
    }

    @Override
    public ResourceLocation getModelResource(LockedChestBlockEntity object) {
        return new ResourceLocation(HexFortress.MODID, "geo/locked_chest.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(LockedChestBlockEntity object) {
        return new ResourceLocation(HexFortress.MODID, "animations/locked_chest.animation.json");
    }
}