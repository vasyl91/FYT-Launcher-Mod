package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public final class StorageUtils {
    private static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils() {
    }

    public static File getCacheDirectory(Context context) {
        return getCacheDirectory(context, true);
    }

    public static File getCacheDirectory(Context context, boolean preferExternal) {
        File appCacheDir = null;
        if (preferExternal && "mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            appCacheDir = getExternalCacheDir(context);
        }
        if (appCacheDir == null) {
            appCacheDir = context.getCacheDir();
        }
        if (appCacheDir == null) {
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            L.w("Can't define system cache directory! '%s' will be used.", cacheDirPath);
            return new File(cacheDirPath);
        }
        return appCacheDir;
    }

    public static File getIndividualCacheDirectory(Context context) {
        File cacheDir = getCacheDirectory(context);
        File individualCacheDir = new File(cacheDir, INDIVIDUAL_DIR_NAME);
        if (!individualCacheDir.exists() && !individualCacheDir.mkdir()) {
            return cacheDir;
        }
        return individualCacheDir;
    }

    public static File getOwnCacheDirectory(Context context, String cacheDir) {
        File appCacheDir = null;
        if ("mounted".equals(Environment.getExternalStorageState()) && hasExternalStoragePermission(context)) {
            appCacheDir = new File(Environment.getExternalStorageDirectory(), cacheDir);
        }
        if (appCacheDir == null || (!appCacheDir.exists() && !appCacheDir.mkdirs())) {
            return context.getCacheDir();
        }
        return appCacheDir;
    }

    private static File getExternalCacheDir(Context context) {
        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File appCacheDir = new File(new File(dataDir, context.getPackageName()), "cache");
        if (!appCacheDir.exists()) {
            if (!appCacheDir.mkdirs()) {
                L.w("Unable to create external cache directory", new Object[0]);
                return null;
            }
            try {
                new File(appCacheDir, ".nomedia").createNewFile();
                return appCacheDir;
            } catch (IOException e) {
                L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
                return appCacheDir;
            }
        }
        return appCacheDir;
    }

    private static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission(EXTERNAL_STORAGE_PERMISSION);
        return perm == 0;
    }
}
