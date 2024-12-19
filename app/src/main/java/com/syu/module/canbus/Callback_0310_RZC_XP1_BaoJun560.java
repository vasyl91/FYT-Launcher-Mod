package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0310_RZC_BaojunRs3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0310_RZC_XP1_BaoJun560 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 29;
    public static final int U_AIR_ACMAX = 40;
    public static final int U_AIR_AUTO = 31;
    public static final int U_AIR_BEGIN = 28;
    public static final int U_AIR_BLOW_BODY_LEFT = 34;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_UP_LEFT = 36;
    public static final int U_AIR_CYCLE = 30;
    public static final int U_AIR_DUAL = 32;
    public static final int U_AIR_END = 41;
    public static final int U_AIR_ION = 41;
    public static final int U_AIR_REAR_DEFROST = 33;
    public static final int U_AIR_SEAT_HOT_LEFT = 42;
    public static final int U_AIR_TEMP_LEFT = 38;
    public static final int U_AIR_TEMP_RIGHT = 39;
    public static final int U_AIR_WIND_LEVEL_LEFT = 37;
    public static final int U_CARINFO_D52_D10 = 22;
    public static final int U_CARINFO_D52_D11 = 23;
    public static final int U_CARINFO_D52_D12 = 24;
    public static final int U_CARINFO_D52_D13 = 25;
    public static final int U_CARINFO_D52_D14 = 26;
    public static final int U_CARINFO_D52_D15 = 27;
    public static final int U_CARINFO_D52_D16 = 29;
    public static final int U_CARINFO_D52_D17 = 30;
    public static final int U_CARINFO_D52_D18 = 31;
    public static final int U_CARINFO_D52_D19 = 32;
    public static final int U_CARINFO_D52_D1A = 33;
    public static final int U_CARINFO_D52_D1B = 34;
    public static final int U_CARINFO_D52_D1C = 35;
    public static final int U_CARINFO_D52_D1D = 36;
    public static final int U_CARINFO_D52_D1E = 37;
    public static final int U_CARINFO_D52_D1F = 38;
    public static final int U_CARINFO_D52_D20 = 39;
    public static final int U_CARINFO_D52_D21 = 40;
    public static final int U_CARINFO_D52_D22 = 42;
    public static final int U_CARINFO_D52_D3 = 9;
    public static final int U_CARINFO_D52_D4 = 10;
    public static final int U_CARINFO_D52_D5 = 11;
    public static final int U_CARINFO_D52_D6 = 12;
    public static final int U_CARINFO_D52_D7 = 13;
    public static final int U_CARINFO_D52_D8 = 14;
    public static final int U_CARINFO_D52_D9 = 15;
    public static final int U_CARINFO_D52_DA = 16;
    public static final int U_CARINFO_D52_DB = 17;
    public static final int U_CARINFO_D52_DC = 18;
    public static final int U_CARINFO_D52_DD = 19;
    public static final int U_CARINFO_D52_DE = 20;
    public static final int U_CARINFO_D52_DF = 21;
    public static final int U_CARINFO_REARVIEW_AUTO = 7;
    public static final int U_CARINFO_TIRE_CAL = 8;
    public static final int U_CNT_MAX = 43;
    public static final int U_DOOR_END = 6;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
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
        for (int i3 = 28; i3 < 41; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0310_RZC_BaojunRs3(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 28; i2 < 41; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
