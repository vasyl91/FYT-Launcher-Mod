package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.biaozhi408.BZ408AirControlActi;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0122_WC2_408_14;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0122_WC2_408_14 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 74;
    public static final int U_AIR_ACMAX = 87;
    public static final int U_AIR_AUTO = 70;
    public static final int U_AIR_BEGIN = 69;
    public static final int U_AIR_BLOW_AUTO_LEFT = 85;
    public static final int U_AIR_BLOW_BODY_LEFT = 76;
    public static final int U_AIR_BLOW_FOOT_LEFT = 77;
    public static final int U_AIR_BLOW_UP_LEFT = 78;
    public static final int U_AIR_CYCLE = 71;
    public static final int U_AIR_DUAL = 80;
    public static final int U_AIR_ECO = 83;
    public static final int U_AIR_END = 90;
    public static final int U_AIR_FRONT_DEFROST = 72;
    public static final int U_AIR_HYAC = 89;
    public static final int U_AIR_MONO = 88;
    public static final int U_AIR_POWER = 82;
    public static final int U_AIR_REAR_DEFROST = 73;
    public static final int U_AIR_SYNC = 86;
    public static final int U_AIR_TEMP_LEFT = 75;
    public static final int U_AIR_TEMP_RIGHT = 81;
    public static final int U_AIR_TEMP_UNIT = 84;
    public static final int U_AIR_WIND_LEVEL_LEFT = 79;
    public static final int U_CNT_MAX = 98;
    public static final int U_DOOR_BACK = 95;
    public static final int U_DOOR_BEGIN = 90;
    public static final int U_DOOR_END = 96;
    public static final int U_DOOR_ENGINE = 90;
    public static final int U_DOOR_FL = 91;
    public static final int U_DOOR_FR = 92;
    public static final int U_DOOR_RL = 93;
    public static final int U_DOOR_RR = 94;
    public static final int U_SHOW_AIR_KEY = 97;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 98; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 90;
        DoorHelper.sUcDoorFl = 91;
        DoorHelper.sUcDoorFr = 92;
        DoorHelper.sUcDoorRl = 93;
        DoorHelper.sUcDoorRr = 94;
        DoorHelper.sUcDoorBack = 95;
        AirHelper.getInstance().buildUi(new Air_0122_WC2_408_14(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 90; i2 < 96; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 69; i3 < 90; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 90; i < 96; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 69; i2 < 90; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 98) {
            if (updateCode == 18) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[18];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 97) {
                if (ints[0] == 1 && !BZ408AirControlActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408AirControlActi");
                    return;
                } else {
                    if (ints[0] == 1 && BZ408AirControlActi.mIsFront && BZ408AirControlActi.mInstance != null) {
                        BZ408AirControlActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
