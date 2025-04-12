package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Oulande extends CallbackCanbusBase {
    public static final int U_ALARMINFO_BEGIN = 105;
    public static final int U_ALARMINFO_END = 114;
    public static final int U_ALARMINFO_INFO1 = 107;
    public static final int U_ALARMINFO_INFO2 = 108;
    public static final int U_ALARMINFO_INFO3 = 109;
    public static final int U_ALARMINFO_INFO4 = 110;
    public static final int U_ALARMINFO_INFO5 = 111;
    public static final int U_ALARMINFO_INFO6 = 112;
    public static final int U_ALARMINFO_INFO7 = 113;
    public static final int U_ALARMINFO_NUM = 106;
    public static final int U_CARINF_D34_D12_D13 = 118;
    public static final int U_CARINF_D34_D4_D5_D6 = 115;
    public static final int U_CARINF_D34_D7_D8 = 116;
    public static final int U_CARINF_D34_D9_D10_D11 = 117;
    public static final int U_CNT_MAX = 119;
    public static final int U_LIGHT_BEGIN = 97;
    public static final int U_LIGHT_END = 105;
    public static final int U_LIGHT_FARLIGHT = 99;
    public static final int U_LIGHT_FRONTFOGFLIGHT = 101;
    public static final int U_LIGHT_LEFTTURNLIGHT = 104;
    public static final int U_LIGHT_NEARLIGHT = 98;
    public static final int U_LIGHT_REARLIGHT = 102;
    public static final int U_LIGHT_RIGHTTURNLIGHT = 103;
    public static final int U_LIGHT_WIDTHLIGHT = 100;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Oulande(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
