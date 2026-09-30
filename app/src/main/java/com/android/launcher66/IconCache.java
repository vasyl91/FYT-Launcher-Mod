package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;

import com.fyt.skin.SkinUtils;
import com.syu.ipc.data.FinalCanbus;
import com.syu.util.CustomIcons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IconCache {
    private static final int INITIAL_ICON_CACHE_CAPACITY = 50;
    private static final String TAG = "Launcher.IconCache";
    private final HashMap<ComponentName, CacheEntry> mCache = new HashMap<>(50);
    private final Context mContext;
    private final Bitmap mDefaultIcon;
    private int mIconDpi;
    private final PackageManager mPackageManager;
    /** Titles and icons kept between process starts; see AppIconDiskCache. */
    private final AppIconDiskCache mDiskCache;
    /** Whether mDiskCache knows the size icons are rendered at (see ensureDiskIconSizeLocked()). */
    private boolean mDiskIconSizeKnown;

    private static class CacheEntry {
        public Bitmap icon;
        public String title;

        private CacheEntry() {
        }

        /* synthetic */ CacheEntry(CacheEntry cacheEntry) {
            this();
        }
    }

    public IconCache(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
        this.mIconDpi = FinalCanbus.CAR_WeiChi2_ChangChengH2;
        this.mDefaultIcon = makeDefaultIcon();
        this.mDiskCache = AppIconDiskCache.get(context);
    }

    public Drawable getFullResDefaultActivityIcon() {
        return getFullResIcon(Resources.getSystem(), android.R.mipmap.sym_def_app_icon);
    }

    public Drawable getFullResIcon(Resources resources, int iconId) {
        Drawable d;
        try {
            d = resources.getDrawableForDensity(iconId, this.mIconDpi, new ContextThemeWrapper(this.mContext, R.style.AppTheme).getTheme());
        } catch (Resources.NotFoundException e) {
            d = null;
        }
        if (d != null) {
            return d;
        }
        Drawable d2 = getFullResDefaultActivityIcon();
        return d2;
    }

    public Drawable getFullResIcon(String packageName, int iconId) {
        Resources resources;
        try {
            resources = this.mPackageManager.getResourcesForApplication(packageName);
        } catch (PackageManager.NameNotFoundException e) {
            resources = null;
        }
        if (resources != null && iconId != 0) {
            return getFullResIcon(resources, iconId);
        }
        return getFullResDefaultActivityIcon();
    }

    public Drawable getFullResIcon(ResolveInfo info) {
        return getFullResIcon(info.activityInfo);
    }

    public Drawable getFullResIcon(ActivityInfo info) {
        Resources resources;
        int iconId;
        int resid = CustomIcons.getIcon(info);
        if (resid > 0) {
            return ContextCompat.getDrawable(this.mContext, resid);
        }
        try {
            resources = this.mPackageManager.getResourcesForApplication(info.applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            resources = null;
        }
        if (resources != null && (iconId = info.getIconResource()) != 0) {
            return getFullResIcon(resources, iconId);
        }
        return getFullResDefaultActivityIcon();
    }

    private Bitmap makeDefaultIcon() {
        Drawable d = getFullResDefaultActivityIcon();
        Bitmap b = Bitmap.createBitmap(Math.max(d.getIntrinsicWidth(), 1), Math.max(d.getIntrinsicHeight(), 1), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        d.setBounds(0, 0, b.getWidth(), b.getHeight());
        d.draw(c);
        c.setBitmap(null);
        return b;
    }

    public void remove(ComponentName componentName) {
        synchronized (this.mCache) {
            this.mCache.remove(componentName);
        }
        this.mDiskCache.remove(componentName);
    }

    public void flush() {
        synchronized (this.mCache) {
            this.mCache.clear();
        }
        this.mDiskCache.clear();
    }

    public void flushInvalidIcons(DeviceProfile grid) {
        synchronized (this.mCache) {
            // The icon size may have changed with the grid: measure it again before the disk
            // cache hands out another icon.
            this.mDiskIconSizeKnown = false;
            Iterator<Map.Entry<ComponentName, CacheEntry>> it = this.mCache.entrySet().iterator();
            while (it.hasNext()) {
                CacheEntry e = it.next().getValue();
                if (e.icon.getWidth() != grid.iconSizePx || e.icon.getHeight() != grid.iconSizePx) {
                    it.remove();
                }
            }
        }
    }

    public void getTitleAndIcon(AppInfo application, ResolveInfo info, HashMap<Object, CharSequence> labelCache) {
        synchronized (this.mCache) {
            CacheEntry entry = cacheLocked(application.componentName, info, labelCache);
            application.title = entry.title;
            application.iconBitmap = setIcon(application.getPackageName(), entry, info);
        }
    }

    public Bitmap getIcon(Intent intent) {
        Bitmap bitmap;
        synchronized (this.mCache) {
            ResolveInfo resolveInfo = getReolveInfo(intent);
            ComponentName component = intent.getComponent();
            if (resolveInfo == null || component == null) {
                bitmap = this.mDefaultIcon;
            } else {
                CacheEntry entry = cacheLocked(component, resolveInfo, null);
                bitmap = setIcon(component.getPackageName(), entry, resolveInfo);
            }
        }
        return bitmap;
    }

    public ResolveInfo getReolveInfo(Intent intent) {
        return this.mPackageManager.resolveActivity(intent, 0);
    }

    public Bitmap getIcon(ComponentName component, ResolveInfo resolveInfo, HashMap<Object, CharSequence> labelCache) {
        Bitmap bitmap;
        synchronized (this.mCache) {
            if (resolveInfo == null || component == null) {
                bitmap = null;
            } else {
                CacheEntry entry = cacheLocked(component, resolveInfo, labelCache);
                bitmap = setIcon(component.getPackageName(), entry, resolveInfo);
            }
        }
        return bitmap;
    }

    public boolean isDefaultIcon(Bitmap icon) {
        return this.mDefaultIcon == icon;
    }

    private Bitmap setIcon(String packageName, CacheEntry entry, ResolveInfo info) {
        SkinUtils.getResources();
        int resid = CustomIcons.getIcon(info.activityInfo);
       return resid != 0 ? Utilities.createIconBitmap_enlarge(SkinUtils.getDrawable(resid)) : Utilities.createIconBitmap_minify(new BitmapDrawable(this.mContext.getResources(), entry.icon));
    }

    private CacheEntry cacheLocked(ComponentName componentName, ResolveInfo info, HashMap<Object, CharSequence> labelCache) {
        CacheEntry entry = this.mCache.get(componentName);
        if (entry == null) {
            entry = new CacheEntry(null);
            this.mCache.put(componentName, entry);
            // Title and icon come from the disk cache while the app's APK is unchanged; otherwise
            // (and the first time) they are read from the APK as before, and then remembered.
            ApplicationInfo appInfo = info.activityInfo != null ? info.activityInfo.applicationInfo : null;
            ComponentName key = LauncherModel.getComponentNameFromResolveInfo(info);
            if (labelCache != null && labelCache.containsKey(key)) {
                entry.title = labelCache.get(key).toString();
            } else {
                String cachedTitle = this.mDiskCache.getTitle(componentName, appInfo);
                entry.title = cachedTitle != null ? cachedTitle : info.loadLabel(this.mPackageManager).toString();
                if (labelCache != null) {
                    labelCache.put(key, entry.title);
                }
            }
            if (entry.title == null) {
                entry.title = info.activityInfo.name;
            }
            ensureDiskIconSizeLocked();
            Bitmap cachedIcon = this.mDiskCache.getIcon(componentName, appInfo);
            entry.icon = cachedIcon != null ? cachedIcon : Utilities.createIconBitmap(getFullResIcon(info), this.mContext);
            this.mDiskCache.putTitleAndIcon(componentName, appInfo, entry.title, entry.icon);
        }
        return entry;
    }

    /**
     * Tells the disk cache the size icons are rendered at, measured on the default icon, so an icon
     * of another size (after a grid change) is never taken from disk. Called under mCache.
     */
    private void ensureDiskIconSizeLocked() {
        if (this.mDiskIconSizeKnown) {
            return;
        }
        this.mDiskIconSizeKnown = true;
        try {
            Bitmap probe = Utilities.createIconBitmap(getFullResDefaultActivityIcon(), this.mContext);
            this.mDiskCache.setIconSize(probe.getWidth(), probe.getHeight());
        } catch (RuntimeException e) {
            this.mDiskCache.setIconSize(0, 0); // size unknown: no icon from disk
        }
    }

    /**
     * Puts the titles the disk cache still has for these activities into labelCache, keyed as
     * LauncherModel.ShortcutNameComparator reads it, so sorting the app list does not open every
     * APK for its label: 1.4-2.4 s at a cold start, 12.6 s during the boot-time freeze.
     */
    public void prefillLabels(List<ResolveInfo> infos, HashMap<Object, CharSequence> labelCache) {
        if (infos == null || labelCache == null) {
            return;
        }
        for (ResolveInfo info : infos) {
            if (info == null || info.activityInfo == null) {
                continue;
            }
            ComponentName key = LauncherModel.getComponentNameFromResolveInfo(info);
            if (labelCache.containsKey(key)) {
                continue;
            }
            String title = this.mDiskCache.getTitle(key, info.activityInfo.applicationInfo);
            if (title != null) {
                labelCache.put(key, title.trim());
            }
        }
    }

    /** Install time kept for this activity's app, or -1 if the disk cache does not know it. */
    public long getCachedFirstInstallTime(ComponentName componentName, ApplicationInfo appInfo) {
        return this.mDiskCache.getFirstInstallTime(componentName, appInfo);
    }

    public void putFirstInstallTime(ComponentName componentName, ApplicationInfo appInfo, long firstInstallTime) {
        this.mDiskCache.putFirstInstallTime(componentName, appInfo, firstInstallTime);
    }

    /** Forgets disk entries of activities that are no longer in the app list. */
    public void retainDiskEntries(List<ResolveInfo> infos) {
        if (infos == null) {
            return;
        }
        List<ComponentName> components = new ArrayList<>(infos.size());
        for (ResolveInfo info : infos) {
            if (info != null && info.activityInfo != null) {
                components.add(LauncherModel.getComponentNameFromResolveInfo(info));
            }
        }
        this.mDiskCache.retainOnly(components);
    }

    public HashMap<ComponentName, Bitmap> getAllIcons() {
        HashMap<ComponentName, Bitmap> set;
        synchronized (this.mCache) {
            set = new HashMap<>();
            for (ComponentName cn2 : this.mCache.keySet()) {
                CacheEntry e = this.mCache.get(cn2);
                set.put(cn2, e.icon);
            }
        }
        return set;
    }
}
