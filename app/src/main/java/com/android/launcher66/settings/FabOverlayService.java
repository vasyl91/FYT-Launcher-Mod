package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.syu.util.WindowUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Shows up to three draggable overlay buttons that swap PiP panes:
 * <ul>
 *     <li>main  - swaps all panes,</li>
 *     <li>left  - swaps the left pane with the third one,</li>
 *     <li>right - swaps the right pane with the fourth one.</li>
 * </ul>
 * Buttons the user has never moved are placed in one column flush against the right screen edge
 * and spread evenly over the usable height. A button that was dragged keeps its saved position.
 */
public class FabOverlayService extends Service {

    private static final String TAG = "FabOverlayService";

    // ---- Button size -----------------------------------------------------------------------

    /**
     * Button size as a fraction of the shorter screen side, see {@link #computeFabSizePx()}.
     * This single value makes the buttons bigger or smaller on every screen.
     */
    private static final float FAB_SIZE_SCREEN_FRACTION = 0.08f;
    /** Lower limit for small screens or unusual configurations. */
    private static final float FAB_MIN_SIZE_DP = 40f;

    // ---- Look ------------------------------------------------------------------------------

    /** Opacity of the black button background (0..1). */
    private static final float BACKGROUND_ALPHA = 0.5f;

    // ---- Click blocking --------------------------------------------------------------------

    /** Clicks are ignored for this long after a swap, so the panes can settle. */
    private static final long BLOCK_AFTER_CLICK_MS = 3000L;
    /** Clicks are ignored for this long after a BLOCK_FLOATING_BUTTON broadcast. */
    private static final long BLOCK_ON_REQUEST_MS = 5000L;

    // ---- Clean-up of positions stored by older versions ------------------------------------

    /** Marker: the one-time clean-up in {@link #migrateLegacyPositions()} has been done. */
    private static final String PREF_LEGACY_POSITIONS_MIGRATED =
            "fab_overlay_legacy_positions_migrated";
    /** y coordinate (px) of the default position used by older versions. */
    private static final float LEGACY_DEFAULT_Y_PX = 100f;
    /** Finger jitter (px) that older versions stored together with that position. */
    private static final float LEGACY_DEFAULT_Y_TOLERANCE_PX = 10f;

    private WindowManager windowManager;
    private SharedPreferences prefs;
    private ContextThemeWrapper themedContext;
    private boolean isReceiverRegistered = false;

    // Settings, read once in onCreate()
    private boolean floatingBtn = false;
    private boolean floatingBtnLeft = false;
    private boolean floatingBtnRight = false;
    private boolean dualPip = false;
    private boolean firstPip = false;
    private boolean secondPip = false;
    private boolean thirdPip = false;
    private boolean fourthPip = false;
    private boolean firstPipPinned = false;
    private boolean secondPipPinned = false;
    private boolean thirdPipPinned = false;
    private boolean fourthPipPinned = false;

    private OverlayFab mainFab;
    private OverlayFab leftFab;
    private OverlayFab rightFab;
    /** Buttons enabled in the settings. The list order is the top-to-bottom default order. */
    private final List<OverlayFab> activeFabs = new ArrayList<>();

    // Screen metrics in px, refreshed on every configuration change
    private float density = 1f;
    private int screenWidth;
    private int screenHeight;
    private int statusBarHeight;
    private int fabSizePx;
    private int touchSlopPx;

    /** Uptime (ms) until which clicks are ignored, see {@link #blockFor(long)}. */
    private long blockedUntilUptimeMs = 0L;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        themedContext = new ContextThemeWrapper(this, R.style.AppTheme);
        readSettings();
        refreshScreenMetrics();

