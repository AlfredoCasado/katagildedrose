package es.alfredocasado.katas.gildedrose;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static es.alfredocasado.katas.gildedrose.GildedRose.updateQuality;

public class GildedRoseTest {

    @Test
    public void when_the_sellIn_date_has_passed_items_degrade_quality_twice() {
        Item itemWithSellInPassed = anItem().withSellIn(0)
                                            .withQuality(20)
                                            .build();


        updateQuality(ofInventoryWith(itemWithSellInPassed));

        assertThat(itemWithSellInPassed.quality, is(18));
    }

    @Test
    public void the_quality_of_an_item_is_never_negative() {
        Item itemWithZeroQuality = anItem().withQuality(0).build();

        updateQuality(ofInventoryWith(itemWithZeroQuality));

        assertThat(itemWithZeroQuality.quality, is(0));
    }

    @Test
    public void Aged_Brie_increases_quality_the_older_it_gets() {
        Item agedBrie = anItem().withName("Aged Brie")
                                .withSellIn(1)
                                .withQuality(1)
                                .build();

        updateQuality(ofInventoryWith(agedBrie));

        assertThat(agedBrie.getQuality(), is(2));
    }

    @Test
    public void the_quality_of_an_item_never_more_than_50() {
        Item agedBrie = anItem().withName("Aged Brie")
                                .withSellIn(1)
                                .withQuality(50)
                                .build();

        updateQuality(ofInventoryWith(agedBrie));

        assertThat(agedBrie.getQuality(), is(50));

    }

    @Test
    public void sulfuras_the_lengendary_item_never_has_to_be_sold() {
        Item sulfuras = anItem().withName("Sulfuras, Hand of Ragnaros")
                                .withSellIn(0)
                                .build();


        updateQuality(ofInventoryWith(sulfuras));

        assertThat(sulfuras.getSellIn(), is(0));
    }

    @Test
    public void sulfuras_the_legendary_item_never_decreases_quality() {
        Item sulfuras = anItem().withName("Sulfuras, Hand of Ragnaros")
                                .withQuality(80)
                                .build();

        updateQuality(ofInventoryWith(sulfuras));

        assertThat(sulfuras.getQuality(), is(80));
    }

    @Test
    public void backstage_passes_increases_in_quality_as_the_selling_day_aproaches() {
        Item backstagePass = anItem().withName("Backstage passes to a TAFKAL80ETC concert")
                                     .withQuality(20)
                                     .withSellIn(15)
                                     .build();


        updateQuality(ofInventoryWith(backstagePass));

        assertThat(backstagePass.getQuality(), is(21));
    }

    @Test
    public void backstage_passes_quality_increases_by_two_if_there_are_10_days_or_less_to_the_sellin_day() {
       Item backstagePass = anItem().withName("Backstage passes to a TAFKAL80ETC concert")
                                     .withQuality(20)
                                     .withSellIn(10)
                                     .build();

        updateQuality(ofInventoryWith(backstagePass));

        assertThat(backstagePass.getQuality(), is(22));
    }

    @Test
    public void backstage_passes_quality_increases_by_three_if_there_are_5_days_or_less_to_the_sellin_day() {
        Item backstagePass = anItem().withName("Backstage passes to a TAFKAL80ETC concert")
                                     .withQuality(20)
                                     .withSellIn(5)
                                     .build();

        updateQuality(ofInventoryWith(backstagePass));

        assertThat(backstagePass.getQuality(), is(23));
    }

    private List<Item> ofInventoryWith(Item item) {
        return Arrays.asList(item);
    }

    private ItemBuilder anItem() {
        return new ItemBuilder();
    }


}

class ItemBuilder {

    private int sellIn = 0;
    private int quality = 0;
    private String name = "some item";

    ItemBuilder withSellIn(int sellIn) {
        this.sellIn = sellIn;
        return this;
    }

    ItemBuilder withQuality(int quality) {
        this.quality = quality;
        return this;
    }

    ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    Item build() {
        return new Item(name, sellIn, quality);
    }


}
