package com.android.launcher66.settings;

import android.Manifest;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import androidx.core.content.ContextCompat;

import com.syu.util.WindowHostVdClient;

import java.io.FileDescriptor;
import java.util.List;

/**
 * The one place that reads the wallpaper of the home screen: for the backdrop of the background selectors and
 * for "Save the day / night wallpaper". It tries the ways WallpaperAccess gives for this device, in order, and
 * returns the picture or null; with null the caller shows the wallpaper's colours and lets the user pick an
 * image. It never asks for the lock screen's wallpaper, and it never throws: a refusal of the system is a way
 * that gave nothing. Blocking (it reads a file and may call the privileged host): never on the main thread.
 *
 * <p>Two sizes: {@link #read(Context)} gives the picture whole, for "Save the day / night wallpaper", which keeps
 * the picture and sets it again later; {@link #read(Context, int, int)} decodes it no bigger than it must be to
 * cover the size asked (SampleSize), for a backdrop that is only looked at.
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
        return read(context, 0, 0);
    }

    /**
     * @param coverWidth  the width the picture must still cover; with 0 (or the height 0) the picture is whole
     * @param coverHeight the height the picture must still cover
     * @return the home screen's wallpaper decoded no bigger than it must be to cover that size, or null
     */
    static Bitmap read(Context context, int coverWidth, int coverHeight) {
        Context app = context.getApplicationContext();
        for (WallpaperAccess.Level level : levels(app)) {
            Bitmap bitmap = null;
            if (level == WallpaperAccess.Level.SYSTEM_API) {
                bitmap = fromSystem(app, coverWidth, coverHeight);
            } else if (level == WallpaperAccess.Level.OWN_COPY) {
                bitmap = OwnWallpaperCopy.read(app, coverWidth, coverHeight);
            } else if (level == WallpaperAccess.Level.HOST) {
                bitmap = fromHost(coverWidth, coverHeight);
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

    /**
     * The real size of the screen in its present orientation, with the system bars: the size a backdrop of the
     * whole screen covers. Read from the display itself, which every kind of context may ask, never 0.
     */
    @SuppressWarnings("deprecation") // getRealMetrics(): the display's real size on every API level this runs on
    static Point screenSize(Context context) {
        Point size = new Point();
        try {
            DisplayManager displays = context.getSystemService(DisplayManager.class);
            Display display = displays != null ? displays.getDisplay(Display.DEFAULT_DISPLAY) : null;
            if (display != null) {
                DisplayMetrics metrics = new DisplayMetrics();
                display.getRealMetrics(metrics);
                size.set(metrics.widthPixels, metrics.heightPixels);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "The screen's real size is not known: " + e);
        }
        if (size.x <= 0 || size.y <= 0) {
            DisplayMetrics metrics = context.getResources().getDisplayMetrics();
            size.set(Math.max(1, metrics.widthPixels), Math.max(1, metrics.heightPixels));
        }
        return size;
    }

    /**
     * Decodes the picture of this descriptor no bigger than it must be to cover the size asked (whole with 0).
     * BitmapFactory leaves a file's position where it was, so the size is read first and the picture after it
     * from the same descriptor; one that cannot seek (a pipe) is decoded whole, in one pass.
     */
    static Bitmap decode(FileDescriptor fd, int coverWidth, int coverHeight) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (coverWidth > 0 && coverHeight > 0 && seekable(fd)) {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fd, null, options);
            options.inSampleSize = SampleSize.toCover(options.outWidth, options.outHeight, coverWidth, coverHeight);
            options.inJustDecodeBounds = false;
        }
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(fd, null, options);
        if (bitmap != null && options.inSampleSize > 1) {
            Log.i(TAG, "Home wallpaper decoded at 1/" + options.inSampleSize + " to cover " + coverWidth + "x"
                    + coverHeight);
        }
        return bitmap;
    }

    private static boolean seekable(FileDescriptor fd) {
        try {
            Os.lseek(fd, 0, OsConstants.SEEK_CUR);
            return true;
        } catch (ErrnoException e) {
            return false;
        }
    }

    private static Bitmap fromSystem(Context app, int coverWidth, int coverHeight) {
        WallpaperManager manager = WallpaperManager.getInstance(app);
        // The stored picture of the home screen's wallpaper
        try (ParcelFileDescriptor file = manager.getWallpaperFile(WallpaperManager.FLAG_SYSTEM)) {
            if (file != null) {
                Bitmap bitmap = decode(file.getFileDescriptor(), coverWidth, coverHeight);
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
                // Drawn smaller by the same rule as a decoded picture, where a size to cover is given
                int sample = SampleSize.toCover(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(),
                        coverWidth, coverHeight);
                Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth() / sample,
                        drawable.getIntrinsicHeight() / sample, Bitmap.Config.ARGB_8888);
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

    private static Bitmap fromHost(int coverWidth, int coverHeight) {
        try (ParcelFileDescriptor file = WindowHostVdClient.readHomeWallpaper()) {
            return file == null ? null : decode(file.getFileDescriptor(), coverWidth, coverHeight);
        } catch (Exception e) {
            Log.w(TAG, "The host could not give the wallpaper: " + e);
            return null;
        }
    }
}
