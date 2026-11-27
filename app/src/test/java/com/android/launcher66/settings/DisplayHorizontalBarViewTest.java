package com.android.launcher66.settings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;
import androidx.preference.TwoStatePreference;

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
 * "Display horizontal bar" in the creator (E1 of round 28, done in round 29): off, the rows of the horizontal bar and of the
 * widget bar are hidden and the swipe up is on and cannot be turned off; on again, the rows are back as they were.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class DisplayHorizontalBarViewTest {

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

    @Test
    public void offHidesTheBarsRowsAndLocksTheSwipeUpOnAndOnBringsThemBack() {
        prefs().edit().clear().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        TwoStatePreference display = screen.findPreference(Keys.DISPLAY_HORIZONTAL_BAR);
        assertNotNull(display);
        assertTrue("on by default", display.isChecked());
        Preference top = screen.findPreference(Keys.HORIZONTAL_BAR_TOP);
        Preference widgetBar = screen.findPreference(Keys.WIDGET_BAR);
        Preference noWeather = screen.findPreference(Keys.WIDGET_BAR_NO_WEATHER);
        assertTrue(top.isVisible());
        assertTrue(widgetBar.isVisible());
        assertTrue("the widget bar is on: its rows are there", noWeather.isVisible());

        display.performClick();
        ShadowLooper.idleMainLooper();
        assertFalse(prefs().getBoolean(Keys.DISPLAY_HORIZONTAL_BAR, true));
        assertFalse(top.isVisible());
        assertFalse(widgetBar.isVisible());
        assertFalse(noWeather.isVisible());
        TwoStatePreference swipe = screen.findPreference(Keys.SWIPE_UP_APP_DRAWER);
        if (swipe != null) {
            assertTrue("the swipe up is the way to the drawer now", swipe.isChecked());
            assertFalse("and cannot be turned off", swipe.isEnabled());
        }

        display.performClick();
        ShadowLooper.idleMainLooper();
        assertTrue(top.isVisible());
        assertTrue(widgetBar.isVisible());
        assertTrue("back as it was", noWeather.isVisible());
        if (swipe != null) {
            assertTrue(swipe.isEnabled());
        }
        controller.pause().stop().destroy();
    }
}
