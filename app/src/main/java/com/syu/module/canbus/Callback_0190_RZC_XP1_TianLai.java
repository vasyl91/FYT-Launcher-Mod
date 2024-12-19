package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarCDAct;
import com.syu.carinfo.xbs.tianlai.XBS09TianlaiCarRadioAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0190_RZC_TianLai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0190_RZC_XP1_TianLai extends CallbackCanbusBase {
    public static String CarCdText = "";
    public static String CarRadioText = "";
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_MODE_LEFT = 11;
    public static final int U_AIR_BLOW_WIN_LEFT = 10;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 7;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_CAREQ_D92_D0_B70 = 90;
    public static final int U_CAREQ_D92_D1_B70 = 91;
    public static final int U_CAREQ_D92_D2_B70 = 92;
    public static final int U_CAREQ_D92_D3_B70 = 93;
    public static final int U_CAREQ_D92_D4_B70 = 94;
    public static final int U_CAREQ_D92_D5_B70 = 95;
    public static final int U_CAREQ_D92_D6_B70 = 96;
    public static final int U_CAREQ_D92_D7_B70 = 97;
    public static final int U_CAREQ_D93_D0_B70 = 74;
    public static final int U_CAREQ_D93_D1_B70 = 75;
    public static final int U_CAREQ_D93_D2_B70 = 76;
    public static final int U_CAREQ_D93_D3_B70 = 77;
    public static final int U_CAREQ_D93_D4_B70 = 78;
    public static final int U_CAREQ_D93_D5_B70 = 79;
    public static final int U_CAREQ_D93_D6_B70 = 80;
    public static final int U_CAREQ_D93_D7_B70 = 81;
    public static final int U_CAREQ_D93_D8_B70 = 82;
    public static final int U_CAREQ_D95_D0_B5 = 85;
    public static final int U_CAREQ_D95_D0_B6 = 84;
    public static final int U_CAREQ_D95_D0_B7 = 83;
    public static final int U_CAREQ_D95_D1_B30 = 101;
    public static final int U_CAREQ_D95_D1_B4 = 100;
    public static final int U_CAREQ_D95_D1_B65 = 99;
    public static final int U_CAREQ_D95_D1_B7 = 98;
    public static final int U_CAREQ_D95_D2_B5 = 104;
    public static final int U_CAREQ_D95_D2_B6 = 103;
    public static final int U_CAREQ_D95_D2_B7 = 102;
    public static final int U_CAREQ_D95_D3_B5 = 107;
    public static final int U_CAREQ_D95_D3_B6 = 106;
    public static final int U_CAREQ_D95_D3_B7 = 105;
    public static final int U_CARINF_D27_D0_B0 = 87;
    public static final int U_CARINF_D27_D0_B1 = 86;
    public static final int U_CARINF_D27_D1_D2_D3 = 88;
    public static final int U_CARINF_D27_D4_D5 = 89;
    public static final int U_CAR_CD_BEGIN = 43;
    public static final int U_CAR_CD_DISC1 = 51;
    public static final int U_CAR_CD_DISC2 = 52;
    public static final int U_CAR_CD_DISC3 = 53;
    public static final int U_CAR_CD_DISC4 = 54;
    public static final int U_CAR_CD_DISC5 = 55;
    public static final int U_CAR_CD_DISC6 = 56;
    public static final int U_CAR_CD_END = 63;
    public static final int U_CAR_CD_NUM = 57;
    public static final int U_CAR_CD_STATE = 44;
    public static final int U_CAR_CD_STATE_FOLD = 45;
    public static final int U_CAR_CD_STATE_MP3 = 47;
    public static final int U_CAR_CD_STATE_PLAY = 61;
    public static final int U_CAR_CD_STATE_SCAN = 48;
    public static final int U_CAR_CD_STATE_TXT = 49;
    public static final int U_CAR_CD_STATE_WMA = 46;
    public static final int U_CAR_CD_STATE_WORK = 50;
    public static final int U_CAR_CD_TEXT = 62;
    public static final int U_CAR_CD_TIME_M = 59;
    public static final int U_CAR_CD_TIME_S = 60;
    public static final int U_CAR_CD_TRACK = 58;
    public static final int U_CAR_EQ_BAL = 68;
    public static final int U_CAR_EQ_BAS = 65;
    public static final int U_CAR_EQ_BEEP = 69;
    public static final int U_CAR_EQ_BEGIN = 64;
    public static final int U_CAR_EQ_END = 71;
    public static final int U_CAR_EQ_FAD = 67;
    public static final int U_CAR_EQ_TREB = 66;
    public static final int U_CAR_EQ_VOL = 70;
    public static final int U_CAR_F_RADAR_SET = 108;
    public static final int U_CAR_MODE_STATE = 72;
    public static final int U_CAR_RADIO_BAND = 32;
    public static final int U_CAR_RADIO_BEGIN = 25;
    public static final int U_CAR_RADIO_END = 42;
    public static final int U_CAR_RADIO_FREQ = 34;
    public static final int U_CAR_RADIO_FREQ1 = 35;
    public static final int U_CAR_RADIO_FREQ2 = 36;
    public static final int U_CAR_RADIO_FREQ3 = 37;
    public static final int U_CAR_RADIO_FREQ4 = 38;
    public static final int U_CAR_RADIO_FREQ5 = 39;
    public static final int U_CAR_RADIO_FREQ6 = 40;
    public static final int U_CAR_RADIO_NUM = 33;
    public static final int U_CAR_RADIO_STATE = 26;
    public static final int U_CAR_RADIO_STATE_AUTO = 30;
    public static final int U_CAR_RADIO_STATE_RDS = 27;
    public static final int U_CAR_RADIO_STATE_SCAN = 28;
    public static final int U_CAR_RADIO_STATE_ST = 29;
    public static final int U_CAR_RADIO_STATE_TXT = 31;
    public static final int U_CAR_RADIO_TXT = 41;
    public static final int U_CAR_RIGHT_LIGHT_CAM = 73;
    public static final int U_CAR_R_RADAR_SET = 109;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_SPEED = 23;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;
    public static final int U_ENGINE_SPEED = 24;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        AirHelper.getInstance().buildUi(new Air_0190_RZC_TianLai(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 16; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 15; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            switch (updateCode) {
                case 41:
                    if (strs != null && strs.length > 0) {
                        CarRadioText = strs[0];
                    } else {
                        CarRadioText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 62:
                    if (strs != null && strs.length > 0) {
                        CarCdText = strs[0];
                    } else {
                        CarCdText = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 72:
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
