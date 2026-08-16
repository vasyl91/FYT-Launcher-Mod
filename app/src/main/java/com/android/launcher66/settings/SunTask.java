package com.android.launcher66.settings;

import android.app.WallpaperManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.Settings;
import android.text.format.DateUtils;
import android.util.Log;

import androidx.preference.PreferenceManager;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import share.ResValue;

public class SunTask extends AsyncTask<String, Void, String> {
    private final Context mContext;
    private final Helpers helpers = new Helpers();
    private final double mLatiude;
    private final double mLongitude;
    private long timeToJob;
    private final WallpaperManager mWallpaperManager;
    private final SharedPreferences mPrefs;
    private final SharedPreferences.Editor editor;
    private final boolean defaultWallpapers;
    private static final String TIME_CONST = "HH:mm:ss";
    private static final String TAG = "SunTask";
    private long sunrise = 0;
    private long sunset = 0;
    private long millisecondOfDay;
    private long dayLength;
    private static final long midnight = 86400000;
    private static  final long arcticDayLong = -3600000;
    private long sunriseCorrectionValue;
    private long sunsetCorrectionValue;
    private static final Object LOCK = new Object();
    private static final String KEY_STATE = "wallpaperState";          // "Day" / "Night"
    private static final String KEY_SOURCE = "wallpaperSource";        // "file" / "default"
    private static final String KEY_SIGNATURE = "wallpaperSignature";  // File hash or resource ID
    private static final String KEY_WALLPAPER_ID = "wallpaperId";      // ID from WallpaperManager
    private static final String SOURCE_FILE = "file";
    private static final String SOURCE_DEFAULT = "default";
    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_DELAY_MS = 0;
    private boolean mOnlyGetTimes;
    public static final int JOB_ID = 123;

    /*
     * One shared thread for all instances. Previously, each instance created its own
     * ScheduledExecutorService, which was shut down only in onCancelled() — under normal
     * task completion, the thread remained alive forever.
     */
    private static final ScheduledExecutorService SCHEDULER =
            Executors.newSingleThreadScheduledExecutor(r -> {
                Thread thread = new Thread(r, "SunTask-wallpaper");
                thread.setDaemon(true);
                return thread;
            });
    private final List<ScheduledFuture<?>> mScheduledTasks =
            Collections.synchronizedList(new ArrayList<>());

    private void schedule(Runnable task, long delayMs) {
        mScheduledTasks.add(SCHEDULER.schedule(task, delayMs, TimeUnit.MILLISECONDS));
    }

    public SunTask(Context context, double latiude, double longitude, boolean onlyGetTimes) {
        this.mContext = context;
        this.mLatiude = latiude;
        this.mLongitude = longitude;
        this.mOnlyGetTimes = onlyGetTimes;
        mWallpaperManager = WallpaperManager.getInstance(context);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        sunriseCorrectionValue = mPrefs.getInt("sunrise_correction", 0) * 60000L;
        sunsetCorrectionValue = mPrefs.getInt("sunset_correction", 0) * 60000L;
        editor = mPrefs.edit();
        defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
    }

    @Override
    protected String doInBackground(String[] url) throws Exception {
        if (isCancelled()) return "";
        getTimes(url[0]);
        if (isCancelled()) return "";
        boolean nightMode = mPrefs.getBoolean("night_mode", false);
        if (nightMode && !mOnlyGetTimes) {
            if (isCancelled()) return "";
            setWallpapers();
            if (isCancelled()) return "";
            boolean brightnessBool = mPrefs.getBoolean("brightness", false);
            if (brightnessBool) {
                setBrightness();
            }
            if (!isCancelled() && notArctic()) {
                scheduleJob(this.mContext, timeToJob);
            }
        }
        return "";
    }

    @Override
    protected void onProgress(Void[] progress) {
        //
    }
    
    @Override
    protected void onCancelled() {
        super.onCancelled();
        // Cancel only this instance's tasks — the shared scheduler remains available for others.
        synchronized (mScheduledTasks) {
            for (ScheduledFuture<?> future : mScheduledTasks) {
                future.cancel(false);
            }
            mScheduledTasks.clear();
        }
        Log.d(TAG, "SunTask cancelled - pending wallpaper tasks dropped");
    }
    
