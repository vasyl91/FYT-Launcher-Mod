package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0272_RZC_XP1_JiangHuaiRuiFengS3 extends CallbackCanbusBase {
    public static final int U_CARSET_D40_D0_B70 = 117;
    public static final int U_CARSET_D40_D1_B70 = 118;
    public static final int U_CARSET_D40_D2_B70 = 119;
    public static final int U_CARSET_D40_D3_B70 = 120;
    public static final int U_CARSET_D40_D4_B70 = 121;
    public static final int U_CARSET_D40_D5_B70 = 122;
    public static final int U_CARSET_D41_D0_B70 = 123;
    public static final int U_CARSET_D41_D1_B70 = 124;
    public static final int U_CARSET_D41_D2_B70 = 125;
    public static final int U_CARSET_D41_D3_B70 = 126;
    public static final int U_CARSET_D41_D4_B70 = 127;
    public static final int U_CARSET_D41_D5_B70 = 128;
    public static final int U_CAR_AUTOLOCK = 113;
    public static final int U_CAR_INTERLIGHT = 112;
    public static final int U_CAR_LOCALIGHT = 115;
    public static final int U_CAR_OUTLIGHT = 111;
    public static final int U_CAR_PROMPTLL = 114;
    public static final int U_CAR_SHOW_TIREWARN = 116;
    public static final int U_CAR_TISHIVOL = 110;
    public static final int U_CNT_MAX = 129;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FR = 99;
    public static final int U_PRESSURE_RL = 100;
    public static final int U_PRESSURE_RR = 101;
    public static final int U_TEMP_FL = 102;
    public static final int U_TEMP_FR = 103;
    public static final int U_TEMP_RL = 104;
    public static final int U_TEMP_RR = 105;
    public static final int U_WARNING_FL = 106;
    public static final int U_WARNING_FR = 107;
    public static final int U_WARNING_RL = 108;
    public static final int U_WARNING_RR = 109;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0272_RZC_JiangHuai_S3(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
