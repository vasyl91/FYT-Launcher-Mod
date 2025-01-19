package com.syu.widget.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("QW", "===================== BootReceiver onReceive  tiem" + SystemClock.uptimeMillis());
        context.getApplicationContext();
    }
}
