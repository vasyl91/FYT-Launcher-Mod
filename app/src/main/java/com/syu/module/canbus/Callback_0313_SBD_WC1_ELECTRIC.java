package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0313_SBD_WC1_ELECTRIC extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 128;
    public static final int U_AIR_BY_AUTO_KEY = 133;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 124;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 125;
    public static final int U_AUTOLOCK_BY_SPEED = 123;
    public static final int U_AUTO_AC_ENABLED = 107;
    public static final int U_BATTERY_CHARGE_STATUS = 205;
    public static final int U_BATTERY_LOW_TEMPERATURE_ALARM = 202;
    public static final int U_BATTERY_PACK_HIGH_TEMPERATURE_ALARM = 189;
    public static final int U_BATTERY_VOLTAGE1 = 138;
    public static final int U_BATTERY_VOLTAGE10 = 147;
    public static final int U_BATTERY_VOLTAGE11 = 148;
    public static final int U_BATTERY_VOLTAGE12 = 149;
    public static final int U_BATTERY_VOLTAGE13 = 150;
    public static final int U_BATTERY_VOLTAGE14 = 151;
    public static final int U_BATTERY_VOLTAGE15 = 152;
    public static final int U_BATTERY_VOLTAGE16 = 153;
    public static final int U_BATTERY_VOLTAGE17 = 154;
    public static final int U_BATTERY_VOLTAGE18 = 155;
    public static final int U_BATTERY_VOLTAGE19 = 156;
    public static final int U_BATTERY_VOLTAGE2 = 139;
    public static final int U_BATTERY_VOLTAGE20 = 157;
    public static final int U_BATTERY_VOLTAGE21 = 158;
    public static final int U_BATTERY_VOLTAGE22 = 159;
    public static final int U_BATTERY_VOLTAGE23 = 160;
    public static final int U_BATTERY_VOLTAGE24 = 161;
    public static final int U_BATTERY_VOLTAGE25 = 162;
    public static final int U_BATTERY_VOLTAGE26 = 163;
    public static final int U_BATTERY_VOLTAGE27 = 164;
    public static final int U_BATTERY_VOLTAGE28 = 165;
    public static final int U_BATTERY_VOLTAGE29 = 166;
    public static final int U_BATTERY_VOLTAGE3 = 140;
    public static final int U_BATTERY_VOLTAGE30 = 167;
    public static final int U_BATTERY_VOLTAGE31 = 168;
    public static final int U_BATTERY_VOLTAGE32 = 169;
    public static final int U_BATTERY_VOLTAGE33 = 170;
    public static final int U_BATTERY_VOLTAGE34 = 171;
    public static final int U_BATTERY_VOLTAGE35 = 172;
    public static final int U_BATTERY_VOLTAGE36 = 173;
    public static final int U_BATTERY_VOLTAGE37 = 174;
    public static final int U_BATTERY_VOLTAGE38 = 175;
    public static final int U_BATTERY_VOLTAGE39 = 176;
    public static final int U_BATTERY_VOLTAGE4 = 141;
    public static final int U_BATTERY_VOLTAGE40 = 177;
    public static final int U_BATTERY_VOLTAGE5 = 142;
    public static final int U_BATTERY_VOLTAGE6 = 143;
    public static final int U_BATTERY_VOLTAGE7 = 144;
    public static final int U_BATTERY_VOLTAGE8 = 145;
    public static final int U_BATTERY_VOLTAGE9 = 146;
    public static final int U_BATTERY_VOLTAGE_HIGH = 178;
    public static final int U_BATTERY_VOLTAGE_HISIGN = 180;
    public static final int U_BATTERY_VOLTAGE_LOSIGN = 181;
    public static final int U_BATTERY_VOLTAGE_LOW = 179;
    public static final int U_CLOSE_BIGLAMP_TIME = 113;
    public static final int U_CLOSE_INSIDELAMP_TIME = 112;
    public static final int U_CNT_MAX = 206;
    public static final int U_CUR_OIL_EXPE = 136;
    public static final int U_CUR_OIL_EXPEND = 97;
    public static final int U_CUR_TRIP_OIL_EXPEND = 101;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 111;
    public static final int U_DRIVING_MILEAGE = 98;
    public static final int U_DRIVING_TIME = 100;
    public static final int U_EMPERATURE_DIFFERENCE_TOO_LARGE = 185;
    public static final int U_ENERGY_STORAGE_DEVICE_OVEROLTAGE_ALARM = 190;
    public static final int U_ENERGY_STORAGE_DEVIC_UNDERVOLTAGE_ALARM = 191;
    public static final int U_EXIST_TPMS = 119;
    public static final int U_FEEDBACK_LAMP_ENABLED = 106;
    public static final int U_HIGH_VOLTAGE_INTERLOCKING_STATE = 200;
    public static final int U_INSULATION_ALARM = 199;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 134;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 127;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 132;
    public static final int U_NEGATIVE_END_TO_GROUND_INSULATION_RESISTANCE = 204;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 110;
    public static final int U_OPTIMAL_OIL_EXPEND = 99;
    public static final int U_PACK_WARM = 103;
    public static final int U_POOR_BATTERY_UNIFORMITY_ALARM = 198;
    public static final int U_POSITIVE_TO_GROUND_INSULATION_RESISTANCE = 203;
    public static final int U_PRESSURE_BACKUP = 118;
    public static final int U_PRESSURE_FL = 114;
    public static final int U_PRESSURE_FR = 115;
    public static final int U_PRESSURE_RL = 116;
    public static final int U_PRESSURE_RR = 117;
    public static final int U_RADAR_VOL = 137;
    public static final int U_RECHARGEABLE_ENERGY_STORAGE_NOT_MATCH_ALARM = 201;
    public static final int U_RECHARGEABLE_ENERGY_STORAGE_NOT_MATCH_ALARM_LEVEL = 197;
    public static final int U_REMOTE_2PRESS_UNLOCK = 126;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 109;
    public static final int U_SHOW_RADAR = 135;
    public static final int U_SHOW_TIRE_BACKUP = 120;
    public static final int U_SINGLE_BATTERY_OVEROLTAGE_ALARM = 193;
    public static final int U_SINGLE_BATTERY_UNDERVOLTAGE_ALARM = 194;
    public static final int U_SINGLE_VOLTAGE_DIFFERENCE = 182;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 131;
    public static final int U_SOC_JUMP_ALARM = 196;
    public static final int U_SOC_LOW_ALARM = 192;
    public static final int U_SOC_TOO_HIGH = 184;
    public static final int U_SOC_TOO_HIGH_ALARM = 195;
    public static final int U_SOC_TRANSTITION = 183;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 102;
    public static final int U_TEMPERATURE_DIFFERENCE_ALARM = 188;
    public static final int U_THE_VOLTAGE_TOO_LOW = 186;
    public static final int U_TIRE_SHOW_STATE = 121;
    public static final int U_TOTAL_VOLAGE_TOO_HIGH = 187;
    public static final int U_TPMS_STATE = 122;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 129;
    public static final int U_UNLOCK_BY_SMART_DOOR = 130;
    public static final int U_VALID_VENTILATION_ENABLED = 108;
    public static final int U_WARNNING_LOW_BATTERY = 105;
    public static final int U_WARNNING_LOW_OIL = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 206; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65849) {
            //AirHelper.getInstance().buildUi(new Air_0313_SBD_WC1_24vW3(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 206) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
