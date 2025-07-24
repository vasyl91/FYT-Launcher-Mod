package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.LauncherApplication;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.time.ZoneId;
import java.util.concurrent.Executor;

public class SettingsActivity extends AppCompatActivity {

    // Settings main activity 

    private SharedPreferences sharedPrefs;
    private SunTask mSunTask;
    private static final String TAG = "SettingsActivity";
    private static final String USER_LAYOUT = "user_layout";
    private static final String USER_INIT_LAYOUT = "user_init_layout";
    static final String SYSTEM_DIALOG_REASON_KEY = "reason";
    static final String SYSTEM_DIALOG_REASON_HOME_KEY = "homekey";
    private final Helpers helpers = new Helpers(); 
    private boolean isReceiverRegistered = false;    

    public static int orientationDimension;
    public static int orientedWidth;
    public static int calculatedStatsWidth;
    public static int calculatedStatsHeight;
    public static int calculatedMapMinHeight;
    public static int calculatedMapMinWidth;
    public static int calculatedDateMinHeight; 
    public static int calculatedDateMinWidth;
    public static int calculatedMusicMinHeight;
    public static int calculatedMusicMinWidth;
    public static int calculatedRadioMinHeight;
    public static int calculatedRadioMinWidth;
    public static int statusBarHeight;
    public static int screenWidth;
    public static int screenHeight;
    public static int arrowLongDim;
    public static int arrowShortDim;
    public static int arrowTextSize;
    public static int selectionTextSize;
    public static int confirmTextSize;
    public static int barHeight;
    public static int progressWidth;
    public static int progressHeight;
    public static int nestedPaddingStart;
    public static int nestedPaddingEnd;
    public static int dialogTitle;
    public static int dialogTextView;
    public static int dialogMargin;
    public static int dialogPadding;
    public static int adaptiveCoordinatesSize;
    public static int adaptiveNameTextSize;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         *  Update the sunrise and sunset times if the night mode feature is disabled.
         *  This prevents an error related to empty strings and gives more accurate results if the function 
         *  had been used at least once and then wasn't used for longer time.
        */
        sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        boolean nightMode = sharedPrefs.getBoolean("night_mode", false); 
        if (!nightMode) {
            getSunriseAndSunsetTimes();
        }
        
        try {
            startWatch();
        } catch (Exception e) {
            Log.e(TAG, "Error starting watch", e);
        }

        calculateLayoutDimensions();

