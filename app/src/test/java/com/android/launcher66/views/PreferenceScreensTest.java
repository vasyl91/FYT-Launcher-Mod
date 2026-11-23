package com.android.launcher66.views;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.app.Application;
import android.content.Context;
import android.view.ContextThemeWrapper;

import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;

import com.android.launcher66.R;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

/**
 * The two screens of the settings are built from their XML files, with every custom preference class in them.
 * A row that names a class or a string that is not there, or a class whose constructor throws, fails here
 * and not on a device.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = Application.class)
public class PreferenceScreensTest {

    private static PreferenceScreen inflate(int xml) {
        Context context = new ContextThemeWrapper(RuntimeEnvironment.getApplication(), R.style.SettingsTheme);
        return new PreferenceManager(context).inflateFromResource(context, xml, null);
    }

    @Test
    public void theFirstScreenIsBuilt() {
        PreferenceScreen screen = inflate(R.xml.launcher_preferences);
        assertNotNull(screen.findPreference("wallpaper_picker"));
        assertNotNull(screen.findPreference("openweather_api_key"));
    }

    @Test
    public void theSecondScreenIsBuilt() {
        PreferenceScreen screen = inflate(R.xml.creator_preferences);
        assertNotNull(screen.findPreference("home_layout_category"));
        assertNotNull(screen.findPreference("workspace_grid_rows"));
        assertNotNull(screen.findPreference("start_page"));
    }

    @Test
    public void theTransparentStatusBarIsInTheHomeScreenLayoutAboveTheStartPage() {
        assertNull(inflate(R.xml.launcher_preferences).findPreference("transparent_statusbar"));
        PreferenceCategory home = inflate(R.xml.creator_preferences).findPreference("home_layout_category");
        assertNotNull(home);
        int statusBar = -1;
        int startPage = -1;
        for (int i = 0; i < home.getPreferenceCount(); i++) {
            String key = home.getPreference(i).getKey();
            if ("transparent_statusbar".equals(key)) statusBar = i;
            if ("start_page".equals(key)) startPage = i;
        }
        assertEquals("directly above the start page", startPage - 1, statusBar);
    }

    @Test
    public void theWidthOfTheVerticalBarIsSetUnderItsRows() {
        PreferenceCategory bars = inflate(R.xml.creator_preferences).findPreference("bars_category");
        assertNotNull(bars);
        int everyPage = -1;
        int resizable = -1;
        int width = -1;
        for (int i = 0; i < bars.getPreferenceCount(); i++) {
            String key = bars.getPreference(i).getKey();
            if ("vertical_bar_every_page".equals(key)) everyPage = i;
            if ("resizable_vertical_bar".equals(key)) resizable = i;
            if ("vertical_bar_width".equals(key)) width = i;
        }
        assertEquals("the switch under \"on every page\"", everyPage + 1, resizable);
        assertEquals("the slider under the switch", resizable + 1, width);
        assertEquals(com.android.launcher66.settings.VerticalBarWidthSeekBarPreference.class,
                bars.getPreference(width).getClass());
    }

    @Test
    public void theBarsAreThreeSectionsWithADividerBetweenThem() {
        PreferenceCategory bars = inflate(R.xml.creator_preferences).findPreference("bars_category");
        assertNotNull(bars);
        StringBuilder sections = new StringBuilder();
        for (int i = 0; i < bars.getPreferenceCount(); i++) {
            androidx.preference.Preference row = bars.getPreference(i);
            if (isDivider(row)) {
                sections.append('|');
            } else if ("horizontal_bar_top".equals(row.getKey())) {
                sections.append('H');
            } else if ("widget_bar".equals(row.getKey())) {
                sections.append('W');
            } else if ("left_bar".equals(row.getKey())) {
                sections.append('V');
            }
        }
        assertEquals("H|W|V", sections.toString());
        int widgetBar = -1;
        int verticalBar = -1;
        for (int i = 0; i < bars.getPreferenceCount(); i++) {
            if ("widget_bar".equals(bars.getPreference(i).getKey())) widgetBar = i;
            if ("left_bar".equals(bars.getPreference(i).getKey())) verticalBar = i;
        }
        assertTrue("a divider directly above the widget bar", isDivider(bars.getPreference(widgetBar - 1)));
        assertTrue("a divider directly above the vertical bar", isDivider(bars.getPreference(widgetBar - 1)));
    }

    @Test
    public void theAppsListRowsStandWithTheWidgetBarsHiddenWidgets() {
        PreferenceCategory bars = inflate(R.xml.creator_preferences).findPreference("bars_category");
        java.util.List<String> keys = new java.util.ArrayList<>();
        for (int i = 0; i < bars.getPreferenceCount(); i++) {
            keys.add(bars.getPreference(i).getKey());
        }
        int weather = keys.indexOf("widget_bar_no_weather");
        assertEquals("widget_bar_no_apps", keys.get(weather + 1));
        assertEquals("widget_bar_fit_apps", keys.get(weather + 2));
        assertEquals(true, keys.indexOf("widget_bar") < weather);
        assertEquals(true, weather + 2 < keys.indexOf("left_bar"));
    }

    @Test
    public void startOnWakeStandsUnderStartOnBoot() {
        PreferenceScreen screen = inflate(R.xml.launcher_preferences);
        Preference boot = screen.findPreference("autostart_apps");
        assertNotNull(boot);
        PreferenceGroup group = boot.getParent();
        java.util.List<String> keys = new java.util.ArrayList<>();
        for (int i = 0; i < group.getPreferenceCount(); i++) {
            keys.add(group.getPreference(i).getKey());
        }
        int at = keys.indexOf("autostart_apps");
        assertEquals("wake_autostart_apps", keys.get(at + 1));
        assertEquals("autostart_apps_by_boot_completed", keys.get(at + 2));
    }

    private static boolean isDivider(Preference p) {
        int layout = p.getLayoutResource();
        return layout == R.layout.preference_separator
                || layout == R.layout.preference_separator_within;
    }
}
