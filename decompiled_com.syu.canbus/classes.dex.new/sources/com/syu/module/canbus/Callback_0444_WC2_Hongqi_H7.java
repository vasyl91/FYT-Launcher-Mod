package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0444_WC2_Hongqi_H7;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0444_WC2_Hongqi_H7 extends CallbackCanbusBase {
    public static final int U_CARSET_D61_D0_B0 = 100;
    public static final int U_CARSET_D61_D0_B1 = 99;
    public static final int U_CARSET_D61_D0_B32 = 98;
    public static final int U_CARSET_D61_D0_B64 = 118;
    public static final int U_CARSET_D61_D0_B7 = 117;
    public static final int U_CARSET_D61_D1_B0 = 104;
    public static final int U_CARSET_D61_D1_B1 = 103;
    public static final int U_CARSET_D61_D1_B2 = 102;
    public static final int U_CARSET_D61_D1_B3 = 101;
    public static final int U_CARSET_D61_D1_B4 = 116;
    public static final int U_CARSET_D61_D1_B65 = 120;
    public static final int U_CARSET_D61_D1_B7 = 119;
    public static final int U_CARSET_D61_D2_B70 = 105;
    public static final int U_CARSET_D61_D3_D4 = 106;
    public static final int U_CARSET_D61_D5_D6 = 107;
    public static final int U_CARSET_D61_D7_B0 = 127;
    public static final int U_CARSET_D61_D7_B1 = 126;
    public static final int U_CARSET_D61_D7_B2 = 125;
    public static final int U_CARSET_D61_D7_B3 = 124;
    public static final int U_CARSET_D61_D7_B54 = 123;
    public static final int U_CARSET_D61_D7_B6 = 122;
    public static final int U_CARSET_D61_D7_B7 = 121;
    public static final int U_CARSET_D62_D0_B30 = 128;
    public static final int U_CARSET_D62_D0_B4 = 129;
    public static final int U_CARSET_D62_D0_B65 = 131;
    public static final int U_CARSET_D62_D0_B7 = 130;
    public static final int U_CARSET_D62_D1_B10 = 136;
    public static final int U_CARSET_D62_D1_B2 = 135;
    public static final int U_CARSET_D62_D1_B3 = 134;
    public static final int U_CARSET_D62_D1_B4 = 133;
    public static final int U_CARSET_D62_D1_B5 = 132;
    public static final int U_CARTIRE_D48_D2_B70 = 108;
    public static final int U_CARTIRE_D48_D3_B70 = 109;
    public static final int U_CARTIRE_D48_D4_B70 = 110;
    public static final int U_CARTIRE_D48_D5_B70 = 111;
    public static final int U_CARTIRE_D48_D6_B70 = 112;
    public static final int U_CARTIRE_D48_D7_B70 = 113;
    public static final int U_CARTIRE_D48_D8_B70 = 114;
    public static final int U_CARTIRE_D48_D9_B70 = 115;
    public static final int U_CNT_MAX = 137;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 137; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0444_WC2_Hongqi_H7(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 137) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
