package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Looper;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;

import com.android.launcher66.R;
import com.android.launcher66.TestLauncherApplication;
import com.android.launcher66.colorpicker.ColorPicker;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;

/**
 * The colour picker comes back by itself after a turn of the screen (a DialogFragment), and "Select" stores its
 * colour there too (the owner, 2026-11-21; ColorPickerTargets). On a phone a turn creates the settings again
 * (recreate()), as {@code controller.recreate()} does here.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class ColorPickerTurnViewTest {

    @After
    public void forget() {
        SettingsDialogMemory.forget();
    }

    private static void idle() {
        shadowOf(Looper.getMainLooper()).idle();
    }

    private static ColorPicker picker(ActivityController<SettingsActivity> controller, String tag) {
        Fragment f = controller.get().getSupportFragmentManager().findFragmentByTag(tag);
        return f instanceof ColorPicker ? (ColorPicker) f : null;
    }

    private static ActivityController<SettingsActivity> secondScreen() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragmentSecond()).commitNow();
        idle();
        return controller;
    }

    private static SettingsFragmentSecond shown(ActivityController<SettingsActivity> controller) {
        return (SettingsFragmentSecond) controller.get().getSupportFragmentManager()
                .findFragmentById(android.R.id.content);
    }

    @Test
    public void theTintPickerStoresItsColourAfterATurn() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putInt(Keys.BAR_TINT_COLOR, Color.rgb(10, 20, 30)).commit();
        ActivityController<SettingsActivity> controller = secondScreen();
        shown(controller).findPreference(Keys.BAR_TINT).performClick();
        idle();
        ColorPicker before = picker(controller, "TintPicker");
        assertNotNull(before);

        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        idle();

        ColorPicker after = picker(controller, "TintPicker");
        assertNotNull("the picker comes back by itself", after);
        assertNotSame(before, after);
        assertTrue(after.isShowing());
        after.setColors(200, 100, 50);
        View select = after.requireView().findViewById(R.id.okColorButton);
        select.performClick();
        idle();
        assertEquals("Select stores the colour after the turn", Color.rgb(200, 100, 50),
                prefs.getInt(Keys.BAR_TINT_COLOR, 0));
        assertFalse("and closes the picker, as before the turn", after.isAdded());

        controller.pause().stop().destroy();
    }

    @Test
    public void defaultForgetsTheTintAfterATurn() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putInt(Keys.WIDGETS_TINT_COLOR, Color.rgb(10, 20, 30)).commit();
        ActivityController<SettingsActivity> controller = secondScreen();
        shown(controller).findPreference(Keys.WIDGETS_TINT).performClick();
        idle();

        controller.recreate();
        idle();

        ColorPicker after = picker(controller, "TintPicker");
        assertNotNull(after);
        after.requireView().findViewById(R.id.defaultColorButton).performClick();
        idle();
        assertFalse(prefs.contains(Keys.WIDGETS_TINT_COLOR));

        controller.pause().stop().destroy();
    }

    @Test
    public void theStatisticsColourIsStoredAsTextAfterATurn() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putString("stats_color", "#FFFFFFFF").commit();
        ActivityController<SettingsActivity> controller = secondScreen();
        shown(controller).findPreference(Keys.COLOR_PICKER).performClick();
        idle();

        controller.recreate();
        idle();

        ColorPicker after = picker(controller, "ColorPicker");
        assertNotNull(after);
        after.setColors(0x12, 0x34, 0x56);
        after.requireView().findViewById(R.id.okColorButton).performClick();
        idle();
        assertEquals("#123456", prefs.getString("stats_color", null));

        controller.pause().stop().destroy();
    }

    @Test
    public void leavingTheScreenForGoodClosesThePicker() {
        ActivityController<SettingsActivity> controller = secondScreen();
        shown(controller).findPreference(Keys.COLOR_PICKER).performClick();
        idle();
        assertNotNull(picker(controller, "ColorPicker"));

        FragmentManager fragments = controller.get().getSupportFragmentManager();
        fragments.beginTransaction().replace(android.R.id.content, new SettingsFragmentFirst()).commitNow();
        idle();
        assertEquals("as before", null, picker(controller, "ColorPicker"));

        controller.pause().stop().destroy();
    }
}
