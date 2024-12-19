package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_19focus;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_19Focus extends CallbackCanbusBase {
    public static final int U_AIR_AC = 7;
    public static final int U_AIR_AUTO = 6;
    public static final int U_AIR_AUTO_LEV = 8;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_DUAL = 2;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 9;
    public static final int U_AIR_FRONT_HOT = 36;
    public static final int U_AIR_MAXAC = 4;
    public static final int U_AIR_MAXHEAT = 3;
    public static final int U_AIR_MAX__HEAT = 50;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_RADAR_BEEP = 51;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_REAR_LOCK = 23;
    public static final int U_AIR_REAR_POWER = 20;
    public static final int U_AIR_REAR_TEMP = 22;
    public static final int U_AIR_REAR_WIND_LEVEL = 21;
    public static final int U_AIR_SEAT_BLOW_LEFT = 37;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 38;
    public static final int U_AIR_SEAT_HEAT_LEFT = 11;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 12;
    public static final int U_AIR_STEER_HOT = 35;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_TEMP_UNIT = 33;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CAR_EQ_BAL = 43;
    public static final int U_CAR_EQ_BASS = 45;
    public static final int U_CAR_EQ_FAD = 44;
    public static final int U_CAR_EQ_MID = 46;
    public static final int U_CAR_EQ_SPEED_VOL = 48;
    public static final int U_CAR_EQ_SURROUND = 49;
    public static final int U_CAR_EQ_TREB = 47;
    public static final int U_CAR_EQ_VOL = 42;
    public static final int U_CAR_SET_AMBIENT_LIGHT = 41;
    public static final int U_CAR_SET_BEGIN = 39;
    public static final int U_CAR_SET_MILE_UNIT = 40;
    public static final int U_CNT_MAX = 52;
    public static final int U_CUR_SPEED = 31;
    public static final int U_DOOR_BACK = 29;
    public static final int U_DOOR_BEGIN = 24;
    public static final int U_DOOR_END = 30;
    public static final int U_DOOR_ENGINE = 24;
    public static final int U_DOOR_FL = 25;
    public static final int U_DOOR_FR = 26;
    public static final int U_DOOR_RL = 27;
    public static final int U_DOOR_RR = 28;
    public static final int U_DRIVING_TIME = 34;
    public static final int U_ENGINE_SPEED = 32;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 24;
        DoorHelper.sUcDoorFl = 25;
        DoorHelper.sUcDoorFr = 26;
        DoorHelper.sUcDoorRl = 27;
        DoorHelper.sUcDoorRr = 28;
        DoorHelper.sUcDoorBack = 29;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 24; i2 < 30; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_19focus(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 24; i < 30; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
