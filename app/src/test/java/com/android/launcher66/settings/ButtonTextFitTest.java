package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ButtonTextFitTest {

    /** Roboto: about 1.17 px of line per px of text. */
    private static final float ROBOTO = 1.17f;

    @Test
    void theSizeTheRowAsksForIsKeptWhenItsLineFits() {
        // a button of 60 px with a text of 30 px: the line is 35 px
        assertEquals(30f, ButtonTextFit.textPx(30f, 60, ROBOTO), 0.001f);
    }

    @Test
    void aTextWhoseLineIsHigherThanTheButtonIsMadeSmaller() {
        float px = ButtonTextFit.textPx(40f, 40, ROBOTO);
        assertTrue(px < 40f);
        assertTrue(px * ROBOTO <= 40f * ButtonTextFit.LINE_SHARE + 0.001f);
    }

    @Test
    void aFontWithAHighLineGetsLessText() {
        assertTrue(ButtonTextFit.textPx(30f, 40, 1.6f) < ButtonTextFit.textPx(30f, 40, ROBOTO));
    }

    @Test
    void withoutAHeightOrAFontTheWantedSizeStays() {
        assertEquals(30f, ButtonTextFit.textPx(30f, 0, ROBOTO), 0.001f);
        assertEquals(30f, ButtonTextFit.textPx(30f, 40, 0f), 0.001f);
    }

    @Test
    void theSizeIsNeverBelowOnePixel() {
        assertEquals(1f, ButtonTextFit.textPx(0f, 40, ROBOTO), 0.001f);
    }
}
