package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_OUDI_CHANGAN extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_SET_CTRL = 1;
    public static final int U_AIR_AC = 77;
    public static final int U_AIR_ACMAX = 97;
    public static final int U_AIR_AQS = 95;
    public static final int U_AIR_AUTO = 80;
    public static final int U_AIR_AUTO2 = 79;
    public static final int U_AIR_BEGIN = 76;
    public static final int U_AIR_BLOW_BODY_LEFT = 84;
    public static final int U_AIR_BLOW_FOOT_LEFT = 85;
    public static final int U_AIR_BLOW_UP_LEFT = 86;
    public static final int U_AIR_CYCLE = 78;
    public static final int U_AIR_DUAL = 81;
    public static final int U_AIR_ECO = 96;
    public static final int U_AIR_END = 98;
    public static final int U_AIR_FRONT_DEFROST = 82;
    public static final int U_AIR_FRONT_DEFROST2 = 93;
    public static final int U_AIR_POWER = 76;
    public static final int U_AIR_REAR_DEFROST = 83;
    public static final int U_AIR_REAR_DEFROST2 = 94;
    public static final int U_AIR_SHOW = 87;
    public static final int U_AIR_TEMP_LEFT = 90;
    public static final int U_AIR_TEMP_RIGHT = 92;
    public static final int U_AIR_TEMP_UNIT_LEFT = 89;
    public static final int U_AIR_TEMP_UNIT_RIGHT = 91;
    public static final int U_AIR_WIND_LEVEL_LEFT = 88;
    public static final int U_CNT_MAX = 99;
    public static final int U_DOOR_BACK = 74;
    public static final int U_DOOR_BEGIN = 69;
    public static final int U_DOOR_END = 75;
    public static final int U_DOOR_ENGINE = 69;
    public static final int U_DOOR_FL = 70;
    public static final int U_DOOR_FR = 71;
    public static final int U_DOOR_RL = 72;
    public static final int U_DOOR_RR = 73;
    public static final int U_LIGHT_LEVL = 65;
    public static final int U_LIGHT_ONOFF = 66;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 68;
    public static final int U_PRESSURE_FL = 5;
    public static final int U_PRESSURE_FL_AIRLINK_FAST = 31;
    public static final int U_PRESSURE_FL_AIRLINK_SLOW = 30;
    public static final int U_PRESSURE_FL_CHECKSELF = 23;
    public static final int U_PRESSURE_FL_ELIGHT = 24;
    public static final int U_PRESSURE_FL_ENABLE = 9;
    public static final int U_PRESSURE_FL_HIGH = 11;
    public static final int U_PRESSURE_FL_HIGHTEMP = 26;
    public static final int U_PRESSURE_FL_HIGHTEMP_S = 27;
    public static final int U_PRESSURE_FL_HIGH_AIR = 29;
    public static final int U_PRESSURE_FL_LOSE = 22;
    public static final int U_PRESSURE_FL_LOW = 10;
    public static final int U_PRESSURE_FL_LOW_AIR = 28;
    public static final int U_PRESSURE_FL_SYSTERM = 21;
    public static final int U_PRESSURE_FL_TEMP = 1;
    public static final int U_PRESSURE_FL_VLOW = 25;
    public static final int U_PRESSURE_FR = 6;
    public static final int U_PRESSURE_FR_AIRLINK_FAST = 42;
    public static final int U_PRESSURE_FR_AIRLINK_SLOW = 41;
    public static final int U_PRESSURE_FR_CHECKSELF = 34;
    public static final int U_PRESSURE_FR_ELIGHT = 35;
    public static final int U_PRESSURE_FR_ENABLE = 12;
    public static final int U_PRESSURE_FR_HIGH = 14;
    public static final int U_PRESSURE_FR_HIGHTEMP = 37;
    public static final int U_PRESSURE_FR_HIGHTEMP_S = 38;
    public static final int U_PRESSURE_FR_HIGH_AIR = 40;
    public static final int U_PRESSURE_FR_LOSE = 33;
    public static final int U_PRESSURE_FR_LOW = 13;
    public static final int U_PRESSURE_FR_LOW_AIR = 39;
    public static final int U_PRESSURE_FR_SYSTERM = 32;
    public static final int U_PRESSURE_FR_TEMP = 2;
    public static final int U_PRESSURE_FR_VLOW = 36;
    public static final int U_PRESSURE_RL = 7;
    public static final int U_PRESSURE_RL_AIRLINK_FAST = 53;
    public static final int U_PRESSURE_RL_AIRLINK_SLOW = 52;
    public static final int U_PRESSURE_RL_CHECKSELF = 45;
    public static final int U_PRESSURE_RL_ELIGHT = 46;
    public static final int U_PRESSURE_RL_ENABLE = 15;
    public static final int U_PRESSURE_RL_HIGH = 17;
    public static final int U_PRESSURE_RL_HIGHTEMP = 48;
    public static final int U_PRESSURE_RL_HIGHTEMP_S = 49;
    public static final int U_PRESSURE_RL_HIGH_AIR = 51;
    public static final int U_PRESSURE_RL_LOSE = 44;
    public static final int U_PRESSURE_RL_LOW = 16;
    public static final int U_PRESSURE_RL_LOW_AIR = 50;
    public static final int U_PRESSURE_RL_SYSTERM = 43;
    public static final int U_PRESSURE_RL_TEMP = 3;
    public static final int U_PRESSURE_RL_VLOW = 47;
    public static final int U_PRESSURE_RR = 8;
    public static final int U_PRESSURE_RR_AIRLINK_FAST = 64;
    public static final int U_PRESSURE_RR_AIRLINK_SLOW = 63;
    public static final int U_PRESSURE_RR_CHECKSELF = 56;
    public static final int U_PRESSURE_RR_ELIGHT = 57;
    public static final int U_PRESSURE_RR_ENABLE = 18;
    public static final int U_PRESSURE_RR_HIGH = 20;
    public static final int U_PRESSURE_RR_HIGHTEMP = 59;
    public static final int U_PRESSURE_RR_HIGHTEMP_S = 60;
    public static final int U_PRESSURE_RR_HIGH_AIR = 62;
    public static final int U_PRESSURE_RR_LOSE = 55;
    public static final int U_PRESSURE_RR_LOW = 19;
    public static final int U_PRESSURE_RR_LOW_AIR = 61;
    public static final int U_PRESSURE_RR_SYSTERM = 54;
    public static final int U_PRESSURE_RR_TEMP = 4;
    public static final int U_PRESSURE_RR_VLOW = 58;
    public static final int U_SEAT_PLEASE = 67;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 99; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 69;
        DoorHelper.sUcDoorFl = 70;
        DoorHelper.sUcDoorFr = 71;
        DoorHelper.sUcDoorRl = 72;
        DoorHelper.sUcDoorRr = 73;
        DoorHelper.sUcDoorBack = 74;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 69; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_OUDI_Changan(LauncherApplication.getInstance()));
        for (int i3 = 76; i3 < 98; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 76; i < 98; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 69; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 99) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
