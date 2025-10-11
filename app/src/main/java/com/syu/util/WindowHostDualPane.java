package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
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

import com.android.launcher66.LauncherApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;

public  class WindowHostDualPane {
    private static final String TAG = "WindowHostDualPane";

    private static final String PREFS = "pip_window_host_prefs";
    private static final String KEY_SPLIT = "dual_split_ratio";
    private static final long SURFACE_RESTORE_DELAY_MS = 500L;

    // Timing
    private static int  START_WAIT_TIMEOUT_MS = 40;
    private static int  START_WAIT_STEP_MS    = 4;

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

    // Surface stability control
    private final AtomicBoolean surfacesHidden = new AtomicBoolean(false);
    private Runnable pendingRestore = null;

    private int leftTask = -1, rightTask = -1;
    private String leftPkg = null, rightPkg = null;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;

    // sizing - overlapping divider design
    private final int DIVIDER_VISUAL_PX = dp(8);         // what user sees
    private final int DIVIDER_GUARD_PX  = dp(12);        // touch area extension each side
    private final int DIVIDER_TOTAL_PX  = DIVIDER_VISUAL_PX + DIVIDER_GUARD_PX*2;
    private static final float MIN_SPLIT_RATIO = 0.25f; // 25%
    private static final float MAX_SPLIT_RATIO = 0.75f;
    private int minPaneWidthPx = dp(120);
    private float splitRatio = 0.5f; // persisted

    // drag
    private final DividerDragController dragController = new DividerDragController();

    boolean isVisible() { return visible.get(); }

