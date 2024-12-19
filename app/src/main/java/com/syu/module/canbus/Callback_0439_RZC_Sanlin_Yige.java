package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_Sanlin_Yige extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_FUEL_AUTO = 4;
    public static final int U_CARINFO_AVG_FUEL_HAND = 5;
    public static final int U_CARINFO_BEGIN = 0;
    public static final int U_CARINFO_CUR_FUEL = 3;
    public static final int U_CARINFO_MILE_DRIVENABLE = 2;
    public static final int U_CARINFO_UNIT = 1;
    public static final int U_CARSAT_AIR_CONDITIONER_1 = 26;
    public static final int U_CARSAT_AIR_CONDITIONER_2 = 27;
    public static final int U_CARSAT_AIR_CONDITIONER_3 = 28;
    public static final int U_CARSAT_AIR_CONDITIONER_4 = 29;
    public static final int U_CARSAT_AIR_CONDITIONER_5 = 30;
    public static final int U_CARSAT_AIR_CONDITIONER_6 = 31;
    public static final int U_CARSAT_DOOR_LOCK_1 = 23;
    public static final int U_CARSAT_DOOR_LOCK_2 = 24;
    public static final int U_CARSAT_DOOR_LOCK_3 = 25;
    public static final int U_CARSAT_KEYLESS_1 = 7;
    public static final int U_CARSAT_KEYLESS_2 = 8;
    public static final int U_CARSAT_KEYLESS_3 = 9;
    public static final int U_CARSAT_LIGHTS_1 = 15;
    public static final int U_CARSAT_LIGHTS_2 = 16;
    public static final int U_CARSAT_LIGHTS_3 = 17;
    public static final int U_CARSAT_LIGHTS_4 = 18;
    public static final int U_CARSAT_LIGHTS_5 = 19;
    public static final int U_CARSAT_OTHER_1 = 32;
    public static final int U_CARSAT_OTHER_2 = 33;
    public static final int U_CARSAT_OTHER_3 = 34;
    public static final int U_CARSAT_TOUCH_SENSE = 6;
    public static final int U_CARSAT_TUM_SIGNAL_1 = 20;
    public static final int U_CARSAT_TUM_SIGNAL_2 = 21;
    public static final int U_CARSAT_TUM_SIGNAL_3 = 22;
    public static final int U_CARSAT_WIPERS_1 = 10;
    public static final int U_CARSAT_WIPERS_2 = 11;
    public static final int U_CARSAT_WIPERS_3 = 12;
    public static final int U_CARSAT_WIPERS_4 = 13;
    public static final int U_CARSAT_WIPERS_5 = 14;
    public static final int U_CNT_MAX = 35;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 35; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = ConstRzcAddData.U_DOOR_ENGINE_ADD;
        DoorHelper.sUcDoorFl = ConstRzcAddData.U_DOOR_FL_ADD;
        DoorHelper.sUcDoorFr = ConstRzcAddData.U_DOOR_FR_ADD;
        DoorHelper.sUcDoorRl = ConstRzcAddData.U_DOOR_RL_ADD;
        DoorHelper.sUcDoorRr = ConstRzcAddData.U_DOOR_RR_ADD;
        DoorHelper.sUcDoorBack = ConstRzcAddData.U_DOOR_BACK_ADD;
        DoorHelper.getInstance().buildUi();
        for (int i3 = ConstRzcAddData.U_DOOR_ENGINE_ADD; i3 <= 558; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
        if (updateCode >= 0 && updateCode < 35) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
