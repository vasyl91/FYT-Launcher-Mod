package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.SystemProperties;
import android.util.Log;
import android.widget.Toast;

import com.android.launcher66.settings.Helpers;
import com.syu.car.CarStates;
import com.syu.util.FytPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import share.Config;

public class AllAppsList {
    public static final int DEFAULT_APPLICATIONS_NUMBER = 42;
    public static ArrayList<AppInfo> data = new ArrayList<>(42);
    private AppFilter mAppFilter;
    private IconCache mIconCache;
    public ArrayList<AppInfo> added = new ArrayList<>(42);
    public ArrayList<AppInfo> removed = new ArrayList<>();
    public ArrayList<AppInfo> modified = new ArrayList<>();

    public AllAppsList(IconCache iconCache, AppFilter appFilter) {
        this.mIconCache = iconCache;
        this.mAppFilter = appFilter;
    }

    public void add(AppInfo info) {
        if ((this.mAppFilter == null || this.mAppFilter.shouldShowApp(info.componentName)) && !findActivity(data, info.componentName) && allowSettings(info)) {
            if (Config.CHIP_UIID != 5 || !info.componentName.getPackageName().equals(FytPackage.sysSetAction)) {
                if (Config.CUSTOMER_ID != 8 || (!info.componentName.getPackageName().equals(FytPackage.ludashiACTION) && !info.componentName.getPackageName().equals(FytPackage.abenchACTION))) {
                    switch (Config.CHIP_UIID) {
                        case 5:
                            if (LauncherApplication.bHideUniCar != null && LauncherApplication.bHideUniCar.equals("0") && info.componentName.getPackageName().equals("com.syu.unicar")) {
                                return;
                            }
                            break;
                    }
                    if (info.componentName.getPackageName().equals(FytPackage.GaodeACTION)) {
                        Config.EXISTAMPAUTO = true;
                        setDefaultNavi();
                    }
                    if (info.componentName.getPackageName().equals(FytPackage.voiceAction)) {
                        Config.EXISTVOICE = true;
                    }
                    data.add(info);
                    this.added.add(info);
                }
            }
        }
    }

    private boolean allowSettings(AppInfo info) {
        return !info.componentName.getPackageName().contains("com.android.launcher") 
        || info.componentName.getClassName().equals("com.android.launcher66.settings.SettingsActivity")
        || info.componentName.getPackageName().contains("leakcanary")
        || info.componentName.getClassName().contains("leakcanary");   
    } 

    public void clear() {
        data.clear();
        this.added.clear();
        this.removed.clear();
        this.modified.clear();
    }

    public int size() {
        return data.size();
    }

    public AppInfo get(int index) {
        return data.get(index);
    }

    public void addPackage(Context context, String packageName) {
        List<ResolveInfo> matches = findActivitiesForPackage(context, packageName);
        if (Config.CUSTOMER_ID != 8 || (!packageName.equals(FytPackage.ludashiACTION) && !packageName.equals(FytPackage.abenchACTION))) {
            if (Config.CHIP_UIID != 5 || !packageName.equals(FytPackage.sysSetAction)) {
                switch (Config.CHIP_UIID) {
                    case 5:
                        if (LauncherApplication.bHideUniCar != null && LauncherApplication.bHideUniCar.equals("0") && packageName.equals("com.syu.unicar")) {
                            return;
                        }
                        break;
                }
                if (matches.size() > 0) {
                    for (ResolveInfo info : matches) {
                        add(new AppInfo(context.getPackageManager(), info, this.mIconCache, null));
                    }
                }
            }
        }
    }

    public void removePackage(String packageName) {
        if (Config.CHIP_UIID == 6 && packageName.equals(FytPackage.dvdAction)) {
            LauncherApplication.isHaveDvd = false;
        }
        List<AppInfo> data2 = data;
        for (int i = data2.size() - 1; i >= 0; i--) {
            AppInfo info = data2.get(i);
            ComponentName component = info.intent.getComponent();
            if (packageName.equals(component.getPackageName())) {
                this.removed.add(info);
                data2.remove(i);
            }
            if (packageName.equals(FytPackage.GaodeACTION)) {
                Config.EXISTAMPAUTO = false;
            }
            if (packageName.equals(FytPackage.voiceAction)) {
                Config.EXISTVOICE = false;
            }
        }
        this.mIconCache.flush();
    }

    public void updatePackage(Context context, String packageName) {
        if (Config.CHIP_UIID == 6 && packageName.equals(FytPackage.dvdAction)) {
            LauncherApplication.isHaveDvd = true;
        }
        List<ResolveInfo> matches = findActivitiesForPackage(context, packageName);
        if (Config.CUSTOMER_ID != 8 || (!packageName.equals(FytPackage.ludashiACTION) && !packageName.equals(FytPackage.abenchACTION))) {
            if (Config.CHIP_UIID != 5 || !packageName.equals(FytPackage.sysSetAction)) {
                switch (Config.CHIP_UIID) {
                    case 5:
                        if (LauncherApplication.bHideUniCar != null && LauncherApplication.bHideUniCar.equals("0") && packageName.equals("com.syu.unicar")) {
                            return;
                        }
                        break;
                }
                if (packageName.equals(FytPackage.GaodeACTION)) {
                    Config.EXISTAMPAUTO = true;
                    setDefaultNavi();
                }
                if (packageName.equals(FytPackage.voiceAction)) {
                    Config.EXISTVOICE = true;
                }
                if (matches.size() > 0) {
                    for (int i = data.size() - 1; i >= 0; i--) {
                        AppInfo applicationInfo = data.get(i);
                        ComponentName component = applicationInfo.intent.getComponent();
                        if (packageName.equals(component.getPackageName()) && !findActivity(matches, component)) {
                            this.removed.add(applicationInfo);
                            this.mIconCache.remove(component);
                            data.remove(i);
                        }
                    }
                    int count = matches.size();
                    for (int i2 = 0; i2 < count; i2++) {
                        ResolveInfo info = matches.get(i2);
                        AppInfo applicationInfo2 = findApplicationInfoLocked(info.activityInfo.applicationInfo.packageName, info.activityInfo.name);
                        if (applicationInfo2 == null) {
                            add(new AppInfo(context.getPackageManager(), info, this.mIconCache, null));
                        } else {
                            this.mIconCache.remove(applicationInfo2.componentName);
                            this.mIconCache.getTitleAndIcon(applicationInfo2, info, null);
                            this.modified.add(applicationInfo2);
                        }
                    }
                    return;
                }
                for (int i3 = data.size() - 1; i3 >= 0; i3--) {
                    AppInfo applicationInfo3 = data.get(i3);
                    ComponentName component2 = applicationInfo3.intent.getComponent();
                    if (packageName.equals(component2.getPackageName())) {
                        this.removed.add(applicationInfo3);
                        this.mIconCache.remove(component2);
                        data.remove(i3);
                    }
                }
            }
        }
    }

