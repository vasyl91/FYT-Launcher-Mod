package com.syu.widget;

import android.annotation.SuppressLint;
import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;

import com.android.launcher66.Launcher;
import com.fyt.widget.Clock;
import com.fyt.widget.Date;
import com.fyt.widget.Date2;
import com.fyt.widget.Day;
import com.fyt.widget.Modulation;
import com.fyt.widget.Month;
import com.fyt.widget.WeekDay;
import com.fyt.widget.WeekDay2;
import com.fyt.widget.Year;
import com.syu.log.LogPreview;

import java.util.ArrayList;
import java.util.List;

public class TimeUpdateReceiver extends BroadcastReceiver {
    public static final String SHOW_TIME = "com.syu.show_time";
    static List<Widget> mWidgets = new ArrayList<>();
    private static TimeUpdateReceiver timeUpdate;

    @Override
    public void onReceive(Context context, Intent intent) {
        LogPreview.show("onReceive");
        new Thread(() -> {
            if (Launcher.mLauncher != null) {
                Launcher.mLauncher.runOnUiThread(() -> {
                    List<Widget> mList = new ArrayList<>(TimeUpdateReceiver.mWidgets);
                    for (Widget widget : mList) {
                        widget.update();
                    }
                    if (Clock.getClock() != null) {
                        Clock.getClock().setTime();
                    }
                    if (Date.getDate() != null) {
                        Date.getDate().setDate();
                    }
                    if (Date2.getDate() != null) {
                        Date2.getDate().setDate();
                    }
                    if (Modulation.getModulation() != null) {
                        Modulation.getModulation().setModulation();
                    }
                    if (WeekDay.getWeekDay() != null) {
                        WeekDay.getWeekDay().setDate();
                    }
                    if (WeekDay2.getWeekDay() != null) {
                        WeekDay2.getWeekDay().setDate();
                    }
                    if (WeekDay.getWeekDay() != null) {
                        WeekDay.getWeekDay().setDate();
                    }
                    if (Year.getYear() != null) {
                        Year.getYear().setDate();
                    }
                    if (Month.getMonth() != null) {
                        Month.getMonth().setDate();
                    }
                    if (Day.getDay() != null) {
                        Day.getDay().setDate();
                    }
                });
            }
        }).start();
    }

    public static void addWidget(Widget widget) {
        if (!mWidgets.contains(widget)) {
            mWidgets.add(widget);
        }
    }

    public static void removeWidget(Widget widget) {
        mWidgets.remove(widget);
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public static void register(Context context) {
        synchronized (TimeUpdateReceiver.class) {
            if (timeUpdate == null) {
                timeUpdate = new TimeUpdateReceiver();
            }
            AppWidgetManager manager = AppWidgetManager.getInstance(context);
            Widget.check(context, manager);
            IntentFilter filter = new IntentFilter("android.intent.action.TIME_TICK");
            filter.addAction("android.intent.action.DATE_CHANGED");
            filter.addAction("android.intent.action.TIME_SET");
            filter.addAction("android.intent.action.TIMEZONE_CHANGED");
            filter.addAction(SHOW_TIME);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                context.registerReceiver(timeUpdate, filter, Context.RECEIVER_EXPORTED);
            } else {
                context.registerReceiver(timeUpdate, filter);
            }
        }
    }

    public static void unregister(Context context) {
        synchronized (TimeUpdateReceiver.class) {
            if (timeUpdate != null) {
                context.unregisterReceiver(timeUpdate);
                timeUpdate = null;
            }
        }
    }
}
