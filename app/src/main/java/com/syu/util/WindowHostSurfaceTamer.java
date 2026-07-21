package com.syu.util;

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
import android.view.ViewParent;

import androidx.annotation.NonNull;

import java.util.concurrent.atomic.AtomicBoolean;

public class WindowHostSurfaceTamer {
    private static final String TAG = "SurfaceTamer";
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static final AtomicBoolean drawing = new AtomicBoolean(false);
    
    /**
     * Aggressively tame and prepare surface for immediate rendering
     */
    static void tame(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv == null) return;
        
        try {
            // Basic Z-order setup (setCompositionOrder doesn't exist in Android API)
            sv.setZOrderOnTop(false);
            sv.setZOrderMediaOverlay(false);
            
            // Force visibility
            sv.setVisibility(View.VISIBLE);
            sv.setWillNotDraw(false);
            
            // Aggressive surface initialization
            forceSurfaceInit(sv);
            
            Log.d(TAG, "Surface tamed and initialized");
            
        } catch (Throwable e) {
            Log.w(TAG, "Failed to tame surface", e);
        }
    }
    
    /**
     * Aggressively force surface initialization with multiple techniques
     */
    private static void forceSurfaceInit(SurfaceView sv) {
        try {
            SurfaceHolder holder = sv.getHolder();
            
            // Set optimal format
            holder.setFormat(PixelFormat.RGBA_8888);
            
            // Add callback that forces initial draw
            holder.addCallback(new SurfaceHolder.Callback2() {
                private boolean initialized = false;
                
                @Override
                public void surfaceCreated(@NonNull SurfaceHolder h) {
                    if (!initialized) {
                        initialized = true;
                        forceInitialDraw(h);
                    }
                }
                
                @Override
                public void surfaceChanged(@NonNull SurfaceHolder h, int format, int width, int height) {
                    if (width > 0 && height > 0 && !initialized) {
                        initialized = true;
                        forceInitialDraw(h);
                    }
                }
                
                @Override
                public void surfaceDestroyed(@NonNull SurfaceHolder h) {
                    initialized = false;
                }
                
                @Override
                public void surfaceRedrawNeeded(@NonNull SurfaceHolder h) {
                    forceInitialDraw(h);
                }
            });
            
            // Force multiple layout passes
            for (int i = 0; i < 5; i++) {
                sv.requestLayout();
                sv.forceLayout();
            }
            
            // Immediate draw attempt
            mainHandler.post(() -> forceInitialDraw(holder));
            
            // Delayed draw attempts for safety
            mainHandler.postDelayed(() -> forceInitialDraw(holder), 50);
            mainHandler.postDelayed(() -> forceInitialDraw(holder), 100);
            mainHandler.postDelayed(() -> forceInitialDraw(holder), 200);
            
        } catch (Throwable e) {
            Log.w(TAG, "Failed to force surface init", e);
        }
    }
    
    /**
     * Force an initial draw to wake up the surface
     */
    private static void forceInitialDraw(SurfaceHolder holder) {
        // If the previous lockCanvas attempt is still in progress (or has just
        // started from another execution path), skip this one to avoid overlapping
        // attempts and buffer contention (dequeueBuffer).
        if (!drawing.compareAndSet(false, true)) {
            return;
        }

        Canvas canvas = null;
        try {
            canvas = holder.lockCanvas();
            if (canvas != null) {
                // Draw transparent background
                canvas.drawColor(Color.TRANSPARENT);

                // Draw a single pixel to ensure surface is active
                Paint paint = new Paint();
                paint.setColor(Color.TRANSPARENT);
                canvas.drawPoint(0, 0, paint);
            }
        } catch (Throwable e) {
            // Surface not ready yet, ignore
        } finally {
            if (canvas != null) {
                try {
                    holder.unlockCanvasAndPost(canvas);
                } catch (Throwable ignore) {}
            }
            drawing.set(false);
        }
    }
    
    /**
     * Enhanced cleanup with immediate surface destruction
     */
    static void forceCleanup(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv == null) return;
        
        try {
            // Make surface invisible first
            sv.setVisibility(View.INVISIBLE);
            
            // Remove all callbacks immediately
            try {
                SurfaceHolder holder = sv.getHolder();
                holder.removeCallback(holder.getSurface() != null ? 
                    new SurfaceHolder.Callback() {
                        public void surfaceCreated(@NonNull SurfaceHolder h) {}
                        public void surfaceChanged(@NonNull SurfaceHolder h, int format, int width, int height) {}
                        public void surfaceDestroyed(@NonNull SurfaceHolder h) {}
                    } : null);
            } catch (Throwable ignore) {}
            
            // Force format change to trigger destruction
            try {
                sv.getHolder().setFormat(PixelFormat.TRANSPARENT);
                sv.getHolder().setFormat(PixelFormat.UNKNOWN);
            } catch (Throwable ignore) {}
            
            // Force zero size
            ViewGroup.LayoutParams lp = sv.getLayoutParams();
            if (lp != null) {
                lp.width = 0;
                lp.height = 0;
                sv.setLayoutParams(lp);
            }
            
            // Multiple layout requests to ensure cleanup
            sv.requestLayout();
            sv.forceLayout();
            sv.invalidate();
            
            // Remove from parent after a brief delay
            mainHandler.postDelayed(() -> {
                ViewParent parent = sv.getParent();
                if (parent instanceof ViewGroup) {
                    try {
                        ((ViewGroup) parent).removeView(sv);
                    } catch (Throwable ignore) {}
                }
            }, 50);
            
        } catch (Throwable e) {
            Log.w(TAG, "Failed to force cleanup", e);
        }
    }
    
    private static SurfaceView findSurfaceView(View v) {
        if (v instanceof SurfaceView) return (SurfaceView) v;
        if (v instanceof ViewGroup g) {

            for (int i = 0; i < g.getChildCount(); i++) {
                SurfaceView res = findSurfaceView(g.getChildAt(i));
                if (res != null) return res;
            }
        }
        return null;
    }
}