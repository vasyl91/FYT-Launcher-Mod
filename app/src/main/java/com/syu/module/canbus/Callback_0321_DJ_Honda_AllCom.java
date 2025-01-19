package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.honda.Activity17CRVAirControl;
import com.syu.carinfo.honda.ActivityAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0192_WC2_15_BinZhi;
//import com.syu.ui.air.Air_0321_WC2_17_guandao;
import com.syu.ui.door.DoorHelper;

public class Callback_0321_DJ_Honda_AllCom extends CallbackCanbusBase {
    public static final int U_CARINFO_RIGHT_TURN_LIGHT_TIME = 146;
    public static final int U_CNT_MAX = 181;
    public static final int U_CUR_SPEED = 144;
    public static final int U_DJ_BEGIN = 162;
    public static final int U_DJ_CARSET_FUNC = 164;
    public static final int U_DJ_CARSET_STATUS = 165;
    public static final int U_DJ_END = 166;
    public static final int U_DJ_REMOTE_LOCK = 163;
    public static final int U_ENGINE_SPEED = 145;
    public static final int U_LANE_WATCH_DURTION = 155;
    public static final int U_LANE_WATCH_LIGHT = 154;
    public static final int U_MEMORY_POSITION_SEAT = 159;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 117;
    public static final int U_RADIO_AM_LIST_FREQ = 172;
    public static final int U_RADIO_AM_LIST_INFO = 173;
    public static final int U_RADIO_BAND = 167;
    public static final int U_RADIO_BEGIN = 167;
    public static final int U_RADIO_CHANNEL = 175;
    public static final int U_RADIO_CHANNEL_AMFREQ_PRESET = 168;
    public static final int U_RADIO_CHANNEL_AM_CNT = 177;
    public static final int U_RADIO_CHANNEL_FMFREQ_PRESET = 169;
    public static final int U_RADIO_CHANNEL_FM_CNT = 178;
    public static final int U_RADIO_END = 180;
    public static final int U_RADIO_FM_LIST_FREQ = 170;
    public static final int U_RADIO_FM_LIST_INFO = 171;
    public static final int U_RADIO_FREQ = 174;
    public static final int U_RADIO_LIGHT_ID = 179;
    public static final int U_RADIO_SEARCH_STATE = 176;
    public static final int U_REAR_VIEW_REMINDER = 156;
    public static final int U_RIGHT_CAREAR_STATE = 119;
    public static final int U_RISE_DRIVER_ATTENTION_MONITOR = 158;
    public static final int U_RISE_WARNING = 157;
    public static final int U_SEAT_BELT_MODE_SET = 160;
    public static final int U_SETTING_65D10 = 131;
    public static final int U_SETTING_65D11 = 130;
    public static final int U_SETTING_65D13 = 129;
    public static final int U_SETTING_65D14 = 149;
    public static final int U_SETTING_65D16 = 147;
    public static final int U_SETTING_66D10 = 128;
    public static final int U_SETTING_66D11 = 127;
    public static final int U_SETTING_66D12 = 126;
    public static final int U_SETTING_66D13 = 125;
    public static final int U_SETTING_67D00 = 121;
    public static final int U_SETTING_67D03 = 120;
    public static final int U_SETTING_67D10 = 124;
    public static final int U_SETTING_67D12 = 123;
    public static final int U_SETTING_67D14 = 122;
    public static final int U_SETTING_68D10 = 135;
    public static final int U_SETTING_68D12 = 134;
    public static final int U_SETTING_68D13 = 133;
    public static final int U_SETTING_68D14 = 132;
    public static final int U_SETTING_69D00 = 140;
    public static final int U_SETTING_69D02 = 139;
    public static final int U_SETTING_69D03 = 138;
    public static final int U_SETTING_69D04 = 137;
    public static final int U_SETTING_69D05 = 136;
    public static final int U_SETTING_69D06 = 149;
    public static final int U_SETTING_69D10 = 143;
    public static final int U_SETTING_69D13 = 142;
    public static final int U_SETTING_69D15 = 141;
    public static final int U_SETTING_75D10 = 150;
    public static final int U_SETTING_75D11 = 151;
    public static final int U_SETTING_A6D60 = 153;
    public static final int U_SETTING_A6D61 = 152;
    public static final int U_SWITCH_LOCK = 161;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 118;
    int carId;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 181; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        this.carId = (DataCanbus.DATA[1000] >> 16) & 255;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (this.carId == 5 || this.carId == 6) {
            //AirHelper.getInstance().buildUi(new Air_0321_WC2_17_guandao(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            //AirHelper.getInstance().buildUi(new Air_0192_WC2_15_BinZhi(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i4 = 0; i4 < 6; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 64:
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
                if (updateCode >= 0 && updateCode < 181) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
