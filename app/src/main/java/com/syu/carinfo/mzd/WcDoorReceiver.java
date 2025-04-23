package com.syu.carinfo.mzd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.syu.module.canbus.DataCanbus;
import com.syu.module.canbus.HandlerCanbus;
import com.syu.ui.door.DoorHelper;

public class WcDoorReceiver extends BroadcastReceiver {
    private final String ACTION_DOOR = "com.youzi.intent.action.doorinfo";
    private final String ACTION_DOOR_PACK = "doorInfo";
    private boolean bInit = true;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (this.bInit) {
            DoorHelper.sUcDoorEngine = 0;
            DoorHelper.sUcDoorFl = 1;
            DoorHelper.sUcDoorFr = 2;
            DoorHelper.sUcDoorRl = 3;
            DoorHelper.sUcDoorRr = 4;
            DoorHelper.sUcDoorBack = 5;
            DoorHelper.getInstance().buildUi();
            for (int i = 0; i < 6; i++) {
                DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
            }
            this.bInit = false;
        }
        if (intent != null) {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "com.youzi.intent.action.doorinfo".equals(action)) {
                int[] doorInfo = intent.getIntArrayExtra("doorInfo");
                HandlerCanbus.update(0, doorInfo[6]);
                HandlerCanbus.update(1, doorInfo[1]);
                HandlerCanbus.update(2, doorInfo[2]);
                HandlerCanbus.update(3, doorInfo[3]);
                HandlerCanbus.update(4, doorInfo[4]);
                HandlerCanbus.update(5, doorInfo[5]);
            }
        }
    }
}
