package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AppSearchTest {

    private static final List<String> APPS = Arrays.asList("Google Maps", "Żółć", "Kalendarz", "Maps.me", "Radio");

    @Test
    void capitalsAndAccentsDoNotMatter() {
        assertTrue(AppSearch.matches("Żółć", "zolc"));
        assertTrue(AppSearch.matches("Google Maps", "MAPS"));
        assertTrue(AppSearch.matches("Élan", "elan"));
        assertTrue(AppSearch.matches("Straße", "stra"));
        assertFalse(AppSearch.matches("Radio", "radiu"));
    }

    @Test
    void aNameMatchesWhenItContainsWhatWasTyped() {
        assertEquals(Arrays.asList("Google Maps", "Maps.me"), AppSearch.filter(APPS, s -> s, "maps"));
        assertEquals(Arrays.asList("Kalendarz"), AppSearch.filter(APPS, s -> s, "  endar "));
    }

    @Test
    void nothingTypedShowsEverythingInTheSameList() {
        assertSame(APPS, AppSearch.filter(APPS, s -> s, ""));
        assertSame(APPS, AppSearch.filter(APPS, s -> s, "   "));
        assertSame(APPS, AppSearch.filter(APPS, s -> s, null));
    }

    @Test
    void theOrderOfTheListIsKeptAndNoMatchIsAnEmptyList() {
        // "a" is in four of the five names: they stay in the order of the list
        assertEquals(Arrays.asList("Google Maps", "Kalendarz", "Maps.me", "Radio"),
                AppSearch.filter(APPS, s -> s, "a"));
        assertTrue(AppSearch.filter(APPS, s -> s, "xyz").isEmpty());
    }
}
