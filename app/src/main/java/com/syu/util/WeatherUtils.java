package com.syu.util;

import com.android.launcher66.LauncherApplication;
import com.android.launcher66.R;

import java.lang.reflect.Field;

public class WeatherUtils {

    public static int getResId(String resName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    private static int getWeatherId(String resName) {
        try {
            Field idField = R.string.class.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    public static String translateDescription(String description) {
        return switch (description) {
            case "clear sky", "few clouds", "scattered clouds", "broken clouds", "overcast clouds",
                 "shower rain", "rain", "thunderstorm", "snow", "mist",
                 "thunderstorm with light rain", "thunderstorm with rain",
                 "thunderstorm with heavy rain", "light thunderstorm", "heavy thunderstorm",
                 "ragged thunderstorm", "thunderstorm with light drizzle",
                 "thunderstorm with drizzle", "thunderstorm with heavy drizzle",
                 "light intensity drizzle", "drizzle", "heavy intensity drizzle",
                 "light intensity drizzle rain", "drizzle rain", "heavy intensity drizzle rain",
                 "shower rain and drizzle", "heavy shower rain and drizzle", "shower drizzle",
                 "light rain", "moderate rain", "heavy intensity rain", "very heavy rain",
                 "extreme rain", "freezing rain", "light intensity shower rain",
                 "heavy intensity shower rain", "ragged shower rain", "light snow", "heavy snow",
                 "sleet", "light shower sleet", "shower sleet", "light rain and snow",
                 "rain and snow", "light shower snow", "shower snow", "heavy shower snow", "smoke",
                 "haze", "sand/dust whirls", "fog", "sand", "dust", "volcanic ash", "squalls",
                 "tornado" ->
                    LauncherApplication.sApp.getString(getWeatherId(description.replace(" ", "_").replace("/", "_")));
            default -> description;
        };
    }
}
