package com.syu.widget;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;

public class RestartService extends Service {
    Handler mHandler = new Handler(Looper.getMainLooper());
    Runnable run = new Runnable() {
        @Override
        public void run() {
            RestartService.this.mHandler.removeCallbacks(RestartService.this.run);
            RestartService.this.mHandler.postDelayed(RestartService.this.run, 500L);
        }
    };

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
