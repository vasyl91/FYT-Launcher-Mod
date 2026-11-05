package com.android.launcher66;

import static com.android.launcher66.BottomBarPlacement.Bar.BUTTON;
import static com.android.launcher66.BottomBarPlacement.Bar.EMBEDDED;
import static com.android.launcher66.BottomBarPlacement.Bar.HANDLE;
import static com.android.launcher66.BottomBarPlacement.Bar.NONE;
import static com.android.launcher66.BottomBarPlacement.Bar.PERSISTENT_OVERLAY;
import static com.android.launcher66.BottomBarPlacement.Reserve.CELL;
import static com.android.launcher66.BottomBarPlacement.Reserve.ROW;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BottomBarPlacementTest {

    private static BottomBarPlacement.Bar bar(int page, boolean every, boolean autoHide, boolean left,
                                              boolean moving) {
        return BottomBarPlacement.bar(page, every, autoHide, left, moving, true);
    }

    @Test
    void withTheOptionOffTheBarIsOnTheFirstPageOnly() {
        assertEquals(EMBEDDED, bar(0, false, false, false, false));
        assertEquals(EMBEDDED, bar(0, false, false, true, false));
        assertEquals(NONE, bar(1, false, false, false, false));
        assertEquals(NONE, bar(3, false, false, true, false));
        // the page moves and takes its own bar along
        assertEquals(EMBEDDED, bar(0, false, false, false, true));
    }

    @Test
    void withTheOptionOffAutoHideHasTheHandleOrTheButtonOnTheFirstPageOnly() {
        assertEquals(HANDLE, bar(0, false, true, false, false));
        assertEquals(BUTTON, bar(0, false, true, true, false));
        assertEquals(NONE, bar(1, false, true, false, false));
        assertEquals(NONE, bar(1, false, true, true, false));
        assertEquals(NONE, bar(0, false, true, false, true));
    }

    @Test
    void withTheOptionOffTheReservationIsTheFirstPagesOnly() {
        assertEquals(ROW, BottomBarPlacement.reserve(0, false, false, true));
        assertEquals(BottomBarPlacement.Reserve.NONE, BottomBarPlacement.reserve(1, false, false, true));
        assertEquals(CELL, BottomBarPlacement.reserve(0, false, true, true));
        assertEquals(BottomBarPlacement.Reserve.NONE, BottomBarPlacement.reserve(2, false, true, true));
    }

    @Test
    void everyPageWithoutAutoHideKeepsTheFirstPagesOwnBarAtRest() {
        assertEquals(EMBEDDED, bar(0, true, false, false, false));
        assertEquals(EMBEDDED, bar(0, true, false, true, false));
    }

    @Test
    void everyPageWithoutAutoHideShowsTheOverlayAtOnceWhenThePagesMove() {
        assertEquals(PERSISTENT_OVERLAY, bar(0, true, false, false, true));
        assertEquals(PERSISTENT_OVERLAY, bar(0, true, false, true, true));
    }

    @Test
    void everyPageWithoutAutoHideKeepsTheOverlayOnTheOtherPagesAndWhileTheyMove() {
        assertEquals(PERSISTENT_OVERLAY, bar(1, true, false, false, false));
        assertEquals(PERSISTENT_OVERLAY, bar(2, true, false, true, false));
        assertEquals(PERSISTENT_OVERLAY, bar(1, true, false, false, true));
        assertEquals(PERSISTENT_OVERLAY, bar(2, true, false, false, true));
    }

    @Test
    void everyPageWithAutoHideHasTheHandleOnEveryPageAndTheButtonOnTheFirstWithTheLeftBar() {
        assertEquals(HANDLE, bar(0, true, true, false, false));
        assertEquals(BUTTON, bar(0, true, true, true, false));
        assertEquals(HANDLE, bar(1, true, true, false, false));
        assertEquals(HANDLE, bar(1, true, true, true, false));
        assertEquals(HANDLE, bar(4, true, true, true, false));
        assertEquals(NONE, bar(1, true, true, false, true));
    }

    @Test
    void everyPageTakesTheRowOrTheCellOnEveryPage() {
        for (int page = 0; page < 4; page++) {
            assertEquals(ROW, BottomBarPlacement.reserve(page, true, false, true));
            assertEquals(CELL, BottomBarPlacement.reserve(page, true, true, true));
        }
    }

    @Test
    void withoutTheUserLayoutTheOtherPagesHaveNoBarAndNoReservation() {
        // the switch was left on, but the persistent overlay and the handles exist only in the user layout
        assertEquals(NONE, BottomBarPlacement.bar(1, true, false, false, false, false));
        assertEquals(NONE, BottomBarPlacement.bar(2, true, true, false, false, false));
        assertEquals(NONE, BottomBarPlacement.bar(1, true, false, true, true, false));
        assertEquals(BottomBarPlacement.Reserve.NONE, BottomBarPlacement.reserve(1, true, false, false));
        assertEquals(BottomBarPlacement.Reserve.NONE, BottomBarPlacement.reserve(3, true, true, false));
    }

    @Test
    void withoutTheUserLayoutTheFirstPageIsAsToday() {
        assertEquals(EMBEDDED, BottomBarPlacement.bar(0, true, false, false, false, false));
        assertEquals(HANDLE, BottomBarPlacement.bar(0, true, true, false, false, false));
        assertEquals(BUTTON, BottomBarPlacement.bar(0, true, true, true, false, false));
        assertEquals(ROW, BottomBarPlacement.reserve(0, true, false, false));
        assertEquals(CELL, BottomBarPlacement.reserve(0, true, true, false));
    }
}
