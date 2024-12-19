package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_Oudi_JMC_NewEnergy;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_OD_JMC_New_Energy extends CallbackCanbusBase {
    public static final int U_CARINF_D27_T1_D1_B70 = 115;
    public static final int U_CARINF_D27_T1_D2_B70 = 116;
    public static final int U_CARINF_D27_T2_D10_B70 = 126;
    public static final int U_CARINF_D27_T2_D11_B70 = 127;
    public static final int U_CARINF_D27_T2_D1_B70 = 117;
    public static final int U_CARINF_D27_T2_D2_B70 = 118;
    public static final int U_CARINF_D27_T2_D3_B70 = 119;
    public static final int U_CARINF_D27_T2_D4_B70 = 120;
    public static final int U_CARINF_D27_T2_D5_B70 = 121;
    public static final int U_CARINF_D27_T2_D6_B70 = 122;
    public static final int U_CARINF_D27_T2_D7_B70 = 123;
    public static final int U_CARINF_D27_T2_D8_B70 = 124;
    public static final int U_CARINF_D27_T2_D9_B70 = 125;
    public static final int U_CARINF_D27_T3_D1_B70 = 128;
    public static final int U_CARINF_D27_T3_D2_B70 = 129;
    public static final int U_CARSET_D29_D1_B70 = 106;
    public static final int U_CARSET_D29_D2_B70 = 107;
    public static final int U_CARSET_D29_D3_B70 = 108;
    public static final int U_CARSET_D29_D4_B70 = 109;
    public static final int U_CARSET_D29_D5_B70 = 110;
    public static final int U_CARSET_D29_D6_B70 = 111;
    public static final int U_CARSET_D29_D7_B70 = 112;
    public static final int U_CARSET_D29_D8_B70 = 113;
    public static final int U_CARSET_D29_D9_B70 = 114;
    public static final int U_CNT_MAX = 130;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 96;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 95;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 94;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 99;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 98;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 97;
    public static final int U_TIRE_PRESSURE_FL = 86;
    public static final int U_TIRE_PRESSURE_FR = 87;
    public static final int U_TIRE_PRESSURE_RL = 88;
    public static final int U_TIRE_PRESSURE_RR = 89;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 105;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 104;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 103;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 102;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 101;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 100;
    public static final int U_TIRE_TEMP_FL = 90;
    public static final int U_TIRE_TEMP_FR = 91;
    public static final int U_TIRE_TEMP_RL = 92;
    public static final int U_TIRE_TEMP_RR = 93;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 130; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_Oudi_JMC_NewEnergy(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 130) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
