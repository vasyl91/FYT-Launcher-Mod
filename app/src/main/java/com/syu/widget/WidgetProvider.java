package com.syu.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public abstract class WidgetProvider extends AppWidgetProvider {
    public static final String APP_WIDGET_START = "syu.widget.start";
    public static final String BTAVNEXTSERVICE = "com.syu.bt.byav.widgetNext";
    public static final String BTAVPLAYSERVICE = "com.syu.bt.byav.widgetPlayPause";
    public static final String BTAVPRESERVICE = "com.syu.bt.byav.widgetPrev";
    public static final String LAUNCHERMUSIC = "com.fyt.launcher.music";
    public static final String NEXTSERVICE = "com.syu.music.next";
    public static final String PLAYSERVICE = "com.syu.music.playpause";
    public static final String PRESERVICE = "com.syu.music.prev";
    public static final String RADIONEXT = "com.syu.radio.nextservice";
    public static final String RADIOPREV = "com.syu.radio.prevservice";

    public abstract void update(Context context, int i);

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        String action = intent.getAction();
        Log.e("TT", "WidgetProvider onReceive =====  ");
        if (action.equals("android.appwidget.action.APPWIDGET_UPDATE")) {
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            int[] _ids = manager.getAppWidgetIds(new ComponentName(context, getClass()));
            if (_ids.length > 0) {
                onUpdate(context, manager, _ids);
            }
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            Log.e("TT", "WidgetProvider onUpdate =====  " + id);
            update(context, id);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        for (int id : appWidgetIds) {
            Widget widget = Widget.getWidget(id);
            if (widget != null) {
                widget.delete();
            }
        }
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }
}
