package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public abstract class ParkingBase extends View {
    protected int[] DATA;
    protected TextView TVShow_Msg;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight_1;
    protected Drawable mDrawableHighlight_10;
    protected Drawable mDrawableHighlight_11;
    protected Drawable mDrawableHighlight_12;
    protected Drawable mDrawableHighlight_13;
    protected Drawable mDrawableHighlight_14;
    protected Drawable mDrawableHighlight_15;
    protected Drawable mDrawableHighlight_2;
    protected Drawable mDrawableHighlight_3;
    protected Drawable mDrawableHighlight_4;
    protected Drawable mDrawableHighlight_5;
    protected Drawable mDrawableHighlight_6;
    protected Drawable mDrawableHighlight_7;
    protected Drawable mDrawableHighlight_8;
    protected Drawable mDrawableHighlight_9;
    protected Drawable mDrawableNormal_1;
    protected Drawable mDrawableNormal_10;
    protected Drawable mDrawableNormal_11;
    protected Drawable mDrawableNormal_12;
    protected Drawable mDrawableNormal_13;
    protected Drawable mDrawableNormal_14;
    protected Drawable mDrawableNormal_15;
    protected Drawable mDrawableNormal_2;
    protected Drawable mDrawableNormal_3;
    protected Drawable mDrawableNormal_4;
    protected Drawable mDrawableNormal_5;
    protected Drawable mDrawableNormal_6;
    protected Drawable mDrawableNormal_7;
    protected Drawable mDrawableNormal_8;
    protected Drawable mDrawableNormal_9;
    protected Drawable mDrawableNull;
    protected Paint mPaint;
    protected Path mPath;
    protected RectF mRectDrawable;
    protected RectF mRectEmpty;
    protected RectF mRectTmp;
    protected float mScale;
    protected float mYScale;
    protected Path srPath;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public ParkingBase(Context context) {
        super(context);
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
        this.mPaint = new Paint();
        this.mRectEmpty = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mRectDrawable = new RectF(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        this.mRectTmp = new RectF();
        this.DATA = DataCanbus.DATA;
        this.mPath = new Path();
        this.srPath = new Path();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setFilterBitmap(true);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(-1);
        init();
    }

    protected void init() {
        initSize();
        initDrawable();
        this.mContentWidth = TheApp.getScreenWidth();
        this.mContentHeight = TheApp.getScreenHeight() - 60;
        this.mRectDrawable.set(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        this.mYScale = TheApp.getScreenHeight() / 540.0f;
        if (this.mDrawableNull != null) {
            this.mDrawableNull.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_1 != null) {
            this.mDrawableNormal_1.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_1 != null) {
            this.mDrawableHighlight_1.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_2 != null) {
            this.mDrawableNormal_2.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_2 != null) {
            this.mDrawableHighlight_2.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_3 != null) {
            this.mDrawableNormal_3.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_3 != null) {
            this.mDrawableHighlight_3.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_4 != null) {
            this.mDrawableNormal_4.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_4 != null) {
            this.mDrawableHighlight_4.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_5 != null) {
            this.mDrawableNormal_5.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_5 != null) {
            this.mDrawableHighlight_5.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_6 != null) {
            this.mDrawableNormal_6.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_6 != null) {
            this.mDrawableHighlight_6.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_7 != null) {
            this.mDrawableNormal_7.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_7 != null) {
            this.mDrawableHighlight_7.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_8 != null) {
            this.mDrawableNormal_8.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_8 != null) {
            this.mDrawableHighlight_8.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_9 != null) {
            this.mDrawableNormal_9.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_9 != null) {
            this.mDrawableHighlight_9.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_10 != null) {
            this.mDrawableNormal_10.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_10 != null) {
            this.mDrawableHighlight_10.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_11 != null) {
            this.mDrawableNormal_11.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_11 != null) {
            this.mDrawableHighlight_11.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_12 != null) {
            this.mDrawableNormal_12.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_12 != null) {
            this.mDrawableHighlight_12.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_13 != null) {
            this.mDrawableNormal_13.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_13 != null) {
            this.mDrawableHighlight_13.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_14 != null) {
            this.mDrawableNormal_14.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_14 != null) {
            this.mDrawableHighlight_14.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableNormal_15 != null) {
            this.mDrawableNormal_15.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight_15 != null) {
            this.mDrawableHighlight_15.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mScale = TheApp.getScreenWidth() / this.mContentWidth;
        setMeasuredDimension(TheApp.getScreenWidth(), TheApp.getScreenHeight());
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContent = Bitmap.createBitmap(this.mContentWidth, this.mContentHeight, Bitmap.Config.ARGB_8888);
        this.mContentCanvas = new Canvas(this.mContent);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContent = null;
        this.mContentCanvas = null;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Bitmap content = this.mContent;
        if (content != null) {
            int x = (int) (event.getX() / this.mScale);
            int y = (int) (event.getY() / this.mScale);
            if (x < 0 || x >= content.getWidth() || y < 0 || y >= content.getHeight() || content.getPixel(x, y) == 0) {
                ParkingHelper.getInstance().getWindow().dismiss();
                return false;
            }
            return false;
        }
        return false;
    }
}
