package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_RZC_Hongqi_H5 extends CallbackCanbusBase {
    public static final int U_CARINF_D52_D1_B70 = 7;
    public static final int U_CARINF_D52_D2_B70 = 8;
    public static final int U_CARINF_D52_D3_B70 = 9;
    public static final int U_CARINF_D52_D4_B70 = 10;
    public static final int U_CARINF_D52_D5_B70 = 11;
    public static final int U_CARINF_D52_D6_B70 = 12;
    public static final int U_CARINF_D52_D7_B70 = 13;
    public static final int U_CARINF_D52_D8_B70 = 14;
    public static final int U_CNT_MAX = 15;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 15; i++) {
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
        if (updateCode >= 0 && updateCode < 15) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
