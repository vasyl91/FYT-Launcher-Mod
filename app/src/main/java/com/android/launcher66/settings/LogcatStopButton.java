package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;

/**
 * The "Stop logcat" button over every screen, for a capture the user started by hand (Tap to start logging
 * in the settings): the settings are covered by the app the user goes on to try, and the capture should end
 * where the problem happened, not when the user is back in the settings. It is a window of the application
 * (no service), main thread only, and it goes when the capture ends, however it ends. It can be dragged,
 * the way the floating buttons of FabOverlayService can, and remembers where it was left.
 *
 * It does not take the focus (FLAG_NOT_FOCUSABLE): the app under it keeps it.
 */
final class LogcatStopButton implements LogcatWorker.CaptureEndListener {

    private static final String TAG = "LogcatStopButton";
    /** The corner radius as a share of the button's height. */
    private static final float CORNER_FRACTION = 0.25f;
    /** The biggest text, as a share of the button's height. */
    private static final float TEXT_FRACTION = 0.3f;

    /** The one button, if it is shown; main thread. */
    private static LogcatStopButton sInstance;

    private final Context app;
    private final WindowManager windowManager;
    private final SharedPreferences prefs;
    private final TextView view;
    private final WindowManager.LayoutParams params;
    private final GradientDrawable background = new GradientDrawable();

    private int width;
    private int height;
    private int screenWidth;
    private int screenHeight;
    private int statusBarHeight;
    private int touchSlopPx;

    private float downRawX;
    private float downRawY;
    private int downWindowX;
    private int downWindowY;
    private boolean dragging;
    private boolean reanchor;
    private boolean added;

    private final ComponentCallbacks configurationCallbacks = new ComponentCallbacks() {
        @Override
        public void onConfigurationChanged(Configuration newConfig) {
            LogcatStopButton.this.onConfigurationChanged();
        }

        @Override
        public void onLowMemory() {
        }
    };

