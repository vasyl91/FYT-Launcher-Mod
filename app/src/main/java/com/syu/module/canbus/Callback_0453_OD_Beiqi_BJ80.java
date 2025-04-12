package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_OD_Beiqi_BJ80 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D40_D0_B70 = 99;
    public static final int U_CARINFO_D40_D10_B70 = 109;
    public static final int U_CARINFO_D40_D11_B70 = 110;
    public static final int U_CARINFO_D40_D12_B70 = 111;
    public static final int U_CARINFO_D40_D1_B70 = 100;
    public static final int U_CARINFO_D40_D2_B70 = 101;
    public static final int U_CARINFO_D40_D3_B70 = 102;
    public static final int U_CARINFO_D40_D4_B70 = 103;
    public static final int U_CARINFO_D40_D5_B70 = 104;
    public static final int U_CARINFO_D40_D6_B70 = 105;
    public static final int U_CARINFO_D40_D7_B70 = 106;
    public static final int U_CARINFO_D40_D8_B70 = 107;
    public static final int U_CARINFO_D40_D9_B70 = 108;
    public static final int U_CARINFO_D41_D0_B70 = 112;
    public static final int U_CARINFO_D41_D1_B70 = 113;
    public static final int U_CARINFO_D41_D2_B70 = 114;
    public static final int U_CARINFO_D41_D3_B70 = 115;
    public static final int U_CARINFO_D41_D4_B70 = 116;
    public static final int U_CARINFO_D41_D5_B70 = 117;
    public static final int U_CARINFO_D41_D6_B70 = 118;
    public static final int U_CARINFO_D41_D7_B70 = 119;
    public static final int U_CARINFO_D41_D8_B70 = 120;
    public static final int U_CARINFO_D41_D9_B70 = 121;
    public static final int U_CARINFO_D42_D0_B70 = 122;
    public static final int U_CARINFO_D42_D1_B70 = 123;
    public static final int U_CARINFO_D42_D2_B70 = 124;
    public static final int U_CARINFO_D42_D3_B70 = 125;
    public static final int U_CARINFO_D42_D4_B70 = 126;
    public static final int U_CNT_MAX = 127;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
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
        if (DataCanbus.DATA[1000] == 12845509) {
            //AirHelper.getInstance().buildUi(new Air_0453_OD_Beiqi_BJ30(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
