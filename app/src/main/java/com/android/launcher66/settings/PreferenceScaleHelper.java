package com.android.launcher66.settings;

import static com.android.launcher66.settings.SettingsActivity.getSettingsActivity;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Non-FYT devices: keeps the preference list clear of the system bars (the settings window is
 * edge-to-edge there, see SettingsActivity.setupEdgeToEdge()).
 *
 * The list used to be shrunk here as well, row by row after each row was attached, which showed
 * every row at full size first and squeezed the nested indent. The proportions now come from the
 * activity's reference density instead (SettingsActivity.attachBaseContext()).
 */
public class PreferenceScaleHelper {

    private static final String TAG = "PreferenceScaleHelper";

    public static void applySystemBarInsets(RecyclerView recyclerView) {
        SettingsActivity activity = getSettingsActivity();
        if (recyclerView == null || activity == null) return;

        int statusBarHeight = activity.getStatusBarHeight();
        int actionBarHeight = activity.getActionBarHeight();
        int navigationBarHeight = activity.getNavigationBarHeight();
        int topPadding = statusBarHeight + actionBarHeight;

        Log.i(TAG, "Insets - status: " + statusBarHeight + ", action bar: " + actionBarHeight
                + ", nav: " + navigationBarHeight + ", portrait: " + SettingsActivity.isPortrait);

        if (SettingsActivity.isPortrait) {
            recyclerView.setPadding(recyclerView.getPaddingLeft(), topPadding,
                    recyclerView.getPaddingRight(), navigationBarHeight);
        } else {
            recyclerView.setPadding(recyclerView.getPaddingLeft(), topPadding,
                    recyclerView.getPaddingRight() + navigationBarHeight, recyclerView.getPaddingBottom());
        }
        recyclerView.setClipToPadding(false);
    }
}
