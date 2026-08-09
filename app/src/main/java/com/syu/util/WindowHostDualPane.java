package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.settings.Keys;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

/**
 * Hosts TWO embedded apps side by side in one WindowManager window, separated by a draggable
 * divider.
 *
 * Reflection contract used by WindowUtil (do not rename):
 *   fields:  leftAV, rightAV, leftHost, rightHost, leftPkg, rightPkg,
 *            leftAttached, rightAttached, leftTask, rightTask, added
 *   methods: show, updateBounds, dismissAsync, cleanup, isVisible,
 *            resyncGeometryAfterSurfaceSwap, flushPendingResizes
 */
public class WindowHostDualPane {

    // =====================================================================================
    // 1. Constants & fields
    // =====================================================================================

    private static final String TAG = "WindowHostDualPane";

    private static final String PREFS = "pip_window_host_prefs";
    private static final String KEY_SPLIT = "dual_split_ratio";

    private static final long SURFACE_RESTORE_DELAY_MS      = 500L;
    private static final long BLACK_SCREEN_CHECK_DELAY_MS   = 1200L;
    private static final long BLACK_SCREEN_CONFIRM_DELAY_MS = 800L;
    private static final int  REQUIRED_BLACK_CONFIRMATIONS  = 2;
    private static final int  MAX_RESTART_ATTEMPTS          = 2;

    private static final int  START_WAIT_TIMEOUT_MS = 600;
    private static final int  START_WAIT_STEP_MS    = 4;

    private static final int  GEOMETRY_RETRIES      = 30;
    private static final int  EXTRA_SETTLE_RETRIES  = 20;
    private static final int  TAP_REGION_RETRIES    = 4;
    private static final long POST_LAYOUT_FALLBACK_MS = 250L;
    /**
     * A pane whose launch was deferred because the initial bounds were not real yet must never
     * stay empty forever -- see the matching note in WindowHostSinglePane.
     */
    private static final long DEFERRED_START_WATCHDOG_MS = 2500L;
    /**
     * A swap does NOT wait for an app to start -- the app is already running and its display
     * already reports a visible task, so the readiness query answers "yes" instantly. What we are
     * actually waiting for is our own SurfaceControl re-parent to be composited on the new host,
     * which takes noticeably longer than one frame. Hence a MINIMUM visible time, not just a cap.
     */
    private static final long SWAP_SPLASH_MIN_MS = 900L;
    private static final long SWAP_SPLASH_MAX_MS = 3000L;
    /** Cold start: the app has to actually draw, and a heavy one (Maps) needs well over a second. */
    private static final long COLD_SPLASH_MIN_MS = 600L;
    private static final long COLD_SPLASH_MAX_MS = 3500L;
    /** Divider drag: the surface only has to come back, so this one really is a couple of frames. */
    private static final long DRAG_SPLASH_MIN_MS = 200L;
    private static final long DRAG_SPLASH_MAX_MS = 1200L;

    private static final float MIN_SPLIT_RATIO = 0.25f;
    private static final float MAX_SPLIT_RATIO = 0.75f;

    private static final ScheduledExecutorService DISMISS_EXEC =
            Executors.newSingleThreadScheduledExecutor();

    private enum Side { LEFT, RIGHT }

    private Activity activity;
    private WindowManager wm;
    private WindowManager.LayoutParams lp;
    private FrameLayout root;
    private FrameLayout leftHost, rightHost;
    private DividerView divider;
    private DividerHandleView dividerHandle;
    private boolean extendedDividerEnabled = true;
    /** True while a handoff cover is up and the divider is shown but not draggable. */
    private boolean dividerFrozen = false;
    private int dividerFreezeGeneration = 0;

    public boolean added;
    private boolean leftAttached;
    private boolean rightAttached;

    private Object leftAV, rightAV;
    /** ActivityView identity as of the last resync -- used to detect which side a swap touched. */
    private Object lastSeenLeftAV, lastSeenRightAV;
    private final AtomicBoolean leftReady       = new AtomicBoolean(false);
    private final AtomicBoolean rightReady      = new AtomicBoolean(false);
    private final AtomicBoolean leftFirstFrame  = new AtomicBoolean(false);
    private final AtomicBoolean rightFirstFrame = new AtomicBoolean(false);
    private final AtomicBoolean visible         = new AtomicBoolean(false);
    private final AtomicBoolean surfacesHidden  = new AtomicBoolean(false);

    private String leftPkg = null, rightPkg = null;
    private int leftTask = -1, rightTask = -1;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;
    private boolean leftStartDeferredForBounds = false;
    private boolean rightStartDeferredForBounds = false;

    private int leftRestartCount = 0, rightRestartCount = 0;
    private int leftBlackConfirmCount = 0, rightBlackConfirmCount = 0;
    private final AtomicBoolean leftBlackScreenDetected  = new AtomicBoolean(false);
    private final AtomicBoolean rightBlackScreenDetected = new AtomicBoolean(false);

    /**
     * Divider geometry.
     */
    private final int DIVIDER_VISUAL_PX     = dp(8);
    /** Full-height touchable strip -- this is the whole grab area when the handle is off. */
    private final int DIVIDER_BAR_TOUCH_PX  = dp(32);
    /** Wide grab handle, centred vertically. Purely an ADDITION on top of the strip above. */
    private final int DIVIDER_HANDLE_W_PX   = dp(80);
    private final int DIVIDER_HANDLE_H_PX   = dp(160);
    /** Default for Keys.EXTENDED_DIVIDER when the preference has never been written. */
    private static final boolean EXTENDED_DIVIDER_DEFAULT = true;
    /** Alpha of the visible bar while the divider is frozen, so it reads as inactive. */
    private static final float DIVIDER_FROZEN_ALPHA = 0.45f;
    /**
     * Safety net: if no reveal callback ever arrives (pane torn down mid-swap), thaw anyway.
     * Must outlast SWAP_SPLASH_MAX_MS plus the fade.
     */
    private static final long DIVIDER_FREEZE_MAX_MS = 4500L;

    private float splitRatio = 0.5f;
    private int lastAppliedLeftW = -1, lastAppliedRightW = -1;

    private int pendingRestoreGeneration = 0;

    private final DividerDragController dragController = new DividerDragController();

    /** Last size actually pushed into each ActivityView's VirtualDisplay. */
    private final Map<Object, int[]> vdSizeCache = new WeakHashMap<>();

    // =====================================================================================
    // 2. Construction & state queries
    // =====================================================================================

    boolean isVisible() { return visible.get(); }

    private Object avOf(Side s)          { return s == Side.LEFT ? leftAV : rightAV; }
    private FrameLayout hostOf(Side s)   { return s == Side.LEFT ? leftHost : rightHost; }
    private boolean attachedOf(Side s)   { return s == Side.LEFT ? leftAttached : rightAttached; }
    private String pkgOf(Side s)         { return s == Side.LEFT ? leftPkg : rightPkg; }
    private int taskOf(Side s)           { return s == Side.LEFT ? leftTask : rightTask; }
    private AtomicBoolean readyOf(Side s)      { return s == Side.LEFT ? leftReady : rightReady; }
    private AtomicBoolean firstFrameOf(Side s) { return s == Side.LEFT ? leftFirstFrame : rightFirstFrame; }
    private AtomicBoolean blackOf(Side s)      { return s == Side.LEFT ? leftBlackScreenDetected : rightBlackScreenDetected; }

    // =====================================================================================
    // 3. Public API
    // =====================================================================================

