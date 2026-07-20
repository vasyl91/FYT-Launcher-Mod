package com.syu.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Pre-warms and manages ActivityView surfaces to eliminate black screen delays
 */
public class WindowHostSurfacePreloader {
    private static final String TAG = "SurfacePreloader";
    
    // Pool of pre-warmed ActivityViews
    private static final Map<String, Object> warmPool = new ConcurrentHashMap<>();
    private static final Map<String, Long> warmTimestamps = new ConcurrentHashMap<>();
    private static final long WARM_EXPIRY_MS = 30_000L; // 30 seconds
    
    /**
     * Pre-create and warm up an ActivityView for instant use
     */
    public static Object prewarmActivityView(Context ctx, String key) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            schedulePrewarmActivityView(ctx, key);
            return null;
        }
        try {
            // Check if we already have a warm instance
            Object existing = warmPool.get(key);
            Long timestamp = warmTimestamps.get(key);
            
            if (existing != null && timestamp != null) {
                long age = System.currentTimeMillis() - timestamp;
                if (age < WARM_EXPIRY_MS) {
                    Log.i(TAG, "Using existing warm ActivityView for: " + key);
                    return existing;
                }
                releaseExpired(key, existing, "expired");
            } else if (existing != null) {
                releaseExpired(key, existing, "missing timestamp");
            }
            
            // Create new ActivityView
            Object av = WindowHostActivityView.newInstance(ctx);
            View avView = WindowHostActivityView.asView(av);
            
            // Force immediate surface creation
            forceSurfaceCreation(avView);
            
            // Store in pool
            warmPool.put(key, av);
            long createdAt = System.currentTimeMillis();
            warmTimestamps.put(key, createdAt);
            scheduleExpiryCheck(key, av, createdAt);
            Log.i(TAG, "Pre-warmed ActivityView for: " + key);
            return av;
            
        } catch (Throwable t) {
            Log.e(TAG, "Failed to prewarm ActivityView for: " + key, t);
            return null;
        }
    }

    public static void schedulePrewarmActivityView(Context ctx, String key) {
        new Handler(Looper.getMainLooper()).post(() -> prewarmActivityView(ctx, key));
    }
    
    /**
     * Retrieve a pre-warmed ActivityView (removes from pool)
     */
    public static Object getWarmActivityView(String key) {
        Object av = warmPool.remove(key);
        warmTimestamps.remove(key);
        
        if (av != null) {
            Log.i(TAG, "Retrieved warm ActivityView for: " + key);
        }
        
        return av;
    }

    private static void scheduleExpiryCheck(String key, Object av, long timestamp) {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Object current = warmPool.get(key);
            Long currentTimestamp = warmTimestamps.get(key);
            if (current == av && currentTimestamp != null && currentTimestamp == timestamp) {
                releaseExpired(key, av, "ttl");
            }
        }, WARM_EXPIRY_MS + 1_000L);
    }

    private static void releaseExpired(String key, Object av, String reason) {
        warmPool.remove(key);
        warmTimestamps.remove(key);
        try {
            WindowHostActivityView.release(av);
            Log.i(TAG, "Released warm ActivityView for: " + key + " reason=" + reason);
        } catch (Throwable t) {
            Log.w(TAG, "Failed to release expired ActivityView for: " + key, t);
        }
    }
    
    /**
     * Clear all pre-warmed instances
     */
    public static void clearPool() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            new Handler(Looper.getMainLooper()).post(WindowHostSurfacePreloader::clearPool);
            return;
        }
        List<Map.Entry<String, Object>> entries = new ArrayList<>(warmPool.entrySet());
        for (Map.Entry<String, Object> entry : entries) {
            try {
                WindowHostActivityView.release(entry.getValue());
            } catch (Throwable ignore) {}
        }
        warmPool.clear();
        warmTimestamps.clear();
        Log.i(TAG, "Cleared all pre-warmed ActivityViews count=" + entries.size());
    }
    
    /**
     * Force immediate surface creation and rendering
     */
    private static void forceSurfaceCreation(View avView) {
        try {
            // Find SurfaceView in the hierarchy
            SurfaceView sv = findSurfaceView(avView);
            if (sv != null) {
                // Force pixel format to ensure surface is created
                sv.getHolder().setFormat(PixelFormat.RGBA_8888);
                
                // Request layout immediately
                sv.requestLayout();
                sv.forceLayout();
                
                // Force a draw pass
                sv.invalidate();
                
                // Set callback to ensure surface is ready
                sv.getHolder().addCallback(new SurfaceHolder.Callback() {
                    @Override
                    public void surfaceCreated(SurfaceHolder holder) {
                        // Draw a transparent pixel to "wake up" the surface
                        try {
                            Canvas canvas = holder.lockCanvas();
                            if (canvas != null) {
                                canvas.drawColor(Color.TRANSPARENT);
                                holder.unlockCanvasAndPost(canvas);
                            }
                        } catch (Throwable ignore) {}
                    }
                    
                    @Override
                    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}
                    
                    @Override
                    public void surfaceDestroyed(SurfaceHolder holder) {}
                });
                
                Log.d(TAG, "Forced surface creation for ActivityView");
            }
            
            // Also ensure the view itself is measured and laid out
            avView.measure(
                View.MeasureSpec.makeMeasureSpec(800, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(600, View.MeasureSpec.EXACTLY)
            );
            avView.layout(0, 0, 800, 600);
            
        } catch (Throwable t) {
            Log.w(TAG, "Failed to force surface creation", t);
        }
    }
    
    /**
     * Aggressively force surface to be ready NOW
     */
    public static void forceInstantSurfaceReady(View avView) {
        if (avView == null) return;
        
        try {
            SurfaceView sv = findSurfaceView(avView);
            if (sv == null) return;
            
            // Multiple aggressive techniques
            sv.setVisibility(View.VISIBLE);
            sv.setWillNotDraw(false);
            sv.setZOrderOnTop(false);
            sv.setZOrderMediaOverlay(false);
            
            SurfaceHolder holder = sv.getHolder();
            holder.setFormat(PixelFormat.RGBA_8888);
            holder.setKeepScreenOn(true);
            
            // Force multiple layout passes
            for (int i = 0; i < 3; i++) {
                sv.requestLayout();
                sv.forceLayout();
                sv.invalidate();
            }
            
            // Try to lock and unlock canvas to initialize surface
            try {
                Canvas canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(Color.TRANSPARENT);
                    holder.unlockCanvasAndPost(canvas);
                }
            } catch (Throwable ignore) {}
            
            // Post another attempt after a frame
            avView.post(() -> {
                try {
                    Canvas canvas = holder.lockCanvas();
                    if (canvas != null) {
                        canvas.drawColor(Color.TRANSPARENT);
                        holder.unlockCanvasAndPost(canvas);
                    }
                } catch (Throwable ignore) {}
            });
            
            Log.i(TAG, "Forced instant surface ready");
            
        } catch (Throwable t) {
            Log.w(TAG, "Failed to force instant surface", t);
        }
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
