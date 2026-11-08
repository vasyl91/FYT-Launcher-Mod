package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BarLayoutTest {

    // landscape box 1280 x 640, bar 100, vertical bar 91; portrait box 720 x 1200, bar 102, vertical bar 85
    private static BarLayout land(boolean top, boolean right, boolean vertical) {
        return new BarLayout(1280, 640, 100, 91, top, right, right, vertical, true);
    }

    private static BarLayout port(boolean top, boolean right, boolean vertical) {
        return new BarLayout(720, 1200, 102, 85, top, right, right, vertical, true);
    }

    @Test
    void horizontalBarBand() {
        assertEquals(540, land(false, false, true).horizontalBarTop());
        assertEquals(640, land(false, false, true).horizontalBarBottom());
        assertEquals(0, land(true, false, true).horizontalBarTop());
        assertEquals(100, land(true, true, true).horizontalBarBottom());
        assertEquals(1098, port(false, true, false).horizontalBarTop());
        assertEquals(102, port(true, false, false).horizontalBarBottom());
    }

    @Test
    void verticalBarBandIsBetweenTheHorizontalBarAndTheOtherEnd() {
        assertArrayEquals(new int[] {0, 0, 91, 540}, land(false, false, true).verticalBarBand());
        assertArrayEquals(new int[] {1189, 0, 1280, 540}, land(false, true, true).verticalBarBand());
        assertArrayEquals(new int[] {0, 100, 91, 640}, land(true, false, true).verticalBarBand());
        assertArrayEquals(new int[] {1189, 100, 1280, 640}, land(true, true, true).verticalBarBand());
        assertArrayEquals(new int[] {635, 102, 720, 1200}, port(true, true, true).verticalBarBand());
        assertArrayEquals(new int[] {0, 0, 0, 0}, land(true, true, false).verticalBarBand());
    }

    @Test
    void contentIsShiftedOnlyByAVerticalBarOnTheLeft() {
        assertEquals(91, land(false, false, true).contentOffsetX());
        assertEquals(91, land(true, false, true).contentOffsetX());
        assertEquals(0, land(false, true, true).contentOffsetX());
        assertEquals(0, land(true, true, true).contentOffsetX());
        assertEquals(0, land(false, false, false).contentOffsetX());
    }

    @Test
    void theWidthLeftToTheWidgetsIsTheSameOnBothSides() {
        assertEquals(1280 - 5 - 91, land(false, false, true).maxRight(5));
        assertEquals(1280 - 5 - 91, land(false, true, true).maxRight(5));
        assertEquals(720 - 5, port(false, true, false).maxRight(5));
    }

    @Test
    void theHeightLeftToTheWidgetsDependsOnTheBarsEdge() {
        assertEquals(540 - 5, land(false, false, true).maxBottom(5));
        assertEquals(0, land(false, false, true).minTop(5));
        assertEquals(100 + 5, land(true, false, true).minTop(5));
        assertEquals(640 - 5, land(true, false, true).maxBottom(5));
        // touching counts as overlap: at least a pixel
        assertEquals(539, land(false, false, true).maxBottom(0));
        assertEquals(101, land(true, true, true).minTop(0));
    }

    @Test
    void aRectangleIsMovedOutOfTheBand() {
        BarLayout bottom = land(false, false, true);
        assertEquals(540 - 120 - 5, bottom.fitY(500, 120, 5));
        assertEquals(300, bottom.fitY(300, 120, 5));
        BarLayout top = land(true, false, true);
        assertEquals(100 + 5, top.fitY(40, 120, 5));
        assertEquals(300, top.fitY(300, 120, 5));
    }

    @Test
    void pageInsets() {
        // the first page, the vertical bar on the left, the horizontal at the bottom
        assertArrayEquals(new int[] {91, 0, 0, 100}, land(false, false, true).pageInsets());
        assertArrayEquals(new int[] {0, 0, 91, 100}, land(false, true, true).pageInsets());
        assertArrayEquals(new int[] {91, 100, 0, 0}, land(true, false, true).pageInsets());
        assertArrayEquals(new int[] {0, 100, 91, 0}, land(true, true, true).pageInsets());
        // a page without the vertical bar: only the horizontal bar's inset
        assertArrayEquals(new int[] {0, 100, 0, 0}, page(true, true, false, true).pageInsets());
        assertArrayEquals(new int[] {0, 0, 0, 0}, page(true, true, false, false).pageInsets());
        assertArrayEquals(new int[] {0, 0, 0, 100}, page(false, false, false, true).pageInsets());
    }

    @Test
    void collapsedButtonAndTheCellsAreAtTheCorner() {
        assertArrayEquals(new int[] {0, 540, 91, 640}, land(false, false, true).collapsedButton());
        assertArrayEquals(new int[] {1189, 540, 1280, 640}, land(false, true, true).collapsedButton());
        assertArrayEquals(new int[] {0, 0, 91, 100}, land(true, false, true).collapsedButton());
        assertArrayEquals(new int[] {1189, 0, 1280, 100}, land(true, true, true).collapsedButton());
        assertEquals(5, land(false, false, true).reservedRow(6));
        assertEquals(0, land(true, false, true).reservedRow(6));
        assertEquals(0, land(false, false, true).cornerCellX(8));
        assertEquals(7, land(false, true, true).cornerCellX(8));
        assertEquals(5, land(false, true, true).cornerCellY(6));
        assertEquals(0, land(true, true, true).cornerCellY(6));
    }

    @Test
    void theCornerCellIsOnTheHandlesSideAndTheButtonOnlyWhenTheSidesAgree() {
        // vertical bar side x handle side
        BarLayout leftLeft = new BarLayout(1280, 640, 100, 91, false, false, false, true, true);
        BarLayout rightRight = new BarLayout(1280, 640, 100, 91, false, true, true, true, true);
        BarLayout barRightHandleLeft = new BarLayout(1280, 640, 100, 91, false, true, false, true, true);
        BarLayout barLeftHandleRight = new BarLayout(1280, 640, 100, 91, false, false, true, true, true);
        assertEquals(0, leftLeft.cornerCellX(8));
        assertEquals(7, rightRight.cornerCellX(8));
        // the handle is on the left: the left corner is reserved, the right one takes icons
        assertEquals(0, barRightHandleLeft.cornerCellX(8));
        assertEquals(7, barLeftHandleRight.cornerCellX(8));
        assertEquals(true, leftLeft.buttonShown());
        assertEquals(true, rightRight.buttonShown());
        assertEquals(false, barRightHandleLeft.buttonShown());
        assertEquals(false, barLeftHandleRight.buttonShown());
        // without the vertical bar there is never a button
        assertEquals(false, new BarLayout(1280, 640, 100, 91, false, false, false, false, true).buttonShown());
        // the corner at the top
        assertEquals(0, new BarLayout(1280, 640, 100, 91, true, true, false, true, true).cornerCellY(6));
    }

    private static BarLayout page(boolean top, boolean right, boolean verticalOnPage, boolean horizontalOnPage) {
        return new BarLayout(1280, 640, 100, 91, top, right, right, verticalOnPage, horizontalOnPage);
    }

    @Test
    void theVerticalBarHasTheWholeHeightOnAPageWithoutTheHorizontalBar() {
        // every combination of the two sides: the vertical bar on a page, the horizontal bar on it or not
        for (boolean top : new boolean[] {false, true}) {
            for (boolean right : new boolean[] {false, true}) {
                int left = right ? 1280 - 91 : 0;
                // with the horizontal bar: between it and the other end
                int[] with = page(top, right, true, true).verticalBarBand();
                assertArrayEquals(new int[] {left, top ? 100 : 0, left + 91, top ? 640 : 540}, with);
                // without it: the whole height
                assertArrayEquals(new int[] {left, 0, left + 91, 640}, page(top, right, true, false).verticalBarBand());
                // and nothing is taken from the widgets above or below
                assertEquals(0, page(top, right, true, false).minTop(5));
                assertEquals(640 - 5, page(top, right, true, false).maxBottom(5));
                assertEquals(300, page(top, right, true, false).fitY(300, 120, 5));
                assertArrayEquals(new int[] {0, 0, 0, 0}, page(top, right, true, false).collapsedButton());
                // without the vertical bar there is no band at all
                assertArrayEquals(new int[] {0, 0, 0, 0}, page(top, right, false, true).verticalBarBand());
                assertEquals(0, page(top, right, false, true).contentOffsetX());
                assertEquals(1280 - 5, page(top, right, false, true).maxRight(5));
            }
        }
    }

    @Test
    void theWindowOfTheVerticalBarTakesTheCornerOnlyWithTheButton() {
        assertArrayEquals(new int[] {0, 0, 91, 540}, page(false, false, true, true).verticalWindow(false));
        assertArrayEquals(new int[] {0, 0, 91, 640}, page(false, false, true, true).verticalWindow(true));
        assertArrayEquals(new int[] {1189, 100, 1280, 640}, page(true, true, true, true).verticalWindow(false));
        assertArrayEquals(new int[] {1189, 0, 1280, 640}, page(true, true, true, true).verticalWindow(true));
        // no horizontal bar on the page, no corner
        assertArrayEquals(new int[] {0, 0, 91, 640}, page(false, false, true, false).verticalWindow(true));
        assertArrayEquals(new int[] {0, 0, 0, 0}, page(false, false, false, true).verticalWindow(true));
    }
}
