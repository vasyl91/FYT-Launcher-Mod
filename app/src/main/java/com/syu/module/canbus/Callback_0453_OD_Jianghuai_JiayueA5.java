package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_OD_Jianghuai_JiayueA5 extends CallbackCanbusBase {
    public static final int U_AIR_WINDOW_ONOFF = 128;
    public static final int U_CAR_D40_D00_B70 = 110;
    public static final int U_CAR_D40_D010_B70 = 120;
    public static final int U_CAR_D40_D011_B70 = 121;
    public static final int U_CAR_D40_D012_B70 = 139;
    public static final int U_CAR_D40_D013_B70 = 129;
    public static final int U_CAR_D40_D014_B70 = 130;
    public static final int U_CAR_D40_D015_B70 = 131;
    public static final int U_CAR_D40_D016_B70 = 132;
    public static final int U_CAR_D40_D01_B70 = 111;
    public static final int U_CAR_D40_D02_B70 = 112;
    public static final int U_CAR_D40_D03_B70 = 113;
    public static final int U_CAR_D40_D04_B70 = 114;
    public static final int U_CAR_D40_D05_B70 = 115;
    public static final int U_CAR_D40_D06_B70 = 116;
    public static final int U_CAR_D40_D07_B70 = 117;
    public static final int U_CAR_D40_D08_B70 = 118;
    public static final int U_CAR_D40_D09_B70 = 119;
    public static final int U_CAR_D42_D0_B70 = 122;
    public static final int U_CAR_D42_D1_B70 = 123;
    public static final int U_CAR_D42_D2_B70 = 124;
    public static final int U_CAR_D42_D3_B70 = 125;
    public static final int U_CAR_D42_D4_B70 = 126;
    public static final int U_CAR_D42_D5_B70 = 127;
    public static final int U_CAR_D43_D0_B70 = 133;
    public static final int U_CAR_D43_D1_D2 = 134;
    public static final int U_CAR_D43_D3_B70 = 135;
    public static final int U_CAR_D43_D4_B70 = 136;
    public static final int U_CAR_D43_D5_B70 = 137;
    public static final int U_CAR_D43_D6_B70 = 138;
    public static final int U_CNT_MAX = 140;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;
    public static final int U_TEMP_FL = 102;
    public static final int U_TEMP_FR = 103;
    public static final int U_TEMP_RL = 104;
    public static final int U_TEMP_RR = 105;
    public static final int U_WARNING_FL = 106;
    public static final int U_WARNING_FR = 107;
    public static final int U_WARNING_RL = 108;
    public static final int U_WARNING_RR = 109;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 140; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_OD_Jianghuai_JiayueA5(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 140) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
