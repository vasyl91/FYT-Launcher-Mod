package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_xbs_nissan_08tianlai;

public class Callback_0439_XBS_09Tianlai extends CallbackCanbusBase {
    public static String CarCdText = "";
    public static String CarRadioText = "";
    public static final int U_CAR_CD_BEGIN = 116;
    public static final int U_CAR_CD_DISC1 = 124;
    public static final int U_CAR_CD_DISC2 = 125;
    public static final int U_CAR_CD_DISC3 = 126;
    public static final int U_CAR_CD_DISC4 = 127;
    public static final int U_CAR_CD_DISC5 = 128;
    public static final int U_CAR_CD_DISC6 = 129;
    public static final int U_CAR_CD_END = 136;
    public static final int U_CAR_CD_NUM = 130;
    public static final int U_CAR_CD_STATE = 117;
    public static final int U_CAR_CD_STATE_FOLD = 118;
    public static final int U_CAR_CD_STATE_MP3 = 120;
    public static final int U_CAR_CD_STATE_PLAY = 134;
    public static final int U_CAR_CD_STATE_SCAN = 121;
    public static final int U_CAR_CD_STATE_TXT = 122;
    public static final int U_CAR_CD_STATE_WMA = 119;
    public static final int U_CAR_CD_STATE_WORK = 123;
    public static final int U_CAR_CD_TEXT = 135;
    public static final int U_CAR_CD_TIME_M = 132;
    public static final int U_CAR_CD_TIME_S = 133;
    public static final int U_CAR_CD_TRACK = 131;
    public static final int U_CAR_EQ_BAL = 141;
    public static final int U_CAR_EQ_BAS = 138;
    public static final int U_CAR_EQ_BEEP = 142;
    public static final int U_CAR_EQ_BEGIN = 137;
    public static final int U_CAR_EQ_END = 144;
    public static final int U_CAR_EQ_FAD = 140;
    public static final int U_CAR_EQ_TREB = 139;
    public static final int U_CAR_EQ_VOL = 143;
    public static final int U_CAR_MODE_STATE = 145;
    public static final int U_CAR_RADIO_BAND = 105;
    public static final int U_CAR_RADIO_BEGIN = 98;
    public static final int U_CAR_RADIO_END = 115;
    public static final int U_CAR_RADIO_FREQ = 107;
    public static final int U_CAR_RADIO_FREQ1 = 108;
    public static final int U_CAR_RADIO_FREQ2 = 109;
    public static final int U_CAR_RADIO_FREQ3 = 110;
    public static final int U_CAR_RADIO_FREQ4 = 111;
    public static final int U_CAR_RADIO_FREQ5 = 112;
    public static final int U_CAR_RADIO_FREQ6 = 113;
    public static final int U_CAR_RADIO_NUM = 106;
    public static final int U_CAR_RADIO_STATE = 99;
    public static final int U_CAR_RADIO_STATE_AUTO = 103;
    public static final int U_CAR_RADIO_STATE_RDS = 100;
    public static final int U_CAR_RADIO_STATE_SCAN = 101;
    public static final int U_CAR_RADIO_STATE_ST = 102;
    public static final int U_CAR_RADIO_STATE_TXT = 104;
    public static final int U_CAR_RADIO_TXT = 114;
    public static final int U_CNT_MAX = 146;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_xbs_nissan_08tianlai(LauncherApplication.getInstance()));
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 146) {
            switch (updateCode) {
                case 114:
                    if (strs != null && strs.length > 0) {
                        CarRadioText = strs[0];
                    } else {
                        CarRadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 135:
                    if (strs != null && strs.length > 0) {
                        CarCdText = strs[0];
                    } else {
                        CarCdText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 145:
                    if (ints[0] == 2 && !XBS09TianlaiCarCDAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct");
                        break;
                    } else if (ints[0] == 1 && !XBS09TianlaiCarRadioAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct");
                        break;
                    } else if (ints[0] == 3) {
                        if (XBS09TianlaiCarRadioAct.mIsFront && XBS09TianlaiCarRadioAct.mInstance != null) {
                            XBS09TianlaiCarRadioAct.mInstance.finish();
                        }
                        if (XBS09TianlaiCarCDAct.mIsFront && XBS09TianlaiCarCDAct.mInstance != null) {
                            XBS09TianlaiCarCDAct.mInstance.finish();
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
