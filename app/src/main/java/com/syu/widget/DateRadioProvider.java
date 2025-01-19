package com.syu.widget;

import android.content.Context;

public class DateRadioProvider extends WidgetProvider {
    @Override
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateRadioWidget(context, appwidgetId);
        }
        widget.update();
    }
}
