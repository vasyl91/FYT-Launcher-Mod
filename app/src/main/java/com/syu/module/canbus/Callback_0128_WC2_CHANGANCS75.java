package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0128_WC2_ChangAn17Cs75;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0128_WC2_CHANGANCS75 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 5;
    public static final int U_AIR_BLOW_FOOT_LEFT = 6;
    public static final int U_AIR_BLOW_UP_LEFT = 7;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 13;
    public static final int U_AIR_FRONT_DEFROST = 19;
    public static final int U_AIR_MAXAC = 12;
    public static final int U_AIR_MODE = 1;
    public static final int U_AIR_POWER = 9;
    public static final int U_AIR_REAR = 56;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_SYNC = 11;
    public static final int U_AIR_TEMP_LEFT = 4;
    public static final int U_AIR_WIND_LEVEL_LEFT = 8;
    public static final int U_CARINFO_BEGIN = 19;
    public static final int U_CARINFO_END = 55;
    public static final int U_CARSET_D78_D3_B43 = 59;
    public static final int U_CARSET_D78_D3_B65 = 58;
    public static final int U_CARSET_D78_D3_B7 = 57;
    public static final int U_CARSET_D78_D4_B32 = 63;
    public static final int U_CARSET_D78_D4_B54 = 62;
    public static final int U_CARSET_D78_D4_B6 = 61;
    public static final int U_CARSET_D78_D4_B7 = 60;
    public static final int U_CARSET_D87_D5_B10 = 66;
    public static final int U_CARSET_D87_D5_B5 = 65;
    public static final int U_CAR_1KEY_TURN = 27;
    public static final int U_CAR_AIR_SELFDRYING = 32;
    public static final int U_CAR_AMBIENT_LIGHTCOLOR = 41;
    public static final int U_CAR_AMBIENT_LIGHTLEV = 42;
    public static final int U_CAR_BACKCAR_REAR_SWIPER = 26;
    public static final int U_CAR_BTCALL_AIRSLOW = 44;
    public static final int U_CAR_DAY_LIGHTL = 43;
    public static final int U_CAR_DELAY_WINDOW = 35;
    public static final int U_CAR_DIANKABA_VOL = 34;
    public static final int U_CAR_DRIVING_AUTO_LOCK = 30;
    public static final int U_CAR_FRONTLIGHT_DELAY = 28;
    public static final int U_CAR_KEY_LONGTOUCH_AIR = 37;
    public static final int U_CAR_REAR_MIRROR_AUTOFOLD = 25;
    public static final int U_CAR_REMOTE_UNLOCK = 31;
    public static final int U_CAR_REMOTE_WINDOW = 36;
    public static final int U_CAR_SKYLIGHT_RAIN = 40;
    public static final int U_CAR_SKYLIGHT_REMOTE = 39;
    public static final int U_CAR_SKYLIGHT_VOICE = 38;
    public static final int U_CAR_TURNOFF_AUTO_UNLOCK = 29;
    public static final int U_CAR_UNLOCK_ACTIVE_VENTILATION = 24;
    public static final int U_CAR_UNLOCK_WINDOWAIR = 33;
    public static final int U_CNT_MAX = 75;
    public static final int U_CUR_SPEED = 22;
    public static final int U_DOOR_BACK = 18;
    public static final int U_DOOR_BEGIN = 13;
    public static final int U_DOOR_END = 19;
    public static final int U_DOOR_ENGINE = 13;
    public static final int U_DOOR_FL = 14;
    public static final int U_DOOR_FR = 15;
    public static final int U_DOOR_RL = 16;
    public static final int U_DOOR_RR = 17;
    public static final int U_ENGINE_SPEED = 23;
    public static final int U_TIRE_BEGIN = 45;
    public static final int U_TIRE_D48_D12_B70 = 71;
    public static final int U_TIRE_D48_D13_B70 = 72;
    public static final int U_TIRE_D48_D14_B70 = 73;
    public static final int U_TIRE_D48_D15_B70 = 74;
    public static final int U_TIRE_D48_D1_B4 = 70;
    public static final int U_TIRE_D48_D1_B5 = 69;
    public static final int U_TIRE_D48_D1_B6 = 68;
    public static final int U_TIRE_D48_D1_B7 = 67;
    public static final int U_TIRE_PRESSURE_FL = 47;
    public static final int U_TIRE_PRESSURE_FR = 48;
    public static final int U_TIRE_PRESSURE_RL = 49;
    public static final int U_TIRE_PRESSURE_RR = 50;
    public static final int U_TIRE_TEMP_FL = 51;
    public static final int U_TIRE_TEMP_FR = 52;
    public static final int U_TIRE_TEMP_RL = 53;
    public static final int U_TIRE_TEMP_RR = 54;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 64;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 75; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 13;
        DoorHelper.sUcDoorFl = 14;
        DoorHelper.sUcDoorFr = 15;
        DoorHelper.sUcDoorRl = 16;
        DoorHelper.sUcDoorRr = 17;
        DoorHelper.sUcDoorBack = 18;
        AirHelper.getInstance().buildUi(new Air_0128_WC2_ChangAn17Cs75(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 13; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 13; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[19].addNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[20].addNotify(AirHelper.SHOW_AND_REFRESH);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 13; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 13; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[19].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[20].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 75) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
