package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HeartTintTest {

    @Test
    void aLikedHeartKeepsItsOwnRed() {
        assertEquals(ViewTint.NONE, HeartTint.of(true, 0xFF00FF00));
        assertEquals(ViewTint.NONE, HeartTint.of(true, ViewTint.NONE));
    }

    @Test
    void aHeartNotLikedHasTheButtonsColour() {
        assertEquals(0xFF00FF00, HeartTint.of(false, 0xFF00FF00));
        assertEquals(ViewTint.NONE, HeartTint.of(false, ViewTint.NONE));
    }
}
