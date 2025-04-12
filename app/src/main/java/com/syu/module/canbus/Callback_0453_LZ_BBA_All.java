package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LZ_BBA_All extends CallbackCanbusBase {
    public static final int U_AIR_SHOW_MODE_LEFT = 112;
    public static final int U_AIR_SHOW_MODE_RIGHT = 113;
    public static final int U_AIR_SHOW_SEAT_LEFT = 114;
    public static final int U_AIR_SHOW_SEAT_RIGHT = 115;
    public static final int U_AIR_SHOW_TEMP_LEFT = 110;
    public static final int U_AIR_SHOW_TEMP_RIGHT = 111;
    public static final int U_AIR_SHOW_WIN = 109;
    public static final int U_CARAUX_CAR_MEDIA = 147;
    public static final int U_CARAUX_CAR_NAVI = 146;
    public static final int U_CARAUX_CAR_TYPE = 144;
    public static final int U_CARAUX_CTRL_TYPE = 143;
    public static final int U_CARAUX_NUM = 145;
    public static final int U_CARAUX_POSTION = 148;
    public static final int U_CAR_ALLSCREEN_ON = 168;
    public static final int U_CAR_ANDROID_UI_VOL = 153;
    public static final int U_CAR_AUDI_TYPE = 157;
    public static final int U_CAR_AUXBMW_TYPE = 161;
    public static final int U_CAR_AUXNEWBMW_TYPE = 162;
    public static final int U_CAR_BACKCAR_DELAY_ON = 169;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_BENZ_TYPE = 156;
    public static final int U_CAR_BMW_TYPE = 155;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_D32_D0_B10 = 123;
    public static final int U_CAR_D32_D0_B32 = 122;
    public static final int U_CAR_D32_D0_B54 = 121;
    public static final int U_CAR_D32_D0_B76 = 120;
    public static final int U_CAR_D32_D1_B76 = 124;
    public static final int U_CAR_D35_D0_B0 = 137;
    public static final int U_CAR_D35_D0_B1 = 136;
    public static final int U_CAR_D35_D0_B2 = 135;
    public static final int U_CAR_D35_D0_B3 = 134;
    public static final int U_CAR_D35_D0_B4 = 133;
    public static final int U_CAR_D35_D0_B5 = 132;
    public static final int U_CAR_D35_D0_B6 = 131;
    public static final int U_CAR_D35_D10_B6 = 142;
    public static final int U_CAR_D35_D10_B7 = 141;
    public static final int U_CAR_D35_D1_B70 = 138;
    public static final int U_CAR_D35_D4_D5 = 139;
    public static final int U_CAR_D35_D7_D8_D9 = 140;
    public static final int U_CAR_D37_D0_B70 = 125;
    public static final int U_CAR_D38_D0_B10 = 128;
    public static final int U_CAR_D38_D0_B4 = 127;
    public static final int U_CAR_D38_D0_B7 = 126;
    public static final int U_CAR_D38_D1_B70 = 159;
    public static final int U_CAR_D38_D2_B4 = 160;
    public static final int U_CAR_D38_D2_B6 = 129;
    public static final int U_CAR_D38_D3_B70 = 154;
    public static final int U_CAR_D39_D0_B70 = 130;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_LIGHT_D99_D0_B7 = 163;
    public static final int U_CAR_LIGHT_D99_D1_B70 = 164;
    public static final int U_CAR_LIGHT_D99_D2_B70 = 165;
    public static final int U_CAR_LIGHT_D99_D3_B70 = 166;
    public static final int U_CAR_LIGHT_D99_D4_B70 = 167;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_LVDS_MODE = 149;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_PTO_CARUI_ON = 170;
    public static final int U_CAR_SCREEN_H = 151;
    public static final int U_CAR_SCREEN_W = 150;
    public static final int U_CAR_TIRE_PRESSURE_FL = 116;
    public static final int U_CAR_TIRE_PRESSURE_FR = 117;
    public static final int U_CAR_TIRE_PRESSURE_RL = 118;
    public static final int U_CAR_TIRE_PRESSURE_RR = 119;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_UI_VOL = 152;
    public static final int U_CAR_VOICE_ANDROID = 158;
    public static final int U_CNT_MAX = 171;
    public static int modevalue = -1;
    public static int cartype = 0;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 171; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0453_lz_bba_all(LauncherApplication.getInstance()));
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 144:
                    cartype = ints[0];
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
