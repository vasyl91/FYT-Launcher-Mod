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
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;
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
    public static final String PIP_REMOVED = "pip.removed";

    public static void initDefaultApp() {
        try {           
            intent = new Intent();
            removePip(null);
            AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
            PackageManager packageManager = LauncherApplication.sApp.getPackageManager();
            if (AppPackageName.isEmpty() || AppPackageName == null) {
                if (Helpers.isPackageInstalled(FytPackage.GMAPS, packageManager)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.GMAPS);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                } else if (Helpers.isPackageInstalled(FytPackage.WAZE, packageManager)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.WAZE);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                } else if (Helpers.isPackageInstalled(FytPackage.GaodeACTION, packageManager)) {
                    SystemProperties.set("persist.launcher.packagename", FytPackage.GaodeACTION);
                    AppPackageName = SystemProperties.get("persist.launcher.packagename", "");
                }              
            }
        } catch (Exception e) {
            String message = LauncherApplication.sApp.getString(R.string.init_default_app_error);
            Toast.makeText(LauncherApplication.sApp, message, Toast.LENGTH_LONG).show();
            Log.e(TAG, "Failed to init default app: " + e.getMessage());
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
        try {
            Helpers helpers = new Helpers();
            if (show || (Utils.topApp()
                && !AppPackageName.isEmpty()
                && AppPackageName != null
                && !helpers.isInOverviewMode()
                && !helpers.isFirstPreferenceWindow()
                && !helpers.isWallpaperWindow()
                || (!helpers.userWasInRecents() && helpers.isListOpen()))) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);

                Log.d(TAG, "openPip: " + AppPackageName);
                intent = FytPackage.getIntent(LauncherApplication.sApp, AppPackageName);

                if (AppPackageName.equals("com.syu.camera360")) {
                    Launcher.mLauncher.sendBroadcast(new Intent("com.syu.camera360.show"));
                }

                Launcher.getLauncher().handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Launcher.getLauncher().pipOverview();

                        boolean userLayout = prefs.getBoolean("user_layout", false);
                        boolean userMap = prefs.getBoolean("user_map", true);
                        if (userMap || !userLayout) {
                            WindowUtil.intent.putExtra("force_pip", true);
                            WindowUtil.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            SystemProperties.set("sys.lsec.force_pip", "true");
                            if (WindowUtil.intent.resolveActivity(LauncherApplication.sApp.getPackageManager()) != null) {
                                LauncherApplication.sApp.startActivity(WindowUtil.intent);
                            }
                        }        
                    }
                }, delayMillis);
                
                visible = true;
                delayMillis = 0;
                helpers.setFirstPreferenceWindow(false);
                helpers.setWallpaperWindow(false);
                helpers.setWasInRecents(false);
            }
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void restartPipApp() {
        if (!AppPackageName.isEmpty() && AppPackageName != null) {
            ActivityManager activityManager = (ActivityManager) LauncherApplication.sApp.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            try {
                Method forceStopPackage = activityManager.getClass().getDeclaredMethod("forceStopPackage", String.class);
                forceStopPackage.setAccessible(true);
                forceStopPackage.invoke(activityManager, AppPackageName);
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void removePip(View v) {
        if (visible) {
            Log.d(TAG, "removePip..");
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            boolean userLayout = prefs.getBoolean("user_layout", false);
            boolean userStats = prefs.getBoolean("user_stats", false);
            if (userLayout && userStats) {
                Helpers helpers = new Helpers();
                if (!helpers.isForegroundAppOpened() && !helpers.isInRecent() && !helpers.isInAllApps()) {
                    helpers.setPipStarted(false);
                    Intent intent = new Intent(PIP_REMOVED);
                    LauncherApplication.sApp.sendBroadcast(intent);
                } else if (helpers.isInOverviewMode()) {
                    Intent intentOverview = new Intent(Workspace.OVERVIEW_MODE_OPEN);
                    LauncherApplication.sApp.sendBroadcast(intentOverview);
                }
            }
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
                    e.printStackTrace();
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