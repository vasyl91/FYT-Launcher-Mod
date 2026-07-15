package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.syu.widget.DateMusicProvider;
import com.syu.widget.Widget;

public class MediaFavoriteReceiver extends BroadcastReceiver {
    private static final long FAVORITE_WIDGET_REFRESH_DELAY_MS = 900L;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && MediaFavoriteController.ACTION_FAVORITE.equals(intent.getAction())) {
            Context appContext = context.getApplicationContext();
            MediaFavoriteController.favoriteCurrent(appContext, null);
            Widget.widgetUpdate(appContext, DateMusicProvider.class);
            new Handler(Looper.getMainLooper()).postDelayed(
                    () -> Widget.widgetUpdate(appContext, DateMusicProvider.class),
                    FAVORITE_WIDGET_REFRESH_DELAY_MS
            );
        }
    }
}
