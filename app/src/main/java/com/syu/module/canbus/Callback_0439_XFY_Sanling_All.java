package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_XFY_Sanling_All extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 112;
    public static final int U_CAREQ_BASS = 114;
    public static final int U_CAREQ_DOLBY_VOLUME = 123;
    public static final int U_CAREQ_FAD = 111;
    public static final int U_CAREQ_MID = 116;
    public static final int U_CAREQ_POSITION = 120;
    public static final int U_CAREQ_POWERON = 124;
    public static final int U_CAREQ_PREMIDIA_HD = 121;
    public static final int U_CAREQ_PUNCH = 117;
    public static final int U_CAREQ_SCV = 122;
    public static final int U_CAREQ_SURROUND = 119;
    public static final int U_CAREQ_TRE = 115;
    public static final int U_CAREQ_TYPE = 113;
    public static final int U_CAREQ_VOL = 118;
    public static final int U_CNT_MAX = 125;
    public static final int U_PRESSURE_END = 110;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FL_TEMP = 99;
    public static final int U_PRESSURE_FL_VOLTAGE = 100;
    public static final int U_PRESSURE_FR = 101;
    public static final int U_PRESSURE_FR_TEMP = 102;
    public static final int U_PRESSURE_FR_VOLTAGE = 103;
    public static final int U_PRESSURE_RL = 104;
    public static final int U_PRESSURE_RL_TEMP = 105;
    public static final int U_PRESSURE_RL_VOLTAGE = 106;
    public static final int U_PRESSURE_RR = 107;
    public static final int U_PRESSURE_RR_TEMP = 108;
    public static final int U_PRESSURE_RR_VOLTAGE = 109;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 125; i++) {
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
        if (updateCode >= 0 && updateCode < 125) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
