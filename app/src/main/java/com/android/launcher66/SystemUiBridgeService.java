package com.android.launcher66;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class SystemUiBridgeService extends Service {
    public static final String ACTION_WIFI = "com.fyt.launcher.systemui.wifi";
    public static final String ACTION_BT = "com.fyt.launcher.systemui.bt";
    public static final String ACTION_SIGNAL = "com.fyt.launcher.systemui.signal";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        stopSelf(startId);
        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
