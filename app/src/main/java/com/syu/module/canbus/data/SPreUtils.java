package com.syu.module.canbus.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SPreUtils {
    private static SharedPreferences mSp;

    public SPreUtils(Context context) {
        checkmSp(context);
    }

    private static void checkmSp(Context context) {
        if (mSp == null) {
            mSp = context.getSharedPreferences("wc_jingyix5", 0);
        }
    }

    public static String get(Context context, String flag, String defVal) {
        checkmSp(context);
        String val = mSp.getString(flag, defVal);
        return val;
    }

    public static void set(Context context, String flag, String val) {
        checkmSp(context);
        mSp.edit().putString(flag, val).commit();
    }
}
