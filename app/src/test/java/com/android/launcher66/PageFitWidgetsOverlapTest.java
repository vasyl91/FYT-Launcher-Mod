package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/** "Allow widgets to overlap" (D7): a widget in the grid is never moved for sharing a cell; one outside the grid still is. */
class PageFitWidgetsOverlapTest {

    private static List<CellOverlap.Box> page() {
        return Arrays.asList(
                new CellOverlap.Box(0, 0, 1, 1, false),   // an icon
                new CellOverlap.Box(0, 0, 2, 2, true),    // a widget over it
                new CellOverlap.Box(1, 1, 2, 2, true));   // a widget beside the icon, over the first widget
    }

    @Test
    void withoutTheSettingTheWidgetsThatShareCellsMove() {
        // the first widget lies over the icon and moves; the second shares no cell with what is kept
        assertEquals(Collections.singletonList(1), PageFit.toMove(page(), 6, 4));
        assertEquals(Collections.singletonList(1), PageFit.toMove(page(), 6, 4, false));
    }

    @Test
    void withTheSettingNothingInTheGridMoves() {
        assertEquals(Collections.emptyList(), PageFit.toMove(page(), 6, 4, true));
    }

    @Test
    void aWidgetOutsideTheGridMovesWhateverTheSetting() {
        List<CellOverlap.Box> items = Arrays.asList(
                new CellOverlap.Box(0, 0, 1, 1, false),
                new CellOverlap.Box(5, 3, 3, 3, true));
        assertEquals(Collections.singletonList(1), PageFit.toMove(items, 6, 4, true));
    }

    @Test
    void iconsStillKeepApartWithTheSetting() {
        List<CellOverlap.Box> items = Arrays.asList(
                new CellOverlap.Box(2, 2, 1, 1, false),
                new CellOverlap.Box(2, 2, 1, 1, false),
                new CellOverlap.Box(0, 0, 3, 3, true));
        assertEquals(Collections.singletonList(1), PageFit.toMove(items, 6, 4, true));
    }
}
