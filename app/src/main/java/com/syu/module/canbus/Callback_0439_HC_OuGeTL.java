package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_OuGeTL extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO_LEFT = 5;
    public static final int U_AIR_AUTO_RIGHT = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_BODY_RIGHT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_BLOW_UP_RIGHT = 11;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 6;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_WIND_LEVEL = 14;
    public static final int U_CNT_MAX = 27;
    public static final int U_DOOR_BACK = 24;
    public static final int U_DOOR_BEGIN = 19;
    public static final int U_DOOR_END = 25;
    public static final int U_DOOR_ENGINE = 19;
    public static final int U_DOOR_FL = 20;
    public static final int U_DOOR_FR = 21;
    public static final int U_DOOR_RL = 22;
    public static final int U_DOOR_RR = 23;
    public static final int U_JUMP_CARINFO = 26;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 27; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 19;
        DoorHelper.sUcDoorFl = 20;
        DoorHelper.sUcDoorFr = 21;
        DoorHelper.sUcDoorRl = 22;
        DoorHelper.sUcDoorRr = 23;
        DoorHelper.sUcDoorBack = 24;
        for (int i2 = 19; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 19; i < 25; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 27) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
