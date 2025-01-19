package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_TangDu_Nissan_All extends CallbackCanbusBase {
    public static final int U_CARINF_D70_D0_B0 = 116;
    public static final int U_CARINF_D70_D0_B1 = 115;
    public static final int U_CARINF_D70_D0_B2 = 114;
    public static final int U_CARINF_D70_D0_B3 = 113;
    public static final int U_CARINF_D70_D0_B4 = 112;
    public static final int U_CARINF_D70_D0_B5 = 111;
    public static final int U_CARINF_D70_D0_B6 = 110;
    public static final int U_CARINF_D70_D0_B7 = 109;
    public static final int U_CARINF_D70_D1_D2 = 117;
    public static final int U_CARINF_D70_D3_D4 = 118;
    public static final int U_CARINF_D70_D5_D6 = 119;
    public static final int U_CARINF_D70_D7_D8 = 120;
    public static final int U_CARINF_D70_D9_B4 = 124;
    public static final int U_CARINF_D70_D9_B5 = 123;
    public static final int U_CARINF_D70_D9_B6 = 122;
    public static final int U_CARINF_D70_D9_B7 = 121;
    public static final int U_CARINF_D71_D0_D1 = 125;
    public static final int U_CARINF_D71_D2_D3 = 126;
    public static final int U_CARINF_D71_D4_D6 = 127;
    public static final int U_CARINF_D72_D0_D1 = 128;
    public static final int U_CARINF_D72_D2_B70 = 129;
    public static final int U_CARSET_D69_D0_B2 = 98;
    public static final int U_CARSET_D69_D0_B3 = 99;
    public static final int U_CARSET_D74_D0_B0 = 134;
    public static final int U_CARSET_D74_D0_B1 = 133;
    public static final int U_CARSET_D74_D0_B2 = 132;
    public static final int U_CARSET_D74_D0_B3 = 131;
    public static final int U_CARSET_D74_D0_B4 = 130;
    public static final int U_CARSET_D74_D1_B20 = 135;
    public static final int U_CARSET_D74_D1_B53 = 136;
    public static final int U_CARSET_D74_D1_B76 = 137;
    public static final int U_CARSET_D74_D2_B10 = 138;
    public static final int U_CARSET_D74_D2_B32 = 139;
    public static final int U_CARSET_D74_D2_B54 = 140;
    public static final int U_CARSET_D74_D2_B6 = 141;
    public static final int U_CARSET_D74_D3_B20 = 142;
    public static final int U_CARSET_D74_D3_B3 = 143;
    public static final int U_CARSET_D74_D4_B0 = 144;
    public static final int U_CARSET_D74_D4_B31 = 145;
    public static final int U_CARSET_D74_D4_B64 = 146;
    public static final int U_CARSET_D75_D0_B70 = 147;
    public static final int U_CARSET_D76_D0_B0 = 148;
    public static final int U_CARSET_D76_D0_B1 = 149;
    public static final int U_CARSET_D93_D0_B70 = 100;
    public static final int U_CARSET_D93_D1_B70 = 101;
    public static final int U_CARSET_D93_D2_B70 = 102;
    public static final int U_CARSET_D93_D3_B70 = 103;
    public static final int U_CARSET_D93_D4_B70 = 104;
    public static final int U_CARSET_D93_D5_B70 = 105;
    public static final int U_CARSET_D93_D6_B70 = 106;
    public static final int U_CARSET_D93_D7_B70 = 107;
    public static final int U_CARSET_D93_D8_B70 = 108;
    public static final int U_CNT_MAX = 150;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 150; i++) {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_TD_INFINIT_ESQ /* 1704391 */:
            case FinalCanbus.CAR_455_TD_INFINIT_G /* 1769927 */:
            case FinalCanbus.CAR_455_TD_INFINIT_QX50 /* 1835463 */:
            case FinalCanbus.CAR_455_TD_INFINIT_06FX /* 1900999 */:
            case FinalCanbus.CAR_455_TD_INFINIT_08FX /* 1966535 */:
            case FinalCanbus.CAR_455_TD_INFINIT_14QX70 /* 2032071 */:
            case FinalCanbus.CAR_455_TD_INFINIT_12FX /* 2097607 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_L /* 13763014 */:
            case FinalCanbus.CAR_454_Tangdu_Nissan_PATROL_H /* 13828550 */:
                //AirHelper.getInstance().buildUi(new Air_0452_TD_Nissan_Tule(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 97; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
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
        if (updateCode >= 0 && updateCode < 150) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
