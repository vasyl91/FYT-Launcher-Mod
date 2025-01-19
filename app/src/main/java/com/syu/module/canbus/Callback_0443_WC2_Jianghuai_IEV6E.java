package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_JiangHuai_IEV6E;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Jianghuai_IEV6E extends CallbackCanbusBase {
    public static final int U_CARSET_D87_D5_B30 = 127;
    public static final int U_CARSET_D87_D5_B74 = 126;
    public static final int U_CARSET_D87_D6_B70 = 128;
    public static final int U_CARSET_D87_D7_B70 = 129;
    public static final int U_CARSET_DE8_D0_B32 = 131;
    public static final int U_CARSET_DE8_D0_B74 = 130;
    public static final int U_CARSET_DE8_D1_B70 = 132;
    public static final int U_CAR_CURRENT = 115;
    public static final int U_CAR_DRIVE_MODE = 113;
    public static final int U_CAR_ELECTRICITY = 119;
    public static final int U_CAR_ENERGY_AIR = 123;
    public static final int U_CAR_ENERGY_AVG = 121;
    public static final int U_CAR_ENERGY_CUR = 122;
    public static final int U_CAR_ENERGY_DRIVE = 125;
    public static final int U_CAR_ENERGY_FLOW = 120;
    public static final int U_CAR_ENERGY_RECYCLE = 124;
    public static final int U_CAR_GEAR = 114;
    public static final int U_CAR_MILEAGE = 117;
    public static final int U_CAR_REMAIN_MILEAGE = 118;
    public static final int U_CAR_VOLTAGE = 116;
    public static final int U_CNT_MAX = 133;
    public static final int U_PRESSURE_FL = 103;
    public static final int U_PRESSURE_FR = 104;
    public static final int U_PRESSURE_RL = 105;
    public static final int U_PRESSURE_RR = 106;
    public static final int U_SYSTEM_UNWORK_WARN = 111;
    public static final int U_TEMP_END = 112;
    public static final int U_TEMP_FL = 99;
    public static final int U_TEMP_FR = 100;
    public static final int U_TEMP_RL = 101;
    public static final int U_TEMP_RR = 102;
    public static final int U_TEMP_WARN_FLW = 107;
    public static final int U_TEMP_WARN_FRW = 108;
    public static final int U_TEMP_WARN_RLW = 109;
    public static final int U_TEMP_WARN_RRW = 110;
    public static final int U_TIRE_BEGIN = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 133; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_JiangHuai_IEV6E(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 133) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
