package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_JiangHuai_IEV6E;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Jianghuai_IEV6E extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AUTO = 19;
    public static final int U_AIR_BEGIN = 14;
    public static final int U_AIR_BLOW_AUTO = 24;
    public static final int U_AIR_BLOW_BODY_LEFT = 26;
    public static final int U_AIR_BLOW_FOOT_LEFT = 25;
    public static final int U_AIR_BLOW_WIN_LEFT = 27;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_END = 31;
    public static final int U_AIR_FRONT_DEFROST = 21;
    public static final int U_AIR_POWER = 15;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_SEAT_HEAT_LEFT = 22;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 23;
    public static final int U_AIR_SYNC = 16;
    public static final int U_AIR_TEMP_LEFT = 29;
    public static final int U_AIR_TEMP_RIGHT = 30;
    public static final int U_AIR_WIND_LEVEL_LEFT = 28;
    public static final int U_CARSET_D87_D5_B30 = 52;
    public static final int U_CARSET_D87_D5_B74 = 51;
    public static final int U_CARSET_D87_D6_B70 = 53;
    public static final int U_CARSET_D87_D7_B70 = 54;
    public static final int U_CARSET_DE8_D0_B32 = 56;
    public static final int U_CARSET_DE8_D0_B74 = 55;
    public static final int U_CARSET_DE8_D1_B70 = 57;
    public static final int U_CAR_CURRENT = 40;
    public static final int U_CAR_DRIVE_MODE = 38;
    public static final int U_CAR_ELECTRICITY = 44;
    public static final int U_CAR_ENERGY_AIR = 48;
    public static final int U_CAR_ENERGY_AVG = 46;
    public static final int U_CAR_ENERGY_CUR = 47;
    public static final int U_CAR_ENERGY_DRIVE = 50;
    public static final int U_CAR_ENERGY_FLOW = 45;
    public static final int U_CAR_ENERGY_RECYCLE = 49;
    public static final int U_CAR_GEAR = 39;
    public static final int U_CAR_MILEAGE = 42;
    public static final int U_CAR_REMAIN_MILEAGE = 43;
    public static final int U_CAR_VOLTAGE = 41;
    public static final int U_CNT_MAX = 58;
    public static final int U_DOOR_BACK = 36;
    public static final int U_DOOR_BEGIN = 31;
    public static final int U_DOOR_END = 37;
    public static final int U_DOOR_ENGINE = 31;
    public static final int U_DOOR_FL = 32;
    public static final int U_DOOR_FR = 33;
    public static final int U_DOOR_RL = 34;
    public static final int U_DOOR_RR = 35;
    public static final int U_PRESSURE_FL = 5;
    public static final int U_PRESSURE_FR = 6;
    public static final int U_PRESSURE_RL = 7;
    public static final int U_PRESSURE_RR = 8;
    public static final int U_SYSTEM_UNWORK_WARN = 13;
    public static final int U_TEMP_END = 14;
    public static final int U_TEMP_FL = 1;
    public static final int U_TEMP_FR = 2;
    public static final int U_TEMP_RL = 3;
    public static final int U_TEMP_RR = 4;
    public static final int U_TEMP_WARN_FLW = 9;
    public static final int U_TEMP_WARN_FRW = 10;
    public static final int U_TEMP_WARN_RLW = 11;
    public static final int U_TEMP_WARN_RRW = 12;
    public static final int U_TIRE_BEGIN = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 58; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 31;
        DoorHelper.sUcDoorFl = 32;
        DoorHelper.sUcDoorFr = 33;
        DoorHelper.sUcDoorRl = 34;
        DoorHelper.sUcDoorRr = 35;
        DoorHelper.sUcDoorBack = 36;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 31; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_JiangHuai_IEV6E(LauncherApplication.getInstance()));
        for (int i3 = 14; i3 < 31; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 31; i < 37; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 14; i2 < 31; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 58) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
