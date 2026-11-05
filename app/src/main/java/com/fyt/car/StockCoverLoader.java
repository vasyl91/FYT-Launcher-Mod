package com.fyt.car;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.content.res.ResourcesCompat;

import com.android.launcher66.settings.FytCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The pictures of com.syu.media's radio that the widget shows as the cover: the icon of an online
 * station (a drawable of the icon pack /odm/app/cabinet.data, named by RadioSource.icon) and the
 * pictures the app shows for an FM station without a logo (radio1 .. radio3 of its own resources).
 * Everything is read on a background thread of its own and kept per name in memory; a request for
 * a picture that is not there yet starts the read and calls back on the main thread when it is.
 *
 * <p>The icon pack is an APK that is not installed. PackageManager.getPackageArchiveInfo() opens it
 * (public API; com.syu.media itself uses the hidden AssetManager.addAssetPath) and the resources are
 * those of getResourcesForApplication() of the package info with its source dir set to the file. If
 * the file cannot be opened directly (SyuMediaFiles), it is copied to cache/stock_res/cabinet.apk, and
 * the copy is taken again when the size or the modification time of the source changes.
 */
final class StockCoverLoader {

    private static final String TAG = "StockCovers";
    static final String ICON_PACK = "/odm/app/cabinet.data";
    private static final int MAX_PX = 512;
    private static final Object NONE = new Object();

    private static final Handler MAIN = new Handler(Looper.getMainLooper());
    private static final ExecutorService WORKER = Executors.newSingleThreadExecutor(r -> {
        Thread t = new Thread(r, "StockCoverLoader");
        t.setPriority(Thread.MIN_PRIORITY);
        t.setDaemon(true);
        return t;
    });

    /** icon name -> PNG bytes, or NONE for a name the pack does not have; guarded by CACHE. */
    private static final Map<String, Object> CACHE = new HashMap<>();
    private static final Set<String> IN_FLIGHT = new HashSet<>();
    private static final Set<String> LOGGED = new HashSet<>();

    // worker thread
    private static Resources sPackResources;
    private static String sPackName;
    private static long sPackSize = -1;
    private static long sPackModified = -1;

    private StockCoverLoader() {
    }

    /** The PNG of an online station's icon if it is loaded; null while it is not or if the pack has none. */
    static byte[] cachedOnline(String icon) {
        synchronized (CACHE) {
            Object o = CACHE.get("online:" + icon);
            return o instanceof byte[] ? (byte[]) o : null;
        }
    }

    /** Whether the icon was looked up already (found or not). */
    static boolean knownOnline(String icon) {
        synchronized (CACHE) {
            return CACHE.containsKey("online:" + icon);
        }
    }

    /**
     * Loads the icon of an online station in the background; {@code onLoaded} runs on the main thread when
     * it is found (not when the pack has no such icon: the default cover stays).
     */
    static void requestOnline(Context app, String stationTitle, String icon, Runnable onLoaded) {
        if (icon == null || icon.isEmpty()) {
            return;
        }
        String key = "online:" + icon;
        synchronized (CACHE) {
            if (CACHE.containsKey(key) || !IN_FLIGHT.add(key)) {
                return;
            }
        }
        WORKER.execute(() -> {
            byte[] png = FytCompat.call("stockcovers.online", () -> loadOnline(app, icon), null);
            boolean packOpened = sPackResources != null;
            synchronized (CACHE) {
                // A pack that could not be opened is tried again (the next update of the station)
                if (png != null || packOpened) {
                    CACHE.put(key, png != null ? png : NONE);
                }
                IN_FLIGHT.remove(key);
            }
            if (png != null || packOpened) {
                logOnce("online:" + icon, "online '" + stationTitle + "' icon=" + icon + " -> "
                        + (png != null ? "ok" : "missing") + " (via the icon pack)");
            }
            if (png != null && onLoaded != null) {
                MAIN.post(onLoaded);
            }
        });
    }

    /**
     * The picture com.syu.media shows for an FM station without a logo: its resource radio1..radio3, chosen
     * by the frequency so that it stays the same (the app picks one at random). Reads on the calling
     * thread, which must not be the main one. null when the app has no such picture.
     */
    static byte[] stationFallback(Context app, int freq) {
        String name = StockLogoNames.fallbackDrawable(freq);
        String key = "media:" + name;
        synchronized (CACHE) {
            Object o = CACHE.get(key);
            if (o != null) {
                return o instanceof byte[] ? (byte[]) o : null;
            }
        }
        byte[] png = FytCompat.call("stockcovers.fallback", () -> loadMediaDrawable(app, name), null);
        synchronized (CACHE) {
            CACHE.put(key, png != null ? png : NONE);
        }
        logOnce(key, "FM fallback " + name + " of com.syu.media -> " + (png != null ? "ok" : "missing"));
        return png;
    }

    // ---------------------------------------------------------------------------------------------

    /** Worker thread. */
    private static byte[] loadOnline(Context app, String icon) {
        Resources r = packResources(app);
        if (r == null) {
            return null;
        }
        String base = icon.contains(".") ? icon.substring(0, icon.lastIndexOf('.')) : icon;
        int id = r.getIdentifier(base, "drawable", sPackName);
        if (id == 0) {
            return null;
        }
        return toPng(r, id);
    }

