package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_Weichai_U70;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Weichai_U70 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND_LEVEL_LEFT = 16;
    public static final int U_CARINFO_BEGIN = 20;
    public static final int U_CARINFO_D40_D0_B6 = 22;
    public static final int U_CARINFO_D40_D0_B7 = 21;
    public static final int U_CARINFO_D40_D1_B70 = 23;
    public static final int U_CARINFO_D40_D2_B70 = 24;
    public static final int U_CARINFO_D40_D3_B70 = 25;
    public static final int U_CARINFO_D40_D4_D5 = 26;
    public static final int U_CARINFO_D40_D6_D7 = 27;
    public static final int U_CARINFO_D40_D8_D9_D10 = 28;
    public static final int U_CNT_MAX = 29;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 29; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_Weichai_U70(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 19; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 29) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}