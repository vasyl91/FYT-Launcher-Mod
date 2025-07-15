package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
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

import share.ResValue;

public class DayNightMode extends JobService {

    private static final String TAG = "DayNightMode";
    private SharedPreferences mPrefs;
    private boolean defaultWallpapers;
    private final Helpers helpers = new Helpers();
    private static final Object LOCK = new Object();

    @Override
    public boolean onStartJob(final JobParameters params) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        HandlerThread handlerThread = new HandlerThread("SomeOtherThread");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(() -> {
            Log.i("JOB", "Started!!!");
            setWallpapers();
            boolean brightnessBool = mPrefs.getBoolean("brightness", false);
            if (brightnessBool) {
                setBrightness();
            }
            jobFinished(params, false);
        });

        return true;
    }

    private void setWallpapers() {
        defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
        File mFile = new File(getApplicationContext().getFilesDir(), "wallpaper_img"); // dir: /data/user/0/com.android.launcher66/files/wallpaper_img
        if (mFile.exists() && !defaultWallpapers) {
            if (allowSetDayWallpaper()) {
                File image = new File(mFile, "Day.webp");
                if (isFileValid(image)) {
                    Bitmap bitmap = decodeBitmapSafely(image);
                    new SetWallpaperTask("Day").execute(bitmap);
                } else {
                    setDefaultWallpapers();
                }
            } else if (allowSetNightWallpaper()) {
                File image = new File(mFile, "Night.webp");
                if (isFileValid(image)) {
                    Bitmap bitmap = decodeBitmapSafely(image);
                    new SetWallpaperTask("Night").execute(bitmap);
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
            new SetWallpaperTask("Day").execute(bitmapDrawable);
        } else if (allowSetNightWallpaper()) {
            Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg_n)));
            new SetWallpaperTask("Night").execute(bitmapDrawable);
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

    @Override
    public boolean onStopJob(final JobParameters params) {
        Log.d("JOB", "onStopJob() was called");
        return true;
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
        }).start();
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }
    
    private class SetWallpaperTask extends AsyncTask<Bitmap, Void, Boolean> {
        private WallpaperManager mWallpaperManager;
        private final String dayTime;

        public SetWallpaperTask(String name) {
            this.dayTime = name;
        }

        @Override
        protected Boolean doInBackground(Bitmap[] newWallpaperBitmap) throws IOException {
            mWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            mWallpaperManager.setBitmap(newWallpaperBitmap[0]);
            saveBitmapHash(dayTime);
            return true;
        }

        @Override
        protected void onProgress(Void[] progress) {
            //
        }

        public void saveBitmapHash(String name) {
            Drawable mWallpaper = mWallpaperManager.getDrawable();
            Bitmap currentWallpaperBitmap = drawableToBitmap(mWallpaper);

            Bitmap normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            normalizedBitmap.compress(getWebPFormat(), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();

            try {
                MessageDigest digest = MessageDigest.getInstance("MD5");
                byte[] hashBytes = digest.digest(byteArray);

                StringBuilder hexString = new StringBuilder();
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString(name + "_hash", hexString.toString());
                editor.apply();
            } catch (NoSuchAlgorithmException e) {
                Log.e(TAG, "Hash error: " + e.getMessage());
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

        public Bitmap normalizeBitmap(Bitmap bitmap) {
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