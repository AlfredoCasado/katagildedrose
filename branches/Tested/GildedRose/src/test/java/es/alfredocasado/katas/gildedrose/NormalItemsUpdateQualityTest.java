package es.alfredocasado.katas.gildedrose;

import java.util.Arrays;
import org.junit.Test;
import static es.alfredocasado.katas.gildedrose.GildedRose.updateQuality;
import static es.alfredocasado.katas.gildedrose.ItemBuilder.anItem;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class NormalItemsUpdateQualityTest {

    @Test
    public void items_degrade_quality_each_update() {
        Item item = anItem().withSellIn(1)
                            .withQuality(20)
                            .build();

        updateQuality(Arrays.asList(item));
        assertThat(item.quality, is(19));
    }
    
    @Test
    public void when_the_sellIn_date_has_passed_items_degrade_quality_twice() {
        Item item = anItem().withSellIn(0)
                            .withQuality(20)
                            .build();

        updateQuality(Arrays.asList(item));
        assertThat(item.quality, is(18));
    }
    
    @Test
    public void the_quality_of_an_item_is_never_negative() {
        Item item = anItem().withQuality(0)
                            .build();

        updateQuality(Arrays.asList(item));
        assertThat(item.quality, is(0));
    }

}
