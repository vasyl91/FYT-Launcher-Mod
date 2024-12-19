package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LZ_LandRover extends CallbackCanbusBase {
    public static final int CMD_CARSET_CTRL = 0;
    public static final int U_AIR_SUSPENSION_MODE = 23;
    public static final int U_AVG_SPEED = 12;
    public static final int U_CARINFO_D0A_D0_D1 = 29;
    public static final int U_CARINFO_D38_D5_B70 = 28;
    public static final int U_CAR_SET = 13;
    public static final int U_CNT_MAX = 30;
    public static final int U_DISTANCE_UNIT = 18;
    public static final int U_DRIVE_MODE = 22;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_FUEL_CONS1 = 10;
    public static final int U_FUEL_CONS2 = 11;
    public static final int U_HDC_ONOFF = 19;
    public static final int U_INSTRUMENT_DISPLAY = 21;
    public static final int U_OIL_CONS_UNIT = 17;
    public static final int U_SPEED_WARNING = 14;
    public static final int U_SPEED_WARNING_ONOFF = 15;
    public static final int U_STALLS_INFO = 20;
    public static final int U_TEMP_UNIT = 16;
    public static final int U_TIRE1_DISTANCE = 24;
    public static final int U_TIRE2_DISTANCE = 25;
    public static final int U_TIRE3_DISTANCE = 26;
    public static final int U_TIRE4_DISTANCE = 27;
    public static final int U_TOTAL_MILEAGE = 9;
    public static final int U_TRAVELABLE_MILEAGE = 7;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 30; i++) {
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
        if (updateCode >= 0 && updateCode < 30) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
