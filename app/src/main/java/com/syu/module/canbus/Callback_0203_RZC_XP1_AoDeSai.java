package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0002_XP1_DaZhong;
import com.syu.ui.air.Air_0203_Oudi_08AodeSai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0203_RZC_XP1_AoDeSai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 28;
    public static final int U_AIR_AUTO = 29;
    public static final int U_AIR_BATTERY = 33;
    public static final int U_AIR_BEGIN = 27;
    public static final int U_AIR_BLOW_AUTO_LEFT = 36;
    public static final int U_AIR_BLOW_BODY_LEFT = 39;
    public static final int U_AIR_BLOW_FOOT_LEFT = 38;
    public static final int U_AIR_BLOW_WIN_LEFT = 37;
    public static final int U_AIR_CYCLE = 30;
    public static final int U_AIR_DUAL = 32;
    public static final int U_AIR_END = 43;
    public static final int U_AIR_FRONT_DEFROST = 34;
    public static final int U_AIR_POWER = 27;
    public static final int U_AIR_REAR_DEFROST = 31;
    public static final int U_AIR_TEMP_LEFT = 41;
    public static final int U_AIR_TEMP_RIGHT = 42;
    public static final int U_AIR_TEMP_UNIT = 40;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_CARCD_CD_INFO1 = 46;
    public static final int U_CARCD_CD_INFO2 = 47;
    public static final int U_CARCD_RADIO_INFO = 45;
    public static final int U_CARCD_STATE = 44;
    public static final int U_CARCD_VOLUME = 48;
    public static final int U_CNT_MAX = 49;
    public static final int U_DOOR_BACK = 25;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 26;
    public static final int U_DOOR_ENGINE = 20;
    public static final int U_DOOR_FL = 21;
    public static final int U_DOOR_FR = 22;
    public static final int U_DOOR_RL = 23;
    public static final int U_DOOR_RR = 24;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        if (DataCanbus.sCanbusId == 196811) {
            for (int i2 = 27; i2 < 43; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            AirHelper.getInstance().buildUi(new Air_0203_Oudi_08AodeSai(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0002_XP1_DaZhong(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 20; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        if (DataCanbus.sCanbusId == 196811) {
            for (int i2 = 27; i2 < 43; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 49) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
