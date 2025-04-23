package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.hava.ActivityHavaH7CarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0244_RZC_XP1_HavalH2 extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String Title = null;
    public static final int U_CAREQ_BAL = 140;
    public static final int U_CAREQ_BASS = 139;
    public static final int U_CAREQ_FAD = 141;
    public static final int U_CAREQ_MID = 138;
    public static final int U_CAREQ_SPEED_VOL = 143;
    public static final int U_CAREQ_SURROUND_VOL = 142;
    public static final int U_CAREQ_TREB = 137;
    public static final int U_CAREQ_VOL = 136;
    public static final int U_CARINFO_ALL_TERRAIN = 116;
    public static final int U_CARINFO_ALS = 106;
    public static final int U_CARINFO_ANTITHEFT = 112;
    public static final int U_CARINFO_AUTO_BRAKE = 118;
    public static final int U_CARINFO_BATTERY_VOLGATE = 99;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CARTOP = 115;
    public static final int U_CARINFO_COLLISION_WARN = 117;
    public static final int U_CARINFO_COOLANT_TEMP = 100;
    public static final int U_CARINFO_D29_D03_B70 = 159;
    public static final int U_CARINFO_D31_D03_B02 = 123;
    public static final int U_CARINFO_D31_D04_B00 = 130;
    public static final int U_CARINFO_D31_D04_B01 = 129;
    public static final int U_CARINFO_D31_D04_B02 = 128;
    public static final int U_CARINFO_D31_D04_B03 = 127;
    public static final int U_CARINFO_D31_D04_B06 = 125;
    public static final int U_CARINFO_D31_D04_B07 = 124;
    public static final int U_CARINFO_D31_D04_B54 = 126;
    public static final int U_CARINFO_D31_D05_B03 = 135;
    public static final int U_CARINFO_D31_D05_B04 = 134;
    public static final int U_CARINFO_D31_D05_B05 = 133;
    public static final int U_CARINFO_D31_D05_B06 = 132;
    public static final int U_CARINFO_D31_D05_B07 = 131;
    public static final int U_CARINFO_D31_D05_B20 = 165;
    public static final int U_CARINFO_D31_D07_B32 = 167;
    public static final int U_CARINFO_D31_D07_B7 = 166;
    public static final int U_CARINFO_D31_D08_B10 = 170;
    public static final int U_CARINFO_D31_D08_B32 = 169;
    public static final int U_CARINFO_D31_D08_B7 = 168;
    public static final int U_CARINFO_D31_D09_B03 = 158;
    public static final int U_CARINFO_D31_D09_B4 = 163;
    public static final int U_CARINFO_D31_D09_B5 = 162;
    public static final int U_CARINFO_D31_D09_B6 = 161;
    public static final int U_CARINFO_D31_D09_B7 = 160;
    public static final int U_CARINFO_DOMEDELAY = 102;
    public static final int U_CARINFO_DOORCTRL = 113;
    public static final int U_CARINFO_END = 121;
    public static final int U_CARINFO_FOLLOWHOME = 103;
    public static final int U_CARINFO_FRONT_LIGHT = 109;
    public static final int U_CARINFO_INTELLIGENT_START_STOP = 119;
    public static final int U_CARINFO_NEWADD = 122;
    public static final int U_CARINFO_PARKING = 111;
    public static final int U_CARINFO_POWERSAVE = 104;
    public static final int U_CARINFO_RAINFALLSENSOR = 105;
    public static final int U_CARINFO_REARVIEW_ATUO = 108;
    public static final int U_CARINFO_SEAT_REM = 110;
    public static final int U_CARINFO_SIDESTEP = 114;
    public static final int U_CARINFO_TRAILER = 120;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 101;
    public static final int U_CAR_AMP_ONOFF = 156;
    public static final int U_CAR_AMP_T = 145;
    public static final int U_CAR_AMP_V = 144;
    public static final int U_CAR_CD_ALBUM = 154;
    public static final int U_CAR_CD_ARTIST = 155;
    public static final int U_CAR_CD_ONOFF = 157;
    public static final int U_CAR_CD_PALYTIME = 152;
    public static final int U_CAR_CD_PLAYSTATE = 147;
    public static final int U_CAR_CD_STATE = 146;
    public static final int U_CAR_CD_TIME_TOTAL = 151;
    public static final int U_CAR_CD_TITLE = 153;
    public static final int U_CAR_CD_TRACK = 150;
    public static final int U_CAR_CD_TRACK_CNT = 149;
    public static final int U_CAR_CD_WORKSTATE = 148;
    public static final int U_CNT_MAX = 171;
    public static final int U_SCREEN_BRIGHT_ADJUST = 107;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 164;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 171; i++) {
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
        if (DataCanbus.DATA[1000] == 262388 || DataCanbus.DATA[1000] == 244 || DataCanbus.DATA[1000] == 327924) {
            //AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_LanBiao(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 393460 || DataCanbus.DATA[1000] == 721140) {
            //AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2S_HongBiao(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_HongBiao(LauncherApplication.getInstance()));
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 171) {
            switch (updateCode) {
                case 146:
                    if (DataCanbus.DATA[updateCode] == 1 && !ActivityHavaH7CarCD.mIsFront) {
                        //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hava.ActivityHavaH7CarCD");
                        break;
                    }
                case 153:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 154:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 155:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 171) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