    void show(Activity act, WindowManager wm, IBinder token, String lPkg, String rPkg, Rect b) {
        if (lPkg == null || rPkg == null || b == null) return;

        this.activity = act;
        this.wm = wm;

        setSplitRatio(loadSplitRatio());

        if (visible.get() && lPkg.equals(leftPkg) && rPkg.equals(rightPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            applySplit(true);
            return;
        }

        final int myGen = ++gen;

        leftRestartCount = rightRestartCount = 0;
        leftBlackConfirmCount = rightBlackConfirmCount = 0;
        leftBlackScreenDetected.set(false);
        rightBlackScreenDetected.set(false);
        resetVdCache();

        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            boolean haveL = (leftTask > 0) && lPkg.equals(leftPkg);
            boolean haveR = (rightTask > 0) && rPkg.equals(rightPkg);
            leftPkg = lPkg;
            rightPkg = rPkg;

            ensureWindow(act, wm, token);
            scheduleRestore();
            setPendingBoundsFast(b);
            ensureActivityView(act, myGen);
            if (!leftAttached)  attachPane(Side.LEFT);
            if (!rightAttached) attachPane(Side.RIGHT);

            leftFirstFrame.set(false);
            rightFirstFrame.set(false);
            visible.set(true);

            // dismissAsync() switches the drag off and nothing used to switch it back on. The pane
            // object outlives a dismiss/show cycle, so without this the divider stays dead.
            dividerFrozen = false;
            dividerFreezeGeneration++;
            if (divider != null) divider.setAlpha(1f);
            dragController.interactive.set(true);

            applySplit(true);
            applyDividerPreference();

            for (Side s : Side.values()) {
                boolean have = (s == Side.LEFT) ? haveL : haveR;
                if (have) continue;

                String pkg = pkgOf(s);
                // Every app now waits for real bounds -- launching with degenerate bounds is what
                // makes an embedded app fall back to the classic PiP UI.
                if (WindowHostActivityView.shouldWaitForRealBounds(launchBounds(s))) {
                    setStartDeferred(s, true);
                    armDeferredStartWatchdog(s, pkg, myGen);
                } else {
                    setStartDeferred(s, false);
                    startWhenReady(s, pkg, myGen);
                    checkForBlackScreenAndRestart(s, pkg, myGen);
                }
            }

            for (Side s : Side.values()) scheduleSplashReveal(s, myGen);
        });
    }

    public void updateBounds(Rect b) {
        boolean boundsChanged = !hasPendingBounds || !pendingBounds.equals(b);
        setPendingBoundsFast(b);
        if (boundsChanged) applySplit(true);

        for (Side s : Side.values()) {
            if (!isStartDeferred(s)) continue;
            String pkg = pkgOf(s);
            if (pkg == null) continue;
            if (!WindowHostActivityView.hasRealLaunchBounds(launchBounds(s))) continue;

            setStartDeferred(s, false);
            startWhenReady(s, pkg, gen);
            checkForBlackScreenAndRestart(s, pkg, gen);
        }
    }

    /** True while either pane is up but still waiting for usable bounds before it may launch. */
    public boolean isAwaitingBounds() {
        return visible.get() && (leftStartDeferredForBounds || rightStartDeferredForBounds);
    }

    /** Last-resort launch when the releasing bounds update never arrives. */
    private void armDeferredStartWatchdog(final Side side, final String pkg, final int expectedGen) {
        postMainDelayed(() -> {
            if (gen != expectedGen || !isStartDeferred(side) || pkg == null) return;
            setStartDeferred(side, false);
            Log.w(TAG, side + ": bounds update never arrived, starting " + pkg + " anyway");
            startWhenReady(side, pkg, expectedGen);
            checkForBlackScreenAndRestart(side, pkg, expectedGen);
        }, DEFERRED_START_WATCHDOG_MS);
    }

    void dismissAsync() {
        final int myGen = ++gen;
        visible.set(false);
        dragController.interactive.set(false);
        cancelPendingRestore();
        parkInvisible();
        postMain(() -> hardRemoveWindow(false, myGen));
        DISMISS_EXEC.schedule(() -> postMain(() -> {
            if (gen != myGen) return;
            if (added || root != null) hardRemoveWindow(false, myGen);
        }), 150, TimeUnit.MILLISECONDS);
    }

    public void cleanup() {
        final int myGen = ++gen;
        visible.set(false);
        cancelPendingRestore();
        hardRemoveWindow(true, myGen);

        if (leftAV != null)  { WindowHostActivityView.release(leftAV);  leftAV = null; }
        if (rightAV != null) { WindowHostActivityView.release(rightAV); rightAV = null; }

        leftReady.set(false); rightReady.set(false);
        leftFirstFrame.set(false); rightFirstFrame.set(false);
        leftTask = rightTask = -1;
        leftPkg = rightPkg = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = rightStartDeferredForBounds = false;
        resetVdCache();
    }

    /** Called by WindowUtil after a native surface swap moved an ActivityView in or out. */
    public void resyncGeometryAfterSurfaceSwap() {
        lastAppliedLeftW = lastAppliedRightW = -1;
        resetVdCache();
        applySplit(true);
        boolean leftChanged  = (lastSeenLeftAV  != null && lastSeenLeftAV  != leftAV);
        boolean rightChanged = (lastSeenRightAV != null && lastSeenRightAV != rightAV);
        if (lastSeenLeftAV == null && lastSeenRightAV == null) {
            leftChanged = rightChanged = true;   // first resync: no baseline, be conservative
        }
        lastSeenLeftAV = leftAV;
        lastSeenRightAV = rightAV;

        for (Side side : Side.values()) {
            boolean changed = (side == Side.LEFT) ? leftChanged : rightChanged;
            if (!changed) continue;

            final Object paneAV = avOf(side);
            if (paneAV == null) continue;

            // Keep whatever icon coverForHandoff() put up at the start of the swap: one icon for
            // the whole operation, then a straight fade to the incoming app.
            coverForHandoff(side, true, null);

            // No IME priming here any more: priming means sending a NON-null matrix. Geometry now
            // goes through syncGeometryWithoutIme(), so IMMS is never involved.
            WindowHostActivityView.syncGeometryWithoutIme(paneAV);
            postMainDelayed(() -> WindowHostActivityView.syncGeometryWithoutIme(paneAV), 60);

            final Side s = side;
            postMainDelayed(() -> uncoverAfterHandoff(s), 120);
        }
    }

    /**
     * Raises the launch cover on both panes and keeps it up until uncoverAfterHandoff() decides
     * otherwise. This is the divider-drag pattern generalised: the cover must go up BEFORE the
     * disruption starts, not after it. Call it at the very beginning of a pane swap -- by the time
     * WindowUtil gets round to resyncGeometryAfterSurfaceSwap(), roughly 600 ms of black has
     * already been on screen.
     */
    public void coverForHandoff() { coverForHandoff(null, false, null); }

    /**
     * Side-specific variants, so a left&lt;-&gt;third swap does not flash a cover over the right
     * pane (and vice versa). WindowUtil knows which half it is about to touch.
     */
    public void coverLeftForHandoff()  { coverForHandoff(Side.LEFT, false, null); }
    public void coverRightForHandoff() { coverForHandoff(Side.RIGHT, false, null); }

    /**
     * Preferred variants: the cover shows the icon of the app that is ARRIVING, not the one that
     * is leaving. A splash announces what you are about to get -- showing the outgoing app for the
     * whole swap and then cutting to a different one reads as a glitch. Only WindowUtil knows the
     * incoming package at this point, because the pane fields are swapped later.
     */
    public void coverLeftForHandoff(String incomingPkg)  { coverForHandoff(Side.LEFT, false, incomingPkg); }
    public void coverRightForHandoff(String incomingPkg) { coverForHandoff(Side.RIGHT, false, incomingPkg); }
    public void coverForHandoff(String incomingPkg)      { coverForHandoff(null, false, incomingPkg); }

    /**
     * @param onlySide  cover just this side (null = both)
     * @param keepIcon  keep whatever icon is already up (see WindowHostSplash.attach)
     */
    private void coverForHandoff(Side onlySide, boolean keepIcon, String incomingPkg) {
        if (root == null) return;
        for (Side side : Side.values()) {
            if (onlySide != null && side != onlySide) continue;

            String pkg = (incomingPkg != null && !incomingPkg.isEmpty()) ? incomingPkg : pkgOf(side);
            if (pkg == null) continue;

            int w = targetPaneWidth(side);
            int h = targetPaneHeight(side);
            if (w <= 1 || h <= 1) continue;

            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(w, h);
            lp.gravity = Gravity.TOP | Gravity.START;
            lp.leftMargin = (side == Side.LEFT) ? 0 : targetPaneWidth(Side.LEFT);
            lp.topMargin = 0;

            WindowHostSplash.attach(root, handoffKey(side), pkg, lp, keepIcon);
        }

        freezeDivider();
    }

    /** Takes the handoff cover down once the swapped-in content is composited. */
    public void uncoverAfterHandoff() { uncoverAfterHandoff(null); }

    private void uncoverAfterHandoff(Side onlySide) {
        if (root == null) return;
        final int myGen = gen;
        final FrameLayout rootRef = root;

        for (Side side : Side.values()) {
            if (onlySide != null && side != onlySide) continue;
            final Object paneAV = avOf(side);
            if (paneAV == null) continue;

            WindowHostSplash.dismissWhenReady(rootRef, handoffKey(side), paneAV,
                    SWAP_SPLASH_MIN_MS, SWAP_SPLASH_MAX_MS, () -> {
                if (gen != myGen) return;
                refreshTapRegionSafely(paneAV, TAP_REGION_RETRIES);
                thawDivider();
            });
        }
    }

    private static String handoffKey(Side side) {
        return "WindowHostSplash#handoff:" + side;
    }

    /** Applies any geometry that is still pending, immediately. */
    public void flushPendingResizes() {
        applySplit(true);
    }

    /**
     * Hands both panes' ActivityViews over to the caller and forgets about them.
     * See WindowHostSinglePane.takeActivityViews() for why they must not be released here.
     */
    void takeActivityViews(java.util.List<Object> out) {
        for (Side side : Side.values()) {
            Object paneAV = avOf(side);
            if (paneAV == null) continue;
 
            try {
                View v = WindowHostActivityView.asView(paneAV);
                if (v != null && v.getParent() instanceof ViewGroup) {
                    ((ViewGroup) v.getParent()).removeView(v);
                }
            } catch (Throwable ignore) { }
 
            out.add(paneAV);
            resetVdCache(paneAV);
 
            if (side == Side.LEFT) {
                leftAV = null; leftTask = -1;
                leftAttached = false;
                leftReady.set(false); leftFirstFrame.set(false);
            } else {
                rightAV = null; rightTask = -1;
                rightAttached = false;
                rightReady.set(false); rightFirstFrame.set(false);
            }
        }
    }

    // =====================================================================================
    // 4. Window lifecycle
    // =====================================================================================

    private void ensureWindow(Activity act, WindowManager wm, IBinder token) {
        if (added && root != null && lp != null) return;
        if (root != null) {
            try { if (root.isAttachedToWindow()) wm.removeViewImmediate(root); } catch (Throwable ignore) {}
        }

        FrameLayout rootView = new FrameLayout(act);
        rootView.setBackgroundColor(Color.TRANSPARENT);
        rootView.setWillNotDraw(true);
        rootView.setClickable(false);

        FrameLayout left = new FrameLayout(act);
        left.setBackgroundColor(Color.TRANSPARENT);
        left.setWillNotDraw(true);
        left.setClickable(false);

        FrameLayout right = new FrameLayout(act);
        right.setBackgroundColor(Color.TRANSPARENT);
        right.setWillNotDraw(true);
        right.setClickable(false);

        DividerView div = new DividerView(act, DIVIDER_VISUAL_PX);
        div.setClickable(false);
        div.setFocusable(false);
        div.setFocusableInTouchMode(false);
        div.setOnTouchListener(dragController);

        DividerHandleView handle = new DividerHandleView(act);
        handle.setClickable(false);
        handle.setFocusable(false);
        handle.setFocusableInTouchMode(false);
        handle.setOnTouchListener(dragController);

        int match = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.addView(left,  new FrameLayout.LayoutParams(match, match));
        rootView.addView(right, new FrameLayout.LayoutParams(match, match));

        FrameLayout.LayoutParams dividerLp = new FrameLayout.LayoutParams(DIVIDER_BAR_TOUCH_PX, match);
        dividerLp.gravity = Gravity.TOP | Gravity.START;
        rootView.addView(div, dividerLp);

        FrameLayout.LayoutParams handleLp =
                new FrameLayout.LayoutParams(DIVIDER_HANDLE_W_PX, DIVIDER_HANDLE_H_PX);
        handleLp.gravity = Gravity.TOP | Gravity.START;
        rootView.addView(handle, handleLp);

        WindowManager.LayoutParams p = new WindowManager.LayoutParams();
        p.type = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
        p.token = token;
        p.format = PixelFormat.TRANSLUCENT;
        p.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_SPLIT_TOUCH
                | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
        p.gravity = Gravity.TOP | Gravity.START;
        p.width = 1; p.height = 1; p.x = -10000; p.y = -10000;
        p.alpha = 1f;
        p.setTitle("PipWindowHost:Dual");

        try { wm.addView(rootView, p); added = true; }
        catch (Throwable t) {
            try { p.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG; wm.addView(rootView, p); added = true; }
            catch (Throwable t2) { throw new RuntimeException("Unable to create dual host window", t2); }
        }

        this.root = rootView;
        this.leftHost = left;
        this.rightHost = right;
        this.divider = div;
        this.dividerHandle = handle;
        applyDividerPreference();
        this.lp = p;

        applySplit(false);
        root.getViewTreeObserver().addOnGlobalLayoutListener(() -> applySplit(false));
    }

    /** Moves/resizes the host window. Pane geometry is applied separately by applySplit(). */
    private void setPendingBoundsFast(Rect b) {
        if (hasPendingBounds && pendingBounds.equals(b)) return;

        pendingBounds.set(b);
        hasPendingBounds = true;

        if (lp == null || root == null) return;

        lp.width  = Math.max(1, b.width());
        lp.height = Math.max(1, b.height());
        lp.x = b.left; lp.y = b.top;
        lp.alpha = 1f;
        lp.flags &= ~WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        try { wm.updateViewLayout(root, lp); } catch (Throwable ignore) {}

        root.setVisibility(View.VISIBLE);
        root.setAlpha(1f);
    }

    private void hardRemoveWindow(boolean releaseAVs, int expectedGen) {
        if (gen != expectedGen) return;
        cancelPendingRestore();

        clearTapRegionQuietly(leftAV);
        clearTapRegionQuietly(rightAV);

        if (root != null) {
            WindowHostSplash.removeImmediately(root, handoffKey(Side.LEFT));
            WindowHostSplash.removeImmediately(root, handoffKey(Side.RIGHT));
        }
        if (leftHost != null) {
            WindowHostSplash.removeImmediately(leftHost);
            if (leftAttached) {
                try { leftHost.removeAllViews(); } catch (Throwable ignore) {}
                leftAttached = false;
            }
        }
        if (rightHost != null) {
            WindowHostSplash.removeImmediately(rightHost);
            if (rightAttached) {
                try { rightHost.removeAllViews(); } catch (Throwable ignore) {}
                rightAttached = false;
            }
        }

        final View toRemove = root;
        final WindowManager wmRef = wm;

        if (added && wmRef != null && toRemove != null) {
            try { wmRef.removeViewImmediate(toRemove); }
            catch (Throwable t) { Log.w(TAG, "hardRemoveWindow: removeViewImmediate threw", t); }
        }

        if (releaseAVs) {
            if (leftAV != null) {
                try { WindowHostActivityView.release(leftAV); } catch (Throwable ignore) {}
                resetVdCache(leftAV); leftAV = null; leftTask = -1; leftReady.set(false);
            }
            if (rightAV != null) {
                try { WindowHostActivityView.release(rightAV); } catch (Throwable ignore) {}
                resetVdCache(rightAV); rightAV = null; rightTask = -1; rightReady.set(false);
            }
        }

        added = false;
        visible.set(false);
        surfacesHidden.set(false);
        root = null; leftHost = null; rightHost = null; divider = null; dividerHandle = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = rightStartDeferredForBounds = false;
        lastAppliedLeftW = lastAppliedRightW = -1;

        if (toRemove != null && wmRef != null) verifyDetached(toRemove, wmRef, 0);
    }

    private void forceRemoveWindowNoGen() {
        cancelPendingRestore();

        clearTapRegionQuietly(leftAV);
        clearTapRegionQuietly(rightAV);

        if (root != null) {
            WindowHostSplash.removeImmediately(root, handoffKey(Side.LEFT));
            WindowHostSplash.removeImmediately(root, handoffKey(Side.RIGHT));
        }
        if (leftHost != null) {
            WindowHostSplash.removeImmediately(leftHost);
            if (leftAttached) {
                try { leftHost.removeAllViews(); } catch (Throwable ignore) {}
                leftAttached = false;
            }
        }
        if (rightHost != null) {
            WindowHostSplash.removeImmediately(rightHost);
            if (rightAttached) {
                try { rightHost.removeAllViews(); } catch (Throwable ignore) {}
                rightAttached = false;
            }
        }
        if (added && wm != null && root != null) {
            try { wm.removeViewImmediate(root); } catch (Throwable ignore) {}
        }

        added = false;
        visible.set(false);
        surfacesHidden.set(false);
        root = null; leftHost = null; rightHost = null; divider = null; dividerHandle = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = rightStartDeferredForBounds = false;
        lastAppliedLeftW = lastAppliedRightW = -1;
    }

    private void parkInvisible() {
        if (!(added && wm != null && lp != null && root != null)) return;

        lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
        lp.width = 600; lp.height = 600;
        lp.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        try { wm.updateViewLayout(root, lp); }
        catch (Throwable t) {
            Log.w(TAG, "parkInvisible updateViewLayout failed, forcing removal", t);
            try { wm.removeViewImmediate(root); } catch (Throwable ignore) {}
        }
        root.setAlpha(0f);
        root.setVisibility(View.INVISIBLE);
    }

    private void verifyDetached(View v, WindowManager wmRef, int attempt) {
        postMainDelayed(() -> {
            boolean stillAttached;
            try { stillAttached = v.isAttachedToWindow(); } catch (Throwable t) { stillAttached = false; }
            if (!stillAttached) return;

            Log.w(TAG, "verifyDetached: still attached (attempt " + attempt + "), forcing again");
            try { wmRef.removeViewImmediate(v); } catch (Throwable ignore) {}

            if (attempt < 10) {
                verifyDetached(v, wmRef, attempt + 1);
            } else {
                Log.e(TAG, "giving up after " + (attempt + 1) + " attempts - neutralizing leaked view");
                try {
                    v.setVisibility(View.GONE);
                    disableTouchRecursively(v);
                } catch (Throwable ignore) {}
            }
        }, 150);
    }

    // =====================================================================================
    // 5. ActivityView lifecycle
    // =====================================================================================

    private void ensureActivityView(Context ctx, int expectedGen) {
        // Fresh instances, always -- see the matching note in WindowHostSinglePane.
        if (leftAV == null) {
            leftAV = WindowHostActivityView.newInstance(ctx);
            leftReady.set(false);
            WindowHostActivityView.trySetCallback(leftAV, new WindowHostActivityView.Callback() {
                @Override public void onReady()            { if (gen == expectedGen) leftReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) leftTask = id; }
                @Override public void onDestroyed()         { if (gen == expectedGen) leftReady.set(false); }
            });
        }

        if (rightAV == null) {
            rightAV = WindowHostActivityView.newInstance(ctx);
            rightReady.set(false);
            WindowHostActivityView.trySetCallback(rightAV, new WindowHostActivityView.Callback() {
                @Override public void onReady()            { if (gen == expectedGen) rightReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) rightTask = id; }
                @Override public void onDestroyed()         { if (gen == expectedGen) rightReady.set(false); }
            });
        }

        leftFirstFrame.set(false);
        rightFirstFrame.set(false);
    }

    private void attachPane(Side side) {
        FrameLayout paneHost = hostOf(side);
        Object paneAV = avOf(side);
        if (paneHost == null || paneAV == null) return;

        resetVdCache(paneAV);

        View v = WindowHostActivityView.asView(paneAV);
        if (v == null) return;

        resetActivityViewForReuse(paneAV);
        clearTapRegionQuietly(paneAV);

        if (v.getParent() instanceof ViewGroup) {
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {}
        }
        paneHost.removeAllViews();
        v.setVisibility(View.VISIBLE);

        hookFirstFrame(v, side);

        paneHost.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (side == Side.LEFT) { leftAttached = true; lastSeenLeftAV = leftAV; }
        else                   { rightAttached = true; lastSeenRightAV = rightAV; }

        // Launch cover: the app's icon on its own colour instead of an empty (black) surface.
        String pkg = pkgOf(side);
        if (pkg != null) WindowHostSplash.attach(paneHost, pkg);

        applyPaneGeometry(side);
    }

    /**
     * Takes the launch cover down once the app is genuinely visible on this pane's
     * VirtualDisplay. The cover obscures the ActivityView while it is up, which suppresses the
     * tap-exclude region, so the region is recomputed as soon as it is gone.
     */
    private void scheduleSplashReveal(final Side side, final int expectedGen) {
        final FrameLayout paneHost = hostOf(side);
        final Object paneAV = avOf(side);
        if (paneHost == null || paneAV == null) return;

        WindowHostSplash.dismissWhenReady(paneHost, paneAV,
                COLD_SPLASH_MIN_MS, COLD_SPLASH_MAX_MS, () -> {
            if (gen != expectedGen) return;
            if (hostOf(side) != paneHost || avOf(side) != paneAV) return;
            refreshTapRegionSafely(paneAV, TAP_REGION_RETRIES);
        });
    }

    private void resetActivityViewForReuse(Object paneAV) {
        View v = WindowHostActivityView.asView(paneAV);
        if (v == null) return;

        v.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        v.setScaleX(1f);
        v.setScaleY(1f);
        v.setTranslationX(0f);
        v.setTranslationY(0f);
        v.setPivotX(0f);
        v.setPivotY(0f);

        resetSurfaceSizeFromLayout(paneAV);
    }

    private void hookFirstFrame(View paneRoot, Side side) {
        SurfaceView sv = findSurfaceView(paneRoot);
        if (sv == null) return;
        try {
            sv.getHolder().addCallback(new SurfaceHolder.Callback2() {
                @Override public void surfaceCreated(@NonNull SurfaceHolder holder) { }
                @Override public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                    if (width > 0 && height > 0) firstFrameOf(side).set(true);
                }
                @Override public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
                @Override public void surfaceRedrawNeeded(@NonNull SurfaceHolder holder) { firstFrameOf(side).set(true); }
            });
        } catch (Throwable ignore) {}
    }

    // =====================================================================================
    // 6. Geometry -- the single entry point for "this pane is now W x H"
    // =====================================================================================

    /**
     * Applies the current split to the pane containers and then to both panes' content.
     *
     * @param force ignore the "nothing changed" shortcut (use after a swap / bounds change)
     */
    private void applySplit(boolean force) { applySplit(force, GEOMETRY_RETRIES); }

    private void applySplit(boolean force, int retriesLeft) {
        if (root == null || leftHost == null || rightHost == null || divider == null) return;
        if (!hasPendingBounds) return;

        // Resizing the pane containers forces a layout traversal on the child ActivityViews;
        // doing that while a native reparent is still in flight throws from inside the
        // framework's own traversal ("window is not the parent window of this display").
        View lv = leftAV  != null ? WindowHostActivityView.asView(leftAV)  : null;
        View rv = rightAV != null ? WindowHostActivityView.asView(rightAV) : null;
        if (WindowUtil.isReparentUnsettled(lv) || WindowUtil.isReparentUnsettled(rv)) {
            if (retriesLeft > 0) postNextFrame(() -> applySplit(force, retriesLeft - 1));
            else postMainDelayed(() -> applySplit(force, EXTRA_SETTLE_RETRIES), 100);
            return;
        }

        int totalWidth = Math.max(1, pendingBounds.width());
        int minW = Math.round(totalWidth * MIN_SPLIT_RATIO);
        int maxW = Math.round(totalWidth * MAX_SPLIT_RATIO);
        int leftW  = clampPx(Math.round(totalWidth * splitRatio), minW, maxW);
        int rightW = totalWidth - leftW;

        if (!force && leftW == lastAppliedLeftW && rightW == lastAppliedRightW) return;

        setPaneWidths(leftW, rightW);

        if (surfacesHidden.get()) return;

        applyPaneGeometry(Side.LEFT);
        applyPaneGeometry(Side.RIGHT);
    }

    /** Pure container layout -- cheap, safe to call on every drag frame. */
    private void setPaneWidths(int leftW, int rightW) {
        if (leftHost == null || rightHost == null || divider == null) return;

        FrameLayout.LayoutParams leftLp    = (FrameLayout.LayoutParams) leftHost.getLayoutParams();
        FrameLayout.LayoutParams rightLp   = (FrameLayout.LayoutParams) rightHost.getLayoutParams();
        FrameLayout.LayoutParams dividerLp = (FrameLayout.LayoutParams) divider.getLayoutParams();

        leftLp.width = leftW;
        leftLp.leftMargin = 0;

        rightLp.width = rightW;
        rightLp.leftMargin = leftW;

        dividerLp.width = DIVIDER_BAR_TOUCH_PX;
        dividerLp.leftMargin = leftW - (DIVIDER_BAR_TOUCH_PX / 2);

        leftHost.setLayoutParams(leftLp);
        rightHost.setLayoutParams(rightLp);
        divider.setLayoutParams(dividerLp);

        if (dividerHandle != null && extendedDividerEnabled) {
            FrameLayout.LayoutParams handleLp =
                    (FrameLayout.LayoutParams) dividerHandle.getLayoutParams();
            int paneH = targetPaneHeight(Side.LEFT);
            if (paneH <= 0 && root != null) paneH = root.getHeight();

            handleLp.width  = DIVIDER_HANDLE_W_PX;
            handleLp.height = DIVIDER_HANDLE_H_PX;
            // Both strips are centred on the split line, so the visible bar sits exactly in the
            // middle of the invisible grab area.
            handleLp.leftMargin = leftW - (DIVIDER_HANDLE_W_PX / 2);
            handleLp.topMargin  = (paneH > DIVIDER_HANDLE_H_PX)
                    ? (paneH - DIVIDER_HANDLE_H_PX) / 2
                    : 0;
            dividerHandle.setLayoutParams(handleLp);
        }

        lastAppliedLeftW = leftW;
        lastAppliedRightW = rightW;

        claimPanePosition(Side.LEFT, 0, 0);
        claimPanePosition(Side.RIGHT, leftW, 0);
    }

    private void claimPanePosition(Side side, int x, int y) {
        Object paneAV = avOf(side);
        if (paneAV == null) return;
        try {
            WindowHostActivityView.syncGeometryWithoutIme(paneAV, x, y);
        } catch (Throwable ignore) { }
    }

    private void applyPaneGeometry(Side side) { applyPaneGeometry(side, GEOMETRY_RETRIES); }

    /**
     * Sizes the ActivityView, its SurfaceView and its VirtualDisplay to the pane's TARGET size,
     * then refreshes the tap-exclude region -- in that order, and always AFTER the layout pass
     * that actually applies the size.
     *
     * Two rules encoded here, both learned the hard way:
     *
     *  1. The child gets EXPLICIT pixel LayoutParams, never MATCH_PARENT. This used to be the
     *     YouTube-only path. With MATCH_PARENT the measured size lags one traversal behind the
     *     host, and every consumer below reads a stale width.
     *  2. Everything that reads getWidth()/getHeight() runs in postAfterLayout(), not in
     *     postNextFrame(). Choreographer.postFrameCallback() is CALLBACK_ANIMATION, which runs
     *     BEFORE CALLBACK_TRAVERSAL of the same frame -- i.e. before layout, so it would report
     *     the OLD width to both the VirtualDisplay and the tap-exclude region. That is what left
     *     a widened pane with an invisible, touch-dead strip after a divider drag.
     */
    private void applyPaneGeometry(Side side, int retriesLeft) {
        final FrameLayout paneHost = hostOf(side);
        final Object paneAV = avOf(side);
        if (paneHost == null || paneAV == null || !attachedOf(side)) return;
        if (surfacesHidden.get()) return;

        final View v = WindowHostActivityView.asView(paneAV);
        if (v == null) return;

        if (WindowUtil.isReparentUnsettled(v)) {
            if (retriesLeft > 0) {
                postNextFrame(() -> applyPaneGeometry(side, retriesLeft - 1));
            } else {
                Log.w(TAG, "applyPaneGeometry(" + side + "): reparent guard still set, extending wait");
                postMainDelayed(() -> applyPaneGeometry(side, EXTRA_SETTLE_RETRIES), 100);
            }
            return;
        }

        final int targetW = targetPaneWidth(side);
        final int targetH = targetPaneHeight(side);
        if (targetW <= 1 || targetH <= 1) {
            if (retriesLeft > 0) postNextFrame(() -> applyPaneGeometry(side, retriesLeft - 1));
            return;
        }

        applyChildSize(v, targetW, targetH);

        postAfterLayout(paneHost, () -> {
            if (hostOf(side) != paneHost || avOf(side) != paneAV || !attachedOf(side)) return;
            if (surfacesHidden.get() || !v.isAttachedToWindow()) return;

            int w = paneHost.getWidth()  > 0 ? paneHost.getWidth()  : targetW;
            int h = paneHost.getHeight() > 0 ? paneHost.getHeight() : targetH;
            if (w <= 1 || h <= 1) return;

            resetSurfaceSizeFromLayout(paneAV);
            enforcePaneVirtualDisplay(paneAV, w, h);
            refreshTapRegionSafely(paneAV, TAP_REGION_RETRIES);
        });
    }

    private void applyChildSize(View v, int w, int h) {
        FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(Math.max(1, w), Math.max(1, h));
        flp.gravity = Gravity.TOP | Gravity.START;
        flp.leftMargin = 0;
        flp.topMargin = 0;
        v.setLayoutParams(flp);

        v.setScaleX(1f);
        v.setScaleY(1f);
        v.setTranslationX(0f);
        v.setTranslationY(0f);
        v.setPivotX(0f);
        v.setPivotY(0f);
    }

    /** The width the pane is SUPPOSED to have -- never a possibly-stale measured width. */
    private int targetPaneWidth(Side side) {
        FrameLayout paneHost = hostOf(side);
        if (paneHost != null) {
            ViewGroup.LayoutParams hlp = paneHost.getLayoutParams();
            if (hlp != null && hlp.width > 0) return hlp.width;   // what applySplit() just set
        }
        if (hasPendingBounds && pendingBounds.width() > 0) {
            int total = pendingBounds.width();
            int leftW = clampPx(Math.round(total * splitRatio),
                    Math.round(total * MIN_SPLIT_RATIO), Math.round(total * MAX_SPLIT_RATIO));
            return side == Side.LEFT ? leftW : (total - leftW);
        }
        return paneHost != null ? paneHost.getWidth() : 0;
    }

    private int targetPaneHeight(Side side) {
        FrameLayout paneHost = hostOf(side);
        if (paneHost != null) {
            ViewGroup.LayoutParams hlp = paneHost.getLayoutParams();
            if (hlp != null && hlp.height > 0) return hlp.height;
        }
        if (hasPendingBounds && pendingBounds.height() > 0) return pendingBounds.height();
        return paneHost != null ? paneHost.getHeight() : 0;
    }

    private void enforcePaneVirtualDisplay(Object paneAV, int paneW, int paneH) {
        if (paneAV == null || paneW <= 1 || paneH <= 1) return;

        View view = WindowHostActivityView.asView(paneAV);
        if (view == null) return;

        int density = resolveDensityDpi(view);
        if (!resizeVirtualDisplay(paneAV, paneW, paneH, density)) return;

        kickSurfaceRedraw(view, paneW, paneH);
    }

    /** @return true when the VirtualDisplay was actually resized (i.e. the size really changed). */
    private boolean resizeVirtualDisplay(Object paneAV, int width, int height, int densityDpi) {
        if (paneAV == null || width <= 0 || height <= 0) return false;

        int safeDensity = Math.max(120, densityDpi);

        // Exact match only. This used to allow an 8px tolerance, which silently swallowed real
        // resizes and left the VirtualDisplay at its old resolution.
        int[] last = vdSizeCache.get(paneAV);
        if (last != null && last[0] == width && last[1] == height && last[2] == safeDensity) {
            return false;
        }

        Object vd = WindowHostActivityView.getVirtualDisplay(paneAV);
        if (vd == null) return false;

        try {
            Method resize = vd.getClass().getMethod("resize", int.class, int.class, int.class);
            resize.invoke(vd, width, height, safeDensity);
        } catch (Throwable t) {
            Log.w(TAG, "resizeVirtualDisplay failed: " + width + "x" + height + " @" + safeDensity, t);
            return false;
        }

        vdSizeCache.put(paneAV, new int[]{ width, height, safeDensity });
        Log.d(TAG, "resizeVD OK -> " + width + "x" + height + " @" + safeDensity);
        return true;
    }

    private int resolveDensityDpi(View view) {
        try {
            Method m = view.getClass().getDeclaredMethod("getBaseDisplayDensity");
            m.setAccessible(true);
            Object v = m.invoke(view);
            if (v instanceof Integer && ((Integer) v) > 0) return (Integer) v;
        } catch (Throwable ignore) { }

        try {
            android.util.DisplayMetrics dm = view.getResources().getDisplayMetrics();
            if (dm != null && dm.densityDpi > 0) return dm.densityDpi;
        } catch (Throwable ignore) { }

        return 160;
    }

    private void kickSurfaceRedraw(View view, int w, int h) { kickSurfaceRedraw(view, w, h, 8); }

    private void kickSurfaceRedraw(View view, int w, int h, int retriesLeft) {
        if (view == null) return;

        if (WindowUtil.isReparentUnsettled(view)) {
            if (retriesLeft > 0) postMainDelayed(() -> kickSurfaceRedraw(view, w, h, retriesLeft - 1), 32);
            return;
        }

        view.requestLayout();
        view.invalidate();

        SurfaceView sv = findSurfaceView(view);
        if (sv == null) return;

        sv.requestLayout();
        sv.invalidate();

        SurfaceHolder holder = sv.getHolder();
        if (holder != null) {
            try { holder.setSizeFromLayout(); } catch (Throwable ignore) {}
        }
    }

    private void resetSurfaceSizeFromLayout(Object paneAV) {
        View view = WindowHostActivityView.asView(paneAV);
        if (view == null) return;
        try {
            SurfaceView sv = findSurfaceView(view);
            if (sv == null) return;
            SurfaceHolder holder = sv.getHolder();
            if (holder != null) holder.setSizeFromLayout();
        } catch (Throwable t) {
            Log.w(TAG, "resetSurfaceSizeFromLayout failed", t);
        }
    }

    private void refreshTapRegionSafely(Object paneAV, int retriesLeft) {
        View v = WindowHostActivityView.asView(paneAV);
        if (v == null || !v.isAttachedToWindow()) return;

        // Preferred path: applies the location + tap-exclude region WITHOUT reporting a matrix to
        // the IME. The framework's own method reports unconditionally whenever the location moved,
        // and that report is what kills an embedded app bound to the IME.
        if (WindowHostActivityView.syncGeometryWithoutIme(paneAV)) return;

        try {
            Method m;
            try { m = v.getClass().getMethod("updateLocationAndTapExcludeRegion"); }
            catch (NoSuchMethodException e) {
                m = v.getClass().getDeclaredMethod("updateLocationAndTapExcludeRegion");
                m.setAccessible(true);
            }
            m.invoke(v);
        } catch (java.lang.reflect.InvocationTargetException ite) {
            Throwable c = ite.getCause();
            boolean parentWindowRace = (c instanceof IllegalArgumentException)
                    && c.getMessage() != null
                    && c.getMessage().contains("not the parent window");
            if (parentWindowRace) {
                clearTapRegionQuietly(paneAV);
                if (retriesLeft > 0) postMainDelayed(() -> refreshTapRegionSafely(paneAV, retriesLeft - 1), 32);
                return;
            }
            Log.w(TAG, "refreshTapRegionSafely failed", ite);
        } catch (Throwable t) {
            Log.w(TAG, "refreshTapRegionSafely failed", t);
        }
    }

    private void clearTapRegionQuietly(Object paneAV) {
        if (paneAV == null) return;
        // cleanTapExcludeRegion() only touches WindowSession -- it never reports a null matrix to
        // the IME (that is clearActivityViewGeometryForIme(), which must never be called.
        WindowHostActivityView.clearTapRegion(paneAV);
    }

    private void resetVdCache() { vdSizeCache.clear(); }

    private void resetVdCache(Object paneAV) { if (paneAV != null) vdSizeCache.remove(paneAV); }

    // =====================================================================================
    // 6b. Surface hide/restore around a divider drag
    // =====================================================================================

    /**
     * Hides both ActivityViews (GONE) behind a plain placeholder for the duration of a drag.
     *
     * GONE, not just covered: a VISIBLE ActivityView is measured/laid out on every one of the
     * ~60 container resizes a drag produces, and each of those makes its inner SurfaceView
     * reallocate a native gralloc buffer (~200ms each in the captured logs). The backlog is what
     * eventually killed the embedded app. One real resize happens at the end, in restoreSurfaces().
     */
    private void hideSurfaces() {
        if (surfacesHidden.get()) return;
        surfacesHidden.set(true);

        for (Side side : Side.values()) {
            FrameLayout paneHost = hostOf(side);
            if (paneHost == null || !attachedOf(side)) continue;

            // The cover goes up BEFORE the ActivityView goes away. The old code inserted a plain
            // transparent View here, so for the whole drag the pane was a hole onto the wallpaper
            // and the splash only appeared afterwards -- which is the "black first, then splash,
            // then app" sequence.
            String pkg = pkgOf(side);
            if (pkg != null) {
                WindowHostSplash.attach(paneHost, pkg);
            } else {
                final String tag = "WindowHostDualPane#Placeholder:" + side;
                View placeholder = paneHost.findViewWithTag(tag);
                if (placeholder == null) {
                    placeholder = new View(activity);
                    placeholder.setTag(tag);
                    placeholder.setClickable(false);
                    placeholder.setFocusable(false);
                    paneHost.addView(placeholder, new FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                } else {
                    placeholder.setVisibility(View.VISIBLE);
                }
            }

            View v = WindowHostActivityView.asView(avOf(side));
            if (v != null) v.setVisibility(View.GONE);
        }
    }

    private void restoreSurfaces() {
        if (!surfacesHidden.get()) return;
        surfacesHidden.set(false);

        for (Side side : Side.values()) {
            FrameLayout paneHost = hostOf(side);
            if (paneHost == null || !attachedOf(side)) continue;

            View placeholder = paneHost.findViewWithTag("WindowHostDualPane#Placeholder:" + side);
            if (placeholder != null) paneHost.removeView(placeholder);

            final Object paneAV = avOf(side);

            // Cover FIRST, then un-hide: the ActivityView's surface was destroyed while it was
            // GONE, so it comes back black for a frame or two. attach() re-uses the cover that
            // hideSurfaces() already put up, and re-raises it above the ActivityView.
            String pkg = pkgOf(side);
            if (pkg != null) WindowHostSplash.attach(paneHost, pkg);

            // Re-claim the position before un-hiding: making the ActivityView VISIBLE brings it
            // back into gatherTransparentRegion()'s reach, and if mLocationInWindow drifted during
            // the drag the very next traversal would report to the IME. Belt and braces on top of
            // the claim already done in setPaneWidths().
            claimPanePosition(side, (side == Side.LEFT) ? 0 : targetPaneWidth(Side.LEFT), 0);

            View v = WindowHostActivityView.asView(paneAV);
            if (v != null) v.setVisibility(View.VISIBLE);
            if (pkg != null) WindowHostSplash.attach(paneHost, pkg);   // keep it on top of the AV

            if (pkg != null) {
                final int myGen = gen;
                WindowHostSplash.dismissWhenReady(paneHost, paneAV,
                        DRAG_SPLASH_MIN_MS, DRAG_SPLASH_MAX_MS, () -> {
                    if (gen != myGen) return;
                    refreshTapRegionSafely(paneAV, TAP_REGION_RETRIES);
                });
            }

            applyPaneGeometry(side);
        }
    }

    private void scheduleRestore() {
        cancelPendingRestore();
        final int myGen = ++pendingRestoreGeneration;
        postMainDelayed(() -> {
            if (myGen == pendingRestoreGeneration) restoreSurfaces();
        }, SURFACE_RESTORE_DELAY_MS);
    }

    private void cancelPendingRestore() { ++pendingRestoreGeneration; }

    // =====================================================================================
    // 7. App launch
    // =====================================================================================

    private Rect launchBounds(Side side) {
        int totalW = hasPendingBounds && pendingBounds.width() > 0
                ? pendingBounds.width()
                : (root != null ? root.getWidth() : 0);
        int totalH = hasPendingBounds && pendingBounds.height() > 0
                ? pendingBounds.height()
                : (root != null ? root.getHeight() : 0);
        if (totalW <= 0 || totalH <= 0) return null;

        int originX = hasPendingBounds ? pendingBounds.left : 0;
        int originY = hasPendingBounds ? pendingBounds.top  : 0;

        int leftW = clampPx(Math.round(totalW * splitRatio),
                Math.round(totalW * MIN_SPLIT_RATIO), Math.round(totalW * MAX_SPLIT_RATIO));

        if (side == Side.LEFT) {
            return new Rect(originX, originY, originX + leftW, originY + totalH);
        }
        return new Rect(originX + leftW, originY, originX + totalW, originY + totalH);
    }

    private boolean isStartDeferred(Side side) {
        return side == Side.LEFT ? leftStartDeferredForBounds : rightStartDeferredForBounds;
    }

    private void setStartDeferred(Side side, boolean value) {
        if (side == Side.LEFT) leftStartDeferredForBounds = value;
        else rightStartDeferredForBounds = value;
    }

    private void startWhenReady(Side side, String pkg, int expectedGen) {
        waitUntil(() -> readyOf(side).get() && attachedOf(side), START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS,
                () -> { if (gen == expectedGen) startNow(side, pkg, expectedGen); },
                () -> { if (gen == expectedGen) startNow(side, pkg, expectedGen); });
    }

    private void startNow(Side side, String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null) return;
        if (taskOf(side) > 0 && pkg.equals(pkgOf(side))) return;

        postMainDelayed(() -> {
            if (gen != expectedGen) return;
            if (taskOf(side) > 0 && pkg.equals(pkgOf(side))) return;

            final Object paneAV = avOf(side);
            if (paneAV == null) return;

            // No IME priming. Geometry is applied through syncGeometryWithoutIme(), which never
            // sends a matrix to IMMS, so there is nothing to prime and nothing that can later be
            // delivered to the app as a non-null update.
            WindowHostActivityView.syncGeometryWithoutIme(paneAV);

            final Rect bounds = launchBounds(side);

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(paneAV, activity, pkg, bounds);
                if (ok) {
                    Log.i(TAG, side + ": start ok for " + pkg);
                    return;
                }

                Log.w(TAG, side + ": start failed for " + pkg + ", attempting fallback");
                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                    if (fallback == null) return;

                    Object opts = WindowHostActivityView.makeOptionsWithBounds(bounds);
                    boolean retryOk = WindowHostActivityView.startActivitySmart(paneAV, activity, fallback, opts);
                    Log.i(TAG, side + (retryOk ? ": fallback succeeded" : ": fallback failed"));
                    if (!retryOk) {
                        postMainDelayed(() -> {
                            if (gen == expectedGen) attemptMinimalLaunch(side, pkg, bounds);
                        }, 300);
                    }
                }, 200);
            } catch (Exception e) {
                Log.e(TAG, side + ": exception starting " + pkg, e);
                postMainDelayed(() -> {
                    if (gen == expectedGen) attemptMinimalLaunch(side, pkg, bounds);
                }, 300);
            }
        }, 80);
    }

    private void attemptMinimalLaunch(Side side, String pkg, Rect bounds) {
        try {
            Object paneAV = avOf(side);
            if (paneAV == null) return;

            Log.i(TAG, side + ": attempting minimal launch for " + pkg);
            Intent minimal = activity.getPackageManager().getLaunchIntentForPackage(pkg);
            if (minimal == null) {
                Log.e(TAG, side + ": no launch intent available");
                return;
            }
            minimal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ActivityOptions opts = (ActivityOptions) WindowHostActivityView.makeOptionsWithBounds(bounds);
            boolean success = WindowHostActivityView.startActivitySmart(paneAV, activity, minimal, opts);
            Log.i(TAG, side + ": minimal launch " + (success ? "succeeded" : "failed"));
        } catch (Exception e) {
            Log.e(TAG, side + ": minimal launch exception", e);
        }
    }

    // =====================================================================================
    // 8. Black-screen watchdog
    // =====================================================================================

    private void checkForBlackScreenAndRestart(Side side, String pkg, int expectedGen) {
        if (gen != expectedGen) return;

        postMainDelayed(() -> {
            if (gen != expectedGen) return;

            if (surfacesHidden.get()) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(side, pkg, expectedGen), 300);
                return;
            }

            int restartCount = (side == Side.LEFT) ? leftRestartCount : rightRestartCount;
            boolean isBlack = false;

            FrameLayout paneHost = hostOf(side);
            if (paneHost != null) {
                SurfaceView sv = findSurfaceView(paneHost);
                if (sv != null && sv.getVisibility() == View.VISIBLE) {
                    try {
                        SurfaceHolder holder = sv.getHolder();
                        if (holder == null || holder.getSurface() == null || !holder.getSurface().isValid()) {
                            isBlack = true;
                        }
                    } catch (Throwable ignore) {
                        isBlack = true;
                    }
                }
            }

            if (!firstFrameOf(side).get() && restartCount < MAX_RESTART_ATTEMPTS) isBlack = true;

            if (!isBlack) {
                if (side == Side.LEFT) leftBlackConfirmCount = 0; else rightBlackConfirmCount = 0;
                return;
            }
            if (blackOf(side).get() || restartCount >= MAX_RESTART_ATTEMPTS) return;

            int confirmCount;
            if (side == Side.LEFT) confirmCount = ++leftBlackConfirmCount;
            else                   confirmCount = ++rightBlackConfirmCount;

            if (confirmCount < REQUIRED_BLACK_CONFIRMATIONS) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(side, pkg, expectedGen), BLACK_SCREEN_CONFIRM_DELAY_MS);
                return;
            }

            Log.w(TAG, side + ": black screen confirmed, restarting " + pkg);
            blackOf(side).set(true);
            if (side == Side.LEFT) { leftBlackConfirmCount = 0; leftRestartCount++; }
            else                   { rightBlackConfirmCount = 0; rightRestartCount++; }

            restartPaneApp(side, pkg, expectedGen);
        }, BLACK_SCREEN_CHECK_DELAY_MS);
    }

    private void restartPaneApp(Side side, String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null || pkg.isEmpty()) return;

        forceStopApp(activity, pkg);

        postMainDelayed(() -> {
            if (gen != expectedGen) return;

            Object paneAV = avOf(side);
            if (paneAV != null) {
                try { WindowHostActivityView.release(paneAV); } catch (Throwable ignore) {}
                resetVdCache(paneAV);
            }

            if (side == Side.LEFT) {
                leftAV = null; leftTask = -1;
                leftReady.set(false); leftFirstFrame.set(false); leftBlackScreenDetected.set(false);
                if (leftHost != null) { leftHost.removeAllViews(); leftAttached = false; }
            } else {
                rightAV = null; rightTask = -1;
                rightReady.set(false); rightFirstFrame.set(false); rightBlackScreenDetected.set(false);
                if (rightHost != null) { rightHost.removeAllViews(); rightAttached = false; }
            }

            ensureActivityView(activity, expectedGen);
            attachPane(side);

            postMainDelayed(() -> {
                if (gen != expectedGen) return;
                startWhenReady(side, pkg, expectedGen);
                checkForBlackScreenAndRestart(side, pkg, expectedGen);
                scheduleSplashReveal(side, expectedGen);
            }, 300);
        }, 500);
    }

    private static void forceStopApp(Context ctx, String pkg) {
        if (pkg == null || pkg.isEmpty() || ctx == null) return;
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(am, pkg);
            Log.i(TAG, "Force stopped " + pkg);
        } catch (Throwable t) {
            Log.w(TAG, "Failed to force stop " + pkg, t);
        }
    }

    // =====================================================================================
    // 9. Split ratio & divider
    // =====================================================================================

    /**
     * Shows the divider on top of the handoff covers but makes it non-draggable.
     */
    private void freezeDivider() {
        dividerFrozen = true;
        dragController.interactive.set(false);

        final int myFreeze = ++dividerFreezeGeneration;
        raiseDividerAboveCovers();

        if (divider != null) divider.setAlpha(DIVIDER_FROZEN_ALPHA);

        postMainDelayed(() -> {
            if (myFreeze == dividerFreezeGeneration) thawDivider();
        }, DIVIDER_FREEZE_MAX_MS);
    }

    private void thawDivider() {
        dividerFreezeGeneration++;
        dividerFrozen = false;
        if (divider != null) divider.setAlpha(1f);
        // Never re-arm the drag on a pane that is on its way out.
        dragController.interactive.set(visible.get());
    }

    /** Covers call bringToFront(); the divider has to be raised after them to stay on top. */
    private void raiseDividerAboveCovers() {
        try {
            if (divider != null) divider.bringToFront();
            if (dividerHandle != null && extendedDividerEnabled) dividerHandle.bringToFront();
        } catch (Throwable ignore) { }
    }

    /**
     * Reads Keys.EXTENDED_DIVIDER and shows or hides the wide grab handle accordingly.
     */
    private void applyDividerPreference() {
        boolean enabled = EXTENDED_DIVIDER_DEFAULT;
        try {
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            enabled = sp.getBoolean(Keys.EXTENDED_DIVIDER, EXTENDED_DIVIDER_DEFAULT);
        } catch (Throwable t) {
            Log.w(TAG, "applyDividerPreference: falling back to default", t);
        }

        extendedDividerEnabled = enabled;
        if (dividerHandle == null) return;

        int want = enabled ? View.VISIBLE : View.GONE;
        if (dividerHandle.getVisibility() != want) {
            dividerHandle.setVisibility(want);
            // The pane's touchable area just changed -- recompute both tap-exclude regions.
            refreshTapRegionSafely(leftAV, TAP_REGION_RETRIES);
            refreshTapRegionSafely(rightAV, TAP_REGION_RETRIES);
        }
    }

    private void setSplitRatio(float r) {
        if (r < MIN_SPLIT_RATIO) r = MIN_SPLIT_RATIO;
        if (r > MAX_SPLIT_RATIO) r = MAX_SPLIT_RATIO;
        this.splitRatio = r;
    }

    private float loadSplitRatio() {
        try {
            SharedPreferences sp = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            float r = sp.getFloat(KEY_SPLIT, 0.5f);
            if (r < MIN_SPLIT_RATIO) r = MIN_SPLIT_RATIO;
            if (r > MAX_SPLIT_RATIO) r = MAX_SPLIT_RATIO;
            return r;
        } catch (Throwable t) {
            return 0.5f;
        }
    }

    private void saveSplitRatio() {
        try {
            SharedPreferences sp = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            sp.edit().putFloat(KEY_SPLIT, splitRatio).apply();
        } catch (Throwable ignore) {}
    }

    /**
     * Everything visible: the light bar and the grip dots, both centred on the split line and both
     * living here regardless of Keys.EXTENDED_DIVIDER. The preference must change the touch area
     * only -- the divider has to look identical either way.
     */
    static final class DividerView extends FrameLayout {
        DividerView(Context ctx, int visualWidthPx) {
            super(ctx);
            setWillNotDraw(false);
            setBackgroundColor(Color.TRANSPARENT);

            View bar = new View(ctx);
            bar.setLayoutParams(new LayoutParams(visualWidthPx, LayoutParams.MATCH_PARENT, Gravity.CENTER));
            bar.setBackgroundColor(0xFFE0E0E0);
            addView(bar);

            View dots = new VerticalDotsView(ctx, 0xFF666666, 2.5f, 9f);
            addView(dots, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER));
        }
    }

    /**
     * Invisible, wide but short grab area centred on the divider -- nothing is drawn here, it
     * exists purely to enlarge the touch target around the grip dots. Toggling it therefore has no
     * visual effect whatsoever.
     */
    static final class DividerHandleView extends FrameLayout {
        DividerHandleView(Context ctx) {
            super(ctx);
            setWillNotDraw(true);
            setBackgroundColor(Color.TRANSPARENT);
        }
    }

    static final class VerticalDotsView extends View {
        private final Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final float dotRadiusPx;
        private final float spacingPx;

        VerticalDotsView(Context ctx, int dotColor, float dotRadiusDp, float spacingDp) {
            super(ctx);
            float d = ctx.getResources().getDisplayMetrics().density;
            p.setColor(dotColor);
            dotRadiusPx = dotRadiusDp * d;
            spacingPx = spacingDp * d;
            setWillNotDraw(false);
        }

        @Override protected void onDraw(@NonNull android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            float cx = getWidth() / 2f, cy = getHeight() / 2f;
            canvas.drawCircle(cx, cy - spacingPx, dotRadiusPx, p);
            canvas.drawCircle(cx, cy,             dotRadiusPx, p);
            canvas.drawCircle(cx, cy + spacingPx, dotRadiusPx, p);
        }

        @Override protected void onMeasure(int w, int h) {
            setMeasuredDimension(Math.round(dotRadiusPx * 2.8f), Math.round(spacingPx * 4 + dotRadiusPx * 6));
        }
    }

    private final class DividerDragController implements View.OnTouchListener, Choreographer.FrameCallback {
        private static final long MIN_APPLY_INTERVAL_MS = 100;

        private final float SLOP = ViewConfiguration.get(LauncherApplication.sApp).getScaledTouchSlop();
        final AtomicBoolean interactive = new AtomicBoolean(true);

        private boolean dragging = false, posted = false, touchCaptured = false;
        private float downRawX, downRawY;
        private int startLeftW;
        private int pendingLeft = -1, pendingRight = -1;
        private int minW, maxW, totalW;
        private long lastAppliedAtMs = 0;

        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if (!interactive.get()) return false;
            if (root == null || leftHost == null || rightHost == null) return false;

            switch (e.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    downRawX = e.getRawX();
                    downRawY = e.getRawY();
                    dragging = posted = touchCaptured = false;

                    totalW = hasPendingBounds ? pendingBounds.width() : root.getWidth();
                    if (totalW <= 0) totalW = Math.max(1, root.getWidth());

                    minW = Math.round(totalW * MIN_SPLIT_RATIO);
                    maxW = Math.round(totalW * MAX_SPLIT_RATIO);
                    startLeftW = clampPx(Math.round(totalW * splitRatio), minW, maxW);

                    pendingLeft = pendingRight = -1;
                    return true;
                }

                case MotionEvent.ACTION_MOVE: {
                    float adx = Math.abs(e.getRawX() - downRawX);
                    float ady = Math.abs(e.getRawY() - downRawY);

                    if (!touchCaptured) {
                        if (adx <= SLOP && ady <= SLOP) return true;
                        if (adx <= ady) return false;

                        touchCaptured = true;
                        dragging = true;
                        try { v.getParent().requestDisallowInterceptTouchEvent(true); } catch (Throwable ignore) {}

                        // The show() path schedules its own unconditional restoreSurfaces() 500ms
                        // after the pane appears. Starting a drag inside that window used to let
                        // the stale timer fire mid-drag and undo the GONE-based hide.
                        cancelPendingRestore();
                        hideSurfaces();
                    }

                    if (!dragging || totalW <= 0) return true;

                    int candidate = startLeftW + Math.round(e.getRawX() - downRawX);
                    int newLeft = clampPx(candidate, minW, maxW);
                    int newRight = totalW - newLeft;

                    if (pendingLeft != newLeft || pendingRight != newRight) {
                        pendingLeft = newLeft;
                        pendingRight = newRight;
                        if (!posted) {
                            posted = true;
                            Choreographer.getInstance().postFrameCallback(this);
                        }
                    }
                    return true;
                }

                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL: {
                    if (!touchCaptured) return false;

                    if (dragging) {
                        if (pendingLeft >= 0) commitWidths(pendingLeft, pendingRight);
                        dragging = posted = false;
                        pendingLeft = pendingRight = -1;
                        saveSplitRatio();

                        // One real, expensive resize -- after the drag, not during it.
                        postMainDelayed(WindowHostDualPane.this::restoreSurfaces, 120);
                    }

                    touchCaptured = false;
                    try { v.getParent().requestDisallowInterceptTouchEvent(false); } catch (Throwable ignore) {}
                    return true;
                }
            }
            return false;
        }

        @Override
        public void doFrame(long frameTimeNanos) {
            posted = false;
            if (pendingLeft < 0) return;

            long now = SystemClock.uptimeMillis();
            if ((now - lastAppliedAtMs) < MIN_APPLY_INTERVAL_MS) {
                // Throttle: a real container resize on every frame dispatches a config change to
                // the embedded app on every frame, which is exactly the burst that used to make
                // an app with IME focus die inside InputMethodManager$H.
                posted = true;
                Choreographer.getInstance().postFrameCallback(this);
                return;
            }

            lastAppliedAtMs = now;
            commitWidths(pendingLeft, pendingRight);
        }

        /** Container-only resize during the drag; content geometry follows in restoreSurfaces(). */
        private void commitWidths(int leftW, int rightW) {
            if (root == null || leftHost == null || rightHost == null || divider == null) return;
            if (leftAV != null && WindowUtil.isReparentUnsettled(WindowHostActivityView.asView(leftAV))) return;
            if (rightAV != null && WindowUtil.isReparentUnsettled(WindowHostActivityView.asView(rightAV))) return;

            int tw = Math.max(1, leftW + rightW);
            int clampedLeft = clampPx(leftW, Math.round(tw * MIN_SPLIT_RATIO), Math.round(tw * MAX_SPLIT_RATIO));
            int clampedRight = tw - clampedLeft;

            setSplitRatio((float) clampedLeft / (float) tw);
            setPaneWidths(clampedLeft, clampedRight);
        }
    }

    // =====================================================================================
    // 10. Utilities
    // =====================================================================================

    private SurfaceView findSurfaceView(View v) {
        return WindowHostActivityView.findSurfaceView(v);
    }

    private void waitUntil(BooleanSupplier cond, int timeoutMs, int stepMs, Runnable onOk, Runnable onTimeout) {
        final long start = SystemClock.uptimeMillis();
        final Runnable[] tick = new Runnable[1];
        tick[0] = () -> {
            if (cond.getAsBoolean()) { onOk.run(); return; }
            if (SystemClock.uptimeMillis() - start >= timeoutMs) { onTimeout.run(); return; }
            postMainDelayed(tick[0], stepMs);
        };
        postMain(tick[0]);
    }

    /**
     * Runs r BEFORE the next traversal (Choreographer CALLBACK_ANIMATION).
     * Use for retry loops only -- never for code that reads a size.
     */
    private static void postNextFrame(Runnable r) {
        try { Choreographer.getInstance().postFrameCallback(ft -> r.run()); }
        catch (Throwable t) { new Handler(Looper.getMainLooper()).postDelayed(r, 16); }
    }

    /** Runs r AFTER the next measure/layout pass of v (with a timeout fallback). */
    private static void postAfterLayout(final View v, final Runnable r) {
        if (v == null || r == null) return;

        final AtomicBoolean done = new AtomicBoolean(false);
        final ViewTreeObserver vto = v.getViewTreeObserver();
        final ViewTreeObserver.OnPreDrawListener[] l = new ViewTreeObserver.OnPreDrawListener[1];

        l[0] = () -> {
            try {
                ViewTreeObserver o = v.isAttachedToWindow() ? v.getViewTreeObserver() : vto;
                if (o.isAlive()) o.removeOnPreDrawListener(l[0]);
            } catch (Throwable ignore) {}
            if (done.getAndSet(true)) return true;
            try { r.run(); } catch (Throwable ignore) {}
            return true;
        };

        try { vto.addOnPreDrawListener(l[0]); }
        catch (Throwable t) { postNextFrame(r); return; }

        v.requestLayout();
        v.invalidate();

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (done.getAndSet(true)) return;
            try {
                ViewTreeObserver o = v.isAttachedToWindow() ? v.getViewTreeObserver() : vto;
                if (o.isAlive()) o.removeOnPreDrawListener(l[0]);
            } catch (Throwable ignore) {}
            try { r.run(); } catch (Throwable ignore) {}
        }, POST_LAYOUT_FALLBACK_MS);
    }

    private void postMain(Runnable r) { new Handler(Looper.getMainLooper()).post(r); }

    private void postMainDelayed(Runnable r, long delayMs) {
        new Handler(Looper.getMainLooper()).postDelayed(r, delayMs);
    }

    private static int dp(int v) {
        return Math.round(LauncherApplication.sApp.getResources().getDisplayMetrics().density * v);
    }

    private static int clampPx(int v, int min, int max) {
        if (v < min) return min;
        return Math.min(v, max);
    }

    private static void disableTouchRecursively(View v) {
        if (v == null) return;
        try {
            v.setOnTouchListener(null);
            v.setOnClickListener(null);
            v.setOnLongClickListener(null);
            v.setClickable(false);
            v.setFocusable(false);
            v.setFocusableInTouchMode(false);
            v.setVisibility(View.GONE);
        } catch (Throwable ignore) {}

        if (v instanceof ViewGroup) {
            ViewGroup g = (ViewGroup) v;
            for (int i = 0; i < g.getChildCount(); i++) disableTouchRecursively(g.getChildAt(i));
        }
    }
}
