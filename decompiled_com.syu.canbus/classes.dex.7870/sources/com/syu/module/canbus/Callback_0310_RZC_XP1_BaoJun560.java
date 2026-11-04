package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0310_OD_Wuling_Xingguang;
import com.syu.ui.air.Air_0310_RZC_BaojunRs3;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Callback_0310_RZC_XP1_BaoJun560 extends CallbackCanbusBase {
    public static final int U_CARINFO_D52_D10 = 113;
    public static final int U_CARINFO_D52_D11 = 114;
    public static final int U_CARINFO_D52_D12 = 115;
    public static final int U_CARINFO_D52_D13 = 116;
    public static final int U_CARINFO_D52_D14 = 117;
    public static final int U_CARINFO_D52_D15 = 118;
    public static final int U_CARINFO_D52_D16 = 119;
    public static final int U_CARINFO_D52_D17 = 120;
    public static final int U_CARINFO_D52_D18 = 121;
    public static final int U_CARINFO_D52_D19 = 122;
    public static final int U_CARINFO_D52_D1A = 123;
    public static final int U_CARINFO_D52_D1B = 124;
    public static final int U_CARINFO_D52_D1C = 125;
    public static final int U_CARINFO_D52_D1D = 126;
    public static final int U_CARINFO_D52_D1E = 127;
    public static final int U_CARINFO_D52_D1F = 128;
    public static final int U_CARINFO_D52_D20 = 129;
    public static final int U_CARINFO_D52_D21 = 130;
    public static final int U_CARINFO_D52_D22 = 131;
    public static final int U_CARINFO_D52_D23 = 141;
    public static final int U_CARINFO_D52_D24 = 142;
    public static final int U_CARINFO_D52_D25 = 143;
    public static final int U_CARINFO_D52_D26 = 144;
    public static final int U_CARINFO_D52_D27 = 145;
    public static final int U_CARINFO_D52_D28 = 146;
    public static final int U_CARINFO_D52_D29 = 147;
    public static final int U_CARINFO_D52_D2A = 148;
    public static final int U_CARINFO_D52_D2B = 149;
    public static final int U_CARINFO_D52_D2C = 150;
    public static final int U_CARINFO_D52_D3 = 100;
    public static final int U_CARINFO_D52_D30 = 132;
    public static final int U_CARINFO_D52_D31 = 133;
    public static final int U_CARINFO_D52_D32 = 134;
    public static final int U_CARINFO_D52_D33 = 135;
    public static final int U_CARINFO_D52_D34 = 136;
    public static final int U_CARINFO_D52_D35 = 138;
    public static final int U_CARINFO_D52_D36 = 139;
    public static final int U_CARINFO_D52_D37 = 140;
    public static final int U_CARINFO_D52_D38 = 156;
    public static final int U_CARINFO_D52_D39 = 157;
    public static final int U_CARINFO_D52_D4 = 101;
    public static final int U_CARINFO_D52_D5 = 102;
    public static final int U_CARINFO_D52_D6 = 103;
    public static final int U_CARINFO_D52_D7 = 104;
    public static final int U_CARINFO_D52_D8 = 105;
    public static final int U_CARINFO_D52_D9 = 106;
    public static final int U_CARINFO_D52_DA = 107;
    public static final int U_CARINFO_D52_DB = 108;
    public static final int U_CARINFO_D52_DC = 109;
    public static final int U_CARINFO_D52_DD = 110;
    public static final int U_CARINFO_D52_DE = 111;
    public static final int U_CARINFO_D52_DF = 112;
    public static final int U_CARINFO_D52_OD_D3A = 176;
    public static final int U_CARINFO_D52_OD_D3B = 177;
    public static final int U_CARINFO_D52_OD_D3C = 178;
    public static final int U_CARINFO_D52_OD_D3D = 179;
    public static final int U_CARINFO_D52_OD_D3E = 180;
    public static final int U_CARINFO_D52_OD_D3F = 181;
    public static final int U_CARINFO_D52_RZC_D2D = 158;
    public static final int U_CARINFO_D52_RZC_D2E = 159;
    public static final int U_CARINFO_D52_RZC_D2F = 160;
    public static final int U_CARINFO_D52_RZC_D30 = 161;
    public static final int U_CARINFO_D52_RZC_D31 = 162;
    public static final int U_CARINFO_D52_RZC_D32 = 163;
    public static final int U_CARINFO_D52_RZC_D33 = 164;
    public static final int U_CARINFO_D52_RZC_D34 = 165;
    public static final int U_CARINFO_D52_RZC_D35 = 166;
    public static final int U_CARINFO_D53_D0_B70 = 167;
    public static final int U_CARINFO_REARVIEW_AUTO = 98;
    public static final int U_CARINFO_TIRE_CAL = 99;
    public static final int U_CARSET_CHARGE_D0 = 151;
    public static final int U_CARSET_CHARGE_D1 = 152;
    public static final int U_CARSET_CHARGE_D2 = 153;
    public static final int U_CARSET_CHARGE_D3 = 154;
    public static final int U_CARSET_CHARGE_D4 = 155;
    public static final int U_CARSET_D40_D0_B70 = 168;
    public static final int U_CARSET_D40_D1_B70 = 169;
    public static final int U_CARSET_D40_D2_B70 = 170;
    public static final int U_CARSET_D40_D3_B70 = 171;
    public static final int U_CARSET_D40_D4_B70 = 172;
    public static final int U_CARSET_D40_D5_B70 = 173;
    public static final int U_CARSET_D40_D6_B70 = 174;
    public static final int U_CARSET_D40_D7_B70 = 175;
    public static final int U_CNT_MAX = 182;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 182; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_OD_RZC_Wuling_23XingGuang /* 1311030 */:
                AirHelper.getInstance().buildUi(new Air_0310_OD_Wuling_Xingguang(TheApp.getInstance()));
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0310_RZC_BaojunRs3(TheApp.getInstance()));
                break;
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
        if (updateCode >= 0 && updateCode < 182) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
