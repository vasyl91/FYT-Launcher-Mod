package com.android.launcher66;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;

/**
 * The kind of window the bars that stay on every page live in.
 *
 * <p>The rule: the bars' windows (the horizontal bar of the other pages and the auto-hide bar, the vertical
 * bar's window, the edge handle) are sub-windows of the launcher's own window. A sub-window lies over the
 * window it belongs to, so over the pages and the panes drawn in it, and under every window of another layer:
 * the floating buttons of the launcher (the PiP swap buttons, Stop logcat), the statistics window, and the
 * floating buttons and overlays of every other app. Before 2026-11-15 the bars were overlays of the same
 * layer as those, and an overlay added later lies over one added earlier; the bars are built after the
 * floating buttons, so the owner saw them cover the buttons on the pages after the first.
 *
 * <p>A sub-window needs the launcher's window to be there (its token), and nothing else: no permission to
 * draw over other apps. It goes with the launcher's window, which is when the bars are put away anyway (the
 * launcher not in front). The coordinates stay the screen's: the windows keep FLAG_LAYOUT_IN_SCREEN.
 */
final class BarWindows {

    /** The window type of the bars: a panel of the launcher's window. */
    static final int TYPE = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;

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
}
