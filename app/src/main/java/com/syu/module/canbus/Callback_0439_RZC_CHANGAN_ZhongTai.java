package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Changan_ZhongTai;
import com.syu.ui.air.Air_0452_RZC_LeTin_Mangguo;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_CHANGAN_ZhongTai extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_SET_CTRL = 1;
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_ACMAX = 26;
    public static final int U_AIR_AQS = 24;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTO2 = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_ECO = 25;
    public static final int U_AIR_END = 29;
    public static final int U_AIR_FRONT_DEFROST = 22;
    public static final int U_AIR_HEAT = 103;
    public static final int U_AIR_ION = 127;
    public static final int U_AIR_MAXFRONT = 13;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR = 14;
    public static final int U_AIR_REAR_DEFROST = 23;
    public static final int U_AIR_REAR_MODE = 120;
    public static final int U_AIR_SEATHEAT_LEFT = 27;
    public static final int U_AIR_SEATHEAT_RIGHT = 28;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_TEMP_UNIT = 19;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CARINFO_BEGIN = 104;
    public static final int U_CARINFO_D24_D2_B30 = 122;
    public static final int U_CARINFO_D24_D2_B74 = 121;
    public static final int U_CARINFO_D24_D3_B7 = 123;
    public static final int U_CARINFO_D41_D2_B30 = 126;
    public static final int U_CARINFO_D41_D2_B64 = 125;
    public static final int U_CARINFO_D41_D2_B7 = 124;
    public static final int U_CARINFO_D47_D0_D1 = 105;
    public static final int U_CARINFO_D47_D11_D12 = 113;
    public static final int U_CARINFO_D47_D13 = 114;
    public static final int U_CARINFO_D47_D14_D15 = 115;
    public static final int U_CARINFO_D47_D16 = 116;
    public static final int U_CARINFO_D47_D17_D18 = 117;
    public static final int U_CARINFO_D47_D19 = 118;
    public static final int U_CARINFO_D47_D20 = 119;
    public static final int U_CARINFO_D47_D2_D3 = 106;
    public static final int U_CARINFO_D47_D4 = 107;
    public static final int U_CARINFO_D47_D5 = 108;
    public static final int U_CARINFO_D47_D6 = 109;
    public static final int U_CARINFO_D47_D7 = 110;
    public static final int U_CARINFO_D47_D8 = 111;
    public static final int U_CARINFO_D47_D9_D10 = 112;
    public static final int U_CNT_MAX = 128;
    public static final int U_HOEM_LIGHT = 98;
    public static final int U_HOEM_LIGHT_ONOFF = 99;
    public static final int U_JUMP_CARAIR = 101;
    public static final int U_LIGHT_HEIGHT = 102;
    public static final int U_LIGHT_LEVL = 95;
    public static final int U_LIGHT_ONOFF = 96;
    public static final int U_PRESSURE_END = 94;
    public static final int U_PRESSURE_FL = 30;
    public static final int U_PRESSURE_FL_AIRLINK_FAST = 42;
    public static final int U_PRESSURE_FL_AIRLINK_SLOW = 41;
    public static final int U_PRESSURE_FL_CHECKSELF = 34;
    public static final int U_PRESSURE_FL_ELIGHT = 35;
    public static final int U_PRESSURE_FL_ENABLE = 82;
    public static final int U_PRESSURE_FL_HIGH = 84;
    public static final int U_PRESSURE_FL_HIGHTEMP = 37;
    public static final int U_PRESSURE_FL_HIGHTEMP_S = 38;
    public static final int U_PRESSURE_FL_HIGH_AIR = 40;
    public static final int U_PRESSURE_FL_LOSE = 33;
    public static final int U_PRESSURE_FL_LOW = 83;
    public static final int U_PRESSURE_FL_LOW_AIR = 39;
    public static final int U_PRESSURE_FL_SYSTERM = 32;
    public static final int U_PRESSURE_FL_TEMP = 31;
    public static final int U_PRESSURE_FL_VLOW = 36;
    public static final int U_PRESSURE_FR = 43;
    public static final int U_PRESSURE_FR_AIRLINK_FAST = 55;
    public static final int U_PRESSURE_FR_AIRLINK_SLOW = 54;
    public static final int U_PRESSURE_FR_CHECKSELF = 47;
    public static final int U_PRESSURE_FR_ELIGHT = 48;
    public static final int U_PRESSURE_FR_ENABLE = 85;
    public static final int U_PRESSURE_FR_HIGH = 87;
    public static final int U_PRESSURE_FR_HIGHTEMP = 50;
    public static final int U_PRESSURE_FR_HIGHTEMP_S = 51;
    public static final int U_PRESSURE_FR_HIGH_AIR = 53;
    public static final int U_PRESSURE_FR_LOSE = 46;
    public static final int U_PRESSURE_FR_LOW = 86;
    public static final int U_PRESSURE_FR_LOW_AIR = 52;
    public static final int U_PRESSURE_FR_SYSTERM = 45;
    public static final int U_PRESSURE_FR_TEMP = 44;
    public static final int U_PRESSURE_FR_VLOW = 49;
    public static final int U_PRESSURE_RL = 56;
    public static final int U_PRESSURE_RL_AIRLINK_FAST = 68;
    public static final int U_PRESSURE_RL_AIRLINK_SLOW = 67;
    public static final int U_PRESSURE_RL_CHECKSELF = 60;
    public static final int U_PRESSURE_RL_ELIGHT = 61;
    public static final int U_PRESSURE_RL_ENABLE = 88;
    public static final int U_PRESSURE_RL_HIGH = 90;
    public static final int U_PRESSURE_RL_HIGHTEMP = 63;
    public static final int U_PRESSURE_RL_HIGHTEMP_S = 64;
    public static final int U_PRESSURE_RL_HIGH_AIR = 66;
    public static final int U_PRESSURE_RL_LOSE = 59;
    public static final int U_PRESSURE_RL_LOW = 89;
    public static final int U_PRESSURE_RL_LOW_AIR = 65;
    public static final int U_PRESSURE_RL_SYSTERM = 58;
    public static final int U_PRESSURE_RL_TEMP = 57;
    public static final int U_PRESSURE_RL_VLOW = 62;
    public static final int U_PRESSURE_RR = 69;
    public static final int U_PRESSURE_RR_AIRLINK_FAST = 81;
    public static final int U_PRESSURE_RR_AIRLINK_SLOW = 80;
    public static final int U_PRESSURE_RR_CHECKSELF = 73;
    public static final int U_PRESSURE_RR_ELIGHT = 74;
    public static final int U_PRESSURE_RR_ENABLE = 91;
    public static final int U_PRESSURE_RR_HIGH = 93;
    public static final int U_PRESSURE_RR_HIGHTEMP = 76;
    public static final int U_PRESSURE_RR_HIGHTEMP_S = 77;
    public static final int U_PRESSURE_RR_HIGH_AIR = 79;
    public static final int U_PRESSURE_RR_LOSE = 72;
    public static final int U_PRESSURE_RR_LOW = 92;
    public static final int U_PRESSURE_RR_LOW_AIR = 78;
    public static final int U_PRESSURE_RR_SYSTERM = 71;
    public static final int U_PRESSURE_RR_TEMP = 70;
    public static final int U_PRESSURE_RR_VLOW = 75;
    public static final int U_ROAD_AWAY = 100;
    public static final int U_SEAT_PLEASE = 97;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 128; i++) {
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
            AirHelper.getInstance().buildUi(new Air_0452_RZC_LeTin_Mangguo(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[103].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else {
            AirHelper.getInstance().buildUi(new Air_0439_RZC_Changan_ZhongTai(LauncherApplication.getInstance()));
        }
        for (int i3 = 7; i3 < 29; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 29; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 128) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
