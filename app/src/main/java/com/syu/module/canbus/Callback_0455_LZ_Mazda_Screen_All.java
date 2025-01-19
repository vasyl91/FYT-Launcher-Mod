package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0455_LZ_Mazda_Screen_All extends CallbackCanbusBase {
    public static final int U_CAR_ALLSCREEN_ON = 113;
    public static final int U_CAR_ANDROID_UI_VOL = 110;
    public static final int U_CAR_BACKCAR_DELAY_ON = 115;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_D38_D1_B70 = 112;
    public static final int U_CAR_D38_D2_B70 = 116;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_PTO_CARUI_ON = 114;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_UI_VOL = 109;
    public static final int U_CAR_VOICE_ANDROID = 111;
    public static final int U_CNT_MAX = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 117) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
