package com.android.launcher66.settings;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;

/**
 * The width of the statistics window (consumption and range) in its three sizes: large, medium (short labels) and small
 * (no labels). A size is a share of the screen, and grows by up to 35 % when its widest text does not fit in the
 * standard font, so that the font is the same in the three sizes and does not change with the unit or the value (L/100 km
 * and L/h are different texts). The editors and the window use the same widths. The arithmetic is plain, for JVM tests.
 */
public final class StatsWindowSize {

    private StatsWindowSize() {
        throw new AssertionError("No instances.");
    }

    /** The widest text must take no more than this share of the window. */
    static final double ROW_FILL = 0.95;
    /** A window grows by at most this much of its share of the screen. */
    static final double MAX_GROWTH = 1.35;
    /** The numbers that make the widest text of each kind of value. */
    static final String WIDEST_PER_100_KM = "188.8";
    static final String WIDEST_PER_HOUR = "88.8";
    static final String WIDEST_RANGE = "8888";

    // ---------------------------------------------------------------------------------------------
    // The arithmetic
    // ---------------------------------------------------------------------------------------------

    /** The share of the screen of a size: the full width (0), two thirds (1) or a quarter (2). */
    static int baseWidth(int selector, int fullWidth) {
        switch (selector) {
            case 1:
                return (fullWidth / 3) * 2;
            case 2:
                return fullWidth / 4;
            default:
                return fullWidth;
        }
    }

    /**
     * The window: the share of the screen, longer where the text needs it, by up to 35 %, and never wider than the screen
     * less the margins.
     *
     * @param baseWidth   the share of the screen of the size
     * @param requiredPx  the width the widest text needs
     * @param screenWidth the width of the screen
     * @param margin      the margin on each side
     */
    static int windowWidth(int baseWidth, int requiredPx, int screenWidth, int margin) {
        int limit = Math.min(Math.max(0, screenWidth - 2 * margin), (int) Math.round(MAX_GROWTH * baseWidth));
        return Math.min(limit, Math.max(baseWidth, requiredPx));
    }

    /**
     * The saved rectangle of a window (its left and right edge) made as wide as the window is, keeping its left edge where
     * it can and the whole of it on the screen, within the margins: {left, right}.
     */
    static int[] fitRectangle(int left, int width, int screenWidth, int margin) {
        int right = left + width;
        int most = screenWidth - margin;
        if (right > most) {
            right = most;
            left = right - width;
        }
        if (left < margin) {
            left = margin;
            right = left + width;
        }
        return new int[]{left, right};
    }

    /** The text size (sp) of the statistics, as the launcher calculates it for the screen dimension that decides. */
    static int textSizeSp(int orientationDimension) {
        return orientationDimension <= 0 ? 0 : (int) (18 * Math.pow(orientationDimension / 2000.0, 0.5));
    }

    // ---------------------------------------------------------------------------------------------
    // The texts
    // ---------------------------------------------------------------------------------------------

    /** The label of the consumption row or the range row of a size; none in the smallest. */
    static String label(Resources res, int selector, boolean consumption) {
        if (selector == 2) {
            return "";
        }
        if (consumption) {
            return res.getString(selector == 1 ? R.string.instantaneous_consumption_mini : R.string.instantaneous_consumption);
        }
        return res.getString(selector == 1 ? R.string.driving_mileage_mini : R.string.driving_mileage);
    }

    /** Every text of the consumption value of a size, with its widest number: L/100 km, the estimate, litres per hour. */
    static String[] consumptionVariants(Resources res, int selector) {
        boolean mini = selector == 2;
        return new String[]{
                res.getString(mini ? R.string.instantaneous_consumption_val_mini : R.string.instantaneous_consumption_val,
                        WIDEST_PER_100_KM),
                res.getString(mini ? R.string.instantaneous_consumption_estimated_mini : R.string.instantaneous_consumption_estimated,
                        WIDEST_PER_100_KM),
                res.getString(mini ? R.string.instantaneous_consumption_idle_mini : R.string.instantaneous_consumption_idle,
                        WIDEST_PER_HOUR),
                res.getString(mini ? R.string.instantaneous_consumption_per_hour_mini : R.string.instantaneous_consumption_per_hour,
                        WIDEST_PER_HOUR)};
    }

    /** The text of the range value of a size, with its widest number. */
    static String[] rangeVariants(Resources res, int selector) {
        return new String[]{res.getString(selector == 2 ? R.string.driving_mileage_val_mini : R.string.driving_mileage_val,
                WIDEST_RANGE)};
    }

