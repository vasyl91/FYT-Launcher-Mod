package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0390_XBS_XP1_ZhongTaiT600 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 33;
    public static final int U_DOOR_BACK = 31;
    public static final int U_DOOR_BEGIN = 26;
    public static final int U_DOOR_END = 32;
    public static final int U_DOOR_ENGINE = 26;
    public static final int U_DOOR_FL = 27;
    public static final int U_DOOR_FR = 28;
    public static final int U_DOOR_RL = 29;
    public static final int U_DOOR_RR = 30;
    public static final int U_LAMP_STATE = 21;
    public static final int U_PM25_IN = 24;
    public static final int U_PM25_OUT = 25;
    public static final int U_PM25_VALUE = 23;
    public static final int U_PRESSURE_FL = 6;
    public static final int U_PRESSURE_FR = 7;
    public static final int U_PRESSURE_RL = 8;
    public static final int U_PRESSURE_RR = 9;
    public static final int U_PRESSURE_WARN_FL = 14;
    public static final int U_PRESSURE_WARN_FR = 15;
    public static final int U_PRESSURE_WARN_RL = 16;
    public static final int U_PRESSURE_WARN_RR = 17;
    public static final int U_SEAT_HEAT_LEFT = 19;
    public static final int U_SEAT_HEAT_RIGHT = 20;
    public static final int U_SYSTEM_UNWORK_WARN = 18;
    public static final int U_TEMP_BEGIN = 0;
    public static final int U_TEMP_FL = 2;
    public static final int U_TEMP_FR = 3;
    public static final int U_TEMP_RL = 4;
    public static final int U_TEMP_RR = 5;
    public static final int U_TEMP_WARN_FL = 10;
    public static final int U_TEMP_WARN_FR = 11;
    public static final int U_TEMP_WARN_RL = 12;
    public static final int U_TEMP_WARN_RR = 13;
    public static final int U_TEMP_WATER = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 33; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 26;
        DoorHelper.sUcDoorFl = 27;
        DoorHelper.sUcDoorFr = 28;
        DoorHelper.sUcDoorRl = 29;
        DoorHelper.sUcDoorRr = 30;
        DoorHelper.sUcDoorBack = 31;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 26; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 26; i < 32; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 33) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
