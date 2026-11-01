package com.android.launcher66.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.R;

import java.util.Locale;

/**
 * The font and the width of the statistics window (consumption and range) in its three sizes: large, medium (short labels)
 * and small (no labels, no units). The font is one for the three windows and comes from the small one, which has the least
 * room (never larger than the launcher's standard text size). The large and the medium window are as wide as their longer
 * line needs: the label, two spaces (one is room for a comma or a fourth digit), three digits and the longest unit of the
 * line (the units are {@link #UNIT_SCALE} of the size of the rest). The small window is 5 % narrower than a quarter of the
 * screen. The font and the two widths are worked out once, saved in the preferences, and worked out again only when the
 * language, the screen or the system font scale change; the editors and the window use the same values. The arithmetic is
 * plain, for JVM tests; only the measuring of the text needs a Context.
 */
public final class StatsWindowSize {

    private static final String TAG = "StatsWindowSize";

    private StatsWindowSize() {
        throw new AssertionError("No instances.");
    }

    /** The widest text of the small window must take no more than this share of the window. */
    static final double ROW_FILL = 0.95;
    /** The small window is this share of a quarter of the screen. */
    static final double SMALL_FACTOR = 0.95;
    /** The rule of the saved widths changes: raise it to have them worked out again. */
    static final String TAG_VERSION = "v1";
    /** The unit of a value in the large and the medium window is this share of the size of the rest of the text. */
    static final float UNIT_SCALE = 0.75f;

    /**
     * Where the unit of a formatted value starts: the index of the first character after the number, or -1 when the number
     * is not in the text. All that follows is the unit (the separator, the unit and the trailing space); a tilde before the
     * number is not. An index equal to the length means no unit.
     */
    static int unitStart(String formatted, String number) {
        if (formatted == null || number == null || number.isEmpty()) {
            return -1;
        }
        int at = formatted.indexOf(number);
        return at < 0 ? -1 : at + number.length();
    }


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

    /** The small window: 5 % narrower than a quarter of the screen. */
    static int smallWidth(int fullWidth) {
        return (int) Math.round(baseWidth(2, fullWidth) * SMALL_FACTOR);
    }

    /**
     * How much the text of a font has to shrink to fit a window: the width of its widest line (px, at the font measured) must
     * take no more than {@code fill} of the window less the background, and two lines of it no more than 90 % of the
     * height. 1 where it fits; a divisor of 0 or less leaves that condition out.
     */
    static float fitScale(float widestPx, double fill, int width, int padding, float lineHeightPx, int height) {
        float scale = 1f;
        // Some room to spare: two rows exactly as tall as the window lost a pixel to rounding, and the column then wrapped
        // the second row out of the window (the narrowest window, where the height decides).
        if (lineHeightPx > 0f) scale = Math.min(scale, (float) (0.9 * height / 2 / lineHeightPx));
        if (widestPx > 0f) scale = Math.min(scale, (float) (fill * (width - padding) / widestPx));
        return scale;
    }

    /**
     * The scale of the standard font that fits the small window: its widest line ("~88.8 " or "8888 ", px at the standard
     * font) in {@link #ROW_FILL} of the window less the background, two lines in 90 % of the height; never above 1.
     */
    static float fontScale(float widestSmallPx, float lineHeightPx, int smallWidth, int padding, int statsHeight) {
        return fitScale(widestSmallPx, ROW_FILL, smallWidth, padding, lineHeightPx, statsHeight);
    }

    /**
     * The width of a line of the large or the medium window (px): the label, a space between it and the value, the room for
     * a comma or a fourth digit (a space, or the width of that character where it is wider: a range of up to 2000 km has
     * four digits, wider than two spaces and three digits), the tilde, three digits, and the unit at {@link #UNIT_SCALE}.
     */
    static float lineWidth(float labelPx, float spacePx, float reservePx, float tildePx, float digitsPx, float unitPx) {
        return labelPx + spacePx + Math.max(spacePx, reservePx) + tildePx + digitsPx + UNIT_SCALE * unitPx;
    }

    /** The width of a window from its longer line, with the background. */
    static int textWidth(float consumptionLine, float rangeLine, int padding) {
        return (int) Math.ceil(Math.max(consumptionLine, rangeLine)) + padding;
    }

    /** A width within the screen less the margins on both sides. */
    static int clampToScreen(int width, int screenWidth, int margin) {
        return Math.min(width, Math.max(0, screenWidth - 2 * margin));
    }

