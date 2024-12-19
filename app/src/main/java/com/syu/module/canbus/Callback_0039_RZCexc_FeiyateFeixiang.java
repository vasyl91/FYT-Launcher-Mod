package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0039_RZCexe_FeiYaTeFeiXiang;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0039_RZCexc_FeiyateFeixiang extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AQS = 10;
    public static final int U_AIR_AUTO = 16;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 2;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_BLOW_WIN_LEFT = 3;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_DUAL = 17;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_FRONT_DEFROST = 18;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_SEAT_HEAT_LEFT = 14;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 15;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 4;
    public static final int U_AIR_WIND_LEVEL = 6;
    public static final int U_CARINF_BEGIN = 44;
    public static final int U_CARINF_CUR_FUEL = 46;
    public static final int U_CARINF_RANGE = 45;
    public static final int U_CARINF_TRIPA_AVG_FUEL = 47;
    public static final int U_CARINF_TRIPA_AVG_SPEED = 48;
    public static final int U_CARINF_TRIPA_DISTANCE = 49;
    public static final int U_CARINF_TRIPA_TIME = 50;
    public static final int U_CARINF_TRIPB_AVG_FUEL = 51;
    public static final int U_CARINF_TRIPB_AVG_SPEED = 52;
    public static final int U_CARINF_TRIPB_DISTANCE = 53;
    public static final int U_CARINF_TRIPB_TIME = 54;
    public static final int U_CARSET_ADD_LIGHTS_D14 = 55;
    public static final int U_CARSET_ADD_PARK_D32 = 56;
    public static final int U_CARSET_ADD_PARK_D33 = 57;
    public static final int U_CARSET_ADD_PARK_D34 = 58;
    public static final int U_CARSET_ADD_PARK_D35 = 59;
    public static final int U_CARSET_ADD_PARK_D36 = 60;
    public static final int U_CARSET_AUTO_CLOSE = 37;
    public static final int U_CARSET_BEEP_VOL = 41;
    public static final int U_CARSET_BEGIN = 27;
    public static final int U_CARSET_CAR_TYPE = 42;
    public static final int U_CARSET_D40_D15_B70 = 61;
    public static final int U_CARSET_D40_D21_B70 = 62;
    public static final int U_CARSET_D40_D37_B70 = 63;
    public static final int U_CARSET_D40_D38_B70 = 64;
    public static final int U_CARSET_END = 43;
    public static final int U_CARSET_LANGUAGE = 28;
    public static final int U_CARSET_LIGHTS_CORNERING = 34;
    public static final int U_CARSET_LIGHTS_COURTESY = 35;
    public static final int U_CARSET_LIGHTS_DAYTIME = 33;
    public static final int U_CARSET_LIGHTS_FLASH = 36;
    public static final int U_CARSET_PARKSENSE = 38;
    public static final int U_CARSET_REAR_PARKENSE_VOL = 39;
    public static final int U_CARSET_TRIPB_SHOW = 40;
    public static final int U_CARSET_UNIT_DISTANCE = 30;
    public static final int U_CARSET_UNIT_FUEL = 29;
    public static final int U_CARSET_UNIT_METRIC = 32;
    public static final int U_CARSET_UNIT_TEMP = 31;
    public static final int U_CNT_MAX = 65;
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
        for (int i = 0; i < 65; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0039_RZCexe_FeiYaTeFeiXiang(LauncherApplication.getInstance()));
        for (int i2 = 20; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 19; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 65) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
