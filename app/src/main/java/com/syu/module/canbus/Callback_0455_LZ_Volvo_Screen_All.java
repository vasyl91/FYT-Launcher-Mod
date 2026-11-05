package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0455_LZ_Volvo_Screen_All extends CallbackCanbusBase {
    public static final int U_CARSET_DA8_D0_B70 = 99;
    public static final int U_CAR_ALLSCREEN_ON = 102;
    public static final int U_CAR_ANDROID_UI_VOL = 101;
    public static final int U_CAR_BACKCAR_UI = 98;
    public static final int U_CAR_STEER_CTRL_TYPE = 103;
    public static final int U_CAR_UI_VOL = 100;
    public static final int U_CNT_MAX = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 104; i++) {
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
        if (updateCode >= 0 && updateCode < 104) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
