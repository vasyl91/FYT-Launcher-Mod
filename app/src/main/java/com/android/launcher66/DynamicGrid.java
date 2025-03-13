package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.preference.PreferenceManager;

import java.util.ArrayList;

public class DynamicGrid {
    private static final String TAG = "DynamicGrid";
    private float mMinHeight;
    private float mMinWidth;
    private DeviceProfile mProfile;

    public static float dpiFromPx(int size, DisplayMetrics metrics) {
        float densityRatio = metrics.densityDpi / 160.0f;
        return size / densityRatio;
    }

    public static int pxFromDp(float size, DisplayMetrics metrics) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, metrics));
    }

    public static int pxFromSp(float size, DisplayMetrics metrics) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, size, metrics));
    }

    public DynamicGrid(Context context, Resources resources, int minWidthPx, int minHeightPx, int widthPx, int heightPx, int awPx, int ahPx) {
        DisplayMetrics dm = resources.getDisplayMetrics();
        ArrayList<DeviceProfile> deviceProfiles = new ArrayList<>();
        if (AppsCustomizePagedView.DISABLE_ALL_APPS) {
        }
        int iconSize = LauncherApplication.sApp.getResources().getInteger(R.integer.shortcut_icon_size);
        int numRows = LauncherApplication.sApp.getResources().getInteger(R.integer.numRows_size);
        int numCols = LauncherApplication.sApp.getResources().getInteger(R.integer.numCols_size);
        LauncherApplication.sApp.getResources().getInteger(R.integer.hoteseat3G_icon_size);
        int hotseatIcon_wifi = LauncherApplication.sApp.getResources().getInteger(R.integer.hoteseatwifi_icon_size);
        int iHotseatCount = LauncherApplication.sApp.getResources().getInteger(R.integer.nhotseat_count);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int iAllAppsTextSize = Integer.parseInt(prefs.getString("all_apps_textSize", String.valueOf(LauncherApplication.sApp.getResources().getInteger(R.integer.all_apps_textSize))));
        deviceProfiles.add(new DeviceProfile("fyt 10", 1024.0f, 600.0f, numRows, numCols, iconSize, iAllAppsTextSize, iHotseatCount, hotseatIcon_wifi));
        deviceProfiles.add(new DeviceProfile("fyt 12", 800.0f, 480.0f, numRows, numCols, iconSize, iAllAppsTextSize, iHotseatCount, hotseatIcon_wifi));
        deviceProfiles.add(new DeviceProfile("fyt 12", 980.0f, 420.0f, numRows, numCols, iconSize, iAllAppsTextSize, iHotseatCount, hotseatIcon_wifi));
        this.mMinWidth = dpiFromPx(minWidthPx, dm);
        this.mMinHeight = dpiFromPx(minHeightPx, dm);
        this.mProfile = new DeviceProfile(context, deviceProfiles, this.mMinWidth, this.mMinHeight, widthPx, heightPx, awPx, ahPx, resources);
    }

    public DeviceProfile getDeviceProfile() {
        return this.mProfile;
    }

    public String toString() {
        return "-------- DYNAMIC GRID ------- \nWd: " + this.mProfile.minWidthDps + ", Hd: " + this.mProfile.minHeightDps + ", W: " + this.mProfile.widthPx + ", H: " + this.mProfile.heightPx + " [r: " + this.mProfile.numRows + ", c: " + this.mProfile.numColumns + ", is: " + this.mProfile.iconSizePx + ", its: " + this.mProfile.iconTextSize + ", cw: " + this.mProfile.cellWidthPx + ", ch: " + this.mProfile.cellHeightPx + ", hc: " + this.mProfile.numHotseatIcons + ", his: " + this.mProfile.hotseatIconSizePx + "]";
    }
}
