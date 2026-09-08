package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ChangedAuxReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null || launcher.mModel == null) {
            return;
        }
        launcher.mModel.onReceive(context, intent);
    }
}
