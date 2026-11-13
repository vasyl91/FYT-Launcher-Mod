package com.android.launcher66.settings;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.syu.util.WindowHostVdClient;

import java.util.List;

/**
 * The one place that reads the wallpaper of the home screen: for the backdrop of the background selectors and
 * for "Save the day / night wallpaper". It tries the ways WallpaperAccess gives for this device, in order, and
 * returns the picture or null; with null the caller shows the wallpaper's colours and lets the user pick an
 * image. It never asks for the lock screen's wallpaper, and it never throws: a refusal of the system is a way
 * that gave nothing. Blocking (it reads a file and may call the privileged host): never on the main thread.
 */
final class HomeWallpaperSource {

    private static final String TAG = "HomeWallpaper";

    private HomeWallpaperSource() {
    }

    /** The ways worth trying on this device now. */
    static List<WallpaperAccess.Level> levels(Context context) {
        boolean storage = ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED;
        boolean allFiles = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && Environment.isExternalStorageManager();
        return WallpaperAccess.levels(Build.VERSION.SDK_INT, Process.myUid() == Process.SYSTEM_UID, storage, allFiles,
                WindowHostVdClient.isPrivilegedHostAttached());
    }

    /**
     * @return the home screen's wallpaper as it is stored, or null when no way gave it (also for a live
     *         wallpaper, which has no picture)
     */
    static Bitmap read(Context context) {
        Context app = context.getApplicationContext();
        for (WallpaperAccess.Level level : levels(app)) {
            Bitmap bitmap = null;
            if (level == WallpaperAccess.Level.SYSTEM_API) {
                bitmap = fromSystem(app);
            } else if (level == WallpaperAccess.Level.HOST) {
                bitmap = fromHost();
            }
            if (bitmap != null) {
                Log.i(TAG, "Home wallpaper read through " + level + ": " + bitmap.getWidth() + "x"
                        + bitmap.getHeight());
                return bitmap;
            }
            if (level != WallpaperAccess.Level.USER_PICKS) {
                Log.i(TAG, "Home wallpaper: " + level + " gave no picture");
            }
        }
        Log.i(TAG, "Home wallpaper cannot be read on this device: the colours and the user's pick are left");
        return null;
    }

    private static Bitmap fromSystem(Context app) {
        WallpaperManager manager = WallpaperManager.getInstance(app);
        // The stored picture of the home screen's wallpaper
        try (ParcelFileDescriptor file = manager.getWallpaperFile(WallpaperManager.FLAG_SYSTEM)) {
            if (file != null) {
                Bitmap bitmap = BitmapFactory.decodeFileDescriptor(file.getFileDescriptor());
                if (bitmap != null) {
                    return bitmap;
                }
            }
        } catch (SecurityException e) {
            Log.w(TAG, "The system refuses the wallpaper's file: " + e.getMessage());
        } catch (Exception e) {
            Log.w(TAG, "The wallpaper's file could not be read: " + e);
        }
        // No file (the built-in wallpaper): what the system draws for the home screen
        try {
            Drawable drawable = Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE
                    ? manager.getDrawable(WallpaperManager.FLAG_SYSTEM) : manager.getDrawable();
            if (drawable != null && drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                        Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                return bitmap;
            }
        } catch (SecurityException e) {
            Log.w(TAG, "The system refuses the wallpaper: " + e.getMessage());
        } catch (Exception e) {
            Log.w(TAG, "The wallpaper could not be drawn: " + e);
        }
        return null;
    }

    private static Bitmap fromHost() {
        try (ParcelFileDescriptor file = WindowHostVdClient.readHomeWallpaper()) {
            return file == null ? null : BitmapFactory.decodeFileDescriptor(file.getFileDescriptor());
        } catch (Exception e) {
            Log.w(TAG, "The host could not give the wallpaper: " + e);
            return null;
        }
    }
}
