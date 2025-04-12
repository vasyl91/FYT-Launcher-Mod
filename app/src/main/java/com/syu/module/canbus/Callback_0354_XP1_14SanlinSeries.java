package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0354_XP1_14SanlinSeries extends CallbackCanbusBase {
    public static final int U_CARSET_D40_D0_B32 = 100;
    public static final int U_CARSET_D40_D0_B75 = 99;
    public static final int U_CARSET_D40_D1_B01 = 105;
    public static final int U_CARSET_D40_D1_B04 = 103;
    public static final int U_CARSET_D40_D1_B05 = 102;
    public static final int U_CARSET_D40_D1_B32 = 104;
    public static final int U_CARSET_D40_D1_B76 = 101;
    public static final int U_CARSET_D40_D2_B07 = 106;
    public static final int U_CARSET_D40_D2_B31 = 108;
    public static final int U_CARSET_D40_D2_B64 = 107;
    public static final int U_CARSET_D40_D3_B20 = 111;
    public static final int U_CARSET_D40_D3_B54 = 110;
    public static final int U_CARSET_D40_D3_B76 = 109;
    public static final int U_CARSET_D40_D4_B02 = 116;
    public static final int U_CARSET_D40_D4_B05 = 114;
    public static final int U_CARSET_D40_D4_B06 = 113;
    public static final int U_CARSET_D40_D4_B07 = 112;
    public static final int U_CARSET_D40_D4_B10 = 117;
    public static final int U_CARSET_D40_D4_B43 = 115;
    public static final int U_CARSET_D40_D5_B01 = 122;
    public static final int U_CARSET_D40_D5_B06 = 119;
    public static final int U_CARSET_D40_D5_B07 = 118;
    public static final int U_CARSET_D40_D5_B32 = 121;
    public static final int U_CARSET_D40_D5_B54 = 120;
    public static final int U_CARSET_D40_D6_B54 = 124;
    public static final int U_CARSET_D40_D6_B76 = 123;
    public static final int U_CARSET_EQ_D17_D0_B70 = 125;
    public static final int U_CARSET_EQ_D17_D10_B70 = 135;
    public static final int U_CARSET_EQ_D17_D11_B70 = 136;
    public static final int U_CARSET_EQ_D17_D12_B70 = 137;
    public static final int U_CARSET_EQ_D17_D1_B70 = 126;
    public static final int U_CARSET_EQ_D17_D2_B70 = 127;
    public static final int U_CARSET_EQ_D17_D3_B70 = 128;
    public static final int U_CARSET_EQ_D17_D4_B70 = 129;
    public static final int U_CARSET_EQ_D17_D5_B70 = 130;
    public static final int U_CARSET_EQ_D17_D6_B70 = 131;
    public static final int U_CARSET_EQ_D17_D7_B70 = 132;
    public static final int U_CARSET_EQ_D17_D8_B70 = 133;
    public static final int U_CARSET_EQ_D17_D9_B70 = 134;
    public static final int U_CAR_TYPE = 98;
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
        //AirHelper.getInstance().buildUi(new Air_0354_XP_Sanlin(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
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
        if (updateCode >= 0 && updateCode >= 0 && updateCode < 138) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
