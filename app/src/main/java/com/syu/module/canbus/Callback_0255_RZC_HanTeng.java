package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0255_RZC_HanTeng;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0255_RZC_HanTeng extends CallbackCanbusBase {
    public static final int U_360_SHOW = 68;
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_ACMAX = 27;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 21;
    public static final int U_AIR_BLOW_UP_LEFT = 20;
    public static final int U_AIR_BLOW_WIN_LEFT = 19;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_END = 28;
    public static final int U_AIR_FRONT_DEFROST = 18;
    public static final int U_AIR_LEFT_HEATSEAT = 25;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_RIGHT_HEATSEAT = 26;
    public static final int U_AIR_SHOW = 14;
    public static final int U_AIR_SYNC = 16;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 22;
    public static final int U_AMBIENT_LIGHT_BLUE_GREEN_RED = 56;
    public static final int U_AMBIENT_LIGHT_BLUE_PURPLE_RED = 57;
    public static final int U_AMBIENT_LIGHT_BRIGHT_LEVEL = 51;
    public static final int U_AMBIENT_LIGHT_COLOR = 70;
    public static final int U_AMBIENT_LIGHT_CONTROL_METHOD = 54;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SAMPLING = 59;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SETTING = 58;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SPEED = 60;
    public static final int U_AMBIENT_LIGHT_LEV = 71;
    public static final int U_AMBIENT_LIGHT_STATIC_SET = 55;
    public static final int U_AMBIENT_LIGHT_SWITCH = 52;
    public static final int U_AUTO_MIRROR = 66;
    public static final int U_AVM_ONOFF = 62;
    public static final int U_CNT_MAX = 73;
    public static final int U_DAY_LIGHT = 64;
    public static final int U_RETURN_HOME = 67;
    public static final int U_SEAT_COURTESY_SWITCH = 53;
    public static final int U_SJ_NOW = 69;
    public static final int U_TEMP_UNIT = 72;
    public static final int U_TIRE_BEGIN = 28;
    public static final int U_TIRE_END = 50;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 39;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 38;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 37;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 42;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 41;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 40;
    public static final int U_TIRE_PRESSURE_FL = 29;
    public static final int U_TIRE_PRESSURE_FR = 30;
    public static final int U_TIRE_PRESSURE_RL = 31;
    public static final int U_TIRE_PRESSURE_RR = 32;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 48;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 47;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 46;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 45;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 44;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 43;
    public static final int U_TIRE_SYS_FAILURE = 49;
    public static final int U_TIRE_TEMP_FL = 33;
    public static final int U_TIRE_TEMP_FR = 34;
    public static final int U_TIRE_TEMP_RL = 35;
    public static final int U_TIRE_TEMP_RR = 36;
    public static final int U_WELCOME_LIGHT = 65;
    public static final int U_YK_AUTO_WINDOW = 63;
    public static final int U_YK_UNLOCK = 61;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 73; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0255_RZC_HanTeng(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 28; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 28; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 73) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
