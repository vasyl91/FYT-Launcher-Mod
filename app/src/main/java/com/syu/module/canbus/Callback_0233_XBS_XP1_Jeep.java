package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0233_XBS_XP1_Jeep extends CallbackCanbusBase {
    public static final int C_CARSET_0bD000 = 5;
    public static final int C_CARSET_0bD001 = 4;
    public static final int C_CARSET_0bD002 = 3;
    public static final int C_CARSET_0bD004 = 2;
    public static final int C_CARSET_0bD006 = 1;
    public static final int C_CARSET_0bD010 = 12;
    public static final int C_CARSET_0bD012 = 11;
    public static final int C_CARSET_0bD013 = 10;
    public static final int C_CARSET_0bD014 = 9;
    public static final int C_CARSET_0bD015 = 8;
    public static final int C_CARSET_0bD016 = 7;
    public static final int C_CARSET_0bD017 = 6;
    public static final int C_CARSET_0bD020 = 17;
    public static final int C_CARSET_0bD022 = 16;
    public static final int C_CARSET_0bD024 = 15;
    public static final int C_CARSET_0bD025 = 14;
    public static final int C_CARSET_0bD026 = 13;
    public static final int C_CARSET_0bD036 = 19;
    public static final int C_CARSET_0bD037 = 18;
    public static final int C_CARSET_0bD040 = 26;
    public static final int C_CARSET_0bD041 = 25;
    public static final int C_CARSET_0bD042 = 24;
    public static final int C_CARSET_0bD043 = 23;
    public static final int C_CARSET_0bD044 = 22;
    public static final int C_CARSET_0bD046 = 21;
    public static final int C_CARSET_0bD047 = 20;
    public static final int C_CARSET_0bD050 = 29;
    public static final int C_CARSET_0bD052 = 28;
    public static final int C_CARSET_0bD054 = 27;
    public static final int C_CARSET_0bD060 = 31;
    public static final int C_CARSET_0bD064 = 30;
    public static final int C_CARSET_0bD070 = 39;
    public static final int C_CARSET_0bD071 = 38;
    public static final int C_CARSET_0bD072 = 37;
    public static final int C_CARSET_0bD073 = 36;
    public static final int C_CARSET_0bD074 = 35;
    public static final int C_CARSET_0bD075 = 34;
    public static final int C_CARSET_0bD076 = 33;
    public static final int C_CARSET_0bD077 = 32;
    public static final int C_CARSET_0bD080 = 45;
    public static final int C_CARSET_0bD081 = 44;
    public static final int C_CARSET_0bD082 = 43;
    public static final int C_CARSET_0bD084 = 42;
    public static final int C_CARSET_0bD085 = 41;
    public static final int C_CARSET_0bD086 = 40;
    public static final int C_CARSET_0bD090 = 50;
    public static final int C_CARSET_0bD091 = 49;
    public static final int C_CARSET_0bD092 = 48;
    public static final int C_CARSET_0bD093 = 47;
    public static final int C_CARSET_0bD094 = 46;
    public static final int C_CARSET_0bD100 = 55;
    public static final int C_CARSET_0bD101 = 54;
    public static final int C_CARSET_0bD102 = 53;
    public static final int C_CARSET_0bD103 = 52;
    public static final int C_CARSET_0bD105 = 51;
    public static final int C_CARSET_0bD110 = 56;
    public static final int C_CARSET_ASK = 57;
    public static final int C_CARSET_STAR = 0;
    public static final int U_CARSET_0bD000 = 67;
    public static final int U_CARSET_0bD000_ENABLE = 11;
    public static final int U_CARSET_0bD001 = 66;
    public static final int U_CARSET_0bD001_ENABLE = 10;
    public static final int U_CARSET_0bD002 = 65;
    public static final int U_CARSET_0bD002_ENABLE = 9;
    public static final int U_CARSET_0bD004 = 64;
    public static final int U_CARSET_0bD004_ENABLE = 8;
    public static final int U_CARSET_0bD006 = 63;
    public static final int U_CARSET_0bD006_ENABLE = 7;
    public static final int U_CARSET_0bD010 = 74;
    public static final int U_CARSET_0bD010_ENABLE = 18;
    public static final int U_CARSET_0bD012 = 73;
    public static final int U_CARSET_0bD012_ENABLE = 17;
    public static final int U_CARSET_0bD013 = 72;
    public static final int U_CARSET_0bD013_ENABLE = 16;
    public static final int U_CARSET_0bD014 = 71;
    public static final int U_CARSET_0bD014_ENABLE = 15;
    public static final int U_CARSET_0bD015 = 70;
    public static final int U_CARSET_0bD015_ENABLE = 14;
    public static final int U_CARSET_0bD016 = 69;
    public static final int U_CARSET_0bD016_ENABLE = 13;
    public static final int U_CARSET_0bD017 = 68;
    public static final int U_CARSET_0bD017_ENABLE = 12;
    public static final int U_CARSET_0bD020 = 79;
    public static final int U_CARSET_0bD020_ENABLE = 23;
    public static final int U_CARSET_0bD022 = 78;
    public static final int U_CARSET_0bD022_ENABLE = 22;
    public static final int U_CARSET_0bD024 = 77;
    public static final int U_CARSET_0bD024_ENABLE = 21;
    public static final int U_CARSET_0bD025 = 76;
    public static final int U_CARSET_0bD025_ENABLE = 20;
    public static final int U_CARSET_0bD026 = 75;
    public static final int U_CARSET_0bD026_ENABLE = 19;
    public static final int U_CARSET_0bD036 = 81;
    public static final int U_CARSET_0bD036_ENABLE = 25;
    public static final int U_CARSET_0bD037 = 80;
    public static final int U_CARSET_0bD037_ENABLE = 24;
    public static final int U_CARSET_0bD040 = 88;
    public static final int U_CARSET_0bD040_ENABLE = 32;
    public static final int U_CARSET_0bD041 = 87;
    public static final int U_CARSET_0bD041_ENABLE = 31;
    public static final int U_CARSET_0bD042 = 86;
    public static final int U_CARSET_0bD042_ENABLE = 30;
    public static final int U_CARSET_0bD043 = 85;
    public static final int U_CARSET_0bD043_ENABLE = 29;
    public static final int U_CARSET_0bD044 = 84;
    public static final int U_CARSET_0bD044_ENABLE = 28;
    public static final int U_CARSET_0bD046 = 83;
    public static final int U_CARSET_0bD046_ENABLE = 27;
    public static final int U_CARSET_0bD047 = 82;
    public static final int U_CARSET_0bD047_ENABLE = 26;
    public static final int U_CARSET_0bD050 = 91;
    public static final int U_CARSET_0bD050_ENABLE = 35;
    public static final int U_CARSET_0bD052 = 90;
    public static final int U_CARSET_0bD052_ENABLE = 34;
    public static final int U_CARSET_0bD054 = 89;
    public static final int U_CARSET_0bD054_ENABLE = 33;
    public static final int U_CARSET_0bD060 = 93;
    public static final int U_CARSET_0bD060_ENABLE = 37;
    public static final int U_CARSET_0bD064 = 92;
    public static final int U_CARSET_0bD064_ENABLE = 36;
    public static final int U_CARSET_0bD070 = 101;
    public static final int U_CARSET_0bD070_ENABLE = 45;
    public static final int U_CARSET_0bD071 = 100;
    public static final int U_CARSET_0bD071_ENABLE = 44;
    public static final int U_CARSET_0bD072 = 99;
    public static final int U_CARSET_0bD072_ENABLE = 43;
    public static final int U_CARSET_0bD073 = 98;
    public static final int U_CARSET_0bD073_ENABLE = 42;
    public static final int U_CARSET_0bD074 = 97;
    public static final int U_CARSET_0bD074_ENABLE = 41;
    public static final int U_CARSET_0bD075 = 96;
    public static final int U_CARSET_0bD075_ENABLE = 40;
    public static final int U_CARSET_0bD076 = 95;
    public static final int U_CARSET_0bD076_ENABLE = 39;
    public static final int U_CARSET_0bD077 = 94;
    public static final int U_CARSET_0bD077_ENABLE = 38;
    public static final int U_CARSET_0bD080 = 107;
    public static final int U_CARSET_0bD080_ENABLE = 51;
    public static final int U_CARSET_0bD081 = 106;
    public static final int U_CARSET_0bD081_ENABLE = 50;
    public static final int U_CARSET_0bD082 = 105;
    public static final int U_CARSET_0bD082_ENABLE = 49;
    public static final int U_CARSET_0bD084 = 104;
    public static final int U_CARSET_0bD084_ENABLE = 48;
    public static final int U_CARSET_0bD085 = 103;
    public static final int U_CARSET_0bD085_ENABLE = 47;
    public static final int U_CARSET_0bD086 = 102;
    public static final int U_CARSET_0bD086_ENABLE = 46;
    public static final int U_CARSET_0bD090 = 112;
    public static final int U_CARSET_0bD090_ENABLE = 56;
    public static final int U_CARSET_0bD091 = 111;
    public static final int U_CARSET_0bD091_ENABLE = 55;
    public static final int U_CARSET_0bD092 = 110;
    public static final int U_CARSET_0bD092_ENABLE = 54;
    public static final int U_CARSET_0bD093 = 109;
    public static final int U_CARSET_0bD093_ENABLE = 53;
    public static final int U_CARSET_0bD094 = 108;
    public static final int U_CARSET_0bD094_ENABLE = 52;
    public static final int U_CARSET_0bD100 = 117;
    public static final int U_CARSET_0bD100_ENABLE = 61;
    public static final int U_CARSET_0bD101 = 116;
    public static final int U_CARSET_0bD101_ENABLE = 60;
    public static final int U_CARSET_0bD102 = 115;
    public static final int U_CARSET_0bD102_ENABLE = 59;
    public static final int U_CARSET_0bD103 = 114;
    public static final int U_CARSET_0bD103_ENABLE = 58;
    public static final int U_CARSET_0bD105 = 113;
    public static final int U_CARSET_0bD105_ENABLE = 57;
    public static final int U_CARSET_0bD110 = 118;
    public static final int U_CARSET_0bD110_ENABLE = 62;
    public static final int U_CNT_MAX = 119;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
