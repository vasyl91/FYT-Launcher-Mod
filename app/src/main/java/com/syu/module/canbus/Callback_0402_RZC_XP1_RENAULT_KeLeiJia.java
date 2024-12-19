package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.carinfo.rzc.keleijia.KeleiaoCarCD;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0402_RZC_Leinuo_Keleiao;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0402_RZC_XP1_RENAULT_KeLeiJia extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 49;
    public static final int U_AIR_DATA0 = 50;
    public static final int U_AIR_DATA1 = 51;
    public static final int U_AIR_DATA2 = 52;
    public static final int U_AIR_DATA3 = 53;
    public static final int U_AIR_DATA4 = 54;
    public static final int U_AIR_DATA5 = 55;
    public static final int U_AIR_END = 57;
    public static final int U_AIR_KARBIN_AC = 59;
    public static final int U_AIR_KARBIN_AUTO = 61;
    public static final int U_AIR_KARBIN_BEGIN = 58;
    public static final int U_AIR_KARBIN_BLOW_FOOT = 65;
    public static final int U_AIR_KARBIN_BLOW_HEAD = 66;
    public static final int U_AIR_KARBIN_BLOW_WIN = 67;
    public static final int U_AIR_KARBIN_CYCLE = 60;
    public static final int U_AIR_KARBIN_END = 71;
    public static final int U_AIR_KARBIN_FRONT_DEFROG = 63;
    public static final int U_AIR_KARBIN_REAR_DEFROG = 62;
    public static final int U_AIR_KARBIN_TEMP_LEFT = 69;
    public static final int U_AIR_KARBIN_TEMP_RIGHT = 70;
    public static final int U_AIR_KARBIN_WIND_LEVEL = 68;
    public static final int U_AIR_RZC_AC = 108;
    public static final int U_AIR_RZC_AQS = 107;
    public static final int U_AIR_RZC_AUTO = 110;
    public static final int U_AIR_RZC_BEGIN = 106;
    public static final int U_AIR_RZC_BLOW_BODY = 119;
    public static final int U_AIR_RZC_BLOW_FOOT = 118;
    public static final int U_AIR_RZC_BLOW_UP = 120;
    public static final int U_AIR_RZC_BLOW_WIN_LEV = 121;
    public static final int U_AIR_RZC_CYCLE = 109;
    public static final int U_AIR_RZC_DUAL = 111;
    public static final int U_AIR_RZC_ECO = 114;
    public static final int U_AIR_RZC_END = 124;
    public static final int U_AIR_RZC_FAST = 116;
    public static final int U_AIR_RZC_FRONT_DEFROG = 113;
    public static final int U_AIR_RZC_NORMAL = 117;
    public static final int U_AIR_RZC_REAR_DEFROG = 112;
    public static final int U_AIR_RZC_SOFT = 115;
    public static final int U_AIR_RZC_TEMP_LEFT = 122;
    public static final int U_AIR_RZC_TEMP_RIGHT = 123;
    public static final int U_AIR_TEMP_ADJUST_MODE = 56;
    public static final int U_CARINFO_71D14_KADJAR = 96;
    public static final int U_CARINFO_71D15_MEGANE = 92;
    public static final int U_CARINFO_71D23_MEGANE = 95;
    public static final int U_CARINFO_71D77_MEGANE = 93;
    public static final int U_CARINFO_72D90_MEGANE = 97;
    public static final int U_CARINFO_72D91_MEGANE = 98;
    public static final int U_CARINFO_72D92_MEGANE = 99;
    public static final int U_CARINFO_72D93_MEGANE = 100;
    public static final int U_CARINFO_72DA0_MEGANE = 101;
    public static final int U_CARINFO_72DA1_MEGANE = 102;
    public static final int U_CARINFO_72DA2_MEGANE = 103;
    public static final int U_CARINFO_72DA3_MEGANE = 104;
    public static final int U_CARINFO_72DA4_MEGANE = 105;
    public static final int U_CARINFO_D73_D0_B0 = 131;
    public static final int U_CARINFO_D73_D0_B1 = 130;
    public static final int U_CARINFO_D73_D0_B2 = 129;
    public static final int U_CARINFO_D73_D0_B3 = 128;
    public static final int U_CARINFO_D73_D0_B4 = 127;
    public static final int U_CARINFO_D73_D0_B5 = 126;
    public static final int U_CARINFO_D73_D0_B6 = 125;
    public static final int U_CARINFO_D73_D0_B7 = 135;
    public static final int U_CARINFO_D73_D1_B10 = 134;
    public static final int U_CARINFO_D73_D1_B2 = 133;
    public static final int U_CARINFO_LANGUAGE_SETS = 94;
    public static final int U_CARINFO_STATE = 91;
    public static final int U_CARINFO_VOL = 90;
    public static final int U_CAR_TIRE_FL = 72;
    public static final int U_CAR_TIRE_FR = 73;
    public static final int U_CAR_TIRE_RL = 74;
    public static final int U_CAR_TIRE_RR = 75;
    public static final int U_CAR_TIRE_WARN = 76;
    public static final int U_CNT_MAX = 136;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_JUMP_SOS_PAGE = 132;
    public static final int U_SAFEBELT_LEFT = 47;
    public static final int U_SAFEBELT_RIGHT = 48;
    public static final int U_SETTING_71D00 = 14;
    public static final int U_SETTING_71D01 = 13;
    public static final int U_SETTING_71D02 = 12;
    public static final int U_SETTING_71D03 = 11;
    public static final int U_SETTING_71D04 = 10;
    public static final int U_SETTING_71D06_18H = 78;
    public static final int U_SETTING_71D07_18H = 77;
    public static final int U_SETTING_71D10 = 17;
    public static final int U_SETTING_71D12 = 16;
    public static final int U_SETTING_71D13 = 15;
    public static final int U_SETTING_71D20 = 24;
    public static final int U_SETTING_71D22 = 23;
    public static final int U_SETTING_71D23 = 22;
    public static final int U_SETTING_71D24 = 21;
    public static final int U_SETTING_71D25 = 20;
    public static final int U_SETTING_71D26 = 19;
    public static final int U_SETTING_71D27 = 18;
    public static final int U_SETTING_71D50 = 25;
    public static final int U_SETTING_71D60 = 26;
    public static final int U_SETTING_71D72_18H = 83;
    public static final int U_SETTING_71D73_18H = 82;
    public static final int U_SETTING_71D74_18H = 81;
    public static final int U_SETTING_71D75_18H = 80;
    public static final int U_SETTING_71D76 = 28;
    public static final int U_SETTING_71D76_18H = 79;
    public static final int U_SETTING_71D77 = 27;
    public static final int U_SETTING_71D80 = 32;
    public static final int U_SETTING_71D80_18H = 84;
    public static final int U_SETTING_71D85 = 31;
    public static final int U_SETTING_71D86 = 30;
    public static final int U_SETTING_71D87 = 29;
    public static final int U_SETTING_71D90 = 33;
    public static final int U_SETTING_71D90_18H = 89;
    public static final int U_SETTING_71D91_18H = 88;
    public static final int U_SETTING_71D93_18H = 87;
    public static final int U_SETTING_71D96_18H = 86;
    public static final int U_SETTING_71D97_18H = 85;
    public static final int U_SETTING_71DA0 = 36;
    public static final int U_SETTING_71DA5 = 35;
    public static final int U_SETTING_71DA7 = 34;
    public static final int U_SETTING_71DB4 = 40;
    public static final int U_SETTING_71DB5 = 39;
    public static final int U_SETTING_71DB6 = 38;
    public static final int U_SETTING_71DB7 = 37;
    public static final int U_SETTING_71DC0 = 41;
    public static final int U_SETTING_81D01 = 42;
    public static final int U_SETTING_81D23 = 43;
    public static final int U_SETTING_81D45 = 44;
    public static final int U_SETTING_END = 46;
    public static final int U_SETTING_USER_COLOR = 45;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 136; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] != 65938 && DataCanbus.DATA[1000] != 131474) {
            AirHelper.getInstance().buildUi(new Air_0402_RZC_Leinuo_Keleiao(LauncherApplication.getInstance()));
            for (int i3 = 50; i3 <= 54; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 0; i4 < 6; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
        if (DataCanbus.DATA[1000] == 197010) {
            for (int i2 = 58; i2 < 71; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 132) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 91) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0] & 7;
            int power = (ints[0] >> 7) & 1;
            if (value != 3 && power == 1 && !KeleiaoCarCD.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.keleijia.KeleiaoCarCD");
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 136) {
            switch (updateCode) {
                case 91:
                    ShowCarState(updateCode, ints);
                    break;
                case 132:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
