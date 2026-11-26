package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.FrameLayout;

/**
 * A black window over the whole screen at the least brightness: the double tap "Turn off screen" on a device that has
 * no command of its own for it (anything but an FYT unit with its main module, {@link ScreenOffPlan}).
 *
 * <p>The rules: it is an application overlay of the full screen, focusable (without focus the brightness of the window
 * does nothing) and keeps the screen on, with the system bars hidden; single touches are swallowed, and a double tap on it
 * ({@link DoubleTap}, the system's timing) closes it. It goes at once when the screen is turned off by the power button
 * ({@code ACTION_SCREEN_OFF}), so that the device does not wake black. It never locks the device, puts it to sleep or
 * wakes it. Opening and closing are logged. Main thread only.
 */
final class ScreenOffOverlay {

    private static final String TAG = "ScreenOffOverlay";

    private static ScreenOffOverlay sShown;

    private final Context mContext;
    private final WindowManager mWindowManager;
    private final DoubleTap mDoubleTap = new DoubleTap();
    private View mView;
    private BroadcastReceiver mScreenOffReceiver;

    private ScreenOffOverlay(Context context) {
        mContext = context.getApplicationContext();
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    }

    /** Shows the black window; nothing happens when it is shown already or cannot be added. */
    static void show(Context context) {
        if (sShown != null) {
            return;
        }
        ScreenOffOverlay overlay = new ScreenOffOverlay(context);
        if (overlay.add()) {
            sShown = overlay;
        }
    }

    /** Closes it, when it is shown. */
    static void hide() {
        if (sShown != null) {
            sShown.remove("closed");
            sShown = null;
        }
    }

    private boolean add() {
        final ViewConfiguration configuration = ViewConfiguration.get(mContext);
        FrameLayout black = new FrameLayout(mContext) {
            @Override
            public boolean onTouchEvent(MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_UP) {
                    if (mDoubleTap.onTap(event.getEventTime(), event.getX(), event.getY(),
                            ViewConfiguration.getDoubleTapTimeout(), configuration.getScaledDoubleTapSlop())) {
                        hide();
                    }
                }
                return true;   // swallowed: nothing under the window gets a touch
            }

            @Override
            protected void onAttachedToWindow() {
                super.onAttachedToWindow();
                hideSystemBars(this);
            }
        };
        black.setBackgroundColor(Color.BLACK);
        black.setFocusable(true);
        black.setFocusableInTouchMode(true);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT,
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
                        ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                        : WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                        | WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.OPAQUE);
        params.screenBrightness = 0f;
        try {
            mWindowManager.addView(black, params);
        } catch (RuntimeException e) {
            Log.w(TAG, "The black window could not be added", e);
            return false;
        }
        mView = black;
        mScreenOffReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // The user put the device to sleep: it does not wake black
                hide();
            }
        };
        mContext.registerReceiver(mScreenOffReceiver, new IntentFilter(Intent.ACTION_SCREEN_OFF));
        Log.i(TAG, "Home double tap: the black window is up, a double tap on it closes it");
        return true;
    }

    private void remove(String why) {
        if (mScreenOffReceiver != null) {
            try {
                mContext.unregisterReceiver(mScreenOffReceiver);
            } catch (IllegalArgumentException alreadyGone) {
                // not registered any more
            }
            mScreenOffReceiver = null;
        }
        if (mView != null) {
            try {
                mWindowManager.removeView(mView);
            } catch (RuntimeException alreadyGone) {
                // the window went with its process
            }
            mView = null;
        }
        Log.i(TAG, "The black window " + why);
    }

    private static void hideSystemBars(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsetsController controller = view.getWindowInsetsController();
            if (controller != null) {
                controller.hide(WindowInsets.Type.systemBars());
                controller.setSystemBarsBehavior(WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
            }
        } else {
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
