package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StatsBarFitTest {

    // the box 1280 x 640, margin 5, the window 270 x 60
    private static final int[] WINDOW = {500, 300, 770, 360};

    private static int[] room(int left, int top, int right, int bottom) {
        return new int[] {left, top, right, bottom};
    }

    private static void assertSize(int[] before, int[] after) {
        assertEquals(before[2] - before[0], after[2] - after[0]);
        assertEquals(before[3] - before[1], after[3] - after[1]);
    }

    @Test
    void aWindowBesideTheBarsStaysWhereItIs() {
        assertArrayEquals(WINDOW, StatsBarFit.move(WINDOW, room(5, 5, 1275, 635)));
        // with every bar on: the bar at the top, at the bottom is not asked here, the vertical bar at both sides
        assertArrayEquals(WINDOW, StatsBarFit.move(WINDOW, room(5, 106, 1184, 535)));
    }

    @Test
    void theBarAtTheTopMovesItDown() {
        int[] user = {500, 20, 770, 80};
        int[] moved = StatsBarFit.move(user, room(5, 106, 1275, 635));
        assertArrayEquals(new int[] {500, 106, 770, 166}, moved);
        assertSize(user, moved);
    }

    @Test
    void theBarAtTheBottomMovesItUp() {
        int[] user = {500, 600, 770, 660};
        int[] moved = StatsBarFit.move(user, room(5, 5, 1275, 535));
        assertArrayEquals(new int[] {500, 475, 770, 535}, moved);
        assertSize(user, moved);
    }

    @Test
    void theVerticalBarOnTheLeftAndOnTheRightMovesItSideways() {
        int[] left = {5, 300, 275, 360};
        // the room starts after the bar on the left (the rectangles are in the box without it: x = 0 is its inner edge)
        assertArrayEquals(new int[] {20, 300, 290, 360}, StatsBarFit.move(left, room(20, 5, 1184, 635)));
        int[] right = {1000, 300, 1270, 360};
        assertArrayEquals(new int[] {914, 300, 1184, 360}, StatsBarFit.move(right, room(5, 5, 1184, 635)));
    }

    @Test
    void allTheBarsTogetherMoveItInBothAxes() {
        int[] user = {1100, 560, 1370, 620};
        int[] moved = StatsBarFit.move(user, room(5, 106, 1184, 535));
        assertArrayEquals(new int[] {914, 475, 1184, 535}, moved);
        assertSize(user, moved);
    }

    @Test
    void aWindowLargerThanTheRoomStandsAtTheInnerEdgeAndKeepsItsSize() {
        int[] wide = {10, 300, 1280, 360};
        int[] moved = StatsBarFit.move(wide, room(20, 5, 1184, 635));
        assertEquals(20, moved[0]);
        assertSize(wide, moved);
        assertTrue(StatsBarFit.largerThanRoom(wide, room(20, 5, 1184, 635)));
        int[] tall = {500, 10, 770, 700};
        int[] movedTall = StatsBarFit.move(tall, room(5, 106, 1275, 635));
        assertEquals(106, movedTall[1]);
        assertSize(tall, movedTall);
        assertTrue(StatsBarFit.largerThanRoom(tall, room(5, 106, 1275, 635)));
        assertFalse(StatsBarFit.largerThanRoom(WINDOW, room(5, 5, 1275, 635)));
    }

    @Test
    void movingBackWhenTheBarsGoIsTheSameAsMovingTheUsersRectangle() {
        // the user's rectangle is what is fitted every time, so a window pushed away by a bar returns to it
        int[] user = {500, 20, 770, 80};
        int[] withBar = StatsBarFit.move(user, room(5, 106, 1275, 635));
        int[] withoutBar = StatsBarFit.move(user, room(5, 5, 1275, 635));
        assertArrayEquals(user, withoutBar);
        assertEquals(106, withBar[1]);
    }
}
