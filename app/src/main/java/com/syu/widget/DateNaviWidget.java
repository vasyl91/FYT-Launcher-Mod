package com.syu.widget;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.android.launcher66.Launcher;
import com.android.launcher66.LauncherApplication;
import com.android.launcher66.MyAutoMapReceiver;
import com.android.launcher66.R;
import com.android.launcher66.settings.Helpers;
import com.syu.car.CarStates;
import com.syu.util.FytPackage;

import share.ResValue;

public class DateNaviWidget extends Widget {
    private static final String TAG = "Vanness";
    private static int count = 0;
    private static final String layoutName = "fyt_xml_dt_navi_widget";

    public DateNaviWidget(Context context, int _id) {
        super(context, _id);
    }

    @Override
    protected void updateViews(RemoteViews views) {
        if (CarStates.mAccState == 0) {
            views.setTextViewText(ResValue.getInstance().car_speed, "0");
            views.setTextViewText(ResValue.getInstance().cur_distance, "0m");
            views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().car);
        }
        if (Launcher.getLauncher() != null) {
            views.setTextViewText(ResValue.getInstance().tv_speed, String.valueOf(Launcher.getLauncher().carSpeed));
        }
        if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_amauto)) {
            if (MyAutoMapReceiver.mCurSpeed >= 10) {
                views.setImageViewResource(ResValue.getInstance().dynamic_trail, ResValue.getInstance().map_bg1 + count);
                count++;
                if (count == LauncherApplication.sApp.getResources().getInteger(R.integer.apps_widget_pic_sum)) {
                    count = 0;
                }
            } else {
                views.setImageViewResource(ResValue.getInstance().dynamic_trail, ResValue.getInstance().map_bg1);
            }
        }
        switch (MyAutoMapReceiver.mTurnIcon) {
            case 0:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().car);
                break;
            case 2:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_left);
                break;
            case 3:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_right);
                break;
            case 4:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_left_up);
                break;
            case 5:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_right_up);
                break;
            case 6:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_leftdown);
                break;
            case 7:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_rightdown);
                break;
            case 8:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_leftback);
                break;
            case 9:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().straight);
                break;
            case 16:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().tunnel);
                break;
            case 19:
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().turn_rightback);
                break;
        }
        if (MyAutoMapReceiver.mCameraDis == -1) {
            views.setViewVisibility(ResValue.getInstance().camera, View.INVISIBLE);
        } else {
            views.setViewVisibility(ResValue.getInstance().camera, View.VISIBLE);
        }
        if (MyAutoMapReceiver.mCurDis_Remain > 1500) {
            float dis = MyAutoMapReceiver.mCurDis_Remain / 1000.0f;
            String str = String.format("%1$.1f", Float.valueOf(dis));
            views.setTextViewText(ResValue.getInstance().cur_distance, str + "km");
        } else {
            views.setTextViewText(ResValue.getInstance().cur_distance, MyAutoMapReceiver.mCurDis_Remain + "m");
        }
        views.setTextViewText(ResValue.getInstance().car_speed, String.valueOf(MyAutoMapReceiver.mCurSpeed));
        switch (MyAutoMapReceiver.mCurState) {
            case 2:
            case 9:
            case 12:
                MyAutoMapReceiver.mTurnIcon = 0;
                MyAutoMapReceiver.mCurSpeed = 0;
                MyAutoMapReceiver.mCurDis_Remain = 0;
                views.setTextViewText(ResValue.getInstance().car_speed, "0");
                views.setTextViewText(ResValue.getInstance().cur_distance, "0m");
                views.setImageViewResource(ResValue.getInstance().map_instr, ResValue.getInstance().car);
                break;
        }
    }

    @Override
    protected void add() {
        super.add();
    }

    @Override
    public void delete() {
        super.delete();
    }

    @Override
    void getLayoutId() {
        this.layoutId = getLayoutId(LauncherApplication.sForeign ? "fyt_xml_dt_navi_widget_f" : layoutName);
    }

    @Override
    void addLisenter(RemoteViews views) {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (Helpers.isPackageInstalled(FytPackage.GaodeACTION, packageManager)) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(FytPackage.GaodeACTION, "com.autonavi.auto.remote.fill.UsbFillActivity"));
                PendingIntent pendIntent = PendingIntent.getActivity(this.mContext, 0, intent, PendingIntent.FLAG_IMMUTABLE);
                views.setOnClickPendingIntent(ResValue.getInstance().mapview, pendIntent);
            }
        } catch (Exception e) {
            Log.e("DateNaviWidget", "Failed to add the widget listener: " + e.getMessage());
        }
    }
}
