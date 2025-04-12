package com.android.launcher66.settings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Helpers helpers = new Helpers();
            helpers.setOnBootBoolean(true);
        }
    }
}