package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.rzc.keleijia.KeleiaoCarCD;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0402_RZC_XP1_RENAULT_KeLeiJia extends CallbackCanbusBase {
    public static final int U_AIR_DATA1 = 204;
    public static final int U_CARAMP_D93_D0_B70 = 191;
    public static final int U_CARAMP_D93_D1_B70 = 192;
    public static final int U_CARAMP_D93_D2_B70 = 193;
    public static final int U_CARAMP_D93_D3_B70 = 194;
    public static final int U_CARAMP_D93_D4_B70 = 195;
    public static final int U_CARINFO_71D14_KADJAR = 163;
    public static final int U_CARINFO_71D15_MEGANE = 159;
    public static final int U_CARINFO_71D23_MEGANE = 162;
    public static final int U_CARINFO_71D77_MEGANE = 160;
    public static final int U_CARINFO_72D90_MEGANE = 164;
    public static final int U_CARINFO_72D91_MEGANE = 165;
    public static final int U_CARINFO_72D92_MEGANE = 166;
    public static final int U_CARINFO_72D93_MEGANE = 167;
    public static final int U_CARINFO_72D94_MEGANE = 196;
    public static final int U_CARINFO_72D95_MEGANE = 197;
    public static final int U_CARINFO_72D96_MEGANE = 198;
    public static final int U_CARINFO_72D97_MEGANE = 199;
    public static final int U_CARINFO_72D98_MEGANE = 200;
    public static final int U_CARINFO_72D99_MEGANE = 201;
    public static final int U_CARINFO_72D9A_MEGANE = 202;
    public static final int U_CARINFO_72D9B_MEGANE = 203;
    public static final int U_CARINFO_72DA0_MEGANE = 168;
    public static final int U_CARINFO_72DA1_MEGANE = 169;
    public static final int U_CARINFO_72DA2_MEGANE = 170;
    public static final int U_CARINFO_72DA3_MEGANE = 171;
    public static final int U_CARINFO_72DA4_MEGANE = 172;
    public static final int U_CARINFO_D40_D0_B70 = 188;
    public static final int U_CARINFO_D73_D0_B0 = 179;
    public static final int U_CARINFO_D73_D0_B1 = 178;
    public static final int U_CARINFO_D73_D0_B2 = 177;
    public static final int U_CARINFO_D73_D0_B3 = 176;
    public static final int U_CARINFO_D73_D0_B4 = 175;
    public static final int U_CARINFO_D73_D0_B5 = 174;
    public static final int U_CARINFO_D73_D0_B6 = 173;
    public static final int U_CARINFO_D73_D0_B7 = 183;
    public static final int U_CARINFO_D73_D1_B10 = 182;
    public static final int U_CARINFO_D73_D1_B2 = 181;
    public static final int U_CARINFO_D73_D1_B3 = 184;
    public static final int U_CARINFO_D73_D2_B10 = 187;
    public static final int U_CARINFO_D73_D2_B2 = 186;
    public static final int U_CARINFO_D73_D2_B3 = 185;
    public static final int U_CARINFO_LANGUAGE_SETS = 161;
    public static final int U_CARINFO_RADAR_VOL_ONOFF = 190;
    public static final int U_CARINFO_RADAR_VOL_TYPE = 189;
    public static final int U_CARINFO_STATE = 158;
    public static final int U_CARINFO_VOL = 157;
    public static final int U_CAR_TIRE_FL = 139;
    public static final int U_CAR_TIRE_FR = 140;
    public static final int U_CAR_TIRE_RL = 141;
    public static final int U_CAR_TIRE_RR = 142;
    public static final int U_CAR_TIRE_WARN = 143;
    public static final int U_CNT_MAX = 205;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_JUMP_SOS_PAGE = 180;
    public static final int U_SAFEBELT_LEFT = 137;
    public static final int U_SAFEBELT_RIGHT = 138;
    public static final int U_SETTING_71D00 = 104;
    public static final int U_SETTING_71D01 = 103;
    public static final int U_SETTING_71D02 = 102;
    public static final int U_SETTING_71D03 = 101;
    public static final int U_SETTING_71D04 = 100;
    public static final int U_SETTING_71D06_18H = 145;
    public static final int U_SETTING_71D07_18H = 144;
    public static final int U_SETTING_71D10 = 107;
    public static final int U_SETTING_71D12 = 106;
    public static final int U_SETTING_71D13 = 105;
    public static final int U_SETTING_71D20 = 114;
    public static final int U_SETTING_71D22 = 113;
    public static final int U_SETTING_71D23 = 112;
    public static final int U_SETTING_71D24 = 111;
    public static final int U_SETTING_71D25 = 110;
    public static final int U_SETTING_71D26 = 109;
    public static final int U_SETTING_71D27 = 108;
    public static final int U_SETTING_71D50 = 115;
    public static final int U_SETTING_71D60 = 116;
    public static final int U_SETTING_71D72_18H = 150;
    public static final int U_SETTING_71D73_18H = 149;
    public static final int U_SETTING_71D74_18H = 148;
    public static final int U_SETTING_71D75_18H = 147;
    public static final int U_SETTING_71D76 = 118;
    public static final int U_SETTING_71D76_18H = 146;
    public static final int U_SETTING_71D77 = 117;
    public static final int U_SETTING_71D80 = 122;
    public static final int U_SETTING_71D80_18H = 151;
    public static final int U_SETTING_71D85 = 121;
    public static final int U_SETTING_71D86 = 120;
    public static final int U_SETTING_71D87 = 119;
    public static final int U_SETTING_71D90 = 123;
    public static final int U_SETTING_71D90_18H = 156;
    public static final int U_SETTING_71D91_18H = 155;
    public static final int U_SETTING_71D93_18H = 154;
    public static final int U_SETTING_71D96_18H = 153;
    public static final int U_SETTING_71D97_18H = 152;
    public static final int U_SETTING_71DA0 = 126;
    public static final int U_SETTING_71DA5 = 125;
    public static final int U_SETTING_71DA7 = 124;
    public static final int U_SETTING_71DB4 = 130;
    public static final int U_SETTING_71DB5 = 129;
    public static final int U_SETTING_71DB6 = 128;
    public static final int U_SETTING_71DB7 = 127;
    public static final int U_SETTING_71DC0 = 131;
    public static final int U_SETTING_81D01 = 132;
    public static final int U_SETTING_81D23 = 133;
    public static final int U_SETTING_81D45 = 134;
    public static final int U_SETTING_END = 136;
    public static final int U_SETTING_USER_COLOR = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 205; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] != 65938 && DataCanbus.DATA[1000] != 131474) {
            //AirHelper.getInstance().buildUi(new Air_0402_RZC_Leinuo_Keleiao(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 <= 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 180) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 158) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0] & 7;
            int power = (ints[0] >> 7) & 1;
            if (value != 3 && power == 1 && !KeleiaoCarCD.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.keleijia.KeleiaoCarCD");
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 205) {
            switch (updateCode) {
                case 158:
                    ShowCarState(updateCode, ints);
                    break;
                case 180:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
