package com.syu.canbus;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ServiceKeepAlive extends Service {
    public static final Binder BINDER = new Binder();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return BINDER;
    }
}
