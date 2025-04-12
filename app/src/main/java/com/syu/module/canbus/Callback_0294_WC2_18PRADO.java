package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0294_WC2_18PRADO extends CallbackCanbusBase {
    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 52;
        DoorHelper.sUcDoorFl = 53;
        DoorHelper.sUcDoorFr = 54;
        DoorHelper.sUcDoorRl = 55;
        DoorHelper.sUcDoorRr = 56;
        DoorHelper.sUcDoorBack = 57;
        //AirHelper.getInstance().buildUi(new Air_0294_WC2_18PRADO(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 52; i2 < 58; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 40; i3 < 51; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i4 = 59; i4 < 70; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 52; i < 58; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 40; i2 < 51; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 18:
                    tripOilexpend(updateCode, ints);
                    break;
                case 19:
                    lastMinoldexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 144) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void tripOilexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void lastMinoldexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
