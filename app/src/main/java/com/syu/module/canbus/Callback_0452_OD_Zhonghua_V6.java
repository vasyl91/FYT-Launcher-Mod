package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_ZhongHuaV6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_Zhonghua_V6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_ACMAX = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_MODE = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARINFO_D4_D0_B70 = 21;
    public static final int U_CARINFO_D4_D1_B0 = 22;
    public static final int U_CARINFO_D4_D1_B1 = 23;
    public static final int U_CARINFO_D4_D1_B2 = 24;
    public static final int U_CARINFO_D4_D3_B70 = 25;
    public static final int U_CARINFO_D4_D4_B70 = 26;
    public static final int U_CARINFO_D4_D5_B4 = 30;
    public static final int U_CARINFO_D4_D5_B5 = 29;
    public static final int U_CARINFO_D4_D5_B6 = 28;
    public static final int U_CARINFO_D4_D5_B7 = 27;
    public static final int U_CNT_MAX = 31;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 31; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OD_ZhongHuaV6(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 20; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 20; i++) {
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
        if (updateCode >= 0 && updateCode < 31) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
