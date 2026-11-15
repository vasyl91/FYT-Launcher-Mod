package com.syu.weather;

/**
 * Which OpenWeather key the launcher asks the weather with.
 *
 * <p>The launcher has a key built in, shared by everyone who uses it; the service counts the requests of a
 * key, so a shared one can run out for all. The rule: a key the user entered is used in place of the built-in
 * one, and only if it looks like a key (32 letters a-f and digits, as OpenWeather issues them); anything else
 * (nothing entered, a mistyped key) leaves the built-in key in use, so the weather never stops because of
 * what stands in the field. A key is never written to a log: only its last four characters are shown, in the
 * settings. Pure Java, so that it has a test.
 */
public final class WeatherKey {

    private static final int LENGTH = 32;

    private WeatherKey() {
    }

    /** Whether the text looks like an OpenWeather key. */
    public static boolean valid(String text) {
        if (text == null) {
            return false;
        }
        String key = text.trim();
        if (key.length() != LENGTH) {
            return false;
        }
        for (int i = 0; i < LENGTH; i++) {
            char c = key.charAt(i);
            boolean hex = (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
            if (!hex) {
                return false;
            }
        }
        return true;
    }

    /** The key to use: the user's own if it is one, else the built-in one. */
    public static String use(String own, String builtIn) {
        return valid(own) ? own.trim() : builtIn;
    }

    /** How a key is shown in the settings: dots and its last four characters; null for no key. */
    public static String shown(String own) {
        if (!valid(own)) {
            return null;
        }
        String key = own.trim();
        return "•••• " + key.substring(LENGTH - 4);
    }
}
