package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_Luz_Nissac_GTR extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D33_D0_B70 = 158;
    public static final int U_CARINFO_D33_D1_B30 = 160;
    public static final int U_CARINFO_D33_D1_B74 = 159;
    public static final int U_CARINFO_D33_D2_B70 = 161;
    public static final int U_CARINFO_D33_D3_B70 = 162;
    public static final int U_CARINFO_D33_D4_B0 = 168;
    public static final int U_CARINFO_D33_D4_B1 = 167;
    public static final int U_CARINFO_D33_D4_B32 = 166;
    public static final int U_CARINFO_D33_D4_B54 = 165;
    public static final int U_CARINFO_D33_D4_B6 = 164;
    public static final int U_CARINFO_D33_D4_B7 = 163;
    public static final int U_CARINFO_D33_D5_B6 = 170;
    public static final int U_CARINFO_D33_D5_B7 = 169;
    public static final int U_CARINFO_D34_DATA0 = 99;
    public static final int U_CARINFO_D34_DATA1 = 100;
    public static final int U_CARINFO_D34_DATA10 = 107;
    public static final int U_CARINFO_D34_DATA2 = 101;
    public static final int U_CARINFO_D34_DATA3 = 102;
    public static final int U_CARINFO_D34_DATA45 = 103;
    public static final int U_CARINFO_D34_DATA6 = 104;
    public static final int U_CARINFO_D34_DATA78 = 105;
    public static final int U_CARINFO_D34_DATA9 = 106;
    public static final int U_CARINFO_D35_DATA0 = 108;
    public static final int U_CARINFO_D35_DATA1 = 109;
    public static final int U_CARINFO_D35_DATA10 = 114;
    public static final int U_CARINFO_D35_DATA23 = 110;
    public static final int U_CARINFO_D35_DATA45 = 111;
    public static final int U_CARINFO_D35_DATA6 = 112;
    public static final int U_CARINFO_D35_DATA789 = 113;
    public static final int U_CARINFO_D36_TIRE_FL = 116;
    public static final int U_CARINFO_D36_TIRE_FR = 115;
    public static final int U_CARINFO_D36_TIRE_RL = 118;
    public static final int U_CARINFO_D36_TIRE_RR = 117;
    public static final int U_CARINFO_D36_TIRE_STATE_FL = 120;
    public static final int U_CARINFO_D36_TIRE_STATE_FR = 119;
    public static final int U_CARINFO_D36_TIRE_STATE_RL = 122;
    public static final int U_CARINFO_D36_TIRE_STATE_RR = 121;
    public static final int U_CARINFO_D37_D0_D1 = 139;
    public static final int U_CARINFO_D37_D2_D3 = 140;
    public static final int U_CARINFO_D37_D4_D6 = 141;
    public static final int U_CARINFO_D37_D7_D8 = 142;
    public static final int U_CARINFO_D39_D0_B70 = 171;
    public static final int U_CARINFO_D39_D1_B70 = 172;
    public static final int U_CARINFO_D39_D2_B70 = 173;
    public static final int U_CARINFO_D39_D3_B70 = 174;
    public static final int U_CARINFO_D39_D4_B70 = 175;
    public static final int U_CARINFO_D39_D5_B30 = 177;
    public static final int U_CARINFO_D39_D5_B4 = 176;
    public static final int U_CARINFO_D40_D0_B70 = 143;
    public static final int U_CARINFO_D40_D10_B70 = 153;
    public static final int U_CARINFO_D40_D11_B70 = 154;
    public static final int U_CARINFO_D40_D12_B70 = 155;
    public static final int U_CARINFO_D40_D13_B70 = 156;
    public static final int U_CARINFO_D40_D14_B70 = 157;
    public static final int U_CARINFO_D40_D1_B70 = 144;
    public static final int U_CARINFO_D40_D2_B70 = 145;
    public static final int U_CARINFO_D40_D3_B70 = 146;
    public static final int U_CARINFO_D40_D4_B70 = 147;
    public static final int U_CARINFO_D40_D5_B70 = 148;
    public static final int U_CARINFO_D40_D6_B70 = 149;
    public static final int U_CARINFO_D40_D7_B70 = 150;
    public static final int U_CARINFO_D40_D8_B70 = 151;
    public static final int U_CARINFO_D40_D9_B70 = 152;
    public static final int U_CARINFO_END = 123;
    public static final int U_CARSET_BEGIN = 124;
    public static final int U_CARSET_D38_DATA0 = 125;
    public static final int U_CARSET_D38_DATA1 = 126;
    public static final int U_CARSET_D38_DATA10 = 135;
    public static final int U_CARSET_D38_DATA11_B6 = 137;
    public static final int U_CARSET_D38_DATA11_B7 = 136;
    public static final int U_CARSET_D38_DATA2 = 127;
    public static final int U_CARSET_D38_DATA3 = 128;
    public static final int U_CARSET_D38_DATA4 = 129;
    public static final int U_CARSET_D38_DATA5 = 130;
    public static final int U_CARSET_D38_DATA6 = 131;
    public static final int U_CARSET_D38_DATA7 = 132;
    public static final int U_CARSET_D38_DATA8 = 133;
    public static final int U_CARSET_D38_DATA9 = 134;
    public static final int U_CARSET_END = 138;
    public static final int U_CNT_MAX = 178;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 178; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_LZ_Nissan_GTR(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 178) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
