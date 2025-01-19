package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0166_WC2_15_AoDeSai extends CallbackCanbusBase {
    public static final int U_CARSHOW_DATA1 = 118;
    public static final int U_CARSHOW_DATA10 = 127;
    public static final int U_CARSHOW_DATA11 = 128;
    public static final int U_CARSHOW_DATA12 = 129;
    public static final int U_CARSHOW_DATA13 = 130;
    public static final int U_CARSHOW_DATA14 = 131;
    public static final int U_CARSHOW_DATA15 = 132;
    public static final int U_CARSHOW_DATA16 = 133;
    public static final int U_CARSHOW_DATA17 = 134;
    public static final int U_CARSHOW_DATA17_2 = 147;
    public static final int U_CARSHOW_DATA18 = 135;
    public static final int U_CARSHOW_DATA19 = 136;
    public static final int U_CARSHOW_DATA2 = 119;
    public static final int U_CARSHOW_DATA20 = 137;
    public static final int U_CARSHOW_DATA21 = 138;
    public static final int U_CARSHOW_DATA22 = 139;
    public static final int U_CARSHOW_DATA23 = 140;
    public static final int U_CARSHOW_DATA24 = 141;
    public static final int U_CARSHOW_DATA25 = 142;
    public static final int U_CARSHOW_DATA26 = 143;
    public static final int U_CARSHOW_DATA27 = 144;
    public static final int U_CARSHOW_DATA28 = 145;
    public static final int U_CARSHOW_DATA29 = 146;
    public static final int U_CARSHOW_DATA3 = 120;
    public static final int U_CARSHOW_DATA4 = 121;
    public static final int U_CARSHOW_DATA5 = 122;
    public static final int U_CARSHOW_DATA6 = 123;
    public static final int U_CARSHOW_DATA7 = 124;
    public static final int U_CARSHOW_DATA8 = 125;
    public static final int U_CARSHOW_DATA9 = 126;
    public static final int U_CNT_MAX = 148;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 148; i++) {
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

    private void updateWarningNum(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 4) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 148) {
            switch (updateCode) {
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                    updateWarningNum(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
