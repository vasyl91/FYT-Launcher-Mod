package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0444_WC2_Porsche_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D14_D0_B70 = 99;
    public static final int U_CARINF_D14_D1_B70 = 100;
    public static final int U_CARINF_D14_D2_B70 = 101;
    public static final int U_CARINF_D14_D3_B0 = 102;
    public static final int U_CARINF_D14_D3_B1 = 103;
    public static final int U_CARINF_D14_D3_B2 = 104;
    public static final int U_CARINF_D14_D3_B3 = 105;
    public static final int U_CARINF_D14_D3_B45 = 106;
    public static final int U_CARINF_D14_D3_B67 = 107;
    public static final int U_CARINF_D14_D4_B0 = 108;
    public static final int U_CARINF_D14_D4_B1 = 109;
    public static final int U_CNT_MAX = 110;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
