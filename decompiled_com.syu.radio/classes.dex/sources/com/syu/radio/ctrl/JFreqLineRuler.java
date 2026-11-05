package com.syu.radio.ctrl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.lsec.core.frame.app.MyUiItem;
import com.lsec.core.frame.ctrl.JPage;
import com.lsec.core.frame.page.IPageNotify;
import com.lsec.core.util.data.FinalChip;
import com.syu.radio.Act_Radio;
import com.syu.radio.App_Radio;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class JFreqLineRuler extends View {
    private Act_Radio actRadio;
    Drawable[] drawable;
    private int extraMax;
    private int extraMin;
    private int hMark;
    String[] iconName;
    private long mDrawingTime;
    private int mFreq;
    private int mFreqMax;
    private int mFreqMin;
    public int mFreqShouldBe;
    private int mFreqStep;
    private int mFreqStepCnt;
    private String[] mFreqText;
    private String mMaxFreqText;
    private String mMinFreqText;
    private int mNumFreqText;
    private Paint mPaint;
    private boolean mSlideFreq;
    private JPage page;
    private int wMarkHalf;
    private int xMax;
    private int xMin;
    private int xPos;
    private int xPosTraget;
    private int yPos;
    private int yPosText;

    public JFreqLineRuler(Act_Radio actRadio, JPage page) {
        super(page.ui.mContext);
        this.mSlideFreq = false;
        this.extraMax = -5;
        this.yPosText = 0;
        this.mNumFreqText = 0;
        this.mMinFreqText = FinalChip.BSP_PLATFORM_Null;
        this.mMaxFreqText = FinalChip.BSP_PLATFORM_Null;
        this.actRadio = actRadio;
        this.page = page;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
    }

    public void setIconName(String[] iconName) {
        this.iconName = iconName;
    }

    public void calcPara(MyUiItem item) {
        int[] para = item.getPara();
        if (para != null && para[0] > 0) {
            this.mNumFreqText = para[0];
            this.mFreqText = new String[this.mNumFreqText];
        }
        int[] recMark = item.getRecMark();
        if (recMark != null) {
            this.xMin = recMark[0];
            this.xMax = recMark[0] + recMark[2];
            this.yPos = recMark[1];
            this.xPos = this.xMin;
            this.extraMin = recMark[3];
            this.yPosText = recMark[4];
            if (recMark.length > 5) {
                this.extraMax = recMark[5];
            }
        }
    }

    public void setup(int freqMin, int freqMax, int stepLen, int stepCnt) {
        this.mFreqMin = freqMin;
        this.mFreqMax = freqMax;
        this.mFreqStep = stepLen;
        this.mFreqStepCnt = stepCnt;
        if (freqMax < 5000) {
            this.mMinFreqText = String.format(Locale.US, "%d", Integer.valueOf(freqMin));
            this.mMaxFreqText = String.format(Locale.US, "%d", Integer.valueOf(freqMax));
            if (this.mFreqText != null) {
                for (int i = 0; i < this.mNumFreqText; i++) {
                    int iStep = (int) ((((this.mFreqStepCnt * (i + 1)) * 1.0f) / (this.mNumFreqText + 1)) + 0.5f);
                    this.mFreqText[i] = String.format(Locale.US, "%d", Integer.valueOf(this.mFreqMin + (stepLen * iStep)));
                }
            }
        } else if (freqMin > 5000) {
            this.mMinFreqText = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freqMin / 100), Integer.valueOf(freqMin % 100));
            this.mMaxFreqText = String.format(Locale.US, "%02d.%02d", Integer.valueOf(freqMax / 100), Integer.valueOf(freqMax % 100));
            if (this.mFreqText != null) {
                for (int i2 = 0; i2 < this.mNumFreqText; i2++) {
                    int iStep2 = (int) ((((this.mFreqStepCnt * (i2 + 1)) * 1.0f) / (this.mNumFreqText + 1)) + 0.5f);
                    int iFreq = this.mFreqMin + (stepLen * iStep2);
                    this.mFreqText[i2] = String.format(Locale.US, "%02d.%02d", Integer.valueOf(iFreq / 100), Integer.valueOf(iFreq % 100));
                }
            }
        }
        updateFreq(this.mFreq);
    }

    public void updateFreq(int value) {
        Log.d("gdy3", " ** 00 JFreqLinRuler updateFreq freq = " + value);
        this.mFreq = value;
        if (this.mFreqMin < this.mFreqMax && value >= this.mFreqMin && value <= this.mFreqMax) {
            this.xPosTraget = this.xMin + ((((value - this.mFreqMin) / this.mFreqStep) * (this.xMax - this.xMin)) / this.mFreqStepCnt);
            invalidate();
        }
    }

    public void setTextSize(float textSize) {
        this.mPaint.setTextSize(textSize);
    }

    public void setTextColor(int textColor) {
        this.mPaint.setColor(textColor);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.drawable == null) {
            this.drawable = new Drawable[2];
            this.drawable[0] = this.page.getDrawableFromPath(this.iconName[0], this.page.mDrawables, null);
            this.drawable[1] = this.page.getDrawableFromPath(this.iconName[1], this.page.mDrawables, null);
            if (App_Radio.mBkWidth != 0) {
                this.drawable[0].setBounds(0, 0, (int) (this.actRadio.ui.mScale * this.drawable[0].getIntrinsicWidth() * App_Radio.RulerScale), (int) (this.actRadio.ui.mScale * this.drawable[0].getIntrinsicHeight() * App_Radio.RulerScale));
            } else {
                this.drawable[0].setBounds(0, 0, (int) (this.actRadio.ui.mScale * this.drawable[0].getIntrinsicWidth()), (int) (this.actRadio.ui.mScale * this.drawable[0].getIntrinsicHeight()));
            }
            this.wMarkHalf = (int) (((double) this.drawable[0].getBounds().width()) * 0.5d);
            this.hMark = this.drawable[0].getBounds().height();
            if (this.iconName.length > 1) {
                if (App_Radio.mBkWidth != 0) {
                    this.drawable[1].setBounds(0, 0, (int) (this.actRadio.ui.mScale * this.drawable[1].getIntrinsicWidth() * App_Radio.RulerScale), (int) (this.actRadio.ui.mScale * this.drawable[1].getIntrinsicHeight() * App_Radio.RulerScale));
                } else {
                    this.drawable[1].setBounds(0, 0, (int) (this.actRadio.ui.mScale * this.drawable[1].getIntrinsicWidth()), (int) (this.actRadio.ui.mScale * this.drawable[1].getIntrinsicHeight()));
                }
            }
            Log.d("ruler", " 11 JFreqLineRuler  onDraw  mScale" + this.actRadio.ui.mScale + " mBkWidth = " + App_Radio.mBkWidth + "  getIntrinsicWidth = " + this.drawable[1].getIntrinsicWidth() + " RulerScale = " + App_Radio.RulerScale);
        }
        if (this.drawable[1] != null) {
            this.drawable[1].draw(canvas);
        }
        if (this.mFreqText[0] != null) {
            canvas.save();
            this.mPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
            float testBaseY = ((this.yPosText + getHeight()) - ((getHeight() - (fontMetrics.bottom - fontMetrics.top)) / 2.0f)) - fontMetrics.bottom;
            canvas.drawText(this.mMinFreqText, this.xMin + this.extraMin, testBaseY, this.mPaint);
            canvas.drawText(this.mMaxFreqText, this.xMax + this.extraMax, testBaseY, this.mPaint);
            boolean bFreqTextNum = this.mNumFreqText > 2;
            if (bFreqTextNum) {
                int xPartOne = (this.xMax - this.xMin) / (this.mNumFreqText + 1);
                int x = this.xMin + xPartOne;
                for (int i = 0; i < this.mNumFreqText; i++) {
                    canvas.drawText(this.mFreqText[i], x, testBaseY, this.mPaint);
                    x += xPartOne;
                }
            }
            canvas.restore();
            if (this.xPos != this.xPosTraget) {
                long drawingTime = getDrawingTime();
                if (this.mDrawingTime == 0) {
                    this.mDrawingTime = drawingTime - 17;
                }
                float distance = ((drawingTime - this.mDrawingTime) * ((long) (this.xMax - this.xMin))) / 500.0f;
                this.mDrawingTime = drawingTime;
                if (Math.abs(this.xPos - this.xPosTraget) < distance) {
                    this.xPos = this.xPosTraget;
                } else if (this.xPos > this.xPosTraget) {
                    this.xPos = (int) (this.xPos - distance);
                } else {
                    this.xPos = (int) (this.xPos + distance);
                }
                invalidate();
            } else {
                this.mDrawingTime = 0L;
            }
        }
        this.drawable[0].setBounds(this.xPos - this.wMarkHalf, this.yPos, this.xPos + this.wMarkHalf, this.yPos + this.hMark);
        this.drawable[0].draw(canvas);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case 0:
                float x = event.getX();
                if (x >= this.xMin && x <= this.xMax) {
                    this.mSlideFreq = true;
                    this.mFreqShouldBe = (((int) (((x - this.xMin) * this.mFreqStepCnt) / (this.xMax - this.xMin))) * this.mFreqStep) + this.mFreqMin;
                    if (this.actRadio.mInterfacePageRadio != null) {
                        this.actRadio.mInterfacePageRadio.updateCurrentFreq(this.mFreqShouldBe, false);
                    }
                    invalidate();
                }
                return true;
            case 1:
            case 3:
                if (this.mSlideFreq) {
                    IPageNotify pageNotify = this.page.getNotify();
                    if (pageNotify != null) {
                        pageNotify.ResponseClick(this);
                    }
                    this.mSlideFreq = false;
                }
                return true;
            case 2:
                if (this.mSlideFreq) {
                    float x2 = event.getX();
                    if (x2 <= this.xMin) {
                        this.mFreqShouldBe = this.mFreqMin;
                    } else if (x2 >= this.xMax) {
                        this.mFreqShouldBe = (this.mFreqStepCnt * this.mFreqStep) + this.mFreqMin;
                    } else {
                        this.mFreqShouldBe = (((int) (((x2 - this.xMin) * this.mFreqStepCnt) / (this.xMax - this.xMin))) * this.mFreqStep) + this.mFreqMin;
                    }
                    if (this.actRadio.mInterfacePageRadio != null) {
                        this.actRadio.mInterfacePageRadio.updateCurrentFreq(this.mFreqShouldBe, false);
                    }
                    invalidate();
                }
                return true;
            default:
                return true;
        }
    }

    public boolean isAdjusting() {
        return this.mSlideFreq;
    }
}
