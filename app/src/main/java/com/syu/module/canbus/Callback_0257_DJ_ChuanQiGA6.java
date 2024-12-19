package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0257_DJ_ChuangQiGa6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0257_DJ_ChuanQiGA6 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 19;
    public static final int U_AIR_AC = 26;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 21;
    public static final int U_AIR_BLOW_BODY_LEFT = 28;
    public static final int U_AIR_BLOW_FOOT_LEFT = 29;
    public static final int U_AIR_BLOW_UP_LEFT = 30;
    public static final int U_AIR_CYCLE = 23;
    public static final int U_AIR_DUAL = 34;
    public static final int U_AIR_END = 37;
    public static final int U_AIR_FRONT_DEFROST = 24;
    public static final int U_AIR_POWER = 36;
    public static final int U_AIR_REAR_DEFROST = 25;
    public static final int U_AIR_SEAT_HEAT_LEFT = 32;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 33;
    public static final int U_AIR_TEMP_LEFT = 27;
    public static final int U_AIR_TEMP_RIGHT = 35;
    public static final int U_AIR_WIND_LEVEL_LEFT = 31;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 16;
    public static final int U_AVERAGE_SPEED = 4;
    public static final int U_CARINFO_END = 21;
    public static final int U_CLOSE_BIGLAMP_TIME = 12;
    public static final int U_CLOSE_INSIDELAMP_TIME = 11;
    public static final int U_CNT_MAX = 43;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_TRIP_OIL_EXPEND = 5;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 10;
    public static final int U_DISPLAY_ENABLE_0 = 3;
    public static final int U_DISPLAY_ENABLE_1 = 13;
    public static final int U_DISPLAY_ENABLE_2 = 14;
    public static final int U_DISPLAY_ENABLE_3 = 15;
    public static final int U_DOOR_BACK = 42;
    public static final int U_DOOR_BEGIN = 37;
    public static final int U_DOOR_END = 43;
    public static final int U_DOOR_ENGINE = 37;
    public static final int U_DOOR_FL = 38;
    public static final int U_DOOR_FR = 39;
    public static final int U_DOOR_RL = 40;
    public static final int U_DOOR_RR = 41;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_DRIVING_TIME = 7;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 18;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 9;
    public static final int U_OPTIMAL_OIL_EXPEND = 2;
    public static final int U_REMOTE_2PRESS_UNLOCK = 17;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 8;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 6;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 37;
        DoorHelper.sUcDoorFl = 38;
        DoorHelper.sUcDoorFr = 39;
        DoorHelper.sUcDoorRl = 40;
        DoorHelper.sUcDoorRr = 41;
        DoorHelper.sUcDoorBack = 42;
        AirHelper.getInstance().buildUi(new Air_0257_DJ_ChuangQiGa6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 37; i2 < 43; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 21; i3 < 37; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 37; i < 43; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 21; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
