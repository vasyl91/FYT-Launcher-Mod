package com.android.launcher66;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.syu.widget.DateMusicProvider;
import com.syu.widget.Widget;

public class MediaFavoriteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null && MediaFavoriteController.ACTION_FAVORITE.equals(intent.getAction())) {
            MediaFavoriteController.favoriteCurrent(context, null);
            Widget.widgetUpdate(context, DateMusicProvider.class);
        }
    }
}
