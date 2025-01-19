package com.syu.weather;

import org.json.JSONObject;

public class DailyWeather {
    String city;
    String date;
    String hightemp;
    String lowtemp;
    String weather;
    String weekDay;
    String windDir;

    public String getHightemp() {
        return this.hightemp;
    }

    public void setHightemp(String hightemp) {
        this.hightemp = hightemp;
    }

    public String getLowtemp() {
        return this.lowtemp;
    }

    public void setLowtemp(String lowtemp) {
        this.lowtemp = lowtemp;
    }

    public String getWeekDay() {
        return this.weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWindDir() {
        return this.windDir;
    }

    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isEmpty() {
        return this.city == null && this.date == null && this.hightemp == null && this.lowtemp == null && this.weather == null && this.weekDay == null && this.windDir == null;
    }

    public String toString() {
        String str = "city :" + this.city + "\ndate:" + this.date + "\nhightemp:" + this.hightemp + "\nlowtemp:" + this.lowtemp + "\nweather:" + this.weather + "\nweekDay:" + this.weekDay + "\nwindDir:" + this.windDir;
        return str;
    }

    public static DailyWeather getDailyWeather(JSONObject json) {
        DailyWeather weather = new DailyWeather();
        if (json != null) {
            weather.city = JSONUtils.getStr(json, "city");
            weather.date = JSONUtils.getStr(json, "date");
            weather.hightemp = JSONUtils.getStr(json, "hightemp");
            weather.lowtemp = JSONUtils.getStr(json, "lowtemp");
            weather.weather = JSONUtils.getStr(json, "weather");
            weather.weekDay = JSONUtils.getStr(json, "weekDay");
            weather.windDir = JSONUtils.getStr(json, "windDir");
        }
        return weather;
    }
}
