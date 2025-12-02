package com.syu.weather;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Locale;

public class WeatherDescription {
    String carWash;
    String city;
    String curTem;
    String humidity;
    String morningExe;
    String temDescription;
    String updateTime;
    String weather;
    String wind;
    String pressure;
    String iconCode;
    private boolean valid = false;

    private static final String TAG = "WeatherDescription";

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
    
    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getIconCode() {
        return iconCode;
    }

    public void setIconCode(String iconCode) {
        this.iconCode = iconCode;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean vaild() {
        return (this.city == null || this.weather == null || this.curTem == null || this.wind == null || this.iconCode == null) ? false : true;
    }
    public static WeatherDescription parseOpenWeatherMapData(String jsonResponse) {
        try {
            JSONObject json = new JSONObject(jsonResponse);
            
            // Extract basic information
            String city = json.getString("name");
            JSONObject main = json.getJSONObject("main");
            JSONArray weatherArray = json.getJSONArray("weather");
            JSONObject weatherObj = weatherArray.getJSONObject(0);
            JSONObject wind = json.getJSONObject("wind");
            
            // Get temperature in Celsius (already in metric units)
            double temp = main.getDouble("temp");
            double tempMin = main.getDouble("temp_min");
            double tempMax = main.getDouble("temp_max");
            
            String weatherDescription = weatherObj.getString("description");
            String weatherIcon = weatherObj.getString("icon");
            double windSpeed = wind.getDouble("speed");
            int humidity = main.getInt("humidity");
            int pressure = main.getInt("pressure");
            
            // Create WeatherDescription object
            WeatherDescription weather = new WeatherDescription();
            
            // Set the fields - you'll need to adjust these based on your WeatherDescription class structure
            weather.city = city;
            weather.weather = weatherDescription;
            weather.curTem = formatTemperature(temp);
            weather.temDescription = formatTemperature(tempMin) + "-" + formatTemperature(tempMax);
            weather.wind = formatWindSpeed(windSpeed);
            weather.humidity = humidity + "%";
            weather.pressure = pressure + " hPa";
            weather.iconCode = weatherIcon;
            
            // Mark as valid
            weather.setValid(true);

            Log.i(TAG, "city = " + weather.city + 
                  "\nweather = " + weather.weather + 
                  "\ncurrent temperature = " + weather.curTem + 
                  "\ntemperature description = " + weather.temDescription + 
                  "\nwind = " + weather.wind + 
                  "\nicon = " + weather.iconCode);            
            return weather;
            
        } catch (Exception e) {
            Log.e(TAG, "Error parsing OpenWeatherMap data", e);
            return null;
        }
    }

    private static String formatTemperature(double temp) {
        // Validate temperature range
        if (temp < -100 || temp > 100) {
            Log.w(TAG, "Invalid temperature detected: " + temp + ", using default");
            return "N/A";
        }
        return String.format(Locale.US, "%.1f℃", temp);
    }
    
    private static String formatWindSpeed(double speed) {
        return String.format(Locale.US, "%.1f m/s", speed);
    }
    
    private static boolean isValidTemperature(String tempStr) {
        if (tempStr == null || tempStr.isEmpty()) {
            return false;
        }
        try {
            // Remove any non-numeric characters except minus and decimal point
            String cleanTemp = tempStr.replaceAll("[^0-9.-]", "");
            double temp = Double.parseDouble(cleanTemp);
            return temp >= -100 && temp <= 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String toString() {
        String str = "city:" + this.city + 
                    "\nweather:" + this.weather + 
                    "\ncurTem:" + this.curTem + 
                    "\ntemDescription:" + this.temDescription + 
                    "\nwind:" + this.wind + 
                    "\nhumidity:" + this.humidity +
                    "\npressure:" + this.pressure +
                    "\niconCode:" + this.iconCode +
                    "\nmorningExe:" + this.morningExe + 
                    "\ncarWash:" + this.carWash + 
                    "\nupdateTime:" + this.updateTime;
        return str;
    }
}