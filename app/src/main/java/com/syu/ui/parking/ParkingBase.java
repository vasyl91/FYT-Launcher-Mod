package com.syu.ui.parking;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public abstract class ParkingBase extends View {
    protected int[] DATA;
    protected TextView TVShow_Msg;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight_1;
    protected Drawable mDrawableHighlight_2;
    protected Drawable mDrawableHighlight_3;
    protected Drawable mDrawableHighlight_4;
    protected Drawable mDrawableHighlight_5;
    protected Drawable mDrawableHighlight_6;
    protected Drawable mDrawableNormal_1;
    protected Drawable mDrawableNormal_2;
    protected Drawable mDrawableNormal_3;
    protected Drawable mDrawableNormal_4;
    protected Drawable mDrawableNormal_5;
    protected Drawable mDrawableNormal_6;
    protected Drawable mDrawableNull;
    protected Paint mPaint;
    protected Rect mRectDrawable;
    protected Rect mRectEmpty;
    protected Rect mRectTmp;
    protected float mScale;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public ParkingBase(Context context) {
        super(context);
        this.mContentWidth = 1024;
        this.mContentHeight = 540;
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
        this.mScale = LauncherApplication.getScreenWidth() / this.mContentWidth;
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
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mScale = LauncherApplication.getScreenWidth() / this.mContentWidth;
        setMeasuredDimension(LauncherApplication.getScreenWidth(), (int) (this.mContentHeight * this.mScale));
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContent = Bitmap.createBitmap(this.mContentWidth, this.mContentHeight, Bitmap.Config.ARGB_8888);
        this.mContentCanvas = new Canvas(this.mContent);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mContent = null;
        this.mContentCanvas = null;
    }

    @Override
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
