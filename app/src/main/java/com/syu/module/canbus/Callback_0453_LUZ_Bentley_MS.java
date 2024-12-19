package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_LZ_Bentley_MS;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LUZ_Bentley_MS extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_ACMAX = 22;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_AUTO_RIGHT = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 18;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 31;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_BODY_RIGHT = 30;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 29;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_BLOW_UP_RIGHT = 28;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 33;
    public static final int U_AIR_FRONT_MAX = 13;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SEAT_AUTO_LEFT = 23;
    public static final int U_AIR_SEAT_AUTO_RIGHT = 24;
    public static final int U_AIR_SEAT_HEAT_LEFT = 26;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 27;
    public static final int U_AIR_SYNC = 12;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_TEMP_UNIT = 25;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 32;
    public static final int U_CARINF_D35_D1_B70 = 34;
    public static final int U_CARINF_D35_D2_D3 = 35;
    public static final int U_CARINF_D35_D7_D8_D9_D10 = 36;
    public static final int U_CNT_MAX = 37;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 37; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0454_LZ_Bentley_MS(LauncherApplication.getInstance()));
        for (int i2 = 7; i2 < 33; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 33; i++) {
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
        if (updateCode >= 0 && updateCode < 37) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
