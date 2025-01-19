package com.syu.carinfo.focus.yl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.syu.canbus.R;
import com.syu.module.canbus.DataCanbus;

public class RadioRuler extends View {
    public static int MAX_ALL_RULER;
    public static int MAX_ALL_RULER_REAL;
    public static int MAX_LEFT;
    private int CANVAS_NUMBER_HEIGHT;
    private int CANVAS_NUMBER_WIDTH;
    private int DRAW_NUMBER_Y;
    private int DRAW_POINT_Y;
    public int mAction;
    private Bitmap mBitmapNumber;
    private Bitmap mBitmapPointer;
    private ICallback mCallback;
    private int mCurMark;
    private int mMaintainTime;
    public Paint mPaint;
    private int mRPoint;
    private int mStartMark;
    private long mStartTime;
    private int mTargetMark;
    public int mX;
    public int mXBak;
    public static int STARTPOINT = 0;
    public static int ERACHROAD = 0;
    public static final ICallback mRulerListener = new ICallback() { 
        @Override
        public void uiChange(float ratio) {
            if (ratio >= 0.0f && ratio <= 1.0f) {
                String str = "";
                int freq = ActivityRadio.mFreqMin + (((int) (((ActivityRadio.mFreqMax - ActivityRadio.mFreqMin) * ratio) / ActivityRadio.mFreqStep)) * ActivityRadio.mFreqStep);
                if (ActivityRadio.Current_Band == 2 || ActivityRadio.Current_Band == 3) {
                    str = new StringBuilder().append(freq).toString();
                } else if (ActivityRadio.Current_Band == 0 || ActivityRadio.Current_Band == 1) {
                    str = String.format("%02d.%02d", Integer.valueOf(freq / 100), Integer.valueOf(freq % 100));
                }
                if (ActivityRadio.mIsInit) {
                    ActivityRadio.mTvCurrfreq.setText(str);
                }
            }
        }

        @Override
        public void cmdChange(int cur, int max) {
            int step = (((ActivityRadio.mFreqMax - ActivityRadio.mFreqMin) / ActivityRadio.mFreqStep) * cur) / max;
            int freq = (ActivityRadio.mFreqStep * step) + ActivityRadio.mFreqMin;
            if (ActivityRadio.mFreqMin == 8750) {
                DataCanbus.PROXY.cmd(2, freq * 10);
            } else {
                DataCanbus.PROXY.cmd(2, freq);
            }
        }
    };

    public interface ICallback {
        void cmdChange(int i, int i2);

        void uiChange(float f);
    }

    public RadioRuler(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    public RadioRuler(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    public RadioRuler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    private void init(Context context) {
        Resources resources = context.getResources();
        MAX_LEFT = (int) resources.getDimension(R.dimen.max_left);
        MAX_ALL_RULER = (int) resources.getDimension(R.dimen.max_all_ruler);
        MAX_ALL_RULER_REAL = (int) resources.getDimension(R.dimen.max_real_all_ruler);
        this.DRAW_NUMBER_Y = (int) resources.getDimension(R.dimen.draw_number_y);
        this.DRAW_POINT_Y = (int) resources.getDimension(R.dimen.draw_point_y);
        this.CANVAS_NUMBER_WIDTH = (int) resources.getDimension(R.dimen.canvas_number_width);
        this.CANVAS_NUMBER_HEIGHT = (int) resources.getDimension(R.dimen.canvas_number_height);
        STARTPOINT = (int) resources.getDimension(R.dimen.startpoint);
        ERACHROAD = (int) resources.getDimension(R.dimen.earchroad);
        this.mBitmapPointer = BitmapFactory.decodeResource(getResources(), R.drawable.ic_ruler_pointer);
        this.mRPoint = this.mBitmapPointer.getWidth() / 2;
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(18.0f);
    }

    public void setCallback(ICallback callback) {
        this.mCallback = callback;
    }

    public void updateFreqNumber(boolean isAm, String[] strs, int[] offsets) {
        if (strs != null && offsets != null && strs.length == offsets.length) {
            this.mBitmapNumber = Bitmap.createBitmap(this.CANVAS_NUMBER_WIDTH, this.CANVAS_NUMBER_HEIGHT, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.mBitmapNumber);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null) {
                    canvas.drawText(strs[i], offsets[i], 15.0f, this.mPaint);
                }
            }
            invalidate();
        }
    }

