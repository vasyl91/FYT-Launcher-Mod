package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0456_CZH_Xiandai_All extends CallbackCanbusBase {
    public static final int U_CARINF_D41_D0_B10 = 101;
    public static final int U_CARINF_D41_D0_B32 = 100;
    public static final int U_CARINF_D41_D0_B54 = 99;
    public static final int U_CARINF_D41_D0_B76 = 98;
    public static final int U_CARINF_D41_D1_B60 = 103;
    public static final int U_CARINF_D41_D1_B7 = 102;
    public static final int U_CARINF_D41_D2_B10 = 108;
    public static final int U_CARINF_D41_D2_B2 = 107;
    public static final int U_CARINF_D41_D2_B43 = 106;
    public static final int U_CARINF_D41_D2_B65 = 105;
    public static final int U_CARINF_D41_D2_B7 = 104;
    public static final int U_CARINF_D41_D3_B10 = 114;
    public static final int U_CARINF_D41_D3_B2 = 113;
    public static final int U_CARINF_D41_D3_B3 = 112;
    public static final int U_CARINF_D41_D3_B4 = 111;
    public static final int U_CARINF_D41_D3_B5 = 110;
    public static final int U_CARINF_D41_D3_B6 = 109;
    public static final int U_CARINF_D41_D4_B10 = 117;
    public static final int U_CARINF_D41_D4_B32 = 116;
    public static final int U_CARINF_D41_D4_B54 = 115;
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
        if (updateCode >= 0 && updateCode < 118) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
