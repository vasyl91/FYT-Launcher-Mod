package com.android.launcher66;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.util.Log;

import com.android.launcher66.settings.BottomBarDimensions;

/**
 * How many slots the bars have room for. The bottom bar used to show a fixed set of slots per mode
 * (4, 5, 7 or 8) and the left bar a fixed five; both now follow the space they have, with one rule
 * for how close two icons may stand: the pitch (icon start to next icon start) is at least
 * {@link #MIN_SLOT_PITCH} times the icon, i.e. the gap is at least a quarter of the icon, which is
 * what the widget bar has always had.
 *
 * The bottom bar's part is pure (screen width, preferences, orientation) so that it can run before
 * any view is measured, e.g. for the bar snapshots; the left bar's part needs the measured height
 * of its recycler and lives in Launcher.EvenVerticalLayoutManager.
 */
public final class BarCapacity {

    private static final String TAG = "BarCapacity";

    /** Smallest pitch of two neighbouring icons, as a multiple of the icon size (both bars). */
    public static final float MIN_SLOT_PITCH = 1.25f;

    /** Most slots the bottom bar is given, however low the bar is. */
    public static final int MAX_BOTTOM_SLOTS = 16;

    /** Rows the database keeps for the bottom bar before any extra slot is asked for. */
    public static final int DEFAULT_BOTTOM_ROWS = 8;

    /** Left bar: the apps opened last that the database remembers, whether they fit or not. */
    public static final int LEFT_MEMORY = 12;

    /** Left bar: fewest slots it shows, the count it had before it followed the space. */
    public static final int MIN_LEFT_SLOTS = 5;

    // Recycler width as a fraction of the screen, mirroring the values that
    // Workspace.forceOriginalSizesLayoutOne/Two() force onto the views.
    public static final float RECYCLER_W_WIDGET_PORTRAIT  = 0.4385f;
    public static final float RECYCLER_W_WIDGET_LANDSCAPE = 0.4395f;
    public static final float RECYCLER_W_PLAIN            = 0.8795f;

    // Recycler height as a fraction of its own width (portrait only; landscape fills the bar).
    public static final float RECYCLER_H_WIDGET_PORTRAIT = 0.295f;

    // Slot counts the widget bar had when the icon size was chosen. They are no longer the number
    // of visible slots; they only fix the reference icon size, which must not change.
    public static final int ICON_REFERENCE_SLOTS_PORTRAIT  = 4;
    public static final int ICON_REFERENCE_SLOTS_LANDSCAPE = 5;

    /** Share of the tile taken by the icon; the rest is breathing room. */
    public static final float ICON_FILL = 0.80f;

    /** Tolerance for a capacity that lands exactly on a whole number (landscape, no widgets: ~10.0). */
    private static final float CAPACITY_EPSILON = 1e-3f;

    /**
     * Slot (AppMultiple.index) -> its rank in the order slots are given up. Rank 0 goes last:
     * 1, 5, 6, 7, 4, 2, 3, 0, then 8, 9, 10, ... A capacity of n shows the n slots of lowest rank,
     * which are exactly the sets the bar showed before: 4 -> {1,5,6,7}, 5 -> {1,4,5,6,7},
     * 7 -> {1..7}, 8 -> {0..7}.
     */
    private static final int[] SLOT_RANK = {7, 0, 5, 6, 4, 1, 2, 3};

    private static String sLastLoggedBottom = "";
    private static String sLastLoggedLeft = "";

    private BarCapacity() {
    }

    // ---------------------------------------------------------------------------------------
    // Bottom bar
    // ---------------------------------------------------------------------------------------

    /** Fewest slots the bottom bar shows in a mode, whatever the height: the count it had before. */
    public static int minBottomSlots(boolean portrait, boolean widgetMode) {
        if (widgetMode) {
            return portrait ? ICON_REFERENCE_SLOTS_PORTRAIT : ICON_REFERENCE_SLOTS_LANDSCAPE;
        }
        return portrait ? 7 : 8;
    }

    /** Width of the bottom bar's recycler in px, as the layouts force it. */
    public static int bottomRecyclerWidth(boolean portrait, boolean widgetMode) {
        float fraction;
        if (widgetMode) {
            fraction = portrait ? RECYCLER_W_WIDGET_PORTRAIT : RECYCLER_W_WIDGET_LANDSCAPE;
        } else {
            fraction = RECYCLER_W_PLAIN;
        }
        return (int) (Launcher.screenWidth * fraction);
    }

