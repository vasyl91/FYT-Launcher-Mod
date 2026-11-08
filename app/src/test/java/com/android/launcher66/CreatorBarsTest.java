package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CreatorBarsTest {

    // box 1280 x 640, bar 100, vertical bar 91; the strip of the handle is 1 % of the longer edge: 13 px
    private static CreatorBars bars(boolean top, boolean verticalRight, boolean handleRight, boolean verticalOnPage,
                                    boolean horizontalOnPage, boolean autoHide) {
        return CreatorBars.of(new BarLayout(1280, 640, 100, 91, top, verticalRight, handleRight, verticalOnPage,
                horizontalOnPage, autoHide), autoHide);
    }

    @Test
    void theButtonIsOnlyWhereTheSidesAgreeAndTheBarCollapses() {
        for (boolean top : new boolean[] {false, true}) {
            for (boolean right : new boolean[] {false, true}) {
                CreatorBars agree = bars(top, right, right, true, true, true);
                assertNotNull(agree.button);
                assertNull(agree.handle);
                assertEquals(right ? 180f : 0f, agree.arrowRotation);
                int left = right ? 1280 - 91 : 0;
                assertArrayEquals(new int[] {left, top ? 0 : 540, left + 91, top ? 100 : 640}, agree.button);
                // the vertical bar ends at the button
                assertFalse(agree.verticalFullHeight);
                assertArrayEquals(new int[] {left, top ? 100 : 0, left + 91, top ? 640 : 540}, agree.verticalBand);

                CreatorBars apart = bars(top, right, !right, true, true, true);
                assertNull(apart.button);
                assertNotNull(apart.handle);
                assertTrue(apart.verticalFullHeight);
                assertArrayEquals(new int[] {left, 0, left + 91, 640}, apart.verticalBand);
            }
        }
    }

    @Test
    void theHandleIsOnItsSideInTheBarsBand() {
        for (boolean top : new boolean[] {false, true}) {
            for (boolean handleRight : new boolean[] {false, true}) {
                CreatorBars b = bars(top, false, handleRight, false, true, true);
                assertNull(b.button);
                int left = handleRight ? 1280 - 13 : 0;
                assertArrayEquals(new int[] {left, top ? 0 : 540, left + 13, top ? 100 : 640}, b.handle);
                assertEquals(handleRight, b.handleRight);
            }
        }
    }

    @Test
    void withoutAutoHideThereIsNeitherButtonNorHandle() {
        for (boolean right : new boolean[] {false, true}) {
            CreatorBars b = bars(false, right, !right, true, true, false);
            assertNull(b.button);
            assertNull(b.handle);
            assertFalse(b.collapsible);
            assertTrue(b.horizontalBand);
            // the bar is there: the vertical bar ends at it
            assertFalse(b.verticalFullHeight);
        }
    }

    @Test
    void aPageWithoutTheHorizontalBarHasNoBandNoButtonAndNoHandle() {
        // the horizontal bar is only on the first page: the other pages
        for (boolean autoHide : new boolean[] {false, true}) {
            CreatorBars b = bars(false, true, true, true, false, autoHide);
            assertFalse(b.horizontalBand);
            assertNull(b.button);
            assertNull(b.handle);
            assertArrayEquals(new int[] {0, 0, 0, 0}, b.horizontalBandRect);
            assertArrayEquals(new int[] {1189, 0, 1280, 640}, b.verticalBand);
        }
    }

    @Test
    void theHorizontalBandIsAtTheTopOrAtTheBottom() {
        assertArrayEquals(new int[] {0, 540, 1280, 640}, bars(false, false, false, false, true, false).horizontalBandRect);
        assertArrayEquals(new int[] {0, 0, 1280, 100}, bars(true, false, false, false, true, false).horizontalBandRect);
        assertTrue(bars(true, false, false, false, true, true).collapsible);
    }

    @Test
    void withoutTheVerticalBarThereIsNoBandAndTheHandleStandsForTheBar() {
        CreatorBars b = bars(false, false, true, false, true, true);
        assertArrayEquals(new int[] {0, 0, 0, 0}, b.verticalBand);
        assertNull(b.button);
        assertNotNull(b.handle);
    }
}
