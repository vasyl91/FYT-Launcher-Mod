package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0321_WC2_Honda_AllCom extends CallbackCanbusBase {
    public static final int U_BATTERY_VOLTAGE = 207;
    public static final int U_CAREQ_DA6_D0_B70 = 200;
    public static final int U_CAREQ_DA6_D1_B70 = 201;
    public static final int U_CAREQ_DA6_D2_B70 = 202;
    public static final int U_CAREQ_DA6_D3_B70 = 203;
    public static final int U_CAREQ_DA6_D4_B70 = 204;
    public static final int U_CAREQ_DA6_D5_B70 = 205;
    public static final int U_CAREQ_DA6_D6_B74 = 206;
    public static final int U_CARINFO_RIGHT_TURN_LIGHT_TIME = 146;
    public static final int U_CARINF_DE8_D6_B4 = 174;
    public static final int U_CARINF_DE8_D6_B5 = 173;
    public static final int U_CARSET_D64_D0_B6 = 188;
    public static final int U_CARSET_D64_D1_B0 = 191;
    public static final int U_CARSET_D64_D1_B1 = 190;
    public static final int U_CARSET_D64_D1_B2 = 189;
    public static final int U_CARSET_D64_D3_B32 = 195;
    public static final int U_CARSET_D64_D3_B54 = 194;
    public static final int U_CARSET_D64_D3_B6 = 193;
    public static final int U_CARSET_D64_D3_B7 = 192;
    public static final int U_CARSET_D64_D4_B3 = 197;
    public static final int U_CARSET_D64_D4_B74 = 196;
    public static final int U_CARSET_D65_D0_B0 = 185;
    public static final int U_CARSET_D65_D0_B1 = 184;
    public static final int U_CARSET_D66_D1_B4 = 183;
    public static final int U_CARSET_D67_D1_B7 = 182;
    public static final int U_CARSET_D68_D0_B4 = 187;
    public static final int U_CARSET_D68_D0_B5 = 186;
    public static final int U_CARSET_D75_D1_B2 = 199;
    public static final int U_CARSET_D75_D1_B3 = 198;
    public static final int U_CARSET_DE8_D0_B10 = 211;
    public static final int U_CARSET_DE8_D0_B32 = 210;
    public static final int U_CARSET_DE8_D0_B4 = 209;
    public static final int U_CAR_BACK_GUID_AUTO = 168;
    public static final int U_CAR_BACK_GUID_STATIC = 169;
    public static final int U_CAR_BACK_SIDE = 166;
    public static final int U_CAR_BACK_VIEW = 167;
    public static final int U_CAR_INSTRUMENT_PANEL_CONFIG = 172;
    public static final int U_CAR_PE_STATE = 208;
    public static final int U_CAR_TURN_BY_TURN_DISPLAY = 170;
    public static final int U_CAR_WARNING_MESSAGE = 171;
    public static final int U_CNT_MAX = 213;
    public static final int U_CUR_SPEED = 144;
    public static final int U_DRIVED_TIME_H = 164;
    public static final int U_DRIVED_TIME_M = 165;
    public static final int U_ENGINE_SPEED = 145;
    public static final int U_LANE_WATCH_DURTION = 155;
    public static final int U_LANE_WATCH_LIGHT = 154;
    public static final int U_MEMORY_POSITION_SEAT = 159;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 117;
    public static final int U_PLAYER_MDI = 179;
    public static final int U_PLAYER_PROGRESS = 180;
    public static final int U_PLAYER_STATES = 181;
    public static final int U_PLAYER_TIME = 176;
    public static final int U_PLAYER_TOTAL_TRACK = 178;
    public static final int U_PLAYER_TRACK = 177;
    public static final int U_REAR_VIEW_REMINDER = 156;
    public static final int U_RIGHT_CAREAR_STATE = 119;
    public static final int U_RISE_DRIVER_ATTENTION_MONITOR = 158;
    public static final int U_RISE_WARNING = 157;
    public static final int U_SEAT_BELT_MODE_SET = 160;
    public static final int U_SETTING_65D10 = 131;
    public static final int U_SETTING_65D11 = 130;
    public static final int U_SETTING_65D13 = 129;
    public static final int U_SETTING_65D14 = 148;
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
    public static final int U_SETTING_68D031 = 162;
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
    public static final int U_SETTING_69D17 = 163;
    public static final int U_SETTING_75D10 = 150;
    public static final int U_SETTING_75D11 = 151;
    public static final int U_SETTING_A6D60 = 153;
    public static final int U_SETTING_A6D61 = 152;
    public static final int U_SHOW_AIRMODE = 212;
    public static final int U_SWITCH_LOCK = 161;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 118;
    public static final int U_USB_TYPE = 175;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 213; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0321_WC2_17_guandao(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 213) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
