package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_lz_bba_all;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_BBA_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 20;
    public static final int U_AIR_AUTO = 47;
    public static final int U_AIR_BEGIN = 18;
    public static final int U_AIR_BLOW_AUTO_LEFT = 28;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 32;
    public static final int U_AIR_BLOW_BODY_LEFT = 26;
    public static final int U_AIR_BLOW_BODY_RIGHT = 30;
    public static final int U_AIR_BLOW_FOOT_LEFT = 27;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 31;
    public static final int U_AIR_BLOW_UP_LEFT = 25;
    public static final int U_AIR_BLOW_UP_RIGHT = 29;
    public static final int U_AIR_CYCLE = 21;
    public static final int U_AIR_END = 48;
    public static final int U_AIR_FRONT_DEFROST = 22;
    public static final int U_AIR_POWER = 19;
    public static final int U_AIR_REAR_DEFROST = 23;
    public static final int U_AIR_SEAT_HEAT_LEFT = 37;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 38;
    public static final int U_AIR_SHOW_MODE_LEFT = 43;
    public static final int U_AIR_SHOW_MODE_RIGHT = 44;
    public static final int U_AIR_SHOW_SEAT_LEFT = 45;
    public static final int U_AIR_SHOW_SEAT_RIGHT = 46;
    public static final int U_AIR_SHOW_TEMP_LEFT = 41;
    public static final int U_AIR_SHOW_TEMP_RIGHT = 42;
    public static final int U_AIR_SHOW_WIN = 40;
    public static final int U_AIR_SYNC = 24;
    public static final int U_AIR_TEMP_LEFT = 33;
    public static final int U_AIR_TEMP_RIGHT = 34;
    public static final int U_AIR_TEMP_UNIT = 39;
    public static final int U_AIR_WIND_AUTO_LEFT = 36;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_CARAUX_CAR_MEDIA = 80;
    public static final int U_CARAUX_CAR_NAVI = 79;
    public static final int U_CARAUX_CAR_TYPE = 77;
    public static final int U_CARAUX_CTRL_TYPE = 76;
    public static final int U_CARAUX_NUM = 78;
    public static final int U_CARAUX_POSTION = 81;
    public static final int U_CAR_ANDROID_UI_VOL = 86;
    public static final int U_CAR_AUDI_TYPE = 90;
    public static final int U_CAR_BELT_STATE = 11;
    public static final int U_CAR_BENZ_TYPE = 89;
    public static final int U_CAR_BMW_TYPE = 88;
    public static final int U_CAR_CUR_SPEED = 14;
    public static final int U_CAR_D32_D0_B10 = 56;
    public static final int U_CAR_D32_D0_B32 = 55;
    public static final int U_CAR_D32_D0_B54 = 54;
    public static final int U_CAR_D32_D0_B76 = 53;
    public static final int U_CAR_D32_D1_B76 = 57;
    public static final int U_CAR_D35_D0_B0 = 70;
    public static final int U_CAR_D35_D0_B1 = 69;
    public static final int U_CAR_D35_D0_B2 = 68;
    public static final int U_CAR_D35_D0_B3 = 67;
    public static final int U_CAR_D35_D0_B4 = 66;
    public static final int U_CAR_D35_D0_B5 = 65;
    public static final int U_CAR_D35_D0_B6 = 64;
    public static final int U_CAR_D35_D10_B6 = 75;
    public static final int U_CAR_D35_D10_B7 = 74;
    public static final int U_CAR_D35_D1_B70 = 71;
    public static final int U_CAR_D35_D4_D5 = 72;
    public static final int U_CAR_D35_D7_D8_D9 = 73;
    public static final int U_CAR_D37_D0_B70 = 58;
    public static final int U_CAR_D38_D0_B10 = 61;
    public static final int U_CAR_D38_D0_B4 = 60;
    public static final int U_CAR_D38_D0_B7 = 59;
    public static final int U_CAR_D38_D2_B6 = 62;
    public static final int U_CAR_D38_D3_B70 = 87;
    public static final int U_CAR_D39_D0_B70 = 63;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_FOOTBRAKE_STATE = 12;
    public static final int U_CAR_HANDBRAKE_STATE = 13;
    public static final int U_CAR_LIGHT_FAR = 8;
    public static final int U_CAR_LIGHT_LEFT = 9;
    public static final int U_CAR_LIGHT_NEAR = 7;
    public static final int U_CAR_LIGHT_RIGHT = 10;
    public static final int U_CAR_LVDS_MODE = 82;
    public static final int U_CAR_SCREEN_H = 84;
    public static final int U_CAR_SCREEN_W = 83;
    public static final int U_CAR_TIRE_PRESSURE_FL = 49;
    public static final int U_CAR_TIRE_PRESSURE_FR = 50;
    public static final int U_CAR_TIRE_PRESSURE_RL = 51;
    public static final int U_CAR_TIRE_PRESSURE_RR = 52;
    public static final int U_CAR_TOTAL_MILE = 17;
    public static final int U_CAR_UI_VOL = 85;
    public static final int U_CNT_MAX = 91;
    public static int modevalue = -1;
    public static int cartype = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 91; i++) {
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
        for (int i3 = 18; i3 < 48; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0453_lz_bba_all(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 18; i2 < 48; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 77:
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
