package com.android.launcher66.settings;

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
import android.os.Environment;
import android.provider.Settings;
import android.util.Log;

import com.android.async.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import android.text.format.DateUtils;

import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import share.ResValue;

public class SunTask extends AsyncTask<String, Void, String> {
    private final Context mContext;
    private final double mLatiude;
    private final double mLongitude;
    private long timeToJob;
    private final WallpaperManager mWallpaperManager;
    private final SharedPreferences mPrefs;
    private final SharedPreferences.Editor editor;
    private final boolean defaultWallpapers;
    private static final String LAST_WALLPAPER = "last_wallpaper";
    private static final String WALLPAPER_DAY = "wallpaper_day";
    private static final String WALLPAPER_NIGHT = "wallpaper_night";
    private static final String TIME_CONST = "HH:mm:ss";
    private long sunrise = 0;
    private long sunset = 0;
    private long millisecondOfDay;
    private long dayLength;
    private static final long midnight = 86400000;
    private static  final long arcticDayLong = -3600000;

    public SunTask(Context context, double latiude, double longitude) {
        this.mContext = context;
        this.mLatiude = latiude;
        this.mLongitude = longitude;
        mWallpaperManager = WallpaperManager.getInstance(context);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this.mContext);
        editor = mPrefs.edit();
        defaultWallpapers = mPrefs.getBoolean("default_wallpapers", true); 
    }

    @Override
    protected String doInBackground(String url) throws Exception {
        getTimes(url);
        boolean nightMode = mPrefs.getBoolean("night_mode", false); 
        if (nightMode) {
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

    private void getTimes(String url) {        
        if (isConnectionAvailable(this.mContext)) {
            try {
                JSONObject sunInfoObject = readJsonFromUrl(url);
                dayLength = dayStringToLong(Objects.requireNonNull(sunInfoObject).getString("day_length"));
                sunrise = stringToLong(Objects.requireNonNull(sunInfoObject).getString("sunrise"));
                sunset = stringToLong(Objects.requireNonNull(sunInfoObject).getString("sunset"));
                if (isPolarDay()) {
                    Helpers.polarDay = true;
                } else if (isPerpetualNight()) {
                    Helpers.perpetualNight = true;
                }
            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        } else {   
            TwilightCalculator sunCalc = new TwilightCalculator(mLatiude, mLongitude);
            if (notArctic()) {
                sunrise = stringToLong(sunCalc.getSunrise());
                sunset = stringToLong(sunCalc.getSunset());
            }
        }
        dayOrNight();
    }

    private void dayOrNight() {
        if (notArctic()) {
            editor.putString("sunrise", longToHour(sunrise));
            editor.putString("sunset", longToHour(sunset));
            editor.apply();
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            millisecondOfDay = 
                TimeUnit.HOURS.toMillis(cal.get(Calendar.HOUR_OF_DAY)) +
                TimeUnit.MINUTES.toMillis(cal.get(Calendar.MINUTE)) +
                TimeUnit.SECONDS.toMillis(cal.get(Calendar.SECOND)) +
                cal.get(Calendar.MILLISECOND);
            if (nightBool()) {
                Helpers.isDay = false;
                if (nightBoolPastMidnight()) {
                    timeToJob = sunrise - millisecondOfDay;
                } else if (nightBoolPreMidnight()) {
                    timeToJob = (midnight - millisecondOfDay) + sunrise;
                }             
                Log.i("NIGHT", "waiting for sunrise at " + longToHour(sunrise) + " time to job: (ms)"+ timeToJob + " (hours)" + longToHourZone(timeToJob)
                 + " Current time: " + longToHour(millisecondOfDay) + " Sunset at: " + longToHour(sunset));
            } else if (dayBool()) {
                Helpers.isDay = true;
                timeToJob = sunset - millisecondOfDay;
                Log.i("DAY", "waiting for sunset at " + longToHour(sunset) + " time to job: (ms)"+ timeToJob + " (hours)" + longToHourZone(timeToJob)
                 + " Current time: " + longToHour(millisecondOfDay) + " Sunrise at: " + longToHour(sunrise));
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
        return !Helpers.perpetualNight && !Helpers.polarDay;
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
        try {
            File mFile = new File(Environment.getExternalStorageDirectory() + File.separator + "Launcher_drawable");
            String lastWallpaper = mPrefs.getString(LAST_WALLPAPER, "");
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            if (allowSetDayWallpaper(mFile, lastWallpaper)) {
                File image = new File(mFile, WALLPAPER_DAY + ".png");
                if (allowSetWallpaperFromFile(image)) {
                    Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
                    mWallpaperManager.setBitmap(bitmap);                    
                } else {
                    Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(this.mContext, ResValue.getInstance().def_bg)));
                    mWallpaperManager.setBitmap(bitmapDrawable);  
                }
                editor.putString(LAST_WALLPAPER, WALLPAPER_DAY);
                editor.apply();
            } else if (allowSetNightWallpaper(mFile, lastWallpaper)) {
                File image = new File(mFile, WALLPAPER_NIGHT + ".png");
                if (allowSetWallpaperFromFile(image)) {
                    Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmOptions);
                    mWallpaperManager.setBitmap(bitmap);                    
                } else {
                    Bitmap bitmapDrawable = drawableToBitmap(Objects.requireNonNull(ContextCompat.getDrawable(this.mContext, ResValue.getInstance().def_bg_n)));
                    mWallpaperManager.setBitmap(bitmapDrawable);  
                }
                editor.putString(LAST_WALLPAPER, WALLPAPER_NIGHT);
                editor.apply();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean allowSetDayWallpaper(File mFile, String lastWallpaper) {
        return mFile.exists() && (!lastWallpaper.equals(WALLPAPER_DAY) && Helpers.isDay || defaultWallpapers  && Helpers.isDay || Helpers.polarDay);
    }

    private boolean allowSetNightWallpaper(File mFile, String lastWallpaper) {
        return mFile.exists() && (!lastWallpaper.equals(WALLPAPER_NIGHT) && !Helpers.isDay || defaultWallpapers  && !Helpers.isDay || Helpers.perpetualNight);
    }

    private boolean allowSetWallpaperFromFile(File image) {
        return image.exists() && !defaultWallpapers;
    }

    public void setBrightness() { 
        int brightness = 70;
        if (Helpers.isDay || Helpers.polarDay) {
            brightness = mPrefs.getInt("day_seek_bar", 70);    
        } else if (!Helpers.isDay || Helpers.perpetualNight) {
            brightness = mPrefs.getInt("night_seek_bar", 0);
        }
        Settings.System.putInt(this.mContext.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, brightness);
    }

    public Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private long stringToLong(String timeStr) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("h:mm:ss a", Locale.ENGLISH);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(TIME_CONST);
        LocalTime time = LocalTime.parse(timeStr, parser);
        String formattedTime = time.format(formatter);

        SimpleDateFormat format = new SimpleDateFormat(TIME_CONST);
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
        SimpleDateFormat format = new SimpleDateFormat(TIME_CONST);
        Date date;
        try {
            date = format.parse(timeStr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        assert date != null;
        return date.getTime();
    }

    public String longToHour(long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat(TIME_CONST);
        return formatter.format(date);
    }

    public String longToHourZone(long time) {
        Date date = new Date(time);
        DateFormat formatter = new SimpleDateFormat(TIME_CONST);
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

        // The JobService that we want to run
        final ComponentName name = new ComponentName(context, DayNightMode.class);

        // Schedule the job
        final int result = jobScheduler.schedule(getJobInfo(name, time));

        // If successfully scheduled, log this thing
        if (result == JobScheduler.RESULT_SUCCESS) {
            Helpers.onCreateJobInit = false; 
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
    protected String doInBackground(String[] input) throws Exception {
        return "";
    }

    @Override
    protected void onBackgroundError(Exception e) {
        //
    }

    public static class TwilightCalculator {

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
                Helpers.perpetualNight = true;
                return;
            } else if (cosHourAngle <= -1) {
                Helpers.polarDay = true;
                return;
            }

            double hourAngle = (Math.acos(cosHourAngle) / (2 * Math.PI));
            long mSunset = Math.round((solarTransitJ2000 + hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;
            long mSunrise = Math.round((solarTransitJ2000 - hourAngle) * DateUtils.DAY_IN_MILLIS) + UTC_2000;

            DateFormat date = new SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH);
            date.setTimeZone(TimeZone.getTimeZone("UTC"));
            dateSunrise = date.format(new Date(mSunrise));  
            dateSunset = date.format(new Date(mSunset));            
        }        
    }
}