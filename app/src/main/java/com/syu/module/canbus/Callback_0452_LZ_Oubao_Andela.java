package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_LZ_Oubao_Andela;

public class Callback_0452_LZ_Oubao_Andela extends CallbackCanbusBase {
    public static String D07Title = null;
    public static String D0BTitle = null;
    public static final int U_CARINFO_D01_D0_B3 = 100;
    public static final int U_CARINFO_D01_D0_B64 = 99;
    public static final int U_CARINFO_D01_D0_B7 = 98;
    public static final int U_CARINFO_D07_ALL_STR = 101;
    public static final int U_CARINFO_D0B_ALL_STR = 103;
    public static final int U_CARINFO_D0B_D0_B30 = 102;
    public static final int U_CARINFO_D12_D0_D1 = 104;
    public static final int U_CARINFO_D12_D2_D3 = 105;
    public static final int U_CARINFO_D12_D4_B70 = 106;
    public static final int U_CARINFO_D12_D5_B70 = 107;
    public static final int U_CARINFO_D12_D6_B70 = 108;
    public static final int U_CARINFO_D12_D7_B70 = 109;
    public static final int U_CARINFO_D13_D0_D1_D2_D3 = 110;
    public static final int U_CARINFO_D13_D4_B70 = 111;
    public static final int U_CARINFO_D13_D5_D6_D7_D8 = 112;
    public static final int U_CARINFO_D13_D9_D10 = 113;
    public static final int U_CARINFO_D14_D0_D1_D2_D3 = 114;
    public static final int U_CARINFO_D14_D4_B70 = 115;
    public static final int U_CARINFO_D14_D5_D6_D7_D8 = 116;
    public static final int U_CARINFO_D14_D9_D10 = 117;
    public static final int U_CNT_MAX = 118;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 118; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Oubao_Andela(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 118) {
            switch (updateCode) {
                case 101:
                    if (strs != null && strs.length > 0) {
                        D07Title = strs[0];
                    } else {
                        D07Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 102:
                default:
                    if (updateCode >= 0 && updateCode < 118) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 103:
                    if (strs != null && strs.length > 0) {
                        D0BTitle = strs[0];
                    } else {
                        D0BTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
