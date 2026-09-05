package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import share.ResValue;

public class DayNightMode extends JobService {

    private static final String TAG = "DayNightMode";
    private SharedPreferences mPrefs;
    private boolean defaultWallpapers;
    private final Helpers helpers = new Helpers();
    private static final Object LOCK = new Object();

    /**
     * Worker thread for a single job run. onStartJob() used to create a HandlerThread and
     * never quit it, so every job run left a live thread with its own Looper behind for
     * the lifetime of the process.
     */
    private HandlerThread mWorkerThread;

    /** Current wallpaper task, cancelled from onStopJob(). */
    private final AtomicReference<SetWallpaperTask> mCurrentTask = new AtomicReference<>();

    @Override
    public boolean onStartJob(final JobParameters params) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        final HandlerThread handlerThread = new HandlerThread("DayNightMode-worker");
        handlerThread.start();
        mWorkerThread = handlerThread;

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(() -> {
            try {
                Log.i(TAG, "Job started");
                setWallpapers();
                boolean brightnessBool = mPrefs.getBoolean("brightness", false);
                if (brightnessBool) {
                    setBrightness();
                }
            } catch (Throwable t) {
                Log.e(TAG, "Job failed", t);
            } finally {
                jobFinished(params, false);
                handlerThread.quitSafely();
            }
        });

