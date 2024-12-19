package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.daojun.tianlai.djTianlaiCd;
import com.syu.carinfo.daojun.tianlai.djTianlaiRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Daojun_TianLai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_Daojun_XP1_TianLai extends CallbackCanbusBase {
    public static final int U_CARINF_D33_D0_D1_D2 = 108;
    public static final int U_CARINF_D33_D3_D4_D5 = 109;
    public static final int U_CARINF_D33_D6_B70 = 110;
    public static final int U_CARINF_D33_D7_D8 = 111;
    public static final int U_CAR_CD_BEGIN = 91;
    public static final int U_CAR_CD_END = 98;
    public static final int U_CAR_CD_NUM = 92;
    public static final int U_CAR_CD_RANDOM = 95;
    public static final int U_CAR_CD_REPEAT = 94;
    public static final int U_CAR_CD_TIME_M = 96;
    public static final int U_CAR_CD_TIME_S = 97;
    public static final int U_CAR_CD_TRACK = 93;
    public static final int U_CAR_EQ_BAL = 103;
    public static final int U_CAR_EQ_BAS = 100;
    public static final int U_CAR_EQ_BEEP = 104;
    public static final int U_CAR_EQ_BEGIN = 99;
    public static final int U_CAR_EQ_END = 106;
    public static final int U_CAR_EQ_FAD = 102;
    public static final int U_CAR_EQ_TREB = 101;
    public static final int U_CAR_EQ_VOL = 105;
    public static final int U_CAR_MODE_STATE = 107;
    public static final int U_CAR_RADIO_BAND = 87;
    public static final int U_CAR_RADIO_BEGIN = 86;
    public static final int U_CAR_RADIO_END = 90;
    public static final int U_CAR_RADIO_FREQ = 89;
    public static final int U_CAR_RADIO_NUM = 88;
    public static final int U_CNT_MAX = 112;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0439_Daojun_TianLai(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 112) {
            switch (updateCode) {
                case 107:
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
