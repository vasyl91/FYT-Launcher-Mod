package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0369_CYT_DaZhongZiDongKongTiao extends CallbackCanbusBase {
    public static final int C_PARK_CARPORT = 1;
    public static final int C_PARK_ROAD = 0;
    public static final int C_RADAR_MUTE = 2;
    public static final int C_REQUEST_DATA = 3;
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AC_MAX = 32;
    public static final int U_AIR_AQS = 29;
    public static final int U_AIR_AUTO = 35;
    public static final int U_AIR_BEGIN = 14;
    public static final int U_AIR_BIG_WIND_LIGHT = 15;
    public static final int U_AIR_BLOW_BODY = 23;
    public static final int U_AIR_BLOW_FOOT = 25;
    public static final int U_AIR_BLOW_UP = 22;
    public static final int U_AIR_CYCLE = 19;
    public static final int U_AIR_DUAL = 20;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 16;
    public static final int U_AIR_MAX = 18;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR = 21;
    public static final int U_AIR_REAR_LOCK = 31;
    public static final int U_AIR_SEAT_HEAT_LEFT = 30;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 33;
    public static final int U_AIR_SHOW = 24;
    public static final int U_AIR_TEMP_LEFT = 27;
    public static final int U_AIR_TEMP_OUT = 34;
    public static final int U_AIR_TEMP_RIGHT = 28;
    public static final int U_AIR_WIND_LEVEL = 26;
    public static final int U_AIR_WIND_MODE = 36;
    public static final int U_BATTERY_VOLTAGE = 7;
    public static final int U_CLEAN_FLUIT_WARN = 4;
    public static final int U_CNT_MAX = 43;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_SPEED = 11;
    public static final int U_DOOR_BACK = 42;
    public static final int U_DOOR_BEGIN = 37;
    public static final int U_DOOR_END = 43;
    public static final int U_DOOR_ENGINE = 37;
    public static final int U_DOOR_FL = 38;
    public static final int U_DOOR_FR = 39;
    public static final int U_DOOR_RL = 40;
    public static final int U_DOOR_RR = 41;
    public static final int U_DRIVE_MILE = 8;
    public static final int U_ENGINE_SPEED = 12;
    public static final int U_HANDLE_BRAKE_WARN = 5;
    public static final int U_LIFE_BELT_WARN = 3;
    public static final int U_LOW_BATTERY_WARN = 2;
    public static final int U_LOW_OIL_WARN = 1;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 14;
    public static final int U_OUT_TEMP = 13;
    public static final int U_PARK = 9;
    public static final int U_RADAR_MUTE = 10;
    public static final int U_RESIDUAL_OIL = 6;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 37;
        DoorHelper.sUcDoorFl = 38;
        DoorHelper.sUcDoorFr = 39;
        DoorHelper.sUcDoorRl = 40;
        DoorHelper.sUcDoorRr = 41;
        DoorHelper.sUcDoorBack = 42;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 37; i2 < 43; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 37; i < 43; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
