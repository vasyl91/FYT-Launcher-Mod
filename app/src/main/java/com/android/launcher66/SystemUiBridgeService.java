package com.android.launcher66;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

import androidx.annotation.Nullable;

public class SystemUiBridgeService extends Service {
    public static final String ACTION_WIFI = "com.fyt.launcher.systemui.wifi";
    public static final String ACTION_BT = "com.fyt.launcher.systemui.bt";
    public static final String ACTION_SIGNAL = "com.fyt.launcher.systemui.signal";

    /**
     * How long after the last command the stub stops. It stopped itself at once, and on the 7870 the
     * commands came every ~8 s: a create/destroy pair each time (and a forced GC of LeakCanary in
     * debug). Re-armed by every command, so a burst keeps one instance.
     */
    private static final long IDLE_STOP_MS = 30_000L;

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable stop = () -> stopSelf();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.removeCallbacks(stop);
        handler.postDelayed(stop, IDLE_STOP_MS);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        handler.removeCallbacks(stop);
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
