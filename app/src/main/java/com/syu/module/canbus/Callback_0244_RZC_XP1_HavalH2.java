package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.hava.ActivityHavaH7CarCD;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0244_RZC_HavaH2S_HongBiao;
import com.syu.ui.air.Air_0244_RZC_HavaH2_HongBiao;
import com.syu.ui.air.Air_0244_RZC_HavaH2_LanBiao;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0244_RZC_XP1_HavalH2 extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String Title = null;
    public static final int U_CAREQ_BAL = 128;
    public static final int U_CAREQ_BASS = 127;
    public static final int U_CAREQ_FAD = 129;
    public static final int U_CAREQ_MID = 126;
    public static final int U_CAREQ_SPEED_VOL = 131;
    public static final int U_CAREQ_SURROUND_VOL = 130;
    public static final int U_CAREQ_TREB = 125;
    public static final int U_CAREQ_VOL = 124;
    public static final int U_CARINFO_ALL_TERRAIN = 104;
    public static final int U_CARINFO_ALS = 94;
    public static final int U_CARINFO_ANTITHEFT = 100;
    public static final int U_CARINFO_AUTO_BRAKE = 106;
    public static final int U_CARINFO_BATTERY_VOLGATE = 87;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_CARTOP = 103;
    public static final int U_CARINFO_COLLISION_WARN = 105;
    public static final int U_CARINFO_COOLANT_TEMP = 88;
    public static final int U_CARINFO_D29_D03_B70 = 147;
    public static final int U_CARINFO_D31_D03_B02 = 111;
    public static final int U_CARINFO_D31_D04_B00 = 118;
    public static final int U_CARINFO_D31_D04_B01 = 117;
    public static final int U_CARINFO_D31_D04_B02 = 116;
    public static final int U_CARINFO_D31_D04_B03 = 115;
    public static final int U_CARINFO_D31_D04_B06 = 113;
    public static final int U_CARINFO_D31_D04_B07 = 112;
    public static final int U_CARINFO_D31_D04_B54 = 114;
    public static final int U_CARINFO_D31_D05_B03 = 123;
    public static final int U_CARINFO_D31_D05_B04 = 122;
    public static final int U_CARINFO_D31_D05_B05 = 121;
    public static final int U_CARINFO_D31_D05_B06 = 120;
    public static final int U_CARINFO_D31_D05_B07 = 119;
    public static final int U_CARINFO_D31_D05_B20 = 153;
    public static final int U_CARINFO_D31_D07_B32 = 155;
    public static final int U_CARINFO_D31_D07_B7 = 154;
    public static final int U_CARINFO_D31_D08_B10 = 158;
    public static final int U_CARINFO_D31_D08_B32 = 157;
    public static final int U_CARINFO_D31_D08_B7 = 156;
    public static final int U_CARINFO_D31_D09_B03 = 146;
    public static final int U_CARINFO_D31_D09_B4 = 151;
    public static final int U_CARINFO_D31_D09_B5 = 150;
    public static final int U_CARINFO_D31_D09_B6 = 149;
    public static final int U_CARINFO_D31_D09_B7 = 148;
    public static final int U_CARINFO_DOMEDELAY = 90;
    public static final int U_CARINFO_DOORCTRL = 101;
    public static final int U_CARINFO_END = 109;
    public static final int U_CARINFO_FOLLOWHOME = 91;
    public static final int U_CARINFO_FRONT_LIGHT = 97;
    public static final int U_CARINFO_INTELLIGENT_START_STOP = 107;
    public static final int U_CARINFO_NEWADD = 110;
    public static final int U_CARINFO_PARKING = 99;
    public static final int U_CARINFO_POWERSAVE = 92;
    public static final int U_CARINFO_RAINFALLSENSOR = 93;
    public static final int U_CARINFO_REARVIEW_ATUO = 96;
    public static final int U_CARINFO_SEAT_REM = 98;
    public static final int U_CARINFO_SIDESTEP = 102;
    public static final int U_CARINFO_TRAILER = 108;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 89;
    public static final int U_CAR_AMP_ONOFF = 144;
    public static final int U_CAR_AMP_T = 133;
    public static final int U_CAR_AMP_V = 132;
    public static final int U_CAR_CD_ALBUM = 142;
    public static final int U_CAR_CD_ARTIST = 143;
    public static final int U_CAR_CD_ONOFF = 145;
    public static final int U_CAR_CD_PALYTIME = 140;
    public static final int U_CAR_CD_PLAYSTATE = 135;
    public static final int U_CAR_CD_STATE = 134;
    public static final int U_CAR_CD_TIME_TOTAL = 139;
    public static final int U_CAR_CD_TITLE = 141;
    public static final int U_CAR_CD_TRACK = 138;
    public static final int U_CAR_CD_TRACK_CNT = 137;
    public static final int U_CAR_CD_WORKSTATE = 136;
    public static final int U_CNT_MAX = 159;
    public static final int U_SCREEN_BRIGHT_ADJUST = 95;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 152;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 159; i++) {
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
        if (DataCanbus.DATA[1000] == 262388 || DataCanbus.DATA[1000] == 244 || DataCanbus.DATA[1000] == 327924) {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_LanBiao(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 393460 || DataCanbus.DATA[1000] == 721140) {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2S_HongBiao(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0244_RZC_HavaH2_HongBiao(LauncherApplication.getInstance()));
        }
        for (int i4 = 10; i4 < 85; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 159) {
            switch (updateCode) {
                case 134:
                    if (DataCanbus.DATA[updateCode] == 1 && !ActivityHavaH7CarCD.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hava.ActivityHavaH7CarCD");
                        break;
                    }
                case 141:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 142:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 143:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 159) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
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
