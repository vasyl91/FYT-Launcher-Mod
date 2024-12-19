package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_TATA_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_MHD_SCORPIO extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_AUTO = 9;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_MODE_LEFT = 15;
    public static final int U_AIR_BLOW_WIN_LEFT = 16;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_ECON = 10;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CARINF_D13_D0_D1 = 24;
    public static final int U_CARINF_D13_D2_D3 = 25;
    public static final int U_CARINF_D13_D4_D5 = 26;
    public static final int U_CARINF_D13_D6_D7 = 27;
    public static final int U_CARINF_D13_D8_B70 = 28;
    public static final int U_CARSET_D61_D0_B0 = 23;
    public static final int U_CARSET_D61_D0_B1 = 22;
    public static final int U_CNT_MAX = 46;
    public static final int U_PRESSURE_BACK = 35;
    public static final int U_PRESSURE_BACK_TEMP = 40;
    public static final int U_PRESSURE_BACK_WARN = 45;
    public static final int U_PRESSURE_ENABLE = 29;
    public static final int U_PRESSURE_FL = 31;
    public static final int U_PRESSURE_FL_TEMP = 36;
    public static final int U_PRESSURE_FL_WARN = 41;
    public static final int U_PRESSURE_FR = 32;
    public static final int U_PRESSURE_FR_TEMP = 37;
    public static final int U_PRESSURE_FR_WARN = 42;
    public static final int U_PRESSURE_RL = 33;
    public static final int U_PRESSURE_RL_TEMP = 38;
    public static final int U_PRESSURE_RL_WARN = 43;
    public static final int U_PRESSURE_RR = 34;
    public static final int U_PRESSURE_RR_TEMP = 39;
    public static final int U_PRESSURE_RR_WARN = 44;
    public static final int U_PRESSURE_WARN = 30;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 46; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_TATA_All(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 46) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
