package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Jaguar_XF extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D35_D1_B70 = 99;
    public static final int U_CARINFO_D35_D2_D3 = 100;
    public static final int U_CARINFO_D35_D4_D5 = 101;
    public static final int U_CARINFO_D35_D7_D8_D9_D10 = 102;
    public static final int U_CARINFO_D36_D0_B7 = 113;
    public static final int U_CARINFO_D36_D1_B70 = 114;
    public static final int U_CARINFO_D36_D1_D2_D3_D4 = 115;
    public static final int U_CARINFO_D36_D5_D6 = 116;
    public static final int U_CARINFO_D36_D7_D8 = 117;
    public static final int U_CARINFO_D36_D9 = 118;
    public static final int U_CARINFO_D38_D0_B70 = 103;
    public static final int U_CARINFO_D38_D10_B70 = 119;
    public static final int U_CARINFO_D38_D11_B70 = 120;
    public static final int U_CARINFO_D38_D12_B70 = 121;
    public static final int U_CARINFO_D38_D13_B70 = 122;
    public static final int U_CARINFO_D38_D14_B70 = 123;
    public static final int U_CARINFO_D38_D15_B70 = 124;
    public static final int U_CARINFO_D38_D16_B70 = 125;
    public static final int U_CARINFO_D38_D17_B70 = 126;
    public static final int U_CARINFO_D38_D18_B70 = 127;
    public static final int U_CARINFO_D38_D19_B70 = 128;
    public static final int U_CARINFO_D38_D1_B70 = 104;
    public static final int U_CARINFO_D38_D20_B70 = 129;
    public static final int U_CARINFO_D38_D2_B70 = 105;
    public static final int U_CARINFO_D38_D3_B70 = 106;
    public static final int U_CARINFO_D38_D4_B70 = 107;
    public static final int U_CARINFO_D38_D5_B70 = 108;
    public static final int U_CARINFO_D38_D6_B70 = 109;
    public static final int U_CARINFO_D38_D7_B70 = 110;
    public static final int U_CARINFO_D38_D8_B70 = 111;
    public static final int U_CARINFO_D38_D9_B70 = 112;
    public static final int U_CNT_MAX = 130;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 130; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_LUZ_Jaguar_XF(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 130) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
