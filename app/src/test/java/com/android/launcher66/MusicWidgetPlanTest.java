package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MusicWidgetPlanTest {

    @Test
    void theBarGoesToOneRowAtTwelvePercentOfTheShorterSide() {
        assertTrue(MusicWidgetPlan.barCompact(72, 600));
        assertFalse(MusicWidgetPlan.barCompact(73, 600));
        assertFalse(MusicWidgetPlan.barCompact(10, 0));
    }

    @Test
    void theDefaultBarsAreNotCompact() {
        // 1024x600 with a status bar of 40: (int) (560 * 0.1638) = 91
        assertFalse(MusicWidgetPlan.barCompact((int) (560 * 0.1638f), 600));
        // 600x1024: (int) (600 * 0.142) = 85
        assertFalse(MusicWidgetPlan.barCompact((int) (600 * 0.142f), 600));
    }

    @Test
    void aLargeHomeWidgetKeepsTwoRowsAtTheMaximumTextSize() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planHome(338, 333, 1f, 22f);
        assertFalse(plan.compact);
        assertTrue(plan.cover);
        assertEquals(43, plan.rowPx);
        assertEquals(22f, plan.textPx, 0.001f);
    }

    @Test
    void aShortHomeWidgetGoesToOneRowWithTheCover() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planHome(338, 100, 1f, 22f);
        assertTrue(plan.compact);
        assertTrue(plan.cover);
        assertEquals(17, plan.rowPx);
    }

    @Test
    void aVeryShortHomeWidgetLosesTheCover() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planHome(338, 60, 1f, 22f);
        assertTrue(plan.compact);
        assertFalse(plan.cover);
        assertEquals(18, plan.rowPx);
    }

    @Test
    void theTextIsNeverBelowTheFloor() {
        for (int h = 1; h < 700; h += 7) {
            for (float density : new float[] {1f, 1.5f, 2f}) {
                MusicWidgetPlan.Plan plan = MusicWidgetPlan.planHome(300, h, density, 22f * density);
                assertTrue(plan.textPx >= MusicWidgetPlan.MIN_TEXT_SP_FLOOR * density);
            }
        }
    }

    @Test
    void theBarIsCompactOnlyAtTwelvePercent() {
        assertTrue(MusicWidgetPlan.planBar(400, 72, 72, 600, 1f).compact);
        assertFalse(MusicWidgetPlan.planBar(400, 91, 91, 600, 1f).compact);
        assertTrue(MusicWidgetPlan.planBar(400, 72, 72, 600, 1f).buttonSidePx > 0);
        assertTrue(MusicWidgetPlan.planBar(400, 91, 91, 600, 1f).buttonSidePx > 0);
    }

    @Test
    void thePartsNeverAddUpToMoreThanTheHeight() {
        for (int h = 20; h < 700; h += 3) {
            for (int w : new int[] {120, 338, 800}) {
                MusicWidgetPlan.Plan home = MusicWidgetPlan.planHome(w, h, 1f, 22f);
                int homeSum = (home.cover ? home.coverPx : 0) + home.rows() * home.rowPx
                        + home.progressPx + home.buttonRowPx
                        + home.gapPx * ((home.cover ? 1 : 0) + home.rows() + 2);
                assertTrue(homeSum <= h, "home " + w + "x" + h + " " + home + " sum " + homeSum);

                MusicWidgetPlan.Plan bar = MusicWidgetPlan.planBar(w, h, h, 1000, 1f);
                int barSum = bar.rows() * bar.rowPx + bar.buttonRowPx + bar.gapPx * (bar.rows() + 1);
                assertTrue(barSum <= h, "bar " + w + "x" + h + " " + bar + " sum " + barSum);
            }
        }
    }
}
