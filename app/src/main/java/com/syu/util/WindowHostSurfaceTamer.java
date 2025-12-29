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
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class WindowHostSurfaceTamer {
    private static final String TAG = "SurfaceTamer";
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    
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
                public void surfaceCreated(SurfaceHolder h) {
                    if (!initialized) {
                        initialized = true;
                        forceInitialDraw(h);
                    }
                }
                
                @Override
                public void surfaceChanged(SurfaceHolder h, int format, int width, int height) {
                    if (width > 0 && height > 0 && !initialized) {
                        initialized = true;
                        forceInitialDraw(h);
                    }
                }
                
                @Override
                public void surfaceDestroyed(SurfaceHolder h) {
                    initialized = false;
                }
                
                @Override
                public void surfaceRedrawNeeded(SurfaceHolder h) {
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
        }
    }
    
    /**
     * Create a snapshot placeholder that shows while surface loads
     */
    static ImageView createLoadingPlaceholder(ViewGroup container, String tag) {
        ImageView placeholder = new ImageView(container.getContext());
        placeholder.setTag(tag);
        placeholder.setScaleType(ImageView.ScaleType.CENTER_CROP);
        placeholder.setBackgroundColor(Color.argb(255, 32, 32, 32)); // Dark gray
        
        // Create a simple "loading" bitmap
        Bitmap loadingBitmap = createLoadingBitmap(400, 300);
        placeholder.setImageBitmap(loadingBitmap);
        
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        );
        
        return placeholder;
    }
    
    /**
     * Create a loading indicator bitmap
     */
    private static Bitmap createLoadingBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        
        // Dark background
        canvas.drawColor(Color.argb(255, 32, 32, 32));
        
        // Loading spinner/text
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.argb(180, 200, 200, 200));
        paint.setTextSize(24);
        paint.setTextAlign(Paint.Align.CENTER);
        
        String text = "Loading...";
        float textX = width / 2f;
        float textY = height / 2f;
        
        canvas.drawText(text, textX, textY, paint);
        
        return bitmap;
    }
    
    /**
     * Try to capture current surface content as placeholder
     */
    static Bitmap captureSurfaceSnapshot(SurfaceView sv) {
        try {
            // Enable drawing cache temporarily
            sv.setDrawingCacheEnabled(true);
            sv.buildDrawingCache(true);
            
            Bitmap snapshot = sv.getDrawingCache();
            if (snapshot != null) {
                // Create a copy since drawing cache is recycled
                Bitmap copy = Bitmap.createBitmap(snapshot);
                sv.setDrawingCacheEnabled(false);
                return copy;
            }
        } catch (Throwable e) {
            Log.w(TAG, "Failed to capture surface snapshot", e);
        }
        
        return null;
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
                        public void surfaceCreated(SurfaceHolder h) {}
                        public void surfaceChanged(SurfaceHolder h, int format, int width, int height) {}
                        public void surfaceDestroyed(SurfaceHolder h) {}
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
    
    /**
     * Ultra-aggressive surface wake-up for instant display
     */
    static void ultraWakeupSurface(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv == null) return;
        
        try {
            // Multiple aggressive techniques in parallel
            
            // Technique 1: Z-order manipulation
            mainHandler.post(() -> {
                try {
                    sv.setZOrderOnTop(true);
                    sv.requestLayout();
                    mainHandler.postDelayed(() -> {
                        sv.setZOrderOnTop(false);
                        sv.requestLayout();
                    }, 16);
                } catch (Throwable ignore) {}
            });
            
            // Technique 2: Format cycling
            mainHandler.postDelayed(() -> {
                try {
                    SurfaceHolder holder = sv.getHolder();
                    holder.setFormat(PixelFormat.RGB_565);
                    holder.setFormat(PixelFormat.RGBA_8888);
                } catch (Throwable ignore) {}
            }, 16);
            
            // Technique 3: Multiple forced draws
            for (int i = 0; i < 10; i++) {
                final int delay = i * 16;
                mainHandler.postDelayed(() -> {
                    forceInitialDraw(sv.getHolder());
                }, delay);
            }
            
            // Technique 4: Visibility cycling
            mainHandler.postDelayed(() -> {
                try {
                    sv.setVisibility(View.INVISIBLE);
                    sv.requestLayout();
                    mainHandler.postDelayed(() -> {
                        sv.setVisibility(View.VISIBLE);
                        sv.requestLayout();
                    }, 16);
                } catch (Throwable ignore) {}
            }, 32);
            
            Log.i(TAG, "Ultra wakeup applied to surface");
            
        } catch (Throwable e) {
            Log.w(TAG, "Failed ultra wakeup", e);
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