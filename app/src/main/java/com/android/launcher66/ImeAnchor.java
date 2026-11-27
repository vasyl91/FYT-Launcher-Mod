package com.android.launcher66;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

/**
 * Keeps the keyboard above the launcher's bars and its statistics window (the owner on the 7862, 2026-11-27: the
 * keyboard opened from a PiP lay under the vertical and the horizontal bar).
 *
 * <p>Why it lay there (Android 10's window manager, DisplayContent.assignChildLayers and computeImeTarget; [A], read in
 * the code, no log of it): the keyboard is drawn just above its target window, and the target is the topmost window that
 * may take the input method (no FLAG_NOT_FOCUSABLE, or it together with FLAG_ALT_FOCUSABLE_IM). On the home screen that
 * is a pane of a PiP (its window has both flags) or the launcher's window; the bars and the statistics window are
 * sub-windows of the launcher's window in higher layers (BarWindows) and do not take the input method, so they lay
 * over the keyboard. No other type for the bars helps: every window above the target is above the keyboard.
 *
 * <p>The rules:
 * <ul>
 *   <li>A window of one pixel, transparent, that takes no touch and no focus but may take the input method, lies above
 *       every window of the launcher: in the layer of the bars ({@link BarWindows#EVERY_PAGE_TYPE}), added again after
 *       each window of that layer and after the statistics window, since within a layer the window added last is the
 *       highest. It is then the keyboard's target, and the keyboard is drawn above all of the launcher.</li>
 *   <li>It changes nothing else: the keyboard still types into the app that has the focus (the input method serves the
 *       focused window, not its target), and nothing is moved or hidden for it.</li>
 *   <li>Only on Android 10 and older ({@link #wanted}), where the PiP panes are ActivityViews and this was seen; Android 11
 *       and later keep their keyboard as before.</li>
 * </ul>
 * It goes with the launcher's window, as every sub-window does. Main thread.
 */
public final class ImeAnchor {

    private static final String TAG = "ImeAnchor";

    private static View sView;
    private static WindowManager sWindowManager;
    /** The Android version the rule is asked for: this device's (a test sets another). */
    static int sSdk = Build.VERSION.SDK_INT;

    private ImeAnchor() {
    }

    /** Whether the anchor is used on this Android version. */
    static boolean wanted(int sdk) {
        return sdk <= Build.VERSION_CODES.Q;
    }

    /**
     * A window of the bars' layer or the statistics window was just added: the anchor is put above it, with the same
     * window manager and parent ({@code token} may be null, the window manager of the launcher gives its own).
     */
    public static void raise(WindowManager windowManager, Context context, IBinder token) {
        if (!wanted(sSdk) || windowManager == null || context == null) {
            return;
        }
        remove();
        View view = new View(context.getApplicationContext());
        view.setWillNotDraw(true);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(1, 1, BarWindows.EVERY_PAGE_TYPE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.LEFT;
        params.windowAnimations = 0;
        params.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_STATE_UNCHANGED
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
        params.token = token;
        params.setTitle(TAG);
        try {
            windowManager.addView(view, params);
            sView = view;
            sWindowManager = windowManager;
        } catch (RuntimeException e) {
            Log.w(TAG, "The keyboard's anchor could not be added: the keyboard may lie under the bars (" + e + ")");
        }
    }

    /** The anchor goes (it is added again above the next window). */
    static void remove() {
        View view = sView;
        WindowManager windowManager = sWindowManager;
        sView = null;
        sWindowManager = null;
        // Removed whenever it was added, not only once it is attached: that is at the next frame, and two bars added
        // in one go would leave two anchors. The launcher's window may have taken it with it already (it throws then).
        if (view != null && windowManager != null) {
            try {
                windowManager.removeViewImmediate(view);
            } catch (RuntimeException e) {
                Log.d(TAG, "The keyboard's anchor was gone already: " + e);
            }
        }
    }

    /** Whether the anchor is there now (a test asks). */
    static boolean isUp() {
        return sView != null;
    }
}
