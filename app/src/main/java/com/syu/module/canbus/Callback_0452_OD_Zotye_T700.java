package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Zotye_T700 extends CallbackCanbusBase {
    public static final int U_AIR_PM25_CAR_IN = 110;
    public static final int U_AIR_PM25_CAR_OUT = 111;
    public static final int U_AIR_PM25_LEVEL_IN = 112;
    public static final int U_AIR_PM25_LEVEL_OUT = 113;
    public static final int U_CARINFO_D41_D0_B2 = 108;
    public static final int U_CARINFO_D41_D0_B3 = 107;
    public static final int U_CARINFO_D41_D0_B74 = 106;
    public static final int U_CARINFO_D41_D1_B70 = 109;
    public static final int U_CARINFO_D41_D2_B70 = 126;
    public static final int U_CARINFO_D41_D3_B70 = 127;
    public static final int U_CARINFO_D41_D4_B70 = 128;
    public static final int U_CARINFO_D41_D5_B70 = 129;
    public static final int U_CARINFO_D41_D6_B70 = 130;
    public static final int U_CNT_MAX = 131;
    public static final int U_PRESSURE_FL_ENABLE = 114;
    public static final int U_PRESSURE_FL_HIGH = 116;
    public static final int U_PRESSURE_FL_LOW = 115;
    public static final int U_PRESSURE_FR_ENABLE = 117;
    public static final int U_PRESSURE_FR_HIGH = 119;
    public static final int U_PRESSURE_FR_LOW = 118;
    public static final int U_PRESSURE_RL_ENABLE = 120;
    public static final int U_PRESSURE_RL_HIGH = 122;
    public static final int U_PRESSURE_RL_LOW = 121;
    public static final int U_PRESSURE_RR_ENABLE = 123;
    public static final int U_PRESSURE_RR_HIGH = 125;
    public static final int U_PRESSURE_RR_LOW = 124;
    public static final int U_TIRE_PRESSURE_FL = 98;
    public static final int U_TIRE_PRESSURE_FR = 99;
    public static final int U_TIRE_PRESSURE_RL = 100;
    public static final int U_TIRE_PRESSURE_RR = 101;
    public static final int U_TIRE_TEMP_FL = 102;
    public static final int U_TIRE_TEMP_FR = 103;
    public static final int U_TIRE_TEMP_RL = 104;
    public static final int U_TIRE_TEMP_RR = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Zhongtai_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 131) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
