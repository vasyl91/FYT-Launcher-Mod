package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XFY_Keleiao extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 4;
    public static final int U_AIR_BLOW_FOOT_LEFT = 5;
    public static final int U_AIR_BLOW_MODE = 6;
    public static final int U_AIR_BLOW_UP_LEFT = 3;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_CYCLE_AUTO = 16;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FAST = 13;
    public static final int U_AIR_FRONT_MAX = 11;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_SOFT = 12;
    public static final int U_AIR_TEMP_LEFT = 1;
    public static final int U_AIR_TEMP_RIGHT = 2;
    public static final int U_AIR_WIND_LEVEL = 7;
    public static final int U_CNT_MAX = 25;
    public static final int U_DOOR_BACK = 23;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 24;
    public static final int U_DOOR_ENGINE = 18;
    public static final int U_DOOR_FL = 19;
    public static final int U_DOOR_FR = 20;
    public static final int U_DOOR_RL = 21;
    public static final int U_DOOR_RR = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 25; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 18;
        DoorHelper.sUcDoorFl = 19;
        DoorHelper.sUcDoorFr = 20;
        DoorHelper.sUcDoorRl = 21;
        DoorHelper.sUcDoorRr = 22;
        DoorHelper.sUcDoorBack = 23;
        for (int i2 = 18; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 24; i++) {
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
