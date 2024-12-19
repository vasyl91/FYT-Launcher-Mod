package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0231_DJ_MENGDIOU2013 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_ACMAX = 15;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_COLD_LEFT = 22;
    public static final int U_AIR_COLD_RIGHT = 23;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 16;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_FRONT_WIND_MODE = 17;
    public static final int U_AIR_HEAT_LEFT = 20;
    public static final int U_AIR_HEAT_RIGHT = 21;
    public static final int U_AIR_MAX = 14;
    public static final int U_AIR_MONO = 19;
    public static final int U_AIR_POWER = 12;
    public static final int U_AIR_REAR = 18;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CNT_MAX = 41;
    public static final int U_CUR_SPEED = 39;
    public static final int U_DOOR_BACK = 37;
    public static final int U_DOOR_BEGIN = 32;
    public static final int U_DOOR_END = 38;
    public static final int U_DOOR_ENGINE = 32;
    public static final int U_DOOR_FL = 33;
    public static final int U_DOOR_FR = 34;
    public static final int U_DOOR_RL = 35;
    public static final int U_DOOR_RR = 36;
    public static final int U_ENGINE_SPEED = 40;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 41; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 32;
        DoorHelper.sUcDoorFl = 33;
        DoorHelper.sUcDoorFr = 34;
        DoorHelper.sUcDoorRl = 35;
        DoorHelper.sUcDoorRr = 36;
        DoorHelper.sUcDoorBack = 37;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 32; i2 < 38; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 32; i < 38; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 41) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
