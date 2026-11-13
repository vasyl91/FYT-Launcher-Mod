package com.android.launcher66.settings;

/**
 * The cell grid of a workspace page, as CellLayout lays it out, and the arithmetic that maps a
 * rectangle onto it. The mapping is exactly CellLayout.pointToCellExact(): the gap between two
 * cells belongs to the cell before it, so a few pixels of move can be enough to enter the next
 * row of icons. Pure Java (no Android imports) so the rules are unit-tested on the JVM.
 *
 * <p>Coordinates are the ones CellLayout uses. The creator saves widget rectangles in a box that
 * lacks the vertical bar, and CellLayout adds the bar's width on page 0 ({@code verticalBarOffset}).
 */
public final class GridGeometry {

    /** The grid of the first page and the grid of the other pages: their bars differ (WorkspaceGrid). */
    private static volatile GridGeometry sPublishedFirst;
    private static volatile GridGeometry sPublishedOthers;

    public final int paddingLeft;
    public final int paddingTop;
    /** cellWidth + widthGap */
    public final int pitchX;
    /** cellHeight + heightGap */
    public final int pitchY;
    public final int countX;
    public final int countY;

    public GridGeometry(int paddingLeft, int paddingTop, int pitchX, int pitchY, int countX, int countY) {
        this.paddingLeft = paddingLeft;
        this.paddingTop = paddingTop;
        this.pitchX = pitchX;
        this.pitchY = pitchY;
        this.countX = countX;
        this.countY = countY;
    }

    /**
     * Called by CellLayout once it has measured its cells. The first page has the bars of its own, the
     * other pages those that are on every page, so there are two grids; all the other pages have the same.
     */
    public static void publish(boolean firstPage, GridGeometry grid) {
        if (firstPage) {
            sPublishedFirst = grid;
        } else {
            sPublishedOthers = grid;
        }
    }

    /** The grid of the first page or of the others, or null until such a page has been measured. */
    public static GridGeometry published(boolean firstPage) {
        return firstPage ? sPublishedFirst : sPublishedOthers;
    }

    public boolean isUsable() {
        return pitchX > 0 && pitchY > 0 && countX > 0 && countY > 0;
    }

    public boolean sameAs(GridGeometry o) {
        return o != null && paddingLeft == o.paddingLeft && paddingTop == o.paddingTop
                && pitchX == o.pitchX && pitchY == o.pitchY && countX == o.countX && countY == o.countY;
    }

    /** Column of the x coordinate (CellLayout space), clamped to the grid. */
    public int colOf(int x) {
        return clamp((x - paddingLeft) / pitchX, countX);
    }

    /** Row of the y coordinate, clamped to the grid. */
    public int rowOf(int y) {
        return clamp((y - paddingTop) / pitchY, countY);
    }

    /**
     * Cells a rectangle is assigned to, the way CellLayout.addCustomWidgetToGrid() does it: the
     * top left corner and the last pixel (right - 1, bottom - 1).
     *
     * @param verticalBarOffset width added to x on page 0 when the vertical bar is on, otherwise 0
     * @return {firstCol, firstRow, lastCol, lastRow}
     */
    public int[] cellsOf(int left, int top, int right, int bottom, int verticalBarOffset) {
        return new int[] {colOf(left + verticalBarOffset), rowOf(top),
                colOf(right - 1 + verticalBarOffset), rowOf(bottom - 1)};
    }

    /** Smallest top that is assigned to {@code row} (row >= 1; row 0 has no lower bound). */
    public int rowStart(int row) {
        return paddingTop + row * pitchY;
    }

    /** Smallest x (CellLayout space) assigned to {@code col}. */
    public int colStart(int col) {
        return paddingLeft + col * pitchX;
    }

    private static int clamp(int v, int count) {
        return Math.max(0, Math.min(v, count - 1));
    }
}
