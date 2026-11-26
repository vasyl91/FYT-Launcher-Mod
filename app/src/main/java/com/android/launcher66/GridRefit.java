package com.android.launcher66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Puts the widgets of a page back on the grid when "Allow widgets to overlap" is turned off.
 *
 * <p>The rules (the owner's, 2026-11-25):
 * <ul>
 *   <li>Icons and folders stand where they are: the widgets give way to them.</li>
 *   <li>The widgets are taken in order, from the top left (the higher first, then the more to the left). A widget
 *       whose cells are free stays. One whose cells are taken goes to the nearest free place of the same size
 *       (the distance between the top left cells, a tie to the higher and then the more left place); when there is
 *       none, it is removed. A widget never goes to cells another widget (or an icon) holds.</li>
 *   <li>A widget that was never moved is never removed while there is room: the result lists what happened to each, so
 *       that the caller logs it and writes it to the database.</li>
 * </ul>
 * Pure Java, so that it has a test; {@code Workspace} makes the items from the page and applies the result.
 */
final class GridRefit {

    /** An item of the page: an icon or a folder ({@code widget} false), or a widget. */
    static final class Item {
        final long id;
        final int cellX;
        final int cellY;
        final int spanX;
        final int spanY;
        final boolean widget;

        Item(long id, int cellX, int cellY, int spanX, int spanY, boolean widget) {
            this.id = id;
            this.cellX = cellX;
            this.cellY = cellY;
            this.spanX = spanX;
            this.spanY = spanY;
            this.widget = widget;
        }
    }

    /** What happened to a widget. */
    static final class Move {
        final long id;
        final boolean removed;
        final int cellX;
        final int cellY;
        /** False when the widget stays where it was. */
        final boolean moved;

        Move(long id, boolean removed, int cellX, int cellY, boolean moved) {
            this.id = id;
            this.removed = removed;
            this.cellX = cellX;
            this.cellY = cellY;
            this.moved = moved;
        }
    }

    private GridRefit() {
    }

    /** The widgets of the page in the order they are put back: the higher first, then the more to the left. */
    static List<Item> widgetsInOrder(List<Item> items) {
        List<Item> widgets = new ArrayList<>();
        for (Item item : items) {
            if (item.widget) {
                widgets.add(item);
            }
        }
        Collections.sort(widgets, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                if (a.cellY != b.cellY) {
                    return Integer.compare(a.cellY, b.cellY);
                }
                if (a.cellX != b.cellX) {
                    return Integer.compare(a.cellX, b.cellX);
                }
                return Long.compare(a.id, b.id);
            }
        });
        return widgets;
    }

    /** The result for every widget of the page, in the order they were handled. */
    static List<Move> refit(List<Item> items, int countX, int countY) {
        boolean[][] taken = new boolean[countX][countY];
        for (Item item : items) {
            if (!item.widget) {
                mark(taken, item.cellX, item.cellY, item.spanX, item.spanY, countX, countY);
            }
        }
        List<Move> moves = new ArrayList<>();
        for (Item widget : widgetsInOrder(items)) {
            if (free(taken, widget.cellX, widget.cellY, widget.spanX, widget.spanY, countX, countY)) {
                mark(taken, widget.cellX, widget.cellY, widget.spanX, widget.spanY, countX, countY);
                moves.add(new Move(widget.id, false, widget.cellX, widget.cellY, false));
                continue;
            }
            int[] place = nearestFree(taken, widget, countX, countY);
            if (place == null) {
                moves.add(new Move(widget.id, true, widget.cellX, widget.cellY, false));
            } else {
                mark(taken, place[0], place[1], widget.spanX, widget.spanY, countX, countY);
                moves.add(new Move(widget.id, false, place[0], place[1], true));
            }
        }
        return moves;
    }

    /** The same by id, for a caller that looks a widget up. */
    static Map<Long, Move> byId(List<Move> moves) {
        Map<Long, Move> map = new HashMap<>();
        for (Move move : moves) {
            map.put(move.id, move);
        }
        return map;
    }

    private static int[] nearestFree(boolean[][] taken, Item widget, int countX, int countY) {
        int bestX = -1;
        int bestY = -1;
        long bestDistance = Long.MAX_VALUE;
        for (int y = 0; y + widget.spanY <= countY; y++) {
            for (int x = 0; x + widget.spanX <= countX; x++) {
                if (!free(taken, x, y, widget.spanX, widget.spanY, countX, countY)) {
                    continue;
                }
                long dx = x - widget.cellX;
                long dy = y - widget.cellY;
                long d = dx * dx + dy * dy;
                // scanned from the top row, the left cell: the first of equal distances is the higher and more left
                if (d < bestDistance) {
                    bestDistance = d;
                    bestX = x;
                    bestY = y;
                }
            }
        }
        return bestX < 0 ? null : new int[] {bestX, bestY};
    }

    private static boolean free(boolean[][] taken, int x, int y, int spanX, int spanY, int countX, int countY) {
        if (x < 0 || y < 0 || x + spanX > countX || y + spanY > countY) {
            return false;
        }
        for (int i = x; i < x + spanX; i++) {
            for (int j = y; j < y + spanY; j++) {
                if (taken[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mark(boolean[][] taken, int x, int y, int spanX, int spanY, int countX, int countY) {
        for (int i = Math.max(0, x); i < Math.min(countX, x + spanX); i++) {
            for (int j = Math.max(0, y); j < Math.min(countY, y + spanY); j++) {
                taken[i][j] = true;
            }
        }
    }
}
