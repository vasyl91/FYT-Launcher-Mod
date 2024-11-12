package com.syu.widget;

import android.content.Context;
import android.util.Log;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class DateNaviProvider extends WidgetProvider {
    private static final String TAG = "WeatherClockProvider";

    @Override // com.syu.widget.WidgetProvider
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            Log.i("mm", "DateNaviProvider update");
            widget = new DateNaviWidget(context, appwidgetId);
        }
        widget.update();
    }
}
