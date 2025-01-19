package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0395_WC2_BeiQiX25;
//import com.syu.ui.air.Air_0395_WC2_BeiQi_18BJ20;
//import com.syu.ui.air.Air_0395_WC2_BenTengB50;
//import com.syu.ui.air.Air_0395_WC2_FengGuang580;
//import com.syu.ui.air.Air_0395_WC2_GUOCHAN;
//import com.syu.ui.air.Air_0395_WC2_HaiMaV70;
//import com.syu.ui.air.Air_0395_WC2_QiChenD60;
//import com.syu.ui.air.Air_0395_WC2_QiChenT90;
//import com.syu.ui.air.Air_0395_WC2_RuiFengS3;
//import com.syu.ui.air.Air_0395_WC2_RuiFengS5;
//import com.syu.ui.air.Air_0395_WC2_RuiHu3X;
//import com.syu.ui.air.Air_0395_WC2_RuiHu5;
//import com.syu.ui.air.Air_0395_WC2_YeMa_T70;
import com.syu.ui.door.DoorHelper;

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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 174) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 174; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        switch (carId) {
            case 0:
                initDoor(callback);
                break;
            case 1:
                initDoor(callback);
                break;
            case 2:
            case 4:
            case 26:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS5(LauncherApplication.getInstance()));
                for (int i2 = 10; i2 < 97; i2++) {
                    DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 3:
                initAir(callback);
                break;
            case 5:
                initDoor(callback);
                break;
            case 6:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQiX25(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 97; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 7:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_HaiMaV70(LauncherApplication.getInstance()));
                for (int i4 = 10; i4 < 97; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 8:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu3X(LauncherApplication.getInstance()));
                for (int i5 = 10; i5 < 97; i5++) {
                    DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 10:
            case 25:
                initDoor(callback);
                break;
            case 11:
            case 19:
            case 20:
            case 31:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQiX25(LauncherApplication.getInstance()));
                for (int i6 = 10; i6 < 97; i6++) {
                    DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 12:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_FengGuang580(LauncherApplication.getInstance()));
                for (int i7 = 10; i7 < 97; i7++) {
                    DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 13:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_BenTengB50(LauncherApplication.getInstance()));
                for (int i8 = 10; i8 < 97; i8++) {
                    DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 14:
            case 15:
            case 27:
            case 28:
            case 29:
            case 30:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu5(LauncherApplication.getInstance()));
                for (int i9 = 10; i9 < 97; i9++) {
                    DataCanbus.NOTIFY_EVENTS[i9].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 16:
            case 18:
                initDoor(callback);
                break;
            case 17:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_YeMa_T70(LauncherApplication.getInstance()));
                for (int i10 = 10; i10 < 97; i10++) {
                    DataCanbus.NOTIFY_EVENTS[i10].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 21:
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenT90(LauncherApplication.getInstance()));
                for (int i11 = 10; i11 < 97; i11++) {
                    DataCanbus.NOTIFY_EVENTS[i11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 22:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS3(LauncherApplication.getInstance()));
                for (int i12 = 10; i12 < 97; i12++) {
                    DataCanbus.NOTIFY_EVENTS[i12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 23:
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenD60(LauncherApplication.getInstance()));
                for (int i13 = 10; i13 < 97; i13++) {
                    DataCanbus.NOTIFY_EVENTS[i13].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 24:
                initDoor(callback);
                //AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQi_18BJ20(LauncherApplication.getInstance()));
                for (int i14 = 10; i14 < 97; i14++) {
                    DataCanbus.NOTIFY_EVENTS[i14].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
        }
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

    private void initAir(IModuleCallback callback) {
        //AirHelper.getInstance().buildUi(new Air_0395_WC2_GUOCHAN(LauncherApplication.getInstance()));
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void initDoor(IModuleCallback callback) {
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
        }
    }
}
