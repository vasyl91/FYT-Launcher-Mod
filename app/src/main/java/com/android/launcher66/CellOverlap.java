package com.android.launcher66;

import java.util.ArrayList;
import java.util.List;

/**
 * Which items of a page have to move because they share a cell with another item.
 *
 * <p>Two items of the home screen never lie in the same cell. The loader refuses a row of the database that
 * overlaps another and the re-arrangement after a change of the grid keeps them apart (GridOverflowPropertyTest),
 * yet the owner saw a widget land over three icons after a change of the columns (2026-11-15), by a way that is
 * not known. So a page looks once more when its items and its own elements are in place.
 *
 * <p>The rule: the icons and folders keep their cells, in the order they were bound; then the widgets, in
 * theirs. An item that shares a cell with one kept before it moves (the page puts it on the nearest free cells,
 * else on another page, and never deletes it). So a widget that came over icons is the one that goes, and of
 * two overlapping icons the later one. Pure Java, so that it has a test.
 */
final class CellOverlap {

    /** The cells of one item. */
    static final class Box {
        final int cellX;
        final int cellY;
        final int spanX;
        final int spanY;
        final boolean widget;

        Box(int cellX, int cellY, int spanX, int spanY, boolean widget) {
            this.cellX = cellX;
            this.cellY = cellY;
            this.spanX = Math.max(1, spanX);
            this.spanY = Math.max(1, spanY);
            this.widget = widget;
        }

        boolean overlaps(Box other) {
            return cellX < other.cellX + other.spanX && other.cellX < cellX + spanX
                    && cellY < other.cellY + other.spanY && other.cellY < cellY + spanY;
        }
    }

    private CellOverlap() {
    }

    /**
     * @param items the items of a page, in the order they were bound
     * @return the positions in {@code items} of those that have to move, in that order
     */
    static List<Integer> toMove(List<Box> items) {
        List<Integer> move = new ArrayList<>();
        List<Box> kept = new ArrayList<>();
        for (int pass = 0; pass < 2; pass++) {
            boolean widgets = pass == 1;
            for (int i = 0; i < items.size(); i++) {
                Box box = items.get(i);
                if (box.widget != widgets) {
                    continue;
                }
                boolean free = true;
                for (Box other : kept) {
                    if (box.overlaps(other)) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    kept.add(box);
                } else {
                    move.add(i);
                }
            }
        }
        java.util.Collections.sort(move);
        return move;
    }
}
