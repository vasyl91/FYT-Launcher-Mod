package com.lsec.core.frame.ctrl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.util.FuncUtils;
import com.lsec.core.util.UiNotifyEvent;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JSwitchButton extends View {
    public static final int ANIMATION_FRAME_DURATION = 16;
    public static final int MAX_ALPHA = 255;
    public static final float VELOCITY = 1000.0f;
    boolean bAttached;
    public boolean bFocusAble;
    public boolean bIsCheckBox;
    public boolean bStateClickDown;
    boolean bWillSetIconName;
    boolean bWillUpdateBackground;
    Drawable[] drawable;
    Drawable drawable_Bk;
    Drawable drawable_Bottom;
    Drawable drawable_Frame;
    Drawable drawable_Mask;
    Drawable drawable_Normal;
    int iState;
    String[] iconNames;
    private int mAlpha;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private float mAnimationPosition;
    private Bitmap mBk;
    private Bitmap mBottom;
    private float mBtnInitPos;
    private Bitmap mBtnNormal;
    private float mBtnOffPos;
    private float mBtnOnPos;
    private float mBtnPos;
    private float mBtnWidth;
    private boolean mChecked;
    private int mClickTimeout;
    public HashMap<String, Drawable> mDrawables;
    private float mFirstDownX;
    private float mFirstDownY;
    private Bitmap mFrame;
    private boolean mIsConditionSwitch;
    private Bitmap mMask;
    private float mMaskWidth;
    private Paint mPaint;
    private PerformClick mPerformClick;
    private float mRealPos;
    private RectF mSaveLayerRectF;
    private float mScaleX;
    private float mScaleY;
    String mStrDrawable;
    String mStrDrawableFix;
    private int mTouchSlop;
    private boolean mTurningOn;
    private float mVelocity;
    private PorterDuffXfermode mXfermode;
    private JPage page;
    Paint paint;
    int[] paras;

    public JSwitchButton(JPage page, boolean bIsCheckBox) {
        super(page.ui.mContext);
        this.bAttached = false;
        this.bWillUpdateBackground = false;
        this.bWillSetIconName = false;
        this.iState = -1;
        this.mAlpha = 255;
        this.mChecked = false;
        this.mIsConditionSwitch = false;
        this.mScaleX = 1.0f;
        this.mScaleY = 1.0f;
        this.mDrawables = new HashMap<>();
        this.page = page;
        this.bIsCheckBox = bIsCheckBox;
        initView(page.ui.mContext);
        this.paint = new Paint();
        this.paint.setColor(-256);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(4.0f);
    }

    public Bitmap getBitmapFromDrawable(Drawable drawable) {
        int w = (int) (drawable.getIntrinsicWidth() * this.mScaleX);
        int h = (int) (drawable.getIntrinsicHeight() * this.mScaleY);
        return FuncUtils.getBitmapFromDrawable(drawable, w, h);
    }

    private void initView(Context context) {
        this.mPaint = new Paint();
        this.mPaint.setColor(-1);
        this.mClickTimeout = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mVelocity = (int) ((1000.0f * FuncUtils.mDispayMetrics.density) + 0.5f);
    }

    @Override // android.view.View
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        if (this.bIsCheckBox) {
            updateBackground();
        }
    }

    public void setParas(int[] paras) {
        this.paras = paras;
    }

    public void setIconName(String[] iconNames) {
        this.iconNames = iconNames;
        if (iconNames != null) {
            if (this.bAttached) {
                if (this.bIsCheckBox) {
                    this.drawable = new Drawable[2];
                    int i = 0;
                    for (String icon : iconNames) {
                        if (i > 1) {
                            break;
                        }
                        this.drawable[i] = this.page.getDrawableFromPath(icon, this.page.mDrawables, null);
                        i++;
                    }
                    invalidate();
                    return;
                }
                this.drawable_Bottom = this.page.getDrawableFromPath(iconNames[0], this.page.mDrawables, null);
                this.drawable_Normal = this.page.getDrawableFromPath(iconNames[1], this.page.mDrawables, null);
                this.drawable_Frame = this.page.getDrawableFromPath(iconNames[2], this.page.mDrawables, null);
                this.drawable_Mask = this.page.getDrawableFromPath(iconNames[3], this.page.mDrawables, null);
                if (iconNames.length > 4) {
                    this.drawable_Bk = this.page.getDrawableFromPath(iconNames[4], this.page.mDrawables, null);
                    return;
                }
                return;
            }
            this.bWillSetIconName = true;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (enabled) {
            setFocusable(true);
        } else {
            setFocusable(false);
        }
        this.mAlpha = enabled ? 255 : 127;
        super.setEnabled(enabled);
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setCondition(boolean bConditon) {
        this.mIsConditionSwitch = bConditon;
    }

    private class RunnableSetChecked implements Runnable {
        private boolean checked;
        private View v;

        public RunnableSetChecked(View v, boolean checked) {
            this.v = v;
            this.checked = checked;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (JSwitchButton.this.mChecked != this.checked) {
                JSwitchButton.this.setChecked(this.checked);
                IPageNotify pageNotify = JSwitchButton.this.page.getNotify();
                if (pageNotify != null) {
                    pageNotify.ResponseClick(this.v);
                }
            }
        }
    }

    private void setCheckedDelayed(boolean checked) {
        UiNotifyEvent.HANDLER_UI.postDelayed(new RunnableSetChecked(this, checked), 10L);
    }

    public void setChecked(boolean checked) {
        if (this.mChecked != checked) {
            this.mChecked = checked;
            if (!this.bIsCheckBox) {
                this.mBtnPos = checked ? this.mBtnOnPos : this.mBtnOffPos;
                this.mRealPos = getRealPos(this.mBtnPos);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.bIsCheckBox) {
            int action = event.getAction();
            switch (action) {
                case 0:
                    if (!this.bStateClickDown) {
                        this.bStateClickDown = true;
                        updateBackground();
                    }
                    break;
                case 1:
                case 3:
                    if (this.bStateClickDown) {
                        this.bStateClickDown = false;
                        updateBackground();
                    }
                    break;
            }
            if (this.mIsConditionSwitch) {
                switch (action) {
                    case 1:
                        IPageNotify pageNotify = this.page.getNotify();
                        if (pageNotify != null) {
                            pageNotify.ResponseClick(this);
                        }
                        break;
                }
                return isEnabled();
            }
            float x = event.getX();
            float y = event.getY();
            float deltaX = Math.abs(x - this.mFirstDownX);
            float deltaY = Math.abs(y - this.mFirstDownY);
            switch (action) {
                case 0:
                    this.mFirstDownX = x;
                    this.mFirstDownY = y;
                    this.mBtnInitPos = this.mChecked ? this.mBtnOnPos : this.mBtnOffPos;
                    break;
                case 1:
                case 3:
                    float time = event.getEventTime() - event.getDownTime();
                    if (deltaY < this.mTouchSlop && deltaX < this.mTouchSlop && time < this.mClickTimeout) {
                        if (this.mPerformClick == null) {
                            this.mPerformClick = new PerformClick(this, null);
                        }
                        if (!post(this.mPerformClick)) {
                            performClick();
                        }
                    } else {
                        startAnimation(this.mTurningOn ? false : true);
                    }
                    break;
                case 2:
                    this.mBtnPos = (this.mBtnInitPos + event.getX()) - this.mFirstDownX;
                    if (this.mBtnPos >= this.mBtnOnPos) {
                        this.mBtnPos = this.mBtnOnPos;
                    }
                    if (this.mBtnPos <= this.mBtnOffPos) {
                        this.mBtnPos = this.mBtnOffPos;
                    }
                    this.mTurningOn = this.mBtnPos > ((this.mBtnOnPos - this.mBtnOffPos) / 2.0f) + this.mBtnOffPos;
                    this.mRealPos = getRealPos(this.mBtnPos);
                    break;
            }
            invalidate();
            return isEnabled();
        }
        return super.onTouchEvent(event);
    }

    private class PerformClick implements Runnable {
        private PerformClick() {
        }

        /* synthetic */ PerformClick(JSwitchButton jSwitchButton, PerformClick performClick) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            JSwitchButton.this.performClick();
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.bIsCheckBox) {
            return super.performClick();
        }
        startAnimation(this.mChecked);
        return true;
    }

    private float getRealPos(float btnPos) {
        return btnPos - (this.mBtnWidth / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.bIsCheckBox) {
            if (this.drawable != null && this.drawable.length > 0) {
                Drawable d = this.drawable[this.mChecked ? (char) 1 : (char) 0];
                if (d != null) {
                    int w = d.getIntrinsicWidth();
                    int h = d.getIntrinsicHeight();
                    if (this.paras != null && this.paras.length == 2) {
                        w = this.paras[0];
                        h = this.paras[1];
                    }
                    d.setBounds(0, 0, w, h);
                    MyUiItem item = (MyUiItem) getTag();
                    Rect[] rec = item.getRect();
                    if (rec != null && rec.length >= 1) {
                        super.onDraw(canvas);
                        canvas.save();
                        canvas.translate(rec[0].left, (getHeight() - this.page.ui.getFixValue(h, true)) / 2);
                        canvas.scale(this.page.ui.mScale, this.page.ui.mScale);
                        d.draw(canvas);
                        canvas.restore();
                    } else {
                        canvas.save();
                        canvas.translate(this.page.ui.getFixValue(w + 5, true), 0.0f);
                        super.onDraw(canvas);
                        canvas.restore();
                        canvas.save();
                        canvas.translate(0.0f, (getHeight() - this.page.ui.getFixValue(h, true)) / 2);
                        canvas.scale(this.page.ui.mScale, this.page.ui.mScale);
                        d.draw(canvas);
                        canvas.restore();
                    }
                } else {
                    return;
                }
            }
        } else if (this.mXfermode != null) {
            super.onDraw(canvas);
            if (this.mBk != null) {
                canvas.drawBitmap(this.mBk, 0.0f, 0.0f, this.mPaint);
            }
            canvas.saveLayerAlpha(this.mSaveLayerRectF, this.mAlpha, 31);
            canvas.drawBitmap(this.mMask, this.mSaveLayerRectF.left, this.mSaveLayerRectF.top, this.mPaint);
            this.mPaint.setXfermode(this.mXfermode);
            canvas.drawBitmap(this.mBottom, this.mSaveLayerRectF.left + this.mRealPos, this.mSaveLayerRectF.top, this.mPaint);
            this.mPaint.setXfermode(null);
            canvas.drawBitmap(this.mFrame, this.mSaveLayerRectF.left, this.mSaveLayerRectF.top, this.mPaint);
            canvas.drawBitmap(this.mBtnNormal, this.mSaveLayerRectF.left + this.mRealPos, this.mSaveLayerRectF.top, this.mPaint);
            canvas.restore();
        } else {
            return;
        }
        if (isFocused()) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (this.bIsCheckBox) {
            super.onSizeChanged(w, h, oldw, oldh);
            return;
        }
        if (w > 0 && h > 0 && this.drawable_Mask != null) {
            if (this.drawable_Bk != null) {
                this.mScaleX = (w * 1.0f) / this.drawable_Bk.getIntrinsicWidth();
                this.mScaleY = (h * 1.0f) / this.drawable_Bk.getIntrinsicHeight();
            } else {
                this.mScaleX = (w * 1.0f) / this.drawable_Mask.getIntrinsicWidth();
                this.mScaleY = (h * 1.0f) / this.drawable_Mask.getIntrinsicHeight();
            }
            if (this.drawable_Bk != null) {
                this.mBk = getBitmapFromDrawable(this.drawable_Bk);
            }
            this.mBottom = getBitmapFromDrawable(this.drawable_Bottom);
            this.mBtnNormal = getBitmapFromDrawable(this.drawable_Normal);
            this.mFrame = getBitmapFromDrawable(this.drawable_Frame);
            this.mMask = getBitmapFromDrawable(this.drawable_Mask);
            this.mBtnWidth = this.mBtnNormal.getWidth();
            this.mMaskWidth = this.mMask.getWidth();
            this.mBtnOffPos = this.mMaskWidth - (this.mBtnWidth / 2.0f);
            this.mBtnOnPos = this.mBtnWidth / 2.0f;
            this.mBtnPos = this.mChecked ? this.mBtnOnPos : this.mBtnOffPos;
            this.mRealPos = getRealPos(this.mBtnPos);
            int xSave = 0;
            int ySave = 0;
            if (this.mBk != null) {
                xSave = ((this.mBk.getWidth() - this.mMask.getWidth()) + 1) / 2;
                ySave = ((this.mBk.getHeight() - this.mMask.getHeight()) + 1) / 2;
            }
            this.mSaveLayerRectF = new RectF(xSave, ySave, this.mMask.getWidth() + xSave, this.mMask.getHeight() + ySave);
            this.mXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        }
    }

    private void startAnimation(boolean turnOn) {
        this.mAnimating = true;
        this.mAnimatedVelocity = turnOn ? -this.mVelocity : this.mVelocity;
        this.mAnimationPosition = this.mBtnPos;
        new SwitchAnimation(this, null).run();
    }

    private void stopAnimation() {
        this.mAnimating = false;
    }

    private class SwitchAnimation implements Runnable {
        private SwitchAnimation() {
        }

        /* synthetic */ SwitchAnimation(JSwitchButton jSwitchButton, SwitchAnimation switchAnimation) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!JSwitchButton.this.mAnimating) {
                return;
            }
            JSwitchButton.this.doAnimation();
            Main.postRunnable_Ui(true, this, 16L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAnimation() {
        this.mAnimationPosition += (this.mAnimatedVelocity * 16.0f) / 1000.0f;
        if (this.mAnimationPosition <= this.mBtnOffPos) {
            stopAnimation();
            this.mAnimationPosition = this.mBtnOffPos;
            setCheckedDelayed(false);
        } else if (this.mAnimationPosition >= this.mBtnOnPos) {
            stopAnimation();
            this.mAnimationPosition = this.mBtnOnPos;
            setCheckedDelayed(true);
        }
        moveView(this.mAnimationPosition);
    }

    private void moveView(float position) {
        this.mBtnPos = position;
        this.mRealPos = getRealPos(this.mBtnPos);
        invalidate();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
        invalidate();
    }

    public void setStrDrawable(String drawable, boolean bUpdateBk) {
        this.iState = -1;
        this.bWillUpdateBackground = true;
        this.mStrDrawable = drawable;
        if (bUpdateBk || isFocused()) {
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
        int iStateBak = this.iState;
        if (this.bStateClickDown || isPressed() || (this.bFocusAble && isFocused())) {
            this.iState = 1;
        } else {
            this.iState = 0;
        }
        if (iStateBak != this.iState && this.mStrDrawable != null) {
            this.mStrDrawableFix = this.mStrDrawable;
            switch (this.iState) {
                case 1:
                    this.mStrDrawableFix = String.valueOf(this.mStrDrawableFix) + "_p";
                    break;
            }
            Drawable drawable = this.page.getDrawableFromPath(this.mStrDrawableFix, this.page.mDrawables, this.mDrawables);
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
