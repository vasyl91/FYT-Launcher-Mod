package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCar6Cd;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarCDAct;
import com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_08_12Tianlai;

public class Callback_0443_WC2_08_12Tianlai extends CallbackCanbusBase {
    public static String CDText = null;
    public static String RadioText = null;
    public static final int U_CARCD_BEGIN = 119;
    public static final int U_CARCD_DISC1 = 127;
    public static final int U_CARCD_DISC1_TYPE = 133;
    public static final int U_CARCD_DISC2 = 126;
    public static final int U_CARCD_DISC2_TYPE = 132;
    public static final int U_CARCD_DISC3 = 125;
    public static final int U_CARCD_DISC3_TYPE = 131;
    public static final int U_CARCD_DISC4 = 124;
    public static final int U_CARCD_DISC4_TYPE = 130;
    public static final int U_CARCD_DISC5 = 123;
    public static final int U_CARCD_DISC5_TYPE = 129;
    public static final int U_CARCD_DISC6 = 122;
    public static final int U_CARCD_DISC6_TYPE = 128;
    public static final int U_CARCD_END = 143;
    public static final int U_CARCD_FLODER = 140;
    public static final int U_CARCD_NUM = 120;
    public static final int U_CARCD_PLAYSTATE = 141;
    public static final int U_CARCD_RANDOM = 139;
    public static final int U_CARCD_REPEAT = 138;
    public static final int U_CARCD_SCAN = 137;
    public static final int U_CARCD_TEXT = 142;
    public static final int U_CARCD_TIME_M = 135;
    public static final int U_CARCD_TIME_S = 136;
    public static final int U_CARCD_TRACK = 134;
    public static final int U_CARCD_TXT_SHOW = 121;
    public static final int U_CAREQ_BAL = 145;
    public static final int U_CAREQ_BASS = 147;
    public static final int U_CAREQ_BEEP = 149;
    public static final int U_CAREQ_BEGIN = 143;
    public static final int U_CAREQ_FAD = 146;
    public static final int U_CAREQ_TRE = 148;
    public static final int U_CAREQ_VOL = 144;
    public static final int U_CARRADIO_AUTOP = 116;
    public static final int U_CARRADIO_BAND = 99;
    public static final int U_CARRADIO_BEGIN = 98;
    public static final int U_CARRADIO_CH = 152;
    public static final int U_CARRADIO_END = 119;
    public static final int U_CARRADIO_FRQ = 100;
    public static final int U_CARRADIO_FRQ1 = 101;
    public static final int U_CARRADIO_FRQ10 = 110;
    public static final int U_CARRADIO_FRQ11 = 111;
    public static final int U_CARRADIO_FRQ12 = 112;
    public static final int U_CARRADIO_FRQ2 = 102;
    public static final int U_CARRADIO_FRQ3 = 103;
    public static final int U_CARRADIO_FRQ4 = 104;
    public static final int U_CARRADIO_FRQ5 = 105;
    public static final int U_CARRADIO_FRQ6 = 106;
    public static final int U_CARRADIO_FRQ7 = 107;
    public static final int U_CARRADIO_FRQ8 = 108;
    public static final int U_CARRADIO_FRQ9 = 109;
    public static final int U_CARRADIO_RDS = 113;
    public static final int U_CARRADIO_SCAN = 114;
    public static final int U_CARRADIO_ST = 115;
    public static final int U_CARRADIO_TXT_INFO = 118;
    public static final int U_CARRADIO_TXT_SHOW = 117;
    public static final int U_CAR_JUMP_CD = 151;
    public static final int U_CAR_JUMP_EQ = 150;
    public static final int U_CNT_MAX = 153;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 153; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_08_12Tianlai(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 151) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 1:
                    if (!WC08TianlaiCarRadioAct.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlaicd.WC08TianlaiCarRadioAct");
                        break;
                    }
                case 2:
                    if (DataCanbus.DATA[120] == 15) {
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 153) {
            switch (updateCode) {
                case 118:
                    if (strs != null && strs.length > 0) {
                        RadioText = strs[0];
                    } else {
                        RadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 142:
                    if (strs != null && strs.length > 0) {
                        CDText = strs[0];
                    } else {
                        CDText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 151:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 153) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
