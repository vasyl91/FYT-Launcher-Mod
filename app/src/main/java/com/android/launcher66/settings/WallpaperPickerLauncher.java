package com.android.launcher66.settings;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.WallpaperPickerActivity;

/**
 * Opens the wallpaper picker of the settings: the one behind "Wallpaper picker" under "Miscellaneous".
 *
 * <p>The rule: every place of the settings that lets the user choose a wallpaper opens the same picker, the
 * one the user chose with "Wallpaper picker source": the system's or the launcher's own. The row itself, the
 * "Pick wallpaper" button of the background selectors and the offer of "Save the day / night wallpaper" all
 * come here. (The two last used to open a file chooser for an image, which set no wallpaper at all: the
 * selector only showed the image behind its tiles.)
 *
 * <p>What the launcher's own picker sets, the launcher keeps a copy of (OwnWallpaperCopy), so it shows
 * behind the selectors afterwards even where the wallpaper cannot be read back. The system's picker gives
 * the launcher nothing; there the wallpaper is read as far as the device lets it (HomeWallpaperSource).
 */
final class WallpaperPickerLauncher {

    private static final String TAG = "WallpaperPickerLauncher";
    private static final String SYSTEM_PICKER = "com.android.wallpaper";

    private WallpaperPickerLauncher() {
    }

    /**
     * @param from the view that was tapped, for the system picker's opening animation; may be null
     * @return whether a picker was started
     */
    static boolean open(Context context, View from) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(Keys.WALLPAPER_PICKER_SOURCE, false) ? openSystem(from) : openOwn();
    }

    private static boolean openSystem(View from) {
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
        try {
            if (LauncherApplication.sApp.getPackageManager().getApplicationInfo(SYSTEM_PICKER, 0).enabled) {
                intent.setPackage(SYSTEM_PICKER);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.i(TAG, "No " + SYSTEM_PICKER + " here: any app that sets wallpapers is asked");
        }
        if (from != null && from.isAttachedToWindow()) {
            int[] at = new int[2];
            from.getLocationOnScreen(at);
            intent.setSourceBounds(new Rect(at[0], at[1], at[0] + from.getWidth(), at[1] + from.getHeight()));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            LauncherApplication.sApp.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Toast.makeText(LauncherApplication.sApp, "activity_not_found", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private static boolean openOwn() {
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
        intent.setComponent(new ComponentName(LauncherApplication.sApp.getPackageName(),
                WallpaperPickerActivity.class.getName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            LauncherApplication.sApp.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            Log.w(TAG, "The launcher's wallpaper picker could not be started: " + e.getMessage());
            return false;
        }
    }
}
