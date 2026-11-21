package com.android.launcher66.settings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import com.android.launcher66.TestLauncherApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

/**
 * "Hide the apps" and "Fit the apps to their icons" (the owner, 2026-11-21): shown with the widget bar only, the
 * fitting and the horizontal bar's "App icons" not while the list is hidden; the order's row follows.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class AppsListRowsViewTest {

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    private static SettingsFragmentSecond open(ActivityController<SettingsActivity> controller) {
        FragmentManager manager = controller.get().getSupportFragmentManager();
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
        return screen;
    }

    private static boolean visible(SettingsFragmentSecond screen, String key) {
        Preference row = screen.findPreference(key);
        return row != null && row.isVisible();
    }

    @Test
    public void withTheWidgetBarBothRowsAreThereAndHidingTheAppsTakesTheFittingAndTheIconsAway() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putBoolean(Keys.WIDGET_BAR_NO_APPS, false).putBoolean(Keys.WIDGET_BAR_FIT_APPS, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        assertTrue(visible(screen, Keys.WIDGET_BAR_NO_APPS));
        assertTrue(visible(screen, Keys.WIDGET_BAR_FIT_APPS));
        assertTrue(visible(screen, Keys.HORIZONTAL_BAR_ICONS));
        String before = String.valueOf(screen.findPreference(Keys.HORIZONTAL_BAR_ORDER).getSummary());

        screen.findPreference(Keys.WIDGET_BAR_NO_APPS).performClick();
        ShadowLooper.idleMainLooper();
        assertTrue(prefs().getBoolean(Keys.WIDGET_BAR_NO_APPS, false));
        assertTrue("the row stays to turn it back", visible(screen, Keys.WIDGET_BAR_NO_APPS));
        assertFalse("nothing to fit", visible(screen, Keys.WIDGET_BAR_FIT_APPS));
        assertFalse("no icons to count", visible(screen, Keys.HORIZONTAL_BAR_ICONS));
        String after = String.valueOf(screen.findPreference(Keys.HORIZONTAL_BAR_ORDER).getSummary());
        assertTrue("the order's row without the apps: " + before + " / " + after, after.length() < before.length());
        controller.pause().stop().destroy();
    }

    @Test
    public void withoutTheWidgetBarNeitherRowIsShownAndTheIconsAreCounted() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, false)
                .putBoolean(Keys.WIDGET_BAR_NO_APPS, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        assertFalse(visible(screen, Keys.WIDGET_BAR_NO_APPS));
        assertFalse(visible(screen, Keys.WIDGET_BAR_FIT_APPS));
        assertTrue("the list is always there without the widget bar", visible(screen, Keys.HORIZONTAL_BAR_ICONS));
        controller.pause().stop().destroy();
    }
}
