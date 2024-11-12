package com.syu.util;

import android.content.Context;
import android.content.res.Resources;
import java.util.HashMap;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class WeatherUtils {
    private static final String weatherBgPrefix = "ic_weather_bg_";
    private static final String weatherImgprefix = "fyt_ic_";
    public static HashMap<String, String> mWeatherMap = new HashMap<>();
    public static final String[] WEATHER_ZH = {"特大暴雨", "大暴雨", "暴雨", "大雨", "中雨", "小雨", "冻雨", "雷阵雨", "阵雨", "暴雪", "大雪", "中雪", "小雪", "雨夹雪", "阵雪", "强沙尘暴", "沙尘暴", "浮尘", "扬沙", "雾", "阴", "闪电", "晴", "雷阵雨伴冰雹", "多云", "冰雹", "sunny", "overcast", "drizzle", "storm", "blizzard", "snowstorm", "windy", "Haze", "breeze", "gale", "typhoon", "hurricane", "foggy", "frosty", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail"};
    public static final String[] WEATHER_EN = {"storm", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail", "sunshine", "cloudy_sky", "rain", "lightning", "great_snow", "heavy_snow", "blowing", "fog", "dust", "sandstorm", "sandstorm", "strong_sandstorm", "fog", "freezing", "x_heavy_rain", "b_heavy_rain", "heavy_rain", "moderate_rain", "rain", "freezing", "thunderstorm", "shower", "heavy_snow", "great_snow", "moderate_snow", "snow", "sleet", "snow_shower", "strong_sandstorm", "sandstorm", "dust", "blowing", "fog", "cloudy_sky", "lightning", "sunshine", "thunderstorm_with_hail", "cloudy", "hail"};

    static {
        for (int i = 0; i < WEATHER_ZH.length; i++) {
            mWeatherMap.put(WEATHER_ZH[i], WEATHER_EN[i]);
        }
    }

    public static int getWeatherImagId(Context context, String name) {
        String str = null;
        String[] strArr = WEATHER_ZH;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                String weather = strArr[i];
                if (name == null || !name.toLowerCase().contains(weather)) {
                    i++;
                } else {
                    str = weather;
                    break;
                }
            } else {
                break;
            }
        }
        if (str != null && !str.equals("")) {
            str = mWeatherMap.get(str);
        }
        int imgId = getResid(context, weatherImgprefix + str, "drawable");
        return imgId;
    }

    public static int getWeatherBgId(Context context, String name) {
        String str = null;
        String[] strArr = WEATHER_ZH;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i < length) {
                String weather = strArr[i];
                if (name == null || !name.contains(weather)) {
                    i++;
                } else {
                    str = weather;
                    break;
                }
            } else {
                break;
            }
        }
        if (str == null || str.equals("")) {
            return -1;
        }
        int imgId = getResid(context, weatherBgPrefix + mWeatherMap.get(str), "drawable");
        return imgId;
    }

    public static int getResid(Context context, String name, String type) {
        Resources res = context.getResources();
        if (res == null) {
            return 0;
        }
        return res.getIdentifier(name, type, context.getPackageName());
    }
}
