package com.android.launcher66;

/**
 * The sizes a drop of an item on a page works with.
 *
 * <p>The rules:
 * <ul>
 * <li>The smallest size a drop asks for is the item's minimum, but never larger than the size it has and never
 * below one cell: an item can always be dropped at the size it already has. The minimum of a widget is counted
 * again at each load from the cells of the grid in use, so after the grid became denser it was larger than the
 * widget's own size, and the search for an area gave up.</li>
 * <li>An area is one only with a cell and a size of at least one cell. The search used to answer such a give-up
 * with the cell 0,0 and the size 0x0, which was taken for an area: the reorder was committed (the dragged widget
 * written to 0,0), and only then the drop saw the size 0x0 and "went back" to that very 0,0, under a pane in the
 * corner (owner, 2026-11-16).</li>
 * </ul>
 * Pure Java, so that it has a test.
 */
final class DropSpan {

    private DropSpan() {
    }

    /** The smallest span a drop asks for, along one axis. */
    static int min(int minSpan, int span) {
        int own = Math.max(1, span);
        return minSpan > 0 ? Math.min(minSpan, own) : own;
    }

    /** Whether a search for an area found one the item can take. */
    static boolean usable(int cellX, int cellY, int spanX, int spanY) {
        return cellX >= 0 && cellY >= 0 && spanX >= 1 && spanY >= 1;
    }
}
