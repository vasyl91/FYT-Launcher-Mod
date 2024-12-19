package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OD_Foton_Tunland;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_Foton_Tunland extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 11;
    public static final int U_AIR_BLOW_FOOT_LEFT = 12;
    public static final int U_AIR_BLOW_MODE_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_CARSET_BEGIN = 17;
    public static final int U_CARSET_D40_D0_B70 = 18;
    public static final int U_CARSET_D40_D1_B70 = 19;
    public static final int U_CARSET_D40_D2_B70 = 20;
    public static final int U_CARSET_D40_D3_B70 = 21;
    public static final int U_CARSET_END = 22;
    public static final int U_CNT_MAX = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 22; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_OD_Foton_Tunland(LauncherApplication.getInstance()));
        for (int i3 = 6; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 6; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 22) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
