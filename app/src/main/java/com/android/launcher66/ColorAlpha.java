package com.android.launcher66;

/**
 * The transparency of a background colour as the colour picker shows it: in whole percent.
 *
 * <p>The rule: the alpha slider of the picker moves in steps of exactly 1 %, from 0 % (fully transparent) to
 * 100 % (opaque), and a colour that was stored comes back at the percent it was chosen with. A colour keeps
 * its alpha as 0 ... 255, so the two are converted here, rounding to the nearest, in both directions:
 * every percent gives an alpha that gives the same percent back. Pure Java, so that it has a test.
 */
public final class ColorAlpha {

    private ColorAlpha() {
    }

    /** 0 ... 100 to 0 ... 255. */
    public static int toAlpha(int percent) {
        int p = Math.max(0, Math.min(100, percent));
        return Math.round(p * 255f / 100f);
    }

    /** 0 ... 255 to 0 ... 100. */
    public static int toPercent(int alpha) {
        int a = Math.max(0, Math.min(255, alpha));
        return Math.round(a * 100f / 255f);
    }

    /** The colour with the alpha of this percent in place of its own. */
    public static int withPercent(int color, int percent) {
        return (toAlpha(percent) << 24) | (color & 0x00FFFFFF);
    }
}
