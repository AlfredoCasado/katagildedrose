package es.alfredocasado.katas.gildedrose;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private final List<InventoryItem> items;
    private final UpdaterSelector select = new UpdaterSelector();

    public Inventory(List<InventoryItem> items) {
        this.items = items;
    }

    void update() {
        for (InventoryItem iventoryItem : items) {
            updateOne(iventoryItem);
        }
    }

    private void updateOne(InventoryItem item) {
        select.updaterFor(item).updateQuality(item);
        select.updaterFor(item).updateSellIn(item);
    }
}

class UpdaterSelector {

    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    
    private static final Map<String, ItemUpdater> updaters = new HashMap();
    private static final ItemUpdater updater = new ItemUpdater();

    static {
        updaters.put(SULFURAS, new SulfurasUpdater());
        updaters.put(AGED_BRIE, new AgedBrieUpdater());
        updaters.put(BACKSTAGE, new BacstagePassUpdater());
    }

    public ItemUpdater updaterFor(InventoryItem inventoryItem) {
        if (updaters.containsKey(inventoryItem.name())) {
            return updaters.get(inventoryItem.name());
        } else {
            return updater;
        }
    }
}
