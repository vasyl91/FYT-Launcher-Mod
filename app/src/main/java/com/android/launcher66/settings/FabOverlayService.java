package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.syu.util.WindowUtil;

public class FabOverlayService extends Service {
    
    private static final String TAG = "FabOverlayService";
    private WindowManager windowManager;
    private FloatingActionButton fabSwitchPips;
    private FloatingActionButton leftFabSwitchPips;
    private FloatingActionButton rightFabSwitchPips;
    private WindowManager.LayoutParams params;
    private WindowManager.LayoutParams leftFabParams;
    private WindowManager.LayoutParams rightFabParams;
    private boolean blockButton = false;
    private boolean floatingBtn = false;
    private boolean floatingBtnLeft = false;
    private boolean floatingBtnRight = false;
    
    // Preferences
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    
    // Click threshold
    private static final float CLICK_THRESHOLD = 10f;
    
    // Drag variables
    private float dX, dY, dXleft, dYleft, dXright, dYright;
    private float initialX, initialY, initialXleft, initialYleft, initialXright, initialYright;
    private long pressStartTime;
    private int lastAction;
    private int screenWidth;
    private int screenHeight;
    private int statusBarHeight;
    
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    
    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
        prefs = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());
        editor = prefs.edit();
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
        statusBarHeight = getStatusBarHeight();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        floatingBtn = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON, false);
        floatingBtnLeft = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_LEFT, false);
        floatingBtnRight = prefs.getBoolean(Keys.FAB_OVERLAY_BUTTON_RIGHT, false);
        if (floatingBtn) {
            setupOverlay();
        }        
        if (floatingBtnLeft) {
            setupOverlayLeft();
        }        
        if (floatingBtnRight) {
            setupOverlayRight();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Keys.SHOW_FAB);
        filter.addAction(Keys.HIDE_FAB);
        filter.addAction(Keys.BLOCK_FLOATING_BUTTON);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(fabReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(fabReceiver, filter);
        }
    }
    
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }
    
    private void setupOverlay() {
        params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 
            PixelFormat.TRANSLUCENT
        );
        
        params.gravity = Gravity.TOP | Gravity.START;
        params.x = 100;  
        params.y = 100;

        ContextThemeWrapper themedContext = new ContextThemeWrapper(this, R.style.AppTheme);
        fabSwitchPips = new FloatingActionButton(themedContext);

        // Remove default padding
        fabSwitchPips.setPadding(0, 0, 0, 0);

        // Set scale type if using ImageView methods
        fabSwitchPips.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // Set image with custom size
        fabSwitchPips.setImageResource(R.drawable.ic_switch_pips);

        int black = ContextCompat.getColor(this, R.color.black);
        int blackWithAlpha = ColorUtils.setAlphaComponent(black, (int) (255 * 0.5f));

        fabSwitchPips.setBackgroundTintList(ColorStateList.valueOf(blackWithAlpha));
        fabSwitchPips.setSize(FloatingActionButton.SIZE_MINI);

        // Set initial size
        int orientation = getResources().getConfiguration().orientation;
        int buttonSize = screenHeight;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            buttonSize = screenWidth;
        } 
        int sizeInPx = (int) (buttonSize * 0.08 * getResources().getDisplayMetrics().density);
        params.width = sizeInPx;
        params.height = sizeInPx;        
        
        // Add to window manager
        windowManager.addView(fabSwitchPips, params);

        fabSwitchPips.post(() -> {
            // Get current layout params
            ViewGroup.LayoutParams layoutParams = fabSwitchPips.getLayoutParams();
            if (layoutParams != null) {

                // Update the view's layout params
                layoutParams.width = sizeInPx;
                layoutParams.height = sizeInPx;
                fabSwitchPips.setLayoutParams(layoutParams);

                // Also update WindowManager params
                params.width = sizeInPx;
                params.height = sizeInPx;
                windowManager.updateViewLayout(fabSwitchPips, params);
            }

            // Adjust icon padding to fill space
            fabSwitchPips.setPadding(0, 0, 0, 0);
            fabSwitchPips.setElevation(0f);
            fabSwitchPips.setCompatElevation(0f);
            fabSwitchPips.setTranslationZ(0f);
            fabSwitchPips.setUseCompatPadding(false);
            fabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);

            // Force redraw
            fabSwitchPips.invalidate();
            fabSwitchPips.requestLayout();
        });
        
        // Setup draggable behavior
        setupDraggableFab();
        
        // Restore saved position
        restoreFabPosition();
        
        // Setup click listener
        fabSwitchPips.setOnClickListener(v -> onSwitchPipsClicked());
    }

    private void setupDraggableFab() {
        fabSwitchPips.setOnTouchListener((view, event) -> {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dX = event.getRawX() - params.x;
                    dY = event.getRawY() - params.y;
                    initialX = event.getRawX();
                    initialY = event.getRawY();
                    pressStartTime = System.currentTimeMillis();
                    lastAction = MotionEvent.ACTION_DOWN;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    // Update position based on drag
                    params.x = (int) (event.getRawX() - dX);
                    params.y = (int) (event.getRawY() - dY);
                    
                    // Constrain within screen bounds (with status bar padding)
                    int fabWidth = view.getWidth();
                    int fabHeight = view.getHeight();
                    
                    // Don't allow going behind status bar
                    int minY = statusBarHeight; // Minimum Y position (below status bar)
                    int maxY = screenHeight + statusBarHeight - fabHeight; // Maximum Y position (above bottom)
                    
                    params.x = Math.max(0, Math.min(params.x, screenWidth - fabWidth));
                    params.y = Math.max(minY, Math.min(params.y, maxY));

                    // Update view position
                    windowManager.updateViewLayout(fabSwitchPips, params);
                    lastAction = MotionEvent.ACTION_MOVE;
                    return true;

                case MotionEvent.ACTION_UP:
                    // Check if it was a click or drag
                    float deltaX = Math.abs(event.getRawX() - initialX);
                    float deltaY = Math.abs(event.getRawY() - initialY);
                    long pressDuration = System.currentTimeMillis() - pressStartTime;

                    if (deltaX < CLICK_THRESHOLD &&
                        deltaY < CLICK_THRESHOLD &&
                        pressDuration < 200 &&
                        lastAction != MotionEvent.ACTION_MOVE) {
                        // It's a click - perform click action
                        view.performClick();
                    } else {
                        // It was a drag - save position
                        saveFabPosition();
                    }

                    lastAction = MotionEvent.ACTION_UP;
                    return true;

                default:
                    return false;
            }
        });
    }

    /**
     * Restore FAB position from preferences
     */
    private void restoreFabPosition() {
        boolean positionSaved = prefs.getBoolean(Keys.KEY_POSITION_SAVED, false);
        
        if (positionSaved) {
            // Use post to ensure view is laid out
            fabSwitchPips.post(() -> {
                float savedX = prefs.getFloat(Keys.KEY_FAB_X, -1);
                float savedY = prefs.getFloat(Keys.KEY_FAB_Y, -1);

                if (savedX != -1 && savedY != -1) {
                    int fabWidth = fabSwitchPips.getWidth();
                    int fabHeight = fabSwitchPips.getHeight();

                    // Constrain within screen bounds
                    savedX = Math.max(0, Math.min(savedX, screenWidth - fabWidth));
                    savedY = Math.max(0, Math.min(savedY, screenHeight - fabHeight));

                    params.x = (int) savedX;
                    params.y = (int) savedY;
                    windowManager.updateViewLayout(fabSwitchPips, params);
                }
            });
        } else {
            // Set default position if not saved
            fabSwitchPips.post(() -> {
                int fabWidth = fabSwitchPips.getWidth();
                params.x = screenWidth - fabWidth - 50; // 50px from right edge
                params.y = 100; // 100px from top
                windowManager.updateViewLayout(fabSwitchPips, params);
            });
        }
    }
    
    /**
     * Save FAB position to preferences
     */
    private void saveFabPosition() {
        fabSwitchPips.setElevation(0f);
        fabSwitchPips.setCompatElevation(0f);
        fabSwitchPips.setTranslationZ(0f);
        fabSwitchPips.setUseCompatPadding(false);
        fabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        editor.putFloat(Keys.KEY_FAB_X, params.x);
        editor.putFloat(Keys.KEY_FAB_Y, params.y);
        editor.putBoolean(Keys.KEY_POSITION_SAVED, true);
        editor.apply();
    }
    
    /**
     * Handle FAB click
     */
    private void onSwitchPipsClicked() {
        if (!blockButton) {
            blockButton = true;
            WindowUtil.removePip(null);
            String firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
            String secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
            String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
            String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
            editor.putString(Keys.PIP_FIRST_PACKAGE, thirdPkg);
            editor.putString(Keys.PIP_SECOND_PACKAGE, fourthPkg);
            editor.putString(Keys.PIP_THIRD_PACKAGE, firstPkg);
            editor.putString(Keys.PIP_FOURTH_PACKAGE, secondPkg);
            editor.apply();
            WindowUtil.startMapPip(null, false);
        }
    }

    // LEFT
    private void setupOverlayLeft() {    
        leftFabParams = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 
            PixelFormat.TRANSLUCENT
        );
        
        leftFabParams.gravity = Gravity.TOP | Gravity.START;
        leftFabParams.x = 100;  
        leftFabParams.y = 100;

        ContextThemeWrapper themedContext = new ContextThemeWrapper(this, R.style.AppTheme);
        leftFabSwitchPips = new FloatingActionButton(themedContext);

        // Remove default padding
        leftFabSwitchPips.setPadding(0, 0, 0, 0);

        // Set scale type if using ImageView methods
        leftFabSwitchPips.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // Set image with custom size
        leftFabSwitchPips.setImageResource(R.drawable.ic_switch_pips_left);

        int black = ContextCompat.getColor(this, R.color.black);
        int blackWithAlpha = ColorUtils.setAlphaComponent(black, (int) (255 * 0.5f));

        leftFabSwitchPips.setBackgroundTintList(ColorStateList.valueOf(blackWithAlpha));
        leftFabSwitchPips.setSize(FloatingActionButton.SIZE_MINI);

        // Set initial size
        int orientation = getResources().getConfiguration().orientation;
        int buttonSize = screenHeight;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            buttonSize = screenWidth;
        } 
        int sizeInPx = (int) (buttonSize * 0.08 * getResources().getDisplayMetrics().density);
        leftFabParams.width = sizeInPx;
        leftFabParams.height = sizeInPx;        
        
        // Add to window manager
        windowManager.addView(leftFabSwitchPips, leftFabParams);

        leftFabSwitchPips.post(() -> {
            // Get current layout leftFabParams
            ViewGroup.LayoutParams layoutParams = leftFabSwitchPips.getLayoutParams();
            if (layoutParams != null) {

                // Update the view's layout leftFabParams
                layoutParams.width = sizeInPx;
                layoutParams.height = sizeInPx;
                leftFabSwitchPips.setLayoutParams(layoutParams);

                // Also update WindowManager leftFabParams
                leftFabParams.width = sizeInPx;
                leftFabParams.height = sizeInPx;
                windowManager.updateViewLayout(leftFabSwitchPips, leftFabParams);
            }

            // Adjust icon padding to fill space
            leftFabSwitchPips.setPadding(0, 0, 0, 0);
            leftFabSwitchPips.setElevation(0f);
            leftFabSwitchPips.setCompatElevation(0f);
            leftFabSwitchPips.setTranslationZ(0f);
            leftFabSwitchPips.setUseCompatPadding(false);
            leftFabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);

            // Force redraw
            leftFabSwitchPips.invalidate();
            leftFabSwitchPips.requestLayout();
        });
        
        // Setup draggable behavior
        setupDraggableFabLeft();
        
        // Restore saved position
        restoreFabPositionLeft();
        
        // Setup click listener
        leftFabSwitchPips.setOnClickListener(v -> onLeftSwitchPipsClicked());
    }

    private void setupDraggableFabLeft() {
        leftFabSwitchPips.setOnTouchListener((view, event) -> {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dXleft = event.getRawX() - leftFabParams.x;
                    dYleft = event.getRawY() - leftFabParams.y;
                    initialXleft = event.getRawX();
                    initialYleft = event.getRawY();
                    pressStartTime = System.currentTimeMillis();
                    lastAction = MotionEvent.ACTION_DOWN;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    // Update position based on drag
                    leftFabParams.x = (int) (event.getRawX() - dXleft);
                    leftFabParams.y = (int) (event.getRawY() - dYleft);
                    
                    // Constrain within screen bounds (with status bar padding)
                    int fabWidth = view.getWidth();
                    int fabHeight = view.getHeight();
                    
                    // Don't allow going behind status bar
                    int minY = statusBarHeight; // Minimum Y position (below status bar)
                    int maxY = screenHeight + statusBarHeight - fabHeight; // Maximum Y position (above bottom)
                    
                    leftFabParams.x = Math.max(0, Math.min(leftFabParams.x, screenWidth - fabWidth));
                    leftFabParams.y = Math.max(minY, Math.min(leftFabParams.y, maxY));

                    // Update view position
                    windowManager.updateViewLayout(leftFabSwitchPips, leftFabParams);
                    lastAction = MotionEvent.ACTION_MOVE;
                    return true;

                case MotionEvent.ACTION_UP:
                    // Check if it was a click or drag
                    float deltaX = Math.abs(event.getRawX() - initialXleft);
                    float deltaY = Math.abs(event.getRawY() - initialYleft);
                    long pressDuration = System.currentTimeMillis() - pressStartTime;

                    if (deltaX < CLICK_THRESHOLD &&
                        deltaY < CLICK_THRESHOLD &&
                        pressDuration < 200 &&
                        lastAction != MotionEvent.ACTION_MOVE) {
                        // It's a click - perform click action
                        view.performClick();
                    } else {
                        // It was a drag - save position
                        saveLeftFabPosition();
                    }

                    lastAction = MotionEvent.ACTION_UP;
                    return true;

                default:
                    return false;
            }
        });
    }

    /**
     * Restore left FAB position from preferences
     */
    private void restoreFabPositionLeft() {
        boolean positionSaved = prefs.getBoolean(Keys.KEY_POSITION_SAVED_LEFT, false);
        
        if (positionSaved) {
            // Use post to ensure view is laid out
            leftFabSwitchPips.post(() -> {
                float savedX = prefs.getFloat(Keys.KEY_FAB_X_LEFT, -1);
                float savedY = prefs.getFloat(Keys.KEY_FAB_Y_LEFT, -1);

                if (savedX != -1 && savedY != -1) {
                    int fabWidth = leftFabSwitchPips.getWidth();
                    int fabHeight = leftFabSwitchPips.getHeight();

                    // Constrain within screen bounds
                    savedX = Math.max(0, Math.min(savedX, screenWidth - fabWidth));
                    savedY = Math.max(0, Math.min(savedY, screenHeight - fabHeight));

                    leftFabParams.x = (int) savedX;
                    leftFabParams.y = (int) savedY;
                    windowManager.updateViewLayout(leftFabSwitchPips, leftFabParams);
                }
            });
        } else {
            // Set default position if not saved
            leftFabSwitchPips.post(() -> {
                int fabWidth = leftFabSwitchPips.getWidth();
                leftFabParams.x = screenWidth - fabWidth - 50; // 50px from right edge
                leftFabParams.y = 100; // 100px from top
                windowManager.updateViewLayout(leftFabSwitchPips, leftFabParams);
            });
        }
    }
    
    /**
     * Save left FAB position to preferences
     */
    private void saveLeftFabPosition() {
        leftFabSwitchPips.setElevation(0f);
        leftFabSwitchPips.setCompatElevation(0f);
        leftFabSwitchPips.setTranslationZ(0f);
        leftFabSwitchPips.setUseCompatPadding(false);
        leftFabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        editor.putFloat(Keys.KEY_FAB_X_LEFT, leftFabParams.x);
        editor.putFloat(Keys.KEY_FAB_Y_LEFT, leftFabParams.y);
        editor.putBoolean(Keys.KEY_POSITION_SAVED_LEFT, true);
        editor.apply();
    }
    
    /**
     * Handle left FAB click
     */
    private void onLeftSwitchPipsClicked() {
        if (!blockButton) {
            blockButton = true;
            WindowUtil.removePip(null);
            String firstPkg = prefs.getString(Keys.PIP_FIRST_PACKAGE, "");
            String thirdPkg = prefs.getString(Keys.PIP_THIRD_PACKAGE, "");
            editor.putString(Keys.PIP_FIRST_PACKAGE, thirdPkg);
            editor.putString(Keys.PIP_THIRD_PACKAGE, firstPkg);
            editor.apply();
            WindowUtil.startMapPip(null, false);
        }
    }

    // RIGHT

    private void setupOverlayRight() {    
        rightFabParams = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, 
            PixelFormat.TRANSLUCENT
        );
        
        rightFabParams.gravity = Gravity.TOP | Gravity.START;
        rightFabParams.x = 100;  
        rightFabParams.y = 100;

        ContextThemeWrapper themedContext = new ContextThemeWrapper(this, R.style.AppTheme);
        rightFabSwitchPips = new FloatingActionButton(themedContext);

        // Remove default padding
        rightFabSwitchPips.setPadding(0, 0, 0, 0);

        // Set scale type if using ImageView methods
        rightFabSwitchPips.setScaleType(ImageView.ScaleType.FIT_CENTER);

        // Set image with custom size
        rightFabSwitchPips.setImageResource(R.drawable.ic_switch_pips_right);

        int black = ContextCompat.getColor(this, R.color.black);
        int blackWithAlpha = ColorUtils.setAlphaComponent(black, (int) (255 * 0.5f));

        rightFabSwitchPips.setBackgroundTintList(ColorStateList.valueOf(blackWithAlpha));
        rightFabSwitchPips.setSize(FloatingActionButton.SIZE_MINI);

        // Set initial size
        int orientation = getResources().getConfiguration().orientation;
        int buttonSize = screenHeight;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            buttonSize = screenWidth;
        } 
        int sizeInPx = (int) (buttonSize * 0.08 * getResources().getDisplayMetrics().density);
        rightFabParams.width = sizeInPx;
        rightFabParams.height = sizeInPx;        
        
        // Add to window manager
        windowManager.addView(rightFabSwitchPips, rightFabParams);

        rightFabSwitchPips.post(() -> {
            // Get current layout rightFabParams
            ViewGroup.LayoutParams layoutParams = rightFabSwitchPips.getLayoutParams();
            if (layoutParams != null) {

                // Update the view's layout rightFabParams
                layoutParams.width = sizeInPx;
                layoutParams.height = sizeInPx;
                rightFabSwitchPips.setLayoutParams(layoutParams);

                // Also update WindowManager rightFabParams
                rightFabParams.width = sizeInPx;
                rightFabParams.height = sizeInPx;
                windowManager.updateViewLayout(rightFabSwitchPips, rightFabParams);
            }

            // Adjust icon padding to fill space
            rightFabSwitchPips.setPadding(0, 0, 0, 0);
            rightFabSwitchPips.setElevation(0f);
            rightFabSwitchPips.setCompatElevation(0f);
            rightFabSwitchPips.setTranslationZ(0f);
            rightFabSwitchPips.setUseCompatPadding(false);
            rightFabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);

            // Force redraw
            rightFabSwitchPips.invalidate();
            rightFabSwitchPips.requestLayout();
        });
        
        // Setup draggable behavior
        setupDraggableFabRight();
        
        // Restore saved position
        restoreFabPositionRight();
        
        // Setup click listener
        rightFabSwitchPips.setOnClickListener(v -> onRightSwitchPipsClicked());
    }

    private void setupDraggableFabRight() {
        rightFabSwitchPips.setOnTouchListener((view, event) -> {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    dXright = event.getRawX() - rightFabParams.x;
                    dYright = event.getRawY() - rightFabParams.y;
                    initialXright = event.getRawX();
                    initialYright = event.getRawY();
                    pressStartTime = System.currentTimeMillis();
                    lastAction = MotionEvent.ACTION_DOWN;
                    return true;

                case MotionEvent.ACTION_MOVE:
                    // Update position based on drag
                    rightFabParams.x = (int) (event.getRawX() - dXright);
                    rightFabParams.y = (int) (event.getRawY() - dYright);
                    
                    // Constrain within screen bounds (with status bar padding)
                    int fabWidth = view.getWidth();
                    int fabHeight = view.getHeight();
                    
                    // Don't allow going behind status bar
                    int minY = statusBarHeight; // Minimum Y position (below status bar)
                    int maxY = screenHeight + statusBarHeight - fabHeight; // Maximum Y position (above bottom)
                    
                    rightFabParams.x = Math.max(0, Math.min(rightFabParams.x, screenWidth - fabWidth));
                    rightFabParams.y = Math.max(minY, Math.min(rightFabParams.y, maxY));

                    // Update view position
                    windowManager.updateViewLayout(rightFabSwitchPips, rightFabParams);
                    lastAction = MotionEvent.ACTION_MOVE;
                    return true;

                case MotionEvent.ACTION_UP:
                    // Check if it was a click or drag
                    float deltaX = Math.abs(event.getRawX() - initialXright);
                    float deltaY = Math.abs(event.getRawY() - initialYright);
                    long pressDuration = System.currentTimeMillis() - pressStartTime;

                    if (deltaX < CLICK_THRESHOLD &&
                        deltaY < CLICK_THRESHOLD &&
                        pressDuration < 200 &&
                        lastAction != MotionEvent.ACTION_MOVE) {
                        // It's a click - perform click action
                        view.performClick();
                    } else {
                        // It was a drag - save position
                        saveRightFabPosition();
                    }

                    lastAction = MotionEvent.ACTION_UP;
                    return true;

                default:
                    return false;
            }
        });
    }

    /**
     * Restore right FAB position from preferences
     */
    private void restoreFabPositionRight() {
        boolean positionSaved = prefs.getBoolean(Keys.KEY_POSITION_SAVED_RIGHT, false);
        
        if (positionSaved) {
            // Use post to ensure view is laid out
            rightFabSwitchPips.post(() -> {
                float savedX = prefs.getFloat(Keys.KEY_FAB_X_RIGHT, -1);
                float savedY = prefs.getFloat(Keys.KEY_FAB_Y_RIGHT, -1);

                if (savedX != -1 && savedY != -1) {
                    int fabWidth = rightFabSwitchPips.getWidth();
                    int fabHeight = rightFabSwitchPips.getHeight();

                    // Constrain within screen bounds
                    savedX = Math.max(0, Math.min(savedX, screenWidth - fabWidth));
                    savedY = Math.max(0, Math.min(savedY, screenHeight - fabHeight));

                    rightFabParams.x = (int) savedX;
                    rightFabParams.y = (int) savedY;
                    windowManager.updateViewLayout(rightFabSwitchPips, rightFabParams);
                }
            });
        } else {
            // Set default position if not saved
            rightFabSwitchPips.post(() -> {
                int fabWidth = rightFabSwitchPips.getWidth();
                rightFabParams.x = screenWidth - fabWidth - 50; // 50px from right edge
                rightFabParams.y = 100; // 100px from top
                windowManager.updateViewLayout(rightFabSwitchPips, rightFabParams);
            });
        }
    }
    
    /**
     * Save right FAB position to preferences
     */
    private void saveRightFabPosition() {
        rightFabSwitchPips.setElevation(0f);
        rightFabSwitchPips.setCompatElevation(0f);
        rightFabSwitchPips.setTranslationZ(0f);
        rightFabSwitchPips.setUseCompatPadding(false);
        rightFabSwitchPips.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        editor.putFloat(Keys.KEY_FAB_X_RIGHT, rightFabParams.x);
        editor.putFloat(Keys.KEY_FAB_Y_RIGHT, rightFabParams.y);
        editor.putBoolean(Keys.KEY_POSITION_SAVED_RIGHT, true);
        editor.apply();
    }
    
    /**
     * Handle right FAB click
     */
    private void onRightSwitchPipsClicked() {
        if (!blockButton) {
            blockButton = true;
            WindowUtil.removePip(null);
            String secondPkg = prefs.getString(Keys.PIP_SECOND_PACKAGE, "");
            String fourthPkg = prefs.getString(Keys.PIP_FOURTH_PACKAGE, "");
            editor.putString(Keys.PIP_SECOND_PACKAGE, fourthPkg);
            editor.putString(Keys.PIP_FOURTH_PACKAGE, secondPkg);
            editor.apply();
            WindowUtil.startMapPip(null, false);
        }
    }

    public int getStatusBarHeight() { 
          int result = 0;
          int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (resourceId > 0) {
              result = getResources().getDimensionPixelSize(resourceId);
          } 
          return result;
    }

    private final BroadcastReceiver fabReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if(intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case Keys.SHOW_FAB:
                            showFab();
                            break;
                        case Keys.HIDE_FAB:
                            hideFab();
                            break;
                        case Keys.BLOCK_FLOATING_BUTTON:
                            // This is called inside startMapPip() to let the view settle before switching PiPs will be possible
                            blockButton = true;
                            new Handler(Looper.getMainLooper()).postDelayed(() -> blockButton = false, 5000);
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Error receiving broadcast: " + e.getMessage());
            }
        }
    };    
    
    /**
     * Show the FAB
     */
    public void showFab() {
        if (floatingBtn && fabSwitchPips != null && fabSwitchPips.getVisibility() == View.GONE) {
            fabSwitchPips.setVisibility(View.VISIBLE);
        }
        if (floatingBtnLeft && leftFabSwitchPips != null && leftFabSwitchPips.getVisibility() == View.GONE) {
            leftFabSwitchPips.setVisibility(View.VISIBLE);
        }
        if (floatingBtnRight && rightFabSwitchPips != null && rightFabSwitchPips.getVisibility() == View.GONE) {
            rightFabSwitchPips.setVisibility(View.VISIBLE);
        }
    }
    
    /**
     * Hide the FAB
     */
    public void hideFab() {
        if (fabSwitchPips != null && fabSwitchPips.getVisibility() == View.VISIBLE) {
            fabSwitchPips.setVisibility(View.GONE);
        }
        if (leftFabSwitchPips != null && leftFabSwitchPips.getVisibility() == View.VISIBLE) {
            leftFabSwitchPips.setVisibility(View.GONE);
        }
        if (rightFabSwitchPips != null && rightFabSwitchPips.getVisibility() == View.VISIBLE) {
            rightFabSwitchPips.setVisibility(View.GONE);
        }
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(fabReceiver);
        // Remove the overlay view when service is destroyed
        if (fabSwitchPips != null) {
            windowManager.removeView(fabSwitchPips);
        }
        if (leftFabSwitchPips != null) {
            windowManager.removeView(leftFabSwitchPips);
        }
        if (rightFabSwitchPips != null) {
            windowManager.removeView(rightFabSwitchPips);
        }
    }
}