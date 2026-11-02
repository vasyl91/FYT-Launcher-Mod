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

    @Test
    void boxFitIsLimitedByWhicheverOfWidthAndHeightIsTighter() {
        // 20 px wide per size unit, line height 1.2 per size unit, maximum 18
        float perSize = 20f;
        float line = 1.2f;
        // wide and tall box: the maximum
        assertEquals(18f, TextFit.fitBox(18f, perSize * 18f, line * 18f, 1000f, 500f, 0.3f));
        // narrow box: the width decides and the text fits it
        float byWidth = TextFit.fitBox(18f, perSize * 18f, line * 18f, 200f, 500f, 0.3f);
        assertTrue(byWidth < 18f && perSize * byWidth <= 200f);
        // low box: the line may take 30 % of 60 px = 18 px -> size 15
        float byHeight = TextFit.fitBox(18f, perSize * 18f, line * 18f, 1000f, 60f, 0.3f);
        assertEquals(15f, byHeight, 0.01f);
        assertTrue(line * byHeight <= 60f * 0.3f + 0.01f);
    }
}
