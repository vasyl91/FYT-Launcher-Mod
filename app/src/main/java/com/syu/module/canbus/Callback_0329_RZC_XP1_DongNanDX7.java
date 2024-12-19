package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0329_DJ_Dongnan_X7;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0329_RZC_XP1_DongNanDX7 extends CallbackCanbusBase {
    public static final int C_ALL_SETTINGS = 0;
    public static final int U_AIR_AC = 16;
    public static final int U_AIR_AC_MAX = 35;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_BLOW_BODY_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 36;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 17;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CARINFO_D32_D2_B70 = 45;
    public static final int U_CARINFO_D33_D11_B70 = 47;
    public static final int U_CARINFO_D33_D12_B70 = 48;
    public static final int U_CARINFO_D33_D9_D10 = 46;
    public static final int U_CARINFO_D34_D0_B0 = 44;
    public static final int U_CARINFO_D34_D0_B1 = 43;
    public static final int U_CARINFO_D34_D0_B2 = 42;
    public static final int U_CARINFO_D34_D0_B3 = 41;
    public static final int U_CARINFO_D34_D0_B4 = 40;
    public static final int U_CARINFO_D34_D0_B5 = 39;
    public static final int U_CARINFO_D34_D0_B6 = 38;
    public static final int U_CARINFO_D34_D0_B7 = 37;
    public static final int U_CARINFO_D34_D1_B70 = 49;
    public static final int U_CARINFO_D34_D2_B70 = 50;
    public static final int U_CNT_MAX = 51;
    public static final int U_CUR_OIL_EXPEND = 5;
    public static final int U_DOOR_BACK = 26;
    public static final int U_DOOR_BEGIN = 21;
    public static final int U_DOOR_END = 27;
    public static final int U_DOOR_ENGINE = 21;
    public static final int U_DOOR_FL = 22;
    public static final int U_DOOR_FR = 23;
    public static final int U_DOOR_RL = 24;
    public static final int U_DOOR_RR = 25;
    public static final int U_DRIVE_BACK_SHOW = 31;
    public static final int U_DRIVE_BLiND_WARN = 30;
    public static final int U_DRIVE_TURN_CAMERA = 28;
    public static final int U_DRIVE_TURN_LIGHT = 29;
    public static final int U_DRIVING_MILEAGE = 6;
    public static final int U_LAST_OIL = 8;
    public static final int U_OPTIMAL_OIL_EXPEND = 7;
    public static final int U_PRESSURE_FL = 1;
    public static final int U_PRESSURE_FR = 2;
    public static final int U_PRESSURE_RL = 3;
    public static final int U_PRESSURE_RR = 4;
    public static final int U_RAIN_CLOSE_WINDOW = 34;
    public static final int U_RL_VIDEO_STATUS = 32;
    public static final int U_SPEED_INFO = 33;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 51; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 21;
        DoorHelper.sUcDoorFl = 22;
        DoorHelper.sUcDoorFr = 23;
        DoorHelper.sUcDoorRl = 24;
        DoorHelper.sUcDoorRr = 25;
        DoorHelper.sUcDoorBack = 26;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 21; i2 < 27; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0329_DJ_Dongnan_X7(LauncherApplication.getInstance()));
        for (int i3 = 9; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 21; i < 27; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 9; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 51) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
