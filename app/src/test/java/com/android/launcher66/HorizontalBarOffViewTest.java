package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.SharedPreferences;
import android.view.View;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.BarLayouts;
import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * "Display horizontal bar" off leaves nothing of the bar (the owner on the A55, 2026-11-27: its apps list was still
 * there and the vertical bar kept the bar's room): the list is GONE whenever it is shown again, and the vertical bar's
 * geometry has the whole height, whatever the caller says of the page.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class HorizontalBarOffViewTest {

    private static SharedPreferences prefs(boolean displayed) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.VERTICAL_BAR, true)
                .putBoolean(Keys.DISPLAY_HORIZONTAL_BAR, displayed).commit();
        return prefs;
    }

    @Test
    public void theAppsListStaysGoneWithoutTheBar() {
        assertEquals(View.GONE, WidgetBarLayout.appsListVisibility(prefs(false)));
        assertEquals(View.VISIBLE, WidgetBarLayout.appsListVisibility(prefs(true)));
    }

    @Test
    public void theVerticalBarHasTheWholeHeightWithoutTheBar() {
        int[] off = BarLayouts.of(prefs(false), 1920, 1080, 160, 120, true, true).verticalWindow(false);
        assertEquals("from the top to the bottom", 1080, off[3] - off[1]);
        int[] on = BarLayouts.of(prefs(true), 1920, 1080, 160, 120, true, true).verticalWindow(false);
        assertTrue("with the bar it ends above it", on[3] - on[1] < 1080);
    }
}
