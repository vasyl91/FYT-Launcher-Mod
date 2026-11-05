package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0444_WC2_Beiqi_Zhixing extends CallbackCanbusBase {
    public static final int U_CARINF_D32_D10_D12 = 101;
    public static final int U_CARINF_D32_D13_B70 = 102;
    public static final int U_CARINF_D32_D1_B70 = 98;
    public static final int U_CARINF_D32_D6_D7 = 99;
    public static final int U_CARINF_D32_D8_D9 = 100;
    public static final int U_CARINF_D48_D0_B70 = 103;
    public static final int U_CARINF_D48_D1_B70 = 104;
    public static final int U_CARINF_D48_D2_B70 = 105;
    public static final int U_CARINF_D48_D3_B70 = 106;
    public static final int U_CARINF_D48_D4_B70 = 107;
    public static final int U_CARINF_D48_D5_B70 = 108;
    public static final int U_CARINF_D48_D6_B70 = 109;
    public static final int U_CARINF_D48_D7_B70 = 110;
    public static final int U_CARSET_D61_D0_B4 = 114;
    public static final int U_CARSET_D61_D0_B5 = 113;
    public static final int U_CARSET_D61_D0_B6 = 112;
    public static final int U_CARSET_D61_D0_B7 = 111;
    public static final int U_CARSET_D61_D1_B53 = 117;
    public static final int U_CARSET_D61_D1_B6 = 116;
    public static final int U_CARSET_D61_D1_B7 = 115;
    public static final int U_CARSET_D61_D2_B4 = 119;
    public static final int U_CARSET_D61_D2_B75 = 118;
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
