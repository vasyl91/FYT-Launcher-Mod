package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0390_XBS_XP1_ZhongTaiT600 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 124;
    public static final int U_LAMP_STATE = 119;
    public static final int U_PM25_IN = 122;
    public static final int U_PM25_OUT = 123;
    public static final int U_PM25_VALUE = 121;
    public static final int U_PRESSURE_FL = 104;
    public static final int U_PRESSURE_FR = 105;
    public static final int U_PRESSURE_RL = 106;
    public static final int U_PRESSURE_RR = 107;
    public static final int U_PRESSURE_WARN_FL = 112;
    public static final int U_PRESSURE_WARN_FR = 113;
    public static final int U_PRESSURE_WARN_RL = 114;
    public static final int U_PRESSURE_WARN_RR = 115;
    public static final int U_SYSTEM_UNWORK_WARN = 116;
    public static final int U_TEMP_BEGIN = 98;
    public static final int U_TEMP_FL = 100;
    public static final int U_TEMP_FR = 101;
    public static final int U_TEMP_RL = 102;
    public static final int U_TEMP_RR = 103;
    public static final int U_TEMP_WARN_FL = 108;
    public static final int U_TEMP_WARN_FR = 109;
    public static final int U_TEMP_WARN_RL = 110;
    public static final int U_TEMP_WARN_RR = 111;
    public static final int U_TEMP_WATER = 120;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
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
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
