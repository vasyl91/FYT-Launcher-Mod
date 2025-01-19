package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAM55;
//import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAV70;
import com.syu.ui.door.DoorHelper;

public class Callback_0237_RZC_XP1_HAIMAM5 extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 119;
    public static final int U_CARSET_END = 121;
    public static final int U_CARSET_HOME_LIGHT = 120;
    public static final int U_CNT_MAX = 122;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_SYSTEM_SELFDETECT = 101;
    public static final int U_TIRE_BATTERY_FL = 104;
    public static final int U_TIRE_BATTERY_FR = 108;
    public static final int U_TIRE_BATTERY_RL = 112;
    public static final int U_TIRE_BATTERY_RR = 116;
    public static final int U_TIRE_BEGIN = 100;
    public static final int U_TIRE_END = 118;
    public static final int U_TIRE_PRESS_FL = 102;
    public static final int U_TIRE_PRESS_FR = 106;
    public static final int U_TIRE_PRESS_RL = 110;
    public static final int U_TIRE_PRESS_RR = 114;
    public static final int U_TIRE_TEMP_FL = 103;
    public static final int U_TIRE_TEMP_FR = 107;
    public static final int U_TIRE_TEMP_RL = 111;
    public static final int U_TIRE_TEMP_RR = 115;
    public static final int U_TIRE_WARN_FL = 105;
    public static final int U_TIRE_WARN_FR = 109;
    public static final int U_TIRE_WARN_RL = 113;
    public static final int U_TIRE_WARN_RR = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 131309 || DataCanbus.DATA[1000] == 262381) {
            //AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAV70(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAM55(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
