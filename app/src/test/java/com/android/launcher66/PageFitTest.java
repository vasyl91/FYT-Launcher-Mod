package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PageFitTest {

    // The A55 in portrait, a page without bars: 10 rows of 211 px, the grid's bottom at 2110, the padding of the
    // first row 18 px (Launcher.workspaceTopPadding)
    private static final int CELL = 211;
    private static final int BOTTOM = 10 * CELL;

    @Test
    void anItemThatEndsAboveTheBottomKeepsItsHeight() {
        // an icon in the first row: drawn 18 px lower, still far from the bottom
        assertEquals(CELL, PageFit.heightInGrid(18, CELL, 18, BOTTOM));
        // an item in the last row has no padding
        assertEquals(CELL, PageFit.heightInGrid(9 * CELL, CELL, 0, BOTTOM));
    }

    @Test
    void theFirstRowsPaddingNeverTakesAnItemPastTheGrid() {
        // a widget from the first row to the last: 18 px too low without the rule
        assertEquals(10 * CELL - 18, PageFit.heightInGrid(18, 10 * CELL, 18, BOTTOM));
        // from the second row (9 px) and the third (4 px)
        assertEquals(9 * CELL - 9, PageFit.heightInGrid(CELL + 9, 9 * CELL, 9, BOTTOM));
        assertEquals(8 * CELL - 4, PageFit.heightInGrid(2 * CELL + 4, 8 * CELL, 4, BOTTOM));
    }

    @Test
    void onlyWhatThePaddingAddedIsTakenOff() {
        // an item whose cells reach past the grid is left to the page's check, not shrunk out of sight
        assertEquals(10 * CELL - 18, PageFit.heightInGrid(CELL + 18, 10 * CELL, 18, BOTTOM));
        assertEquals(1, PageFit.heightInGrid(18, 10, 18, 0));
    }
}
