package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_LZ_Jaguar extends CallbackCanbusBase {
    public static final int U_AIR_BLOW_AUTO_REAR_L = 133;
    public static final int U_AIR_BLOW_AUTO_REAR_R = 136;
    public static final int U_AIR_BLOW_BODY_REAR = 142;
    public static final int U_AIR_BLOW_BODY_REAR_L = 131;
    public static final int U_AIR_BLOW_BODY_REAR_R = 134;
    public static final int U_AIR_BLOW_FOOT_REAR_L = 132;
    public static final int U_AIR_BLOW_FOOT_REAR_R = 135;
    public static final int U_AIR_REAR_LOCK = 130;
    public static final int U_AIR_REAR_TEMP_LEFT = 137;
    public static final int U_AIR_REAR_TEMP_RIGHT = 138;
    public static final int U_AIR_SEAT_HOT_RL = 128;
    public static final int U_AIR_SEAT_HOT_RR = 129;
    public static final int U_AIR_SEAT_LEFT = 123;
    public static final int U_AIR_SEAT_LEFT_REAR = 140;
    public static final int U_AIR_SEAT_MASSAGE_LEFT = 126;
    public static final int U_AIR_SEAT_MASSAGE_LEV_LEFT = 185;
    public static final int U_AIR_SEAT_MASSAGE_LEV_RIGHT = 187;
    public static final int U_AIR_SEAT_MASSAGE_RIGHT = 127;
    public static final int U_AIR_SEAT_MASSAGE_SET_LEFT = 186;
    public static final int U_AIR_SEAT_MASSAGE_SET_RIGHT = 188;
    public static final int U_AIR_SEAT_RIGHT = 125;
    public static final int U_AIR_SEAT_RIGHT_REAR = 143;
    public static final int U_AIR_WAIST_LEFT = 122;
    public static final int U_AIR_WAIST_LEFT_REAR = 139;
    public static final int U_AIR_WAIST_RIGHT = 124;
    public static final int U_AIR_WAIST_RIGHT_REAR = 141;
    public static final int U_CARINFO_AUTO_AVG_FUEL = 117;
    public static final int U_CARINFO_AUTO_AVG_SPEED = 119;
    public static final int U_CARINFO_AUTO_MILE = 118;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D29_D0_D1 = 189;
    public static final int U_CARINFO_D35_D1_B70 = 108;
    public static final int U_CARINFO_D35_D2_D3 = 109;
    public static final int U_CARINFO_D35_D4_D5 = 110;
    public static final int U_CARINFO_D38_D0_B0 = 106;
    public static final int U_CARINFO_D38_D0_B1 = 105;
    public static final int U_CARINFO_D38_D0_B2 = 104;
    public static final int U_CARINFO_D38_D0_B3 = 103;
    public static final int U_CARINFO_D38_D0_B4 = 102;
    public static final int U_CARINFO_D38_D0_B5 = 101;
    public static final int U_CARINFO_D38_D0_B6 = 100;
    public static final int U_CARINFO_D38_D0_B7 = 99;
    public static final int U_CARINFO_D38_D10_B0 = 182;
    public static final int U_CARINFO_D38_D10_B41 = 181;
    public static final int U_CARINFO_D38_D10_B65 = 180;
    public static final int U_CARINFO_D38_D10_B7 = 179;
    public static final int U_CARINFO_D38_D11_B5 = 184;
    public static final int U_CARINFO_D38_D11_B76 = 183;
    public static final int U_CARINFO_D38_D1_B70 = 107;
    public static final int U_CARINFO_D38_D2_B30 = 147;
    public static final int U_CARINFO_D38_D2_B4 = 146;
    public static final int U_CARINFO_D38_D2_B65 = 145;
    public static final int U_CARINFO_D38_D2_B7 = 144;
    public static final int U_CARINFO_D38_D3_B30 = 149;
    public static final int U_CARINFO_D38_D3_B74 = 148;
    public static final int U_CARINFO_D38_D4_B70 = 150;
    public static final int U_CARINFO_D38_D5_B70 = 151;
    public static final int U_CARINFO_D38_D6_B70 = 152;
    public static final int U_CARINFO_D38_D7_B70 = 153;
    public static final int U_CARINFO_D38_D8_B30 = 157;
    public static final int U_CARINFO_D38_D8_B4 = 156;
    public static final int U_CARINFO_D38_D8_B5 = 155;
    public static final int U_CARINFO_D38_D8_B76 = 154;
    public static final int U_CARINFO_D38_D9_B0 = 163;
    public static final int U_CARINFO_D38_D9_B1 = 162;
    public static final int U_CARINFO_D38_D9_B2 = 161;
    public static final int U_CARINFO_D38_D9_B3 = 160;
    public static final int U_CARINFO_D38_D9_B54 = 159;
    public static final int U_CARINFO_D38_D9_B76 = 158;
    public static final int U_CARINFO_D3C_D0_B70 = 164;
    public static final int U_CARINFO_D3C_D1_B70 = 165;
    public static final int U_CARINFO_D3C_D2_B70 = 166;
    public static final int U_CARINFO_D3C_D3_B70 = 167;
    public static final int U_CARINFO_D3C_D4_B70 = 168;
    public static final int U_CARINFO_D3C_D5_B70 = 169;
    public static final int U_CARINFO_D3C_D6_B30 = 170;
    public static final int U_CARINFO_D3D_D0_B70 = 171;
    public static final int U_CARINFO_D3D_D1_B2 = 177;
    public static final int U_CARINFO_D3D_D1_B3 = 176;
    public static final int U_CARINFO_D3D_D1_B4 = 175;
    public static final int U_CARINFO_D3D_D1_B5 = 174;
    public static final int U_CARINFO_D3D_D1_B6 = 173;
    public static final int U_CARINFO_D3D_D1_B7 = 172;
    public static final int U_CARINFO_MILE_UNIT = 121;
    public static final int U_CARINFO_TEMP_UNIT = 120;
    public static final int U_CARINFO_TRIPA_AVG_FUEL = 111;
    public static final int U_CARINFO_TRIPA_AVG_SPEED = 113;
    public static final int U_CARINFO_TRIPA_MILE = 112;
    public static final int U_CARINFO_TRIPB_AVG_FUEL = 114;
    public static final int U_CARINFO_TRIPB_AVG_SPEED = 116;
    public static final int U_CARINFO_TRIPB_MILE = 115;
    public static final int U_CAR_PANEL_KEY = 178;
    public static final int U_CNT_MAX = 190;

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
        //AirHelper.getInstance().buildUi(new Air_0452_LZ_Juguar(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
