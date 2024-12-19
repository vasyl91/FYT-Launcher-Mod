package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0326_XFY_DX7 extends CallbackCanbusBase {
    public static final int C_ALL_SETTINGS = 0;
    public static final int U_AIR_AC = 22;
    public static final int U_AIR_ACMAX = 30;
    public static final int U_AIR_AUTO = 18;
    public static final int U_AIR_BEGIN = 17;
    public static final int U_AIR_BLOW_BODY_LEFT = 24;
    public static final int U_AIR_BLOW_FOOT_LEFT = 25;
    public static final int U_AIR_BLOW_UP_LEFT = 26;
    public static final int U_AIR_CYCLE = 19;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_FRONT_DEFROST = 20;
    public static final int U_AIR_MAX_FRONT = 31;
    public static final int U_AIR_REAR_DEFROST = 21;
    public static final int U_AIR_SYNC = 29;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 28;
    public static final int U_AIR_WIND_LEVEL_LEFT = 27;
    public static final int U_CARINFO_BACKLIGHT_MOTOR = 40;
    public static final int U_CARINFO_BEGIN = 33;
    public static final int U_CARINFO_DOOR_UNLOCK = 35;
    public static final int U_CARINFO_LOCK_SPEED = 38;
    public static final int U_CARINFO_REARVIEW_AUTO = 34;
    public static final int U_CARINFO_RELOCK_AUTO = 39;
    public static final int U_CARINFO_TIME_FORMAT = 41;
    public static final int U_CARINFO_UNLOCK_AUTO = 37;
    public static final int U_CARINFO_UNLOCK_BY_LIGHT = 36;
    public static final int U_CNT_MAX = 42;
    public static final int U_CUR_OIL_EXPEND = 5;
    public static final int U_DOOR_BACK = 15;
    public static final int U_DOOR_BEGIN = 10;
    public static final int U_DOOR_END = 16;
    public static final int U_DOOR_ENGINE = 10;
    public static final int U_DOOR_FL = 11;
    public static final int U_DOOR_FR = 12;
    public static final int U_DOOR_RL = 13;
    public static final int U_DOOR_RR = 14;
    public static final int U_DRIVING_MILEAGE = 6;
    public static final int U_LAST_OIL = 8;
    public static final int U_OPTIMAL_OIL_EXPEND = 7;
    public static final int U_PRESSURE_FL = 1;
    public static final int U_PRESSURE_FR = 2;
    public static final int U_PRESSURE_RL = 3;
    public static final int U_PRESSURE_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 42; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 10;
        DoorHelper.sUcDoorFl = 11;
        DoorHelper.sUcDoorFr = 12;
        DoorHelper.sUcDoorRl = 13;
        DoorHelper.sUcDoorRr = 14;
        DoorHelper.sUcDoorBack = 15;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 10; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 16; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 42) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
