package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.android.launcher66.settings.WidgetMetrics;

import org.junit.jupiter.api.Test;

class MusicWidgetPlanTest {

    @Test
    void theBarShowsOneRowOnlyWhenTheUserAsksForIt() {
        // the height of the bar does not matter any more: 40 px and 120 px give the same answer
        for (int h : new int[] {40, 66, 72, 73, 91, 120}) {
            assertFalse(MusicWidgetPlan.planBar(400, h, 1f, false).compact, "two lines " + h);
            assertTrue(MusicWidgetPlan.planBar(400, h, 1f, true).compact, "one line " + h);
            assertFalse(MusicWidgetPlan.planBarWide(400, h, 1f, false).compact, "wide two lines " + h);
            assertTrue(MusicWidgetPlan.planBarWide(400, h, 1f, true).compact, "wide one line " + h);
        }
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
    void theBarHasButtonsInBothModes() {
        assertTrue(MusicWidgetPlan.planBar(400, 72, 1f, true).buttonSidePx > 0);
        assertTrue(MusicWidgetPlan.planBar(400, 91, 1f, false).buttonSidePx > 0);
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

                for (boolean oneLine : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan bar = MusicWidgetPlan.planBar(w, h, 1f, oneLine);
                    int barSum = bar.rows() * bar.rowPx + bar.buttonRowPx + bar.gapPx * (bar.rows() + 1);
                    assertTrue(barSum <= h, "bar " + w + "x" + h + " " + bar + " sum " + barSum);
                }
            }
        }
    }

    @Test
    void homePartsFitTheMinimumWidgetTheCreatorAllows() {
        int[][] screens = {{1280, 720}, {1920, 1080}, {2000, 1200}};
        float[] densities = {1.5f, 2.0f};
        for (int[] screen : screens) {
            WidgetMetrics.Metrics m = WidgetMetrics.compute(screen[0], screen[1]);
            for (float density : densities) {
                MusicWidgetPlan.Plan p = MusicWidgetPlan.planHome(m.musicMinWidth, m.musicMinHeight,
                        density, 22f * density);
                String where = screen[0] + "x" + screen[1] + " density " + density + ": " + p;
                int elements = (p.cover ? 1 : 0) + p.rows() + 2;
                int used = (p.cover ? p.coverPx : 0) + p.rows() * p.rowPx + p.progressPx
                        + p.buttonRowPx + elements * p.gapPx;
                assertTrue(used <= m.musicMinHeight, "height " + where);
                assertTrue(4 * p.buttonSidePx <= m.musicMinWidth, "buttons " + where);
                assertTrue(p.coverPx <= m.musicMinWidth, "cover " + where);
            }
        }
    }

    // The wide bar: the date or the weather is hidden and the music widget has their room.

    @Test
    void theWideBarGivesTheButtonsThirtyPercentOfTheWidthIn2x2() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(600, 90, 1f, false);
        assertTrue(plan.wide);
        assertFalse(plan.compact);
        assertEquals(2, plan.buttonRows);
        assertEquals(180, plan.buttonBlockPx, 1);
        assertEquals(90, plan.cellWidthPx);
        assertEquals(45, plan.buttonRowPx);
        assertEquals(Math.round(45 * MusicWidgetPlan.BUTTON_FILL), plan.buttonSidePx);
    }

    @Test
    void theCompactWideBarGivesTheButtonsFortyPercentInOneRow() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(359, 66, 1f, true);
        assertTrue(plan.wide);
        assertTrue(plan.compact);
        assertEquals(1, plan.buttonRows);
        assertEquals(144, plan.buttonBlockPx, 1);   // 40% of 359
        assertEquals(36, plan.cellWidthPx, 1);
        assertEquals(66, plan.buttonRowPx);
        assertEquals(Math.round(Math.min(plan.cellWidthPx, 66) * MusicWidgetPlan.BUTTON_FILL), plan.buttonSidePx);
    }

    @Test
    void thePartsOfTheWideBarFitTheWidgetInBothDirections() {
        for (int w : new int[]{200, 359, 400, 560, 800}) {
            for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
                for (boolean oneLine : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(w, h, 1f, oneLine);
                    int gap = (int) (w * MusicWidgetPlan.BAR_COLUMN_GAP);
                    assertTrue(plan.coverPx + gap + plan.columnPx + plan.buttonBlockPx <= w,
                            "width " + w + "x" + h);
                    assertTrue(plan.buttonRows * plan.buttonRowPx <= h, "buttons " + w + "x" + h);
                    assertTrue(plan.rows() * (plan.rowPx + plan.gapPx) <= h, "rows " + w + "x" + h);
                    assertTrue(plan.buttonSidePx <= plan.cellWidthPx && plan.buttonSidePx <= plan.buttonRowPx);
                }
            }
        }
    }

    // 'Large text' of the widget bar.

    @Test
    void largeTextIsNeverSmallerThanTheUsualTextInTheUsualBar() {
        for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBar(359, h, 1f, false, oneLine);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBar(359, h, 1f, true, oneLine);
                assertTrue(large.textPx >= usual.textPx, "text " + h);
                assertTrue(large.rowPx >= usual.rowPx, "row " + h);
            }
        }
    }

    @Test
    void largeTextIsNeverSmallerThanTheUsualTextInTheWideBar() {
        for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBarWide(359, h, 1f, false, oneLine);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBarWide(359, h, 1f, true, oneLine);
                assertTrue(large.textPx >= usual.textPx, "text " + h);
                // the block of buttons keeps its width
                assertEquals(usual.buttonBlockPx, large.buttonBlockPx);
                assertEquals(usual.buttonRows, large.buttonRows);
            }
        }
    }

    @Test
    void largeTextKeepsTheButtonsAsBigAsTheirRowAllows() {
        for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBar(359, h, 1f, false, oneLine);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBar(359, h, 1f, true, oneLine);
                assertTrue(large.buttonSidePx >= Math.min(usual.buttonSidePx, large.buttonRowPx), "buttons " + h);
                assertTrue(large.buttonSidePx <= large.buttonRowPx + 1, "row " + h);
            }
        }
    }

    @Test
    void theSharesOfTheLargePlansAddUpToNoMoreThanTheHeight() {
        float standard = 0f;
        for (float share : MusicWidgetPlan.BAR_STANDARD_LARGE) standard += share;
        float compact = 0f;
        for (float share : MusicWidgetPlan.BAR_COMPACT_LARGE) compact += share;
        float wide = 0f;
        for (float share : MusicWidgetPlan.BAR_WIDE_STANDARD_LARGE) wide += share;
        float wideCompact = 0f;
        for (float share : MusicWidgetPlan.BAR_WIDE_COMPACT_LARGE) wideCompact += share;
        assertTrue(standard <= 1.0001f);
        assertTrue(compact <= 1.0001f);
        assertTrue(wide <= 1.0001f);
        assertTrue(wideCompact <= 1.0001f);
        for (int h : new int[]{40, 66, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBar(359, h, 1f, true, oneLine);
                assertTrue(plan.rows() * (plan.rowPx + plan.gapPx) + plan.buttonRowPx <= h, "bar " + h);
                MusicWidgetPlan.Plan wideLarge = MusicWidgetPlan.planBarWide(359, h, 1f, true, oneLine);
                assertTrue(wideLarge.rows() * (wideLarge.rowPx + wideLarge.gapPx) <= h, "wide " + h);
            }
        }
    }
}
