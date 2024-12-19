package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AIR_0452_OD_Zhongtai_All;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Zotye_T700 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AC_MAX = 22;
    public static final int U_AIR_AUTO = 43;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_MODE = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_HOT_REARVIEW = 23;
    public static final int U_AIR_ION = 21;
    public static final int U_AIR_PM25_CAR_IN = 39;
    public static final int U_AIR_PM25_CAR_OUT = 40;
    public static final int U_AIR_PM25_LEVEL_IN = 41;
    public static final int U_AIR_PM25_LEVEL_OUT = 42;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_SEAT_HOT_LEFT = 24;
    public static final int U_AIR_SEAT_HOT_RIGHT = 25;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARINFO_D41_D0_B2 = 37;
    public static final int U_CARINFO_D41_D0_B3 = 36;
    public static final int U_CARINFO_D41_D0_B74 = 35;
    public static final int U_CARINFO_D41_D1_B70 = 38;
    public static final int U_CARINFO_D41_D2_B70 = 56;
    public static final int U_CARINFO_D41_D3_B70 = 57;
    public static final int U_CARINFO_D41_D4_B70 = 58;
    public static final int U_CARINFO_D41_D5_B70 = 59;
    public static final int U_CARINFO_D41_D6_B70 = 60;
    public static final int U_CNT_MAX = 61;
    public static final int U_PRESSURE_FL_ENABLE = 44;
    public static final int U_PRESSURE_FL_HIGH = 46;
    public static final int U_PRESSURE_FL_LOW = 45;
    public static final int U_PRESSURE_FR_ENABLE = 47;
    public static final int U_PRESSURE_FR_HIGH = 49;
    public static final int U_PRESSURE_FR_LOW = 48;
    public static final int U_PRESSURE_RL_ENABLE = 50;
    public static final int U_PRESSURE_RL_HIGH = 52;
    public static final int U_PRESSURE_RL_LOW = 51;
    public static final int U_PRESSURE_RR_ENABLE = 53;
    public static final int U_PRESSURE_RR_HIGH = 55;
    public static final int U_PRESSURE_RR_LOW = 54;
    public static final int U_TIRE_PRESSURE_FL = 27;
    public static final int U_TIRE_PRESSURE_FR = 28;
    public static final int U_TIRE_PRESSURE_RL = 29;
    public static final int U_TIRE_PRESSURE_RR = 30;
    public static final int U_TIRE_TEMP_FL = 31;
    public static final int U_TIRE_TEMP_FR = 32;
    public static final int U_TIRE_TEMP_RL = 33;
    public static final int U_TIRE_TEMP_RR = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 61; i++) {
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
        AirHelper.getInstance().buildUi(new AIR_0452_OD_Zhongtai_All(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