    private void getTimes(String url) {        
        if (isConnectionAvailable(this.mContext)) {
            try {
                JSONObject sunInfoObject = readJsonFromUrl(url);
                if (sunInfoObject == null) {
                    Log.e(TAG, "JSON response is null, using fallback calculation");
                    useFallbackCalculation();
                    return;
                }
                
                dayLength = dayStringToLong(sunInfoObject.getString("day_length"));
                sunrise = stringToLong(sunInfoObject.getString("sunrise"));
                sunset = stringToLong(sunInfoObject.getString("sunset"));
            } catch (IOException | JSONException e) {
                Log.e(TAG, "Error getting times from API", e);
                useFallbackCalculation();
                return;
            }
        } else {   
            useFallbackCalculation();
            return;
        }               
        if (isPolarDay()) {
            helpers.setPolarDay(true);
        } else if (isPerpetualNight()) {
            helpers.setPerpetualNight(true);
        }
        editor.putString("sunrise", longToHourZone(sunrise));
        editor.putString("sunset", longToHourZone(sunset));
        editor.apply();
        sunrise = sunrise + sunriseCorrectionValue;
        sunset = sunset + sunsetCorrectionValue;
        dayOrNight();
    }

    private void useFallbackCalculation() {
        TwilightCalculator sunCalc = new TwilightCalculator(this.mContext, mLatiude, mLongitude);
        if (notArctic()) {
            sunrise = stringToLongCalc(sunCalc.getSunrise());
            sunset = stringToLongCalc(sunCalc.getSunset());
        }               
        if (isPolarDay()) {
            helpers.setPolarDay(true);
        } else if (isPerpetualNight()) {
            helpers.setPerpetualNight(true);
        }
        editor.putString("sunrise", longToHourZone(sunrise));
        editor.putString("sunset", longToHourZone(sunset));
        editor.apply();
        sunrise = sunrise + sunriseCorrectionValue;
        sunset = sunset + sunsetCorrectionValue;
        dayOrNight();
    }

    private void dayOrNight() {
        if (notArctic()) {
            LocalTime currentTime = LocalTime.now();
            millisecondOfDay = currentTime.toSecondOfDay() * 1000L;
            
            if (nightBool()) {
                helpers.setDay(false);
                if (nightBoolPastMidnight()) {
                    timeToJob = sunrise - millisecondOfDay;
                } else if (nightBoolPreMidnight()) {
                    timeToJob = (midnight - millisecondOfDay) + sunrise;
                }           
                Log.i("NIGHT", "Waiting for sunrise at " + longToHourZone(sunrise) + "; Time to job (in ms): " + timeToJob + " (in hours): " + longToHourZone(timeToJob)
                 + "; Current time: " + longToHourZone(millisecondOfDay) + "; Sunset at: " + longToHourZone(sunset) + "; day length (in ms): " + dayLength + " (in hours): " + longToHourZone(dayLength));
            } else if (dayBool()) {
                helpers.setDay(true);
                timeToJob = sunset - millisecondOfDay;
                Log.i("DAY", "waiting for sunset at " + longToHourZone(sunset) + "; Time to job (in ms): " + timeToJob + " (in hours): " + longToHourZone(timeToJob)
                 + "; Current time: " + longToHourZone(millisecondOfDay) + "; Sunrise at: " + longToHourZone(sunrise) + "; day length (in ms): " + dayLength + " (in hours): " + longToHourZone(dayLength));
            }
        }        
    }

    private boolean isPolarDay() {
        long polarDayLong = -3599000;
        return dayLength == arcticDayLong && sunrise == polarDayLong && sunset == polarDayLong;
    }

    private boolean isPerpetualNight() {
        long perpetualNightLong = -3600000;
        return dayLength == arcticDayLong && sunrise == perpetualNightLong && sunset == perpetualNightLong;
    }

    private boolean notArctic() {
        return !helpers.isPerpetualNight() && !helpers.isPolarDay();
    }

    private boolean nightBool() {
        return millisecondOfDay < sunrise || (millisecondOfDay >= sunset && millisecondOfDay <= midnight);
    }

    private boolean nightBoolPastMidnight() {
        return millisecondOfDay < sunrise;
    }

    private boolean nightBoolPreMidnight() {
        return millisecondOfDay > sunset && millisecondOfDay < midnight;
    }

    private boolean dayBool() {
        return millisecondOfDay >= sunrise && millisecondOfDay < sunset;
    }

