package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0021_WC2_MengDiOuZS2013 extends CallbackCanbusBase {
    public static final int U_CARINFO_LANGUAGE = 102;
    public static final int U_CARINFO_UNIT_DISTANCE = 100;
    public static final int U_CARINFO_UNIT_TEMP = 101;
    public static final int U_CARSET_D34_D2_D3 = 105;
    public static final int U_CARSET_D34_D4_D5_D6 = 106;
    public static final int U_CARSET_D48_D2_D3 = 107;
    public static final int U_CARSET_D48_D4_D5 = 108;
    public static final int U_CARSET_D48_D6_D7 = 109;
    public static final int U_CARSET_D48_D8_D9 = 110;
    public static final int U_CARSET_D61_D1_B30 = 113;
    public static final int U_CARSET_D61_D1_B74 = 112;
    public static final int U_CARSET_D61_D2_B70 = 111;
    public static final int U_CARSET_D61_D4_B30 = 115;
    public static final int U_CARSET_D61_D4_B74 = 114;
    public static final int U_CARSET_D61_D5_B30 = 117;
    public static final int U_CARSET_D61_D5_B74 = 116;
    public static final int U_CARSET_D61_D6_B10 = 120;
    public static final int U_CARSET_D61_D6_B32 = 119;
    public static final int U_CARSET_D61_D6_B74 = 118;
    public static final int U_CARSET_D61_D7_B30 = 122;
    public static final int U_CARSET_D61_D7_B74 = 121;
    public static final int U_CARSET_D61_D8_B10 = 125;
    public static final int U_CARSET_D61_D8_B32 = 124;
    public static final int U_CARSET_D61_D8_B74 = 123;
    public static final int U_CNT_MAX = 126;
    public static final int U_CURSPEED_ENABLE = 104;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_ENABLE = 103;
    public static final int U_ENGINE_SPEED = 99;

    @Override
    public void in() {
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (carId == 6) {
            //AirHelper.getInstance().buildUi(new Air_0021_WC1_Ecosport2018(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0021_WC1_MengDiOu2013H(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 97; i2 < 6; i2++) {
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
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
