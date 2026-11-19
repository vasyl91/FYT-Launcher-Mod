package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;

import androidx.annotation.NonNull;

import com.android.launcher66.BarCapacity;
import com.android.launcher66.BarIconCount;
import com.android.launcher66.BarLayout;

/**
 * The most app icons each bar can show with the settings as they are now, worked out the way the launcher
 * works them out (BarCapacity), for the sliders of the number of icons. Asked again whenever an option that
 * changes it changes, so the slider's end follows at once (BarIconCount: a chosen number above it is lowered).
 */
public final class BarIconLimits {

    private BarIconLimits() {
    }

    /** The horizontal bar: its recycler's width at its icon size (BarCapacity.bottomCapacity). */
    public static int horizontalMax(@NonNull Context context, @NonNull SharedPreferences prefs) {
        int orientation = HorizontalBarDimensions.isPortrait(context)
                ? Configuration.ORIENTATION_PORTRAIT : Configuration.ORIENTATION_LANDSCAPE;
        return BarCapacity.bottomCapacity(prefs, orientation, true, prefs.getBoolean(Keys.WIDGET_BAR, false));
    }

    /**
     * The vertical bar of the first page: its band in the page's box beside the horizontal bar, at the width the
     * settings give it (BarCapacity.leftCapacityFor). The launcher counts with the height it measures.
     */
    public static int verticalMax(@NonNull Context context, @NonNull SharedPreferences prefs) {
        boolean portrait = HorizontalBarDimensions.isPortrait(context);
        Point screen = HorizontalBarDimensions.resolveScreenSize(context);
        int statusBarHeight = HorizontalBarDimensions.getStatusBarHeight(context.getResources());
        int rootWidth = HorizontalBarDimensions.getBarRootWidth(screen.x);
        int rootHeight = HorizontalBarDimensions.getBarRootHeight(screen.y, statusBarHeight);
        // The same height Launcher.getHorizontalBarHeight() gives the bar
        int barHeight = HorizontalBarDimensions.computeBarHeight(prefs, portrait, screen.x, screen.y,
                portrait ? 0 : statusBarHeight);
        boolean resizable = prefs.getBoolean(Keys.USER_LAYOUT, false)
                && prefs.getBoolean(Keys.RESIZABLE_VERTICAL_BAR, false);
        int width = VerticalBarDimensions.width(portrait, portrait ? screen.y : screen.x, resizable,
                VerticalBarWidthSeekBarPreference.readShare(prefs, portrait));
        BarLayout layout = BarLayouts.of(prefs, rootWidth, rootHeight, barHeight, width, true, true);
        return BarCapacity.leftCapacityFor(layout);
    }

    public static int max(@NonNull Context context, @NonNull SharedPreferences prefs, boolean horizontal) {
        return horizontal ? horizontalMax(context, prefs) : verticalMax(context, prefs);
    }

    /**
     * The number stored for the bar in this orientation, lowered (and stored lowered) where it is above the
     * most there is room for now (BarIconCount.kept).
     *
     * @return the number the slider shows: the chosen one, or the most when nothing is chosen
     */
    public static int shownAfterLowering(@NonNull Context context, @NonNull SharedPreferences prefs,
                                         boolean horizontal, int max) {
        String key = BarIconCount.key(horizontal, HorizontalBarDimensions.isPortrait(context));
        int chosen;
        try {
            chosen = prefs.getInt(key, BarIconCount.UNSET);
        } catch (ClassCastException e) {
            chosen = BarIconCount.UNSET;
        }
        int kept = BarIconCount.kept(chosen, max);
        if (kept != chosen) {
            prefs.edit().putInt(key, kept).apply();
        }
        return BarIconCount.shown(kept, max);
    }
}