    private void setWallpapers() {
        String name = allowSetDayWallpaper() ? "Day" : "Night";
        File image = new File(new File(this.mContext.getFilesDir(), "wallpaper_img"), name + ".webp");

        // Use the user's file only if it actually exists and the default has not been forced.
        if (isFileValid(image)) {
            setWallpaperFromFile(image, name, 0, INITIAL_DELAY_MS);
        } else {
            setDefaultWallpaper(name);
        }
    }

    private void setWallpaperFromFile(File imageFile, String name, int retryCount, long delayMs) {
        schedule(() -> {
            synchronized (LOCK) {
                if (isCancelled()) return;

                // The file may have been removed, or the user may have reverted to the default — fallback.
                if (!isFileValid(imageFile)) {
                    Log.d(TAG, "No custom wallpaper for " + name + ", using default");
                    setDefaultWallpaper(name);
                    return;
                }

                String signature = fileSignature(imageFile);
                if (alreadyApplied(name, SOURCE_FILE, signature)) {
                    Log.d(TAG, "Wallpaper already set: " + name);
                    return;
                }

                Bitmap bitmap = decodeBitmapSafely(imageFile);
                if (bitmap == null) {
                    retryOrFallback(imageFile, name, retryCount, delayMs, "decode failed");
                    return;
                }

                try {
                    bitmap.prepareToDraw();
                    int wallpaperId = mWallpaperManager.setBitmap(
                            bitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                    if (wallpaperId == 0) {
                        throw new IOException("setBitmap returned 0");
                    }
                    // Signature calculated from the SOURCE FILE, not from what WallpaperManager returns.
                    rememberApplied(name, SOURCE_FILE, signature, wallpaperId);
                    Log.d(TAG, "Wallpaper set from file: " + name + " (id=" + wallpaperId + ")");
                } catch (IOException | IllegalStateException | IllegalArgumentException e) {
                    retryOrFallback(imageFile, name, retryCount, delayMs, String.valueOf(e.getMessage()));
                } finally {
                    bitmap.recycle();
                }
            }
        }, delayMs);
    }

    private void retryOrFallback(File imageFile, String name, int retryCount, long delayMs, String reason) {
        if (retryCount < MAX_RETRIES) {
            long nextDelay = (delayMs == 0) ? 2000 : delayMs * 2;
            Log.w(TAG, "Retry " + (retryCount + 1) + " for " + name + ": " + reason);
            setWallpaperFromFile(imageFile, name, retryCount + 1, nextDelay);
        } else {
            Log.e(TAG, "Giving up on custom " + name + " (" + reason + "), falling back to default");
            setDefaultWallpaper(name);
        }
    }

    private void setDefaultWallpaper(String name) {
        int drawableId = name.equals("Day") ? ResValue.getInstance().def_bg : ResValue.getInstance().def_bg_n;
        String signature = String.valueOf(drawableId);

        if (alreadyApplied(name, SOURCE_DEFAULT, signature)) {
            Log.d(TAG, "Default wallpaper already set: " + name);
            return;
        }

        try {
            int wallpaperId = mWallpaperManager.setResource(drawableId, WallpaperManager.FLAG_SYSTEM);
            rememberApplied(name, SOURCE_DEFAULT, signature, wallpaperId);
            Log.d(TAG, "Default wallpaper set: " + name + " (id=" + drawableId + ")");
        } catch (IOException e) {
            Log.e(TAG, "Failed setting the default wallpaper: " + e.getMessage());
        }
    }

    /**
     * Skip the update only when EVERYTHING matches: time of day, source,
     * image signature, and the system wallpaper ID. The last condition detects
     * a wallpaper change made outside the launcher and forces the wallpaper to be set again.
     */
    private boolean alreadyApplied(String state, String source, String signature) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        return state.equals(prefs.getString(KEY_STATE, "null"))
                && source.equals(prefs.getString(KEY_SOURCE, "null"))
                && signature.equals(prefs.getString(KEY_SIGNATURE, ""))
                && mWallpaperManager.getWallpaperId(WallpaperManager.FLAG_SYSTEM)
                   == prefs.getInt(KEY_WALLPAPER_ID, -1);
    }

    private void rememberApplied(String state, String source, String signature, int wallpaperId) {
        PreferenceManager.getDefaultSharedPreferences(this.mContext).edit()
                .putString(KEY_STATE, state)
                .putString(KEY_SOURCE, source)
                .putString(KEY_SIGNATURE, signature)
                .putInt(KEY_WALLPAPER_ID, wallpaperId)
                .apply();
    }

