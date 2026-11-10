package com.syu.ui.air;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public abstract class AirBase extends View {
    protected int[] DATA;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight;
    protected Drawable mDrawableNormal;
    protected Paint mPaint;
    protected String mPathHighlight;
    protected String mPathNormal;
    protected Rect mRectDrawable;
    protected Rect mRectEmpty;
    protected Rect mRectTmp;
    protected float mScale;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public AirBase(Context context) {
        super(context);
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
        this.mPaint = new Paint();
        this.mRectEmpty = new Rect(0, 0, 0, 0);
        this.mRectDrawable = new Rect(0, 0, this.mContentWidth, this.mContentHeight);
        this.mRectTmp = new Rect();
        this.DATA = DataCanbus.DATA;
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(-1);
        init();
    }

    protected void init() {
        initSize();
        initDrawable();
        this.mRectDrawable.set(0, 0, this.mContentWidth, this.mContentHeight);
        this.mScale = TheApp.getScreenWidth() / 1024.0f;
        if (this.mDrawableNormal != null) {
            this.mDrawableNormal.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight != null) {
            this.mDrawableHighlight.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mScale = TheApp.getScreenWidth() / this.mContentWidth;
        if (TheApp.getConfiguration() == 1) {
            setMeasuredDimension(TheApp.getScreenWidth(), (int) (this.mContentHeight * this.mScale));
            return;
        }
        if (DataCanbus.DATA[1000] == 3014954 || DataCanbus.DATA[1000] == 3080490 || DataCanbus.DATA[1000] == 3932458 || DataCanbus.DATA[1000] == 4194602 || DataCanbus.DATA[1000] == 3997994 || DataCanbus.DATA[1000] == 3211376 || DataCanbus.DATA[1000] == 3801200 || DataCanbus.DATA[1000] == 3735664 || DataCanbus.DATA[1000] == 3276912 || DataCanbus.DATA[1000] == 3342448 || DataCanbus.DATA[1000] == 3670128 || DataCanbus.DATA[1000] == 5112261 || DataCanbus.DATA[1000] == 393666 || DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
            setMeasuredDimension(TheApp.getScreenWidth(), (int) (this.mContentHeight * this.mScale));
        } else {
            setMeasuredDimension(TheApp.getScreenWidth(), (int) ((this.mContentHeight * TheApp.getScreenHeight()) / 600.0f));
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContent = Bitmap.createBitmap(this.mContentWidth, this.mContentHeight, Bitmap.Config.ARGB_8888);
        this.mContentCanvas = new Canvas(this.mContent);
        if (this.mPathNormal != null) {
            this.mDrawableNormal = ToolkitRes.loadDrawable(this.mPathNormal);
            if (this.mDrawableNormal != null) {
                this.mDrawableNormal.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
            }
        }
        if (this.mPathHighlight != null) {
            this.mDrawableHighlight = ToolkitRes.loadDrawable(this.mPathHighlight);
            if (this.mDrawableHighlight != null) {
                this.mDrawableHighlight.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPathNormal != null) {
            this.mDrawableNormal = null;
        }
        if (this.mPathHighlight != null) {
            this.mDrawableHighlight = null;
        }
        this.mContent = null;
        this.mContentCanvas = null;
    }
}
