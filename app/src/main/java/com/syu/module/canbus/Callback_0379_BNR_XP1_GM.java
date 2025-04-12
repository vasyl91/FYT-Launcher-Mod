package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0379_BNR_XP1_GM extends CallbackCanbusBase {
    public static final int CYCLE_AUTO = 2;
    public static final int CYCLE_INNER_MANUAL = 1;
    public static final int CYCLE_OUTER = 0;
    public static final int TEMP_HIGH = -3;
    public static final int TEMP_LOW = -2;
    public static final int TEMP_NONE = -1;
    public static final int U_ACC_PROMPT = 195;
    public static final int U_CAR_STATE_PROMPT = 191;
    public static final int U_CNT_MAX = 207;
    public static final int U_CRASH_REMINDER_TYPE = 197;
    public static final int U_DETECT_WALKER = 198;
    public static final int U_GETOFF_OPTIONS = 200;
    public static final int U_LANE_CHANGE_WARN = 199;
    public static final int U_RAMP_START_ASSIST = 189;
    public static final int U_REAR_CAR_PASSING_WARN = 201;
    public static final int U_REAR_SEAT_REMINDER = 196;
    public static final int U_REMOTE_AIR_POWER = 192;
    public static final int U_REMOTE_DOORWINDOW = 190;
    public static final int U_REMOTE_REAR_AIR_POWER = 193;
    public static final int U_REMOTE_REAR_DEFROG_POWER_MODE = 194;
    public static final int U_REMOTE_START_COLD_SEAT = 188;
    public static final int U_REMOTE_START_HEAT_SEAT_WeiLang = 187;
    public static final int U_SPARE_TIRE_EXIST = 204;
    public static final int U_SPARE_TIRE_PRESS = 206;
    public static final int U_TIRE_EXIST = 203;
    public static final int U_TIRE_UNIT = 205;
    public static final int U_WIFI_PASSWORD = 202;
    final int SYS_START_VER = 0;
    final int CAR_AIR_CONTROL = 1;
    final int CAR_COMM_CONTROL = 3;
    final int CAR_RADAR_CTL = 4;
    final int CAR_ON_START_CTL = 5;
    final int CAR_ON_START_CALL = 6;
    final int CAR_WARNN_VOL = 7;
    final int CAR_NAVI_STATE = 9;
    final int C_CAR_LANGUAGE_SETUP = 96;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 207; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 2294139) {
            //AirHelper.getInstance().buildUi(new Air_0379_HC_GL6(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0379_BNR_GM(LauncherApplication.getInstance()));
        }
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
        switch (updateCode) {
            case 115:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 207) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
