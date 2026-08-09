package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Choreographer;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

/**
 * Hosts ONE embedded app in its own WindowManager window.
 *
 * Reflection contract used by WindowUtil (do not rename):
 *   fields:  av, host, currentPkg, childAttached, taskId, added
 *   methods: show, updateBounds, dismissAsync, cleanup, isVisible,
 *            resyncGeometryAfterSurfaceSwap, flushPendingResizes
 */
public class WindowHostSinglePane {

    // =====================================================================================
    // 1. Constants & fields
    // =====================================================================================

    private static final String TAG = "WindowHostSinglePane";

    private static final long BLACK_SCREEN_CHECK_DELAY_MS   = 800L;
    private static final long BLACK_SCREEN_CONFIRM_DELAY_MS = 800L;
    private static final int  REQUIRED_BLACK_CONFIRMATIONS  = 2;
    private static final int  MAX_RESTART_ATTEMPTS          = 2;

    private static final int  START_WAIT_TIMEOUT_MS   = 600;
    private static final int  START_WAIT_STEP_MS      = 4;

    private static final int  GEOMETRY_RETRIES        = 30;
    private static final int  EXTRA_SETTLE_RETRIES    = 20;
    private static final int  TAP_REGION_RETRIES      = 4;
    private static final long POST_LAYOUT_FALLBACK_MS = 250L;
    /**
     * A pane whose launch was deferred because the initial bounds were not real yet must never
     * stay empty forever. In the captured failure the workspace was not laid out when
     * openMultiplePips() ran, every pane got the offscreen fallback rect, the follow-up bounds
     * update never arrived, and the panes sat there with no app in them at all.
     */
    private static final long DEFERRED_START_WATCHDOG_MS = 2500L;
    /** See the matching note in WindowHostDualPane: a swap needs a MINIMUM cover time. */
    private static final long SWAP_SPLASH_MIN_MS = 900L;
    private static final long SWAP_SPLASH_MAX_MS = 3000L;
    /** Cold start: the app has to actually draw, and a heavy one (Maps) needs well over a second. */
    private static final String HANDOFF_KEY = "WindowHostSplash#handoff";
    private static final long COLD_SPLASH_MIN_MS = 600L;
    private static final long COLD_SPLASH_MAX_MS = 3500L;

    private static final ScheduledExecutorService DISMISS_EXEC =
            Executors.newSingleThreadScheduledExecutor();

    private final String name;

    private Activity activity;
    private WindowManager wm;
    private WindowManager.LayoutParams lp;
    private FrameLayout root, host;

    public boolean added;
    private boolean childAttached;

    private Object av;
    /** ActivityView identity as of the last resync -- used to detect whether a swap touched us. */
    private Object lastSeenAv;
    private final AtomicBoolean avReady    = new AtomicBoolean(false);
    private final AtomicBoolean firstFrame = new AtomicBoolean(false);
    private final AtomicBoolean visible    = new AtomicBoolean(false);

    private String currentPkg = null;
    private int taskId = -1;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;
    private boolean startDeferredForBounds = false;

    private int restartCount = 0;
    private int blackConfirmCount = 0;
    private final AtomicBoolean blackScreenDetected = new AtomicBoolean(false);

    /** Last size actually pushed into each ActivityView's VirtualDisplay. */
    private final Map<Object, int[]> vdSizeCache = new WeakHashMap<>();

    // =====================================================================================
    // 2. Construction & state queries
    // =====================================================================================

    WindowHostSinglePane(String name) { this.name = name; }

    boolean isVisible() { return visible.get(); }

    // =====================================================================================
    // 3. Public API
    // =====================================================================================

