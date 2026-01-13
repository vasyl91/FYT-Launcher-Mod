package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.android.launcher66.Launcher;
import com.android.launcher66.Workspace;

public class StatusBarSwipeDetector extends Service {

    private WindowManager windowManager;
    private View overlayView;
    private GestureDetector gestureDetector;
    private Workspace mWorkspace;

    @Override
    public void onCreate() {
        super.onCreate();

        mWorkspace = Launcher.getWorkspace();

        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

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

        // Set up gesture detection
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            private static final int SWIPE_THRESHOLD = 100;
            private static final int SWIPE_VELOCITY_THRESHOLD = 100;

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                float diffX = e2.getX() - e1.getX();

                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    return true;
                }
                return false;
            }
        });

        // Add touch listener to detect gestures
        overlayView.setOnTouchListener((v, event) -> gestureDetector.onTouchEvent(event));

        // Add the overlay view to the window
        windowManager.addView(overlayView, params);
    }

    private void onSwipeLeft() {
        if (mWorkspace != null) {
            mWorkspace.scrollRight();
        }
    }

    private void onSwipeRight() {
        if (mWorkspace != null) {
            mWorkspace.scrollLeft();
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
        if (overlayView != null) {
            windowManager.removeView(overlayView);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}