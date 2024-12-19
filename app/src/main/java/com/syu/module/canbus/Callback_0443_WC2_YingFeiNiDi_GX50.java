package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.infeinidi.WcInfinitCarCD;
import com.syu.carinfo.wc.infeinidi.WcInfinitCarRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Infeinidi;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_YFND_QX60;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_YingFeiNiDi_GX50 extends CallbackCanbusBase {
    public static final int C_PARKING_KEYDOWN = 1;
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_ADD_AUTO_REAR = 42;
    public static final int U_AIR_ADD_BEGIN = 39;
    public static final int U_AIR_ADD_END = 54;
    public static final int U_AIR_ADD_FOREST = 41;
    public static final int U_AIR_ADD_UP_WIN = 40;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_REAR = 49;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_BODY_REAR = 48;
    public static final int U_AIR_BLOW_BODY_RIGHT = 44;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_REAR = 47;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 43;
    public static final int U_AIR_BLOW_MODE_LEFT = 11;
    public static final int U_AIR_BLOW_MODE_REAR = 50;
    public static final int U_AIR_BLOW_MODE_RIGHT = 46;
    public static final int U_AIR_BLOW_WIN_LEFT = 10;
    public static final int U_AIR_BLOW_WIN_RIGHT = 45;
    public static final int U_AIR_CLIMATE = 53;
    public static final int U_AIR_CYCLE = 4;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_REAR_LOCK = 145;
    public static final int U_AIR_SEAT_HOT_LEFT = 143;
    public static final int U_AIR_SEAT_HOT_RIGHT = 144;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_REAR = 52;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_AIR_WIND_LEVEL_REAR = 51;
    public static final int U_CARAIR_SET_BEGIN = 55;
    public static final int U_CARAIR_SET_DATA5_B30 = 57;
    public static final int U_CARAIR_SET_DATA5_B74 = 56;
    public static final int U_CARAIR_SET_DATA6_B5 = 60;
    public static final int U_CARAIR_SET_DATA6_B6 = 59;
    public static final int U_CARAIR_SET_DATA6_B7 = 58;
    public static final int U_CARAIR_SET_END = 61;
    public static final int U_CARCD_PLAY_TIME = 106;
    public static final int U_CARCD_PLAY_TRACK = 107;
    public static final int U_CARCD_POWER_STATE = 103;
    public static final int U_CARCD_RADIO_FRQ = 105;
    public static final int U_CARCD_TOTAL_TRACK = 108;
    public static final int U_CARCD_TYPE = 104;
    public static final int U_CARINFO_AVG_FUEL = 25;
    public static final int U_CARINFO_AVG_FUEL_HIS1 = 28;
    public static final int U_CARINFO_AVG_FUEL_HIS10 = 37;
    public static final int U_CARINFO_AVG_FUEL_HIS2 = 29;
    public static final int U_CARINFO_AVG_FUEL_HIS3 = 30;
    public static final int U_CARINFO_AVG_FUEL_HIS4 = 31;
    public static final int U_CARINFO_AVG_FUEL_HIS5 = 32;
    public static final int U_CARINFO_AVG_FUEL_HIS6 = 33;
    public static final int U_CARINFO_AVG_FUEL_HIS7 = 34;
    public static final int U_CARINFO_AVG_FUEL_HIS8 = 35;
    public static final int U_CARINFO_AVG_FUEL_HIS9 = 36;
    public static final int U_CARINFO_BEGIN = 23;
    public static final int U_CARINFO_CUR_FUEL = 24;
    public static final int U_CARINFO_DRIVE_ENABLE = 27;
    public static final int U_CARINFO_END = 38;
    public static final int U_CARINFO_TOTAL_MILE = 26;
    public static final int U_CARSET_AUTOLIGHT = 67;
    public static final int U_CARSET_AUTOLIGHT_TIME = 68;
    public static final int U_CARSET_BEGIN = 62;
    public static final int U_CARSET_CENTERRADAR = 65;
    public static final int U_CARSET_D61_D0_B0 = 125;
    public static final int U_CARSET_D61_D4_B0 = 114;
    public static final int U_CARSET_D61_D4_B1 = 113;
    public static final int U_CARSET_D61_D4_B2 = 112;
    public static final int U_CARSET_D61_D4_B43 = 111;
    public static final int U_CARSET_D61_D4_B65 = 110;
    public static final int U_CARSET_D61_D4_B7 = 109;
    public static final int U_CARSET_D61_D5_B10 = 120;
    public static final int U_CARSET_D61_D5_B32 = 119;
    public static final int U_CARSET_D61_D5_B4 = 118;
    public static final int U_CARSET_D61_D5_B5 = 117;
    public static final int U_CARSET_D61_D5_B6 = 116;
    public static final int U_CARSET_D61_D5_B7 = 115;
    public static final int U_CARSET_D61_D6_B10 = 124;
    public static final int U_CARSET_D61_D6_B2 = 123;
    public static final int U_CARSET_D61_D6_B3 = 122;
    public static final int U_CARSET_D61_D6_B4 = 121;
    public static final int U_CARSET_D62_D0_B4 = 128;
    public static final int U_CARSET_D62_D0_B5 = 127;
    public static final int U_CARSET_D62_D0_B76 = 126;
    public static final int U_CARSET_D62_D1_B4 = 129;
    public static final int U_CARSET_D62_D2_B30 = 131;
    public static final int U_CARSET_D62_D2_B74 = 130;
    public static final int U_CARSET_D62_D3_B0 = 139;
    public static final int U_CARSET_D62_D3_B1 = 138;
    public static final int U_CARSET_D62_D3_B2 = 137;
    public static final int U_CARSET_D62_D3_B3 = 136;
    public static final int U_CARSET_D62_D3_B4 = 135;
    public static final int U_CARSET_D62_D3_B5 = 134;
    public static final int U_CARSET_D62_D3_B6 = 133;
    public static final int U_CARSET_D62_D3_B7 = 132;
    public static final int U_CARSET_D62_D4_B5 = 142;
    public static final int U_CARSET_D62_D4_B6 = 141;
    public static final int U_CARSET_D62_D4_B7 = 140;
    public static final int U_CARSET_ECO_PEDAL = 74;
    public static final int U_CARSET_END = 82;
    public static final int U_CARSET_FIRST_VIEW = 79;
    public static final int U_CARSET_MOVING_OBJECT_DETECTION = 75;
    public static final int U_CARSET_PARKING_RADAR_AUTO = 77;
    public static final int U_CARSET_PARKING_RADAR_SENSOR = 78;
    public static final int U_CARSET_PARKING_TRONT_RADAR = 76;
    public static final int U_CARSET_RADAR_ONOFF = 63;
    public static final int U_CARSET_RESET = 71;
    public static final int U_CARSET_SEATMOVE_AWAY = 73;
    public static final int U_CARSET_SECOND_VIEW = 80;
    public static final int U_CARSET_SIDERADAR = 64;
    public static final int U_CARSET_STEERUP_AWAY = 72;
    public static final int U_CARSET_THIRD_VIEW = 81;
    public static final int U_CARSET_UNLOCK_LIGHT = 66;
    public static final int U_CARSET_UNLOCK_SEL = 69;
    public static final int U_CARSET_UNLOCK_SMARTKEY = 70;
    public static final int U_CARTIRE_BEGIN = 83;
    public static final int U_CARTIRE_END = 88;
    public static final int U_CARTIRE_VALUE_FL = 84;
    public static final int U_CARTIRE_VALUE_FR = 85;
    public static final int U_CARTIRE_VALUE_RL = 86;
    public static final int U_CARTIRE_VALUE_RR = 87;
    public static final int U_CNT_MAX = 146;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;
    public static final int U_EQ_DA6_D0 = 93;
    public static final int U_EQ_DA6_D1 = 94;
    public static final int U_EQ_DA6_D2 = 95;
    public static final int U_EQ_DA6_D3 = 96;
    public static final int U_EQ_DA6_D4 = 97;
    public static final int U_EQ_DA6_D5 = 98;
    public static final int U_EQ_DA6_D6_B20 = 101;
    public static final int U_EQ_DA6_D6_B3 = 100;
    public static final int U_EQ_DA6_D6_B4 = 99;
    public static final int U_EQ_DA6_D7 = 102;
    public static final int U_PARK_BTN = 91;
    public static final int U_PARK_CAMERA = 92;
    public static final int U_PARK_PAGE = 90;
    public static final int U_PARK_TXTMSG = 89;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 16; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Infeinidi(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 15; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i4 = 39; i4 < 54; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60 /* 4194747 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14QX60_SP /* 4260283 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l /* 4325819 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_16Q50l_SP /* 5308859 */:
            case FinalCanbus.CAR_443_WC2_YingFeiNiDi_14Q50_L /* 8651195 */:
                ParkingHelper.getInstance().buildUi(new Parking_YFND_QX60(LauncherApplication.getInstance()));
                DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
                for (int i5 = 89; i5 <= 92; i5++) {
                    DataCanbus.NOTIFY_EVENTS[i5].addNotify(ParkingHelper.getInstance(), 0);
                }
                break;
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 89; i2 <= 92; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
        for (int i3 = 0; i3 < 15; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i4 = 39; i4 < 54; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void showDashBoard(int updateCode, int[] ints) {
        if (updateCode == 104) {
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 104:
                showDashBoard(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 146) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
