package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

public class WindowHostSinglePane {
    private static final String TAG = "WindowHostSinglePane";
    private static final long BLACK_SCREEN_CHECK_DELAY_MS = 800L;
    private static final int MAX_RESTART_ATTEMPTS = 2;
    private int restartAttempts = 0;
    private final AtomicBoolean blackScreenDetected = new AtomicBoolean(false);

    // Timing
    private static final long REVEAL_FALLBACK_NS = 320_000_000L; // ~320ms
    private static final int  START_WAIT_TIMEOUT_MS = 40;
    private static final int  START_WAIT_STEP_MS    = 4;

    private static final ScheduledExecutorService DISMISS_EXEC =
            Executors.newSingleThreadScheduledExecutor();
            
    private Activity activity;
    private WindowManager wm;
    private final String name;
    private WindowManager.LayoutParams lp;
    private FrameLayout root, host, curtain;
    public boolean added;
    private boolean childAttached;

    private Object av;
    private final AtomicBoolean avReady = new AtomicBoolean(false);
    private final AtomicBoolean firstFrame = new AtomicBoolean(false);
    private final AtomicBoolean visible = new AtomicBoolean(false);

    private String currentPkg = null;
    private int taskId = -1;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;
    private boolean startDeferredForBounds = false;
    private long startNs = 0L;

    private int blackConfirmCount = 0;
    private static final int REQUIRED_BLACK_CONFIRMATIONS = 2;
    private static final long BLACK_SCREEN_CONFIRM_DELAY_MS = 800L;
    private static final int EXTRA_SETTLE_RETRIES = 20;

    // VirtualDisplay size cache (Size Guard - prevents resize spam)
    private int lastVdW = -1;
    private int lastVdH = -1;
    private int lastVdDpi = -1;

    WindowHostSinglePane(String name) { this.name = name; }

    boolean isVisible() { return visible.get(); }

