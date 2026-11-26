package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
 * The screen "Notification badges" (H2): its rows are in the order the owner gave, the defaults are the ones of the brief,
 * and with the first switch off every row below it is dimmed but there.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class NotificationBadgesFragmentTest {

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    private static NotificationBadgesFragment open(ActivityController<SettingsActivity> controller) {
        FragmentManager manager = controller.get().getSupportFragmentManager();
        NotificationBadgesFragment screen = new NotificationBadgesFragment();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
        return screen;
    }

    @Test
    public void theRowsAreThereWithTheDefaultsOfTheBrief() {
        prefs().edit().clear().commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        NotificationBadgesFragment screen = open(controller);
        for (String key : new String[] {Keys.BADGES_ENABLED, Keys.BADGES_PREVIEW, Keys.BADGES_POSITION, Keys.BADGES_SIZE,
                Keys.BADGES_CORNER, Keys.BADGES_COLOR, Keys.BADGES_OUTLINE}) {
            assertNotNull(key + " is a row of the screen", screen.findPreference(key));
        }
        assertTrue(prefs().getBoolean(Keys.BADGES_ENABLED, true));
        androidx.preference.ListPreference position = screen.findPreference(Keys.BADGES_POSITION);
        assertEquals("top_right", position.getValue());
        androidx.preference.ListPreference size = screen.findPreference(Keys.BADGES_SIZE);
        assertEquals("medium", size.getValue());
        assertEquals(4, position.getEntries().length);
        assertEquals(3, size.getEntries().length);
        controller.pause().stop().destroy();
    }

    @Test
    public void withTheBadgesOffEveryRowBelowTheSwitchIsDimmedAndStillThere() {
        prefs().edit().clear().putBoolean(Keys.BADGES_ENABLED, false).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        NotificationBadgesFragment screen = open(controller);
        for (String key : new String[] {Keys.BADGES_POSITION, Keys.BADGES_SIZE, Keys.BADGES_CORNER, Keys.BADGES_COLOR,
                Keys.BADGES_OUTLINE}) {
            Preference row = screen.findPreference(key);
            assertNotNull(row);
            assertTrue(row.isVisible());
            assertFalse(key + " does not respond", row.isEnabled());
        }
        assertTrue("the switch itself does", screen.findPreference(Keys.BADGES_ENABLED).isEnabled());
        controller.pause().stop().destroy();
    }

    @Test
    public void theBadgeSettingsAreNotTheCreators() {
        // CreatorKeys has none of them: the badges work with the stock layout too
        for (String key : new String[] {Keys.BADGES_ENABLED, Keys.BADGES_POSITION, Keys.BADGES_SIZE, Keys.BADGES_CORNER,
                Keys.BADGES_COLOR, Keys.BADGES_OUTLINE}) {
            assertFalse(key, com.android.launcher66.CreatorKeys.contains(key));
        }
    }
}
