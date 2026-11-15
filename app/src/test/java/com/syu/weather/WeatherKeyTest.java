package com.syu.weather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class WeatherKeyTest {

    private static final String BUILT_IN = "00000000000000000000000000000000";
    private static final String OWN = "0123456789abcdef0123456789ABCDEF";

    @Test
    void aKeyIs32LettersAToFAndDigits() {
        assertTrue(WeatherKey.valid(OWN));
        assertTrue(WeatherKey.valid("  " + OWN + "\n"));
        assertFalse(WeatherKey.valid(null));
        assertFalse(WeatherKey.valid(""));
        assertFalse(WeatherKey.valid(OWN.substring(1)));
        assertFalse(WeatherKey.valid(OWN + "0"));
        assertFalse(WeatherKey.valid("0123456789abcdef0123456789abcdeg"));
    }

    @Test
    void theUsersOwnKeyIsUsedInPlaceOfTheBuiltInOne() {
        assertEquals(OWN, WeatherKey.use(" " + OWN + " ", BUILT_IN));
    }

    @Test
    void withoutAKeyOrWithAMistypedOneTheBuiltInKeyStays() {
        assertEquals(BUILT_IN, WeatherKey.use(null, BUILT_IN));
        assertEquals(BUILT_IN, WeatherKey.use("", BUILT_IN));
        assertEquals(BUILT_IN, WeatherKey.use("my key", BUILT_IN));
    }

    @Test
    void onlyTheLastFourCharactersAreShown() {
        assertEquals("•••• CDEF", WeatherKey.shown(OWN));
        assertNull(WeatherKey.shown(""));
        assertNull(WeatherKey.shown("abc"));
    }
}
