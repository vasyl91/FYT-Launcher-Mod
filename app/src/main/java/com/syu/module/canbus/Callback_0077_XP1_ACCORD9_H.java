package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.accord9.xp.XPAccord9BackCarActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0077_XP1_ACCORD9_H extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 121;
    public static final int U_ACC_SETTING_FAIL = 133;
    public static final int U_AIR_BY_AUTO_KEY = 126;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 117;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 118;
    public static final int U_AUTOLOCK_BY_SPEED = 116;
    public static final int U_CAR_CAMERA_TYPE = 135;
    public static final int U_CAR_RIGHTCAMERA_STATE = 131;
    public static final int U_CNT_MAX = 151;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 132;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 120;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 125;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 136;
    public static final int U_REMOTE_2PRESS_UNLOCK = 119;
    public static final int U_SETTING_FAIL = 134;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 124;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 150;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 122;
    public static final int U_UNLOCK_BY_SMART_DOOR = 123;
    public static final int U_WARNNING_CLEANNING_FLUID = 130;
    public static final int U_WARNNING_LIFE_BELT = 129;
    public static final int U_WARNNING_LOW_BATTERY = 128;
    public static final int U_WARNNING_LOW_OIL = 127;
    public static int mBrigressLevel = 15;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0041_XP1_Accord(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 151) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
