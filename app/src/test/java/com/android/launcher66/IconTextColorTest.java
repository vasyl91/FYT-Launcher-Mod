package com.android.launcher66;

import static org.junit.Assert.assertEquals;

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
 * "Set icon text color": the names under the icons are white until a colour is chosen, and white again with the
 * stock layout, whatever is stored.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class IconTextColorTest {

    private static final int WHITE = 0xffffffff;

    private static SharedPreferences prefs() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().clear().commit();
        return prefs;
    }

    @Test
    public void whiteWithoutAChosenColour() {
        SharedPreferences prefs = prefs();
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        assertEquals(WHITE, IconTextColor.workspace(prefs, RuntimeEnvironment.getApplication()));
    }

    @Test
    public void theChosenColourWithTheCreatorOnAndAlwaysOpaque() {
        SharedPreferences prefs = prefs();
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putInt(Keys.WORKSPACE_TEXT_COLOR, 0x40336699).commit();
        assertEquals(0xff336699, IconTextColor.workspace(prefs, RuntimeEnvironment.getApplication()));
    }

    @Test
    public void whiteWithTheStockLayoutWhateverIsStored() {
        SharedPreferences prefs = prefs();
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).putInt(Keys.WORKSPACE_TEXT_COLOR, 0xff336699).commit();
        assertEquals(WHITE, IconTextColor.workspace(prefs, RuntimeEnvironment.getApplication()));
    }
}