        // determine class likely containing canbus codes
        SharedPreferences mPrefs = getSharedPreferences("HelpersPrefs", Context.MODE_PRIVATE);
        String can = mPrefs.getString("canbus_class", "empty");
        if (can.equals("empty")) {
            new CanbusClasses().execute();
        }
        helpers.setSettingsOpenedBoolean(true);
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragmentFirst()).commit();       
    }   

    private void calculateLayoutDimensions() {
        statusBarHeight = getStatusBarHeight();
        screenWidth = getResources().getDisplayMetrics().widthPixels; 
        screenHeight = getResources().getDisplayMetrics().heightPixels; 

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            orientationDimension = screenHeight;
            orientedWidth = screenWidth;
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientationDimension = screenWidth - getStatusBarHeight();
            orientedWidth = screenHeight + getStatusBarHeight();
        } 

        calculatedStatsWidth = calculateDimension(orientationDimension, 21.75);
        calculatedStatsHeight = calculateDimension(orientationDimension, 5.0);
        calculatedMapMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedMapMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedDateMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedDateMinWidth = calculateDimension(orientedWidth, 44.0);
        calculatedMusicMinHeight = calculateDimension(orientationDimension, 18.0);
        calculatedMusicMinWidth = calculateDimension(orientedWidth, 25.1);
        calculatedRadioMinHeight = calculateDimension(orientationDimension, 7.2);
        calculatedRadioMinWidth = calculateDimension(orientedWidth, 25.1);    
        
        arrowLongDim = calculateDimension(orientationDimension, 8.5);
        arrowShortDim = calculateDimension(orientationDimension, 3.5);
        arrowTextSize = calculateAdaptiveTextSize(screenWidth, 14);
        
        selectionTextSize = calculateAdaptiveTextSize(screenWidth, 20);
        confirmTextSize = calculateAdaptiveTextSize(screenWidth, 22);

        barHeight = calculateDimension(orientationDimension, 9.0);

        progressWidth = calculateDimension(orientationDimension, 35.0);
        progressHeight = calculateDimension(orientationDimension, 13.75);

        nestedPaddingStart = calculateDimension(orientationDimension, 6.5);
        nestedPaddingEnd = calculateDimension(orientationDimension, 0.8);

        dialogTitle = calculateAdaptiveTextSize(screenWidth, 20);
        dialogTextView = calculateAdaptiveTextSize(screenWidth, 16);
        dialogMargin = calculateDimension(orientationDimension, 0.95);
        dialogPadding = calculateDimension(orientationDimension, 0.9);

        adaptiveCoordinatesSize = calculateAdaptiveTextSize(orientationDimension, 50);
        adaptiveNameTextSize = calculateAdaptiveTextSize(orientationDimension, 40);
    }

    public int calculateDimension(int dimension, double percentage) {
        if (dimension <= 0 || percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid input: dimension must be positive, and percentage must be between 0 and 100.");
        }
        double result = (percentage / 100.0) * dimension;
        return (int) result;
    }

    public int calculateAdaptiveTextSize(int screenWidth, double baseSize) {
        if (screenWidth <= 0 || baseSize <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        double ratio = screenWidth / 2000.0;
        double scaleFactor = Math.pow(ratio, 0.5); 
        
        return (int) (baseSize * scaleFactor);
    }

    public int getStatusBarHeight() { 
          int result = 0;
          int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
          if (resourceId > 0) {
              result = getResources().getDimensionPixelSize(resourceId);
          } 
          return result;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void startWatch() {
        if (mReceiver != null && !isReceiverRegistered) {
            IntentFilter mFilter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    registerReceiver(mReceiver, mFilter, Context.RECEIVER_EXPORTED);
                } else {
                    registerReceiver(mReceiver, mFilter);
                }
                isReceiverRegistered = true; 
            } catch (Exception e) {
                Log.e(TAG, "Error registering receiver", e);
            }
        }
    }

    public void stopWatch() {
        if (isReceiverRegistered && mReceiver != null) {
            try {
                unregisterReceiver(mReceiver);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Receiver not registered", e);
            }
            isReceiverRegistered = false; 
        }
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override 
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
                String reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY);
                if (SYSTEM_DIALOG_REASON_HOME_KEY.equals(reason)) {
                    stopWatch();
                    Log.i("Home Receiver", "home clicked"); 
                    helpers.setBackFromCreator(false);
                    boolean initLayout = sharedPrefs.getBoolean(USER_INIT_LAYOUT, false);
                    boolean userLayoutBool = sharedPrefs.getBoolean(USER_LAYOUT, false);
                    if (initLayout != userLayoutBool) {
                        helpers.setLayoutTypeChanged(true);
                    }
                    boolean leftBar = sharedPrefs.getBoolean("left_bar", false);
                    if (leftBar) {
                        if (helpers.hasLeftBarChanged()) {
                            helpers.resetPrefs();
                        }  
                    }
                    new VersionChecker().cancelDownload();
                    setBrightness();
                    Intent intentUpdateUserPage = new Intent("update.user.page");
                    LauncherApplication.sApp.sendBroadcast(intentUpdateUserPage);
                }
            }
        }
    };


    private void getSunriseAndSunsetTimes() {
        if (ActivityCompat.checkSelfPermission(LauncherApplication.sApp, 
                android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(LauncherApplication.sApp, 
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            FusedLocationProviderClient fusedLocationClient = 
                LocationServices.getFusedLocationProviderClient(LauncherApplication.sApp);
            Executor executor = ContextCompat.getMainExecutor(LauncherApplication.sApp);
            
            fusedLocationClient.getLastLocation()
                .addOnSuccessListener(executor, new LocationSuccessListener());
        }
    }

    private static class LocationSuccessListener implements OnSuccessListener<Location> {
        @Override
        public void onSuccess(Location location) {
            SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(LauncherApplication.sApp);
            double lat;
            double longt;
            if (location != null) {
                SharedPreferences.Editor editor = mPrefs.edit();
                lat = location.getLatitude();
                longt = location.getLongitude();
                editor.putString("latiude", String.valueOf(lat));
                editor.putString("longitude", String.valueOf(longt));
                editor.apply();
            } else {
                lat = Double.parseDouble(mPrefs.getString("latiude", "52.408165"));
                longt = Double.parseDouble(mPrefs.getString("longitude", "16.932490"));
            }
            String urlString = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + longt + 
                "&date=today" + "&tzid=" + String.valueOf(ZoneId.systemDefault());

            SunTask sunTask = new SunTask(LauncherApplication.sApp, lat, longt, true);
            sunTask.execute(urlString);
        }
    }

    private void setBrightness() {
        final int dayBrightness = sharedPrefs.getInt("day_seek_bar", 70);
        final int nightBrightness = sharedPrefs.getInt("night_seek_bar", 0);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopWatch();
        if (mSunTask != null) {
            mSunTask.cancel(true);
        }
    }
}