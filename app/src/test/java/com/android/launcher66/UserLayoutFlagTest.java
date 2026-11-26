package com.android.launcher66;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The creator's switch is readable before any page exists (a touch right after a start used to meet a null
 * preferences field in Workspace.determineScrollingStart) and follows the preference afterwards.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class UserLayoutFlagTest {

    @Test
    public void theFlagHasTheStoredValueFromTheStart() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        assertTrue(new UserLayoutFlag(prefs).get());

        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        assertFalse(new UserLayoutFlag(prefs).get());
    }

    @Test
    public void theFlagFollowsAChangeOfTheKeyAndNotOfAnotherKey() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        UserLayoutFlag flag = new UserLayoutFlag(prefs);
        assertFalse(flag.get());

        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        assertTrue(flag.get());

        prefs.edit().putBoolean(Keys.VERTICAL_BAR, true).commit();
        assertTrue(flag.get());
    }

    @Test
    public void refreshReadsTheValueAgain() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        UserLayoutFlag flag = new UserLayoutFlag(prefs);
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        flag.refresh();
        assertTrue(flag.get());
    }
}
