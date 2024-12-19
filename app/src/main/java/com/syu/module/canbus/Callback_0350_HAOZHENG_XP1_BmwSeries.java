package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0350_HAOZHENG_XP1_BmwSeries extends CallbackCanbusBase {
    public static final int U_AUTO_AC_ENABLED = 8;
    public static final int U_CARINFO_BEGIN = 0;
    public static final int U_CARINFO_END = 16;
    public static final int U_CLOSE_BIGLAMP_TIME = 14;
    public static final int U_CLOSE_INSIDELAMP_TIME = 13;
    public static final int U_CNT_MAX = 23;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_CUR_TRIP_OIL_EXPEND = 5;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 12;
    public static final int U_DOOR_BACK = 22;
    public static final int U_DOOR_BEGIN = 17;
    public static final int U_DOOR_END = 23;
    public static final int U_DOOR_ENGINE = 17;
    public static final int U_DOOR_FL = 18;
    public static final int U_DOOR_FR = 19;
    public static final int U_DOOR_RL = 20;
    public static final int U_DOOR_RR = 21;
    public static final int U_DRIVING_MILEAGE = 2;
    public static final int U_DRIVING_TIME = 4;
    public static final int U_FEEDBACK_LAMP_ENABLED = 7;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 11;
    public static final int U_OPTIMAL_OIL_EXPEND = 3;
    public static final int U_PRESSURE_FL = 15;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 10;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 6;
    public static final int U_VALID_VENTILATION_ENABLED = 9;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 23; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 17;
        DoorHelper.sUcDoorFl = 18;
        DoorHelper.sUcDoorFr = 19;
        DoorHelper.sUcDoorRl = 20;
        DoorHelper.sUcDoorRr = 21;
        DoorHelper.sUcDoorBack = 22;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 17; i2 < 23; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 17; i < 23; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 23) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
