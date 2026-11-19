package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BarIconCountTest {

    @Test
    void nothingChosenIsAsManyAsFit() {
        assertEquals(9, BarIconCount.shown(BarIconCount.UNSET, 9));
        assertEquals(BarIconCount.UNSET, BarIconCount.kept(BarIconCount.UNSET, 9));
    }

    @Test
    void aChosenNumberIsShownWithinTheRoom() {
        assertEquals(3, BarIconCount.shown(3, 9));
        assertEquals(1, BarIconCount.shown(1, 9));
        assertEquals(9, BarIconCount.shown(12, 9));
        assertEquals(1, BarIconCount.shown(5, 0));
    }

    @Test
    void aChosenNumberIsLoweredOnlyWhereTheRoomIsSmaller() {
        assertEquals(7, BarIconCount.kept(9, 7));   // a higher bar, a narrower one: lowered and stored
        assertEquals(5, BarIconCount.kept(5, 7));   // smaller: kept as chosen
        assertEquals(5, BarIconCount.kept(5, 12));  // more room later: not raised
    }

    @Test
    void eachBarAndOrientationHasItsOwnNumber() {
        assertEquals("horizontal_bar_icons_port", BarIconCount.key(true, true));
        assertEquals("horizontal_bar_icons_land", BarIconCount.key(true, false));
        assertEquals("vertical_bar_icons_port", BarIconCount.key(false, true));
        assertEquals("vertical_bar_icons_land", BarIconCount.key(false, false));
    }
}
