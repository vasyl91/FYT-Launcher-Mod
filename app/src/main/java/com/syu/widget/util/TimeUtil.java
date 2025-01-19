package com.syu.widget.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;

import com.android.launcher66.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import share.ResValue;

@SuppressLint({"SimpleDateFormat"})
public class TimeUtil {
    public static String getDateOfToday(Context context, String format) {
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentTime(Context context) {
        String format;
        boolean b24 = DateFormat.is24HourFormat(context);
        if (b24) {
            format = "HH:mm";
        } else {
            format = "hh:mm";
        }
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    public static String getCurStr(Context context) {
        String format;
        boolean b24 = DateFormat.is24HourFormat(context);
        if (b24) {
            format = "HHmm";
        } else {
            format = "hhmm";
        }
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    public static boolean b24Hour(Context context) {
        boolean b24 = DateFormat.is24HourFormat(context);
        return b24;
    }

    public static String getAmPm(Context context) {
        DateFormat.is24HourFormat(context);
        int flag = Calendar.getInstance().get(9);
        if (flag != 0) {
            String format = context.getString(R.string.pm);
            return format;
        }
        String format2 = context.getString(ResValue.getInstance().getId("am", "string"));
        return format2;
    }

    public static String getWeekDay(Context context) {
        Resources res = context.getResources();
        String[] weekdays = res.getStringArray(R.array.weekday);
        int weekday = Calendar.getInstance().get(7) - 1;
        int len = weekdays.length;
        return weekdays[Math.max(0, Math.min(weekday, len))];
    }

    public static String getMonth() {
        return String.valueOf(Calendar.getInstance().get(2) + 1);
    }

    public static String getDay() {
        return String.valueOf(Calendar.getInstance().get(5));
    }
}
