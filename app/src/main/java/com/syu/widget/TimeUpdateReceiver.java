package com.syu.widget;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class TimeUpdateReceiver extends BroadcastReceiver {
    public static final String SHOW_TIME = "com.syu.show_time";
    private static final String TAG = "TimeUpdateReceiver";
    static List<Widget> mWidgets = new ArrayList();
    private static TimeUpdateReceiver timeUpdate;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogPreview.show("onReceive");
        new Thread(new Runnable() { // from class: com.syu.widget.TimeUpdateReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                if (Launcher.mLauncher != null) {
                    Launcher.mLauncher.runOnUiThread(new Runnable() { // from class: com.syu.widget.TimeUpdateReceiver.1.1
                        @Override // java.lang.Runnable
                        public void run() {
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
                        }
                    });
                }
            }
        }).start();
    }

    public static void addWidget(Widget widget) {
        if (!mWidgets.contains(widget)) {
            mWidgets.add(widget);
        }
    }

    public static void removeWidget(Widget widget) {
        if (mWidgets.contains(widget)) {
            mWidgets.remove(widget);
        }
    }

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
            context.registerReceiver(timeUpdate, filter, Context.RECEIVER_EXPORTED);
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