    void show(Activity act, WindowManager wm, IBinder token, String pkg, Rect b) {
        if (pkg == null || b == null) return;

        if (!WindowHostActivityView.isGoogleMapsPackage(pkg)) {
            new Thread(() -> WindowHostSurfacePreloader.prewarmActivityView(act, "single_" + name)).start();
        }

        this.activity = act;
        this.wm = wm;

        if (visible.get() && pkg.equals(currentPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            return;
        }

        final int myGen = ++gen;
        
        restartAttempts = 0;
        blackConfirmCount = 0;
        blackScreenDetected.set(false);
        resetVdCache();

        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            ensureWindow(act, wm, token);
            setPendingBoundsFast(b);
            resetPaneToMatchParent();
            ensureActivityView(act, myGen, pkg);
            if (!childAttached) attachChild();

            boolean haveTask = (taskId > 0) && pkg.equals(currentPkg);
            currentPkg = pkg;
            firstFrame.set(false);
            startNs = System.nanoTime();
            visible.set(true);

            if (!haveTask) {
                if (WindowHostActivityView.shouldWaitForRealBounds(pkg, b)) {
                    startDeferredForBounds = true;
                } else {
                    startDeferredForBounds = false;
                    startWhenReady(pkg, myGen);
                    checkForBlackScreenAndRestart(pkg, myGen);
                }
            }
            liftCurtainLoop(myGen);
        });
    }

    public void updateBounds(Rect b) {
        setPendingBoundsFast(b);
        if (startDeferredForBounds
                && currentPkg != null
                && WindowHostActivityView.hasRealLaunchBounds(currentPkg, b)) {
            startDeferredForBounds = false;
            Log.i(TAG, name + ": starting deferred Google Maps after bounds update: " + b);
            startWhenReady(currentPkg, gen);
            checkForBlackScreenAndRestart(currentPkg, gen);
        }
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
        avReady.set(false); firstFrame.set(false);
        currentPkg = null; taskId = -1;
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;
        resetVdCache();
    }

    private void resetVdCache() {
        lastVdW = -1;
        lastVdH = -1;
        lastVdDpi = -1;
    }

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

        FrameLayout overlayCurtain = new FrameLayout(act);
        overlayCurtain.setBackgroundColor(Color.BLACK);
        overlayCurtain.setWillNotDraw(true);
        overlayCurtain.setAlpha(1f);

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

        rootView.addView(container, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.addView(overlayCurtain, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        try { wm.addView(rootView, p); added = true; }
        catch (Throwable t) {
            try { p.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG; wm.addView(rootView, p); added = true; }
            catch (Throwable t2) { throw new RuntimeException("Unable to create host window for " + name, t2); }
        }
        this.root = rootView; this.host = container; this.curtain = overlayCurtain; this.lp = p;
    }

    public void resyncGeometryAfterSurfaceSwap() {
        if (host == null || av == null) return;

        resetVdCache();

        View v = WindowHostActivityView.asView(av);
        if (v != null) {
            SurfaceView sv = findSurfaceView(v);
            if (sv != null && sv.getHolder() != null) {
                try { sv.getHolder().setSizeFromLayout(); } catch (Throwable ignore) {}
            }
        }

        if (hasPendingBounds) {
            int w = freshPaneWidthPx(pendingBounds.width());
            int h = pendingBounds.height() > 0 ? pendingBounds.height() : freshPaneWidthPx(0);
            applyPortraitSafeChildSize(w, h);
        } else if (host.getWidth() > 0 && host.getHeight() > 0) {
            applyPortraitSafeChildSize(host.getWidth(), host.getHeight());
        }
    }

    private void applyPortraitSafeChildSize(int realWidth, int realHeight) {
        applyPortraitSafeChildSize(realWidth, realHeight, 30);
    }

    private void applyPortraitSafeChildSize(int realWidth, int realHeight, int retriesLeft) {
        if (host == null || av == null || !childAttached) return;
        View v = WindowHostActivityView.asView(av);

        if (WindowUtil.isReparentUnsettled(v)) {
            if (retriesLeft > 0) {
                postNextFrame(() -> applyPortraitSafeChildSize(
                        freshPaneWidthPx(realWidth),
                        pendingBounds.height() > 0 ? pendingBounds.height() : realHeight,
                        retriesLeft - 1));
                return;
            }
        }

        if (realWidth <= 1 && retriesLeft > 0) {
            postNextFrame(() -> applyPortraitSafeChildSize(
                    freshPaneWidthPx(realWidth), 
                    pendingBounds.height() > 0 ? pendingBounds.height() : realHeight, 
                    retriesLeft - 1));
            return;
        }

        final int paneW = Math.max(1, realWidth);
        final int paneH = Math.max(1, realHeight);

        FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(paneW, paneH);
        flp.gravity = Gravity.TOP | Gravity.START;
        flp.leftMargin = 0;
        flp.topMargin = 0;
        v.setLayoutParams(flp);

        v.setScaleX(1f);
        v.setScaleY(1f);
        v.setTranslationX(0f);
        v.setTranslationY(0f);

        resetSurfaceSizeFromLayout();
        enforcePaneVirtualDisplay(paneW, paneH);

        refreshTapRegionSafely(8);
    }

    private int freshPaneWidthPx(int fallback) {
        if (hasPendingBounds && pendingBounds.width() > 0) return pendingBounds.width();
        if (host != null) {
            ViewGroup.LayoutParams hlp = host.getLayoutParams();
            if (hlp != null && hlp.width > 0) return hlp.width;
            if (host.getWidth() > 0) return host.getWidth();
        }
        return fallback;
    }

    private void resetActivityViewForReuse(Object paneAV) {
        View v = WindowHostActivityView.asView(paneAV);
        if (v == null) return;

        v.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        v.setScaleX(1f);
        v.setScaleY(1f);
        v.setTranslationX(0f);
        v.setTranslationY(0f);
        v.setPivotX(0f);
        v.setPivotY(0f);

        try {
            SurfaceView sv = findSurfaceView(v);
            if (sv != null) {
                SurfaceHolder holder = sv.getHolder();
                if (holder != null) {
                    holder.setSizeFromLayout();
                }
            }
        } catch (Throwable ignore) {}
    }

    private void resetSurfaceSizeFromLayout() {
        View avView = WindowHostActivityView.asView(av);
        if (avView == null) return;
        try {
            SurfaceView sv = findSurfaceView(avView);
            if (sv == null) return;
            SurfaceHolder holder = sv.getHolder();
            if (holder != null) holder.setSizeFromLayout();
        } catch (Throwable t) {
            Log.w(TAG, name + ": resetSurfaceSizeFromLayout failed", t);
        }
    }

    private void resetPaneToMatchParent() {
        if (host == null || av == null) return;
        resetPaneToMatchParent(host, av, 30);
    }

    private void resetPaneToMatchParent(FrameLayout paneHost, Object paneAV, int retriesLeft) {
        View v = WindowHostActivityView.asView(paneAV);
        if (v == null) return;

        if (WindowUtil.isReparentUnsettled(v)) {
            if (retriesLeft > 0) {
                postNextFrame(() -> resetPaneToMatchParent(paneHost, paneAV, retriesLeft - 1));
                return;
            }
            Log.w(TAG, "resetPaneToMatchParent: reparent guard did not clear in "
                    + retriesLeft + " frames, extending wait");
            postMainDelayed(() -> resetPaneToMatchParent(paneHost, paneAV, EXTRA_SETTLE_RETRIES), 100);
            return;
        }

        v.setLayoutParams(new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        v.setScaleX(1f);
        v.setScaleY(1f);
        v.setTranslationX(0f);
        v.setTranslationY(0f);
        v.setPivotX(0f);
        v.setPivotY(0f);

        int w = 0;
        int h = 0;
        if (hasPendingBounds) {
            w = pendingBounds.width();
            h = pendingBounds.height();
        }
        if (w <= 0 || h <= 0) {
            ViewGroup.LayoutParams lpHost = paneHost.getLayoutParams();
            if (w <= 0 && lpHost != null && lpHost.width > 0) w = lpHost.width;
            if (h <= 0 && lpHost != null && lpHost.height > 0) h = lpHost.height;
            if (w <= 0) w = Math.max(1, paneHost.getWidth());
            if (h <= 0) h = Math.max(1, paneHost.getHeight());
        }

        resetSurfaceSizeFromLayout();
        enforcePaneVirtualDisplay(w, h);
    }

    private int resolveDensityDpi(View avView) {
        try {
            Method m = avView.getClass().getDeclaredMethod("getBaseDisplayDensity");
            m.setAccessible(true);
            Object v = m.invoke(avView);
            if (v instanceof Integer && ((Integer) v) > 0) return (Integer) v;
        } catch (Throwable ignore) { }

        try {
            android.util.DisplayMetrics dm = avView.getResources().getDisplayMetrics();
            if (dm != null && dm.densityDpi > 0) return dm.densityDpi;
        } catch (Throwable ignore) { }

        return 160;
    }

    private void resizeActivityViewVirtualDisplay(int width, int height, int densityDpi) {
        View avView = WindowHostActivityView.asView(av);
        if (avView == null) {
            Log.d(TAG, name + ": resizeVD skip - avView null");
            return;
        }
        if (width <= 0 || height <= 0) return;

        int safeDensity = Math.max(120, densityDpi);

        // Size deduplication (Size Guard) – ignore the call if the size hasn't changed
        if (width == lastVdW && height == lastVdH && safeDensity == lastVdDpi) {
            return;
        }

        try {
            java.lang.reflect.Field vdField = avView.getClass().getDeclaredField("mVirtualDisplay");
            vdField.setAccessible(true);
            Object vd = vdField.get(avView);
            if (vd == null) {
                Log.d(TAG, name + ": resizeVD skip - mVirtualDisplay is null (avReady=" + avReady.get() + ")");
                return;
            }

            Method resize = vd.getClass().getMethod("resize", int.class, int.class, int.class);
            resize.invoke(vd, width, height, safeDensity);
            
            lastVdW = width;
            lastVdH = height;
            lastVdDpi = safeDensity;

            Log.d(TAG, name + ": Fourth: resizeVD OK -> " + width + "x" + height + " @" + safeDensity);
        } catch (Throwable t) {
            Log.w(TAG, name + ": resizeActivityViewVirtualDisplay failed: " + width + "x" + height + " @" + densityDpi, t);
        }
    }

    private void enforcePaneVirtualDisplay(int paneW, int paneH) {
        View avView = WindowHostActivityView.asView(av);
        if (avView == null) return;
        int density = resolveDensityDpi(avView);
        resizeActivityViewVirtualDisplay(Math.max(1, paneW), Math.max(1, paneH), density);
        if (WindowHostActivityView.isGoogleMapsPackage(currentPkg)) {
            notifyGoogleMapsSurfaceResize(avView, paneW, paneH);
        }
    }

    private void notifyGoogleMapsSurfaceResize(View avView, int w, int h) {
        notifyGoogleMapsSurfaceResize(avView, w, h, 8);
    }

    private void notifyGoogleMapsSurfaceResize(View avView, int w, int h, int retriesLeft) {
        if (avView == null) return;

        // Guard against the reparent race documented in WindowUtil.isReparentUnsettled():
        // requestLayout() on an ActivityView that was just native-reparented (e.g. swapped
        // in from a single pane) can throw deep inside the framework's own traversal
        // ("window is not the parent window of this display"). Defer instead of crashing.
        if (WindowUtil.isReparentUnsettled(avView)) {
            if (retriesLeft > 0) {
                postMainDelayed(() -> notifyGoogleMapsSurfaceResize(avView, w, h, retriesLeft - 1), 32);
            }
            return;
        }

        avView.requestLayout();
        avView.invalidate();

        SurfaceView sv = findSurfaceView(avView);
        if (sv != null) {
            sv.requestLayout();
            sv.invalidate();
            SurfaceHolder holder = sv.getHolder();
            if (holder != null) {
                try {
                    holder.setFixedSize(w, h);
                    postNextFrame(() -> {
                        try { holder.setSizeFromLayout(); } catch (Throwable ignore) {}
                    });
                } catch (Throwable ignore) {}
            }
        }
    }

    private void clearTapRegionQuietly() {
        View v = WindowHostActivityView.asView(av);
        if (v == null) return;
        try {
            Method m;
            try {
                m = v.getClass().getMethod("cleanTapExcludeRegion");
            } catch (NoSuchMethodException e) {
                m = v.getClass().getDeclaredMethod("cleanTapExcludeRegion");
                m.setAccessible(true);
            }
            m.invoke(v);
        } catch (Throwable ignore) {
        }
    }

    private void refreshTapRegionSafely(int retriesLeft) {
        View v = WindowHostActivityView.asView(av);
        if (v == null) return;

        try {
            Method m;
            try {
                m = v.getClass().getMethod("updateLocationAndTapExcludeRegion");
            } catch (NoSuchMethodException e) {
                m = v.getClass().getDeclaredMethod("updateLocationAndTapExcludeRegion");
                m.setAccessible(true);
            }
            m.invoke(v);
        } catch (java.lang.reflect.InvocationTargetException ite) {
            Throwable c = ite.getCause();
            boolean parentWindowRace =
                    (c instanceof IllegalArgumentException)
                            && c.getMessage() != null
                            && c.getMessage().contains("not the parent window");
            if (parentWindowRace) {
                clearTapRegionQuietly();
                if (retriesLeft > 0) {
                    postMainDelayed(() -> refreshTapRegionSafely(retriesLeft - 1), 32);
                }
                return;
            }
            Log.w(TAG, name + ": refreshTapRegionSafely failed", ite);
        } catch (Throwable t) {
            Log.w(TAG, name + ": refreshTapRegionSafely failed", t);
        }
    }

    private void setPendingBoundsFast(Rect b) {
        if (hasPendingBounds && pendingBounds.equals(b)) {
            return;
        }
        pendingBounds.set(b);
        hasPendingBounds = true;
        if (lp != null && root != null) {
            lp.width = Math.max(1, b.width());
            lp.height = Math.max(1, b.height());
            lp.x = b.left; lp.y = b.top;
            lp.alpha = 1f;
            lp.flags &= ~WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE; 
            try { wm.updateViewLayout(root, lp); } catch (Throwable ignore) {}
            root.setVisibility(View.VISIBLE);
            root.setAlpha(1f);
            if (curtain != null) curtain.setVisibility(View.GONE); 

            if (WindowHostActivityView.isYouTubePackage(currentPkg)) {
                applyPortraitSafeChildSize(b.width(), b.height());
            } else if (host != null && av != null && childAttached) {
                View avView = WindowHostActivityView.asView(av);
                avView.setLayoutParams(new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                resetSurfaceSizeFromLayout();
                enforcePaneVirtualDisplay(b.width(), b.height());
            }

            if (host != null && childAttached) {
                View avView = WindowHostActivityView.asView(av);
                if (avView != null) {
                    postMain(() -> {
                        try {
                            avView.requestFocus();
                            avView.requestFocusFromTouch();
                        } catch (Throwable ignore) {}
                    });
                }
            }
        }
    }

    private void ensureActivityView(Context ctx, int expectedGen, String pkg) {
        if (av == null) {
            if (!WindowHostActivityView.isGoogleMapsPackage(pkg)) {
                WindowHostSurfacePreloader.keepWarm("single_" + name);
                av = WindowHostSurfacePreloader.getWarmActivityView("single_" + name);
            }

            if (av == null) {
                av = WindowHostActivityView.newInstance(ctx);
            }

            avReady.set(false);
            firstFrame.set(false);
            WindowHostActivityView.trySetCallback(av, new WindowHostActivityView.Callback() {
                @Override public void onReady() { if (gen == expectedGen) avReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) taskId = id; }
                @Override public void onDestroyed() { if (gen == expectedGen) avReady.set(false); }
            });

            if (!WindowHostActivityView.isGoogleMapsPackage(pkg)) {
                View avView = WindowHostActivityView.asView(av);
                WindowHostSurfacePreloader.forceInstantSurfaceReady(avView);
            }
        }
    }

    private void attachChild() {
        if (host == null || av == null) return;

        boolean isMaps = WindowHostActivityView.isGoogleMapsPackage(currentPkg);
        if (isMaps) {
            resetVdCache();
        }

        View v = WindowHostActivityView.asView(av);
        resetActivityViewForReuse(av);

        if (v.getParent() instanceof ViewGroup) { 
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} 
        }
        host.removeAllViews();
        v.setVisibility(View.VISIBLE);

        if (!isMaps) {
            WindowHostSurfaceTamer.tame(v);
        }

        hookFirstFrame(v);
        host.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        childAttached = true;
        if (curtain != null) curtain.setVisibility(View.VISIBLE);

        if (!isMaps) {
            WindowHostInstantRenderStrategy.applyToContainer(host, "single_" + name);
        }

        if (hasPendingBounds && WindowHostActivityView.isYouTubePackage(currentPkg)) {
            postNextFrame(() -> {
                resetPaneToMatchParent();
                int safeW = freshPaneWidthPx(pendingBounds.width());
                int safeH = pendingBounds.height() > 0 ? pendingBounds.height() : freshPaneWidthPx(0);
                applyPortraitSafeChildSize(safeW, safeH);
            });
        }
    }

    private void startWhenReady(String pkg, int expectedGen) {
        waitUntil(() -> avReady.get() && childAttached, START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS, () -> {
            if (gen != expectedGen) return;
            startNow(pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startNow(pkg, expectedGen); });
    }

    private void startNow(String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (taskId > 0 && pkg.equals(currentPkg)) return;

        Runnable doStart = () -> {
            if (gen != expectedGen) return;
            if (taskId > 0 && pkg.equals(currentPkg)) return;

            if (host != null) {
                SurfaceView sv = findSurfaceView(host);
                if (sv != null) {
                    try {
                        SurfaceHolder holder = sv.getHolder();
                        if (holder == null || holder.getSurface() == null || !holder.getSurface().isValid()) {
                            Log.w(TAG, name + ": Surface not ready yet, deferring start");
                            postMainDelayed(() -> startNow(pkg, expectedGen), 50);
                            return;
                        }
                    } catch (Throwable t) {
                        Log.w(TAG, name + ": Surface check failed, deferring start", t);
                        postMainDelayed(() -> startNow(pkg, expectedGen), 50);
                        return;
                    }
                }
            }

            Rect bounds = hasPendingBounds ? new Rect(pendingBounds) : null;

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(av, activity, pkg, bounds);

                if (!ok) {
                    Log.w(TAG, name + ": start failed for " + pkg + ", attempting fallback");

                    postMainDelayed(() -> {
                        if (gen != expectedGen) return;

                        Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                        if (fallback != null) {
                            Object fallbackOpts = WindowHostActivityView.makeOptionsWithBounds(pkg, bounds);
                            boolean retryOk = WindowHostActivityView.startActivitySmart(av, activity, fallback, fallbackOpts);
                            Log.i(TAG, name + (retryOk ? ": fallback succeeded" : ": fallback failed"));

                            if (!retryOk) {
                                postMainDelayed(() -> {
                                    if (gen != expectedGen) return;
                                    attemptMinimalLaunch(pkg, bounds);
                                }, 300);
                            }
                        }
                    }, 200);
                } else {
                    Log.i(TAG, name + ": start ok for " + pkg + " (process check)");
                }
            } catch (Exception e) {
                Log.e(TAG, name + ": Exception starting " + pkg, e);

                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    attemptMinimalLaunch(pkg, bounds);
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
        }, 400, 25, () -> postMainDelayed(doStart, 80), () -> {
            Log.w(TAG, name + ": surface stability wait timed out, proceeding to start anyway");
            postMainDelayed(doStart, 80);
        });
    }

    private void attemptMinimalLaunch(String pkg, Rect bounds) {
        try {
            Log.i(TAG, name + ": Attempting minimal launch for " + pkg);
            
            PackageManager pm = activity.getPackageManager();
            Intent minimal = pm.getLaunchIntentForPackage(pkg);
            
            if (minimal == null) {
                Log.e(TAG, name + ": No launch intent available");
                return;
            }
            
            minimal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
            ActivityOptions opts = (ActivityOptions) WindowHostActivityView.makeOptionsWithBounds(pkg, bounds);
            boolean success = WindowHostActivityView.startActivitySmart(av, activity, minimal, opts);
            Log.i(TAG, name + ": Minimal launch " + (success ? "succeeded" : "failed"));
            
        } catch (Exception e) {
            Log.e(TAG, name + ": Minimal launch exception", e);
        }
    }

    private void liftCurtainLoop(int expectedGen) {
        if (gen != expectedGen || root == null) return;
        long now = System.nanoTime();
        boolean gateOk = firstFrame.get() || (now - startNs) >= REVEAL_FALLBACK_NS;
        if (gateOk) {
            if (curtain != null && curtain.getAlpha() > 0f) {
                curtain.setAlpha(0f);
                curtain.setVisibility(View.GONE);
            }
            return;
        }
        postNextFrame(() -> liftCurtainLoop(expectedGen));
    }

    private void hardRemoveWindow(boolean releaseAV, int expectedGen) {
        if (gen != expectedGen) return;
        if (host != null && childAttached) { try { host.removeAllViews(); } catch (Throwable ignore) {} childAttached = false; }

        final View toRemove = root;
        final WindowManager wmRef = wm;

        if (added && wmRef != null && toRemove != null) {
            try { wmRef.removeViewImmediate(toRemove); }
            catch (Throwable t) { Log.w(TAG, name + ": hardRemoveWindow: removeViewImmediate threw, will verify", t); }
        }

        if (releaseAV && av != null) { try { WindowHostActivityView.release(av); } catch (Throwable ignore) {} av = null; taskId = -1; }

        added = false;
        visible.set(false);
        root = null; host = null; curtain = null; lp = null;
        resetVdCache();
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;

        if (toRemove != null && wmRef != null) {
            verifyDetached(toRemove, wmRef, 0);
        }
    }

    private void verifyDetached(View v, WindowManager wmRef, int attempt) {
        postMainDelayed(() -> {
            boolean stillAttached;
            try { stillAttached = v.isAttachedToWindow(); } catch (Throwable t) { stillAttached = false; }

            if (!stillAttached) return;

            Log.w(TAG, name + ": verifyDetached: view still attached after removal (attempt " + attempt + "), forcing again");
            try { wmRef.removeViewImmediate(v); } catch (Throwable ignore) {}

            if (attempt < 10) {
                verifyDetached(v, wmRef, attempt + 1);
            } else {
                Log.e(TAG,"giving up after " + (attempt+1) + " attempts — neutralizing leaked view");
                try {
                    v.setVisibility(View.GONE);
                    if (v instanceof ViewGroup) disableTouchRecursively((ViewGroup) v);
                } catch (Throwable ignore) {}
            }
        }, 150);
    }

    private void forceRemoveWindowNoGen() {
        if (host != null && childAttached) { try { host.removeAllViews(); } catch (Throwable ignore) {} childAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        added = false; visible.set(false);
        root = null; host = null; curtain = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        startDeferredForBounds = false;
        resetVdCache();
    }

    private void parkInvisible() {
        if (added && wm != null && lp != null && root != null) {
            lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
            lp.width = 600; lp.height = 600;
            lp.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
            try { wm.updateViewLayout(root, lp); }
            catch (Throwable t) {
                Log.w(TAG, name + ": parkInvisible updateViewLayout failed, forcing removal", t);
                try { wm.removeViewImmediate(root); } catch (Throwable ignore2) {}
            }
            root.setAlpha(0f);
            root.setVisibility(View.INVISIBLE);
            WindowHostSurfaceTamer.forceCleanup(root);
            if (curtain != null) { curtain.setAlpha(1f); curtain.setVisibility(View.VISIBLE); }
        }
    }

    private void hookFirstFrame(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv != null) {
            try {
                SurfaceHolder h = sv.getHolder();
                h.addCallback(new SurfaceHolder.Callback2() {
                    @Override public void surfaceCreated(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                        if (width > 0 && height > 0) firstFrame.set(true);
                    }
                    @Override public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceRedrawNeeded(@NonNull SurfaceHolder holder) { firstFrame.set(true); }
                });
            } catch (Throwable ignore) {}
        } else {
            root.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                boolean done;
                @Override public boolean onPreDraw() {
                    if (done) return true;
                    done = true;
                    postNextFrame(() -> firstFrame.set(true));
                    root.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        }
    }

    private SurfaceView findSurfaceView(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup g) {
            for (int i=0;i<g.getChildCount();i++) {
                SurfaceView res = findSurfaceView(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }

    private void waitUntil(BooleanSupplier cond, int timeoutMs, int stepMs, Runnable onOk, Runnable onTimeout) {
        final long start = SystemClock.uptimeMillis();
        final Runnable[] tick = new Runnable[1];
        tick[0] = () -> {
            if (cond.getAsBoolean()) { onOk.run(); return; }
            long elapsed = SystemClock.uptimeMillis() - start;
            if (elapsed >= timeoutMs) { onTimeout.run(); return; }
            postMainDelayed(tick[0], stepMs);
        };
        postMain(tick[0]);
    }

    private static void postNextFrame(Runnable r) {
        try { Choreographer.getInstance().postFrameCallback(ft -> r.run()); }
        catch (Throwable t) { new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(r, 16); }
    }

    private void postMain(Runnable r) { new Handler(Looper.getMainLooper()).post(r); }
    private void postMainDelayed(Runnable r, long delayMs) {
        new Handler(Looper.getMainLooper()).postDelayed(r, delayMs);
    }

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

            if (!firstFrame.get() && restartAttempts < MAX_RESTART_ATTEMPTS) {
                isBlack = true;
            }

            if (!isBlack) {
                blackConfirmCount = 0;
                return;
            }

            if (blackScreenDetected.get() || restartAttempts >= MAX_RESTART_ATTEMPTS) {
                return;
            }

            blackConfirmCount++;

            if (blackConfirmCount < REQUIRED_BLACK_CONFIRMATIONS) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(pkg, expectedGen), BLACK_SCREEN_CONFIRM_DELAY_MS);
                return;
            }

            Log.w(TAG, name + " showing black screen (confirmed), restarting app: " + pkg);
            blackScreenDetected.set(true);
            blackConfirmCount = 0;
            restartAttempts++;

            restartPaneApp(pkg, expectedGen);

        }, BLACK_SCREEN_CHECK_DELAY_MS);
    }

    private void restartPaneApp(String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null || pkg.isEmpty()) return;

        try {
            ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
            Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(am, pkg);
            Log.i(TAG, "Force stopped " + pkg);
        } catch (Throwable t) {
            Log.w(TAG, "Failed to force stop " + pkg, t);
        }
        
        postMainDelayed(() -> {
            if (gen != expectedGen) return;
            
            if (av != null) {
                try {
                    WindowHostActivityView.release(av);
                } catch (Throwable ignore) {}
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
            
            ensureActivityView(activity, expectedGen, pkg);
            attachChild();
            
            postMainDelayed(() -> {
                if (gen != expectedGen) return;
                startWhenReady(pkg, expectedGen);
                
                checkForBlackScreenAndRestart(pkg, expectedGen);
            }, 300);
            
        }, 500);
    }

    private static void disableTouchRecursively(ViewGroup root) {
        disableTouchRecursively((View) root);
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

        if (v instanceof ViewGroup g) {
            for (int i = 0; i < g.getChildCount(); i++) {
                disableTouchRecursively(g.getChildAt(i));
            }
        }
    }
}