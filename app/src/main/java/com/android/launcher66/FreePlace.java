package com.android.launcher66;

/**
 * Where a freeform widget goes when it is dropped ("Freeform widgets", FreeformWidgets): at the pixels the user let
 * it go, and, while widgets may not overlap, the nearest place where it lies over free cells only.
 *
 * <p>The rules (the owner on the A55, 2026-11-27: the widget did not land where it was let go):
 * <ul>
 *   <li>The widget keeps its size, and lies wholly in the page: a part past an edge is pushed back, nothing else. It
 *       is not limited to the cells the grid found for the drop.</li>
 *   <li>With "Allow widgets to overlap" that is the place.</li>
 *   <li>Without it the widget may lie only over cells no other item holds (a cell counts when the widget touches it at
 *       all). Where the place reaches a held cell, the widget goes to the nearest place, in pixels, where it touches free
 *       cells only; where there is none, {@link #place} says so and the caller uses the cells of the grid.</li>
 * </ul>
 * The cells are given by their edges in the page's container: column x spans {@code colLeft[x]..colRight[x]}, row y
 * {@code rowTop[y]..rowBottom[y]}, in order. Pure Java, so that it has a test.
 */
final class FreePlace {

    private FreePlace() {
    }

    /**
     * @param left,top       where the widget's top left corner was let go, in the container
     * @param width,height   the widget's size
     * @param areaW,areaH    the container's size
     * @param occupied       {@code occupied[x][y]}: the cell is held by another item; null when widgets may overlap
     * @return {left, top, width, height}, or null when no place without a held cell exists
     */
    static int[] place(int left, int top, int width, int height, int areaW, int areaH,
                       int[] colLeft, int[] colRight, int[] rowTop, int[] rowBottom, boolean[][] occupied) {
        int w = Math.max(1, Math.min(width, Math.max(1, areaW)));
        int h = Math.max(1, Math.min(height, Math.max(1, areaH)));
        int l = clamp(left, 0, areaW - w);
        int t = clamp(top, 0, areaH - h);
        if (occupied == null || free(l, t, w, h, colLeft, colRight, rowTop, rowBottom, occupied)) {
            return new int[] {l, t, w, h};
        }
        int[] best = null;
        long bestDistance = Long.MAX_VALUE;
        int countX = colLeft.length;
        int countY = rowTop.length;
        for (int x0 = 0; x0 < countX; x0++) {
            int x1 = lastFor(colLeft, colRight, x0, w);
            if (x1 < 0) {
                continue;
            }
            for (int y0 = 0; y0 < countY; y0++) {
                int y1 = lastFor(rowTop, rowBottom, y0, h);
                if (y1 < 0 || !vacant(occupied, x0, y0, x1, y1)) {
                    continue;
                }
                // The place in this block of free cells nearest to where it was let go
                int pl = clamp(l, colLeft[x0], colRight[x1] - w);
                int pt = clamp(t, rowTop[y0], rowBottom[y1] - h);
                long dx = pl - l;
                long dy = pt - t;
                long distance = dx * dx + dy * dy;
                if (distance < bestDistance) {
                    bestDistance = distance;
                    best = new int[] {pl, pt, w, h};
                }
            }
        }
        return best;
    }

    /** The cells {cellX, cellY, spanX, spanY} a rectangle touches, however little; null when it touches none. */
    static int[] cellsTouched(int left, int top, int width, int height,
                              int[] colLeft, int[] colRight, int[] rowTop, int[] rowBottom) {
        int x0 = -1;
        int x1 = -1;
        for (int x = 0; x < colLeft.length; x++) {
            if (colLeft[x] < left + width && left < colRight[x]) {
                if (x0 < 0) {
                    x0 = x;
                }
                x1 = x;
            }
        }
        int y0 = -1;
        int y1 = -1;
        for (int y = 0; y < rowTop.length; y++) {
            if (rowTop[y] < top + height && top < rowBottom[y]) {
                if (y0 < 0) {
                    y0 = y;
                }
                y1 = y;
            }
        }
        if (x0 < 0 || y0 < 0) {
            return null;
        }
        return new int[] {x0, y0, x1 - x0 + 1, y1 - y0 + 1};
    }

    private static boolean free(int l, int t, int w, int h, int[] colLeft, int[] colRight, int[] rowTop,
                                int[] rowBottom, boolean[][] occupied) {
        int[] cells = cellsTouched(l, t, w, h, colLeft, colRight, rowTop, rowBottom);
        return cells == null
                || vacant(occupied, cells[0], cells[1], cells[0] + cells[2] - 1, cells[1] + cells[3] - 1);
    }

    /** The last column (or row) from {@code first} on that a size fits in together with it; -1 when none does. */
    private static int lastFor(int[] start, int[] end, int first, int size) {
        for (int i = first; i < start.length; i++) {
            if (end[i] - start[first] >= size) {
                return i;
            }
        }
        return -1;
    }

    private static boolean vacant(boolean[][] occupied, int x0, int y0, int x1, int y1) {
        for (int x = x0; x <= x1; x++) {
            for (int y = y0; y <= y1; y++) {
                if (x < occupied.length && y < occupied[x].length && occupied[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int clamp(int v, int lo, int hi) {
        return Math.max(lo, Math.min(Math.max(lo, hi), v));
    }
}
