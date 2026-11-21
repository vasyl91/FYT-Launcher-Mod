package com.android.launcher66.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Shadows.shadowOf;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceManager;

import com.android.launcher66.TestLauncherApplication;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.android.controller.ActivityController;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowDialog;

/**
 * A dialog that is open when the screen turns is open again after the turn, with what was typed into it (the
 * owner, 2026-11-21; SettingsDialogMemory). On a phone the settings are created again for the other orientation
 * (recreate()), as {@code controller.recreate()} does here.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class, qualifiers = "w2000dp-h1200dp-land-mdpi")
public class SettingsDialogTurnViewTest {

    @After
    public void forget() {
        SettingsDialogMemory.forget();
    }

    private static EditText firstField(Dialog dialog) {
        return findField(dialog.getWindow().getDecorView());
    }

    private static EditText findField(View view) {
        if (view instanceof EditText) {
            return (EditText) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                EditText found = findField(group.getChildAt(i));
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    private static Fragment shown(ActivityController<SettingsActivity> controller) {
        return controller.get().getSupportFragmentManager().findFragmentById(android.R.id.content);
    }

    @Test
    public void theMarginsDialogComesBackWithWhatWasTyped() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).commit();
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        SettingsFragmentSecond screen = new SettingsFragmentSecond();
        controller.get().getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, screen).commitNow();
        shadowOf(Looper.getMainLooper()).idle();

        Preference row = screen.findPreference(Keys.LAYOUT_MARGIN);
        assertNotNull(row);
        row.performClick();
        shadowOf(Looper.getMainLooper()).idle();
        Dialog before = ShadowDialog.getLatestDialog();
        assertTrue(before.isShowing());
        firstField(before).setText("17");
        assertEquals("the field takes 0 to 25", "17", firstField(before).getText().toString());

        // The screen turns on a phone: the settings are created again
        RuntimeEnvironment.setQualifiers("w1200dp-h2000dp-port-mdpi");
        controller.recreate();
        shadowOf(Looper.getMainLooper()).idle();

        assertNotSame("a new screen", screen, shown(controller));
        Dialog after = ShadowDialog.getLatestDialog();
        assertNotSame(before, after);
        assertFalse("the old screen's dialog went with it", before.isShowing());
        assertTrue("open again", after.isShowing());
        assertEquals("17", firstField(after).getText().toString());

        controller.pause().stop().destroy();
    }

    @Test
    public void theWeatherKeyDialogOfTheFirstScreenComesBackWithWhatWasTyped() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        shadowOf(Looper.getMainLooper()).idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) shown(controller);

        Preference row = screen.findPreference(Keys.OPENWEATHER_API_KEY);
        assertNotNull(row);
        row.performClick();
        shadowOf(Looper.getMainLooper()).idle();
        Dialog before = ShadowDialog.getLatestDialog();
        firstField(before).setText("abc123");

        controller.recreate();
        shadowOf(Looper.getMainLooper()).idle();

        Dialog after = ShadowDialog.getLatestDialog();
        assertNotSame(before, after);
        assertTrue(after.isShowing());
        assertEquals("abc123", firstField(after).getText().toString());

        controller.pause().stop().destroy();
    }

    @Test
    public void aDialogClosedBeforeTheTurnStaysClosed() {
        ActivityController<SettingsActivity> controller = Robolectric.buildActivity(SettingsActivity.class).setup();
        shadowOf(Looper.getMainLooper()).idle();
        SettingsFragmentFirst screen = (SettingsFragmentFirst) shown(controller);
        screen.findPreference(Keys.OPENWEATHER_API_KEY).performClick();
        shadowOf(Looper.getMainLooper()).idle();
        Dialog before = ShadowDialog.getLatestDialog();
        before.dismiss();

        controller.recreate();
        shadowOf(Looper.getMainLooper()).idle();

        assertEquals("no dialog opened by the new screen", before, ShadowDialog.getLatestDialog());
        controller.pause().stop().destroy();
    }
}
