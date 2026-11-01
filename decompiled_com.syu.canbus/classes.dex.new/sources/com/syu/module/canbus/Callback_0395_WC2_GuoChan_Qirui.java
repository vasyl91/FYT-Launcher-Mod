package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0395_WC2_RuiHu3X;
import com.syu.ui.air.Air_0395_WC2_RuiHu5;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0395_WC2_GuoChan_Qirui extends CallbackCanbusBase {
    public static final int U_CARINFO_AUTO_FOLD_REARVIEW = 113;
    public static final int U_CARINFO_AUTO_LOCK = 103;
    public static final int U_CARINFO_AUTO_UNLOCK = 112;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_BIGLIGHT_SLEEP = 104;
    public static final int U_CARINFO_BLIND_SIDE = 114;
    public static final int U_CARINFO_D61_D2_B0 = 128;
    public static final int U_CARINFO_D61_D2_B1 = 127;
    public static final int U_CARINFO_D61_D2_B2 = 126;
    public static final int U_CARINFO_D61_D2_B53 = 125;
    public static final int U_CARINFO_D61_D3_B70 = 129;
    public static final int U_CARINFO_D61_D4_B0 = 134;
    public static final int U_CARINFO_D61_D4_B1 = 133;
    public static final int U_CARINFO_D61_D4_B32 = 132;
    public static final int U_CARINFO_D61_D4_B4 = 131;
    public static final int U_CARINFO_D61_D4_B5 = 130;
    public static final int U_CARINFO_D87_D3_B5 = 135;
    public static final int U_CARINFO_D87_D6_B0 = 124;
    public static final int U_CARINFO_D87_D6_B1 = 123;
    public static final int U_CARINFO_D87_D6_B2 = 122;
    public static final int U_CARINFO_D87_D6_B5 = 121;
    public static final int U_CARINFO_DASHBOARD_BACKLIGHT = 110;
    public static final int U_CARINFO_DAYLIGHT = 105;
    public static final int U_CARINFO_ENGIN_SPEED = 99;
    public static final int U_CARINFO_EPS_MODE = 117;
    public static final int U_CARINFO_FORTIFICATION_PROMPT = 116;
    public static final int U_CARINFO_HAND_ENABLE = 119;
    public static final int U_CARINFO_HAND_SKYWIN = 120;
    public static final int U_CARINFO_REMOTE_BACK = 111;
    public static final int U_CARINFO_ROAD_AWAY = 115;
    public static final int U_CARINFO_SPEED_ALARM = 109;
    public static final int U_CARINFO_STEERING_ANIM = 107;
    public static final int U_CARINFO_STEERING_AVM = 106;
    public static final int U_CARINFO_VEHICLE_GUIDES = 108;
    public static final int U_CARINFO_WARN_EXIST = 100;
    public static final int U_CARINFO_WARN_SWITCH = 101;
    public static final int U_CARINFO_WARN_TYPE = 102;
    public static final int U_CARINFO_WELCOME_ONOFF = 118;
    public static final int U_CNT_MAX = 136;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 136) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 136; i++) {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_WC2_GUOCHAN_8 /* 524683 */:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu3X(TheApp.getInstance()));
                break;
            case FinalCanbus.CAR_WC2_GUOCHAN_10 /* 655755 */:
            case 1638795:
            case FinalCanbus.CAR_WC2_Qirui_M1AEVFL1 /* 2687371 */:
                break;
            default:
                AirHelper.getInstance().buildUi(new Air_0395_WC2_RuiHu5(TheApp.getInstance()));
                break;
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
}
