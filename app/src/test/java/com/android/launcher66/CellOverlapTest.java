package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

class CellOverlapTest {

    private static CellOverlap.Box icon(int x, int y) {
        return new CellOverlap.Box(x, y, 1, 1, false);
    }

    private static CellOverlap.Box widget(int x, int y, int spanX, int spanY) {
        return new CellOverlap.Box(x, y, spanX, spanY, true);
    }

    @Test
    void aWidgetOverIconsIsTheOneThatMoves() {
        // The owner's case: a widget over three icons in a row; bound after them, or even before
        assertEquals(Collections.singletonList(3),
                CellOverlap.toMove(Arrays.asList(icon(0, 2), icon(1, 2), icon(2, 2), widget(0, 2, 3, 1))));
        assertEquals(Collections.singletonList(0),
                CellOverlap.toMove(Arrays.asList(widget(0, 2, 3, 1), icon(0, 2), icon(1, 2), icon(2, 2))));
    }

    @Test
    void ofTwoIconsInOneCellTheLaterOneMoves() {
        assertEquals(Collections.singletonList(1), CellOverlap.toMove(Arrays.asList(icon(4, 4), icon(4, 4))));
    }

    @Test
    void itemsSideBySideStay() {
        assertTrue(CellOverlap.toMove(Arrays.asList(icon(0, 0), widget(1, 0, 2, 2), icon(3, 0), icon(1, 2)))
                .isEmpty());
    }

    @Test
    void ofTwoOverlappingWidgetsTheLaterOneMoves() {
        assertEquals(Collections.singletonList(1),
                CellOverlap.toMove(Arrays.asList(widget(0, 0, 2, 2), widget(1, 1, 2, 2), icon(3, 3))));
    }
}
