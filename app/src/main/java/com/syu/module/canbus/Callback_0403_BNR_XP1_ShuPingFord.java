package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0022_XP1_Focus2012;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0403_BNR_XP1_ShuPingFord extends CallbackCanbusBase {
    public static final int U_AIR_FRONT_DEFROG = 60;
    public static final int U_AIR_MODE = 48;
    public static final int U_AIR_REAR_DEFROG = 49;
    public static final int U_AIR_REAR_LOCK = 61;
    public static final int U_AIR_REAR_POWER = 63;
    public static final int U_AIR_REAR_TEMP_LEVEL = 65;
    public static final int U_AIR_REAR_TEMP_STATUS = 64;
    public static final int U_AIR_REAR_WIND_LEVEL = 62;
    public static final int U_AIR_SEAT_COLD_LEFT = 59;
    public static final int U_AIR_SEAT_COLD_RIGHT = 58;
    public static final int U_AIR_SEAT_HEAT_LEFT = 56;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 57;
    public static final int U_CARSET_AMBIENT_LIGHT = 54;
    public static final int U_CARSET_AMBIENT_LIGHT_COLOR = 55;
    public static final int U_CARSET_ECOMODE_CARSPEED = 51;
    public static final int U_CARSET_ECOMODE_DRIVE_PLAN = 50;
    public static final int U_CARSET_ENGINE_NOT_HOT = 52;
    public static final int U_CARSET_ENGINE_NOT_HOT_OPTION = 53;
    public static final int U_CAR_EQ_ASL = 76;
    public static final int U_CAR_EQ_BAL = 75;
    public static final int U_CAR_EQ_BASS = 77;
    public static final int U_CAR_EQ_BEGIN = 73;
    public static final int U_CAR_EQ_FAD = 74;
    public static final int U_CAR_EQ_MIDDLE = 78;
    public static final int U_CAR_EQ_SUROUND = 81;
    public static final int U_CAR_EQ_TREB = 79;
    public static final int U_CAR_EQ_VOL = 80;
    public static final int U_CAR_TIRE_BEGIN = 67;
    public static final int U_CAR_TIRE_END = 72;
    public static final int U_CAR_TIRE_VALUE_FL = 68;
    public static final int U_CAR_TIRE_VALUE_FR = 69;
    public static final int U_CAR_TIRE_VALUE_RL = 70;
    public static final int U_CAR_TIRE_VALUE_RR = 71;
    public static final int U_CNT_MAX = 82;
    public static final int U_SEAT_ADJUST_LEFT = 66;
    public static final int U_SEAT_ADJUST_RIGHT = 67;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 82; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 29;
        DoorHelper.sUcDoorFr = 30;
        DoorHelper.sUcDoorRl = 31;
        DoorHelper.sUcDoorRr = 32;
        DoorHelper.sUcDoorBack = 33;
        AirHelper.getInstance().buildUi(new Air_0022_XP1_Focus2012(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 29; i2 < 35; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 14; i3 < 29; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 29; i < 35; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 14; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1 || updateCode == 2 || updateCode == 7 || updateCode == 13 || updateCode == 12) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        } else if (updateCode >= 0 && updateCode < 82) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
