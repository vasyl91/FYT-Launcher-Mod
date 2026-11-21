package com.android.launcher66;

/**
 * The widths of the widgets of the widget bar (as shares of the bar's width, the
 * {@code constraintWidth_percent} of custom_layout_two_user in layout-land and layout-port) and
 * what happens to them when the date or the weather is hidden: the music widget takes their room.
 * Kept free of views so that the arithmetic can be tested; {@link WidgetBarLayout} applies it.
 *
 * <p>The apps list fitted to its icons (the owner, 2026-11-21, "Fit the apps to their icons"): the list is as
 * wide as the tiles it shows, each tile as wide as it is with the most icons the list has room for, so the icons
 * keep the margins they have at the maximum. The room it gives up goes to the widgets: <b>the date and the weather
 * get 10% of it each, the music the rest</b>; a widget that is not shown (the date in portrait, a hidden date or
 * weather) gets nothing, and its 10% goes to the music too ({@link #shares}). Only with the widget bar: without it
 * the list keeps its usual width. The total of the shares does not change. An element whose height comes from its
 * own width (the portrait list and weather) keeps the height of its usual width ({@link #keptRatio}).
 *
 * <p>The apps list hidden (the owner, 2026-11-21, "Hide the apps"): the bar shows no list, and all of its room is
 * shared the same way; the app drawer button stays. <b>Only with the widget bar</b> ({@link #appsHidden}): with the
 * widget bar off the list is always shown, at its usual width, whatever is stored under the key.
 */
public final class WidgetBarPlan {

    static final float MUSIC_LAND = 0.28f;
    static final float DATE_LAND = 0.05f;
    static final float WEATHER_LAND = 0.12f;

    static final float MUSIC_PORT = 0.295f;
    static final float WEATHER_PORT = 0.15f;

    /** The apps list's usual share: the one BarCapacity counts its room with. */
    static final float APPS_LAND = BarCapacity.RECYCLER_W_WIDGET_LANDSCAPE;
    static final float APPS_PORT = BarCapacity.RECYCLER_W_WIDGET_PORTRAIT;
    /** Of the room the apps list gives up, the date and the weather each get this share; the music the rest. */
    static final float FREED_TO_DATE = 0.10f;
    static final float FREED_TO_WEATHER = 0.10f;
    /** Height per width of the portrait list and weather (their "H," ratios in layout-port). */
    static final float APPS_RATIO_PORT = BarCapacity.RECYCLER_H_WIDGET_PORTRAIT;
    static final float WEATHER_RATIO_PORT = 0.95f;

    /** The widths of the widget bar's elements, as shares of the bar's width; the drawer button keeps its own. */
    public static final class Shares {
        public final float apps;
        public final float music;
        /** 0 where the date is not shown. */
        public final float date;
        /** 0 where the weather is hidden. */
        public final float weather;
        /** The apps list gave up room: the list, the date and the weather have other widths than usual. */
        public final boolean appsChanged;

        Shares(float apps, float music, float date, float weather, boolean appsChanged) {
            this.apps = apps;
            this.music = music;
            this.date = date;
            this.weather = weather;
            this.appsChanged = appsChanged;
        }
    }

    /** 'Large text': the text rows of the weather widget get this much more of its height. */
    static final float WEATHER_ROW_GROWTH = 0.15f;
    /** The icon above the weather texts keeps at least this share of its usual height. */
    static final float WEATHER_ICON_MIN_SHARE = 0.6f;

    /** With the buttons beside the text in two rows of two, they take this share of the room right of the cover. */
    static final float BESIDE_BUTTONS_TWO_ROWS = 0.35f;
    /** In one row of four ('Buttons in one line'), in landscape. */
    static final float BESIDE_BUTTONS_ONE_ROW_LAND = 0.40f;
    /** In one row of four, in portrait, where the bar is narrow and four buttons need the room. */
    static final float BESIDE_BUTTONS_ONE_ROW_PORT = 0.50f;

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

    static float usualApps(boolean portrait) {
        return portrait ? APPS_PORT : APPS_LAND;
    }

    static float usualWeather(boolean portrait) {
        return portrait ? WEATHER_PORT : WEATHER_LAND;
    }

    /** Whether the bar shows no apps list: "Hide the apps", in the user layout's widget bar only. */
    public static boolean appsHidden(boolean userLayout, boolean widgetBar, boolean noApps) {
        return userLayout && widgetBar && noApps;
    }

    /**
     * The apps list's share: nothing when it is hidden; its usual one; or, fitted, the share of the {@code shown}
     * tiles at the width a tile has with {@code room} of them (the most the list has room for). Fitted only when it
     * shows fewer than it has room for.
     */
    public static float appsShare(boolean portrait, boolean hidden, boolean fit, int shown, int room) {
        float usual = usualApps(portrait);
        if (hidden) {
            return 0f;
        }
        if (fit && room > 0 && shown > 0 && shown < room) {
            return usual * shown / room;
        }
        return usual;
    }

    /** The widths of all the elements for an apps list of the share {@code apps} (see the class for the rule). */
    public static Shares shares(boolean portrait, boolean dateHidden, boolean weatherHidden, float apps) {
        float freed = Math.max(0f, usualApps(portrait) - apps);
        boolean dateShown = !portrait && !dateHidden;
        float dateGain = dateShown ? freed * FREED_TO_DATE : 0f;
        float weatherGain = weatherHidden ? 0f : freed * FREED_TO_WEATHER;
        float music = musicShare(portrait, dateHidden, weatherHidden) + freed - dateGain - weatherGain;
        float date = dateShown ? DATE_LAND + dateGain : 0f;
        float weather = weatherHidden ? 0f : usualWeather(portrait) + weatherGain;
        return new Shares(apps, music, date, weather, freed > 0f);
    }

    /**
     * The "H," ratio (height per width) that keeps the height an element has at its usual width when it gets
     * another width: the portrait list and weather are as high as their own width says.
     */
    static float keptRatio(float ratio, float usualShare, float share) {
        return share > 0f ? ratio * usualShare / share : ratio;
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

    /**
     * The share of R (what is left of the widget right of the cover and its gap) the block of
     * buttons takes beside the text; the text keeps the rest, rounding included.
     */
    static float besideButtonsShare(boolean portrait, boolean oneRow) {
        if (!oneRow) {
            return BESIDE_BUTTONS_TWO_ROWS;
        }
        return portrait ? BESIDE_BUTTONS_ONE_ROW_PORT : BESIDE_BUTTONS_ONE_ROW_LAND;
    }

    /** The music widget is wider than usual when the date or the weather is hidden: it takes their room. */
    public static boolean widensMusic(boolean dateHidden, boolean weatherHidden) {
        return dateHidden || weatherHidden;
    }

    /**
     * Something of the bar is hidden: the date, the weather or the album cover. Then the music
     * widget has room that the usual layout does not use, and the buttons may go beside the text.
     */
    public static boolean wide(boolean dateHidden, boolean weatherHidden, boolean coverHidden) {
        return dateHidden || weatherHidden || coverHidden;
    }

    /**
     * The layout with the buttons beside the text (music_bar_content_wide) is used when something
     * is hidden and the user wants the buttons there. Otherwise the usual layout (the text, and
     * the buttons below it) is used, with the whole width the music widget has.
     */
    public static boolean buttonsBeside(boolean dateHidden, boolean weatherHidden, boolean coverHidden,
            boolean switchOn) {
        return wide(dateHidden, weatherHidden, coverHidden) && switchOn;
    }
}
