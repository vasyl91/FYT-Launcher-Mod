package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.accord9.wc.Accord9HBackCamera;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0042_WC2_ACCORD9_Lo extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 118;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 119;
    public static final int U_AVERAGE_SPEED = 120;
    public static final int U_BRIGHT_VALUE = 130;
    public static final int U_CAR_CAMERA_MODE = 134;
    public static final int U_CAR_RIGHT_CAMERA_STATUS = 133;
    public static final int U_CLOSE_BIGLAMP_TIME = 124;
    public static final int U_CLOSE_INSIDELAMP_TIME = 125;
    public static final int U_CNT_MAX = 136;
    public static final int U_CONTAST_VALUE = 132;
    public static final int U_CURRENT_SPEED = 121;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 127;
    public static final int U_LAST_MILEAGE_BY_TYPE = 129;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 123;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 126;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 128;
    public static final int U_SET_ENABLE_BACKVIDEO = 135;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 122;
    public static final int U_STATUR_VALUE = 131;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
        for (int i = 0; i < 136; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0042_WC2_Accord9(LauncherApplication.getInstance()));
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
            if (value == 1 && !Accord9HBackCamera.isFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.accord9.wc.Accord9HBackCamera");
                return;
            } else {
                if (value == 0 && Accord9HBackCamera.isFront && Accord9HBackCamera.mInstance != null) {
                    Accord9HBackCamera.mInstance.finish();
                    return;
                }
                return;
            }
        }
        if (updateCode >= 0 && updateCode < 136) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
