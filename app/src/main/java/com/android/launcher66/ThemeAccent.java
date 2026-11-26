package com.android.launcher66;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

/**
 * The one accent colour of the settings and of the views the launcher colours with it, chosen in "Set global theme
 * color" (a creator setting, the first of the "Home screen layout" rows).
 *
 * <p>The rules:
 * <ul>
 *   <li>The colour is stored as an int under {@link #KEY}; none stored is {@link #DEFAULT}, the blue of
 *       {@code R.color.colorAccent}.</li>
 *   <li>It is a setting of the layout creator, so "Stock layout" turns it off like every other one: the default
 *       colour applies whatever is stored ({@link #resolve}).</li>
 *   <li>A lighter tone of it ({@link #lighter}) is used for the track of a switch and for the background of a
 *       selection: the same hue and saturation, the lightness raised by a quarter and held to 1.</li>
 * </ul>
 * Code that needs the colour asks {@link #color(Context)} and never {@code R.color.colorAccent}, so that a colour
 * chosen by the user reaches it. The arithmetic is plain Java and tested; {@link #color} reads the preferences,
 * which are in memory (they are loaded when the app starts).
 */
public final class ThemeAccent {

    /** The preference key; the value is an int (ARGB). */
    public static final String KEY = "theme_accent_color";
    /** The accent that applies when none is chosen: {@code R.color.colorAccent} (#4285F4). */
    public static final int DEFAULT = 0xff4285f4;
    /** How much lighter {@link #lighter} is, in lightness (HSL). */
    static final float LIGHTER_BY = 0.25f;

    private ThemeAccent() {
    }

    /** The colour to use: the stored one, unless there is none or the stock layout is on. */
    static int resolve(boolean hasStored, int stored, boolean creatorOn, int defaultColor) {
        if (!hasStored || !creatorOn) {
            return defaultColor;
        }
        // The colour is always opaque: the picker may hand over a transparent one
        return 0xff000000 | stored;
    }

    /** The accent now. Main thread safe: the preferences are in memory. */
    public static int color(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return resolve(prefs.contains(KEY), prefs.getInt(KEY, DEFAULT),
                prefs.getBoolean(com.android.launcher66.settings.Keys.USER_LAYOUT, false), DEFAULT);
    }

    /** The colour with its lightness raised by a quarter (HSL), alpha as it was. */
    public static int lighter(int color) {
        float[] hsl = new float[3];
        toHsl(color, hsl);
        hsl[2] = Math.min(1f, hsl[2] + LIGHTER_BY);
        return fromHsl(hsl, (color >>> 24) & 0xff);
    }

    /** The colour with another alpha (0..255). */
    public static int withAlpha(int color, int alpha) {
        return (Math.max(0, Math.min(255, alpha)) << 24) | (color & 0x00ffffff);
    }

    /** Hue in degrees (0..360), saturation and lightness (0..1) of an ARGB colour. */
    static void toHsl(int color, float[] hsl) {
        float r = ((color >> 16) & 0xff) / 255f;
        float g = ((color >> 8) & 0xff) / 255f;
        float b = (color & 0xff) / 255f;
        float max = Math.max(r, Math.max(g, b));
        float min = Math.min(r, Math.min(g, b));
        float l = (max + min) / 2f;
        float h;
        float s;
        float d = max - min;
        if (d == 0f) {
            h = 0f;
            s = 0f;
        } else {
            s = l > 0.5f ? d / (2f - max - min) : d / (max + min);
            if (max == r) {
                h = ((g - b) / d + (g < b ? 6f : 0f));
            } else if (max == g) {
                h = (b - r) / d + 2f;
            } else {
                h = (r - g) / d + 4f;
            }
            h *= 60f;
        }
        hsl[0] = h;
        hsl[1] = s;
        hsl[2] = l;
    }

    static int fromHsl(float[] hsl, int alpha) {
        float h = hsl[0] / 360f;
        float s = hsl[1];
        float l = hsl[2];
        float r;
        float g;
        float b;
        if (s == 0f) {
            r = l;
            g = l;
            b = l;
        } else {
            float q = l < 0.5f ? l * (1f + s) : l + s - l * s;
            float p = 2f * l - q;
            r = channel(p, q, h + 1f / 3f);
            g = channel(p, q, h);
            b = channel(p, q, h - 1f / 3f);
        }
        return (alpha << 24) | (Math.round(r * 255f) << 16) | (Math.round(g * 255f) << 8) | Math.round(b * 255f);
    }

    private static float channel(float p, float q, float t) {
        if (t < 0f) {
            t += 1f;
        }
        if (t > 1f) {
            t -= 1f;
        }
        if (t < 1f / 6f) {
            return p + (q - p) * 6f * t;
        }
        if (t < 1f / 2f) {
            return q;
        }
        if (t < 2f / 3f) {
            return p + (q - p) * (2f / 3f - t) * 6f;
        }
        return p;
    }
}
