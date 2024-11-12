package com.syu.util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.android.launcher66.LauncherAppState;
import com.android.launcher66.LauncherApplication;
import java.util.List;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
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
            return res.getBoolean(res.getIdentifier(name, "bool", getCtx().getPackageName()));
        } catch (Exception e) {
            return false;
        }
    }

    public static String getNameToStr(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getString(res.getIdentifier(name, "string", getCtx().getPackageName()));
        } catch (Exception e) {
            return "";
        }
    }

    public static int getNameToInteger(String name) {
        try {
            Resources res = getCtx().getResources();
            return res.getInteger(res.getIdentifier(name, "integer", getCtx().getPackageName()));
        } catch (Exception e) {
            return 0;
        }
    }

    public static boolean topApp() {
        try {
            ActivityManager manager = (ActivityManager) getCtx().getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> info = manager.getRunningTasks(1);
            for (ActivityManager.RunningTaskInfo runningTaskInfo : info) {
                Log.d("LZP", "topActivity:" + runningTaskInfo.topActivity.getPackageName() + "baseActivity:" + runningTaskInfo.baseActivity.getPackageName());
                if (runningTaskInfo.topActivity.getPackageName().equals(getCtx().getPackageName()) || runningTaskInfo.baseActivity.getPackageName().equals(getCtx().getPackageName())) {
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
}
