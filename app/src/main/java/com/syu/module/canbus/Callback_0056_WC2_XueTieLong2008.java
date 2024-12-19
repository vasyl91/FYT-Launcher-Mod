package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0056_WC2_XueTieLong2008 extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 21;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 22;
    public static final int U_CLOSE_BIGLAMP_TIME = 32;
    public static final int U_CLOSE_INSIDELAMP_TIME = 30;
    public static final int U_CNT_MAX = 49;
    public static final int U_DOOR_BACK = 48;
    public static final int U_DOOR_BEGIN = 43;
    public static final int U_DOOR_END = 49;
    public static final int U_DOOR_ENGINE = 43;
    public static final int U_DOOR_FL = 44;
    public static final int U_DOOR_FR = 45;
    public static final int U_DOOR_RL = 46;
    public static final int U_DOOR_RR = 47;
    public static final int U_EXIST_TPMS = 40;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 24;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 25;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 23;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 28;
    public static final int U_MUTIL_ECO_TIPS = 26;
    public static final int U_MUTIL_TRAVELLING_TIME = 27;
    public static final int U_PRESSURE_BACKUP = 39;
    public static final int U_PRESSURE_FL = 35;
    public static final int U_PRESSURE_FR = 36;
    public static final int U_PRESSURE_RL = 37;
    public static final int U_PRESSURE_RR = 38;
    public static final int U_RADAR_MUTE = 20;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 31;
    public static final int U_SHOW_TIRE_BACKUP = 41;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 29;
    public static final int U_UNIT_CONSUMPTION = 34;
    public static final int U_UNIT_TEMPERATURE = 33;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 43;
        DoorHelper.sUcDoorFl = 44;
        DoorHelper.sUcDoorFr = 45;
        DoorHelper.sUcDoorRl = 46;
        DoorHelper.sUcDoorRr = 47;
        DoorHelper.sUcDoorBack = 48;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 43; i2 < 49; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 43; i < 49; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 49) {
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
