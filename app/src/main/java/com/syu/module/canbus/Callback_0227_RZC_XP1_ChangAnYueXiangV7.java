package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0227_RZC_16YueXiangV7;
import com.syu.ui.air.Air_0227_RZC_Beiqi_Shenbao_D50;
import com.syu.ui.air.Air_0227_RZC_ChangAnYueXiangV7;
import com.syu.ui.air.Air_0227_RZC_EC180;
import com.syu.ui.air.Air_0227_RZC_JingYiX5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0227_RZC_XP1_ChangAnYueXiangV7 extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_RELOCK = 89;
    public static final int U_CARINFO_BEGIN = 85;
    public static final int U_CARINFO_CAR_BATTERY = 94;
    public static final int U_CARINFO_CAR_STATE1 = 92;
    public static final int U_CARINFO_CAR_STATE2 = 93;
    public static final int U_CARINFO_CLEAR_LEV = 101;
    public static final int U_CARINFO_CO2_LEV = 99;
    public static final int U_CARINFO_CREEP = 104;
    public static final int U_CARINFO_DRIVEN_MILES = 91;
    public static final int U_CARINFO_ENERGEY_CONSUME = 90;
    public static final int U_CARINFO_ENERGEY_CONSUME_TOTAL = 95;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int U_CARINFO_HEADLIGHT_DELAY = 86;
    public static final int U_CARINFO_PEDAL_STATE = 102;
    public static final int U_CARINFO_REARVIEW_AUTO = 98;
    public static final int U_CARINFO_REMOTE_LOCK_CYCLE = 96;
    public static final int U_CARINFO_REMOTE_LOCK_WINDOW = 97;
    public static final int U_CARINFO_SAVING_TIME = 87;
    public static final int U_CARINFO_SIDE_PEDAL = 103;
    public static final int U_CARINFO_SPEED_LOCK = 88;
    public static final int U_CARINFO_TREE_LEV = 100;
    public static final int U_CARINF_D50_D0_B10 = 129;
    public static final int U_CARINF_D50_D0_B2 = 128;
    public static final int U_CARINF_D50_D0_B3 = 127;
    public static final int U_CARINF_D50_D1_B20 = 132;
    public static final int U_CARINF_D50_D1_B3 = 131;
    public static final int U_CARINF_D50_D1_B4 = 130;
    public static final int U_CNT_MAX = 133;
    public static final int U_D37_D1_D1_B70 = 106;
    public static final int U_D37_D1_D2_B70 = 107;
    public static final int U_D37_D1_D3_B70 = 108;
    public static final int U_D37_D2_D1_B70 = 109;
    public static final int U_D37_D2_D2_B70 = 110;
    public static final int U_D37_D2_D3_B70 = 111;
    public static final int U_D37_D2_D4_B70 = 112;
    public static final int U_D37_D3_D1_B70 = 113;
    public static final int U_D37_D3_D2_B70 = 114;
    public static final int U_D37_D4_D1_B70 = 105;
    public static final int U_D37_D4_D2_B70 = 124;
    public static final int U_D37_D4_D3_B70 = 125;
    public static final int U_D37_D4_D4_B70 = 126;
    public static final int U_D37_D5_D1_B70 = 116;
    public static final int U_D37_D5_D2_B70 = 117;
    public static final int U_D39_D10_B70_T1 = 118;
    public static final int U_D39_D10_B70_T2 = 119;
    public static final int U_D50_D01_B70 = 120;
    public static final int U_D50_D02_B5 = 122;
    public static final int U_D50_D02_B6 = 121;
    public static final int U_D50_D03_B70 = 123;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 105;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 133; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (carId == 1) {
            AirHelper.getInstance().buildUi(new Air_0227_RZC_ChangAnYueXiangV7(LauncherApplication.getInstance()));
        } else if (carId == 3 || carId == 7 || carId == 12) {
            AirHelper.getInstance().buildUi(new Air_0227_RZC_EC180(LauncherApplication.getInstance()));
        } else if (carId == 4) {
            AirHelper.getInstance().buildUi(new Air_0227_RZC_16YueXiangV7(LauncherApplication.getInstance()));
        } else if (carId == 13) {
            AirHelper.getInstance().buildUi(new Air_0227_RZC_Beiqi_Shenbao_D50(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0227_RZC_JingYiX5(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 10; i4 < 85; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 90:
                HandlerCanbus.update(updateCode, ints);
                U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
                break;
            default:
                if (updateCode >= 0 && updateCode < 133) {
                    HandlerCanbus.update(updateCode, ints);
                }
                if (updateCode >= 500 && updateCode < 560) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
