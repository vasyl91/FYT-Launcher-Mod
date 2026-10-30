package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0395_WC2_BeiQiX25;
import com.syu.ui.air.Air_0395_WC2_BeiQi_18BJ20;
import com.syu.ui.air.Air_0395_WC2_BenTengB50;
import com.syu.ui.air.Air_0395_WC2_FengGuang580;
import com.syu.ui.air.Air_0395_WC2_HaiMaV70;
import com.syu.ui.air.Air_0395_WC2_QiChenD60;
import com.syu.ui.air.Air_0395_WC2_QiChenT90;
import com.syu.ui.air.Air_0395_WC2_RuiFengS3;
import com.syu.ui.air.Air_0395_WC2_RuiFengS5;
import com.syu.ui.air.Air_0395_WC2_RuiHu3X;
import com.syu.ui.air.Air_0395_WC2_RuiHu5;
import com.syu.ui.air.Air_0395_WC2_YeMa_T70;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0395_WC2_GuoChan extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_AIR = 150;
    public static final int U_CARINFO_AUTO_FOLD_REARVIEW = 148;
    public static final int U_CARINFO_AUTO_LOCK = 133;
    public static final int U_CARINFO_AUTO_UNLOCK = 147;
    public static final int U_CARINFO_AUTO_WIND_LEV = 149;
    public static final int U_CARINFO_BEGIN = 120;
    public static final int U_CARINFO_BELT_WARN = 156;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 134;
    public static final int U_CARINFO_BLIND_SIDE = 165;
    public static final int U_CARINFO_BTPHONE_LOW_WIND = 153;
    public static final int U_CARINFO_CAR_VOL = 132;
    public static final int U_CARINFO_CHANGE_ROAD_LIGHTONOFF = 169;
    public static final int U_CARINFO_CHARGING_SECURITY = 162;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 140;
    public static final int U_CARINFO_DAYLIGHT = 135;
    public static final int U_CARINFO_ENERGY_CYCLE = 163;
    public static final int U_CARINFO_ENGIN_SPEED = 120;
    public static final int U_CARINFO_EPS_MODE = 170;
    public static final int U_CARINFO_FORTIFICATION_PROMPT = 167;
    public static final int U_CARINFO_HAND_ENABLE = 172;
    public static final int U_CARINFO_HAND_SKYWIN = 173;
    public static final int U_CARINFO_HOME_LIGHT = 168;
    public static final int U_CARINFO_LIGHT_DIPPED = 122;
    public static final int U_CARINFO_LIGHT_DOUBLE_FLASH = 128;
    public static final int U_CARINFO_LIGHT_FFOG = 125;
    public static final int U_CARINFO_LIGHT_HIGBEAM = 123;
    public static final int U_CARINFO_LIGHT_LAMP = 124;
    public static final int U_CARINFO_LIGHT_LEFT_TURN = 126;
    public static final int U_CARINFO_LIGHT_RIGHT_TURN = 127;
    public static final int U_CARINFO_LONGTOUCH_LOCK_WINDOW = 159;
    public static final int U_CARINFO_LONGTOUCH_UNLOCK_WINDOW = 158;
    public static final int U_CARINFO_NO_FIND_KEY = 154;
    public static final int U_CARINFO_NO_PARK_AWAY = 155;
    public static final int U_CARINFO_PARK_CYCLE = 152;
    public static final int U_CARINFO_PM25_TEST = 151;
    public static final int U_CARINFO_REARVIEW_AUTO = 161;
    public static final int U_CARINFO_REMOTE_BACK = 146;
    public static final int U_CARINFO_REMOTE_DOWN_WINDOW = 160;
    public static final int U_CARINFO_RESTRICTOR = 121;
    public static final int U_CARINFO_ROAD_AWAY = 166;
    public static final int U_CARINFO_SPEED_ALARM = 139;
    public static final int U_CARINFO_STEERING_ANIM = 137;
    public static final int U_CARINFO_STEERING_AVM = 136;
    public static final int U_CARINFO_STEERING_POWER = 164;
    public static final int U_CARINFO_UNLOCK_DOOR = 157;
    public static final int U_CARINFO_VEHICLE_GUIDES = 138;
    public static final int U_CARINFO_WARN_EXIST = 129;
    public static final int U_CARINFO_WARN_SWITCH = 130;
    public static final int U_CARINFO_WARN_TYPE = 131;
    public static final int U_CARINFO_WELCOME_ONOFF = 171;
    public static final int U_CNT_MAX = 174;
    public static final int U_PRESSINFO_FL = 141;
    public static final int U_PRESSINFO_FR = 142;
    public static final int U_PRESSINFO_RL = 143;
    public static final int U_PRESSINFO_RR = 144;
    public static final int U_PRESSURE_FL = 103;
    public static final int U_PRESSURE_FR = 104;
    public static final int U_PRESSURE_RL = 105;
    public static final int U_PRESSURE_RR = 106;
    public static final int U_SYSTEM_UNWORK_WARN = 119;
    public static final int U_TEMP_BEGIN = 97;
    public static final int U_TEMP_FL = 99;
    public static final int U_TEMP_FR = 100;
    public static final int U_TEMP_RL = 101;
    public static final int U_TEMP_RR = 102;
    public static final int U_TEMP_WARN_FFW = 107;
    public static final int U_TEMP_WARN_FL_H = 109;
    public static final int U_TEMP_WARN_FL_L = 108;
    public static final int U_TEMP_WARN_FRW = 110;
    public static final int U_TEMP_WARN_FR_H = 111;
    public static final int U_TEMP_WARN_FR_L = 112;
    public static final int U_TEMP_WARN_RLW = 113;
    public static final int U_TEMP_WARN_RL_H = 115;
    public static final int U_TEMP_WARN_RL_L = 114;
    public static final int U_TEMP_WARN_RRW = 116;
    public static final int U_TEMP_WARN_RR_H = 118;
    public static final int U_TEMP_WARN_RR_L = 117;
    public static final int U_WARN_ZHONGTAI = 145;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 174) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 174; i++) {
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
        boolean showair = false;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_GUOCHAN_2 /* 131467 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_4 /* 262539 */:
            case FinalCanbus.CAR_WC2_RUIFENG_M4 /* 1704331 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS5(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_6 /* 393611 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_11 /* 721291 */:
            case FinalCanbus.CAR_WC2_BeiQi_X35 /* 1245579 */:
            case FinalCanbus.CAR_WC2_BeiQi_M50F /* 1311115 */:
            case FinalCanbus.CAR_WC2_BeiQi_S3L /* 2032011 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQiX25(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_7 /* 459147 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_HaiMaV70(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_8 /* 524683 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu3X(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_12 /* 786827 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_FengGuang580(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_13 /* 852363 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BenTengB50(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_14 /* 917899 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_15 /* 983435 */:
            case FinalCanbus.CAR_WC2_18BYD_YUAN /* 1769867 */:
            case FinalCanbus.CAR_WC2_AiRuiZ_GX /* 1835403 */:
            case FinalCanbus.CAR_WC2_JieTu_X70 /* 1900939 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_H /* 1966475 */:
            case FinalCanbus.CAR_WC2_GUOCHAN_Ruihu5X /* 2097547 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_22 /* 2294155 */:
            case FinalCanbus.CAR_WC2_JieTu_X70_22_H /* 2359691 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu5(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_17 /* 1114507 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_YeMa_T70(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_QiChen_T90 /* 1376651 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenT90(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_RuiFeng_S2Mini /* 1442187 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS3(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_QiChen_D60 /* 1507723 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenD60(TheApp.getInstance()));
                showair = true;
                break;
            case FinalCanbus.CAR_WC2_BeiQi_18BJ20 /* 1573259 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQi_18BJ20(TheApp.getInstance()));
                showair = true;
                break;
        }
        if (showair) {
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
}
