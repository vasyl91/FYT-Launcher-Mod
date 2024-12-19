package com.syu.module.canbus.up;

import com.syu.module.IUiNotify;

public class HandleCanUp {
    private static final IUiNotify NTF_CANBUS_UP_ID = new IUiNotify() { 
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            CallbackCanUpBase callbackCanbus = HandleCanUp.getCallbackCanbusById(DataCanUp.DATA[updateCode]);
            ModuleCallbackCanUpProxy.getInstance().setCallbackCanbus(callbackCanbus);
        }
    };

    public static void update(int updateCode, int[] ints) {
        if (ints != null && ints.length != 0 && DataCanUp.DATA[updateCode] != ints[0]) {
            DataCanUp.DATA[updateCode] = ints[0];
            DataCanUp.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void update(int updateCode, int value) {
        if (DataCanUp.DATA[updateCode] != value) {
            DataCanUp.DATA[updateCode] = value;
            DataCanUp.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    public static void canbusUpId(int updateCode, int value) {
        if (DataCanUp.DATA[updateCode] != value) {
            DataCanUp.DATA[updateCode] = value;
            DataCanUp.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }

    static {
        DataCanUp.NOTIFY_EVENTS[100].addNotify(NTF_CANBUS_UP_ID, 1);
    }

    public static CallbackCanUpBase getCallbackCanbusById(int id) {
        switch (id) {
            case 1:
                return new Callback_0001_SBD();
            case 2:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 19:
                return new Callback_0002_WC();
            case 3:
            case 9:
            case 12:
            case 13:
            case 14:
            case 15:
            case 17:
            case 18:
            case 20:
                return new Callback_0003_XP();
            case 4:
                return new Callback_0004_AY();
            case 11:
            case 16:
                return new Callback_0005_LZ();
            default:
                return null;
        }
    }
}
