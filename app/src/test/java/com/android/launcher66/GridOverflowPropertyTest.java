package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * GridOverflow on many random home screens: whatever the grids before and after (more or fewer columns and
 * rows, a bar that comes, goes or changes sides), no two items share a cell afterwards, and every item that
 * was shown is shown again. The layouts are drawn the way the launcher stores them: items do not overlap,
 * widgets have spans of their own, and some items lie outside the grid of this orientation (placed in the
 * other one).
 */
class GridOverflowPropertyTest {

    private static final long FIRST_PAGE = -302;
    private static final int UNIVERSE = 16;

    @Test
    void noTwoItemsShareACellAfterAnyChangeOfTheGrid() {
        Random random = new Random(20261115L);
        for (int round = 0; round < 3000; round++) {
            WorkspaceGrid.Signature before = randomSignature(random);
            WorkspaceGrid.Signature now = randomSignature(random);
            List<Long> order = new ArrayList<>(Arrays.asList(3L, 4L, 5L));
            List<GridOverflow.Item> items = randomItems(random, before);
            long[] next = {100};
            List<GridOverflow.Item> moves = GridOverflow.plan(items, before, now, order, () -> next[0]++);

            Map<Long, GridOverflow.Item> after = new HashMap<>();
            for (GridOverflow.Item item : items) {
                after.put(item.id, item);
            }
            for (GridOverflow.Item move : moves) {
                after.put(move.id, move);
            }
            String context = "round " + round + ": " + before + " -> " + now + ", items " + items
                    + ", moves " + moves;
            assertNoOverlap(after.values(), context);
            for (GridOverflow.Item item : items) {
                if (before.of(item.screen).holds(item.cellX, item.cellY, item.spanX, item.spanY)) {
                    GridOverflow.Item placed = after.get(item.id);
                    assertTrue(now.of(placed.screen).holds(placed.cellX, placed.cellY, placed.spanX, placed.spanY),
                            "shown before, not shown after: " + placed + " in " + context);
                }
            }
        }
    }

    private static void assertNoOverlap(Iterable<GridOverflow.Item> items, String context) {
        Map<Long, long[][]> pages = new HashMap<>();
        for (GridOverflow.Item item : items) {
            long[][] cells = pages.computeIfAbsent(item.screen, s -> new long[UNIVERSE + 4][UNIVERSE + 4]);
            for (int x = item.cellX; x < item.cellX + item.spanX; x++) {
                for (int y = item.cellY; y < item.cellY + item.spanY; y++) {
                    if (cells[x][y] != 0) {
                        fail("items " + cells[x][y] + " and " + item.id + " share cell " + x + "," + y
                                + " of page " + item.screen + " in " + context);
                    }
                    cells[x][y] = item.id;
                }
            }
        }
    }

    private static WorkspaceGrid.Signature randomSignature(Random random) {
        int columns = 4 + random.nextInt(11);
        int rows = 4 + random.nextInt(11);
        return new WorkspaceGrid.Signature(randomCells(random, columns, rows), randomCells(random, columns, rows));
    }

    /** A page of that grid with a vertical bar (a column fewer) or a horizontal one (a row fewer), or none. */
    private static WorkspaceGrid.Cells randomCells(Random random, int columns, int rows) {
        boolean vertical = random.nextBoolean();
        boolean horizontal = random.nextBoolean();
        int offsetX = vertical && random.nextBoolean() ? 1 : 0;
        int offsetY = horizontal && random.nextBoolean() ? 1 : 0;
        return new WorkspaceGrid.Cells(columns - (vertical ? 1 : 0), rows - (horizontal ? 1 : 0), offsetX, offsetY);
    }

    /** Non-overlapping items on four pages, most inside the grid before, a few outside it. */
    private static List<GridOverflow.Item> randomItems(Random random, WorkspaceGrid.Signature before) {
        List<GridOverflow.Item> items = new ArrayList<>();
        long[] screens = {FIRST_PAGE, 3, 4, 5};
        long id = 1;
        for (long screen : screens) {
            boolean[][] taken = new boolean[UNIVERSE][UNIVERSE];
            WorkspaceGrid.Cells grid = before.of(screen);
            int count = random.nextInt(14);
            for (int i = 0; i < count; i++) {
                boolean widget = random.nextInt(4) == 0;
                int spanX = widget ? 1 + random.nextInt(4) : 1;
                int spanY = widget ? 1 + random.nextInt(4) : 1;
                boolean outside = random.nextInt(8) == 0;
                int limitX = outside ? UNIVERSE : grid.countX;
                int limitY = outside ? UNIVERSE : grid.countY;
                for (int attempt = 0; attempt < 20; attempt++) {
                    if (spanX > limitX || spanY > limitY) {
                        break;
                    }
                    int x = random.nextInt(limitX - spanX + 1);
                    int y = random.nextInt(limitY - spanY + 1);
                    if (free(taken, x, y, spanX, spanY)) {
                        mark(taken, x, y, spanX, spanY);
                        items.add(new GridOverflow.Item(id++, screen, x, y, spanX, spanY));
                        break;
                    }
                }
            }
        }
        return items;
    }

    private static boolean free(boolean[][] taken, int x0, int y0, int spanX, int spanY) {
        for (int x = x0; x < x0 + spanX; x++) {
            for (int y = y0; y < y0 + spanY; y++) {
                if (taken[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mark(boolean[][] taken, int x0, int y0, int spanX, int spanY) {
        for (int x = x0; x < x0 + spanX; x++) {
            for (int y = y0; y < y0 + spanY; y++) {
                taken[x][y] = true;
            }
        }
    }
}
