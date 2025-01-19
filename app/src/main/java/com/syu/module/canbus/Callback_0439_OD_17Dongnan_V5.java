package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_OD_17Dongnan_V5 extends CallbackCanbusBase {
    public static final int CMD_SET_CTRL = 0;
    public static final int U_CARSET_INFO1 = 18;
    public static final int U_CARSET_INFO2 = 19;
    public static final int U_CARSET_INFO3 = 20;
    public static final int U_CARSET_INFO4 = 21;
    public static final int U_CAR_INFO1 = 13;
    public static final int U_CAR_INFO2 = 14;
    public static final int U_CAR_INFO3 = 15;
    public static final int U_CAR_INFO4 = 16;
    public static final int U_CAR_INFO5 = 17;
    public static final int U_CNT_MAX = 22;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_PRESSURE_FL = 9;
    public static final int U_PRESSURE_FR = 10;
    public static final int U_PRESSURE_RL = 11;
    public static final int U_PRESSURE_RR = 12;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 22; i++) {
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
        if (updateCode >= 0 && updateCode < 22) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
