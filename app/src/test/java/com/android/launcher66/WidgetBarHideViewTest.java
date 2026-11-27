package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
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
 * The widget bar with the app drawer button or the music widget hidden (E2, E3 of round 28, built in round 29): the
 * hidden one takes no room, every other element is as wide as the one rule says (BarShares), they lie in their order
 * without overlapping, inside the bar, the same on the page and in the window (both are made by WidgetBarLayout.apply).
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class WidgetBarHideViewTest {

    @After
    public void screen() {
        Launcher.screenWidth = 0;
    }

    private static SharedPreferences prefs(boolean portrait, boolean noDrawer, boolean noMusic) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.getApplication());
        prefs.edit().clear().putBoolean(Keys.USER_LAYOUT, true).putBoolean(Keys.WIDGET_BAR, true)
                .putBoolean(Keys.HORIZONTAL_BAR_NO_DRAWER, noDrawer).putBoolean(Keys.WIDGET_BAR_NO_MUSIC, noMusic)
                .remove(BarOrderLayout.key(portrait)).commit();
        return prefs;
    }

    private static View bar(SharedPreferences prefs, boolean portrait, int width, int height) {
        Context context = RuntimeEnvironment.getApplication();
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
        return view.getVisibility() == View.GONE ? 0 : view.getRight() - view.getLeft();
    }

    private static void check(boolean portrait, boolean noDrawer, boolean noMusic) {
        int width = portrait ? 1080 : 2000;
        int height = portrait ? 2340 : 1200;
        Launcher.screenWidth = width;
        SharedPreferences prefs = prefs(portrait, noDrawer, noMusic);
        BarShares.Result r = WidgetBarLayout.barShares(prefs, portrait);
        View bar = bar(prefs, portrait, width, height);
        String what = (portrait ? "portrait" : "landscape") + (noDrawer ? ", no drawer" : "") + (noMusic ? ", no music" : "");

        if (noDrawer) {
            assertEquals(what + ": the drawer button takes no room", 0, width(bar, R.id.rl_allapps));
            assertFalse(bar.findViewById(R.id.rl_allapps).isClickable());
        } else {
            assertEquals(what, (int) (width * r.share(BarShares.Element.DRAWER)), width(bar, R.id.rl_allapps), 2);
        }
        if (noMusic) {
            assertEquals(what + ": no music widget", View.GONE, bar.findViewById(R.id.rl_music_two).getVisibility());
        } else {
            assertEquals(what, (int) (width * r.share(BarShares.Element.MUSIC)), width(bar, R.id.rl_music_two), 2);
        }
        assertEquals(what, (int) (width * r.share(BarShares.Element.APPS)), width(bar, R.id.recycler_view), 2);
        assertEquals(what, (int) (width * r.share(BarShares.Element.WEATHER)), width(bar, R.id.bar_widget_weather), 2);
        if (!portrait) {
            assertEquals(what, (int) (width * r.share(BarShares.Element.DATE)), width(bar, R.id.bar_widget_date), 2);
        }
        assertEquals(what + ": the shares make the whole bar's usual total", 1f, r.total() / usualTotal(portrait), 0.001f);

        // In the order, without overlapping, inside the bar
        List<BarOrder.Element> shown = BarOrderLayout.shown(prefs, portrait);
        shown.removeIf(e -> bar.findViewById(BarOrderLayout.viewId(e)) == null
                || bar.findViewById(BarOrderLayout.viewId(e)).getVisibility() == View.GONE);
        int end = 0;
        for (BarOrder.Element e : shown) {
            View view = bar.findViewById(BarOrderLayout.viewId(e));
            assertTrue(what + ": " + e + " right of the one before: " + view.getLeft() + " >= " + end,
                    view.getLeft() >= end - 1);
            end = Math.max(end, view.getRight());
        }
        assertTrue(what + ": inside the bar: " + end, end <= width + 1);
    }

    private static float usualTotal(boolean portrait) {
        float sum = 0f;
        for (BarShares.Element e : BarShares.Element.values()) {
            sum += BarShares.usual(e, portrait);
        }
        return sum;
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void inLandscapeTheHiddenElementsRoomIsShared() {
        check(false, true, false);
        check(false, false, true);
        check(false, true, true);
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void inPortraitTheHiddenElementsRoomIsShared() {
        check(true, true, false);
        check(true, false, true);
        check(true, true, true);
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void withNeitherHiddenTheBarIsAsBefore() {
        SharedPreferences prefs = prefs(false, false, false);
        assertEquals(1f, WidgetBarLayout.appsWidthFactor(prefs, false), 0f);
        assertFalse(WidgetBarLayout.drawerHidden(prefs));
        assertFalse(WidgetBarLayout.musicHidden(prefs));
    }

    @Test
    public void aBarWithEverythingHiddenIsEmpty() {
        assertTrue(BarShares.empty(false, true, true, true, true, true));
        assertFalse("the drawer button alone is a bar", BarShares.empty(false, false, true, true, true, true));
        assertFalse(BarShares.empty(true, true, false, true, true, true));
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void withTheMusicHiddenTheListHasRoomForMoreIcons() {
        Launcher.screenWidth = 2000;
        SharedPreferences prefs = prefs(false, false, true);
        assertTrue(WidgetBarLayout.appsWidthFactor(prefs, false) > 1f);
    }
}
