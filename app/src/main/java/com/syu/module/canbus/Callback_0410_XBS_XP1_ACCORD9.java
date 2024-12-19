package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0410_XBS_XP1_ACCORD9;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0410_XBS_XP1_ACCORD9 extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 12;
    public static final int U_AIR_AC = 31;
    public static final int U_AIR_AUTO = 33;
    public static final int U_AIR_BEGIN = 30;
    public static final int U_AIR_BLOW_BODY = 37;
    public static final int U_AIR_BLOW_FOOT = 38;
    public static final int U_AIR_BLOW_WIN = 36;
    public static final int U_AIR_CYCLE = 32;
    public static final int U_AIR_DUAL = 34;
    public static final int U_AIR_END = 45;
    public static final int U_AIR_FRONT_DEFROST = 42;
    public static final int U_AIR_POWER = 30;
    public static final int U_AIR_REAR_DEFROST = 35;
    public static final int U_AIR_SHOW = 44;
    public static final int U_AIR_TEMP_LEFT = 40;
    public static final int U_AIR_TEMP_RIGHT = 41;
    public static final int U_AIR_TEMP_UNIT = 43;
    public static final int U_AIR_WIND_LEFT = 39;
    public static final int U_CARINDFO_END = 84;
    public static final int U_CARINFO_ACC_DISCOVERY_VEHICLE_IN_FRONT_TONE = 66;
    public static final int U_CARINFO_AUTO_LIGHT_SENSITIVITY = 54;
    public static final int U_CARINFO_BACK_BRIGHT = 50;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_BRIGHT_MODE = 79;
    public static final int U_CARINFO_CAMERA_LINKAGE_LAMP = 83;
    public static final int U_CARINFO_ENERGY_SAVE_AUTO_ENGHINE = 64;
    public static final int U_CARINFO_FUEL_EFFIC_BACKLIGHT = 61;
    public static final int U_CARINFO_HEADLIGHT_AUTO_OFF_TIME = 55;
    public static final int U_CARINFO_INTERIOR_LIGHT_DIMMING_TIME = 56;
    public static final int U_CARINFO_KEYLESS_ACCESS_BEEP = 59;
    public static final int U_CARINFO_KEY_LOCK_ANSWER = 57;
    public static final int U_CARINFO_LANGUAGE = 65;
    public static final int U_CARINFO_MINOR_LANE_DEPARTURE_SYS_SETTINGS = 70;
    public static final int U_CARINFO_MODE_BRIGHT = 80;
    public static final int U_CARINFO_MODE_CONTRAST = 81;
    public static final int U_CARINFO_MODE_STATURTION = 82;
    public static final int U_CARINFO_OUT_TEMP_SHOW = 53;
    public static final int U_CARINFO_PAUSE_LKAS_TONE = 67;
    public static final int U_CARINFO_REMOTE_START_SYS = 60;
    public static final int U_CARINFO_SECURITY_RELOCK_TIME = 58;
    public static final int U_CARINFO_SET_FRONT_HAZARD_DISTANCE = 68;
    public static final int U_CARINFO_SMART_KEY_START_GUIDE = 62;
    public static final int U_CARINFO_TRAFFIC_SIGN_RECOGNITION_SYS = 69;
    public static final int U_CARINFO_TRIP_A = 51;
    public static final int U_CARINFO_TRIP_B = 52;
    public static final int U_CARINFO_VOLUME_ALARM_SYS = 63;
    public static final int U_CARRADIO_BEGIN = 100;
    public static final int U_CARRADIO_END = 113;
    public static final int U_CHANNEL_CNT = 105;
    public static final int U_CHANNEL_FREQ = 103;
    public static final int U_CHANNEL_FREQ_AM = 104;
    public static final int U_CNT_MAX = 113;
    public static final int U_CUR_BAND = 101;
    public static final int U_CUR_CHANNEL = 102;
    public static final int U_CUR_FREQ = 100;
    public static final int U_DOOR_BACK = 25;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 26;
    public static final int U_DOOR_ENGINE = 20;
    public static final int U_DOOR_FL = 21;
    public static final int U_DOOR_FR = 22;
    public static final int U_DOOR_RL = 23;
    public static final int U_DOOR_RR = 24;
    public static final int U_LIST_CNT = 107;
    public static final int U_LIST_FREQ = 106;
    public static final int U_PRESET_CHANNEL = 111;
    public static final int U_STATE_REFRESH = 109;
    public static final int U_STATE_SCAN = 108;
    public static final int U_STATE_ST = 110;
    public static final int[] CHANNEL_FREQ_REFRESH = new int[12];
    public static final int[] CHANNEL_FREQ_LIST = new int[256];

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 113) {
            if (updateCode == 44) {
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
        for (int i = 0; i < 113; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0410_XBS_XP1_ACCORD9(LauncherApplication.getInstance()));
        for (int i2 = 20; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 30; i3 < 45; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 30; i2 < 45; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }
}
