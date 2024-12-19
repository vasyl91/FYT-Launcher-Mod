package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.accord9.wc.Accord9HBackCamera;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0042_WC2_Accord9;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0042_WC2_ACCORD9_Lo extends CallbackCanbusBase {
    public static final int U_AIR_AC = 45;
    public static final int U_AIR_AUTO = 41;
    public static final int U_AIR_BEGIN = 40;
    public static final int U_AIR_BLOW_BODY_LEFT = 47;
    public static final int U_AIR_BLOW_FOOT_LEFT = 48;
    public static final int U_AIR_BLOW_UP_LEFT = 49;
    public static final int U_AIR_CYCLE = 42;
    public static final int U_AIR_DUAL = 51;
    public static final int U_AIR_END = 55;
    public static final int U_AIR_FRONT_DEFROST = 43;
    public static final int U_AIR_POWER = 53;
    public static final int U_AIR_REAR_DEFROST = 44;
    public static final int U_AIR_SYNC = 54;
    public static final int U_AIR_TEMP_LEFT = 46;
    public static final int U_AIR_TEMP_RIGHT = 52;
    public static final int U_AIR_WIND_LEVEL_LEFT = 50;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 20;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 21;
    public static final int U_AVERAGE_SPEED = 22;
    public static final int U_BRIGHT_VALUE = 32;
    public static final int U_CAR_CAMERA_MODE = 63;
    public static final int U_CAR_RIGHT_CAMERA_STATUS = 62;
    public static final int U_CLOSE_BIGLAMP_TIME = 26;
    public static final int U_CLOSE_INSIDELAMP_TIME = 27;
    public static final int U_CNT_MAX = 65;
    public static final int U_CONTAST_VALUE = 34;
    public static final int U_CURRENT_SPEED = 23;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 29;
    public static final int U_LAST_MILEAGE_BY_TYPE = 31;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 25;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 28;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 30;
    public static final int U_SET_ENABLE_BACKVIDEO = 64;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 24;
    public static final int U_STATUR_VALUE = 33;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        for (int i = 0; i < 65; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 55;
        DoorHelper.sUcDoorFl = 56;
        DoorHelper.sUcDoorFr = 57;
        DoorHelper.sUcDoorRl = 58;
        DoorHelper.sUcDoorRr = 59;
        DoorHelper.sUcDoorBack = 60;
        AirHelper.getInstance().buildUi(new Air_0042_WC2_Accord9(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 55; i2 < 61; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 40; i3 < 55; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 55; i < 61; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 40; i2 < 55; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1021) {
            int value = ints[0];
            if (value == 1 && !Accord9HBackCamera.isFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.accord9.wc.Accord9HBackCamera");
                return;
            } else {
                if (value == 0 && Accord9HBackCamera.isFront && Accord9HBackCamera.mInstance != null) {
                    Accord9HBackCamera.mInstance.finish();
                    return;
                }
                return;
            }
        }
        if (updateCode >= 0 && updateCode < 65) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
