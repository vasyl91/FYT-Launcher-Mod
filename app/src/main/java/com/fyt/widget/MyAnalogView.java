package com.fyt.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.util.Calendar;

import share.ResValue;

public class MyAnalogView extends View {
    int availableHeight;
    int availableWidth;
    BitmapDrawable bmdBg;
    BitmapDrawable bmdHour;
    BitmapDrawable bmdMinute;
    BitmapDrawable bmdSecond;
    int centerX;
    int centerY;
    Bitmap mBmpBg;
    Bitmap mBmpHour;
    Bitmap mBmpMinute;
    Bitmap mBmpSecond;
    int mHeight;
    int mHourHeight;
    int mHourWidth;
    int mMinuteHeight;
    int mMinuteWidth;
    Paint mPaint;
    int mSecondHeight;
    int mSecondWidth;
    int mTempHeight;
    int mTempWidth;
    int mWidth;
    float pointerCenterX;
    float pointerCenterY;
    int pointerX;
    int pointerY;
    Handler tickHandler;
    private final Runnable tickRunnable;
    String timeZoneStr;

    public MyAnalogView(Context context) {
        super(context);
        this.availableWidth = LauncherApplication.sApp.getResources().getInteger(R.integer.analogwidth);
        this.availableHeight = LauncherApplication.sApp.getResources().getInteger(R.integer.analogheight);
        this.pointerCenterX = LauncherApplication.sApp.getResources().getDimension(R.dimen.analogCenterX);
        this.pointerCenterY = LauncherApplication.sApp.getResources().getDimension(R.dimen.analogCenterY);
        this.tickRunnable = new Runnable() {
            @Override
            public void run() {
                MyAnalogView.this.postInvalidate();
                MyAnalogView.this.tickHandler.postDelayed(MyAnalogView.this.tickRunnable, 1000L);
            }
        };
    }

    public MyAnalogView(Context context, AttributeSet arg1, int arg2) {
        this(context, "GMT+8：00");
    }

    public MyAnalogView(Context context, AttributeSet attrs) {
        this(context, "GMT+8：00");
    }

    public MyAnalogView(Context context, String timeZone) {
        super(context);
        this.availableWidth = LauncherApplication.sApp.getResources().getInteger(R.integer.analogwidth);
        this.availableHeight = LauncherApplication.sApp.getResources().getInteger(R.integer.analogheight);
        this.pointerCenterX = LauncherApplication.sApp.getResources().getDimension(R.dimen.analogCenterX);
        this.pointerCenterY = LauncherApplication.sApp.getResources().getDimension(R.dimen.analogCenterY);
        this.tickRunnable = new Runnable() {
            @Override
            public void run() {
                MyAnalogView.this.postInvalidate();
                MyAnalogView.this.tickHandler.postDelayed(MyAnalogView.this.tickRunnable, 1000L);
            }
        };
        this.timeZoneStr = timeZone;
        this.mBmpHour = BitmapFactory.decodeResource(getResources(), ResValue.getInstance().clock_hour);
        this.mBmpMinute = BitmapFactory.decodeResource(getResources(), ResValue.getInstance().clock_minute);
        this.mBmpSecond = BitmapFactory.decodeResource(getResources(), ResValue.getInstance().clock_second);
        this.mBmpBg = BitmapFactory.decodeResource(getResources(), ResValue.getInstance().clock_bg);
        this.bmdBg = new BitmapDrawable(getResources(), this.mBmpBg);
        this.bmdHour = new BitmapDrawable(getResources(), this.mBmpHour);
        this.bmdMinute = new BitmapDrawable(getResources(), this.mBmpMinute);
        this.bmdSecond = new BitmapDrawable(getResources(), this.mBmpSecond);
        this.mWidth = this.mBmpBg.getWidth();
        this.mHeight = this.mBmpBg.getHeight();
        this.mHourWidth = this.bmdHour.getIntrinsicWidth();
        this.mHourHeight = this.bmdHour.getIntrinsicHeight();
        this.mMinuteWidth = this.bmdMinute.getIntrinsicWidth();
        this.mMinuteHeight = this.bmdMinute.getIntrinsicHeight();
        this.mSecondWidth = this.bmdSecond.getIntrinsicWidth();
        this.mSecondHeight = this.bmdSecond.getIntrinsicHeight();
        this.centerX = this.availableWidth / 2;
        this.centerY = this.availableHeight / 2;
        this.pointerX = this.mWidth / 2;
        this.pointerY = this.mWidth / 2;
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.parseColor("#FFFF01"));
        run();
    }

    public void run() {
        this.tickHandler = new Handler(Looper.getMainLooper());
        this.tickHandler.post(this.tickRunnable);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(10);
        int minute = cal.get(12);
        int second = cal.get(13);
        float hourRotate = (hour * 30.0f) + ((minute / 60.0f) * 30.0f);
        float minuteRotate = minute * 6.0f;
        float secondRotate = second * 6.0f;
        if (this.availableWidth < this.mWidth || this.availableHeight < this.mHeight) {
            float scale = Math.min(this.availableWidth / this.mWidth, this.availableHeight / this.mHeight);
            canvas.save();
            canvas.scale(scale, scale, this.centerX, this.centerY);
        }
        canvas.save();
        canvas.rotate(hourRotate, this.pointerX - this.pointerCenterX, this.pointerY - this.pointerCenterY);
        this.bmdHour.setBounds(this.pointerX - (this.mHourWidth / 2), this.pointerY - (this.mHourHeight / 2), this.pointerX + (this.mHourWidth / 2), this.pointerY + (this.mHourHeight / 2));
        this.bmdHour.draw(canvas);
        canvas.restore();
        canvas.save();
        canvas.rotate(minuteRotate, this.pointerX - this.pointerCenterX, this.pointerY - this.pointerCenterY);
        this.bmdMinute.setBounds(this.pointerX - (this.mMinuteWidth / 2), this.pointerY - (this.mMinuteHeight / 2), this.pointerX + (this.mMinuteWidth / 2), this.pointerY + (this.mMinuteHeight / 2));
        this.bmdMinute.draw(canvas);
        canvas.restore();
        canvas.rotate(secondRotate, this.pointerX - this.pointerCenterX, this.pointerY - this.pointerCenterY);
        this.bmdSecond.setBounds(this.pointerX - (this.mSecondWidth / 2), this.pointerY - (this.mSecondHeight / 2), this.pointerX + (this.mSecondWidth / 2), this.pointerY + (this.mSecondHeight / 2));
        this.bmdSecond.draw(canvas);
    }
}
