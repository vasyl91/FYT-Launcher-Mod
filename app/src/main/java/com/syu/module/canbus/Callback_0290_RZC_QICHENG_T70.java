package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0290_RZC_QICHENG_T70 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 25;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_MODE_LEFT = 21;
    public static final int U_AIR_BLOW_WIN_LEFT = 19;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 26;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 23;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_AVM_61_D00 = 59;
    public static final int U_AVM_61_D01 = 58;
    public static final int U_AVM_61_D02 = 57;
    public static final int U_AVM_61_D03 = 56;
    public static final int U_BELT_LEFT = 54;
    public static final int U_BELT_RIGHT = 55;
    public static final int U_CARINFO_MILEAGE = 52;
    public static final int U_CARINO_BEGIN = 50;
    public static final int U_CARINO_END = 53;
    public static final int U_CNT_MAX = 61;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_SPEED = 50;
    public static final int U_DOOR_BACK = 8;
    public static final int U_DOOR_BEGIN = 3;
    public static final int U_DOOR_END = 9;
    public static final int U_DOOR_ENGINE = 3;
    public static final int U_DOOR_FL = 4;
    public static final int U_DOOR_FR = 5;
    public static final int U_DOOR_RL = 6;
    public static final int U_DOOR_RR = 7;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_ENGINE_SPEED = 51;
    public static final int U_LIGHT_TRAVEL_MODE = 60;
    public static final int U_OPTIMAL_OIL_EXPEND = 2;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 61; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 3;
        DoorHelper.sUcDoorFl = 4;
        DoorHelper.sUcDoorFr = 5;
        DoorHelper.sUcDoorRl = 6;
        DoorHelper.sUcDoorRr = 7;
        DoorHelper.sUcDoorBack = 8;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 3; i2 < 9; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 3; i < 9; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
