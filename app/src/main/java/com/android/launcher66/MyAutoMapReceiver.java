package com.android.launcher66;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.fyt.car.LauncherNotify;
import com.fyt.car.MapConfig;
import com.syu.car.CarStates;
import com.syu.widget.Widget;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public class MyAutoMapReceiver extends BroadcastReceiver {
    public static int mCurDis_All;
    public static int mCurDis_Remain;
    public static String mCurRoadName;
    public static int mCurSpeed;
    public static String mNextRoadName;
    public static int mTurnIcon;
    public static int mCameraDis = -1;
    public static int mCurState = -1;
    public static int mTotalTime = 0;
    public static int mREMAINTime = 0;
    public static int mREMAINDis = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ComponentName cn2 = am.getRunningTasks(1).get(0).topActivity;
            int number = LauncherApplication.sApp.getResources().getInteger(R.integer.apps_launcher_packagename);
            String launcherPackageName = "com.android.launcher" + number;
            if (!launcherPackageName.equals(cn2.getPackageName())) {
                mCameraDis = -1;
                mTurnIcon = -1;
                mCurDis_Remain = 0;
                mCurDis_All = -1;
                mCurSpeed = 0;
                mCurState = -1;
                mTotalTime = -1;
                mREMAINTime = -1;
                mREMAINDis = 0;
                mNextRoadName = "";
                return;
            }
            if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_navi) && CarStates.mAccState != 0 && bundle != null) {
                if (bundle.getInt(MapConfig.KEY_TYPE) == 10001) {
                    if (bundle.getString(MapConfig.CURROADNAME) != null && !bundle.getString(MapConfig.CURROADNAME).equals("")) {
                        mCurRoadName = bundle.getString(MapConfig.CURROADNAME);
                    }
                    mNextRoadName = bundle.getString(MapConfig.NEXT_ROAD_NAME);
                    mCameraDis = bundle.getInt(MapConfig.CAMERA_DIST, 0);
                    mTurnIcon = bundle.getInt(MapConfig.ICON);
                    mCurDis_Remain = bundle.getInt(MapConfig.SEG_REMAIN_DIS);
                    mCurDis_All = bundle.getInt(MapConfig.ROUTE_ALL_DIS);
                    mCurSpeed = bundle.getInt(MapConfig.CUR_SPEED);
                    mTotalTime = bundle.getInt(MapConfig.ROUTE_ALL_TIME);
                    mREMAINTime = bundle.getInt(MapConfig.ROUTE_REMAIN_TIME);
                    mREMAINDis = bundle.getInt(MapConfig.ROUTE_REMAIN_DIS);
                    if (mCurRoadName != null && !LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_design)) {
                        LauncherNotify.NOTIFIER_NAVIVIEW.set(new int[]{mCurDis_Remain, mCurState}, null, null, new String[]{mCurRoadName}, null, "unknown");
                    }
                }
                if (bundle.getInt(MapConfig.KEY_TYPE) == 10019) {
                    mCurState = bundle.getInt(MapConfig.EXTRA_STATE);
                    if (!LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_design)) {
                        LauncherNotify.NOTIFIER_NAVISTATE.set(new int[]{mCurDis_Remain, mCurState}, null, null, new String[]{mCurRoadName}, null, "unknown");
                    }
                }
                Log.i("xx", "mCurDis_Remain: " + mCurDis_Remain + " mCurState: " + mCurState);
                if (LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_design) && !LauncherApplication.sApp.getResources().getBoolean(R.bool.apps_widget_amauto)) {
                    Widget.update(LauncherApplication.sApp);
                    return;
                }
                return;
            }
            return;
        }
        mCurSpeed = 0;
    }
}
