package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0092_WC2_DS5LS extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 22;
    public static final int U_AIR_END = 23;
    public static final int U_CNT_MAX = 29;
    public static final int U_DOOR_BACK = 28;
    public static final int U_DOOR_BEGIN = 23;
    public static final int U_DOOR_END = 29;
    public static final int U_DOOR_ENGINE = 23;
    public static final int U_DOOR_FL = 24;
    public static final int U_DOOR_FR = 25;
    public static final int U_DOOR_RL = 26;
    public static final int U_DOOR_RR = 27;
    public static final int U_UNIT_CONSUMPTION = 21;
    public static final int U_UNIT_TEMPERATURE = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 29; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 23;
        DoorHelper.sUcDoorFl = 24;
        DoorHelper.sUcDoorFr = 25;
        DoorHelper.sUcDoorRl = 26;
        DoorHelper.sUcDoorRr = 27;
        DoorHelper.sUcDoorBack = 28;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 23; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 23; i < 29; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 29) {
            if (updateCode == 18) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[18];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa.PsaOilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (updateCode == 19) {
                HandlerCanbus.update(updateCode, ints);
                int value2 = DataCanbus.DATA[19];
                if (value2 == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.psa.PsaAlarmRecordActi");
                    return;
                } else {
                    if (value2 == 0 && PsaAllAlarmRecordActi.mIsFront && PsaAllAlarmRecordActi.mInstance != null) {
                        PsaAllAlarmRecordActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
