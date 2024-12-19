package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_DJ_Rongwei_I5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_DJ_Rongwe_iI5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 14;
    public static final int U_AIR_BLOW_FOOT = 15;
    public static final int U_AIR_BLOW_MODE = 16;
    public static final int U_AIR_BLOW_UP = 13;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_POWER = 12;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_SEAT_HOT_LEFT = 19;
    public static final int U_AIR_SEAT_HOT_RIGHT = 20;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND_LEVEL = 8;
    public static final int U_CARINFO_B00_DATA0 = 28;
    public static final int U_CARINFO_B00_DATA1 = 29;
    public static final int U_CARINFO_B01_DATA0 = 27;
    public static final int U_CARINFO_B02_DATA0 = 26;
    public static final int U_CARINFO_B03_DATA0 = 25;
    public static final int U_CARINFO_B04_DATA0 = 24;
    public static final int U_CARINFO_B75_DATA0 = 23;
    public static final int U_CARINFO_BEGIN = 22;
    public static final int U_CARINFO_GUIJI_MODE = 31;
    public static final int U_CARINFO_RIGHT_ALLVIEW = 30;
    public static final int U_CNT_MAX = 32;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 32; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0439_DJ_Rongwei_I5(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 32) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
