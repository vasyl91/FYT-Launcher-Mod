package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ChangedAuxReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Launcher.mModel != null) {
            Launcher.mModel.onReceive(context, intent);
        }
    }
}
