package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7AirActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0040_XP_Golf7;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0044_XP1_GaoErFu7_Lo extends CallbackCanbusBase {
    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 470; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 109;
        DoorHelper.sUcDoorFl = 110;
        DoorHelper.sUcDoorFr = 111;
        DoorHelper.sUcDoorRl = 112;
        DoorHelper.sUcDoorRr = 113;
        DoorHelper.sUcDoorBack = 114;
        AirHelper.getInstance().buildUi(new Air_0040_XP_Golf7(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 109; i2 < 115; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 87; i3 < 108; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 109; i < 115; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 108; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 74:
                    warningVehicle(updateCode, ints);
                    break;
                case 75:
                    warningStartStop(updateCode, ints);
                    break;
                case 76:
                    convConsumer(updateCode, ints);
                    break;
                case 82:
                    if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(ConstGolf.mCarId, strs[0])) {
                        ConstGolf.mCarId = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
                case 104:
                    if (updateCode >= 0 && updateCode < 470) {
                        HandlerCanbus.update(updateCode, ints);
                    }
                    int value = DataCanbus.DATA[104];
                    if (value == 1 && !Golf7AirActi.mIsFront) {
                        AirHelper.disableAirWindowLocal(true);
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.Golf7AirActi");
                        break;
                    } else if (value == 0 && Golf7AirActi.mIsFront && Golf7AirActi.mInstance != null) {
                        Golf7AirActi.mInstance.finish();
                        break;
                    }
                default:
                    if (updateCode >= 0 && updateCode < 470) {
                        HandlerCanbus.update(updateCode, ints);
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
