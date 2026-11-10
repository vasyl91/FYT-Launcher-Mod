package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JDashLine extends View {
    boolean bAttached;
    boolean bWillUpdateBackground;
    public HashMap<String, Drawable> mDrawables;
    private Paint mPaint;
    Path mPath;
    PathEffect mPathEffects;
    String mStrDrawable;
    public JPage page;

    public JDashLine(Context context, JPage page) {
        super(context);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.mDrawables = new HashMap<>();
        this.mPathEffects = new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f);
        this.page = page;
        Init();
    }

    private void Init() {
        this.mPaint = new Paint();
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    public void setColor(int color) {
        this.mPaint.setColor(color);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0) {
            if (w > h) {
                this.mPaint.setStrokeWidth(h);
            } else {
                this.mPaint.setStrokeWidth(w);
            }
            this.mPath = new Path();
            if (getWidth() > getHeight()) {
                this.mPath.moveTo(0.0f, 0.0f);
                this.mPath.lineTo(getWidth(), 0.0f);
            } else {
                this.mPath.moveTo(0.0f, 0.0f);
                this.mPath.lineTo(0.0f, getHeight());
            }
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mPaint.setPathEffect(this.mPathEffects);
        canvas.drawPath(this.mPath, this.mPaint);
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
