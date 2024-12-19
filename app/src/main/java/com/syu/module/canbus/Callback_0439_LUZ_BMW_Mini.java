package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LUZ_BMW_Mini extends CallbackCanbusBase {
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
    public static final int U_CARINF_D38_D1_B65 = 26;
    public static final int U_CARINF_D38_D1_B7 = 25;
    public static final int U_CARINF_D38_D2_B70 = 27;
    public static final int U_CARINF_D38_D3_D4 = 28;
    public static final int U_CARINF_D38_D5_B70 = 29;
    public static final int U_CNT_MAX = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
