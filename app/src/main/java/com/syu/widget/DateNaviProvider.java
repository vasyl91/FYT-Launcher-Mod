package com.syu.widget;

import android.content.Context;
import android.util.Log;

public class DateNaviProvider extends WidgetProvider {
    private static final String TAG = "WeatherClockProvider";

    @Override
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            Log.i("mm", "DateNaviProvider update");
            widget = new DateNaviWidget(context, appwidgetId);
        }
        widget.update();
    }
}
