package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.Map;
import java.util.Set;

/**
 * The settings of a touch are read once and kept: many moves of a finger (or of a drag's search for a cell)
 * read the preferences no more than the first did, and a change of any setting is seen at the next move.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class TouchSettingsTest {

    /** The default preferences, with every reading counted. */
    private static final class Counting implements SharedPreferences {
        final SharedPreferences real;
        int reads;

        Counting(SharedPreferences real) {
            this.real = real;
        }

        @Override public Map<String, ?> getAll() { reads++; return real.getAll(); }
        @Override public String getString(String k, String d) { reads++; return real.getString(k, d); }
        @Override public Set<String> getStringSet(String k, Set<String> d) { reads++; return real.getStringSet(k, d); }
        @Override public int getInt(String k, int d) { reads++; return real.getInt(k, d); }
        @Override public long getLong(String k, long d) { reads++; return real.getLong(k, d); }
        @Override public float getFloat(String k, float d) { reads++; return real.getFloat(k, d); }
        @Override public boolean getBoolean(String k, boolean d) { reads++; return real.getBoolean(k, d); }
        @Override public boolean contains(String k) { reads++; return real.contains(k); }
        @Override public Editor edit() { return real.edit(); }
        @Override public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener l) {
            real.registerOnSharedPreferenceChangeListener(l);
        }
        @Override public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener l) {
            real.unregisterOnSharedPreferenceChangeListener(l);
        }
    }

    private static Context app() {
        return RuntimeEnvironment.getApplication();
    }

    private static Counting counting() {
        SharedPreferences real = PreferenceManager.getDefaultSharedPreferences(app());
        real.edit().clear().commit();
        Counting counting = new Counting(real);
        TouchSettings.use(app(), counting);
        return counting;
    }

    private static void oneMove() {
        TouchSettings.swipeUp(app());
        TouchSettings.swipeDown(app());
        TouchSettings.cornerCell(app(), true);
        TouchSettings.cornerCell(app(), false);
        TouchSettings.barSides(app());
    }

    @After
    public void backToTheApplicationsOwn() {
        TouchSettings.use(app(), PreferenceManager.getDefaultSharedPreferences(app()));
    }

    @Test
    public void manyMovesReadTheSettingsNoMoreThanTheFirst() {
        Counting prefs = counting();
        oneMove();
        int first = prefs.reads;
        assertTrue("the first move reads the settings", first > 0);
        for (int i = 0; i < 300; i++) {
            oneMove();
        }
        assertEquals("no more reads after the first move", first, prefs.reads);
    }

    @Test
    public void aChangeOfASettingIsSeenAtTheNextMove() {
        Counting prefs = counting();
        assertFalse(TouchSettings.swipeUp(app()));
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.SWIPE_UP_APP_DRAWER, true).commit();
        assertTrue(TouchSettings.swipeUp(app()));
        prefs.edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        assertFalse("with Stock layout the creator's swipe is off", TouchSettings.swipeUp(app()));
    }

    @Test
    public void theBarsSidesFollowTheVerticalBar() {
        Counting prefs = counting();
        assertFalse(TouchSettings.barSides(app()).verticalBar);
        prefs.edit().putBoolean(Keys.VERTICAL_BAR, true).commit();
        assertTrue(TouchSettings.barSides(app()).verticalBar);
    }
}
