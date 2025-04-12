package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_RZC_MahindraTata_All extends CallbackCanbusBase {
    public static final int U_CARINF_D60_D0_B70 = 114;
    public static final int U_CARINF_D60_D11_D12 = 120;
    public static final int U_CARINF_D60_D13_D14 = 121;
    public static final int U_CARINF_D60_D15_D16 = 122;
    public static final int U_CARINF_D60_D1_B70 = 115;
    public static final int U_CARINF_D60_D2_D3 = 116;
    public static final int U_CARINF_D60_D4_D5 = 117;
    public static final int U_CARINF_D60_D6_D7 = 118;
    public static final int U_CARINF_D60_D8_B70 = 119;
    public static final int U_CARSET_D3F_D10_B70 = 106;
    public static final int U_CARSET_D3F_D11_B70 = 107;
    public static final int U_CARSET_D3F_D20_B70 = 108;
    public static final int U_CARSET_D3F_D21_B70 = 109;
    public static final int U_CARSET_D3F_D22_B70 = 110;
    public static final int U_CARSET_D3F_D30_B70 = 111;
    public static final int U_CARSET_D3F_D31_B70 = 112;
    public static final int U_CARSET_D3F_D32_B70 = 113;
    public static final int U_CNT_MAX = 123;
    public static final int U_TIRE_TEMP_FL = 102;
    public static final int U_TIRE_TEMP_FR = 103;
    public static final int U_TIRE_TEMP_RL = 104;
    public static final int U_TIRE_TEMP_RR = 105;
    public static final int U_TIRE_VALUE_FL = 98;
    public static final int U_TIRE_VALUE_FR = 99;
    public static final int U_TIRE_VALUE_RL = 100;
    public static final int U_TIRE_VALUE_RR = 101;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0454_RZC_MahindraTata_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 123) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
