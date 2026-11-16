package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PageFitTest {

    // The A55 in portrait, a page without bars: 10 rows of 211 px, the grid's bottom at 2110, the padding of the
    // first row 18 px (Launcher.workspaceTopPadding)
    private static final int CELL = 211;
    private static final int BOTTOM = 10 * CELL;

    @Test
    void anElementInsideTheBoxStaysWhereItIs() {
        // the A55's page box 1080x2116; the music element of the log of 13:30
        assertArrayEquals(new int[] {485, 1458, 448, 483}, PageFit.intoBox(485, 1458, 448, 483, 1080, 2116));
    }

    @Test
    void anElementBelowTheBoxIsMovedUpKeepingItsSize() {
        // saved while the box was taken for the screen without the status bar (2251 px): 135 px too low
        assertArrayEquals(new int[] {145, 1716, 930, 400}, PageFit.intoBox(145, 1851, 930, 400, 1080, 2116));
        // past the right edge, above the top
        assertArrayEquals(new int[] {580, 0, 500, 300}, PageFit.intoBox(700, -20, 500, 300, 1080, 2116));
    }

    @Test
    void onlyAnElementLargerThanTheBoxIsMadeSmaller() {
        assertArrayEquals(new int[] {0, 0, 1080, 2116}, PageFit.intoBox(-10, 5, 1200, 2300, 1080, 2116));
    }

    @Test
    void anItemIsInTheGridOnlyWithAllItsCells() {
        // a page of 6 by 10 cells
        assertTrue(PageFit.inGrid(0, 0, 1, 1, 6, 10));
        assertTrue(PageFit.inGrid(2, 6, 4, 4, 6, 10));
        // the top left cell inside, the rest not: what CellLayout.addViewToCellLayout() let through
        assertFalse(PageFit.inGrid(2, 7, 4, 4, 6, 10));
        assertFalse(PageFit.inGrid(3, 0, 4, 1, 6, 10));
        assertFalse(PageFit.inGrid(-1, 0, 1, 1, 6, 10));
        assertFalse(PageFit.inGrid(0, 0, 0, 1, 6, 10));
    }

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
