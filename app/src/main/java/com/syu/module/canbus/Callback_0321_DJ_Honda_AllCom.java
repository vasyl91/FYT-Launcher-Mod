package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.honda.Activity17CRVAirControl;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0192_WC2_15_BinZhi;
import com.syu.ui.air.Air_0321_WC2_17_guandao;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0321_DJ_Honda_AllCom extends CallbackCanbusBase {
    public static final int U_AIR_AC = 30;
    public static final int U_AIR_ADD = 77;
    public static final int U_AIR_AUTO = 26;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_BODY_LEFT = 32;
    public static final int U_AIR_BLOW_BODY_RIGHT = 80;
    public static final int U_AIR_BLOW_FOOT_LEFT = 33;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 81;
    public static final int U_AIR_BLOW_UP_LEFT = 34;
    public static final int U_AIR_BLOW_UP_RIGHT = 82;
    public static final int U_AIR_CYCLE = 27;
    public static final int U_AIR_DUAL = 36;
    public static final int U_AIR_END = 40;
    public static final int U_AIR_FRONT_DEFROST = 28;
    public static final int U_AIR_MODE = 73;
    public static final int U_AIR_MODE_RIGHT = 83;
    public static final int U_AIR_POWER = 38;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SEAT_BLOW_HEAT_LEFT = 78;
    public static final int U_AIR_SEAT_BLOW_HEAT_RIGHT = 79;
    public static final int U_AIR_SYNC = 39;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 37;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 84;
    public static final int U_CARINFO_RIGHT_TURN_LIGHT_TIME = 85;
    public static final int U_CNT_MAX = 127;
    public static final int U_CUR_SPEED = 75;
    public static final int U_DJ_BEGIN = 108;
    public static final int U_DJ_CARSET_FUNC = 110;
    public static final int U_DJ_CARSET_STATUS = 111;
    public static final int U_DJ_END = 112;
    public static final int U_DJ_REMOTE_LOCK = 109;
    public static final int U_DOOR_BACK = 45;
    public static final int U_DOOR_BEGIN = 40;
    public static final int U_DOOR_END = 46;
    public static final int U_DOOR_ENGINE = 40;
    public static final int U_DOOR_FL = 41;
    public static final int U_DOOR_FR = 42;
    public static final int U_DOOR_RL = 43;
    public static final int U_DOOR_RR = 44;
    public static final int U_ENGINE_SPEED = 76;
    public static final int U_LANE_WATCH_DURTION = 94;
    public static final int U_LANE_WATCH_LIGHT = 93;
    public static final int U_MEMORY_POSITION_SEAT = 98;
    public static final int U_RADIO_AM_LIST_FREQ = 118;
    public static final int U_RADIO_AM_LIST_INFO = 119;
    public static final int U_RADIO_BAND = 113;
    public static final int U_RADIO_BEGIN = 113;
    public static final int U_RADIO_CHANNEL = 121;
    public static final int U_RADIO_CHANNEL_AMFREQ_PRESET = 114;
    public static final int U_RADIO_CHANNEL_AM_CNT = 123;
    public static final int U_RADIO_CHANNEL_FMFREQ_PRESET = 115;
    public static final int U_RADIO_CHANNEL_FM_CNT = 124;
    public static final int U_RADIO_END = 126;
    public static final int U_RADIO_FM_LIST_FREQ = 116;
    public static final int U_RADIO_FM_LIST_INFO = 117;
    public static final int U_RADIO_FREQ = 120;
    public static final int U_RADIO_LIGHT_ID = 125;
    public static final int U_RADIO_SEARCH_STATE = 122;
    public static final int U_REAR_VIEW_REMINDER = 95;
    public static final int U_RIGHT_CAREAR_STATE = 48;
    public static final int U_RISE_DRIVER_ATTENTION_MONITOR = 97;
    public static final int U_RISE_WARNING = 96;
    public static final int U_SEAT_BELT_MODE_SET = 99;
    public static final int U_SETTING_65D10 = 60;
    public static final int U_SETTING_65D11 = 59;
    public static final int U_SETTING_65D13 = 58;
    public static final int U_SETTING_65D14 = 87;
    public static final int U_SETTING_65D16 = 86;
    public static final int U_SETTING_66D10 = 57;
    public static final int U_SETTING_66D11 = 56;
    public static final int U_SETTING_66D12 = 55;
    public static final int U_SETTING_66D13 = 54;
    public static final int U_SETTING_67D00 = 50;
    public static final int U_SETTING_67D03 = 49;
    public static final int U_SETTING_67D10 = 53;
    public static final int U_SETTING_67D12 = 52;
    public static final int U_SETTING_67D14 = 51;
    public static final int U_SETTING_68D10 = 64;
    public static final int U_SETTING_68D12 = 63;
    public static final int U_SETTING_68D13 = 62;
    public static final int U_SETTING_68D14 = 61;
    public static final int U_SETTING_69D00 = 69;
    public static final int U_SETTING_69D02 = 68;
    public static final int U_SETTING_69D03 = 67;
    public static final int U_SETTING_69D04 = 66;
    public static final int U_SETTING_69D05 = 65;
    public static final int U_SETTING_69D06 = 88;
    public static final int U_SETTING_69D10 = 72;
    public static final int U_SETTING_69D13 = 71;
    public static final int U_SETTING_69D15 = 70;
    public static final int U_SETTING_75D10 = 89;
    public static final int U_SETTING_75D11 = 90;
    public static final int U_SETTING_A6D60 = 92;
    public static final int U_SETTING_A6D61 = 91;
    public static final int U_SHOW_AIR_KEY = 74;
    public static final int U_SWITCH_LOCK = 100;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 47;
    int carId;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        this.carId = (DataCanbus.DATA[1000] >> 16) & 255;
        DoorHelper.sUcDoorEngine = 40;
        DoorHelper.sUcDoorFl = 41;
        DoorHelper.sUcDoorFr = 42;
        DoorHelper.sUcDoorRl = 43;
        DoorHelper.sUcDoorRr = 44;
        DoorHelper.sUcDoorBack = 45;
        if (this.carId == 5 || this.carId == 6) {
            AirHelper.getInstance().buildUi(new Air_0321_WC2_17_guandao(LauncherApplication.getInstance()));
            for (int i2 = 25; i2 < 40; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i3 = 77; i3 <= 84; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            AirHelper.getInstance().buildUi(new Air_0192_WC2_15_BinZhi(LauncherApplication.getInstance()));
            for (int i4 = 25; i4 < 40; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i5 = 40; i5 < 46; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 40; i < 46; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 25; i2 < 40; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 74:
                if (this.carId == 7 || this.carId == 8 || this.carId == 9) {
                    if (ints[0] == 1 && !Activity17CRVAirControl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.Activity17CRVAirControl");
                        break;
                    } else if (ints[0] == 1 && Activity17CRVAirControl.mIsFront && Activity17CRVAirControl.mInstance != null) {
                        Activity17CRVAirControl.mInstance.finish();
                        break;
                    }
                } else if (ints[0] == 1 && !ActivityAirControl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.honda.ActivityAirControl");
                    break;
                } else if (ints[0] == 1 && ActivityAirControl.mIsFront && ActivityAirControl.mInstance != null) {
                    ActivityAirControl.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 127) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}