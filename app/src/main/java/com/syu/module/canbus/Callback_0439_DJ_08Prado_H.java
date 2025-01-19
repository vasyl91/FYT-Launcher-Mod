package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0439_DJ_08Prado_H extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_JUMP_EQ = 2;
    public static final int CMD_SET_CTRL = 1;
    public static final int CMD_SET_CTRL2 = 3;
    public static final int CMD_SET_CTRL3 = 4;
    public static final int CMD_SET_CTRL4 = 5;
    public static final int U_CAR_CD1_STATE = 117;
    public static final int U_CAR_CD2_STATE = 118;
    public static final int U_CAR_CD3_STATE = 119;
    public static final int U_CAR_CD4_STATE = 120;
    public static final int U_CAR_CD5_STATE = 121;
    public static final int U_CAR_CD6_STATE = 122;
    public static final int U_CAR_CD_ASL = 116;
    public static final int U_CAR_CD_DISC_RANDOM = 113;
    public static final int U_CAR_CD_DISC_REPEAT = 112;
    public static final int U_CAR_CD_MIN = 114;
    public static final int U_CAR_CD_NUM = 107;
    public static final int U_CAR_CD_RANDOM = 111;
    public static final int U_CAR_CD_REPEAT = 110;
    public static final int U_CAR_CD_SCAN = 123;
    public static final int U_CAR_CD_SEC = 115;
    public static final int U_CAR_CD_TOTALTRACK = 109;
    public static final int U_CAR_CD_TRACK = 108;
    public static final int U_CAR_RADIO_BAND = 98;
    public static final int U_CAR_RADIO_FREQ = 99;
    public static final int U_CAR_RADIO_FREQ1 = 100;
    public static final int U_CAR_RADIO_FREQ2 = 101;
    public static final int U_CAR_RADIO_FREQ3 = 102;
    public static final int U_CAR_RADIO_FREQ4 = 103;
    public static final int U_CAR_RADIO_FREQ5 = 104;
    public static final int U_CAR_RADIO_FREQ6 = 105;
    public static final int U_CAR_RADIO_STATE = 106;
    public static final int U_CAR_SET_INFO1 = 125;
    public static final int U_CAR_SET_INFO2 = 126;
    public static final int U_CAR_VOL = 124;
    public static final int U_CNT_MAX = 127;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
