package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_DJ_Dodge_JCUV;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_DJ_Dodge_JCUV extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_AUTO = 20;
    public static final int U_AIR_AUTO_REAR = 24;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_REAR = 22;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_REAR = 23;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 28;
    public static final int U_AIR_POWER_REAR = 21;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_REAR_ENABLE = 27;
    public static final int U_AIR_SEAT_HOT_LEFT = 18;
    public static final int U_AIR_SEAT_HOT_RIGHT = 19;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_REAR = 25;
    public static final int U_AIR_TEMP_RIGHT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 8;
    public static final int U_AIR_WIND_LEVEL_REAR = 26;
    public static final int U_CAREQ_BAL = 44;
    public static final int U_CAREQ_BASS = 46;
    public static final int U_CAREQ_FAD = 45;
    public static final int U_CAREQ_MID = 47;
    public static final int U_CAREQ_SPEED_VOL = 49;
    public static final int U_CAREQ_TREB = 48;
    public static final int U_CAREQ_VOL = 42;
    public static final int U_CAREQ_VOL_PERCENTATE = 43;
    public static final int U_CARINFO_BEGIN = 29;
    public static final int U_CARINFO_D36_D0_B0 = 34;
    public static final int U_CARINFO_D36_D0_B1 = 33;
    public static final int U_CARINFO_D36_D0_B32 = 32;
    public static final int U_CARINFO_D36_D0_B54 = 31;
    public static final int U_CARINFO_D36_D0_B76 = 30;
    public static final int U_CARINFO_D36_D1_B21 = 40;
    public static final int U_CARINFO_D36_D1_B3 = 39;
    public static final int U_CARINFO_D36_D1_B4 = 38;
    public static final int U_CARINFO_D36_D1_B5 = 37;
    public static final int U_CARINFO_D36_D1_B6 = 36;
    public static final int U_CARINFO_D36_D1_B7 = 35;
    public static final int U_CARINFO_LANGUAGE = 51;
    public static final int U_CARINFO_UNIT = 50;
    public static final int U_CARSET_END = 41;
    public static final int U_CNT_MAX = 52;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_DJ_Dodge_JCUV(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 28; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 28; i++) {
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
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
