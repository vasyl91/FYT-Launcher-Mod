package com.android.launcher66;

import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.android.launcher66.DragLayer;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class DragView extends View {
    private static float sDragAlpha = 1.0f;
    ValueAnimator mAnim;
    private Bitmap mBitmap;
    private Bitmap mCrossFadeBitmap;
    private float mCrossFadeProgress;
    private DragLayer mDragLayer;
    private Rect mDragRegion;
    private Point mDragVisualizeOffset;
    private boolean mHasDrawn;
    private float mInitialScale;
    private float mOffsetX;
    private float mOffsetY;
    private Paint mPaint;
    private int mRegistrationX;
    private int mRegistrationY;

    public DragView(Launcher launcher, Bitmap bitmap, int registrationX, int registrationY, int left, int top, int width, int height, final float initialScale) {
        super(launcher);
        this.mDragVisualizeOffset = null;
        this.mDragRegion = null;
        this.mDragLayer = null;
        this.mHasDrawn = false;
        this.mCrossFadeProgress = 0.0f;
        this.mOffsetX = 0.0f;
        this.mOffsetY = 0.0f;
        this.mInitialScale = 1.0f;
        this.mDragLayer = launcher.getDragLayer();
        this.mInitialScale = initialScale;
        Resources res = getResources();
        final float offsetX = res.getDimensionPixelSize(R.dimen.dragViewOffsetX);
        final float offsetY = res.getDimensionPixelSize(R.dimen.dragViewOffsetY);
        float scaleDps = res.getDimensionPixelSize(R.dimen.dragViewScale);
        final float scale = (width + scaleDps) / width;
        setScaleX(initialScale);
        setScaleY(initialScale);
        this.mAnim = LauncherAnimUtils.ofFloat(this, 0.0f, 1.0f);
        this.mAnim.setDuration(150L);
        this.mAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.DragView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = ((Float) animation.getAnimatedValue()).floatValue();
                int deltaX = (int) ((offsetX * value) - DragView.this.mOffsetX);
                int deltaY = (int) ((offsetY * value) - DragView.this.mOffsetY);
                DragView.this.mOffsetX += deltaX;
                DragView.this.mOffsetY += deltaY;
                DragView.this.setScaleX(initialScale + ((scale - initialScale) * value));
                DragView.this.setScaleY(initialScale + ((scale - initialScale) * value));
                if (DragView.sDragAlpha != 1.0f) {
                    DragView.this.setAlpha((DragView.sDragAlpha * value) + (1.0f - value));
                }
                if (DragView.this.getParent() == null) {
                    animation.cancel();
                } else {
                    DragView.this.setTranslationX(DragView.this.getTranslationX() + deltaX);
                    DragView.this.setTranslationY(DragView.this.getTranslationY() + deltaY);
                }
            }
        });
        this.mBitmap = Bitmap.createBitmap(bitmap, left, top, width, height);
        setDragRegion(new Rect(0, 0, width, height));
        this.mRegistrationX = registrationX;
        this.mRegistrationY = registrationY;
        int ms = View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        measure(ms, ms);
        this.mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public int getDragRegionLeft() {
        return this.mDragRegion.left;
    }

    public int getDragRegionTop() {
        return this.mDragRegion.top;
    }

    public int getDragRegionWidth() {
        return this.mDragRegion.width();
    }

    public int getDragRegionHeight() {
        return this.mDragRegion.height();
    }

    public void setDragVisualizeOffset(Point p) {
        this.mDragVisualizeOffset = p;
    }

    public Point getDragVisualizeOffset() {
        return this.mDragVisualizeOffset;
    }

    public void setDragRegion(Rect r) {
        this.mDragRegion = r;
    }

    public Rect getDragRegion() {
        return this.mDragRegion;
    }

    public float getInitialScale() {
        return this.mInitialScale;
    }

    public void updateInitialScaleToCurrentScale() {
        this.mInitialScale = getScaleX();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(this.mBitmap.getWidth(), this.mBitmap.getHeight());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mHasDrawn = true;
        boolean crossFade = this.mCrossFadeProgress > 0.0f && this.mCrossFadeBitmap != null;
        if (crossFade) {
            int alpha = crossFade ? (int) ((1.0f - this.mCrossFadeProgress) * 255.0f) : 255;
            this.mPaint.setAlpha(alpha);
        }
        canvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, this.mPaint);
        if (crossFade) {
            this.mPaint.setAlpha((int) (this.mCrossFadeProgress * 255.0f));
            canvas.save();
            float sX = (this.mBitmap.getWidth() * 1.0f) / this.mCrossFadeBitmap.getWidth();
            float sY = (this.mBitmap.getHeight() * 1.0f) / this.mCrossFadeBitmap.getHeight();
            canvas.scale(sX, sY);
            canvas.drawBitmap(this.mCrossFadeBitmap, 0.0f, 0.0f, this.mPaint);
            canvas.restore();
        }
    }

    public void setCrossFadeBitmap(Bitmap crossFadeBitmap) {
        this.mCrossFadeBitmap = crossFadeBitmap;
    }

    public void crossFade(int duration) {
        ValueAnimator va = LauncherAnimUtils.ofFloat(this, 0.0f, 1.0f);
        va.setDuration(duration);
        va.setInterpolator(new DecelerateInterpolator(1.5f));
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.android.launcher66.DragView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                DragView.this.mCrossFadeProgress = animation.getAnimatedFraction();
            }
        });
        va.start();
    }

    public void setColor(int color) {
        if (this.mPaint == null) {
            this.mPaint = new Paint(Paint.FILTER_BITMAP_FLAG);
        }
        if (color != 0) {
            this.mPaint.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
        } else {
            this.mPaint.setColorFilter(null);
        }
        invalidate();
    }

    public boolean hasDrawn() {
        return this.mHasDrawn;
    }

    @Override // android.view.View
    public void setAlpha(float alpha) {
        super.setAlpha(alpha);
        this.mPaint.setAlpha((int) (255.0f * alpha));
        invalidate();
    }

    public void show(int touchX, int touchY) {
        this.mDragLayer.addView(this);
        DragLayer.LayoutParams lp = new DragLayer.LayoutParams(0, 0);
        lp.width = this.mBitmap.getWidth();
        lp.height = this.mBitmap.getHeight();
        lp.customPosition = true;
        setLayoutParams(lp);
        setTranslationX(touchX - this.mRegistrationX);
        setTranslationY(touchY - this.mRegistrationY);
        post(new Runnable() { // from class: com.android.launcher66.DragView.3
            @Override // java.lang.Runnable
            public void run() {
                DragView.this.mAnim.start();
            }
        });
    }

    public void cancelAnimation() {
        if (this.mAnim != null && this.mAnim.isRunning()) {
            this.mAnim.cancel();
        }
    }

    public void resetLayoutParams() {
        this.mOffsetY = 0.0f;
        this.mOffsetX = 0.0f;
        requestLayout();
    }

    void move(int touchX, int touchY) {
        setTranslationX((touchX - this.mRegistrationX) + ((int) this.mOffsetX));
        setTranslationY((touchY - this.mRegistrationY) + ((int) this.mOffsetY));
    }

    void remove() {
        if (getParent() != null) {
            this.mDragLayer.removeView(this);
        }
    }
}
