package com.android.launcher66;

/**
 * The widths of the widgets of the widget bar (as shares of the bar's width, the
 * {@code constraintWidth_percent} of custom_layout_two_user in layout-land and layout-port) and
 * what happens to them when the date or the weather is hidden: the music widget takes their room.
 * Kept free of views so that the arithmetic can be tested; {@link WidgetBarLayout} applies it.
 */
public final class WidgetBarPlan {

    static final float MUSIC_LAND = 0.28f;
    static final float DATE_LAND = 0.05f;
    static final float WEATHER_LAND = 0.12f;

    static final float MUSIC_PORT = 0.295f;
    static final float WEATHER_PORT = 0.15f;

    /** 'Large text': the text rows of the weather widget get this much more of its height. */
    static final float WEATHER_ROW_GROWTH = 0.15f;
    /** The icon above the weather texts keeps at least this share of its usual height. */
    static final float WEATHER_ICON_MIN_SHARE = 0.6f;

    private WidgetBarPlan() {
    }

    /**
     * The height shares of the weather widget's text rows and of its icon with 'Large text' on,
     * computed from the shares of the layout file. They must never be computed from the shares the
     * views have now: the bar is attached again after every wake, and a result that feeds back
     * into its input would grow the rows (and shrink the icon) a little more every time.
     *
     * @return {row share, icon share}
     */
    static float[] largeWeatherShares(float usualRow, float usualIcon) {
        float largeRow = usualRow * (1f + WEATHER_ROW_GROWTH);
        // Two rows of text sit under the icon (the city and the temperature share the second one)
        float largeIcon = Math.max(usualIcon * WEATHER_ICON_MIN_SHARE,
                usualIcon - 2f * (largeRow - usualRow));
        return new float[] {largeRow, largeIcon};
    }

    /** In portrait the bar has no date, so only the weather can be hidden there. */
    public static boolean dateHidden(boolean noDate, boolean portrait) {
        return noDate && !portrait;
    }

    /** The music widget's width share with nothing hidden: the width its cover is sized from. */
    static float baseShare(boolean portrait) {
        return portrait ? MUSIC_PORT : MUSIC_LAND;
    }

    /** The music widget's own width plus the widths of the hidden widgets. */
    static float musicShare(boolean portrait, boolean dateHidden, boolean weatherHidden) {
        if (portrait) {
            return MUSIC_PORT + (weatherHidden ? WEATHER_PORT : 0f);
        }
        return MUSIC_LAND + (dateHidden ? DATE_LAND : 0f) + (weatherHidden ? WEATHER_LAND : 0f);
    }

    /** The music widget is wider than usual when any widget of the bar is hidden. */
    public static boolean wide(boolean dateHidden, boolean weatherHidden) {
        return dateHidden || weatherHidden;
    }

    /**
     * The layout with the buttons beside the text (music_bar_content_wide) is used when something
     * is hidden and the user wants the buttons there. Otherwise the usual layout (the text, and
     * the buttons below it) is used, with the whole widened width.
     */
    static boolean buttonsBeside(boolean dateHidden, boolean weatherHidden, boolean switchOn) {
        return wide(dateHidden, weatherHidden) && switchOn;
    }
}
