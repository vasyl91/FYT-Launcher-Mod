package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_LandRover_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_LandRover_KeepCD extends CallbackCanbusBase {
    public static final int U_AIR_AC = 20;
    public static final int U_AIR_AC_MAX = 38;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 18;
    public static final int U_AIR_BLOW_AUTO_LEFT = 29;
    public static final int U_AIR_BLOW_AUTO_LEFT_REAR = 50;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 43;
    public static final int U_AIR_BLOW_AUTO_RIGHT_REAR = 53;
    public static final int U_AIR_BLOW_BODY_LEFT = 27;
    public static final int U_AIR_BLOW_BODY_LEFT_REAR = 48;
    public static final int U_AIR_BLOW_BODY_RIGHT = 41;
    public static final int U_AIR_BLOW_BODY_RIGHT_REAR = 51;
    public static final int U_AIR_BLOW_FOOT_LEFT = 28;
    public static final int U_AIR_BLOW_FOOT_LEFT_REAR = 49;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 42;
    public static final int U_AIR_BLOW_FOOT_RIGHT_REAR = 52;
    public static final int U_AIR_BLOW_UP_LEFT = 26;
    public static final int U_AIR_BLOW_UP_RIGHT = 40;
    public static final int U_AIR_BLOW_WIN_REAR = 54;
    public static final int U_AIR_CYCLE = 21;
    public static final int U_AIR_END = 59;
    public static final int U_AIR_FRONT_DEFROST = 24;
    public static final int U_AIR_FRONT_HOT = 39;
    public static final int U_AIR_POWER = 19;
    public static final int U_AIR_POWER_REAR = 57;
    public static final int U_AIR_REAR_DEFROST = 25;
    public static final int U_AIR_REAR_LOCK = 47;
    public static final int U_AIR_SEAT_HEAT_LEFT = 36;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 37;
    public static final int U_AIR_SEAT_LEFT_REAR = 45;
    public static final int U_AIR_SEAT_RIGHT_REAR = 46;
    public static final int U_AIR_STEER_HOT = 34;
    public static final int U_AIR_SYNC = 23;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_LEFT_REAR = 55;
    public static final int U_AIR_TEMP_RIGHT = 32;
    public static final int U_AIR_TEMP_RIGHT_REAR = 56;
    public static final int U_AIR_TEMP_UNIT = 35;
    public static final int U_AIR_WIND_AUTO_LEFT = 33;
    public static final int U_AIR_WIND_LEVEL_LEFT = 30;
    public static final int U_AIR_WIND_LEVEL_REAR = 58;
    public static final int U_CARINFO_D24_D1_B4 = 69;
    public static final int U_CARINFO_D24_D1_B5 = 70;
    public static final int U_CARINFO_D24_D1_B6 = 71;
    public static final int U_CARINF_D12_D1_B70 = 60;
    public static final int U_CAR_ANDROID_UI_VOL = 65;
    public static final int U_CAR_BELT_STATE = 11;
    public static final int U_CAR_CUR_SPEED = 14;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_FOOTBRAKE_STATE = 12;
    public static final int U_CAR_HANDBRAKE_STATE = 13;
    public static final int U_CAR_LIGHT_FAR = 8;
    public static final int U_CAR_LIGHT_LEFT = 9;
    public static final int U_CAR_LIGHT_NEAR = 7;
    public static final int U_CAR_LIGHT_RIGHT = 10;
    public static final int U_CAR_LVDS_MODE = 61;
    public static final int U_CAR_OIL_REMAINED = 15;
    public static final int U_CAR_PANNEL_TYPE = 68;
    public static final int U_CAR_SCREEN_H = 63;
    public static final int U_CAR_SCREEN_TYPE = 67;
    public static final int U_CAR_SCREEN_W = 62;
    public static final int U_CAR_SET_TYPE = 72;
    public static final int U_CAR_STEER_CTRL_TYPE = 73;
    public static final int U_CAR_TOTAL_MILE = 17;
    public static final int U_CAR_TOUCH_TYPE = 66;
    public static final int U_CAR_UI_VOL = 64;
    public static final int U_CNT_MAX = 74;
    public static int modevalue = -1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 74; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0453_LZ_LandRover_All(LauncherApplication.getInstance()));
        for (int i2 = 18; i2 < 59; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 59; i++) {
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
        if (updateCode >= 0 && updateCode < 74) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
