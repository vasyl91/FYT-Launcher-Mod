package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0354_XP_Sanlin;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0354_XP1_14SanlinSeries extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 6;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 13;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 9;
    public static final int U_CARSET_D40_D0_B32 = 22;
    public static final int U_CARSET_D40_D0_B75 = 21;
    public static final int U_CARSET_D40_D1_B01 = 27;
    public static final int U_CARSET_D40_D1_B04 = 25;
    public static final int U_CARSET_D40_D1_B05 = 24;
    public static final int U_CARSET_D40_D1_B32 = 26;
    public static final int U_CARSET_D40_D1_B76 = 23;
    public static final int U_CARSET_D40_D2_B07 = 28;
    public static final int U_CARSET_D40_D2_B31 = 30;
    public static final int U_CARSET_D40_D2_B64 = 29;
    public static final int U_CARSET_D40_D3_B20 = 33;
    public static final int U_CARSET_D40_D3_B54 = 32;
    public static final int U_CARSET_D40_D3_B76 = 31;
    public static final int U_CARSET_D40_D4_B02 = 38;
    public static final int U_CARSET_D40_D4_B05 = 36;
    public static final int U_CARSET_D40_D4_B06 = 35;
    public static final int U_CARSET_D40_D4_B07 = 34;
    public static final int U_CARSET_D40_D4_B10 = 39;
    public static final int U_CARSET_D40_D4_B43 = 37;
    public static final int U_CARSET_D40_D5_B01 = 44;
    public static final int U_CARSET_D40_D5_B06 = 41;
    public static final int U_CARSET_D40_D5_B07 = 40;
    public static final int U_CARSET_D40_D5_B32 = 43;
    public static final int U_CARSET_D40_D5_B54 = 42;
    public static final int U_CARSET_D40_D6_B54 = 46;
    public static final int U_CARSET_D40_D6_B76 = 45;
    public static final int U_CARSET_EQ_D17_D0_B70 = 47;
    public static final int U_CARSET_EQ_D17_D10_B70 = 57;
    public static final int U_CARSET_EQ_D17_D11_B70 = 58;
    public static final int U_CARSET_EQ_D17_D12_B70 = 59;
    public static final int U_CARSET_EQ_D17_D1_B70 = 48;
    public static final int U_CARSET_EQ_D17_D2_B70 = 49;
    public static final int U_CARSET_EQ_D17_D3_B70 = 50;
    public static final int U_CARSET_EQ_D17_D4_B70 = 51;
    public static final int U_CARSET_EQ_D17_D5_B70 = 52;
    public static final int U_CARSET_EQ_D17_D6_B70 = 53;
    public static final int U_CARSET_EQ_D17_D7_B70 = 54;
    public static final int U_CARSET_EQ_D17_D8_B70 = 55;
    public static final int U_CARSET_EQ_D17_D9_B70 = 56;
    public static final int U_CAR_TYPE = 20;
    public static final int U_CNT_MAX = 60;
    public static final int U_DOOR_BACK = 18;
    public static final int U_DOOR_BEGIN = 13;
    public static final int U_DOOR_END = 19;
    public static final int U_DOOR_ENGINE = 13;
    public static final int U_DOOR_FL = 14;
    public static final int U_DOOR_FR = 15;
    public static final int U_DOOR_RL = 16;
    public static final int U_DOOR_RR = 17;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 60; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 13;
        DoorHelper.sUcDoorFl = 14;
        DoorHelper.sUcDoorFr = 15;
        DoorHelper.sUcDoorRl = 16;
        DoorHelper.sUcDoorRr = 17;
        DoorHelper.sUcDoorBack = 18;
        AirHelper.getInstance().buildUi(new Air_0354_XP_Sanlin(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 13; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 13; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 13; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 13; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode >= 0 && updateCode < 60) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
