package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0118_XP1_BiaoZhi2008 extends CallbackCanbusBase {
    public static final int U_174008_PANNEL_LEFT = 105;
    public static final int U_174008_PANNEL_RIGHT = 106;
    public static final int U_AIR_AC = 74;
    public static final int U_AIR_ACMAX = 87;
    public static final int U_AIR_AQS = 97;
    public static final int U_AIR_AUTO = 70;
    public static final int U_AIR_BEGIN = 69;
    public static final int U_AIR_BLOW_AUTO_LEFT = 85;
    public static final int U_AIR_BLOW_BODY_LEFT = 76;
    public static final int U_AIR_BLOW_FOOT_LEFT = 77;
    public static final int U_AIR_BLOW_UP_LEFT = 78;
    public static final int U_AIR_BY_AUTO_KEY = 42;
    public static final int U_AIR_CYCLE = 71;
    public static final int U_AIR_DUAL = 80;
    public static final int U_AIR_ECO = 83;
    public static final int U_AIR_END = 90;
    public static final int U_AIR_FRONT_DEFROST = 72;
    public static final int U_AIR_HYAC = 89;
    public static final int U_AIR_MONO = 88;
    public static final int U_AIR_POWER = 82;
    public static final int U_AIR_REAR_DEFROST = 73;
    public static final int U_AIR_SYNC = 86;
    public static final int U_AIR_TEMP_LEFT = 75;
    public static final int U_AIR_TEMP_RIGHT = 81;
    public static final int U_AIR_TEMP_UNIT = 84;
    public static final int U_AIR_WIND_LEVEL_LEFT = 79;
    public static final int U_AIR_WIND_STRENGTH = 98;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 21;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 22;
    public static final int U_BATTERY_VOLTAGE = 50;
    public static final int U_CARSET_BLACKLIGHT = 107;
    public static final int U_CARSET_CARDOOR_LOCK_STATE = 108;
    public static final int U_CARSET_CENTER_LOCK = 109;
    public static final int U_CARSET_DRIVER_ASSIST = 99;
    public static final int U_CARSET_OIL_UNIT = 113;
    public static final int U_CARSET_ONLY_UNLOOK_BACKDOOR = 102;
    public static final int U_CARSET_PILAO_DETECT = 103;
    public static final int U_CARSET_PULL_CONTROL_SYS = 104;
    public static final int U_CARSET_THEME_COLOR = 110;
    public static final int U_CARSET_TURNLIGHT_BYDRIVER = 100;
    public static final int U_CAR_INFO_BTN_ENTER = 57;
    public static final int U_CLOSE_BIGLAMP_TIME = 32;
    public static final int U_CLOSE_INSIDELAMP_TIME = 30;
    public static final int U_CNT_MAX = 122;
    public static final int U_DISPLAY_ENABLE_0 = 58;
    public static final int U_DISPLAY_ENABLE_1 = 59;
    public static final int U_DISPLAY_ENABLE_2 = 60;
    public static final int U_DISPLAY_ENABLE_3 = 61;
    public static final int U_DISPLAY_ENABLE_4 = 62;
    public static final int U_DISPLAY_ENABLE_5 = 63;
    public static final int U_DISPLAY_ENABLE_6 = 64;
    public static final int U_DISPLAY_ENABLE_7 = 65;
    public static final int U_DISPLAY_ENABLE_8 = 66;
    public static final int U_DOOR_BACK = 95;
    public static final int U_DOOR_BEGIN = 90;
    public static final int U_DOOR_END = 96;
    public static final int U_DOOR_ENGINE = 90;
    public static final int U_DOOR_FL = 91;
    public static final int U_DOOR_FR = 92;
    public static final int U_DOOR_RL = 93;
    public static final int U_DOOR_RR = 94;
    public static final int U_ECOMIC_MODE = 112;
    public static final int U_ENGINE_SPEED = 51;
    public static final int U_ESC_SYSTEM = 54;
    public static final int U_EXIST_TPMS = 40;
    public static final int U_IDCARNUM = 68;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 43;
    public static final int U_LAST_OIL = 49;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 111;
    public static final int U_MEM_SPEED1 = 117;
    public static final int U_MEM_SPEED2 = 118;
    public static final int U_MEM_SPEED3 = 119;
    public static final int U_MEM_SPEED4 = 120;
    public static final int U_MEM_SPEED5 = 121;
    public static final int U_MEM_SPEED_ONOFF = 114;
    public static final int U_MEM_SPEED_SELECT = 115;
    public static final int U_MEM_SPEED_SHOW = 116;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 24;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 25;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 23;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 28;
    public static final int U_MUTIL_ECO_TIPS = 26;
    public static final int U_MUTIL_TRAVELLING_TIME = 27;
    public static final int U_OIL_MARK_MAX = 56;
    public static final int U_PARK_BESIDE_ROAD = 52;
    public static final int U_PARK_IN_CARPORT = 53;
    public static final int U_PRESSURE_BACKUP = 39;
    public static final int U_PRESSURE_FL = 35;
    public static final int U_PRESSURE_FR = 36;
    public static final int U_PRESSURE_RL = 37;
    public static final int U_PRESSURE_RR = 38;
    public static final int U_RADAR_MUTE = 20;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 31;
    public static final int U_SHOW_TIRE_BACKUP = 41;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 29;
    public static final int U_TIRE_SHOW_STATE = 67;
    public static final int U_UNIT_CONSUMPTION = 34;
    public static final int U_UNIT_PRESSURE = 55;
    public static final int U_UNIT_TEMPERATURE = 33;
    public static final int U_WARNNING_CLEANNING_FLUID = 47;
    public static final int U_WARNNING_HANDLE_BRAKE = 48;
    public static final int U_WARNNING_LIFE_BELT = 46;
    public static final int U_WARNNING_LOW_BATTERY = 45;
    public static final int U_WARNNING_LOW_OIL = 44;
    public static int mSum = -1;
    public static int mCurrPage = -1;
    public static String mCarId = null;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 122; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 90;
        DoorHelper.sUcDoorFl = 91;
        DoorHelper.sUcDoorFr = 92;
        DoorHelper.sUcDoorRl = 93;
        DoorHelper.sUcDoorRr = 94;
        DoorHelper.sUcDoorBack = 95;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 90; i2 < 96; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 90; i < 96; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 122) {
            if (updateCode == 18) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[18];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 68) {
                if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(mCarId, strs[0])) {
                    mCarId = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
