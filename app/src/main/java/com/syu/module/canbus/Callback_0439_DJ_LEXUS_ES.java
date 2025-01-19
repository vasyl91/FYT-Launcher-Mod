package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.daojun.lexus.djLexusCd;
import com.syu.carinfo.daojun.lexus.djLexusRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_DJ_LEXUS_ES;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_DJ_LEXUS_ES extends CallbackCanbusBase {
    public static final int U_CAR_CD1_STATE = 126;
    public static final int U_CAR_CD2_STATE = 127;
    public static final int U_CAR_CD3_STATE = 128;
    public static final int U_CAR_CD4_STATE = 129;
    public static final int U_CAR_CD5_STATE = 130;
    public static final int U_CAR_CD6_STATE = 131;
    public static final int U_CAR_CD_ASL = 116;
    public static final int U_CAR_CD_BAN = 121;
    public static final int U_CAR_CD_BASS = 117;
    public static final int U_CAR_CD_DISC_RANDOM = 113;
    public static final int U_CAR_CD_DISC_REPEAT = 112;
    public static final int U_CAR_CD_FAD = 120;
    public static final int U_CAR_CD_MID = 118;
    public static final int U_CAR_CD_MIN = 114;
    public static final int U_CAR_CD_NUM = 107;
    public static final int U_CAR_CD_RANDOM = 111;
    public static final int U_CAR_CD_REPEAT = 110;
    public static final int U_CAR_CD_SCAN = 123;
    public static final int U_CAR_CD_SEC = 115;
    public static final int U_CAR_CD_TOTALTRACK = 109;
    public static final int U_CAR_CD_TRACK = 108;
    public static final int U_CAR_CD_TREB = 119;
    public static final int U_CAR_CD_VOL = 122;
    public static final int U_CAR_JUMP_CD = 124;
    public static final int U_CAR_JUMP_RADIO = 125;
    public static final int U_CAR_RADIO_BAND = 98;
    public static final int U_CAR_RADIO_FREQ = 99;
    public static final int U_CAR_RADIO_FREQ1 = 100;
    public static final int U_CAR_RADIO_FREQ2 = 101;
    public static final int U_CAR_RADIO_FREQ3 = 102;
    public static final int U_CAR_RADIO_FREQ4 = 103;
    public static final int U_CAR_RADIO_FREQ5 = 104;
    public static final int U_CAR_RADIO_FREQ6 = 105;
    public static final int U_CAR_RADIO_STATE = 106;
    public static final int U_CNT_MAX = 138;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_DJ_LEXUS_ES(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 138) {
            int value = ints[0];
            switch (updateCode) {
                case 124:
                    if (value == 1 && !djLexusCd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.lexus.djLexusCd");
                        break;
                    }
                case 125:
                    if (value == 1 && !djLexusRadio.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.lexus.djLexusRadio");
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
