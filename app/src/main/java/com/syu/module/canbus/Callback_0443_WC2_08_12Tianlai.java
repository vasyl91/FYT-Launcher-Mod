package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_08_12Tianlai;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_08_12Tianlai extends CallbackCanbusBase {
    public static String CDText = null;
    public static String RadioText = null;
    public static final int U_CARCD_BEGIN = 107;
    public static final int U_CARCD_DISC1 = 115;
    public static final int U_CARCD_DISC1_TYPE = 121;
    public static final int U_CARCD_DISC2 = 114;
    public static final int U_CARCD_DISC2_TYPE = 120;
    public static final int U_CARCD_DISC3 = 113;
    public static final int U_CARCD_DISC3_TYPE = 119;
    public static final int U_CARCD_DISC4 = 112;
    public static final int U_CARCD_DISC4_TYPE = 118;
    public static final int U_CARCD_DISC5 = 111;
    public static final int U_CARCD_DISC5_TYPE = 117;
    public static final int U_CARCD_DISC6 = 110;
    public static final int U_CARCD_DISC6_TYPE = 116;
    public static final int U_CARCD_END = 131;
    public static final int U_CARCD_FLODER = 128;
    public static final int U_CARCD_NUM = 108;
    public static final int U_CARCD_PLAYSTATE = 129;
    public static final int U_CARCD_RANDOM = 127;
    public static final int U_CARCD_REPEAT = 126;
    public static final int U_CARCD_SCAN = 125;
    public static final int U_CARCD_TEXT = 130;
    public static final int U_CARCD_TIME_M = 123;
    public static final int U_CARCD_TIME_S = 124;
    public static final int U_CARCD_TRACK = 122;
    public static final int U_CARCD_TXT_SHOW = 109;
    public static final int U_CAREQ_BAL = 133;
    public static final int U_CAREQ_BASS = 135;
    public static final int U_CAREQ_BEEP = 137;
    public static final int U_CAREQ_BEGIN = 131;
    public static final int U_CAREQ_FAD = 134;
    public static final int U_CAREQ_TRE = 136;
    public static final int U_CAREQ_VOL = 132;
    public static final int U_CARRADIO_AUTOP = 104;
    public static final int U_CARRADIO_BAND = 87;
    public static final int U_CARRADIO_BEGIN = 86;
    public static final int U_CARRADIO_CH = 140;
    public static final int U_CARRADIO_END = 107;
    public static final int U_CARRADIO_FRQ = 88;
    public static final int U_CARRADIO_FRQ1 = 89;
    public static final int U_CARRADIO_FRQ10 = 98;
    public static final int U_CARRADIO_FRQ11 = 99;
    public static final int U_CARRADIO_FRQ12 = 100;
    public static final int U_CARRADIO_FRQ2 = 90;
    public static final int U_CARRADIO_FRQ3 = 91;
    public static final int U_CARRADIO_FRQ4 = 92;
    public static final int U_CARRADIO_FRQ5 = 93;
    public static final int U_CARRADIO_FRQ6 = 94;
    public static final int U_CARRADIO_FRQ7 = 95;
    public static final int U_CARRADIO_FRQ8 = 96;
    public static final int U_CARRADIO_FRQ9 = 97;
    public static final int U_CARRADIO_RDS = 101;
    public static final int U_CARRADIO_SCAN = 102;
    public static final int U_CARRADIO_ST = 103;
    public static final int U_CARRADIO_TXT_INFO = 106;
    public static final int U_CARRADIO_TXT_SHOW = 105;
    public static final int U_CAR_JUMP_CD = 139;
    public static final int U_CAR_JUMP_EQ = 138;
    public static final int U_CNT_MAX = 141;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 141; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_08_12Tianlai(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 85; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 139) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 1:
                    if (!WC08TianlaiCarRadioAct.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct");
                        break;
                    }
                case 2:
                    if (DataCanbus.DATA[108] == 15) {
                        if (!WC08TianlaiCarCDAct.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct");
                            break;
                        }
                    } else if (!WC08TianlaiCar6Cd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd");
                        break;
                    }
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 141) {
            switch (updateCode) {
                case 106:
                    if (strs != null && strs.length > 0) {
                        RadioText = strs[0];
                    } else {
                        RadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 130:
                    if (strs != null && strs.length > 0) {
                        CDText = strs[0];
                    } else {
                        CDText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 139:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 141) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
