package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Tianlai_Gongjue extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_MODE = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 7;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL = 12;
    public static final int U_CAREQ_BAL = 24;
    public static final int U_CAREQ_BASS = 27;
    public static final int U_CAREQ_BEGIN = 22;
    public static final int U_CAREQ_BOSE = 28;
    public static final int U_CAREQ_END = 31;
    public static final int U_CAREQ_FAD = 25;
    public static final int U_CAREQ_SPEEDVOL = 29;
    public static final int U_CAREQ_SURROUND = 30;
    public static final int U_CAREQ_TRB = 26;
    public static final int U_CAREQ_VOL = 23;
    public static final int U_CARSET_AUTOKEY_UNLOCK = 37;
    public static final int U_CARSET_BEGIN = 32;
    public static final int U_CARSET_END = 38;
    public static final int U_CARSET_LIGHT_OFFTIME = 35;
    public static final int U_CARSET_LIGHT_SENSOR = 34;
    public static final int U_CARSET_RAINVIPER_SPEED = 36;
    public static final int U_CARSET_UNLOCK_LIGHTON = 33;
    public static final int U_CNT_MAX = 38;
    public static final int U_DOOR_BACK = 20;
    public static final int U_DOOR_BEGIN = 15;
    public static final int U_DOOR_END = 21;
    public static final int U_DOOR_ENGINE = 15;
    public static final int U_DOOR_FL = 16;
    public static final int U_DOOR_FR = 17;
    public static final int U_DOOR_RL = 18;
    public static final int U_DOOR_RR = 19;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 38; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 15;
        DoorHelper.sUcDoorFl = 16;
        DoorHelper.sUcDoorFr = 17;
        DoorHelper.sUcDoorRl = 18;
        DoorHelper.sUcDoorRr = 19;
        DoorHelper.sUcDoorBack = 20;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 15; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 15; i < 21; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 38) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
