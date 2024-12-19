package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0307_XBS_15ZhongHuaV3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0307_XBS_XP1_15ZhongHuaV3 extends CallbackCanbusBase {
    public static final int C_CMD_CARINFO = 0;
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_ACMAX = 68;
    public static final int U_AIR_AUTO = 69;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 7;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 70;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMP_LEFT = 5;
    public static final int U_AIR_TEMP_RIGHT = 6;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 52;
    public static final int U_CARINFO_AUTO_DOOR_RELOCK = 53;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 51;
    public static final int U_CARINFO_BACKCAR_MUTE_INHIBITION = 59;
    public static final int U_CARINFO_BACK_CAMERA = 58;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_D4_D03_B54 = 62;
    public static final int U_CARINFO_D4_D03_B6 = 61;
    public static final int U_CARINFO_D4_D03_B7 = 60;
    public static final int U_CARINFO_D4_D04_B32 = 71;
    public static final int U_CARINFO_D4_D04_B64 = 66;
    public static final int U_CARINFO_D4_D04_B7 = 63;
    public static final int U_CARINFO_D4_D05_B70 = 64;
    public static final int U_CARINFO_D4_D06_B70 = 65;
    public static final int U_CARINFO_END = 67;
    public static final int U_CARINFO_LOCK_FLASH = 55;
    public static final int U_CARINFO_ONE_DOOR_UNLOCK = 54;
    public static final int U_CARINFO_REAR_MIRROR_AUTO_FOLD = 57;
    public static final int U_CARINFO_UNLOCK_FLASH = 56;
    public static final int U_CNT_MAX = 72;
    public static final int U_DOOR_BACK = 17;
    public static final int U_DOOR_BEGIN = 12;
    public static final int U_DOOR_END = 18;
    public static final int U_DOOR_ENGINE = 12;
    public static final int U_DOOR_FL = 13;
    public static final int U_DOOR_FR = 14;
    public static final int U_DOOR_RL = 15;
    public static final int U_DOOR_RR = 16;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 72; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 12;
        DoorHelper.sUcDoorFl = 13;
        DoorHelper.sUcDoorFr = 14;
        DoorHelper.sUcDoorRl = 15;
        DoorHelper.sUcDoorRr = 16;
        DoorHelper.sUcDoorBack = 17;
        AirHelper.getInstance().buildUi(new Air_0307_XBS_15ZhongHuaV3(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 12; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 11; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 131379 || DataCanbus.DATA[1000] == 196915) {
            DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 12; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 72) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
