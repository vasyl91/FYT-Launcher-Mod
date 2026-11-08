package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BarLayoutTest {

    // landscape box 1280 x 640, bar 100, vertical bar 91; portrait box 720 x 1200, bar 102, vertical bar 85
    private static BarLayout land(boolean top, boolean right, boolean vertical) {
        return new BarLayout(1280, 640, 100, 91, top, right, right, vertical);
    }

    private static BarLayout port(boolean top, boolean right, boolean vertical) {
        return new BarLayout(720, 1200, 102, 85, top, right, right, vertical);
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
        assertArrayEquals(new int[] {91, 0, 0, 100}, land(false, false, true).pageInsets(true, true));
        assertArrayEquals(new int[] {0, 0, 91, 100}, land(false, true, true).pageInsets(true, true));
        assertArrayEquals(new int[] {91, 100, 0, 0}, land(true, false, true).pageInsets(true, true));
        assertArrayEquals(new int[] {0, 100, 91, 0}, land(true, true, true).pageInsets(true, true));
        // the other pages: no vertical bar; the horizontal one only with the bar on every page
        assertArrayEquals(new int[] {0, 100, 0, 0}, land(true, true, true).pageInsets(false, true));
        assertArrayEquals(new int[] {0, 0, 0, 0}, land(true, true, true).pageInsets(false, false));
        assertArrayEquals(new int[] {0, 0, 0, 102}, port(false, false, true).pageInsets(false, true));
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
        BarLayout leftLeft = new BarLayout(1280, 640, 100, 91, false, false, false, true);
        BarLayout rightRight = new BarLayout(1280, 640, 100, 91, false, true, true, true);
        BarLayout barRightHandleLeft = new BarLayout(1280, 640, 100, 91, false, true, false, true);
        BarLayout barLeftHandleRight = new BarLayout(1280, 640, 100, 91, false, false, true, true);
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
        assertEquals(false, new BarLayout(1280, 640, 100, 91, false, false, false, false).buttonShown());
        // the corner at the top
        assertEquals(0, new BarLayout(1280, 640, 100, 91, true, true, false, true).cornerCellY(6));
    }
}
