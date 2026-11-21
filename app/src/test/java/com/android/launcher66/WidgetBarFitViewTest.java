package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

/**
 * "Fit the apps to their icons" (the owner, 2026-11-21; WidgetBarPlan): the widget bar's apps list is as wide as the
 * tiles it shows at their width with the most icons, the music, the date and the weather are wider by their parts of
 * its room, nothing overlaps, and the window's widths (WidgetBarLayout.shares, as forceOriginalSizes uses them) are
 * the page's. In portrait the list keeps its height. "Hide the apps": no list, all its room shared the same way.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class WidgetBarFitViewTest {

    @After
    public void screen() {
        Launcher.screenWidth = 0;
    }

    private static SharedPreferences prefs(boolean portrait, boolean fit, int icons) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putBoolean(Keys.WIDGET_BAR_FIT_APPS, fit).putBoolean(Keys.WIDGET_BAR_NO_APPS, false)
                .putInt(portrait ? Keys.HORIZONTAL_BAR_ICONS_PORT : Keys.HORIZONTAL_BAR_ICONS_LAND, icons)
                .remove(BarOrderLayout.key(portrait)).commit();
        return prefs;
    }

    private static View bar(boolean portrait, int width, int height) {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        FrameLayout parent = new FrameLayout(context);
        View bar = inflater.inflate(R.layout.custom_layout_two_user, parent, false);
        WidgetBarLayout.apply(bar, inflater, prefs, portrait);
        BarOrderLayout.apply(bar, prefs, portrait);
        parent.addView(bar, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        parent.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        parent.layout(0, 0, width, height);
        return bar;
    }

    private static int width(View bar, int id) {
        View view = bar.findViewById(id);
        return view.getRight() - view.getLeft();
    }

    private static void check(boolean portrait, int width, int height, int icons) {
        Launcher.screenWidth = width;
        SharedPreferences prefs = prefs(portrait, true, icons);
        int room = WidgetBarLayout.appIcons(prefs, portrait)[1];
        assertTrue("fewer icons than room: " + icons + " < " + room, icons < room);
        WidgetBarPlan.Shares shares = WidgetBarLayout.shares(prefs, portrait);
        assertTrue(shares.appsChanged);
        View page = bar(portrait, width, height);

        // The list: as wide as its tiles, each as wide as with the most icons
        int usualList = BarCapacity.bottomRecyclerWidth(portrait, true);
        int tile = usualList / BarCapacity.bottomTiles(prefs, portrait ? Configuration.ORIENTATION_PORTRAIT
                : Configuration.ORIENTATION_LANDSCAPE, true, true, icons);
        assertEquals("a tile keeps its width at the maximum", usualList / room, tile);
        int list = width(page, R.id.recycler_view);
        assertTrue("the list holds its " + icons + " tiles: " + list + " >= " + icons * tile, list >= icons * tile);
        assertTrue("and no more than a pixel or two: " + list, list <= icons * tile + icons + 2);

        // The widgets: wider by their parts; the page as the window
        assertEquals((int) (width * shares.music), width(page, R.id.rl_music_two), 2);
        assertEquals((int) (width * shares.weather), width(page, R.id.bar_widget_weather), 2);
        assertTrue(width(page, R.id.rl_music_two) > (int) (width * WidgetBarPlan.baseShare(portrait)));
        if (!portrait) {
            assertEquals((int) (width * shares.date), width(page, R.id.bar_widget_date), 2);
            assertTrue(width(page, R.id.bar_widget_date) > (int) (width * 0.05f));
        }

        // In the order, without overlapping, inside the bar
        List<BarOrder.Element> shown = BarOrderLayout.shown(prefs, portrait);
        shown.removeIf(e -> page.findViewById(BarOrderLayout.viewId(e)) == null);
        int end = 0;
        for (BarOrder.Element e : shown) {
            View view = page.findViewById(BarOrderLayout.viewId(e));
            assertTrue(e + " right of the one before: " + view.getLeft() + " >= " + end, view.getLeft() >= end - 1);
            end = view.getRight();
        }
        assertTrue("inside the bar: " + end, end <= width + 1);
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void inLandscapeTheListIsAsWideAsItsIcons() {
        check(false, 2000, 1200, 1);
        check(false, 2000, 1200, 3);
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void inPortraitTheListIsAsWideAsItsIconsAndKeepsItsHeight() {
        check(true, 1080, 2116, 1);
        check(true, 1080, 2116, 3);

        Launcher.screenWidth = 1080;
        prefs(true, false, 2);
        int usualHeight = bar(true, 1080, 2116).findViewById(R.id.recycler_view).getHeight();
        prefs(true, true, 2);
        View fitted = bar(true, 1080, 2116);
        assertEquals("the height of its usual width", usualHeight,
                fitted.findViewById(R.id.recycler_view).getHeight(), 1);
        int usualWeather = (int) (1080 * 0.15f * 0.95f);
        assertEquals("the weather too", usualWeather, fitted.findViewById(R.id.bar_widget_weather).getHeight(), 2);
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void withAllTheIconsOrTheSwitchOffNothingChanges() {
        Launcher.screenWidth = 2000;
        SharedPreferences prefs = prefs(false, false, 2);
        assertEquals(0.4395f, WidgetBarLayout.shares(prefs, false).apps, 0.0001f);
        int room = WidgetBarLayout.appIcons(prefs, false)[1];
        prefs(false, true, room);
        assertEquals(0.4395f, WidgetBarLayout.shares(prefs, false).apps, 0.0001f);
        assertEquals(room, BarCapacity.bottomTiles(prefs, Configuration.ORIENTATION_LANDSCAPE, true, true, room));
        // Without the widget bar the switch does nothing
        prefs.edit().putBoolean(Keys.WIDGET_BAR, false).putInt(Keys.HORIZONTAL_BAR_ICONS_LAND, 2).commit();
        assertEquals(2, BarCapacity.bottomTiles(prefs, Configuration.ORIENTATION_LANDSCAPE, true, false, 2));
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void withTheListHiddenItsRoomGoesToTheWidgetsInLandscape() {
        hidden(false, 2000, 1200);
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void withTheListHiddenItsRoomGoesToTheWidgetsInPortrait() {
        hidden(true, 1080, 2116);
    }

    private static void hidden(boolean portrait, int width, int height) {
        Launcher.screenWidth = width;
        SharedPreferences prefs = prefs(portrait, false, 0);
        prefs.edit().putBoolean(Keys.WIDGET_BAR_NO_APPS, true).commit();
        WidgetBarPlan.Shares shares = WidgetBarLayout.shares(prefs, portrait);
        assertEquals(0f, shares.apps, 0.0001f);
        View page = bar(portrait, width, height);
        assertEquals(View.GONE, page.findViewById(R.id.recycler_view).getVisibility());
        assertEquals(View.GONE, WidgetBarLayout.appsListVisibility(prefs));
        assertEquals((int) (width * shares.music), width(page, R.id.rl_music_two), 2);
        assertEquals((int) (width * shares.weather), width(page, R.id.bar_widget_weather), 2);
        if (!portrait) {
            assertEquals((int) (width * shares.date), width(page, R.id.bar_widget_date), 2);
        }
        List<BarOrder.Element> shown = BarOrderLayout.shown(prefs, portrait);
        assertTrue("no list in the order", !shown.contains(BarOrder.Element.APPS));
        shown.removeIf(e -> page.findViewById(BarOrderLayout.viewId(e)) == null);
        int end = 0;
        for (BarOrder.Element e : shown) {
            View view = page.findViewById(BarOrderLayout.viewId(e));
            assertTrue(e + " right of the one before", view.getLeft() >= end - 1);
            end = view.getRight();
        }
        assertTrue("inside the bar: " + end, end <= width + 1);

        // The widget bar off: the list is shown whatever is stored
        prefs.edit().putBoolean(Keys.WIDGET_BAR, false).commit();
        assertEquals(View.VISIBLE, WidgetBarLayout.appsListVisibility(prefs));
        assertTrue(BarOrderLayout.shown(prefs, portrait).contains(BarOrder.Element.APPS));
        prefs.edit().putBoolean(Keys.WIDGET_BAR_NO_APPS, false).commit();
    }
}