        mainFab = new OverlayFab("main", R.drawable.ic_switch_pips,
                Keys.KEY_FAB_X, Keys.KEY_FAB_Y, Keys.KEY_POSITION_SAVED,
                () -> WindowUtil.swapAllPanes());
        leftFab = new OverlayFab("left", R.drawable.ic_switch_pips_left,
                Keys.KEY_FAB_X_LEFT, Keys.KEY_FAB_Y_LEFT, Keys.KEY_POSITION_SAVED_LEFT,
                () -> WindowUtil.swapLeftAndThird());
        rightFab = new OverlayFab("right", R.drawable.ic_switch_pips_right,
                Keys.KEY_FAB_X_RIGHT, Keys.KEY_FAB_Y_RIGHT, Keys.KEY_POSITION_SAVED_RIGHT,
                () -> WindowUtil.swapRightAndFourth());

        migrateLegacyPositions();

        // The complete list has to be known before the first button is placed, because the
        // default layout depends on the number of active buttons.
        if (isFloatingButton()) {
            activeFabs.add(mainFab);
        }
        if (isFloatingButtonLeft()) {
            activeFabs.add(leftFab);
        }
        if (isFloatingButtonRight()) {
            activeFabs.add(rightFab);
        }
        for (OverlayFab fab : activeFabs) {
            addOverlay(fab);
        }

        // The buttons belong on the screen only together with the PiP panes. The launcher starts
        // this service only while they are up, but a START_STICKY restart after the process was
        // killed comes without it and used to put the buttons over whatever app was in front.
        // Hidden before their first frame; SHOW_FAB brings them up once the panes are there.
        if (!isPipShownByLauncher()) {
            hideFab();
        }

