package com.syu.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The name of the drawable that shows a weather icon code ("01d", "10n", ...). Free of android.*
 * so it can be tested.
 */
public final class WeatherIcons {

    private WeatherIcons() {}

    /**
     * The night icons that are the very picture of the day ones: only the day file exists for
     * these codes, the others have both.
     */
    private static final Set<String> SAME_AS_DAY =
            new HashSet<>(Arrays.asList("03n", "04n", "13n", "50n"));

    public static String name(String iconCode) {
        if (iconCode != null && SAME_AS_DAY.contains(iconCode)) {
            return "weather" + iconCode.substring(0, 2) + "d";
        }
        return "weather" + iconCode;
    }
}
