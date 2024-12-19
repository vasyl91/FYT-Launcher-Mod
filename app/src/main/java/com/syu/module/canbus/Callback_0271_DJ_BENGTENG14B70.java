package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.dj.b70.DjB70AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0271_DJ_BenTeng14B70;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0271_DJ_BENGTENG14B70 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 6;
    public static final int U_AIR_AUTO = 5;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 4;
    public static final int U_AIR_BLOW_FOOT = 3;
    public static final int U_AIR_BLOW_UP = 2;
    public static final int U_AIR_CYCLE = 0;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_REAR_DEFROST = 1;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL = 7;
    public static final int U_CAT_BT_CONNECT_STATE = 19;
    public static final int U_CAT_BT_NUMBER = 20;
    public static final int U_CAT_BT_STATE = 18;
    public static final int U_CNT_MAX = 22;
    public static final int U_DOOR_BACK = 16;
    public static final int U_DOOR_BEGIN = 11;
    public static final int U_DOOR_END = 17;
    public static final int U_DOOR_ENGINE = 11;
    public static final int U_DOOR_FL = 12;
    public static final int U_DOOR_FR = 13;
    public static final int U_DOOR_RL = 14;
    public static final int U_DOOR_RR = 15;
    public static final int U_SHOW_AIR_KEY = 21;
    public static String btNumber;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 22; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 11;
        DoorHelper.sUcDoorFl = 12;
        DoorHelper.sUcDoorFr = 13;
        DoorHelper.sUcDoorRl = 14;
        DoorHelper.sUcDoorRr = 15;
        DoorHelper.sUcDoorBack = 16;
        AirHelper.getInstance().buildUi(new Air_0271_DJ_BenTeng14B70(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 11; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 11; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 11; i < 17; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 20:
                if (strs != null && strs.length > 0) {
                    btNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            case 21:
                int i = DataCanbus.DATA[21];
                if (ints[0] == 1 && !DjB70AirControlAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.b70.DjB70AirControlAct");
                    break;
                } else if (ints[0] == 1 && DjB70AirControlAct.mIsFront && DjB70AirControlAct.mInstance != null) {
                    DjB70AirControlAct.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 22) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
