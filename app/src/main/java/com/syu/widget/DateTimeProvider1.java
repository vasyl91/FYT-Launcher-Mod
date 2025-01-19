package com.syu.widget;

import android.content.Context;

public class DateTimeProvider1 extends WidgetProvider {
    @Override
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateTimeWidget1(context, appwidgetId);
        }
        widget.update();
    }
}
