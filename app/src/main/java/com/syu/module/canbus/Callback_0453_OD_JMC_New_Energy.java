package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0453_Oudi_JMC_NewEnergy;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_OD_JMC_New_Energy extends CallbackCanbusBase {
    public static final int U_CARINF_D27_T1_D1_B70 = 127;
    public static final int U_CARINF_D27_T1_D2_B70 = 128;
    public static final int U_CARINF_D27_T2_D10_B70 = 138;
    public static final int U_CARINF_D27_T2_D11_B70 = 139;
    public static final int U_CARINF_D27_T2_D1_B70 = 129;
    public static final int U_CARINF_D27_T2_D2_B70 = 130;
    public static final int U_CARINF_D27_T2_D3_B70 = 131;
    public static final int U_CARINF_D27_T2_D4_B70 = 132;
    public static final int U_CARINF_D27_T2_D5_B70 = 133;
    public static final int U_CARINF_D27_T2_D6_B70 = 134;
    public static final int U_CARINF_D27_T2_D7_B70 = 135;
    public static final int U_CARINF_D27_T2_D8_B70 = 136;
    public static final int U_CARINF_D27_T2_D9_B70 = 137;
    public static final int U_CARINF_D27_T3_D1_B70 = 140;
    public static final int U_CARINF_D27_T3_D2_B70 = 141;
    public static final int U_CARSET_D29_D1_B70 = 118;
    public static final int U_CARSET_D29_D2_B70 = 119;
    public static final int U_CARSET_D29_D3_B70 = 120;
    public static final int U_CARSET_D29_D4_B70 = 121;
    public static final int U_CARSET_D29_D5_B70 = 122;
    public static final int U_CARSET_D29_D6_B70 = 123;
    public static final int U_CARSET_D29_D7_B70 = 124;
    public static final int U_CARSET_D29_D8_B70 = 125;
    public static final int U_CARSET_D29_D9_B70 = 126;
    public static final int U_CNT_MAX = 142;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 108;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 107;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 106;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 111;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 110;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 109;
    public static final int U_TIRE_PRESSURE_FL = 98;
    public static final int U_TIRE_PRESSURE_FR = 99;
    public static final int U_TIRE_PRESSURE_RL = 100;
    public static final int U_TIRE_PRESSURE_RR = 101;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 117;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 116;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 115;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 114;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 113;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 112;
    public static final int U_TIRE_TEMP_FL = 102;
    public static final int U_TIRE_TEMP_FR = 103;
    public static final int U_TIRE_TEMP_RL = 104;
    public static final int U_TIRE_TEMP_RR = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 142; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0453_Oudi_JMC_NewEnergy(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 142) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
