package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0188_XBS_XP1_CRV2012 extends CallbackCanbusBase {
    public static final int U_CAR_CURR_SOURCE = 2;
    public static final int U_CAR_MID_ENABLE = 3;
    public static final int U_CAR_PLAY_PROGRESS = 6;
    public static final int U_CAR_PLAY_STATE = 1;
    public static final int U_CAR_TRACK_INFO = 5;
    public static final int U_CAR_TRACK_TIME_INFO = 4;
    public static final int U_CNT_MAX = 13;
    public static final int U_DOOR_BACK = 12;
    public static final int U_DOOR_BEGIN = 7;
    public static final int U_DOOR_END = 13;
    public static final int U_DOOR_ENGINE = 7;
    public static final int U_DOOR_FL = 8;
    public static final int U_DOOR_FR = 9;
    public static final int U_DOOR_RL = 10;
    public static final int U_DOOR_RR = 11;
    public static int[] mTRACK_TIME_INFO = new int[2];
    public static int[] mTRACK_INFO = new int[2];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 13; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 7;
        DoorHelper.sUcDoorFl = 8;
        DoorHelper.sUcDoorFr = 9;
        DoorHelper.sUcDoorRl = 10;
        DoorHelper.sUcDoorRr = 11;
        DoorHelper.sUcDoorBack = 12;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 7; i2 < 13; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 13; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 4) {
            if (ints != null && ints.length >= 2) {
                mTRACK_TIME_INFO = ints;
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
                return;
            }
            return;
        }
        if (updateCode == 5) {
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
