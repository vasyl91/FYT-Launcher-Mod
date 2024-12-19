package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.hc.volvo.IndexAct_Hc_volvo;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Volvo;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Volvo extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 6;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_SEAT_HOT_LEFT = 15;
    public static final int U_AIR_SEAT_HOT_RIGHT = 16;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_TEMP_RIGHT = 10;
    public static final int U_AIR_TEMP_UNIT = 14;
    public static final int U_AIR_WIND_LEVEL = 13;
    public static final int U_CNT_MAX = 26;
    public static final int U_DOOR_BACK = 23;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 24;
    public static final int U_DOOR_ENGINE = 18;
    public static final int U_DOOR_FL = 19;
    public static final int U_DOOR_FR = 20;
    public static final int U_DOOR_RL = 21;
    public static final int U_DOOR_RR = 22;
    public static final int U_JUMP_CARINFO = 25;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 26; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 18;
        DoorHelper.sUcDoorFl = 19;
        DoorHelper.sUcDoorFr = 20;
        DoorHelper.sUcDoorRl = 21;
        DoorHelper.sUcDoorRr = 22;
        DoorHelper.sUcDoorBack = 23;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 18; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_HC_Volvo(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void convCarVideo(int updateCode, int[] ints) {
        if (updateCode == 25) {
            int value = ints[0];
            if (value == 1 && !IndexAct_Hc_volvo.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hc.volvo.IndexAct_Hc_volvo");
            } else if (IndexAct_Hc_volvo.mIsFront && IndexAct_Hc_volvo.mInstance != null) {
                IndexAct_Hc_volvo.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 26) {
            switch (updateCode) {
                case 25:
                    convCarVideo(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
