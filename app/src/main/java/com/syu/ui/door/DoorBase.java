package com.syu.ui.door;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;

import com.android.launcher66.LauncherApplication;
import com.syu.module.canbus.DataCanbus;

public abstract class DoorBase extends View {
    protected int[] DATA;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight;
    protected Drawable mDrawableNormal;
    protected Paint mPaint;
    protected Rect mRectDrawable;
    protected Rect mRectEmpty;
    protected Rect mRectTmp;
    protected float mScale;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public DoorBase(Context context) {
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
        init();
    }

    protected void init() {
        initSize();
        initDrawable();
        if (this.mDrawableNormal != null) {
            this.mDrawableNormal.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight != null) {
            this.mDrawableHighlight.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        this.mRectDrawable.set(0, 0, this.mContentWidth, this.mContentHeight);
        if (LauncherApplication.getScreenWidth() > LauncherApplication.getScreenHeight()) {
            this.mScale = 1.0f;
        } else {
            this.mScale = LauncherApplication.getScreenWidth() / LauncherApplication.getScreenHeight();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (LauncherApplication.getScreenWidth() > LauncherApplication.getScreenHeight()) {
            this.mScale = 1.0f;
        } else {
            this.mScale = LauncherApplication.getScreenWidth() / LauncherApplication.getScreenHeight();
        }
        setMeasuredDimension((int) (this.mContentWidth * this.mScale), (int) (this.mContentHeight * this.mScale));
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
                DoorHelper.getInstance().getWindow().dismiss();
                return false;
            }
            return false;
        }
        return false;
    }
}
