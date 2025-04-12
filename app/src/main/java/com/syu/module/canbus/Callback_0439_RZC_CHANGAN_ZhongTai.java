package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_CHANGAN_ZhongTai extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 170;
    public static final int U_CARINFO_D24_D2_B30 = 187;
    public static final int U_CARINFO_D24_D2_B74 = 186;
    public static final int U_CARINFO_D24_D3_B7 = 188;
    public static final int U_CARINFO_D41_D2_B30 = 191;
    public static final int U_CARINFO_D41_D2_B64 = 190;
    public static final int U_CARINFO_D41_D2_B7 = 189;
    public static final int U_CARINFO_D47_D0_D1 = 171;
    public static final int U_CARINFO_D47_D11_D12 = 179;
    public static final int U_CARINFO_D47_D13 = 180;
    public static final int U_CARINFO_D47_D14_D15 = 181;
    public static final int U_CARINFO_D47_D16 = 182;
    public static final int U_CARINFO_D47_D17_D18 = 183;
    public static final int U_CARINFO_D47_D19 = 184;
    public static final int U_CARINFO_D47_D20 = 185;
    public static final int U_CARINFO_D47_D2_D3 = 172;
    public static final int U_CARINFO_D47_D4 = 173;
    public static final int U_CARINFO_D47_D5 = 174;
    public static final int U_CARINFO_D47_D6 = 175;
    public static final int U_CARINFO_D47_D7 = 176;
    public static final int U_CARINFO_D47_D8 = 177;
    public static final int U_CARINFO_D47_D9_D10 = 178;
    public static final int U_CNT_MAX = 192;
    public static final int U_HOEM_LIGHT = 166;
    public static final int U_HOEM_LIGHT_ONOFF = 167;
    public static final int U_LIGHT_HEIGHT = 169;
    public static final int U_LIGHT_LEVL = 163;
    public static final int U_LIGHT_ONOFF = 164;
    public static final int U_PRESSURE_END = 162;
    public static final int U_PRESSURE_FL = 98;
    public static final int U_PRESSURE_FL_AIRLINK_FAST = 110;
    public static final int U_PRESSURE_FL_AIRLINK_SLOW = 109;
    public static final int U_PRESSURE_FL_CHECKSELF = 102;
    public static final int U_PRESSURE_FL_ELIGHT = 103;
    public static final int U_PRESSURE_FL_ENABLE = 150;
    public static final int U_PRESSURE_FL_HIGH = 152;
    public static final int U_PRESSURE_FL_HIGHTEMP = 105;
    public static final int U_PRESSURE_FL_HIGHTEMP_S = 106;
    public static final int U_PRESSURE_FL_HIGH_AIR = 108;
    public static final int U_PRESSURE_FL_LOSE = 101;
    public static final int U_PRESSURE_FL_LOW = 151;
    public static final int U_PRESSURE_FL_LOW_AIR = 107;
    public static final int U_PRESSURE_FL_SYSTERM = 100;
    public static final int U_PRESSURE_FL_TEMP = 99;
    public static final int U_PRESSURE_FL_VLOW = 104;
    public static final int U_PRESSURE_FR = 111;
    public static final int U_PRESSURE_FR_AIRLINK_FAST = 123;
    public static final int U_PRESSURE_FR_AIRLINK_SLOW = 122;
    public static final int U_PRESSURE_FR_CHECKSELF = 115;
    public static final int U_PRESSURE_FR_ELIGHT = 116;
    public static final int U_PRESSURE_FR_ENABLE = 153;
    public static final int U_PRESSURE_FR_HIGH = 155;
    public static final int U_PRESSURE_FR_HIGHTEMP = 118;
    public static final int U_PRESSURE_FR_HIGHTEMP_S = 119;
    public static final int U_PRESSURE_FR_HIGH_AIR = 121;
    public static final int U_PRESSURE_FR_LOSE = 114;
    public static final int U_PRESSURE_FR_LOW = 154;
    public static final int U_PRESSURE_FR_LOW_AIR = 120;
    public static final int U_PRESSURE_FR_SYSTERM = 113;
    public static final int U_PRESSURE_FR_TEMP = 112;
    public static final int U_PRESSURE_FR_VLOW = 117;
    public static final int U_PRESSURE_RL = 124;
    public static final int U_PRESSURE_RL_AIRLINK_FAST = 136;
    public static final int U_PRESSURE_RL_AIRLINK_SLOW = 135;
    public static final int U_PRESSURE_RL_CHECKSELF = 128;
    public static final int U_PRESSURE_RL_ELIGHT = 129;
    public static final int U_PRESSURE_RL_ENABLE = 156;
    public static final int U_PRESSURE_RL_HIGH = 158;
    public static final int U_PRESSURE_RL_HIGHTEMP = 131;
    public static final int U_PRESSURE_RL_HIGHTEMP_S = 132;
    public static final int U_PRESSURE_RL_HIGH_AIR = 134;
    public static final int U_PRESSURE_RL_LOSE = 127;
    public static final int U_PRESSURE_RL_LOW = 157;
    public static final int U_PRESSURE_RL_LOW_AIR = 133;
    public static final int U_PRESSURE_RL_SYSTERM = 126;
    public static final int U_PRESSURE_RL_TEMP = 125;
    public static final int U_PRESSURE_RL_VLOW = 130;
    public static final int U_PRESSURE_RR = 137;
    public static final int U_PRESSURE_RR_AIRLINK_FAST = 149;
    public static final int U_PRESSURE_RR_AIRLINK_SLOW = 148;
    public static final int U_PRESSURE_RR_CHECKSELF = 141;
    public static final int U_PRESSURE_RR_ELIGHT = 142;
    public static final int U_PRESSURE_RR_ENABLE = 159;
    public static final int U_PRESSURE_RR_HIGH = 161;
    public static final int U_PRESSURE_RR_HIGHTEMP = 144;
    public static final int U_PRESSURE_RR_HIGHTEMP_S = 145;
    public static final int U_PRESSURE_RR_HIGH_AIR = 147;
    public static final int U_PRESSURE_RR_LOSE = 140;
    public static final int U_PRESSURE_RR_LOW = 160;
    public static final int U_PRESSURE_RR_LOW_AIR = 146;
    public static final int U_PRESSURE_RR_SYSTERM = 139;
    public static final int U_PRESSURE_RR_TEMP = 138;
    public static final int U_PRESSURE_RR_VLOW = 143;
    public static final int U_ROAD_AWAY = 168;
    public static final int U_SEAT_PLEASE = 165;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 192; i++) {
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
        if (DataCanbus.DATA[1000] == 13697476) {
            //AirHelper.getInstance().buildUi(new Air_0452_RZC_LeTin_Mangguo(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0439_RZC_Changan_ZhongTai(LauncherApplication.getInstance()));
        }
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
        if (updateCode >= 0 && updateCode < 192) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