    void show(Activity act, WindowManager wm, ActivityManager am, IBinder token, String lPkg, String rPkg, Rect b) {
        if (lPkg == null || rPkg == null || b == null) return;

        this.activity = act;
        this.wm = wm;

        // restore saved split position
        float saved = loadSplitRatio();
        setSplitRatio(saved);

        if (visible.get() && lPkg.equals(leftPkg) && rPkg.equals(rightPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            applySplitFromBounds();
            return;
        }

        final int myGen = ++gen;
        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            ensureWindow(act, wm, token);
            setPendingBoundsFast(b);
            applySplitFromBounds();
            ensureAVs(act, myGen);
            if (!leftAttached) attachLeft(myGen);
            if (!rightAttached) attachRight(myGen);

            boolean haveL = (leftTask > 0) && lPkg.equals(leftPkg);
            boolean haveR = (rightTask > 0) && rPkg.equals(rightPkg);
            leftPkg = lPkg; rightPkg = rPkg;
            leftFirstFrame.set(false); rightFirstFrame.set(false);
            visible.set(true);

            if (!haveL) startLeftWhenReady(am, lPkg, myGen);
            if (!haveR) startRightWhenReady(am, rPkg, myGen);
        });
    }

    public void updateBounds(Rect b) {
        setPendingBoundsFast(b);
    }

    void dismissAsync(boolean keepTasks) {
        final int myGen = ++gen;
        visible.set(false);
        cancelPendingRestore();
        parkInvisible();
        postMain(() -> hardRemoveWindow(!keepTasks, myGen));
        DISMISS_EXEC.schedule(() -> postMain(() -> {
            if (gen != myGen) return;
            if (added || root != null) hardRemoveWindow(!keepTasks, myGen);
        }), 150, TimeUnit.MILLISECONDS);
    }

    void cleanup() {
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
    }

    private void ensureWindow(Activity act, WindowManager wm, IBinder token) {
        if (added && root != null && lp != null) return;

        // Root container
        FrameLayout rootView = new FrameLayout(act);
        rootView.setBackgroundColor(Color.TRANSPARENT);
        rootView.setWillNotDraw(true);
        rootView.setClickable(false);

        // Left pane - full width initially
        FrameLayout left = new FrameLayout(act);
        left.setBackgroundColor(Color.TRANSPARENT);
        left.setWillNotDraw(true);
        left.setClickable(false);

        // Right pane - full width initially
        FrameLayout right = new FrameLayout(act);
        right.setBackgroundColor(Color.TRANSPARENT);
        right.setWillNotDraw(true);
        right.setClickable(false);

        // Divider - overlays on top
        DividerView divider = new DividerView(act, DIVIDER_VISUAL_PX, DIVIDER_GUARD_PX);
        divider.setClickable(false); 
        divider.setFocusable(false);
        divider.setFocusableInTouchMode(false);
        divider.setOnTouchListener(dragController);

        int match = ViewGroup.LayoutParams.MATCH_PARENT;
        
        // Add panes to root with full size
        rootView.addView(left, new FrameLayout.LayoutParams(match, match));
        rootView.addView(right, new FrameLayout.LayoutParams(match, match));
        
        // Add divider on top with specific positioning
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
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
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
        root.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override public void onGlobalLayout() { applySplitImmediate(); }
        });
    }

    private void setPendingBoundsFast(Rect b) {
        pendingBounds.set(b);
        hasPendingBounds = true;
        if (lp != null && root != null) {
            lp.width = Math.max(1, b.width());
            lp.height = Math.max(1, b.height());
            lp.x = b.left; lp.y = b.top;
            lp.alpha = 1f;
            try { wm.updateViewLayout(root, lp); } catch (Throwable ignore) {}
            root.setVisibility(View.VISIBLE);
            root.setAlpha(1f);
        }
    }

    private void ensureAVs(Context ctx, int expectedGen) {
        if (leftAV == null) {
            leftAV = WindowHostActivityView.newInstance(ctx);
            leftReady.set(false);
            WindowHostActivityView.trySetCallback(leftAV, new WindowHostActivityView.Callback() {
                @Override public void onReady() { if (gen == expectedGen) leftReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) leftTask = id; }
            });
        }
        if (rightAV == null) {
            rightAV = WindowHostActivityView.newInstance(ctx);
            rightReady.set(false);
            WindowHostActivityView.trySetCallback(rightAV, new WindowHostActivityView.Callback() {
                @Override public void onReady() { if (gen == expectedGen) rightReady.set(true); }
                @Override public void onTaskCreated(int id) { if (gen == expectedGen) rightTask = id; }
            });
        }
        leftFirstFrame.set(false); rightFirstFrame.set(false);
    }

    private void attachLeft(int expectedGen) {
        if (leftHost == null || leftAV == null) return;
        View v = WindowHostActivityView.asView(leftAV);
        if (v.getParent() instanceof ViewGroup) { try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} }
        leftHost.removeAllViews();
        v.setVisibility(View.VISIBLE);
        WindowHostSurfaceTamer.tame(v);
        hookFirstFrame(v, true);
        leftHost.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        leftAttached = true;
    }

    private void attachRight(int expectedGen) {
        if (rightHost == null || rightAV == null) return;
        View v = WindowHostActivityView.asView(rightAV);
        if (v.getParent() instanceof ViewGroup) { try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} }
        rightHost.removeAllViews();
        v.setVisibility(View.VISIBLE);
        WindowHostSurfaceTamer.tame(v);
        hookFirstFrame(v, false);
        rightHost.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rightAttached = true;
    }

    private void startLeftWhenReady(ActivityManager am, String pkg, int expectedGen) {
        waitUntil(() -> leftReady.get() && leftAttached, START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS, () -> {
            if (gen != expectedGen) return;
            startLeftNow(am, pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startLeftNow(am, pkg, expectedGen); });
    }

    private void startRightWhenReady(ActivityManager am, String pkg, int expectedGen) {
        waitUntil(() -> rightReady.get() && rightAttached, START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS, () -> {
            if (gen != expectedGen) return;
            startRightNow(am, pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startRightNow(am, pkg, expectedGen); });
    }

    private void startLeftNow(ActivityManager am, String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (leftTask > 0 && pkg.equals(leftPkg)) return;
        Intent i = mainLaunchIntent(activity, pkg);
        if (i == null) return;
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        int leftW = hasPendingBounds ? Math.max(1, Math.round(pendingBounds.width() * splitRatio)) : 300;
        Rect b = hasPendingBounds ? new Rect(pendingBounds.left, pendingBounds.top,
                pendingBounds.left + leftW, pendingBounds.bottom) : null;
        Object o = WindowHostActivityView.makeOptionsWithBounds(b);
        boolean ok = WindowHostActivityView.startActivitySmart(leftAV, activity, i, o);
        Log.i(TAG, "DualLeft " + (ok ? "start ok" : "start failed"));
    }

    private void startRightNow(ActivityManager am, String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (rightTask > 0 && pkg.equals(rightPkg)) return;
        Intent i = mainLaunchIntent(activity, pkg);
        if (i == null) return;
        i.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        int leftWidth = hasPendingBounds ? Math.max(1, Math.round(pendingBounds.width() * splitRatio)) : 300;
        Rect b = hasPendingBounds ? new Rect(
                pendingBounds.left + leftWidth,
                pendingBounds.top, pendingBounds.right, pendingBounds.bottom) : null;
        Object o = WindowHostActivityView.makeOptionsWithBounds(b);
        boolean ok = WindowHostActivityView.startActivitySmart(rightAV, activity, i, o);
        Log.i(TAG, "DualRight " + (ok ? "start ok" : "start failed"));
    }

    private void hideSurfaces() {
        if (surfacesHidden.get()) return;
        surfacesHidden.set(true);

        // LEFT
        if (leftHost != null && leftAttached) {
            // Keep container visible; hide only the app SurfaceView
            SurfaceView sv = findSurfaceView(leftHost);
            if (sv != null) sv.setVisibility(View.INVISIBLE);

            // Add a gray placeholder if not present
            final String tag = "WindowHostDualPane#LeftPlaceholder";
            View placeholder = leftHost.findViewWithTag(tag);
            if (placeholder == null) {
                placeholder = new View(activity);
                placeholder.setTag(tag);
                placeholder.setClickable(false);
                placeholder.setFocusable(false);
                placeholder.setBackgroundColor(android.graphics.Color.argb(160, 128, 128, 128)); // semi-transparent gray
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
                leftHost.addView(placeholder, lp);
            } else {
                placeholder.setVisibility(View.VISIBLE);
            }
        }

        // RIGHT
        if (rightHost != null && rightAttached) {
            // Keep container visible; hide only the app SurfaceView
            SurfaceView sv = findSurfaceView(rightHost);
            if (sv != null) sv.setVisibility(View.INVISIBLE);

            // Add a gray placeholder if not present
            final String tag = "WindowHostDualPane#RightPlaceholder";
            View placeholder = rightHost.findViewWithTag(tag);
            if (placeholder == null) {
                placeholder = new View(activity);
                placeholder.setTag(tag);
                placeholder.setClickable(false);
                placeholder.setFocusable(false);
                placeholder.setBackgroundColor(android.graphics.Color.argb(160, 128, 128, 128)); // semi-transparent gray
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );
                rightHost.addView(placeholder, lp);
            } else {
                placeholder.setVisibility(View.VISIBLE);
            }
        }

        Log.d(TAG, "Surfaces hidden during resize (placeholders shown)");
    }

    private void restoreSurfaces() {
        if (!surfacesHidden.get()) return;
        surfacesHidden.set(false);

        // LEFT
        if (leftHost != null && leftAttached) {
            // Remove/hide placeholder
            View placeholder = leftHost.findViewWithTag("WindowHostDualPane#LeftPlaceholder");
            if (placeholder != null) {
                leftHost.removeView(placeholder);
            }
            // Show app SurfaceView again
            SurfaceView sv = findSurfaceView(leftHost);
            if (sv != null) sv.setVisibility(View.VISIBLE);
        }

        // RIGHT
        if (rightHost != null && rightAttached) {
            // Remove/hide placeholder
            View placeholder = rightHost.findViewWithTag("WindowHostDualPane#RightPlaceholder");
            if (placeholder != null) {
                rightHost.removeView(placeholder);
            }
            // Show app SurfaceView again
            SurfaceView sv = findSurfaceView(rightHost);
            if (sv != null) sv.setVisibility(View.VISIBLE);
        }

        Log.d(TAG, "Surfaces restored after resize (placeholders removed)");
    }

    private void scheduleRestore() {
        cancelPendingRestore();
        pendingRestore = this::restoreSurfaces;
        postMainDelayed(pendingRestore, SURFACE_RESTORE_DELAY_MS);
    }

    private void cancelPendingRestore() {
        if (pendingRestore != null) {
            // Note: We can't actually cancel a posted runnable easily,
            // so we'll nullify the reference and check it in the restore method
            pendingRestore = null;
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
        } catch (Throwable t) { return 0.5f; }
    }

    private void applySplitFromBounds() {
        if (root == null || leftHost == null || rightHost == null || divider == null) return;
        if (!hasPendingBounds) return;

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
    }

    private void saveSplitRatio() {
        try {
            SharedPreferences sp = activity.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            sp.edit().putFloat(KEY_SPLIT, splitRatio).apply();
        } catch (Throwable ignore) {}
    }

    private void applySplitImmediate() {
        if (root == null || leftHost == null || rightHost == null || divider == null) return;
        if (!hasPendingBounds) return;

        int totalWidth = Math.max(1, pendingBounds.width());

        int minW = Math.round(totalWidth * MIN_SPLIT_RATIO);
        int maxW = Math.round(totalWidth * MAX_SPLIT_RATIO);
        int leftW  = clampPx(Math.round(totalWidth * splitRatio), minW, maxW);
        int rightW = totalWidth - leftW;

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
    }

    private void hookFirstFrame(View root, boolean isLeft) {
        SurfaceView sv = findSurfaceView(root);
        if (sv != null) {
            try {
                SurfaceHolder h = sv.getHolder();
                h.addCallback(new SurfaceHolder.Callback2() {
                    @Override public void surfaceCreated(SurfaceHolder holder) { }
                    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                        if (width > 0 && height > 0) {
                            if (isLeft) leftFirstFrame.set(true); else rightFirstFrame.set(true);
                        }
                    }
                    @Override public void surfaceDestroyed(SurfaceHolder holder) { }
                    @Override public void surfaceRedrawNeeded(SurfaceHolder holder) {
                        if (isLeft) leftFirstFrame.set(true); else rightFirstFrame.set(true);
                    }
                });
            } catch (Throwable ignore) {}
        } else {
            root.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                boolean done;
                @Override public boolean onPreDraw() {
                    if (done) return true;
                    done = true;
                    postNextFrame(() -> { if (isLeft) leftFirstFrame.set(true); else rightFirstFrame.set(true); });
                    root.getViewTreeObserver().removeOnPreDrawListener(this);
                    return true;
                }
            });
        }
    }

    private SurfaceView findSurfaceView(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup) {
            ViewGroup g = (ViewGroup) v;
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
        if (leftHost != null && leftAttached) { try { leftHost.removeAllViews(); } catch (Throwable ignore) {} leftAttached = false; }
        if (rightHost != null && rightAttached) { try { rightHost.removeAllViews(); } catch (Throwable ignore) {} rightAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        if (releaseAVs) {
            if (leftAV != null)  { try { WindowHostActivityView.release(leftAV); } catch (Throwable ignore) {} leftAV = null; leftTask = -1; leftReady.set(false); }
            if (rightAV != null) { try { WindowHostActivityView.release(rightAV); } catch (Throwable ignore) {} rightAV = null; rightTask = -1; rightReady.set(false); }
        }
        added = false;
        visible.set(false);
        root = null; leftHost = null; rightHost = null; divider = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        surfacesHidden.set(false);
    }

    private void forceRemoveWindowNoGen() {
        cancelPendingRestore();
        if (leftHost != null && leftAttached) { try { leftHost.removeAllViews(); } catch (Throwable ignore) {} leftAttached = false; }
        if (rightHost != null && rightAttached) { try { rightHost.removeAllViews(); } catch (Throwable ignore) {} rightAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        added = false;
        visible.set(false);
        root = null; leftHost = null; rightHost = null; divider = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
        surfacesHidden.set(false);
    }

    private void parkInvisible() {
        if (added && wm != null && lp != null && root != null) {
            lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
            lp.width = 600; lp.height = 600;
            try { wm.updateViewLayout(root, lp); } catch (Throwable ignore) {}
            root.setAlpha(0f); 
            root.setVisibility(View.INVISIBLE);
            WindowHostSurfaceTamer.forceCleanup(root);
        }
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

    private static int dp(int v) { return Math.round(LauncherApplication.sApp.getResources().getDisplayMetrics().density * v); }
    private static int clampPx(int v, int min, int max) { if (v < min) return min; if (v > max) return max; return v; }

    private static void postNextFrame(Runnable r) {
        try { Choreographer.getInstance().postFrameCallback(ft -> r.run()); }
        catch (Throwable t) { new android.os.Handler(android.os.Looper.getMainLooper()).postDelayed(r, 16); }
    }

    private static Intent mainLaunchIntent(Context ctx, String pkg) {
        try {
            PackageManager pm = ctx.getPackageManager();
            Intent i = pm.getLaunchIntentForPackage(pkg);
            if (i == null) return null;
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            return i;
        } catch (Throwable t) {
            Log.w(TAG, "mainLaunchIntent failed for " + pkg, t);
            return null;
        }
    }

    private void postMain(Runnable r) { new Handler(Looper.getMainLooper()).post(r); }
    private void postMainDelayed(Runnable r, long delayMs) {
        new Handler(Looper.getMainLooper()).postDelayed(r, delayMs);
    }

    static final class DividerView extends FrameLayout {
        public DividerView(Context ctx, int visualWidthPx, int guardPx) {
            super(ctx);
            setWillNotDraw(false);
            setBackgroundColor(Color.TRANSPARENT);
            
            // Center thin visual bar
            View bar = new View(ctx);
            LayoutParams lp = new LayoutParams(visualWidthPx, LayoutParams.MATCH_PARENT, Gravity.CENTER);
            bar.setLayoutParams(lp);
            bar.setBackgroundColor(0xFFE0E0E0);
            addView(bar);
            
            // Dots overlay centered on the bar
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
        protected void onDraw(android.graphics.Canvas canvas) {
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
        private boolean touchCaptured = false; // New flag to track if we should handle this touch sequence
        private float downRawX, downRawY;
        private int startLeftW;
        private int pendingLeft = -1, pendingRight = -1;
        private int minW, maxW, totalW;

        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if (root == null || leftHost == null || rightHost == null) return false;

            switch (e.getActionMasked()) {
                case MotionEvent.ACTION_DOWN: {
                    downRawX = e.getRawX();
                    downRawY = e.getRawY();
                    dragging = false;
                    posted = false;
                    touchCaptured = false; // don't capture until we know it's a horizontal drag

                    // Establish current geometry and clamp window for 25–75%
                    totalW = hasPendingBounds ? pendingBounds.width() : root.getWidth();
                    if (totalW <= 0 && root != null) totalW = root.getWidth();
                    if (totalW <= 0) totalW = 1;

                    minW = Math.round(totalW * MIN_SPLIT_RATIO); // 25%
                    maxW = Math.round(totalW * MAX_SPLIT_RATIO); // 75%
                    startLeftW = clampPx(Math.round(totalW * splitRatio), minW, maxW);

                    pendingLeft = pendingRight = -1;

                    // Consume DOWN so we can disambiguate the gesture; only capture later if horizontal
                    return true;
                }

                case MotionEvent.ACTION_MOVE: {
                    float adx = Math.abs(e.getRawX() - downRawX);
                    float ady = Math.abs(e.getRawY() - downRawY);

                    if (!touchCaptured) {
                        // Disambiguate: capture only horizontal drags; let vertical/taps pass through
                        if (adx > SLOP || ady > SLOP) {
                            if (adx > ady && adx > SLOP) {
                                // Horizontal drag — capture and start resizing
                                touchCaptured = true;
                                dragging = true;
                                try {
                                    v.getParent().requestDisallowInterceptTouchEvent(true);
                                } catch (Throwable ignore) { }
                                hideSurfaces();
                            } else {
                                // Vertical movement — don't capture; allow underlying apps to handle it
                                return false;
                            }
                        } else {
                            // Still within slop; keep monitoring without capturing
                            return true;
                        }
                    }

                    if (!dragging) return false;
                    if (totalW <= 0) return true;

                    // Update pending widths based on horizontal delta
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
                    if (!touchCaptured) {
                        // Short tap or vertical gesture that we didn't capture — let it pass through
                        return false;
                    }

                    if (dragging) {
                        if (pendingLeft >= 0) applyWidths(pendingLeft, pendingRight);
                        dragging = false;
                        posted = false;
                        pendingLeft = pendingRight = -1;

                        // Persist and restore surfaces after resizing ends
                        saveSplitRatio();
                        scheduleRestore();
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

            int tw = Math.max(1, leftW + rightW);

            // Enforce 25–75% when committing the layout
            int min = Math.round(tw * MIN_SPLIT_RATIO);
            int max = Math.round(tw * MAX_SPLIT_RATIO);
            int clampedLeft  = clampPx(leftW, min, max);
            int clampedRight = tw - clampedLeft;

            // Persist ratio within bounds
            setSplitRatio((float) clampedLeft / (float) tw);

            // Keep your layout semantics
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
}