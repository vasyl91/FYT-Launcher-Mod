package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.golf7.ConstGolf;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

public class Callback_0270_WC2_LingDu extends CallbackCanbusBase {
    public static final int CMD_AIR = 22;
    public static final int CMD_SET = 23;
    public static final int U_CNT_MAX = 272;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 272; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 131342 || DataCanbus.DATA[1000] == 262414 || DataCanbus.DATA[1000] == 327950) {
            //AirHelper.getInstance().buildUi(new Air_0270_WC_TuRui(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 196878) {
            //AirHelper.getInstance().buildUi(new Air_0270_HSY_TuRui(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_Golf(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 171:
                    warningVehicle(updateCode, ints);
                    break;
                case 172:
                    warningStartStop(updateCode, ints);
                    break;
                case 173:
                    convConsumer(updateCode, ints);
                    break;
                case 174:
                case 175:
                case 176:
                case 177:
                case 178:
                default:
                    if (updateCode >= 0 && updateCode < 461) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 179:
                    if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(ConstGolf.mCarId, strs[0])) {
                        ConstGolf.mCarId = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
            }
        }
    }

    private void convConsumer(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mConvConsumer[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningVehicle(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 16) {
            ConstGolf.mVehicleWarning[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningStartStop(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mSartStop[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
