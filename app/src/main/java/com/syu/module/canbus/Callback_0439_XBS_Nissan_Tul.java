package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xbs.tule.XBS_TuleDZSJ_AirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XBS_Nissan_Tule;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XBS_Nissan_Tul extends CallbackCanbusBase {
    public static final int U_AIR_AC = 16;
    public static final int U_AIR_ACMAX = 19;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 12;
    public static final int U_AIR_BLOW_FOOT = 13;
    public static final int U_AIR_BLOW_MODE = 14;
    public static final int U_AIR_BLOW_UP = 11;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_DUAL = 17;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 23;
    public static final int U_AIR_MAXFRONT = 21;
    public static final int U_AIR_REAR = 22;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_SEATHEAT_LEFT = 24;
    public static final int U_AIR_SEATHEAT_RIGHT = 25;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL = 10;
    public static final int U_CARINF2_BEGIN = 49;
    public static final int U_CARINF2_BLIND_SPOT = 57;
    public static final int U_CARINF2_BLIND_SPOT_WARN = 60;
    public static final int U_CARINF2_COLLISION_WARN = 58;
    public static final int U_CARINF2_DISTANCE_ASSIT = 55;
    public static final int U_CARINF2_END = 63;
    public static final int U_CARINF2_INTERRUPT_DISPLAY = 52;
    public static final int U_CARINF2_REARVIEW_LEFT = 61;
    public static final int U_CARINF2_REARVIEW_RIGHT = 62;
    public static final int U_CARINF2_ROADAWAY = 56;
    public static final int U_CARINF2_ROADAWAY_WARN = 59;
    public static final int U_CARINF2_SENAR = 50;
    public static final int U_CARINF2_SENAR_FR = 51;
    public static final int U_CARINF2_SENAR_SENSITIVITY = 53;
    public static final int U_CARINF2_SENAR_VOLUME = 54;
    public static final int U_CARINF_AVGFUEL = 30;
    public static final int U_CARINF_BEGIN = 27;
    public static final int U_CARINF_CENTRE_SENSOR = 33;
    public static final int U_CARINF_CORNER_SENSOR = 32;
    public static final int U_CARINF_DOOR_UNLOCK = 36;
    public static final int U_CARINF_END = 40;
    public static final int U_CARINF_INTER_LIGHT = 34;
    public static final int U_CARINF_KEY_UNLOCK = 37;
    public static final int U_CARINF_LIGHTOFF_DELAY = 39;
    public static final int U_CARINF_LIGHT_SENSOR = 38;
    public static final int U_CARINF_MILEAGE = 28;
    public static final int U_CARINF_PARK_SENSOR = 31;
    public static final int U_CARINF_SPEED_WIPER = 35;
    public static final int U_CARINF_TRAVELABLE = 29;
    public static final int U_CAR_TIRE_BEGIN = 40;
    public static final int U_CAR_TIRE_END = 49;
    public static final int U_CAR_TIRE_VALUE_FL = 41;
    public static final int U_CAR_TIRE_VALUE_FR = 42;
    public static final int U_CAR_TIRE_VALUE_RL = 43;
    public static final int U_CAR_TIRE_VALUE_RR = 44;
    public static final int U_CAR_TIRE_WARN_FL = 45;
    public static final int U_CAR_TIRE_WARN_FR = 46;
    public static final int U_CAR_TIRE_WARN_RL = 47;
    public static final int U_CAR_TIRE_WARN_RR = 48;
    public static final int U_CNT_MAX = 66;
    public static final int U_CUR_MOTOR_SPEED = 65;
    public static final int U_CUR_SPEED = 64;
    Runnable mDismissAir = new Runnable() { // from class: com.syu.module.canbus.Callback_0439_XBS_Nissan_Tul.1
        @Override // java.lang.Runnable
        public void run() {
            if (XBS_TuleDZSJ_AirControlActi.mIsFront && XBS_TuleDZSJ_AirControlActi.mInstance != null) {
                XBS_TuleDZSJ_AirControlActi.mInstance.finish();
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 66; i++) {
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
        if (DataCanbus.DATA[1000] != 8716727) {
            AirHelper.getInstance().buildUi(new Air_0439_XBS_Nissan_Tule(LauncherApplication.getInstance()));
            for (int i3 = 7; i3 < 26; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (DataCanbus.DATA[1000] == 8716727) {
            if (!XBS_TuleDZSJ_AirControlActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.tule.XBS_TuleDZSJ_AirControlActi");
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissAir);
            HandlerUI.getInstance().postDelayed(this.mDismissAir, 3500L);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 66) {
            if (updateCode >= 7 && updateCode < 26) {
                if (DataCanbus.DATA[1000] == 8716727) {
                    showCotrolAir(updateCode, ints);
                }
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
