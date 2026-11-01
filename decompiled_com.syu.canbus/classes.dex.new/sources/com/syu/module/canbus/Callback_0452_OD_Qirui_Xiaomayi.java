package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0452_OD_Qirui_Xiaomayi extends CallbackCanbusBase {
    public static final int U_CARSET_D41_D0_B0 = 109;
    public static final int U_CARSET_D41_D0_B1 = 108;
    public static final int U_CARSET_D41_D0_B2 = 107;
    public static final int U_CARSET_D41_D0_B3 = 102;
    public static final int U_CARSET_D41_D0_B4 = 101;
    public static final int U_CARSET_D41_D0_B5 = 100;
    public static final int U_CARSET_D41_D0_B6 = 99;
    public static final int U_CARSET_D41_D0_B7 = 98;
    public static final int U_CARSET_D41_D1_B70 = 103;
    public static final int U_CARSET_D41_D2_B70 = 104;
    public static final int U_CARSET_D41_D3_B0 = 112;
    public static final int U_CARSET_D41_D3_B21 = 111;
    public static final int U_CARSET_D41_D3_B3 = 110;
    public static final int U_CARSET_D41_D4_B30 = 113;
    public static final int U_CARSET_D41_D5_B70 = 114;
    public static final int U_CARSET_D41_D6_B20 = 117;
    public static final int U_CARSET_D41_D6_B3 = 116;
    public static final int U_CARSET_D41_D6_B4 = 115;
    public static final int U_CARSET_D41_D7_B0 = 120;
    public static final int U_CARSET_D41_D7_B31 = 119;
    public static final int U_CARSET_D41_D7_B74 = 118;
    public static final int U_CARSET_D44_D0_D1 = 105;
    public static final int U_CARSET_D44_D2_B70 = 106;
    public static final int U_CNT_MAX = 121;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 121; i++) {
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
        if (updateCode >= 0 && updateCode < 121) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
