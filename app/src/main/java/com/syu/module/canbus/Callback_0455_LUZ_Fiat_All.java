package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0455_LUZ_Fiat_All extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D10_B7 = 9;
    public static final int U_CARINF_D35_D2_D3 = 7;
    public static final int U_CARINF_D35_D7_D9 = 8;
    public static final int U_CARINF_D37_D0_B70 = 10;
    public static final int U_CARINF_D37_D10_D11 = 18;
    public static final int U_CARINF_D37_D12_D13 = 19;
    public static final int U_CARINF_D37_D14_B65 = 21;
    public static final int U_CARINF_D37_D14_B7 = 20;
    public static final int U_CARINF_D37_D1_B70 = 11;
    public static final int U_CARINF_D37_D2_B70 = 12;
    public static final int U_CARINF_D37_D3_D4 = 13;
    public static final int U_CARINF_D37_D5_D6 = 14;
    public static final int U_CARINF_D37_D7_B70 = 15;
    public static final int U_CARINF_D37_D8_B70 = 16;
    public static final int U_CARINF_D37_D9_B70 = 17;
    public static final int U_CNT_MAX = 22;

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
        if (updateCode >= 0 && updateCode >= 0 && updateCode < 22) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
