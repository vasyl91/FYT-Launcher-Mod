package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.sbd.x80.TianLai09Act;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0388_HC_XP1_9TianLai;
import com.syu.ui.door.DoorHelper;

public class Callback_0388_HC_OLD_9TianLai extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CAR_VOL = 115;
    public static final int U_CD_BEGIN = 104;
    public static final int U_CD_CURRENT_DISC_TRACK = 107;
    public static final int U_CD_CURRENT_TIME = 108;
    public static final int U_CD_DISC_STATE = 106;
    public static final int U_CD_DISC_WORK_STATE = 109;
    public static final int U_CD_END = 111;
    public static final int U_CD_STATE = 105;
    public static final int U_CD_TEXT = 110;
    public static final int U_CNT_MAX = 117;
    public static final int U_MEDIA_BEGIN = 112;
    public static final int U_MEDIA_END = 114;
    public static final int U_MEDIA_STATE = 113;
    public static final int U_RADIO_BAND = 100;
    public static final int U_RADIO_CHANNEL_FREQ = 101;
    public static final int U_RADIO_END = 103;
    public static final int U_RADIO_STATE = 99;
    public static final int U_RADIO_TEXT = 102;
    public static final int U_SOURCE_STATE = 116;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0388_HC_XP1_9TianLai(LauncherApplication.getInstance()));
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
        if (updateCode == 101 || updateCode == 102 || updateCode == 110) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 116) {
            if ((ints[0] == 2 || ints[0] == 1) && !TianLai09Act.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.x80.TianLai09Act");
            }
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 117) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
