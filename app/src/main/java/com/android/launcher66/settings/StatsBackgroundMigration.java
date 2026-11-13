package com.android.launcher66.settings;

import android.content.SharedPreferences;

import com.android.launcher66.BackgroundChoice;

/**
 * The background of the statistics window as the old settings gave it, turned into the one choice the new
 * settings keep ("Choose background for statistics", a BackgroundChoice like the widgets' and the bars').
 *
 * <p>The old settings were three switches, a colour and a transparency: "Statistics background", "Default
 * background", "Colored background", "Set the background color" and its slider. The rule of the change: the
 * window looks after it exactly as it looked before. So the result is what CanbusService really drew from
 * those values, with the defaults it used when a value was never stored (background on, default picture off,
 * colour off; they differ from the defaults the settings showed):
 * <ul>
 *   <li>background off, or on with neither kind chosen: no background;</li>
 *   <li>the default picture: the picture bg_custom;</li>
 *   <li>the colour: the user's own colour, with the stored transparency as its alpha. The stored colour is
 *       taken as it is, although the old settings damaged it on saving (they masked it with another colour):
 *       it is the colour the window has shown since, and the user can now choose it again.</li>
 * </ul>
 * The rule itself ({@link #of}, {@link #argb}, {@link #parse}) is plain Java, so that it has a test; only
 * {@link #run} reads and writes the preferences.
 */
public final class StatsBackgroundMigration {

    /** What CanbusService assumed for a value that was never stored. */
    private static final boolean DEFAULT_BACKGROUND = true;
    private static final boolean DEFAULT_PICTURE = false;
    private static final boolean DEFAULT_COLOURED = false;
    private static final int DEFAULT_COLOUR = 0xFF000000;
    private static final int DEFAULT_ALPHA = 255;
    /** The picture "Default background" stood for. */
    static final String PICTURE = "bg_custom";

    /** The new values: the text of the choice, and the colour to store beside it (null: none). */
    static final class Result {
        final String choice;
        final Integer color;

        Result(String choice, Integer color) {
            this.choice = choice;
            this.color = color;
        }
    }

    private StatsBackgroundMigration() {
    }

    /**
     * Every argument is the stored value, or null when nothing was stored under its key.
     *
     * @param background "stats_bg"
     * @param picture    "bg_drawable"
     * @param coloured   "bg_color"
     * @param colour     "bg_stats_color", as text ("#RRGGBB" or "#AARRGGBB")
     * @param alpha      "alpha_seek_bar", 0 ... 255
     */
    static Result of(Boolean background, Boolean picture, Boolean coloured, String colour, Integer alpha) {
        boolean on = background != null ? background : DEFAULT_BACKGROUND;
        boolean asPicture = picture != null ? picture : DEFAULT_PICTURE;
        boolean asColour = coloured != null ? coloured : DEFAULT_COLOURED;
        // The colour is kept whatever is chosen, so that it is there when the user picks the colour tile
        Integer kept = colour != null || alpha != null ? argb(colour, alpha) : null;
        if (!on) {
            return new Result(BackgroundChoice.NONE, kept);
        }
        if (asPicture) {
            return new Result(PICTURE, kept);
        }
        if (asColour) {
            return new Result(BackgroundChoice.CUSTOM, argb(colour, alpha));
        }
        return new Result(BackgroundChoice.NONE, kept);
    }

    /** The keys of the old settings, all removed once they are carried over. */
    private static final String[] OLD_KEYS = {Keys.STATS_BG, Keys.BG_DRAWABLE, Keys.BG_COLOR, Keys.BG_STATS_COLOR,
            Keys.ALPHA_SEEK_BAR, "red", "green", "blue", "bg_red", "bg_green", "bg_blue"};

    /**
     * Carries the old settings over, once: it does nothing when none of the old keys is stored, and it removes
     * them all, so a second start finds nothing to do. A choice that is already stored is not overwritten.
     */
    public static void run(SharedPreferences prefs) {
        boolean any = false;
        for (String key : OLD_KEYS) {
            any |= prefs.contains(key);
        }
        if (!any) {
            return;
        }
        SharedPreferences.Editor editor = prefs.edit();
        if (!prefs.contains(Keys.STATS_SELECTED_BACKGROUND)) {
            Result result = of(bool(prefs, Keys.STATS_BG), bool(prefs, Keys.BG_DRAWABLE), bool(prefs, Keys.BG_COLOR),
                    text(prefs, Keys.BG_STATS_COLOR), number(prefs, Keys.ALPHA_SEEK_BAR));
            editor.putString(Keys.STATS_SELECTED_BACKGROUND, result.choice);
            if (result.color != null && !prefs.contains(Keys.STATS_CUSTOM_BACKGROUND_COLOR)) {
                editor.putInt(Keys.STATS_CUSTOM_BACKGROUND_COLOR, result.color);
            }
        }
        for (String key : OLD_KEYS) {
            editor.remove(key);
        }
        editor.apply();
    }

    private static Boolean bool(SharedPreferences prefs, String key) {
        try {
            return prefs.contains(key) ? prefs.getBoolean(key, false) : null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    private static String text(SharedPreferences prefs, String key) {
        try {
            return prefs.contains(key) ? prefs.getString(key, null) : null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    private static Integer number(SharedPreferences prefs, String key) {
        try {
            return prefs.contains(key) ? prefs.getInt(key, 255) : null;
        } catch (ClassCastException e) {
            return null;
        }
    }

    /** The stored colour with the stored transparency as its alpha, as the window drew it. */
    static int argb(String colour, Integer alpha) {
        int rgb = parse(colour) & 0x00FFFFFF;
        int a = alpha != null ? Math.max(0, Math.min(255, alpha)) : DEFAULT_ALPHA;
        return (a << 24) | rgb;
    }

    /** "#RRGGBB" or "#AARRGGBB" to a colour; anything else is the old default, black. */
    public static int parse(String colour) {
        if (colour == null) {
            return DEFAULT_COLOUR;
        }
        String hex = colour.trim();
        if (hex.startsWith("#")) {
            hex = hex.substring(1);
        }
        try {
            if (hex.length() == 6) {
                return 0xFF000000 | (int) Long.parseLong(hex, 16);
            }
            if (hex.length() == 8) {
                return (int) Long.parseLong(hex, 16);
            }
        } catch (NumberFormatException e) {
            // falls through to the default
        }
        return DEFAULT_COLOUR;
    }
}
