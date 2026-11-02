package com.android.launcher66.settings;

import java.util.HashMap;
import java.util.Map;

/**
 * Which grid cells of each workspace page hold something that is not a custom widget or PiP,
 * built from the launcher database rows (icons, folders, widgets of the user). Pure Java so the
 * page mapping and the marking are unit-tested; {@code CustomLayoutDb} reads the rows.
 */
public final class WorkspaceOccupancy {

    private final GridGeometry grid;
    private final Map<Integer, boolean[][]> pages = new HashMap<>();

    public WorkspaceOccupancy(GridGeometry grid) {
        this.grid = grid;
    }

    /**
     * Page index (as Workspace.mScreenOrder numbers them) of a database screen id, or -1.
     *
     * The custom pages come first: page i is CUSTOM_CONTENT_SCREEN_ID1 - i (-302, -303, ...), they
     * are never persisted. Workspace.updateWorkspaceScreenOrder() persists only the ids >= 0, in
     * page order, so the n-th screen of the database ranking is page customCount + n.
     *
     * @param firstCustomScreenId Workspace.CUSTOM_CONTENT_SCREEN_ID1
     * @param rankedScreenIds     the ids of the screens table, ordered by rank
     */
    public static int pageForScreenId(long screenId, long firstCustomScreenId, int customCount,
                                      long[] rankedScreenIds) {
        long customIndex = firstCustomScreenId - screenId;
        if (customIndex >= 0 && customIndex < customCount) {
            return (int) customIndex;
        }
        for (int i = 0; i < rankedScreenIds.length; i++) {
            if (rankedScreenIds[i] == screenId) {
                return customCount + i;
            }
        }
        return -1;
    }

    /** Marks the cells of one item of the page; cells outside the grid are ignored. */
    public void add(int page, int cellX, int cellY, int spanX, int spanY) {
        if (page < 0 || grid == null) return;
        boolean[][] occupied = pages.get(page);
        if (occupied == null) {
            occupied = new boolean[grid.countX][grid.countY];
            pages.put(page, occupied);
        }
        for (int x = Math.max(0, cellX); x < Math.min(grid.countX, cellX + Math.max(1, spanX)); x++) {
            for (int y = Math.max(0, cellY); y < Math.min(grid.countY, cellY + Math.max(1, spanY)); y++) {
                occupied[x][y] = true;
            }
        }
    }

    /** Occupied cells of the page, indexed [column][row]; an empty grid for a page without items. */
    public boolean[][] page(int page) {
        boolean[][] occupied = pages.get(page);
        return occupied != null ? occupied : new boolean[grid.countX][grid.countY];
    }

    public GridGeometry grid() {
        return grid;
    }
}
