package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TopBarFrameTest {

    @Test
    void portraitWithACutoutAtTheTopStartsBelowTheStatusBar() {
        // 1080 x 2400, the status bar and the camera cut-out take the top 96 px
        TopBarFrame.Overlay o = TopBarFrame.overlay(0, 96, 1080);
        assertEquals(96, o.y);
        assertEquals(0, o.x);
        assertEquals(1080, o.width);
        TopBarFrame.Handle h = TopBarFrame.handle(0, 96, 1080, 1080, false);
        assertEquals(96, h.y);
        assertEquals(0, h.x);
    }

    @Test
    void landscapeWithACutoutAtTheLeftStaysOutOfIt() {
        // the cut-out takes 120 px of the left side; the status bar 72 px
        TopBarFrame.Overlay o = TopBarFrame.overlay(120, 72, 2400);
        assertEquals(120, o.x);
        assertEquals(72, o.y);
        assertEquals(2280, o.width);
        TopBarFrame.Handle left = TopBarFrame.handle(120, 72, 2400, 2400, false);
        assertEquals(120, left.x);
        assertEquals(72, left.y);
    }

    @Test
    void theHandleOnTheRightCountsFromTheRightEdge() {
        // the cut-out takes 120 px of the right side
        TopBarFrame.Handle right = TopBarFrame.handle(0, 72, 2280, 2400, true);
        assertEquals(120, right.x);
        assertEquals(72, right.y);
        TopBarFrame.Handle noCutout = TopBarFrame.handle(0, 72, 2400, 2400, true);
        assertEquals(0, noCutout.x);
    }

    @Test
    void theHeadUnitInLandscapeHasTheStatusBarAndNoSideInset() {
        TopBarFrame.Overlay o = TopBarFrame.overlay(0, 48, 1920);
        assertEquals(0, o.x);
        assertEquals(48, o.y);
        assertEquals(1920, o.width);
        assertEquals(0, TopBarFrame.handle(0, 48, 1920, 1920, true).x);
        assertEquals(0, TopBarFrame.handle(0, 48, 1920, 1920, false).x);
    }

    @Test
    void anEmptyBoxGivesNoNegativeWidth() {
        assertEquals(0, TopBarFrame.overlay(500, 0, 400).width);
    }
}
