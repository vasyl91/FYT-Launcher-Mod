package com.android.launcher66;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Where the items of the home screen go when the grid of their page changes: because the user chose
 * another number of rows or columns, or because a bar was switched on, off or to another side
 * ({@link WorkspaceGrid}).
 *
 * <p>The rules:
 * <ul>
 * <li><b>Nothing is deleted</b> and nothing is left where it cannot be shown. An item that has no cell in
 * the new grid of its page gets the free cells nearest to its old place on that page, else on the pages
 * after it, else on the pages before it, else on a new page at the end.</li>
 * <li><b>An item keeps its place on the screen.</b> A bar at the left or at the top lies before the first
 * cell, so when such a bar comes or goes every cell number of the page changes by one while the icons stay
 * where they were ({@link WorkspaceGrid.Cells#offsetX}).</li>
 * <li><b>Only what was shown is touched.</b> An item that had no cell in the grid before the change (the
 * launcher keeps one cell per item for both orientations, so an item placed in the other orientation can
 * lie outside this one) is left as it is.</li>
 * <li>An item wider or taller than the new grid is made as large as the grid.</li>
 * </ul>
 * Cells that the launcher's own elements (the panes, the widgets of the creator) take are not known here;
 * an item moved under one of them is moved on by the page itself when the element is placed
 * (CellLayout.handleConflictingViews). Pure Java, so that it has a test.
 */
public final class GridOverflow {

    /** An item on a page of the home screen; not one in the hotseat or in a folder. */
    public static final class Item {
        public final long id;
        public final long screen;
        public final int cellX;
        public final int cellY;
        public final int spanX;
        public final int spanY;

        public Item(long id, long screen, int cellX, int cellY, int spanX, int spanY) {
            this.id = id;
            this.screen = screen;
            this.cellX = cellX;
            this.cellY = cellY;
            this.spanX = Math.max(1, spanX);
            this.spanY = Math.max(1, spanY);
        }

        @Override
        public String toString() {
            return id + "@" + screen + ":" + cellX + "," + cellY + " " + spanX + "x" + spanY;
        }
    }

    /** Gives the id of a new page. */
    public interface NewScreen {
        long create();
    }

    private GridOverflow() {
    }

    /**
     * @param items     the items of all pages, each with the cell it has now
     * @param before    the grids the items were arranged for
     * @param now       the grids of the pages now
     * @param order     the pages after the first one, in their order
     * @param newScreen asked for a page when no page has room; the page is put at the end of {@code order}
     * @return every item whose screen, cell or span changes, with its new values
     */
    public static List<Item> plan(List<Item> items, WorkspaceGrid.Signature before,
                                  WorkspaceGrid.Signature now, List<Long> order, NewScreen newScreen) {
        List<Item> moves = new ArrayList<>();
        Map<Long, boolean[][]> taken = new HashMap<>();
        List<Item> shown = new ArrayList<>();
        for (Item item : items) {
            if (before.of(item.screen).holds(item.cellX, item.cellY, item.spanX, item.spanY)) {
                shown.add(item);
            } else {
                // Not shown before, so not this change's to move. Where it reaches into the new grid its
                // cells are taken first, so that nothing is put where it appears now or after a turn of the screen
                mark(taken, now.of(item.screen), item.screen, item.cellX, item.cellY, item.spanX, item.spanY);
            }
        }
        List<Item> homeless = new ArrayList<>();
        for (Item item : shown) {
            WorkspaceGrid.Cells old = before.of(item.screen);
            WorkspaceGrid.Cells grid = now.of(item.screen);
            int x = item.cellX + old.offsetX - grid.offsetX;
            int y = item.cellY + old.offsetY - grid.offsetY;
            if (grid.holds(x, y, item.spanX, item.spanY) && free(taken, grid, item.screen, x, y, item.spanX, item.spanY)) {
                mark(taken, grid, item.screen, x, y, item.spanX, item.spanY);
                if (x != item.cellX || y != item.cellY) {
                    moves.add(new Item(item.id, item.screen, x, y, item.spanX, item.spanY));
                }
            } else {
                homeless.add(new Item(item.id, item.screen, x, y, item.spanX, item.spanY));
            }
        }
        // From the top left, page by page, so that the result does not depend on the order of the rows read
        Collections.sort(homeless, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                if (a.screen != b.screen) {
                    return Long.compare(rank(order, a.screen), rank(order, b.screen));
                }
                if (a.cellY != b.cellY) {
                    return Integer.compare(a.cellY, b.cellY);
                }
                return a.cellX != b.cellX ? Integer.compare(a.cellX, b.cellX) : Long.compare(a.id, b.id);
            }
        });
        List<Long> pages = new ArrayList<>(order);
        for (Item item : homeless) {
            moves.add(place(item, now, pages, taken, newScreen));
        }
        return moves;
    }

    /** The first page (a negative id) comes before the others; a page not in the order after them. */
    private static long rank(List<Long> order, long screen) {
        if (screen < 0) {
            return -1;
        }
        int index = order.indexOf(screen);
        return index >= 0 ? index : order.size();
    }

    private static Item place(Item item, WorkspaceGrid.Signature now, List<Long> pages,
                              Map<Long, boolean[][]> taken, NewScreen newScreen) {
        List<Long> candidates = new ArrayList<>();
        candidates.add(item.screen);
        int own = pages.indexOf(item.screen);
        for (int i = own + 1; i < pages.size(); i++) {
            candidates.add(pages.get(i));
        }
        for (int i = 0; i < own; i++) {
            candidates.add(pages.get(i));
        }
        for (long screen : candidates) {
            WorkspaceGrid.Cells grid = now.of(screen);
            int spanX = Math.min(item.spanX, grid.countX);
            int spanY = Math.min(item.spanY, grid.countY);
            int[] cell = nearest(taken, grid, screen, item.cellX, item.cellY, spanX, spanY);
            if (cell != null) {
                mark(taken, grid, screen, cell[0], cell[1], spanX, spanY);
                return new Item(item.id, screen, cell[0], cell[1], spanX, spanY);
            }
        }
        long screen = newScreen.create();
        pages.add(screen);
        WorkspaceGrid.Cells grid = now.of(screen);
        int spanX = Math.min(item.spanX, grid.countX);
        int spanY = Math.min(item.spanY, grid.countY);
        mark(taken, grid, screen, 0, 0, spanX, spanY);
        return new Item(item.id, screen, 0, 0, spanX, spanY);
    }

    /** The free area whose corner is nearest to the wanted cell; rows from the top win a tie. Null if none. */
    private static int[] nearest(Map<Long, boolean[][]> taken, WorkspaceGrid.Cells grid, long screen,
                                 int wantX, int wantY, int spanX, int spanY) {
        int[] best = null;
        long bestDistance = Long.MAX_VALUE;
        for (int y = 0; y + spanY <= grid.countY; y++) {
            for (int x = 0; x + spanX <= grid.countX; x++) {
                if (!free(taken, grid, screen, x, y, spanX, spanY)) {
                    continue;
                }
                long dx = x - wantX;
                long dy = y - wantY;
                long distance = dx * dx + dy * dy;
                if (distance < bestDistance) {
                    bestDistance = distance;
                    best = new int[] {x, y};
                }
            }
        }
        return best;
    }

    private static boolean free(Map<Long, boolean[][]> taken, WorkspaceGrid.Cells grid, long screen,
                                int cellX, int cellY, int spanX, int spanY) {
        boolean[][] cells = taken.get(screen);
        if (cells == null) {
            return true;
        }
        for (int x = cellX; x < cellX + spanX; x++) {
            for (int y = cellY; y < cellY + spanY; y++) {
                if (x < grid.countX && y < grid.countY && cells[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mark(Map<Long, boolean[][]> taken, WorkspaceGrid.Cells grid, long screen,
                             int cellX, int cellY, int spanX, int spanY) {
        boolean[][] cells = taken.get(screen);
        if (cells == null) {
            cells = new boolean[grid.countX][grid.countY];
            taken.put(screen, cells);
        }
        for (int x = Math.max(0, cellX); x < cellX + spanX && x < grid.countX; x++) {
            for (int y = Math.max(0, cellY); y < cellY + spanY && y < grid.countY; y++) {
                cells[x][y] = true;
            }
        }
    }
}
