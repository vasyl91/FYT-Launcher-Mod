package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0420_WC2_ToYoTa_10_Crown extends CallbackCanbusBase {
    public static final int U_CAREQ_D87_D0_B70 = 127;
    public static final int U_CAREQ_D87_D1_B70 = 128;
    public static final int U_CAREQ_D87_D2_B70 = 129;
    public static final int U_CAREQ_D87_D3_B70 = 130;
    public static final int U_CAREQ_D87_D4_B70 = 131;
    public static final int U_CAREQ_D87_D5_B70 = 132;
    public static final int U_CARINF_D13_D0_D1 = 133;
    public static final int U_CARINF_D13_D10_B70 = 138;
    public static final int U_CARINF_D13_D11_B70 = 139;
    public static final int U_CARINF_D13_D14_D15 = 140;
    public static final int U_CARINF_D13_D2_D3 = 134;
    public static final int U_CARINF_D13_D4_D5 = 135;
    public static final int U_CARINF_D13_D6_D7 = 136;
    public static final int U_CARINF_D13_D8_D9 = 137;
    public static final int U_CDC_BEGIN = 116;
    public static final int U_CDC_END = 126;
    public static final int U_CD_CURRENT_DISC_TRACK = 119;
    public static final int U_CD_CURRENT_TIME = 120;
    public static final int U_CD_DISC_STATE = 117;
    public static final int U_CD_DISC_TYPE = 118;
    public static final int U_CD_DISC_WORK_STATE = 121;
    public static final int U_CD_STATE = 122;
    public static final int U_CNT_MAX = 141;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_RADIO_AM_ST_STATE = 104;
    public static final int U_RADIO_BAND = 101;
    public static final int U_RADIO_BEGIN = 100;
    public static final int U_RADIO_CURRENT_FREQ = 102;
    public static final int U_RADIO_END = 115;
    public static final int U_RADIO_PRE_BAND = 106;
    public static final int U_RADIO_PRE_CHANNEL_FREQ = 107;
    public static final int U_RADIO_PRE_SAVE_CHANNEL = 103;
    public static final int U_RADIO_TUNER_STATE = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 141; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0420_WC2_10_crown(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 141) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
