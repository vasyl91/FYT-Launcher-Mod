package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0255_RZC_HanTeng;
import com.syu.ui.door.DoorHelper;

public class Callback_0255_RZC_HanTeng extends CallbackCanbusBase {
    public static final int U_360_SHOW = 138;
    public static final int U_AMBIENT_LIGHT_BLUE_GREEN_RED = 126;
    public static final int U_AMBIENT_LIGHT_BLUE_PURPLE_RED = 127;
    public static final int U_AMBIENT_LIGHT_BRIGHT_LEVEL = 121;
    public static final int U_AMBIENT_LIGHT_COLOR = 140;
    public static final int U_AMBIENT_LIGHT_CONTROL_METHOD = 124;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SAMPLING = 129;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SETTING = 128;
    public static final int U_AMBIENT_LIGHT_DYNAMIC_SPEED = 130;
    public static final int U_AMBIENT_LIGHT_LEV = 141;
    public static final int U_AMBIENT_LIGHT_STATIC_SET = 125;
    public static final int U_AMBIENT_LIGHT_SWITCH = 122;
    public static final int U_AUTO_MIRROR = 136;
    public static final int U_AVM_ONOFF = 132;
    public static final int U_CNT_MAX = 143;
    public static final int U_DAY_LIGHT = 134;
    public static final int U_RETURN_HOME = 137;
    public static final int U_SEAT_COURTESY_SWITCH = 123;
    public static final int U_SJ_NOW = 139;
    public static final int U_TEMP_UNIT = 142;
    public static final int U_TIRE_BEGIN = 98;
    public static final int U_TIRE_END = 120;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 109;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 108;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 107;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 112;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 111;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 110;
    public static final int U_TIRE_PRESSURE_FL = 99;
    public static final int U_TIRE_PRESSURE_FR = 100;
    public static final int U_TIRE_PRESSURE_RL = 101;
    public static final int U_TIRE_PRESSURE_RR = 102;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 118;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 117;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 116;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 115;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 114;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 113;
    public static final int U_TIRE_SYS_FAILURE = 119;
    public static final int U_TIRE_TEMP_FL = 103;
    public static final int U_TIRE_TEMP_FR = 104;
    public static final int U_TIRE_TEMP_RL = 105;
    public static final int U_TIRE_TEMP_RR = 106;
    public static final int U_WELCOME_LIGHT = 135;
    public static final int U_YK_AUTO_WINDOW = 133;
    public static final int U_YK_UNLOCK = 131;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 143; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0255_RZC_HanTeng(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 143) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
