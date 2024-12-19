package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0395_WC2_BeiQiX25;
import com.syu.ui.air.Air_0395_WC2_BeiQi_18BJ20;
import com.syu.ui.air.Air_0395_WC2_BenTengB50;
import com.syu.ui.air.Air_0395_WC2_FengGuang580;
import com.syu.ui.air.Air_0395_WC2_GUOCHAN;
import com.syu.ui.air.Air_0395_WC2_HaiMaV70;
import com.syu.ui.air.Air_0395_WC2_QiChenD60;
import com.syu.ui.air.Air_0395_WC2_QiChenT90;
import com.syu.ui.air.Air_0395_WC2_RuiFengS3;
import com.syu.ui.air.Air_0395_WC2_RuiFengS5;
import com.syu.ui.air.Air_0395_WC2_RuiHu3X;
import com.syu.ui.air.Air_0395_WC2_RuiHu5;
import com.syu.ui.air.Air_0395_WC2_YeMa_T70;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0395_WC2_GuoChan extends CallbackCanbusBase {
    public static final int U_AIR_AC = 27;
    public static final int U_AIR_AQS = 43;
    public static final int U_AIR_AUTO = 25;
    public static final int U_AIR_BEGIN = 23;
    public static final int U_AIR_BLOW_AUTO = 33;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 64;
    public static final int U_AIR_BLOW_BODY_LEFT = 36;
    public static final int U_AIR_BLOW_BODY_RIGHT = 66;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 65;
    public static final int U_AIR_BLOW_MODE_LEFT = 69;
    public static final int U_AIR_BLOW_MODE_RIGHT = 70;
    public static final int U_AIR_BLOW_WIN_LEFT = 37;
    public static final int U_AIR_BLOW_WIN_RIGHT = 67;
    public static final int U_AIR_CYCLE = 28;
    public static final int U_AIR_DUAL = 72;
    public static final int U_AIR_END = 44;
    public static final int U_AIR_FRONT_DEFROST = 30;
    public static final int U_AIR_ION = 42;
    public static final int U_AIR_MAX = 24;
    public static final int U_AIR_REAL = 41;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_REAR_POWER = 71;
    public static final int U_AIR_SEAT_HEAT_LEFT = 31;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 32;
    public static final int U_AIR_SHOW = 81;
    public static final int U_AIR_SYNC = 26;
    public static final int U_AIR_TEMP_LEFT = 40;
    public static final int U_AIR_TEMP_RIGHT = 68;
    public static final int U_AIR_WIND_LEVEL_LEFT = 39;
    public static final int U_CARINFO_AUTO_AIR = 91;
    public static final int U_CARINFO_AUTO_FOLD_REARVIEW = 89;
    public static final int U_CARINFO_AUTO_LOCK = 73;
    public static final int U_CARINFO_AUTO_UNLOCK = 88;
    public static final int U_CARINFO_AUTO_WIND_LEV = 90;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_BELT_WARN = 97;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 74;
    public static final int U_CARINFO_BLIND_SIDE = 106;
    public static final int U_CARINFO_BTPHONE_LOW_WIND = 94;
    public static final int U_CARINFO_CAR_VOL = 62;
    public static final int U_CARINFO_CHANGE_ROAD_LIGHTONOFF = 110;
    public static final int U_CARINFO_CHARGING_SECURITY = 103;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 80;
    public static final int U_CARINFO_DAYLIGHT = 75;
    public static final int U_CARINFO_END = 115;
    public static final int U_CARINFO_ENERGY_CYCLE = 104;
    public static final int U_CARINFO_ENGIN_SPEED = 50;
    public static final int U_CARINFO_EPS_MODE = 111;
    public static final int U_CARINFO_FORTIFICATION_PROMPT = 108;
    public static final int U_CARINFO_HAND_ENABLE = 113;
    public static final int U_CARINFO_HAND_SKYWIN = 114;
    public static final int U_CARINFO_HOME_LIGHT = 109;
    public static final int U_CARINFO_LIGHT_DIPPED = 52;
    public static final int U_CARINFO_LIGHT_DOUBLE_FLASH = 58;
    public static final int U_CARINFO_LIGHT_FFOG = 55;
    public static final int U_CARINFO_LIGHT_HIGBEAM = 53;
    public static final int U_CARINFO_LIGHT_LAMP = 54;
    public static final int U_CARINFO_LIGHT_LEFT_TURN = 56;
    public static final int U_CARINFO_LIGHT_RIGHT_TURN = 57;
    public static final int U_CARINFO_LONGTOUCH_LOCK_WINDOW = 100;
    public static final int U_CARINFO_LONGTOUCH_UNLOCK_WINDOW = 99;
    public static final int U_CARINFO_NO_FIND_KEY = 95;
    public static final int U_CARINFO_NO_PARK_AWAY = 96;
    public static final int U_CARINFO_PARK_CYCLE = 93;
    public static final int U_CARINFO_PM25_TEST = 92;
    public static final int U_CARINFO_REARVIEW_AUTO = 102;
    public static final int U_CARINFO_REMOTE_BACK = 87;
    public static final int U_CARINFO_REMOTE_DOWN_WINDOW = 101;
    public static final int U_CARINFO_RESTRICTOR = 51;
    public static final int U_CARINFO_ROAD_AWAY = 107;
    public static final int U_CARINFO_SPEED_ALARM = 79;
    public static final int U_CARINFO_STEERING_ANIM = 77;
    public static final int U_CARINFO_STEERING_AVM = 76;
    public static final int U_CARINFO_STEERING_POWER = 105;
    public static final int U_CARINFO_UNLOCK_DOOR = 98;
    public static final int U_CARINFO_VEHICLE_GUIDES = 78;
    public static final int U_CARINFO_WARN_EXIST = 59;
    public static final int U_CARINFO_WARN_SWITCH = 60;
    public static final int U_CARINFO_WARN_TYPE = 61;
    public static final int U_CARINFO_WELCOME_ONOFF = 112;
    public static final int U_CNT_MAX = 115;
    public static final int U_DOOR_BACK = 49;
    public static final int U_DOOR_BEGIN = 44;
    public static final int U_DOOR_END = 50;
    public static final int U_DOOR_ENGINE = 44;
    public static final int U_DOOR_FL = 45;
    public static final int U_DOOR_FR = 46;
    public static final int U_DOOR_RL = 47;
    public static final int U_DOOR_RR = 48;
    public static final int U_POWER_ON = 23;
    public static final int U_PRESSINFO_FL = 82;
    public static final int U_PRESSINFO_FR = 83;
    public static final int U_PRESSINFO_RL = 84;
    public static final int U_PRESSINFO_RR = 85;
    public static final int U_PRESSURE_FL = 6;
    public static final int U_PRESSURE_FR = 7;
    public static final int U_PRESSURE_RL = 8;
    public static final int U_PRESSURE_RR = 9;
    public static final int U_SYSTEM_UNWORK_WARN = 22;
    public static final int U_TEMP_BEGIN = 0;
    public static final int U_TEMP_END = 23;
    public static final int U_TEMP_FL = 2;
    public static final int U_TEMP_FR = 3;
    public static final int U_TEMP_RL = 4;
    public static final int U_TEMP_RR = 5;
    public static final int U_TEMP_WARN_FFW = 10;
    public static final int U_TEMP_WARN_FL_H = 12;
    public static final int U_TEMP_WARN_FL_L = 11;
    public static final int U_TEMP_WARN_FRW = 13;
    public static final int U_TEMP_WARN_FR_H = 14;
    public static final int U_TEMP_WARN_FR_L = 15;
    public static final int U_TEMP_WARN_RLW = 16;
    public static final int U_TEMP_WARN_RL_H = 18;
    public static final int U_TEMP_WARN_RL_L = 17;
    public static final int U_TEMP_WARN_RRW = 19;
    public static final int U_TEMP_WARN_RR_H = 21;
    public static final int U_TEMP_WARN_RR_L = 20;
    public static final int U_WARN_ZHONGTAI = 86;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 115) {
            if (updateCode == 81) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                    return;
                } else {
                    AirHelper.getInstance().showAndRefresh();
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
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
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS5(LauncherApplication.getInstance()));
                for (int i2 = 23; i2 < 44; i2++) {
                    DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[64].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[65].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[66].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[67].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 3:
                initAir(callback);
                break;
            case 5:
                initDoor(callback);
                break;
            case 6:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQiX25(LauncherApplication.getInstance()));
                for (int i3 = 23; i3 < 44; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 7:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_HaiMaV70(LauncherApplication.getInstance()));
                for (int i4 = 23; i4 < 44; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 8:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu3X(LauncherApplication.getInstance()));
                for (int i5 = 23; i5 < 44; i5++) {
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
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQiX25(LauncherApplication.getInstance()));
                for (int i6 = 23; i6 < 44; i6++) {
                    DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 12:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_FengGuang580(LauncherApplication.getInstance()));
                for (int i7 = 23; i7 < 44; i7++) {
                    DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[71].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 13:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BenTengB50(LauncherApplication.getInstance()));
                for (int i8 = 23; i8 < 44; i8++) {
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
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu5(LauncherApplication.getInstance()));
                for (int i9 = 23; i9 < 44; i9++) {
                    DataCanbus.NOTIFY_EVENTS[i9].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[72].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 16:
            case 18:
                initDoor(callback);
                break;
            case 17:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_YeMa_T70(LauncherApplication.getInstance()));
                for (int i10 = 23; i10 < 44; i10++) {
                    DataCanbus.NOTIFY_EVENTS[i10].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case 21:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenT90(LauncherApplication.getInstance()));
                for (int i11 = 23; i11 < 44; i11++) {
                    DataCanbus.NOTIFY_EVENTS[i11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[72].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 22:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiFengS3(LauncherApplication.getInstance()));
                for (int i12 = 23; i12 < 44; i12++) {
                    DataCanbus.NOTIFY_EVENTS[i12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[64].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[65].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[66].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[67].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 23:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_QiChenD60(LauncherApplication.getInstance()));
                for (int i13 = 23; i13 < 44; i13++) {
                    DataCanbus.NOTIFY_EVENTS[i13].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[72].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                break;
            case 24:
                initDoor(callback);
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQi_18BJ20(LauncherApplication.getInstance()));
                for (int i14 = 23; i14 < 44; i14++) {
                    DataCanbus.NOTIFY_EVENTS[i14].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        switch (carId) {
            case 0:
                for (int i = 23; i < 44; i++) {
                    DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                AirHelper.getInstance().destroyUi();
                break;
            case 1:
                for (int i2 = 44; i2 < 50; i2++) {
                    DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                break;
            case 2:
                for (int i3 = 44; i3 < 50; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                break;
            case 3:
                for (int i4 = 23; i4 < 44; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                AirHelper.getInstance().destroyUi();
                break;
            case 4:
            case 22:
                for (int i5 = 44; i5 < 50; i5++) {
                    DataCanbus.NOTIFY_EVENTS[i5].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i6 = 23; i6 < 44; i6++) {
                    DataCanbus.NOTIFY_EVENTS[i6].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                DataCanbus.NOTIFY_EVENTS[64].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[65].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[66].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[67].removeNotify(AirHelper.SHOW_AND_REFRESH);
                AirHelper.getInstance().destroyUi();
                break;
            case 5:
                for (int i7 = 44; i7 < 50; i7++) {
                    DataCanbus.NOTIFY_EVENTS[i7].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                break;
            case 6:
                for (int i8 = 23; i8 < 44; i8++) {
                    DataCanbus.NOTIFY_EVENTS[i8].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                AirHelper.getInstance().destroyUi();
                break;
            case 7:
                for (int i9 = 44; i9 < 50; i9++) {
                    DataCanbus.NOTIFY_EVENTS[i9].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i10 = 23; i10 < 44; i10++) {
                    DataCanbus.NOTIFY_EVENTS[i10].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                AirHelper.getInstance().destroyUi();
                break;
            case 8:
            case 17:
                for (int i11 = 44; i11 < 50; i11++) {
                    DataCanbus.NOTIFY_EVENTS[i11].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i12 = 23; i12 < 44; i12++) {
                    DataCanbus.NOTIFY_EVENTS[i12].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                AirHelper.getInstance().destroyUi();
                break;
            case 10:
                for (int i13 = 44; i13 < 50; i13++) {
                    DataCanbus.NOTIFY_EVENTS[i13].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                break;
            case 12:
            case 26:
            case 27:
            case 28:
                for (int i14 = 44; i14 < 50; i14++) {
                    DataCanbus.NOTIFY_EVENTS[i14].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i15 = 23; i15 < 44; i15++) {
                    DataCanbus.NOTIFY_EVENTS[i15].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                DataCanbus.NOTIFY_EVENTS[71].removeNotify(AirHelper.SHOW_AND_REFRESH);
                AirHelper.getInstance().destroyUi();
                break;
            case 13:
                for (int i16 = 44; i16 < 50; i16++) {
                    DataCanbus.NOTIFY_EVENTS[i16].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i17 = 23; i17 < 44; i17++) {
                    DataCanbus.NOTIFY_EVENTS[i17].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                break;
            case 14:
                for (int i18 = 44; i18 < 50; i18++) {
                    DataCanbus.NOTIFY_EVENTS[i18].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                for (int i19 = 23; i19 < 44; i19++) {
                    DataCanbus.NOTIFY_EVENTS[i19].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                DataCanbus.NOTIFY_EVENTS[72].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[68].removeNotify(AirHelper.SHOW_AND_REFRESH);
                AirHelper.getInstance().destroyUi();
                break;
            case 16:
            case 18:
                for (int i20 = 44; i20 < 50; i20++) {
                    DataCanbus.NOTIFY_EVENTS[i20].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                break;
            case 21:
            case 23:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu5(LauncherApplication.getInstance()));
                for (int i21 = 23; i21 < 44; i21++) {
                    DataCanbus.NOTIFY_EVENTS[i21].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                DataCanbus.NOTIFY_EVENTS[72].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[68].removeNotify(AirHelper.SHOW_AND_REFRESH);
                break;
            case 24:
                for (int i22 = 44; i22 < 50; i22++) {
                    DataCanbus.NOTIFY_EVENTS[i22].removeNotify(DoorHelper.getInstance());
                }
                DoorHelper.getInstance().destroyUi();
                AirHelper.getInstance().buildUi(new Air_0395_WC2_BeiQi_18BJ20(LauncherApplication.getInstance()));
                for (int i23 = 23; i23 < 44; i23++) {
                    DataCanbus.NOTIFY_EVENTS[i23].removeNotify(AirHelper.SHOW_AND_REFRESH);
                }
                break;
        }
    }

    private void initAir(IModuleCallback callback) {
        AirHelper.getInstance().buildUi(new Air_0395_WC2_GUOCHAN(LauncherApplication.getInstance()));
        for (int i = 23; i < 44; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void initDoor(IModuleCallback callback) {
        DoorHelper.sUcDoorEngine = 44;
        DoorHelper.sUcDoorFl = 45;
        DoorHelper.sUcDoorFr = 46;
        DoorHelper.sUcDoorRl = 47;
        DoorHelper.sUcDoorRr = 48;
        DoorHelper.sUcDoorBack = 49;
        DoorHelper.getInstance().buildUi();
        for (int i = 44; i < 50; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
        }
    }
}
