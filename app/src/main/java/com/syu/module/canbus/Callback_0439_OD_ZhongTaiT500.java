package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_OD_ZhongTaiT500 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 166;
    public static final int U_LIGHT_LEVL = 162;
    public static final int U_LIGHT_ONOFF = 163;
    public static final int U_MISC_BEGIN = 97;
    public static final int U_MISC_END = 165;
    public static final int U_PRESSURE_FL = 102;
    public static final int U_PRESSURE_FL_AIRLINK_FAST = 128;
    public static final int U_PRESSURE_FL_AIRLINK_SLOW = 127;
    public static final int U_PRESSURE_FL_CHECKSELF = 120;
    public static final int U_PRESSURE_FL_ELIGHT = 121;
    public static final int U_PRESSURE_FL_ENABLE = 106;
    public static final int U_PRESSURE_FL_HIGH = 108;
    public static final int U_PRESSURE_FL_HIGHTEMP = 123;
    public static final int U_PRESSURE_FL_HIGHTEMP_S = 124;
    public static final int U_PRESSURE_FL_HIGH_AIR = 126;
    public static final int U_PRESSURE_FL_LOSE = 119;
    public static final int U_PRESSURE_FL_LOW = 107;
    public static final int U_PRESSURE_FL_LOW_AIR = 125;
    public static final int U_PRESSURE_FL_SYSTERM = 118;
    public static final int U_PRESSURE_FL_TEMP = 98;
    public static final int U_PRESSURE_FL_VLOW = 122;
    public static final int U_PRESSURE_FR = 103;
    public static final int U_PRESSURE_FR_AIRLINK_FAST = 139;
    public static final int U_PRESSURE_FR_AIRLINK_SLOW = 138;
    public static final int U_PRESSURE_FR_CHECKSELF = 131;
    public static final int U_PRESSURE_FR_ELIGHT = 132;
    public static final int U_PRESSURE_FR_ENABLE = 109;
    public static final int U_PRESSURE_FR_HIGH = 111;
    public static final int U_PRESSURE_FR_HIGHTEMP = 134;
    public static final int U_PRESSURE_FR_HIGHTEMP_S = 135;
    public static final int U_PRESSURE_FR_HIGH_AIR = 137;
    public static final int U_PRESSURE_FR_LOSE = 130;
    public static final int U_PRESSURE_FR_LOW = 110;
    public static final int U_PRESSURE_FR_LOW_AIR = 136;
    public static final int U_PRESSURE_FR_SYSTERM = 129;
    public static final int U_PRESSURE_FR_TEMP = 99;
    public static final int U_PRESSURE_FR_VLOW = 133;
    public static final int U_PRESSURE_RL = 104;
    public static final int U_PRESSURE_RL_AIRLINK_FAST = 150;
    public static final int U_PRESSURE_RL_AIRLINK_SLOW = 149;
    public static final int U_PRESSURE_RL_CHECKSELF = 142;
    public static final int U_PRESSURE_RL_ELIGHT = 143;
    public static final int U_PRESSURE_RL_ENABLE = 112;
    public static final int U_PRESSURE_RL_HIGH = 114;
    public static final int U_PRESSURE_RL_HIGHTEMP = 145;
    public static final int U_PRESSURE_RL_HIGHTEMP_S = 146;
    public static final int U_PRESSURE_RL_HIGH_AIR = 148;
    public static final int U_PRESSURE_RL_LOSE = 141;
    public static final int U_PRESSURE_RL_LOW = 113;
    public static final int U_PRESSURE_RL_LOW_AIR = 147;
    public static final int U_PRESSURE_RL_SYSTERM = 140;
    public static final int U_PRESSURE_RL_TEMP = 100;
    public static final int U_PRESSURE_RL_VLOW = 144;
    public static final int U_PRESSURE_RR = 105;
    public static final int U_PRESSURE_RR_AIRLINK_FAST = 161;
    public static final int U_PRESSURE_RR_AIRLINK_SLOW = 160;
    public static final int U_PRESSURE_RR_CHECKSELF = 153;
    public static final int U_PRESSURE_RR_ELIGHT = 154;
    public static final int U_PRESSURE_RR_ENABLE = 115;
    public static final int U_PRESSURE_RR_HIGH = 117;
    public static final int U_PRESSURE_RR_HIGHTEMP = 156;
    public static final int U_PRESSURE_RR_HIGHTEMP_S = 157;
    public static final int U_PRESSURE_RR_HIGH_AIR = 159;
    public static final int U_PRESSURE_RR_LOSE = 152;
    public static final int U_PRESSURE_RR_LOW = 116;
    public static final int U_PRESSURE_RR_LOW_AIR = 158;
    public static final int U_PRESSURE_RR_SYSTERM = 151;
    public static final int U_PRESSURE_RR_TEMP = 101;
    public static final int U_PRESSURE_RR_VLOW = 155;
    public static final int U_SEAT_PLEASE = 164;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 166; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_OD_ZhongTaiT500(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 166) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
