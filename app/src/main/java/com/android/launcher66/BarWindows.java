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
 * <p>The layers of the launcher's own sub-windows, from the bottom: the panes of the PiPs ({@code PANEL}, they
 * move with the pages), the statistics window on the home screen ({@link #HOME_STATS_TYPE}, a sub-panel, it
 * moves with its page and lies over a pane it shares a place with), the bars on every page
 * ({@link #EVERY_PAGE_TYPE}, the layer above sub-panels), which stand still while everything else moves under
 * them. A layer decides whatever the order the windows were added in; within one layer the one added later lies
 * higher, and the panes are added again at every start of the PiPs, the bars once. Before 2026-11-18 the
 * statistics window was an overlay above every window of the launcher and passed over the vertical bar during a
 * swipe (the owner, 7862). The auto-hide bar and the edge handle stay panels. If the system refuses a type, the
 * window takes the next one down ({@link #addEveryPageBar}) and the log says so.
 *
 * <p>The keyboard is kept above the bars by ImeAnchor, a window of one pixel above them that is the keyboard's target
 * (Android 10 and older; the owner on the 7862, 2026-11-27).
 *
 * <p>A sub-window needs the launcher's window to be there (its token), and nothing else: no permission to
 * draw over other apps. It goes with the launcher's window. The coordinates stay the screen's: the windows keep
 * FLAG_LAYOUT_IN_SCREEN.
 */
public final class BarWindows {

    private static final String TAG = "BarWindows";

    /** The window type of the auto-hide bar and the edge handle: a panel of the launcher's window. */
    static final int TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;

    /**
     * The window type of the bars on every page: the layer above the sub-panels
     * (WindowManager.LayoutParams.TYPE_APPLICATION_ABOVE_SUB_PANEL, hidden in the SDK, FIRST_SUB_WINDOW + 5).
     */
    static final int EVERY_PAGE_TYPE = WindowManager.LayoutParams.FIRST_SUB_WINDOW + 5;

    /** The window type of the statistics window on the home screen: a sub-panel, between the panes and the bars. */
    public static final int HOME_STATS_TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL;

    /** The types a bar on every page is tried with, in this order (see the class). */
    private static final int[] EVERY_PAGE_TYPES = {EVERY_PAGE_TYPE, HOME_STATS_TYPE, TYPE};

    private BarWindows() {
    }

    /**
     * Whether the launcher's window is there for a bar's window to be added to. A bar that could not be added
     * while it was not there has not failed: it is built again by the next update.
     */
    public static boolean parentReady(Activity launcher) {
        if (launcher == null || launcher.getWindow() == null) {
            return false;
        }
        View decor = launcher.getWindow().peekDecorView();
        return decor != null && decor.getWindowToken() != null;
    }

    /**
     * Adds the window of a bar on every page in the layer above the sub-panels, else in the next one down that the
     * system takes (EVERY_PAGE_TYPES).
     *
     * @throws RuntimeException what adding it as a panel threw: the launcher's window is not there
     */
    static void addEveryPageBar(WindowManager windowManager, View root, WindowManager.LayoutParams params,
                                String what) {
        for (int i = 0; i < EVERY_PAGE_TYPES.length; i++) {
            params.type = EVERY_PAGE_TYPES[i];
            try {
                windowManager.addView(root, params);
                if (i > 0) {
                    Log.w(TAG, what + ": added with the window type " + params.type);
                }
                // The keyboard stays above it (ImeAnchor): the anchor is put above the window just added
                ImeAnchor.raise(windowManager, root.getContext(), params.token);
                return;
            } catch (RuntimeException e) {
                if (i == EVERY_PAGE_TYPES.length - 1) {
                    throw e;
                }
                Log.w(TAG, what + ": not added with the window type " + params.type + " (" + e + ")");
            }
        }
    }
}