        // Registered even if adding a button failed, so SHOW/HIDE/BLOCK broadcasts never
        // reach a half-initialised service that then crashes.
        registerFabReceiver();
    }

    /** Same rule the launcher applies before it shows the buttons, see Launcher.canShowOverlayFab(). */
    private static boolean isPipShownByLauncher() {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null) {
            return false;
        }
        try {
            return launcher.canShowOverlayFab();
        } catch (RuntimeException e) {
            Log.w(TAG, "Unable to query the launcher state, keeping the buttons hidden", e);
            return false;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    /**
     * Rotation, a resolution change or a density change ("display size") would otherwise leave
     * the buttons with a stale size, or even outside the screen, because the service is not
     * recreated on configuration changes.
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        refreshScreenMetrics();
        for (OverlayFab fab : activeFabs) {
            if (!fab.added) {
                continue;
            }
            fab.params.width = fabSizePx;
            fab.params.height = fabSizePx;
            if (fab.dragging) {
                // Leave the button under the finger, only keep it on the screen.
                fab.params.x = clampX(fab.params.x);
                fab.params.y = clampY(fab.params.y);
            } else {
                resolvePosition(fab);
            }
            updateViewLayoutSafely(fab);
        }
    }

    // ---- Settings --------------------------------------------------------------------------

    private void readSettings() {
        floatingBtn = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON, false);
        floatingBtnLeft = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_LEFT, false);
        floatingBtnRight = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_RIGHT, false);
        dualPip = prefs.getBoolean(Keys.PIP_DUAL, false);
        firstPip = prefs.getBoolean(Keys.PIP_FIRST, false);
        secondPip = prefs.getBoolean(Keys.PIP_SECOND, false);
        thirdPip = prefs.getBoolean(Keys.PIP_THIRD, false);
        fourthPip = prefs.getBoolean(Keys.PIP_FOURTH, false);
        firstPipPinned = prefs.getBoolean(Keys.PIP_FIRST_MODE, false);
        secondPipPinned = prefs.getBoolean(Keys.PIP_SECOND_MODE, false);
        thirdPipPinned = prefs.getBoolean(Keys.PIP_THIRD_MODE, false);
        fourthPipPinned = prefs.getBoolean(Keys.PIP_FOURTH_MODE, false);
    }

    private boolean isFloatingButton() {
        if (!floatingBtn) return false;
        return (dualPip || (firstPip && !firstPipPinned && secondPip && !secondPipPinned))
                && thirdPip && fourthPip && !thirdPipPinned && !fourthPipPinned;
    }

    private boolean isFloatingButtonLeft() {
        if (!floatingBtnLeft) return false;
        return (dualPip || (firstPip && !firstPipPinned)) && thirdPip && !thirdPipPinned;
    }

    private boolean isFloatingButtonRight() {
        if (!floatingBtnRight) return false;
        return (dualPip || (secondPip && !secondPipPinned)) && fourthPip && !fourthPipPinned;
    }

    // ---- Screen metrics and button size ----------------------------------------------------

    /**
     * Reads the current screen metrics. Called on creation and on every configuration change.
     * <p>
     * The DisplayMetrics of the service describe the area available to application windows
     * (full height including the status bar, minus the navigation bar). That matches the
     * coordinate space of these overlays (TOP|START gravity, FLAG_LAYOUT_IN_SCREEN), and the
     * values are already updated when onConfigurationChanged() runs, unlike values cached once
     * at application start.
     */
    private void refreshScreenMetrics() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        density = dm.density > 0f ? dm.density : 1f;
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;
        statusBarHeight = getStatusBarHeight();
        touchSlopPx = ViewConfiguration.get(this).getScaledTouchSlop();
        fabSizePx = computeFabSizePx();
    }

    /**
     * Button size in px: a fixed share of the shorter screen side, whatever the density setting.
     * <p>
     * Car head units often run a density setting unrelated to the pixel density of the panel
     * (e.g. 160 dpi on a 2000x1200 screen). An upper limit in dp follows that setting instead of
     * the screen: a 64dp limit, for example, allows only 64 px there, about 5% of the height.
     * A share of the screen gives about the same physical size on screens of the same physical
     * size, whatever their resolution, so the button can neither shrink nor grow out of
     * proportion on high-resolution screens (the original code multiplied the size by 1.5 above
     * density 1.5). Taking the shorter side directly does not depend on the orientation.
     */
    private int computeFabSizePx() {
        int shorterSide = Math.min(screenWidth, screenHeight);
        int size = Math.round(shorterSide * FAB_SIZE_SCREEN_FRACTION);
        return Math.max(dpToPx(FAB_MIN_SIZE_DP), size);
    }

    // ---- Overlay creation ------------------------------------------------------------------

    private void addOverlay(OverlayFab fab) {
        try {
            fab.view = createFabView(fab.iconRes);
            fab.params = createLayoutParams();
            // Position is computed before addView(), so the button never shows up at a
            // temporary spot and then jumps (the old code moved it in a post() callback).
            resolvePosition(fab);
            attachTouchHandler(fab);
            fab.view.setOnClickListener(v -> onFabClicked(fab));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                excludeFromSystemGestures(fab.view);
            }
            windowManager.addView(fab.view, fab.params);
            fab.added = true;
        } catch (RuntimeException e) {
            // E.g. BadTokenException when the "display over other apps" permission is missing.
            // One failing button must not crash the launcher process (with START_STICKY that
            // would also turn into a restart loop).
            Log.e(TAG, "Unable to add the " + fab.name + " overlay button", e);
            fab.added = false;
            return;
        }

        // Re-apply the flat look after the first layout pass (kept from the original code as a
        // safety net in case the widget restores its defaults while being attached).
        fab.view.post(() -> {
            if (!fab.added) {
                return; // Removed in the meantime (e.g. service destroyed right after start).
            }
            fab.view.setPadding(0, 0, 0, 0);
            applyFlatStyle(fab.view);
            fab.view.invalidate();
            fab.view.requestLayout();
        });
    }

    private FloatingActionButton createFabView(@DrawableRes int iconRes) {
        FloatingActionButton fab = new FloatingActionButton(themedContext);
        fab.setPadding(0, 0, 0, 0);
        fab.setScaleType(ImageView.ScaleType.FIT_CENTER);
        fab.setImageResource(iconRes);

        int black = ContextCompat.getColor(this, R.color.black);
        int blackWithAlpha = ColorUtils.setAlphaComponent(black, (int) (255 * BACKGROUND_ALPHA));
        fab.setBackgroundTintList(ColorStateList.valueOf(blackWithAlpha));
        fab.setSize(FloatingActionButton.SIZE_MINI);

        // The window manager gives an overlay window the measured size of its view. Depending on
        // the theme (e.g. Material Components), a mini FAB adds a transparent ring around the
        // circle to reach the 48dp minimum touch target, so the window would end up a few dp
        // bigger than fabSizePx and the visible circle would sit off the computed position:
        // cut off at the right and bottom edges, with a gap at the left and top edges. Without
        // the ring the window, the view and the visible circle are all exactly fabSizePx.
        fab.setEnsureMinTouchTargetSize(false);

        // Applied before the first frame, so no default shadow flashes up.
        applyFlatStyle(fab);
        return fab;
    }

    @SuppressLint("RtlHardcoded") // Window coordinates are always measured from the left.
    private WindowManager.LayoutParams createLayoutParams() {
        // Fixed size: the view is measured with exactly this size (see createFabView() for why
        // the window does not grow beyond it). FLAG_LAYOUT_NO_LIMITS lets the window leave the
        // screen, which is why every position goes through clampX()/clampY().
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                fabSizePx,
                fabSizePx,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                        | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT);
        // x/y are offsets from the top-left corner. LEFT instead of START makes sure this also
        // holds for right-to-left languages, since all the position math assumes it.
        lp.gravity = Gravity.TOP | Gravity.LEFT;
        return lp;
    }

    /**
     * With gesture navigation, a swipe that starts at the left or right screen edge is the
     * system "back" gesture. The default column is flush with the right edge, so a drag started
     * on the outer part of a button could trigger "back" instead of moving the button. The
     * button area is excluded from those gestures. The system honours at most 200dp per edge,
     * so with a very low density setting part of the column may stay unprotected; nothing
     * else changes in that case.
     */
    @RequiresApi(Build.VERSION_CODES.Q)
    private static void excludeFromSystemGestures(View view) {
        view.addOnLayoutChangeListener((v, left, top, right, bottom,
                                        oldLeft, oldTop, oldRight, oldBottom) ->
                v.setSystemGestureExclusionRects(Collections.singletonList(
                        new Rect(0, 0, right - left, bottom - top))));
    }

    private static void applyFlatStyle(FloatingActionButton fab) {
        fab.setElevation(0f);
        fab.setCompatElevation(0f);
        fab.setTranslationZ(0f);
        fab.setUseCompatPadding(false);
        fab.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
    }

    // ---- Positioning -----------------------------------------------------------------------

    /**
     * Places the button at its saved position or, if the user has never moved it, in its slot
     * of the default layout. Dragging, restoring and the default layout all share the same
     * bounds (clampX()/clampY()), so a saved position no longer shifts after a restart.
     */
    private void resolvePosition(OverlayFab fab) {
        if (!applySavedPosition(fab)) {
            applyDefaultPosition(fab);
        }
    }

    private boolean applySavedPosition(OverlayFab fab) {
        if (!prefs.getBoolean(fab.keySaved, false)) {
            return false;
        }
        float x = readFloatPref(fab.keyX);
        float y = readFloatPref(fab.keyY);
        if (isInvalidPosition(x, y)) {
            return false;
        }
        fab.params.x = clampX(Math.round(x));
        fab.params.y = clampY(Math.round(y));
        return true;
    }

    /**
     * Default layout: every active button in one column touching the right screen edge, spread
     * over the usable height (below the status bar) with equal gaps above, between and below
     * them.
     * <p>
     * Slots are assigned to all active buttons, including the ones the user has moved, so
     * moving one button never shifts the others on the next start.
     */
    private void applyDefaultPosition(OverlayFab fab) {
        int count = Math.max(1, activeFabs.size());
        int slot = Math.max(0, activeFabs.indexOf(fab));

        int top = statusBarHeight;
        int usableHeight = Math.max(0, screenHeight - top);
        float gap = Math.max(0f, (usableHeight - count * fabSizePx) / (float) (count + 1));

        // Flush with the right edge: the right side of the button is the right side of the screen.
        fab.params.x = clampX(screenWidth - fabSizePx);
        fab.params.y = clampY(Math.round(top + gap + slot * (fabSizePx + gap)));
    }

    /** Keeps the button horizontally inside the screen. */
    private int clampX(int x) {
        return Math.max(0, Math.min(x, screenWidth - fabSizePx));
    }

    /** Keeps the button below the status bar and above the bottom edge of the usable area. */
    private int clampY(int y) {
        return Math.max(statusBarHeight, Math.min(y, screenHeight - fabSizePx));
    }

    private void savePosition(OverlayFab fab) {
        // Stored as float to stay compatible with positions saved by earlier versions.
        prefs.edit()
                .putFloat(fab.keyX, fab.params.x)
                .putFloat(fab.keyY, fab.params.y)
                .putBoolean(fab.keySaved, true)
                .apply();
    }

    private float readFloatPref(String key) {
        try {
            return prefs.getFloat(key, -1f);
        } catch (ClassCastException e) {
            // Value stored with a different type; treat it as missing.
            return -1f;
        }
    }

    private static boolean isInvalidPosition(float x, float y) {
        // Valid positions are never negative, because they always pass clampX()/clampY().
        return Float.isNaN(x) || Float.isNaN(y) || x < 0f || y < 0f;
    }

    private void updateViewLayoutSafely(OverlayFab fab) {
        if (!fab.added || windowManager == null) {
            return;
        }
        try {
            windowManager.updateViewLayout(fab.view, fab.params);
        } catch (IllegalArgumentException e) {
            // The view is no longer attached to the window manager.
            Log.w(TAG, "updateViewLayout failed for the " + fab.name + " button", e);
        }
    }

    // ---- Touch handling --------------------------------------------------------------------

    /**
     * Tap vs. drag detection. The touch state lives in each OverlayFab instead of fields shared
     * by all three buttons, so simultaneous touches on two buttons cannot mix up their state.
     * <p>
     * The old version treated a touch as a drag as soon as a single ACTION_MOVE arrived. Almost
     * every tap produces some ACTION_MOVE events (finger jitter, especially in a moving car), so
     * taps were often ignored and saved as a "new" position instead. Now a drag starts only
     * after the finger has moved beyond the system touch slop.
     */
    @SuppressLint("ClickableViewAccessibility") // performClick() is called for taps below
    private void attachTouchHandler(OverlayFab fab) {
        fab.view.setOnTouchListener((v, event) -> {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    fab.downRawX = event.getRawX();
                    fab.downRawY = event.getRawY();
                    fab.downWindowX = fab.params.x;
                    fab.downWindowY = fab.params.y;
                    fab.dragging = false;
                    fab.reanchor = false;
                    return true;

                case MotionEvent.ACTION_POINTER_DOWN:
                case MotionEvent.ACTION_POINTER_UP:
                    // getRawX()/getRawY() follow the first finger listed in the event, which
                    // changes when that finger is lifted while another one stays down. Measuring
                    // from the old reference point would make the button jump by the distance
                    // between the fingers, so the next event starts a new reference point.
                    fab.reanchor = true;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    trackFinger(fab, event);
                    return true;

                case MotionEvent.ACTION_UP:
                    // The UP event carries the final finger position, which can differ from the
                    // last MOVE (or be the only movement at all on touch panels with a low report
                    // rate). Without this, such a swipe would count as a tap.
                    trackFinger(fab, event);
                    if (fab.dragging) {
                        fab.dragging = false;
                        onDragFinished(fab);
                    } else if (event.getEventTime() - event.getDownTime()
                            < ViewConfiguration.getLongPressTimeout()) {
                        v.performClick();
                    }
                    // A long press without movement is neither a tap nor a drag: nothing happens
                    // and, unlike before, no position gets saved.
                    return true;

                case MotionEvent.ACTION_CANCEL:
                    // The gesture was taken away (e.g. the buttons were hidden mid-drag).
                    // Keep the button where it ended up.
                    if (fab.dragging) {
                        fab.dragging = false;
                        onDragFinished(fab);
                    }
                    return true;

                default:
                    return false;
            }
        });
    }

    /** Starts a drag once the finger leaves the touch slop, then moves the button with it. */
    private void trackFinger(OverlayFab fab, MotionEvent event) {
        if (fab.reanchor) {
            fab.reanchor = false;
            fab.downRawX = event.getRawX();
            fab.downRawY = event.getRawY();
            fab.downWindowX = fab.params.x;
            fab.downWindowY = fab.params.y;
            return;
        }
        float dx = event.getRawX() - fab.downRawX;
        float dy = event.getRawY() - fab.downRawY;
        if (!fab.dragging && dx * dx + dy * dy > (float) touchSlopPx * touchSlopPx) {
            fab.dragging = true;
        }
        if (!fab.dragging) {
            return;
        }
        // Relative to the DOWN position, so the grabbed point stays under the finger.
        int x = clampX(Math.round(fab.downWindowX + dx));
        int y = clampY(Math.round(fab.downWindowY + dy));
        if (x != fab.params.x || y != fab.params.y) {
            fab.params.x = x;
            fab.params.y = y;
            updateViewLayoutSafely(fab);
        }
    }

    private void onDragFinished(OverlayFab fab) {
        applyFlatStyle(fab.view);
        savePosition(fab);
    }

    // ---- Click handling --------------------------------------------------------------------

    private void onFabClicked(OverlayFab fab) {
        if (SystemClock.uptimeMillis() < blockedUntilUptimeMs) {
            return;
        }
        blockFor(BLOCK_AFTER_CLICK_MS);
        try {
            fab.action.run();
        } catch (RuntimeException e) {
            // An exception thrown from a click handler would crash the whole launcher.
            Log.e(TAG, "Swap action of the " + fab.name + " button failed", e);
        }
    }

    /**
     * Ignores clicks for the given time. The block is only ever extended, never shortened.
     * The old version posted a separate "unblock" callback for every block, so the 3 s callback
     * of an earlier click could cancel a later 5 s block too early.
     */
    private void blockFor(long durationMs) {
        blockedUntilUptimeMs = Math.max(blockedUntilUptimeMs,
                SystemClock.uptimeMillis() + durationMs);
    }

    // ---- Visibility ------------------------------------------------------------------------

    /**
     * Show the FABs.
     */
    public void showFab() {
        setOverlayVisibility(View.VISIBLE);
    }

    /**
     * Hide the FABs.
     */
    public void hideFab() {
        setOverlayVisibility(View.GONE);
    }

    private void setOverlayVisibility(int visibility) {
        for (OverlayFab fab : activeFabs) {
            if (fab.added && fab.view.getVisibility() != visibility) {
                fab.view.setVisibility(visibility);
            }
        }
    }

    // ---- Broadcasts ------------------------------------------------------------------------

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void registerFabReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Keys.SHOW_FAB);
        filter.addAction(Keys.HIDE_FAB);
        filter.addAction(Keys.BLOCK_FLOATING_BUTTON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Exported as before. If all senders live in this app, RECEIVER_NOT_EXPORTED is
            // safer: an exported receiver lets any installed app hide or block the buttons.
            registerReceiver(fabReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(fabReceiver, filter);
        }
        isReceiverRegistered = true;
    }

    private final BroadcastReceiver fabReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action == null) {
                return;
            }
            try {
                switch (action) {
                    case Keys.SHOW_FAB:
                        showFab();
                        break;
                    case Keys.HIDE_FAB:
                        hideFab();
                        break;
                    case Keys.BLOCK_FLOATING_BUTTON:
                        // Sent from startMapPip() to let the view settle before switching PiPs
                        // is possible again.
                        blockFor(BLOCK_ON_REQUEST_MS);
                        break;
                    default:
                        break;
                }
            } catch (RuntimeException e) {
                Log.e(TAG, "Error handling broadcast " + action, e);
            }
        }
    };

    // ---- Migration -------------------------------------------------------------------------

    /**
     * One-time clean-up of positions stored by older versions of this service.
     * <p>
     * Those versions saved the position after almost every tap (any ACTION_MOVE or a press
     * longer than 200 ms counted as a drag), which stored the old default spot (y = 100 px,
     * close to the right edge) although the user never moved the button. Such entries are not
     * real user choices and would keep all buttons stacked in one place, so they are removed
     * once and the new default layout applies. Positions dragged anywhere else are kept.
     */
    private void migrateLegacyPositions() {
        if (prefs.getBoolean(PREF_LEGACY_POSITIONS_MIGRATED, false)) {
            return;
        }
        SharedPreferences.Editor editor = prefs.edit();
        for (OverlayFab fab : new OverlayFab[]{mainFab, leftFab, rightFab}) {
            if (!prefs.getBoolean(fab.keySaved, false)) {
                continue;
            }
            float x = readFloatPref(fab.keyX);
            float y = readFloatPref(fab.keyY);
            boolean legacyDefault =
                    Math.abs(y - LEGACY_DEFAULT_Y_PX) <= LEGACY_DEFAULT_Y_TOLERANCE_PX
                            && x >= screenWidth / 2f;
            if (isInvalidPosition(x, y) || legacyDefault) {
                editor.remove(fab.keySaved).remove(fab.keyX).remove(fab.keyY);
                Log.i(TAG, "Dropped the legacy default position of the " + fab.name + " button");
            }
        }
        editor.putBoolean(PREF_LEGACY_POSITIONS_MIGRATED, true).apply();
    }

    // ---- Tear-down -------------------------------------------------------------------------

    @Override
    public void onDestroy() {
        // unregisterReceiver() throws IllegalArgumentException when registration failed. Guarded,
        // so the exception cannot abort onDestroy() before the overlays are removed and leave
        // orphaned type 2038 windows (with their ViewRootImpl) in the WindowManager.
        if (isReceiverRegistered) {
            try {
                unregisterReceiver(fabReceiver);
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "Receiver was not registered: " + e.getMessage());
            }
            isReceiverRegistered = false;
        }

        // One button at a time, so a failure on one cannot prevent removing the others.
        for (OverlayFab fab : activeFabs) {
            removeOverlay(fab);
        }
        activeFabs.clear();
        super.onDestroy();
    }

    private void removeOverlay(OverlayFab fab) {
        // The "added" flag is checked instead of isAttachedToWindow(): a view counts as attached
        // only after its first traversal, so a service destroyed right after creation used to
        // skip the removal, leak the windows and then crash in the pending post() callbacks.
        if (!fab.added || windowManager == null) {
            return;
        }
        fab.added = false; // Also turns callbacks that are still pending into no-ops.
        try {
            // removeView() is asynchronous, so the ViewRootImpl would survive one more
            // message-loop pass after the service is already gone.
            windowManager.removeViewImmediate(fab.view);
        } catch (RuntimeException e) {
            Log.w(TAG, "Failed to remove the " + fab.name + " overlay button", e);
        }
    }

    // ---- Helpers ---------------------------------------------------------------------------

    @SuppressLint({"DiscouragedApi", "InternalInsetResource"})
    public int getStatusBarHeight() {
        // There is no public API for the status bar height before a window is attached.
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? getResources().getDimensionPixelSize(resourceId) : 0;
    }

    private int dpToPx(float dp) {
        return Math.round(dp * density);
    }

    /** One overlay button with its window parameters, preference keys and touch state. */
    private static final class OverlayFab {
        final String name;
        @DrawableRes
        final int iconRes;
        final String keyX;
        final String keyY;
        final String keySaved;
        final Runnable action;

        FloatingActionButton view;
        WindowManager.LayoutParams params;
        /** True between a successful addView() and removeOverlay(). */
        boolean added;

        // Touch state of this button only
        float downRawX;
        float downRawY;
        int downWindowX;
        int downWindowY;
        boolean dragging;
        /** The next touch event starts a new reference point (a finger was added or lifted). */
        boolean reanchor;

        OverlayFab(String name, @DrawableRes int iconRes, String keyX, String keyY,
                   String keySaved, Runnable action) {
            this.name = name;
            this.iconRes = iconRes;
            this.keyX = keyX;
            this.keyY = keyY;
            this.keySaved = keySaved;
            this.action = action;
        }
    }
}
