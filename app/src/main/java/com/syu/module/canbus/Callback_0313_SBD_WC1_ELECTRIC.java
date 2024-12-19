package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0313_SBD_WC1_24vW3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0313_SBD_WC1_ELECTRIC extends CallbackCanbusBase {
    public static final int C_CMD_AIR_CONTROL = 0;
    public static final int C_CMR_SOC_CALI = 1;
    public static final int U_2TIMES_KEY_UNLOCK = 31;
    public static final int U_AIR_AC = 112;
    public static final int U_AIR_AUTO = 110;
    public static final int U_AIR_BEGIN = 109;
    public static final int U_AIR_BLOW_BODY_RIGHT = 114;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 115;
    public static final int U_AIR_BLOW_UP_RIGHT = 116;
    public static final int U_AIR_BY_AUTO_KEY = 36;
    public static final int U_AIR_CYCLE = 111;
    public static final int U_AIR_END = 120;
    public static final int U_AIR_FRONT_DEFROST = 119;
    public static final int U_AIR_POWER = 118;
    public static final int U_AIR_TEMP_LEFT = 113;
    public static final int U_AIR_WIND_LEVEL_LEFT = 117;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 27;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 28;
    public static final int U_AUTOLOCK_BY_SPEED = 26;
    public static final int U_AUTO_AC_ENABLED = 10;
    public static final int U_BATTERY_CHARGE_STATUS = 108;
    public static final int U_BATTERY_LOW_TEMPERATURE_ALARM = 105;
    public static final int U_BATTERY_PACK_HIGH_TEMPERATURE_ALARM = 92;
    public static final int U_BATTERY_VOLTAGE1 = 41;
    public static final int U_BATTERY_VOLTAGE10 = 50;
    public static final int U_BATTERY_VOLTAGE11 = 51;
    public static final int U_BATTERY_VOLTAGE12 = 52;
    public static final int U_BATTERY_VOLTAGE13 = 53;
    public static final int U_BATTERY_VOLTAGE14 = 54;
    public static final int U_BATTERY_VOLTAGE15 = 55;
    public static final int U_BATTERY_VOLTAGE16 = 56;
    public static final int U_BATTERY_VOLTAGE17 = 57;
    public static final int U_BATTERY_VOLTAGE18 = 58;
    public static final int U_BATTERY_VOLTAGE19 = 59;
    public static final int U_BATTERY_VOLTAGE2 = 42;
    public static final int U_BATTERY_VOLTAGE20 = 60;
    public static final int U_BATTERY_VOLTAGE21 = 61;
    public static final int U_BATTERY_VOLTAGE22 = 62;
    public static final int U_BATTERY_VOLTAGE23 = 63;
    public static final int U_BATTERY_VOLTAGE24 = 64;
    public static final int U_BATTERY_VOLTAGE25 = 65;
    public static final int U_BATTERY_VOLTAGE26 = 66;
    public static final int U_BATTERY_VOLTAGE27 = 67;
    public static final int U_BATTERY_VOLTAGE28 = 68;
    public static final int U_BATTERY_VOLTAGE29 = 69;
    public static final int U_BATTERY_VOLTAGE3 = 43;
    public static final int U_BATTERY_VOLTAGE30 = 70;
    public static final int U_BATTERY_VOLTAGE31 = 71;
    public static final int U_BATTERY_VOLTAGE32 = 72;
    public static final int U_BATTERY_VOLTAGE33 = 73;
    public static final int U_BATTERY_VOLTAGE34 = 74;
    public static final int U_BATTERY_VOLTAGE35 = 75;
    public static final int U_BATTERY_VOLTAGE36 = 76;
    public static final int U_BATTERY_VOLTAGE37 = 77;
    public static final int U_BATTERY_VOLTAGE38 = 78;
    public static final int U_BATTERY_VOLTAGE39 = 79;
    public static final int U_BATTERY_VOLTAGE4 = 44;
    public static final int U_BATTERY_VOLTAGE40 = 80;
    public static final int U_BATTERY_VOLTAGE5 = 45;
    public static final int U_BATTERY_VOLTAGE6 = 46;
    public static final int U_BATTERY_VOLTAGE7 = 47;
    public static final int U_BATTERY_VOLTAGE8 = 48;
    public static final int U_BATTERY_VOLTAGE9 = 49;
    public static final int U_BATTERY_VOLTAGE_HIGH = 81;
    public static final int U_BATTERY_VOLTAGE_HISIGN = 83;
    public static final int U_BATTERY_VOLTAGE_LOSIGN = 84;
    public static final int U_BATTERY_VOLTAGE_LOW = 82;
    public static final int U_CLOSE_BIGLAMP_TIME = 16;
    public static final int U_CLOSE_INSIDELAMP_TIME = 15;
    public static final int U_CNT_MAX = 126;
    public static final int U_CUR_OIL_EXPE = 39;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_TRIP_OIL_EXPEND = 4;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 14;
    public static final int U_DOOR_BACK = 125;
    public static final int U_DOOR_BEGIN = 120;
    public static final int U_DOOR_END = 126;
    public static final int U_DOOR_ENGINE = 120;
    public static final int U_DOOR_FL = 121;
    public static final int U_DOOR_FR = 122;
    public static final int U_DOOR_RL = 123;
    public static final int U_DOOR_RR = 124;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_DRIVING_TIME = 3;
    public static final int U_EMPERATURE_DIFFERENCE_TOO_LARGE = 88;
    public static final int U_ENERGY_STORAGE_DEVICE_OVEROLTAGE_ALARM = 93;
    public static final int U_ENERGY_STORAGE_DEVIC_UNDERVOLTAGE_ALARM = 94;
    public static final int U_EXIST_TPMS = 22;
    public static final int U_FEEDBACK_LAMP_ENABLED = 9;
    public static final int U_HIGH_VOLTAGE_INTERLOCKING_STATE = 103;
    public static final int U_INSULATION_ALARM = 102;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 37;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 30;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 35;
    public static final int U_NEGATIVE_END_TO_GROUND_INSULATION_RESISTANCE = 107;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 13;
    public static final int U_OPTIMAL_OIL_EXPEND = 2;
    public static final int U_PACK_WARM = 6;
    public static final int U_POOR_BATTERY_UNIFORMITY_ALARM = 101;
    public static final int U_POSITIVE_TO_GROUND_INSULATION_RESISTANCE = 106;
    public static final int U_PRESSURE_BACKUP = 21;
    public static final int U_PRESSURE_FL = 17;
    public static final int U_PRESSURE_FR = 18;
    public static final int U_PRESSURE_RL = 19;
    public static final int U_PRESSURE_RR = 20;
    public static final int U_RADAR_VOL = 40;
    public static final int U_RECHARGEABLE_ENERGY_STORAGE_NOT_MATCH_ALARM = 104;
    public static final int U_RECHARGEABLE_ENERGY_STORAGE_NOT_MATCH_ALARM_LEVEL = 100;
    public static final int U_REMOTE_2PRESS_UNLOCK = 29;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 12;
    public static final int U_SHOW_RADAR = 38;
    public static final int U_SHOW_TIRE_BACKUP = 23;
    public static final int U_SINGLE_BATTERY_OVEROLTAGE_ALARM = 96;
    public static final int U_SINGLE_BATTERY_UNDERVOLTAGE_ALARM = 97;
    public static final int U_SINGLE_VOLTAGE_DIFFERENCE = 85;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 34;
    public static final int U_SOC_JUMP_ALARM = 99;
    public static final int U_SOC_LOW_ALARM = 95;
    public static final int U_SOC_TOO_HIGH = 87;
    public static final int U_SOC_TOO_HIGH_ALARM = 98;
    public static final int U_SOC_TRANSTITION = 86;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 5;
    public static final int U_TEMPERATURE_DIFFERENCE_ALARM = 91;
    public static final int U_THE_VOLTAGE_TOO_LOW = 89;
    public static final int U_TIRE_SHOW_STATE = 24;
    public static final int U_TOTAL_VOLAGE_TOO_HIGH = 90;
    public static final int U_TPMS_STATE = 25;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 32;
    public static final int U_UNLOCK_BY_SMART_DOOR = 33;
    public static final int U_VALID_VENTILATION_ENABLED = 11;
    public static final int U_WARNNING_LOW_BATTERY = 8;
    public static final int U_WARNNING_LOW_OIL = 7;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 120;
        DoorHelper.sUcDoorFl = 121;
        DoorHelper.sUcDoorFr = 122;
        DoorHelper.sUcDoorRl = 123;
        DoorHelper.sUcDoorRr = 124;
        DoorHelper.sUcDoorBack = 125;
        if (DataCanbus.DATA[1000] == 65849) {
            AirHelper.getInstance().buildUi(new Air_0313_SBD_WC1_24vW3(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 120; i2 < 126; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 109; i3 < 120; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 109; i < 120; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
