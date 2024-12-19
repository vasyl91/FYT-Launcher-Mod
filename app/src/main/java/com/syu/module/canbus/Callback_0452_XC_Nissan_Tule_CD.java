package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xinchi_Nissan_Tule_CD;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_XC_Nissan_Tule_CD extends CallbackCanbusBase {
    public static final int U_CARCD_PLAYSTATE = 110;
    public static final int U_CARCD_PLAY_TIME = 113;
    public static final int U_CARCD_PLAY_TRACK = 115;
    public static final int U_CARCD_RANDOM = 111;
    public static final int U_CARCD_REPEAT = 112;
    public static final int U_CARCD_TOTAL_TIME = 114;
    public static final int U_CARCD_TOTAL_TRACK = 116;
    public static final int U_CAREQ_BAL = 131;
    public static final int U_CAREQ_BASS = 129;
    public static final int U_CAREQ_BOSS_CENTERPOINT = 134;
    public static final int U_CAREQ_DRIVER = 136;
    public static final int U_CAREQ_FAD = 132;
    public static final int U_CAREQ_SPEED_VOL = 133;
    public static final int U_CAREQ_SURROUND = 135;
    public static final int U_CAREQ_TRE = 130;
    public static final int U_CAREQ_VOL = 128;
    public static final int U_CARINFO_AVG_OIL = 98;
    public static final int U_CARINFO_MILE = 97;
    public static final int U_CARINFO_TOTAL_MILE = 96;
    public static final int U_CARRADIO_BAND = 101;
    public static final int U_CARRADIO_CUR_CH = 103;
    public static final int U_CARRADIO_CUR_FRQ = 102;
    public static final int U_CARRADIO_FRQ1 = 104;
    public static final int U_CARRADIO_FRQ2 = 105;
    public static final int U_CARRADIO_FRQ3 = 106;
    public static final int U_CARRADIO_FRQ4 = 107;
    public static final int U_CARRADIO_FRQ5 = 108;
    public static final int U_CARRADIO_FRQ6 = 109;
    public static final int U_CARRADIO_SCAN = 100;
    public static final int U_CARSET_D6C_D0_B70 = 118;
    public static final int U_CARSET_D6C_D1_B70 = 119;
    public static final int U_CARSET_D6C_D2_B70 = 120;
    public static final int U_CARSET_D6D_D0_B0 = 125;
    public static final int U_CARSET_D6D_D0_B1 = 124;
    public static final int U_CARSET_D6D_D0_B2 = 123;
    public static final int U_CARSET_D6D_D0_B3 = 122;
    public static final int U_CARSET_D6D_D0_B4 = 121;
    public static final int U_CARSET_D6D_D1_B70 = 126;
    public static final int U_CARSET_D6D_D2_B70 = 127;
    public static final int U_CARSET_D70_D0_B70 = 150;
    public static final int U_CARSET_D70_D1_B70 = 151;
    public static final int U_CARSET_D70_D2_B70 = 152;
    public static final int U_CARSET_D70_D3_B70 = 153;
    public static final int U_CARSET_D70_D4_B70 = 154;
    public static final int U_CARSET_D71_D0_B0 = 160;
    public static final int U_CARSET_D71_D0_B1 = 159;
    public static final int U_CARSET_D71_D0_B2 = 158;
    public static final int U_CARSET_D71_D0_B3 = 157;
    public static final int U_CARSET_D71_D0_B4 = 156;
    public static final int U_CARSET_D71_D0_B5 = 155;
    public static final int U_CAR_REAR_D72_D0_B0 = 141;
    public static final int U_CAR_REAR_D72_D0_B1 = 140;
    public static final int U_CAR_REAR_D72_D0_B32 = 139;
    public static final int U_CAR_REAR_D72_D0_B54 = 138;
    public static final int U_CAR_REAR_D72_D0_B76 = 137;
    public static final int U_CAR_REAR_D72_D1_B6 = 143;
    public static final int U_CAR_REAR_D72_D1_B7 = 142;
    public static final int U_CAR_REAR_D73_ALBUM = 149;
    public static final int U_CAR_REAR_D73_ARTIST = 148;
    public static final int U_CAR_REAR_D73_D0_B65 = 145;
    public static final int U_CAR_REAR_D73_D0_B7 = 144;
    public static final int U_CAR_REAR_D73_PLAYTIME = 146;
    public static final int U_CAR_REAR_D73_TITLE = 147;
    public static final int U_CAR_SOURCE_ID = 117;
    public static final int U_CAR_TIRE_BEGIN = 86;
    public static final int U_CAR_TIRE_END = 95;
    public static final int U_CAR_TIRE_VALUE_FL = 87;
    public static final int U_CAR_TIRE_VALUE_FR = 88;
    public static final int U_CAR_TIRE_VALUE_RL = 89;
    public static final int U_CAR_TIRE_VALUE_RR = 90;
    public static final int U_CAR_TIRE_WARN_FL = 91;
    public static final int U_CAR_TIRE_WARN_FR = 92;
    public static final int U_CAR_TIRE_WARN_RL = 93;
    public static final int U_CAR_TIRE_WARN_RR = 94;
    public static final int U_CNT_MAX = 161;
    public static final int U_CUR_MOTOR_SPEED = 99;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 161; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_Xinchi_Nissan_Tule_CD(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 161) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
