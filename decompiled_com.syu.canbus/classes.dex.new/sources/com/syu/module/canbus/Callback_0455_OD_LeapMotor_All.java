package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_Oudi_LeapMotor_T03;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0455_OD_LeapMotor_All extends CallbackCanbusBase {
    public static final int U_CARSET_D31_D0_B10 = 101;
    public static final int U_CARSET_D31_D0_B32 = 100;
    public static final int U_CARSET_D31_D0_B4 = 99;
    public static final int U_CARSET_D31_D0_B5 = 98;
    public static final int U_CARSET_D31_D1_B70 = 102;
    public static final int U_CARSET_D31_D2_B10 = 108;
    public static final int U_CARSET_D31_D2_B2 = 107;
    public static final int U_CARSET_D31_D2_B43 = 106;
    public static final int U_CARSET_D31_D2_B5 = 105;
    public static final int U_CARSET_D31_D2_B6 = 104;
    public static final int U_CARSET_D31_D2_B7 = 103;
    public static final int U_CARSET_D31_D3_B20 = 114;
    public static final int U_CARSET_D31_D3_B3 = 113;
    public static final int U_CARSET_D31_D3_B4 = 112;
    public static final int U_CARSET_D31_D3_B5 = 111;
    public static final int U_CARSET_D31_D3_B6 = 110;
    public static final int U_CARSET_D31_D3_B7 = 109;
    public static final int U_CARSET_D31_D4_B0 = 120;
    public static final int U_CARSET_D31_D4_B1 = 119;
    public static final int U_CARSET_D31_D4_B2 = 118;
    public static final int U_CARSET_D31_D4_B3 = 117;
    public static final int U_CARSET_D31_D4_B4 = 116;
    public static final int U_CARSET_D31_D4_B5 = 115;
    public static final int U_CARSET_D31_D5_B70 = 121;
    public static final int U_CARSET_D42_D0_B70 = 122;
    public static final int U_CARSET_D42_D1_B70 = 123;
    public static final int U_CARSET_D42_D2_B70 = 124;
    public static final int U_CARSET_D42_D3_D4 = 125;
    public static final int U_CARSET_D42_D5_D6 = 126;
    public static final int U_CARSET_D42_D7_D8 = 127;
    public static final int U_CARSET_D43_D0_D2 = 128;
    public static final int U_CARSET_D43_D12_D13 = 135;
    public static final int U_CARSET_D43_D14_B70 = 136;
    public static final int U_CARSET_D43_D15_B70 = 137;
    public static final int U_CARSET_D43_D16_B70 = 138;
    public static final int U_CARSET_D43_D17_B70 = 139;
    public static final int U_CARSET_D43_D18_D20 = 140;
    public static final int U_CARSET_D43_D21_D22 = 141;
    public static final int U_CARSET_D43_D23_B70 = 142;
    public static final int U_CARSET_D43_D3_D4 = 129;
    public static final int U_CARSET_D43_D5_B70 = 130;
    public static final int U_CARSET_D43_D6_B70 = 131;
    public static final int U_CARSET_D43_D7_B70 = 132;
    public static final int U_CARSET_D43_D8_B70 = 133;
    public static final int U_CARSET_D43_D9_D11 = 134;
    public static final int U_CARSET_D52_D0_B30 = 144;
    public static final int U_CARSET_D52_D0_B74 = 143;
    public static final int U_CARSET_D52_D1_B30 = 146;
    public static final int U_CARSET_D52_D1_B74 = 145;
    public static final int U_CARSET_D52_D2_B70 = 147;
    public static final int U_CARSET_D52_D3_B70 = 148;
    public static final int U_CARSET_D52_D4_B70 = 149;
    public static final int U_CARSET_D52_D5_B70 = 150;
    public static final int U_CNT_MAX = 151;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0455_Oudi_LeapMotor_T03(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 151) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
