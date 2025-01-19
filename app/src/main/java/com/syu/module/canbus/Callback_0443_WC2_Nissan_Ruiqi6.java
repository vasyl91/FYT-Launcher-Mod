package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC_nissan_ruiqi;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Nissan_Ruiqi6 extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_FUEL = 99;
    public static final int U_CARINFO_AVG_SPEED = 101;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CURRENT = 103;
    public static final int U_CARINFO_SOC = 104;
    public static final int U_CARINFO_TOTAL_MILEAGE = 100;
    public static final int U_CARINFO_VOLTAGE = 102;
    public static final int U_CARINF_AIR_CLEAR = 123;
    public static final int U_CARINF_AIR_SHOWTEMPMODE = 120;
    public static final int U_CARINF_AIR_SHOWWINMODE = 121;
    public static final int U_CARINF_AIR_UI_TOP = 122;
    public static final int U_CARINF_END = 105;
    public static final int U_CARSET_AUTOLOCK_DRIVING = 116;
    public static final int U_CARSET_AUTOUNLOCK_STOP = 117;
    public static final int U_CARSET_BEGIN = 115;
    public static final int U_CARSET_D61_D0_B10 = 126;
    public static final int U_CARSET_D61_D0_B3 = 125;
    public static final int U_CARSET_D61_D0_B4 = 119;
    public static final int U_CARSET_D61_D1_B32 = 127;
    public static final int U_CARSET_D61_D2_B53 = 128;
    public static final int U_CARSET_D61_D3_B7 = 124;
    public static final int U_CARSET_HOME_LIGHT = 118;
    public static final int U_CAR_TIRE_BEGIN = 105;
    public static final int U_CAR_TIRE_END = 114;
    public static final int U_CAR_TIRE_TEMP_FL = 110;
    public static final int U_CAR_TIRE_TEMP_FR = 111;
    public static final int U_CAR_TIRE_TEMP_RL = 112;
    public static final int U_CAR_TIRE_TEMP_RR = 113;
    public static final int U_CAR_TIRE_VALUE_FL = 106;
    public static final int U_CAR_TIRE_VALUE_FR = 107;
    public static final int U_CAR_TIRE_VALUE_RL = 108;
    public static final int U_CAR_TIRE_VALUE_RR = 109;
    public static final int U_CNT_MAX = 129;

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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto /* 197052 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_P15_MC_EV /* 262588 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Auto /* 721340 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_GCC /* 852412 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV1 /* 917948 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV2 /* 983484 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_EV3 /* 1049020 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_OFFROAD /* 1114556 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Auto2 /* 1180092 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand1 /* 1245628 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7_Hand2 /* 1311164 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_Iran /* 1900988 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_Ruiqi7 /* 2752956 */:
            case FinalCanbus.CAR_444_WC2_Nissan_Yunche_S15_ADAS /* 3080636 */:
                break;
            case FinalCanbus.CAR_444_WC2_Dongfeng_Xiaokang_Ix5 /* 1835452 */:
                //AirHelper.getInstance().buildUi(new Air_0444_WC2_Dongfeng_FengguangIX5(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 97; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
            default:
                //AirHelper.getInstance().buildUi(new Air_0443_WC_nissan_ruiqi(LauncherApplication.getInstance()));
                for (int i4 = 10; i4 < 97; i4++) {
                    DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
