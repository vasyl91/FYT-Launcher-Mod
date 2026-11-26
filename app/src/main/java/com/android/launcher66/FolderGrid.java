package com.android.launcher66;

/**
 * The columns and rows an open folder arranges its icons in.
 *
 * <p>Two ways, by the setting "Follow home screen grid inside folders" (D-92):
 * <ul>
 *   <li><b>Its own grid</b> (the setting off, as it always was): the grid grows and shrinks with the number of
 *       icons, nearly square, up to the home screen's number of columns and rows ({@link #own}, the arithmetic
 *       of {@code Folder.setupContentDimensions} moved here so that it can be tested).</li>
 *   <li><b>The home screen's grid</b>: always the home screen's columns, and as many rows as the icons need
 *       ({@link #followGrid}); a folder of one icon is one cell wide in a row of columns, never a single column of icons.</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class FolderGrid {

    private FolderGrid() {
    }

    /**
     * The folder's own grid for {@code count} icons, from the grid it has now; at most {@code maxX} columns and
     * {@code maxY} rows. Returns {columns, rows}.
     */
    static int[] own(int count, int countX, int countY, int maxX, int maxY) {
        boolean done = false;
        while (!done) {
            int oldCountX = countX;
            int oldCountY = countY;
            if (countX * countY < count) {
                // Current grid is too small, expand it
                if ((countX <= countY || countY == maxY) && countX < maxX) {
                    countX++;
                } else if (countY < maxY) {
                    countY++;
                }
                if (countY == 0) {
                    countY++;
                }
            } else if ((countY - 1) * countX >= count && countY >= countX) {
                countY = Math.max(0, countY - 1);
            } else if ((countX - 1) * countY >= count) {
                countX = Math.max(0, countX - 1);
            }
            done = countX == oldCountX && countY == oldCountY;
        }
        return new int[] {countX, countY};
    }

    /** The home screen's columns, and the rows the icons need. Returns {columns, rows}; at least 1 x 1. */
    static int[] followGrid(int count, int homeColumns) {
        int columns = Math.max(1, homeColumns);
        int rows = Math.max(1, (Math.max(0, count) + columns - 1) / columns);
        return new int[] {columns, rows};
    }
}
