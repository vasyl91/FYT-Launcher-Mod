package com.syu.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.view.View;
import android.view.WindowManager;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ObjApp {
    private static ActivityManager sActivityManager;
    private static AssetManager sAssetManager;
    private static AudioManager sAudioManager;
    private static ContentResolver sContentResolver;
    private static DebugView sDebugView;
    private static InfoView sInfoView;
    private static LocationManager sLocationManager;
    private static PackageManager sPackageManager;
    private static Point sPoint = new Point();
    private static PowerManager sPowerManager;
    private static Resources sResources;
    private static View sRootView;
    private static WifiManager sWifiManager;
    private static WindowManager sWindowManager;

    public static void init(Application app) {
        sDebugView = new DebugView(app);
        sInfoView = new InfoView(app);
        sAssetManager = app.getAssets();
        sResources = app.getResources();
        sPackageManager = app.getPackageManager();
        sActivityManager = (ActivityManager) app.getSystemService("activity");
        sWindowManager = (WindowManager) app.getSystemService("window");
        sAudioManager = (AudioManager) app.getSystemService("audio");
        sContentResolver = app.getContentResolver();
        sWifiManager = (WifiManager) app.getSystemService("wifi");
        sPowerManager = (PowerManager) app.getSystemService("power");
        sRootView = new View(app);
        sLocationManager = (LocationManager) app.getSystemService("location");
        sWindowManager.getDefaultDisplay().getSize(sPoint);
    }

    public static int getWidth() {
        return sPoint.x;
    }

    public static int getHeight() {
        return sPoint.y;
    }

    public static LocationManager getLocationManager() {
        return sLocationManager;
    }

    public static View getRootView() {
        return sRootView;
    }

    public static DebugView getMsgView() {
        return sDebugView;
    }

    public static InfoView getInfoView() {
        return sInfoView;
    }

    public static AssetManager getAssetManager() {
        return sAssetManager;
    }

    public static Resources getResources() {
        return sResources;
    }

    public static PackageManager getPackageManager() {
        return sPackageManager;
    }

    public static ActivityManager getActivityManager() {
        return sActivityManager;
    }

    public static WindowManager getWindowManager() {
        return sWindowManager;
    }

    public static AudioManager getAudioManager() {
        return sAudioManager;
    }

    public static PowerManager getPowerManager() {
        return sPowerManager;
    }

    public static WifiManager getWifiManager() {
        return sWifiManager;
    }

    public static ContentResolver getContentResolver() {
        return sContentResolver;
    }
}
