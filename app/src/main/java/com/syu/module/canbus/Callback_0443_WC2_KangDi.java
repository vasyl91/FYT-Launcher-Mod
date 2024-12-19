package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_KangDI;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_KangDi extends CallbackCanbusBase {
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
    public static final int U_AIR_END = 34;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_ONOFF = 33;
    public static final int U_AIR_POWER = 30;
    public static final int U_AIR_PTC = 32;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SEAT_HEAT_LEFT = 17;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 18;
    public static final int U_AIR_SHOW = 12;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL = 31;
    public static final int U_AIR_WIND_LEVEL_LEFT = 24;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 28;
    public static final int U_ALARMINFO_BEGIN = 42;
    public static final int U_ALARMINFO_END = 51;
    public static final int U_ALARMINFO_INFO1 = 44;
    public static final int U_ALARMINFO_INFO2 = 45;
    public static final int U_ALARMINFO_INFO3 = 46;
    public static final int U_ALARMINFO_INFO4 = 47;
    public static final int U_ALARMINFO_INFO5 = 48;
    public static final int U_ALARMINFO_INFO6 = 49;
    public static final int U_ALARMINFO_INFO7 = 50;
    public static final int U_ALARMINFO_NUM = 43;
    public static final int U_CNT_MAX = 51;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_LIGHT_BEGIN = 34;
    public static final int U_LIGHT_END = 42;
    public static final int U_LIGHT_FARLIGHT = 36;
    public static final int U_LIGHT_FRONTFOGFLIGHT = 38;
    public static final int U_LIGHT_LEFTTURNLIGHT = 41;
    public static final int U_LIGHT_NEARLIGHT = 35;
    public static final int U_LIGHT_REARLIGHT = 39;
    public static final int U_LIGHT_RIGHTTURNLIGHT = 40;
    public static final int U_LIGHT_WIDTHLIGHT = 37;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 51; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_KangDI(LauncherApplication.getInstance()));
        for (int i3 = 9; i3 < 34; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 9; i2 < 34; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 51) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
