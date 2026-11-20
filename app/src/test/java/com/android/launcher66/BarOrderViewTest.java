package com.android.launcher66;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.preference.PreferenceManager;

import com.android.launcher66.settings.Keys;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The horizontal bar's elements lie from left to right in the order chosen in the settings (BarOrder), without
 * overlapping and inside the bar, in portrait and in landscape, with the widget bar and without it. The page's bar
 * (sizes as shares of the layout) and the window's (sizes in pixels, as forceOriginalSizes() gives them) put each
 * element at the same place.
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = TestLauncherApplication.class)
public class BarOrderViewTest {

    private static View inflate(Context context, int layout, boolean portrait) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        FrameLayout parent = new FrameLayout(context);
        View bar = inflater.inflate(layout, parent, false);
        if (layout == R.layout.custom_layout_two_user) {
            WidgetBarLayout.apply(bar, inflater, prefs, portrait);
        }
        parent.addView(bar, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return bar;
    }

    private static void layOut(View bar, int width, int height) {
        View root = (View) bar.getParent();
        root.measure(View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY));
        root.layout(0, 0, width, height);
    }

    /** Each shown element's left and right, in the order given. */
    private static List<int[]> places(View bar, List<BarOrder.Element> order) {
        List<int[]> places = new ArrayList<>();
        for (BarOrder.Element e : order) {
            View view = bar.findViewById(BarOrderLayout.viewId(e));
            places.add(new int[] {view.getLeft(), view.getRight()});
        }
        return places;
    }

    private static void check(boolean portrait, boolean widgetBar, int width, int height) {
        Context context = RuntimeEnvironment.getApplication();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int layout = widgetBar ? R.layout.custom_layout_two_user : R.layout.custom_layout_one_user;
        List<BarOrder.Element> reversed = new ArrayList<>(BarOrder.DEFAULT);
        Collections.reverse(reversed);
        for (List<BarOrder.Element> order : List.of(BarOrder.DEFAULT, reversed)) {
            prefs.edit().putBoolean(Keys.WIDGET_BAR, widgetBar)
                    .putString(BarOrderLayout.key(portrait), BarOrder.format(order)).commit();
            View page = inflate(context, layout, portrait);
            BarOrderLayout.apply(page, prefs, portrait);
            layOut(page, width, height);
            List<BarOrder.Element> shown = BarOrderLayout.shown(prefs, portrait);
            shown.removeIf(e -> page.findViewById(BarOrderLayout.viewId(e)) == null);
            assertEquals("elements shown " + shown, widgetBar ? (portrait ? 4 : 5) : 2, shown.size());
            List<int[]> places = places(page, shown);
            for (int i = 0; i < places.size(); i++) {
                int[] p = places.get(i);
                assertTrue(shown.get(i) + " inside the bar: " + p[0] + ".." + p[1], p[0] >= 0 && p[1] <= width);
                assertTrue(shown.get(i) + " has a width", p[1] > p[0]);
                if (i > 0) {
                    assertTrue(shown.get(i) + " right of " + shown.get(i - 1) + ": " + p[0] + " < "
                            + places.get(i - 1)[1], p[0] >= places.get(i - 1)[1] - 1);
                }
            }
            assertTrue("the first at the left edge", places.get(0)[0] <= 1);

            // The window: the same elements with their sizes in pixels
            View window = inflate(context, layout, portrait);
            for (int i = 0; i < shown.size(); i++) {
                View view = window.findViewById(BarOrderLayout.viewId(shown.get(i)));
                ViewGroup.LayoutParams lp = view.getLayoutParams();
                lp.width = places.get(i)[1] - places.get(i)[0];
                view.setLayoutParams(lp);
            }
            BarOrderLayout.apply(window, prefs, portrait);
            layOut(window, width, height);
            List<int[]> inWindow = places(window, shown);
            for (int i = 0; i < shown.size(); i++) {
                assertTrue(shown.get(i) + " at the same place on the page and in the window: "
                                + places.get(i)[0] + " / " + inWindow.get(i)[0],
                        Math.abs(places.get(i)[0] - inWindow.get(i)[0]) <= 1);
            }
        }
    }

    @Test
    @Config(qualifiers = "w2000dp-h1200dp-land-mdpi")
    public void inLandscapeTheElementsLieInTheChosenOrder() {
        check(false, true, 2000, 1200);
        check(false, false, 2000, 1200);
    }

    @Test
    @Config(qualifiers = "w1080dp-h2340dp-port-mdpi")
    public void inPortraitTheElementsLieInTheChosenOrder() {
        check(true, true, 1080, 2116);
        check(true, false, 1080, 2116);
    }
}
