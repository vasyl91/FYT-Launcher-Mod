package com.android.launcher66;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GridOverflowTest {

    private static final long FIRST = -302;

    private static WorkspaceGrid.Signature grids(WorkspaceGrid.Cells first, WorkspaceGrid.Cells others) {
        return new WorkspaceGrid.Signature(first, others);
    }

    private static WorkspaceGrid.Cells cells(int x, int y, int ox, int oy) {
        return new WorkspaceGrid.Cells(x, y, ox, oy);
    }

    private static GridOverflow.Item item(long id, long screen, int x, int y) {
        return new GridOverflow.Item(id, screen, x, y, 1, 1);
    }

    private static Map<Long, GridOverflow.Item> byId(List<GridOverflow.Item> moves) {
        Map<Long, GridOverflow.Item> map = new HashMap<>();
        for (GridOverflow.Item move : moves) {
            assertTrue(map.put(move.id, move) == null, "an item is moved once");
        }
        return map;
    }

    private static final GridOverflow.NewScreen NONE = () -> {
        throw new AssertionError("no new page is needed");
    };

    private static final WorkspaceGrid.Signature LEGACY_PORTRAIT = WorkspaceGrid.Signature.legacy(false);

    @Test
    void theSameGridsMoveNothing() {
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 0, 0), item(2, 5, 5, 9));
        assertTrue(GridOverflow.plan(items, LEGACY_PORTRAIT, LEGACY_PORTRAIT, Arrays.asList(5L), NONE).isEmpty());
    }

    @Test
    void anIconInTheRowTheBarTakesGoesToTheNearestFreeCell() {
        // The horizontal bar at the bottom of the first page: the tenth row is gone
        WorkspaceGrid.Signature now = grids(cells(6, 9, 0, 0), cells(6, 10, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 2, 9), item(2, FIRST, 2, 8), item(3, 5, 2, 9));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, LEGACY_PORTRAIT, now, Arrays.asList(5L), NONE));
        assertEquals(1, moves.size());
        GridOverflow.Item moved = moves.get(1L);
        assertEquals(FIRST, moved.screen);
        assertEquals(8, moved.cellY);
        assertTrue(moved.cellX == 1 || moved.cellX == 3, "beside the icon above its old cell: " + moved);
    }

    @Test
    void aBarAtTheLeftRenumbersTheColumnsAndTheIconsStay() {
        // Column 1 of the whole page is the first column beside the bar
        WorkspaceGrid.Signature now = grids(cells(5, 10, 1, 0), cells(6, 10, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 1, 0), item(2, FIRST, 5, 4), item(3, 7, 1, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, LEGACY_PORTRAIT, now, Arrays.asList(7L), NONE));
        assertEquals(2, moves.size());
        assertEquals(0, moves.get(1L).cellX);
        assertEquals(0, moves.get(1L).cellY);
        assertEquals(4, moves.get(2L).cellX);
        assertEquals(4, moves.get(2L).cellY);
    }

    @Test
    void anIconThatLayUnderTheLeftBarGetsAFreeCell() {
        WorkspaceGrid.Signature now = grids(cells(5, 10, 1, 0), cells(6, 10, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 0, 3), item(2, FIRST, 1, 3));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, LEGACY_PORTRAIT, now, new ArrayList<>(), NONE));
        // Item 2 keeps its place (now column 0); item 1 goes beside or below it
        assertEquals(0, moves.get(2L).cellX);
        GridOverflow.Item moved = moves.get(1L);
        assertEquals(FIRST, moved.screen);
        assertTrue(Math.abs(moved.cellX) + Math.abs(moved.cellY - 3) == 1, "next to its old place: " + moved);
    }

    @Test
    void aBarAtTheTopRenumbersTheRows() {
        WorkspaceGrid.Signature now = grids(cells(6, 9, 0, 1), cells(6, 10, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 3, 1), item(2, FIRST, 3, 9));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, LEGACY_PORTRAIT, now, new ArrayList<>(), NONE));
        assertEquals(0, moves.get(1L).cellY);
        assertEquals(8, moves.get(2L).cellY);
    }

    @Test
    void aBarSwitchedOffGivesTheColumnBack() {
        WorkspaceGrid.Signature before = grids(cells(5, 10, 1, 0), cells(6, 10, 0, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(Arrays.asList(item(1, FIRST, 0, 0)), before,
                LEGACY_PORTRAIT, new ArrayList<>(), NONE));
        assertEquals(1, moves.get(1L).cellX);
    }

    @Test
    void aBarMovedFromTheLeftToTheRightKeepsTheIconsInPlace() {
        WorkspaceGrid.Signature before = grids(cells(5, 10, 1, 0), cells(6, 10, 0, 0));
        WorkspaceGrid.Signature now = grids(cells(5, 10, 0, 0), cells(6, 10, 0, 0));
        // Column 0 beside the left bar is column 1 of the page; column 4 becomes the one under the right bar
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 0, 0), item(2, FIRST, 4, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, before, now, new ArrayList<>(), NONE));
        assertEquals(1, moves.get(1L).cellX);
        assertEquals(FIRST, moves.get(2L).screen);
        assertTrue(moves.get(2L).cellX < 5);
    }

    @Test
    void fewerColumnsMoveOnlyWhatLiesOutside() {
        WorkspaceGrid.Signature now = grids(cells(4, 10, 0, 0), cells(4, 10, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, 5, 3, 0), item(2, 5, 5, 0), item(3, 5, 4, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, LEGACY_PORTRAIT, now, Arrays.asList(5L), NONE));
        assertEquals(new HashSet<>(Arrays.asList(2L, 3L)), moves.keySet());
        Set<String> cellsTaken = new HashSet<>(Arrays.asList("3,0"));
        for (GridOverflow.Item move : moves.values()) {
            assertEquals(5, move.screen);
            assertTrue(move.cellX < 4 && move.cellY < 10);
            assertTrue(cellsTaken.add(move.cellX + "," + move.cellY), "two items in one cell: " + move);
        }
    }

    @Test
    void moreRowsMoveNothing() {
        WorkspaceGrid.Signature now = grids(cells(6, 14, 0, 0), cells(6, 14, 0, 0));
        assertTrue(GridOverflow.plan(Arrays.asList(item(1, 5, 5, 9)), LEGACY_PORTRAIT, now, Arrays.asList(5L), NONE).isEmpty());
    }

    @Test
    void aFullPageSendsTheIconToThePageAfterIt() {
        WorkspaceGrid.Signature before = grids(cells(2, 2, 0, 0), cells(2, 2, 0, 0));
        WorkspaceGrid.Signature now = grids(cells(2, 1, 0, 0), cells(2, 1, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, 5, 0, 0), item(2, 5, 1, 0), item(3, 5, 0, 1),
                item(4, 6, 0, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, before, now, Arrays.asList(4L, 5L, 6L), NONE));
        assertEquals(1, moves.size());
        assertEquals(6, moves.get(3L).screen);
        assertEquals(1, moves.get(3L).cellX);
        assertEquals(0, moves.get(3L).cellY);
    }

    @Test
    void withNoPageAfterItThePagesBeforeAreTried() {
        WorkspaceGrid.Signature before = grids(cells(1, 2, 0, 0), cells(1, 2, 0, 0));
        WorkspaceGrid.Signature now = grids(cells(1, 1, 0, 0), cells(1, 1, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, 6, 0, 0), item(2, 6, 0, 1));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, before, now, Arrays.asList(4L, 6L), NONE));
        assertEquals(4, moves.get(2L).screen);
    }

    @Test
    void withNoRoomAnywhereANewPageIsMadeAndNothingIsLost() {
        WorkspaceGrid.Signature before = grids(cells(1, 3, 0, 0), cells(1, 3, 0, 0));
        WorkspaceGrid.Signature now = grids(cells(1, 1, 0, 0), cells(1, 1, 0, 0));
        List<GridOverflow.Item> items = Arrays.asList(item(1, 6, 0, 0), item(2, 6, 0, 1), item(3, 6, 0, 2));
        long[] next = {40};
        List<GridOverflow.Item> moves = GridOverflow.plan(items, before, now, Arrays.asList(6L), () -> next[0]++);
        Map<Long, GridOverflow.Item> byId = byId(moves);
        assertEquals(2, byId.size());
        assertEquals(40, byId.get(2L).screen);
        assertEquals(41, byId.get(3L).screen);
        assertEquals(0, byId.get(3L).cellX);
        assertEquals(0, byId.get(3L).cellY);
    }

    @Test
    void anItemOfTheOtherOrientationIsLeftAlone() {
        // Placed in landscape at column 8: never shown in the six portrait columns, so not moved now
        WorkspaceGrid.Signature now = grids(cells(5, 9, 1, 0), cells(6, 10, 0, 0));
        assertTrue(GridOverflow.plan(Arrays.asList(item(1, FIRST, 8, 2)), LEGACY_PORTRAIT, now,
                new ArrayList<>(), NONE).isEmpty());
    }

    @Test
    void anItemThatAppearsInALargerGridKeepsItsCell() {
        // Eight columns now: the item placed at column 7 in landscape appears, and nothing is put on it,
        // whichever of the two rows was read first
        WorkspaceGrid.Signature before = grids(cells(5, 10, 1, 0), cells(6, 10, 0, 0));
        WorkspaceGrid.Signature now = grids(cells(8, 10, 0, 0), cells(8, 10, 0, 0));
        // Column 4 beside the left bar is column 5 of the page, where the other item has lain unseen
        List<GridOverflow.Item> items = Arrays.asList(item(1, FIRST, 4, 0), item(2, FIRST, 5, 0));
        Map<Long, GridOverflow.Item> moves = byId(GridOverflow.plan(items, before, now, new ArrayList<>(), NONE));
        assertEquals(1, moves.size());
        GridOverflow.Item moved = moves.get(1L);
        assertTrue(!(moved.cellX == 5 && moved.cellY == 0), "not onto the item that appeared: " + moved);
        assertTrue(Math.abs(moved.cellX - 5) + moved.cellY == 1, "beside it: " + moved);
    }

    @Test
    void aWidgetWiderThanTheGridIsMadeAsWideAsTheGrid() {
        WorkspaceGrid.Signature now = grids(cells(4, 10, 0, 0), cells(4, 10, 0, 0));
        GridOverflow.Item widget = new GridOverflow.Item(1, 5, 0, 2, 6, 2);
        List<GridOverflow.Item> moves = GridOverflow.plan(Arrays.asList(widget), LEGACY_PORTRAIT, now,
                Arrays.asList(5L), NONE);
        assertEquals(1, moves.size());
        assertEquals(4, moves.get(0).spanX);
        assertEquals(2, moves.get(0).spanY);
        assertEquals(0, moves.get(0).cellX);
        assertEquals(2, moves.get(0).cellY);
    }

    @Test
    void theIconsOfThePhoneKeepTheirPlacesBesideBothBars() {
        // First page of the screenshot: the vertical bar at the left, the horizontal one at the bottom
        WorkspaceGrid.Signature now = grids(cells(5, 9, 1, 0), cells(6, 10, 0, 0));
        List<GridOverflow.Item> items = new ArrayList<>();
        long id = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 6; x++) {
                items.add(item(id++, FIRST, x, y));
            }
        }
        List<GridOverflow.Item> moves = GridOverflow.plan(items, LEGACY_PORTRAIT, now, new ArrayList<>(), NONE);
        Set<String> taken = new HashSet<>();
        Map<Long, GridOverflow.Item> byId = byId(moves);
        assertEquals(18, byId.size());
        for (GridOverflow.Item move : moves) {
            assertEquals(FIRST, move.screen);
            assertTrue(now.firstPage.holds(move.cellX, move.cellY, 1, 1), "in the grid: " + move);
            assertTrue(taken.add(move.cellX + "," + move.cellY), "one item per cell: " + move);
        }
        // An icon beside the bar moved one column number down and stayed in its row
        assertEquals(1, byId.get(3L).cellX);
        assertEquals(0, byId.get(3L).cellY);
        // The three that lay under the bar took free cells near their old places, below the others
        for (long under : new long[] {1, 7, 13}) {
            GridOverflow.Item moved = byId.get(under);
            assertTrue(moved.cellY >= 3 && moved.cellY <= 4 && moved.cellX <= 1, "near the left edge: " + moved);
        }
    }
}
