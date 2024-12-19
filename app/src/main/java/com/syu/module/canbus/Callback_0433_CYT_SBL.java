package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0433_CYT_SBL extends CallbackCanbusBase {
    public static final int C_AIR_CMD = 0;
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_AC_MAX = 28;
    public static final int U_AIR_AQS = 25;
    public static final int U_AIR_AUTO = 31;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BIG_WIND_LIGHT = 11;
    public static final int U_AIR_BLOW_BODY = 19;
    public static final int U_AIR_BLOW_FOOT = 21;
    public static final int U_AIR_BLOW_UP = 18;
    public static final int U_AIR_CYCLE = 15;
    public static final int U_AIR_DUAL = 16;
    public static final int U_AIR_END = 33;
    public static final int U_AIR_FRONT_DEFROG = 14;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 12;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_REAR_DEFROG = 17;
    public static final int U_AIR_REAR_LOCK = 27;
    public static final int U_AIR_SEAT_HEAT_LEFT = 26;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 29;
    public static final int U_AIR_SHOW = 20;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_OUT = 30;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL = 22;
    public static final int U_AIR_WIND_MODE = 32;
    public static final int U_CNT_MAX = 34;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
