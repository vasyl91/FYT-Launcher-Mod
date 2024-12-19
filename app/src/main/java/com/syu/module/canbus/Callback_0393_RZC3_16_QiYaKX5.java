package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0393_RZC_16_QiYaKX5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0393_RZC3_16_QiYaKX5 extends CallbackCanbusBase {
    public static final int C_CMD_SETTING = 1;
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 23;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 24;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 22;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SYNC = 25;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_BLIND_SPOTS = 28;
    public static final int U_CAR_ACCON = 45;
    public static final int U_CAR_ACCON_ENABLE = 69;
    public static final int U_CAR_AVG_FUEL = 50;
    public static final int U_CAR_AVG_FUEL_ENABLE = 74;
    public static final int U_CAR_AVG_SPEED = 40;
    public static final int U_CAR_AVG_SPEED_ENABLE = 64;
    public static final int U_CAR_CUR_FUEL = 49;
    public static final int U_CAR_CUR_FUEL_ENABLE = 73;
    public static final int U_CAR_CUR_SPEED = 39;
    public static final int U_CAR_CUR_SPEED_ENABLE = 63;
    public static final int U_CAR_DOOR_ENABLE = 79;
    public static final int U_CAR_DRIVENABLE_MILEAGE = 42;
    public static final int U_CAR_DRIVENABLE_MILEAGE_ENABLE = 66;
    public static final int U_CAR_ENGINE_SPEED = 53;
    public static final int U_CAR_ENGINE_SPEED_ENABLE = 77;
    public static final int U_CAR_FRAME_NUM = 30;
    public static final int U_CAR_HANDBRAKE = 48;
    public static final int U_CAR_HANDBRAKE_ENABLE = 72;
    public static final int U_CAR_INFO_BEGIN = 29;
    public static final int U_CAR_INFO_END = 81;
    public static final int U_CAR_LIGHT = 46;
    public static final int U_CAR_LIGHT_ENABLE = 70;
    public static final int U_CAR_LIGHT_FAR = 33;
    public static final int U_CAR_LIGHT_FAR_ENABLE = 57;
    public static final int U_CAR_LIGHT_FRONT = 36;
    public static final int U_CAR_LIGHT_FRONT_ENABLE = 60;
    public static final int U_CAR_LIGHT_LEFT = 34;
    public static final int U_CAR_LIGHT_LEFT_ENABLE = 58;
    public static final int U_CAR_LIGHT_NEAR = 32;
    public static final int U_CAR_LIGHT_NEAR_ENABLE = 56;
    public static final int U_CAR_LIGHT_REAR = 37;
    public static final int U_CAR_LIGHT_REAR_ENABLE = 61;
    public static final int U_CAR_LIGHT_RIGHT = 35;
    public static final int U_CAR_LIGHT_RIGHT_ENABLE = 59;
    public static final int U_CAR_LIGHT_WIDTH = 31;
    public static final int U_CAR_LIGHT_WIDTH_ENABLE = 55;
    public static final int U_CAR_REAR_BACK = 47;
    public static final int U_CAR_REAR_BACK_ENABLE = 71;
    public static final int U_CAR_SEAT_BELT_LEFT = 43;
    public static final int U_CAR_SEAT_BELT_LEFT_ENABLE = 67;
    public static final int U_CAR_SEAT_BELT_RIGHT = 44;
    public static final int U_CAR_SEAT_BELT_RIGHT_ENABLE = 68;
    public static final int U_CAR_STEER_ANGLE_ENABLE = 80;
    public static final int U_CAR_TEMP_MOTOR_OIL = 52;
    public static final int U_CAR_TEMP_MOTOR_OIL_ENABLE = 76;
    public static final int U_CAR_TEMP_OUT_ENABLE = 81;
    public static final int U_CAR_TEMP_WATER = 51;
    public static final int U_CAR_TEMP_WATER_ENABLE = 75;
    public static final int U_CAR_TOTAL_MILEAGE = 41;
    public static final int U_CAR_TOTAL_MILEAGE_ENABLE = 65;
    public static final int U_CAR_VOLTAGE = 54;
    public static final int U_CAR_VOLTAGE_ENABLE = 78;
    public static final int U_CAR_WIPER_LEV = 38;
    public static final int U_CAR_WIPER_LEV_ENABLE = 62;
    public static final int U_CLIMATE = 27;
    public static final int U_CNT_MAX = 84;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 84; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0393_RZC_16_QiYaKX5(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 84) {
            if (updateCode == 27) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                } else {
                    AirHelper.getInstance().showAndRefresh();
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
