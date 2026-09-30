package com.android.launcher66;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Titles, launcher-rendered icons and install times of launcher activities, kept on disk between
 * process starts.
 *
 * Building the all-apps list opens every app's APK twice, once for the label (the sort) and once
 * for the icon: 3-5 s at a cold start, and 12-14 s when that start overlaps the boot-time freeze,
 * during which system_server hashes the APEX files and the disk is saturated (captures
 * 29-09-2026 20:51 and 21:40). With this cache a start only reads what changed.
 *
 * An entry is used only while its app's APK is the same file (size and modification time of
 * applicationInfo.sourceDir: no update, no reinstall), and only while the header matches: the
 * launcher's own APK (icon code and resources) and the locale (titles). An icon is also used only
 * at the current icon size. Anything else is a miss, and a miss runs the old code.
 *
 * Thread-safe. The file is read on first use and written from a background thread, a few seconds
 * after the last change.
 */
final class AppIconDiskCache {

    private static final String TAG = "Launcher.IconDiskCache";
    private static final String FILE_NAME = "app_icon_cache.bin";
    private static final int MAGIC = 0x4C364943; // "L6IC"
    private static final int FORMAT = 1;
    private static final long SAVE_DELAY_MS = 3000L;

    private static AppIconDiskCache sInstance;

    static synchronized AppIconDiskCache get(Context context) {
        if (sInstance == null) {
            sInstance = new AppIconDiskCache(context.getApplicationContext() != null
                    ? context.getApplicationContext() : context);
        }
        return sInstance;
    }

    private static final class Entry {
        String apkStamp;
        String title;
        long firstInstallTime = -1L;
        int iconWidth;
        int iconHeight;
        int iconDensity;
        /** Compressed icon, from the file or from the last save; null until then. */
        byte[] png;
        /** The icon as rendered or decoded in this process. */
        Bitmap icon;
    }

    private final Context mContext;
    private final File mFile;
    private final Map<String, Entry> mEntries = new HashMap<>();
    private final ScheduledExecutorService mSaver = Executors.newSingleThreadScheduledExecutor(r -> {
        Thread t = new Thread(r, "IconDiskCacheSave");
        t.setDaemon(true);
        t.setPriority(Thread.MIN_PRIORITY);
        return t;
    });

    private boolean mLoaded;
    private boolean mDirty;
    private boolean mSaveScheduled;
    private String mLauncherStamp = "";
    private String mLocale = "";
    /** Current size of the icons IconCache renders; 0 = not known yet (then icons are not used). */
    private int mIconWidth;
    private int mIconHeight;

    AppIconDiskCache(Context context) {
        mContext = context;
        mFile = new File(context.getFilesDir(), FILE_NAME);
    }

    // =========================================================================================
    // Queries -- all return "unknown" for a missing or stale entry
    // =========================================================================================

    synchronized String getTitle(ComponentName cn, ApplicationInfo ai) {
        Entry e = validEntry(cn, ai);
        return e != null ? e.title : null;
    }

    synchronized Bitmap getIcon(ComponentName cn, ApplicationInfo ai) {
        Entry e = validEntry(cn, ai);
        if (e == null || mIconWidth <= 0 || e.iconWidth != mIconWidth || e.iconHeight != mIconHeight) {
            return null;
        }
        if (e.icon == null && e.png != null) {
            Bitmap decoded = BitmapFactory.decodeByteArray(e.png, 0, e.png.length);
            if (decoded == null || decoded.getWidth() != e.iconWidth || decoded.getHeight() != e.iconHeight) {
                return null;
            }
            decoded.setDensity(e.iconDensity);
            e.icon = decoded;
        }
        return e.icon;
    }

    /** -1 when unknown. */
    synchronized long getFirstInstallTime(ComponentName cn, ApplicationInfo ai) {
        Entry e = validEntry(cn, ai);
        return e != null ? e.firstInstallTime : -1L;
    }

    // =========================================================================================
    // Updates
    // =========================================================================================

    synchronized void putTitleAndIcon(ComponentName cn, ApplicationInfo ai, String title, Bitmap icon) {
        Entry e = entryForUpdate(cn, ai);
        if (e == null) {
            return;
        }
        boolean changed = false;
        if (title != null && !title.equals(e.title)) {
            e.title = title;
            changed = true;
        }
        if (icon != null && icon != e.icon) {
            e.icon = icon;
            e.png = null; // re-encoded on the next save
            e.iconWidth = icon.getWidth();
            e.iconHeight = icon.getHeight();
            e.iconDensity = icon.getDensity();
            changed = true;
        }
        if (changed) {
            markDirty();
        }
    }

