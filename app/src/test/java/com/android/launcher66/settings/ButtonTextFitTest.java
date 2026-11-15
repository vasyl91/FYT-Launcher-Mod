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

    @Test
    void aLabelTooLongForItsButtonIsMadeSmallerNotBroken() {
        // "Paleisti iš naujo 1": about 8.6 px of width per px of text; a button with 120 px for its text
        float px = ButtonTextFit.textPx(30f, 60, ROBOTO, 120, 8.6f);
        assertTrue(px < 30f);
        assertTrue(px * 8.6f <= 120f + 0.001f, "the whole label lies in the button's width");
    }

    @Test
    void aShortLabelKeepsItsSizeInAWideButton() {
        // "Restart 1": about 4.4 px per px; 30 px of text need 132 px
        assertEquals(30f, ButtonTextFit.textPx(30f, 60, ROBOTO, 140, 4.4f), 0.001f);
    }

    @Test
    void theSmallerOfTheTwoLimitsHolds() {
        // The height allows 29.4, the width 20
        assertEquals(20f, ButtonTextFit.textPx(40f, 40, ROBOTO, 100, 5f), 0.001f);
        // The width allows 50, the height 29.4
        assertEquals(40f * ButtonTextFit.LINE_SHARE / ROBOTO, ButtonTextFit.textPx(40f, 40, ROBOTO, 250, 5f), 0.001f);
    }

    @Test
    void aButtonAsWideAsItsTextHasNoWidthLimit() {
        assertEquals(30f, ButtonTextFit.textPx(30f, 60, ROBOTO, 0, 99f), 0.001f);
    }
}
