package es.alfredocasado.katas.gildedrose;

import java.util.Arrays;
import org.junit.Test;
import static es.alfredocasado.katas.gildedrose.GildedRose.updateQuality;
import static es.alfredocasado.katas.gildedrose.ItemBuilder.anItem;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AgedBrieUpdateQualityTest {

    @Test
    public void increases_quality_the_older_it_gets() {
        Item agedBrie = anAgredBrie().withSellIn(1)
                                     .withQuality(1)
                                     .build();

        updateQuality(Arrays.asList(agedBrie));
        assertThat(agedBrie.getQuality(), is(2));
    }

    @Test
    public void never_increases_over_50() {
        Item agedBrie = anAgredBrie().withSellIn(1)
                                     .withQuality(50)
                                     .build();

        updateQuality(Arrays.asList(agedBrie));
        assertThat(agedBrie.getQuality(), is(50));
    }
    
    private ItemBuilder anAgredBrie() {
        return anItem().withName("Aged Brie");
    }


}
