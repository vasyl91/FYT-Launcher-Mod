package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Hongqi_H7;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Hongqi_H7 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 5;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_BLOW_WIN_LEFT = 9;
    public static final int U_AIR_COLD_HOT = 8;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 6;
    public static final int U_AIR_ECO = 4;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 7;
    public static final int U_AIR_SEAT_HOT_LEFT = 15;
    public static final int U_AIR_SEAT_HOT_RIGHT = 16;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_CARSET_D41_D0_B70 = 38;
    public static final int U_CARSET_D41_D1_B70 = 39;
    public static final int U_CARSET_D41_D2_B70 = 40;
    public static final int U_CARSET_D41_D3_B70 = 41;
    public static final int U_CARSET_D41_D4_B70 = 42;
    public static final int U_CARSET_D41_D5_B70 = 43;
    public static final int U_CARSET_D41_D6_B4 = 47;
    public static final int U_CARSET_D41_D6_B5 = 46;
    public static final int U_CARSET_D41_D6_B6 = 45;
    public static final int U_CARSET_D41_D6_B7 = 44;
    public static final int U_CARSET_D41_D7_B4 = 51;
    public static final int U_CARSET_D41_D7_B5 = 50;
    public static final int U_CARSET_D41_D7_B6 = 49;
    public static final int U_CARSET_D41_D7_B7 = 48;
    public static final int U_CARSET_D41_D8_B6 = 53;
    public static final int U_CARSET_D41_D8_B7 = 52;
    public static final int U_CNT_MAX = 54;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 28;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 27;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 26;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 31;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 30;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 29;
    public static final int U_TIRE_PRESSURE_FL = 18;
    public static final int U_TIRE_PRESSURE_FR = 19;
    public static final int U_TIRE_PRESSURE_RL = 20;
    public static final int U_TIRE_PRESSURE_RR = 21;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 37;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 36;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 35;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 34;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 33;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 32;
    public static final int U_TIRE_TEMP_FL = 22;
    public static final int U_TIRE_TEMP_FR = 23;
    public static final int U_TIRE_TEMP_RL = 24;
    public static final int U_TIRE_TEMP_RR = 25;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 54; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0452_OD_Hongqi_H7(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 17; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 54) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
