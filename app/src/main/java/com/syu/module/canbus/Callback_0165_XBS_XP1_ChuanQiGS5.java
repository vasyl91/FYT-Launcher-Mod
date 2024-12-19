package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0165_XBS_ChuanQiGs3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0165_XBS_XP1_ChuanQiGS5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 39;
    public static final int U_AIR_ANION_MODE = 3;
    public static final int U_AIR_AUTO = 35;
    public static final int U_AIR_BEGIN = 34;
    public static final int U_AIR_BLOW_BODY_LEFT = 41;
    public static final int U_AIR_BLOW_FOOT_LEFT = 42;
    public static final int U_AIR_BLOW_UP_LEFT = 43;
    public static final int U_AIR_COMFORT = 2;
    public static final int U_AIR_CYCLE = 36;
    public static final int U_AIR_DUAL = 50;
    public static final int U_AIR_END = 52;
    public static final int U_AIR_FRONT_DEFROST = 37;
    public static final int U_AIR_ION = 49;
    public static final int U_AIR_MAX = 51;
    public static final int U_AIR_POWER = 48;
    public static final int U_AIR_REAR_DEFROST = 38;
    public static final int U_AIR_SEAT_HEAT_LEFT = 45;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 46;
    public static final int U_AIR_TEMP_LEFT = 40;
    public static final int U_AIR_TEMP_RIGHT = 47;
    public static final int U_AIR_WIND_LEVEL_LEFT = 44;
    public static final int U_AUTO_AC_ENABLED = 11;
    public static final int U_AUTO_COMPRE = 0;
    public static final int U_AUTO_CYCLE = 1;
    public static final int U_AUTO_MATICALLY = 7;
    public static final int U_AUTO_REAR = 26;
    public static final int U_AUTO_UNLOCK = 15;
    public static final int U_BATTERY = 28;
    public static final int U_CAR_GUANGXIAOQI = 20;
    public static final int U_CAR_LANGUAGE = 19;
    public static final int U_CHARGE = 30;
    public static final int U_CNT_MAX = 58;
    public static final int U_CUR_TRIP_OIL_EXPEND = 8;
    public static final int U_CYCLE_DATE = 33;
    public static final int U_CYCLE_MODE = 32;
    public static final int U_DAYLIGHT = 23;
    public static final int U_DOOR_BACK = 57;
    public static final int U_DOOR_BEGIN = 52;
    public static final int U_DOOR_END = 58;
    public static final int U_DOOR_ENGINE = 52;
    public static final int U_DOOR_FL = 53;
    public static final int U_DOOR_FR = 54;
    public static final int U_DOOR_RL = 55;
    public static final int U_DOOR_RR = 56;
    public static final int U_DRIVER_SEAT = 4;
    public static final int U_ENERGY_BACK = 27;
    public static final int U_ENERGY_FLOW = 29;
    public static final int U_FEEDBACK_LAMP_ENABLED = 10;
    public static final int U_FRONT_WIND = 16;
    public static final int U_FRONT_YUGUA = 17;
    public static final int U_LIGHT_ASISTY = 24;
    public static final int U_MISC_END = 34;
    public static final int U_REAR_YUGUA = 18;
    public static final int U_RESERVE_TIME = 31;
    public static final int U_ROMOTE_UNLOCK = 13;
    public static final int U_SEAT_WELCOME = 6;
    public static final int U_SECDRIVER_SEAT = 5;
    public static final int U_SPEEDLOCK = 14;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 9;
    public static final int U_UNLOCK_VOL = 25;
    public static final int U_VALID_VENTILATION_ENABLED = 12;
    public static final int U_WITHHOME = 21;
    public static final int U_WUDENG_HELP = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 58; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 52;
        DoorHelper.sUcDoorFl = 53;
        DoorHelper.sUcDoorFr = 54;
        DoorHelper.sUcDoorRl = 55;
        DoorHelper.sUcDoorRr = 56;
        DoorHelper.sUcDoorBack = 57;
        AirHelper.getInstance().buildUi(new Air_0165_XBS_ChuanQiGs3(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 52; i2 < 58; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 34; i3 < 52; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 52; i < 58; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 34; i2 < 52; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 58) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
