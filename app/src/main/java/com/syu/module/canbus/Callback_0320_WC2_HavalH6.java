package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0320_WC2_HavalH6 extends CallbackCanbusBase {
    public static final int U_CARINFO2_ALTITUDE = 115;
    public static final int U_CARINFO2_BEGIN = 109;
    public static final int U_CARINFO2_FRONTWHEEL = 112;
    public static final int U_CARINFO2_INCLINATION = 113;
    public static final int U_CARINFO2_PRESSURE = 110;
    public static final int U_CARINFO2_SLOPE = 111;
    public static final int U_CARINFO2_STEER = 156;
    public static final int U_CARINFO2_TRAILER = 114;
    public static final int U_CARINFO_ALLTERRAIN = 128;
    public static final int U_CARINFO_ANTITHEFT_SET = 122;
    public static final int U_CARINFO_BATTERY_VOLGATE = 99;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_BIAOZHI_INFO = 131;
    public static final int U_CARINFO_CARTOP_MODE = 127;
    public static final int U_CARINFO_CETA_SET = 126;
    public static final int U_CARINFO_COLLISION_SAFE = 133;
    public static final int U_CARINFO_COLOR_MONOR = 139;
    public static final int U_CARINFO_COOLANT_TEMP = 100;
    public static final int U_CARINFO_D62_D2_B31 = 159;
    public static final int U_CARINFO_D62_D2_B54 = 158;
    public static final int U_CARINFO_D62_D2_B76 = 157;
    public static final int U_CARINFO_D62_D3_B31 = 162;
    public static final int U_CARINFO_D62_D3_B54 = 161;
    public static final int U_CARINFO_D62_D3_B76 = 160;
    public static final int U_CARINFO_D62_D4_B0 = 167;
    public static final int U_CARINFO_D62_D4_B1 = 166;
    public static final int U_CARINFO_D62_D4_B32 = 165;
    public static final int U_CARINFO_D62_D4_B54 = 164;
    public static final int U_CARINFO_D62_D4_B76 = 163;
    public static final int U_CARINFO_D62_D5_B2 = 172;
    public static final int U_CARINFO_D62_D5_B3 = 171;
    public static final int U_CARINFO_D62_D5_B4 = 170;
    public static final int U_CARINFO_D62_D5_B65 = 169;
    public static final int U_CARINFO_D62_D5_B7 = 168;
    public static final int U_CARINFO_D62_D6_B5 = 175;
    public static final int U_CARINFO_D62_D6_B6 = 174;
    public static final int U_CARINFO_D62_D6_B7 = 173;
    public static final int U_CARINFO_D67_D0_B10 = 181;
    public static final int U_CARINFO_D67_D0_B5 = 177;
    public static final int U_CARINFO_D67_D0_B76 = 176;
    public static final int U_CARINFO_D68_D0_B5 = 152;
    public static final int U_CARINFO_D68_D0_B6 = 151;
    public static final int U_CARINFO_D68_D0_B7 = 150;
    public static final int U_CARINFO_D68_D1_B0 = 153;
    public static final int U_CARINFO_D68_D2_B2 = 182;
    public static final int U_CARINFO_D68_D3_B0 = 141;
    public static final int U_CARINFO_D68_D3_B1 = 140;
    public static final int U_CARINFO_D68_D3_B32 = 155;
    public static final int U_CARINFO_D68_D3_B4 = 154;
    public static final int U_CARINFO_D68_D4_B20 = 180;
    public static final int U_CARINFO_D68_D4_B3 = 179;
    public static final int U_CARINFO_D68_D4_B54 = 178;
    public static final int U_CARINFO_D68_D4_B6 = 183;
    public static final int U_CARINFO_D68_D5_B10 = 188;
    public static final int U_CARINFO_D68_D5_B2 = 187;
    public static final int U_CARINFO_D68_D5_B3 = 186;
    public static final int U_CARINFO_D68_D5_B4 = 185;
    public static final int U_CARINFO_D68_D5_B75 = 184;
    public static final int U_CARINFO_DA6_D0_B70 = 142;
    public static final int U_CARINFO_DA6_D1_B70 = 143;
    public static final int U_CARINFO_DA6_D2_B70 = 144;
    public static final int U_CARINFO_DA6_D3_B70 = 145;
    public static final int U_CARINFO_DA6_D4_B70 = 146;
    public static final int U_CARINFO_DA6_D5_B70 = 147;
    public static final int U_CARINFO_DA6_D6_B10 = 149;
    public static final int U_CARINFO_DA6_D6_B32 = 148;
    public static final int U_CARINFO_DOMEDELAY = 116;
    public static final int U_CARINFO_DOORLOCK_SET = 124;
    public static final int U_CARINFO_FATIGUE_WARN = 132;
    public static final int U_CARINFO_FOLLOWHOME = 117;
    public static final int U_CARINFO_FRONTLIGHT_MODE = 120;
    public static final int U_CARINFO_OPENDOOR_WARN = 138;
    public static final int U_CARINFO_PARALLEL_SYS = 136;
    public static final int U_CARINFO_PARK_SET = 121;
    public static final int U_CARINFO_PEDESTRIAN_SAFE = 134;
    public static final int U_CARINFO_POWERSAVE = 118;
    public static final int U_CARINFO_RAINFALLSENSOR = 119;
    public static final int U_CARINFO_REARVIEW_AUTO = 123;
    public static final int U_CARINFO_REARVIEW_SIDE_SYS = 137;
    public static final int U_CARINFO_ROADAWAY_WARN = 130;
    public static final int U_CARINFO_SEAT_MEMORY = 125;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 101;
    public static final int U_CARINFO_WARN_SNESOR = 135;
    public static final int U_CNT_MAX = 189;
    public static final int U_CUR_SPEED = 105;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 104;
    public static final int U_ENGINE_SPEED = 106;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 103;
    public static final int U_REAR_MIRROR = 107;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 102;
    public static final int U_SMART_STARTSOTP = 108;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 129;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 189; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0320_WC2_HavaH6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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
        if (updateCode >= 0 && updateCode < 189) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
