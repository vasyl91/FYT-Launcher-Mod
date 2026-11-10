package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JProgressBar extends ProgressBar {
    boolean bAttached;
    boolean bWillUpdateBackground;
    public HashMap<String, Drawable> mDrawables;
    String mStrDrawable;
    public JPage page;

    public JProgressBar(Context context, AttributeSet attrs, int defStyleAttr, JPage page) {
        super(context, attrs, defStyleAttr);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.page = page;
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

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        this.bAttached = true;
        if (this.bWillUpdateBackground) {
            this.bWillUpdateBackground = false;
            updateBackground();
        }
        super.onAttachedToWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
