package com.syu.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Settings of the windows that follow the workspace pages (the PiP panes, WindowHostSinglePane
 * and WindowHostDualPane, and the CAN bus stats overlay) that are not about their content.
 */
public final class PaneWindows {

    /** WindowManager.LayoutParams.PRIVATE_FLAG_NO_MOVE_ANIMATION; hidden before API 34. */
    private static final int PRIVATE_FLAG_NO_MOVE_ANIMATION = 0x00000040;

    private PaneWindows() {}

    /** WindowManager.LayoutParams.setCanPlayMoveAnimation() is public from API 34. */
    static boolean usesPublicApi(int sdkInt) {
        return sdkInt >= 34;
    }

    /**
     * Makes WindowManager move the window without an animation.
     *
     * A pane window follows the workspace page by page: it is moved on every frame of a scroll.
     * WindowState animates a move of a window whose size did not change (startMoveAnimation(),
     * when the window animations are on), and every new position restarts that animation, so the
     * pane keeps chasing its page and looks slower than the page does. That is what the Galaxy A55
     * (window animation scale 1x, 120 Hz) showed. The same animation also played for the first jump
     * of a new window from -10000 to its place.
     *
     * @return how it was done, for the log: "api", "privateFlags" or "unavailable: ..."
     */
    @SuppressLint("NewApi")
    public static String disableMoveAnimation(WindowManager.LayoutParams p) {
        if (usesPublicApi(Build.VERSION.SDK_INT)) {
            p.setCanPlayMoveAnimation(false);
            return "api";
        }
        try {
            // On the grey list: reachable by an app of the user as well (the 7870 runs Android 13).
            // The system app on the 7862 has no limits anyway.
            Field privateFlags = WindowManager.LayoutParams.class.getField("privateFlags");
            privateFlags.setInt(p, privateFlags.getInt(p) | PRIVATE_FLAG_NO_MOVE_ANIMATION);
            return "privateFlags";
        } catch (Throwable t) {
            return "unavailable: " + t;
        }
    }

    /**
     * Whether WindowManager takes a pane window's move without the caller waiting for it. From
     * Android 14 on ViewRootImpl sends a move that keeps the size as relayoutAsync(), a oneway call:
     * nothing holds the panes back when WindowManager falls behind, the moves queue up. The Galaxy
     * A55 handled 100-150 relayouts a second while the launcher sent about 190 (three panes and the
     * stats), and the panes came to the page's place 0.4-0.5 s after it (log 28-10-2026 01:22).
     * Before Android 14 relayout() waits for WindowManager, so no queue builds up.
     */
    static boolean relayoutIsAsync(int sdkInt) {
        return sdkInt >= 34;
    }

    /**
     * Whether a pane that was entirely beside the viewport (0 to viewportWidth) is so again at the
     * same size: moving its window would show nothing and only cost WindowManager a relayout. A
     * change of size is always passed on, so the pane does not resize while it comes into view.
     */
    static boolean staysOffScreen(int oldLeft, int oldRight, int newLeft, int newRight,
            boolean sameSize, int viewportWidth) {
        return sameSize && isOffScreen(oldLeft, oldRight, viewportWidth)
                && isOffScreen(newLeft, newRight, viewportWidth);
    }

    private static boolean isOffScreen(int left, int right, int viewportWidth) {
        return right <= 0 || left >= viewportWidth;
    }

    /**
     * Whether this many pane windows may be moved now when, together, they are to be moved at most
     * perSecond times a second, and were last moved at lastMoveMs (0: not yet). toleranceMs allows
     * for frames that come a little early.
     */
    static boolean withinRelayoutBudget(long nowMs, long lastMoveMs, int windows, int perSecond,
            long toleranceMs) {
        if (lastMoveMs <= 0 || windows <= 0) return true;
        return nowMs - lastMoveMs >= windows * 1000.0 / perSecond - toleranceMs;
    }
}
