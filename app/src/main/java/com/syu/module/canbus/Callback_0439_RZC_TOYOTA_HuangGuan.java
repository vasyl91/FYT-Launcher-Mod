package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_TOYOTA_HuangGuan extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int C_CMD_BUTTON = 0;
    public static final int C_CMD_KEY = 2;
    public static final int C_CMD_REQUEST = 1;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 106;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 111;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 110;
    public static final int U_CARINFO_DVD_ID = 105;
    public static final int U_CARINFO_DVD_PLAYTIME = 112;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 109;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 108;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 107;
    public static final int U_CARINFO_END = 113;
    public static final int U_CARINFO_RADIO_BAND = 99;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 101;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 103;
    public static final int U_CARINFO_RADIO_FREQ = 100;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 102;
    public static final int U_CARINFO_SOURCE = 98;
    public static final int U_CNT_MAX = 114;
    boolean jump = false;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 114; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_Toyato(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (updateCode == 80) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !rzc_439_Huangguan_AirControlAct.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct");
                this.jump = true;
                return;
            }
            this.jump = false;
            if (rzc_439_Huangguan_AirControlAct.mIsFront && this.jump && rzc_439_Huangguan_AirControlAct.mInstance != null) {
                rzc_439_Huangguan_AirControlAct.mInstance.finish();
            }
        }
    }

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 98) {
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
        if (updateCode >= 0) {
            if (updateCode == 103) {
                CHANNEL_FREQ_PRESET = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
            } else if (updateCode == 80) {
                showCotrolAir(updateCode, ints);
            } else if (updateCode == 98) {
                showCotrolCD(updateCode, ints);
            } else {
                HandlerCanbus.update(updateCode, ints);
            }
        }
    }
}
