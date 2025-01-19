package com.syu.widget;

import android.content.Context;

public class DateTimeProvider extends WidgetProvider {
    @Override
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateTimeWidget(context, appwidgetId);
        }
        widget.update();
    }
}
