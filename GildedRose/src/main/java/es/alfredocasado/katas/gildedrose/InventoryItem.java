package es.alfredocasado.katas.gildedrose;

public class InventoryItem {

    private final Item item;

    public InventoryItem(Item item) {
        this.item = item;
    }

    boolean is(String itemName) {
        return itemName.equals(item.name);
    }

    public void decreaseQuality() {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    public void increaseQuality() {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }

    public boolean isSellInPassed() {
        return item.getSellIn() <= 0;
    }

    public boolean isSellInClose() {
        return item.getSellIn() < 11;
    }

    public boolean isSellInVeryClose() {
        return item.getSellIn() < 6;
    }

    void setMinimumQuality() {
        item.setQuality(0);
    }

    void decreaseSellIn() {
        item.setSellIn(item.getSellIn()-1);
    }

    String name() {
        return item.name;
    }

}
