package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Jianghuai_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_Jianghuai_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_AUTO = 8;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_MODE = 15;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 70;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_REAR_DEFROST = 10;
    public static final int U_AIR_SEAT_HOT_LEFT = 71;
    public static final int U_AIR_SEAT_HOT_RIGHT = 72;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND_LEVEL_LEFT = 16;
    public static final int U_CARSET_D3A_D10_B70 = 78;
    public static final int U_CARSET_D3A_D11_B70 = 79;
    public static final int U_CARSET_D3A_D12_B70 = 80;
    public static final int U_CARSET_D3A_DB_B70 = 73;
    public static final int U_CARSET_D3A_DC_B70 = 74;
    public static final int U_CARSET_D3A_DD_B70 = 75;
    public static final int U_CARSET_D3A_DE_B70 = 76;
    public static final int U_CARSET_D3A_DF_B70 = 77;
    public static final int U_CARSET_D40_D0_B76 = 66;
    public static final int U_CARSET_D40_D1_B5 = 69;
    public static final int U_CARSET_D40_D1_B6 = 68;
    public static final int U_CARSET_D40_D1_B7 = 67;
    public static final int U_CAR_AUTOLOCK_SPEED = 61;
    public static final int U_CAR_BACKLIGHT = 65;
    public static final int U_CAR_CHARGING_MODE = 47;
    public static final int U_CAR_CHARGING_TIME_MODE = 57;
    public static final int U_CAR_CHARGING_TIME_VALUE1_1 = 48;
    public static final int U_CAR_CHARGING_TIME_VALUE1_2 = 49;
    public static final int U_CAR_CHARGING_TIME_VALUE2_1 = 50;
    public static final int U_CAR_CHARGING_TIME_VALUE2_2 = 51;
    public static final int U_CAR_CHARGING_TIME_VALUE3_1 = 52;
    public static final int U_CAR_CHARGING_TIME_VALUE3_2 = 53;
    public static final int U_CAR_CHARGING_TIME_VALUE4_1 = 54;
    public static final int U_CAR_CHARGING_TIME_VALUE4_2 = 55;
    public static final int U_CAR_CHARGING_TIME_VALUE5 = 56;
    public static final int U_CAR_CURRENT = 36;
    public static final int U_CAR_DRIVE_MODE = 34;
    public static final int U_CAR_ELECTRICITY = 40;
    public static final int U_CAR_ENERGY_AIR = 44;
    public static final int U_CAR_ENERGY_AVG = 42;
    public static final int U_CAR_ENERGY_CUR = 43;
    public static final int U_CAR_ENERGY_DRIVE = 46;
    public static final int U_CAR_ENERGY_FLOW = 41;
    public static final int U_CAR_ENERGY_RECYCLE = 45;
    public static final int U_CAR_FORTIFICATION_BEEP = 62;
    public static final int U_CAR_GEAR = 35;
    public static final int U_CAR_INSIDE_LIGHT_DELAY_TIME = 60;
    public static final int U_CAR_LIGHT_POSITION = 63;
    public static final int U_CAR_LIGHT_TURN_AID = 64;
    public static final int U_CAR_MILEAGE = 38;
    public static final int U_CAR_OUT_LIGHT_DELAY_TIME = 59;
    public static final int U_CAR_REARVIEW_AUTO = 33;
    public static final int U_CAR_REMAIN_MILEAGE = 39;
    public static final int U_CAR_TOUCH_SENSITIVITY = 58;
    public static final int U_CAR_VOLTAGE = 37;
    public static final int U_CAR_WIN_AUTODOWN = 32;
    public static final int U_CNT_MAX = 81;
    public static final int U_PRESSURE_FL = 20;
    public static final int U_PRESSURE_FR = 21;
    public static final int U_PRESSURE_RL = 22;
    public static final int U_PRESSURE_RR = 23;
    public static final int U_TEMP_FL = 24;
    public static final int U_TEMP_FR = 25;
    public static final int U_TEMP_RL = 26;
    public static final int U_TEMP_RR = 27;
    public static final int U_WARNING_FL = 28;
    public static final int U_WARNING_FR = 29;
    public static final int U_WARNING_RL = 30;
    public static final int U_WARNING_RR = 31;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 81; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_Jianghuai_All(LauncherApplication.getInstance()));
        for (int i4 = 7; i4 < 19; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 19; i++) {
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
        if (updateCode >= 0 && updateCode < 81) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
