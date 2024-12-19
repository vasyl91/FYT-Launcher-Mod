package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_TOYOTA_09HG extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_MODE_LEFT = 11;
    public static final int U_AIR_BLOW_WIN_LEFT = 10;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_CAR_EQ_BAL = 24;
    public static final int U_CAR_EQ_BASS = 26;
    public static final int U_CAR_EQ_FAD = 25;
    public static final int U_CAR_EQ_MID = 27;
    public static final int U_CAR_EQ_SPEEDVOL = 29;
    public static final int U_CAR_EQ_TRE = 28;
    public static final int U_CAR_EQ_VOL = 23;
    public static final int U_CNT_MAX = 30;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 30; i++) {
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
        if (updateCode >= 0 && updateCode < 30) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