    /**
     * Icon size of the bottom bar before it is cut down to the width of a tile. Always taken from
     * the widget-bar metrics, in both modes, and scaled with the bar height when that is resizable
     * (user layouts only): a lower bar has smaller icons, which is where the extra slots come from.
     * AppListAdapter and bottomCapacity() both read it from here, so they cannot disagree.
     */
    public static int bottomIconSize(SharedPreferences prefs, boolean portrait, boolean userLayout) {
        int widgetRecyclerWidth = bottomRecyclerWidth(portrait, true);
        int widgetTileWidth = widgetRecyclerWidth
                / (portrait ? ICON_REFERENCE_SLOTS_PORTRAIT : ICON_REFERENCE_SLOTS_LANDSCAPE);
        int widgetRecyclerHeight = portrait
                ? (int) (widgetRecyclerWidth * RECYCLER_H_WIDGET_PORTRAIT)
                : widgetTileWidth;

        int iconSize = (int) (Math.min(widgetTileWidth, widgetRecyclerHeight) * ICON_FILL);
        // Resizable bottom bar (user layouts only - the other layouts keep their XML bar): the
        // icon follows the bar height proportionally, so it keeps exactly the icon/bar ratio of the
        // legacy layout (a lowered bar would otherwise clip it). Nothing changes while
        // Keys.RESIZABLE_BOTTOM_BAR is off or at its default value; the tile width is untouched.
        if (userLayout && BottomBarDimensions.isResizable(prefs)) {
            iconSize = (int) (iconSize * BottomBarDimensions.getHeightScale(prefs, portrait));
        }
        return iconSize;
    }

    /**
     * Slots that fit in the bottom bar: floor(recycler width / (icon * MIN_SLOT_PITCH)), at least
     * what the mode showed before and at most {@link #MAX_BOTTOM_SLOTS}. Pure: no view is measured.
     *
     * @param orientation Configuration.ORIENTATION_*; anything but portrait counts as landscape
     */
    public static int bottomCapacity(SharedPreferences prefs, int orientation,
                                     boolean userLayout, boolean widgetBar) {
        boolean portrait = orientation == Configuration.ORIENTATION_PORTRAIT;
        boolean widgetMode = userLayout && widgetBar;
        int min = minBottomSlots(portrait, widgetMode);

        int available = bottomRecyclerWidth(portrait, widgetMode);
        int iconSize = bottomIconSize(prefs, portrait, userLayout);
        int capacity = min;
        if (available > 0 && iconSize > 0) {
            capacity = (int) Math.floor(available / (iconSize * MIN_SLOT_PITCH) + CAPACITY_EPSILON);
            capacity = Math.max(min, Math.min(MAX_BOTTOM_SLOTS, capacity));
        }
        logOnce(false, "bottom: " + (portrait ? "portrait" : "landscape") + (widgetMode ? " widget" : " plain")
                + " available=" + available + " icon=" + iconSize + " pitch=" + MIN_SLOT_PITCH
                + " min=" + min + " capacity=" + capacity);
        return capacity;
    }

    /**
     * Whether the slot (AppMultiple.index) is shown at this capacity. A slot is the logical index
     * of its row, not a position in the query result or in the adapter.
     */
    public static boolean isBottomSlotVisible(int slot, int capacity) {
        if (slot < 0) {
            return false;
        }
        int rank = slot < SLOT_RANK.length ? SLOT_RANK[slot] : slot;
        return rank < capacity;
    }

    // ---------------------------------------------------------------------------------------
    // Left bar
    // ---------------------------------------------------------------------------------------

    /**
     * Slots that fit in a left bar of this height when an item is naturally this tall:
     * floor(height / (item * MIN_SLOT_PITCH)), within [MIN_LEFT_SLOTS, LEFT_MEMORY].
     */
    public static int leftCapacity(int height, int naturalItemHeight) {
        if (height <= 0 || naturalItemHeight <= 0) {
            return MIN_LEFT_SLOTS;
        }
        int capacity = (int) Math.floor(height / (naturalItemHeight * MIN_SLOT_PITCH) + CAPACITY_EPSILON);
        capacity = Math.max(MIN_LEFT_SLOTS, Math.min(LEFT_MEMORY, capacity));
        logOnce(true, "left: available=" + height + " item=" + naturalItemHeight + " pitch=" + MIN_SLOT_PITCH
                + " capacity=" + capacity);
        return capacity;
    }

    /** Keeps the log to one line per change; the capacities are asked for on every rebuild. */
    private static void logOnce(boolean left, String line) {
        synchronized (BarCapacity.class) {
            if (line.equals(left ? sLastLoggedLeft : sLastLoggedBottom)) {
                return;
            }
            if (left) {
                sLastLoggedLeft = line;
            } else {
                sLastLoggedBottom = line;
            }
        }
        Log.d(TAG, line);
    }
}
