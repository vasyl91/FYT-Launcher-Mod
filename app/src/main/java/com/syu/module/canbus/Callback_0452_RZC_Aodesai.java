package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_RZC_Honda_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_RZC_Aodesai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 49;
    public static final int U_AIR_AUTO = 45;
    public static final int U_AIR_BACK_AUTO = 67;
    public static final int U_AIR_BACK_BODY = 64;
    public static final int U_AIR_BACK_FOOT = 65;
    public static final int U_AIR_BACK_TEMP = 62;
    public static final int U_AIR_BACK_UP = 63;
    public static final int U_AIR_BACK_WIND = 66;
    public static final int U_AIR_BEGIN = 44;
    public static final int U_AIR_BLOW_BODY_LEFT = 51;
    public static final int U_AIR_BLOW_BODY_RIGHT = 69;
    public static final int U_AIR_BLOW_FOOT_LEFT = 52;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 70;
    public static final int U_AIR_BLOW_UP_LEFT = 53;
    public static final int U_AIR_BLOW_UP_RIGHT = 68;
    public static final int U_AIR_CLIMATE = 60;
    public static final int U_AIR_CYCLE = 46;
    public static final int U_AIR_DUAL = 55;
    public static final int U_AIR_END = 75;
    public static final int U_AIR_FRONT_DEFROST = 47;
    public static final int U_AIR_POWER = 57;
    public static final int U_AIR_REAR_DEFROST = 48;
    public static final int U_AIR_REAR_LOCK = 59;
    public static final int U_AIR_SEAT_COLD_LEFT = 71;
    public static final int U_AIR_SEAT_COLD_RIGHT = 73;
    public static final int U_AIR_SEAT_HEAT_LEFT = 72;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 74;
    public static final int U_AIR_SYNC = 61;
    public static final int U_AIR_TEMP_LEFT = 50;
    public static final int U_AIR_TEMP_RIGHT = 56;
    public static final int U_AIR_TEMP_UNIT = 58;
    public static final int U_AIR_WIND_LEVEL_LEFT = 54;
    public static final int U_CARRADIO_AM_FREQ1 = 25;
    public static final int U_CARRADIO_AM_FREQ2 = 26;
    public static final int U_CARRADIO_AM_FREQ3 = 17;
    public static final int U_CARRADIO_AM_FREQ4 = 18;
    public static final int U_CARRADIO_AM_FREQ5 = 19;
    public static final int U_CARRADIO_AM_FREQ6 = 20;
    public static final int U_CARRADIO_BAND = 8;
    public static final int U_CARRADIO_BEGIN = 7;
    public static final int U_CARRADIO_CHNNEL = 11;
    public static final int U_CARRADIO_CUR_FREQ = 12;
    public static final int U_CARRADIO_FM_FREQ1 = 13;
    public static final int U_CARRADIO_FM_FREQ10 = 22;
    public static final int U_CARRADIO_FM_FREQ11 = 23;
    public static final int U_CARRADIO_FM_FREQ12 = 24;
    public static final int U_CARRADIO_FM_FREQ2 = 14;
    public static final int U_CARRADIO_FM_FREQ3 = 15;
    public static final int U_CARRADIO_FM_FREQ4 = 16;
    public static final int U_CARRADIO_FM_FREQ5 = 17;
    public static final int U_CARRADIO_FM_FREQ6 = 18;
    public static final int U_CARRADIO_FM_FREQ7 = 19;
    public static final int U_CARRADIO_FM_FREQ8 = 20;
    public static final int U_CARRADIO_FM_FREQ9 = 21;
    public static final int U_CARRADIO_SCAN = 10;
    public static final int U_CARRADIO_ST = 9;
    public static final int U_CNT_MAX = 85;
    public static final int U_INFO_BEGIN = 21;
    public static final int U_INFO_CAR_CD1_STATE = 38;
    public static final int U_INFO_CAR_CD2_STATE = 39;
    public static final int U_INFO_CAR_CD3_STATE = 40;
    public static final int U_INFO_CAR_CD4_STATE = 41;
    public static final int U_INFO_CAR_CD5_STATE = 42;
    public static final int U_INFO_CAR_CD6_STATE = 43;
    public static final int U_INFO_CAR_CD_M = 35;
    public static final int U_INFO_CAR_CD_NUM = 37;
    public static final int U_INFO_CAR_CD_PLAY = 34;
    public static final int U_INFO_CAR_CD_S = 36;
    public static final int U_INFO_CAR_CD_STATE = 32;
    public static final int U_INFO_CAR_CD_TRACK = 33;
    public static final int U_INFO_CAR_DISC_STATE = 81;
    public static final int U_INFO_CAR_SOUND_CHANNEL = 31;
    public static final int U_INFO_CAR_TIME_AMPM = 28;
    public static final int U_INFO_CAR_TIME_FORMAT = 27;
    public static final int U_INFO_CAR_TIME_HOUR = 29;
    public static final int U_INFO_CAR_TIME_MINTUS = 30;
    public static final int U_INFO_CAR_USB_FILE_NUM = 76;
    public static final int U_INFO_CAR_USB_M = 79;
    public static final int U_INFO_CAR_USB_PLAY_STATE = 78;
    public static final int U_INFO_CAR_USB_S = 80;
    public static final int U_INFO_CAR_USB_STATE = 82;
    public static final int U_INFO_CAR_USB_TRACK = 77;
    public static final int U_INFO_CAR_VOL = 26;
    public static final int U_INFO_CAR_VOL_SHOW = 25;
    public static final int U_INFO_CONTENT = 24;
    public static final int U_INFO_HILIGHT = 23;
    public static final int U_INFO_TIME_HOUR = 83;
    public static final int U_INFO_TIME_MIN = 84;
    public static final int U_INFO_TITLE = 22;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 85; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_RZC_Honda_All(LauncherApplication.getInstance()));
        for (int i3 = 44; i3 < 75; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 32) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 44; i2 < 75; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 85) {
            switch (updateCode) {
                case 24:
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                    break;
                case 32:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
