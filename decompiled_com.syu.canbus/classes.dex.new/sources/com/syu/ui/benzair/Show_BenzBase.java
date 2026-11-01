package com.syu.ui.benzair;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.TheApp;
import com.syu.module.canbus.DataCanbus;
import com.syu.util.ToolkitRes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public abstract class Show_BenzBase extends View {
    protected int[] DATA;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight1;
    protected Drawable mDrawableNormal;
    protected Paint mPaint;
    protected Path mPath;
    protected String mPathHighlight1;
    protected String mPathNormal;
    protected RectF mRectDrawable;
    protected RectF mRectEmpty;
    protected RectF mRectTmp;
    protected float mScale;
    protected Path srPath;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public Show_BenzBase(Context context) {
        super(context);
        this.mContentWidth = 1280;
        this.mContentHeight = 420;
        this.mPath = new Path();
        this.srPath = new Path();
        this.mPaint = new Paint();
        this.mRectEmpty = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.mRectDrawable = new RectF(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        this.mRectTmp = new RectF();
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
        this.mRectDrawable.set(0.0f, 0.0f, this.mContentWidth, this.mContentHeight);
        this.mScale = TheApp.getScreenWidth() / this.mContentWidth;
        if (this.mDrawableNormal != null) {
            this.mDrawableNormal.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight1 != null) {
            this.mDrawableHighlight1.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mScale = TheApp.getScreenWidth() / this.mContentWidth;
        setMeasuredDimension(TheApp.getScreenWidth(), (int) (this.mContentHeight * this.mScale));
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
        if (this.mPathHighlight1 != null) {
            this.mDrawableHighlight1 = ToolkitRes.loadDrawable(this.mPathHighlight1);
            if (this.mDrawableHighlight1 != null) {
                this.mDrawableHighlight1.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
            }
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mPathNormal != null) {
            this.mDrawableNormal = null;
        }
        if (this.mPathHighlight1 != null) {
            this.mDrawableHighlight1 = null;
        }
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
                Show_BenzHelper.getInstance().getWindow().dismiss();
                return false;
            }
            return false;
        }
        return false;
    }
}
