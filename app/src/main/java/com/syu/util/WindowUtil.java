package com.syu.util;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;

import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.Workspace;
import com.android.launcher66.settings.Helpers;
import com.fyt.car.MapConfig;
import com.fyt.thread.ThreadManager;
import com.syu.ipc.data.FinalCanbus;
import com.syu.log.LogPreview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WindowUtil {
    private static final String TAG = "WindowUtil";
    private static Intent intent;
    private static IActivityManager mActivityManager;
    public static String AppPackageName = "";
    public static boolean visible = true;
    public static int delayMillis = 0;
    public static final String PIP_STARTED = "pip.started";
    public static final String PIP_REMOVED = "pip.removed";

    public static void initDefaultApp() {
        intent = new Intent();
        removePip(null);
        AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
        if (AppPackageName.isEmpty()) {
            SystemProperties.set("persist.launcher.packagename", FytPackage.GaodeACTION);
            AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
        }
    }

    public static void startMapPip(final View v, final boolean show) {
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(v, show);
            }
        });
    }

    public static void startMapPip(final View v, final boolean show, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.openPip(v, show);
            }
        });
    }

    public static void removePip(final View v, int millis) {
        delayMillis = millis;
        ThreadManager.getLongPool().execute(new Runnable() {
            @Override
            public void run() {
                WindowUtil.removePip(v);
            }
        });
    }

    public static void openPip(View v, boolean show) {
        LogPreview.show("startMapPip:" + AppPackageName);
        Log.d("LZP", "openPip..");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout && userStats) {
            Helpers.pipStarted = true;
            Helpers.foregroundAppOpened = false;
            Helpers.inAllApps = false;
            Helpers.isInRecent = false;
            Helpers.overviewMode = false;
            Intent intentpip = new Intent(PIP_STARTED);
            LauncherApplication.sApp.sendBroadcast(intentpip);
        }
        if ((!visible || show) && Utils.topApp()) {
            intent = FytPackage.getIntent(LauncherApplication.sApp, AppPackageName);

            if (AppPackageName.equals("com.syu.camera360")) {
                Launcher.mLauncher.sendBroadcast(new Intent("com.syu.camera360.show"));
            }
            Launcher.getLauncher().handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    try {
                        WindowUtil.intent.putExtra("force_pip", true);
                        SystemProperties.set("sys.lsec.force_pip", "true");
                        LauncherApplication.sApp.startActivity(WindowUtil.intent);
                    } catch (ActivityNotFoundException e) {
                    }
                }
            }, delayMillis);
            visible = true;
            delayMillis = 0;
        }
    }

    public static void restartPipApp() {
        ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        try {
            Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
            forceStopPackage.setAccessible(true);
            forceStopPackage.invoke(activityManager, AppPackageName);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void removePip(View v) {
        Log.d("LZP", "removePip..");
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        boolean userLayout = prefs.getBoolean("user_layout", false);
        boolean userStats = prefs.getBoolean("user_stats", false);
        if (userLayout && userStats) {
            if (!Helpers.foregroundAppOpened && !Helpers.isInRecent && !Helpers.inAllApps) {
                Helpers.pipStarted = false;
                Intent intent = new Intent(PIP_REMOVED);
                LauncherApplication.sApp.sendBroadcast(intent);
            } else if (Helpers.overviewMode) {
                Intent intentOverview = new Intent(Workspace.OVERVIEW_MODE_OPEN);
                LauncherApplication.sApp.sendBroadcast(intentOverview);
            }
        }
        if (visible) {
            mActivityManager = ActivityManager.getService();
            Launcher.getLauncher().handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (WindowUtil.AppPackageName.equals("com.syu.camera360")) {
                        LauncherApplication.sApp.sendBroadcast(new Intent("com.syu.camera360.hide"));
                    }
                    WindowUtil.mActivityManager.setPinnedStackVisible(false);
                }
            }, delayMillis);
            if (AppPackageName.equals(FytPackage.GaodeACTION)) {
                try {
                    LauncherApplication.sApp.removeGaoDeCoverView();
                } catch (Exception e) {
                }
            }
            visible = false;
            delayMillis = 0;
            return;
        }
        LogPreview.show("WindowUtil ------ removePip");
    }

    public static void sendBROADCAST(boolean show) {
        Intent intent2 = new Intent();
        intent2.setAction("FOURCAMERA2_BROADCAST_RECV");
        Bundle bundle = new Bundle();
        bundle.putBoolean("SHOW", show);
        bundle.putInt(MapConfig.KEY_TYPE, 10000);
        if (Utils.getRes().getDisplayMetrics().widthPixels == 1024) {
            bundle.putInt("POS_X", FinalCanbus.CAR_0397);
            bundle.putInt("POS_Y", FinalCanbus.CAR_XP2_OPEL);
            bundle.putInt("POS_W", 614);
            bundle.putInt("POS_H", FinalCanbus.CAR_FYT_WC1_15YiDong);
        } else {
            bundle.putInt("POS_X", 495);
            bundle.putInt("POS_Y", FinalCanbus.CAR_RZC_XP1_JiangHuaiRuiFengS3);
            bundle.putInt("POS_W", 770);
            bundle.putInt("POS_H", 432);
        }
        intent2.putExtras(bundle);
        LauncherApplication.sApp.sendBroadcast(intent2);
    }

    private static boolean checkAppInstalled(String packageName) {
        PackageInfo packageInfo;
        if (packageName == null || packageName.isEmpty()) {
            return false;
        }
        try {
            packageInfo = LauncherApplication.sApp.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        return packageInfo != null;
    }
}
