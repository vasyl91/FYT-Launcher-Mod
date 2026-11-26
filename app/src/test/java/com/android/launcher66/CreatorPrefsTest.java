package com.android.launcher66;

import static org.junit.Assert.assertEquals;
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
 * "Stock layout" (USER_LAYOUT off) shows the launcher the defaults of the creator's settings: a bar colour,
 * a grid of 12 x 8 and a text size of 40 that are stored do not apply, and they apply again with the creator on.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class CreatorPrefsTest {

    private static SharedPreferences prefs() {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().clear().commit();
        return prefs;
    }

    @Test
    public void theStockLayoutGivesTheDefaultsWhateverIsStored() {
        SharedPreferences prefs = prefs();
        prefs.edit()
                .putBoolean(Keys.USER_LAYOUT, false)
                .putInt(Keys.BAR_TINT_COLOR, 0xffff0000)
                .putInt(Keys.WORKSPACE_GRID_LONG, 12)
                .putInt(Keys.WORKSPACE_GRID_SHORT, 8)
                .putString("workspace_textSize", "40")
                .putBoolean(Keys.HORIZONTAL_BAR_TOP, true)
                .commit();
        CreatorPrefs creator = CreatorPrefs.of(prefs);
        assertFalse(creator.creatorOn());
        assertEquals(-7, creator.getInt(Keys.BAR_TINT_COLOR, -7));
        assertEquals(10, creator.getInt(Keys.WORKSPACE_GRID_LONG, 10));
        assertEquals(6, creator.getInt(Keys.WORKSPACE_GRID_SHORT, 6));
        assertEquals("30", creator.getString("workspace_textSize", "30"));
        assertFalse(creator.getBoolean(Keys.HORIZONTAL_BAR_TOP, false));
        assertFalse(creator.contains(Keys.BAR_TINT_COLOR));
    }

    @Test
    public void withTheCreatorOnTheStoredValuesApply() {
        SharedPreferences prefs = prefs();
        prefs.edit()
                .putBoolean(Keys.USER_LAYOUT, true)
                .putInt(Keys.BAR_TINT_COLOR, 0xffff0000)
                .putInt(Keys.WORKSPACE_GRID_LONG, 12)
                .putBoolean(Keys.HORIZONTAL_BAR_TOP, true)
                .commit();
        CreatorPrefs creator = CreatorPrefs.of(prefs);
        assertTrue(creator.creatorOn());
        assertEquals(0xffff0000, creator.getInt(Keys.BAR_TINT_COLOR, -7));
        assertEquals(12, creator.getInt(Keys.WORKSPACE_GRID_LONG, 10));
        assertTrue(creator.getBoolean(Keys.HORIZONTAL_BAR_TOP, false));
        assertTrue(creator.contains(Keys.BAR_TINT_COLOR));
    }

    @Test
    public void aKeyThatIsNotTheCreatorsIsReadAsStoredInTheStockLayoutToo() {
        SharedPreferences prefs = prefs();
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).putBoolean("badges_enabled", false).commit();
        assertFalse(CreatorPrefs.of(prefs).getBoolean("badges_enabled", true));
    }

    @Test
    public void theStoredValuesAreKeptForWhenTheCreatorComesBack() {
        SharedPreferences prefs = prefs();
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).putInt(Keys.WORKSPACE_GRID_LONG, 12).commit();
        assertEquals(10, CreatorPrefs.of(prefs).getInt(Keys.WORKSPACE_GRID_LONG, 10));
        assertEquals(12, prefs.getInt(Keys.WORKSPACE_GRID_LONG, 10));
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        assertEquals(12, CreatorPrefs.of(prefs).getInt(Keys.WORKSPACE_GRID_LONG, 10));
    }
}
