package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_xbs_nissan_08tianlai;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XBS_09Tianlai extends CallbackCanbusBase {
    public static String CarCdText = "";
    public static String CarRadioText = "";
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 5;
    public static final int U_AIR_BLOW_FOOT = 6;
    public static final int U_AIR_BLOW_MODE = 7;
    public static final int U_AIR_BLOW_UP = 4;
    public static final int U_AIR_CYCLE = 11;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 9;
    public static final int U_AIR_REAR_DEFROST = 8;
    public static final int U_AIR_TEMP_LEFT = 1;
    public static final int U_AIR_TEMP_RIGHT = 2;
    public static final int U_AIR_WIND_LEVEL = 3;
    public static final int U_CAR_CD_BEGIN = 33;
    public static final int U_CAR_CD_DISC1 = 41;
    public static final int U_CAR_CD_DISC2 = 42;
    public static final int U_CAR_CD_DISC3 = 43;
    public static final int U_CAR_CD_DISC4 = 44;
    public static final int U_CAR_CD_DISC5 = 45;
    public static final int U_CAR_CD_DISC6 = 46;
    public static final int U_CAR_CD_END = 53;
    public static final int U_CAR_CD_NUM = 47;
    public static final int U_CAR_CD_STATE = 34;
    public static final int U_CAR_CD_STATE_FOLD = 35;
    public static final int U_CAR_CD_STATE_MP3 = 37;
    public static final int U_CAR_CD_STATE_PLAY = 51;
    public static final int U_CAR_CD_STATE_SCAN = 38;
    public static final int U_CAR_CD_STATE_TXT = 39;
    public static final int U_CAR_CD_STATE_WMA = 36;
    public static final int U_CAR_CD_STATE_WORK = 40;
    public static final int U_CAR_CD_TEXT = 52;
    public static final int U_CAR_CD_TIME_M = 49;
    public static final int U_CAR_CD_TIME_S = 50;
    public static final int U_CAR_CD_TRACK = 48;
    public static final int U_CAR_EQ_BAL = 58;
    public static final int U_CAR_EQ_BAS = 55;
    public static final int U_CAR_EQ_BEEP = 59;
    public static final int U_CAR_EQ_BEGIN = 54;
    public static final int U_CAR_EQ_END = 61;
    public static final int U_CAR_EQ_FAD = 57;
    public static final int U_CAR_EQ_TREB = 56;
    public static final int U_CAR_EQ_VOL = 60;
    public static final int U_CAR_MODE_STATE = 62;
    public static final int U_CAR_RADIO_BAND = 22;
    public static final int U_CAR_RADIO_BEGIN = 15;
    public static final int U_CAR_RADIO_END = 32;
    public static final int U_CAR_RADIO_FREQ = 24;
    public static final int U_CAR_RADIO_FREQ1 = 25;
    public static final int U_CAR_RADIO_FREQ2 = 26;
    public static final int U_CAR_RADIO_FREQ3 = 27;
    public static final int U_CAR_RADIO_FREQ4 = 28;
    public static final int U_CAR_RADIO_FREQ5 = 29;
    public static final int U_CAR_RADIO_FREQ6 = 30;
    public static final int U_CAR_RADIO_NUM = 23;
    public static final int U_CAR_RADIO_STATE = 16;
    public static final int U_CAR_RADIO_STATE_AUTO = 20;
    public static final int U_CAR_RADIO_STATE_RDS = 17;
    public static final int U_CAR_RADIO_STATE_SCAN = 18;
    public static final int U_CAR_RADIO_STATE_ST = 19;
    public static final int U_CAR_RADIO_STATE_TXT = 21;
    public static final int U_CAR_RADIO_TXT = 31;
    public static final int U_CNT_MAX = 63;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 63; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0439_xbs_nissan_08tianlai(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 14; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 14; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 63) {
            switch (updateCode) {
                case 31:
                    if (strs != null && strs.length > 0) {
                        CarRadioText = strs[0];
                    } else {
                        CarRadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 52:
                    if (strs != null && strs.length > 0) {
                        CarCdText = strs[0];
                    } else {
                        CarCdText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 62:
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
