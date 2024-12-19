package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0408_SHA_Bus extends CallbackCanbusBase {
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_FOOT = 21;
    public static final int U_AIR_BLOW_MODE = 23;
    public static final int U_AIR_BLOW_UP = 20;
    public static final int U_AIR_BLOW_WIN = 22;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_CYCLE_DEFROST = 17;
    public static final int U_AIR_DEFROST_STATE = 19;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_TEMP_LEFTT = 16;
    public static final int U_AIR_WATER_VALVE = 14;
    public static final int U_AIR_WIND = 15;
    public static final int U_AIR_WIND_DEFROST = 18;
    public static final int U_CARINFO_24V_LOW_VOLTAGE = 88;
    public static final int U_CARINFO_24V_OVERLOAD_ERROR = 110;
    public static final int U_CARINFO_ACCELERATE_PEDAL_CAPABILITY_CHECK = 59;
    public static final int U_CARINFO_ACCELERATE_PEDAL_GUN_SHORT_CHECK = 61;
    public static final int U_CARINFO_ACCELERATE_PEDAL_OPEN_CHECK = 62;
    public static final int U_CARINFO_ACCELERATE_PEDAL_POWER_SHORT_CHECK = 60;
    public static final int U_CARINFO_ACTIVE_DISCHARGE_ERROR = 99;
    public static final int U_CARINFO_AIR_BREAK_LEVEL = 57;
    public static final int U_CARINFO_AIR_CONTROL_DROPPED_CHECK = 76;
    public static final int U_CARINFO_AIR_PUMP_CONTROL_DROPPED_CHECK = 81;
    public static final int U_CARINFO_AVER_VOLTAGE_OVERRUN = 116;
    public static final int U_CARINFO_BATTERY_BRAKE_LEVEL = 52;
    public static final int U_CARINFO_BATTERY_CONTROL_DROPPED_CHECK = 72;
    public static final int U_CARINFO_BATTERY_LOW_VOLTAGE_CHECK = 69;
    public static final int U_CARINFO_BATTERY_TEMP_EQUAL_ERROR = 122;
    public static final int U_CARINFO_BATTERY_TOO_LOW_CHECK = 70;
    public static final int U_CARINFO_BATVOL_EQUALIZATION_ERROR = 111;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_BUS_LOW_VOLTAGE = 94;
    public static final int U_CARINFO_BUS_OVELVOLTAGE = 133;
    public static final int U_CARINFO_BUS_OVER_VOLTAGE = 89;
    public static final int U_CARINFO_CAN_COMMINICATION_ERROR = 143;
    public static final int U_CARINFO_CAN_COMMUNICATE_EXCEPTION = 163;
    public static final int U_CARINFO_CAN_RECEPTION_ERROR = 105;
    public static final int U_CARINFO_CAN_SEND_ERROR = 103;
    public static final int U_CARINFO_CAR_BRAKE_LEVEL = 50;
    public static final int U_CARINFO_CAR_CONTROL_BRAKE_LEVEL = 53;
    public static final int U_CARINFO_CHARGER_BRAKE_LEVEL = 55;
    public static final int U_CARINFO_CHARGER_DROPPED_CHECK = 74;
    public static final int U_CARINFO_CHARGE_STORAGE_UNMATCH = 124;
    public static final int U_CARINFO_CHARGE_TEMP_TOO_HIGH = 128;
    public static final int U_CARINFO_COMMUNICATION_STATUS = 131;
    public static final int U_CARINFO_CONTROL_OVERTEMP = 167;
    public static final int U_CARINFO_CONTROL_TEMP_SENSOR_ERROR = 165;
    public static final int U_CARINFO_CURR_SENSOR_ERROR = 164;
    public static final int U_CARINFO_CUTOFF_MAIN_NEGATIVE = 114;
    public static final int U_CARINFO_DCDC_WORK_TYPE_DATA_LOST = 158;
    public static final int U_CARINFO_DC_DC_BRAKE_LEVEL = 54;
    public static final int U_CARINFO_DC_DC_DROPPED_CHECK = 77;
    public static final int U_CARINFO_DC_HIGH_PRESS_OVER_PRESS = 171;
    public static final int U_CARINFO_DC_HIGH_PRESS_UNDER_PRESS = 170;
    public static final int U_CARINFO_DOWN_MACHINE_NORESPOND_ALARM = 120;
    public static final int U_CARINFO_DRIVE_LOW_VOLTAGE = 87;
    public static final int U_CARINFO_DRIVE_OVERCUR = 86;
    public static final int U_CARINFO_DRIVE_OVER_HEAT = 93;
    public static final int U_CARINFO_EEPPOM_READ_WRITE_ERROR = 134;
    public static final int U_CARINFO_EEPROM_ERROR = 104;
    public static final int U_CARINFO_ELEC_DETECTION_ERROR = 95;
    public static final int U_CARINFO_ELEC_MOTOR_POSITION_EXCEPTION = 162;
    public static final int U_CARINFO_END = 173;
    public static final int U_CARINFO_FAST_LIMIT = 90;
    public static final int U_CARINFO_GAS_TANK_PRESS_LOW_CHECK = 82;
    public static final int U_CARINFO_HARDWARE_ERROR = 127;
    public static final int U_CARINFO_HELP_CONTROL_DROPPED_CHECK = 75;
    public static final int U_CARINFO_HIGH_PRESS_ERROR = 107;
    public static final int U_CARINFO_HIGH_PRESS_OVER_VOLTAGE = 149;
    public static final int U_CARINFO_HIGH_PRESS_UNDER_PRESS = 150;
    public static final int U_CARINFO_INITIATIVE_PEDAL_CAPABILITY_CHECK = 63;
    public static final int U_CARINFO_INITIATIVE_PEDAL_GUN_SHORT_CHECK = 65;
    public static final int U_CARINFO_INITIATIVE_PEDAL_OPEN_CHECK = 66;
    public static final int U_CARINFO_INITIATIVE_PEDAL_POWER_SHORT_CHECK = 64;
    public static final int U_CARINFO_INPUT_LOW_PRESS = 132;
    public static final int U_CARINFO_INPUT_VALTAGE = 129;
    public static final int U_CARINFO_INSULATION_ERROR = 121;
    public static final int U_CARINFO_INTERLOCK_ERROR = 159;
    public static final int U_CARINFO_IPM_PRETECT = 139;
    public static final int U_CARINFO_LACK_OF_PHASE = 138;
    public static final int U_CARINFO_LOW_CAPACITY_ALARM = 119;
    public static final int U_CARINFO_LOW_PRESS_CURR_SENSOR = 156;
    public static final int U_CARINFO_LOW_PRESS_ERROR = 145;
    public static final int U_CARINFO_LOW_PRESS_OVER_VOLTAGE = 151;
    public static final int U_CARINFO_LOW_PRESS_UNDER_VOLTAGE = 154;
    public static final int U_CARINFO_MICROPHONE = 25;
    public static final int U_CARINFO_MOTOR_BRAKE_LEVEL = 51;
    public static final int U_CARINFO_MOTOR_CONTROL_DROPPED_CHECK = 71;
    public static final int U_CARINFO_MOTOR_CONTROL_INVERTER_ERROR = 172;
    public static final int U_CARINFO_MOTOR_CONTROL_TEMP_CHECK = 68;
    public static final int U_CARINFO_MOTOR_OVERCUR = 85;
    public static final int U_CARINFO_MOTOR_OVERLOAD = 102;
    public static final int U_CARINFO_MOTOR_OVERTEMP = 168;
    public static final int U_CARINFO_MOTOR_SPEEDING = 96;
    public static final int U_CARINFO_MOTOR_SPEEDING2 = 169;
    public static final int U_CARINFO_MOTOR_TEMP_SENSOR_DROPPED = 100;
    public static final int U_CARINFO_MOTOR_TEMP_SENSOR_ERROR = 166;
    public static final int U_CARINFO_MOTOR_TEMP_TOO_HIGH = 98;
    public static final int U_CARINFO_OUTPUT_ERROR = 152;
    public static final int U_CARINFO_OUTPUT_IS_MISSING = 92;
    public static final int U_CARINFO_OVERCURRENT = 135;
    public static final int U_CARINFO_OVERHEAT = 136;
    public static final int U_CARINFO_OVERLOAD = 137;
    public static final int U_CARINFO_OVER_CHARGE_ALARM = 125;
    public static final int U_CARINFO_OVER_CURRENT_ERROR = 148;
    public static final int U_CARINFO_OVER_HEAT_ERROR = 146;
    public static final int U_CARINFO_OVER_TEMP_ERROR = 153;
    public static final int U_CARINFO_OVER_VOLTAGE_ERROR = 147;
    public static final int U_CARINFO_PHASE_ELEC_OVER_CURR = 108;
    public static final int U_CARINFO_POSITION_ERROR = 142;
    public static final int U_CARINFO_POWER_BATTERY_LOW_VOLTAGE_CHECK = 67;
    public static final int U_CARINFO_POWER_MODULE_OVER_CURR = 161;
    public static final int U_CARINFO_POWER_VOLTAGE_ERROR = 141;
    public static final int U_CARINFO_PUMP_BREAK_LEVEL = 58;
    public static final int U_CARINFO_RESISTANCE_PUMP_BREAK_LEVEL = 56;
    public static final int U_CARINFO_ROTATION_ERROR = 91;
    public static final int U_CARINFO_RUN_FAILED = 160;
    public static final int U_CARINFO_SELF_TEST_ERROR = 140;
    public static final int U_CARINFO_SELF_TEST_FAIL = 144;
    public static final int U_CARINFO_SINGLE_MAX_TEMP_LIMIT = 112;
    public static final int U_CARINFO_SINGLE_MAX_VOLTAGE_LIMIT = 117;
    public static final int U_CARINFO_SINGLE_MIN_VOLTAGE_LIMIT = 118;
    public static final int U_CARINFO_SOC_FAILURE_RATE_10_CHECK = 80;
    public static final int U_CARINFO_SOC_FAILURE_RATE_20_CHECK = 79;
    public static final int U_CARINFO_SOC_FAILURE_RATE_30_CHECK = 78;
    public static final int U_CARINFO_SOC_JUMP_ERROR = 123;
    public static final int U_CARINFO_SOC_TOO_HIGH = 126;
    public static final int U_CARINFO_SPEED_DEVIATION_TOO_LARGE = 97;
    public static final int U_CARINFO_START_STATE = 130;
    public static final int U_CARINFO_STOP_POWER_FAIL = 155;
    public static final int U_CARINFO_TBOX_DROPPED_CHECK = 83;
    public static final int U_CARINFO_TBOX_SIM_STATE = 84;
    public static final int U_CARINFO_TEMP_SENSOR_ERROR = 157;
    public static final int U_CARINFO_THROTTLE_BROKEN = 106;
    public static final int U_CARINFO_TORQUE_TOO_LARGE = 109;
    public static final int U_CARINFO_TOTAL_CUR_LIMIT = 115;
    public static final int U_CARINFO_TOTAL_VOLTAGE_OVERRUN = 113;
    public static final int U_CARINFO_TRANSFORMER_OVERLOAD = 101;
    public static final int U_CARINFO_WATER_PUMP_STATE = 73;
    public static final int U_CNT_MAX = 173;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Log.d("air", "updatecode:" + updateCode);
        if (updateCode >= 0 && updateCode < 173) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        Log.d("air", "register:------------------------");
        for (int i = 0; i < 173; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }
}
