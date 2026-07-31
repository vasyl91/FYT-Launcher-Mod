package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import com.syu.widget.DateMusicProvider;
import com.syu.widget.Widget;

public class MediaFavoriteReceiver extends BroadcastReceiver {
    public static final String EXTRA_PREFERRED_PACKAGE =
            "com.android.launcher66.extra.PREFERRED_MEDIA_PACKAGE";
    private static final long FAVORITE_WIDGET_REFRESH_DELAY_MS = 900L;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && MediaFavoriteController.ACTION_FAVORITE.equals(intent.getAction())) {
            handleFavoriteAction(context, intent.getStringExtra(EXTRA_PREFERRED_PACKAGE));
        }
    }

    static boolean handleFavoriteAction(Context context, String preferredPackage) {
        Context appContext = context.getApplicationContext();
        boolean sent = MediaFavoriteController.favoriteCurrent(appContext, preferredPackage);
        Widget.widgetUpdate(appContext, DateMusicProvider.class);
        new Handler(Looper.getMainLooper()).postDelayed(
                () -> Widget.widgetUpdate(appContext, DateMusicProvider.class),
                FAVORITE_WIDGET_REFRESH_DELAY_MS
        );
        return sent;
    }
}
