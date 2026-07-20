package com.syu.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.SystemClock;
import android.SystemProperties;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FytPackage {
    private static final String TAG = "FytPackage";
    private static final long NAVIGATION_CACHE_MS = 30000L;
    private static final Object sPackageCacheLock = new Object();
    private static final Map<String, Intent> sLaunchIntentCache = new HashMap<>();
    private static String sCachedNavigationPackage;
    private static long sCachedNavigationPackageAt;
    public static final String SYS_NAVI_PACKAGE = "persist.sys.navi.packagename";
    public static final String AddAction = "com.syu.add";
    public static final String AppAction = "com.android.launcher66";
    public static final String BTAVNEXTSERVICE = "com.syu.bt.byav.widgetNext";
    public static final String BTAVPLAYSERVICE = "com.syu.bt.byav.widgetPlayPause";
    public static final String BTAVPRESERVICE = "com.syu.bt.byav.widgetPrev";
    public static final String CARLIFEACTION = "com.baidu.carlifevehicle";
    public static final String CARRADIOACTION = "com.syu.carradio";
    public static final String DVRSERVICE = "com.syu.dvr.server.CollisionVideoService";
    public static final String GaodeACTION = "com.autonavi.amapauto";
    public static final String INNER360 = "com.syu.panoramic";
    public static final String INNER_DVR = "com.syu.dvr";
    public static final String KLFMACTION = "com.edog.car";
    public static final String KWACTION = "cn.kuwo.kwmusiccar";
    public static final String LAUNCHERMUSIC = "com.fyt.launcher.music";
    public static List<String> LOADED_LIST = null;
    public static final String LOCKACTION = "android.com.syu.dvr.action.LOCKE";
    public static final String NEXTSERVICE = "com.syu.music.next";
    public static final String OUT360 = "com.syu.camera360";
    public static final String OUTER_DVR = "com.syu.exdvr";
    public static final String PHOTOACTION = "android.com.syu.dvr.action.PHOTO";
    public static final String PLAYSERVICE = "com.syu.music.playpause";
    public static final String PRESERVICE = "com.syu.music.prev";
    public static final String RECACTION = "android.com.syu.dvr.action.RECORD";
    public static final String RechargeACTION = "com.syu.unicar";
    public static final String UNICARACTION = "com.syu.unicar";
    public static final String YKACTION = "com.youku.phone";
    public static final String abenchACTION = "com.antutu.ABenchMark";
    public static final String allappAction = "com.syu.allapps";
    public static final String auxAction = "com.syu.av";
    public static final String av2Action = "com.syu.av2";
    public static final String browserAction = "com.android.browser";
    public static final String btAction = "com.syu.bt";
    public static final String btavAction = "com.syu.btav";
    public static final String calculatorAction = "com.android.calculator2";
    public static final String calibrationAction = "com.syu.calibration";
    public static final String camera360 = "com.syu.camera360";
    public static final String carAction = "com.syu.car";
    public static final String carBus = "com.syu.canbus";
    public static final String carlifeACTION = "com.baidu.carlifevehicle";
    public static final String carlinkAction = "com.syu.carlink";
    public static final String cdcAction = "com.syu.cdc";
    public static final String chromeAction = "com.android.chrome";
    public static final String dvdAction = "com.syu.dvd";
    public static final String easyAction = "net.easyconn";
    public static final String easyconnACTION = "net.easyconn";
    public static final String ecarAction = "com.coagent.ecar";
    public static final String ecarOnlineClassName = "com.coagent.ecarnet.car.activity.WelcomeActivity";
    public static final String eqACTION = "com.syu.eq";
    public static final String extireAction = "com.cz.usbserial.tpms";
    public static final String filemanagerAction = "com.syu.filemanager";
    public static final String fourcamera2Action = "com.syu.fourcamera2";
    public static final String frontvideoAction = "com.syu.frontvideo";
    public static final String galleryAction = "com.syu.gallery";
    public static final String gpsAction = "com.syu.gps";
    public static final String guideAction = "com.syu.guide";
    public static final String hicarAction = "com.syu.hicar";
    public static final String hongfansAction = "com.hongfans.rearview";
    public static final String ipodAction = "com.syu.ipod";
    public static final String ludashiACTION = "com.ludashi.benchmark";
    public static final String mapsAction = "com.google.android.apps.maps";
    public static final String miudriveAction = "com.didi365.miudrive.navi";
    public static final String mp3Action = "com.syu.music";
    public static final String naviAction = "com.syu.onekeynavi";
    public static final String radarAction = "com.syu.radar";
    public static final String radioAction = "com.syu.radio";
    public static final String settingAction = "com.syu.settings";
    public static final String sosAction = "com.ecar.assistantnew";
    public static final String spotifyAction = "com.spotify.music";
    public static final String steerACTION = "com.syu.steer";
    public static final String sysSetAction = "com.android.settings";
    public static final String tireAction = "com.syu.tire";
    public static final String tvAction = "com.syu.tv";
    public static final String videoAction = "com.syu.video";
    public static final String voiceAction = "com.syu.voice";
    public static final String youtubeAction = "com.google.android.youtube";
    public static final String GMAPS = "com.google.android.apps.maps";
    public static final String WAZE = "com.waze";
    public static final String[] NAVIGATION_PACKAGE_CANDIDATES = {
        GMAPS,
        WAZE,
        miudriveAction,
        GaodeACTION,
        naviAction
    };
    private static final String[] NAVIGATION_KEYWORDS = {
        "maps",
        "map",
        "navi",
        "navigation",
        "navigate",
        "gps",
        "waze",
        "amap",
        "gaode",
        "miudrive"
    };
    

    static {
        LOADED_LIST = null;
        LOADED_LIST = new ArrayList<>();
        LOADED_LIST.add("com.syu.music");
        LOADED_LIST.add(dvdAction);
        LOADED_LIST.add(auxAction);
        LOADED_LIST.add("com.syu.bt");
        LOADED_LIST.add("com.syu.settings");
        LOADED_LIST.add(tvAction);
        LOADED_LIST.add("com.syu.video");
        LOADED_LIST.add(steerACTION);
    }

    public static Intent getIntent(Context context, String pkg) {
        Intent launchIntent = getLaunchIntent(context, pkg);
        if (launchIntent != null) {
            return launchIntent;
        }

        Intent mainIntent;
        Intent intent;
        if (pkg.equals(sysSetAction)) {
            intent = new Intent("android.settings.SETTINGS");
            mainIntent = new Intent("android.settings.SETTINGS", null);
        } else {
            mainIntent = new Intent(Intent.ACTION_MAIN, null);
            intent = new Intent(Intent.ACTION_MAIN);
        }
        mainIntent.setPackage(pkg);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo res : apps) {
            if (res.activityInfo.packageName.equals(pkg)) {
                intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            }
        }
        return intent;
    }

    public static String resolveNavigationPackage(Context context) {
        long now = SystemClock.uptimeMillis();
        synchronized (sPackageCacheLock) {
            if (sCachedNavigationPackage != null
                    && now - sCachedNavigationPackageAt < NAVIGATION_CACHE_MS) {
                return sCachedNavigationPackage;
            }
        }

        String resolvedPackage = resolveNavigationPackageUncached(context);
        synchronized (sPackageCacheLock) {
            sCachedNavigationPackage = resolvedPackage;
            sCachedNavigationPackageAt = now;
        }
        return resolvedPackage;
    }

    private static String resolveNavigationPackageUncached(Context context) {
        String configuredPackage = SystemProperties.get(SYS_NAVI_PACKAGE, "");
        if (isNavigationPackage(context, configuredPackage)) {
            return configuredPackage;
        }

        for (String packageName : NAVIGATION_PACKAGE_CANDIDATES) {
            if (isPackageInstalled(context, packageName)) {
                return packageName;
            }
        }

        return findNavigationPackageFromLaunchers(context);
    }

    public static boolean setDefaultNavigationPackage(String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        try {
            SystemProperties.set(SYS_NAVI_PACKAGE, packageName);
            synchronized (sPackageCacheLock) {
                sCachedNavigationPackage = packageName;
                sCachedNavigationPackageAt = SystemClock.uptimeMillis();
            }
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Failed to set default navigation package: " + packageName, e);
            return false;
        }
    }

    public static boolean isNavigationPackage(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName) || !isPackageInstalled(context, packageName)) {
            return false;
        }

        for (String candidate : NAVIGATION_PACKAGE_CANDIDATES) {
            if (candidate.equals(packageName)) {
                return true;
            }
        }

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mainIntent.setPackage(packageName);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo resolveInfo : apps) {
            if (looksLikeNavigation(resolveInfo, packageManager)) {
                return true;
            }
        }
        return false;
    }

    public static Intent getLaunchIntent(Context context, String pkg) {
        if (context == null || TextUtils.isEmpty(pkg)) {
            return null;
        }

        synchronized (sPackageCacheLock) {
            Intent cached = sLaunchIntentCache.get(pkg);
            if (cached != null) {
                return new Intent(cached);
            }
        }

        if (sysSetAction.equals(pkg)) {
            Intent settingsIntent = new Intent("android.settings.SETTINGS");
            settingsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            return cacheLaunchIntent(pkg, settingsIntent);
        }

        if (GaodeACTION.equals(pkg)) {
            Intent gaodeUsbIntent = getExplicitIntentIfActivityExists(
                    context,
                    GaodeACTION,
                    "com.autonavi.auto.remote.fill.UsbFillActivity"
            );
            if (gaodeUsbIntent != null) {
                return cacheLaunchIntent(pkg, gaodeUsbIntent);
            }
        }

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mainIntent.setPackage(pkg);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo res : apps) {
            if (res.activityInfo.packageName.equals(pkg)) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
                intent.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
                return cacheLaunchIntent(pkg, intent);
            }
        }

        Intent fallback = packageManager.getLaunchIntentForPackage(pkg);
        if (fallback != null) {
            fallback.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            return cacheLaunchIntent(pkg, fallback);
        }
        return null;
    }

    private static Intent cacheLaunchIntent(String packageName, Intent intent) {
        if (intent == null) {
            return null;
        }
        synchronized (sPackageCacheLock) {
            sLaunchIntentCache.put(packageName, new Intent(intent));
        }
        return new Intent(intent);
    }

    public static void invalidatePackageCache() {
        synchronized (sPackageCacheLock) {
            sLaunchIntentCache.clear();
            sCachedNavigationPackage = null;
            sCachedNavigationPackageAt = 0L;
        }
    }

    private static Intent getExplicitIntentIfActivityExists(Context context, String packageName, String className) {
        try {
            ComponentName componentName = new ComponentName(packageName, className);
            ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, 0);
            if (activityInfo == null) {
                return null;
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            intent.setComponent(componentName);
            return intent;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    private static boolean isPackageInstalled(Context context, String packageName) {
        if (context == null || TextUtils.isEmpty(packageName)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static String findNavigationPackageFromLaunchers(Context context) {
        if (context == null) {
            return "";
        }
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        for (ResolveInfo resolveInfo : apps) {
            if (looksLikeNavigation(resolveInfo, packageManager)) {
                return resolveInfo.activityInfo.packageName;
            }
        }
        return "";
    }

    private static boolean looksLikeNavigation(ResolveInfo resolveInfo, PackageManager packageManager) {
        if (resolveInfo == null || resolveInfo.activityInfo == null) {
            return false;
        }
        String packageName = resolveInfo.activityInfo.packageName;
        String className = resolveInfo.activityInfo.name;
        CharSequence label = resolveInfo.loadLabel(packageManager);
        return containsNavigationKeyword(packageName)
                || containsNavigationKeyword(className)
                || containsNavigationKeyword(label != null ? label.toString() : "");
    }

    private static boolean containsNavigationKeyword(String value) {
        if (TextUtils.isEmpty(value)) {
            return false;
        }
        String lowerValue = value.toLowerCase();
        for (String keyword : NAVIGATION_KEYWORDS) {
            if (lowerValue.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
