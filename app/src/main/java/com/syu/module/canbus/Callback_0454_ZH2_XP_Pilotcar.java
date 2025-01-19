package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0454_ZH2_XP_Pilotcar extends CallbackCanbusBase {
    public static final int U_CARINF_D41_T1_D1_B30 = 99;
    public static final int U_CARINF_D41_T1_D1_B6 = 120;
    public static final int U_CARINF_D41_T1_D1_B7 = 98;
    public static final int U_CARINF_D41_T1_D2_B4 = 103;
    public static final int U_CARINF_D41_T1_D2_B5 = 102;
    public static final int U_CARINF_D41_T1_D2_B6 = 101;
    public static final int U_CARINF_D41_T1_D2_B7 = 100;
    public static final int U_CARINF_D41_T1_D3_B1 = 110;
    public static final int U_CARINF_D41_T1_D3_B2 = 109;
    public static final int U_CARINF_D41_T1_D3_B3 = 108;
    public static final int U_CARINF_D41_T1_D3_B4 = 107;
    public static final int U_CARINF_D41_T1_D3_B5 = 106;
    public static final int U_CARINF_D41_T1_D3_B6 = 105;
    public static final int U_CARINF_D41_T1_D3_B7 = 104;
    public static final int U_CARINF_D41_T2_D1_D3 = 111;
    public static final int U_CARINF_D41_T2_D4_D5 = 112;
    public static final int U_CARINF_D41_T2_D6_D7 = 113;
    public static final int U_CARINF_D41_T2_D8_B70 = 114;
    public static final int U_CARINF_D41_T3_D1_B70 = 115;
    public static final int U_CARINF_D41_T3_D2_B70 = 116;
    public static final int U_CARINF_D41_T3_D3_D4 = 117;
    public static final int U_CARINF_D41_T3_D5_B70 = 118;
    public static final int U_CARINF_D41_T3_D6_D7 = 119;
    public static final int U_CARINF_D41_T4_D1_D2 = 121;
    public static final int U_CARINF_D41_T4_D3_D4 = 122;
    public static final int U_CARINF_D41_T4_D5_D6 = 123;
    public static final int U_CARINF_D41_T4_D7_B70 = 124;
    public static final int U_CARINF_D41_T4_D8_B70 = 125;
    public static final int U_CARINF_DAY_HOUR = 127;
    public static final int U_CARINF_DAY_MIN = 128;
    public static final int U_CARINF_TRIP_VALUE = 126;
    public static final int U_CNT_MAX = 129;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
