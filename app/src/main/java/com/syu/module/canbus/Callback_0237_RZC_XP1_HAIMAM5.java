package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAM55;
import com.syu.ui.air.Air_0237_RZC_XP1_HAIMAV70;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0237_RZC_XP1_HAIMAM5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 5;
    public static final int U_AIR_BLOW_FOOT = 6;
    public static final int U_AIR_BLOW_UP = 4;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAL = 13;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMPERATURE_LEFT = 8;
    public static final int U_AIR_TEMPERATURE_RIGHT = 9;
    public static final int U_AIR_TEMPERATURE_UNIT = 10;
    public static final int U_AIR_WIND_LEVEL = 7;
    public static final int U_CARSET_BEGIN = 42;
    public static final int U_CARSET_END = 44;
    public static final int U_CARSET_HOME_LIGHT = 43;
    public static final int U_CNT_MAX = 45;
    public static final int U_CUR_SPEED = 21;
    public static final int U_DOOR_BACK = 19;
    public static final int U_DOOR_BEGIN = 14;
    public static final int U_DOOR_END = 20;
    public static final int U_DOOR_ENGINE = 14;
    public static final int U_DOOR_FL = 15;
    public static final int U_DOOR_FR = 16;
    public static final int U_DOOR_RL = 17;
    public static final int U_DOOR_RR = 18;
    public static final int U_ENGINE_SPEED = 22;
    public static final int U_SYSTEM_SELFDETECT = 24;
    public static final int U_TIRE_BATTERY_FL = 27;
    public static final int U_TIRE_BATTERY_FR = 31;
    public static final int U_TIRE_BATTERY_RL = 35;
    public static final int U_TIRE_BATTERY_RR = 39;
    public static final int U_TIRE_BEGIN = 23;
    public static final int U_TIRE_END = 41;
    public static final int U_TIRE_PRESS_FL = 25;
    public static final int U_TIRE_PRESS_FR = 29;
    public static final int U_TIRE_PRESS_RL = 33;
    public static final int U_TIRE_PRESS_RR = 37;
    public static final int U_TIRE_TEMP_FL = 26;
    public static final int U_TIRE_TEMP_FR = 30;
    public static final int U_TIRE_TEMP_RL = 34;
    public static final int U_TIRE_TEMP_RR = 38;
    public static final int U_TIRE_WARN_FL = 28;
    public static final int U_TIRE_WARN_FR = 32;
    public static final int U_TIRE_WARN_RL = 36;
    public static final int U_TIRE_WARN_RR = 40;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 45; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 14;
        DoorHelper.sUcDoorFl = 15;
        DoorHelper.sUcDoorFr = 16;
        DoorHelper.sUcDoorRl = 17;
        DoorHelper.sUcDoorRr = 18;
        DoorHelper.sUcDoorBack = 19;
        if (DataCanbus.DATA[1000] == 131309 || DataCanbus.DATA[1000] == 262381) {
            AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAV70(LauncherApplication.getInstance()));
            for (int i2 = 0; i2 < 14; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0237_RZC_XP1_HAIMAM55(LauncherApplication.getInstance()));
            for (int i3 = 0; i3 < 14; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 14; i4 < 20; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 14; i < 20; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        if (DataCanbus.DATA[1000] == 65773) {
            for (int i2 = 0; i2 < 14; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
            AirHelper.getInstance().destroyUi();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 45) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
