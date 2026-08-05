package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
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
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.android.launcher66.LauncherApplication;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

public class WindowHostDualPane {
    private static final String TAG = "WindowHostDualPane";

    private static final String PREFS = "pip_window_host_prefs";
    private static final String KEY_SPLIT = "dual_split_ratio";
    private static final long SURFACE_RESTORE_DELAY_MS = 500L; 
    private static final long BLACK_SCREEN_CHECK_DELAY_MS = 1200L;
    private static final int MAX_RESTART_ATTEMPTS = 2;
    private int leftRestartCount = 0;
    private int rightRestartCount = 0;
    private final AtomicBoolean leftBlackScreenDetected = new AtomicBoolean(false);
    private final AtomicBoolean rightBlackScreenDetected = new AtomicBoolean(false);

    private static final int START_WAIT_TIMEOUT_MS = 60;
    private static final int START_WAIT_STEP_MS    = 4;

    private static final ScheduledExecutorService DISMISS_EXEC =
            Executors.newSingleThreadScheduledExecutor();
            
    private Activity activity;

    private WindowManager wm;
    private WindowManager.LayoutParams lp;
    private FrameLayout root;
    private FrameLayout leftHost, rightHost;
    private DividerView divider;
    public boolean added;
    private boolean leftAttached;
    private boolean rightAttached;

    private Object leftAV, rightAV;
    private final AtomicBoolean leftReady = new AtomicBoolean(false);
    private final AtomicBoolean rightReady = new AtomicBoolean(false);
    private final AtomicBoolean leftFirstFrame = new AtomicBoolean(false);
    private final AtomicBoolean rightFirstFrame = new AtomicBoolean(false);
    private final AtomicBoolean visible = new AtomicBoolean(false);

    private final AtomicBoolean surfacesHidden = new AtomicBoolean(false);
    private int pendingRestoreGeneration = 0;
    private Runnable pendingRestore = null;

    private int leftTask = -1, rightTask = -1;
    private int lastAppliedSplitLeftW = -1, lastAppliedSplitRightW = -1;
    private String leftPkg = null, rightPkg = null;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;
    private boolean leftStartDeferredForBounds = false;
    private boolean rightStartDeferredForBounds = false;

    private final int DIVIDER_VISUAL_PX = dp(8);
    private final int DIVIDER_GUARD_PX  = dp(12);
    private final int DIVIDER_TOTAL_PX  = DIVIDER_VISUAL_PX + DIVIDER_GUARD_PX*2;
    private static final float MIN_SPLIT_RATIO = 0.25f;
    private static final float MAX_SPLIT_RATIO = 0.75f;
    private float splitRatio = 0.5f;

    private int leftBlackConfirmCount = 0;
    private int rightBlackConfirmCount = 0;
    private static final int REQUIRED_BLACK_CONFIRMATIONS = 2;
    private static final long BLACK_SCREEN_CONFIRM_DELAY_MS = 800L;
    private static final int EXTRA_SETTLE_RETRIES = 20;

    private final DividerDragController dragController = new DividerDragController();
    private final Handler resizeHandler = new Handler(Looper.getMainLooper());

    private Runnable pendingLeftResizeRunnable = null;
    private Runnable pendingRightResizeRunnable = null;

    private final java.util.Map<Object, int[]> vdSizeCache = new java.util.WeakHashMap<>();
    boolean isVisible() { return visible.get(); }

    private static void forceStopApp(Context ctx, String pkg) {
        if (pkg == null || pkg.isEmpty() || ctx == null) return;
        try {
            ActivityManager am = (ActivityManager) ctx.getSystemService(Context.ACTIVITY_SERVICE);
            Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(am, pkg);
            Log.i(TAG, "Force stopped " + pkg + " for safe container transition");
        } catch (Throwable t) {
            Log.w(TAG, "Failed to force stop " + pkg, t);
        }
    }

