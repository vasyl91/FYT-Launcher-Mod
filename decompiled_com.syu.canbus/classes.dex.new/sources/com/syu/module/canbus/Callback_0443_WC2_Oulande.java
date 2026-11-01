package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Oulande;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Oulande extends CallbackCanbusBase {
    public static final int U_ALARMINFO_BEGIN = 105;
    public static final int U_ALARMINFO_END = 114;
    public static final int U_ALARMINFO_INFO1 = 107;
    public static final int U_ALARMINFO_INFO2 = 108;
    public static final int U_ALARMINFO_INFO3 = 109;
    public static final int U_ALARMINFO_INFO4 = 110;
    public static final int U_ALARMINFO_INFO5 = 111;
    public static final int U_ALARMINFO_INFO6 = 112;
    public static final int U_ALARMINFO_INFO7 = 113;
    public static final int U_ALARMINFO_NUM = 106;
    public static final int U_CARINF_D18_D0_D1 = 122;
    public static final int U_CARINF_D18_D10_D11 = 130;
    public static final int U_CARINF_D18_D2_D3 = 123;
    public static final int U_CARINF_D18_D4_B70 = 124;
    public static final int U_CARINF_D18_D5_B70 = 125;
    public static final int U_CARINF_D18_D6_B70 = 126;
    public static final int U_CARINF_D18_D7_B70 = 127;
    public static final int U_CARINF_D18_D8_B70 = 128;
    public static final int U_CARINF_D18_D9_B70 = 129;
    public static final int U_CARINF_D1F_D0_B30 = 147;
    public static final int U_CARINF_D1F_D0_B7 = 146;
    public static final int U_CARINF_D1F_D1_B4 = 151;
    public static final int U_CARINF_D1F_D1_B5 = 150;
    public static final int U_CARINF_D1F_D1_B6 = 149;
    public static final int U_CARINF_D1F_D1_B7 = 148;
    public static final int U_CARINF_D32_D13_B70 = 121;
    public static final int U_CARINF_D32_D6_B70 = 119;
    public static final int U_CARINF_D32_D9_B70 = 120;
    public static final int U_CARINF_D34_D12_D13 = 118;
    public static final int U_CARINF_D34_D14_D15 = 158;
    public static final int U_CARINF_D34_D16_D17 = 159;
    public static final int U_CARINF_D34_D18_B70 = 160;
    public static final int U_CARINF_D34_D2_D3 = 157;
    public static final int U_CARINF_D34_D4_D5_D6 = 115;
    public static final int U_CARINF_D34_D7_D8 = 116;
    public static final int U_CARINF_D34_D9_D10_D11 = 117;
    public static final int U_CARINF_D48_D2_B70 = 131;
    public static final int U_CARINF_D48_D3_B70 = 132;
    public static final int U_CARINF_D48_D4_B70 = 133;
    public static final int U_CARINF_D48_D5_B70 = 134;
    public static final int U_CARINF_D50_T1_D2_B70 = 161;
    public static final int U_CARINF_D50_T1_D3_D4 = 162;
    public static final int U_CARINF_D50_T1_D5_D6 = 163;
    public static final int U_CARINF_D50_T1_D7_B70 = 164;
    public static final int U_CARINF_D50_T2_D2_B70 = 165;
    public static final int U_CARINF_D50_T2_D3_D4 = 166;
    public static final int U_CARINF_D50_T2_D5_D6 = 167;
    public static final int U_CARINF_D50_T2_D7_B70 = 168;
    public static final int U_CARINF_D50_T3_D2_B70 = 169;
    public static final int U_CARINF_D50_T3_D3_D4 = 170;
    public static final int U_CARINF_D50_T3_D5_D6 = 171;
    public static final int U_CARINF_D50_T3_D7_B70 = 172;
    public static final int U_CARINF_D50_T4_D2_B70 = 173;
    public static final int U_CARINF_D50_T4_D3_D4 = 174;
    public static final int U_CARINF_D50_T4_D5_D6 = 175;
    public static final int U_CARINF_D50_T4_D7_B70 = 176;
    public static final int U_CARINF_D50_T5_D2_B70 = 177;
    public static final int U_CARINF_D50_T5_D3_D4 = 178;
    public static final int U_CARINF_D50_T5_D5_D6 = 179;
    public static final int U_CARINF_D50_T5_D7_B70 = 180;
    public static final int U_CARSET_D5E_D0_B70 = 153;
    public static final int U_CARSET_D5E_D1_B70 = 154;
    public static final int U_CARSET_D5E_D2_B70 = 155;
    public static final int U_CARSET_D5E_D3_B70 = 156;
    public static final int U_CARSET_D61_D0_B20 = 137;
    public static final int U_CARSET_D61_D0_B54 = 136;
    public static final int U_CARSET_D61_D0_B6 = 135;
    public static final int U_CARSET_D61_D0_B7 = 152;
    public static final int U_CARSET_D61_D1_B20 = 140;
    public static final int U_CARSET_D61_D1_B43 = 139;
    public static final int U_CARSET_D61_D1_B75 = 138;
    public static final int U_CARSET_D61_D2_B0 = 145;
    public static final int U_CARSET_D61_D2_B21 = 144;
    public static final int U_CARSET_D61_D2_B3 = 143;
    public static final int U_CARSET_D61_D2_B54 = 142;
    public static final int U_CARSET_D61_D2_B76 = 141;
    public static final int U_CNT_MAX = 181;
    public static final int U_LIGHT_BEGIN = 97;
    public static final int U_LIGHT_END = 105;
    public static final int U_LIGHT_FARLIGHT = 99;
    public static final int U_LIGHT_FRONTFOGFLIGHT = 101;
    public static final int U_LIGHT_LEFTTURNLIGHT = 104;
    public static final int U_LIGHT_NEARLIGHT = 98;
    public static final int U_LIGHT_REARLIGHT = 102;
    public static final int U_LIGHT_RIGHTTURNLIGHT = 103;
    public static final int U_LIGHT_WIDTHLIGHT = 100;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 181; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Oulande(TheApp.getInstance()));
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
        if (updateCode >= 0 && updateCode < 181) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
