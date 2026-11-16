package com.android.launcher66;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

/**
 * The kind of window the bars that stay on every page live in.
 *
 * <p>The rule: the bars' windows (the horizontal bar of the other pages and the auto-hide bar, the vertical
 * bar's window, the edge handle) are sub-windows of the launcher's own window. A sub-window lies over the
 * window it belongs to, so over the pages drawn in it, and under every window of another layer: the floating
 * buttons of the launcher (the PiP swap buttons, Stop logcat), the statistics window, and the floating buttons
 * and overlays of every other app. Before 2026-11-15 the bars were overlays of the same layer as those, and an
 * overlay added later lies over one added earlier; the bars are built after the floating buttons, so the owner
 * saw them cover the buttons on the pages after the first.
 *
 * <p>The windows of the bars on every page (the horizontal bar's and the vertical bar's) are sub-panels: they
 * lie over the panes of the PiPs, which are panels of the same launcher's window and move with the pages. Among
 * sub-windows of one kind the one added later lies higher, and the bars were built before the panes at a cold
 * start but after them on every return from an app, so a pane moving with its page passed over the vertical
 * bar after a start and under it after a return. A sub-panel lies over every panel whatever the order, so the
 * pages and their panes always move under the bars that stand still. The auto-hide bar and the edge handle stay
 * panels. If the system refuses a sub-panel, the bar's window is a panel as before ({@link #addEveryPageBar}).
 *
 * <p>A sub-window needs the launcher's window to be there (its token), and nothing else: no permission to
 * draw over other apps. It goes with the launcher's window. The coordinates stay the screen's: the windows keep
 * FLAG_LAYOUT_IN_SCREEN.
 */
final class BarWindows {

    private static final String TAG = "BarWindows";

    /** The window type of the auto-hide bar and the edge handle: a panel of the launcher's window. */
    static final int TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;

    /** The window type of the bars on every page: a sub-panel of the launcher's window, over its panels. */
    static final int EVERY_PAGE_TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;

    private BarWindows() {
    }

    /**
     * Whether the launcher's window is there for a bar's window to be added to. A bar that could not be added
     * while it was not there has not failed: it is built again by the next update.
     */
    static boolean parentReady(Activity launcher) {
        if (launcher == null || launcher.getWindow() == null) {
            return false;
        }
        View decor = launcher.getWindow().peekDecorView();
        return decor != null && decor.getWindowToken() != null;
    }

    /**
     * Adds the window of a bar on every page as a sub-panel, and as a panel if the system refuses that.
     *
     * @throws RuntimeException what adding it as a panel threw: the launcher's window is not there
     */
    static void addEveryPageBar(WindowManager windowManager, View root, WindowManager.LayoutParams params,
                                String what) {
        params.type = EVERY_PAGE_TYPE;
        try {
            windowManager.addView(root, params);
            return;
        } catch (RuntimeException e) {
            Log.w(TAG, what + ": not added as a sub-panel (" + e + "), added as a panel");
        }
        params.type = TYPE;
        windowManager.addView(root, params);
    }
}
