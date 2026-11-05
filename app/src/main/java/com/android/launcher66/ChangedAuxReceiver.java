package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ChangedAuxReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        com.android.launcher66.settings.FytCompat.run("receiver com.syu.launcherdisplayico", () -> handle(context, intent));
    }

    private void handle(Context context, Intent intent) {
        Launcher launcher = Launcher.getLauncher();
        if (launcher == null || launcher.mModel == null) {
            return;
        }
        launcher.mModel.onReceive(context, intent);
    }
}
