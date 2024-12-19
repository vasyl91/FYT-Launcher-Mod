package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Bnr_RongweiRx5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_BNR_Rongwei_RX5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_ACMAX = 20;
    public static final int U_AIR_AQS = 18;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODYFOOT_LEFT = 9;
    public static final int U_AIR_BLOW_BODY_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_UPFOOT_LEFT = 12;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_ECO = 19;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 16;
    public static final int U_AIR_MAX_FRONT = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR = 7;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_TEMPUNIT = 21;
    public static final int U_AIR_TEMP_FLAG = 13;
    public static final int U_AIR_TEMP_LEFT = 14;
    public static final int U_AIR_TEMP_RIGHT = 15;
    public static final int U_AIR_WIND_LEVEL_LEFT = 8;
    public static final int U_CARINFO_ECO_DRIVE = 33;
    public static final int U_CARINFO_FIND_LIGHT = 30;
    public static final int U_CARINFO_HOME_LIGHT = 29;
    public static final int U_CARINFO_NEAR_UNLOCK = 32;
    public static final int U_CARINFO_REMOTE_UNLOCK = 31;
    public static final int U_CARINFO_TIRE_RESET = 34;
    public static final int U_CARINFO_TISHI_VOL = 35;
    public static final int U_CNT_MAX = 37;
    public static final int U_DOOR_BACK = 27;
    public static final int U_DOOR_BEGIN = 22;
    public static final int U_DOOR_END = 28;
    public static final int U_DOOR_ENGINE = 22;
    public static final int U_DOOR_FL = 23;
    public static final int U_DOOR_FR = 24;
    public static final int U_DOOR_RL = 25;
    public static final int U_DOOR_RR = 26;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 36;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 37; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 22;
        DoorHelper.sUcDoorFl = 23;
        DoorHelper.sUcDoorFr = 24;
        DoorHelper.sUcDoorRl = 25;
        DoorHelper.sUcDoorRr = 26;
        DoorHelper.sUcDoorBack = 27;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 22; i2 < 28; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_Bnr_RongweiRx5(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 22; i < 28; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 37) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
