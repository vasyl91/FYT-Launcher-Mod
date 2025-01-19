package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0412_XP1_YearGmcSeries extends CallbackCanbusBase {
    public static final int U_CARSET_D38_D0_B10 = 99;
    public static final int U_CARSET_D38_D0_B2 = 100;
    public static final int U_CARSET_D38_D0_B3 = 101;
    public static final int U_CARSET_D38_D0_B4 = 102;
    public static final int U_CARSET_D38_D0_B5 = 103;
    public static final int U_CARSET_D38_D0_B6 = 104;
    public static final int U_CARSET_D38_D0_B7 = 105;
    public static final int U_CARSET_D38_D1_B0 = 106;
    public static final int U_CARSET_D38_D1_B1 = 107;
    public static final int U_CARSET_D38_D1_B2 = 108;
    public static final int U_CARSET_D38_D1_B3 = 109;
    public static final int U_CARSET_D38_D1_B4 = 110;
    public static final int U_CARSET_D38_D1_B75 = 111;
    public static final int U_CARSET_D38_D2_B0 = 112;
    public static final int U_CARSET_D38_D2_B1 = 113;
    public static final int U_CARSET_D38_D2_B2 = 114;
    public static final int U_CARSET_D38_D2_B3 = 115;
    public static final int U_CARSET_D38_D2_B4 = 116;
    public static final int U_CARSET_D38_D3_B70 = 117;
    public static final int U_CAR_SPEED = 98;
    public static final int U_CNT_MAX = 118;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
