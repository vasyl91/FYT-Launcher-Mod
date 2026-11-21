package com.android.launcher66;

import android.content.SharedPreferences;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.android.launcher66.settings.Keys;

import java.util.List;

/**
 * Puts the horizontal bar's elements in the order chosen in the settings (BarOrder holds the rules), the same way
 * for the page's own bar (Workspace.createUserPage(), after WidgetBarLayout) and for the bar's window
 * (Workspace.forceOriginalSizes(), after its sizes): one source of the elements' left and right anchors, so both
 * bars lie alike. Only the horizontal anchors are touched; sizes, heights and the vertical place stay with the code
 * that set them. Main thread only.
 */
public final class BarOrderLayout {

    private BarOrderLayout() {
    }

    /** The stored order of one orientation (the whole order, hidden elements included). */
    public static List<BarOrder.Element> order(SharedPreferences prefs, boolean portrait) {
        return BarOrder.parse(prefs.getString(key(portrait), null));
    }

    public static String key(boolean portrait) {
        return portrait ? Keys.HORIZONTAL_BAR_ORDER_PORT : Keys.HORIZONTAL_BAR_ORDER_LAND;
    }

    /** The elements the bar shows with these settings, in their order. */
    public static List<BarOrder.Element> shown(SharedPreferences prefs, boolean portrait) {
        return BarOrder.shown(order(prefs, portrait), prefs.getBoolean(Keys.WIDGET_BAR, false), portrait,
                WidgetBarLayout.dateHidden(prefs, portrait), WidgetBarLayout.weatherHidden(prefs),
                WidgetBarLayout.appsHidden(prefs));
    }

    /** The view of an element (no resource id in a switch: they are no constants with this build). */
    static int viewId(BarOrder.Element element) {
        if (element == BarOrder.Element.DRAWER) return R.id.rl_allapps;
        if (element == BarOrder.Element.APPS) return R.id.recycler_view;
        if (element == BarOrder.Element.MUSIC) return R.id.rl_music_two;
        if (element == BarOrder.Element.DATE) return R.id.bar_widget_date;
        return R.id.bar_widget_weather;
    }

    /** Ties the bar's elements in their order. {@code bar} holds them (a page's bar layout or the window's). */
    public static void apply(View bar, SharedPreferences prefs, boolean portrait) {
        List<BarOrder.Element> shown = shown(prefs, portrait);
        // An element the layout does not have (the portrait date) is not shown, whatever the settings say
        shown.removeIf(e -> bar.findViewById(viewId(e)) == null);
        apply(bar, shown);
    }

    /** Ties the given elements, in this order, and unties the others. */
    static void apply(View bar, List<BarOrder.Element> shown) {
        int parent = ConstraintLayout.LayoutParams.PARENT_ID;
        for (BarOrder.Element element : BarOrder.Element.values()) {
            View view = bar.findViewById(viewId(element));
            if (view != null && view.getLayoutParams() instanceof ConstraintLayout.LayoutParams lp) {
                untie(lp);
                if (!shown.contains(element)) {
                    lp.startToStart = parent;   // hidden (GONE): tied to nothing that is shown
                }
                view.setLayoutParams(lp);
            }
        }
        for (BarOrder.Anchor anchor : BarOrder.anchors(shown)) {
            View view = bar.findViewById(viewId(anchor.element));
            if (view == null || !(view.getLayoutParams() instanceof ConstraintLayout.LayoutParams lp)) {
                continue;
            }
            if (anchor.start == null) {
                lp.startToStart = parent;
            } else {
                lp.startToEnd = viewId(anchor.start);
            }
            if (anchor.endTied) {
                if (anchor.end == null) {
                    lp.endToEnd = parent;
                } else {
                    lp.endToStart = viewId(anchor.end);
                }
            }
            view.setLayoutParams(lp);
        }
    }

    private static void untie(ConstraintLayout.LayoutParams lp) {
        int unset = ConstraintLayout.LayoutParams.UNSET;
        lp.leftToLeft = unset;
        lp.leftToRight = unset;
        lp.rightToLeft = unset;
        lp.rightToRight = unset;
        lp.startToStart = unset;
        lp.startToEnd = unset;
        lp.endToStart = unset;
        lp.endToEnd = unset;
    }
}
