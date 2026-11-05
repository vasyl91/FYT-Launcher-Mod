package com.fyt.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

class RadioStationStateTest {

    private static RadioStationState.Row row(int favorite, String cover, String title) {
        return new RadioStationState.Row(favorite, cover, title);
    }

    @Test
    void aFrequencyWithoutRowsIsKnownNotToBeAFavorite() {
        RadioStationState s = RadioStationState.of(Collections.emptyList());
        assertEquals(Boolean.FALSE, s.favorite);
        assertNull(s.coverPath);
    }

    @Test
    void aFavoriteRowInAnyCityMakesItAFavorite() {
        RadioStationState s = RadioStationState.of(Arrays.asList(row(0, null, "RMF"), row(1, null, "RMF FM")));
        assertEquals(Boolean.TRUE, s.favorite);
    }

    @Test
    void noFavoriteRowMeansNotAFavorite() {
        RadioStationState s = RadioStationState.of(Arrays.asList(row(0, "", "A"), row(0, "", "B")));
        assertEquals(Boolean.FALSE, s.favorite);
    }

    @Test
    void theCoverOfAFavoriteRowIsPreferred() {
        RadioStationState s = RadioStationState.of(Arrays.asList(
                row(0, "/sdcard/radio_logo/a.png", "A"), row(1, "/sdcard/radio_logo/b.png", "B")));
        assertEquals("/sdcard/radio_logo/b.png", s.coverPath);
        assertEquals("B", s.title);
    }

    @Test
    void anEmptyCoverPathIsNoCover() {
        RadioStationState s = RadioStationState.of(Arrays.asList(row(1, "  ", null), row(0, "/x/y.png", "T")));
        assertEquals("/x/y.png", s.coverPath);
        assertEquals("T", s.title);
    }

    @Test
    void aTableThatCouldNotBeReadIsUnknown() {
        RadioStationState s = RadioStationState.of(null);
        assertSame(RadioStationState.UNKNOWN, s);
        assertNull(s.favorite);
        assertTrue(s.coverPath == null && s.title == null);
    }
}
