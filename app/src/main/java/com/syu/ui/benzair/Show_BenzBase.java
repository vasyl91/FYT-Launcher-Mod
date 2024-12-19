package com.syu.ui.benzair;

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
import com.syu.util.ToolkitRes;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public abstract class Show_BenzBase extends View {
    protected int[] DATA;
    protected Bitmap mContent;
    protected Canvas mContentCanvas;
    protected int mContentHeight;
    protected int mContentWidth;
    protected Drawable mDrawableHighlight1;
    protected Drawable mDrawableNormal;
    protected Paint mPaint;
    protected String mPathHighlight1;
    protected String mPathNormal;
    protected Rect mRectDrawable;
    protected Rect mRectEmpty;
    protected Rect mRectTmp;
    protected float mScale;

    protected abstract void initDrawable();

    protected abstract void initSize();

    public Show_BenzBase(Context context) {
        super(context);
        this.mContentWidth = 1280;
        this.mContentHeight = 420;
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
        if (this.mDrawableNormal != null) {
            this.mDrawableNormal.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
        if (this.mDrawableHighlight1 != null) {
            this.mDrawableHighlight1.setBounds(0, 0, this.mContentWidth, this.mContentHeight);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mScale = LauncherApplication.getScreenWidth() / this.mContentWidth;
        setMeasuredDimension(LauncherApplication.getScreenWidth(), (int) (this.mContentHeight * this.mScale));
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
