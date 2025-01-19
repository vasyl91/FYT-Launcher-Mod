package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.psa_all.PsaAllAlarmRecordActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0056_WC2_XueTieLong2008 extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 118;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 119;
    public static final int U_CLOSE_BIGLAMP_TIME = 129;
    public static final int U_CLOSE_INSIDELAMP_TIME = 127;
    public static final int U_CNT_MAX = 139;
    public static final int U_EXIST_TPMS = 137;
    public static final int U_MUTIL_AVERAGE_CONSUMPTION = 121;
    public static final int U_MUTIL_CONVENIENCE_CONSUMER = 122;
    public static final int U_MUTIL_CURRENT_CONSUMPTION = 120;
    public static final int U_MUTIL_DISTANCE_TRAVELLED = 125;
    public static final int U_MUTIL_ECO_TIPS = 123;
    public static final int U_MUTIL_TRAVELLING_TIME = 124;
    public static final int U_PRESSURE_BACKUP = 136;
    public static final int U_PRESSURE_FL = 132;
    public static final int U_PRESSURE_FR = 133;
    public static final int U_PRESSURE_RL = 134;
    public static final int U_PRESSURE_RR = 135;
    public static final int U_RADAR_MUTE = 117;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 128;
    public static final int U_SHOW_TIRE_BACKUP = 138;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 126;
    public static final int U_UNIT_CONSUMPTION = 131;
    public static final int U_UNIT_TEMPERATURE = 130;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 139; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 139) {
            if (updateCode == 115) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[115];
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
            if (updateCode == 116) {
                HandlerCanbus.update(updateCode, ints);
                int value2 = DataCanbus.DATA[116];
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
