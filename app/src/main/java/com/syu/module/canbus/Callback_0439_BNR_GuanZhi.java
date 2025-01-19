package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_OD_Guanzhi2019;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_BNR_GuanZhi extends CallbackCanbusBase {
    public static final int U_CAR_INFO_AUTOVIEW_CLOSE = 99;
    public static final int U_CAR_INFO_BEGIN = 98;
    public static final int U_CAR_INFO_D41_D1_B70 = 118;
    public static final int U_CAR_INFO_D41_D2_D3 = 119;
    public static final int U_CAR_INFO_D41_D4_D5 = 120;
    public static final int U_CAR_INFO_D41_D6_D7_D8 = 121;
    public static final int U_CAR_INFO_HOME_LIGHT = 101;
    public static final int U_CAR_INFO_METER_LIGHT = 102;
    public static final int U_CAR_INFO_OILUNIT = 106;
    public static final int U_CAR_INFO_TEMPUNIT = 105;
    public static final int U_CAR_INFO_TIMEFORMAT = 104;
    public static final int U_CAR_INFO_TIRERESET = 107;
    public static final int U_CAR_INFO_TRUNK_CTRL = 108;
    public static final int U_CAR_INFO_TRUNK_START = 109;
    public static final int U_CAR_INFO_UNIT = 103;
    public static final int U_CAR_INFO_WELCOME_LIGHT = 100;
    public static final int U_CNT_MAX = 122;
    public static final int U_PRESSURE_FL = 110;
    public static final int U_PRESSURE_FL_WARN = 114;
    public static final int U_PRESSURE_FR = 111;
    public static final int U_PRESSURE_FR_WARN = 115;
    public static final int U_PRESSURE_RL = 112;
    public static final int U_PRESSURE_RL_WARN = 116;
    public static final int U_PRESSURE_RR = 113;
    public static final int U_PRESSURE_RR_WARN = 117;

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
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_OD_Guanzhi2019(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 122) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
