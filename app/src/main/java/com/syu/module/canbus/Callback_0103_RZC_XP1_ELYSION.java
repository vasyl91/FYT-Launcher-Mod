package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0103_RZC_XP1_ELYSION extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL = 4;
    public static final int U_AVERAGE_SPEED = 6;
    public static final int U_A_DIS_CONTROL_BIT = 2;
    public static final int U_B_DIS_CONTROL_BIT = 3;
    public static final int U_CAR_SPEED_INFO = 9;
    public static final int U_CNT_MAX = 22;
    public static final int U_DIS_CONTROL_BIT = 1;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;
    public static final int U_FRONT_FOG_LIGHTS_SWITCH = 13;
    public static final int U_HEADLIGHT_SWITCH = 11;
    public static final int U_HIGH_BEAM_SWITCH = 12;
    public static final int U_INSTRUMENT_LIGHT_BRIGHT = 15;
    public static final int U_OIL_BEGIN = 0;
    public static final int U_OIL_END = 16;
    public static final int U_REAR_FOG_LAMPS_SWITCH = 14;
    public static final int U_SMALL_LIGHTS_SWITCH = 10;
    public static final int U_TRAVEL_DISTANCE = 5;
    public static final int U_TRAVEL_TIME = 7;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 22; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 16; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 22) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
