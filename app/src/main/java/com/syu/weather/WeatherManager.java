package com.syu.weather;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.syu.esri.ShapeDB;
import com.syu.esri.ShapeData;
import com.syu.esri.ShapeIndex;
import com.syu.esri.ShapeReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherManager {
    private static final String TAG = "WeatherManager";
    public static final String OPEN_WEATHER_APPID = "4a87b2f097e39a2cb9c75916073e75a7";
    public static final String OPEN_WEATHER_GEO_URL = "https://api.openweathermap.org/geo/1.0/reverse?limit=1&appid=" + OPEN_WEATHER_APPID;
    public static final String OPEN_WEATHER_CURRENT_URL = "https://api.openweathermap.org/data/2.5/weather?appid=" + OPEN_WEATHER_APPID + "&units=metric";
    
    private FusedLocationProviderClient fusedLocationClient;
    private SharedPreferences mPrefs;
    public static WeatherManager instance;
    String cityName;
    HandlerThread handlerThread;
    boolean inChina;
    boolean isGettingWeather;
    Context mContext;
    Location mCurLocation;
    WeatherDescription mCurWeather;
    LocationManager mLocationManager;
    NetworkCheck mNetworkCheck;
    String tmpCity;
    // Use WeakReference to avoid leaking activity/listener implementers
    public List<WeakReference<OnWeatherChangedListener>> weatherListeners;
    boolean isRunning = false;
    long lastLocationTime = 0;
    long lastWeatherTime = 0;
    boolean isFirst = true;
    int minDis = 3;
    
    private OkHttpClient okHttpClient;

    GnssStatus.Callback mListener = new GnssStatus.Callback() {
        long time;

        @Override 
        public void onSatelliteStatusChanged(@NonNull GnssStatus status) {
            if (SystemClock.elapsedRealtime() - this.time > 10000) {
                this.time = SystemClock.elapsedRealtime();
                double maxSatellites = status.getSatelliteCount();
                double usedInFix = 0;
                for (int i = 0; i < maxSatellites; ++i) {
                    if (status.usedInFix(i)) {
                        ++usedInFix;
                    }
                }
            }
        }
    };
    
    LocationListener mNetListener = new LocationListener() { 
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
        }
    };
    
    LocationListener mGpsListener = new LocationListener() { 
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                boolean flag = WeatherManager.this.isBetterLocation(location, WeatherManager.this.mCurLocation);
                if (flag) {
                    WeatherManager.this.mCurLocation = location;
                    if (mPrefs == null) {
                        mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
                    }                    
                    SharedPreferences.Editor editor = mPrefs.edit();
                    double lat = location.getLatitude();
                    double longt = location.getLongitude();
                    editor.putString("latiude", String.valueOf(lat));
                    editor.putString("longitude", String.valueOf(longt));
                    editor.apply();
                    if (WeatherManager.this.minDis == 0) {
                        WeatherManager.this.stop();
                        WeatherManager.this.minDis = 2000;
                        if (WeatherManager.this.mLocationManager.isProviderEnabled("gps") && hasLocationPermission()) {
                            try {
                                WeatherManager.this.mLocationManager.requestLocationUpdates("gps", 2L, WeatherManager.this.minDis, WeatherManager.this.mGpsListener);
                            } catch (SecurityException e) {
                                Log.e(TAG, "GPS location permission denied", e);
                            }
                        }
                    }
                    WeatherManager.this.updateLocation(WeatherManager.this.mCurLocation);
                }
            }
        }
    };
    
    public mThread_readLocalData mThread_readLocalData = new mThread_readLocalData();

    public interface OnWeatherChangedListener {
        void onWeatherChanged(WeatherDescription weatherDescription);
    }

    public interface RecentWeatherListener {
        void onResult(int i, RecentWeather recentWeather);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
            (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkCapabilities capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            return capabilities != null && 
                   (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR));
        }
        return false;
    }

    private boolean hasLocationPermission() {
        return ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
               ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    public void addOnWeatherChangedListener(OnWeatherChangedListener listener) {
        if (listener == null) return;

        if (this.weatherListeners == null) {
            this.weatherListeners = new ArrayList<>();
        }

        synchronized (this.weatherListeners) {
            // Cleanup cleared references and check for existing listener
            Iterator<WeakReference<OnWeatherChangedListener>> it = this.weatherListeners.iterator();
            while (it.hasNext()) {
                OnWeatherChangedListener l = it.next().get();
                if (l == null) {
                    it.remove();
                } else if (l == listener) {
                    // already registered; still notify current weather
                    try {
                        listener.onWeatherChanged(this.mCurWeather);
                    } catch (Exception e) {
                        Log.e(TAG, "Error notifying listener in addOnWeatherChangedListener", e);
                    }
                    return;
                }
            }

            // notify current weather then add as weak reference
            try {
                listener.onWeatherChanged(this.mCurWeather);
            } catch (Exception e) {
                Log.e(TAG, "Error notifying listener in addOnWeatherChangedListener", e);
            }

            this.weatherListeners.add(new WeakReference<>(listener));
        }
    }

    public void removeOnWeatherChangedListener(OnWeatherChangedListener listener) {
        if (this.weatherListeners == null || listener == null) return;

        synchronized (this.weatherListeners) {
            Iterator<WeakReference<OnWeatherChangedListener>> it = this.weatherListeners.iterator();
            while (it.hasNext()) {
                OnWeatherChangedListener l = it.next().get();
                if (l == null || l == listener) {
                    it.remove();
                }
            }
        }
    }

    /**
     * Explicitly clear all listener references (optional utility).
     * Call from application/owner when appropriate (e.g. global shutdown).
     */
    public void clearListeners() {
        if (this.weatherListeners == null) return;
        synchronized (this.weatherListeners) {
            this.weatherListeners.clear();
        }
    }

    public static WeatherManager initialize(Context context) {
        if (instance == null) {
            instance = new WeatherManager(context);
        }
        return instance;
    }

    public static WeatherManager getInstance() {
        return instance;
    }

    WeatherManager(Context context) {
        this.inChina = false;
        this.mContext = context.getApplicationContext();
        
        // Initialize OkHttpClient
        this.okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this.mContext);
        SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
        String string = preferences.getString("city", "");
        this.cityName = string;
        this.tmpCity = string;
        this.inChina = preferences.getBoolean("inChina", this.inChina);
        this.mLocationManager = (LocationManager) this.mContext.getSystemService(Context.LOCATION_SERVICE);
        this.mNetworkCheck = new NetworkCheck(this.mContext);
        this.mNetworkCheck.registerLisenter(new NetworkCheck.OnNetworkStateChangeLisenter() { 
            @Override
            public void onChanged(boolean vaild) {
                if (vaild) {
                    WeatherManager.this.start();
                    if (WeatherManager.this.isRunning && WeatherManager.this.mCurLocation != null) {
                        WeatherManager.this.getWeather(Double.valueOf(WeatherManager.this.mCurLocation.getLatitude()), Double.valueOf(WeatherManager.this.mCurLocation.getLongitude()), "gogogo");
                        return;
                    }
                    return;
                }
                WeatherManager.this.stop();
            }
        });
        this.mNetworkCheck.register(this.mContext);
    }

    @SuppressLint("MissingPermission")
    public void start() {
        if (!isNetworkAvailable()) {
            Log.w(TAG, "No network available, cannot start weather updates");
            return;
        }
        if (!hasLocationPermission()) {
            Log.w(TAG, "Location permission not granted, cannot start location updates, asking user for permission");
            ActivityCompat.requestPermissions(
                    Launcher.getLauncher(),
                    new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    0
            );
            return;
        }

        if (mLocationManager != null) {
            try {
                mLocationManager.registerGnssStatusCallback(mListener, null);
            } catch (SecurityException e) {
                Log.e(TAG, "GNSS status callback permission denied", e);
            }
        }
        
        if (this.mNetworkCheck != null && this.mNetworkCheck.hasNet && !this.isRunning) {
            this.lastLocationTime = this.lastWeatherTime = 0L;
            
            // Check permission for fused location
            if (hasLocationPermission()) {
                fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
                    if (location != null) {
                        Location mLocation = location;
                        if (WeatherManager.this.mCurLocation == null) {
                            if (mLocation != null) {
                                WeatherManager.this.updateLocation(mLocation);
                                WeatherManager.this.isFirst = false;
                            } else {
                                (new Thread(() -> {
                                    boolean flag = true;

                                    while(flag) {
                                        try {
                                            Thread.sleep(500L);
                                        } catch (InterruptedException var3) {
                                            var3.printStackTrace();
                                        }

                                        if (WeatherManager.this.mCurLocation != null || mLocation != null) {
                                            WeatherManager.this.updateLocation(mLocation);
                                            WeatherManager.this.isFirst = false;
                                            flag = false;
                                        }
                                    }

                                })).start();
                            }
                        }
                    }
                }).addOnFailureListener(e -> {
                    e.printStackTrace();
                });
            }

            // Request location updates with permission checks
            if (this.mLocationManager.isProviderEnabled("gps") && hasLocationPermission()) {
                try {
                    this.mLocationManager.requestLocationUpdates("gps", 30000L, (float)this.minDis, this.mGpsListener);
                } catch (SecurityException e) {
                    Log.e(TAG, "GPS location updates permission denied", e);
                }
            }

            if (this.mLocationManager.isProviderEnabled("network") && hasLocationPermission()) {
                try {
                    this.mLocationManager.requestLocationUpdates("network", 30000L, (float)this.minDis, this.mNetListener);
                } catch (SecurityException e) {
                    Log.e(TAG, "Network location updates permission denied", e);
                }
            }

            this.isRunning = true;
        }
    }

    void stop() {
        if (mLocationManager != null) {
            try {
                mLocationManager.unregisterGnssStatusCallback(mListener);
            } catch (Exception e) {
                Log.e(TAG, "Error unregistering GNSS callback", e);
            }
            
            if (this.mLocationManager != null) {
                try {
                    this.mLocationManager.removeUpdates(this.mGpsListener);
                } catch (Exception e) {
                    Log.e(TAG, "Error removing GPS updates", e);
                }
                try {
                    this.mLocationManager.removeUpdates(this.mNetListener);
                } catch (Exception e2) {
                    Log.e(TAG, "Error removing network updates", e2);
                }
            }
        }
        this.isRunning = false;
    }

    public void updateLocation(Location location) {
        Log.d("hzq", "call updateLocation ** location = " + location);
        if (location != null) {
            boolean ischina = this.inChina(location);
            if (this.inChina != ischina) {
                this.inChina = ischina;
                SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
                preferences.edit().putBoolean("inChina", this.inChina).commit();
            }

            final long temptime = SystemClock.elapsedRealtime();
            if (this.mCurLocation == null || this.mCurWeather == null || !this.mCurWeather.vaild() || temptime - this.lastLocationTime > 120000L) {
                this.mCurLocation = location;
                (new AsyncTask<Location, Void, String>() {
                    @Override
                    protected String doInBackground(Location[] params) throws Exception {
                        if (params != null && params.length > 0) {
                            String city = getCityFromCoordinates(params[0].getLatitude(), params[0].getLongitude());
                            return checkCity(city);
                        } else {
                            return null;
                        }
                    }

                    @Override
                    protected void onProgress(Void[] progress) {
                        //
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        if (result != null && !result.isEmpty()) {
                            boolean changed = false;
                            WeatherManager.this.lastLocationTime = SystemClock.elapsedRealtime();
                            if (!result.equals(WeatherManager.this.cityName)) {
                                WeatherManager.this.tmpCity = result;
                                changed = true;
                            }

                            try {
                                if (!changed && !WeatherManager.this.isFirst && WeatherManager.this.mCurWeather != null) {
                                    if (WeatherManager.this.mCurLocation != null && WeatherManager.this.mCurWeather != null && WeatherManager.this.mCurWeather.vaild()) {
                                        if (temptime - WeatherManager.this.lastWeatherTime < 3600000L) {
                                            return;
                                        }

                                        WeatherManager.this.getWeather(WeatherManager.this.mCurLocation.getLatitude(), WeatherManager.this.mCurLocation.getLongitude(), WeatherManager.this.tmpCity);
                                    }
                                } else {
                                    WeatherManager.this.getWeather(WeatherManager.this.mCurLocation.getLatitude(), WeatherManager.this.mCurLocation.getLongitude(), "gogogo");
                                }
                            } catch (Exception var4) {
                            }
                        }

                    }

                    @Override
                    protected void onBackgroundError(Exception e) {
                        e.printStackTrace();
                    }
                }).execute(new Location[]{this.mCurLocation});
            }
        }
    }

    protected boolean isBetterLocation(Location newLocation, Location oldLocation) {
        if (oldLocation == null) {
            return newLocation != null;
        }
        long timeDelta = newLocation.getTime() - oldLocation.getTime();
        if (Math.abs(newLocation.getLatitude() - oldLocation.getLatitude()) >= 0.02d || Math.abs(newLocation.getLongitude() - oldLocation.getLongitude()) >= 0.02d) {
        }
        boolean isRunNewer = timeDelta > 900000;
        boolean isOlder = timeDelta < -900000;
        boolean isNewer = timeDelta > 60000;
        if (isRunNewer) {
            return true;
        }
        if (isOlder) {
            return false;
        }
        int accuracyDelta = (int) (newLocation.getAccuracy() - oldLocation.getAccuracy());
        boolean isLessAccurate = accuracyDelta > 0;
        boolean isMoreAccurate = accuracyDelta < 0;
        boolean isSignificantlyLessAccurate = accuracyDelta > 200;
        boolean isFromSameProvider = isSameProvider(newLocation.getProvider(), oldLocation.getProvider());
        if (isMoreAccurate) {
            return true;
        }
        if (isNewer && !isLessAccurate) {
            return true;
        }
        if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
            return true;
        }
        return false;
    }

    private boolean isSameProvider(String provider1, String provider2) {
        if (provider1 == null) {
            return provider2 == null;
        }
        return provider1.equals(provider2);
    }

    boolean inChina(Location location) {
        double lon = location.getLongitude();
        double lat = location.getLatitude();
        return lon >= 73.33d && lon <= 135.05d && lat >= 3.51d && lat <= 53.33d;
    }

    public String getContentFromUrl(String url) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            int responseCode = response.code();
            Log.i("hzq", " getContentFromUrl: " + url + "  result responseCode :" + responseCode);
            
            if (responseCode != 200) {
                return null;
            }
            
            if (response.body() != null) {
                return response.body().string();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getCityFromCoordinates(double latitude, double longitude) {
        String url = OPEN_WEATHER_GEO_URL + "&lat=" + latitude + "&lon=" + longitude;
        String entry = sendGet(url);
        
        if (entry != null && !entry.isEmpty()) {
            try {
                JSONArray jsonArray = new JSONArray(entry);
                if (jsonArray.length() > 0) {
                    JSONObject location = jsonArray.getJSONObject(0);
                    return location.getString("name");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error parsing city from coordinates", e);
            }
        }
        return null;
    }

    void getWeather(final Double lat, final Double lon, String city) {
        if (!this.isGettingWeather && lat != null && lon != null) {
            this.isGettingWeather = true;
            (new AsyncTask<String, Void, WeatherDescription>() {
                public WeatherDescription doInBackground(String[] params) {
                    if (params != null && params.length > 0) {
                        String url = OPEN_WEATHER_CURRENT_URL + "&lat=" + lat + "&lon=" + lon;
                        Log.d("hzq", "getWeatherNew url = " + url);
                        String entry = WeatherManager.sendGet(url);
                        Log.d("hzq", "call getWeatherNew ** entry = " + entry);
                        if (entry != null && !entry.isEmpty()) {
                            return WeatherDescription.parseOpenWeatherMapData(entry);
                        }
                    }
                    return null;
                }

                @Override
                protected void onProgress(Void[] progress) {
                    //
                }

                @Override
                public void onPostExecute(WeatherDescription result) {
                    WeatherManager.this.isGettingWeather = false;
                    if (result != null && result.vaild()) {
                        WeatherManager.this.cityName = WeatherManager.this.tmpCity;
                        SharedPreferences preferences = WeatherManager.this.mContext.getSharedPreferences(WeatherManager.this.mContext.getPackageName(), 0);
                        preferences.edit().putString("city", WeatherManager.this.cityName).commit();
                        WeatherManager.this.lastWeatherTime = SystemClock.elapsedRealtime();
                        WeatherManager.this.mCurWeather = result;
                        if (WeatherManager.this.weatherListeners != null && WeatherManager.this.weatherListeners.size() > 0) {
                            // collect live listeners while cleaning up cleared refs
                            List<OnWeatherChangedListener> list = new ArrayList<>();
                            synchronized (WeatherManager.this.weatherListeners) {
                                Iterator<WeakReference<OnWeatherChangedListener>> it = WeatherManager.this.weatherListeners.iterator();
                                while (it.hasNext()) {
                                    OnWeatherChangedListener l = it.next().get();
                                    if (l == null) {
                                        it.remove();
                                    } else {
                                        list.add(l);
                                    }
                                }
                            }
                            for (OnWeatherChangedListener listener : list) {
                                try {
                                    listener.onWeatherChanged(WeatherManager.this.mCurWeather);
                                } catch (Exception e) {
                                    Log.e(TAG, "Error notifying listener in getWeather", e);
                                }
                            }
                        }
                    } else {
                        Log.e(TAG, "Failed to get weather data");
                    }
                }

                @Override
                protected void onBackgroundError(Exception e) {
                    WeatherManager.this.isGettingWeather = false;
                    Log.e(TAG, "Background error in getWeatherNew", e);
                }
            }).execute(new String[]{city});
        }
    }

    public static String sendGet(String url) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("Connection", "keep-alive")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                Log.w(TAG, "HTTP error: " + response.code() + " for URL: " + url);
                return null;
            }
            
            if (response.body() != null) {
                return response.body().string();
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Network error: " + url + " - " + e.getMessage());
            return null;
        }
    }

    String checkCity(String city) {
        if (city == null) {
            return null;
        }
        if (city.length() <= 2) {
            return city;
        }
        if (!city.endsWith("市") && !city.endsWith("州") && !city.endsWith("县")) {
            return city;
        }
        String weatherCity = city.substring(0, city.length() - 1);
        return weatherCity;
    }

    public static class RecentWeather {
        SparseArray<DailyWeather> mWeathers = new SparseArray<>();

        public DailyWeather getDailyWeatherAt(int day) {
            if (this.mWeathers == null || this.mWeathers.indexOfKey(day) < 0) {
                return null;
            }
            return this.mWeathers.get(day);
        }

        public void put(int day, DailyWeather weather) {
            if (this.mWeathers == null) {
                this.mWeathers = new SparseArray<>();
            }
            this.mWeathers.put(day, weather);
        }

        public SparseArray<DailyWeather> getAllWeathers() {
            return this.mWeathers;
        }

        public boolean isDataEmpty() {
            return size() <= 0;
        }

        public int size() {
            if (this.mWeathers == null) {
                return 0;
            }
            return this.mWeathers.size();
        }
    }

    public void requestRecentWeathers(String city, final WeatherManager.RecentWeatherListener listener) {
        if (city != null && city.length() != 0) {
            String url = String.format(Locale.US, "http://apk.carsql.com/Weather/WetherMain?name=%s", this.checkCity(city));
            (new AsyncTask<String, DailyWeather, WeatherManager.RecentWeather>() {
                int resultCode = -2;

                @Override
                protected WeatherManager.RecentWeather doInBackground(String[] params) {
                    WeatherManager.RecentWeather recentWeather = null;
                    if (params != null && params.length > 0) {
                        String url = params[0];
                        recentWeather = new WeatherManager.RecentWeather();
                        String entry = WeatherManager.sendGet(url);
                        Log.e("weather", " entry :" + entry);
                        if (entry != null && entry.length() > 0) {
                            try {
                                JSONObject msg = new JSONObject(entry);
                                if (!msg.has("states") && JSONUtils.getInt(msg, "states", -1) != 1) {
                                    this.resultCode = -1;
                                } else {
                                    JSONArray daysjson = JSONUtils.getJSONArray(msg, "dayjson");
                                    if (daysjson != null && daysjson.length() > 0) {
                                        int count = daysjson.length();

                                        for(int index = 0; index < count; ++index) {
                                            JSONObject obj = daysjson.getJSONObject(index);
                                            DailyWeather weather = DailyWeather.getDailyWeather(obj);
                                            if (!weather.isEmpty()) {
                                                recentWeather.put(index, weather);
                                            }
                                        }
                                    }

                                    if (!recentWeather.isDataEmpty()) {
                                        this.resultCode = 1;
                                    }
                                }
                            } catch (JSONException var11) {
                                var11.printStackTrace();
                            }
                        }
                    }

                    return recentWeather;
                }

                @Override
                protected void onProgress(DailyWeather[] progress) {
                    //
                }

                @Override
                protected void onPostExecute(WeatherManager.RecentWeather result) {
                    if (result != null && listener != null) {
                        listener.onResult(this.resultCode, result);
                    }

                }

                @Override
                protected void onBackgroundError(Exception e) {
                    e.printStackTrace();
                }
            }).execute(new String[]{url});
        }
    }

    public WeatherDescription getThisWeather() {
        return this.mCurWeather;
    }

    public void updateWeather() {
        if (!isNetworkAvailable()) {
            Log.w(TAG, "No network available, cannot update weather");
            return;
        }
        
        if (mCurLocation != null) {
            getWeather(
                mCurLocation.getLatitude(), 
                mCurLocation.getLongitude(), 
                tmpCity != null ? tmpCity : cityName
            );
        } else {
            if (mPrefs == null) {
                mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            }    
            double lat = Double.parseDouble(mPrefs.getString("latiude", "52.408165"));
            double longt = Double.parseDouble(mPrefs.getString("longitude", "16.932490"));
            Log.w(TAG, "No location available, using fallback location to update weather");
            getWeather(
                lat, 
                longt, 
                tmpCity != null ? tmpCity : cityName
            );
        }
    }

    public class mThread_readLocalData extends Thread {
        public mThread_readLocalData() {
        }

        @Override
        public void run() {
            ShapeIndex shx = null;
            ByteArrayOutputStream out = null;
            InputStream inputStream_shx = null;
            InputStream inputStream_shp = null;
            
            try {
                AssetManager assetManager = WeatherManager.this.mContext.getResources().getAssets();
                inputStream_shx = assetManager.open("CHN_adm2.shx");
                shx = ShapeReader.readShapeIndex(new DataInputStream(inputStream_shx));
                inputStream_shp = assetManager.open("CHN_adm2.shp");
                out = new ByteArrayOutputStream();

                byte[] buffer = new byte[4096];
                while (true) {
                    int n = inputStream_shp.read(buffer);
                    if (n == -1) {
                        break;
                    } else {
                        out.write(buffer, 0, n);
                    }
                }
                byte[] mBuffer = out.toByteArray();
                ShapeDB.SHAPE_DATA = new ShapeData(mBuffer, shx);
                
            } catch (Exception e) {
                Log.e(TAG, "Error reading local data", e);
                String string = Log.getStackTraceString(e);
                Log.i("hzq", string);
            } finally {
                // Close resources in finally block
                try {
                    if (inputStream_shx != null) {
                        inputStream_shx.close();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error closing shx input stream", e);
                }
                
                try {
                    if (inputStream_shp != null) {
                        inputStream_shp.close();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error closing shp input stream", e);
                }
                
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Error closing output stream", e);
                }
            }
        }
    }

    public void readLocalData() {
        ShapeIndex shx = null;
        ByteArrayOutputStream out = null;
        InputStream inputStream_shx = null;
        InputStream inputStream_shp = null;
        
        try {
            AssetManager assetManager = this.mContext.getResources().getAssets();
            inputStream_shx = assetManager.open("CHN_adm2.shx");
            shx = ShapeReader.readShapeIndex(new DataInputStream(inputStream_shx));
            inputStream_shp = assetManager.open("CHN_adm2.shp");
            out = new ByteArrayOutputStream();

            byte[] buffer = new byte[4096];
            while (true) {
                int n = inputStream_shp.read(buffer);
                if (n == -1) {
                    break;
                } else {
                    out.write(buffer, 0, n);
                }
            }
            byte[] mBuffer = out.toByteArray();
            ShapeDB.SHAPE_DATA = new ShapeData(mBuffer, shx);
            
        } catch (Exception e) {
            Log.e(TAG, "Error reading local data", e);
            String string = Log.getStackTraceString(e);
            Log.i("hzq", string);
        } finally {
            // Close resources in finally block
            try {
                if (inputStream_shx != null) {
                    inputStream_shx.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error closing shx input stream", e);
            }
            
            try {
                if (inputStream_shp != null) {
                    inputStream_shp.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error closing shp input stream", e);
            }
            
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error closing output stream", e);
            }
        }
    }
}