    void show(Activity act, WindowManager wm, IBinder token, String lPkg, String rPkg, Rect b) {
        if (lPkg == null || rPkg == null || b == null) return;

        new Thread(() -> {
            if (!WindowHostActivityView.isGoogleMapsPackage(lPkg)) {
                WindowHostSurfacePreloader.prewarmActivityView(act, "dual_left");
            }
            if (!WindowHostActivityView.isGoogleMapsPackage(rPkg)) {
                WindowHostSurfacePreloader.prewarmActivityView(act, "dual_right");
            }
        }).start();

        this.activity = act;
        this.wm = wm;

        float saved = loadSplitRatio();
        setSplitRatio(saved);

        if (visible.get() && lPkg.equals(leftPkg) && rPkg.equals(rightPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            applySplitFromBounds();
            return;
        }

        final int myGen = ++gen;
        
        leftRestartCount = 0;
        rightRestartCount = 0;
        leftBlackConfirmCount = 0;
        rightBlackConfirmCount = 0;
        leftBlackScreenDetected.set(false);
        rightBlackScreenDetected.set(false);
        
        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            boolean haveL = (leftTask > 0) && lPkg.equals(leftPkg);
            boolean haveR = (rightTask > 0) && rPkg.equals(rightPkg);
            leftPkg = lPkg; rightPkg = rPkg;

            ensureWindow(act, wm, token);
            scheduleRestore();
            setPendingBoundsFast(b);
            applySplitFromBounds();
            ensureActivityView(act, myGen, lPkg, rPkg);
            if (!leftAttached) attachLeft();
            if (!rightAttached) attachRight();

            leftFirstFrame.set(false); rightFirstFrame.set(false);
            visible.set(true);

            if (!haveL) {
                Rect leftBounds = getLeftLaunchBounds();
                if (WindowHostActivityView.shouldWaitForRealBounds(lPkg, leftBounds)) {
                    leftStartDeferredForBounds = true;
                } else {
                    leftStartDeferredForBounds = false;
                    startLeftWhenReady(lPkg, myGen);
                    checkForBlackScreenAndRestart(true, lPkg, myGen);
                }
            }
            if (!haveR) {
                Rect rightBounds = getRightLaunchBounds();
                if (WindowHostActivityView.shouldWaitForRealBounds(rPkg, rightBounds)) {
                    rightStartDeferredForBounds = true;
                } else {
                    rightStartDeferredForBounds = false;
                    startRightWhenReady(rPkg, myGen);
                    checkForBlackScreenAndRestart(false, rPkg, myGen);
                }
            }
        });
    }

    public void updateBounds(Rect b) {
        boolean boundsChanged = !hasPendingBounds || !pendingBounds.equals(b);
        setPendingBoundsFast(b);
        if (boundsChanged) {
            applySplitFromBounds();
        }
        if (leftStartDeferredForBounds
                && leftPkg != null
                && WindowHostActivityView.hasRealLaunchBounds(leftPkg, getLeftLaunchBounds())) {
            leftStartDeferredForBounds = false;
            startLeftWhenReady(leftPkg, gen);
            checkForBlackScreenAndRestart(true, leftPkg, gen);
        }
        if (rightStartDeferredForBounds
                && rightPkg != null
                && WindowHostActivityView.hasRealLaunchBounds(rightPkg, getRightLaunchBounds())) {
            rightStartDeferredForBounds = false;
            startRightWhenReady(rightPkg, gen);
            checkForBlackScreenAndRestart(false, rightPkg, gen);
        }
    }

    void dismissAsync() {
        final int myGen = ++gen;
        visible.set(false);
        dragController.interactive.set(false);
        cancelPendingRestore();
        flushPendingResizes();
        parkInvisible();
        postMain(() -> hardRemoveWindow(false, myGen));
        DISMISS_EXEC.schedule(() -> postMain(() -> {
            if (gen != myGen) return;
            if (added || root != null) hardRemoveWindow(false, myGen);
        }), 150, TimeUnit.MILLISECONDS);
    }

    public void cleanup() {
        flushPendingResizes();
        final int myGen = ++gen;
        visible.set(false);
        cancelPendingRestore();
        hardRemoveWindow(true, myGen);
        if (leftAV != null)  { WindowHostActivityView.release(leftAV);  leftAV = null; }
        if (rightAV != null) { WindowHostActivityView.release(rightAV); rightAV = null; }
        leftFirstFrame.set(false); rightFirstFrame.set(false);
        leftTask = rightTask = -1;
        leftPkg = rightPkg = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = false;
        rightStartDeferredForBounds = false;
    }

    private void resetVdCache() {
        vdSizeCache.clear();
    }

    private void resetVdCache(Object paneAV) {
        if (paneAV != null) vdSizeCache.remove(paneAV);
    }

    public void flushPendingResizes() {
        if (pendingLeftResizeRunnable != null) {
            resizeHandler.removeCallbacks(pendingLeftResizeRunnable);
            pendingLeftResizeRunnable.run();
            pendingLeftResizeRunnable = null;
        }
        if (pendingRightResizeRunnable != null) {
            resizeHandler.removeCallbacks(pendingRightResizeRunnable);
            pendingRightResizeRunnable.run();
            pendingRightResizeRunnable = null;
        }
    }

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

        DividerView divider = new DividerView(act, DIVIDER_VISUAL_PX);
        divider.setClickable(false); 
        divider.setFocusable(false);
        divider.setFocusableInTouchMode(false);
        divider.setOnTouchListener(dragController);

        int match = ViewGroup.LayoutParams.MATCH_PARENT;
        
        rootView.addView(left, new FrameLayout.LayoutParams(match, match));
        rootView.addView(right, new FrameLayout.LayoutParams(match, match));
        
        FrameLayout.LayoutParams dividerLp = new FrameLayout.LayoutParams(DIVIDER_TOTAL_PX, match);
        dividerLp.gravity = Gravity.TOP | Gravity.START;
        rootView.addView(divider, dividerLp);

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
        this.leftHost = left; this.rightHost = right;
        this.divider = divider; this.lp = p;

        applySplitImmediate();
        root.getViewTreeObserver().addOnGlobalLayoutListener(this::applySplitImmediate);
    }

    public void resyncGeometryAfterSurfaceSwap() {
        lastAppliedSplitLeftW = lastAppliedSplitRightW = -1;
        resetVdCache();
        applySplitImmediate();
    }

    private void resetPaneToMatchParent(FrameLayout paneHost, Object paneAV) {
        resetPaneToMatchParent(paneHost, paneAV, 30);
    }

    private void resetPaneToMatchParent(FrameLayout paneHost, Object paneAV, int retriesLeft) {
        if (paneHost == null || paneAV == null) return;
        View v = WindowHostActivityView.asView(paneAV);

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

        if (surfacesHidden.get()) return;

        int paneW = paneHost.getWidth();
        int paneH = paneHost.getHeight();
        if (paneW <= 0 && paneHost.getLayoutParams() != null) paneW = paneHost.getLayoutParams().width;
        if (paneH <= 0 && paneHost.getLayoutParams() != null) paneH = paneHost.getLayoutParams().height;
        if (paneW <= 0 && hasPendingBounds) {
            int totalW = pendingBounds.width();
            paneW = (paneHost == leftHost) ? Math.round(totalW * splitRatio) : (totalW - Math.round(totalW * splitRatio));
        }
        if (paneH <= 0 && hasPendingBounds) paneH = pendingBounds.height();

        if (paneW > 50 && paneH > 50) {
            resetVdCache();
            enforcePaneVirtualDisplay(paneAV, paneW, paneH);
        }

        postNextFrame(() -> {
            if (!paneHost.isAttachedToWindow() || !v.isAttachedToWindow()) return;
            int w = paneHost.getWidth() > 0 ? paneHost.getWidth() : (paneHost.getLayoutParams() != null ? paneHost.getLayoutParams().width : 0);
            int h = paneHost.getHeight() > 0 ? paneHost.getHeight() : (paneHost.getLayoutParams() != null ? paneHost.getLayoutParams().height : 0);
            if (w <= 0 && hasPendingBounds) w = (paneHost == leftHost) ? Math.round(pendingBounds.width() * splitRatio) : (pendingBounds.width() - Math.round(pendingBounds.width() * splitRatio));
            if (h <= 0 && hasPendingBounds) h = pendingBounds.height();

            if (w > 50 && h > 50) {
                resetVdCache();
                enforcePaneVirtualDisplay(paneAV, w, h);
                refreshTapRegionSafely(paneAV, 4);
                postNextFrame(() -> refreshTapRegionSafely(paneAV, 4));
            }
        });
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
        }
    }

    private void ensureActivityView(Context ctx, int expectedGen, String lPkg, String rPkg) {
        if (leftAV == null) {
            if (!WindowHostActivityView.isGoogleMapsPackage(lPkg)) {
                WindowHostSurfacePreloader.keepWarm("dual_left");    
                leftAV = WindowHostSurfacePreloader.getWarmActivityView("dual_left");
            }

            if (leftAV == null) {
                leftAV = WindowHostActivityView.newInstance(ctx);
            }
            
            leftReady.set(false);
            WindowHostActivityView.trySetCallback(leftAV, new WindowHostActivityView.Callback() {
                @Override public void onReady() { if (gen == expectedGen) leftReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) leftTask = id; }
            });
            
            if (!WindowHostActivityView.isGoogleMapsPackage(lPkg)) {
                View leftView = WindowHostActivityView.asView(leftAV);
                WindowHostSurfacePreloader.forceInstantSurfaceReady(leftView);
            }
        }
        
        if (rightAV == null) {
            if (!WindowHostActivityView.isGoogleMapsPackage(rPkg)) {
                WindowHostSurfacePreloader.keepWarm("dual_right"); 
                rightAV = WindowHostSurfacePreloader.getWarmActivityView("dual_right");
            }

            if (rightAV == null) {
                rightAV = WindowHostActivityView.newInstance(ctx);
            }
            
            rightReady.set(false);
            WindowHostActivityView.trySetCallback(rightAV, new WindowHostActivityView.Callback() {
                @Override public void onReady() { if (gen == expectedGen) rightReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) rightTask = id; }
            });
            
            if (!WindowHostActivityView.isGoogleMapsPackage(rPkg)) {
                View rightView = WindowHostActivityView.asView(rightAV);
                WindowHostSurfacePreloader.forceInstantSurfaceReady(rightView);
            }
        }
        
        leftFirstFrame.set(false); 
        rightFirstFrame.set(false);
    }

    private void attachLeft() {
        if (leftHost == null || leftAV == null) return;

        resetVdCache(leftAV);

        boolean isMaps = WindowHostActivityView.isGoogleMapsPackage(leftPkg);

        View v = WindowHostActivityView.asView(leftAV);
        resetActivityViewForReuse(leftAV);

        clearTapRegionQuietly(leftAV);

        if (v.getParent() instanceof ViewGroup) { 
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} 
        }
        leftHost.removeAllViews();
        v.setVisibility(View.VISIBLE);

        if (!isMaps) {
            WindowHostSurfaceTamer.tame(v);
        }
        
        hookFirstFrame(v, true);
        leftHost.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        leftAttached = true;
        
        if (!isMaps) {
            WindowHostInstantRenderStrategy.applyToContainer(leftHost, "dual_left");
        }
    }

    private void attachRight() {
        if (rightHost == null || rightAV == null) return;

        resetVdCache(rightAV);

        boolean isMaps = WindowHostActivityView.isGoogleMapsPackage(rightPkg);

        View v = WindowHostActivityView.asView(rightAV);
        resetActivityViewForReuse(rightAV);

        clearTapRegionQuietly(rightAV);

        if (v.getParent() instanceof ViewGroup) { 
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} 
        }
        rightHost.removeAllViews();
        v.setVisibility(View.VISIBLE);

        if (!isMaps) {
            WindowHostSurfaceTamer.tame(v);
        }

        hookFirstFrame(v, false);
        rightHost.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rightAttached = true;
        
        if (!isMaps) {
            WindowHostInstantRenderStrategy.applyToContainer(rightHost, "dual_right");
        }
    }

    private void startLeftWhenReady(String pkg, int expectedGen) {
        waitUntil(() -> leftReady.get() && leftAttached, () -> {
            if (gen != expectedGen) return;
            startLeftNow(pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startLeftNow(pkg, expectedGen); });
    }

    private void startRightWhenReady(String pkg, int expectedGen) {
        waitUntil(() -> rightReady.get() && rightAttached, () -> {
            if (gen != expectedGen) return;
            startRightNow(pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startRightNow(pkg, expectedGen); });
    }

    private Rect getLeftLaunchBounds() {
        if (!hasPendingBounds || pendingBounds.width() <= 0 || pendingBounds.height() <= 0) {
            return null;
        }
        int leftW = Math.max(1, Math.round(pendingBounds.width() * splitRatio));
        return new Rect(pendingBounds.left, pendingBounds.top,
                pendingBounds.left + leftW, pendingBounds.bottom);
    }

    private Rect getRightLaunchBounds() {
        if (!hasPendingBounds || pendingBounds.width() <= 0 || pendingBounds.height() <= 0) {
            return null;
        }
        int leftWidth = Math.max(1, Math.round(pendingBounds.width() * splitRatio));
        return new Rect(pendingBounds.left + leftWidth,
                pendingBounds.top, pendingBounds.right, pendingBounds.bottom);
    }

    private void startLeftNow(String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (leftTask > 0 && pkg.equals(leftPkg)) return;

        Runnable doStartLeft = () -> {
            if (gen != expectedGen) return;
            if (leftTask > 0 && pkg.equals(leftPkg)) return;

            Rect b = getLeftLaunchBounds();
            // Fallback to prevent calling startActivity() with empty bounds for Google Maps.
            if (b == null || b.isEmpty() || b.width() <= 0) {
                if (root != null && root.getWidth() > 0) {
                    int w = Math.max(1, Math.round(root.getWidth() * splitRatio));
                    b = new Rect(0, 0, w, Math.max(1, root.getHeight()));
                }
            }

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(leftAV, activity, pkg, b);
                if (!ok) {
                    final Rect finalB = b;
                    postMainDelayed(() -> {
                        if (gen != expectedGen) return;
                        Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                        if (fallback != null) {
                            Object fallbackOpts = WindowHostActivityView.makeOptionsWithBounds(pkg, finalB);
                            WindowHostActivityView.startActivitySmart(leftAV, activity, fallback, fallbackOpts);
                        }
                    }, 200);
                }
            } catch (Exception e) {
                Log.e(TAG, "DualLeft: Exception starting " + pkg, e);
            }
        };

        postMainDelayed(doStartLeft, 80);
    }

    private void startRightNow(String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (rightTask > 0 && pkg.equals(rightPkg)) return;

        Runnable doStartRight = () -> {
            if (gen != expectedGen) return;
            if (rightTask > 0 && pkg.equals(rightPkg)) return;

            Rect b = getRightLaunchBounds();
            // Fallback to prevent calling startActivity() with empty bounds for Google Maps.
            if (b == null || b.isEmpty() || b.width() <= 0) {
                if (root != null && root.getWidth() > 0) {
                    int totalW = root.getWidth();
                    int leftW = Math.max(1, Math.round(totalW * splitRatio));
                    b = new Rect(leftW, 0, totalW, Math.max(1, root.getHeight()));
                }
            }

            try {
                boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(rightAV, activity, pkg, b);
                if (!ok) {
                    final Rect finalB = b;
                    postMainDelayed(() -> {
                        if (gen != expectedGen) return;
                        Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                        if (fallback != null) {
                            Object fallbackOpts = WindowHostActivityView.makeOptionsWithBounds(pkg, finalB);
                            WindowHostActivityView.startActivitySmart(rightAV, activity, fallback, fallbackOpts);
                        }
                    }, 200);
                }
            } catch (Exception e) {
                Log.e(TAG, "DualRight: Exception starting " + pkg, e);
            }
        };

        postMainDelayed(doStartRight, 80);
    }

    private void hideSurfaces() {
        if (surfacesHidden.get()) return;
        surfacesHidden.set(true);

        if (leftHost != null && leftAttached) {
            final String tag = "WindowHostDualPane#LeftPlaceholder";
            View placeholder = leftHost.findViewWithTag(tag);
            if (placeholder == null) {
                placeholder = new View(activity);
                placeholder.setTag(tag);
                placeholder.setClickable(false);
                placeholder.setFocusable(false);
                leftHost.addView(placeholder, new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            } else {
                placeholder.setVisibility(View.VISIBLE);
            }
        }

        if (rightHost != null && rightAttached) {
            final String tag = "WindowHostDualPane#RightPlaceholder";
            View placeholder = rightHost.findViewWithTag(tag);
            if (placeholder == null) {
                placeholder = new View(activity);
                placeholder.setTag(tag);
                placeholder.setClickable(false);
                placeholder.setFocusable(false);
                rightHost.addView(placeholder, new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            } else {
                placeholder.setVisibility(View.VISIBLE);
            }
        }
    }

    private void restoreSurfaces() {
        if (!surfacesHidden.get()) return;
        surfacesHidden.set(false);

        if (leftHost != null && leftAttached) {
            View placeholder = leftHost.findViewWithTag("WindowHostDualPane#LeftPlaceholder");
            if (placeholder != null) leftHost.removeView(placeholder);
            resetPaneToMatchParent(leftHost, leftAV);
        }

        if (rightHost != null && rightAttached) {
            View placeholder = rightHost.findViewWithTag("WindowHostDualPane#RightPlaceholder");
            if (placeholder != null) rightHost.removeView(placeholder);
            resetPaneToMatchParent(rightHost, rightAV);
        }

        flushPendingResizes();
    }

    private void scheduleRestore() {
        cancelPendingRestore();
        final int myGen = ++pendingRestoreGeneration;
        pendingRestore = () -> {
            if (myGen == pendingRestoreGeneration) {
                restoreSurfaces();
            }
        };
        postMainDelayed(pendingRestore, SURFACE_RESTORE_DELAY_MS);
    }

    private void cancelPendingRestore() {
        ++pendingRestoreGeneration;
        pendingRestore = null;
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
        } catch (Throwable t) { return 0.5f; }
    }

    private void applySplitFromBounds() {
        if (root == null || leftHost == null || rightHost == null || divider == null) return;
        if (!hasPendingBounds) return;

        lastAppliedSplitLeftW = lastAppliedSplitRightW = -1;

        int totalWidth = Math.max(1, pendingBounds.width());
        int minW = Math.round(totalWidth * MIN_SPLIT_RATIO);
        int maxW = Math.round(totalWidth * MAX_SPLIT_RATIO);
        int leftWidth  = clampPx(Math.round(totalWidth * splitRatio), minW, maxW);
        int rightWidth = totalWidth - leftWidth;

        int dividerX = leftWidth - (DIVIDER_TOTAL_PX / 2);

        FrameLayout.LayoutParams leftLp = (FrameLayout.LayoutParams) leftHost.getLayoutParams();
        leftLp.width = leftWidth;
        leftLp.leftMargin = 0;
        leftHost.setLayoutParams(leftLp);

        FrameLayout.LayoutParams rightLp = (FrameLayout.LayoutParams) rightHost.getLayoutParams();
        rightLp.width = rightWidth;
        rightLp.leftMargin = leftWidth;
        rightHost.setLayoutParams(rightLp);

        FrameLayout.LayoutParams dividerLp = (FrameLayout.LayoutParams) divider.getLayoutParams();
        dividerLp.leftMargin = dividerX;
        dividerLp.width = DIVIDER_TOTAL_PX;
        divider.setLayoutParams(dividerLp);

        if (!surfacesHidden.get()) {
            resetPaneToMatchParent(leftHost, leftAV);
            resetPaneToMatchParent(rightHost, rightAV);
        }
    }

    private void saveSplitRatio() {
        try {
            SharedPreferences sp = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            sp.edit().putFloat(KEY_SPLIT, splitRatio).apply();
        } catch (Throwable ignore) {}
    }

    private void applySplitImmediate() {
        applySplitImmediate(30);
    }

    private void applySplitImmediate(int retriesLeft) {
        if (root == null || leftHost == null || rightHost == null || divider == null) return;
        if (!hasPendingBounds) return;

        // Guard against resizing the pane *containers* while either ActivityView is
        // still mid native-reparent (see WindowUtil.isReparentUnsettled()). Resizing
        // leftHost/rightHost forces a layout traversal on the (INVISIBLE-but-still-
        // laid-out) child ActivityView, which can throw deep inside the framework's
        // own traversal before reparentHostChild's waiter has confirmed success.
        View leftView  = leftAV  != null ? WindowHostActivityView.asView(leftAV)  : null;
        View rightView = rightAV != null ? WindowHostActivityView.asView(rightAV) : null;
        if (WindowUtil.isReparentUnsettled(leftView) || WindowUtil.isReparentUnsettled(rightView)) {
            if (retriesLeft > 0) {
                postNextFrame(() -> applySplitImmediate(retriesLeft - 1));
            } else {
                postMainDelayed(() -> applySplitImmediate(EXTRA_SETTLE_RETRIES), 100);
            }
            return;
        }

        int totalWidth = Math.max(1, pendingBounds.width());

        int minW = Math.round(totalWidth * MIN_SPLIT_RATIO);
        int maxW = Math.round(totalWidth * MAX_SPLIT_RATIO);

        int leftW  = clampPx(Math.round(totalWidth * splitRatio), minW, maxW);
        int rightW = totalWidth - leftW;

        if (leftW == lastAppliedSplitLeftW && rightW == lastAppliedSplitRightW) {
            return; 
        }
        lastAppliedSplitLeftW = leftW;
        lastAppliedSplitRightW = rightW;

        FrameLayout.LayoutParams leftLp = (FrameLayout.LayoutParams) leftHost.getLayoutParams();
        FrameLayout.LayoutParams rightLp = (FrameLayout.LayoutParams) rightHost.getLayoutParams();
        FrameLayout.LayoutParams dividerLp = (FrameLayout.LayoutParams) divider.getLayoutParams();

        leftLp.width = leftW;
        leftLp.leftMargin = 0;

        rightLp.width = rightW;
        rightLp.leftMargin = leftW;

        dividerLp.leftMargin = leftW - (DIVIDER_TOTAL_PX / 2);
        dividerLp.width = DIVIDER_TOTAL_PX;

        leftHost.setLayoutParams(leftLp);
        rightHost.setLayoutParams(rightLp);
        divider.setLayoutParams(dividerLp);

        if (!surfacesHidden.get()) {
            resetPaneToMatchParent(leftHost, leftAV);
            resetPaneToMatchParent(rightHost, rightAV);
        }
    }

    private void hookFirstFrame(View root, boolean isLeft) {
        SurfaceView sv = findSurfaceView(root);
        if (sv != null) {
            try {
                SurfaceHolder h = sv.getHolder();
                h.addCallback(new SurfaceHolder.Callback2() {
                    @Override public void surfaceCreated(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                        if (width > 0 && height > 0) {
                            if (isLeft) leftFirstFrame.set(true); else rightFirstFrame.set(true);
                        }
                    }
                    @Override public void surfaceDestroyed(@NonNull SurfaceHolder holder) { }
                    @Override public void surfaceRedrawNeeded(@NonNull SurfaceHolder holder) {
                        if (isLeft) leftFirstFrame.set(true); else rightFirstFrame.set(true);
                    }
                });
            } catch (Throwable ignore) {}
        }
    }

    private SurfaceView findSurfaceView(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup g) {
            for (int i = 0; i < g.getChildCount(); i++) {
                SurfaceView res = findSurfaceView(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }

    private void hardRemoveWindow(boolean releaseAVs, int expectedGen) {
        if (gen != expectedGen) return;
        cancelPendingRestore();

        clearTapRegionQuietly(leftAV);
        clearTapRegionQuietly(rightAV);

        if (leftHost != null && leftAttached) { try { leftHost.removeAllViews(); } catch (Throwable ignore) {} leftAttached = false; }
        if (rightHost != null && rightAttached) { try { rightHost.removeAllViews(); } catch (Throwable ignore) {} rightAttached = false; }

        final View toRemove = root;
        final WindowManager wmRef = wm;

        if (added && wmRef != null && toRemove != null) {
            try { wmRef.removeViewImmediate(toRemove); }
            catch (Throwable t) { Log.w(TAG, "hardRemoveWindow: removeViewImmediate threw", t); }
        }

        if (releaseAVs) {
            if (leftAV != null)  { try { WindowHostActivityView.release(leftAV); } catch (Throwable ignore) {} resetVdCache(leftAV); leftAV = null; leftTask = -1; leftReady.set(false); }
            if (rightAV != null) { try { WindowHostActivityView.release(rightAV); } catch (Throwable ignore) {} resetVdCache(rightAV); rightAV = null; rightTask = -1; rightReady.set(false); }
        }

        added = false;
        root = null; leftHost = null; rightHost = null; divider = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = false;
        rightStartDeferredForBounds = false;
        visible.set(false);
        surfacesHidden.set(false);
    }

    private void forceRemoveWindowNoGen() {
        cancelPendingRestore();

        clearTapRegionQuietly(leftAV);
        clearTapRegionQuietly(rightAV);

        if (leftHost != null && leftAttached) { try { leftHost.removeAllViews(); } catch (Throwable ignore) {} leftAttached = false; }
        if (rightHost != null && rightAttached) { try { rightHost.removeAllViews(); } catch (Throwable ignore) {} rightAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        added = false;
        visible.set(false);
        root = null; leftHost = null; rightHost = null; divider = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        leftStartDeferredForBounds = false;
        rightStartDeferredForBounds = false;
        surfacesHidden.set(false);
    }

    private void parkInvisible() {
        if (added && wm != null && lp != null && root != null) {
            lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
            lp.width = 600; lp.height = 600;
            lp.flags |= WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
            try { wm.updateViewLayout(root, lp); }
            catch (Throwable t) {
                try { wm.removeViewImmediate(root); } catch (Throwable ignore2) {}
            }
            root.setAlpha(0f); 
            root.setVisibility(View.INVISIBLE);
            WindowHostSurfaceTamer.forceCleanup(root);
        }
    }

    private void waitUntil(BooleanSupplier cond, Runnable onOk, Runnable onTimeout) {
        final long start = SystemClock.uptimeMillis();
        final Runnable[] tick = new Runnable[1];
        tick[0] = () -> {
            if (cond.getAsBoolean()) { onOk.run(); return; }
            long elapsed = SystemClock.uptimeMillis() - start;
            if (elapsed >= START_WAIT_TIMEOUT_MS) { onTimeout.run(); return; }
            postMainDelayed(tick[0], START_WAIT_STEP_MS);
        };
        postMain(tick[0]);
    }

    private static int dp(int v) { return Math.round(LauncherApplication.sApp.getResources().getDisplayMetrics().density * v); }
    private static int clampPx(int v, int min, int max) { if (v < min) return min;
        return Math.min(v, max);
    }

    private static void postNextFrame(Runnable r) {
        try { Choreographer.getInstance().postFrameCallback(ft -> r.run()); }
        catch (Throwable t) { new Handler(Looper.getMainLooper()).postDelayed(r, 16); }
    }

    private void postMain(Runnable r) { new Handler(Looper.getMainLooper()).post(r); }
    private void postMainDelayed(Runnable r, long delayMs) {
        new Handler(Looper.getMainLooper()).postDelayed(r, delayMs);
    }

    private void checkForBlackScreenAndRestart(boolean isLeft, String pkg, int expectedGen) {
        if (gen != expectedGen) return;

        postMainDelayed(() -> {
            if (gen != expectedGen) return;

            if (surfacesHidden.get()) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(isLeft, pkg, expectedGen), 300);
                return;
            }

            boolean isBlack = false;
            AtomicBoolean detectionFlag = isLeft ? leftBlackScreenDetected : rightBlackScreenDetected;
            int restartCount = isLeft ? leftRestartCount : rightRestartCount;

            FrameLayout container = isLeft ? leftHost : rightHost;
            if (container != null) {
                SurfaceView sv = findSurfaceView(container);
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

            AtomicBoolean firstFrameFlag = isLeft ? leftFirstFrame : rightFirstFrame;
            if (!firstFrameFlag.get() && restartCount < MAX_RESTART_ATTEMPTS) {
                isBlack = true;
            }

            if (!isBlack) {
                if (isLeft) leftBlackConfirmCount = 0; else rightBlackConfirmCount = 0;
                return;
            }

            if (detectionFlag.get() || restartCount >= MAX_RESTART_ATTEMPTS) {
                return;
            }

            if (isLeft) leftBlackConfirmCount++; else rightBlackConfirmCount++;
            int confirmCount = isLeft ? leftBlackConfirmCount : rightBlackConfirmCount;

            if (confirmCount < REQUIRED_BLACK_CONFIRMATIONS) {
                postMainDelayed(() -> checkForBlackScreenAndRestart(isLeft, pkg, expectedGen), BLACK_SCREEN_CONFIRM_DELAY_MS);
                return;
            }

            detectionFlag.set(true);
            if (isLeft) leftBlackConfirmCount = 0; else rightBlackConfirmCount = 0;

            if (isLeft) leftRestartCount++; else rightRestartCount++;

            restartPaneApp(isLeft, pkg, expectedGen);

        }, BLACK_SCREEN_CHECK_DELAY_MS);
    }

    private void restartPaneApp(boolean isLeft, String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null || pkg.isEmpty()) return;

        forceStopApp(activity, pkg);
        
        postMainDelayed(() -> {
            if (gen != expectedGen) return;
            
            if (isLeft) {
                if (leftAV != null) {
                    try { WindowHostActivityView.release(leftAV); } catch (Throwable ignore) {}
                    leftAV = null;
                }
                leftTask = -1;
                leftReady.set(false);
                leftFirstFrame.set(false);
                leftBlackScreenDetected.set(false);
                
                if (leftHost != null) {
                    leftHost.removeAllViews();
                    leftAttached = false;
                }
                
                ensureActivityView(activity, expectedGen, pkg, rightPkg);
                attachLeft();
                
                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    startLeftWhenReady(pkg, expectedGen);
                    checkForBlackScreenAndRestart(true, pkg, expectedGen);
                }, 300);
                
            } else {
                if (rightAV != null) {
                    try { WindowHostActivityView.release(rightAV); } catch (Throwable ignore) {}
                    rightAV = null;
                }
                rightTask = -1;
                rightReady.set(false);
                rightFirstFrame.set(false);
                rightBlackScreenDetected.set(false);
                
                if (rightHost != null) {
                    rightHost.removeAllViews();
                    rightAttached = false;
                }
                
                ensureActivityView(activity, expectedGen, leftPkg, pkg);
                attachRight();
                
                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    startRightWhenReady(pkg, expectedGen);
                    checkForBlackScreenAndRestart(false, pkg, expectedGen);
                }, 300);
            }
        }, 500);
    }

    static final class DividerView extends FrameLayout {
        public DividerView(Context ctx, int visualWidthPx) {
            super(ctx);
            setWillNotDraw(false);
            setBackgroundColor(Color.TRANSPARENT);
            
            View bar = new View(ctx);
            LayoutParams lp = new LayoutParams(visualWidthPx, LayoutParams.MATCH_PARENT, Gravity.CENTER);
            bar.setLayoutParams(lp);
            bar.setBackgroundColor(0xFFE0E0E0);
            addView(bar);
            
            View dots = new VerticalDotsView(ctx, 0xFF666666, 2.5f, 9f);
            LayoutParams dl = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER);
            addView(dots, dl);
        }
    }

    static final class VerticalDotsView extends View {
        private final Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        private final float dotRadiusPx;
        private final float spacingPx;

        public VerticalDotsView(Context ctx, int dotColor, float dotRadiusDp, float spacingDp) {
            super(ctx);
            float d = ctx.getResources().getDisplayMetrics().density;
            p.setColor(dotColor);
            dotRadiusPx = dotRadiusDp * d;
            spacingPx   = spacingDp * d;
            setWillNotDraw(false);
        }

        @Override 
        protected void onDraw(@NonNull android.graphics.Canvas canvas) {
            super.onDraw(canvas);
            float cx = getWidth() / 2f, cy = getHeight() / 2f;
            canvas.drawCircle(cx, cy - spacingPx, dotRadiusPx, p);
            canvas.drawCircle(cx, cy,               dotRadiusPx, p);
            canvas.drawCircle(cx, cy + spacingPx, dotRadiusPx, p);
        }

        @Override 
        protected void onMeasure(int w, int h) {
            int ww = Math.round(dotRadiusPx * 2.8f);
            int hh = Math.round(spacingPx * 4 + dotRadiusPx * 6);
            setMeasuredDimension(ww, hh);
        }
    }

    private final class DividerDragController implements View.OnTouchListener, Choreographer.FrameCallback {
        private final float SLOP = ViewConfiguration.get(LauncherApplication.sApp).getScaledTouchSlop();
        private boolean dragging = false, posted = false;
        private boolean touchCaptured = false; 
        private float downRawX, downRawY;
        private int startLeftW;
        private int pendingLeft = -1, pendingRight = -1;
        private int minW, maxW, totalW;
        private final AtomicBoolean interactive = new AtomicBoolean(true);

        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if (!interactive.get()) return false;
            if (root == null || leftHost == null || rightHost == null) return false;

            switch (e.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    downRawX = e.getRawX();
                    downRawY = e.getRawY();
                    dragging = false;
                    posted = false;
                    touchCaptured = false;

                    totalW = hasPendingBounds ? pendingBounds.width() : root.getWidth();
                    if (totalW <= 0 && root != null) totalW = root.getWidth();
                    if (totalW <= 0) totalW = 1;

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
                        if (adx > SLOP || ady > SLOP) {
                            if (adx > ady) {
                                touchCaptured = true;
                                dragging = true;
                                try {
                                    v.getParent().requestDisallowInterceptTouchEvent(true);
                                } catch (Throwable ignore) { }
                                hideSurfaces();
                            } else {
                                return false;
                            }
                        } else {
                            return true;
                        }
                    }

                    if (!dragging) return false;
                    if (totalW <= 0) return true;

                    float dx = e.getRawX() - downRawX;
                    int candidate = startLeftW + Math.round(dx);
                    int newLeft  = clampPx(candidate, minW, maxW);
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
                        if (pendingLeft >= 0) applyWidths(pendingLeft, pendingRight);
                        dragging = false;
                        posted = false;
                        pendingLeft = pendingRight = -1;

                        saveSplitRatio();

                        postMainDelayed(() -> {
                            restoreSurfaces();
                            flushPendingResizes();

                            if (WindowHostActivityView.isGoogleMapsPackage(leftPkg) && leftAV != null && leftHost != null) {
                                notifyGoogleMapsSurfaceResize(WindowHostActivityView.asView(leftAV), leftHost.getWidth(), leftHost.getHeight());
                            }
                            if (WindowHostActivityView.isGoogleMapsPackage(rightPkg) && rightAV != null && rightHost != null) {
                                notifyGoogleMapsSurfaceResize(WindowHostActivityView.asView(rightAV), rightHost.getWidth(), rightHost.getHeight());
                            }
                        }, 120);
                    }

                    touchCaptured = false;
                    try {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                    } catch (Throwable ignore) { }
                    return true;
                }
            }
            return false;
        }

        @Override
        public void doFrame(long frameTimeNanos) {
            posted = false;
            if (pendingLeft >= 0) applyWidths(pendingLeft, pendingRight);
        }

        private void applyWidths(int leftW, int rightW) {
            if (root == null || leftHost == null || rightHost == null || divider == null) return;

            if (leftAV != null && WindowUtil.isReparentUnsettled(WindowHostActivityView.asView(leftAV))) return;
            if (rightAV != null && WindowUtil.isReparentUnsettled(WindowHostActivityView.asView(rightAV))) return;

            int tw = Math.max(1, leftW + rightW);

            int min = Math.round(tw * MIN_SPLIT_RATIO);
            int max = Math.round(tw * MAX_SPLIT_RATIO);
            int clampedLeft  = clampPx(leftW, min, max);
            int clampedRight = tw - clampedLeft;

            setSplitRatio((float) clampedLeft / (float) tw);

            FrameLayout.LayoutParams leftLp = (FrameLayout.LayoutParams) leftHost.getLayoutParams();
            FrameLayout.LayoutParams rightLp = (FrameLayout.LayoutParams) rightHost.getLayoutParams();
            FrameLayout.LayoutParams dividerLp = (FrameLayout.LayoutParams) divider.getLayoutParams();

            leftLp.width = clampedLeft;
            leftLp.leftMargin = 0;

            rightLp.width = clampedRight;
            rightLp.leftMargin = clampedLeft;

            dividerLp.leftMargin = clampedLeft - (DIVIDER_TOTAL_PX / 2);
            dividerLp.width = DIVIDER_TOTAL_PX;

            leftHost.setLayoutParams(leftLp);
            rightHost.setLayoutParams(rightLp);
            divider.setLayoutParams(dividerLp);
        }
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

    private void resizeActivityViewVirtualDisplay(Object paneAV, int width, int height, int densityDpi) {
        View avView = WindowHostActivityView.asView(paneAV);
        if (avView == null || width <= 0 || height <= 0) return;

        try {
            java.lang.reflect.Field vdField = avView.getClass().getDeclaredField("mVirtualDisplay");
            vdField.setAccessible(true);
            Object vd = vdField.get(avView);
            if (vd == null) return;

            Method resize = vd.getClass().getMethod("resize", int.class, int.class, int.class);
            int safeDensity = Math.max(120, densityDpi);
            resize.invoke(vd, width, height, safeDensity);
        } catch (Throwable t) {
            Log.w(TAG, "resizeActivityViewVirtualDisplay failed", t);
        }
    }

    private void enforcePaneVirtualDisplay(Object paneAV, int paneW, int paneH) {
        if (paneAV == null || paneW < 50 || paneH < 50) return;

        if (surfacesHidden.get()) return;

        View avView = WindowHostActivityView.asView(paneAV);

        int[] last = vdSizeCache.get(paneAV);

        if (last != null && Math.abs(paneW - last[0]) < 8 && Math.abs(paneH - last[1]) < 8) {
            return;
        }

        if (last == null) {
            last = new int[2];
            vdSizeCache.put(paneAV, last);
        }
        last[0] = paneW;
        last[1] = paneH;

        int density = resolveDensityDpi(avView);
        resizeActivityViewVirtualDisplay(paneAV, paneW, paneH, density);

        String currentPkg = (paneAV == leftAV) ? leftPkg : rightPkg;
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

    private void clearTapRegionQuietly(Object paneAV) {
        View v = WindowHostActivityView.asView(paneAV);
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
        } catch (Throwable ignore) { }
    }

    private void refreshTapRegionSafely(Object paneAV, int retriesLeft) {
        View v = WindowHostActivityView.asView(paneAV);
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
        } catch (Throwable t) {
            if (retriesLeft > 0) {
                postMainDelayed(() -> refreshTapRegionSafely(paneAV, retriesLeft - 1), 32);
            }
        }
    }
}