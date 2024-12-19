package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0305_DJ_MengdiOu;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0305_DJ_MENGDIOU2013_BAOLIUAirPanel extends CallbackCanbusBase {
    public static final int U_AIR_AQS = 56;
    public static final int U_AIR_BLOW_BODY_RIGHT = 53;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 54;
    public static final int U_AIR_BLOW_UP_RIGHT = 52;
    public static final int U_AIR_BLOW_WIN_RIGHT = 51;
    public static final int U_AIR_MAX = 50;
    public static final int U_AIR_REAR_DEFROST = 49;
    public static final int U_AIR_SEAT_COLD_LEFT = 59;
    public static final int U_AIR_SEAT_COLD_RIGHT = 60;
    public static final int U_AIR_SEAT_HEAT_LEFT = 57;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 58;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 55;
    public static final int U_CARSET_END = 48;
    public static final int U_CNT_MAX = 61;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 61; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 29;
        DoorHelper.sUcDoorFr = 30;
        DoorHelper.sUcDoorRl = 31;
        DoorHelper.sUcDoorRr = 32;
        DoorHelper.sUcDoorBack = 33;
        DoorHelper.sUcDoorEngine = 34;
        AirHelper.getInstance().buildUi(new Air_0305_DJ_MengdiOu(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 29; i2 < 35; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 14; i3 < 29; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i4 = 49; i4 < 61; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 29; i < 35; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 14; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 49; i3 < 61; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1 || updateCode == 2 || updateCode == 7 || updateCode == 13 || updateCode == 12) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        } else if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
