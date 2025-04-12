package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_RZC_Aodesai extends CallbackCanbusBase {
    public static final int U_CARRADIO_AM_FREQ1 = 116;
    public static final int U_CARRADIO_AM_FREQ2 = 117;
    public static final int U_CARRADIO_AM_FREQ3 = 108;
    public static final int U_CARRADIO_AM_FREQ4 = 109;
    public static final int U_CARRADIO_AM_FREQ5 = 110;
    public static final int U_CARRADIO_AM_FREQ6 = 111;
    public static final int U_CARRADIO_BAND = 99;
    public static final int U_CARRADIO_BEGIN = 98;
    public static final int U_CARRADIO_CHNNEL = 102;
    public static final int U_CARRADIO_CUR_FREQ = 103;
    public static final int U_CARRADIO_FM_FREQ1 = 104;
    public static final int U_CARRADIO_FM_FREQ10 = 113;
    public static final int U_CARRADIO_FM_FREQ11 = 114;
    public static final int U_CARRADIO_FM_FREQ12 = 115;
    public static final int U_CARRADIO_FM_FREQ2 = 105;
    public static final int U_CARRADIO_FM_FREQ3 = 106;
    public static final int U_CARRADIO_FM_FREQ4 = 107;
    public static final int U_CARRADIO_FM_FREQ5 = 108;
    public static final int U_CARRADIO_FM_FREQ6 = 109;
    public static final int U_CARRADIO_FM_FREQ7 = 110;
    public static final int U_CARRADIO_FM_FREQ8 = 111;
    public static final int U_CARRADIO_FM_FREQ9 = 112;
    public static final int U_CARRADIO_SCAN = 101;
    public static final int U_CARRADIO_ST = 100;
    public static final int U_CNT_MAX = 144;
    public static final int U_INFO_BEGIN = 112;
    public static final int U_INFO_CAR_CD1_STATE = 129;
    public static final int U_INFO_CAR_CD2_STATE = 130;
    public static final int U_INFO_CAR_CD3_STATE = 131;
    public static final int U_INFO_CAR_CD4_STATE = 132;
    public static final int U_INFO_CAR_CD5_STATE = 133;
    public static final int U_INFO_CAR_CD6_STATE = 134;
    public static final int U_INFO_CAR_CD_M = 126;
    public static final int U_INFO_CAR_CD_NUM = 128;
    public static final int U_INFO_CAR_CD_PLAY = 125;
    public static final int U_INFO_CAR_CD_S = 127;
    public static final int U_INFO_CAR_CD_STATE = 123;
    public static final int U_INFO_CAR_CD_TRACK = 124;
    public static final int U_INFO_CAR_DISC_STATE = 140;
    public static final int U_INFO_CAR_SOUND_CHANNEL = 122;
    public static final int U_INFO_CAR_TIME_AMPM = 119;
    public static final int U_INFO_CAR_TIME_FORMAT = 118;
    public static final int U_INFO_CAR_TIME_HOUR = 120;
    public static final int U_INFO_CAR_TIME_MINTUS = 121;
    public static final int U_INFO_CAR_USB_FILE_NUM = 135;
    public static final int U_INFO_CAR_USB_M = 138;
    public static final int U_INFO_CAR_USB_PLAY_STATE = 137;
    public static final int U_INFO_CAR_USB_S = 139;
    public static final int U_INFO_CAR_USB_STATE = 141;
    public static final int U_INFO_CAR_USB_TRACK = 136;
    public static final int U_INFO_CAR_VOL = 117;
    public static final int U_INFO_CAR_VOL_SHOW = 116;
    public static final int U_INFO_CONTENT = 115;
    public static final int U_INFO_HILIGHT = 114;
    public static final int U_INFO_TIME_HOUR = 142;
    public static final int U_INFO_TIME_MIN = 143;
    public static final int U_INFO_TITLE = 113;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_RZC_Honda_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 144) {
            switch (updateCode) {
                case 115:
                    HandlerCanbus.update(updateCode, ints, flts, strs);
                    break;
                case 123:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
