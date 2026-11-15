package com.android.launcher66.settings;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * The copy the launcher keeps of a wallpaper it set itself, for the devices where it cannot read the
 * wallpaper back (Android 13 and later without a privileged host that can).
 *
 * <p>Whoever in the launcher sets a wallpaper (the wallpaper picker, the night mode, "Save the day
 * wallpaper") hands the picture here right after, and it is kept with the id the system gave the new
 * wallpaper. HomeWallpaperSource reads it back as one of its ways, and only while that wallpaper is still
 * the one that is set (OwnWallpaperRecord). So a wallpaper chosen in the launcher's picker shows behind the
 * background selectors and can be saved for the day or the night, with no permission at all.
 *
 * <p>Nothing is kept where the system's API gives the launcher the picture anyway (a system app, or with the
 * storage access the API wants): the copy would never be asked for. The picker runs in a process of its own,
 * so the copy and its id are two files in the launcher's files directory, not preferences. Every method
 * blocks on files: never on the main thread.
 */
public final class OwnWallpaperCopy {

    private static final String TAG = "OwnWallpaperCopy";
    private static final String DIR = "wallpaper_img";
    private static final String IMAGE = "current.img";
    private static final String ID = "current.id";
    private static final Object LOCK = new Object();

    private OwnWallpaperCopy() {
    }

    /** Whether this device needs the copy: the system's API does not give the launcher the picture. */
    private static boolean wanted(Context context) {
        boolean storage = ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                == android.content.pm.PackageManager.PERMISSION_GRANTED;
        boolean allFiles = Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && Environment.isExternalStorageManager();
        return !WallpaperAccess.apiGivesThePicture(Build.VERSION.SDK_INT, Process.myUid() == Process.SYSTEM_UID,
                storage, allFiles);
    }

    /** The picture just set as the home screen's wallpaper, as the bytes of an image file. */
    public static void note(Context context, byte[] image) {
        if (image == null || image.length == 0) {
            return;
        }
        store(context, out -> out.write(image));
    }

    /** The picture just set as the home screen's wallpaper, read from a stream to its end (not closed here). */
    public static void note(Context context, InputStream image) {
        if (image == null) {
            return;
        }
        store(context, out -> {
            byte[] buffer = new byte[64 * 1024];
            int read;
            while ((read = image.read(buffer)) > 0) {
                out.write(buffer, 0, read);
            }
        });
    }

    /** The image file just set as the home screen's wallpaper. */
    public static void note(Context context, File image) {
        if (image == null || !image.isFile()) {
            return;
        }
        try (InputStream in = new FileInputStream(image)) {
            note(context, in);
        } catch (IOException e) {
            Log.w(TAG, "The wallpaper's copy could not be kept: " + e);
        }
    }

    /** The bitmap just set as the home screen's wallpaper. */
    public static void note(Context context, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        if (!wanted(context.getApplicationContext())) {
            return;   // before the bitmap is compressed for nothing
        }
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, bytes)) {
            note(context, bytes.toByteArray());
        }
    }

    private interface Writer {
        void write(FileOutputStream out) throws IOException;
    }

    private static void store(Context context, Writer writer) {
        Context app = context.getApplicationContext();
        if (!wanted(app)) {
            return;
        }
        int id;
        try {
            id = WallpaperManager.getInstance(app).getWallpaperId(WallpaperManager.FLAG_SYSTEM);
        } catch (RuntimeException e) {
            Log.w(TAG, "The id of the wallpaper is not known, no copy is kept: " + e);
            return;
        }
        synchronized (LOCK) {
            File dir = new File(app.getFilesDir(), DIR);
            if (!dir.isDirectory() && !dir.mkdirs()) {
                Log.w(TAG, "No directory for the wallpaper's copy");
                return;
            }
            File idFile = new File(dir, ID);
            // The id goes first: a copy half written must not pass for the wallpaper that was there before
            if (idFile.exists() && !idFile.delete()) {
                Log.w(TAG, "The old id of the wallpaper's copy could not be removed");
                return;
            }
            File image = new File(dir, IMAGE);
            try (FileOutputStream out = new FileOutputStream(image)) {
                writer.write(out);
            } catch (IOException e) {
                Log.w(TAG, "The wallpaper's copy could not be written: " + e);
                return;
            }
            try (FileOutputStream out = new FileOutputStream(idFile)) {
                out.write(OwnWallpaperRecord.format(id).getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                Log.w(TAG, "The id of the wallpaper's copy could not be written: " + e);
                return;
            }
            Log.i(TAG, "Kept a copy of the wallpaper the launcher set (id " + id + ", " + image.length() + " bytes)");
        }
    }

    /** The copy, if the wallpaper it was made of is still the one that is set; else null. */
    static Bitmap read(Context context) {
        Context app = context.getApplicationContext();
        synchronized (LOCK) {
            File dir = new File(app.getFilesDir(), DIR);
            File idFile = new File(dir, ID);
            File image = new File(dir, IMAGE);
            if (!idFile.isFile() || !image.isFile()) {
                return null;
            }
            int noted;
            try (InputStream in = new FileInputStream(idFile)) {
                byte[] text = new byte[32];
                int read = in.read(text);
                noted = OwnWallpaperRecord.parse(read > 0 ? new String(text, 0, read, StandardCharsets.UTF_8) : null);
            } catch (IOException e) {
                return null;
            }
            int current;
            try {
                current = WallpaperManager.getInstance(app).getWallpaperId(WallpaperManager.FLAG_SYSTEM);
            } catch (RuntimeException e) {
                return null;
            }
            if (!OwnWallpaperRecord.stillSet(noted, current)) {
                Log.i(TAG, "The copy is of another wallpaper (id " + noted + ", now " + current + "): not used");
                return null;
            }
            return BitmapFactory.decodeFile(image.getAbsolutePath());
        }
    }
}
