package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OD_Fengye_80V;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Fengye_80V extends CallbackCanbusBase {
    public static final int U_CARSET_D4D_D0_B10 = 181;
    public static final int U_CARSET_D4D_D0_B2 = 180;
    public static final int U_CARSET_D4D_D0_B3 = 179;
    public static final int U_CARSET_D4D_D1_B0 = 182;
    public static final int U_CARSET_D4D_D2_B10 = 185;
    public static final int U_CARSET_D4D_D2_B5 = 184;
    public static final int U_CARSET_D4D_D2_B7 = 183;
    public static final int U_CARSET_D4E_D0_B10 = 159;
    public static final int U_CARSET_D4E_D1_B4 = 161;
    public static final int U_CARSET_D4E_D1_B7 = 160;
    public static final int U_CARSET_D4E_D3_B0 = 166;
    public static final int U_CARSET_D4E_D3_B1 = 165;
    public static final int U_CARSET_D4E_D3_B2 = 164;
    public static final int U_CARSET_D4E_D3_B43 = 163;
    public static final int U_CARSET_D4E_D3_B5 = 162;
    public static final int U_CARSET_D4E_D4_B1 = 170;
    public static final int U_CARSET_D4E_D4_B32 = 169;
    public static final int U_CARSET_D4E_D4_B5 = 168;
    public static final int U_CARSET_D4E_D4_B7 = 167;
    public static final int U_CARSET_D4E_D5_B2 = 174;
    public static final int U_CARSET_D4E_D5_B3 = 173;
    public static final int U_CARSET_D4E_D5_B4 = 172;
    public static final int U_CARSET_D4E_D5_B7 = 171;
    public static final int U_CARSET_D4E_D6_B70 = 175;
    public static final int U_CARSET_D4E_D7_B30 = 177;
    public static final int U_CARSET_D4E_D7_B74 = 176;
    public static final int U_CARSET_D4E_D8_B70 = 178;
    public static final int U_CARSET_D4F_D0_B10 = 135;
    public static final int U_CARSET_D4F_D0_B2 = 134;
    public static final int U_CARSET_D4F_D1_B5 = 138;
    public static final int U_CARSET_D4F_D1_B6 = 137;
    public static final int U_CARSET_D4F_D1_B7 = 136;
    public static final int U_CARSET_D4F_D2_B3 = 140;
    public static final int U_CARSET_D4F_D2_B65 = 139;
    public static final int U_CARSET_D4F_D3_B0 = 144;
    public static final int U_CARSET_D4F_D3_B1 = 143;
    public static final int U_CARSET_D4F_D3_B2 = 142;
    public static final int U_CARSET_D4F_D3_B43 = 141;
    public static final int U_CARSET_D4F_D4_B0 = 151;
    public static final int U_CARSET_D4F_D4_B1 = 150;
    public static final int U_CARSET_D4F_D4_B32 = 149;
    public static final int U_CARSET_D4F_D4_B4 = 148;
    public static final int U_CARSET_D4F_D4_B5 = 147;
    public static final int U_CARSET_D4F_D4_B6 = 146;
    public static final int U_CARSET_D4F_D4_B7 = 145;
    public static final int U_CARSET_D4F_D5_B5 = 154;
    public static final int U_CARSET_D4F_D5_B6 = 153;
    public static final int U_CARSET_D4F_D5_B7 = 152;
    public static final int U_CARSET_D4F_D6_B70 = 155;
    public static final int U_CARSET_D4F_D7_B6 = 157;
    public static final int U_CARSET_D4F_D7_B7 = 156;
    public static final int U_CARSET_D4F_D8_B70 = 158;
    public static final int U_CARSET_D50_D0_B10 = 98;
    public static final int U_CARSET_D50_D1_B10 = 100;
    public static final int U_CARSET_D50_D1_B2 = 121;
    public static final int U_CARSET_D50_D1_B3 = 120;
    public static final int U_CARSET_D50_D1_B74 = 99;
    public static final int U_CARSET_D50_D2_B10 = 105;
    public static final int U_CARSET_D50_D2_B2 = 104;
    public static final int U_CARSET_D50_D2_B3 = 103;
    public static final int U_CARSET_D50_D2_B4 = 102;
    public static final int U_CARSET_D50_D2_B65 = 101;
    public static final int U_CARSET_D50_D3_B0 = 107;
    public static final int U_CARSET_D50_D3_B1 = 106;
    public static final int U_CARSET_D50_D4_B10 = 189;
    public static final int U_CARSET_D50_D4_B2 = 188;
    public static final int U_CARSET_D50_D4_B3 = 187;
    public static final int U_CARSET_D50_D4_B4 = 186;
    public static final int U_CARSET_D50_D4_B5 = 124;
    public static final int U_CARSET_D50_D4_B6 = 123;
    public static final int U_CARSET_D50_D4_B7 = 122;
    public static final int U_CARSET_D50_D5_B70 = 125;
    public static final int U_CARSET_D50_D6_B30 = 127;
    public static final int U_CARSET_D50_D6_B54 = 126;
    public static final int U_CARSET_D50_D7_B70 = 128;
    public static final int U_CARSET_D50_D8_B20 = 133;
    public static final int U_CARSET_D50_D8_B4 = 132;
    public static final int U_CARSET_D50_D8_B5 = 131;
    public static final int U_CARSET_D50_D8_B6 = 130;
    public static final int U_CARSET_D50_D8_B7 = 129;
    public static final int U_CNT_MAX = 190;
    public static final int U_TIRE_STATE_FL = 108;
    public static final int U_TIRE_STATE_FR = 109;
    public static final int U_TIRE_STATE_RL = 110;
    public static final int U_TIRE_STATE_RR = 111;
    public static final int U_TIRE_TEMP_FL = 116;
    public static final int U_TIRE_TEMP_FR = 117;
    public static final int U_TIRE_TEMP_RL = 118;
    public static final int U_TIRE_TEMP_RR = 119;
    public static final int U_TIRE_VALUE_FL = 112;
    public static final int U_TIRE_VALUE_FR = 113;
    public static final int U_TIRE_VALUE_RL = 114;
    public static final int U_TIRE_VALUE_RR = 115;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 190; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_Fengye_80V(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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
        if (updateCode >= 0 && updateCode < 190) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
