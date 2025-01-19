package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0227_RZC_16YueXiangV7;
//import com.syu.ui.air.Air_0227_RZC_Beiqi_Shenbao_D50;
//import com.syu.ui.air.Air_0227_RZC_ChangAnYueXiangV7;
//import com.syu.ui.air.Air_0227_RZC_EC180;
//import com.syu.ui.air.Air_0227_RZC_JingYiX5;
import com.syu.ui.door.DoorHelper;

public class Callback_0227_RZC_XP1_ChangAnYueXiangV7 extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_RELOCK = 101;
    public static final int U_CARINFO_BEGIN = 97;
    public static final int U_CARINFO_CAR_BATTERY = 106;
    public static final int U_CARINFO_CAR_STATE1 = 104;
    public static final int U_CARINFO_CAR_STATE2 = 105;
    public static final int U_CARINFO_CLEAR_LEV = 113;
    public static final int U_CARINFO_CO2_LEV = 111;
    public static final int U_CARINFO_CREEP = 116;
    public static final int U_CARINFO_DRIVEN_MILES = 103;
    public static final int U_CARINFO_ENERGEY_CONSUME = 102;
    public static final int U_CARINFO_ENERGEY_CONSUME_TOTAL = 107;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int U_CARINFO_HEADLIGHT_DELAY = 98;
    public static final int U_CARINFO_PEDAL_STATE = 114;
    public static final int U_CARINFO_REARVIEW_AUTO = 110;
    public static final int U_CARINFO_REMOTE_LOCK_CYCLE = 108;
    public static final int U_CARINFO_REMOTE_LOCK_WINDOW = 109;
    public static final int U_CARINFO_SAVING_TIME = 99;
    public static final int U_CARINFO_SIDE_PEDAL = 115;
    public static final int U_CARINFO_SPEED_LOCK = 100;
    public static final int U_CARINFO_TREE_LEV = 112;
    public static final int U_CARINF_D50_D0_B10 = 141;
    public static final int U_CARINF_D50_D0_B2 = 140;
    public static final int U_CARINF_D50_D0_B3 = 139;
    public static final int U_CARINF_D50_D1_B20 = 144;
    public static final int U_CARINF_D50_D1_B3 = 143;
    public static final int U_CARINF_D50_D1_B4 = 142;
    public static final int U_CAR_DRIVENABLE_MILEAGE = 145;
    public static final int U_CNT_MAX = 146;
    public static final int U_D37_D1_D1_B70 = 118;
    public static final int U_D37_D1_D2_B70 = 119;
    public static final int U_D37_D1_D3_B70 = 120;
    public static final int U_D37_D2_D1_B70 = 121;
    public static final int U_D37_D2_D2_B70 = 122;
    public static final int U_D37_D2_D3_B70 = 123;
    public static final int U_D37_D2_D4_B70 = 124;
    public static final int U_D37_D3_D1_B70 = 125;
    public static final int U_D37_D3_D2_B70 = 126;
    public static final int U_D37_D4_D1_B70 = 117;
    public static final int U_D37_D4_D2_B70 = 136;
    public static final int U_D37_D4_D3_B70 = 137;
    public static final int U_D37_D4_D4_B70 = 138;
    public static final int U_D37_D5_D1_B70 = 128;
    public static final int U_D37_D5_D2_B70 = 129;
    public static final int U_D39_D10_B70_T1 = 130;
    public static final int U_D39_D10_B70_T2 = 131;
    public static final int U_D50_D01_B70 = 132;
    public static final int U_D50_D02_B5 = 134;
    public static final int U_D50_D02_B6 = 133;
    public static final int U_D50_D03_B70 = 135;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 146; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65763) {
            //AirHelper.getInstance().buildUi(new Air_0227_RZC_ChangAnYueXiangV7(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 196835 || DataCanbus.DATA[1000] == 458979 || DataCanbus.DATA[1000] == 1376483 || DataCanbus.DATA[1000] == 786659) {
            //AirHelper.getInstance().buildUi(new Air_0227_RZC_EC180(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 262371) {
            //AirHelper.getInstance().buildUi(new Air_0227_RZC_16YueXiangV7(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 852195) {
            //AirHelper.getInstance().buildUi(new Air_0227_RZC_Beiqi_Shenbao_D50(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0227_RZC_JingYiX5(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[64].removeNotify(AirHelper.SHOW_AND_REFRESH);
        int i4 = DataCanbus.DATA[1000];
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
        switch (updateCode) {
            case 102:
                HandlerCanbus.update(updateCode, ints);
                U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
                break;
            default:
                if (updateCode >= 0 && updateCode < 146) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
