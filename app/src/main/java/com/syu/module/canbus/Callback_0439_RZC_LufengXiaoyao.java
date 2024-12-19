package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_LufengXiaoyao;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_LufengXiaoyao extends CallbackCanbusBase {
    public static final int U_AVM_MODE = 134;
    public static final int U_AVM_MODE_STATE = 135;
    public static final int U_CARSET_AUTO_MIRROR = 131;
    public static final int U_CARSET_AVM_ONOFF = 128;
    public static final int U_CARSET_DAY_LIGHT = 130;
    public static final int U_CARSET_LIGHT_HOME = 133;
    public static final int U_CARSET_LIGHT_WELCOME = 132;
    public static final int U_CARSET_REMOTE_AUTO_WINDOW = 129;
    public static final int U_CARSET_REMOT_UNLOCK = 127;
    public static final int U_CNT_MAX = 136;
    public static final int U_TIRE_BEGIN = 85;
    public static final int U_TIRE_END = 126;
    public static final int U_TIRE_FL_AIR_LEAK = 97;
    public static final int U_TIRE_FL_ELECTRICIT_LOSE = 101;
    public static final int U_TIRE_FL_ELECTRICIT_LOW = 100;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 96;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 95;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 94;
    public static final int U_TIRE_FL_TEMP_HIGH_ALARM = 98;
    public static final int U_TIRE_FL_TEMP_LOSE = 99;
    public static final int U_TIRE_FR_AIR_LEAK = 105;
    public static final int U_TIRE_FR_ELECTRICIT_LOSE = 109;
    public static final int U_TIRE_FR_ELECTRICIT_LOW = 108;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 104;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 103;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 102;
    public static final int U_TIRE_FR_TEMP_HIGH_ALARM = 106;
    public static final int U_TIRE_FR_TEMP_LOSE = 107;
    public static final int U_TIRE_PRESSURE_FL = 90;
    public static final int U_TIRE_PRESSURE_FR = 91;
    public static final int U_TIRE_PRESSURE_RL = 92;
    public static final int U_TIRE_PRESSURE_RR = 93;
    public static final int U_TIRE_RL_AIR_LEAK = 121;
    public static final int U_TIRE_RL_ELECTRICIT_LOSE = 125;
    public static final int U_TIRE_RL_ELECTRICIT_LOW = 124;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 120;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 119;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 118;
    public static final int U_TIRE_RL_TEMP_HIGH_ALARM = 122;
    public static final int U_TIRE_RL_TEMP_LOSE = 123;
    public static final int U_TIRE_RR_AIR_LEAK = 113;
    public static final int U_TIRE_RR_ELECTRICIT_LOSE = 117;
    public static final int U_TIRE_RR_ELECTRICIT_LOW = 116;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 112;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 111;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 110;
    public static final int U_TIRE_RR_TEMP_HIGH_ALARM = 114;
    public static final int U_TIRE_RR_TEMP_LOSE = 115;
    public static final int U_TIRE_TEMP_FL = 86;
    public static final int U_TIRE_TEMP_FR = 87;
    public static final int U_TIRE_TEMP_RL = 88;
    public static final int U_TIRE_TEMP_RR = 89;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 136; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0439_RZC_LufengXiaoyao(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 136) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
