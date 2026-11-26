package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class MediaTransportReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }

        Context appContext = context.getApplicationContext();
        // The player the launcher's widget shows: the stock one too, not a paused app's session
        Launcher launcher = Launcher.mLauncher;
        String target = launcher != null ? launcher.mMusicWidget.getTransportTargetPackage() : null;
        MediaTransportController.handleAction(appContext, intent.getAction(), target);
    }
}
