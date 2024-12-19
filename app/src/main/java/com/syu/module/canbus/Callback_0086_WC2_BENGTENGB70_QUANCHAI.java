package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0086_WC2_BENGTENGB70_QUANCHAI extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 7;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_CNT_MAX = 18;
    public static final int U_DOOR_BACK = 17;
    public static final int U_DOOR_BEGIN = 12;
    public static final int U_DOOR_END = 18;
    public static final int U_DOOR_ENGINE = 12;
    public static final int U_DOOR_FL = 13;
    public static final int U_DOOR_FR = 14;
    public static final int U_DOOR_RL = 15;
    public static final int U_DOOR_RR = 16;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 18; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 12;
        DoorHelper.sUcDoorFl = 13;
        DoorHelper.sUcDoorFr = 14;
        DoorHelper.sUcDoorRl = 15;
        DoorHelper.sUcDoorRr = 16;
        DoorHelper.sUcDoorBack = 17;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 12; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 12; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 18) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
