package com.syu.weather;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherManager {
    private static final String TAG = "WeatherManager";
    public static final String OPEN_WEATHER_APPID = "4a87b2f097e39a2cb9c75916073e75a7";
    public static final String OPEN_WEATHER_CURRENT_URL = "https://api.openweathermap.org/data/2.5/weather?appid=" + OPEN_WEATHER_APPID + "&units=metric";

    /**
     * When the weather is fetched again: once the car is this far from where the last one was
     * fetched (at 100 km/h about every 3 min), otherwise once it is this old. Nothing polls for it:
     * the distance is checked in the location callback the GPS delivers anyway, and the age by one
     * timer the launcher sets to the exact moment it runs out.
     */
    private static final float REFRESH_DISTANCE_M = 5000f;
    private static final long REFRESH_INTERVAL_MS = 10 * 60 * 1000L;
    /** A failed fetch is retried after 10 s, then 20 s, 40 s ... up to 5 min. */
    private static final long RETRY_MIN_MS = 10_000L;
    private static final long RETRY_MAX_MS = 5 * 60 * 1000L;
    /** The fallback position in the prefs (NightModeService reads it too) is rewritten after this much movement. */
    private static final float SAVE_DISTANCE_M = 1000f;

    /**
     * Whether anything shows the weather right now (the launcher between onPostResume and onStop).
     * Location updates keep coming while it is in the background, but they do not fetch then; the
     * launcher checks what is due when it comes back.
     */
    private static volatile boolean sForeground = false;

    /** One client for every request, so connections (and the TLS session) are reused. */
    private static volatile OkHttpClient sHttpClient;

    private boolean locationPermissionRequested = false;
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
    long lastWeatherTime = 0;
    int minDis = 3;

    // Main thread only: written by getWeather() and the location callbacks, read by refreshIfDue().
    private double mLastFetchLat = Double.NaN;
    private double mLastFetchLon = Double.NaN;
    private double mLastSavedLat = Double.NaN;
    private double mLastSavedLon = Double.NaN;
    private long mRetryDelayMs = 0L;
    private long mNextAttemptAt = 0L;

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
                    WeatherManager.this.updateLocation(location);
                }
            }
        }
    };
    
    public mThread_readLocalData mThread_readLocalData = new mThread_readLocalData();

    public interface OnWeatherChangedListener {
        void onWeatherChanged(WeatherDescription weatherDescription);
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
                    // Not a fetch on every reconnect: on the road the mobile data comes and goes.
                    // A failed attempt is retried at once, though -- the connection it lacked is back.
                    WeatherManager.this.mNextAttemptAt = 0L;
                    WeatherManager.this.refreshIfDue("network back");
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
            // The launcher can be missing (not created yet / destroyed). Asking once per process is
            // enough: start() runs on every network change and would re-open the dialog each time.
            Launcher launcher = Launcher.getLauncher();
            if (launcher != null && !locationPermissionRequested) {
                locationPermissionRequested = true;
                ActivityCompat.requestPermissions(
                        launcher,
                        new String[]{
                                android.Manifest.permission.ACCESS_FINE_LOCATION,
                                android.Manifest.permission.ACCESS_COARSE_LOCATION
                        },
                        0
                );
            }
            return;
        }

        if (this.mNetworkCheck != null && this.mNetworkCheck.hasNet && !this.isRunning) {
            // Check permission for fused location
            if (hasLocationPermission()) {
                fusedLocationClient.getLastLocation().addOnSuccessListener(location -> {
                    if (location != null) {
                        if (WeatherManager.this.mCurLocation == null) {
                            WeatherManager.this.updateLocation(location);
                        }
                    }
                }).addOnFailureListener(e -> {
                    e.printStackTrace();
                });
            }

            this.isRunning = true;
            updateGpsRequest();
        }
    }

    /*
     * GPS only while the launcher shows the weather (sForeground): it used to stay on for the whole
     * drive, also behind a full-screen app and with the weather off screen, a fix every 30 s for
     * nothing. A fix from before the launcher came back is still asked for: getLastLocation() in
     * start() and the first fix after the request. The "network" provider was requested as well,
     * with a listener that ignored every location -- dropped.
     */
    private boolean mGpsRequested = false;

    /** Main thread. Requests or removes the GPS updates to match isRunning and sForeground. */
    @SuppressLint("MissingPermission")
    void updateGpsRequest() {
        if (mLocationManager == null) {
            return;
        }
        boolean wanted = isRunning && sForeground && hasLocationPermission();
        if (wanted == mGpsRequested) {
            return;
        }
        if (wanted) {
            try {
                if (!mLocationManager.isProviderEnabled("gps")) {
                    return;
                }
                mLocationManager.requestLocationUpdates("gps", 30000L, (float) this.minDis,
                        this.mGpsListener, android.os.Looper.getMainLooper());
                mGpsRequested = true;
            } catch (SecurityException e) {
                Log.e(TAG, "GPS location updates permission denied", e);
            } catch (RuntimeException e) {
                Log.w(TAG, "GPS location updates not available: " + e);
            }
        } else {
            try {
                mLocationManager.removeUpdates(this.mGpsListener);
            } catch (RuntimeException e) {
                Log.w(TAG, "Removing the GPS updates failed: " + e);
            }
            mGpsRequested = false;
        }
    }

    void stop() {
        this.isRunning = false;
        updateGpsRequest();
    }

    /**
     * A new position. Costs a few multiplications per GPS fix; the network is used only when the
     * car has moved REFRESH_DISTANCE_M since the last fetch (or there is no weather yet).
     *
     * This used to send every fix older than two minutes to the reverse geocoding API first, only
     * to compare the city name -- one request every two minutes while driving, for a name nothing
     * displays (the bar shows the city from the weather answer itself).
     */
    public void updateLocation(Location location) {
        if (location == null) {
            return;
        }
        boolean ischina = this.inChina(location);
        if (this.inChina != ischina) {
            this.inChina = ischina;
            SharedPreferences preferences = this.mContext.getSharedPreferences(this.mContext.getPackageName(), 0);
            preferences.edit().putBoolean("inChina", this.inChina).apply();
        }
        this.mCurLocation = location;
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        saveFallbackLocationIfMoved(lat, lon);

        if (!sForeground || this.isGettingWeather || SystemClock.elapsedRealtime() < mNextAttemptAt) {
            return;
        }
        String reason = null;
        if (!hasValidWeather()) {
            reason = "first position";
        } else if (distanceMeters(mLastFetchLat, mLastFetchLon, lat, lon) >= REFRESH_DISTANCE_M) {
            reason = "moved " + Math.round(distanceMeters(mLastFetchLat, mLastFetchLon, lat, lon) / 100f) / 10f + " km";
        }
        if (reason != null && isNetworkAvailable()) {
            Log.d(TAG, "Weather refresh: " + reason);
            getWeather(lat, lon, this.tmpCity);
        }
    }

    /**
     * Called by the launcher whenever it shows the weather (back home, bar rebuilt, wake). Fetches
     * only when something is due, and tells the caller when to ask again.
     *
     * @return ms until the next time-based check is useful
     */
    public long refreshIfDue(String source) {
        if (!sForeground) {
            // Nothing shows it; the launcher asks again from onPostResume().
            return REFRESH_INTERVAL_MS;
        }
        long now = SystemClock.elapsedRealtime();
        if (now < mNextAttemptAt) {
            return mNextAttemptAt - now;
        }
        if (this.isGettingWeather) {
            return RETRY_MIN_MS;
        }

        double lat;
        double lon;
        boolean fallback = false;
        if (mCurLocation != null) {
            lat = mCurLocation.getLatitude();
            lon = mCurLocation.getLongitude();
        } else {
            double[] saved = readFallbackLocation();
            if (saved == null) {
                // No position at all: the first fix fetches from updateLocation().
                return REFRESH_INTERVAL_MS;
            }
            lat = saved[0];
            lon = saved[1];
            fallback = true;
        }

        String reason = null;
        if (!hasValidWeather()) {
            reason = "no weather yet";
        } else if (now - lastWeatherTime >= REFRESH_INTERVAL_MS) {
            reason = "older than " + (REFRESH_INTERVAL_MS / 60000L) + " min";
        } else if (distanceMeters(mLastFetchLat, mLastFetchLon, lat, lon) >= REFRESH_DISTANCE_M) {
            reason = "moved";
        }
        if (reason == null) {
            return nextCheckDelay(now);
        }
        if (!isNetworkAvailable()) {
            // The network callback asks again once it is back.
            return REFRESH_INTERVAL_MS;
        }
        Log.d(TAG, "Weather refresh (" + source + "): " + reason
                + (fallback ? ", using the saved position (no fix yet)" : ""));
        getWeather(lat, lon, this.tmpCity);
        return RETRY_MIN_MS;
    }

    /** Shows the weather on screen (called from onPostResume) or not (onStop). */
    public static void setForeground(boolean foreground) {
        sForeground = foreground;
        WeatherManager manager = instance;
        if (manager != null) {
            manager.updateGpsRequest();
        }
    }

    private long nextCheckDelay(long now) {
        if (now < mNextAttemptAt) {
            return mNextAttemptAt - now;
        }
        if (!hasValidWeather()) {
            return RETRY_MIN_MS;
        }
        return Math.max(1000L, lastWeatherTime + REFRESH_INTERVAL_MS - now);
    }

    private boolean hasValidWeather() {
        return mCurWeather != null && mCurWeather.vaild() && !Double.isNaN(mLastFetchLat);
    }

    @Nullable
    private double[] readFallbackLocation() {
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        String latStr = mPrefs.getString("latiude", null);
        String lngStr = mPrefs.getString("longitude", null);
        if (latStr == null || lngStr == null) {
            return null;
        }
        try {
            return new double[]{Double.parseDouble(latStr), Double.parseDouble(lngStr)};
        } catch (NumberFormatException e) {
            Log.w(TAG, "Saved position is not a number: " + latStr + ", " + lngStr);
            return null;
        }
    }

    /**
     * The saved position is the fallback for the next start and NightModeService's sunrise/sunset
     * position. It was rewritten on every GPS fix (every 30 s); a kilometre is precise enough for both.
     */
    private void saveFallbackLocationIfMoved(double lat, double lon) {
        if (!Double.isNaN(mLastSavedLat)
                && distanceMeters(mLastSavedLat, mLastSavedLon, lat, lon) < SAVE_DISTANCE_M) {
            return;
        }
        mLastSavedLat = lat;
        mLastSavedLon = lon;
        if (mPrefs == null) {
            mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
        }
        mPrefs.edit()
                .putString("latiude", String.valueOf(lat))
                .putString("longitude", String.valueOf(lon))
                .apply();
    }

    /** Equirectangular approximation: off by a few metres at most at these ranges. */
    static float distanceMeters(double lat1, double lon1, double lat2, double lon2) {
        if (Double.isNaN(lat1) || Double.isNaN(lat2)) {
            return Float.MAX_VALUE;
        }
        double x = Math.toRadians(lon2 - lon1) * Math.cos(Math.toRadians((lat1 + lat2) * 0.5));
        double y = Math.toRadians(lat2 - lat1);
        return (float) (Math.sqrt(x * x + y * y) * 6371000.0);
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
                        WeatherManager.this.lastWeatherTime = SystemClock.elapsedRealtime();
                        WeatherManager.this.mLastFetchLat = lat;
                        WeatherManager.this.mLastFetchLon = lon;
                        WeatherManager.this.mRetryDelayMs = 0L;
                        WeatherManager.this.mNextAttemptAt = 0L;
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
                        WeatherManager.this.scheduleRetryAfterFailure();
                    }
                }

                @Override
                protected void onBackgroundError(Exception e) {
                    WeatherManager.this.isGettingWeather = false;
                    Log.e(TAG, "Background error in getWeatherNew", e);
                    WeatherManager.this.scheduleRetryAfterFailure();
                }
            }).execute(new String[]{city});
        }
    }

    private void scheduleRetryAfterFailure() {
        mRetryDelayMs = mRetryDelayMs <= 0L ? RETRY_MIN_MS : Math.min(mRetryDelayMs * 2L, RETRY_MAX_MS);
        mNextAttemptAt = SystemClock.elapsedRealtime() + mRetryDelayMs;
        Log.d(TAG, "Weather fetch failed, next attempt in " + (mRetryDelayMs / 1000L) + " s");
    }

    private static OkHttpClient httpClient() {
        OkHttpClient client = sHttpClient;
        if (client == null) {
            synchronized (WeatherManager.class) {
                client = sHttpClient;
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build();
                    sHttpClient = client;
                }
            }
        }
        return client;
    }

    public static String sendGet(String url) {
        // A new client per request also meant a new connection pool and dispatcher threads,
        // and a fresh TLS handshake every time.
        OkHttpClient client = httpClient();

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

    public WeatherDescription getThisWeather() {
        return this.mCurWeather;
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