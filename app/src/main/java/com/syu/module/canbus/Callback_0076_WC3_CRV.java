package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0076_WC3_CRV extends CallbackCanbusBase {
    public static final int C_COMPASS_AREA = 1;
    public static final int C_COMPASS_CALIBRATION = 2;
    public static final int C_CONTROL_PLAYER = 0;
    public static final int C_CONTROL_PLAYER_PLAY_NULL = 0;
    public static final int C_CONTROL_PLAYER_PLAY_ON = 1;
    public static final int C_CONTROL_PLAYER_SKIP_B = 3;
    public static final int C_CONTROL_PLAYER_SKIP_F = 4;
    public static final int C_CONTROL_PLAYER_STOP_OFF = 2;
    public static final int U_CNT_MAX = 19;
    public static final int U_COMPASS_STATUS = 18;
    public static final int U_CUR_SPEED = 10;
    public static final int U_MISC_BEGIN = 10;
    public static final int U_MISC_END = 19;
    public static final int U_PLAYER_MDI = 15;
    public static final int U_PLAYER_PROGRESS = 16;
    public static final int U_PLAYER_STATES = 17;
    public static final int U_PLAYER_TIME = 12;
    public static final int U_PLAYER_TOTAL_TRACK = 14;
    public static final int U_PLAYER_TRACK = 13;
    public static final int U_USB_TYPE = 11;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 19; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 19) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}