package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.android.launcher66.BarCapacity;
import com.android.launcher66.BarIconCount;
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
 * The sliders of the number of app icons in the second screen of the settings: shown with or without their
 * bar's "Resizable" switch (the owner, 2026-11-21), their end the most the bar has room for now; a chosen number
 * above a newly smaller most is lowered and stored lowered, one below it stays (BarIconCount, BarIconLimits).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class BarIconsSliderViewTest {

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
    public void theVerticalSliderEndsWhereTheBarIsFullAndLowersANumberAboveIt() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.VERTICAL_BAR, true)
                .putBoolean(Keys.RESIZABLE_VERTICAL_BAR, true)
                .putInt(Keys.VERTICAL_BAR_ICONS_PORT, 12).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        BarIconsSeekBarPreference slider = screen.findPreference(Keys.VERTICAL_BAR_ICONS);
        assertTrue(slider.isVisible());
        int max = BarIconLimits.verticalMax(screen.requireContext(), prefs());
        assertEquals(max, slider.getMax());
        assertTrue("room for fewer than 12: " + max, max < 12);
        assertEquals("lowered to the most and stored so", max, prefs().getInt(Keys.VERTICAL_BAR_ICONS_PORT, 0));

        // A wider bar has bigger icons and room for fewer: the end follows at once
        prefs().edit().putFloat(Keys.VERTICAL_BAR_WIDTH_PORT, 0.10f).commit();
        ShadowLooper.idleMainLooper();
        int wider = BarIconLimits.verticalMax(screen.requireContext(), prefs());
        assertTrue("fewer with a wider bar: " + wider + " < " + max, wider < max);
        assertEquals(wider, slider.getMax());
        assertEquals(wider, prefs().getInt(Keys.VERTICAL_BAR_ICONS_PORT, 0));
        controller.pause().stop().destroy();
    }

    @Test
    public void aSmallerNumberStaysAndNothingChosenIsTheMost() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.VERTICAL_BAR, true)
                .putBoolean(Keys.RESIZABLE_VERTICAL_BAR, true).putBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, true)
                .putInt(Keys.VERTICAL_BAR_ICONS_PORT, 2).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        BarIconsSeekBarPreference vertical = screen.findPreference(Keys.VERTICAL_BAR_ICONS);
        assertEquals(2, vertical.getValue());
        assertEquals(2, prefs().getInt(Keys.VERTICAL_BAR_ICONS_PORT, 0));
        BarIconsSeekBarPreference horizontal = screen.findPreference(Keys.HORIZONTAL_BAR_ICONS);
        assertTrue(horizontal.isVisible());
        assertEquals(horizontal.getMax(), horizontal.getValue());
        assertEquals(BarIconCount.UNSET, prefs().getInt(Keys.HORIZONTAL_BAR_ICONS_PORT, BarIconCount.UNSET));
        controller.pause().stop().destroy();
    }

    @Test
    public void withoutTheResizableSwitchesTheSlidersAreShownAndTheNumberCounts() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.VERTICAL_BAR, true)
                .putBoolean(Keys.RESIZABLE_VERTICAL_BAR, false).putBoolean(Keys.RESIZABLE_HORIZONTAL_BAR, false)
                .putInt(Keys.VERTICAL_BAR_ICONS_PORT, 3).putInt(Keys.HORIZONTAL_BAR_ICONS_PORT, 2).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        BarIconsSeekBarPreference vertical = screen.findPreference(Keys.VERTICAL_BAR_ICONS);
        BarIconsSeekBarPreference horizontal = screen.findPreference(Keys.HORIZONTAL_BAR_ICONS);
        assertTrue(vertical.isVisible());
        assertTrue(screen.findPreference("vertical_bar_icons_title").isVisible());
        assertTrue(horizontal.isVisible());
        assertEquals(3, vertical.getValue());
        assertEquals(2, horizontal.getValue());
        assertFalse("the width stays with its switch", screen.findPreference(Keys.VERTICAL_BAR_WIDTH).isVisible());

        // The launcher counts the chosen number without the switch too
        assertEquals(3, BarCapacity.chosen(prefs(), false, true));
        assertEquals(2, BarCapacity.chosen(prefs(), true, true));
        // Only the user layout has the bars' numbers
        prefs().edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        assertEquals(BarIconCount.UNSET, BarCapacity.chosen(prefs(), true, true));
        controller.pause().stop().destroy();
    }

    @Test
    public void withoutTheVerticalBarItsSliderIsNotShown() {
        prefs().edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.VERTICAL_BAR, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        assertFalse(((BarIconsSeekBarPreference) screen.findPreference(Keys.VERTICAL_BAR_ICONS)).isVisible());
        assertTrue(((BarIconsSeekBarPreference) screen.findPreference(Keys.HORIZONTAL_BAR_ICONS)).isVisible());
        controller.pause().stop().destroy();
    }
}
