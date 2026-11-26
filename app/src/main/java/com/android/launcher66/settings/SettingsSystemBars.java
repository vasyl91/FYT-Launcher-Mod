package com.android.launcher66.settings;

import android.view.View;

/**
 * The room of the status bar, the action bar and the navigation bar for a screen of the settings that is not a
 * preference list (those get it from {@link PreferenceScaleHelper#applySystemBarInsets}): the same numbers, on the
 * screen's root. Not used on a FYT unit, where the settings are laid out without the system bars.
 */
final class SettingsSystemBars {

    private SettingsSystemBars() {
    }

    static void pad(View root) {
        SettingsActivity activity = SettingsActivity.getSettingsActivity();
        if (root == null || activity == null) {
            return;
        }
        int top = activity.getStatusBarHeight() + activity.getActionBarHeight();
        int navigation = activity.getNavigationBarHeight();
        if (SettingsActivity.isPortrait) {
            root.setPadding(root.getPaddingLeft(), top, root.getPaddingRight(), navigation);
        } else {
            root.setPadding(root.getPaddingLeft(), top, root.getPaddingRight() + navigation, root.getPaddingBottom());
        }
    }
}
