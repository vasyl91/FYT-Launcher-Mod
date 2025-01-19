package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0165_XBS_ChuanQiGs3;
import com.syu.ui.door.DoorHelper;

public class Callback_0165_XBS_XP1_ChuanQiGS5 extends CallbackCanbusBase {
    public static final int U_AIR_ANION_MODE = 101;
    public static final int U_AIR_COMFORT = 100;
    public static final int U_AUTO_AC_ENABLED = 109;
    public static final int U_AUTO_COMPRE = 98;
    public static final int U_AUTO_CYCLE = 99;
    public static final int U_AUTO_MATICALLY = 105;
    public static final int U_AUTO_REAR = 124;
    public static final int U_AUTO_UNLOCK = 113;
    public static final int U_BATTERY = 126;
    public static final int U_CAR_GUANGXIAOQI = 118;
    public static final int U_CAR_LANGUAGE = 117;
    public static final int U_CHARGE = 128;
    public static final int U_CNT_MAX = 132;
    public static final int U_CUR_TRIP_OIL_EXPEND = 106;
    public static final int U_CYCLE_DATE = 131;
    public static final int U_CYCLE_MODE = 130;
    public static final int U_DAYLIGHT = 121;
    public static final int U_DRIVER_SEAT = 102;
    public static final int U_ENERGY_BACK = 125;
    public static final int U_ENERGY_FLOW = 127;
    public static final int U_FEEDBACK_LAMP_ENABLED = 108;
    public static final int U_FRONT_WIND = 114;
    public static final int U_FRONT_YUGUA = 115;
    public static final int U_LIGHT_ASISTY = 122;
    public static final int U_REAR_YUGUA = 116;
    public static final int U_RESERVE_TIME = 129;
    public static final int U_ROMOTE_UNLOCK = 111;
    public static final int U_SEAT_WELCOME = 104;
    public static final int U_SECDRIVER_SEAT = 103;
    public static final int U_SPEEDLOCK = 112;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 107;
    public static final int U_UNLOCK_VOL = 123;
    public static final int U_VALID_VENTILATION_ENABLED = 110;
    public static final int U_WITHHOME = 119;
    public static final int U_WUDENG_HELP = 120;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 132; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0165_XBS_ChuanQiGs3(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 132) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
