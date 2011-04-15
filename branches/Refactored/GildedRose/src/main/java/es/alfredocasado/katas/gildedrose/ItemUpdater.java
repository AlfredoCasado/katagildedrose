package es.alfredocasado.katas.gildedrose;

public class ItemUpdater {

    public void updateQuality(InventoryItem item) {
        item.decreaseQuality();
        if (item.isSellInPassed()) {
            item.decreaseQuality();
        }
    }

    public void updateSellIn(InventoryItem item) {
        item.decreaseSellIn();
    }
}

class SulfurasUpdater extends ItemUpdater {

    @Override
    public void updateQuality(InventoryItem item) {
    }

    @Override
    public void updateSellIn(InventoryItem item) {
    }
}

class AgedBrieUpdater extends ItemUpdater {

    @Override
    public void updateQuality(InventoryItem item) {
        if (item.isSellInPassed()) {
            item.decreaseQuality();
        } else {
            item.increaseQuality();
        }
    }
}

class BacstagePassUpdater extends ItemUpdater {

    @Override
    public void updateQuality(InventoryItem item) {
        if (item.isSellInPassed()) {
            item.setMinimumQuality();
        } else {
            item.increaseQuality();
            if (item.isSellInClose()) {
                item.increaseQuality();
            }
            if (item.isSellInVeryClose()) {
                item.increaseQuality();
            }
        }
    }
}
