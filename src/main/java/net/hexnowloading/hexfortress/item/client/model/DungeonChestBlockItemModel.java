package net.hexnowloading.hexfortress.item.client.model;

import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.item.DungeonChestBlockItem;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DungeonChestBlockItemModel extends DefaultedItemGeoModel<DungeonChestBlockItem> {
    public DungeonChestBlockItemModel() { super(new ResourceLocation(HexFortress.MODID, "dungeon_chest")); }

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

    @Override
    public RenderType getRenderType(DungeonChestBlockItem animatable, ResourceLocation texture) {
        return RenderType.entityTranslucent(getTextureResource(animatable));
    }
}
