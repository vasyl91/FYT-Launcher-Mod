package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_LandRover_KeepCD extends CallbackCanbusBase {
    public static final int U_AIR_SEAT_LEFT = 123;
    public static final int U_AIR_SEAT_RIGHT = 124;
    public static final int U_CARINFO_D24_D1_B4 = 118;
    public static final int U_CARINFO_D24_D1_B5 = 119;
    public static final int U_CARINFO_D24_D1_B6 = 120;
    public static final int U_CARINF_D12_D1_B70 = 109;
    public static final int U_CARSET_FRONT_AIRMODE = 126;
    public static final int U_CARSET_FRONT_BLOW = 129;
    public static final int U_CARSET_FRONT_TEMP = 125;
    public static final int U_CARSET_GUIJI_TYPE = 130;
    public static final int U_CARSET_PANEL_TYPE = 131;
    public static final int U_CARSET_REAR_AIRMODE = 128;
    public static final int U_CARSET_REAR_TEMP = 127;
    public static final int U_CAR_ANDROID_UI_VOL = 114;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_LVDS_MODE = 110;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_PANNEL_TYPE = 117;
    public static final int U_CAR_SCREEN_H = 112;
    public static final int U_CAR_SCREEN_TYPE = 116;
    public static final int U_CAR_SCREEN_W = 111;
    public static final int U_CAR_SET_TYPE = 121;
    public static final int U_CAR_STEER_CTRL_TYPE = 122;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_TOUCH_TYPE = 115;
    public static final int U_CAR_UI_VOL = 113;
    public static final int U_CNT_MAX = 132;
    public static int modevalue = -1;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 132; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0453_LZ_LandRover_All(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 132) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
