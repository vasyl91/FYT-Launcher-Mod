package com.android.launcher66;

import static com.android.launcher66.VerticalBarPlacement.Bar.EMBEDDED;
import static com.android.launcher66.VerticalBarPlacement.Bar.NONE;
import static com.android.launcher66.VerticalBarPlacement.Bar.PERSISTENT_OVERLAY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class VerticalBarPlacementTest {

    @Test
    void withTheOptionOffTheBarIsOnTheFirstPageOnly() {
        assertEquals(EMBEDDED, VerticalBarPlacement.bar(0, false, false, true));
        assertEquals(EMBEDDED, VerticalBarPlacement.bar(0, false, true, true));
        assertEquals(NONE, VerticalBarPlacement.bar(1, false, false, true));
        assertEquals(NONE, VerticalBarPlacement.bar(3, false, true, true));
    }

    @Test
    void everyPageKeepsTheFirstPagesOwnBarAtRest() {
        assertEquals(EMBEDDED, VerticalBarPlacement.bar(0, true, false, true));
    }

    @Test
    void everyPageShowsTheWindowOnTheOtherPagesAndAtOnceWhenAnyPageMoves() {
        assertEquals(PERSISTENT_OVERLAY, VerticalBarPlacement.bar(0, true, true, true));
        assertEquals(PERSISTENT_OVERLAY, VerticalBarPlacement.bar(1, true, false, true));
        assertEquals(PERSISTENT_OVERLAY, VerticalBarPlacement.bar(2, true, true, true));
    }

    @Test
    void withoutTheUserLayoutTheOtherPagesHaveNoBar() {
        assertEquals(NONE, VerticalBarPlacement.bar(1, true, false, false));
        assertEquals(EMBEDDED, VerticalBarPlacement.bar(0, true, true, false));
    }

    @Test
    void theBarIsOnAPageForTheGeometry() {
        assertTrue(VerticalBarPlacement.onPage(true, 0, false, true));
        assertFalse(VerticalBarPlacement.onPage(true, 1, false, true));
        assertTrue(VerticalBarPlacement.onPage(true, 1, true, true));
        assertTrue(VerticalBarPlacement.onPage(true, 5, true, true));
        // the option is lost without the user layout
        assertFalse(VerticalBarPlacement.onPage(true, 1, true, false));
        // no bar at all
        assertFalse(VerticalBarPlacement.onPage(false, 0, true, true));
        assertFalse(VerticalBarPlacement.onPage(false, 2, true, true));
    }
}
