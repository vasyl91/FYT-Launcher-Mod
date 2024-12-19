package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0392_CYT_SHUPING_CAMARY extends CallbackCanbusBase {
    public static final int C_2TIMES_KEY_UNLOCK = 12;
    public static final int C_AIR_BY_AUTO_KEY = 17;
    public static final int C_AIR_CONTIRE_CMD = 22;
    public static final int C_AUTOLOCK_BY_SHIFT_FROM_P = 2;
    public static final int C_AUTOLOCK_BY_SHIFT_TO_P = 3;
    public static final int C_AUTOLOCK_BY_SPEED = 1;
    public static final int C_CAR_CAMERA_LOUCS = 21;
    public static final int C_CLEAR_LAST_N_MINUTE_OIL_EXPEND = 10;
    public static final int C_CLEAR_TRIP_OIL_EXPEND = 9;
    public static final int C_CLOSE_BIGLAMP_TIME = 7;
    public static final int C_CLOSE_INSIDELAMP_TIME = 11;
    public static final int C_DAYTIME_RUNNING_LIGHTS = 5;
    public static final int C_IN_OUT_AIR_BY_AUTO_KEY = 18;
    public static final int C_LOCK_UNLOCK_FEEDBACK_TONE = 6;
    public static final int C_LOCK_UNLOCK_LAMP_FLASH = 16;
    public static final int C_RADAR_VOL = 19;
    public static final int C_REMOTE_2PRESS_UNLOCK = 4;
    public static final int C_SENSITIVITY_OPEN_BIGLAMP = 0;
    public static final int C_SMARTLOCK_AND_ONE_KEY_BOOT = 15;
    public static final int C_UNLOCK_BY_DRIVERS_DOOR_OPEN = 13;
    public static final int C_UNLOCK_BY_SMART_DOOR = 14;
    public static final int C_UPDATE_TRIP_OIL_EXPEND = 8;
    public static final int DOOR_ALL = 0;
    public static final int DOOR_DRIVER = 1;
    public static final int U_AIR_AC = 60;
    public static final int U_AIR_AC_MAX = 73;
    public static final int U_AIR_AUTO = 76;
    public static final int U_AIR_BEGIN = 59;
    public static final int U_AIR_BLOW_BODY = 66;
    public static final int U_AIR_BLOW_FOOT = 67;
    public static final int U_AIR_BLOW_UP = 65;
    public static final int U_AIR_CYCLE = 62;
    public static final int U_AIR_DUAL = 63;
    public static final int U_AIR_END = 89;
    public static final int U_AIR_FLOWER = 80;
    public static final int U_AIR_FRONT = 79;
    public static final int U_AIR_MAX = 61;
    public static final int U_AIR_POWER = 59;
    public static final int U_AIR_REAR = 64;
    public static final int U_AIR_REAR_LOCK = 72;
    public static final int U_AIR_SEAT_COLD_LEFT = 77;
    public static final int U_AIR_SEAT_COLD_RIGHT = 78;
    public static final int U_AIR_SEAT_HEAT_LEFT = 71;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 74;
    public static final int U_AIR_TEMP_LEFT = 69;
    public static final int U_AIR_TEMP_OUT = 75;
    public static final int U_AIR_TEMP_RIGHT = 70;
    public static final int U_AIR_WIND_LEVEL = 68;
    public static final int U_AIR_WIND_MODE = 82;
    public static final int U_CNT_MAX = 95;
    public static final int U_DOOR_BACK = 94;
    public static final int U_DOOR_BEGIN = 89;
    public static final int U_DOOR_END = 95;
    public static final int U_DOOR_ENGINE = 89;
    public static final int U_DOOR_FL = 90;
    public static final int U_DOOR_FR = 91;
    public static final int U_DOOR_RL = 92;
    public static final int U_DOOR_RR = 93;
    public static final int U_SAFE_BELF_RIGHT = 81;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 95; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 89;
        DoorHelper.sUcDoorFl = 90;
        DoorHelper.sUcDoorFr = 91;
        DoorHelper.sUcDoorRl = 92;
        DoorHelper.sUcDoorRr = 93;
        DoorHelper.sUcDoorBack = 94;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 89; i2 < 95; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 89; i < 95; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 8:
                    TripOilExpand(updateCode, ints);
                    break;
                case 37:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 95) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
