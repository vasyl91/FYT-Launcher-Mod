package com.syu.weather;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class WeatherDescription {
    String carWash;
    String city;
    String curTem;
    String humidity;
    String icon;
    String morningExe;
    String temDescription;
    String updateTime;
    String weather;
    String wind;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return this.wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getCurTem() {
        return this.curTem;
    }

    public void setCurTem(String curTem) {
        this.curTem = curTem;
    }

    public String getTemDescription() {
        return this.temDescription;
    }

    public void setTemDescription(String temDescription) {
        this.temDescription = temDescription;
    }

    public String getCarWash() {
        return this.carWash;
    }

    public void setCarWash(String carWash) {
        this.carWash = carWash;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getUpdateTime() {
        return this.updateTime;
    }

    public String getMorningExe() {
        return this.morningExe;
    }

    public void setMorningExe(String morningExe) {
        this.morningExe = morningExe;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean vaild() {
        return (this.city == null || this.weather == null || this.curTem == null || this.wind == null) ? false : true;
    }

    public static WeatherDescription getWeather(String msg) {
        JSONObject wind;
        JSONObject main;
        WeatherDescription info = new WeatherDescription();
        try {
            JSONObject jsonMsg = new JSONObject(msg);
            if (jsonMsg != null && jsonMsg.getInt("cod") == 200) {
                info.city = JSONUtils.getStr(jsonMsg, "name");
                JSONObject json = JSONUtils.getObjFromArray(jsonMsg, "weather", 0);
                if (json != null) {
                    info.weather = JSONUtils.getStr(json, "description");
                }
                if (jsonMsg.has("main") && (main = jsonMsg.getJSONObject("main")) != null) {
                    info.curTem = String.valueOf(JSONUtils.getTempName(main, "temp")) + "℃";
                    info.temDescription = String.valueOf(JSONUtils.getTempName(main, "temp_min")) + "-" + JSONUtils.getTempName(main, "temp_max") + "℃";
                    info.humidity = JSONUtils.getStr(main, "humidity");
                }
                if (jsonMsg.has("wind") && (wind = jsonMsg.getJSONObject("wind")) != null) {
                    info.wind = JSONUtils.getDoubleName(wind, "speed");
                }
                JSONObject json2 = JSONUtils.getObjFromArray(jsonMsg, "weather", 0);
                if (json2 != null) {
                    info.icon = JSONUtils.getStr(json2, "icon");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (info.vaild()) {
            return info;
        }
        return null;
    }

    public static WeatherDescription getWeatherInChina(String msg) {
        WeatherDescription info = new WeatherDescription();
        try {
            JSONObject jsonMsg = new JSONObject(msg);
            if (jsonMsg != null && jsonMsg.has("status") && jsonMsg.getInt("status") == 1) {
                info.city = JSONUtils.getStr(jsonMsg, "cityName");
                String str = JSONUtils.getStr(jsonMsg, "DatailWeather");
                String[] values = null;
                try {
                    values = str.split(" ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (values != null) {
                    if (values.length >= 1) {
                        info.weather = values[0];
                    }
                    if (values.length >= 2) {
                        info.curTem = values[1];
                    }
                }
                info.temDescription = JSONUtils.getStr(jsonMsg, "tRange");
                info.wind = JSONUtils.getStr(jsonMsg, "winds");
                info.carWash = JSONUtils.getStr(jsonMsg, "clearCar");
                info.humidity = JSONUtils.getStr(jsonMsg, "humidity");
                info.updateTime = JSONUtils.getStr(jsonMsg, "updateTime");
                info.morningExe = JSONUtils.getStr(jsonMsg, "MorningExe");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (info.vaild()) {
            return info;
        }
        return null;
    }

    public static WeatherDescription getWeatherOutChina(String msg) {
        WeatherDescription info = new WeatherDescription();
        try {
            JSONObject jsonMsg = new JSONObject(msg);
            if (jsonMsg != null && jsonMsg.has("status") && jsonMsg.getInt("status") == 1) {
                info.city = JSONUtils.getStr(jsonMsg, "cityName");
                String str = JSONUtils.getStr(jsonMsg, "DatailWeather");
                String[] values = null;
                try {
                    values = str.split(" ");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (values != null) {
                    if (values.length >= 1) {
                        info.weather = values[0];
                    }
                    if (values.length >= 2) {
                        info.curTem = values[1];
                    }
                }
                info.temDescription = JSONUtils.getStr(jsonMsg, "tRange");
                info.wind = JSONUtils.getStr(jsonMsg, "winds");
                info.carWash = JSONUtils.getStr(jsonMsg, "clearCar");
                info.humidity = JSONUtils.getStr(jsonMsg, "humidity");
                info.updateTime = JSONUtils.getStr(jsonMsg, "updateTime");
                info.morningExe = JSONUtils.getStr(jsonMsg, "MorningExe");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (info.vaild()) {
            return info;
        }
        return null;
    }

    public static WeatherDescription getWeatherNew(String msg) {
        JSONObject jsonResult;
        WeatherDescription info = new WeatherDescription();
        try {
            JSONObject jsonMsg = new JSONObject(msg);
            if (jsonMsg != null && (jsonResult = JSONUtils.getJSONObject(jsonMsg, "result")) != null && jsonResult.getInt("status") == 1) {
                JSONObject jsonCity = JSONUtils.getJSONObject(jsonResult, "city");
                if (jsonCity != null) {
                    info.city = JSONUtils.getStr(jsonCity, "city");
                }
                info.weather = JSONUtils.getStr(jsonResult, "weather");
                info.curTem = JSONUtils.getStr(jsonResult, "temp");
                info.temDescription = JSONUtils.getStr(jsonResult, "temp");
                info.humidity = JSONUtils.getStr(jsonResult, "humidity");
                info.wind = JSONUtils.getStr(jsonResult, "wind");
                info.updateTime = JSONUtils.getStr(jsonResult, "updatetime");
                info.carWash = JSONUtils.getStr(jsonResult, "washindex");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (info.vaild()) {
            return info;
        }
        return null;
    }

    public String toString() {
        String str = "city:" + this.city + "\nweather:" + this.weather + "\ncurTem:" + this.curTem + "\ntemDescription:" + this.temDescription + "\nwind" + this.wind + "\nmorningExe:" + this.morningExe + "\ncarWash:" + this.carWash + "\nhumidity:" + this.humidity + "\nupdateTime:" + this.updateTime;
        return str;
    }
}
