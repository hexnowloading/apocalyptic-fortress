package net.hexnowloading.hexfortress.block.client.render;

import net.hexnowloading.hexfortress.block.client.model.DungeonChestBlockModel;
import net.hexnowloading.hexfortress.block.entity.DungeonChestBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class DungeonChestBlockRenderer extends GeoBlockRenderer<DungeonChestBlockEntity> {
    public DungeonChestBlockRenderer() {
        super(new DungeonChestBlockModel());
    }
}
