package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0404_RZC_QiRUiGX;
import com.syu.ui.air.Air_0404_RZC_RuiHu7;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0404_RZC_XP1_QiRuiAiRuiZe5 extends CallbackCanbusBase {
    public static final int U_CARINFO_AMAY_ROAD = 102;
    public static final int U_CARINFO_AMBIENT_LIGHTt = 110;
    public static final int U_CARINFO_AUTO_LOCK = 89;
    public static final int U_CARINFO_AUTO_UNLOCK = 98;
    public static final int U_CARINFO_BEGIN = 85;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 90;
    public static final int U_CARINFO_BLIND_SIDE = 101;
    public static final int U_CARINFO_BLOWER_DELAY = 112;
    public static final int U_CARINFO_BLOWER_EARLY = 111;
    public static final int U_CARINFO_CHANGE_WAY_LIGHT = 107;
    public static final int U_CARINFO_D40_D1C_B70 = 114;
    public static final int U_CARINFO_D40_D1D_B70 = 115;
    public static final int U_CARINFO_D40_D1E_B70 = 116;
    public static final int U_CARINFO_D40_D1F_B70 = 117;
    public static final int U_CARINFO_D40_D20_B70 = 118;
    public static final int U_CARINFO_D40_D21_B70 = 119;
    public static final int U_CARINFO_D40_D22_B70 = 120;
    public static final int U_CARINFO_D40_D23_B70 = 121;
    public static final int U_CARINFO_D40_D24_B70 = 122;
    public static final int U_CARINFO_D40_D25_B70 = 123;
    public static final int U_CARINFO_D40_D26_B70 = 124;
    public static final int U_CARINFO_D40_D27_B70 = 125;
    public static final int U_CARINFO_D40_D28_B70 = 126;
    public static final int U_CARINFO_D40_D29_B70 = 127;
    public static final int U_CARINFO_D40_D2A_B70 = 128;
    public static final int U_CARINFO_D40_D2B_B70 = 146;
    public static final int U_CARINFO_D40_D2C_B70 = 147;
    public static final int U_CARINFO_D40_D2D_B70 = 148;
    public static final int U_CARINFO_D40_D2E_B70 = 149;
    public static final int U_CARINFO_D40_D2F_B70 = 150;
    public static final int U_CARINFO_D40_D30_B70 = 142;
    public static final int U_CARINFO_D40_D30_B70_RZC = 154;
    public static final int U_CARINFO_D40_D31_B70 = 143;
    public static final int U_CARINFO_D40_D31_B70_RZC = 155;
    public static final int U_CARINFO_D40_D32_B70 = 144;
    public static final int U_CARINFO_D40_D32_B70_RZC = 156;
    public static final int U_CARINFO_D40_D33_B70 = 145;
    public static final int U_CARINFO_D40_D33_B70_RZC = 157;
    public static final int U_CARINFO_D40_D34_B70 = 151;
    public static final int U_CARINFO_D40_D34_B70_RZC = 158;
    public static final int U_CARINFO_D40_D35_B70 = 152;
    public static final int U_CARINFO_D40_D35_B70_RZC = 159;
    public static final int U_CARINFO_D40_D36_B70_RZC = 160;
    public static final int U_CARINFO_D40_D37_B70_RZC = 161;
    public static final int U_CARINFO_D40_D38_B70_RZC = 162;
    public static final int U_CARINFO_D40_DFE_B70 = 129;
    public static final int U_CARINFO_D41_D0_B0 = 137;
    public static final int U_CARINFO_D41_D0_B1 = 136;
    public static final int U_CARINFO_D41_D0_B2 = 135;
    public static final int U_CARINFO_D41_D0_B3 = 134;
    public static final int U_CARINFO_D41_D0_B4 = 133;
    public static final int U_CARINFO_D41_D0_B5 = 132;
    public static final int U_CARINFO_D41_D0_B7 = 131;
    public static final int U_CARINFO_D41_D1_B70 = 138;
    public static final int U_CARINFO_D41_D2_B70 = 139;
    public static final int U_CARINFO_D41_D3_D4 = 140;
    public static final int U_CARINFO_D41_D5_B70 = 141;
    public static final int U_CARINFO_D41_D6_B70 = 153;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 96;
    public static final int U_CARINFO_DAYLIGHT = 91;
    public static final int U_CARINFO_EPS_SYSTERM = 109;
    public static final int U_CARINFO_GESTURE_KNOW = 104;
    public static final int U_CARINFO_GESTURE_WINDOW = 105;
    public static final int U_CARINFO_HOME_LIGHT = 106;
    public static final int U_CARINFO_LAN = 86;
    public static final int U_CARINFO_ONLY_REMOTE_OPEN_BACK_DOOR = 99;
    public static final int U_CARINFO_POWER_ON_SHOWS_POWER_FLOW = 100;
    public static final int U_CARINFO_REARVIEW_AUTO = 103;
    public static final int U_CARINFO_SPEED_ALARM = 95;
    public static final int U_CARINFO_STEERING_ANIM = 93;
    public static final int U_CARINFO_STEERING_AUXILIARY_LIGHTING = 97;
    public static final int U_CARINFO_STEERING_AVM = 92;
    public static final int U_CARINFO_TRUNK_DEGREE = 113;
    public static final int U_CARINFO_VEHICLE_GUIDES = 94;
    public static final int U_CARINFO_WARN = 87;
    public static final int U_CARINFO_WARN_EXIST = 88;
    public static final int U_CARINFO_WELCOME_LIGHT = 108;
    public static final int U_CARSET_RIGHT_VIEW = 130;
    public static final int U_CNT_MAX = 163;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 163) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 163; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        initDoor();
        if (DataCanbus.DATA[1000] == 262548 || DataCanbus.DATA[1000] == 393620 || DataCanbus.DATA[1000] == 459156 || DataCanbus.DATA[1000] == 590228 || DataCanbus.DATA[1000] == 655764 || DataCanbus.DATA[1000] == 328084) {
            AirHelper.getInstance().buildUi(new Air_0404_RZC_QiRUiGX(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0404_RZC_RuiHu7(LauncherApplication.getInstance()));
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void initDoor() {
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].addNotify(DoorHelper.getInstance(), 0);
        }
    }
}
