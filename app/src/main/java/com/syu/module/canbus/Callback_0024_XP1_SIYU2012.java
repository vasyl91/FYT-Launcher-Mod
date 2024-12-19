package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.crv.XpCrvActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0024_XP1_SIYU2012 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 16;
    public static final int U_COMPASS_ANGLE = 9;
    public static final int U_COMPASS_AREA = 8;
    public static final int U_COMPASS_CALIBRATION = 7;
    public static final int U_PLAYER_FOLDER = 5;
    public static final int U_PLAYER_PROGRESS = 6;
    public static final int U_PLAYER_TIME = 2;
    public static final int U_PLAYER_TOTAL_TRACK = 4;
    public static final int U_PLAYER_TRACK = 3;
    public static final int U_USB_STATES = 0;
    public static final int U_USB_TYPE = 1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 16; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 10;
        DoorHelper.sUcDoorFl = 11;
        DoorHelper.sUcDoorFr = 12;
        DoorHelper.sUcDoorRl = 13;
        DoorHelper.sUcDoorRr = 14;
        DoorHelper.sUcDoorBack = 15;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 10; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 16; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 16) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode == 0) {
            int value = DataCanbus.DATA[0];
            if (value == 3 && !XpCrvActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.crv.XpCrvActi");
            } else if (value == 2 && XpCrvActi.mIsFront && XpCrvActi.mInstance != null) {
                XpCrvActi.mInstance.finish();
            }
        }
    }
}
