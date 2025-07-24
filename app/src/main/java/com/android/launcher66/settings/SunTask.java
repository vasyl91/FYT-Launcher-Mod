package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.android.async.AsyncTask;
import com.android.launcher66.LauncherApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.text.format.DateUtils;

import androidx.preference.PreferenceManager;

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
    private static final int MAX_RETRIES = 5;
    private static final long INITIAL_DELAY_MS = 0;
    private boolean mOnlyGetTimes;
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

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
        getTimes(url[0]);
        boolean nightMode = mPrefs.getBoolean("night_mode", false); 
        if (nightMode && !mOnlyGetTimes) {
            setWallpapers();
            boolean brightnessBool = mPrefs.getBoolean("brightness", false);
            if (brightnessBool) {
                setBrightness();
            }
            if (notArctic()) {
                scheduleJob(this.mContext, timeToJob);
            }
        }
        return "";
    }

    @Override
    protected void onProgress(Void[] progress) {
        //
    }

    private void getTimes(String url) {        
        if (isConnectionAvailable(this.mContext)) {
            try {
                JSONObject sunInfoObject = readJsonFromUrl(url);
                dayLength = dayStringToLong(Objects.requireNonNull(sunInfoObject).getString("day_length"));
                sunrise = stringToLong(Objects.requireNonNull(sunInfoObject).getString("sunrise"));
                sunset = stringToLong(Objects.requireNonNull(sunInfoObject).getString("sunset"));
                if (isPolarDay()) {
                    helpers.setPolarDay(true);
                } else if (isPerpetualNight()) {
                    helpers.setPerpetualNight(true);
                }
            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        } else {   
            TwilightCalculator sunCalc = new TwilightCalculator(mLatiude, mLongitude);
            if (notArctic()) {
                sunrise = stringToLongCalc(sunCalc.getSunrise());
                sunset = stringToLongCalc(sunCalc.getSunset());
            }
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
        File mFile = new File(this.mContext.getFilesDir(), "wallpaper_img");
        if (mFile.exists() && !defaultWallpapers) {
            if (allowSetDayWallpaper()) {
                File image = new File(mFile, "Day.webp");
                if (isFileValid(image)) {
                    setWallpaperFromFile(image, "Day", 0, INITIAL_DELAY_MS);
                } else {
                    setDefaultWallpapers();
                }
            } else if (allowSetNightWallpaper()) {
                File image = new File(mFile, "Night.webp");
                if (isFileValid(image)) {
                    setWallpaperFromFile(image, "Night", 0, INITIAL_DELAY_MS);
                } else {
                    setDefaultWallpapers();
                }
            }            
        } else {
            setDefaultWallpapers();
        }
    }

    private void setDefaultWallpapers() {
        if (allowSetDayWallpaper()) {
            setDefaultWallpaper("Day");
        } else if (allowSetNightWallpaper()) {
            setDefaultWallpaper("Night");
        }   
    }

    private void setWallpaperFromFile(File imageFile, String name, int retryCount, long delayMs) {
        scheduler.schedule(() -> {
            synchronized (LOCK) {
                try {
                    Bitmap newWallpaperBitmap = decodeBitmapSafely(imageFile);
                    if (newWallpaperBitmap == null) {
                        if (retryCount < MAX_RETRIES) {
                            long nextDelay = (delayMs == 0) ? 2000 : delayMs * 2;
                            setWallpaperFromFile(imageFile, name, retryCount + 1, nextDelay);
                        }
                        return;
                    }
                    SharedPreferences idPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
                    SharedPreferences.Editor idEditor = idPrefs.edit();
                    idEditor.putInt("previousDrawableId", 0);
                    idEditor.apply();
                    setWallpaperIfDifferent(newWallpaperBitmap, name, 0, INITIAL_DELAY_MS);
                } catch (Exception e) {
                    Log.e(TAG, "Error decoding bitmap", e);
                }
            }
        }, delayMs, TimeUnit.MILLISECONDS);
    }

    private void setDefaultWallpaper(String name) {
        SharedPreferences idPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        int previousDrawableId = idPrefs.getInt("previousDrawableId", 0);
        int drawableId = name.equals("Day") ? ResValue.getInstance().def_bg : ResValue.getInstance().def_bg_n;
        if (previousDrawableId != drawableId) {
            try {
                mWallpaperManager.setResource(drawableId);           
                SharedPreferences.Editor idEditor = idPrefs.edit();
                idEditor.putInt("previousDrawableId", drawableId);
                idEditor.apply();
                Log.d(TAG, "Default wallpaper set successfully.");
            } catch (IOException e) {
                Log.e(TAG, "Failed setting the default wallpaper: " + e.getMessage());
            }
        } else {
            Log.d(TAG, "Default wallpaper already set.");
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

    private void setWallpaperIfDifferent(Bitmap newWallpaperBitmap, String name, int retryCount, long delayMs) {
        scheduler.schedule(() -> {
            synchronized (LOCK) {
                try {
                    if (newWallpaperBitmap == null || newWallpaperBitmap.isRecycled()) {
                        throw new IllegalStateException("Invalid bitmap");
                    }

                    if (areBitmapsHashEqual(name)) {
                        Log.d(TAG, "Wallpaper already set.");
                        return;
                    }

                    newWallpaperBitmap.prepareToDraw();
                    mWallpaperManager.setBitmap(newWallpaperBitmap, null, true, WallpaperManager.FLAG_SYSTEM);
                    saveBitmapHash(name);
                    Log.d(TAG, "Wallpaper set successfully.");
                } catch (IOException | IllegalStateException e) {
                    Log.e(TAG, "Retry " + (retryCount + 1) + " failed: " + e.getMessage());
                    if (retryCount < MAX_RETRIES) {
                        long nextDelay = (delayMs == 0) ? 2000 : delayMs * 2; 
                        setWallpaperIfDifferent(newWallpaperBitmap, name, retryCount + 1, nextDelay);
                    }
                }
            }
        }, delayMs, TimeUnit.MILLISECONDS); 
    }

    private boolean areBitmapsHashEqual(String name) {
        String savedWallpaperHash = mPrefs.getString(name + "_hash", "");

        Drawable mWallpaper = mWallpaperManager.getDrawable();
        Bitmap currentWallpaperBitmap = drawableToBitmap(mWallpaper);

        Bitmap normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        normalizedBitmap.compress(getWebPFormat(), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(byteArray);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            String currentWallpaperHash = hexString.toString();
            Log.i("HASH", "CUR: " + currentWallpaperHash + " Saved: " + savedWallpaperHash);
            return savedWallpaperHash.equals(currentWallpaperHash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void saveBitmapHash(String name) {
        Drawable mWallpaper = mWallpaperManager.getDrawable();
        Bitmap currentWallpaperBitmap = drawableToBitmap(mWallpaper);

        Bitmap normalizedBitmap = normalizeBitmap(currentWallpaperBitmap);
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        normalizedBitmap.compress(getWebPFormat(), 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashBytes = digest.digest(byteArray);

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            SharedPreferences hashPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            SharedPreferences.Editor hashEditor = hashPrefs.edit();
            hashEditor.putString(name + "_hash", hexString.toString());
            hashEditor.apply();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("NewApi")
    private Bitmap.CompressFormat getWebPFormat() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            return Bitmap.CompressFormat.WEBP_LOSSLESS;
        } else {
            return Bitmap.CompressFormat.WEBP;
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
    
    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public Bitmap normalizeBitmap(Bitmap bitmap) {
        Bitmap normalizedBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(normalizedBitmap);
        canvas.drawBitmap(bitmap, 0, 0, null);
        return normalizedBitmap;
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
        return new JobInfo.Builder(123, name)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
                    .setMinimumLatency(time)
                    .setRequiresDeviceIdle(false)
                    .setRequiresCharging(false)
                    .setPersisted(false)
                    .build();
    }

    @Override
    protected void onBackgroundError(Exception e) {
        Log.d(TAG, "Background error: " + e.getMessage());
    }

    public static class TwilightCalculator {
        
        private final Helpers helpers = new Helpers();
        
        public TwilightCalculator(double latiude, double longitude) {
            calculateTwilight(latiude, longitude);
        }

        private String dateSunset = "";
        private String dateSunrise = "";

        private static final double DEGREES_TO_RADIANS = Math.PI / 180.0f;

        // element for calculating solar transit.
        private static final double J0 = 0.0009f;

        // correction for civil twilight
        private static final double ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = 0; //ZK for sunset/sunrise remove 6 degree horizon correction -0.104719755f;

        // coefficients for calculating Equation of Center.
        private static final double C1 = 0.0334196f;
        private static final double C2 = 0.000349066f;
        private static final double C3 = 0.000005236f;

        private static final double OBLIQUITY = 0.40927971f;

        // Java time on Jan 1, 2000 12:00 UTC.
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
            // The day or night never ends for the given date and location, if this value is out of
            // range.
            if (cosHourAngle >= 1) {
                helpers.setPerpetualNight(true);
                return;
            } else if (cosHourAngle <= -1) {
                helpers.setPolarDay(true);
                return;
            }

            double hourAngle = (Math.acos(cosHourAngle) / (2 * Math.PI));
            long mSunset = Math.round((solarTransitJ2000 + hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;
            long mSunrise = Math.round((solarTransitJ2000 - hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a", Locale.ENGLISH);
            dateSunrise = Instant.ofEpochMilli(mSunrise).atZone(ZoneId.systemDefault()).format(formatter);
            dateSunset = Instant.ofEpochMilli(mSunset).atZone(ZoneId.systemDefault()).format(formatter);           
        }        
    }
}