        return true;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        Log.d(TAG, "onStopJob() was called");
        cancelCurrentTask();
        quitWorkerThread();
        return true;
    }

    @Override
    public void onDestroy() {
        // The JobService goes away after jobFinished() while SetWallpaperTask may still
        // be running, which is what the heap dump showed:
        //   Thread 'pool-4-thread-2' -> DayNightMode$SetWallpaperTask
        //     -> SetWallpaperTask.this$0 -> DayNightMode (destroyed JobService)
        cancelCurrentTask();
        quitWorkerThread();
        super.onDestroy();
    }

    private void cancelCurrentTask() {
        SetWallpaperTask task = mCurrentTask.getAndSet(null);
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }
    }

    private void quitWorkerThread() {
        HandlerThread thread = mWorkerThread;
        mWorkerThread = null;
        if (thread != null) {
            thread.quitSafely();
        }
    }

    private void startTask(String dayTime, Bitmap bitmap) {
        if (bitmap == null) {
            Log.w(TAG, "startTask(" + dayTime + "): no bitmap, skipping");
            return;
        }
        cancelCurrentTask();
        SetWallpaperTask task = new SetWallpaperTask(getApplicationContext(), mPrefs, dayTime);
        mCurrentTask.set(task);
        task.execute(bitmap);
    }

    private void setWallpapers() {
        defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
        File mFile = new File(getApplicationContext().getFilesDir(), "wallpaper_img"); // dir: /data/user/0/com.android.launcher66/files/wallpaper_img
        if (mFile.exists() && !defaultWallpapers) {
            if (allowSetDayWallpaper()) {
                File image = new File(mFile, "Day.webp");
                Bitmap bitmap = isFileValid(image) ? decodeBitmapSafely(image) : null;
                if (bitmap != null) {
                    startTask("Day", bitmap);
                } else {
                    setDefaultWallpapers();
                }
            } else if (allowSetNightWallpaper()) {
                File image = new File(mFile, "Night.webp");
                Bitmap bitmap = isFileValid(image) ? decodeBitmapSafely(image) : null;
                if (bitmap != null) {
                    startTask("Night", bitmap);
                } else {
                    setDefaultWallpapers();
                }
            }            
        } else {
            setDefaultWallpapers();
        }
    }

    private void setDefaultWallpapers() {
        if (allowSetDayWallpaper()) {
            Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg)));
            startTask("Day", bitmapDrawable);
        } else if (allowSetNightWallpaper()) {
            Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg_n)));
            startTask("Night", bitmapDrawable);
        }   
    }

    private boolean allowSetDayWallpaper() {
        return !helpers.isDay() || helpers.isPolarDay();
    }

    private boolean allowSetNightWallpaper() {
        return helpers.isDay() || helpers.isPerpetualNight();
    }

    private boolean isFileValid(File file) {
        return file.exists() && file.length() > 0  && !defaultWallpapers;
    }

    private Bitmap decodeBitmapSafely(File image) {
        synchronized (LOCK) {            
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize = 2; 
            
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), options);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    return null;
                }
                return bitmap;
            } catch (OutOfMemoryError | Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void setBrightness() {
        final int dayBrightness = mPrefs.getInt("day_seek_bar", 70);
        final int nightBrightness = mPrefs.getInt("night_seek_bar", 0);
        final boolean isDay = helpers.isDay();
        final boolean isPolarDay = helpers.isPolarDay();
        final boolean isPerpetualNight = helpers.isPerpetualNight();

        new Thread(() -> {
            int brightness = 70;
            if (isDay || isPolarDay) {
                brightness = dayBrightness;
            } else if (!isDay || isPerpetualNight) {
                brightness = nightBrightness;
            }
            try {
                Settings.System.putInt(
                    LauncherApplication.sApp.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS,
                    brightness
                );
            } catch (Exception e) {
                Log.e(TAG, "Error setting brightness", e);
            }
        }, "DayNightMode-brightness").start();
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        int width = Math.max(1, drawable.getIntrinsicWidth());
        int height = Math.max(1, drawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Static on purpose: as an inner class it carried a synthetic this$0 == DayNightMode
     * and so kept the whole JobService alive while the task sat in
     * WallpaperManager.setBitmap() on a pool thread. It now takes only what it needs.
     */
    private static class SetWallpaperTask extends AsyncTask<Bitmap, Void, Boolean> {

        private final Context appContext;
        private final SharedPreferences prefs;
        private final String dayTime;
        private WallpaperManager mWallpaperManager;

        SetWallpaperTask(Context appContext, SharedPreferences prefs, String name) {
            this.appContext = appContext.getApplicationContext();
            this.prefs = prefs;
            this.dayTime = name;
        }

        @Override
        protected Boolean doInBackground(Bitmap[] newWallpaperBitmap) throws IOException {
            if (newWallpaperBitmap == null || newWallpaperBitmap.length == 0
                    || newWallpaperBitmap[0] == null) {
                return false;
            }
            if (isCancelled()) {
                return false;
            }
            mWallpaperManager = WallpaperManager.getInstance(appContext);
            mWallpaperManager.setBitmap(newWallpaperBitmap[0]);
            if (isCancelled()) {
                return false;
            }
            saveBitmapHash(dayTime);
            return true;
        }

        @Override
        protected void onProgress(Void[] progress) {
            //
        }

        private void saveBitmapHash(String name) {
            Bitmap currentWallpaperBitmap = null;
            Bitmap normalizedBitmap = null;
            try {
                Drawable mWallpaper = mWallpaperManager.getDrawable();
                if (mWallpaper == null) {
                    return;
                }
                currentWallpaperBitmap = drawableToBitmap(mWallpaper);
                normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                normalizedBitmap.compress(getWebPFormat(), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();

                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] hashBytes = digest.digest(byteArray);

                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(name + "_hash", hexString.toString());
                editor.apply();
            } catch (NoSuchAlgorithmException e) {
                Log.e(TAG, "Hash error: " + e.getMessage());
            } catch (OutOfMemoryError e) {
                Log.e(TAG, "Hash error: out of memory copying the wallpaper", e);
            } finally {
                // Two full-screen ARGB_8888 copies run to tens of MB on this device
                // (heap dump metadata: 3 large bitmaps, 50.3 MB). Without recycle() they
                // wait for the GC along with the WEBP byte array.
                recycleQuietly(normalizedBitmap);
                recycleQuietly(currentWallpaperBitmap);
            }
        }

        private static void recycleQuietly(Bitmap bitmap) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
        }

        @SuppressLint("NewApi")
        private Bitmap.CompressFormat getWebPFormat() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                return Bitmap.CompressFormat.WEBP_LOSSLESS;
            } else {
                return Bitmap.CompressFormat.WEBP;
            }
        }

        private Bitmap normalizeBitmap(Bitmap bitmap) {
            Bitmap normalizedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(normalizedBitmap);
            canvas.drawBitmap(bitmap, 0, 0, null);
            return normalizedBitmap;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (Boolean.TRUE.equals(success)) {
                Log.d(TAG, "Wallpaper updated successfully.");
            } else {
                Log.d(TAG, "Wallpaper was not updated.");
            }
        }
        
        @Override
        protected void onBackgroundError(Exception e) {
            Log.d(TAG, "Background error, wallpaper was not updated:" + e.getMessage());
        }
    }
}
