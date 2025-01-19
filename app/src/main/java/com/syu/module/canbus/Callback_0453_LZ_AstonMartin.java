package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_AstonMartin extends CallbackCanbusBase {
    public static final int U_CARINF_D36_VINID = 110;
    public static final int U_CARINF_D38_D0_B0 = 105;
    public static final int U_CARINF_D38_D0_B1 = 104;
    public static final int U_CARINF_D38_D0_B2 = 103;
    public static final int U_CARINF_D38_D0_B3 = 102;
    public static final int U_CARINF_D38_D0_B4 = 101;
    public static final int U_CARINF_D38_D0_B5 = 100;
    public static final int U_CARINF_D38_D0_B6 = 99;
    public static final int U_CARINF_D38_D0_B7 = 98;
    public static final int U_CARINF_D38_D1_B43 = 108;
    public static final int U_CARINF_D38_D1_B65 = 107;
    public static final int U_CARINF_D38_D1_B7 = 106;
    public static final int U_CARINF_D39_D7_D8_D9 = 109;
    public static final int U_CNT_MAX = 111;
    public static String VinId = "";

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
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
        if (updateCode == 110) {
            if (strs != null && strs.length > 0) {
                VinId = strs[0];
            } else {
                VinId = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
