package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_Bagu_360Guiji extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 7;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 7; i++) {
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
        if (updateCode >= 0 && updateCode < 7) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
