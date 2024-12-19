package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Maserati300C;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_Maserati_300C extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 148;
    public static final int U_CARINFO_EQ_BASS = 144;
    public static final int U_CARINFO_EQ_CARVOL = 149;
    public static final int U_CARINFO_EQ_FAD = 147;
    public static final int U_CARINFO_EQ_MID = 145;
    public static final int U_CARINFO_EQ_SPEEDVOL = 151;
    public static final int U_CARINFO_EQ_SUROUND = 150;
    public static final int U_CARINFO_EQ_TREB = 146;
    public static final int U_CARINF_BEGIN = 86;
    public static final int U_CARINF_D38_D0_B10 = 92;
    public static final int U_CARINF_D38_D0_B2 = 91;
    public static final int U_CARINF_D38_D0_B3 = 90;
    public static final int U_CARINF_D38_D0_B4 = 89;
    public static final int U_CARINF_D38_D0_B65 = 88;
    public static final int U_CARINF_D38_D0_B7 = 87;
    public static final int U_CARINF_D38_D1_B0 = 99;
    public static final int U_CARINF_D38_D1_B1 = 98;
    public static final int U_CARINF_D38_D1_B2 = 97;
    public static final int U_CARINF_D38_D1_B3 = 96;
    public static final int U_CARINF_D38_D1_B4 = 95;
    public static final int U_CARINF_D38_D1_B5 = 94;
    public static final int U_CARINF_D38_D1_B76 = 93;
    public static final int U_CARINF_D38_D2_B0 = 107;
    public static final int U_CARINF_D38_D2_B1 = 106;
    public static final int U_CARINF_D38_D2_B2 = 105;
    public static final int U_CARINF_D38_D2_B3 = 104;
    public static final int U_CARINF_D38_D2_B4 = 103;
    public static final int U_CARINF_D38_D2_B5 = 102;
    public static final int U_CARINF_D38_D2_B6 = 101;
    public static final int U_CARINF_D38_D2_B7 = 100;
    public static final int U_CARINF_D38_D3_B0 = 113;
    public static final int U_CARINF_D38_D3_B1 = 112;
    public static final int U_CARINF_D38_D3_B2 = 111;
    public static final int U_CARINF_D38_D3_B3 = 110;
    public static final int U_CARINF_D38_D3_B54 = 109;
    public static final int U_CARINF_D38_D3_B76 = 108;
    public static final int U_CARINF_D38_D4_B70 = 114;
    public static final int U_CARINF_D38_D5_B0 = 122;
    public static final int U_CARINF_D38_D5_B1 = 121;
    public static final int U_CARINF_D38_D5_B2 = 120;
    public static final int U_CARINF_D38_D5_B3 = 119;
    public static final int U_CARINF_D38_D5_B4 = 118;
    public static final int U_CARINF_D38_D5_B5 = 117;
    public static final int U_CARINF_D38_D5_B6 = 116;
    public static final int U_CARINF_D38_D5_B7 = 115;
    public static final int U_CARINF_D38_D6_B10 = 126;
    public static final int U_CARINF_D38_D6_B32 = 125;
    public static final int U_CARINF_D38_D6_B54 = 124;
    public static final int U_CARINF_D38_D6_B76 = 123;
    public static final int U_CARINF_D38_D7_B0 = 132;
    public static final int U_CARINF_D38_D7_B1 = 131;
    public static final int U_CARINF_D38_D7_B2 = 130;
    public static final int U_CARINF_D38_D7_B3 = 129;
    public static final int U_CARINF_D38_D7_B54 = 128;
    public static final int U_CARINF_D38_D7_B76 = 127;
    public static final int U_CARINF_D38_D8_B10 = 139;
    public static final int U_CARINF_D38_D8_B2 = 138;
    public static final int U_CARINF_D38_D8_B3 = 137;
    public static final int U_CARINF_D38_D8_B4 = 136;
    public static final int U_CARINF_D38_D8_B5 = 135;
    public static final int U_CARINF_D38_D8_B6 = 134;
    public static final int U_CARINF_D38_D8_B7 = 133;
    public static final int U_CARINF_D38_D9_B21 = 143;
    public static final int U_CARINF_D38_D9_B3 = 142;
    public static final int U_CARINF_D38_D9_B54 = 141;
    public static final int U_CARINF_D38_D9_B76 = 140;
    public static final int U_CNT_MAX = 152;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0453_LZ_Maserati300C(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 152) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
