package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LZ_Kayan extends CallbackCanbusBase {
    public static final int CMD_SET_CTRL = 0;
    public static final int U_AIR_SEAT_AUTO_LEFT = 100;
    public static final int U_AIR_SEAT_AUTO_RIGHT = 101;
    public static final int U_AIR_SEAT_COLD_AUTO_LEFT = 98;
    public static final int U_AIR_SEAT_COLD_AUTO_RIGHT = 99;
    public static final int U_AIR_SEAT_COLD_LEFT_BOTTOM = 107;
    public static final int U_AIR_SEAT_COLD_LEFT_WAIST = 106;
    public static final int U_AIR_SEAT_COLD_RIGHT_BOTTOM = 109;
    public static final int U_AIR_SEAT_COLD_RIGHT_WAIST = 108;
    public static final int U_AIR_SEAT_HOT_LEFT_BOTTOM = 103;
    public static final int U_AIR_SEAT_HOT_LEFT_WAIST = 102;
    public static final int U_AIR_SEAT_HOT_RIGHT_BOTTOM = 105;
    public static final int U_AIR_SEAT_HOT_RIGHT_WAIST = 104;
    public static final int U_CARAUX_CTRL_TYPE = 130;
    public static final int U_CAR_AUDI_TYPE = 128;
    public static final int U_CAR_LVDS_MODE = 129;
    public static final int U_CAR_SET_AIR_AUTOCIRC = 123;
    public static final int U_CAR_SET_AIR_PANEL = 122;
    public static final int U_CAR_SET_AIR_STYLE = 124;
    public static final int U_CAR_SET_BEGIN = 112;
    public static final int U_CAR_SET_COMFORT_ENTRY = 121;
    public static final int U_CAR_SET_DAYTIME_LIGHT = 115;
    public static final int U_CAR_SET_DOOR_LOCK = 120;
    public static final int U_CAR_SET_DOOR_UNLOCK = 119;
    public static final int U_CAR_SET_END = 126;
    public static final int U_CAR_SET_EXTERIORLIGHT_OFFTIME = 125;
    public static final int U_CAR_SET_INTERLIGHT = 114;
    public static final int U_CAR_SET_INTERLIGHT_OFFTIME = 113;
    public static final int U_CAR_SET_REAR_WIPER = 117;
    public static final int U_CAR_SET_REVERSING_OPTIONS = 118;
    public static final int U_CAR_SET_WIPER_SENSOR = 116;
    public static final int U_CAR_STEER_TYPE = 127;
    public static final int U_CNT_MAX = 131;
    public static final int U_ENGINE_SPEED = 110;
    public static final int U_TOTAL_MILEAGE = 111;
    public static int modevalue = -1;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_LZ_Kayan(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 131) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
