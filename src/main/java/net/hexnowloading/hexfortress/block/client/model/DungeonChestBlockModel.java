package net.hexnowloading.hexfortress.block.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;


public class DungeonChestBlockModel extends DefaultedBlockGeoModel<DungeonChestBlockEntity> {
    public DungeonChestBlockModel() {
        super(new ResourceLocation(HexFortress.MODID, "dungeon_chest"));
    }

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

    @Override
    public RenderType getRenderType(DungeonChestBlockEntity animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}