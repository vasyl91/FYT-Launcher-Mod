package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Qirui_Xiaomayi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_MAX_FRONT = 12;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_PTC = 11;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARSET_D41_D0_B0 = 32;
    public static final int U_CARSET_D41_D0_B1 = 31;
    public static final int U_CARSET_D41_D0_B2 = 30;
    public static final int U_CARSET_D41_D0_B3 = 25;
    public static final int U_CARSET_D41_D0_B4 = 24;
    public static final int U_CARSET_D41_D0_B5 = 23;
    public static final int U_CARSET_D41_D0_B6 = 22;
    public static final int U_CARSET_D41_D0_B7 = 21;
    public static final int U_CARSET_D41_D1_B70 = 26;
    public static final int U_CARSET_D41_D2_B70 = 27;
    public static final int U_CARSET_D44_D0_D1 = 28;
    public static final int U_CARSET_D44_D2_B70 = 29;
    public static final int U_CNT_MAX = 33;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 33; i++) {
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
        if (updateCode >= 0 && updateCode < 33) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
