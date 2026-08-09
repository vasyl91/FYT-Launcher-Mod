package com.syu.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;

public class WindowHost {
    public static volatile WindowHost sInstance;

    private final Activity activity;
    private final WindowManager wm;
    private final IBinder appToken;

    // Panes
    private final WindowHostSinglePane first, second, third, fourth;
    private final WindowHostDualPane dual;

    public WindowHost(Activity activity) {
        this.activity = activity;
        this.wm = (WindowManager) activity.getSystemService(Context.WINDOW_SERVICE);
        View decor = activity.getWindow().getDecorView();
        this.appToken = decor.getWindowToken();
        if (appToken == null) throw new IllegalStateException("Call after onResume() so window token exists.");
        WindowHostActivityView.ensureLoaded();
        this.first  = new WindowHostSinglePane("First");
        this.second = new WindowHostSinglePane("Second");
        this.third  = new WindowHostSinglePane("Third");
        this.fourth = new WindowHostSinglePane("Fourth");
        this.dual   = new WindowHostDualPane();

        // publish instance
        sInstance = this;
    }

    // ===== API: Dual =====
    public void showDual(String leftPkg, String rightPkg, Rect bounds) { dual.show(activity, wm, appToken, leftPkg, rightPkg, bounds); }
    public void updateDualBounds(Rect bounds) { if (dual != null) dual.updateBounds(bounds); }
    public void dismissDual()   { dual.dismissAsync(); }
    public void cleanupDual()   { dual.cleanup(); }
    public boolean isDualVisible() { return dual.isVisible(); }

    // ===== API: Singles =====
    public void showFirst(String pkg, Rect bounds)  { first.show(activity, wm, appToken, pkg, bounds); }
    public void showSecond(String pkg, Rect bounds) { second.show(activity, wm, appToken, pkg, bounds); }
    public void showThird(String pkg, Rect bounds)  { third.show(activity, wm, appToken, pkg, bounds); }
    public void showFourth(String pkg, Rect bounds) { fourth.show(activity, wm, appToken, pkg, bounds); }

    public void updateFirstBounds(Rect bounds) { if (first != null) first.updateBounds(bounds); }
    public void updateSecondBounds(Rect bounds) { if (second != null) second.updateBounds(bounds); }
    public void updateThirdBounds(Rect bounds) { if (third != null)  third.updateBounds(bounds); }
    public void updateFourthBounds(Rect bounds) { if (fourth != null) fourth.updateBounds(bounds); }

    public void dismissFirst()  { first.dismissAsync(); }
    public void dismissSecond() { second.dismissAsync(); }
    public void dismissThird()  { third.dismissAsync(); }
    public void dismissFourth() { fourth.dismissAsync(); }

    public void dismiss() {
        first.dismissAsync();
        second.dismissAsync();
        third.dismissAsync();
        fourth.dismissAsync();
        dual.dismissAsync();
    }

    public void cleanup() {
        first.cleanup();
        second.cleanup();
        third.cleanup();
        fourth.cleanup();
        dual.cleanup();

        // Clear published instance if it's this one
        if (sInstance == this) {
            sInstance = null;
        }
    }

    /**
     * Detaches every ActivityView from this (now obsolete) host and hands them to
     * WindowHostAvReaper, which releases each one only after its VirtualDisplay stops hosting a
     * task -- i.e. after the new WindowHost has taken the embedded app over.
     *
     * Call this INSTEAD of cleanup() when the host object is being replaced but the embedded
     * apps must keep running.
     */
    public void retireActivityViews() {
        java.util.List<Object> retired = new java.util.ArrayList<>();
        try { first.takeActivityViews(retired); }  catch (Throwable ignore) {}
        try { second.takeActivityViews(retired); } catch (Throwable ignore) {}
        try { third.takeActivityViews(retired); }  catch (Throwable ignore) {}
        try { fourth.takeActivityViews(retired); } catch (Throwable ignore) {}
        try { dual.takeActivityViews(retired); }   catch (Throwable ignore) {}
 
        if (sInstance == this) sInstance = null;
 
        WindowHostAvReaper.retireAll(retired);
    }

    public static WindowHost getInstance() {
        return sInstance;
    }

    public boolean isFirstVisible()  { return first.isVisible(); }
    public boolean isSecondVisible() { return second.isVisible(); }
    public boolean isThirdVisible()  { return third.isVisible(); }
    public boolean isFourthVisible() { return fourth.isVisible(); }

    /**
     * True if any visible panel is still waiting for valid dimensions and therefore has not yet
     * started its app. In this state, a subsequent openPip() is NOT a duplicate -- it is the call
     * that provides the dimensions needed to unblock the startup.
     */
    public boolean isAnyPaneAwaitingBounds() {
        try {
            return first.isAwaitingBounds()
                    || second.isAwaitingBounds()
                    || third.isAwaitingBounds()
                    || fourth.isAwaitingBounds()
                    || dual.isAwaitingBounds();
        } catch (Throwable t) {
            return true;  
        }
    }

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