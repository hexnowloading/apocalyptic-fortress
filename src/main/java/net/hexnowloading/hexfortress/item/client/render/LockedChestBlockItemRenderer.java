package net.hexnowloading.hexfortress.item.client.render;

import net.hexnowloading.hexfortress.item.LockedChestBlockItem;
import net.hexnowloading.hexfortress.item.client.model.LockedChestBlockItemModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class LockedChestBlockItemRenderer extends GeoItemRenderer<LockedChestBlockItem> {

    public LockedChestBlockItemRenderer() { super(new LockedChestBlockItemModel()); }
}
