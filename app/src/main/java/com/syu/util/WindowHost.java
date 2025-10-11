package com.syu.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;

public class WindowHost {
    private final Activity activity;
    private final WindowManager wm;
    private final ActivityManager am;
    private final IBinder appToken;
    private final boolean retainTasks = true;

    // Panes
    private final WindowHostSinglePane first, second, third, fourth;
    private final WindowHostDualPane dual;

    public WindowHost(Activity activity) {
        this.activity = activity;
        this.wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        this.am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        View decor = activity.getWindow().getDecorView();
        this.appToken = decor.getWindowToken();
        if (appToken == null) throw new IllegalStateException("Call after onResume() so window token exists.");
        WindowHostActivityView.ensureLoaded();
        this.first  = new WindowHostSinglePane("First");
        this.second = new WindowHostSinglePane("Second");
        this.third  = new WindowHostSinglePane("Third");
        this.fourth = new WindowHostSinglePane("Fourth");
        this.dual   = new WindowHostDualPane();
    }

    // ===== API: Dual =====
    public void showDual(String leftPkg, String rightPkg, Rect bounds) { dual.show(activity, wm, am, appToken, leftPkg, rightPkg, bounds); }
    public void updateDualBounds(Rect bounds) { if (dual != null) dual.updateBounds(bounds); }
    public void dismissDual()   { dual.dismissAsync(retainTasks); }
    public void cleanupDual()   { dual.cleanup(); }
    public boolean isDualVisible() { return dual.isVisible(); }

    // ===== API: Singles =====
    public void showFirst(String pkg, Rect bounds)  { first.show(activity, wm, am, appToken, pkg, bounds); }
    public void showSecond(String pkg, Rect bounds) { second.show(activity, wm, am, appToken, pkg, bounds); }
    public void showThird(String pkg, Rect bounds)  { third.show(activity, wm, am, appToken, pkg, bounds); }
    public void showFourth(String pkg, Rect bounds) { fourth.show(activity, wm, am, appToken, pkg, bounds); }

    public void updateFirstBounds(Rect bounds) { if (first != null) first.updateBounds(bounds); }
    public void updateSecondBounds(Rect bounds) { if (second != null) second.updateBounds(bounds); }
    public void updateThirdBounds(Rect bounds) { if (third != null)  third.updateBounds(bounds); }
    public void updateFourthBounds(Rect bounds) { if (fourth != null) fourth.updateBounds(bounds); }

    public void dismissFirst()  { first.dismissAsync(retainTasks); }
    public void dismissSecond() { second.dismissAsync(retainTasks); }
    public void dismissThird()  { third.dismissAsync(retainTasks); }
    public void dismissFourth() { fourth.dismissAsync(retainTasks); }

    public void dismiss() {
        first.dismissAsync(retainTasks);
        second.dismissAsync(retainTasks);
        third.dismissAsync(retainTasks);
        fourth.dismissAsync(retainTasks);
        dual.dismissAsync(retainTasks);
    }

    public void cleanup() {
        first.cleanup();
        second.cleanup();
        third.cleanup();
        fourth.cleanup();
        dual.cleanup();
    }

    public boolean isFirstVisible()  { return first.isVisible(); }
    public boolean isSecondVisible() { return second.isVisible(); }
    public boolean isThirdVisible()  { return third.isVisible(); }
    public boolean isFourthVisible() { return fourth.isVisible(); }

    /** Waits until all host windows are detached (or times out ~120ms), then runs action. */
    public void awaitHandoff(Runnable action) { awaitHandoff(120, action); }
    public void awaitHandoff(int maxWaitMs, Runnable action) {
        final long start = SystemClock.uptimeMillis();
        final Runnable tick = new Runnable() {
            @Override public void run() {
                if (areAllWindowsDetached() || SystemClock.uptimeMillis() - start >= maxWaitMs) {
                    try { action.run(); } catch (Throwable ignore) {}
                } else {
                    postMainDelayed(this, 12);
                }
            }
        };
        postMain(tick);
    }
    private boolean areAllWindowsDetached() {
        return !first.added && !second.added && !third.added && !fourth.added && !dual.added;
    }

    private void postMain(Runnable r) { new Handler(Looper.getMainLooper()).post(r); }
    private void postMainDelayed(Runnable r, long delayMs) {
        new Handler(Looper.getMainLooper()).postDelayed(r, delayMs);
    }
}