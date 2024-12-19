package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_12ELYSION extends CallbackCanbusBase {
    public static String STR_SHOW1 = null;
    public static String STR_SHOW2 = null;
    public static String STR_SHOW3 = null;
    public static String STR_SHOW4 = null;
    public static final int U_AVERAGE_OIL_CONSUMPTION = 3;
    public static final int U_AVERAGE_OIL_CONSUMPTION_1 = 13;
    public static final int U_AVERAGE_OIL_CONSUMPTION_2 = 15;
    public static final int U_AVERAGE_OIL_CONSUMPTION_3 = 17;
    public static final int U_AVERAGE_OIL_CONSUMPTION_UNIT = 8;
    public static final int U_CARCD_D0_D18_B5 = 39;
    public static final int U_CARCD_D0_D18_B6 = 38;
    public static final int U_CARCD_D0_D18_B7 = 37;
    public static final int U_CARCD_D0_D19_B30 = 40;
    public static final int U_CARCD_D0_D1_B0 = 32;
    public static final int U_CARCD_D0_D1_B31 = 31;
    public static final int U_CARCD_D0_D1_B74 = 30;
    public static final int U_CARCD_D0_D20_B30 = 42;
    public static final int U_CARCD_D0_D20_B7 = 41;
    public static final int U_CARCD_D0_D21_B20 = 45;
    public static final int U_CARCD_D0_D21_B53 = 44;
    public static final int U_CARCD_D0_D21_B7 = 43;
    public static final int U_CARCD_D0_STR_SHOW1 = 33;
    public static final int U_CARCD_D0_STR_SHOW2 = 34;
    public static final int U_CARCD_D0_STR_SHOW3 = 35;
    public static final int U_CARCD_D0_STR_SHOW4 = 36;
    public static final int U_CARCD_VOL = 46;
    public static final int U_CNT_MAX = 47;
    public static final int U_CURRENT_AVERAGE_OIL_CONSUMPTION = 1;
    public static final int U_CURRENT_OIL_CONSUMPTION = 0;
    public static final int U_CURRENT_OIL_CONSUMPTION_UNIT = 6;
    public static final int U_CUR_SPEED = 27;
    public static final int U_DOOR_BACK = 26;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 29;
    public static final int U_DOOR_ENGINE = 21;
    public static final int U_DOOR_FL = 22;
    public static final int U_DOOR_FR = 23;
    public static final int U_DOOR_RL = 24;
    public static final int U_DOOR_RR = 25;
    public static final int U_ENGINE_SPEED = 28;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION = 2;
    public static final int U_HISTORY_AVERAGE_OIL_CONSUMPTION_UNIT = 7;
    public static final int U_LIFE_MILEAGE = 5;
    public static final int U_LIFE_MILEAGE_UNIT = 10;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 19;
    public static final int U_OIL_CONSUMPTION_COUNT = 11;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 18;
    public static final int U_TRIPA = 4;
    public static final int U_TRIPA_1 = 12;
    public static final int U_TRIPA_2 = 14;
    public static final int U_TRIPA_3 = 16;
    public static final int U_TRIPA_UNIT = 9;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 21;
        DoorHelper.sUcDoorFl = 22;
        DoorHelper.sUcDoorFr = 23;
        DoorHelper.sUcDoorRl = 24;
        DoorHelper.sUcDoorRr = 25;
        DoorHelper.sUcDoorBack = 26;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 20; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 29; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            switch (updateCode) {
                case 33:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW1 = strs[0];
                    } else {
                        STR_SHOW1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 34:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW2 = strs[0];
                    } else {
                        STR_SHOW2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 35:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW3 = strs[0];
                    } else {
                        STR_SHOW3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 36:
                    if (strs != null && strs.length > 0) {
                        STR_SHOW4 = strs[0];
                    } else {
                        STR_SHOW4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
