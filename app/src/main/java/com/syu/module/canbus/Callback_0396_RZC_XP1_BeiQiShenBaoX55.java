package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.shenbao.ActivityM50FAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0396_RZC_BJ20;
import com.syu.ui.air.Air_0396_RZC_ShengBaoM50F;
import com.syu.ui.air.Air_0396_RZC_ShengBaoX55;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0396_RZC_XP1_BeiQiShenBaoX55 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AC_MAX = 33;
    public static final int U_AIR_AQS = 26;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_AUTO_WIND = 32;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY = 16;
    public static final int U_AIR_BLOW_FOOT = 17;
    public static final int U_AIR_BLOW_UP = 15;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 23;
    public static final int U_AIR_ECO = 27;
    public static final int U_AIR_END = 35;
    public static final int U_AIR_FRONT_DEFROST = 18;
    public static final int U_AIR_FRONT_MAX = 14;
    public static final int U_AIR_ION = 34;
    public static final int U_AIR_JUMPCON = 31;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 19;
    public static final int U_AIR_REAR_LOCK = 24;
    public static final int U_AIR_SEAT_HEAT_LEFT = 29;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 30;
    public static final int U_AIR_TEMPUNIT = 28;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 25;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_CAMERA_MODE = 36;
    public static final int U_CARSET_BLIND_WARN = 38;
    public static final int U_CARSET_D39_D01_B70 = 39;
    public static final int U_CARSET_D39_D02_B70 = 40;
    public static final int U_CARSET_D39_D03_B70 = 41;
    public static final int U_CARSET_D39_D04_B70 = 42;
    public static final int U_CARSET_D39_D05_B70 = 43;
    public static final int U_CARSET_D39_D06_B70 = 44;
    public static final int U_CARSET_D39_D07_B70 = 45;
    public static final int U_CARSET_D39_D08_B70 = 46;
    public static final int U_CARSET_D39_D09_B70 = 47;
    public static final int U_CARSET_D39_D0A_B70 = 48;
    public static final int U_CARSET_D39_D0B_B70 = 49;
    public static final int U_CARSET_D39_D0C_B70 = 50;
    public static final int U_CARSET_D39_D0D_B70 = 51;
    public static final int U_CARSET_D39_D0E_B70 = 52;
    public static final int U_CARSET_D39_D0F_B70 = 53;
    public static final int U_CARSET_D39_D10_D1_B70 = 54;
    public static final int U_CARSET_D39_D10_D2_B70 = 55;
    public static final int U_CARSET_D39_D10_D3_B70 = 56;
    public static final int U_CARSET_D39_D11_B70 = 57;
    public static final int U_CARSET_D39_D12_B70 = 58;
    public static final int U_CARSET_ROAD_AWAY = 37;
    public static final int U_CNT_MAX = 59;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 59; i++) {
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
                AirHelper.getInstance().buildUi(new Air_0396_RZC_ShengBaoM50F(LauncherApplication.getInstance()));
                for (int i2 = 10; i2 < 35; i2++) {
                    DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ20 /* 721292 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ20_H /* 917900 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21 /* 983436 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_21_H /* 1048972 */:
            case FinalCanbus.CAR_RZC_XP1_BeiQiBJ40_20_H /* 1114508 */:
                AirHelper.getInstance().buildUi(new Air_0396_RZC_BJ20(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 35; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0396_RZC_ShengBaoX55(LauncherApplication.getInstance()));
                for (int i4 = 10; i4 < 22; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
        }
        DoorHelper.getInstance().buildUi();
        for (int i5 = 0; i5 < 6; i5++) {
            DataCanbus.NOTIFY_EVENTS[i5].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 35; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 59) {
            switch (updateCode) {
                case 31:
                    int value = DataCanbus.DATA[31];
                    if (value == 1 && !ActivityM50FAirControl.mIsFront) {
                        AirHelper.disableAirWindowLocal(true);
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.shenbao.ActivityM50FAirControl");
                        break;
                    } else if (value == 0 && ActivityM50FAirControl.mIsFront && ActivityM50FAirControl.mInstance != null) {
                        ActivityM50FAirControl.mInstance.finish();
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
