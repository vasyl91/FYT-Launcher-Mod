package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends TextView {
    public static Clock clock;
    private IntentFilter filter;
    private Typeface gmeTypeface;

    public static Clock getClock() {
        return clock;
    }

    public Clock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.gmeTypeface = null;
        init(context);
    }

    public Clock(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.gmeTypeface = null;
        init(context);
    }

    public Clock(Context context) {
        super(context);
        this.gmeTypeface = null;
        init(context);
    }

    private void init(Context context) {
        clock = this;
    }

    @Override
    protected void onAttachedToWindow() {
        setTime();
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setTime() {
        setText(getSmallTime(getContext()));
    }

    public CharSequence getSmallTime(Context context) {
        String format;
        boolean b24 = DateFormat.is24HourFormat(getContext());
        if (b24) {
            format = "H:mm";
        } else {
            format = "h:mm";
        }
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    private void setTypeface() {
        try {
            this.gmeTypeface = Typeface.createFromFile("/system/fonts/MICROGME.TTF");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.gmeTypeface != null) {
            setTypeface(this.gmeTypeface);
        }
    }
}
