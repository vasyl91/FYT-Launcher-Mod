package com.syu.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Strategy for instant rendering with zero black screen delay
 * Uses multi-layered approach: placeholder → surface → content
 */
public class WindowHostInstantRenderStrategy {
    private static final String TAG = "InstantRender";
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    
    /**
     * Apply instant render strategy to an ActivityView container
     */
    public static void applyToContainer(ViewGroup container, String identifier) {
        if (container == null) return;
        
        try {
            // Step 1: Add instant placeholder
            ImageView placeholder = createInstantPlaceholder(container, identifier);
            container.addView(placeholder, 0); // Add at bottom
            
            // Step 2: Find and prepare the ActivityView
            View activityView = findActivityView(container);
            if (activityView != null) {
                // Apply all instant render techniques
                prepareForInstantRender(activityView);
                
                // Step 3: Monitor for first frame and remove placeholder
                monitorAndRemovePlaceholder(activityView, placeholder, identifier);
            }
            
            Log.i(TAG, "Applied instant render strategy to: " + identifier);
            
        } catch (Throwable t) {
            Log.e(TAG, "Failed to apply instant render strategy", t);
        }
    }
    
    /**
     * Create a placeholder that appears instantly
     */
    private static ImageView createInstantPlaceholder(ViewGroup container, String identifier) {
        ImageView placeholder = new ImageView(container.getContext());
        placeholder.setTag("instant_placeholder_" + identifier);
        placeholder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        
        // Use a very subtle gray instead of black
        placeholder.setBackgroundColor(Color.argb(255, 48, 48, 48));
        
        // Create a subtle loading indicator
        Bitmap loadingBitmap = createSubtleLoadingBitmap(300, 200);
        placeholder.setImageBitmap(loadingBitmap);
        placeholder.setAlpha(0.95f);
        
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        );
        placeholder.setLayoutParams(lp);
        
