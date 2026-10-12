package com.android.launcher66.settings;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * Keeps the launcher's process -- and with it WakeDetection -- up, and brings it back after the
 * system has killed it (START_STICKY). The detection and the handling of sleep and wake are no
 * longer in here, they live as long as the process does (see WakeDetection): a stopped service
 * used to mean that no wake was handled any more.
 *
 * Started from LauncherApplication.onCreate() and never stopped by the launcher. Without system
 * privileges Android still stops it a minute after the launcher has left the screen; WakeDetection
 * does not depend on it.
 */
public class WakeDetectionService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // Started by LauncherApplication already; this does nothing then.
        WakeDetection.start(getApplicationContext());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
