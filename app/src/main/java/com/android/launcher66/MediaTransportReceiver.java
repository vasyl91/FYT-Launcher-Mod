package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.syu.widget.DateMusicProvider;
import com.syu.widget.DateRadioProvider;
import com.syu.widget.Widget;

public class MediaTransportReceiver extends BroadcastReceiver {
    private static final long WIDGET_REFRESH_DELAY_MS = 800L;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }

        Context appContext = context.getApplicationContext();
        if (MediaTransportController.handleAction(appContext, intent.getAction())) {
            refreshMusicWidgets(appContext);
        }
    }

    private void refreshMusicWidgets(Context context) {
        Widget.widgetUpdate(context, DateMusicProvider.class);
        Widget.widgetUpdate(context, DateRadioProvider.class);
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Widget.widgetUpdate(context, DateMusicProvider.class);
            Widget.widgetUpdate(context, DateRadioProvider.class);
        }, WIDGET_REFRESH_DELAY_MS);
    }
}
