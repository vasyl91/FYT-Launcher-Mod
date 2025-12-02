package com.android.launcher66;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;

import com.syu.util.CustomIcons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AppInfo extends ItemInfo {
    static final int DOWNLOADED_FLAG = 1;
    private static final String TAG = "launcher66.AppInfo";
    static final int UPDATED_SYSTEM_APP_FLAG = 2;
    public ComponentName componentName;
    long firstInstallTime;
    int flags;
    public Bitmap iconBitmap;
    private int iconResid;
    public Intent intent;

    public int getIconResid() {
        return this.iconResid;
    }

    public void setIconResid(int iconResid) {
        this.iconResid = iconResid;
    }

    AppInfo() {
        this.flags = 0;
        this.itemType = 1;
    }

    @Override
    protected Intent getIntent() {
        return this.intent;
    }

    public AppInfo(PackageManager pm, ResolveInfo info, IconCache iconCache, HashMap<Object, CharSequence> labelCache) {
        this.flags = 0;
        String packageName = info.activityInfo.applicationInfo.packageName;
        this.componentName = new ComponentName(packageName, info.activityInfo.name);
        this.container = -1L;
        setActivity(this.componentName, Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
        try {
            PackageInfo pi = pm.getPackageInfo(packageName, 0);
            this.flags = initFlags(pi);
            this.firstInstallTime = initFirstInstallTime(pi);
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(TAG, "PackageManager.getApplicationInfo failed for " + packageName);
        }
        this.iconResid = CustomIcons.getIcon(info.activityInfo);
        iconCache.getTitleAndIcon(this, info, labelCache);
    }

    public static int initFlags(PackageInfo pi) {
        int appFlags = pi.applicationInfo.flags;
        if ((appFlags & 1) != 0) {
            return 0;
        }
        int flags = 0 | 1;
        if ((appFlags & 128) != 0) {
            return flags | 2;
        }
        return flags;
    }

    public static long initFirstInstallTime(PackageInfo pi) {
        return pi.firstInstallTime;
    }

    public AppInfo(AppInfo info) {
        super(info);
        this.flags = 0;
        this.componentName = info.componentName;
        this.title = info.title.toString();
        this.intent = new Intent(info.intent);
        this.flags = info.flags;
        this.firstInstallTime = info.firstInstallTime;
    }

    final void setActivity(ComponentName className, int launchFlags) {
        this.intent = new Intent("android.intent.action.MAIN");
        this.intent.addCategory("android.intent.category.LAUNCHER");
        this.intent.setComponent(className);
        this.intent.setFlags(launchFlags);
        this.itemType = 0;
    }

    @Override
    public String toString() {
        return "ApplicationInfo(title=" + this.title.toString() + " id=" + this.id + " type=" + this.itemType + " container=" + this.container + " screen=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " dropPos=" + this.dropPos + ")";
    }

    public static void dumpApplicationInfoList(String tag, String label, ArrayList<AppInfo> list) {
        Log.d(tag, String.valueOf(label) + " size=" + list.size());
        Iterator<AppInfo> it = list.iterator();
        while (it.hasNext()) {
            AppInfo info = it.next();
            Log.d(tag, "   title=\"" + ((Object) info.title) + "\" iconBitmap=" + info.iconBitmap + " firstInstallTime=" + info.firstInstallTime);
        }
    }

    public ShortcutInfo makeShortcut() {
        return new ShortcutInfo(this);
    }

    public String getPackageName() {
        if (this.intent != null) {
            String packageName = this.intent.getPackage();
            if (packageName == null && this.intent.getComponent() != null) {
                packageName = this.intent.getComponent().getPackageName();
            }
            if (packageName != null) {
                return packageName;
            }
        }
        return "";
    }

    public String getClassName() {
        if (this.componentName != null) {
            String className = this.componentName.getClassName();
            if (!TextUtils.isEmpty(className)) {
                return className;
            }
        }
        return "";
    }
}
