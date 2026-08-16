package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import android.os.SystemClock;
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

    private static SunTask currentSunTask;
    private static final Object TASK_LOCK = new Object();

    /* The interval below which a subsequent wallpaper refresh request is ignored.
     * The Launcher (onResume + delayed watchdog) and WakeDetectionService can start
     * the service several times within a second — without this, each one would start a SunTask.
     */
    private static final long MIN_REFRESH_INTERVAL_MS = 5000;
    private static long lastWallpaperCheckMs = 0;

    private final Handler nightModeHandler = new Handler(Looper.getMainLooper());
    private boolean isNightModeRunning = false;
    private final Handler checkTimeHandler = new Handler(Looper.getMainLooper());
    private LocalDateTime lastCheckedDateTime;
    private boolean isCheckTimeRunning = false;
    private boolean timeChanged = false;

    private boolean isReceiverRegistered = false;
    private boolean isStarted = false;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started (startId=" + startId + ", alreadyStarted=" + isStarted + ")");

        registerRecreateReceiver();

        /* onStartCommand() is called on EVERY startService(), even when the service is already running.
         * Without this guard, a repeated start would register another receiver and reset the timer.
         */
        if (isStarted) {
            Log.d(TAG, "Duplicate start ignored - service already initialised");
            return START_STICKY;
        }
        isStarted = true;

        lastCheckedDateTime = LocalDateTime.now();
        checkTime();
        nightMode();
        return START_STICKY;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    private void registerRecreateReceiver() {
        if (isReceiverRegistered) {
            return;
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(Keys.RECREATE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(recreateReceiver, filter, Context.RECEIVER_EXPORTED);
        } else {
            registerReceiver(recreateReceiver, filter);
        }
        isReceiverRegistered = true;
    }

    private void unregisterRecreateReceiver() {
        if (!isReceiverRegistered) {
            return;
        }
        try {
            unregisterReceiver(recreateReceiver);
        } catch (IllegalArgumentException e) {
            Log.w(TAG, "Receiver was not registered: " + e.getMessage());
        }
        isReceiverRegistered = false;
    }

    private final BroadcastReceiver recreateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction() != null) {
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
        isStarted = false;
        unregisterRecreateReceiver();
        removeNightRunnables(true);
        cancelSunTask();
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
                timeChanged = true;
                checkWallpapers("checkTimeRunnable");
            }
            checkTimeHandler.postDelayed(this, 3000);
        }
    };

    // runs once when the service starts or whenever the view has been Keys.RECREATEd by the user
    private final Runnable nightModeRunnable = new Runnable() {
        @Override
        public void run() {
            // Release the flag so that the next RECREATE can schedule another run.
            isNightModeRunning = false;
            if (!timeChanged) { // it is pointless to run it if the change of the system time was detected on the first start
                checkWallpapers("nightModeRunnable");
            }
            timeChanged = false;
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
        lastCheckedDateTime = currentDateTime;
        return minutes >= 1;
    }

    private void checkWallpapers(String reason) {
        synchronized (TASK_LOCK) {
            long now = SystemClock.elapsedRealtime();
            if (lastWallpaperCheckMs != 0 && now - lastWallpaperCheckMs < MIN_REFRESH_INTERVAL_MS) {
                Log.d(TAG, "checkWallpapers(" + reason + ") skipped - ran "
                        + (now - lastWallpaperCheckMs) + " ms ago");
                return;
            }
            lastWallpaperCheckMs = now;
        }
        Log.d(TAG, "checkWallpapers() started in: " + reason);

        if (ActivityCompat.checkSelfPermission(LauncherApplication.sApp, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(LauncherApplication.sApp, android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            FusedLocationProviderClient fusedLocationClient = LocationServices.getFusedLocationProviderClient(LauncherApplication.sApp);
            OnSuccessListener<Location> listener = new OnSuccessListener<Location>() {
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
                    startSunTask(lat, longt);
                }
            };


            // Activity can be null (e.g. when waking up 10 seconds after the screen turns on, while the
            // Launcher has not started yet) — the Activity-based variant would throw an NPE, so listen without it.
            Activity activity = Launcher.getLauncher();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                fusedLocationClient.getLastLocation().addOnSuccessListener(activity, listener);
            } else {
                fusedLocationClient.getLastLocation().addOnSuccessListener(listener);
            }
        } else {
            Activity activity = Launcher.getLauncher();
            if (activity == null) {
                Log.w(TAG, "No location permission and no activity to ask from - skipping");
                return;
            }
            ActivityCompat.requestPermissions(
                    activity,
                    new String[]{
                            android.Manifest.permission.ACCESS_FINE_LOCATION,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    0
            );
        }
    }

    private void startSunTask(double lat, double longt) {
        synchronized (TASK_LOCK) {
            // Always kill the previous task — otherwise two SunTasks race to update the wallpaper.
            cancelSunTask();

            JobScheduler jobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            if (jobScheduler != null) {
                jobScheduler.cancel(SunTask.JOB_ID); // Only our job, not cancelAll().
            }

            String urlString = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + longt
                    + "&date=today" + "&tzid=" + ZoneId.systemDefault();
            currentSunTask = new SunTask(LauncherApplication.sApp, lat, longt, false);
            currentSunTask.execute(urlString);
        }
    }

    public static void cancelSunTask() {
        synchronized (TASK_LOCK) {
            if (currentSunTask != null) {
                currentSunTask.cancel(true);
                currentSunTask = null;
            }
        }
    }
}
