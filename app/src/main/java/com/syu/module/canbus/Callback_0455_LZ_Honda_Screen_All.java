package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0455_LZ_Honda_Screen_All extends CallbackCanbusBase {
    public static final int U_CAR_ANDROID_UI_VOL = 106;
    public static final int U_CAR_BACKCAR_UI = 98;
    public static final int U_CAR_LVDS_TYPE = 100;
    public static final int U_CAR_SCREEN_H = 104;
    public static final int U_CAR_SCREEN_TYPE = 99;
    public static final int U_CAR_SCREEN_W = 103;
    public static final int U_CAR_UI_VOL = 105;
    public static final int U_CAR_VOICE_ANDROID = 102;
    public static final int U_CNT_MAX = 107;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 101;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
