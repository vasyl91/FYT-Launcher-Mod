package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0188_XBS_XP1_CRV2012 extends CallbackCanbusBase {
    public static final int U_CAR_CURR_SOURCE = 8;
    public static final int U_CAR_MID_ENABLE = 9;
    public static final int U_CAR_PLAY_PROGRESS = 12;
    public static final int U_CAR_PLAY_STATE = 7;
    public static final int U_CAR_TRACK_INFO = 11;
    public static final int U_CAR_TRACK_TIME_INFO = 10;
    public static final int U_CNT_MAX = 13;
    public static int[] mTRACK_TIME_INFO = new int[2];
    public static int[] mTRACK_INFO = new int[2];

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 13; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 10) {
            if (ints != null && ints.length >= 2) {
                mTRACK_TIME_INFO = ints;
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
                return;
            }
            return;
        }
        if (updateCode == 11) {
            if (ints != null && ints.length >= 2) {
                mTRACK_INFO = ints;
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
                return;
            }
            return;
        }
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
