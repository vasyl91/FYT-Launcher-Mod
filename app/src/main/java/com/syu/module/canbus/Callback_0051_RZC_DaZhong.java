package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0002_XP1_DaZhong;
import com.syu.ui.air.Air_0051_RZC_Audi_Q5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0051_RZC_DaZhong extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AC_MAX = 32;
    public static final int U_AIR_AQS = 29;
    public static final int U_AIR_AUTO = 35;
    public static final int U_AIR_AUTO3_RIGHT = 49;
    public static final int U_AIR_AUTO4_RIGHT = 50;
    public static final int U_AIR_BEGIN = 14;
    public static final int U_AIR_BIG_WIND_LIGHT = 15;
    public static final int U_AIR_BLOW_BODY = 23;
    public static final int U_AIR_BLOW_BODY_RIGHT = 47;
    public static final int U_AIR_BLOW_FOOT = 25;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 48;
    public static final int U_AIR_BLOW_MODE = 45;
    public static final int U_AIR_BLOW_UP = 22;
    public static final int U_AIR_BLOW_UP_RIGHT = 46;
    public static final int U_AIR_CYCLE = 19;
    public static final int U_AIR_DUAL = 20;
    public static final int U_AIR_END = 36;
    public static final int U_AIR_FRONT = 44;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 16;
    public static final int U_AIR_MAX = 18;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR = 21;
    public static final int U_AIR_REAR_LOCK = 31;
    public static final int U_AIR_SEAT_HEAT_LEFT = 30;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 33;
    public static final int U_AIR_SHOW = 24;
    public static final int U_AIR_TEMP_LEFT = 27;
    public static final int U_AIR_TEMP_OUT = 34;
    public static final int U_AIR_TEMP_RIGHT = 28;
    public static final int U_AIR_WIND_LEVEL = 26;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 51;
    public static final int U_BATTERY_VOLTAGE = 7;
    public static final int U_CARINF_D41_D11_D1_B20 = 56;
    public static final int U_CARINF_D41_D11_D1_B3 = 55;
    public static final int U_CARINF_D41_D11_D1_B4 = 54;
    public static final int U_CARINF_D41_D11_D1_B5 = 53;
    public static final int U_CARINF_D41_D11_D1_B76 = 52;
    public static final int U_CARSET_BACKCAR_TYPE = 58;
    public static final int U_CARSET_D25_D0_B32 = 60;
    public static final int U_CARSET_D27_D0_B70 = 61;
    public static final int U_CARSET_D27_D1_B70 = 62;
    public static final int U_CARSET_D27_D2_B70 = 63;
    public static final int U_CARSET_D27_D3_B70 = 64;
    public static final int U_CARSET_D27_D4_B70 = 65;
    public static final int U_CARSET_D27_D5_B70 = 66;
    public static final int U_CARSET_D27_D6_B70 = 67;
    public static final int U_CARSET_D27_D7_B70 = 68;
    public static final int U_CARSET_D41_D40_D1_B30 = 69;
    public static final int U_CARSET_D41_D40_D1_B74 = 70;
    public static final int U_CARSET_D41_D40_D2_B30 = 71;
    public static final int U_CARSET_D41_D40_D2_B74 = 72;
    public static final int U_CARSET_D41_D40_D3_B30 = 73;
    public static final int U_CARSET_D41_D80_D1_B70 = 74;
    public static final int U_CARSET_D41_D80_D2_B70 = 75;
    public static final int U_CARSET_D41_D80_D3_B70 = 76;
    public static final int U_CARSET_D41_D80_D4_B70 = 77;
    public static final int U_CARSET_RADAR_VOL = 57;
    public static final int U_CARSET_SCREEN_TYPE = 59;
    public static final int U_CLEAN_FLUIT_WARN = 4;
    public static final int U_CNT_MAX = 78;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_SPEED = 11;
    public static final int U_DOOR_BACK = 42;
    public static final int U_DOOR_BEGIN = 37;
    public static final int U_DOOR_END = 43;
    public static final int U_DOOR_ENGINE = 37;
    public static final int U_DOOR_FL = 38;
    public static final int U_DOOR_FR = 39;
    public static final int U_DOOR_RL = 40;
    public static final int U_DOOR_RR = 41;
    public static final int U_DRIVE_MILE = 8;
    public static final int U_ENGINE_SPEED = 12;
    public static final int U_HANDLE_BRAKE_WARN = 5;
    public static final int U_LIFE_BELT_WARN = 3;
    public static final int U_LOW_BATTERY_WARN = 2;
    public static final int U_LOW_OIL_WARN = 1;
    public static final int U_OUT_TEMP = 13;
    public static final int U_PARK = 9;
    public static final int U_RADAR_MUTE = 10;
    public static final int U_RESIDUAL_OIL = 6;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 78; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 37;
        DoorHelper.sUcDoorFl = 38;
        DoorHelper.sUcDoorFr = 39;
        DoorHelper.sUcDoorRl = 40;
        DoorHelper.sUcDoorRr = 41;
        DoorHelper.sUcDoorBack = 42;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 37; i2 < 43; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 2949171) {
            for (int i3 = 14; i3 < 36; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
            for (int i4 = 46; i4 <= 51; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
            DataCanbus.NOTIFY_EVENTS[34].removeNotify(AirHelper.SHOW_AND_REFRESH);
            AirHelper.getInstance().buildUi(new Air_0051_RZC_Audi_Q5(LauncherApplication.getInstance()));
            return;
        }
        for (int i5 = 14; i5 < 36; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[34].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().buildUi(new Air_0002_XP1_DaZhong(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 37; i < 43; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 46; i2 <= 51; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 14; i3 < 36; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 78) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
