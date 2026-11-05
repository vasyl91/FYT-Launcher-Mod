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
            assertFalse(MusicWidgetPlan.planBar(400, h, 400, 1f, false, false).compact, "two lines " + h);
            assertTrue(MusicWidgetPlan.planBar(400, h, 400, 1f, false, true).compact, "one line " + h);
            assertFalse(MusicWidgetPlan.planBarWide(400, h, 400, 1f, false, false, false).compact, "wide two lines " + h);
            assertTrue(MusicWidgetPlan.planBarWide(400, h, 400, 1f, false, true, false).compact, "wide one line " + h);
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
        assertTrue(MusicWidgetPlan.planBar(400, 72, 400, 1f, false, true).buttonSidePx > 0);
        assertTrue(MusicWidgetPlan.planBar(400, 91, 400, 1f, false, false).buttonSidePx > 0);
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
                    MusicWidgetPlan.Plan bar = MusicWidgetPlan.planBar(w, h, w, 1f, false, oneLine);
                    int barSum = bar.rows() * (bar.rowTopPx + bar.rowPx) + bar.buttonsTopPx + bar.buttonsHeightPx
                            + bar.buttonsBottomPx;
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
    void theTextGetsSixtyFiveAndTheButtonsThirtyFivePercentOfWhatIsLeftOfTheCover() {
        for (int w : new int[] {200, 359, 400, 560, 800}) {
            for (int h : new int[] {40, 66, 91, 120}) {
                for (boolean oneLine : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(w, h, w, 1f, false, oneLine, false);
                    assertTrue(plan.wide);
                    int rest = w - plan.coverPx - plan.coverGapPx;
                    assertEquals(rest, plan.restPx);
                    assertEquals(rest * 0.35f, plan.buttonBlockPx, 2f, "buttons " + w + "x" + h);
                    assertEquals(rest * 0.65f, plan.columnPx, 2.01f, "text " + w + "x" + h);
                    assertEquals(rest, plan.columnPx + plan.buttonBlockPx);
                }
            }
        }
    }

    @Test
    void theButtonsAreAlwaysInTwoRowsOfTwo() {
        for (int h : new int[] {40, 54, 66, 72, 73, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                for (boolean large : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(359, h, 250, 1f, large, oneLine, false);
                    assertEquals(2, plan.buttonRows, "rows " + h);
                    assertEquals(h / 2, plan.buttonRowPx);
                    assertEquals(plan.buttonBlockPx / 2, plan.cellWidthPx);
                    assertEquals(Math.round(Math.min(plan.cellWidthPx, plan.buttonRowPx) * MusicWidgetPlan.BUTTON_FILL),
                            plan.buttonSidePx);
                }
            }
        }
    }

    @Test
    void theCoverAndItsGapAreTheSameWhateverTheSettingsHide() {
        // W0 is the width with nothing hidden; hiding the date and the weather widens the widget to W
        int w0 = 359;
        for (int h : new int[] {40, 66, 91, 120}) {
            MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBar(w0, h, w0, 1f, false, false);
            for (int w : new int[] {w0, 430, 520, 650}) {
                for (boolean oneLine : new boolean[] {false, true}) {
                    for (boolean large : new boolean[] {false, true}) {
                        MusicWidgetPlan.Plan below = MusicWidgetPlan.planBar(w, h, w0, 1f, large, oneLine);
                        MusicWidgetPlan.Plan beside = MusicWidgetPlan.planBarWide(w, h, w0, 1f, large, oneLine, false);
                        String where = w + "x" + h + " large=" + large + " oneLine=" + oneLine;
                        assertEquals(usual.coverPx, below.coverPx, "cover below " + where);
                        assertEquals(usual.coverPx, beside.coverPx, "cover beside " + where);
                        assertEquals(usual.coverGapPx, below.coverGapPx, "gap below " + where);
                        assertEquals(usual.coverGapPx, beside.coverGapPx, "gap beside " + where);
                    }
                }
            }
        }
    }

    @Test
    void theUsualLayoutWithNothingHiddenIsTheTodaysPlan() {
        // W = W0: the column is what is left of the cover and a 3% gap, as before the rule changes
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBar(359, 66, 359, 1f, false, false);
        assertEquals(Math.min((int) (66 * 0.86f), (int) (359 * 0.25f)), plan.coverPx);
        assertEquals(359 - plan.coverPx - (int) (359 * 0.03f), plan.columnPx);
        assertEquals(16, plan.rowPx);   // 0.25 of 66
        assertEquals(16f / 1.3f, plan.textPx, 0.01f);
        assertEquals(plan.gapPx, plan.rowTopPx);
    }

    @Test
    void theUsualLayoutGetsTheWholeWidenedWidth() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBar(500, 66, 359, 1f, false, false);
        assertEquals(500 - plan.coverPx - plan.coverGapPx, plan.columnPx);
        assertEquals(Math.round(Math.min(plan.buttonRowPx, plan.columnPx / 4f) * MusicWidgetPlan.BUTTON_FILL),
                plan.buttonSidePx);
    }

    @Test
    void theUsualWidthIsWorkedOutFromTheSharesOfTheBar() {
        // landscape, the date and the weather hidden: 0.45 of the bar instead of 0.28
        assertEquals(359, MusicWidgetPlan.usualWidth(577, WidgetBarPlan.baseShare(false),
                WidgetBarPlan.musicShare(false, true, true)), 1);
        // nothing hidden: the width itself
        assertEquals(359, MusicWidgetPlan.usualWidth(359, WidgetBarPlan.baseShare(false),
                WidgetBarPlan.musicShare(false, false, false)));
        assertEquals(400, MusicWidgetPlan.usualWidth(400, 0f, 0.5f));
    }

    @Test
    void thePartsOfTheWideBarFitTheWidgetInBothDirections() {
        for (int w : new int[]{200, 359, 400, 560, 800}) {
            for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
                for (boolean oneLine : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(w, h, w, 1f, false, oneLine, false);
                    assertTrue(plan.coverPx + plan.coverGapPx + plan.columnPx + plan.buttonBlockPx <= w,
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
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBar(359, h, 359, 1f, false, oneLine);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBar(359, h, 359, 1f, true, oneLine);
                assertTrue(large.textPx >= usual.textPx, "text " + h);
                assertTrue(large.rowPx >= usual.rowPx, "row " + h);
            }
        }
    }

    @Test
    void largeTextIsNeverSmallerThanTheUsualTextInTheWideBar() {
        for (int h : new int[]{40, 54, 66, 72, 73, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBarWide(359, h, 359, 1f, false, oneLine, false);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBarWide(359, h, 359, 1f, true, oneLine, false);
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
                MusicWidgetPlan.Plan usual = MusicWidgetPlan.planBar(359, h, 359, 1f, false, oneLine);
                MusicWidgetPlan.Plan large = MusicWidgetPlan.planBar(359, h, 359, 1f, true, oneLine);
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
        assertTrue(standard <= 1.0001f);
        assertTrue(compact <= 1.0001f);
        assertTrue(wide <= 1.0001f);
        for (int h : new int[]{40, 66, 91, 120}) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBar(359, h, 359, 1f, true, oneLine);
                assertTrue(plan.rows() * (plan.rowTopPx + plan.rowPx) + plan.buttonsTopPx + plan.buttonsHeightPx
                        + plan.buttonsBottomPx <= h, "bar " + h);
                MusicWidgetPlan.Plan wideLarge = MusicWidgetPlan.planBarWide(359, h, 359, 1f, true, oneLine, false);
                assertTrue(wideLarge.rows() * (wideLarge.rowPx + wideLarge.gapPx) <= h, "wide " + h);
            }
        }
    }

    // One line: centred, and sized from the box of the font.

    @Test
    void theOneLineHasNoMarginOnTopAndTheWholeRoomAboveTheButtons() {
        for (int h : new int[] {40, 66, 91, 120}) {
            for (boolean large : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan beside = MusicWidgetPlan.planBarWide(359, h, 359, 1f, large, true, false);
                assertEquals(0, beside.rowTopPx, "beside top " + h);
                assertEquals(h, beside.rowPx, "beside row " + h);
                MusicWidgetPlan.Plan below = MusicWidgetPlan.planBar(359, h, 359, 1f, large, true);
                assertEquals(0, below.rowTopPx, "below top " + h);
                // the text row, the row of buttons and the room left under them are the whole height
                assertEquals(h, below.rowPx + below.buttonsHeightPx + below.buttonsBottomPx, "below " + h);
                assertEquals(below.yButtonsPx, below.rowPx, "text row ends at the buttons " + h);
            }
        }
    }

    @Test
    void twoLinesKeepTheirMarginsAndHeights() {
        MusicWidgetPlan.Plan beside = MusicWidgetPlan.planBarWide(359, 66, 359, 1f, false, false, false);
        assertEquals(beside.gapPx, beside.rowTopPx);
        assertEquals((int) (66 * MusicWidgetPlan.BAR_WIDE_STANDARD[0]), beside.rowPx);
        MusicWidgetPlan.Plan large = MusicWidgetPlan.planBarWide(359, 66, 359, 1f, true, false, false);
        assertEquals((int) (66 * MusicWidgetPlan.BAR_WIDE_STANDARD_LARGE[0]), large.rowPx);
        assertEquals(large.gapPx, large.rowTopPx);
    }

    @Test
    void theBoxOfTheLargeOneLineIsBiggerThanTheUsualAndNeverBiggerThanTheRow() {
        for (int h : new int[] {40, 66, 91, 120}) {
            for (boolean beside : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan usual = beside
                        ? MusicWidgetPlan.planBarWide(359, h, 359, 1f, false, true, false)
                        : MusicWidgetPlan.planBar(359, h, 359, 1f, false, true);
                MusicWidgetPlan.Plan large = beside
                        ? MusicWidgetPlan.planBarWide(359, h, 359, 1f, true, true, false)
                        : MusicWidgetPlan.planBar(359, h, 359, 1f, true, true);
                assertTrue(large.fontBoxPx > usual.fontBoxPx, "box " + h + " beside=" + beside);
                assertTrue(large.fontBoxPx <= large.rowPx, "box in row " + h);
                assertTrue(usual.fontBoxPx <= usual.rowPx);
                assertEquals(MusicWidgetPlan.ONE_LINE_BOX * usual.rowPx, usual.fontBoxPx, 0.01f);
                assertEquals(MusicWidgetPlan.ONE_LINE_BOX_LARGE * large.rowPx, large.fontBoxPx, 0.01f);
                assertTrue(large.textPx > usual.textPx, "text " + h + " beside=" + beside);
            }
        }
    }

    @Test
    void theOneLineIsSizedFromTheMetricsOfTheFont() {
        MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(359, 66, 359, 1f, true, true, false);
        // a font whose box is 1.4 times its size gets a smaller size than one with 1.0
        float tall = plan.withFont(new MusicWidgetPlan.FontShape(1.4f, 0.7f, 1.1f), 1f).textPx;
        float flat = plan.withFont(new MusicWidgetPlan.FontShape(1.0f, 0.7f, 0.8f), 1f).textPx;
        assertEquals(plan.fontBoxPx / 1.4f, tall, 0.01f);
        assertEquals(plan.fontBoxPx / 1.0f, flat, 0.01f);
        assertTrue(flat > tall);
        // the box of the text fills the box it was given
        assertEquals(plan.fontBoxPx, flat * 1.0f, 0.01f);
        // two lines keep their size whatever the metrics say
        MusicWidgetPlan.Plan two = MusicWidgetPlan.planBarWide(359, 66, 359, 1f, false, false, false);
        float before = two.textPx;
        assertEquals(before, two.withFont(new MusicWidgetPlan.FontShape(1.4f, 0.7f, 1.1f), 1f).textPx, 0f);
        // never under the floor
        assertEquals(MusicWidgetPlan.MIN_TEXT_SP_FLOOR * 2f, MusicWidgetPlan.textForBox(1f, 1.2f, 2f), 0f);
    }

    @Test
    void theOneLineIsCentredInItsRoom() {
        // the room is the row's own height, so the free space above and below the line is equal
        for (int h : new int[] {40, 66, 91, 120}) {
            MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(359, h, 359, 1f, false, true, false);
            int free = plan.rowPx - Math.round(plan.fontBoxPx);
            int above = plan.rowTopPx + free / 2;
            int below = h - above - Math.round(plan.fontBoxPx);
            assertEquals(above, below, 1, "centred " + h);
        }
    }

    @Test
    void theBlockIsWholeCellsWideSoTheFlexboxNeverWrapsToOneButtonPerRow() {
        for (int w = 150; w < 900; w++) {
            for (boolean oneLine : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(w, 66, w * 28 / 45, 1f, false, oneLine, false);
                assertEquals(2 * plan.cellWidthPx, plan.buttonBlockPx, "block " + w);
                assertEquals(plan.restPx, plan.columnPx + plan.buttonBlockPx, "rest " + w);
            }
        }
    }

    // 'Buttons in one line': one row of four, 40% of what is left, the text 60%.

    @Test
    void buttonsInOneRowTakeFortyPercentAndTheTextSixty() {
        for (int w : new int[] {200, 359, 400, 560, 800}) {
            for (int h : new int[] {40, 66, 91, 120}) {
                for (boolean oneLine : new boolean[] {false, true}) {
                    MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(w, h, w, 1f, false, oneLine, true);
                    int rest = plan.restPx;
                    assertEquals(1, plan.buttonRows);
                    assertEquals(rest * 0.40f, plan.buttonBlockPx, 4f, "buttons " + w + "x" + h);
                    assertEquals(rest * 0.60f, plan.columnPx, 4.01f, "text " + w + "x" + h);
                    assertEquals(4 * plan.cellWidthPx, plan.buttonBlockPx);
                    assertEquals(rest, plan.columnPx + plan.buttonBlockPx);
                    assertEquals(h, plan.buttonRowPx);
                    assertEquals(Math.round(Math.min(plan.cellWidthPx, h) * MusicWidgetPlan.BUTTON_FILL),
                            plan.buttonSidePx);
                }
            }
        }
    }

    @Test
    void buttonsInOneRowKeepTheCoverAndTheTextHeights() {
        MusicWidgetPlan.Plan two = MusicWidgetPlan.planBarWide(359, 66, 223, 1f, false, false, false);
        MusicWidgetPlan.Plan row = MusicWidgetPlan.planBarWide(359, 66, 223, 1f, false, false, true);
        assertEquals(two.coverPx, row.coverPx);
        assertEquals(two.coverGapPx, row.coverGapPx);
        assertEquals(two.rowPx, row.rowPx);
        assertEquals(two.textPx, row.textPx, 0f);
        assertTrue(row.columnPx > two.columnPx - 1 - two.restPx * 0.06f && row.columnPx < two.columnPx);
    }

    // One line in the usual layout: centred between the top and the visible buttons, by the letters.

    @Test
    void theVisibleButtonsStayWhereTheyWere() {
        for (int h : new int[] {40, 66, 91, 110, 120}) {
            for (boolean large : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan one = MusicWidgetPlan.planBar(359, h, 359, 1f, large, true);
                // their row ended at h and they stood in its middle: the top edge is the same
                int topBefore = h - (one.buttonRowPx + one.buttonSidePx) / 2;
                assertEquals(topBefore, one.yButtonsPx, 1, "top " + h + " large=" + large);
                assertEquals(one.buttonSidePx, one.buttonsHeightPx);
                assertEquals(0, one.buttonsTopPx);
                assertEquals(h, one.rowPx + one.buttonsHeightPx + one.buttonsBottomPx);
                // the font box is taken from the new, taller, row
                assertEquals((large ? MusicWidgetPlan.ONE_LINE_BOX_LARGE : MusicWidgetPlan.ONE_LINE_BOX)
                        * one.rowPx, one.fontBoxPx, 0.01f);
            }
        }
    }

    @Test
    void theLettersAreAsFarFromTheTopAsFromTheButtons() {
        MusicWidgetPlan.FontShape font = MusicWidgetPlan.DEFAULT_FONT;
        for (int h : new int[] {66, 110}) {
            for (boolean large : new boolean[] {false, true}) {
                MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBar(359, h, 359, 1f, large, true)
                        .withFont(font, 1f);
                float capH = font.capRatio * plan.textPx;
                float baseline = plan.textTopPaddingPx + font.ascentRatio * plan.textPx;
                float aboveCaps = baseline - capH;
                float belowBaseline = plan.yButtonsPx - baseline;
                assertEquals(aboveCaps, belowBaseline, 1f, "gaps " + h + " large=" + large);
                assertEquals(aboveCaps, plan.capTopPx, 1f, "capTop " + h + " large=" + large);
                assertTrue(aboveCaps > 0, "room " + h);
            }
        }
    }

    @Test
    void theLettersOfTheLineBesideTheButtonsAreCentredToo() {
        MusicWidgetPlan.FontShape font = MusicWidgetPlan.DEFAULT_FONT;
        for (int h : new int[] {66, 110}) {
            MusicWidgetPlan.Plan plan = MusicWidgetPlan.planBarWide(359, h, 359, 1f, false, true, false)
                    .withFont(font, 1f);
            float baseline = plan.textTopPaddingPx + font.ascentRatio * plan.textPx;
            assertEquals(baseline - font.capRatio * plan.textPx, plan.rowPx - baseline, 1f, "beside " + h);
        }
    }

    @Test
    void theTopPaddingPutsTheBaselineBelowTheMiddleByHalfTheCapitals() {
        // a row of 40, capitals of 20, ascent 30: the baseline is at 30, so no padding is needed
        assertEquals(0, MusicWidgetPlan.oneLineTopPadding(40f, 20f, 30f));
        // a row of 100, capitals of 40, ascent 50: baseline 70, padding 20
        assertEquals(20, MusicWidgetPlan.oneLineTopPadding(100f, 40f, 50f));
        // never negative
        assertEquals(0, MusicWidgetPlan.oneLineTopPadding(40f, 10f, 60f));
    }

    @Test
    void twoLinesInTheUsualLayoutKeepTheButtonsRow() {
        MusicWidgetPlan.Plan two = MusicWidgetPlan.planBar(359, 66, 359, 1f, false, false);
        assertEquals(two.gapPx, two.buttonsTopPx);
        assertEquals(two.buttonRowPx, two.buttonsHeightPx);
        assertEquals(0, two.buttonsBottomPx);
    }
}
