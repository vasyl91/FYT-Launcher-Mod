package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0456_ZH2_Logistics_HT002 extends CallbackCanbusBase {
    public static final int U_CARINF_D23_D0_B2 = 7;
    public static final int U_CARINF_D23_D0_B3 = 8;
    public static final int U_CARINF_D23_D0_B74 = 9;
    public static final int U_CARINF_D23_D1_B70 = 10;
    public static final int U_CARINF_D23_D3_B6 = 11;
    public static final int U_CARINF_D23_D3_B7 = 12;
    public static final int U_CARINF_D23_D4_B30 = 13;
    public static final int U_CARINF_D23_D5_B70 = 26;
    public static final int U_CARINF_D30_D0_D1 = 14;
    public static final int U_CARINF_D30_D2_D3 = 15;
    public static final int U_CARINF_D30_D4_B70 = 16;
    public static final int U_CARINF_D30_D5_D6 = 17;
    public static final int U_CARINF_D31_D0_B70 = 18;
    public static final int U_CARINF_D31_D1_B70 = 19;
    public static final int U_CARINF_D31_D2_B70 = 20;
    public static final int U_CARINF_D31_D3_B70 = 21;
    public static final int U_CARINF_D31_D4_B70 = 22;
    public static final int U_CARINF_D31_D5_B70 = 23;
    public static final int U_CARINF_D31_D6_B70 = 24;
    public static final int U_CARINF_D31_D7_B70 = 25;
    public static final int U_CNT_MAX = 27;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 27; i++) {
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
        if (updateCode >= 0 && updateCode < 27) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
