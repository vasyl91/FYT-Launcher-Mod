package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0425_XFY_HonDa_GuanDao extends CallbackCanbusBase {
    public static final int U_CARINDO_END = 126;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CAR_AUDIO_TYPE = 125;
    public static final int U_CNT_MAX = 126;
    public static final int U_CUR_SPEED = 99;
    public static final int U_D0B00 = 119;
    public static final int U_D0B02 = 118;
    public static final int U_D0B04 = 101;
    public static final int U_D1B00 = 103;
    public static final int U_D1B02 = 102;
    public static final int U_D2B00 = 108;
    public static final int U_D2B02 = 107;
    public static final int U_D2B04 = 106;
    public static final int U_D2B06 = 105;
    public static final int U_D2B07 = 104;
    public static final int U_D3B04 = 112;
    public static final int U_D3B05 = 111;
    public static final int U_D3B06 = 110;
    public static final int U_D3B07 = 109;
    public static final int U_D4B06 = 114;
    public static final int U_D4B07 = 113;
    public static final int U_D5B02 = 124;
    public static final int U_D5B03 = 123;
    public static final int U_D5B04 = 122;
    public static final int U_D5B05 = 121;
    public static final int U_D5B06 = 120;
    public static final int U_DTS_SURROUND = 117;
    public static final int U_ENGINE_SPEED = 100;
    public static final int U_LOUD = 115;
    public static final int U_SPEED_VOL = 116;

    @Override
    public void in() {
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
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (DataCanbus.DATA[1000] == 131497) {
            //AirHelper.getInstance().buildUi(new Air_0425_XFY_VOLVOXC60(LauncherApplication.getInstance()));
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
        if (DataCanbus.DATA[1000] == 131497) {
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
            AirHelper.getInstance().destroyUi();
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 126) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
