package com.android.launcher66.settings;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class GridGeometryTest {

    // padding 10/20, cells 100x80 with gaps 8/6 -> pitch 108/86, 6 columns x 5 rows
    private final GridGeometry grid = new GridGeometry(10, 20, 108, 86, 6, 5);

    /** The formula of CellLayout.pointToCellExact(), written out. */
    private static int[] pointToCellExact(GridGeometry g, int x, int y) {
        int cx = (x - g.paddingLeft) / g.pitchX;
        int cy = (y - g.paddingTop) / g.pitchY;
        cx = Math.max(0, Math.min(cx, g.countX - 1));
        cy = Math.max(0, Math.min(cy, g.countY - 1));
        return new int[] {cx, cy};
    }

    @Test
    void cellsOfMatchesPointToCellExact() {
        int[][] rects = {{10, 20, 118, 106}, {0, 0, 50, 50}, {200, 150, 700, 450}, {118, 106, 119, 107},
                {-30, -30, 20, 30}, {600, 440, 5000, 5000}};
        for (int offset : new int[] {0, 142}) {
            for (int[] r : rects) {
                int[] a = pointToCellExact(grid, r[0] + offset, r[1]);
                int[] b = pointToCellExact(grid, r[2] - 1 + offset, r[3] - 1);
                assertArrayEquals(new int[] {a[0], a[1], b[0], b[1]},
                        grid.cellsOf(r[0], r[1], r[2], r[3], offset), r[0] + "," + r[1] + " off " + offset);
            }
        }
    }

    @Test
    void theGapBelongsToTheCellBefore() {
        // row 0 covers y 20..105 (cell 80 + gap 6), row 1 starts at 106
        assertEquals(0, grid.rowOf(105));
        assertEquals(1, grid.rowOf(106));
        assertEquals(106, grid.rowStart(1));
        assertEquals(0, grid.colOf(117));
        assertEquals(1, grid.colOf(118));
        assertEquals(118, grid.colStart(1));
    }

    @Test
    void rowStartIsTheSmallestTopOfThatRow() {
        for (int row = 1; row < grid.countY; row++) {
            assertEquals(row, grid.rowOf(grid.rowStart(row)));
            assertEquals(row - 1, grid.rowOf(grid.rowStart(row) - 1));
        }
    }

    @Test
    void thePositionIsClampedToTheGrid() {
        assertEquals(0, grid.colOf(-500));
        assertEquals(0, grid.rowOf(-500));
        assertEquals(5, grid.colOf(99999));
        assertEquals(4, grid.rowOf(99999));
    }

    @Test
    void leftBarOffsetShiftsTheColumns() {
        int[] without = grid.cellsOf(10, 20, 200, 100, 0);
        int[] with = grid.cellsOf(10, 20, 200, 100, 216);
        assertEquals(0, without[0]);
        assertEquals(2, with[0]);
    }

    @Test
    void usableAndPublished() {
        assertTrue(grid.isUsable());
        assertFalse(new GridGeometry(0, 0, 0, 10, 5, 5).isUsable());
        assertTrue(grid.sameAs(new GridGeometry(10, 20, 108, 86, 6, 5)));
        assertFalse(grid.sameAs(new GridGeometry(10, 20, 108, 86, 7, 5)));
    }
}
