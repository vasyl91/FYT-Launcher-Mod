package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0396_RZC_BJ20;
//import com.syu.ui.air.Air_0396_RZC_ShengBaoM50F;
//import com.syu.ui.air.Air_0396_RZC_ShengBaoX55;
import com.syu.ui.door.DoorHelper;

public class Callback_0396_RZC_XP1_BeiQiShenBaoX55 extends CallbackCanbusBase {
    public static final int U_CAMERA_MODE = 98;
    public static final int U_CARSET_BLIND_WARN = 100;
    public static final int U_CARSET_D39_D01_B70 = 101;
    public static final int U_CARSET_D39_D02_B70 = 102;
    public static final int U_CARSET_D39_D03_B70 = 103;
    public static final int U_CARSET_D39_D04_B70 = 104;
    public static final int U_CARSET_D39_D05_B70 = 105;
    public static final int U_CARSET_D39_D06_B70 = 106;
    public static final int U_CARSET_D39_D07_B70 = 107;
    public static final int U_CARSET_D39_D08_B70 = 108;
    public static final int U_CARSET_D39_D09_B70 = 109;
    public static final int U_CARSET_D39_D0A_B70 = 110;
    public static final int U_CARSET_D39_D0B_B70 = 111;
    public static final int U_CARSET_D39_D0C_B70 = 112;
    public static final int U_CARSET_D39_D0D_B70 = 113;
    public static final int U_CARSET_D39_D0E_B70 = 114;
    public static final int U_CARSET_D39_D0F_B70 = 115;
    public static final int U_CARSET_D39_D10_D1_B70 = 116;
    public static final int U_CARSET_D39_D10_D2_B70 = 117;
    public static final int U_CARSET_D39_D10_D3_B70 = 118;
    public static final int U_CARSET_D39_D11_B70 = 119;
    public static final int U_CARSET_D39_D12_B70 = 120;
    public static final int U_CARSET_ROAD_AWAY = 99;
    public static final int U_CNT_MAX = 121;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 121; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_RZC_XP1_BeiQiM50F /* 65932 */:
                //AirHelper.getInstance().buildUi(new Air_0396_RZC_ShengBaoM50F(LauncherApplication.getInstance()));
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ20 /* 721292 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ20_H /* 917900 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21 /* 983436 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_20_H /* 1114508 */:
                //AirHelper.getInstance().buildUi(new Air_0396_RZC_BJ20(LauncherApplication.getInstance()));
                break;
            default:
                //AirHelper.getInstance().buildUi(new Air_0396_RZC_ShengBaoX55(LauncherApplication.getInstance()));
                break;
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 121) {
            switch (updateCode) {
                case 55:
                    int value = DataCanbus.DATA[55];
                    if (value == 1 && !Air_Activity_All_NewAdd_HP.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                        break;
                    } else if (value == 0 && Air_Activity_All_NewAdd_HP.mIsFront && Air_Activity_All_NewAdd_HP.mInstance != null) {
                        Air_Activity_All_NewAdd_HP.mInstance.finish();
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
