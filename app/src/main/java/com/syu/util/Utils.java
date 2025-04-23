package com.syu.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;

import com.android.launcher66.LauncherAppState;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.lang.reflect.Field;
import java.util.List;

public class Utils {
    public static LauncherApplication getCtx() {
        return LauncherApplication.sApp;
    }

    public static Resources getRes() {
        return getCtx().getResources();
    }

    public static SharedPreferences getSp() {
        return LauncherApplication.sApp.getSharedPreferences(LauncherAppState.getSharedPreferencesKey(), 0);
    }

    public static boolean getNameToBool(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getBoolean(getId(name, "bool"));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getNameToStr(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getString(getId(name, "string"));
        } catch (Exception e) {
            return "";
        }
    }

    public static int getNameToInteger(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getInteger(getId(name, "integer"));
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean topApp() {
        try {
            ActivityManager activityManager = (ActivityManager) getCtx().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            for(ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND 
                && appProcess.importanceReasonCode == ActivityManager.RunningAppProcessInfo.REASON_UNKNOWN
                && appProcess.processName.equals(getCtx().getPackageName())) { 
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean topApp(String packageName) {
        try {
            ActivityManager activityManager = (ActivityManager) getCtx().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            for(ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND 
                && appProcess.importanceReasonCode == ActivityManager.RunningAppProcessInfo.REASON_UNKNOWN
                && appProcess.processName.equals(packageName)) { 
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void setTextId(TextView v, int id) {
        if (v != null) {
            v.setText(id);
        }
    }

    public static void setTextStr(TextView v, String str) {
        if (v != null) {
            v.setText(str);
        }
    }

    public static void setGone(View v) {
        if (v != null) {
            v.setVisibility(View.GONE);
        }
    }

    public static void setVisible(View v) {
        if (v != null) {
            v.setVisibility(View.VISIBLE);
        }
    }

    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    public static int getId(String name, String type) {
        switch (type) {
            case "string":
                return getResId(name, R.string.class);
            case "bool":
                return getResId(name, R.bool.class);
            case "integer":
                return getResId(name, R.integer.class);
            default:
                return -1;
        }
    }
}
