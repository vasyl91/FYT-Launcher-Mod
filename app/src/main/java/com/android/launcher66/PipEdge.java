package com.android.launcher66;

import java.util.List;

/**
 * Where a widget dropped over a PiP goes with "Allow widgets to overlap" (FreeformWidgets): a widget may lie over icons,
 * folders and other widgets, but not over a PiP window of the user's layout, which shows an app above everything.
 *
 * <p>The rules (the owner on the A55, 2026-11-27):
 * <ul>
 *   <li>A widget that touches no PiP stays exactly where it was let go.</li>
 *   <li>One that does is moved edge to edge with the PiP: to the left, the right, above or below it, whichever is the
 *       shortest move that leaves the widget wholly in the page and clear of every PiP.</li>
 *   <li>Where no such move exists the widget is not moved by this ({@link #clear} gives null and the caller says so in
 *       the log).</li>
 * </ul>
 * Rectangles are {left, top, width, height} in the page's container. Pure Java, so that it has a test.
 */
final class PipEdge {

    private PipEdge() {
    }

    /** The widget's rectangle clear of the PiPs, the same one when it touches none; null when it cannot be cleared. */
    static int[] clear(int[] rect, List<int[]> pips, int areaW, int areaH) {
        if (pips == null || pips.isEmpty() || !touchesAny(rect, pips)) {
            return rect;
        }
        int[] best = null;
        long bestDistance = Long.MAX_VALUE;
        for (int[] pip : pips) {
            int[][] moves = {
                    {pip[0] - (rect[0] + rect[2]), 0},   // to its left
                    {pip[0] + pip[2] - rect[0], 0},      // to its right
                    {0, pip[1] - (rect[1] + rect[3])},   // above it
                    {0, pip[1] + pip[3] - rect[1]},      // below it
            };
            for (int[] move : moves) {
                int[] moved = {rect[0] + move[0], rect[1] + move[1], rect[2], rect[3]};
                if (moved[0] < 0 || moved[1] < 0 || moved[0] + moved[2] > areaW || moved[1] + moved[3] > areaH
                        || touchesAny(moved, pips)) {
                    continue;
                }
                long distance = (long) move[0] * move[0] + (long) move[1] * move[1];
                if (distance < bestDistance) {
                    bestDistance = distance;
                    best = moved;
                }
            }
        }
        return best;
    }

    static boolean touches(int[] a, int[] b) {
        return a[0] < b[0] + b[2] && b[0] < a[0] + a[2] && a[1] < b[1] + b[3] && b[1] < a[1] + a[3];
    }

    private static boolean touchesAny(int[] rect, List<int[]> pips) {
        for (int[] pip : pips) {
            if (touches(rect, pip)) {
                return true;
            }
        }
        return false;
    }
}
