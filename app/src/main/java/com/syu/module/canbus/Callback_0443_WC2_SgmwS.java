package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_SgmwS extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AC_MAX = 16;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_AUTO2 = 29;
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_BLOW_BODY_LEFT = 22;
    public static final int U_AIR_BLOW_BODY_RIGHT = 26;
    public static final int U_AIR_BLOW_FOOT_LEFT = 23;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 27;
    public static final int U_AIR_BLOW_UP_LEFT = 21;
    public static final int U_AIR_BLOW_UP_RIGHT = 25;
    public static final int U_AIR_CYCLE = 11;
    public static final int U_AIR_DUAL = 9;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 30;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SEAT_HEAT_LEFT = 17;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 18;
    public static final int U_AIR_SHOW = 12;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL = 31;
    public static final int U_AIR_WIND_LEVEL_LEFT = 24;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 28;
    public static final int U_ALARMINFO_BEGIN = 40;
    public static final int U_ALARMINFO_END = 49;
    public static final int U_ALARMINFO_INFO1 = 42;
    public static final int U_ALARMINFO_INFO2 = 43;
    public static final int U_ALARMINFO_INFO3 = 44;
    public static final int U_ALARMINFO_INFO4 = 45;
    public static final int U_ALARMINFO_INFO5 = 46;
    public static final int U_ALARMINFO_INFO6 = 47;
    public static final int U_ALARMINFO_INFO7 = 48;
    public static final int U_ALARMINFO_NUM = 41;
    public static final int U_CNT_MAX = 49;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_LIGHT_BEGIN = 32;
    public static final int U_LIGHT_END = 40;
    public static final int U_LIGHT_FARLIGHT = 34;
    public static final int U_LIGHT_FRONTFOGFLIGHT = 36;
    public static final int U_LIGHT_LEFTTURNLIGHT = 39;
    public static final int U_LIGHT_NEARLIGHT = 33;
    public static final int U_LIGHT_REARLIGHT = 37;
    public static final int U_LIGHT_RIGHTTURNLIGHT = 38;
    public static final int U_LIGHT_WIDTHLIGHT = 35;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_SgmwS(LauncherApplication.getInstance()));
        for (int i3 = 9; i3 < 32; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 9; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 49) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
