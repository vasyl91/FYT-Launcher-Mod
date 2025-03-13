package com.android.launcher66.settings;

import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;

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
                setBrightness(helpers.isDay());
            }
            jobFinished(params, false);
        });

        return true;
    }

    private void setWallpapers() {
        defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
        File mFile = new File(getApplicationContext().getFilesDir(), "wallpaper_img"); // dir: /data/user/0/com.android.launcher66/files/wallpaper_img
        if (helpers.isDay() && mFile.exists() || helpers.isDay() && defaultWallpapers) {
            File image = new File(mFile, "Night.png");
            if (allowSetWallpaperFromFile(image)) {
                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath());
                new SetWallpaperTask("Night").execute(bitmap);
            } else {
                Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg_n)));
                new SetWallpaperTask("Night").execute(bitmapDrawable);
            }
        } else if (!helpers.isDay() && mFile.exists() || !helpers.isDay() && defaultWallpapers) {
            File image = new File(mFile, "Day.png");
            if (allowSetWallpaperFromFile(image)) {
                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath());
                new SetWallpaperTask("Day").execute(bitmap);
            } else {
                Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg)));
                new SetWallpaperTask("Day").execute(bitmapDrawable);
            }
        } 
    }

    private boolean allowSetWallpaperFromFile(File image) {
        return image.exists() && !defaultWallpapers;
    }

    @Override
    public boolean onStopJob(final JobParameters params) {
        Log.d("JOB", "onStopJob() was called");
        return true;
    }

    public void setBrightness(boolean day) { 
        int brightness;
        if (day) {
            brightness = mPrefs.getInt("day_seek_bar", 70);    
        } else {
            brightness = mPrefs.getInt("night_seek_bar", 0);
        }
        Settings.System.putInt(getApplicationContext().getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
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
        protected Boolean doInBackground(Bitmap... newWallpaperBitmap) throws IOException {
            mWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
            mWallpaperManager.setBitmap(newWallpaperBitmap[0]);
            saveBitmapHash(dayTime);
            return true;
        }

        public void saveBitmapHash(String name) {
            Drawable mWallpaper = mWallpaperManager.getDrawable();
            Bitmap currentWallpaperBitmap = drawableToBitmap(mWallpaper);

            Bitmap normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            normalizedBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
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