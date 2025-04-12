package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.wc.infeinidi.WcInfinitCarCD;
import com.syu.carinfo.wc.infeinidi.WcInfinitCarRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_YFND_QX60;

public class Callback_0443_WC2_YingFeiNiDi_GX50 extends CallbackCanbusBase {
    public static final int C_PARKING_KEYDOWN = 1;
    public static final int U_CARAIR_SET_DATA5_B30 = 114;
    public static final int U_CARAIR_SET_DATA5_B74 = 113;
    public static final int U_CARAIR_SET_DATA6_B5 = 117;
    public static final int U_CARAIR_SET_DATA6_B6 = 116;
    public static final int U_CARAIR_SET_DATA6_B7 = 115;
    public static final int U_CARCD_PLAY_TIME = 158;
    public static final int U_CARCD_PLAY_TRACK = 159;
    public static final int U_CARCD_POWER_STATE = 155;
    public static final int U_CARCD_RADIO_FRQ = 157;
    public static final int U_CARCD_TOTAL_TRACK = 160;
    public static final int U_CARCD_TYPE = 156;
    public static final int U_CARINFO_AVG_FUEL = 100;
    public static final int U_CARINFO_AVG_FUEL_HIS1 = 103;
    public static final int U_CARINFO_AVG_FUEL_HIS10 = 112;
    public static final int U_CARINFO_AVG_FUEL_HIS2 = 104;
    public static final int U_CARINFO_AVG_FUEL_HIS3 = 105;
    public static final int U_CARINFO_AVG_FUEL_HIS4 = 106;
    public static final int U_CARINFO_AVG_FUEL_HIS5 = 107;
    public static final int U_CARINFO_AVG_FUEL_HIS6 = 108;
    public static final int U_CARINFO_AVG_FUEL_HIS7 = 109;
    public static final int U_CARINFO_AVG_FUEL_HIS8 = 110;
    public static final int U_CARINFO_AVG_FUEL_HIS9 = 111;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CUR_FUEL = 99;
    public static final int U_CARINFO_DRIVE_ENABLE = 102;
    public static final int U_CARINFO_TOTAL_MILE = 101;
    public static final int U_CARSET_AUTOLIGHT = 122;
    public static final int U_CARSET_AUTOLIGHT_TIME = 123;
    public static final int U_CARSET_CENTERRADAR = 120;
    public static final int U_CARSET_D61_D0_B0 = 177;
    public static final int U_CARSET_D61_D4_B0 = 166;
    public static final int U_CARSET_D61_D4_B1 = 165;
    public static final int U_CARSET_D61_D4_B2 = 164;
    public static final int U_CARSET_D61_D4_B43 = 163;
    public static final int U_CARSET_D61_D4_B65 = 162;
    public static final int U_CARSET_D61_D4_B7 = 161;
    public static final int U_CARSET_D61_D5_B10 = 172;
    public static final int U_CARSET_D61_D5_B32 = 171;
    public static final int U_CARSET_D61_D5_B4 = 170;
    public static final int U_CARSET_D61_D5_B5 = 169;
    public static final int U_CARSET_D61_D5_B6 = 168;
    public static final int U_CARSET_D61_D5_B7 = 167;
    public static final int U_CARSET_D61_D6_B10 = 176;
    public static final int U_CARSET_D61_D6_B2 = 175;
    public static final int U_CARSET_D61_D6_B3 = 174;
    public static final int U_CARSET_D61_D6_B4 = 173;
    public static final int U_CARSET_D62_D0_B4 = 180;
    public static final int U_CARSET_D62_D0_B5 = 179;
    public static final int U_CARSET_D62_D0_B76 = 178;
    public static final int U_CARSET_D62_D1_B4 = 181;
    public static final int U_CARSET_D62_D2_B30 = 183;
    public static final int U_CARSET_D62_D2_B74 = 182;
    public static final int U_CARSET_D62_D3_B0 = 191;
    public static final int U_CARSET_D62_D3_B1 = 190;
    public static final int U_CARSET_D62_D3_B2 = 189;
    public static final int U_CARSET_D62_D3_B3 = 188;
    public static final int U_CARSET_D62_D3_B4 = 187;
    public static final int U_CARSET_D62_D3_B5 = 186;
    public static final int U_CARSET_D62_D3_B6 = 185;
    public static final int U_CARSET_D62_D3_B7 = 184;
    public static final int U_CARSET_D62_D4_B5 = 194;
    public static final int U_CARSET_D62_D4_B6 = 193;
    public static final int U_CARSET_D62_D4_B7 = 192;
    public static final int U_CARSET_D62_D7_B6 = 196;
    public static final int U_CARSET_D62_D7_B7 = 195;
    public static final int U_CARSET_ECO_PEDAL = 129;
    public static final int U_CARSET_FIRST_VIEW = 134;
    public static final int U_CARSET_MOVING_OBJECT_DETECTION = 130;
    public static final int U_CARSET_PARKING_RADAR_AUTO = 132;
    public static final int U_CARSET_PARKING_RADAR_SENSOR = 133;
    public static final int U_CARSET_PARKING_TRONT_RADAR = 131;
    public static final int U_CARSET_RADAR_ONOFF = 118;
    public static final int U_CARSET_RESET = 126;
    public static final int U_CARSET_SEATMOVE_AWAY = 128;
    public static final int U_CARSET_SECOND_VIEW = 135;
    public static final int U_CARSET_SIDERADAR = 119;
    public static final int U_CARSET_STEERUP_AWAY = 127;
    public static final int U_CARSET_THIRD_VIEW = 136;
    public static final int U_CARSET_UNLOCK_LIGHT = 121;
    public static final int U_CARSET_UNLOCK_SEL = 124;
    public static final int U_CARSET_UNLOCK_SMARTKEY = 125;
    public static final int U_CARTIRE_VALUE_FL = 137;
    public static final int U_CARTIRE_VALUE_FR = 138;
    public static final int U_CARTIRE_VALUE_RL = 139;
    public static final int U_CARTIRE_VALUE_RR = 140;
    public static final int U_CNT_MAX = 197;
    public static final int U_EQ_DA6_D0 = 145;
    public static final int U_EQ_DA6_D1 = 146;
    public static final int U_EQ_DA6_D2 = 147;
    public static final int U_EQ_DA6_D3 = 148;
    public static final int U_EQ_DA6_D4 = 149;
    public static final int U_EQ_DA6_D5 = 150;
    public static final int U_EQ_DA6_D6_B20 = 153;
    public static final int U_EQ_DA6_D6_B3 = 152;
    public static final int U_EQ_DA6_D6_B4 = 151;
    public static final int U_EQ_DA6_D7 = 154;
    public static final int U_PARK_BTN = 143;
    public static final int U_PARK_CAMERA = 144;
    public static final int U_PARK_PAGE = 142;
    public static final int U_PARK_TXTMSG = 141;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 197; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Infeinidi(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60 /* 4194747 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_20QX60 /* 15204795 */:
                ParkingHelper.getInstance().buildUi(new Parking_YFND_QX60(LauncherApplication.getInstance()));
                DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
                for (int i4 = 141; i4 <= 144; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(ParkingHelper.getInstance(), 0);
                }
                break;
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 141; i2 <= 144; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void showDashBoard(int updateCode, int[] ints) {
        if (updateCode == 156) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 1:
                case 4:
                    if (!WcInfinitCarRadio.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.infeinidi.WcInfinitCarRadio");
                        break;
                    }
                case 2:
                    if (!WcInfinitCarCD.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.infeinidi.WcInfinitCarCD");
                        break;
                    }
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 156:
                showDashBoard(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 197) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
