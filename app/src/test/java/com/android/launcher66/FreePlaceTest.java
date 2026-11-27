package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class FreePlaceTest {

    // Four columns of 100 px and three rows of 100 px, no gaps: a container of 400 x 300
    private static final int[] COL_L = {0, 100, 200, 300};
    private static final int[] COL_R = {100, 200, 300, 400};
    private static final int[] ROW_T = {0, 100, 200};
    private static final int[] ROW_B = {100, 200, 300};

    private static boolean[][] free() {
        return new boolean[4][3];
    }

    @Test
    void theWidgetGoesWhereItIsLetGoNotToTheCells() {
        assertArrayEquals(new int[] {37, 54, 150, 80},
                FreePlace.place(37, 54, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, free()));
        assertArrayEquals(new int[] {37, 54, 150, 80},
                FreePlace.place(37, 54, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, null), "overlap allowed");
    }

    @Test
    void aWidgetPastAnEdgeIsPushedBackItsSizeKept() {
        assertArrayEquals(new int[] {250, 0, 150, 80},
                FreePlace.place(320, -30, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, null));
        assertArrayEquals(new int[] {0, 0, 400, 300},
                FreePlace.place(10, 10, 900, 900, 400, 300, COL_L, COL_R, ROW_T, ROW_B, null), "no larger than the page");
    }

    @Test
    void withOverlapTheHeldCellsDoNotMatter() {
        boolean[][] held = free();
        held[0][0] = true;
        assertArrayEquals(new int[] {10, 10, 150, 80},
                FreePlace.place(10, 10, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, null));
    }

    @Test
    void overAHeldCellItGoesToTheNearestPlaceOverFreeCells() {
        boolean[][] held = free();
        held[0][0] = true;   // an icon in the top left cell
        // let go at 30,20, 150 x 80: it would touch cells 0..1 x 0; the nearest free place is just right of the icon
        assertArrayEquals(new int[] {100, 20, 150, 80},
                FreePlace.place(30, 20, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, held));
    }

    @Test
    void theNearestPlaceMayBeBelow() {
        boolean[][] held = free();
        held[1][0] = true;
        held[2][0] = true;
        held[3][0] = true;   // the top row is full but its first cell
        // 150 wide does not fit in the first column alone: below the row it goes
        assertArrayEquals(new int[] {30, 100, 150, 80},
                FreePlace.place(30, 10, 150, 80, 400, 300, COL_L, COL_R, ROW_T, ROW_B, held));
    }

    @Test
    void withNoFreePlaceThereIsNone() {
        boolean[][] held = free();
        for (int x = 0; x < 4; x++) {
            held[x][1] = true;
        }
        // 150 tall needs two rows, and every pair of rows has the middle one held
        assertNull(FreePlace.place(30, 10, 80, 150, 400, 300, COL_L, COL_R, ROW_T, ROW_B, held));
    }

    @Test
    void theCellsARectangleTouches() {
        assertArrayEquals(new int[] {0, 0, 2, 1}, FreePlace.cellsTouched(37, 10, 150, 80, COL_L, COL_R, ROW_T, ROW_B));
        assertArrayEquals(new int[] {1, 0, 2, 1}, FreePlace.cellsTouched(100, 20, 150, 80, COL_L, COL_R, ROW_T, ROW_B),
                "an edge on a cell's edge does not touch the cell beside it");
        assertNull(FreePlace.cellsTouched(500, 500, 10, 10, COL_L, COL_R, ROW_T, ROW_B));
    }

    @Test
    void gapsBetweenTheCellsAreNoCell() {
        int[] colL = {0, 110};
        int[] colR = {100, 210};
        int[] rowT = {0};
        int[] rowB = {100};
        boolean[][] held = new boolean[2][1];
        held[1][0] = true;
        // 100 wide fits in the first column exactly
        assertArrayEquals(new int[] {0, 0, 100, 100}, FreePlace.place(40, 0, 100, 100, 210, 100, colL, colR, rowT, rowB,
                held));
    }
}
