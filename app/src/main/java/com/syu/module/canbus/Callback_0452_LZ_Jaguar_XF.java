package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LUZ_Jaguar_XF;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Jaguar_XF extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 11;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_FRONT_HOT = 38;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 18;
    public static final int U_AIR_SEAT_BLOW_LEFT = 41;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 42;
    public static final int U_AIR_SEAT_HOT_LEFT = 39;
    public static final int U_AIR_SEAT_HOT_RIGHT = 40;
    public static final int U_AIR_STEER_HOT = 37;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_TEMP_UNIT = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_CARINFO_BEGIN = 22;
    public static final int U_CARINFO_D35_D1_B70 = 23;
    public static final int U_CARINFO_D35_D2_D3 = 24;
    public static final int U_CARINFO_D35_D4_D5 = 25;
    public static final int U_CARINFO_D35_D7_D8_D9_D10 = 26;
    public static final int U_CARINFO_D36_D0_B7 = 43;
    public static final int U_CARINFO_D36_D1_B70 = 44;
    public static final int U_CARINFO_D36_D1_D2_D3_D4 = 45;
    public static final int U_CARINFO_D36_D5_D6 = 46;
    public static final int U_CARINFO_D36_D7_D8 = 47;
    public static final int U_CARINFO_D36_D9 = 48;
    public static final int U_CARINFO_D38_D0_B70 = 27;
    public static final int U_CARINFO_D38_D10_B70 = 49;
    public static final int U_CARINFO_D38_D11_B70 = 50;
    public static final int U_CARINFO_D38_D12_B70 = 51;
    public static final int U_CARINFO_D38_D13_B70 = 52;
    public static final int U_CARINFO_D38_D14_B70 = 53;
    public static final int U_CARINFO_D38_D15_B70 = 54;
    public static final int U_CARINFO_D38_D16_B70 = 55;
    public static final int U_CARINFO_D38_D17_B70 = 56;
    public static final int U_CARINFO_D38_D18_B70 = 57;
    public static final int U_CARINFO_D38_D19_B70 = 58;
    public static final int U_CARINFO_D38_D1_B70 = 28;
    public static final int U_CARINFO_D38_D20_B70 = 59;
    public static final int U_CARINFO_D38_D2_B70 = 29;
    public static final int U_CARINFO_D38_D3_B70 = 30;
    public static final int U_CARINFO_D38_D4_B70 = 31;
    public static final int U_CARINFO_D38_D5_B70 = 32;
    public static final int U_CARINFO_D38_D6_B70 = 33;
    public static final int U_CARINFO_D38_D7_B70 = 34;
    public static final int U_CARINFO_D38_D8_B70 = 35;
    public static final int U_CARINFO_D38_D9_B70 = 36;
    public static final int U_CNT_MAX = 60;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 60; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LUZ_Jaguar_XF(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 21; i++) {
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
        if (updateCode >= 0 && updateCode < 60) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
