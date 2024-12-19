package com.syu.carinfo.mzd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.HandlerCanbus;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class WcDoorReceiver extends BroadcastReceiver {
    private final String ACTION_DOOR = "com.youzi.intent.action.doorinfo";
    private final String ACTION_DOOR_PACK = "doorInfo";
    private boolean bInit = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.bInit) {
            DoorHelper.sUcDoorEngine = 42;
            DoorHelper.sUcDoorFl = 43;
            DoorHelper.sUcDoorFr = 44;
            DoorHelper.sUcDoorRl = 45;
            DoorHelper.sUcDoorRr = 46;
            DoorHelper.sUcDoorBack = 47;
            DoorHelper.getInstance().buildUi();
            for (int i = 42; i < 48; i++) {
                DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
            }
            this.bInit = false;
        }
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "com.youzi.intent.action.doorinfo".equals(action)) {
                int[] doorInfo = intent.getIntArrayExtra("doorInfo");
                HandlerCanbus.update(42, doorInfo[6]);
                HandlerCanbus.update(43, doorInfo[1]);
                HandlerCanbus.update(44, doorInfo[2]);
                HandlerCanbus.update(45, doorInfo[3]);
                HandlerCanbus.update(46, doorInfo[4]);
                HandlerCanbus.update(47, doorInfo[5]);
            }
        }
    }
}
