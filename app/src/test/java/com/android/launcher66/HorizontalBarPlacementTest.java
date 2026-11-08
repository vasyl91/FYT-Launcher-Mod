package com.android.launcher66;

import static com.android.launcher66.HorizontalBarPlacement.Bar.BUTTON;
import static com.android.launcher66.HorizontalBarPlacement.Bar.EMBEDDED;
import static com.android.launcher66.HorizontalBarPlacement.Bar.HANDLE;
import static com.android.launcher66.HorizontalBarPlacement.Bar.NONE;
import static com.android.launcher66.HorizontalBarPlacement.Bar.PERSISTENT_OVERLAY;
import static com.android.launcher66.HorizontalBarPlacement.Reserve.CELL;
import static com.android.launcher66.HorizontalBarPlacement.Reserve.ROW;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HorizontalBarPlacementTest {

    private static HorizontalBarPlacement.Bar bar(int page, boolean every, boolean autoHide, boolean left,
                                              boolean moving) {
        return HorizontalBarPlacement.bar(page, every, autoHide, left && page == 0, true, moving, true);
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
        assertEquals(ROW, HorizontalBarPlacement.reserve(0, false, false, true));
        assertEquals(HorizontalBarPlacement.Reserve.NONE, HorizontalBarPlacement.reserve(1, false, false, true));
        assertEquals(CELL, HorizontalBarPlacement.reserve(0, false, true, true));
        assertEquals(HorizontalBarPlacement.Reserve.NONE, HorizontalBarPlacement.reserve(2, false, true, true));
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
    void everyPageWithAutoHideHasTheHandleOnEveryPageAndTheButtonOnTheFirstWithTheVerticalBar() {
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
            assertEquals(ROW, HorizontalBarPlacement.reserve(page, true, false, true));
            assertEquals(CELL, HorizontalBarPlacement.reserve(page, true, true, true));
        }
    }

    @Test
    void withoutTheUserLayoutTheOtherPagesHaveNoBarAndNoReservation() {
        // the switch was left on, but the persistent overlay and the handles exist only in the user layout
        assertEquals(NONE, HorizontalBarPlacement.bar(1, true, false, false, true, false, false));
        assertEquals(NONE, HorizontalBarPlacement.bar(2, true, true, false, true, false, false));
        assertEquals(NONE, HorizontalBarPlacement.bar(1, true, false, false, true, true, false));
        assertEquals(HorizontalBarPlacement.Reserve.NONE, HorizontalBarPlacement.reserve(1, true, false, false));
        assertEquals(HorizontalBarPlacement.Reserve.NONE, HorizontalBarPlacement.reserve(3, true, true, false));
    }

    @Test
    void withoutTheUserLayoutTheFirstPageIsAsToday() {
        assertEquals(EMBEDDED, HorizontalBarPlacement.bar(0, true, false, false, true, false, false));
        assertEquals(HANDLE, HorizontalBarPlacement.bar(0, true, true, false, true, false, false));
        assertEquals(BUTTON, HorizontalBarPlacement.bar(0, true, true, true, true, false, false));
        assertEquals(ROW, HorizontalBarPlacement.reserve(0, true, false, false));
        assertEquals(CELL, HorizontalBarPlacement.reserve(0, true, true, false));
    }

    @Test
    void theButtonIsOnlyOnTheHandlesSideAndTheHandleStandsForTheBarOnTheOther() {
        for (int page = 0; page < 3; page++) {
            for (boolean moving : new boolean[] {false, true}) {
                // the vertical bar on the other side than the handle: never a button
                HorizontalBarPlacement.Bar other = HorizontalBarPlacement.bar(page, true, true, true && page == 0, false, moving, true);
                assertEquals(moving ? NONE : HANDLE, other);
                // the same side: the button on the first page only
                HorizontalBarPlacement.Bar same = HorizontalBarPlacement.bar(page, true, true, true && page == 0, true, moving, true);
                assertEquals(moving ? NONE : page == 0 ? BUTTON : HANDLE, same);
                // without the vertical bar the sides do not matter
                assertEquals(moving ? NONE : HANDLE,
                        HorizontalBarPlacement.bar(page, true, true, false, true, moving, true));
                assertEquals(moving ? NONE : HANDLE,
                        HorizontalBarPlacement.bar(page, true, true, false, false, moving, true));
            }
        }
        // the first page with the option off
        assertEquals(HANDLE, HorizontalBarPlacement.bar(0, false, true, true, false, false, true));
        assertEquals(BUTTON, HorizontalBarPlacement.bar(0, false, true, true, true, false, true));
        assertEquals(NONE, HorizontalBarPlacement.bar(1, false, true, false, true, false, true));
    }

    @Test
    void withTheVerticalBarOnEveryPageTheOtherPagesHaveTheButtonToo() {
        // verticalOnPage is true on page 2: the button on the handle's side, the handle on the other
        assertEquals(BUTTON, HorizontalBarPlacement.bar(2, true, true, true, true, false, true));
        assertEquals(HANDLE, HorizontalBarPlacement.bar(2, true, true, true, false, false, true));
        assertEquals(NONE, HorizontalBarPlacement.bar(2, true, true, true, true, true, true));
        // the horizontal bar is only on the first page: nothing on page 2, the vertical bar or not
        assertEquals(NONE, HorizontalBarPlacement.bar(2, false, true, true, true, false, true));
    }
}
