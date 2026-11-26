package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.launcher66.TestLauncherApplication;
import com.android.launcher66.ThemeAccent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import java.util.ArrayList;
import java.util.List;

/**
 * The accent of the settings reaches the creator's screen: every switch of its rows has it for the thumb when on, the
 * row "Set global theme color" is there, and with "Stock layout" the default blue is back.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w1080dp-h2340dp-port-mdpi")
public class AccentSettingsViewTest {

    private static final int RED = 0xffd32f2f;

    private static SharedPreferences prefs() {
        return PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
    }

    private static SettingsFragmentSecond open(ActivityController<SettingsActivity> controller) {
        FragmentManager manager = controller.get().getSupportFragmentManager();
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        manager.beginTransaction().replace(android.R.id.content, screen).commitNow();
        ShadowLooper.idleMainLooper();
        RecyclerView list = screen.getListView();
        list.measure(View.MeasureSpec.makeMeasureSpec(1080, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(2000, View.MeasureSpec.EXACTLY));
        list.layout(0, 0, 1080, 2000);
        ShadowLooper.idleMainLooper();
        return screen;
    }

    private static void switchesIn(View view, List<SwitchCompat> found) {
        if (view instanceof SwitchCompat) {
            found.add((SwitchCompat) view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                switchesIn(group.getChildAt(i), found);
            }
        }
    }

    private static int checkedThumb(SwitchCompat toggle) {
        ColorStateList thumb = toggle.getThumbTintList();
        return thumb.getColorForState(new int[] {android.R.attr.state_checked}, thumb.getDefaultColor());
    }

    @Test
    public void everySwitchOfTheCreatorsScreenHasTheChosenAccentWhenOn() {
        prefs().edit().clear().putBoolean(Keys.USER_LAYOUT, true).putInt(ThemeAccent.KEY, RED).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        assertTrue("the row of the colour is on the screen", screen.findPreference(ThemeAccent.KEY) != null);
        List<SwitchCompat> switches = new ArrayList<>();
        switchesIn(screen.getListView(), switches);
        assertFalse("the list shows switches", switches.isEmpty());
        for (SwitchCompat toggle : switches) {
            assertEquals(RED, checkedThumb(toggle));
        }
        controller.pause().stop().destroy();
    }

    @Test
    public void aChangeOfTheColourReachesTheRowsAtOnceAndTheStockLayoutGivesTheDefaultBack() {
        prefs().edit().clear().putBoolean(Keys.USER_LAYOUT, true).putInt(ThemeAccent.KEY, RED).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = open(controller);
        prefs().edit().putInt(ThemeAccent.KEY, 0xff2e7d32).commit();
        ShadowLooper.idleMainLooper();
        List<SwitchCompat> switches = new ArrayList<>();
        switchesIn(screen.getListView(), switches);
        assertFalse(switches.isEmpty());
        assertEquals(0xff2e7d32, checkedThumb(switches.get(0)));

        prefs().edit().putBoolean(Keys.USER_LAYOUT, false).commit();
        ShadowLooper.idleMainLooper();
        switches.clear();
        switchesIn(screen.getListView(), switches);
        assertEquals(ThemeAccent.DEFAULT, checkedThumb(switches.get(0)));
        controller.pause().stop().destroy();
    }
}