    /**
     * Shows the button if a capture started by hand is running and the "display over other apps" permission is
     * there; nothing otherwise, and nothing if it is shown already. Main thread.
     */
    static void show(Context context) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(() -> show(context));
            return;
        }
        final Context app = context.getApplicationContext();
        if (sInstance != null || !LogcatWorker.get().isManualCapture()) {
            return;
        }
        if (!Settings.canDrawOverlays(app)) {
            Log.w(TAG, "No permission to display over other apps: no stop button");
            return;
        }
        LogcatStopButton button = new LogcatStopButton(app);
        if (button.add()) {
            sInstance = button;
        }
    }

    /** Takes the button away, if it is shown. Main thread. */
    static void hide() {
        LogcatStopButton button = sInstance;
        sInstance = null;
        if (button != null) {
            button.remove();
        }
    }

    @Override
    public void onCaptureEnded() {
        if (sInstance == this) {
            hide();
        } else {
            remove();
        }
    }

    @SuppressLint("ClickableViewAccessibility") // performClick() is called for taps below
    private LogcatStopButton(Context app) {
        this.app = app;
        this.windowManager = (WindowManager) app.getSystemService(Context.WINDOW_SERVICE);
        this.prefs = PreferenceManager.getDefaultSharedPreferences(app);
        refreshMetrics();

        view = new TextView(app);
        view.setText(R.string.logcat_stop_button);
        view.setGravity(Gravity.CENTER);
        view.setSingleLine(true);
        view.setTypeface(Typeface.DEFAULT_BOLD);
        view.setTextColor(ContextCompat.getColor(app, R.color.logcat_stop_text));
        int black = ContextCompat.getColor(app, R.color.black);
        background.setColor(ColorUtils.setAlphaComponent(black, (int) (255 * FabOverlayService.BACKGROUND_ALPHA)));
        view.setBackground(background);
        applySize();

        params = new WindowManager.LayoutParams(
                width,
                height,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        // x/y from the top-left corner, also in right-to-left languages
        params.gravity = Gravity.TOP | Gravity.LEFT;
        // The position before addView(), so the button never shows up at a spot it then leaves
        resolvePosition();

        view.setOnClickListener(v -> onClicked());
        view.setOnTouchListener((v, event) -> {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    downRawX = event.getRawX();
                    downRawY = event.getRawY();
                    downWindowX = params.x;
                    downWindowY = params.y;
                    dragging = false;
                    reanchor = false;
                    return true;

                case MotionEvent.ACTION_POINTER_DOWN:
                case MotionEvent.ACTION_POINTER_UP:
                    // The raw coordinates follow the first finger of the event, which changes when
                    // that one is lifted: a new reference point, or the button would jump.
                    reanchor = true;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    trackFinger(event);
                    return true;

                case MotionEvent.ACTION_UP:
                    // The final position of the finger can differ from that of the last MOVE
                    trackFinger(event);
                    if (dragging) {
                        dragging = false;
                        savePosition();
                    } else if (event.getEventTime() - event.getDownTime() < ViewConfiguration.getLongPressTimeout()) {
                        v.performClick();
                    }
                    // A long press without movement does nothing
                    return true;

                case MotionEvent.ACTION_CANCEL:
                    if (dragging) {
                        dragging = false;
                        savePosition();
                    }
                    return true;

                default:
                    return false;
            }
        });
    }

    private boolean add() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                FabOverlayService.excludeFromSystemGestures(view);
            }
            windowManager.addView(view, params);
            added = true;
        } catch (RuntimeException e) {
            // E.g. BadTokenException when the permission is gone
            Log.e(TAG, "Unable to add the stop button", e);
            return false;
        }
        LogcatWorker.get().addCaptureEndListener(this);
        app.registerComponentCallbacks(configurationCallbacks);
        return true;
    }

    private void remove() {
        LogcatWorker.get().removeCaptureEndListener(this);
        app.unregisterComponentCallbacks(configurationCallbacks);
        if (!added) {
            return;
        }
        added = false;
        try {
            windowManager.removeViewImmediate(view);
        } catch (RuntimeException e) {
            Log.w(TAG, "Failed to remove the stop button", e);
        }
    }

    /** Stops the capture the way the run button of the settings does; the button goes with onCaptureEnded(). */
    private void onClicked() {
        view.setEnabled(false);
        LogcatWorker.get().stop(true, app);
    }

    // ---- Size and position -----------------------------------------------------------------

    private void refreshMetrics() {
        DisplayMetrics dm = app.getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        statusBarHeight = FabOverlayService.statusBarHeightPx(app);
        height = FabOverlayService.fabSizePx(app);
        width = 2 * height;
        touchSlopPx = ViewConfiguration.get(app).getScaledTouchSlop();
    }

    /** The text and the corners follow the size of the button. */
    private void applySize() {
        background.setCornerRadius(height * CORNER_FRACTION);
        int max = Math.max(2, Math.round(height * TEXT_FRACTION));
        view.setAutoSizeTextTypeUniformWithConfiguration(Math.max(1, max / 3), max, 1, TypedValue.COMPLEX_UNIT_PX);
    }

    private void onConfigurationChanged() {
        if (!added) {
            return;
        }
        refreshMetrics();
        applySize();
        params.width = width;
        params.height = height;
        if (dragging) {
            // Under the finger: only kept on the screen
            params.x = clampX(params.x);
            params.y = clampY(params.y);
        } else {
            resolvePosition();
        }
        updateViewLayoutSafely();
    }

    /** Where the user left it, else centred at the top, below the status bar. */
    private void resolvePosition() {
        if (prefs.getBoolean(Keys.LOGCAT_STOP_SAVED, false)) {
            float x = readFloatPref(Keys.LOGCAT_STOP_X);
            float y = readFloatPref(Keys.LOGCAT_STOP_Y);
            if (!Float.isNaN(x) && !Float.isNaN(y) && x >= 0f && y >= 0f) {
                params.x = clampX(Math.round(x));
                params.y = clampY(Math.round(y));
                return;
            }
        }
        params.x = clampX((screenWidth - width) / 2);
        params.y = clampY(statusBarHeight);
    }

    private int clampX(int x) {
        return Math.max(0, Math.min(x, screenWidth - width));
    }

    private int clampY(int y) {
        return Math.max(statusBarHeight, Math.min(y, screenHeight - height));
    }

    private float readFloatPref(String key) {
        try {
            return prefs.getFloat(key, -1f);
        } catch (ClassCastException e) {
            // Stored with another type: missing
            return -1f;
        }
    }

    private void savePosition() {
        prefs.edit()
                .putFloat(Keys.LOGCAT_STOP_X, params.x)
                .putFloat(Keys.LOGCAT_STOP_Y, params.y)
                .putBoolean(Keys.LOGCAT_STOP_SAVED, true)
                .apply();
    }

    private void updateViewLayoutSafely() {
        if (!added) {
            return;
        }
        try {
            windowManager.updateViewLayout(view, params);
        } catch (IllegalArgumentException e) {
            // The view is no longer attached to the window manager
            Log.w(TAG, "updateViewLayout failed for the stop button", e);
        }
    }

    // ---- Dragging ---------------------------------------------------------------------------

    /** Starts a drag once the finger leaves the touch slop, then moves the button with it. */
    private void trackFinger(MotionEvent event) {
        if (reanchor) {
            reanchor = false;
            downRawX = event.getRawX();
            downRawY = event.getRawY();
            downWindowX = params.x;
            downWindowY = params.y;
            return;
        }
        float dx = event.getRawX() - downRawX;
        float dy = event.getRawY() - downRawY;
        if (!dragging && dx * dx + dy * dy > (float) touchSlopPx * touchSlopPx) {
            dragging = true;
        }
        if (!dragging) {
            return;
        }
        // Relative to the DOWN position, so the grabbed point stays under the finger
        int x = clampX(Math.round(downWindowX + dx));
        int y = clampY(Math.round(downWindowY + dy));
        if (x != params.x || y != params.y) {
            params.x = x;
            params.y = y;
            updateViewLayoutSafely();
        }
    }
}
