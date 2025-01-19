package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LUZ_BMW_Mini extends CallbackCanbusBase {
    public static final int U_CARINF_D19_D0_B30 = 37;
    public static final int U_CARINF_D19_D0_B6 = 36;
    public static final int U_CARINF_D19_D0_B7 = 35;
    public static final int U_CARINF_D19_D1_B0 = 45;
    public static final int U_CARINF_D19_D1_B1 = 44;
    public static final int U_CARINF_D19_D1_B2 = 43;
    public static final int U_CARINF_D19_D1_B3 = 42;
    public static final int U_CARINF_D19_D1_B4 = 41;
    public static final int U_CARINF_D19_D1_B5 = 40;
    public static final int U_CARINF_D19_D1_B6 = 39;
    public static final int U_CARINF_D19_D1_B7 = 38;
    public static final int U_CARINF_D19_D2_B0 = 46;
    public static final int U_CARINF_D19_D3_B70 = 47;
    public static final int U_CARINF_D19_D4_B70 = 48;
    public static final int U_CARINF_D19_D5_B70 = 49;
    public static final int U_CARINF_D34_D0_B70 = 7;
    public static final int U_CARINF_D34_D1_B70 = 8;
    public static final int U_CARINF_D34_D2_D3 = 9;
    public static final int U_CARINF_D34_D4_B70 = 10;
    public static final int U_CARINF_D34_D5_D6 = 11;
    public static final int U_CARINF_D34_D7_D8 = 12;
    public static final int U_CARINF_D34_D9_D10 = 13;
    public static final int U_CARINF_D35_D0_D1 = 14;
    public static final int U_CARINF_D35_D2_D3 = 15;
    public static final int U_CARINF_D35_D4_D5 = 16;
    public static final int U_CARINF_D36_D0_B4 = 33;
    public static final int U_CARINF_D36_D0_B5 = 32;
    public static final int U_CARINF_D36_D0_B6 = 31;
    public static final int U_CARINF_D36_D0_B7 = 30;
    public static final int U_CARINF_D38_D0_B0 = 24;
    public static final int U_CARINF_D38_D0_B1 = 23;
    public static final int U_CARINF_D38_D0_B2 = 22;
    public static final int U_CARINF_D38_D0_B3 = 21;
    public static final int U_CARINF_D38_D0_B4 = 20;
    public static final int U_CARINF_D38_D0_B5 = 19;
    public static final int U_CARINF_D38_D0_B6 = 18;
    public static final int U_CARINF_D38_D0_B7 = 17;
    public static final int U_CARINF_D38_D1_B4 = 34;
    public static final int U_CARINF_D38_D1_B65 = 26;
    public static final int U_CARINF_D38_D1_B7 = 25;
    public static final int U_CARINF_D38_D2_B70 = 27;
    public static final int U_CARINF_D38_D3_D4 = 28;
    public static final int U_CARINF_D38_D5_B70 = 29;
    public static final int U_CNT_MAX = 50;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 50; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
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
        if (updateCode >= 0 && updateCode < 50) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
