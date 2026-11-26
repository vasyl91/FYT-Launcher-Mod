package com.android.launcher66;

/**
 * Every item of a page lies wholly in the part of the page that is seen: an item in cells within the page's grid,
 * an element of the creator (placed by pixels) within the page's box. The page itself is laid out inside the
 * system bars (PagedView takes their insets off), so an item that keeps to this rule is never under the status bar
 * or the navigation bar. Free of android.* so that the rules can be tested.
 *
 * <p>Before 2026-11-16 nothing checked it where items were drawn, and the owner found a widget half under the
 * navigation bar of the A55 after a reorganisation of the page.
 */
final class PageFit {

    private PageFit() {
    }

    /**
     * An element of the creator {x, y, width, height} moved into the page's box: by as much as it lies outside,
     * keeping its size; only an element larger than the box is made as large as the box. The saved rectangle is
     * left as the user made it; this is where it is shown.
     */
    static int[] intoBox(int x, int y, int width, int height, int boxWidth, int boxHeight) {
        int w = Math.max(1, Math.min(width, boxWidth));
        int h = Math.max(1, Math.min(height, boxHeight));
        int left = Math.max(0, Math.min(x, boxWidth - w));
        int top = Math.max(0, Math.min(y, boxHeight - h));
        return new int[] {left, top, w, h};
    }

    /**
     * The items of a page that have to move: those that do not lie wholly in the grid, and of the others those
     * that share a cell with one kept before them (CellOverlap). An item outside the grid is not counted as in
     * the way of one inside it.
     *
     * @return the positions in {@code items} of those that have to move, in that order
     */
    static java.util.List<Integer> toMove(java.util.List<CellOverlap.Box> items, int countX, int countY) {
        return toMove(items, countX, countY, false);
    }

    /**
     * As above; with {@code widgetsMayOverlap} ("Allow widgets to overlap") a widget that lies in the grid is never in the way
     * of another item and is never moved for sharing a cell: only one outside the grid moves.
     */
    static java.util.List<Integer> toMove(java.util.List<CellOverlap.Box> items, int countX, int countY,
                                          boolean widgetsMayOverlap) {
        java.util.List<Integer> outside = new java.util.ArrayList<>();
        java.util.List<Integer> insideAt = new java.util.ArrayList<>();
        java.util.List<CellOverlap.Box> inside = new java.util.ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            CellOverlap.Box box = items.get(i);
            if (inGrid(box.cellX, box.cellY, box.spanX, box.spanY, countX, countY)) {
                if (widgetsMayOverlap && box.widget) {
                    continue;
                }
                insideAt.add(i);
                inside.add(box);
            } else {
                outside.add(i);
            }
        }
        java.util.List<Integer> move = new java.util.ArrayList<>(outside);
        for (int k : CellOverlap.toMove(inside)) {
            move.add(insideAt.get(k));
        }
        java.util.Collections.sort(move);
        return move;
    }

    /** Whether an item of this span at this cell lies wholly in a grid of {@code countX} by {@code countY} cells. */
    static boolean inGrid(int cellX, int cellY, int spanX, int spanY, int countX, int countY) {
        return cellX >= 0 && cellY >= 0 && spanX >= 1 && spanY >= 1
                && cellX + spanX <= countX && cellY + spanY <= countY;
    }

    /**
     * The height of an item in cells, so that the padding of the first rows (the item is drawn that much lower)
     * never takes it past the grid's bottom. Only what the padding added is taken off: an item whose own cells
     * reach past the grid is not hidden here, it is moved by the check of the page.
     *
     * @param top        the item's top in the grid, with the padding
     * @param height     its height from its cells
     * @param padding    the padding of its row
     * @param gridBottom the bottom of the grid's last row
     */
    static int heightInGrid(int top, int height, int padding, int gridBottom) {
        int over = top + height - gridBottom;
        if (over <= 0 || padding <= 0) {
            return height;
        }
        return Math.max(1, height - Math.min(padding, over));
    }
}
