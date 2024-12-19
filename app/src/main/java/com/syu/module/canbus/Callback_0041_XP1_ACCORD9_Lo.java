package com.syu.module.canbus;

import android.os.RemoteException;
import android.widget.Toast;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0041_XP1_Accord;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0041_XP1_ACCORD9_Lo extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 23;
    public static final int U_ACC_SETTING_FAIL = 35;
    public static final int U_AIR_AC = 43;
    public static final int U_AIR_AUTO = 39;
    public static final int U_AIR_BEGIN = 38;
    public static final int U_AIR_BLOW_BODY_LEFT = 45;
    public static final int U_AIR_BLOW_FOOT_LEFT = 46;
    public static final int U_AIR_BLOW_UP_LEFT = 47;
    public static final int U_AIR_BY_AUTO_KEY = 28;
    public static final int U_AIR_CYCLE = 40;
    public static final int U_AIR_DUAL = 49;
    public static final int U_AIR_END = 53;
    public static final int U_AIR_FRONT_DEFROST = 41;
    public static final int U_AIR_POWER = 51;
    public static final int U_AIR_REAR_DEFROST = 42;
    public static final int U_AIR_TEMP_LEFT = 44;
    public static final int U_AIR_TEMP_RIGHT = 50;
    public static final int U_AIR_TEMP_UNIT = 52;
    public static final int U_AIR_WIND_LEVEL_LEFT = 48;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 19;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 20;
    public static final int U_AUTOLOCK_BY_SPEED = 18;
    public static final int U_CAR_CAMERA_TYPE = 37;
    public static final int U_CAR_RIGHTCAMERA_STATE = 33;
    public static final int U_CNT_MAX = 61;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 34;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 22;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 27;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 38;
    public static final int U_REMOTE_2PRESS_UNLOCK = 21;
    public static final int U_SETTING_FAIL = 36;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 26;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 60;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 24;
    public static final int U_UNLOCK_BY_SMART_DOOR = 25;
    public static final int U_WARNNING_CLEANNING_FLUID = 32;
    public static final int U_WARNNING_LIFE_BELT = 31;
    public static final int U_WARNNING_LOW_BATTERY = 30;
    public static final int U_WARNNING_LOW_OIL = 29;
    private Runnable showTip = new Runnable() { // from class: com.syu.module.canbus.Callback_0041_XP1_ACCORD9_Lo.1
        @Override // java.lang.Runnable
        public void run() {
            if (Callback_0041_XP1_ACCORD9_Lo.this.toast == null) {
                Callback_0041_XP1_ACCORD9_Lo.this.toast = Toast.makeText(LauncherApplication.getInstance(), "", 1);
            }
            Callback_0041_XP1_ACCORD9_Lo.this.toast.setText(Callback_0041_XP1_ACCORD9_Lo.this.toast_msg);
            Callback_0041_XP1_ACCORD9_Lo.this.toast.show();
        }
    };
    private Toast toast;
    private String toast_msg;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 61; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 53;
        DoorHelper.sUcDoorFl = 54;
        DoorHelper.sUcDoorFr = 55;
        DoorHelper.sUcDoorRl = 56;
        DoorHelper.sUcDoorRr = 57;
        DoorHelper.sUcDoorBack = 58;
        AirHelper.getInstance().buildUi(new Air_0041_XP1_Accord(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 53; i2 < 59; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 38; i3 < 53; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 53; i < 59; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 38; i2 < 53; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showTip(String str) {
        this.toast_msg = str;
        HandlerUI.getInstance().post(this.showTip);
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
