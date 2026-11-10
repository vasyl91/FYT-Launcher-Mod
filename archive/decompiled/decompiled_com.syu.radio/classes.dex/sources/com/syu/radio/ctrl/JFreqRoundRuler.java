package com.syu.radio.ctrl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.Act_Radio;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JFreqRoundRuler extends View {
    private static final float ANGLE_DISTANCE = 256.0f;
    private static final float ANGLE_MAX = 400.0f;
    private static final float ANGLE_MIN = 144.0f;
    private Act_Radio actRadio;
    private boolean bRotateFlag;
    public Drawable drawable;
    private float mAngle;
    private float mAngleTarget;
    private float mAngleTouch;
    private long mDrawingTime;
    private int mFreq;
    private int mFreqMax;
    private int mFreqMin;
    public int mFreqShouldBe;
    private int mFreqStep;
    private String mMaxFreqText;
    private int mMaxFreqTxtHeight;
    private int mMaxFreqTxtWidth;
    private String mMinFreqText;
    private int mMinFreqTxtHeight;
    private int mMinFreqTxtWidth;
    private Paint mPaint;
    private JPage page;

    public JFreqRoundRuler(Act_Radio actRadio, JPage page) {
        super(page.ui.mContext);
        this.mMinFreqText = FinalChip.BSP_PLATFORM_Null;
        this.mMaxFreqText = FinalChip.BSP_PLATFORM_Null;
        this.mAngle = ANGLE_MIN;
        this.mAngleTarget = ANGLE_MIN;
        this.mAngleTouch = -1.0f;
        this.bRotateFlag = false;
        this.actRadio = actRadio;
        this.page = page;
        if (this.mPaint == null) {
            this.mPaint = new Paint();
        }
    }

    public void setIconName(String iconName) {
        this.drawable = this.page.getDrawableFromPath(iconName, this.page.mDrawables, null);
        this.drawable.setBounds(0, 0, (int) (this.actRadio.ui.mScale * this.drawable.getIntrinsicWidth()), (int) (this.actRadio.ui.mScale * this.drawable.getIntrinsicHeight()));
    }

    public JFreqRoundRuler(Context context) {
        super(context);
        this.mMinFreqText = FinalChip.BSP_PLATFORM_Null;
        this.mMaxFreqText = FinalChip.BSP_PLATFORM_Null;
        this.mAngle = ANGLE_MIN;
        this.mAngleTarget = ANGLE_MIN;
        this.mAngleTouch = -1.0f;
        this.bRotateFlag = false;
    }

    public void calcPara(MyUiItem item) {
        int[] para = item.getPara();
        if (para != null && para[0] == 1) {
            this.bRotateFlag = true;
        }
        int[] recMark = item.getRecMark();
        if (recMark != null) {
            this.mMinFreqTxtWidth = recMark[0];
            this.mMinFreqTxtHeight = recMark[1];
            this.mMaxFreqTxtWidth = recMark[2];
            this.mMaxFreqTxtHeight = recMark[3];
        }
    }

    public void setTextSize(float textSize) {
        this.mPaint.setTextSize(textSize);
    }

    public void setTextColor(int textColor) {
        this.mPaint.setColor(textColor);
        this.mPaint.setAntiAlias(true);
    }

    protected void inits(Context context) {
        setWillNotDraw(false);
    }

    public void setup(int freqMin, int freqMax, int stepLen, int stepCnt) {
        this.mFreqMin = freqMin;
        this.mFreqMax = freqMax;
        this.mFreqStep = stepLen;
        if (freqMax < 5000) {
            this.mMinFreqText = String.format(Locale.US, "%d", Integer.valueOf(freqMin));
            this.mMaxFreqText = String.format(Locale.US, "%d", Integer.valueOf(freqMax));
        } else if (freqMin > 5000) {
            this.mMinFreqText = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freqMin / 100), Integer.valueOf(freqMin % 100));
            this.mMaxFreqText = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freqMax / 100), Integer.valueOf(freqMax % 100));
        }
        updateFreq(this.mFreq);
    }

    public void updateFreq(int value) {
        this.mFreq = value;
        if (this.mFreqMin < this.mFreqMax && value >= this.mFreqMin && value <= this.mFreqMax) {
            float angleTarget = ANGLE_MIN + (((value - this.mFreqMin) * ANGLE_DISTANCE) / (this.mFreqMax - this.mFreqMin));
            this.mAngleTarget = angleTarget;
            invalidate();
        }
    }

    public int calcFreqNum(float angle) {
        if (this.mFreqMin >= this.mFreqMax || this.mFreqStep <= 0 || this.mFreqStep > this.mFreqMax - this.mFreqMin) {
            return -1;
        }
        float freqOffset = ((this.mFreqMax - this.mFreqMin) * (angle - ANGLE_MIN)) / ANGLE_DISTANCE;
        int freqStepCnt = (int) ((freqOffset / this.mFreqStep) + 0.5f);
        return (this.mFreqStep * freqStepCnt) + this.mFreqMin;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.drawable != null) {
            canvas.save();
            canvas.rotate(this.mAngle, (getWidth() / 2.0f) + 5.0f, (getHeight() / 2.0f) + 5.0f);
            float xTranslate = getWidth() - ((this.drawable.getIntrinsicWidth() * this.actRadio.ui.mScale) + 4.0f);
            float yTranslate = (getHeight() - (this.drawable.getIntrinsicHeight() * this.actRadio.ui.mScale)) / 2.0f;
            canvas.translate(xTranslate - 5.0f, yTranslate);
            this.drawable.draw(canvas);
            canvas.restore();
            float MinFreqTxtWidth = this.mMinFreqTxtWidth * this.actRadio.ui.mScale;
            float MinFreqTxtHeight = this.mMinFreqTxtHeight * this.actRadio.ui.mScale;
            float MaxFreqTxtWidth = this.mMaxFreqTxtWidth * this.actRadio.ui.mScale;
            float MaxFreqTxtHeight = this.mMaxFreqTxtHeight * this.actRadio.ui.mScale;
            canvas.save();
            this.mPaint.setTextAlign(Paint.Align.LEFT);
            if (this.bRotateFlag) {
                canvas.rotate(-36.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            }
            canvas.drawText(this.mMinFreqText, MinFreqTxtWidth, MinFreqTxtHeight, this.mPaint);
            this.mPaint.setTextAlign(Paint.Align.RIGHT);
            if (this.bRotateFlag) {
                canvas.rotate(72.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            }
            canvas.drawText(this.mMaxFreqText, MaxFreqTxtWidth, MaxFreqTxtHeight, this.mPaint);
            canvas.restore();
            if (this.mAngle != this.mAngleTarget) {
                long drawingTime = getDrawingTime();
                if (this.mDrawingTime == 0) {
                    this.mDrawingTime = drawingTime - 17;
                }
                float distance = ((drawingTime - this.mDrawingTime) * ANGLE_DISTANCE) / 500.0f;
                this.mDrawingTime = drawingTime;
                if (Math.abs(this.mAngle - this.mAngleTarget) < distance) {
                    this.mAngle = this.mAngleTarget;
                } else if (this.mAngle > this.mAngleTarget) {
                    this.mAngle -= distance;
                } else {
                    this.mAngle += distance;
                }
                invalidate();
                return;
            }
            this.mDrawingTime = 0L;
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        inits(getContext());
        super.onAttachedToWindow();
        this.mAngleTouch = -1.0f;
        if (this.mAngle != this.mAngleTarget) {
            this.mAngle = this.mAngleTarget;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                float fCalcAngle = calcAngle(event, false);
                this.mAngle = fCalcAngle;
                this.mAngleTouch = fCalcAngle;
                if (this.mAngleTouch > 0.0f) {
                    this.mFreqShouldBe = calcFreqNum(this.mAngleTouch);
                    if (this.actRadio.mInterfacePageRadio != null) {
                        this.actRadio.mInterfacePageRadio.updateCurrentFreq(this.mFreqShouldBe, false);
                    }
                    invalidate();
                }
                return true;
            case 1:
                if (this.mAngleTouch >= 0.0f) {
                    IPageNotify pageNotify = this.page.getNotify();
                    if (pageNotify != null) {
                        pageNotify.ResponseClick(this);
                    }
                    this.mAngleTouch = -1.0f;
                }
                return true;
            case 2:
                if (this.mAngleTouch >= 0.0f) {
                    float angle = calcAngle(event, true);
                    if (angle > 0.0f) {
                        this.mAngleTouch = angle;
                        this.mFreqShouldBe = calcFreqNum(this.mAngleTouch);
                        if (this.actRadio.mInterfacePageRadio != null) {
                            this.actRadio.mInterfacePageRadio.updateCurrentFreq(this.mFreqShouldBe, false);
                        }
                        invalidate();
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public boolean isAdjusting() {
        return this.mAngleTouch > 0.0f;
    }

    private float calcAngle(MotionEvent event, boolean bMove) {
        float angle = -1.0f;
        float x = event.getX();
        float y = event.getY();
        float cx = getWidth() / 2.0f;
        float cy = getHeight() / 2.0f;
        float r = Math.min(cx, cy);
        float dx = x - cx;
        float dy = y - cy;
        float dsq = (dx * dx) + (dy * dy);
        float delta = 60.0f * this.actRadio.ui.mScale;
        if (dx == 0.0f || dy == 0.0f) {
            return -1.0f;
        }
        if (bMove || (dsq <= r * r && dsq >= (r - delta) * (r - delta))) {
            angle = (float) Math.toDegrees(Math.atan2(dy, dx));
            if (angle < 0.0f) {
                angle += 360.0f;
            }
            if (angle < 51.0f) {
                angle += 360.0f;
                if (angle > ANGLE_MAX) {
                    angle = ANGLE_MAX;
                }
            } else if (angle > 129.0f && angle < ANGLE_MIN) {
                angle = ANGLE_MIN;
            }
            if (angle < ANGLE_MIN || angle > ANGLE_MAX) {
                return -1.0f;
            }
        }
        return angle;
    }
}
