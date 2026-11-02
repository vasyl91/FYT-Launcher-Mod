package com.android.launcher66;

import android.content.Context;
import android.util.Log;

import com.android.launcher66.settings.GridGeometry;
import com.android.launcher66.settings.WorkspaceOccupancy;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Reads the launcher database for the cells of the workspace pages that hold icons, folders and
 * widgets, so that custom widgets and PiPs are only moved or reset into free cells. The page
 * mapping is in {@link WorkspaceOccupancy#pageForScreenId}.
 */
public final class CustomLayoutDb {

    private static final String TAG = "CustomLayoutDb";

    private CustomLayoutDb() {
    }

    /**
     * One query of the Favorites table and one of the screens table on the calling thread (small
     * tables). LauncherModel's worker thread is deliberately not flushed: this runs on the main
     * thread, possibly while the workspace is being loaded.
     *
     * @return the occupied cells, or null when the grid is not known yet or the database cannot
     *         be read - the caller then does not move anything into "free" space it cannot verify.
     */
    public static WorkspaceOccupancy read(Context context, GridGeometry grid, int customPageCount) {
        if (grid == null || !grid.isUsable()) return null;
        try {
            TreeMap<Integer, Long> ranked = LauncherModel.loadWorkspaceScreensDb(context);
            long[] rankedIds = new long[ranked.size()];
            int n = 0;
            for (Map.Entry<Integer, Long> e : ranked.entrySet()) {
                rankedIds[n++] = e.getValue();
            }

            WorkspaceOccupancy occupancy = new WorkspaceOccupancy(grid);
            ArrayList<ItemInfo> items = LauncherModel.getItemsInLocalCoordinates(context);
            for (ItemInfo item : items) {
                // Only the desktop: not the hotseat, not the contents of a folder
                if (item.container != LauncherSettings.Favorites.CONTAINER_DESKTOP) continue;
                int page = WorkspaceOccupancy.pageForScreenId(item.screenId,
                        Workspace.CUSTOM_CONTENT_SCREEN_ID1, customPageCount, rankedIds);
                occupancy.add(page, item.cellX, item.cellY, item.spanX, item.spanY);
            }
            return occupancy;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot read the occupied cells: " + e);
            return null;
        }
    }
}
