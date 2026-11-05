package com.lsec.core.frame.ctrl;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JView extends View {
    boolean bAttached;
    boolean bWillUpdateBackground;
    public boolean focus;
    int iState;
    public HashMap<String, Drawable> mDrawables;
    String mStrDrawable;
    String mStrDrawableFix;
    private JPage page;

    public JView(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.iState = -1;
        this.focus = false;
        this.mDrawables = new HashMap<>();
        this.page = page;
    }

    public void setFocus(boolean focus) {
        this.focus = focus;
        updateBackground();
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.iState = -1;
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

    public String getStrDrawable() {
        return this.mStrDrawable;
    }

    public int getState() {
        return this.iState;
    }

    public void updateBackground() {
        if (!this.bAttached) {
            this.bWillUpdateBackground = true;
            return;
        }
        this.bWillUpdateBackground = false;
        int iStateBak = this.iState;
        if (this.focus) {
            this.iState = 1;
        } else {
            this.iState = 0;
        }
        if (iStateBak != this.iState && this.mStrDrawable != null) {
            this.mStrDrawableFix = this.mStrDrawable;
            switch (this.iState) {
                case 1:
                    this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_p";
                    break;
            }
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables);
            setBackground(drawable);
        }
    }

    @Override // android.view.View
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
