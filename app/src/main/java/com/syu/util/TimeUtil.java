package com.syu.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;

import com.android.launcher66.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class TimeUtil {
    public static String getDateOfToday(Context context, String format) {
        return new SimpleDateFormat(format).format(Calendar.getInstance().getTime());
    }

    public static String getCurrentTime(Context context) {
        String format;
        boolean b24 = DateFormat.is24HourFormat(context);
        if (b24) {
            format = "H:mm";
        } else {
            format = "h:mm";
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

    public static String getAmPm(Context context) {
        boolean b24 = DateFormat.is24HourFormat(context);
        int flag = Calendar.getInstance().get(9);
        if (b24) {
            return "";
        }
        return flag == 0 ? "AM" : "PM";
    }

    public static String getWeekDay(Context context) {
        Resources res = context.getResources();
        String[] weekdays = res.getStringArray(R.array.weekday);
        int weekday = Calendar.getInstance().get(7) - 1;
        int len = weekdays.length;
        return weekdays[Math.max(0, Math.min(weekday, len))];
    }

    public static String getMonth() {
        return new StringBuilder().append(Calendar.getInstance().get(2) + 1).toString();
    }

    public static String getDay() {
        return new StringBuilder().append(Calendar.getInstance().get(5)).toString();
    }
}
