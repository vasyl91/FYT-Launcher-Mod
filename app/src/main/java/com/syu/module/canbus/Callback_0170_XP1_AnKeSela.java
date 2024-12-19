package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0170_XP1_AnKeSela extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_CARCDENDI = 6;
    public static final int U_CARCDSTATE = 0;
    public static final int U_CAR_PLAY_PROGRESS = 2;
    public static final int U_CAR_PLAY_STATE = 3;
    public static final int U_CAR_TRACK_INFO = 4;
    public static final int U_CNT_MAX = 26;
    public static final int U_DISPLAY_ENABLE_0 = 5;
    public static final int U_DOOR_BACK = 25;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 26;
    public static final int U_DOOR_ENGINE = 20;
    public static final int U_DOOR_FL = 21;
    public static final int U_DOOR_FR = 22;
    public static final int U_DOOR_RL = 23;
    public static final int U_DOOR_RR = 24;
    public static final int U_SYNC_LINE_GROUP_STR = 1;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 26; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 20; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 26) {
            if (updateCode == 1) {
                if (ints != null && ints.length >= 1) {
                    infoType = ints[0];
                    if (strs != null && strs.length > 0) {
                        Songname = strs[0];
                    } else {
                        Songname = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
