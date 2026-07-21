package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.settings.Keys;
import com.syu.util.TimeUtil;

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
    private SharedPreferences prefs;
    private boolean blackTintWidgets;
    private boolean layoutInitialized = false;
    private static final float DIGIT_WIDTH_RATIO = 0.22f;
    private static final float DIGIT_HEIGHT_RATIO = 0.22f;
    private static final float DOT_WIDTH_RATIO = 0.08f;
    private static final float DOT_HEIGHT_RATIO = 0.22f;

    public DigitClock(Context context, AttributeSet arg1, int arg2) {
        super(context, arg1, arg2);
        this.context = context;
        initPreferences();
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = createTimeRunnable();
        init(context);
        initViews();
        setupLayoutListener();
    }

    public DigitClock(Context context, AttributeSet arg1) {
        super(context, arg1);
        this.context = context;
        initPreferences();
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = createTimeRunnable();
        init(context);
        initViews();
        setupLayoutListener();
    }

    public DigitClock(Context context) {
        super(context);
        this.context = context;
        initPreferences();
        this.images = new int[]{ResValue.getInstance().time00, ResValue.getInstance().time01, ResValue.getInstance().time02, ResValue.getInstance().time03, ResValue.getInstance().time04, ResValue.getInstance().time05, ResValue.getInstance().time06, ResValue.getInstance().time07, ResValue.getInstance().time08, ResValue.getInstance().time09};
        this.timeRunnable = createTimeRunnable();
        init(context);
        initViews();
        setupLayoutListener();
    }

    private void initPreferences() {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
        blackTintWidgets = prefs.getBoolean(Keys.BLACK_WIDGETS, false);
    }

    private Runnable createTimeRunnable() {
        return new Runnable() {
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
                DigitClock.this.tv1.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index, DigitClock.this.images.length - 1))]);
                int index2 = Integer.parseInt(String.valueOf(times[1]));
                DigitClock.this.tv2.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index2, DigitClock.this.images.length - 1))]);
                int index3 = Integer.parseInt(String.valueOf(times[2]));
                DigitClock.this.tv4.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index3, DigitClock.this.images.length - 1))]);
                int index4 = Integer.parseInt(String.valueOf(times[3]));
                DigitClock.this.tv5.setBackgroundResource(DigitClock.this.images[Math.max(0, Math.min(index4, DigitClock.this.images.length - 1))]);
                if (blackTintWidgets) {
                    applyColorFilter(DigitClock.this.tv1);
                    applyColorFilter(DigitClock.this.tv2);
                    applyColorFilter(DigitClock.this.tv4);
                    applyColorFilter(DigitClock.this.tv5);
                } else {
                    removeColorFilter(DigitClock.this.tv1);
                    removeColorFilter(DigitClock.this.tv2);
                    removeColorFilter(DigitClock.this.tv4);
                    removeColorFilter(DigitClock.this.tv5);
                }
                DigitClock.this.timeHandler.postDelayed(DigitClock.this.timeRunnable, 1000L);
            }
        };
    }

    private void setupLayoutListener() {
        ViewTreeObserver observer = getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (!layoutInitialized && getWidth() > 0) {
                    recalculateSizes();
                    updateViewSizes();
                    layoutInitialized = true;
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }

    private void recalculateSizes() {
        int widgetWidth = getWidth();
        
        if (widgetWidth > 0) {
            this.mViewWidth = (int) (widgetWidth * DIGIT_WIDTH_RATIO);
            this.mViewHeight = (int) (widgetWidth * DIGIT_HEIGHT_RATIO);
            this.mDotWidth = (int) (widgetWidth * DOT_WIDTH_RATIO);
            this.mDotHeight = (int) (widgetWidth * DOT_HEIGHT_RATIO);

            if (this.mViewWidth < 20) {
                this.mViewWidth = 20;
            }
            if (this.mViewHeight < 20) {
                this.mViewHeight = 20;
            }
            if (this.mDotWidth < 10) {
                this.mDotWidth = 10;
            }
            if (this.mDotHeight < 10) {
                this.mDotHeight = 10;
            }
            
            Log.d("DigitClock", "Widget width: " + widgetWidth + ", Digit size: " + mViewWidth + "x" + mViewHeight + ", Dot size: " + mDotWidth + "x" + mDotHeight);
        } else {
            this.mViewWidth = Launcher.digit_clock_width;
            this.mViewHeight = Launcher.digit_clock_height;
            this.mDotWidth = Launcher.dot_clock_width;
            this.mDotHeight = Launcher.dot_clock_height;
            
            if (this.mViewWidth == 0 || this.mViewHeight == 0) {
                this.mViewWidth = -2;
                this.mViewHeight = -2;
            }
            if (this.mDotWidth == 0 || this.mDotHeight == 0) {
                this.mDotWidth = -2;
                this.mDotHeight = -2;
            }
        }
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
        
        recalculateSizes();

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(this.tv1, params);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params2.addRule(RelativeLayout.RIGHT_OF, this.tv1.getId());
        params2.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(this.tv2, params2);

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(this.mDotWidth, this.mDotHeight);
        params3.addRule(RelativeLayout.RIGHT_OF, this.tv2.getId());
        params3.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(this.tv3, params3);

        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params4.addRule(RelativeLayout.RIGHT_OF, this.tv3.getId());
        params4.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(this.tv4, params4);
        
        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(this.mViewWidth, this.mViewHeight);
        params5.addRule(RelativeLayout.RIGHT_OF, this.tv4.getId());
        params5.addRule(RelativeLayout.CENTER_VERTICAL);
        addView(this.tv5, params5);
        
        this.tv3.setBackgroundResource(ResValue.getInstance().timedot);
        if (blackTintWidgets) {
            applyColorFilter(DigitClock.this.tv3);
        } else {
            removeColorFilter(DigitClock.this.tv3);
        }
        
        timeRun();
    }

    private void updateViewSizes() {
        if (tv1 != null) {
            updateLayoutParams(tv1, this.mViewWidth, this.mViewHeight);
            updateLayoutParams(tv2, this.mViewWidth, this.mViewHeight);
            updateLayoutParams(tv3, this.mDotWidth, this.mDotHeight);
            updateLayoutParams(tv4, this.mViewWidth, this.mViewHeight);
            updateLayoutParams(tv5, this.mViewWidth, this.mViewHeight);
        }
    }

    private void updateLayoutParams(View view, int width, int height) {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (params != null) {
            params.width = width;
            params.height = height;
            view.setLayoutParams(params);
        }
    }

    private void timeRun() {
        this.timeHandler = new Handler(Looper.getMainLooper());
        this.timeHandler.post(this.timeRunnable);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeClockCallbacks();
    }

    public void removeClockCallbacks() {
        if (timeHandler != null) {
            timeHandler.removeCallbacks(timeRunnable);
        }
    }

    private void init(Context context) {
    }

    private void applyColorFilter(TextView textView) {
        if (textView != null && textView.getBackground() != null) {
            textView.getBackground().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
        }
    }

    private void removeColorFilter(TextView textView) {
        if (textView != null && textView.getBackground() != null) {
            textView.getBackground().clearColorFilter();
        }
        if (textView != null) {
            textView.invalidate();
        }
    }
}