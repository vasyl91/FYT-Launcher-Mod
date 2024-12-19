package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XC_Feiyate_Feiyue;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XC_Feiyate_Feiyue extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 16;
    public static final int U_AIR_CYCLE = 11;
    public static final int U_AIR_END = 30;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_AUTO = 24;
    public static final int U_AIR_REAR_BLOW_BODY = 27;
    public static final int U_AIR_REAR_BLOW_FOOT = 28;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_REAR_LOCK = 25;
    public static final int U_AIR_REAR_POWER = 23;
    public static final int U_AIR_REAR_TEMP = 29;
    public static final int U_AIR_REAR_WIN_LEV = 26;
    public static final int U_AIR_SEAR_HOT_LEFT = 21;
    public static final int U_AIR_SEAR_HOT_RIGHT = 22;
    public static final int U_AIR_SEAT_BLOW_LEFT = 52;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 53;
    public static final int U_AIR_STEER_HOT = 54;
    public static final int U_AIR_SYNC = 14;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL = 15;
    public static final int U_CAREQ_BAL = 44;
    public static final int U_CAREQ_BASS = 46;
    public static final int U_CAREQ_FAD = 45;
    public static final int U_CAREQ_MID = 47;
    public static final int U_CAREQ_SPEED_VOL = 49;
    public static final int U_CAREQ_TREB = 48;
    public static final int U_CAREQ_VOL = 43;
    public static final int U_CARINFO_LANGUAGE = 51;
    public static final int U_CARINFO_UNIT = 50;
    public static final int U_CARSET_BEGIN = 31;
    public static final int U_CARSET_D07_D0B76 = 32;
    public static final int U_CARSET_D07_D1B00 = 33;
    public static final int U_CARSET_D07_D2B01 = 37;
    public static final int U_CARSET_D07_D2B03 = 36;
    public static final int U_CARSET_D07_D2B54 = 35;
    public static final int U_CARSET_D07_D2B76 = 34;
    public static final int U_CARSET_D07_D3B02 = 40;
    public static final int U_CARSET_D07_D3B03 = 39;
    public static final int U_CARSET_D07_D3B06 = 38;
    public static final int U_CARSET_D07_D4B65 = 41;
    public static final int U_CARSET_END = 42;
    public static final int U_CNT_MAX = 55;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 55; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_XC_Feiyate_Feiyue(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 30; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 30; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 55) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
