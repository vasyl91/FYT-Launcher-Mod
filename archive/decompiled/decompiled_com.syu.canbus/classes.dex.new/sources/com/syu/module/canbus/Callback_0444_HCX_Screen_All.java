package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WY_BBA_All;
import com.syu.ui.air.Air_0446_HCX_BYD_Tang;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0444_HCX_Screen_All extends CallbackCanbusBase {
    public static String D0FCarUIStr1 = null;
    public static final int U_CARINF_D12_D2_B70 = 116;
    public static final int U_CARINF_D12_D5_B70 = 109;
    public static final int U_CARINF_D12_D6_B54 = 111;
    public static final int U_CARINF_D12_D6_B76 = 110;
    public static final int U_CARINF_D47_D0_B70 = 112;
    public static final int U_CARINF_D52_D0_B30 = 121;
    public static final int U_CARINF_D52_D0_B74 = 120;
    public static final int U_CARINF_D52_D1_B70 = 122;
    public static final int U_CARINF_D52_D2_B70 = 123;
    public static final int U_CARINF_D52_D3_B10 = 127;
    public static final int U_CARINF_D52_D3_B32 = 126;
    public static final int U_CARINF_D52_D3_B54 = 125;
    public static final int U_CARINF_D52_D3_B76 = 124;
    public static final int U_CARINF_D52_D4_B32 = 130;
    public static final int U_CARINF_D52_D4_B54 = 129;
    public static final int U_CARINF_D52_D4_B76 = 128;
    public static final int U_CARINF_D52_D5_B30 = 133;
    public static final int U_CARINF_D52_D5_B6 = 132;
    public static final int U_CARINF_D52_D5_B7 = 131;
    public static final int U_CARINF_D52_D6_B32 = 136;
    public static final int U_CARINF_D52_D6_B54 = 135;
    public static final int U_CARINF_D52_D6_B76 = 134;
    public static final int U_CARINF_D52_SHOW_FLAG = 163;
    public static final int U_CARINF_D52_T01_D8_B70 = 137;
    public static final int U_CARINF_D52_T02_D8_B70 = 138;
    public static final int U_CARINF_D52_T03_D10_B70 = 141;
    public static final int U_CARINF_D52_T03_D11_B70 = 142;
    public static final int U_CARINF_D52_T03_D12_B70 = 143;
    public static final int U_CARINF_D52_T03_D13_B70 = 144;
    public static final int U_CARINF_D52_T03_D14_B70 = 145;
    public static final int U_CARINF_D52_T03_D8_B70 = 139;
    public static final int U_CARINF_D52_T03_D9_B70 = 140;
    public static final int U_CARINF_D52_T0F_D8_B6 = 147;
    public static final int U_CARINF_D52_T0F_D8_B7 = 146;
    public static final int U_CARINF_D52_T0F_STR = 148;
    public static final int U_CARINF_D52_T10_D11_B7 = 151;
    public static final int U_CARINF_D52_T10_D8_B70 = 149;
    public static final int U_CARINF_D52_T10_D9_D10 = 150;
    public static final int U_CARINF_D52_T20_D10_B70 = 153;
    public static final int U_CARINF_D52_T20_D12_B70 = 154;
    public static final int U_CARINF_D52_T20_D13_B70 = 155;
    public static final int U_CARINF_D52_T20_D8_B70 = 152;
    public static final int U_CARINF_D52_T40_D10_B70 = 156;
    public static final int U_CARINF_D52_T40_D12_B70 = 157;
    public static final int U_CARINF_D52_T40_D13_B70 = 158;
    public static final int U_CARINF_D52_T50_D11_B70 = 160;
    public static final int U_CARINF_D52_T50_D12_B70 = 161;
    public static final int U_CARINF_D52_T50_D13_B70 = 162;
    public static final int U_CARINF_D52_T50_D9_B70 = 159;
    public static final int U_CARSET_AUX_CH_CHANGE = 117;
    public static final int U_CARSET_BACKCAR_TYPE = 113;
    public static final int U_CARSET_CARUI_ONOFF = 115;
    public static final int U_CARSET_D1_D0_B6 = 118;
    public static final int U_CARSET_D1_D0_B7 = 119;
    public static final int U_CARSET_SPLIT_ONOFF = 114;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LEXUS_UI_TOP = 165;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_VOICE_ANDROID = 164;
    public static final int U_CNT_MAX = 166;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 166; i++) {
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
        if (DataCanbus.DATA[1000] == 1049022) {
            AirHelper.getInstance().buildUi(new Air_0446_HCX_BYD_Tang(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0443_WY_BBA_All(TheApp.getInstance()));
        }
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
        if (updateCode >= 0 && updateCode < 166) {
            switch (updateCode) {
                case 148:
                    if (strs != null && strs.length > 0) {
                        D0FCarUIStr1 = strs[0];
                    } else {
                        D0FCarUIStr1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
