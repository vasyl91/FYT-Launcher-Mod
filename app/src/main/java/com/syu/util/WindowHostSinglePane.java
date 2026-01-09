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

import com.android.launcher66.LauncherApplication;

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
    private static long REVEAL_FALLBACK_NS = 320_000_000L; // ~320ms
    private static int  START_WAIT_TIMEOUT_MS = 40;
    private static int  START_WAIT_STEP_MS    = 4;

    private static final ScheduledExecutorService DISMISS_EXEC =
            Executors.newSingleThreadScheduledExecutor();
            
    private Activity activity;
    private WindowManager wm;
    private final String name;
    private WindowManager.LayoutParams lp;
    private FrameLayout root, host, curtain;
    public boolean added;
    private boolean childAttached;

    private Object av;              // android.app.ActivityView
    private final AtomicBoolean avReady = new AtomicBoolean(false);
    private final AtomicBoolean firstFrame = new AtomicBoolean(false);
    private final AtomicBoolean visible = new AtomicBoolean(false);

    private String currentPkg = null;
    private int taskId = -1;
    private int gen = 0;

    private final Rect pendingBounds = new Rect();
    private boolean hasPendingBounds = false;
    private long startNs = 0L;

    WindowHostSinglePane(String name) { this.name = name; }

    boolean isVisible() { return visible.get(); }

    void show(Activity act, WindowManager wm, ActivityManager am, IBinder token, String pkg, Rect b) {
        if (pkg == null || b == null) return;

        // Pre-warm for next time
        new Thread(() -> {
            WindowHostSurfacePreloader.prewarmActivityView(act, "single_" + name);
        }).start();

        this.activity = act;
        this.wm = wm;

        if (visible.get() && pkg.equals(currentPkg) && added && root != null && lp != null) {
            setPendingBoundsFast(b);
            Log.i(TAG, name + ": show suppressed (already visible) – resize-only.");
            return;
        }

        final int myGen = ++gen;
        
        // Reset restart counter and detection flag for new show
        restartAttempts = 0;
        blackScreenDetected.set(false);

        forceRemoveWindowNoGen();

        postNextFrame(() -> {
            if (gen != myGen) return;

            ensureWindow(act, wm, token);
            setPendingBoundsFast(b);
            ensureActivityView(act, myGen);
            if (!childAttached) attachChild(myGen);

            boolean haveTask = (taskId > 0) && pkg.equals(currentPkg);
            currentPkg = pkg;
            firstFrame.set(false);
            startNs = System.nanoTime();
            visible.set(true);

            if (!haveTask) {
                startWhenReady(am, pkg, myGen);
                // Schedule black screen check
                checkForBlackScreenAndRestart(pkg, myGen);
            }
            liftCurtainLoop(true, myGen);
        });
    }

    public void updateBounds(Rect b) {
        setPendingBoundsFast(b);
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
    }

    private void ensureWindow(Activity act, WindowManager wm, IBinder token) {
        if (added && root != null && lp != null) return;

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
                | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS;
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
            if (curtain != null) curtain.setVisibility(View.GONE); // Add this
            
            // Add this: Request focus for the embedded view after repositioning
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

    private void ensureActivityView(Context ctx, int expectedGen) {
        if (av != null) return;
        
        // Try to get pre-warmed instance first
        av = WindowHostSurfacePreloader.getWarmActivityView("single_" + name);
        
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
        
        // Force instant surface readiness
        View avView = WindowHostActivityView.asView(av);
        WindowHostSurfacePreloader.forceInstantSurfaceReady(avView);
    }

    private void attachChild(int expectedGen) {
        if (host == null || av == null) return;
        View v = WindowHostActivityView.asView(av);
        if (v.getParent() instanceof ViewGroup) { 
            try { ((ViewGroup) v.getParent()).removeView(v); } catch (Throwable ignore) {} 
        }
        host.removeAllViews();
        v.setVisibility(View.VISIBLE);
        WindowHostSurfaceTamer.tame(v);
        hookFirstFrame(v);
        host.addView(v, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        childAttached = true;
        if (curtain != null) curtain.setVisibility(View.VISIBLE);
        
        WindowHostInstantRenderStrategy.applyToContainer(host, "single_" + name);
    }

    private void startWhenReady(ActivityManager am, String pkg, int expectedGen) {
        waitUntil(() -> avReady.get() && childAttached, START_WAIT_TIMEOUT_MS, START_WAIT_STEP_MS, () -> {
            if (gen != expectedGen) return;
            startNow(am, pkg, expectedGen);
        }, () -> { if (gen != expectedGen) return; startNow(am, pkg, expectedGen); });
    }

    private void startNow(ActivityManager am, String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        if (taskId > 0 && pkg.equals(currentPkg)) return;
        
        // Validate surface is ready
        if (host != null) {
            SurfaceView sv = findSurfaceView(host);
            if (sv != null) {
                try {
                    SurfaceHolder holder = sv.getHolder();
                    if (holder == null || holder.getSurface() == null || !holder.getSurface().isValid()) {
                        Log.w(TAG, name + ": Surface not ready yet, deferring start");
                        postMainDelayed(() -> startNow(am, pkg, expectedGen), 50);
                        return;
                    }
                } catch (Throwable t) {
                    Log.w(TAG, name + ": Surface check failed, deferring start", t);
                    postMainDelayed(() -> startNow(am, pkg, expectedGen), 50);
                    return;
                }
            }
        }
        
        // Get bounds
        Rect bounds = hasPendingBounds ? new Rect(pendingBounds) : null;
        
        try {
            // Use enhanced method that checks for existing process
            boolean ok = WindowHostActivityView.startActivitySmartWithProcessCheck(av, activity, pkg, bounds);
            
            if (!ok) {
                Log.w(TAG, name + ": start failed for " + pkg + ", attempting fallback");
                
                // Fallback: use standard method with explicit intent
                postMainDelayed(() -> {
                    if (gen != expectedGen) return;
                    
                    Intent fallback = WindowHostActivityView.getLaunchIntentForPackage(activity, pkg);
                    if (fallback != null) {
                        Object fallbackOpts = WindowHostActivityView.makeOptionsWithBounds(bounds);
                        boolean retryOk = WindowHostActivityView.startActivitySmart(av, activity, fallback, fallbackOpts);
                        Log.i(TAG, name + (retryOk ? ": fallback succeeded" : ": fallback failed"));
                        
                        if (!retryOk) {
                            // Final attempt with minimal configuration
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
            
            // Try one more time with minimal configuration
            postMainDelayed(() -> {
                if (gen != expectedGen) return;
                attemptMinimalLaunch(pkg, bounds);
            }, 300);
        }
    }

    /**
     * Last-resort minimal launch attempt
     */
    private void attemptMinimalLaunch(String pkg, Rect bounds) {
        try {
            Log.i(TAG, name + ": Attempting minimal launch for " + pkg);
            
            PackageManager pm = activity.getPackageManager();
            Intent minimal = pm.getLaunchIntentForPackage(pkg);
            
            if (minimal == null) {
                Log.e(TAG, name + ": No launch intent available");
                return;
            }
            
            // Absolutely minimal flags
            minimal.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
            // Try with and without bounds
            ActivityOptions opts = ActivityOptions.makeBasic();
            if (bounds != null) {
                opts.setLaunchBounds(bounds);
            }
            
            boolean success = WindowHostActivityView.startActivitySmart(av, activity, minimal, opts);
            Log.i(TAG, name + ": Minimal launch " + (success ? "succeeded" : "failed"));
            
        } catch (Exception e) {
            Log.e(TAG, name + ": Minimal launch exception", e);
        }
    }

    private void liftCurtainLoop(boolean needFirstFrame, int expectedGen) {
        if (gen != expectedGen || root == null) return;
        long now = System.nanoTime();
        boolean gateOk = !needFirstFrame || firstFrame.get() || (now - startNs) >= REVEAL_FALLBACK_NS;
        if (gateOk) {
            if (curtain != null && curtain.getAlpha() > 0f) {
                curtain.setAlpha(0f);
                curtain.setVisibility(View.GONE);
            }
            return;
        }
        postNextFrame(() -> liftCurtainLoop(needFirstFrame, expectedGen));
    }

    private void hardRemoveWindow(boolean releaseAV, int expectedGen) {
        if (gen != expectedGen) return;
        if (host != null && childAttached) { try { host.removeAllViews(); } catch (Throwable ignore) {} childAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        if (releaseAV && av != null) { try { WindowHostActivityView.release(av); } catch (Throwable ignore) {} av = null; taskId = -1; }
        added = false;
        visible.set(false);
        root = null; host = null; curtain = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
    }

    private void forceRemoveWindowNoGen() {
        if (host != null && childAttached) { try { host.removeAllViews(); } catch (Throwable ignore) {} childAttached = false; }
        if (added && wm != null && root != null) { try { wm.removeViewImmediate(root); } catch (Throwable ignore) {} }
        added = false; visible.set(false);
        root = null; host = null; curtain = null; lp = null;
        hasPendingBounds = false; pendingBounds.setEmpty();
    }

    private void parkInvisible() {
        if (added && wm != null && lp != null && root != null) {
            lp.x = -3000; lp.y = -3000; lp.alpha = 0f;
            lp.width = 600; lp.height = 600;
            try { wm.updateViewLayout(root, lp); } catch (Throwable ignore) {}
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
                    @Override public void surfaceCreated(SurfaceHolder holder) { }
                    @Override public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                        if (width > 0 && height > 0) firstFrame.set(true);
                    }
                    @Override public void surfaceDestroyed(SurfaceHolder holder) { }
                    @Override public void surfaceRedrawNeeded(SurfaceHolder holder) { firstFrame.set(true); }
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
        if (v instanceof ViewGroup) {
            ViewGroup g = (ViewGroup) v;
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

    private static Intent mainLaunchIntent(String pkg) {
        try {
            PackageManager pm = LauncherApplication.sApp.getPackageManager();
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

    private void checkForBlackScreenAndRestart(String pkg, int expectedGen) {
        if (gen != expectedGen) return;
        
        postMainDelayed(() -> {
            if (gen != expectedGen) return;
            
            boolean isBlack = false;
            
            // Check if surface is visible and has content
            if (host != null) {
                SurfaceView sv = findSurfaceView(host);
                if (sv != null && sv.getVisibility() == View.VISIBLE) {
                    // Check if surface holder has a valid surface
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
            
            // Also check if the first frame was never rendered
            if (!firstFrame.get() && restartAttempts < MAX_RESTART_ATTEMPTS) {
                isBlack = true;
            }
            
            if (isBlack && !blackScreenDetected.get() && restartAttempts < MAX_RESTART_ATTEMPTS) {
                Log.w(TAG, name + " showing black screen, restarting app: " + pkg);
                blackScreenDetected.set(true);
                restartAttempts++;
                
                // Restart the app
                restartPaneApp(pkg, expectedGen);
            }
        }, BLACK_SCREEN_CHECK_DELAY_MS);
    }

    private void restartPaneApp(String pkg, int expectedGen) {
        if (gen != expectedGen || pkg == null || pkg.isEmpty()) return;
        
        // Force stop the app
        try {
            ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
            Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(am, pkg);
            Log.i(TAG, name + ": Force stopped " + pkg);
        } catch (Throwable t) {
            Log.w(TAG, name + ": Failed to force stop " + pkg, t);
        }
        
        // Release and recreate the ActivityView
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
            
            // Recreate ActivityView
            ensureActivityView(activity, expectedGen);
            attachChild(expectedGen);
            
            // Restart the activity
            postMainDelayed(() -> {
                if (gen != expectedGen) return;
                ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
                startWhenReady(am, pkg, expectedGen);
                
                // Schedule another check
                checkForBlackScreenAndRestart(pkg, expectedGen);
            }, 300);
            
        }, 500);
    }
}