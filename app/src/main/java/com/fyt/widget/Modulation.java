package com.fyt.widget;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.util.Calendar;

import share.ResValue;

public class Modulation extends TextView {
    public static Modulation modulation;
    private final Boolean bRegister;
    private IntentFilter filter;
    private Typeface gmeTypeface;

    public static Modulation getModulation() {
        return modulation;
    }

    public Modulation(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.gmeTypeface = null;
        this.bRegister = false;
        init(context);
    }

    public Modulation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.gmeTypeface = null;
        this.bRegister = false;
        init(context);
    }

    public Modulation(Context context) {
        super(context);
        this.gmeTypeface = null;
        this.bRegister = false;
        init(context);
    }

    private void init(Context context) {
        modulation = this;
    }

    @Override
    protected void onAttachedToWindow() {
        setModulation();
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setModulation() {
        if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.app_ampm_show)) {
            if (getResources().getString(R.string.am).equals(getSmallTime(getContext()))) {
                setBackgroundResource(ResValue.getInstance().im_am);
                return;
            } else if (getResources().getString(R.string.pm).equals(getSmallTime(getContext()))) {
                setBackgroundResource(ResValue.getInstance().im_pm);
                return;
            } else {
                setBackgroundResource(0);
                return;
            }
        }
        setText(getSmallTime(getContext()));
    }

    public CharSequence getSmallTime(Context context) {
        boolean b24 = DateFormat.is24HourFormat(getContext());
        int flag = Calendar.getInstance().get(9);
        if (b24) {
            return "";
        }
        if (flag != 0) {
            String format = context.getString(R.string.pm);
            return format;
        }
        String format2 = context.getString(R.string.am);
        return format2;
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