    synchronized void putFirstInstallTime(ComponentName cn, ApplicationInfo ai, long firstInstallTime) {
        Entry e = entryForUpdate(cn, ai);
        if (e != null && e.firstInstallTime != firstInstallTime) {
            e.firstInstallTime = firstInstallTime;
            markDirty();
        }
    }

    /** The size IconCache renders icons at; icons of another size are misses from now on. */
    synchronized void setIconSize(int width, int height) {
        mIconWidth = width;
        mIconHeight = height;
    }

    synchronized void remove(ComponentName cn) {
        ensureLoadedLocked();
        if (cn != null && mEntries.remove(cn.flattenToString()) != null) {
            markDirty();
        }
    }

    synchronized void clear() {
        ensureLoadedLocked();
        if (!mEntries.isEmpty()) {
            mEntries.clear();
            markDirty();
        }
    }

    /** Drops entries of activities that are no longer in the launcher's app list. */
    synchronized void retainOnly(Collection<ComponentName> components) {
        ensureLoadedLocked();
        Set<String> keep = new HashSet<>();
        for (ComponentName cn : components) {
            if (cn != null) {
                keep.add(cn.flattenToString());
            }
        }
        boolean removed = false;
        for (Iterator<String> it = mEntries.keySet().iterator(); it.hasNext(); ) {
            if (!keep.contains(it.next())) {
                it.remove();
                removed = true;
            }
        }
        if (removed) {
            markDirty();
        }
    }

    // =========================================================================================
    // Internals
    // =========================================================================================

    private Entry validEntry(ComponentName cn, ApplicationInfo ai) {
        ensureLoadedLocked();
        if (cn == null) {
            return null;
        }
        Entry e = mEntries.get(cn.flattenToString());
        if (e == null) {
            return null;
        }
        String stamp = apkStamp(ai);
        return stamp != null && stamp.equals(e.apkStamp) ? e : null;
    }

    /** The entry to write into: a stale one (other APK) starts over. Null if uncacheable. */
    private Entry entryForUpdate(ComponentName cn, ApplicationInfo ai) {
        ensureLoadedLocked();
        String stamp = apkStamp(ai);
        if (cn == null || stamp == null) {
            return null;
        }
        String key = cn.flattenToString();
        Entry e = mEntries.get(key);
        if (e == null || !stamp.equals(e.apkStamp)) {
            e = new Entry();
            e.apkStamp = stamp;
            mEntries.put(key, e);
        }
        return e;
    }

    /** Size and modification time of the APK: both change with every update or reinstall. */
    static String apkStamp(ApplicationInfo ai) {
        if (ai == null || ai.sourceDir == null) {
            return null;
        }
        File apk = new File(ai.sourceDir);
        long length = apk.length();
        if (length <= 0L) {
            return null; // unreadable: do not cache
        }
        return length + ":" + apk.lastModified();
    }

    private String currentLauncherStamp() {
        String stamp = apkStamp(mContext.getApplicationInfo());
        return stamp != null ? stamp : "";
    }

    private String currentLocale() {
        try {
            return mContext.getResources().getConfiguration().getLocales().get(0).toLanguageTag();
        } catch (RuntimeException e) {
            return Locale.getDefault().toLanguageTag();
        }
    }

