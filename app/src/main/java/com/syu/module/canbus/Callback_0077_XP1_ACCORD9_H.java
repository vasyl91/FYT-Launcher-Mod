package com.syu.module.canbus;

import android.os.RemoteException;
import android.widget.Toast;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.accord9.xp.XPAccord9BackCarActi;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0041_XP1_Accord;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0077_XP1_ACCORD9_H extends CallbackCanbusBase {
    public static final int Band_Am = 10000;
    public static final int Band_Am1 = 10001;
    public static final int Band_Am2 = 10002;
    public static final int Band_Am3 = 10003;
    public static final int Band_Fm = 0;
    public static final int Band_Fm1 = 1;
    public static final int Band_Fm2 = 2;
    public static final int Band_Fm3 = 3;
    public static final int C_ABLE_SELECT = 84;
    public static final int C_ADJUST_OUTDISE_TEMP_DISPLAY = 0;
    public static final int C_AUTO_DOOR_LOCK_WITH = 7;
    public static final int C_AUTO_DOOR_UNLOCK_WITH = 8;
    public static final int C_AUTO_LIGHT_SENSITIVITY = 6;
    public static final int C_BACKCAR_TYPE = 64;
    public static final int C_BAND = 72;
    public static final int C_CHANNEL_SELECT = 82;
    public static final int C_DEFAULT_ALL = 15;
    public static final int C_DEFLATION_WARNING_SYSTEM = 17;
    public static final int C_DOOR_UNLOCK_MODE = 18;
    public static final int C_FREQ = 70;
    public static final int C_FREQ_SEARCH = 71;
    public static final int C_FUEL_EFFICIENCY_BACKLIGHT = 1;
    public static final int C_HEADLIGHT_AUTO_OFF_TIMER = 5;
    public static final int C_INTERIOR_LIGHT_DIMMING_TIME = 4;
    public static final int C_KEYLESS_ACCESS_BEEP = 13;
    public static final int C_KEYLESS_ACCESS_BEEP_VOLUME = 12;
    public static final int C_KEYLESS_ACCESS_LIGHT_FLASH = 19;
    public static final int C_KEYLESS_LOCK_ANSWER_BACK = 10;
    public static final int C_KEY_AND_REMOTE_UNLOCK_MODE = 9;
    public static final int C_REFLASH = 83;
    public static final int C_RESET_MAINTENANCE_INFO = 14;
    public static final int C_SAVE = 80;
    public static final int C_SCAN = 73;
    public static final int C_SCREEN_BACKGROUND_COLOR = 65;
    public static final int C_SCREEN_BRIGHTNESS = 67;
    public static final int C_SCREEN_CONTTAST = 68;
    public static final int C_SCREEN_SATURATION = 69;
    public static final int C_SCREEN_SHOW = 66;
    public static final int C_SECURITY_RELOCK_TIMER = 11;
    public static final int C_SELECT = 81;
    public static final int C_TRIPA_RESET_TIMING = 2;
    public static final int C_TRIPB_RESET_TIMING = 3;
    public static final int C_TURNER_BAND = 56;
    public static final int C_TURNER_CHANNEL_ABLE_SELECT = 54;
    public static final int C_TURNER_CHANNEL_PRESET_SELECT = 55;
    public static final int C_TURNER_CHANNEL_REFLASH = 52;
    public static final int C_TURNER_CHANNEL_SAVE = 50;
    public static final int C_TURNER_CHANNEL_SCAN = 49;
    public static final int C_TURNER_CHANNEL_SEARCH = 48;
    public static final int C_TURNER_CHANNEL_SELECT = 51;
    public static final int C_TURNER_FREQ = 53;
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
    public static final int U_DOOR_BACK = 58;
    public static final int U_DOOR_BEGIN = 53;
    public static final int U_DOOR_END = 59;
    public static final int U_DOOR_ENGINE = 53;
    public static final int U_DOOR_FL = 54;
    public static final int U_DOOR_FR = 55;
    public static final int U_DOOR_RL = 56;
    public static final int U_DOOR_RR = 57;
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
    public static int mBrigressLevel = 15;
    public final int[] Max = {600, 100, 120, 200, 300, 400, ConstRzcAddData.U_CAR_ADD_START, 600, 700, 800, 900, 1000};
    private Runnable showTip = new Runnable() { // from class: com.syu.module.canbus.Callback_0077_XP1_ACCORD9_H.1
        @Override // java.lang.Runnable
        public void run() {
            if (Callback_0077_XP1_ACCORD9_H.this.toast == null) {
                Callback_0077_XP1_ACCORD9_H.this.toast = Toast.makeText(LauncherApplication.getInstance(), "", 1);
            }
            Callback_0077_XP1_ACCORD9_H.this.toast.setText(Callback_0077_XP1_ACCORD9_H.this.toast_msg);
            Callback_0077_XP1_ACCORD9_H.this.toast.show();
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
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
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
        if (updateCode == 1021) {
            int value = ints[0];
            if (value == 1 && !XPAccord9BackCarActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.accord9.xp.XPAccord9BackCarActi");
                return;
            } else {
                if (value == 0 && XPAccord9BackCarActi.mIsFront && XPAccord9BackCarActi.mInstance != null) {
                    XPAccord9BackCarActi.mInstance.finish();
                    return;
                }
                return;
            }
        }
        if (updateCode >= 0 && updateCode < 61) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
