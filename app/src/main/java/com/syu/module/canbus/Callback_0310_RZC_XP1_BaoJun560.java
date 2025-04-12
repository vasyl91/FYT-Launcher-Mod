package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0310_RZC_XP1_BaoJun560 extends CallbackCanbusBase {
    public static final int U_CARINFO_D52_D10 = 113;
    public static final int U_CARINFO_D52_D11 = 114;
    public static final int U_CARINFO_D52_D12 = 115;
    public static final int U_CARINFO_D52_D13 = 116;
    public static final int U_CARINFO_D52_D14 = 117;
    public static final int U_CARINFO_D52_D15 = 118;
    public static final int U_CARINFO_D52_D16 = 119;
    public static final int U_CARINFO_D52_D17 = 120;
    public static final int U_CARINFO_D52_D18 = 121;
    public static final int U_CARINFO_D52_D19 = 122;
    public static final int U_CARINFO_D52_D1A = 123;
    public static final int U_CARINFO_D52_D1B = 124;
    public static final int U_CARINFO_D52_D1C = 125;
    public static final int U_CARINFO_D52_D1D = 126;
    public static final int U_CARINFO_D52_D1E = 127;
    public static final int U_CARINFO_D52_D1F = 128;
    public static final int U_CARINFO_D52_D20 = 129;
    public static final int U_CARINFO_D52_D21 = 130;
    public static final int U_CARINFO_D52_D22 = 131;
    public static final int U_CARINFO_D52_D3 = 100;
    public static final int U_CARINFO_D52_D4 = 101;
    public static final int U_CARINFO_D52_D5 = 102;
    public static final int U_CARINFO_D52_D6 = 103;
    public static final int U_CARINFO_D52_D7 = 104;
    public static final int U_CARINFO_D52_D8 = 105;
    public static final int U_CARINFO_D52_D9 = 106;
    public static final int U_CARINFO_D52_DA = 107;
    public static final int U_CARINFO_D52_DB = 108;
    public static final int U_CARINFO_D52_DC = 109;
    public static final int U_CARINFO_D52_DD = 110;
    public static final int U_CARINFO_D52_DE = 111;
    public static final int U_CARINFO_D52_DF = 112;
    public static final int U_CARINFO_REARVIEW_AUTO = 98;
    public static final int U_CARINFO_TIRE_CAL = 99;
    public static final int U_CNT_MAX = 132;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 132; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0310_RZC_BaojunRs3(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 132) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
