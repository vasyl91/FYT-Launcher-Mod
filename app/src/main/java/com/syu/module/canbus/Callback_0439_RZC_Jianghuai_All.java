package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.honda.ActivityHondaNullBackCar;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_Jianghuai_All extends CallbackCanbusBase {
    public static final int U_CARINF_UBACK_STATE = 166;
    public static final int U_CARINF_UBACK_STATE_ACT = 167;
    public static final int U_CARSET_D3A_D10_B70 = 153;
    public static final int U_CARSET_D3A_D11_B70 = 154;
    public static final int U_CARSET_D3A_D12_B70 = 155;
    public static final int U_CARSET_D3A_DB_B70 = 148;
    public static final int U_CARSET_D3A_DC_B70 = 149;
    public static final int U_CARSET_D3A_DD_B70 = 150;
    public static final int U_CARSET_D3A_DE_B70 = 151;
    public static final int U_CARSET_D3A_DF_B70 = 152;
    public static final int U_CARSET_D3B_D0_B30 = 165;
    public static final int U_CARSET_D3B_D0_B54 = 164;
    public static final int U_CARSET_D40_D0_B76 = 144;
    public static final int U_CARSET_D40_D1_B5 = 147;
    public static final int U_CARSET_D40_D1_B6 = 146;
    public static final int U_CARSET_D40_D1_B7 = 145;
    public static final int U_CARSET_D60_D0_B4 = 157;
    public static final int U_CARSET_D60_D0_B6 = 156;
    public static final int U_CARSET_D60_D1_B70 = 158;
    public static final int U_CARSET_D60_D2_B70 = 159;
    public static final int U_CARSET_D60_D3_B70 = 160;
    public static final int U_CARSET_D60_D4_B70 = 161;
    public static final int U_CARSET_D60_D5_B70 = 162;
    public static final int U_CARSET_D60_D6_B70 = 163;
    public static final int U_CAR_AUTOLOCK_SPEED = 139;
    public static final int U_CAR_BACKLIGHT = 143;
    public static final int U_CAR_CHARGING_MODE = 125;
    public static final int U_CAR_CHARGING_TIME_MODE = 135;
    public static final int U_CAR_CHARGING_TIME_VALUE1_1 = 126;
    public static final int U_CAR_CHARGING_TIME_VALUE1_2 = 127;
    public static final int U_CAR_CHARGING_TIME_VALUE2_1 = 128;
    public static final int U_CAR_CHARGING_TIME_VALUE2_2 = 129;
    public static final int U_CAR_CHARGING_TIME_VALUE3_1 = 130;
    public static final int U_CAR_CHARGING_TIME_VALUE3_2 = 131;
    public static final int U_CAR_CHARGING_TIME_VALUE4_1 = 132;
    public static final int U_CAR_CHARGING_TIME_VALUE4_2 = 133;
    public static final int U_CAR_CHARGING_TIME_VALUE5 = 134;
    public static final int U_CAR_CURRENT = 114;
    public static final int U_CAR_DRIVE_MODE = 112;
    public static final int U_CAR_ELECTRICITY = 118;
    public static final int U_CAR_ENERGY_AIR = 122;
    public static final int U_CAR_ENERGY_AVG = 120;
    public static final int U_CAR_ENERGY_CUR = 121;
    public static final int U_CAR_ENERGY_DRIVE = 124;
    public static final int U_CAR_ENERGY_FLOW = 119;
    public static final int U_CAR_ENERGY_RECYCLE = 123;
    public static final int U_CAR_FORTIFICATION_BEEP = 140;
    public static final int U_CAR_GEAR = 113;
    public static final int U_CAR_INSIDE_LIGHT_DELAY_TIME = 138;
    public static final int U_CAR_LIGHT_POSITION = 141;
    public static final int U_CAR_LIGHT_TURN_AID = 142;
    public static final int U_CAR_MILEAGE = 116;
    public static final int U_CAR_OUT_LIGHT_DELAY_TIME = 137;
    public static final int U_CAR_REARVIEW_AUTO = 111;
    public static final int U_CAR_REMAIN_MILEAGE = 117;
    public static final int U_CAR_TOUCH_SENSITIVITY = 136;
    public static final int U_CAR_VOLTAGE = 115;
    public static final int U_CAR_WIN_AUTODOWN = 110;
    public static final int U_CNT_MAX = 168;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;
    public static final int U_TEMP_FL = 102;
    public static final int U_TEMP_FR = 103;
    public static final int U_TEMP_RL = 104;
    public static final int U_TEMP_RR = 105;
    public static final int U_WARNING_FL = 106;
    public static final int U_WARNING_FR = 107;
    public static final int U_WARNING_RL = 108;
    public static final int U_WARNING_RR = 109;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 168; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_Jianghuai_All(LauncherApplication.getInstance()));
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
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 166) {
            if (DataCanbus.DATA[1000] == 6095301) {
                int value = ints[0];
                if (value == 1) {
                    if (!ActivityHondaNullBackCar.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityHondaNullBackCar");
                    }
                } else if (ActivityHondaNullBackCar.mIsFront && ActivityHondaNullBackCar.mInstance != null) {
                    ActivityHondaNullBackCar.mInstance.finish();
                }
            }
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode >= 0 && updateCode < 168) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
