package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.android.launcher66.Launcher;
import com.android.launcher66.Workspace;

public class StatusBarSwipeDetector extends Service {

    private WindowManager windowManager;
    private View overlayView;
    private int touchSlop;

    // State of the current gesture, from its ACTION_DOWN.
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

        overlayView = new FrameLayout(this);

        // The strip pages the workspace exactly like a swipe on the workspace itself: every event
        // goes through the workspace's own paging (Workspace.handleExternalSwipe()), so the pages
        // follow the finger and snap with the fling velocity on release.
        overlayView.setOnTouchListener((v, event) -> {
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
            return true;
        });

        // Add the overlay view to the window
        windowManager.addView(overlayView, params);
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
        if (overlayView != null) {
            windowManager.removeView(overlayView);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
