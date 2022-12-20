package net.hexnowloading.hexfortress.block.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import net.hexnowloading.hexfortress.block.entity.LockedChestBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class LockedChestBlockModel extends DefaultedBlockGeoModel<LockedChestBlockEntity> {
    public LockedChestBlockModel() {
        super(new ResourceLocation(HexFortress.MODID, "locked_chest"));
    }

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

    @Override
    public RenderType getRenderType(LockedChestBlockEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}