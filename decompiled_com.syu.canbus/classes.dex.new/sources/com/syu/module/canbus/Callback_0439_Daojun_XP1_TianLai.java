package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.daojun.tianlai.djTianlaiCd;
import com.syu.carinfo.daojun.tianlai.djTianlaiRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Daojun_TianLai;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0439_Daojun_XP1_TianLai extends CallbackCanbusBase {
    public static final int U_CARINF_D33_D0_D1_D2 = 120;
    public static final int U_CARINF_D33_D3_D4_D5 = 121;
    public static final int U_CARINF_D33_D6_B70 = 122;
    public static final int U_CARINF_D33_D7_D8 = 123;
    public static final int U_CARINF_D38_D4_B70 = 133;
    public static final int U_CARINF_D38_D5_B70 = 134;
    public static final int U_CARINF_D38_D6_B70 = 135;
    public static final int U_CARINF_D38_D7_B70 = 136;
    public static final int U_CARINF_D41_D0_B5 = 126;
    public static final int U_CARINF_D41_D0_B6 = 125;
    public static final int U_CARINF_D41_D0_B7 = 124;
    public static final int U_CARINF_D41_D12_D13 = 132;
    public static final int U_CARINF_D41_D1_D2 = 127;
    public static final int U_CARINF_D41_D3_D4 = 128;
    public static final int U_CARINF_D41_D5_D6 = 129;
    public static final int U_CARINF_D41_D7_D8 = 130;
    public static final int U_CARINF_D41_D9_D11 = 131;
    public static final int U_CAR_CD_BEGIN = 103;
    public static final int U_CAR_CD_END = 110;
    public static final int U_CAR_CD_NUM = 104;
    public static final int U_CAR_CD_RANDOM = 107;
    public static final int U_CAR_CD_REPEAT = 106;
    public static final int U_CAR_CD_TIME_M = 108;
    public static final int U_CAR_CD_TIME_S = 109;
    public static final int U_CAR_CD_TRACK = 105;
    public static final int U_CAR_EQ_BAL = 115;
    public static final int U_CAR_EQ_BAS = 112;
    public static final int U_CAR_EQ_BEEP = 116;
    public static final int U_CAR_EQ_BEGIN = 111;
    public static final int U_CAR_EQ_END = 118;
    public static final int U_CAR_EQ_FAD = 114;
    public static final int U_CAR_EQ_TREB = 113;
    public static final int U_CAR_EQ_VOL = 117;
    public static final int U_CAR_MODE_STATE = 119;
    public static final int U_CAR_RADIO_BAND = 99;
    public static final int U_CAR_RADIO_BEGIN = 98;
    public static final int U_CAR_RADIO_END = 102;
    public static final int U_CAR_RADIO_FREQ = 101;
    public static final int U_CAR_RADIO_NUM = 100;
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
        AirHelper.getInstance().buildUi(new Air_0439_Daojun_TianLai(TheApp.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
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
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 137) {
            switch (updateCode) {
                case 119:
                    HandlerCanbus.update(updateCode, ints);
                    if (ints[0] == 2 && !djTianlaiCd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.tianlai.djTianlaiCd");
                        break;
                    } else if (ints[0] == 1 && !djTianlaiRadio.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.tianlai.djTianlaiRadio");
                        break;
                    } else if (ints[0] == 0) {
                        if (djTianlaiRadio.isFront && djTianlaiRadio.mInit != null) {
                            djTianlaiRadio.mInit.finish();
                        }
                        if (djTianlaiCd.isFront && djTianlaiCd.mInit != null) {
                            djTianlaiCd.mInit.finish();
                            break;
                        }
                    }
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
