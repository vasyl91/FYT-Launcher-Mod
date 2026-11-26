package com.android.launcher66;

/**
 * The grid of the app drawer's pages: the rows and the columns.
 *
 * <p>The rule (the owner, 2026-11-25): like the home screen's grid (WorkspaceGrid) it is stored as the cells along the
 * long and along the short edge of the screen, so that the same screen keeps the same grid when it is turned: 7 along
 * the long edge and 4 along the short one by default (what the drawer always had: 7 rows by 4 columns upright, 4 by 7
 * across), 3 to 12 along the long edge and 2 to 8 along the short. Rows are the long edge upright and the short one across.
 * It is a creator setting, so with "Stock layout" the default is what the launcher reads (CreatorPrefs). Pure Java,
 * so that it has a test.
 */
public final class AppsGrid {

    public static final int DEFAULT_LONG = 7;
    public static final int DEFAULT_SHORT = 4;
    public static final int MIN_LONG = 3;
    public static final int MAX_LONG = 12;
    public static final int MIN_SHORT = 2;
    public static final int MAX_SHORT = 8;

    private AppsGrid() {
    }

    public static int clampLong(int cells) {
        return Math.max(MIN_LONG, Math.min(MAX_LONG, cells));
    }

    public static int clampShort(int cells) {
        return Math.max(MIN_SHORT, Math.min(MAX_SHORT, cells));
    }

    /** The rows of a page: the short edge across, the long one upright. */
    public static int rows(boolean landscape, int longCells, int shortCells) {
        return landscape ? clampShort(shortCells) : clampLong(longCells);
    }

    /** The columns of a page: the long edge across, the short one upright. */
    public static int columns(boolean landscape, int longCells, int shortCells) {
        return landscape ? clampLong(longCells) : clampShort(shortCells);
    }
}