    void show(Activity act, WindowManager wm, IBinder token, String pkg, Rect b) {
        if (pkg == null || b == null) return;

        this.activity = act;
        this.wm = wm;

        if (visible.get() && pkg.equals(currentPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            return;
        }

        final int myGen = ++gen;

        restartCount = 0;
        blackConfirmCount = 0;
        blackScreenDetected.set(false);
        resetVdCache();

        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            ensureWindow(act, wm, token);
            setPendingBoundsFast(b);
            ensureActivityView(act, myGen);
            if (!childAttached) attachPane();

            boolean haveTask = (taskId > 0) && pkg.equals(currentPkg);
            currentPkg = pkg;
            firstFrame.set(false);
            visible.set(true);

            applyPaneGeometry();

            if (!haveTask) {
                // Every app now waits for real bounds -- launching with degenerate bounds is
                // what makes an embedded app fall back to the classic PiP UI.
                if (WindowHostActivityView.shouldWaitForRealBounds(b)) {
                    startDeferredForBounds = true;
                    armDeferredStartWatchdog(pkg, myGen);
                } else {
                    startDeferredForBounds = false;
                    startWhenReady(pkg, myGen);
                    checkForBlackScreenAndRestart(pkg, myGen);
                }
            }
            // Cover the pane with the app's icon splash and take it down only once the app is
            // really on screen. Removing the splash un-obscures the ActivityView, so the
            // tap-exclude region has to be recomputed afterwards.
            WindowHostSplash.attach(host, pkg);
            WindowHostSplash.dismissWhenReady(host, av,
                    COLD_SPLASH_MIN_MS, COLD_SPLASH_MAX_MS, () -> {
                if (gen != myGen) return;
                refreshTapRegionSafely(av, TAP_REGION_RETRIES);
            });
        });
    }

    public void updateBounds(Rect b) {
        boolean boundsChanged = !hasPendingBounds || !pendingBounds.equals(b);
        setPendingBoundsFast(b);
        if (boundsChanged) applyPaneGeometry();

        if (startDeferredForBounds
                && currentPkg != null
                && WindowHostActivityView.hasRealLaunchBounds(b)) {
            startDeferredForBounds = false;
            Log.i(TAG, name + ": starting deferred app after bounds update: " + b);
            startWhenReady(currentPkg, gen);
            checkForBlackScreenAndRestart(currentPkg, gen);
        }
    }

    /** True while this pane is up but still waiting for usable bounds before it may launch. */
    public boolean isAwaitingBounds() {
        return visible.get() && startDeferredForBounds;
    }

    /**
     * Last-resort launch: if the bounds update that should release a deferred start never comes,
     * start the app anyway with whatever bounds the pane currently has. An imperfect first frame
     * is recoverable; an empty pane is not.
     */
    private void armDeferredStartWatchdog(final String pkg, final int expectedGen) {
        postMainDelayed(() -> {
            if (gen != expectedGen || !startDeferredForBounds || pkg == null) return;
            startDeferredForBounds = false;
            Log.w(TAG, name + ": bounds update never arrived, starting " + pkg + " anyway");
            startWhenReady(pkg, expectedGen);
            checkForBlackScreenAndRestart(pkg, expectedGen);
        }, DEFERRED_START_WATCHDOG_MS);
    }

    void dismissAsync() {
        final int myGen = ++gen;
        visible.set(false);
        parkInvisible();
        postMain(() -> hardRemoveWindow(false, myGen));
        DISMISS_EXEC.schedule(() -> postMain(() -> {
            if (gen != myGen) return;
            if (added || root != null) hardRemoveWindow(false, myGen);
        }), 150, TimeUnit.MILLISECONDS);
    }

    void cleanup() {
        final int myGen = ++gen;
        visible.set(false);
        hardRemoveWindow(true, myGen);
        if (av != null) { WindowHostActivityView.release(av); av = null; }
        avReady.set(false);
        firstFrame.set(false);
        currentPkg = null;
        taskId = -1;
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;
        resetVdCache();
    }

    /** Called by WindowUtil after a native surface swap moved an ActivityView in or out. */
    public void resyncGeometryAfterSurfaceSwap() {
        resetVdCache();
        applyPaneGeometry();

        // Only act when this pane's ActivityView actually moved. primeImeGeometry() on a pane that
        // was not part of the swap sends a non-null ActivityView matrix to an app that is bound to
        // the IME right now, and that kills it -- see WindowHostDualPane for the log evidence.
        boolean changed = (lastSeenAv == null) || (lastSeenAv != av);
        lastSeenAv = av;
        if (!changed || av == null) return;

        // Keep the icon raised at the start of the swap; fade straight to the incoming app.
        coverForHandoff(true, null);

        final Object paneAV = av;
        // No IME priming here any more -- see WindowHostDualPane for the reasoning.
        WindowHostActivityView.syncGeometryWithoutIme(paneAV);
        postMainDelayed(() -> WindowHostActivityView.syncGeometryWithoutIme(paneAV), 60);

        postMainDelayed(this::uncoverAfterHandoff, 120);
    }

    /**
     * Raises the launch cover and keeps it up until uncoverAfterHandoff() decides otherwise.
     * See the matching note in WindowHostDualPane: the cover has to go up BEFORE the swap starts.
     */
    public void coverForHandoff() { coverForHandoff(false, null); }

    /**
     * The cover shows the icon of the app that is ARRIVING, not the one that is leaving -- only
     * WindowUtil knows it at this point, because the pane fields are swapped later.
     */
    public void coverForHandoff(String incomingPkg) { coverForHandoff(false, incomingPkg); }

    private void coverForHandoff(boolean keepIcon, String incomingPkg) {
        // Into root, NOT into host: WindowUtil calls host.removeAllViews() in the middle of every
        // swap, which would take the cover down with it. See WindowHostDualPane for the details.
        String pkg = (incomingPkg != null && !incomingPkg.isEmpty()) ? incomingPkg : currentPkg;
        if (root != null && pkg != null) {
            WindowHostSplash.attach(root, HANDOFF_KEY, pkg, null, keepIcon);
        }
    }

    /** Takes the handoff cover down once the swapped-in content is composited. */
    public void uncoverAfterHandoff() {
        if (root == null || av == null) return;
        final int myGen = gen;
        final Object paneAV = av;
        WindowHostSplash.dismissWhenReady(root, HANDOFF_KEY, paneAV,
                SWAP_SPLASH_MIN_MS, SWAP_SPLASH_MAX_MS, () -> {
            if (gen != myGen) return;
            refreshTapRegionSafely(paneAV, TAP_REGION_RETRIES);
        });
    }

    /** Applies any geometry that is still pending, immediately. */
    public void flushPendingResizes() {
        applyPaneGeometry();
    }

    /**
     * Hands this pane's ActivityView over to the caller and forgets about it.
     *
     * Used when the whole WindowHost is being replaced: the ActivityView must NOT be released
     * here, because its VirtualDisplay still hosts the embedded task and releasing it would kill
     * the app's state. WindowHostAvReaper releases it only once the task has moved elsewhere.
     */
    void takeActivityViews(java.util.List<Object> out) {
        if (av == null) return;
 
        try {
            View v = WindowHostActivityView.asView(av);
            if (v != null && v.getParent() instanceof ViewGroup) {
                ((ViewGroup) v.getParent()).removeView(v);
            }
        } catch (Throwable ignore) { }
 
        childAttached = false;
        out.add(av);
 
        resetVdCache(av);
        av = null;
        taskId = -1;
        avReady.set(false);
        firstFrame.set(false);
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
        rootView.setAlpha(1f);

        FrameLayout container = new FrameLayout(act);
        container.setBackgroundColor(Color.TRANSPARENT);
        container.setWillNotDraw(true);

        // No black curtain here any more: the launch cover lives INSIDE the pane container
        // (WindowHostSplash), so it is sized to the pane and can carry the app's icon.
        int match = ViewGroup.LayoutParams.MATCH_PARENT;
        rootView.addView(container, new FrameLayout.LayoutParams(match, match));

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
        p.setTitle("PipWindowHost:" + name);

        try { wm.addView(rootView, p); added = true; }
        catch (Throwable t) {
            try { p.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG; wm.addView(rootView, p); added = true; }
            catch (Throwable t2) { throw new RuntimeException("Unable to create host window for " + name, t2); }
        }

        this.root = rootView;
        this.host = container;
        this.lp = p;
    }

    /** Moves/resizes the host window. Pane geometry is applied separately by applyPaneGeometry(). */
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

    private void hardRemoveWindow(boolean releaseAV, int expectedGen) {
        if (gen != expectedGen) return;

        clearTapRegionQuietly(av);

        if (root != null) WindowHostSplash.removeImmediately(root, HANDOFF_KEY);
        if (host != null) {
            WindowHostSplash.removeImmediately(host);
            if (childAttached) {
                try { host.removeAllViews(); } catch (Throwable ignore) {}
                childAttached = false;
            }
        }

        final View toRemove = root;
        final WindowManager wmRef = wm;

        if (added && wmRef != null && toRemove != null) {
            try { wmRef.removeViewImmediate(toRemove); }
            catch (Throwable t) { Log.w(TAG, name + ": hardRemoveWindow: removeViewImmediate threw", t); }
        }

        if (releaseAV && av != null) {
            try { WindowHostActivityView.release(av); } catch (Throwable ignore) {}
            resetVdCache(av);
            av = null; taskId = -1; avReady.set(false);
        }

        added = false;
        visible.set(false);
        root = null; host = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;

        if (toRemove != null && wmRef != null) verifyDetached(toRemove, wmRef, 0);
    }

    private void forceRemoveWindowNoGen() {
        clearTapRegionQuietly(av);

        if (root != null) WindowHostSplash.removeImmediately(root, HANDOFF_KEY);
        if (host != null) {
            WindowHostSplash.removeImmediately(host);
            if (childAttached) {
                try { host.removeAllViews(); } catch (Throwable ignore) {}
                childAttached = false;
            }
        }
        if (added && wm != null && root != null) {
            try { wm.removeViewImmediate(root); } catch (Throwable ignore) {}
        }
        added = false;
        visible.set(false);
        root = null; host = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;
    }

    private void parkInvisible() {
        if (!(added && wm != null && lp != null && root != null)) return;

        lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
        lp.width = 600; lp.height = 600;
        lp.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        try { wm.updateViewLayout(root, lp); }
        catch (Throwable t) {
            Log.w(TAG, name + ": parkInvisible updateViewLayout failed, forcing removal", t);
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

            Log.w(TAG, name + ": verifyDetached: still attached (attempt " + attempt + "), forcing again");
            try { wmRef.removeViewImmediate(v); } catch (Throwable ignore) {}

            if (attempt < 10) {
                verifyDetached(v, wmRef, attempt + 1);
            } else {
                Log.e(TAG, name + ": giving up after " + (attempt + 1) + " attempts - neutralizing leaked view");
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
        if (av != null) return;

        // A fresh instance, always. The pre-warm pool used to be skipped for Maps only, because a
        // pooled ActivityView (pre-measured at 800x600, canvas-locked, carrying stale holder
        // callbacks) is what pushed an embedded app into the degraded PiP-style UI. That applies
        // to every app, so the pool is simply not used here any more.
        av = WindowHostActivityView.newInstance(ctx);

        avReady.set(false);
        firstFrame.set(false);
        WindowHostActivityView.trySetCallback(av, new WindowHostActivityView.Callback() {
            @Override public void onReady()             { if (gen == expectedGen) avReady.set(true); }
            @Override public void onTaskCreated(int id) { if (gen == expectedGen) taskId = id; }
            @Override public void onDestroyed()         { if (gen == expectedGen) avReady.set(false); }
        });
    }

    private void attachPane() {
        if (host == null || av == null) return;

        resetVdCache(av);

        View v = WindowHostActivityView.asView(av);
        if (v == null) return;

        resetActivityViewForReuse(av);
        clearTapRegionQuietly(av);

        if (v.getParent() instanceof ViewGroup) {
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {}
        }
        host.removeAllViews();
        v.setVisibility(View.VISIBLE);

        hookFirstFrame(v);

        host.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        childAttached = true;
        lastSeenAv = av;

        if (currentPkg != null) WindowHostSplash.attach(host, currentPkg);

        applyPaneGeometry();
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

    private void hookFirstFrame(View paneRoot) {
        SurfaceView sv = findSurfaceView(paneRoot);
        if (sv != null) {
            try {
                sv.getHolder().addCallback(new SurfaceHolder.Callback2() {
                    @Override public void surfaceCreated(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                        if (width > 0 && height > 0) firstFrame.set(true);
                    }
                    @Override public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceRedrawNeeded(@NonNull SurfaceHolder holder) { firstFrame.set(true); }
                });
            } catch (Throwable ignore) {}
            return;
        }

        paneRoot.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            boolean done;
            @Override public boolean onPreDraw() {
                if (done) return true;
                done = true;
                postNextFrame(() -> firstFrame.set(true));
                try { paneRoot.getViewTreeObserver().removeOnPreDrawListener(this); } catch (Throwable ignore) {}
                return true;
            }
        });
    }

    // =====================================================================================
    // 6. Geometry -- the single entry point for "this pane is now W x H"
    // =====================================================================================

    private void applyPaneGeometry() { applyPaneGeometry(GEOMETRY_RETRIES); }

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
     *     the OLD size to both the VirtualDisplay and the tap-exclude region.
     */
    private void applyPaneGeometry(int retriesLeft) {
        if (host == null || av == null || !childAttached) return;

        final View v = WindowHostActivityView.asView(av);
        if (v == null) return;

        if (WindowUtil.isReparentUnsettled(v)) {
            if (retriesLeft > 0) {
                postNextFrame(() -> applyPaneGeometry(retriesLeft - 1));
            } else {
                Log.w(TAG, name + ": applyPaneGeometry: reparent guard still set, extending wait");
                postMainDelayed(() -> applyPaneGeometry(EXTRA_SETTLE_RETRIES), 100);
            }
            return;
        }

        final int targetW = targetPaneWidth();
        final int targetH = targetPaneHeight();
        if (targetW <= 1 || targetH <= 1) {
            if (retriesLeft > 0) postNextFrame(() -> applyPaneGeometry(retriesLeft - 1));
            return;
        }

        applyChildSize(v, targetW, targetH);

        final FrameLayout paneHost = host;
        postAfterLayout(paneHost, () -> {
            if (host != paneHost || av == null || !childAttached) return;
            if (!v.isAttachedToWindow()) return;

            int w = paneHost.getWidth()  > 0 ? paneHost.getWidth()  : targetW;
            int h = paneHost.getHeight() > 0 ? paneHost.getHeight() : targetH;
            if (w <= 1 || h <= 1) return;

            resetSurfaceSizeFromLayout(av);
            enforcePaneVirtualDisplay(av, w, h);
            refreshTapRegionSafely(av, TAP_REGION_RETRIES);
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
    private int targetPaneWidth() {
        if (hasPendingBounds && pendingBounds.width() > 0) return pendingBounds.width();
        if (host != null) {
            ViewGroup.LayoutParams hlp = host.getLayoutParams();
            if (hlp != null && hlp.width > 0) return hlp.width;
            if (host.getWidth() > 0) return host.getWidth();
        }
        return 0;
    }

    private int targetPaneHeight() {
        if (hasPendingBounds && pendingBounds.height() > 0) return pendingBounds.height();
        if (host != null) {
            ViewGroup.LayoutParams hlp = host.getLayoutParams();
            if (hlp != null && hlp.height > 0) return hlp.height;
            if (host.getHeight() > 0) return host.getHeight();
        }
        return 0;
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

        int[] last = vdSizeCache.get(paneAV);
        if (last != null && last[0] == width && last[1] == height && last[2] == safeDensity) {
            return false;
        }

        Object vd = WindowHostActivityView.getVirtualDisplay(paneAV);
        if (vd == null) {
            Log.d(TAG, name + ": resizeVD skip - mVirtualDisplay is null (avReady=" + avReady.get() + ")");
            return false;
        }

        try {
            Method resize = vd.getClass().getMethod("resize", int.class, int.class, int.class);
            resize.invoke(vd, width, height, safeDensity);
        } catch (Throwable t) {
            Log.w(TAG, name + ": resizeVirtualDisplay failed: " + width + "x" + height + " @" + safeDensity, t);
            return false;
        }

        vdSizeCache.put(paneAV, new int[]{ width, height, safeDensity });
        Log.d(TAG, name + ": resizeVD OK -> " + width + "x" + height + " @" + safeDensity);
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
            Log.w(TAG, name + ": resetSurfaceSizeFromLayout failed", t);
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
            Log.w(TAG, name + ": refreshTapRegionSafely failed", ite);
        } catch (Throwable t) {
            Log.w(TAG, name + ": refreshTapRegionSafely failed", t);
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
    // 7. App launch
    // =====================================================================================

    private Rect launchBounds() {
        if (!hasPendingBounds || pendingBounds.width() <= 0 || pendingBounds.height() <= 0) {
            if (root != null && root.getWidth() > 0 && root.getHeight() > 0) {
                return new Rect(0, 0, root.getWidth(), root.getHeight());
            }
            return null;
        }
        return new Rect(pendingBounds);
    }

    private void startWhenReady(String pkg, int expectedGen) {
        waitUntil(() -> avReady.get() && childAttached, START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS,
                () -> { if (gen == expectedGen) startNow(pkg, expectedGen); },
                () -> { if (gen == expectedGen) startNow(pkg, expectedGen); });
    }

    private void startNow(String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (taskId > 0 && pkg.equals(currentPkg)) return;

        final Runnable doStart = () -> {
            if (gen != expectedGen) return;
            if (taskId > 0 && pkg.equals(currentPkg)) return;

            if (host != null) {
                SurfaceView sv = findSurfaceView(host);
                if (sv != null) {
                    try {
                        SurfaceHolder holder = sv.getHolder();
                        if (holder == null || holder.getSurface() == null || !holder.getSurface().isValid()) {
                            Log.w(TAG, name + ": surface not ready yet, deferring start");
                            postMainDelayed(() -> startNow(pkg, expectedGen), 50);
                            return;
                        }
                    } catch (Throwable t) {
                        postMainDelayed(() -> startNow(pkg, expectedGen), 50);
                        return;
                    }
                }
            }

            // No IME priming. Geometry is applied through syncGeometryWithoutIme(), which never
            // sends a matrix to IMMS, so there is nothing to prime and nothing that can later be
            // delivered to the app as a non-null update.
            WindowHostActivityView.syncGeometryWithoutIme(av);

            final Rect bounds = launchBounds();

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(av, activity, pkg, bounds);
                if (ok) {
                    Log.i(TAG, name + ": start ok for " + pkg);
                    return;
                }

                Log.w(TAG, name + ": start failed for " + pkg + ", attempting fallback");
                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                    if (fallback == null) return;

                    Object opts = WindowHostActivityView.makeOptionsWithBounds(bounds);
                    boolean retryOk = WindowHostActivityView.startActivitySmart(av, activity, fallback, opts);
                    Log.i(TAG, name + (retryOk ? ": fallback succeeded" : ": fallback failed"));
                    if (!retryOk) {
                        postMainDelayed(() -> {
                            if (gen == expectedGen) attemptMinimalLaunch(pkg, bounds);
                        }, 300);
                    }
                }, 200);
            } catch (Exception e) {
                Log.e(TAG, name + ": exception starting " + pkg, e);
                postMainDelayed(() -> {
                    if (gen == expectedGen) attemptMinimalLaunch(pkg, bounds);
                }, 300);
            }
        };

        waitUntil(() -> {
            if (host == null || !childAttached) return false;
            SurfaceView sv = findSurfaceView(host);
            if (sv != null) {
                try {
                    SurfaceHolder holder = sv.getHolder();
                    android.view.Surface s = (holder != null) ? holder.getSurface() : null;
                    if (s != null && s.isValid() && firstFrame.get()) return true;
                } catch (Throwable ignore) {}
            }
            return firstFrame.get();
        }, 400, 25,
                () -> postMainDelayed(doStart, 80),
                () -> {
                    Log.w(TAG, name + ": surface stability wait timed out, starting anyway");
                    postMainDelayed(doStart, 80);
                });
    }

    private void attemptMinimalLaunch(String pkg, Rect bounds) {
        try {
            Log.i(TAG, name + ": attempting minimal launch for " + pkg);
            Intent minimal = activity.getPackageManager().getLaunchIntentForPackage(pkg);
            if (minimal == null) {
                Log.e(TAG, name + ": no launch intent available");
                return;
            }
            minimal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ActivityOptions opts = (ActivityOptions) WindowHostActivityView.makeOptionsWithBounds(bounds);
            boolean success = WindowHostActivityView.startActivitySmart(av, activity, minimal, opts);
            Log.i(TAG, name + ": minimal launch " + (success ? "succeeded" : "failed"));
        } catch (Exception e) {
            Log.e(TAG, name + ": minimal launch exception", e);
        }
    }


    // =====================================================================================
    // 8. Black-screen watchdog
    // =====================================================================================

    private void checkForBlackScreenAndRestart(String pkg, int expectedGen) {
        if (gen != expectedGen) return;

        postMainDelayed(() -> {
            if (gen != expectedGen) return;

            boolean isBlack = false;

            if (host != null) {
                SurfaceView sv = findSurfaceView(host);
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

            if (!firstFrame.get() && restartCount < MAX_RESTART_ATTEMPTS) isBlack = true;

            if (!isBlack) { blackConfirmCount = 0; return; }
            if (blackScreenDetected.get() || restartCount >= MAX_RESTART_ATTEMPTS) return;

            blackConfirmCount++;
            if (blackConfirmCount < REQUIRED_BLACK_CONFIRMATIONS) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(pkg, expectedGen), BLACK_SCREEN_CONFIRM_DELAY_MS);
                return;
            }

            Log.w(TAG, name + ": black screen confirmed, restarting " + pkg);
            blackScreenDetected.set(true);
            blackConfirmCount = 0;
            restartCount++;
            restartPaneApp(pkg, expectedGen);
        }, BLACK_SCREEN_CHECK_DELAY_MS);
    }

    private void restartPaneApp(String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null || pkg.isEmpty()) return;

        forceStopApp(activity, pkg);

        postMainDelayed(() -> {
            if (gen != expectedGen) return;

            if (av != null) {
                try { WindowHostActivityView.release(av); } catch (Throwable ignore) {}
                resetVdCache(av);
                av = null;
            }
            taskId = -1;
            avReady.set(false);
            firstFrame.set(false);
            blackScreenDetected.set(false);

            if (host != null) {
                host.removeAllViews();
                childAttached = false;
            }

            ensureActivityView(activity, expectedGen);
            attachPane();

            postMainDelayed(() -> {
                if (gen != expectedGen) return;
                startWhenReady(pkg, expectedGen);
                checkForBlackScreenAndRestart(pkg, expectedGen);
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
    // 9. Utilities
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

        // Fallback: if no traversal ever comes (detached/hidden host), don't lose the work.
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
