package com.android.launcher66;

/**
 * Where the two bars are and what they leave to the widgets: one place for the geometry that used to
 * assume the horizontal bar at the bottom and the vertical bar on the left. Pure Java (no android.*), so
 * that the rules have a test.
 *
 * <p>All coordinates are those of the box the home screen lives in (below the status bar). The horizontal
 * bar spans the whole width, at the top or at the bottom. The vertical bar, on the first page only, takes
 * the rest of the height at the left or the right edge, between the horizontal bar and the other end.
 *
 * <p>The rectangles of the widgets are saved in the box without the vertical bar: x = 0 is its inner edge,
 * so on the left the page adds {@link #contentOffsetX()} to x, and on the right nothing. The usable width
 * is the same on both sides ({@link #maxRight(int)}). In y the rectangles are absolute, and a horizontal
 * bar at the top simply starts them at {@link #minTop(int)}.
 */
public final class BarLayout {

    public final int rootWidth;
    public final int rootHeight;
    public final int barHeight;
    public final int verticalBarWidth;
    public final boolean top;
    /** The vertical bar is at the right edge. */
    public final boolean right;
    /** The edge handle (and the reserved corner cell of the auto-hide bar) is at the right edge. */
    public final boolean handleRight;
    /** The vertical bar is on (and, by the caller's choice of page, it is the first one). */
    public final boolean verticalBar;

    public BarLayout(int rootWidth, int rootHeight, int barHeight, int verticalBarWidth,
                     boolean top, boolean right, boolean handleRight, boolean verticalBar) {
        this.rootWidth = rootWidth;
        this.rootHeight = rootHeight;
        this.barHeight = barHeight;
        this.verticalBarWidth = verticalBar ? Math.max(0, verticalBarWidth) : 0;
        this.top = top;
        this.right = right;
        this.handleRight = handleRight;
        this.verticalBar = verticalBar;
    }

    // ---------------------------------------------------------------- the bars

    /** First y of the horizontal bar. */
    public int horizontalBarTop() {
        return top ? 0 : rootHeight - barHeight;
    }

    /** First y after the horizontal bar. */
    public int horizontalBarBottom() {
        return top ? barHeight : rootHeight;
    }

    /** {left, top, right, bottom} of the vertical bar; all zero without it. */
    public int[] verticalBarBand() {
        if (!verticalBar) {
            return new int[] {0, 0, 0, 0};
        }
        int left = right ? rootWidth - verticalBarWidth : 0;
        return new int[] {left, top ? barHeight : 0, left + verticalBarWidth, top ? rootHeight : rootHeight - barHeight};
    }

    /**
     * The corner of the collapsed (auto-hide) bar's button: the vertical bar's width, in the band of the
     * horizontal bar, at the side of the vertical bar. {left, top, right, bottom}. The button exists
     * only where the vertical bar and the handle are on the same side ({@link #buttonShown()}).
     */
    public int[] collapsedButton() {
        int left = right ? rootWidth - verticalBarWidth : 0;
        return new int[] {left, horizontalBarTop(), left + verticalBarWidth, horizontalBarBottom()};
    }

    // ---------------------------------------------------------------- what is left to the widgets

    /** Added to x (CellLayout space) on the first page: the width of the vertical bar when it is on the left. */
    public int contentOffsetX() {
        return verticalBar && !right ? verticalBarWidth : 0;
    }

    /** Largest right edge of a rectangle (box coordinates): the vertical bar takes its width on either side. */
    public int maxRight(int margin) {
        return (int) Math.floor(rootWidth - margin - verticalBarWidth);
    }

    /**
     * Smallest top of a rectangle: below a horizontal bar at the top. Touching counts as overlap, so at
     * least a pixel apart, as for the bar at the bottom.
     */
    public int minTop(int margin) {
        return top ? barHeight + Math.max(margin, 1) : 0;
    }

    /** Largest bottom edge of a rectangle. */
    public int maxBottom(int margin) {
        return top ? rootHeight - margin : horizontalBarTop() - Math.max(margin, 1);
    }

    /**
     * The top y of a rectangle of this height moved just out of the band of the horizontal bar, where it
     * reaches into it; unchanged otherwise.
     */
    public int fitY(int y, int height, int margin) {
        if (top) {
            return y < barHeight ? barHeight + margin : y;
        }
        int barTop = horizontalBarTop();
        return y + height > barTop ? barTop - height - margin : y;
    }

    /** Insets of a page's content on one side each: {left, top, right, bottom}. */
    public int[] pageInsets(boolean firstPage, boolean barOnThisPage) {
        int left = firstPage && verticalBar && !right ? verticalBarWidth : 0;
        int rightInset = firstPage && verticalBar && right ? verticalBarWidth : 0;
        return new int[] {left, barOnThisPage && top ? barHeight : 0, rightInset, barOnThisPage && !top ? barHeight : 0};
    }

    // ---------------------------------------------------------------- the cell grid

    /** The row of the cell grid the horizontal bar takes: the first at the top, the last at the bottom. */
    public int reservedRow(int countY) {
        return top ? 0 : countY - 1;
    }

    /**
     * Whether the collapsed bar shows a button in the corner of the vertical bar: only when the handle
     * is on the same side. On the other side the handle stands for the bar and there is no button.
     */
    public boolean buttonShown() {
        return verticalBar && sidesAgree();
    }

    /** The vertical bar and the handle are on the same side. */
    public boolean sidesAgree() {
        return right == handleRight;
    }

    /**
     * The cell the auto-hide bar reserves: at the corner on the handle's side, which is where the
     * handle lies and, when the button is shown, the button too.
     */
    public int cornerCellX(int countX) {
        return handleRight ? countX - 1 : 0;
    }

    public int cornerCellY(int countY) {
        return top ? 0 : countY - 1;
    }
}
