package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0444_WC2_Wuling_All extends CallbackCanbusBase {
    public static final int U_CARSER_D31_D8_B0 = 101;
    public static final int U_CARSER_D31_D8_B1 = 100;
    public static final int U_CARSER_D31_D8_B2 = 99;
    public static final int U_CARSER_D31_D8_B3 = 98;
    public static final int U_CARSER_D61_D0_B0 = 119;
    public static final int U_CARSER_D61_D0_B1 = 104;
    public static final int U_CARSER_D61_D0_B2 = 103;
    public static final int U_CARSER_D61_D0_B3 = 123;
    public static final int U_CARSER_D61_D0_B54 = 118;
    public static final int U_CARSER_D61_D0_B76 = 102;
    public static final int U_CARSER_D61_D1_B0 = 109;
    public static final int U_CARSER_D61_D1_B1 = 108;
    public static final int U_CARSER_D61_D1_B32 = 107;
    public static final int U_CARSER_D61_D1_B54 = 106;
    public static final int U_CARSER_D61_D1_B76 = 105;
    public static final int U_CARSER_D61_D2_B0 = 115;
    public static final int U_CARSER_D61_D2_B1 = 114;
    public static final int U_CARSER_D61_D2_B2 = 113;
    public static final int U_CARSER_D61_D2_B3 = 112;
    public static final int U_CARSER_D61_D2_B54 = 111;
    public static final int U_CARSER_D61_D2_B6 = 110;
    public static final int U_CARSER_D61_D2_B7 = 124;
    public static final int U_CARSER_D61_D3_B60 = 117;
    public static final int U_CARSER_D61_D3_B7 = 116;
    public static final int U_CARSER_D61_D4_B3 = 121;
    public static final int U_CARSER_D61_D4_B74 = 120;
    public static final int U_CARSER_D61_D5_B54 = 125;
    public static final int U_CARSER_D61_D5_B76 = 122;
    public static final int U_CARSER_D61_D6_B30 = 127;
    public static final int U_CARSER_D61_D6_B74 = 126;
    public static final int U_CARSER_D61_D7_B74 = 128;
    public static final int U_CARSER_D63_D0_B6 = 130;
    public static final int U_CARSER_D63_D0_B7 = 129;
    public static final int U_CARSER_D63_D1_B70 = 131;
    public static final int U_CARSER_D63_D2_B70 = 132;
    public static final int U_CARSER_D63_D3_B70 = 133;
    public static final int U_CARSER_D63_D4_B70 = 134;
    public static final int U_CNT_MAX = 135;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 135; i++) {
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
        if (updateCode >= 0 && updateCode < 135) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
