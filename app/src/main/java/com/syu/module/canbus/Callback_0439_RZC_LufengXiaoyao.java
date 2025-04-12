package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_LufengXiaoyao extends CallbackCanbusBase {
    public static final int U_AVM_MODE = 146;
    public static final int U_AVM_MODE_STATE = 147;
    public static final int U_CARSET_AUTO_MIRROR = 143;
    public static final int U_CARSET_AVM_ONOFF = 140;
    public static final int U_CARSET_DAY_LIGHT = 142;
    public static final int U_CARSET_LIGHT_HOME = 145;
    public static final int U_CARSET_LIGHT_WELCOME = 144;
    public static final int U_CARSET_REMOTE_AUTO_WINDOW = 141;
    public static final int U_CARSET_REMOT_UNLOCK = 139;
    public static final int U_CNT_MAX = 148;
    public static final int U_TIRE_BEGIN = 97;
    public static final int U_TIRE_END = 138;
    public static final int U_TIRE_FL_AIR_LEAK = 109;
    public static final int U_TIRE_FL_ELECTRICIT_LOSE = 113;
    public static final int U_TIRE_FL_ELECTRICIT_LOW = 112;
    public static final int U_TIRE_FL_HIGH_PRESSURE_ALARM = 108;
    public static final int U_TIRE_FL_LOW_PRESSURE_ALARM = 107;
    public static final int U_TIRE_FL_SENSOR_FAILURE = 106;
    public static final int U_TIRE_FL_TEMP_HIGH_ALARM = 110;
    public static final int U_TIRE_FL_TEMP_LOSE = 111;
    public static final int U_TIRE_FR_AIR_LEAK = 117;
    public static final int U_TIRE_FR_ELECTRICIT_LOSE = 121;
    public static final int U_TIRE_FR_ELECTRICIT_LOW = 120;
    public static final int U_TIRE_FR_HIGH_PRESSURE_ALARM = 116;
    public static final int U_TIRE_FR_LOW_PRESSURE_ALARM = 115;
    public static final int U_TIRE_FR_SENSOR_FAILURE = 114;
    public static final int U_TIRE_FR_TEMP_HIGH_ALARM = 118;
    public static final int U_TIRE_FR_TEMP_LOSE = 119;
    public static final int U_TIRE_PRESSURE_FL = 102;
    public static final int U_TIRE_PRESSURE_FR = 103;
    public static final int U_TIRE_PRESSURE_RL = 104;
    public static final int U_TIRE_PRESSURE_RR = 105;
    public static final int U_TIRE_RL_AIR_LEAK = 133;
    public static final int U_TIRE_RL_ELECTRICIT_LOSE = 137;
    public static final int U_TIRE_RL_ELECTRICIT_LOW = 136;
    public static final int U_TIRE_RL_HIGH_PRESSURE_ALARM = 132;
    public static final int U_TIRE_RL_LOW_PRESSURE_ALARM = 131;
    public static final int U_TIRE_RL_SENSOR_FAILURE = 130;
    public static final int U_TIRE_RL_TEMP_HIGH_ALARM = 134;
    public static final int U_TIRE_RL_TEMP_LOSE = 135;
    public static final int U_TIRE_RR_AIR_LEAK = 125;
    public static final int U_TIRE_RR_ELECTRICIT_LOSE = 129;
    public static final int U_TIRE_RR_ELECTRICIT_LOW = 128;
    public static final int U_TIRE_RR_HIGH_PRESSURE_ALARM = 124;
    public static final int U_TIRE_RR_LOW_PRESSURE_ALARM = 123;
    public static final int U_TIRE_RR_SENSOR_FAILURE = 122;
    public static final int U_TIRE_RR_TEMP_HIGH_ALARM = 126;
    public static final int U_TIRE_RR_TEMP_LOSE = 127;
    public static final int U_TIRE_TEMP_FL = 98;
    public static final int U_TIRE_TEMP_FR = 99;
    public static final int U_TIRE_TEMP_RL = 100;
    public static final int U_TIRE_TEMP_RR = 101;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 148; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_LufengXiaoyao(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 148) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
