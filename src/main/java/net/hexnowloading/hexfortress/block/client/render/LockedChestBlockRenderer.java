package net.hexnowloading.hexfortress.block.client.render;

import net.hexnowloading.hexfortress.block.client.model.LockedChestBlockModel;
import net.hexnowloading.hexfortress.block.entity.LockedChestBlockEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class LockedChestBlockRenderer extends GeoBlockRenderer<LockedChestBlockEntity> {
    public LockedChestBlockRenderer() {
        super(new LockedChestBlockModel());
    }
}
