package com.android.launcher66;

/**
 * Whether the launcher shows the weather anywhere, kept free of android.* so that the rule can
 * be tested. When it does not, the WeatherManager has no reason to exist: it registers a
 * receiver, asks for the location (and the permission for it) and keeps the GPS on every 30 s.
 */
final class WeatherNeed {

    private WeatherNeed() {
    }

    /**
     * @param userLayout the user layout is on (only it has the widget bar)
     * @param widgetBar "Widget bottom bar" is on
     * @param noWeather "Hide the weather" is on
     * @param hotseatWeather the hotseat shows the weather (R.bool.weather_show, off by default)
     */
    static boolean needed(boolean userLayout, boolean widgetBar, boolean noWeather, boolean hotseatWeather) {
        return (userLayout && widgetBar && !noWeather) || hotseatWeather;
    }
}