    /** What the saved values depend on: they are worked out again when it changes. */
    static String geometryTag(String languageTag, int orientationDimension, int statsHeight, int densityDpi, float fontScale) {
        return TAG_VERSION + "|" + languageTag + "|" + orientationDimension + "|" + statsHeight + "|" + densityDpi + "|" + fontScale;
    }

    /** Whether the saved values are missing or were worked out for another geometry. */
    static boolean needsRecompute(boolean hasFont, boolean hasLarge, boolean hasMedium, String savedTag, String tag) {
        return !hasFont || !hasLarge || !hasMedium || savedTag == null || !savedTag.equals(tag);
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

    /** The text size (sp) of the window: the launcher's, else (the settings run alone) calculated the same way. */
    static int textSizeSp() {
        return Launcher.textSizeBasic > 0 ? Launcher.textSizeBasic : textSizeSp(SettingsActivity.orientationDimension);
    }

    private static int fullWidth() {
        return SettingsActivity.calculatedStatsWidth > 0 ? SettingsActivity.calculatedStatsWidth : Launcher.calculatedStatsWidth;
    }

    private static int statsHeight() {
        return SettingsActivity.calculatedStatsHeight > 0 ? SettingsActivity.calculatedStatsHeight : Launcher.calculatedStatsHeight;
    }

    private static int orientationDimension() {
        return Launcher.orientationDimension > 0 ? Launcher.orientationDimension : SettingsActivity.orientationDimension;
    }

    // ---------------------------------------------------------------------------------------------
    // The measuring (needs a Context)
    // ---------------------------------------------------------------------------------------------

    /** The paint of the values of the window at a text size (px): the typeface of its layout. */
    private static TextPaint measuringPaint(Context context, float px) {
        TextView value = (TextView) LayoutInflater.from(context).inflate(R.layout.absolute_stats, null)
                .findViewById(R.id.instantaneous_consumption_val);
        TextPaint paint = new TextPaint();
        paint.set(value.getPaint());
        paint.setTextSize(px);
        return paint;
    }

    /** The horizontal padding of the background of the window. */
    private static int backgroundPadding(Context context) {
        Drawable background = ContextCompat.getDrawable(context, R.drawable.bg_custom);
        Rect padding = new Rect();
        return background != null && background.getPadding(padding) ? padding.left + padding.right : 0;
    }

    /** The unit of a value: all that follows the number in its text (with the separator and the trailing space). */
    private static String unitOf(Resources res, int resId) {
        String text = res.getString(resId, "888");
        int start = unitStart(text, "888");
        return start < 0 ? "" : text.substring(start);
    }

    /** The widest line of the small window at a text size (px): the estimate with its tilde, or the range of four digits. */
    private static float smallTextWidth(Context context, TextPaint paint) {
        Resources res = context.getResources();
        return Math.max(paint.measureText(res.getString(R.string.instantaneous_consumption_estimated_mini, "88.8")),
                paint.measureText(res.getString(R.string.driving_mileage_val_mini, "8888")));
    }

    /**
     * The widths (px) of the two lines of the large (0) or the medium (1) window at a text size (px): {consumption, range},
     * each with its label, the room for the value and its longest unit. The window and the saved widths measure the same way.
     */
    static float[] lineWidths(Context context, int selector, float fontPx) {
        Resources res = context.getResources();
        TextPaint paint = measuringPaint(context, fontPx);
        float space = paint.measureText("\u0020");
        float digits = paint.measureText("888");
        float consumptionUnit = Math.max(
                paint.measureText(unitOf(res, R.string.instantaneous_consumption_val)),
                paint.measureText(unitOf(res, R.string.instantaneous_consumption_per_hour)));
        float rangeUnit = paint.measureText(unitOf(res, R.string.driving_mileage_val));
        float consumption = lineWidth(paint.measureText(label(res, selector, true)), space, paint.measureText("."),
                paint.measureText("~"), digits, consumptionUnit);
        float range = lineWidth(paint.measureText(label(res, selector, false)), space, paint.measureText("8"), 0f, digits,
                rangeUnit);
        return new float[]{consumption, range};
    }

    /**
     * The scale that makes the text of a window at the text size {@code fontPx} fit it, 1 if it fits: the safety of the
     * window, for a width cut to the screen or a margin changed since the widths were saved. The same rules as the saved
     * widths come from (the small window keeps its margin from the background).
     */
    static float fitScaleOfWindow(Context context, int selector, float fontPx, int width, int height) {
        TextPaint paint = measuringPaint(context, fontPx);
        Paint.FontMetrics fm = paint.getFontMetrics();
        float lineHeight = fm.bottom - fm.top;
        int padding = backgroundPadding(context);
        if (selector == 2) {
            return fitScale(smallTextWidth(context, paint), ROW_FILL, width, padding, lineHeight, height);
        }
        float[] lines = lineWidths(context, selector, fontPx);
        return fitScale(Math.max(lines[0], lines[1]), 1.0, width, padding, lineHeight, height);
    }

    // ---------------------------------------------------------------------------------------------
    // The saved values
    // ---------------------------------------------------------------------------------------------

    private static String currentTag(Context context) {
        Configuration c = context.getResources().getConfiguration();
        return geometryTag(Locale.getDefault().toLanguageTag(), orientationDimension(), statsHeight(), c.densityDpi,
                c.fontScale);
    }

    /**
     * Works out the font and the widths of the large and the medium window and saves them, unless they are saved for this
     * language and screen. Quick when they are (a few reads of the preferences). Main thread; the measuring has no I/O and
     * the save is an apply().
     */
    public static void ensureSaved(Context context, SharedPreferences prefs) {
        if (context == null || prefs == null) {
            return;
        }
        Context app = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        String tag = currentTag(app);
        if (!needsRecompute(prefs.contains(Keys.STATS_FONT_PX), prefs.contains(Keys.STATS_WIDTH_LARGE_PX),
                prefs.contains(Keys.STATS_WIDTH_MEDIUM_PX), prefs.getString(Keys.STATS_GEOMETRY_TAG, null), tag)) {
            return;
        }
        int full = fullWidth();
        int height = statsHeight();
        if (textSizeSp() <= 0 || full <= 0 || height <= 0) {
            return; // the dimensions are not calculated yet: nothing to save
        }
        int padding = backgroundPadding(app);
        float basePx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, textSizeSp(), app.getResources().getDisplayMetrics());
        TextPaint paint = measuringPaint(app, basePx);
        Paint.FontMetrics fm = paint.getFontMetrics();
        float fontPx = basePx * fontScale(smallTextWidth(app, paint), fm.bottom - fm.top, smallWidth(full), padding, height);
        float[] large = lineWidths(app, 0, fontPx);
        float[] medium = lineWidths(app, 1, fontPx);
        int largeWidth = textWidth(large[0], large[1], padding);
        int mediumWidth = textWidth(medium[0], medium[1], padding);
        prefs.edit()
                .putFloat(Keys.STATS_FONT_PX, fontPx)
                .putInt(Keys.STATS_WIDTH_LARGE_PX, largeWidth)
                .putInt(Keys.STATS_WIDTH_MEDIUM_PX, mediumWidth)
                .putString(Keys.STATS_GEOMETRY_TAG, tag)
                .apply();
        Log.i(TAG, "font " + fontPx + " px (standard " + basePx + "), large " + largeWidth + ", medium " + mediumWidth
                + ", small " + smallWidth(full) + " px, padding " + padding + ", " + tag);
    }

    private static SharedPreferences defaultPrefs(Context context) {
        Context app = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    /** The text size (px) of the three windows; 0 where it cannot be worked out yet. */
    public static float fontPx(Context context, SharedPreferences prefs) {
        ensureSaved(context, prefs);
        return prefs.getFloat(Keys.STATS_FONT_PX, 0f);
    }

    /** The saved width of the large (0) or the medium (1) window; its share of the screen where it is not saved. */
    static int savedWidth(Context context, SharedPreferences prefs, int selector) {
        ensureSaved(context, prefs);
        int saved = prefs.getInt(selector == 1 ? Keys.STATS_WIDTH_MEDIUM_PX : Keys.STATS_WIDTH_LARGE_PX, 0);
        return saved > 0 ? saved : baseWidth(selector, fullWidth());
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

    /**
     * The width of the window of a size on this screen: the saved width of the large (0) and the medium (1) window, a
     * quarter of the screen less 5 % for the small one (2), within the margins of the screen.
     */
    static int widthFor(Context context, int selector, int fullWidth, int screenWidth, int margin) {
        int width = selector == 2 ? smallWidth(fullWidth) : savedWidth(context, defaultPrefs(context), selector);
        return clampToScreen(width, screenWidth, margin);
    }
}
