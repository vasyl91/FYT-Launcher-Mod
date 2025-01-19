package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.syu.util.TimeUtil;
import com.syu.util.Utils;

import share.ResValue;

public class DigitClock extends RelativeLayout {
    private final Context context;
    private IntentFilter filter;
    private final int[] images;
    private int mDotHeight;
    private int mDotWidth;
    private int mViewHeight;
    private int mViewWidth;
    private Handler timeHandler;
    private final Runnable timeRunnable;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;

    public DigitClock(Context context, AttributeSet arg1, int arg2) {
        super(context, arg1, arg2);
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = new Runnable() { 
            @Override
            public void run() {
                DigitClock.this.postInvalidate();
                DateFormat.is24HourFormat(DigitClock.this.context);
                String hm = TimeUtil.getCurStr(DigitClock.this.context);
                char[] times = hm.toCharArray();
                int len = times.length;
                if (len == 3) {
                    DigitClock.this.tv1.setVisibility(View.GONE);
                    DigitClock.this.tv1.setBackgroundResource(0);
                } else if (len > 3) {
                    DigitClock.this.tv1.setVisibility(android.view.View.VISIBLE);
                }
                int index = Integer.parseInt(String.valueOf(times[0]));
                DigitClock.this.tv1.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index, DigitClock.this.images.length))]);
                int index2 = Integer.parseInt(String.valueOf(times[1]));
                DigitClock.this.tv2.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index2, DigitClock.this.images.length))]);
                int index3 = Integer.parseInt(String.valueOf(times[2]));
                DigitClock.this.tv4.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index3, DigitClock.this.images.length))]);
                int index4 = Integer.parseInt(String.valueOf(times[3]));
                DigitClock.this.tv5.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index4, DigitClock.this.images.length))]);
                DigitClock.this.timeHandler.postDelayed(DigitClock.this.timeRunnable, 1000L);
            }
        };
        this.context = context;
        init(context);
        initViews();
    }

    public DigitClock(Context context, AttributeSet arg1) {
        super(context, arg1);
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = new Runnable() { 
            @Override
            public void run() {
                DigitClock.this.postInvalidate();
                DateFormat.is24HourFormat(DigitClock.this.context);
                String hm = TimeUtil.getCurStr(DigitClock.this.context);
                char[] times = hm.toCharArray();
                int len = times.length;
                if (len == 3) {
                    DigitClock.this.tv1.setVisibility(View.GONE);
                    DigitClock.this.tv1.setBackgroundResource(0);
                } else if (len > 3) {
                    DigitClock.this.tv1.setVisibility(View.VISIBLE);
                }
                int index = Integer.parseInt(String.valueOf(times[0]));
                DigitClock.this.tv1.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index, DigitClock.this.images.length))]);
                int index2 = Integer.parseInt(String.valueOf(times[1]));
                DigitClock.this.tv2.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index2, DigitClock.this.images.length))]);
                int index3 = Integer.parseInt(String.valueOf(times[2]));
                DigitClock.this.tv4.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index3, DigitClock.this.images.length))]);
                int index4 = Integer.parseInt(String.valueOf(times[3]));
                DigitClock.this.tv5.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index4, DigitClock.this.images.length))]);
                DigitClock.this.timeHandler.postDelayed(DigitClock.this.timeRunnable, 1000L);
            }
        };
        this.context = context;
        init(context);
        initViews();
    }

    public DigitClock(Context context) {
        super(context);
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = new Runnable() { 
            @Override
            public void run() {
                DigitClock.this.postInvalidate();
                DateFormat.is24HourFormat(DigitClock.this.context);
                String hm = TimeUtil.getCurStr(DigitClock.this.context);
                char[] times = hm.toCharArray();
                int len = times.length;
                if (len == 3) {
                    DigitClock.this.tv1.setVisibility(View.GONE);
                    DigitClock.this.tv1.setBackgroundResource(0);
                } else if (len > 3) {
                    DigitClock.this.tv1.setVisibility(View.VISIBLE);
                }
                int index = Integer.parseInt(String.valueOf(times[0]));
                DigitClock.this.tv1.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index, DigitClock.this.images.length))]);
                int index2 = Integer.parseInt(String.valueOf(times[1]));
                DigitClock.this.tv2.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index2, DigitClock.this.images.length))]);
                int index3 = Integer.parseInt(String.valueOf(times[2]));
                DigitClock.this.tv4.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index3, DigitClock.this.images.length))]);
                int index4 = Integer.parseInt(String.valueOf(times[3]));
                DigitClock.this.tv5.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index4, DigitClock.this.images.length))]);
                DigitClock.this.timeHandler.postDelayed(DigitClock.this.timeRunnable, 1000L);
            }
        };
        this.context = context;
        init(context);
        initViews();
    }

    private void initViews() {
        this.tv1 = new TextView(this.context);
        this.tv2 = new TextView(this.context);
        this.tv3 = new TextView(this.context);
        this.tv4 = new TextView(this.context);
        this.tv5 = new TextView(this.context);
        this.tv1.setId(View.generateViewId());
        this.tv2.setId(View.generateViewId());
        this.tv3.setId(View.generateViewId());
        this.tv4.setId(View.generateViewId());
        this.tv5.setId(View.generateViewId());
        this.mDotWidth = Utils.getNameToInteger("dot_clock_width");
        this.mDotHeight = Utils.getNameToInteger("dot_clock_height");
        this.mViewWidth = Utils.getNameToInteger("digit_clock_width");
        this.mViewHeight = Utils.getNameToInteger("digit_clock_height");
        Log.d("LZP", "mViewWidth:" + this.mViewWidth);
        if (this.mViewWidth == 0 || this.mViewHeight == 0) {
            this.mViewWidth = -2;
            this.mViewHeight = -2;
        }
        if (this.mDotWidth == 0 || this.mDotHeight == 0) {
            this.mDotWidth = -2;
            this.mDotHeight = -2;
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params.addRule(20);
        addView(this.tv1, params);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params2.addRule(17, this.tv1.getId());
        addView(this.tv2, params2);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(this.mDotWidth, this.mDotHeight);
        params3.addRule(17, this.tv2.getId());
        addView(this.tv3, params3);
        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params4.addRule(17, this.tv3.getId());
        addView(this.tv4, params4);
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params5.addRule(17, this.tv4.getId());
        addView(this.tv5, params5);
        this.tv3.setBackgroundResource(ResValue.getInstance().timedot);
        timeRun();
    }

    private void timeRun() {
        this.timeHandler = new Handler(Looper.getMainLooper());
        this.timeHandler.post(this.timeRunnable);
    }

    private void init(Context context) {
    }
}