    /** Worker thread. @return the resources of the icon pack, null when it cannot be opened */
    private static Resources packResources(Context app) {
        File source = new File(ICON_PACK);
        long size = source.length();
        long modified = source.lastModified();
        boolean changed = size != sPackSize || modified != sPackModified;
        if (sPackResources != null && !changed) {
            return sPackResources;
        }
        PackageManager pm = app.getPackageManager();
        String path = ICON_PACK;
        PackageInfo info = size > 0 ? pm.getPackageArchiveInfo(path, 0) : null;
        if (info != null && info.applicationInfo != null) {
            logPackOnce(size, "direct");
        }
        if (info == null || info.applicationInfo == null) {
            // not readable here: a copy, from whatever way reads it
            File copy = new File(new File(app.getCacheDir(), "stock_res"), "cabinet.apk");
            if (sPackResources != null && size <= 0 && copy.isFile()) {
                return sPackResources; // the source cannot even be looked at: keep what was loaded
            }
            SyuMediaFiles.Copied copied = SyuMediaFiles.copyTo(SyuMediaFiles.FAMILY_ICON_PACK, ICON_PACK, copy);
            if (copied == null) {
                return null;
            }
            logPackOnce(copied.bytes, copied.via);
            path = copy.getPath();
            info = pm.getPackageArchiveInfo(path, 0);
        }
        if (info == null || info.applicationInfo == null) {
            return null;
        }
        info.applicationInfo.sourceDir = path;
        info.applicationInfo.publicSourceDir = path;
        try {
            sPackResources = pm.getResourcesForApplication(info.applicationInfo);
        } catch (PackageManager.NameNotFoundException | RuntimeException e) {
            Log.w(TAG, "icon pack resources: " + e);
            return null;
        }
        sPackName = info.packageName;
        sPackSize = size;
        sPackModified = modified;
        if (changed) {
            synchronized (CACHE) {
                // another file than the pictures in memory came from
                CACHE.keySet().removeIf(k -> k.startsWith("online:"));
            }
        }
        return sPackResources;
    }

    private static boolean sPackLogged;

    /** Once per process: how big the icon pack is and by which way it was had (it was read into memory before 64 MB). */
    private static synchronized void logPackOnce(long bytes, String way) {
        if (!sPackLogged) {
            sPackLogged = true;
            Log.i(TAG, "icon pack " + bytes + " bytes, " + way);
        }
    }

    /** Worker thread. */
    private static byte[] loadMediaDrawable(Context app, String name) {
        try {
            Resources r = app.getPackageManager().getResourcesForApplication(MusicService.MEDIA_PKG);
            int id = r.getIdentifier(name, "drawable", MusicService.MEDIA_PKG);
            return id == 0 ? null : toPng(r, id);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    /**
     * A drawable resource as PNG bytes of at most MAX_PX; null if it cannot be drawn. A bitmap
     * is decoded (sampled down); a vector or an XML drawable, for which decodeResource() gives
     * nothing, is drawn on a bitmap of its own size (MAX_PX at the most). The types radio1 to
     * radio3 of com.syu.media were not known to be bitmaps.
     */
    private static byte[] toPng(Resources r, int id) {
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(r, id, bounds);
        if (bounds.outWidth > 0 && bounds.outHeight > 0) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = sampleSize(bounds.outWidth, bounds.outHeight);
            Bitmap bitmap = BitmapFactory.decodeResource(r, id, options);
            if (bitmap != null) {
                return compress(bitmap);
            }
        }
        return drawnPng(r, id);
    }

    private static byte[] drawnPng(Resources r, int id) {
        try {
            Drawable drawable = ResourcesCompat.getDrawable(r, id, null);
            if (drawable == null) {
                return null;
            }
            int width = drawable.getIntrinsicWidth();
            int height = drawable.getIntrinsicHeight();
            if (width <= 0 || height <= 0) {
                return null;
            }
            float scale = Math.min(1f, (float) MAX_PX / Math.max(width, height));
            width = Math.max(1, Math.round(width * scale));
            height = Math.max(1, Math.round(height * scale));
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, width, height);
            drawable.draw(canvas);
            return compress(bitmap);
        } catch (RuntimeException e) {
            Log.w(TAG, "drawable " + id + " cannot be drawn: " + e);
            return null;
        }
    }

    /** Image bytes (PNG, JPEG ...) as PNG bytes of at most MAX_PX; null if they are not an image. */
    static byte[] toPng(byte[] image) {
        if (image == null || image.length == 0) {
            return null;
        }
        BitmapFactory.Options bounds = new BitmapFactory.Options();
        bounds.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(image, 0, image.length, bounds);
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = sampleSize(bounds.outWidth, bounds.outHeight);
        return compress(BitmapFactory.decodeByteArray(image, 0, image.length, options));
    }

    private static int sampleSize(int width, int height) {
        int sample = 1;
        while (width / (sample * 2) >= MAX_PX && height / (sample * 2) >= MAX_PX) {
            sample *= 2;
        }
        return sample;
    }

    private static byte[] compress(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            return out.toByteArray();
        } finally {
            bitmap.recycle();
        }
    }

    private static void logOnce(String key, String line) {
        boolean first;
        synchronized (LOGGED) {
            first = LOGGED.add(key);
        }
        if (first) {
            Log.i(TAG, line);
        }
    }
}
