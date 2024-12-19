package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0175_XP1_MZD_CX5 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 12;
    public static final int U_AIR_END = 13;
    public static final int U_AUTO_AC_ENABLED = 8;
    public static final int U_CAR_INFO_END = 12;
    public static final int U_CNT_MAX = 19;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_CUR_TRIP_OIL_EXPEND = 5;
    public static final int U_DOOR_BACK = 18;
    public static final int U_DOOR_BEGIN = 13;
    public static final int U_DOOR_END = 19;
    public static final int U_DOOR_ENGINE = 13;
    public static final int U_DOOR_FL = 14;
    public static final int U_DOOR_FR = 15;
    public static final int U_DOOR_RL = 16;
    public static final int U_DOOR_RR = 17;
    public static final int U_DRIVING_MILEAGE = 2;
    public static final int U_DRIVING_TIME = 4;
    public static final int U_FEEDBACK_LAMP_ENABLED = 7;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 11;
    public static final int U_OPTIMAL_OIL_EXPEND = 3;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 10;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 6;
    public static final int U_VALID_VENTILATION_ENABLED = 9;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 19; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 13;
        DoorHelper.sUcDoorFl = 14;
        DoorHelper.sUcDoorFr = 15;
        DoorHelper.sUcDoorRl = 16;
        DoorHelper.sUcDoorRr = 17;
        DoorHelper.sUcDoorBack = 18;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 13; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 13; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 19) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
