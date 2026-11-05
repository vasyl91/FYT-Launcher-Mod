package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class StockLogoNamesTest {

    @Test
    void aFmFrequencyLosesItsDotAndIsReadAsAWholeNumber() {
        StockLogoNames.Logo logo = StockLogoNames.parse("Radio Zet_90.40.png");
        assertNotNull(logo);
        assertEquals("Radio Zet", logo.name);
        assertEquals(9040, logo.freq);
        assertEquals(9040, StockLogoNames.parse("RMF_9040.png").freq);
    }

    @Test
    void oneDecimalIsAnotherNumberThanTheUnitsOfTheRadioModule() {
        // "90.4" is 904 for com.syu.media: not the 9040 of 90.40 MHz
        assertEquals(904, StockLogoNames.parse("RMF_90.4.png").freq);
        assertNotEquals(9040, StockLogoNames.parse("RMF_90.4.png").freq);
    }

    @Test
    void anAmFrequencyIsTheKilohertz() {
        assertEquals(1008, StockLogoNames.parse("Jedynka_1008.png").freq);
    }

    @Test
    void exactlyTwoPartsAroundTheUnderscore() {
        assertNull(StockLogoNames.parse("My_Station_90.40.png"));
        assertNull(StockLogoNames.parse("Station90.40.png"));
        assertNull(StockLogoNames.parse("_90.40.png"));
    }

    @Test
    void theExtensionIsPngInLowerCase() {
        assertNull(StockLogoNames.parse("RMF_90.40.PNG"));
        assertNull(StockLogoNames.parse("RMF_90.40.jpg"));
        assertNull(StockLogoNames.parse("RMF_90.40"));
        assertNull(StockLogoNames.parse(null));
    }

    @Test
    void aFrequencyThatIsNotANumberIsNoLogo() {
        assertNull(StockLogoNames.parse("RMF_abc.png"));
        assertNull(StockLogoNames.parse("RMF_.png"));
    }

    @Test
    void theFallbackPictureStaysTheSameForAFrequency() {
        assertEquals("radio1", StockLogoNames.fallbackDrawable(9000));
        assertEquals(StockLogoNames.fallbackDrawable(9040), StockLogoNames.fallbackDrawable(9040));
        for (int f = 8750; f <= 10800; f += 10) {
            String name = StockLogoNames.fallbackDrawable(f);
            assertEquals(true, name.equals("radio1") || name.equals("radio2") || name.equals("radio3"), name);
        }
    }
}
