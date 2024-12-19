package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0290_RZC_QiChenT90;
import com.syu.ui.air.Air_0290_RZC_Qichen_21_T90;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0290_RZC_QICHENG_T90 extends CallbackCanbusBase {
    public static final int AIR_CONTROL_CMD = 1;
    public static final int U_AIR_AC = 14;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO = 20;
    public static final int U_AIR_BLOW_BODY_LEFT = 23;
    public static final int U_AIR_BLOW_FOOT_LEFT = 22;
    public static final int U_AIR_BLOW_MODE_LEFT = 30;
    public static final int U_AIR_BLOW_WIN_LEFT = 24;
    public static final int U_AIR_CYCLE = 15;
    public static final int U_AIR_DUAL = 29;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_MAX = 11;
    public static final int U_AIR_REAL = 28;
    public static final int U_AIR_REAR_DEFROST = 16;
    public static final int U_AIR_SEAT_HEAT_LEFT = 18;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 19;
    public static final int U_AIR_SYNC = 13;
    public static final int U_AIR_TEMP_LEFT = 27;
    public static final int U_AIR_TEMP_RIGHT = 31;
    public static final int U_AIR_WIND_LEVEL_LEFT = 26;
    public static final int U_CNT_MAX = 33;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_POWER_ON = 10;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 33; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        if (DataCanbus.DATA[1000] == 721186) {
            AirHelper.getInstance().buildUi(new Air_0290_RZC_Qichen_21_T90(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0290_RZC_QiChenT90(LauncherApplication.getInstance()));
        }
        for (int i2 = 10; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 33) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
