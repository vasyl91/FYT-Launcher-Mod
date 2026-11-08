package com.android.launcher66.settings;

/**
 * Moves the statistics window out of the way of the bars. The window lies above every other element of the home
 * screen (the PiPs, the widgets, the icons), so it never collides with them; the horizontal and the vertical bar
 * are the only things it must not cover. So it is moved, and only moved: its size is the user's (the three sizes
 * in the settings), it is not cut, and nothing else is moved to make room for it. Pure Java, so that the rule
 * has a test.
 *
 * <p>The room is the free area of the page beside the bars ({@code bounds}), which Helpers works out from the same
 * environment it fits the PiPs and the widgets in. Each axis is treated alone, by the smallest step that brings
 * the window into the room; a window that does not overlap a bar stays exactly where it is. A window larger than
 * the room in an axis stands at the room's inner edge (the left, the top) and is as large as it was.
 */
public final class StatsBarFit {

    private StatsBarFit() {
    }

    /**
     * @param rect   {left, top, right, bottom} the window, as the user placed it
     * @param bounds {left, top, right, bottom} the room beside the bars
     * @return the same size, moved into the room
     */
    public static int[] move(int[] rect, int[] bounds) {
        int width = rect[2] - rect[0];
        int height = rect[3] - rect[1];
        int left = place(rect[0], width, bounds[0], bounds[2]);
        int top = place(rect[1], height, bounds[1], bounds[3]);
        return new int[] {left, top, left + width, top + height};
    }

    /** Whether the window is larger than the room in either axis (it then stands at the inner edge). */
    public static boolean largerThanRoom(int[] rect, int[] bounds) {
        return rect[2] - rect[0] > bounds[2] - bounds[0] || rect[3] - rect[1] > bounds[3] - bounds[1];
    }

    private static int place(int start, int size, int low, int high) {
        if (size > high - low) {
            return low;
        }
        return Math.max(low, Math.min(start, high - size));
    }
}
