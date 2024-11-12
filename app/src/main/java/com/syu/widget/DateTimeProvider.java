package com.syu.widget;

import android.content.Context;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class DateTimeProvider extends WidgetProvider {
    @Override // com.syu.widget.WidgetProvider
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateTimeWidget(context, appwidgetId);
        }
        widget.update();
    }
}
