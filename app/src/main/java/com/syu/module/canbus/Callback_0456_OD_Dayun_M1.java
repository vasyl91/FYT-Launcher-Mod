package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0456_OD_Dayun_M1 extends CallbackCanbusBase {
    public static final int U_CARINF_D31_D0_B20 = 99;
    public static final int U_CARINF_D31_D0_B7 = 98;
    public static final int U_CARINF_D31_D1_B70 = 100;
    public static final int U_CARINF_D31_D2_B6 = 102;
    public static final int U_CARINF_D31_D2_B7 = 101;
    public static final int U_CARINF_D31_D3_B10 = 107;
    public static final int U_CARINF_D31_D3_B4 = 106;
    public static final int U_CARINF_D31_D3_B5 = 105;
    public static final int U_CARINF_D31_D3_B6 = 104;
    public static final int U_CARINF_D31_D3_B7 = 103;
    public static final int U_CARINF_D31_D4_B60 = 109;
    public static final int U_CARINF_D31_D4_B7 = 108;
    public static final int U_CARINF_D40_D0_D1 = 110;
    public static final int U_CARINF_D40_D2_D3 = 111;
    public static final int U_CARINF_D40_D4_B70 = 112;
    public static final int U_CARINF_D40_D5_D6 = 113;
    public static final int U_CARINF_D40_D7_B70 = 114;
    public static final int U_CNT_MAX = 115;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 115) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
