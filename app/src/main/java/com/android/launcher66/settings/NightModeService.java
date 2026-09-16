package com.android.launcher66.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
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
                    if (intent.getAction().equals(Keys.RECREATE)) {
                        Log.i(TAG, "Recreate broadcast received");
                        removeNightRunnables(false);
                        nightMode();
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
                // Forced: the throttle is meant for duplicate service starts. A clock correction a few
                // seconds after the wake refresh is new information, and skipping it would leave the
                // wallpaper that was chosen with the wrong time. Setting the same one twice is prevented
                // by SunTask's own check, so an extra run is harmless.
                checkWallpapers("checkTimeRunnable", true);
            }
            checkTimeHandler.postDelayed(this, 3000);
        }
    };

    // runs once when the service starts or whenever the view has been Keys.RECREATEd by the user
    private final Runnable nightModeRunnable = () -> {
        // Release the flag so that the next RECREATE can schedule another run.
        isNightModeRunning = false;
        if (!timeChanged) { // it is pointless to run it if the change of the system time was detected on the first start
            checkWallpapers("nightModeRunnable");
        }
        timeChanged = false;
    };

    private boolean hasTimeChanged() {
        LocalDateTime currentDateTime = LocalDateTime.now();

        // this should never run because lastCheckedDateTime is supposed to be set on the service start
        if (lastCheckedDateTime == null) {
            lastCheckedDateTime = currentDateTime;
            return false;
        }

        Duration duration = Duration.between(lastCheckedDateTime, currentDateTime);
        // abs(): a clock stepped back across sunrise/sunset needs a refresh just as much as one stepped forward.
        long minutes = Math.abs(duration.toMinutes());
        lastCheckedDateTime = currentDateTime;
        return minutes >= 1;
    }

    private void checkWallpapers(String reason) {
        checkWallpapers(reason, false);
    }

    /** @param force skip the MIN_REFRESH_INTERVAL_MS throttle (used when the clock has changed). */
    private void checkWallpapers(String reason, boolean force) {
        synchronized (TASK_LOCK) {
            long now = SystemClock.elapsedRealtime();
            if (!force && lastWallpaperCheckMs != 0 && now - lastWallpaperCheckMs < MIN_REFRESH_INTERVAL_MS) {
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
            OnSuccessListener<Location> listener = location -> {
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
                    String latStr = mPrefs.getString("latiude", null);
                    String lngStr = mPrefs.getString("longitude", null);
                    if (latStr != null && lngStr != null) {
                        lat = Double.parseDouble(latStr);
                        longt = Double.parseDouble(lngStr);
                    } else return;
                }
                startSunTask(LauncherApplication.sApp, lat, longt, reason);
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

    /**
     * Day/night refresh for the last saved location, without asking the location provider.
     * Used by DayNightMode at sunrise/sunset, so the job goes through the same SunTask (and the same
     * "already applied" check) as every other refresh instead of setting the wallpaper on its own.
     *
     * @return false when there is no usable saved location
     */
    public static boolean startSunTaskForSavedLocation(Context context, String reason) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        String latStr = prefs.getString("latiude", null);
        String lngStr = prefs.getString("longitude", null);
        if (latStr == null || lngStr == null) {
            return false;
        }
        try {
            startSunTask(context, Double.parseDouble(latStr), Double.parseDouble(lngStr), reason);
            return true;
        } catch (NumberFormatException e) {
            Log.w(TAG, "Invalid saved location: " + latStr + ", " + lngStr);
            return false;
        }
    }

    /*
     * Static so that DayNightMode can use it without a running service instance. There is only one
     * SunTask at a time for the whole process, whoever started it.
     */
    private static void startSunTask(Context context, double lat, double longt, String reason) {
        Context appContext = context.getApplicationContext();
        synchronized (TASK_LOCK) {
            // Always kill the previous task — otherwise two SunTasks race to update the wallpaper.
            cancelSunTask();

            // The new task schedules the next sunrise/sunset job itself.
            SunTask.cancelScheduledJob(appContext);

            String urlString = "https://api.sunrise-sunset.org/json?lat=" + lat + "&lng=" + longt
                    + "&date=today" + "&tzid=" + ZoneId.systemDefault();
            Log.d(TAG, "Starting SunTask (" + reason + ")");
            currentSunTask = new SunTask(appContext, lat, longt, false);
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
