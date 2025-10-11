package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Service;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import androidx.core.app.ActivityCompat;
import androidx.preference.PreferenceManager;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class NightModeService extends Service {
    private static final String TAG = "NightModeService";
    private final Handler nightModeHandler = new Handler(Looper.getMainLooper());
    private boolean isNightModeRunning = false;
    private final Handler checkTimeHandler = new Handler(Looper.getMainLooper());
    private LocalDateTime lastCheckedDateTime;
    private boolean isCheckTimeRunning = false;
    private boolean timeChanged = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started"); 
        IntentFilter filter = new IntentFilter();
        filter.addAction(Keys.RECREATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(recreateReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(recreateReceiver, filter);
        }
        lastCheckedDateTime = LocalDateTime.now();
        checkTime();
        nightMode();
        return START_STICKY;
    }

    private final BroadcastReceiver recreateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if(intent.getAction() != null) {
                    switch (intent.getAction()) {
                        case Keys.RECREATE:
                            Log.i(TAG, "Recreate broadcast received"); 
                            removeNightRunnables(false);
                            nightMode();
                            break;
                        default:
                            break;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Error receiving broadcast: " + e.getMessage());
            }
        }
    };

    private void checkTime() {
        if (!isCheckTimeRunning) {
            checkTimeHandler.post(checkTimeRunnable); // check if device has updated the time
            isCheckTimeRunning = true;
        }  
    }

    private void nightMode() { 
        if (!isNightModeRunning) {
            nightModeHandler.postDelayed(nightModeRunnable, 4000); // prevents an error when wallpaper is half loaded half black on boot
            isNightModeRunning = true;
        }        
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
        unregisterReceiver(recreateReceiver);
        removeNightRunnables(true);
    }

    public void removeNightRunnables(boolean time) {
        if (isCheckTimeRunning && time) {
            checkTimeHandler.removeCallbacks(checkTimeRunnable);
            isCheckTimeRunning = false; 
        } 
        if (isNightModeRunning) {
            nightModeHandler.removeCallbacks(nightModeRunnable);
            isNightModeRunning = false; 
        } 
    }

    /* checks every 3s if there was a change in the system time that was greater than one minute
    ** this function exists because the head unit displays incorret time whenever it was cut from the power for a longer peroid of time 
    ** having an internet connection or manual change updates the system time and this triggers checkWallpapers() that sets accurate wallpaper
    */
    private final Runnable checkTimeRunnable = new Runnable() {
        @Override
        public void run() {
            if (hasTimeChanged()) {
                Log.i(TAG, "checkTimeRunnable"); 
                timeChanged = true;
                checkWallpapers();
            } 
            checkTimeHandler.postDelayed(this, 3000);
        }
    };

    // runs once when the service starts or whenever the view has been Keys.RECREATEd by the user
    private final Runnable nightModeRunnable = new Runnable() {
        @Override
        public void run() {
            if (!timeChanged) { // it is pointless to run it if the change of the system time was detected on the first start
                Log.i(TAG, "nightModeRunnable"); 
                timeChanged = false;
                checkWallpapers();
            }
        }
    }; 

    private boolean hasTimeChanged() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // this should never run because lastCheckedDateTime is supposed to be set on the service start
        if (lastCheckedDateTime == null) {
            lastCheckedDateTime = currentDateTime;
            return false;
        }

        Duration duration = Duration.between(lastCheckedDateTime, currentDateTime);
        long minutes = duration.toMinutes();

        if (minutes < 1) {
            lastCheckedDateTime = currentDateTime; 
            return false; 
        } else { 
            lastCheckedDateTime = currentDateTime; 
            return true;  
        }
    } 

    private void checkWallpapers() {
        if (ActivityCompat.checkSelfPermission(LauncherApplication.sApp, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(LauncherApplication.sApp, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            
            FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(LauncherApplication.sApp);
            fusedLocationClient.getLastLocation().addOnSuccessListener(Launcher.getLauncher(), new OnSuccessListener<Location>() {
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
                        // in case the head unit has lost both GPS and internet connection on boot
                        lat = Double.parseDouble(mPrefs.getString("latiude", "52.408165"));
                        longt = Double.parseDouble(mPrefs.getString("longitude", "16.932490"));
                    }
                    final JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
                    jobScheduler.cancelAll();
                    String urlString = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + longt + "&date=today" + "&tzid=" + String.valueOf(ZoneId.systemDefault());
                    SunTask sunTask = new SunTask(LauncherApplication.sApp, lat, longt, false);
                    sunTask.execute(urlString);
                }
            });
        }
    }
}