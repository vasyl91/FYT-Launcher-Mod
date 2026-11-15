package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TitleTagTest {

    @Test
    void thePlaceholdersAreNoTitle() {
        assertNull(TitleTag.valid(null));
        assertNull(TitleTag.valid(""));
        assertNull(TitleTag.valid("   "));
        assertNull(TitleTag.valid("null"));
        assertNull(TitleTag.valid("Unknown"));
        assertNull(TitleTag.valid("UNKNOWN"));
        assertNull(TitleTag.valid(" unknown "));
        assertNull(TitleTag.valid("<unknown>"));
        assertNull(TitleTag.valid("<UNKNOWN>"));
    }

    @Test
    void aTitleWithTheWordInItIsATitle() {
        assertEquals("Unknown Pleasures", TitleTag.valid("Unknown Pleasures"));
        assertEquals("The Unknown", TitleTag.valid("The Unknown"));
        assertEquals("Null and Void", TitleTag.valid("Null and Void"));
        assertTrue(TitleTag.isValue("Nullsleep"));
    }

    @Test
    void aValueIsTrimmed() {
        assertEquals("Atmosphere", TitleTag.valid("  Atmosphere \n"));
        assertFalse(TitleTag.isValue(" <unknown> "));
    }
}
