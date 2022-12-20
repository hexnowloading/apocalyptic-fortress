package net.hexnowloading.hexfortress.item.client.render;

import net.hexnowloading.hexfortress.item.DungeonChestBlockItem;
import net.hexnowloading.hexfortress.item.client.model.DungeonChestBlockItemModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class DungeonChestBlockItemRenderer extends GeoItemRenderer<DungeonChestBlockItem> {

    public DungeonChestBlockItemRenderer() { super(new DungeonChestBlockItemModel()); }
}
