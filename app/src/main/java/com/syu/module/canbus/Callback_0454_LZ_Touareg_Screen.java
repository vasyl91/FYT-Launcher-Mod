package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0454_LZ_Touareg_Screen;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_LZ_Touareg_Screen extends CallbackCanbusBase {
    public static final int U_CARSET_D35_D2_D3 = 109;
    public static final int U_CARSET_D35_D7_D10 = 110;
    public static final int U_CAR_ANDROID_UI_VOL = 114;
    public static final int U_CAR_AUDI_TYPE = 117;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_D39_D0_B70 = 118;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_LVDS_MODE = 116;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_SCREEN_H = 112;
    public static final int U_CAR_SCREEN_W = 111;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_UI_VOL = 113;
    public static final int U_CAR_VOICE_ANDROID = 115;
    public static final int U_CNT_MAX = 119;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0454_LZ_Touareg_Screen(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
