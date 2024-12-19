package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LZ_Kayan extends CallbackCanbusBase {
    public static final int CMD_SET_CTRL = 0;
    public static final int U_CAR_SET_AIR_AUTOCIRC = 21;
    public static final int U_CAR_SET_AIR_PANEL = 20;
    public static final int U_CAR_SET_AIR_STYLE = 22;
    public static final int U_CAR_SET_BEGIN = 10;
    public static final int U_CAR_SET_COMFORT_ENTRY = 19;
    public static final int U_CAR_SET_DAYTIME_LIGHT = 13;
    public static final int U_CAR_SET_DOOR_LOCK = 18;
    public static final int U_CAR_SET_DOOR_UNLOCK = 17;
    public static final int U_CAR_SET_END = 24;
    public static final int U_CAR_SET_EXTERIORLIGHT_OFFTIME = 23;
    public static final int U_CAR_SET_INTERLIGHT = 12;
    public static final int U_CAR_SET_INTERLIGHT_OFFTIME = 11;
    public static final int U_CAR_SET_REAR_WIPER = 15;
    public static final int U_CAR_SET_REVERSING_OPTIONS = 16;
    public static final int U_CAR_SET_WIPER_SENSOR = 14;
    public static final int U_CNT_MAX = 25;
    public static final int U_CUR_SPEED = 9;
    public static final int U_ENGINE_SPEED = 7;
    public static final int U_TOTAL_MILEAGE = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 25; i++) {
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
        if (updateCode >= 0 && updateCode < 25) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
