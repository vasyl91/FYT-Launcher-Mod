package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Siwei;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_SiWei extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 17;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 11;
    public static final int U_AIR_BLOW_FOOT = 12;
    public static final int U_AIR_BLOW_MODE = 13;
    public static final int U_AIR_BLOW_UP = 10;
    public static final int U_AIR_CYCLE = 16;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FRONT_DEFROST = 19;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR_DEFROST = 18;
    public static final int U_AIR_SEAT_BLOW_LEFT = 21;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 24;
    public static final int U_AIR_SEAT_HOT_LEFT = 20;
    public static final int U_AIR_SEAT_HOT_RIGHT = 23;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL = 22;
    public static final int U_CARINFO_BEGIN = 26;
    public static final int U_CARINFO_D41_DATA0_B02 = 30;
    public static final int U_CARINFO_D41_DATA0_B03 = 29;
    public static final int U_CARINFO_D41_DATA0_B04 = 28;
    public static final int U_CARINFO_D41_DATA0_B10 = 31;
    public static final int U_CARINFO_D41_DATA0_B75 = 27;
    public static final int U_CARINFO_D41_DATA1_B00 = 37;
    public static final int U_CARINFO_D41_DATA1_B01 = 36;
    public static final int U_CARINFO_D41_DATA1_B02 = 35;
    public static final int U_CARINFO_D41_DATA1_B07 = 32;
    public static final int U_CARINFO_D41_DATA1_B43 = 34;
    public static final int U_CARINFO_D41_DATA1_B65 = 33;
    public static final int U_CARINFO_D41_DATA2_B00 = 44;
    public static final int U_CARINFO_D41_DATA2_B01 = 43;
    public static final int U_CARINFO_D41_DATA2_B03 = 42;
    public static final int U_CARINFO_D41_DATA2_B04 = 41;
    public static final int U_CARINFO_D41_DATA2_B05 = 40;
    public static final int U_CARINFO_D41_DATA2_B06 = 39;
    public static final int U_CARINFO_D41_DATA2_B07 = 38;
    public static final int U_CNT_MAX = 45;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 45; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_RZC_Siwei(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 25; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