    public void setTargetMarkAnim(int freq, int min, int max) {
        int targetMark = (int) (MAX_LEFT + ((MAX_ALL_RULER_REAL * (freq - min)) / (max - min)));
        if (this.mCurMark != targetMark) {
            float ratio = Math.abs((this.mCurMark - targetMark) / MAX_ALL_RULER_REAL);
            this.mStartMark = this.mCurMark;
            this.mTargetMark = targetMark;
            this.mMaintainTime = (int) (700.0f * ratio);
            this.mStartTime = SystemClock.uptimeMillis();
            HandlerAnim.mInst.startRulerAnim();
        }
    }

    public void doAnim() {
        if (this.mMaintainTime != 0) {
            setOffset((int) (this.mStartMark + (((this.mTargetMark - this.mStartMark) * (SystemClock.uptimeMillis() - this.mStartTime)) / this.mMaintainTime)), false);
        }
    }

    public boolean isAnimEnd() {
        return SystemClock.uptimeMillis() - this.mStartTime > ((long) this.mMaintainTime);
    }

    public void setToTarget() {
        setOffset(this.mTargetMark, false);
    }

    public void setTargetMark(int freq, int min, int max) {
        setOffset((int) ((MAX_ALL_RULER_REAL * (freq - min)) / (max - min)), false);
    }

    public int getmCurMark() {
        return this.mCurMark;
    }

    private void setOffset(int offset, boolean callback) {
        if (offset < MAX_LEFT) {
            offset = MAX_LEFT;
        } else if (offset > MAX_ALL_RULER) {
            offset = MAX_ALL_RULER;
        }
        this.mCurMark = offset;
        invalidate();
        if (callback && this.mCallback != null) {
            float ratio = (this.mCurMark - MAX_LEFT) / MAX_ALL_RULER_REAL;
            this.mCallback.uiChange(ratio);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mAction = event.getAction();
        if (this.mAction == 0) {
            this.mX = (int) event.getX();
            this.mXBak = this.mX;
        } else if (this.mAction == 2) {
            this.mX = (int) event.getX();
            if (Math.abs(this.mXBak - this.mX) > 5) {
                this.mXBak = this.mX;
                setOffset(this.mX, true);
            }
        } else if (this.mAction == 1) {
            int offset = (int) event.getX();
            if (offset < MAX_LEFT) {
                offset = MAX_LEFT;
            } else if (offset > MAX_ALL_RULER) {
                offset = MAX_ALL_RULER;
            }
            int offset2 = offset - MAX_LEFT;
            if (this.mCallback != null) {
                float ratio = offset2 / MAX_ALL_RULER_REAL;
                if (ratio > 1.0f) {
                    ratio = 1.0f;
                } else if (ratio < 0.0f) {
                    ratio = 0.0f;
                }
                this.mCallback.uiChange(ratio);
                this.mCallback.cmdChange(offset2, MAX_ALL_RULER_REAL);
            }
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (this.mBitmapNumber != null) {
            canvas.drawBitmap(this.mBitmapNumber, 0.0f, this.DRAW_NUMBER_Y, (Paint) null);
        }
        if (this.mBitmapPointer != null) {
            if (this.mCurMark < MAX_LEFT) {
                this.mCurMark = MAX_LEFT;
            } else if (this.mCurMark > MAX_ALL_RULER) {
                this.mCurMark = MAX_ALL_RULER;
            }
            canvas.drawBitmap(this.mBitmapPointer, this.mCurMark - this.mRPoint, this.DRAW_POINT_Y, (Paint) null);
        }
    }
}