        return placeholder;
    }
    
    /**
     * Create subtle loading bitmap
     */
    private static Bitmap createSubtleLoadingBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        
        // Subtle gradient background
        canvas.drawColor(Color.argb(255, 48, 48, 48));
        
        // Small loading indicator
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.argb(120, 180, 180, 180));
        paint.setStrokeWidth(3);
        paint.setStyle(Paint.Style.STROKE);
        
        // Draw a small spinner circle
        float cx = width / 2f;
        float cy = height / 2f;
        float radius = 20;
        canvas.drawCircle(cx, cy, radius, paint);
        
        // Draw partial arc for animation effect
        paint.setStrokeWidth(4);
        canvas.drawArc(cx - radius, cy - radius, cx + radius, cy + radius, 
                      -90, 270, false, paint);
        
        return bitmap;
    }
    
    /**
     * Prepare ActivityView for instant rendering
     */
    private static void prepareForInstantRender(View activityView) {
        // Find the SurfaceView
        SurfaceView sv = findSurfaceView(activityView);
        if (sv == null) return;
        
        // Technique 1: Force visibility immediately
        sv.setVisibility(View.VISIBLE);
        sv.setWillNotDraw(false);
        
        // Technique 2: Optimal Z-ordering
        try {
            sv.setZOrderOnTop(false);
            sv.setZOrderMediaOverlay(false);
        } catch (Throwable ignore) {}
        
        // Technique 3: Force optimal pixel format
        SurfaceHolder holder = sv.getHolder();
        holder.setFormat(PixelFormat.RGBA_8888);
        
        // Technique 4: Pre-lock the canvas to initialize surface
        mainHandler.post(() -> preLockCanvas(holder));
        mainHandler.postDelayed(() -> preLockCanvas(holder), 16);
        mainHandler.postDelayed(() -> preLockCanvas(holder), 32);
        mainHandler.postDelayed(() -> preLockCanvas(holder), 48);
        
        // Technique 5: Add aggressive callback
        holder.addCallback(new SurfaceHolder.Callback2() {
            private boolean firstDrawn = false;
            
            @Override
            public void surfaceCreated(SurfaceHolder h) {
                if (!firstDrawn) {
                    firstDrawn = true;
                    // Immediate draw on surface creation
                    preLockCanvas(h);
                }
            }
            
            @Override
            public void surfaceChanged(SurfaceHolder h, int format, int width, int height) {
                if (width > 0 && height > 0) {
                    preLockCanvas(h);
                }
            }
            
            @Override
            public void surfaceDestroyed(SurfaceHolder h) {
                firstDrawn = false;
            }
            
            @Override
            public void surfaceRedrawNeeded(SurfaceHolder h) {
                preLockCanvas(h);
            }
        });
        
        // Technique 6: Force multiple layout passes
        for (int i = 0; i < 8; i++) {
            final int delay = i * 8;
            mainHandler.postDelayed(() -> {
                sv.requestLayout();
                sv.forceLayout();
                sv.invalidate();
            }, delay);
        }
        
        Log.d(TAG, "Prepared ActivityView for instant render");
    }
    
    /**
     * Pre-lock canvas to force surface initialization
     */
    private static void preLockCanvas(SurfaceHolder holder) {
        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                // Draw fully transparent - this wakes up the surface
                canvas.drawColor(Color.TRANSPARENT);
            }
        } catch (Throwable ignore) {
            // Surface not ready, silently ignore
        } finally {
            if (canvas != null) {
                try {
                    holder.unlockCanvasAndPost(canvas);
                } catch (Throwable ignore) {}
            }
        }
    }
    
    /**
     * Monitor for first frame and remove placeholder when ready
     */
    private static void monitorAndRemovePlaceholder(View activityView, ImageView placeholder, 
                                                     String identifier) {
        AtomicBoolean removed = new AtomicBoolean(false);
        
        SurfaceView sv = findSurfaceView(activityView);
        if (sv == null) {
            // No SurfaceView found, remove placeholder after timeout
            mainHandler.postDelayed(() -> removePlaceholder(placeholder, removed, identifier), 500);
            return;
        }
        
        // Strategy 1: Monitor via SurfaceHolder callback
        sv.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {}
            
            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (width > 0 && height > 0) {
                    // Surface has content, remove placeholder after brief delay
                    mainHandler.postDelayed(() -> 
                        removePlaceholder(placeholder, removed, identifier), 100);
                }
            }
            
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {}
        });
        
        // Strategy 2: Monitor via draw listener
        activityView.getViewTreeObserver().addOnDrawListener(() -> {
            // After first draw, wait a tiny bit then remove
            if (!removed.get()) {
                mainHandler.postDelayed(() -> 
                    removePlaceholder(placeholder, removed, identifier), 150);
            }
        });
        
        // Strategy 3: Timeout fallback (remove after max 600ms)
        mainHandler.postDelayed(() -> 
            removePlaceholder(placeholder, removed, identifier), 600);
    }
    
    /**
     * Remove placeholder with smooth fade
     */
    private static void removePlaceholder(ImageView placeholder, AtomicBoolean removed, 
                                          String identifier) {
        if (removed.getAndSet(true)) return; // Already removed
        
        if (placeholder == null || placeholder.getParent() == null) return;
        
        try {
            // Smooth fade out
            placeholder.animate()
                .alpha(0f)
                .setDuration(150)
                .withEndAction(() -> {
                    try {
                        ViewGroup parent = (ViewGroup) placeholder.getParent();
                        if (parent != null) {
                            parent.removeView(placeholder);
                            Log.d(TAG, "Removed placeholder for: " + identifier);
                        }
                    } catch (Throwable ignore) {}
                })
                .start();
        } catch (Throwable t) {
            // Fallback: immediate removal
            try {
                ViewGroup parent = (ViewGroup) placeholder.getParent();
                if (parent != null) {
                    parent.removeView(placeholder);
                }
            } catch (Throwable ignore) {}
        }
    }
    
    /**
     * Find ActivityView in hierarchy (usually direct child)
     */
    private static View findActivityView(ViewGroup container) {
        // ActivityView is usually a direct child
        for (int i = 0; i < container.getChildCount(); i++) {
            View child = container.getChildAt(i);
            String className = child.getClass().getName();
            if (className.contains("ActivityView")) {
                return child;
            }
        }
        return null;
    }
    
    private static SurfaceView findSurfaceView(View v) {
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
}