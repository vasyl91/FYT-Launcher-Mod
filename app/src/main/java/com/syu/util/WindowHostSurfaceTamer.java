package com.syu.util;

import android.graphics.PixelFormat;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class WindowHostSurfaceTamer {
    static void tame(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv == null) return;
        try {
            sv.setCompositionOrder(-1);
            sv.setZOrderOnTop(false);
            sv.setZOrderMediaOverlay(false);
        } catch (Throwable ignore) {}
    }
    
    static void forceCleanup(View root) {
        SurfaceView sv = findSurfaceView(root);
        if (sv == null) return;
        try {
            // Make surface invisible first
            sv.setVisibility(View.INVISIBLE);
            
            // Force surface destruction by changing format
            try {
                sv.getHolder().setFormat(PixelFormat.TRANSPARENT);
                sv.getHolder().setFormat(PixelFormat.UNKNOWN);
            } catch (Throwable ignore) {}
            
            // Remove all callbacks to prevent lingering references
            try {
                sv.getHolder().removeCallback(sv.getHolder().getSurface() != null ? 
                    new android.view.SurfaceHolder.Callback() {
                        public void surfaceCreated(android.view.SurfaceHolder holder) {}
                        public void surfaceChanged(android.view.SurfaceHolder holder, int format, int width, int height) {}
                        public void surfaceDestroyed(android.view.SurfaceHolder holder) {}
                    } : null);
            } catch (Throwable ignore) {}
            
            // Force layout to zero size
            ViewGroup.LayoutParams lp = sv.getLayoutParams();
            if (lp != null) {
                lp.width = 0;
                lp.height = 0;
                sv.setLayoutParams(lp);
            }
            
            // Request immediate layout
            sv.requestLayout();
            
            // Remove from parent if possible
            ViewParent parent = sv.getParent();
            if (parent instanceof ViewGroup) {
                try {
                    ((ViewGroup) parent).removeView(sv);
                } catch (Throwable ignore) {}
            }
        } catch (Throwable ignore) {}
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