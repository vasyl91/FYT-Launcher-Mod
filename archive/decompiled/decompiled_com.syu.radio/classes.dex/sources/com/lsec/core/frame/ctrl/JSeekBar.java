package com.lsec.core.frame.ctrl;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.FuncUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSeekBar extends View {
    boolean bAttached;
    public boolean bCanSeekAble;
    public boolean bClickDown;
    public boolean bDrawMidTxt;
    boolean bWillSetIconName;
    boolean bWillUpdateBackground;
    private Bitmap bmp_seekbar;
    private Bitmap bmp_seekbar_focus;
    private Bitmap bmp_thumb;
    private Bitmap bmp_txtBK;
    Drawable drawable_seekbar;
    Drawable drawable_seekbar_focus;
    Drawable drawable_thumb;
    Drawable drawable_txtBk;
    private Paint.FontMetricsInt fontMetrics;
    public int hExtraTxt;
    public int hExtraTxtBk;
    public int hLine;
    String[] iconNames;
    public HashMap<String, Drawable> mDrawables;
    public int mMax;
    public int mMin;
    public int mMinDisp;
    public int mPosMin;
    public int mPosTarget;
    public int mProgress;
    private float mScaleX;
    private float mScaleY;
    public float mStep;
    String mStrDrawable;
    private float mTextSize;
    public int[] mValDisp;
    public int mValue;
    private boolean mVertical;
    public JPage page;
    private Paint paint;
    public Rect rec_seekBar;
    public Rect rec_thumb;
    public Rect rec_txtMax;
    public Rect rec_txtMin;
    public int szThumb;

    public JSeekBar(JPage page) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.bWillSetIconName = false;
        this.bClickDown = false;
        this.bCanSeekAble = true;
        this.bDrawMidTxt = false;
        this.mTextSize = 18.0f;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.szThumb = 0;
        this.mValue = 0;
        this.mMax = 1000000;
        this.hExtraTxt = 0;
        this.hExtraTxtBk = 0;
        this.hLine = 5;
        this.mVertical = false;
        this.mProgress = 0;
        this.mStep = 0.0f;
        this.mMin = -1;
        this.mMinDisp = 0;
        this.mPosMin = 0;
        this.mPosTarget = 0;
        this.mDrawables = new HashMap<>();
        this.page = page;
        calcStep();
        init();
    }

    public void setIconName(String[] iconNames) {
        this.iconNames = iconNames;
        if (iconNames != null) {
            if (this.bAttached) {
                this.drawable_seekbar = this.page.getDrawableFromPath(iconNames[0], this.page.mDrawables, null);
                this.drawable_seekbar_focus = this.page.getDrawableFromPath(iconNames[1], this.page.mDrawables, null);
                if (iconNames.length > 2) {
                    this.drawable_thumb = this.page.getDrawableFromPath(iconNames[2], this.page.mDrawables, null);
                }
                if (iconNames.length > 3) {
                    this.drawable_txtBk = this.page.getDrawableFromPath(iconNames[3], this.page.mDrawables, null);
                    return;
                }
                return;
            }
            this.bWillSetIconName = true;
        }
    }

    public void calcStep() {
        if (this.rec_seekBar != null) {
            this.mStep = (((this.rec_seekBar.right - this.rec_seekBar.left) - this.szThumb) * 1.0f) / this.mMax;
        }
    }

    public void setProgressMax(int max) {
        if (max > 0) {
            this.mMax = max;
            calcStep();
        }
    }

    public void setProgressMin(int min) {
        this.mMin = min;
        int posMin = (int) (min * this.mStep);
        if (this.mPosMin != posMin) {
            this.mPosMin = posMin;
            invalidate();
        }
    }

    public void setProgressMinDisp(int minDisp) {
        this.mMinDisp = minDisp;
    }

    public void setProgress(int progress) {
        int pos = this.mPosTarget;
        if (progress < 0) {
            pos = 0;
            progress = 0;
        }
        if (progress > this.mMax) {
            progress = this.mMax;
        }
        this.mProgress = progress;
        this.mValue = this.mProgress;
        if (this.mStep >= 0.0f) {
            pos = (int) (progress * this.mStep);
        }
        if (this.mPosTarget != pos) {
            this.mPosTarget = pos;
            invalidate();
        }
    }

    public void calcValue(int x, int y) {
        if (this.mVertical) {
            this.mValue = (int) (((double) (((this.rec_seekBar.bottom - this.rec_seekBar.top) - (y - this.rec_seekBar.top)) / this.mStep)) + 0.5d);
        } else {
            this.mValue = (int) (((double) ((x - this.rec_seekBar.left) / this.mStep)) + 0.5d);
        }
        if (this.mValue > this.mMax) {
            this.mValue = this.mMax;
        }
        if (this.mValue < 0) {
            this.mValue = 0;
        }
        setProgress(this.mValue);
    }

    public int getValue() {
        return this.mValue;
    }

    public Bitmap getBitmapFromDrawable(Drawable drawable, float scaleX, float scaleY) {
        if (drawable == null) {
            return null;
        }
        int w = (int) (drawable.getIntrinsicWidth() * scaleX);
        int h = (int) (drawable.getIntrinsicHeight() * scaleY);
        return FuncUtils.getBitmapFromDrawable(drawable, w, h);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w > 0 && h > 0) {
            super.onSizeChanged(w, h, oldw, oldh);
            if (this.drawable_seekbar != null) {
                if (this.drawable_seekbar.getIntrinsicWidth() < this.drawable_seekbar.getIntrinsicHeight()) {
                    this.mVertical = true;
                }
                this.mScaleX = ((this.rec_seekBar.right - this.rec_seekBar.left) * 1.0f) / this.drawable_seekbar.getIntrinsicWidth();
                this.mScaleY = ((this.rec_seekBar.bottom - this.rec_seekBar.top) * 1.0f) / this.drawable_seekbar.getIntrinsicHeight();
                this.bmp_seekbar = getBitmapFromDrawable(this.drawable_seekbar, this.mScaleX, this.mScaleY);
                this.bmp_seekbar_focus = getBitmapFromDrawable(this.drawable_seekbar_focus, this.mScaleX, this.mScaleY);
                this.bmp_thumb = getBitmapFromDrawable(this.drawable_thumb, this.mScaleX, this.mScaleY);
                this.bmp_txtBK = getBitmapFromDrawable(this.drawable_txtBk, this.page.ui.mScale, this.page.ui.mScale);
                if (this.mVertical) {
                    if (this.bmp_thumb != null) {
                        this.szThumb = this.bmp_thumb.getHeight();
                    }
                    this.mStep = (((this.rec_seekBar.bottom - this.rec_seekBar.top) - this.szThumb) * 1.0f) / this.mMax;
                } else {
                    if (this.bmp_thumb != null) {
                        this.szThumb = this.bmp_thumb.getWidth();
                    }
                    this.mStep = (((this.rec_seekBar.right - this.rec_seekBar.left) - this.szThumb) * 1.0f) / this.mMax;
                }
                this.mPosTarget = (int) (this.mProgress * this.mStep);
                this.mTextSize *= this.mScaleY;
                this.paint.setTextSize(this.mTextSize);
                this.fontMetrics = this.paint.getFontMetricsInt();
            }
        }
    }

    public void init() {
        this.paint = new Paint();
        this.paint.setSubpixelText(true);
        this.paint.setAntiAlias(true);
        this.paint.setFilterBitmap(true);
        this.paint.setTextAlign(Paint.Align.CENTER);
    }

    public void setTextSize(float textSize) {
        this.mTextSize = textSize;
    }

    public void setTextColor(int textColor) {
        this.paint.setColor(textColor);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.bmp_seekbar != null) {
            if (this.rec_txtMin != null && this.rec_txtMax != null) {
                int baseline = (this.rec_txtMin.top + ((((this.rec_txtMin.bottom - this.rec_txtMin.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2)) - this.fontMetrics.top;
                if (this.mValDisp != null && this.mValDisp.length > 0) {
                    int[] iArr = this.mValDisp;
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        int val = iArr[i2];
                        canvas.drawText(new StringBuilder().append(this.mMinDisp + val).toString(), this.rec_seekBar.left + ((int) (val * this.mStep)) + (this.szThumb / 2), baseline, this.paint);
                        int left = this.rec_seekBar.left + ((int) (val * this.mStep)) + (this.szThumb / 2);
                        int top = this.rec_txtMin.bottom;
                        canvas.drawRect(left, top, left + 2, this.hLine + top, this.paint);
                        i = i2 + 1;
                    }
                } else {
                    if (!this.mVertical) {
                        float textWidth = this.paint.measureText(new StringBuilder().append(this.mMinDisp).toString());
                        canvas.drawText(new StringBuilder().append(this.mMinDisp).toString(), this.rec_txtMin.left + (textWidth / 2.0f) + 5.0f, baseline, this.paint);
                    } else {
                        canvas.drawText(new StringBuilder().append(this.mMinDisp).toString(), this.rec_txtMin.centerX(), baseline, this.paint);
                    }
                    int baseline2 = (this.rec_txtMax.top + ((((this.rec_txtMax.bottom - this.rec_txtMax.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2)) - this.fontMetrics.top;
                    if (!this.mVertical) {
                        float textWidth2 = this.paint.measureText(new StringBuilder().append(this.mMax + this.mMinDisp).toString());
                        canvas.drawText(new StringBuilder().append(this.mMax + this.mMinDisp).toString(), (this.rec_txtMax.right - (textWidth2 / 2.0f)) - 5.0f, baseline2, this.paint);
                        if (this.bDrawMidTxt) {
                            float textWidth3 = this.paint.measureText(new StringBuilder().append((this.mMax / 2) + this.mMinDisp).toString());
                            canvas.drawText(new StringBuilder().append((this.mMax / 2) + this.mMinDisp).toString(), ((this.rec_txtMin.right + this.rec_txtMax.right) / 2) - (textWidth3 / 2.0f), baseline2, this.paint);
                        }
                    } else {
                        canvas.drawText(new StringBuilder().append(this.mMax + this.mMinDisp).toString(), this.rec_txtMax.centerX(), baseline2, this.paint);
                        if (this.bDrawMidTxt) {
                            canvas.drawText(new StringBuilder().append((this.mMax / 2) + this.mMinDisp).toString(), this.rec_txtMax.centerX(), (((this.rec_txtMax.top + this.rec_txtMin.top) / 2) + ((((this.rec_txtMax.bottom - this.rec_txtMax.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2)) - this.fontMetrics.top, this.paint);
                        }
                    }
                }
            }
            canvas.save();
            canvas.clipRect(this.rec_seekBar.left, this.rec_seekBar.top, this.rec_seekBar.right, this.rec_seekBar.bottom);
            canvas.drawBitmap(this.bmp_seekbar, this.rec_seekBar.left, this.rec_seekBar.top, this.paint);
            canvas.restore();
            canvas.save();
            if (this.mVertical) {
                if (this.mMin >= 0) {
                    int min = this.mPosMin;
                    int max = this.mPosTarget;
                    if (min > max) {
                        min = this.mPosTarget;
                        max = this.mPosMin;
                    }
                    canvas.clipRect(this.rec_seekBar.left, (this.rec_seekBar.bottom - max) - (this.szThumb / 2), this.rec_seekBar.right, (this.rec_seekBar.bottom - min) - (this.szThumb / 2));
                } else {
                    canvas.clipRect(this.rec_seekBar.left, (this.rec_seekBar.bottom - this.mPosTarget) - (this.szThumb / 2), this.rec_seekBar.right, this.rec_seekBar.bottom);
                }
            } else if (this.mMin >= 0) {
                int min2 = this.mPosMin;
                int max2 = this.mPosTarget;
                if (min2 > max2) {
                    min2 = this.mPosTarget;
                    max2 = this.mPosMin;
                }
                canvas.clipRect(this.rec_seekBar.left + min2 + (this.szThumb / 2), this.rec_seekBar.top, this.rec_seekBar.left + max2 + (this.szThumb / 2), this.rec_seekBar.bottom);
            } else {
                canvas.clipRect(this.rec_seekBar.left, this.rec_seekBar.top, this.rec_seekBar.left + this.mPosTarget + (this.szThumb / 2), this.rec_seekBar.bottom);
            }
            canvas.drawBitmap(this.bmp_seekbar_focus, this.rec_seekBar.left, this.rec_seekBar.top, this.paint);
            canvas.restore();
            canvas.save();
            if (this.mVertical) {
                if (this.bmp_thumb != null) {
                    canvas.drawBitmap(this.bmp_thumb, this.rec_thumb.left, (this.rec_seekBar.bottom - this.mPosTarget) - (this.rec_thumb.bottom - this.rec_thumb.top), this.paint);
                    if (this.mMin >= 0) {
                        canvas.drawBitmap(this.bmp_thumb, this.rec_thumb.left, (this.rec_seekBar.bottom - this.mPosMin) - (this.rec_thumb.bottom - this.rec_thumb.top), this.paint);
                    }
                }
                if (this.rec_txtMin != null) {
                    int iTopTxt = (this.rec_seekBar.bottom - this.mPosTarget) - (((this.szThumb + this.rec_txtMin.bottom) - this.rec_txtMin.top) / 2);
                    if (this.bmp_txtBK != null) {
                        canvas.drawBitmap(this.bmp_txtBK, this.rec_txtMin.left, iTopTxt, this.paint);
                    }
                    canvas.drawText(new StringBuilder().append(this.mProgress + this.mMinDisp).toString(), this.rec_txtMin.centerX(), (((((this.rec_txtMin.bottom - this.rec_txtMin.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2) + iTopTxt) - this.fontMetrics.top, this.paint);
                    if (this.mMin >= 0) {
                        canvas.drawText(new StringBuilder().append(this.mMin + this.mMinDisp).toString(), this.rec_txtMin.centerX(), (((((this.rec_txtMin.bottom - this.rec_txtMin.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2) + ((this.rec_seekBar.bottom - this.mPosMin) - (((this.szThumb + this.rec_txtMin.bottom) - this.rec_txtMin.top) / 2))) - this.fontMetrics.top, this.paint);
                    }
                }
            } else {
                if (this.bmp_thumb != null) {
                    canvas.drawBitmap(this.bmp_thumb, this.rec_seekBar.left + this.mPosTarget, this.rec_thumb.top, this.paint);
                    if (this.mMin >= 0) {
                        canvas.drawBitmap(this.bmp_thumb, this.rec_seekBar.left + this.mPosMin, this.rec_thumb.top, this.paint);
                    }
                }
                if (this.rec_txtMin != null) {
                    if (this.bmp_txtBK != null) {
                        canvas.drawBitmap(this.bmp_txtBK, this.rec_seekBar.left + this.mPosTarget + ((this.szThumb - this.rec_txtMin.width()) / 2), this.rec_txtMin.top + this.hExtraTxtBk, this.paint);
                        if (this.mMin >= 0) {
                            canvas.drawBitmap(this.bmp_txtBK, this.rec_seekBar.left + this.mPosMin + ((this.szThumb - this.rec_txtMin.width()) / 2), this.rec_txtMin.top + this.hExtraTxtBk, this.paint);
                        }
                    }
                    int baseline3 = ((this.rec_txtMin.top + this.hExtraTxt) + ((((this.rec_txtMin.bottom - this.rec_txtMin.top) - this.fontMetrics.bottom) + this.fontMetrics.top) / 2)) - this.fontMetrics.top;
                    canvas.drawText(new StringBuilder().append(this.mProgress + this.mMinDisp).toString(), this.rec_seekBar.left + this.mPosTarget + (this.szThumb / 2), baseline3, this.paint);
                    if (this.mMin >= 0) {
                        canvas.drawText(new StringBuilder().append(this.mMin + this.mMinDisp).toString(), this.rec_seekBar.left + this.mPosMin + (this.szThumb / 2), baseline3, this.paint);
                    }
                }
            }
            canvas.restore();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.bCanSeekAble) {
            return super.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                this.bClickDown = true;
                calcValue(x, y);
                IPageNotify pageNotify = this.page.getNotify();
                if (pageNotify == null) {
                    return true;
                }
                pageNotify.ResponseClick(this);
                return true;
            case 1:
            case 3:
                this.bClickDown = false;
                calcValue(x, y);
                IPageNotify pageNotify2 = this.page.getNotify();
                if (pageNotify2 == null) {
                    return true;
                }
                pageNotify2.ResponseClick(this);
                return true;
            case 2:
                if (!this.bClickDown) {
                    return true;
                }
                calcValue(x, y);
                IPageNotify pageNotify3 = this.page.getNotify();
                if (pageNotify3 == null) {
                    return true;
                }
                pageNotify3.ResponseClick(this);
                return true;
            default:
                return true;
        }
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
        if (this.bWillSetIconName) {
            this.bWillSetIconName = false;
            setIconName(this.iconNames);
        }
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.bAttached = false;
        super.onDetachedFromWindow();
    }
}
