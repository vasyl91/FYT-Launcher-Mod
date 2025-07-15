package com.fyt.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.android.launcher66.settings.Helpers;

import share.ResValue;

public class RadioRuler extends View {
    private static final int msg_rulerview_anim = 0;
    private final Handler handler;
    public int mAction;
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
    private final int radioMarkRange;
    private final int radiomarkL;
    private final int radiomarkR;

    public interface ICallback {
        void cmdChange(int i, int i2);

        void uiChange(float f);
    }

    public RadioRuler(Context context) {
        super(context);
        this.radioMarkRange = getResources().getInteger(ResValue.getInstance().getId("getwidth", "integer")) - 12;
        this.radiomarkR = this.radioMarkRange - 6;
        this.radiomarkL = 6;
        this.handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        if (!RadioRuler.this.isAnimEnd()) {
                            RadioRuler.this.doAnim();
                            sendEmptyMessage(0);
                            break;
                        } else {
                            RadioRuler.this.setToTarget();
                            break;
                        }
                }
            }
        };
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    public RadioRuler(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.radioMarkRange = getResources().getInteger(ResValue.getInstance().getId("getwidth", "integer")) - 12;
        this.radiomarkR = this.radioMarkRange - 6;
        this.radiomarkL = 6;
        this.handler = new Handler(Looper.getMainLooper()) { 
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        if (!RadioRuler.this.isAnimEnd()) {
                            RadioRuler.this.doAnim();
                            sendEmptyMessage(0);
                            break;
                        } else {
                            RadioRuler.this.setToTarget();
                            break;
                        }
                }
            }
        };
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    public RadioRuler(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.radioMarkRange = getResources().getInteger(ResValue.getInstance().getId("getwidth", "integer")) - 12;
        this.radiomarkR = this.radioMarkRange - 6;
        this.radiomarkL = 6;
        this.handler = new Handler(Looper.getMainLooper()) { 
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 0:
                        if (!RadioRuler.this.isAnimEnd()) {
                            RadioRuler.this.doAnim();
                            sendEmptyMessage(0);
                            break;
                        } else {
                            RadioRuler.this.setToTarget();
                            break;
                        }
                }
            }
        };
        this.mPaint = new Paint();
        this.mCurMark = 0;
        init(context);
    }

    private void init(Context context) {
        this.mBitmapPointer = Helpers.glideLoader(ResValue.getInstance().radio_pointer);
        this.mRPoint = this.mBitmapPointer.getWidth() / 2;
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setColor(Color.parseColor("#000001"));
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(25.0f);
    }

    public void setCallback(ICallback callback) {
        this.mCallback = callback;
    }

    public void setTargetMarkAnim(int freq, int min, int max) {
        int targetMark = (int) (6.0f + ((this.radiomarkR * (freq - min)) / (max - min)));
        if (this.mCurMark != targetMark) {
            float ratio = Math.abs((this.mCurMark - targetMark) / this.radiomarkR);
            this.mStartMark = this.mCurMark;
            this.mTargetMark = targetMark;
            this.mMaintainTime = (int) (700.0f * ratio);
            this.mStartTime = SystemClock.uptimeMillis();
            this.handler.sendEmptyMessage(0);
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
        setOffset((int) (6.0f + ((this.radiomarkR * (freq - min)) / (max - min))), false);
    }

    public int getmCurMark() {
        return this.mCurMark;
    }

    private void setOffset(int offset, boolean callback) {
        if (offset < 6) {
            offset = this.radioMarkRange;
        } else if (offset > this.radioMarkRange) {
            offset = 6;
        }
        this.mCurMark = offset;
        invalidate();
        if (callback && this.mCallback != null) {
            float ratio = (this.mCurMark - 6) / this.radiomarkR;
            this.mCallback.uiChange(ratio);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mAction = event.getAction();
        if (this.mAction == 0) {
            this.mX = (int) event.getX();
            this.mXBak = this.mX;
            return false;
        }
        if (this.mAction == 2) {
            this.mX = (int) event.getX();
            if (Math.abs(this.mXBak - this.mX) > 5) {
                this.mXBak = this.mX;
                setOffset(this.mX, true);
                return false;
            }
            return false;
        }
        if (this.mAction == 1) {
            int offset = (int) event.getX();
            if (offset < 6) {
                offset = 6;
            } else if (offset > this.radioMarkRange) {
                offset = this.radioMarkRange;
            }
            int offset2 = offset - 6;
            if (this.mCallback != null) {
                float ratio = offset2 / this.radiomarkR;
                if (ratio > 1.0f) {
                    ratio = 1.0f;
                } else if (ratio < 0.0f) {
                    ratio = 0.0f;
                }
                this.mCallback.uiChange(ratio);
                this.mCallback.cmdChange(offset2, this.radiomarkR);
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (this.mBitmapPointer != null) {
            if (this.mCurMark < 80) {
                this.mCurMark = 80;
            } else if (this.mCurMark > this.radioMarkRange) {
                this.mCurMark = this.radioMarkRange;
            }
            canvas.drawBitmap(this.mBitmapPointer, this.mCurMark - this.mRPoint, 0.0f, null);
        }
    }
}