    private void ensureLoadedLocked() {
        if (mLoaded) {
            return;
        }
        mLoaded = true;
        mLauncherStamp = currentLauncherStamp();
        mLocale = currentLocale();
        long start = System.nanoTime();
        int count = 0;
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(mFile)))) {
            if (in.readInt() != MAGIC || in.readInt() != FORMAT) {
                return;
            }
            String launcherStamp = in.readUTF();
            String locale = in.readUTF();
            if (!mLauncherStamp.equals(launcherStamp)) {
                Log.i(TAG, "launcher changed, cache dropped");
                mDirty = true;
                return;
            }
            boolean keepTitles = mLocale.equals(locale);
            count = in.readInt();
            for (int i = 0; i < count; i++) {
                String key = in.readUTF();
                Entry e = new Entry();
                e.apkStamp = in.readUTF();
                String title = in.readBoolean() ? in.readUTF() : null;
                e.title = keepTitles ? title : null;
                e.firstInstallTime = in.readLong();
                e.iconWidth = in.readInt();
                e.iconHeight = in.readInt();
                e.iconDensity = in.readInt();
                int pngLength = in.readInt();
                if (pngLength > 0) {
                    e.png = new byte[pngLength];
                    in.readFully(e.png);
                }
                mEntries.put(key, e);
            }
            if (!keepTitles) {
                mDirty = true;
            }
        } catch (IOException | RuntimeException e) {
            if (mFile.exists()) {
                Log.w(TAG, "cache unreadable, starting empty", e);
            }
            mEntries.clear();
        } finally {
            Log.d(TAG, "loaded " + mEntries.size() + " of " + count + " entries in "
                    + (System.nanoTime() - start) / 1_000_000L + " ms");
        }
    }

    private void markDirty() {
        mDirty = true;
        if (!mSaveScheduled) {
            mSaveScheduled = true;
            mSaver.schedule(this::saveNow, SAVE_DELAY_MS, TimeUnit.MILLISECONDS);
        }
    }

    /** Writes the cache now, on the calling thread; normally runs on the saver thread. */
    void saveNow() {
        List<Map.Entry<String, Entry>> snapshot;
        String launcherStamp;
        String locale;
        synchronized (this) {
            mSaveScheduled = false;
            if (!mDirty) {
                return;
            }
            mDirty = false;
            snapshot = new ArrayList<>(mEntries.entrySet());
            launcherStamp = mLauncherStamp;
            locale = mLocale;
        }
        long start = System.nanoTime();
        // Encoding happens outside the lock; an entry changed meanwhile marks the cache dirty
        // again, and the next save picks that up.
        List<Object[]> rows = new ArrayList<>(snapshot.size());
        for (Map.Entry<String, Entry> me : snapshot) {
            Entry e = me.getValue();
            byte[] png;
            String title;
            long installTime;
            int w;
            int h;
            int density;
            Bitmap icon;
            String apkStamp;
            synchronized (this) {
                apkStamp = e.apkStamp;
                png = e.png;
                icon = e.icon;
                title = e.title;
                installTime = e.firstInstallTime;
                w = e.iconWidth;
                h = e.iconHeight;
                density = e.iconDensity;
            }
            if (png == null && icon != null) {
                png = encode(icon);
                if (png != null) {
                    synchronized (this) {
                        if (e.icon == icon) {
                            e.png = png;
                        }
                    }
                }
            }
            rows.add(new Object[] {me.getKey(), apkStamp, title, installTime, w, h, density, png});
        }
        File tmp = new File(mFile.getPath() + ".tmp");
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(tmp)))) {
            out.writeInt(MAGIC);
            out.writeInt(FORMAT);
            out.writeUTF(launcherStamp);
            out.writeUTF(locale);
            out.writeInt(rows.size());
            for (Object[] r : rows) {
                out.writeUTF((String) r[0]);
                out.writeUTF((String) r[1]);
                String title = (String) r[2];
                out.writeBoolean(title != null);
                if (title != null) {
                    out.writeUTF(title);
                }
                out.writeLong((Long) r[3]);
                out.writeInt((Integer) r[4]);
                out.writeInt((Integer) r[5]);
                out.writeInt((Integer) r[6]);
                byte[] png = (byte[]) r[7];
                if (png != null) {
                    out.writeInt(png.length);
                    out.write(png);
                } else {
                    out.writeInt(0);
                }
            }
        } catch (IOException | RuntimeException e) {
            Log.w(TAG, "cache not saved", e);
            //noinspection ResultOfMethodCallIgnored
            tmp.delete();
            return;
        }
        if (!tmp.renameTo(mFile)) {
            Log.w(TAG, "cache not saved: rename failed");
            //noinspection ResultOfMethodCallIgnored
            tmp.delete();
            return;
        }
        Log.d(TAG, "saved " + rows.size() + " entries in " + (System.nanoTime() - start) / 1_000_000L + " ms");
    }

    private static byte[] encode(Bitmap icon) {
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream(8192);
            if (!icon.compress(Bitmap.CompressFormat.PNG, 100, bytes)) {
                return null;
            }
            return bytes.toByteArray();
        } catch (RuntimeException e) {
            return null;
        }
    }
}
