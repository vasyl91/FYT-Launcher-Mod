package com.syu.canbus;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class ServiceKeepAlive extends Service {
    public static final Binder BINDER = new Binder();

    @Override
    public IBinder onBind(Intent intent) {
        return BINDER;
    }
}
