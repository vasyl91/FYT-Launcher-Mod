package com.syu.widget;

import android.content.Context;

public class DateMusicProvider extends WidgetProvider {
    @Override
    public void update(Context context, int appwidgetId) {
        Widget widget = Widget.getWidget(appwidgetId);
        if (widget == null) {
            widget = new DateMusicWidget(context, appwidgetId);
        }
        widget.update();
    }
}
