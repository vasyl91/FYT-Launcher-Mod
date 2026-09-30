package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.android.launcher66.Launcher;
import com.android.launcher66.Workspace;

public class StatusBarSwipeDetector extends Service {

    private static final String TAG = "StatusBarSwipeDetector";

    private WindowManager windowManager;
    private int touchSlop;

    /*
     * The strip's window lives on its own thread. Adding a window on this ROM makes the Unisoc
     * ViewRootImpl constructor ask system_server whether there is a navigation bar, and at boot
     * system_server stalls for seconds: on the main thread that froze the whole launcher for over
     * seven seconds (capture of 28-09-2026 20:41: IWindowManager.hasNavigationBar <-
     * SprdViewRootImpl.<init> <- WindowManager.addView <- StatusBarSwipeDetector.onCreate).
     * The window thread only owns the window and delivers its touches; each event is handed to the
     * main thread as a copy, and the gesture is handled there exactly as before.
     */
    private HandlerThread windowThread;
    private Handler windowHandler;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private View overlayView;      // window thread only
    private boolean destroyed;     // main thread only

    // State of the current gesture, from its ACTION_DOWN. Main thread only.
    private Workspace gestureWorkspace;       // the workspace this gesture pages, null if none
    private boolean barHiddenThisGesture;
    private float downRawX;
    private float downRawY;
    private float lastX; // last position in this window, for a closing ACTION_CANCEL
    private float lastY;

    @Override
    public void onCreate() {
        super.onCreate();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        touchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

        final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_ERROR, // For system apps only
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                PixelFormat.TRANSLUCENT
        );

        // Calculate overlay dimensions and position
        int displayWidth = getResources().getDisplayMetrics().widthPixels;
        int statusBarHeight = getStatusBarHeight();


        params.width = displayWidth / 2; // 1/2 of display width
        params.height = (statusBarHeight * 2) / 3; // 2/3 of status bar height
        params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL; // Horizontally centered, vertically top-aligned
        params.y = statusBarHeight - params.height; // Positioned at the bottom of the status bar

        windowThread = new HandlerThread("StatusBarSwipeWindow");
        windowThread.start();
        windowHandler = new Handler(windowThread.getLooper());
        windowHandler.post(() -> addOverlay(params));
    }

    /** Window thread: creates the strip and adds its window. */
    private void addOverlay(WindowManager.LayoutParams params) {
        View view = new FrameLayout(this);
        view.setOnTouchListener((v, event) -> {
            // A copy, since the original is recycled as soon as this returns.
            final MotionEvent copy = MotionEvent.obtain(event);
            mainHandler.post(() -> {
                try {
                    onStripTouch(copy);
                } finally {
                    copy.recycle();
                }
            });
            return true;
        });
        try {
            windowManager.addView(view, params);
            overlayView = view;
        } catch (RuntimeException e) {
            Log.w(TAG, "Cannot add the status bar swipe strip", e);
        }
    }

    /**
     * Main thread. The strip pages the workspace exactly like a swipe on the workspace itself:
     * every event goes through the workspace's own paging (Workspace.handleExternalSwipe()), so
     * the pages follow the finger and snap with the fling velocity on release.
     */
    private void onStripTouch(MotionEvent event) {
        if (destroyed) {
            return; // stragglers delivered after onDestroy(); the gesture was already cancelled
        }
        final int action = event.getActionMasked();
        lastX = event.getX();
        lastY = event.getY();
        if (action == MotionEvent.ACTION_DOWN) {
            barHiddenThisGesture = false;
            downRawX = event.getRawX();
            downRawY = event.getRawY();
            gestureWorkspace = currentWorkspace();
        } else if (action == MotionEvent.ACTION_MOVE && !barHiddenThisGesture
                && (Math.abs(event.getRawX() - downRawX) > touchSlop
                    || Math.abs(event.getRawY() - downRawY) > touchSlop)) {
            // The finger has started to move: the auto-hide bar goes away right now.
            hideAutoHideBarOnce();
        }

        Workspace workspace = gestureWorkspace;
        if (workspace != null && !workspace.handleExternalSwipe(event)) {
            gestureWorkspace = null; // cannot page now (e.g. all apps open): ignore the rest
        }
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            gestureWorkspace = null;
        }
    }

    /**
     * The Workspace of the current launcher. Looked up for every gesture rather than kept from
     * onCreate(): this service outlives the activity, and a kept reference would point to the
     * destroyed Workspace (and keep it in memory) once the launcher has been recreated.
     */
    private static Workspace currentWorkspace() {
        Launcher launcher = Launcher.getLauncher();
        return launcher != null ? launcher.getWorkspace() : null;
    }

    /**
     * Swiping over this strip hides the auto-hide bottom bar. The bar does not notice the swipe by
     * itself: this window lies above it, and only windows above the touched one get ACTION_OUTSIDE.
     */
    private void hideAutoHideBarOnce() {
        if (barHiddenThisGesture) {
            return;
        }
        barHiddenThisGesture = true;
        Workspace workspace = currentWorkspace();
        if (workspace != null) {
            workspace.hideAutoHideBarIfShown("status bar swipe");
        }
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyed = true;
        // Stopped in the middle of a swipe (the launcher lost the front): the window goes away
        // without an ACTION_UP, so let the pages settle instead of stopping between two of them.
        Workspace workspace = gestureWorkspace;
        gestureWorkspace = null;
        if (workspace != null) {
            long now = SystemClock.uptimeMillis();
            MotionEvent cancel = MotionEvent.obtain(now, now, MotionEvent.ACTION_CANCEL, lastX, lastY, 0);
            workspace.handleExternalSwipe(cancel);
            cancel.recycle();
        }
        // The window belongs to its thread, so it is removed there -- after the add, which may still
        // be waiting for system_server. The thread ends itself once the window is gone.
        if (windowHandler != null) {
            windowHandler.post(this::removeOverlay);
        }
    }

    /** Window thread. */
    private void removeOverlay() {
        View view = overlayView;
        overlayView = null;
        if (view != null) {
            try {
                // Immediate: a plain removeView() finishes on a later message of this thread,
                // and the thread quits right below.
                windowManager.removeViewImmediate(view);
            } catch (RuntimeException e) {
                Log.w(TAG, "Cannot remove the status bar swipe strip", e);
            }
        }
        windowThread.quitSafely();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
