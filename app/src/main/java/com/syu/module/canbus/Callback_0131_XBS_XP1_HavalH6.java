package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0131_FYT_XBS_HavaH6;
import com.syu.ui.air.Air_0131_XBS_HavaH2;
import com.syu.ui.air.Air_0132_XBS_Hava17H2;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0131_XBS_XP1_HavalH6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 3;
    public static final int U_AIR_BLOW_BODY_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_MODE = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_BLOW_WIN_LEFT = 16;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR_DEFROST = 7;
    public static final int U_AIR_SYNC = 20;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 13;
    public static final int U_AUTO_AC_ENABLED = 2;
    public static final int U_CNT_MAX = 34;
    public static final int U_CUR_SPEED = 28;
    public static final int U_DOOR_BACK = 26;
    public static final int U_DOOR_BEGIN = 21;
    public static final int U_DOOR_END = 27;
    public static final int U_DOOR_ENGINE = 21;
    public static final int U_DOOR_FL = 22;
    public static final int U_DOOR_FR = 23;
    public static final int U_DOOR_RL = 24;
    public static final int U_DOOR_RR = 25;
    public static final int U_ENGINE_SPEED = 29;
    public static final int U_FEEDBACK_LAMP_ENABLED = 1;
    public static final int U_INFO_END = 30;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 0;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 33;
    public static int carid = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        carid = (DataCanbus.DATA[1000] >> 16) & 65535;
        DoorHelper.sUcDoorEngine = 21;
        DoorHelper.sUcDoorFl = 22;
        DoorHelper.sUcDoorFr = 23;
        DoorHelper.sUcDoorRl = 24;
        DoorHelper.sUcDoorRr = 25;
        DoorHelper.sUcDoorBack = 26;
        if (carid == 4) {
            AirHelper.getInstance().buildUi(new Air_0131_XBS_HavaH2(LauncherApplication.getInstance()));
        } else if (carid == 5) {
            AirHelper.getInstance().buildUi(new Air_0132_XBS_Hava17H2(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0131_FYT_XBS_HavaH6(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 21; i2 < 27; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 3; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 21; i < 27; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 3; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
