package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0319_WC3_15Fucos;
import com.syu.ui.door.DoorHelper;

public class Callback_0319_WC2_FOCUS15 extends CallbackCanbusBase {
    public static final int U_CARINFO_END = 116;
    public static final int U_CAR_BT_STATE = 110;
    public static final int U_CAR_CURRENT_SPEED = 106;
    public static final int U_CAR_SRC = 100;
    public static final int U_CAR_WARN = 115;
    public static final int U_CNT_MAX = 117;
    public static final int U_CUR_SPEED = 98;
    public static final int U_DISPLAY_MODE = 109;
    public static final int U_DRIVING_TIME = 107;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_FLASH_LIGHT = 101;
    public static final int U_LINE_GROUP = 114;
    public static final int U_MESSAGE_SOUND = 104;
    public static final int U_MILES_UNIT = 103;
    public static final int U_OPTIMAL_OIL_EXPEND = 108;
    public static final int U_PLAY_TIME = 111;
    public static final int U_PULL_CONTROL = 102;
    public static final int U_SCREEN_ICON = 113;
    public static final int U_SCREEN_ID = 112;
    public static final int U_WARN_SOUND = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0319_WC3_15Fucos(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 115) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode >= 0 && updateCode < 117) {
            if (strs == null) {
                Log.v("zed", " updateCode == " + updateCode + "  ints[0] = " + ints[0]);
                HandlerCanbus.update(updateCode, ints);
            } else {
                HandlerCanbus.update(updateCode, ints, flts, strs);
            }
        }
    }
}
