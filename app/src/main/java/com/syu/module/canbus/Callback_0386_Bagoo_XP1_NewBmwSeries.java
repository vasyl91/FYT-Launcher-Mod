package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0386_Bagoo_XP1_NewBmwSeries extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 16;
    public static final int U_CARINFO_RADAR_ONOFF = 19;
    public static final int U_CARINFO_SEAT_HOT_LEFT = 17;
    public static final int U_CARINFO_SEAT_HOT_RIGHT = 18;
    public static final int U_CNT_MAX = 20;
    public static final int U_DOOR_BACK = 14;
    public static final int U_DOOR_BEGIN = 9;
    public static final int U_DOOR_END = 15;
    public static final int U_DOOR_ENGINE = 9;
    public static final int U_DOOR_FL = 10;
    public static final int U_DOOR_FR = 11;
    public static final int U_DOOR_RL = 12;
    public static final int U_DOOR_RR = 13;
    public static final int U_SETTING_03D23 = 1;
    public static final int U_SETTING_03D45 = 2;
    public static final int U_SETTING_03D67 = 3;
    public static final int U_SETTING_04D0 = 4;
    public static final int U_SETTING_04D1 = 5;
    public static final int U_SETTING_04D2 = 6;
    public static final int U_SETTING_04D3 = 7;
    public static final int U_SETTING_04D4 = 8;
    public static final int U_SETTING_BEGIN = 0;
    public static final int U_SETTING_END = 9;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 20; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 9;
        DoorHelper.sUcDoorFl = 10;
        DoorHelper.sUcDoorFr = 11;
        DoorHelper.sUcDoorRl = 12;
        DoorHelper.sUcDoorRr = 13;
        DoorHelper.sUcDoorBack = 14;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 9; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 9; i < 15; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 20) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
