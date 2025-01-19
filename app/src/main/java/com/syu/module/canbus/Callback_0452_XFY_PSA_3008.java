package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XFY_PSA_3008 extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 109;
    public static final int U_CARINF_D50_D0_D1 = 110;
    public static final int U_CARINF_D50_D2_D3 = 111;
    public static final int U_CARINF_D50_D4_D5 = 112;
    public static final int U_CARINF_D51_D0_D1 = 113;
    public static final int U_CARINF_D51_D2_D3 = 114;
    public static final int U_CARINF_D51_D4_D5 = 115;
    public static final int U_CARINF_D52_D0_D1 = 116;
    public static final int U_CARINF_D52_D2_D3 = 117;
    public static final int U_CARINF_D52_D4_D5 = 118;
    public static final int U_CARINF_JUMP = 119;
    public static final int U_CARSET_BEGIN = 97;
    public static final int U_CARSET_D26_D0_B0 = 98;
    public static final int U_CARSET_D26_D0_B1 = 99;
    public static final int U_CARSET_D26_D0_B2 = 100;
    public static final int U_CARSET_D26_D0_B3 = 101;
    public static final int U_CARSET_D26_D0_B64 = 102;
    public static final int U_CARSET_D26_D0_B7 = 103;
    public static final int U_CARSET_D26_D1_B2 = 104;
    public static final int U_CARSET_D26_D1_B3 = 105;
    public static final int U_CARSET_D26_D1_B4 = 106;
    public static final int U_CARSET_D26_D1_B5 = 107;
    public static final int U_CARSET_D26_D1_B76 = 108;
    public static final int U_CNT_MAX = 120;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
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
        if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
