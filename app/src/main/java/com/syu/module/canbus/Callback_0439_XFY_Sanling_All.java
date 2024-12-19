package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XFY_Sanling_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 19;
    public static final int U_AIR_AUTO = 20;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_MODE = 14;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_CYCLE = 17;
    public static final int U_AIR_DUAL = 18;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_MAXFRONT = 15;
    public static final int U_AIR_POWER = 21;
    public static final int U_AIR_REAR_DEFROST = 16;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CAREQ_BAL = 37;
    public static final int U_CAREQ_BASS = 39;
    public static final int U_CAREQ_DOLBY_VOLUME = 48;
    public static final int U_CAREQ_FAD = 36;
    public static final int U_CAREQ_MID = 41;
    public static final int U_CAREQ_POSITION = 45;
    public static final int U_CAREQ_POWERON = 49;
    public static final int U_CAREQ_PREMIDIA_HD = 46;
    public static final int U_CAREQ_PUNCH = 42;
    public static final int U_CAREQ_SCV = 47;
    public static final int U_CAREQ_SURROUND = 44;
    public static final int U_CAREQ_TRE = 40;
    public static final int U_CAREQ_TYPE = 38;
    public static final int U_CAREQ_VOL = 43;
    public static final int U_CNT_MAX = 50;
    public static final int U_PRESSURE_END = 35;
    public static final int U_PRESSURE_FL = 23;
    public static final int U_PRESSURE_FL_TEMP = 24;
    public static final int U_PRESSURE_FL_VOLTAGE = 25;
    public static final int U_PRESSURE_FR = 26;
    public static final int U_PRESSURE_FR_TEMP = 27;
    public static final int U_PRESSURE_FR_VOLTAGE = 28;
    public static final int U_PRESSURE_RL = 29;
    public static final int U_PRESSURE_RL_TEMP = 30;
    public static final int U_PRESSURE_RL_VOLTAGE = 31;
    public static final int U_PRESSURE_RR = 32;
    public static final int U_PRESSURE_RR_TEMP = 33;
    public static final int U_PRESSURE_RR_VOLTAGE = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 50; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 50) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
