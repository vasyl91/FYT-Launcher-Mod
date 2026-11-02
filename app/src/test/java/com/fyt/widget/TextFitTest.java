package com.fyt.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TextFitTest {

    // Text width is proportional to the size, as for a real font.
    private static float width(float perSize, float size) {
        return perSize * size;
    }

    @Test
    void textThatFitsKeepsTheMaximum() {
        assertEquals(18f, TextFit.fit(18f, 90f, 120f));
    }

    @Test
    void tooWideTextIsLoweredAndThenFits() {
        float perSize = 10f; // 18 sp -> 180 px wide
        float fitted = TextFit.fit(18f, width(perSize, 18f), 120f);
        assertTrue(fitted < 18f);
        assertTrue(width(perSize, fitted) <= 120f);
    }

    @Test
    void shorterTextAfterALongerOneGrowsBackToTheMaximum() {
        float longer = TextFit.fit(18f, 180f, 120f);
        float shorter = TextFit.fit(18f, 90f, 120f);
        assertTrue(longer < shorter);
        assertEquals(18f, shorter);
    }

    @Test
    void unknownWidthNeverChangesTheSize() {
        assertEquals(18f, TextFit.fit(18f, 180f, 0f));
        assertEquals(18f, TextFit.fit(18f, 0f, 120f));
    }
}
