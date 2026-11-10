package com.syu.radio.ctrl;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.android.volley.DefaultRetryPolicy;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.util.data.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSwitchButon2 extends View implements View.OnClickListener {
    final int MAX_VELOCITYX;
    final int MIN_FLING;
    boolean isChang;
    boolean isFling;
    float mDisx;
    float mDownx;
    float mDowny;
    GestureDetector.SimpleOnGestureListener mGenericMotionListener;
    GestureDetectorCompat mGestureDetector;
    float mLastX;
    float mLastY;
    OnSwitchStateLisenter mLisenter;
    Rect mSliderRect;
    boolean mSwitch;
    int mSwitchHeight;
    Drawable mSwitchOff;
    Drawable mSwitchOn;
    Drawable mSwitchSlider;
    int mSwitchWidth;
    int maxMoveLen;
    boolean moved;
    int[] realSize;
    String tag;

    public interface OnSwitchStateLisenter {
        void onSwitchOff();

        void onSwitchOn();
    }

    public JSwitchButon2(JPage page, MyUiItem item) {
        super(page.ui.mContext);
        this.mSwitch = false;
        this.realSize = new int[6];
        this.isChang = true;
        this.moved = false;
        this.tag = FinalChip.BSP_PLATFORM_Null;
        this.MIN_FLING = 8;
        this.MAX_VELOCITYX = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        this.mGenericMotionListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.syu.radio.ctrl.JSwitchButon2.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (Math.abs(e1.getX() - e2.getX()) > 8.0f && Math.abs(velocityX) < 2500.0f) {
                    JSwitchButon2.this.isFling = true;
                }
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                JSwitchButon2.this.isFling = false;
                return super.onDown(e);
            }
        };
        Drawable pointer = null;
        Drawable on = null;
        Drawable off = null;
        if (item.getPara() != null && item.getPara().length > 5) {
            this.realSize[0] = item.getPara()[0];
            this.realSize[1] = item.getPara()[1];
            this.realSize[2] = item.getPara()[2];
            this.realSize[3] = item.getPara()[3];
            this.realSize[4] = item.getPara()[4];
            this.realSize[5] = item.getPara()[5];
        }
        if (item.getStrDrawableExtra() != null) {
            pointer = page.getDrawableFromPath(item.getStrDrawableExtra()[0], page.mDrawables, null);
            if (item.getStrDrawableExtra().length > 1) {
                on = page.getDrawableFromPath(item.getStrDrawableExtra()[1].trim(), page.mDrawables, null);
                off = page.getDrawableFromPath(item.getStrDrawableExtra()[2].trim(), page.mDrawables, null);
            }
        }
        if (pointer != null) {
            this.mSwitchSlider = pointer;
        }
        if (on != null) {
            this.mSwitchOn = on;
        }
        if (off != null) {
            this.mSwitchOff = off;
        }
        if (this.mSwitchOff != null) {
            if (this.realSize != null && this.realSize[2] > 0) {
                this.mSwitchWidth = this.realSize[2];
            } else {
                this.mSwitchWidth = this.mSwitchOff.getIntrinsicWidth();
            }
        }
        if (this.mSwitchOn != null) {
            if (this.realSize != null && this.realSize[5] > 0) {
                this.mSwitchHeight = this.realSize[5];
            } else {
                this.mSwitchHeight = this.mSwitchOn.getIntrinsicHeight();
            }
        }
        if (this.mSwitchSlider != null) {
            if (this.realSize != null && this.realSize[0] > 0) {
                this.maxMoveLen = this.mSwitchWidth - this.realSize[0];
            } else {
                this.maxMoveLen = this.mSwitchWidth - this.mSwitchSlider.getIntrinsicWidth();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        this.mDisx = this.mSwitch ? -this.maxMoveLen : this.maxMoveLen;
        this.mSwitch = !this.mSwitch;
        if (this.mLisenter != null) {
            if (this.mSwitch) {
                this.mLisenter.onSwitchOn();
            } else {
                this.mLisenter.onSwitchOff();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setOnClickListener(this);
        this.mGestureDetector = new GestureDetectorCompat(getContext(), this.mGenericMotionListener);
        if (this.mLisenter == null) {
            this.mLisenter = new OnSwitchStateLisenter() { // from class: com.syu.radio.ctrl.JSwitchButon2.2
                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOff() {
                }

                @Override // com.syu.radio.ctrl.JSwitchButon2.OnSwitchStateLisenter
                public void onSwitchOn() {
                }
            };
        }
    }

    public String getSwitchTag() {
        return this.tag;
    }

    public void setSwitchBk(String tag, Drawable on, Drawable off) {
        this.tag = tag;
        if (on != null) {
            this.mSwitchOn = on;
        }
        if (off != null) {
            this.mSwitchOff = off;
        }
        invalidate();
    }

    public void setSwitch(boolean mSwitch) {
        if (mSwitch != this.mSwitch) {
            this.mSwitch = mSwitch;
            this.mDisx = mSwitch ? this.maxMoveLen : -this.maxMoveLen;
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        float hScale = 1.0f;
        float vScale = 1.0f;
        if (widthMode != 0 && widthSize < this.mSwitchWidth) {
            hScale = widthSize / this.mSwitchWidth;
        }
        if (heightMode != 0 && heightSize < this.mSwitchHeight) {
            vScale = heightSize / this.mSwitchHeight;
        }
        float scale = Math.min(hScale, vScale);
        setMeasuredDimension(resolveSizeAndState((int) (this.mSwitchWidth * scale), widthMeasureSpec, 0), resolveSizeAndState((int) (this.mSwitchHeight * scale), heightMeasureSpec, 0));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean changed = this.isChang;
        if (changed) {
            this.isChang = false;
        }
        int availableWidth = getRight() - getLeft();
        int availableHeight = getBottom() - getTop();
        int x = availableWidth / 2;
        int y = availableHeight / 2;
        Drawable mDial = this.mSwitch ? this.mSwitchOn : this.mSwitchOff;
        int w = mDial.getIntrinsicWidth();
        int h = mDial.getIntrinsicHeight();
        if (this.realSize != null && this.realSize[2] > 0 && this.realSize[3] > 0 && this.realSize[4] > 0 && this.realSize[5] > 0) {
            w = this.mSwitch ? this.realSize[4] : this.realSize[2];
            h = this.mSwitch ? this.realSize[5] : this.realSize[3];
        }
        boolean scaled = false;
        float sDisx = this.mDisx;
        if (availableWidth < w || availableHeight < h) {
            scaled = true;
            float scale = Math.min(availableWidth / w, availableHeight / h);
            canvas.save();
            canvas.scale(scale, scale, x, y);
            sDisx /= scale;
        }
        mDial.setBounds(x - (w / 2), y - (h / 2), (w / 2) + x, (h / 2) + y);
        mDial.draw(canvas);
        canvas.save();
        Drawable slider = this.mSwitchSlider;
        int sw = slider.getIntrinsicWidth();
        if (this.realSize != null && this.realSize[0] > 0) {
            sw = this.realSize[0];
        }
        if (this.mSliderRect == null) {
            this.mSliderRect = new Rect(x - (w / 2), y - (h / 2), (x - (w / 2)) + sw, (h / 2) + y);
        }
        if (this.mDisx != 0.0f) {
            int left = Math.min(((w / 2) + x) - sw, Math.max(x - (w / 2), (int) (this.mSliderRect.left + sDisx)));
            int right = left + sw;
            this.mSliderRect.set(left, y - (h / 2), Math.min(right, (w / 2) + x), (h / 2) + y);
        }
        slider.setBounds(this.mSliderRect);
        slider.draw(canvas);
        canvas.restore();
        if (scaled) {
            canvas.restore();
        }
    }

    public void setOnSwitchStateLisenter(OnSwitchStateLisenter mLisenter) {
        this.mLisenter = mLisenter;
    }
}
