package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0408_SHA_Bus extends CallbackCanbusBase {
    public static final int U_CARINFO_24V_LOW_VOLTAGE = 137;
    public static final int U_CARINFO_24V_OVERLOAD_ERROR = 159;
    public static final int U_CARINFO_ACCELERATE_PEDAL_CAPABILITY_CHECK = 108;
    public static final int U_CARINFO_ACCELERATE_PEDAL_GUN_SHORT_CHECK = 110;
    public static final int U_CARINFO_ACCELERATE_PEDAL_OPEN_CHECK = 111;
    public static final int U_CARINFO_ACCELERATE_PEDAL_POWER_SHORT_CHECK = 109;
    public static final int U_CARINFO_ACTIVE_DISCHARGE_ERROR = 148;
    public static final int U_CARINFO_AIR_BREAK_LEVEL = 106;
    public static final int U_CARINFO_AIR_CONTROL_DROPPED_CHECK = 125;
    public static final int U_CARINFO_AIR_PUMP_CONTROL_DROPPED_CHECK = 130;
    public static final int U_CARINFO_AVER_VOLTAGE_OVERRUN = 165;
    public static final int U_CARINFO_BATTERY_BRAKE_LEVEL = 101;
    public static final int U_CARINFO_BATTERY_CONTROL_DROPPED_CHECK = 121;
    public static final int U_CARINFO_BATTERY_LOW_VOLTAGE_CHECK = 118;
    public static final int U_CARINFO_BATTERY_TEMP_EQUAL_ERROR = 171;
    public static final int U_CARINFO_BATTERY_TOO_LOW_CHECK = 119;
    public static final int U_CARINFO_BATVOL_EQUALIZATION_ERROR = 160;
    public static final int U_CARINFO_BEGIN = 99;
    public static final int U_CARINFO_BUS_LOW_VOLTAGE = 143;
    public static final int U_CARINFO_BUS_OVELVOLTAGE = 182;
    public static final int U_CARINFO_BUS_OVER_VOLTAGE = 138;
    public static final int U_CARINFO_CAN_COMMINICATION_ERROR = 192;
    public static final int U_CARINFO_CAN_COMMUNICATE_EXCEPTION = 212;
    public static final int U_CARINFO_CAN_RECEPTION_ERROR = 154;
    public static final int U_CARINFO_CAN_SEND_ERROR = 152;
    public static final int U_CARINFO_CAR_BRAKE_LEVEL = 99;
    public static final int U_CARINFO_CAR_CONTROL_BRAKE_LEVEL = 102;
    public static final int U_CARINFO_CHARGER_BRAKE_LEVEL = 104;
    public static final int U_CARINFO_CHARGER_DROPPED_CHECK = 123;
    public static final int U_CARINFO_CHARGE_STORAGE_UNMATCH = 173;
    public static final int U_CARINFO_CHARGE_TEMP_TOO_HIGH = 177;
    public static final int U_CARINFO_COMMUNICATION_STATUS = 180;
    public static final int U_CARINFO_CONTROL_OVERTEMP = 216;
    public static final int U_CARINFO_CONTROL_TEMP_SENSOR_ERROR = 214;
    public static final int U_CARINFO_CURR_SENSOR_ERROR = 213;
    public static final int U_CARINFO_CUTOFF_MAIN_NEGATIVE = 163;
    public static final int U_CARINFO_DCDC_WORK_TYPE_DATA_LOST = 207;
    public static final int U_CARINFO_DC_DC_BRAKE_LEVEL = 103;
    public static final int U_CARINFO_DC_DC_DROPPED_CHECK = 126;
    public static final int U_CARINFO_DC_HIGH_PRESS_OVER_PRESS = 220;
    public static final int U_CARINFO_DC_HIGH_PRESS_UNDER_PRESS = 219;
    public static final int U_CARINFO_DOWN_MACHINE_NORESPOND_ALARM = 169;
    public static final int U_CARINFO_DRIVE_LOW_VOLTAGE = 136;
    public static final int U_CARINFO_DRIVE_OVERCUR = 135;
    public static final int U_CARINFO_DRIVE_OVER_HEAT = 142;
    public static final int U_CARINFO_EEPPOM_READ_WRITE_ERROR = 183;
    public static final int U_CARINFO_EEPROM_ERROR = 153;
    public static final int U_CARINFO_ELEC_DETECTION_ERROR = 144;
    public static final int U_CARINFO_ELEC_MOTOR_POSITION_EXCEPTION = 211;
    public static final int U_CARINFO_END = 222;
    public static final int U_CARINFO_FAST_LIMIT = 139;
    public static final int U_CARINFO_GAS_TANK_PRESS_LOW_CHECK = 131;
    public static final int U_CARINFO_HARDWARE_ERROR = 176;
    public static final int U_CARINFO_HELP_CONTROL_DROPPED_CHECK = 124;
    public static final int U_CARINFO_HIGH_PRESS_ERROR = 156;
    public static final int U_CARINFO_HIGH_PRESS_OVER_VOLTAGE = 198;
    public static final int U_CARINFO_HIGH_PRESS_UNDER_PRESS = 199;
    public static final int U_CARINFO_INITIATIVE_PEDAL_CAPABILITY_CHECK = 112;
    public static final int U_CARINFO_INITIATIVE_PEDAL_GUN_SHORT_CHECK = 114;
    public static final int U_CARINFO_INITIATIVE_PEDAL_OPEN_CHECK = 115;
    public static final int U_CARINFO_INITIATIVE_PEDAL_POWER_SHORT_CHECK = 113;
    public static final int U_CARINFO_INPUT_LOW_PRESS = 181;
    public static final int U_CARINFO_INPUT_VALTAGE = 178;
    public static final int U_CARINFO_INSULATION_ERROR = 170;
    public static final int U_CARINFO_INTERLOCK_ERROR = 208;
    public static final int U_CARINFO_IPM_PRETECT = 188;
    public static final int U_CARINFO_LACK_OF_PHASE = 187;
    public static final int U_CARINFO_LOW_CAPACITY_ALARM = 168;
    public static final int U_CARINFO_LOW_PRESS_CURR_SENSOR = 205;
    public static final int U_CARINFO_LOW_PRESS_ERROR = 194;
    public static final int U_CARINFO_LOW_PRESS_OVER_VOLTAGE = 200;
    public static final int U_CARINFO_LOW_PRESS_UNDER_VOLTAGE = 203;
    public static final int U_CARINFO_MICROPHONE = 98;
    public static final int U_CARINFO_MOTOR_BRAKE_LEVEL = 100;
    public static final int U_CARINFO_MOTOR_CONTROL_DROPPED_CHECK = 120;
    public static final int U_CARINFO_MOTOR_CONTROL_INVERTER_ERROR = 221;
    public static final int U_CARINFO_MOTOR_CONTROL_TEMP_CHECK = 117;
    public static final int U_CARINFO_MOTOR_OVERCUR = 134;
    public static final int U_CARINFO_MOTOR_OVERLOAD = 151;
    public static final int U_CARINFO_MOTOR_OVERTEMP = 217;
    public static final int U_CARINFO_MOTOR_SPEEDING = 145;
    public static final int U_CARINFO_MOTOR_SPEEDING2 = 218;
    public static final int U_CARINFO_MOTOR_TEMP_SENSOR_DROPPED = 149;
    public static final int U_CARINFO_MOTOR_TEMP_SENSOR_ERROR = 215;
    public static final int U_CARINFO_MOTOR_TEMP_TOO_HIGH = 147;
    public static final int U_CARINFO_OUTPUT_ERROR = 201;
    public static final int U_CARINFO_OUTPUT_IS_MISSING = 141;
    public static final int U_CARINFO_OVERCURRENT = 184;
    public static final int U_CARINFO_OVERHEAT = 185;
    public static final int U_CARINFO_OVERLOAD = 186;
    public static final int U_CARINFO_OVER_CHARGE_ALARM = 174;
    public static final int U_CARINFO_OVER_CURRENT_ERROR = 197;
    public static final int U_CARINFO_OVER_HEAT_ERROR = 195;
    public static final int U_CARINFO_OVER_TEMP_ERROR = 202;
    public static final int U_CARINFO_OVER_VOLTAGE_ERROR = 196;
    public static final int U_CARINFO_PHASE_ELEC_OVER_CURR = 157;
    public static final int U_CARINFO_POSITION_ERROR = 191;
    public static final int U_CARINFO_POWER_BATTERY_LOW_VOLTAGE_CHECK = 116;
    public static final int U_CARINFO_POWER_MODULE_OVER_CURR = 210;
    public static final int U_CARINFO_POWER_VOLTAGE_ERROR = 190;
    public static final int U_CARINFO_PUMP_BREAK_LEVEL = 107;
    public static final int U_CARINFO_RESISTANCE_PUMP_BREAK_LEVEL = 105;
    public static final int U_CARINFO_ROTATION_ERROR = 140;
    public static final int U_CARINFO_RUN_FAILED = 209;
    public static final int U_CARINFO_SELF_TEST_ERROR = 189;
    public static final int U_CARINFO_SELF_TEST_FAIL = 193;
    public static final int U_CARINFO_SINGLE_MAX_TEMP_LIMIT = 161;
    public static final int U_CARINFO_SINGLE_MAX_VOLTAGE_LIMIT = 166;
    public static final int U_CARINFO_SINGLE_MIN_VOLTAGE_LIMIT = 167;
    public static final int U_CARINFO_SOC_FAILURE_RATE_10_CHECK = 129;
    public static final int U_CARINFO_SOC_FAILURE_RATE_20_CHECK = 128;
    public static final int U_CARINFO_SOC_FAILURE_RATE_30_CHECK = 127;
    public static final int U_CARINFO_SOC_JUMP_ERROR = 172;
    public static final int U_CARINFO_SOC_TOO_HIGH = 175;
    public static final int U_CARINFO_SPEED_DEVIATION_TOO_LARGE = 146;
    public static final int U_CARINFO_START_STATE = 179;
    public static final int U_CARINFO_STOP_POWER_FAIL = 204;
    public static final int U_CARINFO_TBOX_DROPPED_CHECK = 132;
    public static final int U_CARINFO_TBOX_SIM_STATE = 133;
    public static final int U_CARINFO_TEMP_SENSOR_ERROR = 206;
    public static final int U_CARINFO_THROTTLE_BROKEN = 155;
    public static final int U_CARINFO_TORQUE_TOO_LARGE = 158;
    public static final int U_CARINFO_TOTAL_CUR_LIMIT = 164;
    public static final int U_CARINFO_TOTAL_VOLTAGE_OVERRUN = 162;
    public static final int U_CARINFO_TRANSFORMER_OVERLOAD = 150;
    public static final int U_CARINFO_WATER_PUMP_STATE = 122;
    public static final int U_CNT_MAX = 222;

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 222) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 222; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }
}
