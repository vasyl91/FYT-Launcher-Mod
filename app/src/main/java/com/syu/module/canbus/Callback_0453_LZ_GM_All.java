package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_GM_All extends CallbackCanbusBase {
    public static final int U_CARSET_D35_D10_B70 = 123;
    public static final int U_CARSET_D35_D11_B6 = 125;
    public static final int U_CARSET_D35_D11_B7 = 124;
    public static final int U_CARSET_D35_D2_D3 = 121;
    public static final int U_CARSET_D35_D7_D8_D9 = 122;
    public static final int U_CARSET_D36_D0_D1 = 126;
    public static final int U_CARSET_D36_D2_B70 = 127;
    public static final int U_CARSET_D36_D3_B70 = 128;
    public static final int U_CARSET_D36_D4_B70 = 129;
    public static final int U_CARSET_D38_D0_B0 = 98;
    public static final int U_CARSET_D38_D0_B1 = 99;
    public static final int U_CARSET_D38_D0_B32 = 100;
    public static final int U_CARSET_D38_D0_B54 = 101;
    public static final int U_CARSET_D38_D0_B76 = 102;
    public static final int U_CARSET_D38_D1_B10 = 103;
    public static final int U_CARSET_D38_D1_B3 = 104;
    public static final int U_CARSET_D38_D2_B0 = 105;
    public static final int U_CARSET_D38_D2_B21 = 106;
    public static final int U_CARSET_D38_D2_B3 = 107;
    public static final int U_CARSET_D38_D2_B4 = 108;
    public static final int U_CARSET_D38_D2_B65 = 109;
    public static final int U_CARSET_D38_D2_B7 = 110;
    public static final int U_CARSET_D38_D3_B0 = 111;
    public static final int U_CARSET_D38_D3_B1 = 112;
    public static final int U_CARSET_D38_D3_B2 = 113;
    public static final int U_CARSET_D38_D3_B3 = 114;
    public static final int U_CARSET_D38_D3_B4 = 115;
    public static final int U_CARSET_D38_D3_B65 = 116;
    public static final int U_CARSET_D38_D3_B7 = 117;
    public static final int U_CARSET_D38_D4_B70 = 118;
    public static final int U_CARSET_D38_D5_B70 = 119;
    public static final int U_CARSET_D39_D0_B70 = 120;
    public static final int U_CNT_MAX = 130;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 130; i++) {
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
        if (updateCode >= 0 && updateCode < 130) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