    /** All the texts of the values of a size: the consumption ones, then the range one. */
    static String[] valueVariants(Resources res, int selector) {
        String[] consumption = consumptionVariants(res, selector);
        String[] range = rangeVariants(res, selector);
        String[] all = new String[consumption.length + range.length];
        System.arraycopy(consumption, 0, all, 0, consumption.length);
        System.arraycopy(range, 0, all, consumption.length, range.length);
        return all;
    }

    /** The width of a row: its label and the widest of the texts of its value. */
    static float rowWidth(TextPaint paint, String label, String[] variants) {
        float widest = 0f;
        for (String v : variants) {
            widest = Math.max(widest, paint.measureText(v));
        }
        return paint.measureText(label) + widest;
    }

    // ---------------------------------------------------------------------------------------------
    // The width in a window
    // ---------------------------------------------------------------------------------------------

    /** The text size (sp) of the window: the launcher's, else (the settings run alone) calculated the same way. */
    static int textSizeSp() {
        return Launcher.textSizeBasic > 0 ? Launcher.textSizeBasic : textSizeSp(SettingsActivity.orientationDimension);
    }

    /** The paint of the values of the window at the standard text size: the typeface of its layout. */
    private static TextPaint measuringPaint(Context context) {
        Resources res = context.getResources();
        TextView value = (TextView) LayoutInflater.from(context).inflate(R.layout.absolute_stats, null)
                .findViewById(R.id.instantaneous_consumption_val);
        TextPaint paint = new TextPaint();
        paint.set(value.getPaint());
        paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSizeSp(), res.getDisplayMetrics()));
        return paint;
    }

    /** The horizontal padding of the background of the window. */
    private static int backgroundPadding(Context context) {
        Drawable background = ContextCompat.getDrawable(context, R.drawable.bg_custom);
        Rect padding = new Rect();
        return background != null && background.getPadding(padding) ? padding.left + padding.right : 0;
    }

    /** The width the widest row of a size needs at the standard text size, to fill 95 % of the window, with the background. */
    static int requiredWidthPx(Context context, int selector) {
        if (textSizeSp() <= 0) {
            return 0;
        }
        Resources res = context.getResources();
        TextPaint paint = measuringPaint(context);
        float row = Math.max(
                rowWidth(paint, label(res, selector, true), consumptionVariants(res, selector)),
                rowWidth(paint, label(res, selector, false), rangeVariants(res, selector)));
        return (int) Math.ceil(row / ROW_FILL) + backgroundPadding(context);
    }

    /**
     * Makes the rectangle saved for the statistics window as wide as the window: the editors draw it and the home screen
     * reserves its place from these corners, and the window takes its width from its size, so that all three agree (the
     * saved rectangles of before are mended on first use). {@code app} is the window over an app. Does nothing without a saved
     * rectangle.
     */
    public static void syncSavedRectangle(Context context, android.content.SharedPreferences prefs, boolean app) {
        String key = app ? "appStats" : "stats";
        if (!prefs.contains(key + "TopLeftX") || !prefs.contains(key + "TopRightX")) {
            return;
        }
        int selector = prefs.getInt(app ? Keys.APP_STATS_WIDTH_SELECTOR : Keys.STATS_WIDTH_SELECTOR, 0);
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int margin;
        try {
            margin = Integer.parseInt(prefs.getString(Keys.LAYOUT_MARGIN, "5"));
        } catch (NumberFormatException e) {
            margin = 5;
        }
        int width = widthFor(context, selector, SettingsActivity.calculatedStatsWidth > 0
                ? SettingsActivity.calculatedStatsWidth : Launcher.calculatedStatsWidth, screenWidth, margin);
        int left = prefs.getInt(key + "TopLeftX", margin);
        int right = prefs.getInt(key + "TopRightX", left + width);
        if (width <= 0 || right - left == width) {
            return;
        }
        int[] fitted = fitRectangle(left, width, screenWidth, margin);
        prefs.edit()
                .putInt(key + "TopLeftX", fitted[0]).putInt(key + "BottomLeftX", fitted[0])
                .putInt(key + "TopRightX", fitted[1]).putInt(key + "BottomRightX", fitted[1])
                .putInt(app ? Keys.APP_STATS_WIDTH : Keys.STATS_WIDTH, width)
                .apply();
    }

    /** The width of the window of a size on this screen. */
    static int widthFor(Context context, int selector, int fullWidth, int screenWidth, int margin) {
        return windowWidth(baseWidth(selector, fullWidth), requiredWidthPx(context, selector), screenWidth, margin);
    }
}
