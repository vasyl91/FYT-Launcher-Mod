package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_LZ_Ford_QuanshunT8_all;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0455_LZ_Ford_QuanshunT8 extends CallbackCanbusBase {
    public static final int U_CARINF_D29_T2_D1_B0 = 99;
    public static final int U_CARINF_D29_T2_D1_B1 = 98;
    public static final int U_CARINF_D29_T2_D6_D7 = 100;
    public static final int U_CARINF_D29_T2_D8_D10 = 101;
    public static final int U_CARINF_D29_T3_D1_B70 = 102;
    public static final int U_CARINF_D29_T3_D2_B70 = 103;
    public static final int U_CARINF_D29_T3_D3_B70 = 104;
    public static final int U_CARINF_D29_T3_D4_B70 = 105;
    public static final int U_CARINF_D29_T3_D5_B70 = 106;
    public static final int U_CARINF_D29_T3_D6_B70 = 107;
    public static final int U_CARINF_D29_T3_D7_B70 = 108;
    public static final int U_CARINF_D29_T3_D8_B70 = 109;
    public static final int U_CARINF_D29_T3_D9_B70 = 110;
    public static final int U_CARINF_D29_T4_D1_B70 = 111;
    public static final int U_CARINF_D29_T4_D2_D3 = 112;
    public static final int U_CARINF_D29_T4_D4_B70 = 113;
    public static final int U_CARSET_D31_D0_B30 = 115;
    public static final int U_CARSET_D31_D0_B74 = 114;
    public static final int U_CARSET_D31_D1_B0 = 123;
    public static final int U_CARSET_D31_D1_B1 = 122;
    public static final int U_CARSET_D31_D1_B2 = 121;
    public static final int U_CARSET_D31_D1_B3 = 120;
    public static final int U_CARSET_D31_D1_B4 = 119;
    public static final int U_CARSET_D31_D1_B5 = 118;
    public static final int U_CARSET_D31_D1_B6 = 117;
    public static final int U_CARSET_D31_D1_B7 = 116;
    public static final int U_CARSET_D31_D2_B6 = 125;
    public static final int U_CARSET_D31_D2_B7 = 124;
    public static final int U_CARSET_D31_D3_B74 = 126;
    public static final int U_CARSET_D65_T1_D1_B70 = 127;
    public static final int U_CARSET_D65_T1_D2_B70 = 128;
    public static final int U_CARSET_D65_T1_D3_D4 = 129;
    public static final int U_CARSET_D65_T1_D5_B70 = 130;
    public static final int U_CARSET_D65_T2_D1_B70 = 131;
    public static final int U_CARSET_D65_T2_D2_B70 = 132;
    public static final int U_CARSET_D65_T2_D3_D4 = 133;
    public static final int U_CARSET_D65_T2_D5_D6 = 134;
    public static final int U_CARSET_D65_T3_D1_B70 = 135;
    public static final int U_CARSET_D65_T3_D2_B70 = 136;
    public static final int U_CARSET_D65_T3_D3_B70 = 137;
    public static final int U_CARSET_D65_T3_D4_B70 = 138;
    public static final int U_CARSET_D65_T3_D5_B70 = 139;
    public static final int U_CARSET_D65_T4_D1_B70 = 140;
    public static final int U_CARSET_D65_T5_D1_B70 = 141;
    public static final int U_CARSET_D65_T5_D2_D3 = 142;
    public static final int U_CARSET_D65_T5_D4_D5 = 143;
    public static final int U_CARSET_D65_T6_D1_B7 = 144;
    public static final int U_CARSET_D65_T6_D2_B70 = 145;
    public static final int U_CARSET_D65_T7_D1_D2 = 146;
    public static final int U_CARSET_D65_T7_D3_D4 = 147;
    public static final int U_CARSET_D65_T8_D1_B70 = 148;
    public static final int U_CARSET_D65_T8_D2_D3 = 149;
    public static final int U_CARSET_D65_T8_D4_D5 = 150;
    public static final int U_CARSET_D65_T9_D1_B7 = 151;
    public static final int U_CARSET_D65_T9_D2_B70 = 152;
    public static final int U_CARSET_D65_TA_D1_B7 = 153;
    public static final int U_CARSET_D65_TA_D2_B70 = 154;
    public static final int U_CNT_MAX = 155;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 155; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0455_LZ_Ford_QuanshunT8_all(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 155) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
