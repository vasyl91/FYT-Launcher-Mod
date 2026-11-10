package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_LZ_Dodge_Ram1500;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0455_LZ_Dodge_RAM1500 extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 138;
    public static final int U_CARINFO_EQ_BASS = 140;
    public static final int U_CARINFO_EQ_FAD = 139;
    public static final int U_CARINFO_EQ_MID = 141;
    public static final int U_CARINFO_EQ_SPEEDVOL = 144;
    public static final int U_CARINFO_EQ_SUROUND = 143;
    public static final int U_CARINFO_EQ_TREB = 142;
    public static final int U_CARINFO_EQ_VOL = 137;
    public static final int U_CARINF_D38_D0_B10 = 103;
    public static final int U_CARINF_D38_D0_B2 = 102;
    public static final int U_CARINF_D38_D0_B3 = 101;
    public static final int U_CARINF_D38_D0_B4 = 100;
    public static final int U_CARINF_D38_D0_B65 = 99;
    public static final int U_CARINF_D38_D0_B7 = 98;
    public static final int U_CARINF_D38_D10_B21 = 160;
    public static final int U_CARINF_D38_D10_B3 = 159;
    public static final int U_CARINF_D38_D10_B4 = 158;
    public static final int U_CARINF_D38_D10_B5 = 133;
    public static final int U_CARINF_D38_D10_B6 = 132;
    public static final int U_CARINF_D38_D10_B7 = 131;
    public static final int U_CARINF_D38_D11_B70 = 161;
    public static final int U_CARINF_D38_D1_B0 = 108;
    public static final int U_CARINF_D38_D1_B1 = 107;
    public static final int U_CARINF_D38_D1_B4 = 106;
    public static final int U_CARINF_D38_D1_B5 = 105;
    public static final int U_CARINF_D38_D1_B76 = 104;
    public static final int U_CARINF_D38_D2_B0 = 115;
    public static final int U_CARINF_D38_D2_B1 = 114;
    public static final int U_CARINF_D38_D2_B2 = 113;
    public static final int U_CARINF_D38_D2_B3 = 112;
    public static final int U_CARINF_D38_D2_B4 = 111;
    public static final int U_CARINF_D38_D2_B5 = 110;
    public static final int U_CARINF_D38_D2_B6 = 109;
    public static final int U_CARINF_D38_D2_B7 = 171;
    public static final int U_CARINF_D38_D3_B0 = 170;
    public static final int U_CARINF_D38_D3_B1 = 145;
    public static final int U_CARINF_D38_D3_B2 = 118;
    public static final int U_CARINF_D38_D3_B3 = 117;
    public static final int U_CARINF_D38_D3_B76 = 116;
    public static final int U_CARINF_D38_D4_B70 = 119;
    public static final int U_CARINF_D38_D5_B4 = 121;
    public static final int U_CARINF_D38_D5_B5 = 147;
    public static final int U_CARINF_D38_D5_B6 = 146;
    public static final int U_CARINF_D38_D5_B7 = 120;
    public static final int U_CARINF_D38_D6_B10 = 149;
    public static final int U_CARINF_D38_D6_B32 = 148;
    public static final int U_CARINF_D38_D6_B54 = 123;
    public static final int U_CARINF_D38_D6_B76 = 122;
    public static final int U_CARINF_D38_D7_B1 = 153;
    public static final int U_CARINF_D38_D7_B2 = 152;
    public static final int U_CARINF_D38_D7_B54 = 151;
    public static final int U_CARINF_D38_D7_B76 = 150;
    public static final int U_CARINF_D38_D8_B10 = 129;
    public static final int U_CARINF_D38_D8_B2 = 128;
    public static final int U_CARINF_D38_D8_B3 = 127;
    public static final int U_CARINF_D38_D8_B4 = 126;
    public static final int U_CARINF_D38_D8_B5 = 125;
    public static final int U_CARINF_D38_D8_B6 = 124;
    public static final int U_CARINF_D38_D8_B7 = 154;
    public static final int U_CARINF_D38_D9_B21 = 157;
    public static final int U_CARINF_D38_D9_B3 = 130;
    public static final int U_CARINF_D38_D9_B54 = 156;
    public static final int U_CARINF_D38_D9_B76 = 155;
    public static final int U_CARINF_D3A_D0_B30 = 135;
    public static final int U_CARINF_D3A_D0_B7 = 134;
    public static final int U_CARINF_D3A_D1_B70 = 136;
    public static final int U_CDC_D3B_D0_B30 = 163;
    public static final int U_CDC_D3B_D0_B7 = 162;
    public static final int U_CDC_D3B_D1_B30 = 165;
    public static final int U_CDC_D3B_D1_B74 = 164;
    public static final int U_CDC_D3B_D2_B70 = 166;
    public static final int U_CDC_D3B_D3_B70 = 167;
    public static final int U_CDC_D3B_D4_D5 = 168;
    public static final int U_CDC_D3B_D6_D7 = 169;
    public static final int U_CNT_MAX = 172;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 172; i++) {
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
        if (TheApp.getScreenWidth() < 1200 || TheApp.getConfiguration() != 1) {
            AirHelper.getInstance().buildUi(new Air_0455_LZ_Dodge_Ram1500(TheApp.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
        if (updateCode >= 0 && updateCode < 172) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
