package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Hongqi_H7;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0452_OD_Hongqi_H7 extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B70 = 118;
    public static final int U_CARSET_D41_D1_B70 = 119;
    public static final int U_CARSET_D41_D2_B70 = 120;
    public static final int U_CARSET_D41_D3_B70 = 121;
    public static final int U_CARSET_D41_D4_B70 = 122;
    public static final int U_CARSET_D41_D5_B70 = 123;
    public static final int U_CARSET_D41_D6_B4 = 127;
    public static final int U_CARSET_D41_D6_B5 = 126;
    public static final int U_CARSET_D41_D6_B6 = 125;
    public static final int U_CARSET_D41_D6_B7 = 124;
    public static final int U_CARSET_D41_D7_B4 = 131;
    public static final int U_CARSET_D41_D7_B5 = 130;
    public static final int U_CARSET_D41_D7_B6 = 129;
    public static final int U_CARSET_D41_D7_B7 = 128;
    public static final int U_CARSET_D41_D8_B6 = 133;
    public static final int U_CARSET_D41_D8_B7 = 132;
    public static final int U_CARSET_D42_D0_B70 = 134;
    public static final int U_CARSET_D42_D1_B70 = 135;
    public static final int U_CARSET_D42_D2_B70 = 136;
    public static final int U_CARSET_D42_D3_B0 = 143;
    public static final int U_CARSET_D42_D3_B21 = 142;
    public static final int U_CARSET_D42_D3_B3 = 141;
    public static final int U_CARSET_D42_D3_B4 = 140;
    public static final int U_CARSET_D42_D3_B5 = 139;
    public static final int U_CARSET_D42_D3_B6 = 138;
    public static final int U_CARSET_D42_D3_B7 = 137;
    public static final int U_CARSET_D42_D4_B70 = 144;
    public static final int U_CARSET_D42_D5_B2 = 147;
    public static final int U_CARSET_D42_D5_B3 = 146;
    public static final int U_CARSET_D42_D5_B74 = 145;
    public static final int U_CARSET_D42_D6_B6 = 149;
    public static final int U_CARSET_D42_D6_B7 = 148;
    public static final int U_CARSET_D43_D0_B70 = 150;
    public static final int U_CARSET_D43_D1_B70 = 151;
    public static final int U_CARSET_D43_D2_B70 = 152;
    public static final int U_CARSET_D43_D3_B70 = 153;
    public static final int U_CARSET_D43_D4_B70 = 154;
    public static final int U_CARSET_D43_D5_B70 = 155;
    public static final int U_CARSET_D43_D6_B70 = 156;
    public static final int U_CARSET_D43_D7_B70 = 157;
    public static final int U_CNT_MAX = 158;
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 158; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Hongqi_H7(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 158) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