    /** MD5 hash of the file contents — changes when the user replaces Day.webp/Night.webp. */
    private String fileSignature(File file) {
        try (InputStream in = new FileInputStream(file)) {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                digest.update(buffer, 0, read);
            }
            StringBuilder hex = new StringBuilder();
            for (byte b : digest.digest()) {
                hex.append(String.format(Locale.US, "%02x", b));
            }
            return hex.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            Log.e(TAG, "Cannot hash " + file.getName() + ", using size/mtime", e);
            return file.length() + "_" + file.lastModified();
        }
    }

    private boolean allowSetDayWallpaper() {
        return helpers.isDay() || helpers.isPolarDay();
    }

    private boolean allowSetNightWallpaper() {
        return !helpers.isDay() || helpers.isPerpetualNight();
    }

    private boolean isFileValid(File file) {
        return file.exists() && file.length() > 0  && !defaultWallpapers;
    }

    private Bitmap decodeBitmapSafely(File image) {
        synchronized (LOCK) {
            if (!isFileValid(image)) return null;
            
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inSampleSize = 2; 
            
            try {
                Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), options);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    return null;
                }
                return bitmap;
            } catch (OutOfMemoryError | Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void setBrightness() {
        final int dayBrightness = mPrefs.getInt("day_seek_bar", 70);
        final int nightBrightness = mPrefs.getInt("night_seek_bar", 0);
        final boolean isDay = helpers.isDay();
        final boolean isPolarDay = helpers.isPolarDay();
        final boolean isPerpetualNight = helpers.isPerpetualNight();

        new Thread(() -> {
            int brightness = 70;
            if (isDay || isPolarDay) {
                brightness = dayBrightness;
            } else if (!isDay || isPerpetualNight) {
                brightness = nightBrightness;
            }
            try {
                Settings.System.putInt(
                    LauncherApplication.sApp.getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS,
                    brightness
                );
            } catch (Exception e) {
                Log.e(TAG, "Error setting brightness", e);
            }
        }).start();
    }
    
    private long stringToLong(String timeStr) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("h:mm:ss a", Locale.ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_CONST);
        LocalTime time = LocalTime.parse(timeStr, parser);
        String formattedTime = time.format(formatter);

        SimpleDateFormat format = new SimpleDateFormat(TIME_CONST, Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date;
        try {
            date = format.parse(formattedTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assert date != null;
        return date.getTime();
    }

    private long stringToLongCalc(String timeStr) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("h:mm:ss a", Locale.ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_CONST);
        LocalTime time = LocalTime.parse(timeStr, parser);
        String formattedTime = time.format(formatter);

        SimpleDateFormat format = new SimpleDateFormat(TIME_CONST, Locale.US);
        // Keep UTC to get correct milliseconds since midnight
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date;
        try {
            date = format.parse(formattedTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assert date != null;
        return date.getTime();
    }

    private long dayStringToLong(String timeStr) {
        SimpleDateFormat format = new SimpleDateFormat(TIME_CONST, Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date;
        try {
            date = format.parse(timeStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assert date != null;
        return date.getTime();
    }

    public String longToHourZone(long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat(TIME_CONST, Locale.US);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }

    public static JSONObject readJsonFromUrl(String urlQueryString) throws IOException, JSONException {
        try (InputStream input = new URL(urlQueryString).openStream()) {
            BufferedReader re = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            String text = read(re);
            return new JSONObject(text).getJSONObject("results");
        } catch (IOException ex) {
            return null;
        }
    }

    public static String read(Reader re) throws IOException {
        StringBuilder str = new StringBuilder(); 
        int temp;
        do {
            temp = re.read(); 
            str.append((char) temp);
        } while (temp != -1);
        return str.toString();
    }

    private boolean isConnectionAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        }
        Network network = connectivityManager.getActiveNetwork();
        if (network == null) {
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) ||
               networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH);
    }

    private void scheduleJob(Context context, long time) {
        final JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        
        final ComponentName name = new ComponentName(context, DayNightMode.class);

        final int result = jobScheduler.schedule(getJobInfo(name, time));

        if (result == JobScheduler.RESULT_SUCCESS) {
            Log.d("JOB", "Scheduled job successfully!");
        }

    }

    private JobInfo getJobInfo(final ComponentName name, long time) {
        return new JobInfo.Builder(JOB_ID, name)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
                    .setMinimumLatency(time)
                    .setRequiresDeviceIdle(false)
                    .setRequiresCharging(false)
                    .setPersisted(false)
                    .build();
    }

    @Override
    protected void onBackgroundError(Exception e) {
        Log.d(TAG, "Background error: " + e);
    }

    public static class TwilightCalculator {
        
        private final Helpers helpers = new Helpers();
        private final Context mContext; // Add context to access timezone info
        
        public TwilightCalculator(Context context, double latiude, double longitude) {
            this.mContext = context; // Store context
            calculateTwilight(latiude, longitude);
        }

        private String dateSunset = "";
        private String dateSunrise = "";

        private static final double DEGREES_TO_RADIANS = Math.PI / 180.0f;
        private static final double J0 = 0.0009f;
        private static final double ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = 0;
        private static final double C1 = 0.0334196f;
        private static final double C2 = 0.000349066f;
        private static final double C3 = 0.000005236f;
        private static final double OBLIQUITY = 0.40927971f;
        private static final long UTC_2000 = 946728000000L;

        public String getSunrise() {
            return dateSunrise;
        }

        public String getSunset() {
            return dateSunset;
        }

        /**
         * calculates the civil twilight bases on time and geo-coordinates.
         *
         * @param latiude latitude in degrees.
         * @param longitude latitude in degrees.
         */
        public void calculateTwilight(double latiude, double longitude) {
            long time = System.currentTimeMillis();
            final double daysSince2000 = (double) (time - UTC_2000) / DateUtils.DAY_IN_MILLIS;

            // mean anomaly
            final double meanAnomaly = 6.240059968f + daysSince2000 * 0.01720197f;

            // true anomaly
            final double trueAnomaly = meanAnomaly + C1 * Math.sin(meanAnomaly) + C2
                    * Math.sin(2 * meanAnomaly) + C3 * Math.sin(3 * meanAnomaly);

            // ecliptic longitude
            final double solarLng = trueAnomaly + 1.796593063f + Math.PI;

            // solar transit in days since 2000
            final double arcLongitude = -longitude / 360;
            double n = Math.round(daysSince2000 - J0 - arcLongitude);
            double solarTransitJ2000 = n + J0 + arcLongitude + 0.0053f * Math.sin(meanAnomaly)
                    + -0.0069f * Math.sin(2 * solarLng);

            // declination of sun
            double solarDec = Math.asin(Math.sin(solarLng) * Math.sin(OBLIQUITY));

            final double latRad = latiude * DEGREES_TO_RADIANS;

            double cosHourAngle = (Math.sin(ALTIDUTE_CORRECTION_CIVIL_TWILIGHT) - Math.sin(latRad)
                    * Math.sin(solarDec)) / (Math.cos(latRad) * Math.cos(solarDec));
            
            // The day or night never ends for the given date and location, if this value is out of range.
            if (cosHourAngle >= 1) {
                helpers.setPerpetualNight(true);
                return;
            } else if (cosHourAngle <= -1) {
                helpers.setPolarDay(true);
                return;
            }

            double hourAngle = (Math.acos(cosHourAngle) / (2 * Math.PI));
            
            // Calculate sunrise and sunset in UTC
            long sunsetUtc = Math.round((solarTransitJ2000 + hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;
            long sunriseUtc = Math.round((solarTransitJ2000 - hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;
            
            // Convert to local time with DST consideration
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.ENGLISH);
            
            // Use system default timezone which automatically handles DST
            ZoneId systemZone = ZoneId.systemDefault();
            
            dateSunrise = Instant.ofEpochMilli(sunriseUtc)
                    .atZone(systemZone)
                    .format(formatter);
            dateSunset = Instant.ofEpochMilli(sunsetUtc)
                    .atZone(systemZone)
                    .format(formatter);
            
            Log.d("TwilightCalculator", "Latiude: " + String.valueOf(latiude) + ", Longitude: " + String.valueOf(longitude));
            Log.d("TwilightCalculator", "Sunrise (UTC): " + Instant.ofEpochMilli(sunriseUtc) +
                  " -> Local: " + dateSunrise);
            Log.d("TwilightCalculator", "Sunset (UTC): " + Instant.ofEpochMilli(sunsetUtc) + 
                  " -> Local: " + dateSunset);
        }  
    }
}
