package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Juguar;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Jaguar extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AC_MAX = 54;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_AUTO_LEV = 21;
    public static final int U_AIR_AUTO_WIND = 22;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 17;
    public static final int U_AIR_BLOW_AUTO_REAR_L = 71;
    public static final int U_AIR_BLOW_AUTO_REAR_R = 74;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 59;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_BODY_REAR = 115;
    public static final int U_AIR_BLOW_BODY_REAR_L = 69;
    public static final int U_AIR_BLOW_BODY_REAR_R = 72;
    public static final int U_AIR_BLOW_BODY_RIGHT = 57;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_REAR_L = 70;
    public static final int U_AIR_BLOW_FOOT_REAR_R = 73;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 58;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_BLOW_UP_RIGHT = 56;
    public static final int U_AIR_CLIMATE = 52;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_ECO = 11;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_FRONT_HOT = 55;
    public static final int U_AIR_NANOE = 118;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_POWER_REAR = 116;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_REAR_LOCK = 68;
    public static final int U_AIR_SEAT_HOT_LEFT = 24;
    public static final int U_AIR_SEAT_HOT_RIGHT = 25;
    public static final int U_AIR_SEAT_HOT_RL = 66;
    public static final int U_AIR_SEAT_HOT_RR = 67;
    public static final int U_AIR_SEAT_LEFT = 61;
    public static final int U_AIR_SEAT_LEFT_REAR = 78;
    public static final int U_AIR_SEAT_MASSAGE_LEFT = 64;
    public static final int U_AIR_SEAT_MASSAGE_LEV_LEFT = 126;
    public static final int U_AIR_SEAT_MASSAGE_LEV_RIGHT = 128;
    public static final int U_AIR_SEAT_MASSAGE_RIGHT = 65;
    public static final int U_AIR_SEAT_MASSAGE_SET_LEFT = 127;
    public static final int U_AIR_SEAT_MASSAGE_SET_RIGHT = 129;
    public static final int U_AIR_SEAT_RIGHT = 63;
    public static final int U_AIR_SEAT_RIGHT_REAR = 80;
    public static final int U_AIR_SEAT_SHOW = 53;
    public static final int U_AIR_STEER_HOT = 23;
    public static final int U_AIR_SYNC = 51;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_REAR_LEFT = 75;
    public static final int U_AIR_TEMP_REAR_RIGHT = 76;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WAIST_LEFT = 60;
    public static final int U_AIR_WAIST_LEFT_REAR = 77;
    public static final int U_AIR_WAIST_RIGHT = 62;
    public static final int U_AIR_WAIST_RIGHT_REAR = 79;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_AIR_WIN_LEV_REAR = 117;
    public static final int U_CARINFO_AUTO_AVG_FUEL = 46;
    public static final int U_CARINFO_AUTO_AVG_SPEED = 48;
    public static final int U_CARINFO_AUTO_MILE = 47;
    public static final int U_CARINFO_BEGIN = 27;
    public static final int U_CARINFO_D29_D0_D1 = 130;
    public static final int U_CARINFO_D35_D1_B70 = 37;
    public static final int U_CARINFO_D35_D2_D3 = 38;
    public static final int U_CARINFO_D35_D4_D5 = 39;
    public static final int U_CARINFO_D38_D0_B0 = 35;
    public static final int U_CARINFO_D38_D0_B1 = 34;
    public static final int U_CARINFO_D38_D0_B2 = 33;
    public static final int U_CARINFO_D38_D0_B3 = 32;
    public static final int U_CARINFO_D38_D0_B4 = 31;
    public static final int U_CARINFO_D38_D0_B5 = 30;
    public static final int U_CARINFO_D38_D0_B6 = 29;
    public static final int U_CARINFO_D38_D0_B7 = 28;
    public static final int U_CARINFO_D38_D10_B0 = 123;
    public static final int U_CARINFO_D38_D10_B41 = 122;
    public static final int U_CARINFO_D38_D10_B65 = 121;
    public static final int U_CARINFO_D38_D10_B7 = 120;
    public static final int U_CARINFO_D38_D11_B5 = 125;
    public static final int U_CARINFO_D38_D11_B76 = 124;
    public static final int U_CARINFO_D38_D1_B70 = 36;
    public static final int U_CARINFO_D38_D2_B30 = 84;
    public static final int U_CARINFO_D38_D2_B4 = 83;
    public static final int U_CARINFO_D38_D2_B65 = 82;
    public static final int U_CARINFO_D38_D2_B7 = 81;
    public static final int U_CARINFO_D38_D3_B30 = 86;
    public static final int U_CARINFO_D38_D3_B74 = 85;
    public static final int U_CARINFO_D38_D4_B70 = 87;
    public static final int U_CARINFO_D38_D5_B70 = 88;
    public static final int U_CARINFO_D38_D6_B70 = 89;
    public static final int U_CARINFO_D38_D7_B70 = 90;
    public static final int U_CARINFO_D38_D8_B30 = 94;
    public static final int U_CARINFO_D38_D8_B4 = 93;
    public static final int U_CARINFO_D38_D8_B5 = 92;
    public static final int U_CARINFO_D38_D8_B76 = 91;
    public static final int U_CARINFO_D38_D9_B0 = 100;
    public static final int U_CARINFO_D38_D9_B1 = 99;
    public static final int U_CARINFO_D38_D9_B2 = 98;
    public static final int U_CARINFO_D38_D9_B3 = 97;
    public static final int U_CARINFO_D38_D9_B54 = 96;
    public static final int U_CARINFO_D38_D9_B76 = 95;
    public static final int U_CARINFO_D3C_D0_B70 = 101;
    public static final int U_CARINFO_D3C_D1_B70 = 102;
    public static final int U_CARINFO_D3C_D2_B70 = 103;
    public static final int U_CARINFO_D3C_D3_B70 = 104;
    public static final int U_CARINFO_D3C_D4_B70 = 105;
    public static final int U_CARINFO_D3C_D5_B70 = 106;
    public static final int U_CARINFO_D3C_D6_B30 = 107;
    public static final int U_CARINFO_D3D_D0_B70 = 108;
    public static final int U_CARINFO_D3D_D1_B2 = 114;
    public static final int U_CARINFO_D3D_D1_B3 = 113;
    public static final int U_CARINFO_D3D_D1_B4 = 112;
    public static final int U_CARINFO_D3D_D1_B5 = 111;
    public static final int U_CARINFO_D3D_D1_B6 = 110;
    public static final int U_CARINFO_D3D_D1_B7 = 109;
    public static final int U_CARINFO_MILE_UNIT = 50;
    public static final int U_CARINFO_TEMP_UNIT = 49;
    public static final int U_CARINFO_TRIPA_AVG_FUEL = 40;
    public static final int U_CARINFO_TRIPA_AVG_SPEED = 42;
    public static final int U_CARINFO_TRIPA_MILE = 41;
    public static final int U_CARINFO_TRIPB_AVG_FUEL = 43;
    public static final int U_CARINFO_TRIPB_AVG_SPEED = 45;
    public static final int U_CARINFO_TRIPB_MILE = 44;
    public static final int U_CAR_PANEL_KEY = 119;
    public static final int U_CNT_MAX = 131;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Juguar(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 26; i++) {
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
        if (updateCode >= 0 && updateCode < 131) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
