package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class FolderGridTest {

    // the home screen's grid of a landscape unit: 10 columns, 6 rows

    @Test
    void theOwnGridGrowsNearlySquareFromTheOneThatIsThere() {
        // a folder that was 1 x 1 gets its icons one after another
        assertArrayEquals(new int[] {1, 1}, FolderGrid.own(1, 1, 1, 10, 6));
        assertArrayEquals(new int[] {2, 1}, FolderGrid.own(2, 1, 1, 10, 6));
        assertArrayEquals(new int[] {2, 2}, FolderGrid.own(3, 2, 1, 10, 6));
        assertArrayEquals(new int[] {3, 2}, FolderGrid.own(5, 2, 2, 10, 6));
        assertArrayEquals(new int[] {3, 3}, FolderGrid.own(9, 3, 2, 10, 6));
    }

    @Test
    void theOwnGridStopsAtTheHomeScreensColumnsAndRows() {
        int[] grid = FolderGrid.own(40, 6, 6, 10, 6);
        assertArrayEquals(new int[] {7, 6}, grid);
        assertArrayEquals(new int[] {10, 6}, FolderGrid.own(60, 10, 6, 10, 6));
        // more icons than room: the grid is the largest there is
        assertArrayEquals(new int[] {10, 6}, FolderGrid.own(99, 10, 6, 10, 6));
    }

    @Test
    void theOwnGridShrinksWhenIconsLeave() {
        assertArrayEquals(new int[] {2, 2}, FolderGrid.own(4, 4, 4, 10, 6));
        assertArrayEquals(new int[] {1, 1}, FolderGrid.own(1, 3, 3, 10, 6));
    }

    @Test
    void theHomeGridHasTheHomeScreensColumnsAndTheRowsTheIconsNeed() {
        assertArrayEquals(new int[] {10, 1}, FolderGrid.followGrid(1, 10));
        assertArrayEquals(new int[] {10, 1}, FolderGrid.followGrid(5, 10));
        assertArrayEquals(new int[] {10, 1}, FolderGrid.followGrid(10, 10));
        assertArrayEquals(new int[] {10, 2}, FolderGrid.followGrid(11, 10));
        assertArrayEquals(new int[] {10, 4}, FolderGrid.followGrid(40, 10));
        assertArrayEquals(new int[] {6, 7}, FolderGrid.followGrid(40, 6));
    }

    @Test
    void anEmptyFolderAndABrokenColumnCountAreOneCellAtLeast() {
        assertArrayEquals(new int[] {10, 1}, FolderGrid.followGrid(0, 10));
        assertArrayEquals(new int[] {1, 5}, FolderGrid.followGrid(5, 0));
    }
}
