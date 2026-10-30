package com.syu.ui.door;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public abstract class DoorBase extends View {
    protected int[] DATA;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight;
    protected Drawable mDrawableNormal;
    protected Paint mPaint;
    protected Path mPath;
    protected RectF mRectDrawable;
    protected RectF mRectEmpty;
    protected RectF mRectTmp;
    protected float mScale;
    protected Path srPath;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public DoorBase(Context context) {
        super(context);
        this.mPath = new Path();
        this.srPath = new Path();
        this.mContentWidth = 1024;
        this.mContentHeight = 173;
        this.mPaint = new Paint();
        this.mRectEmpty = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mRectDrawable = new RectF(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        this.mRectTmp = new RectF();
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
        this.mRectDrawable.set(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        if (TheApp.getScreenWidth() > TheApp.getScreenHeight()) {
            this.mScale = 1.0f;
        } else {
            this.mScale = TheApp.getScreenWidth() / TheApp.getScreenHeight();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (TheApp.getScreenWidth() > TheApp.getScreenHeight()) {
            this.mScale = 1.0f;
        } else {
            this.mScale = TheApp.getScreenWidth() / TheApp.getScreenHeight();
        }
        setMeasuredDimension((int) (this.mContentWidth * this.mScale), (int) (this.mContentHeight * this.mScale));
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mContent = Bitmap.createBitmap(this.mContentWidth, this.mContentHeight, Bitmap.Config.ARGB_8888);
        if (this.mContent == null) {
            Log.v("zed", "mContent ================ null  111111111111");
        } else {
            Log.v("zed", "mContent 22222222222222222  =  " + this.mContent);
        }
        this.mContentCanvas = new Canvas(this.mContent);
        if (this.mContentCanvas == null) {
            Log.v("zed", "mContentCanvas ================ null  33333333333333");
        } else {
            Log.v("zed", "mContentCanvas 44444444444  =  " + this.mContentCanvas);
        }
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
                DoorHelper.getInstance().getWindow().dismiss();
                return false;
            }
            return false;
        }
        return false;
    }
}
