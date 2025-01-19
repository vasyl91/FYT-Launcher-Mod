package com.android.launcher66.settings;

import android.app.WallpaperManager;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.util.Log;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import share.ResValue;

public class DayNightMode extends JobService {

    private SharedPreferences mPrefs;

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
                setBrightness(Helpers.isDay);
            }
            jobFinished(params, false);
        });

        return true;
    }

    private void setWallpapers() {
        final WallpaperManager mWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        boolean defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
        SharedPreferences.Editor editor = mPrefs.edit();
        File mFile = new File(Environment.getExternalStorageDirectory() + File.separator + "Launcher_drawable");
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        try {
            if (Helpers.isDay && mFile.exists() || Helpers.isDay && defaultWallpapers) {
                File image = new File(mFile, "wallpaper_night.png");
                if (image.exists() && !defaultWallpapers) {
                    Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
                    mWallpaperManager.setBitmap(bitmap);
                } else {
                    Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg_n)));
                    mWallpaperManager.setBitmap(bitmapDrawable);
                }
                editor.putString("last_wallpaper", "wallpaper_night");
                editor.apply();
            } else if (!Helpers.isDay && mFile.exists() || !Helpers.isDay && defaultWallpapers) {
                File image = new File(mFile, "wallpaper_day.png");
                if (image.exists() && !defaultWallpapers) {
                    Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
                    mWallpaperManager.setBitmap(bitmap);
                } else {
                    Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(getApplicationContext(), ResValue.getInstance().def_bg)));
                    mWallpaperManager.setBitmap(bitmapDrawable);
                }
                editor.putString("last_wallpaper", "wallpaper_day");
                editor.apply();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }     
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
}