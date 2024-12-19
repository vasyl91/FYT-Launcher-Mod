package com.syu.carinfo.dj.b70;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DjB70Recevier extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("com.syu.djb70.showpip") && !DjB70Carbt.mIsFront) {
            DjB70ShowPip.showWindow();
        }
    }
}
