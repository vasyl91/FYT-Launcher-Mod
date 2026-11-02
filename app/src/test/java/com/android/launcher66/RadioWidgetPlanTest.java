package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.WidgetMetrics;

import org.junit.jupiter.api.Test;

class RadioWidgetPlanTest {

    /** Roughly the widths of "MHz" and "108.00" per px of text size in Roboto. */
    private static final float LABEL = 1.9f;
    private static final float FREQ = 3.4f * 1.08f;

    private static int usedWidth(RadioWidgetPlan.Plan p) {
        return 2 * p.paddingPx + 2 * p.columnPx + 2 * p.gapPx + Math.round(p.freqTextPx * FREQ);
    }

    private static int columnHeight(RadioWidgetPlan.Plan p) {
        return p.labelRowPx + p.gapPx + p.buttonPx;
    }

    @Test
    void everythingGrowsWithTheWidget() {
        RadioWidgetPlan.Plan small = RadioWidgetPlan.plan(250, 90, 1f, LABEL, FREQ);
        RadioWidgetPlan.Plan large = RadioWidgetPlan.plan(500, 180, 1f, LABEL, FREQ);
        assertTrue(large.buttonPx > small.buttonPx);
        assertTrue(large.labelTextPx > small.labelTextPx);
        assertTrue(large.freqTextPx > small.freqTextPx);
        assertEquals(2 * small.buttonPx, large.buttonPx, 2);
        assertEquals(2 * small.freqTextPx, large.freqTextPx, 2f);
    }

    @Test
    void theContentFitsTheWidget() {
        int[][] sizes = {{250, 90}, {500, 180}, {300, 300}, {800, 120}, {180, 160}, {1200, 400}};
        for (int[] s : sizes) {
            RadioWidgetPlan.Plan p = RadioWidgetPlan.plan(s[0], s[1], 1f, LABEL, FREQ);
            assertTrue(usedWidth(p) <= s[0] + 1, "width " + s[0] + "x" + s[1] + ": " + p);
            assertTrue(columnHeight(p) <= s[1] - 2 * p.paddingPx, "height " + s[0] + "x" + s[1] + ": " + p);
            assertTrue(p.freqTextPx * RadioWidgetPlan.LINE_FACTOR <= s[1] - 2 * p.paddingPx + 1,
                    "freq " + s[0] + "x" + s[1] + ": " + p);
            assertTrue(p.columnPx >= p.buttonPx);
            assertTrue(p.labelTextPx * LABEL <= p.columnPx + 1, "label " + s[0] + "x" + s[1] + ": " + p);
        }
    }

    @Test
    void aWideShortWidgetIsLimitedByTheHeight() {
        RadioWidgetPlan.Plan p = RadioWidgetPlan.plan(1000, 100, 1f, LABEL, FREQ);
        int innerH = 100 - 2 * p.paddingPx;
        assertEquals(Math.round(innerH * RadioWidgetPlan.FREQ_ROW) / RadioWidgetPlan.LINE_FACTOR,
                p.freqTextPx, 0.01f);
    }

    @Test
    void aNarrowTallWidgetIsLimitedByTheWidth() {
        RadioWidgetPlan.Plan p = RadioWidgetPlan.plan(200, 400, 1f, LABEL, FREQ);
        assertTrue(p.freqTextPx * RadioWidgetPlan.LINE_FACTOR < 400 * 0.5f);
        assertTrue(usedWidth(p) <= 201);
    }

    @Test
    void neverBelowTheMinimumText() {
        RadioWidgetPlan.Plan p = RadioWidgetPlan.plan(40, 20, 2f, LABEL, FREQ);
        assertTrue(p.freqTextPx >= RadioWidgetPlan.MIN_TEXT_SP * 2f);
        assertTrue(p.labelTextPx >= RadioWidgetPlan.MIN_TEXT_SP * 2f);
    }

    @Test
    void textFitsTheMinimumWidgetTheCreatorAllows() {
        int[][] screens = {{1280, 720}, {1920, 1080}, {2000, 1200}};
        float[] densities = {1.5f, 2.0f};
        for (int[] screen : screens) {
            WidgetMetrics.Metrics m = WidgetMetrics.compute(screen[0], screen[1]);
            for (float density : densities) {
                RadioWidgetPlan.Plan p = RadioWidgetPlan.plan(m.radioMinWidth, m.radioMinHeight,
                        density, 2.0f, 3.3f);
                String where = screen[0] + "x" + screen[1] + " density " + density + ": " + p;
                assertTrue(p.labelTextPx * 2.0f <= p.columnPx + 1, "label " + where);
                int innerW = m.radioMinWidth - 2 * p.paddingPx;
                int freqWidth = innerW - 2 * p.columnPx - 2 * p.gapPx;
                assertTrue(p.freqTextPx * 3.3f <= freqWidth + 1, "frequency " + where);
            }
        }
    }
}
