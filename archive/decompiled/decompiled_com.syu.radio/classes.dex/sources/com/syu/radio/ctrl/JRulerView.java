package com.syu.radio.ctrl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.internal.view.SupportMenu;
import android.view.MotionEvent;
import android.view.View;
import com.lsec.core.frame.ctrl.JPage;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JRulerView extends View {
    public static int mClrDraw = -15329744;
    private Act_Radio actRadio;
    int mDispMin;
    private int mHeight;
    private int mLastX;
    private float mLineMaxHeight;
    private float mLineMidHeight;
    private float mLineMinHeight;
    private Paint mLinePaint;
    private float mLineSpaceWidth;
    private float mLineWidth;
    private OnValueChangeListener mListener;
    private int mMaxOffset;
    private float mMaxValue;
    private float mMinValue;
    private int mMove;
    private float mOffset;
    private float mPerValue;
    private float mSelectorValue;
    private boolean mSlideFreq;
    int mStepCnt;
    int mStepLen;
    private float mTextHeight;
    private float mTextMarginTop;
    private Paint mTextPaint;
    private float mTextSize;
    private int mTotalLine;
    private int mWidth;
    public JPage page;

    public interface OnValueChangeListener {
        void onValueChange(float f);
    }

    public JRulerView(Act_Radio actRadio, JPage page) {
        super(page.ui.mContext, null, 0);
        this.mDispMin = 0;
        this.mSelectorValue = 0.0f;
        this.mMaxValue = 100.0f;
        this.mMinValue = 0.0f;
        this.mPerValue = 1.0f;
        this.mLineSpaceWidth = 6.0f;
        this.mLineWidth = 1.0f;
        this.mLineMaxHeight = 18.0f;
        this.mLineMidHeight = 12.0f;
        this.mLineMinHeight = 6.0f;
        this.mTextMarginTop = 0.0f;
        this.mTextSize = 14.0f;
        this.mSlideFreq = false;
        this.actRadio = actRadio;
        this.page = page;
    }

    public void init(int clrDraw, int lineSpaceWidth, int lineWidth, int lineMaxHeight, int lineMidHeight, int lineMinHeight, int textSize) {
        mClrDraw = clrDraw;
        this.mLineSpaceWidth = lineSpaceWidth;
        this.mLineWidth = lineWidth;
        this.mLineMaxHeight = lineMaxHeight;
        this.mLineMidHeight = lineMidHeight;
        this.mLineMinHeight = lineMinHeight;
        this.mTextSize = textSize;
        this.mSelectorValue = 0.0f;
        this.mMinValue = 0.0f;
        this.mMaxValue = 100.0f;
        this.mPerValue = 0.1f;
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mTextPaint.setColor(mClrDraw);
        this.mTextHeight = getFontHeight(this.mTextPaint);
        this.mLinePaint = new Paint(1);
        this.mLinePaint.setStrokeWidth(this.mLineWidth);
        this.mLinePaint.setColor(mClrDraw);
        setValue(this.mSelectorValue, this.mMinValue, this.mMaxValue, this.mPerValue);
    }

    private float getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    public void setTextColor(int color) {
        this.mTextPaint.setColor(color);
        invalidate();
    }

    public void setTextSize(float textSize) {
        this.mTextPaint.setTextSize(textSize);
        invalidate();
    }

    public void setTextMarginTop(float marginTop) {
        this.mTextMarginTop = marginTop;
        invalidate();
    }

    public void setLineColor(int color) {
        this.mLinePaint.setColor(color);
        invalidate();
    }

    public void setLineWidth(float width) {
        this.mLineWidth = width;
        invalidate();
    }

    public void setLineSpaceWidth(float width) {
        this.mLineSpaceWidth = width;
        invalidate();
    }

    public void setLineMinHeight(float height) {
        this.mLineMinHeight = height;
        invalidate();
    }

    public void setLineMidHeight(float height) {
        this.mLineMidHeight = height;
        invalidate();
    }

    public void setLineMaxHeight(float height) {
        this.mLineMaxHeight = height;
        invalidate();
    }

    public void setValue(float selectorValue, float minValue, float maxValue, float per) {
        this.mSelectorValue = selectorValue;
        if (maxValue >= 0.0f) {
            this.mMaxValue = maxValue;
        }
        if (minValue >= 0.0f) {
            this.mMinValue = minValue;
        }
        if (per >= 0.0f) {
            this.mPerValue = (int) (per * 10.0f);
        }
        this.mTotalLine = ((int) (((this.mMaxValue * 10.0f) - (this.mMinValue * 10.0f)) / this.mPerValue)) + 1;
        this.mMaxOffset = (int) ((-(this.mTotalLine - 1)) * this.mLineSpaceWidth);
        this.mOffset = ((this.mMinValue - this.mSelectorValue) / this.mPerValue) * this.mLineSpaceWidth * 10.0f;
        invalidate();
        setVisibility(0);
    }

    public void setOnValueChangeListener(OnValueChangeListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w > 0 && h > 0) {
            this.mWidth = w;
            this.mHeight = h;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float height;
        String value;
        super.onDraw(canvas);
        if (this.mLinePaint != null) {
            int srcPointX = this.mWidth / 2;
            float Min_Val = this.mMinValue;
            float Max_Val = this.mMaxValue;
            float Total_Line = this.mTotalLine;
            float Off_Set = this.mOffset;
            if (Min_Val >= 7000.0f) {
                if (App_Radio.iRadioType_Arm > 0) {
                    Min_Val -= 600.0f;
                    float f = Max_Val + 600.0f;
                    Total_Line += 1200.0f;
                    Off_Set -= 60.0f * this.mLineSpaceWidth;
                } else {
                    Min_Val -= 300.0f;
                    float f2 = Max_Val + 300.0f;
                    Total_Line += 600.0f;
                    Off_Set -= 60.0f * this.mLineSpaceWidth;
                }
            } else if (Min_Val >= 500.0f) {
                Min_Val -= 540.0f;
                float f3 = Max_Val + 540.0f;
                Total_Line += 1080.0f;
                Off_Set -= 60.0f * this.mLineSpaceWidth;
            }
            for (int i = 0; i < Total_Line; i++) {
                float left = srcPointX + Off_Set + (i * this.mLineSpaceWidth);
                if (left >= 0.0f && left <= this.mWidth) {
                    int iMaxHeightStep = 10;
                    if (App_Radio.iRadioType_Arm > 0) {
                        iMaxHeightStep = 15;
                    }
                    if ((i % iMaxHeightStep == 0 && i + 10 <= Total_Line) || i + 1 == Total_Line) {
                        height = this.mLineMaxHeight;
                    } else if (i % 5 == 0) {
                        height = this.mLineMidHeight;
                    } else {
                        height = this.mLineMinHeight;
                    }
                    this.mLinePaint.setColor(mClrDraw);
                    canvas.drawLine(left, this.mHeight - height, left, this.mHeight, this.mLinePaint);
                    if (height == this.mLineMaxHeight) {
                        int val = (int) (((i * this.mPerValue) / 10.0f) + Min_Val);
                        if (val < 5000) {
                            value = String.valueOf(val);
                        } else {
                            value = String.format(Locale.US, "%02d.%02d", Integer.valueOf(val / 100), Integer.valueOf(val % 100));
                        }
                        canvas.drawText(value, left - (this.mTextPaint.measureText(value) / 2.0f), this.mTextMarginTop + this.mTextHeight, this.mTextPaint);
                    }
                }
            }
            this.mLinePaint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawLine(srcPointX - 1, this.mHeight - this.mLineMaxHeight, srcPointX - 1, this.mHeight, this.mLinePaint);
            canvas.drawLine(srcPointX, this.mHeight - this.mLineMaxHeight, srcPointX, this.mHeight, this.mLinePaint);
            canvas.drawLine(srcPointX + 1, this.mHeight - this.mLineMaxHeight, srcPointX + 1, this.mHeight, this.mLinePaint);
        }
    }

    public boolean isAdjusting() {
        return this.mSlideFreq;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int xPosition = (int) event.getX();
        switch (action) {
            case 0:
                this.mSlideFreq = true;
                this.mLastX = xPosition;
                this.mMove = 0;
                invalidate();
                break;
            case 1:
            case 3:
                countMoveEnd();
                if (!this.mSlideFreq) {
                    return false;
                }
                this.mSlideFreq = false;
                notifyValueChange();
                return false;
            case 2:
                this.mMove = this.mLastX - xPosition;
                changeMoveAndValue();
                break;
        }
        this.mLastX = xPosition;
        return true;
    }

    private void countMoveEnd() {
        this.mOffset -= this.mMove;
        if (this.mOffset <= this.mMaxOffset) {
            this.mOffset = this.mMaxOffset;
        } else if (this.mOffset >= 0.0f) {
            this.mOffset = 0.0f;
        }
        this.mLastX = 0;
        this.mMove = 0;
        this.mSelectorValue = this.mMinValue + ((Math.round((Math.abs(this.mOffset) * 1.0f) / this.mLineSpaceWidth) * this.mPerValue) / 10.0f);
        this.mOffset = (((this.mMinValue - this.mSelectorValue) * 10.0f) / this.mPerValue) * this.mLineSpaceWidth;
        postInvalidate();
    }

    private void changeMoveAndValue() {
        this.mOffset -= this.mMove;
        if (this.mOffset <= this.mMaxOffset) {
            this.mOffset = this.mMaxOffset;
            this.mMove = 0;
        } else if (this.mOffset >= 0.0f) {
            this.mOffset = 0.0f;
            this.mMove = 0;
        }
        this.mSelectorValue = this.mMinValue + ((Math.round((Math.abs(this.mOffset) * 1.0f) / this.mLineSpaceWidth) * this.mPerValue) / 10.0f);
        if (this.actRadio.mInterfacePageRadio != null) {
            this.actRadio.mInterfacePageRadio.updateCurrentFreq((int) this.mSelectorValue, false);
        }
        postInvalidate();
    }

    private void notifyValueChange() {
        if (this.mListener != null) {
            this.mListener.onValueChange(this.mSelectorValue);
        }
    }

    public void setup(float curVal, int min, int max, int stepLen) {
        setValue(curVal, min, max, stepLen);
    }
}