    public boolean updatePackageExt(Context context, String packageName) {
        final List<ResolveInfo> matches = findActivitiesForPackage(context, packageName);
        if (matches.size() > 0) {
            // Find disabled/removed activities and remove them from data and add them
            // to the removed list.
            for (int i = data.size() - 1; i >= 0; i--) {
                final AppInfo applicationInfo = data.get(i);
                final ComponentName component = applicationInfo.intent.getComponent();
                if (packageName.equals(component.getPackageName())) {
                    if (!findActivity(matches, component)) {
                        removed.add(applicationInfo);
                        mIconCache.remove(component);
                        data.remove(i);
                    }
                }
            }

            // Find enabled activities and add them to the adapter
            // Also updates existing activities with new labels/icons
            int count = matches.size();
            for (int i = 0; i < count; i++) {
                final ResolveInfo info = matches.get(i);
                AppInfo applicationInfo = findApplicationInfoLocked(
                        info.activityInfo.applicationInfo.packageName,
                        info.activityInfo.name);
                if (applicationInfo == null) {
                    add(new AppInfo(context.getPackageManager(), info, mIconCache, null));
                } else {
                    mIconCache.remove(applicationInfo.componentName);
                    mIconCache.getTitleAndIcon(applicationInfo, info, null);
                    modified.add(applicationInfo);
                }
            }
        } else {
            // Remove all data for this package.
            for (int i = data.size() - 1; i >= 0; i--) {
                final AppInfo applicationInfo = data.get(i);
                final ComponentName component = applicationInfo.intent.getComponent();
                if (packageName.equals(component.getPackageName())) {
                    removed.add(applicationInfo);
                    mIconCache.remove(component);
                    data.remove(i);
                }
            }
            return true;
        }
        return false;
    }

    static List<ResolveInfo> findActivitiesForPackage(Context context, String packageName) {
        PackageManager packageManager = context.getPackageManager();
        Intent mainIntent = new Intent("android.intent.action.MAIN", (Uri) null);
        mainIntent.addCategory("android.intent.category.LAUNCHER");
        mainIntent.setPackage(packageName);
        List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
        return apps != null ? apps : new ArrayList<>();
    }

    private static boolean findActivity(List<ResolveInfo> apps, ComponentName component) {
        String className = component.getClassName();
        for (ResolveInfo info : apps) {
            ActivityInfo activityInfo = info.activityInfo;
            if (activityInfo.name.equals(className)) {
                return true;
            }
        }
        return false;
    }

    private static boolean findActivity(ArrayList<AppInfo> apps, ComponentName component) {
        int N = apps.size();
        for (int i = 0; i < N; i++) {
            AppInfo info = apps.get(i);
            if (info.componentName.equals(component)) {
                return true;
            }
        }
        return false;
    }

    private AppInfo findApplicationInfoLocked(String packageName, String className) {
        Iterator<AppInfo> it = data.iterator();
        while (it.hasNext()) {
            AppInfo info = it.next();
            ComponentName component = info.intent.getComponent();
            if (packageName.equals(component.getPackageName()) && className.equals(component.getClassName())) {
                return info;
            }
        }
        return null;
    }

    private void setDefaultNavi() {
        try {
            String naviPackage = SystemProperties.get("persist.sys.navi.packagename", "");
            if ((naviPackage.equals("") || naviPackage == null) && Helpers.isPackageInstalled(FytPackage.GaodeACTION)) {
                CarStates.getCar(LauncherApplication.sApp).mTools.sendStr(0, 9, FytPackage.GaodeACTION);
            }
        } catch (Exception e) {
            Toast.makeText(LauncherApplication.sApp, LauncherApplication.sApp.getString(R.string.init_default_app_error), Toast.LENGTH_LONG).show();
            Log.e("AllAppsList", "Failed to set default navi: " + e.getMessage());
        }
    }

    static List<ResolveInfo> findActivitysByIntent(Context context, Intent intent) {
        final PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> apps;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            apps = packageManager.queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PackageManager.GET_RESOLVED_FILTER));
        } else {
            // For API levels below 33
            @SuppressWarnings("deprecation")
            List<ResolveInfo> deprecatedApps = packageManager.queryIntentActivities(intent, PackageManager.GET_INTENT_FILTERS);
            apps = deprecatedApps;
        }
        return apps != null ? apps : new ArrayList<ResolveInfo>();
    }
}
