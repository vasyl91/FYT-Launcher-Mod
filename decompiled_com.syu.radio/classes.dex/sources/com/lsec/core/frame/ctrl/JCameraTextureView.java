package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.TextureView;
import com.lsec.core.util.InterfaceSurfaceTexture;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JCameraTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    boolean bAttached;
    boolean bWillUpdateBackground;
    public HashMap<String, Drawable> mDrawables;
    public InterfaceSurfaceTexture mInterfaceSurfaceTexture;
    String mStrDrawable;
    SurfaceTexture mSurfaceTexture;
    public JPage page;

    @Override // android.view.TextureView
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public JCameraTextureView(Context context, JPage page) {
        super(context);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mInterfaceSurfaceTexture = null;
        this.page = page;
        setSurfaceTextureListener(this);
    }

    public JCameraTextureView(Context context) {
        super(context);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mInterfaceSurfaceTexture = null;
        setSurfaceTextureListener(this);
    }

    public JCameraTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mInterfaceSurfaceTexture = null;
        setSurfaceTextureListener(this);
    }

    public JCameraTextureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mInterfaceSurfaceTexture = null;
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        this.mSurfaceTexture = surface;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        this.mSurfaceTexture = surface;
        if (this.mInterfaceSurfaceTexture != null) {
            this.mInterfaceSurfaceTexture.onSurfaceTextureSizeChanged(width, height);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        this.mSurfaceTexture = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        this.mSurfaceTexture = surface;
        if (this.mInterfaceSurfaceTexture != null) {
            this.mInterfaceSurfaceTexture.onSurfaceTextureUpdated(surface);
        }
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk) {
            if (drawable == null) {
                setBackground(null);
            } else {
                updateBackground();
            }
        }
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        if (this.page != null && this.mStrDrawable != null) {
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawable, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
