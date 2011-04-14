package es.alfredocasado.katas.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

    public static void main(String[] args) {

        List<Item> items = new ArrayList<Item>();

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality(items);

        for (Item item : items) {
            System.out.println("Item: " + item.name + ",Quality: " + item.quality + ",SellIn: " + item.sellIn);
        }
    }

    public static void updateQuality(List<Item> items) {
        for (Item item : items) {
            updateOne(item);
        }
    }

    private static void updateOne(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        updateQuality(item);
        updateSellIn(item);
    }

    private static void updateQuality(Item item) {
        if ((!isAgedBrie(item)) && !isBackstagePass(item)) {
            decreaseQuality(item);
        } else {
            increaseQuality(item);
            if (isBackstagePass(item)) {
                if (isSellInClose(item)) {
                    increaseQuality(item);
                }

                if (isSellInVeryClose(item)) {
                    increaseQuality(item);
                }
            }
        }

        if (isSellInPassed(item)) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    decreaseQuality(item);
                } else {
                    item.setQuality(0);
                }
            } else {
                increaseQuality(item);
            }
        }
    }

    private static void updateSellIn(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        item.setSellIn(item.getSellIn() - 1);
    }

    private static boolean isSulfuras(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.getName());
    }

    private static boolean isAgedBrie(Item item) {
        return "Aged Brie".equals(item.getName());
    }

    private static boolean isBackstagePass(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
    }

    private static void decreaseQuality(Item item) {
        if (item.getQuality() > 0) {
            item.setQuality(item.getQuality() - 1);
        }
    }

    private static void increaseQuality(Item item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
        }
    }
    
    private static boolean isSellInPassed(Item item) {
        return item.getSellIn() <= 0;
    }
    
    private static boolean isSellInClose(Item item) {
        return item.getSellIn() < 11;
    }

    private static boolean isSellInVeryClose(Item item) {
        return item.getSellIn() < 6;
    }
}
