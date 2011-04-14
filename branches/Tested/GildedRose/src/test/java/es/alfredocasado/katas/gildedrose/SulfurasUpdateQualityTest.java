package es.alfredocasado.katas.gildedrose;

import java.util.Arrays;
import org.junit.Test;
import static es.alfredocasado.katas.gildedrose.GildedRose.updateQuality;
import static es.alfredocasado.katas.gildedrose.ItemBuilder.anItem;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SulfurasUpdateQualityTest {

    @Test
    public void never_has_to_be_sold() {
        Item sulfuras = sulfuras();
        
        updateQuality(Arrays.asList(sulfuras));
        assertThat(sulfuras.getSellIn(), is(0));
    }

    @Test
    public void never_decreases_quality() {
        Item sulfuras = sulfuras();
        
        updateQuality(Arrays.asList(sulfuras));
        assertThat(sulfuras.getQuality(), is(80));
    }
    
    private Item sulfuras() {
        return anItem().withName("Sulfuras, Hand of Ragnaros")
                       .withSellIn(0)
                       .withQuality(80)
                       .build();
    }
    
    

}
