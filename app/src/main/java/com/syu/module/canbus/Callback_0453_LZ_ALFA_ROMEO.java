package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_ALFA_ROMEO;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_ALFA_ROMEO extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 15;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 19;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_RIGHT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_BLOW_UP_RIGHT = 16;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 27;
    public static final int U_AIR_FRONT_DEFROST = 10;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_SEAT_HEAT_LEFT = 24;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 25;
    public static final int U_AIR_STEER_HOT = 22;
    public static final int U_AIR_TEMPUNIT = 23;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 26;
    public static final int U_CARINF_D35_D10_B30 = 60;
    public static final int U_CARINF_D35_D10_B6 = 59;
    public static final int U_CARINF_D35_D10_B7 = 58;
    public static final int U_CARINF_D35_D11_B30 = 61;
    public static final int U_CARINF_D35_D2_D3 = 56;
    public static final int U_CARINF_D35_D7_D8_D9 = 57;
    public static final int U_CARINF_D37_D0_B70 = 33;
    public static final int U_CARINF_D38_D0_B10 = 39;
    public static final int U_CARINF_D38_D0_B32 = 38;
    public static final int U_CARINF_D38_D0_B4 = 37;
    public static final int U_CARINF_D38_D0_B5 = 36;
    public static final int U_CARINF_D38_D0_B6 = 35;
    public static final int U_CARINF_D38_D0_B7 = 34;
    public static final int U_CARINF_D38_D1_B70 = 40;
    public static final int U_CARINF_D38_D2_B10 = 47;
    public static final int U_CARINF_D38_D2_B2 = 46;
    public static final int U_CARINF_D38_D2_B3 = 45;
    public static final int U_CARINF_D38_D2_B4 = 44;
    public static final int U_CARINF_D38_D2_B5 = 43;
    public static final int U_CARINF_D38_D2_B6 = 42;
    public static final int U_CARINF_D38_D2_B7 = 41;
    public static final int U_CARINF_D38_D3_B20 = 50;
    public static final int U_CARINF_D38_D3_B43 = 49;
    public static final int U_CARINF_D38_D3_B75 = 48;
    public static final int U_CARINF_D38_D4_B2 = 54;
    public static final int U_CARINF_D38_D4_B3 = 53;
    public static final int U_CARINF_D38_D4_B54 = 52;
    public static final int U_CARINF_D38_D4_B76 = 51;
    public static final int U_CARINF_D38_D5_B70 = 55;
    public static final int U_CNT_MAX = 62;
    public static final int U_TIRE_PRESSURE_FL = 28;
    public static final int U_TIRE_PRESSURE_FR = 29;
    public static final int U_TIRE_PRESSURE_RL = 30;
    public static final int U_TIRE_PRESSURE_RR = 31;
    public static final int U_TIRE_PRESSURE_UNIT = 32;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 62; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0453_LZ_ALFA_ROMEO(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 27; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 27; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 62) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
