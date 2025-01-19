package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0128_WC2_ChangAn17Cs75;
import com.syu.ui.door.DoorHelper;

public class Callback_0128_WC2_CHANGANCS75 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARSET_D78_D3_B43 = 134;
    public static final int U_CARSET_D78_D3_B65 = 133;
    public static final int U_CARSET_D78_D3_B7 = 132;
    public static final int U_CARSET_D78_D4_B32 = 138;
    public static final int U_CARSET_D78_D4_B54 = 137;
    public static final int U_CARSET_D78_D4_B6 = 136;
    public static final int U_CARSET_D78_D4_B7 = 135;
    public static final int U_CARSET_D87_D5_B10 = 141;
    public static final int U_CARSET_D87_D5_B5 = 140;
    public static final int U_CAR_1KEY_TURN = 104;
    public static final int U_CAR_AIR_SELFDRYING = 109;
    public static final int U_CAR_AMBIENT_LIGHTCOLOR = 118;
    public static final int U_CAR_AMBIENT_LIGHTLEV = 119;
    public static final int U_CAR_BACKCAR_REAR_SWIPER = 103;
    public static final int U_CAR_BTCALL_AIRSLOW = 121;
    public static final int U_CAR_DAY_LIGHTL = 120;
    public static final int U_CAR_DELAY_WINDOW = 112;
    public static final int U_CAR_DIANKABA_VOL = 111;
    public static final int U_CAR_DRIVING_AUTO_LOCK = 107;
    public static final int U_CAR_FRONTLIGHT_DELAY = 105;
    public static final int U_CAR_KEY_LONGTOUCH_AIR = 114;
    public static final int U_CAR_REAR_MIRROR_AUTOFOLD = 102;
    public static final int U_CAR_REMOTE_UNLOCK = 108;
    public static final int U_CAR_REMOTE_WINDOW = 113;
    public static final int U_CAR_SKYLIGHT_RAIN = 117;
    public static final int U_CAR_SKYLIGHT_REMOTE = 116;
    public static final int U_CAR_SKYLIGHT_VOICE = 115;
    public static final int U_CAR_TURNOFF_AUTO_UNLOCK = 106;
    public static final int U_CAR_UNLOCK_ACTIVE_VENTILATION = 101;
    public static final int U_CAR_UNLOCK_WINDOWAIR = 110;
    public static final int U_CNT_MAX = 150;
    public static final int U_CUR_SPEED = 99;
    public static final int U_ENGINE_SPEED = 100;
    public static final int U_TIRE_BEGIN = 122;
    public static final int U_TIRE_D48_D12_B70 = 146;
    public static final int U_TIRE_D48_D13_B70 = 147;
    public static final int U_TIRE_D48_D14_B70 = 148;
    public static final int U_TIRE_D48_D15_B70 = 149;
    public static final int U_TIRE_D48_D1_B4 = 145;
    public static final int U_TIRE_D48_D1_B5 = 144;
    public static final int U_TIRE_D48_D1_B6 = 143;
    public static final int U_TIRE_D48_D1_B7 = 142;
    public static final int U_TIRE_PRESSURE_FL = 124;
    public static final int U_TIRE_PRESSURE_FR = 125;
    public static final int U_TIRE_PRESSURE_RL = 126;
    public static final int U_TIRE_PRESSURE_RR = 127;
    public static final int U_TIRE_TEMP_FL = 128;
    public static final int U_TIRE_TEMP_FR = 129;
    public static final int U_TIRE_TEMP_RL = 130;
    public static final int U_TIRE_TEMP_RR = 131;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 139;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 150; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0128_WC2_ChangAn17Cs75(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 150) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
