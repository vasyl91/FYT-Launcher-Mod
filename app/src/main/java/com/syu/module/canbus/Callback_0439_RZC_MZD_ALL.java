package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_MZD_ALL extends CallbackCanbusBase {
    public static String SongAblum = null;
    public static String SongArtist = null;
    public static String SongTitle = null;
    public static final int U_CARSET_BEGIN = 7;
    public static final int U_CARSET_CD_ABLUM = 91;
    public static final int U_CARSET_CD_ARTIST = 90;
    public static final int U_CARSET_CD_TITLE = 89;
    public static final int U_CARSET_D40_D0_B70 = 8;
    public static final int U_CARSET_D40_D1_B70 = 9;
    public static final int U_CARSET_D40_D2_B70 = 10;
    public static final int U_CARSET_D40_D3_B60 = 12;
    public static final int U_CARSET_D40_D3_B7 = 11;
    public static final int U_CARSET_D40_D4_B63 = 14;
    public static final int U_CARSET_D40_D4_B7 = 13;
    public static final int U_CARSET_D41_D0_B10 = 18;
    public static final int U_CARSET_D41_D0_B2 = 17;
    public static final int U_CARSET_D41_D0_B43 = 16;
    public static final int U_CARSET_D41_D0_B75 = 15;
    public static final int U_CARSET_D41_D1_B7 = 19;
    public static final int U_CARSET_D41_D2_B65 = 21;
    public static final int U_CARSET_D41_D2_B7 = 20;
    public static final int U_CARSET_D41_D3_B1 = 25;
    public static final int U_CARSET_D41_D3_B32 = 24;
    public static final int U_CARSET_D41_D3_B54 = 23;
    public static final int U_CARSET_D41_D3_B76 = 22;
    public static final int U_CARSET_D41_D4_B42 = 27;
    public static final int U_CARSET_D41_D4_B75 = 26;
    public static final int U_CARSET_D41_D5_B20 = 32;
    public static final int U_CARSET_D41_D5_B3 = 31;
    public static final int U_CARSET_D41_D5_B54 = 30;
    public static final int U_CARSET_D41_D5_B6 = 29;
    public static final int U_CARSET_D41_D5_B7 = 28;
    public static final int U_CARSET_D41_D6_B32 = 36;
    public static final int U_CARSET_D41_D6_B54 = 35;
    public static final int U_CARSET_D41_D6_B6 = 34;
    public static final int U_CARSET_D41_D6_B7 = 33;
    public static final int U_CARSET_D41_D7_B0 = 42;
    public static final int U_CARSET_D41_D7_B1 = 41;
    public static final int U_CARSET_D41_D7_B2 = 40;
    public static final int U_CARSET_D41_D7_B3 = 39;
    public static final int U_CARSET_D41_D7_B64 = 38;
    public static final int U_CARSET_D41_D7_B7 = 37;
    public static final int U_CARSET_D41_D8_B76 = 43;
    public static final int U_CARSET_D50_D0_D1 = 44;
    public static final int U_CARSET_D50_D10_D11 = 49;
    public static final int U_CARSET_D50_D14_D15 = 50;
    public static final int U_CARSET_D50_D2_D3 = 45;
    public static final int U_CARSET_D50_D4_D5 = 46;
    public static final int U_CARSET_D50_D6_D7 = 47;
    public static final int U_CARSET_D50_D8_D9 = 48;
    public static final int U_CARSET_D51_D0_D1 = 51;
    public static final int U_CARSET_D51_D10_D11 = 56;
    public static final int U_CARSET_D51_D12_D13 = 57;
    public static final int U_CARSET_D51_D14_D15 = 58;
    public static final int U_CARSET_D51_D16_D17 = 59;
    public static final int U_CARSET_D51_D18_D19 = 60;
    public static final int U_CARSET_D51_D20_D21 = 61;
    public static final int U_CARSET_D51_D22_D23 = 62;
    public static final int U_CARSET_D51_D24_D25 = 63;
    public static final int U_CARSET_D51_D26_D27 = 64;
    public static final int U_CARSET_D51_D28_D29 = 65;
    public static final int U_CARSET_D51_D2_D3 = 52;
    public static final int U_CARSET_D51_D4_D5 = 53;
    public static final int U_CARSET_D51_D6_D7 = 54;
    public static final int U_CARSET_D51_D8_D9 = 55;
    public static final int U_CARSET_D52_D0_B3 = 70;
    public static final int U_CARSET_D52_D0_B4 = 69;
    public static final int U_CARSET_D52_D0_B5 = 68;
    public static final int U_CARSET_D52_D0_B6 = 67;
    public static final int U_CARSET_D52_D0_B7 = 66;
    public static final int U_CARSET_D52_D11_D12 = 77;
    public static final int U_CARSET_D52_D1_B70 = 71;
    public static final int U_CARSET_D52_D2_D3 = 72;
    public static final int U_CARSET_D52_D4_D5 = 73;
    public static final int U_CARSET_D52_D6_B70 = 74;
    public static final int U_CARSET_D52_D7_D8 = 75;
    public static final int U_CARSET_D52_D9_D10 = 76;
    public static final int U_CARSET_D60_D0_B7 = 78;
    public static final int U_CARSET_D61_D0_B70 = 79;
    public static final int U_CARSET_D61_D1_B3 = 84;
    public static final int U_CARSET_D61_D1_B4 = 83;
    public static final int U_CARSET_D61_D1_B5 = 82;
    public static final int U_CARSET_D61_D1_B6 = 81;
    public static final int U_CARSET_D61_D1_B7 = 80;
    public static final int U_CARSET_D61_D2_D3 = 85;
    public static final int U_CARSET_D61_D4_D5 = 86;
    public static final int U_CARSET_D61_D6_D7_D8 = 87;
    public static final int U_CARSET_D61_D9_D10_D11 = 88;
    public static final int U_CARSET_D70_D0_B70 = 92;
    public static final int U_CARSET_D70_D1_B70 = 93;
    public static final int U_CARSET_D70_D2_B70 = 94;
    public static final int U_CARSET_D70_D3_B70 = 95;
    public static final int U_CARSET_D70_D4_B70 = 96;
    public static final int U_CARSET_D70_D5_B70 = 97;
    public static final int U_CARSET_D70_D6_B6 = 99;
    public static final int U_CARSET_D70_D6_B7 = 98;
    public static final int U_CARSET_D74_D0_B21 = 103;
    public static final int U_CARSET_D74_D0_B43 = 102;
    public static final int U_CARSET_D74_D0_B65 = 101;
    public static final int U_CARSET_D74_D0_B7 = 100;
    public static final int U_CARSET_D74_D10_B54 = 134;
    public static final int U_CARSET_D74_D10_B76 = 133;
    public static final int U_CARSET_D74_D11_B75 = 135;
    public static final int U_CARSET_D74_D12_B76 = 136;
    public static final int U_CARSET_D74_D13_B76 = 137;
    public static final int U_CARSET_D74_D1_B65 = 105;
    public static final int U_CARSET_D74_D1_B7 = 104;
    public static final int U_CARSET_D74_D2_B43 = 108;
    public static final int U_CARSET_D74_D2_B65 = 107;
    public static final int U_CARSET_D74_D2_B7 = 106;
    public static final int U_CARSET_D74_D3_B65 = 110;
    public static final int U_CARSET_D74_D3_B7 = 109;
    public static final int U_CARSET_D74_D4_B10 = 114;
    public static final int U_CARSET_D74_D4_B2 = 113;
    public static final int U_CARSET_D74_D4_B43 = 112;
    public static final int U_CARSET_D74_D4_B75 = 111;
    public static final int U_CARSET_D74_D5_B43 = 117;
    public static final int U_CARSET_D74_D5_B65 = 116;
    public static final int U_CARSET_D74_D5_B7 = 115;
    public static final int U_CARSET_D74_D6_B5 = 120;
    public static final int U_CARSET_D74_D6_B6 = 119;
    public static final int U_CARSET_D74_D6_B7 = 118;
    public static final int U_CARSET_D74_D7_B10 = 125;
    public static final int U_CARSET_D74_D7_B2 = 124;
    public static final int U_CARSET_D74_D7_B53 = 123;
    public static final int U_CARSET_D74_D7_B6 = 122;
    public static final int U_CARSET_D74_D7_B7 = 121;
    public static final int U_CARSET_D74_D8_B21 = 129;
    public static final int U_CARSET_D74_D8_B43 = 128;
    public static final int U_CARSET_D74_D8_B65 = 127;
    public static final int U_CARSET_D74_D8_B7 = 126;
    public static final int U_CARSET_D74_D9_B5 = 132;
    public static final int U_CARSET_D74_D9_B6 = 131;
    public static final int U_CARSET_D74_D9_B7 = 130;
    public static final int U_CNT_MAX = 138;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
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
        if (updateCode >= 0 && updateCode < 138) {
            switch (updateCode) {
                case 89:
                    if (strs != null && strs.length > 0) {
                        SongTitle = strs[0];
                    } else {
                        SongTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 90:
                    if (strs != null && strs.length > 0) {
                        SongArtist = strs[0];
                    } else {
                        SongArtist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 91:
                    if (strs != null && strs.length > 0) {
                        SongAblum = strs[0];
                    } else {
                        SongAblum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 138) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
