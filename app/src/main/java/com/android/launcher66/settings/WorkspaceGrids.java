package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.android.launcher66.BarLayout;
import com.android.launcher66.HorizontalBarPlacement;
import com.android.launcher66.WorkspaceGrid;

/**
 * Builds the {@link WorkspaceGrid} of a page from the settings: the one place that reads the numbers of rows
 * and columns and which bars take a strip from which page. The page (CellLayout), the loader (LauncherModel)
 * and the settings ask here, so that they cannot disagree about the grid of a page.
 *
 * <p>A page is either the first one or one of the others: the bars' rules ask no more of a page than that
 * (HorizontalBarPlacement, VerticalBarPlacement). The vertical bar takes a column only in the user layout;
 * the built-in layout of the first page is not made of cells.
 */
public final class WorkspaceGrids {

    private WorkspaceGrids() {
    }

    public static boolean landscape(Context context) {
        return context.getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT;
    }

    /** Cells along the long edge of the screen, as chosen. */
    public static int longCells(SharedPreferences prefs) {
        return WorkspaceGrid.clampLong(prefs.getInt(Keys.WORKSPACE_GRID_LONG, WorkspaceGrid.DEFAULT_LONG));
    }

    /** Cells along the short edge of the screen, as chosen. */
    public static int shortCells(SharedPreferences prefs) {
        return WorkspaceGrid.clampShort(prefs.getInt(Keys.WORKSPACE_GRID_SHORT, WorkspaceGrid.DEFAULT_SHORT));
    }

    /** The columns of a page without bars. */
    public static int columns(SharedPreferences prefs, boolean landscape) {
        return WorkspaceGrid.columns(landscape, longCells(prefs), shortCells(prefs));
    }

    /** The rows of a page without bars. */
    public static int rows(SharedPreferences prefs, boolean landscape) {
        return WorkspaceGrid.rows(landscape, longCells(prefs), shortCells(prefs));
    }

    /** A page number that stands for the first page or for any other one in the bars' rules. */
    private static int page(boolean firstPage) {
        return firstPage ? 0 : 1;
    }

    /** Whether the vertical bar takes a column of such a page. */
    public static boolean verticalBar(SharedPreferences prefs, boolean firstPage) {
        return prefs.getBoolean(Keys.USER_LAYOUT, false) && BarLayouts.verticalOnPage(prefs, page(firstPage));
    }

    /** What the horizontal bar takes of such a page. */
    public static HorizontalBarPlacement.Reserve reserve(SharedPreferences prefs, boolean firstPage) {
        return HorizontalBarPlacement.reserve(page(firstPage), prefs.getBoolean(Keys.HORIZONTAL_BAR_EVERY_PAGE, false),
                prefs.getBoolean(Keys.AUTO_HIDE_HORIZONTAL_BAR, false), prefs.getBoolean(Keys.USER_LAYOUT, false));
    }

    public static WorkspaceGrid.Cells cells(SharedPreferences prefs, boolean landscape, boolean firstPage) {
        BarLayout sides = BarLayouts.sides(prefs, true);
        return WorkspaceGrid.cells(columns(prefs, landscape), rows(prefs, landscape),
                verticalBar(prefs, firstPage), sides.right,
                reserve(prefs, firstPage) == HorizontalBarPlacement.Reserve.ROW, sides.top);
    }

    /** The strips the bars take from such a page, in pixels: {left, top, right, bottom}. */
    public static int[] insets(SharedPreferences prefs, boolean landscape, boolean firstPage, int barHeight,
                               int verticalBarWidth) {
        BarLayout sides = BarLayouts.sides(prefs, true);
        return WorkspaceGrid.insets(columns(prefs, landscape), rows(prefs, landscape),
                verticalBar(prefs, firstPage), sides.right, verticalBarWidth,
                reserve(prefs, firstPage) == HorizontalBarPlacement.Reserve.ROW, sides.top, barHeight);
    }

    /** Whether the auto-hide bar keeps the corner cell of such a page. */
    public static boolean cornerCell(SharedPreferences prefs, boolean firstPage) {
        return WorkspaceGrid.cornerCell(reserve(prefs, firstPage), verticalBar(prefs, firstPage),
                BarLayouts.sides(prefs, true).sidesAgree());
    }

    /** The grids of all pages in this orientation. */
    public static WorkspaceGrid.Signature signature(SharedPreferences prefs, boolean landscape) {
        return new WorkspaceGrid.Signature(cells(prefs, landscape, true), cells(prefs, landscape, false));
    }

    /** The key under which the grids the items were last arranged for are kept, per orientation. */
    public static String arrangedKey(boolean landscape) {
        return landscape ? Keys.WORKSPACE_GRID_ARRANGED_LANDSCAPE : Keys.WORKSPACE_GRID_ARRANGED_PORTRAIT;
    }
}
