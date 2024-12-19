package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0017_WC2_Golf;
import com.syu.ui.air.Air_0270_HSY_TuRui;
import com.syu.ui.air.Air_0270_WC_TuRui;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0270_WC2_LingDu extends CallbackCanbusBase {
    public static final int CMD_AIR = 22;
    public static final int CMD_SET = 23;
    public static final int U_AIR_FRONT_WIN_HOT = 235;
    public static final int U_AIR_STEER_HOT = 234;
    public static final int U_CNT_MAX = 236;
    public static final int U_SET_RAIN_SENSOR = 164;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 236; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 109;
        DoorHelper.sUcDoorFl = 110;
        DoorHelper.sUcDoorFr = 111;
        DoorHelper.sUcDoorRl = 112;
        DoorHelper.sUcDoorRr = 113;
        DoorHelper.sUcDoorBack = 114;
        if (DataCanbus.DATA[1000] == 131342 || DataCanbus.DATA[1000] == 262414 || DataCanbus.DATA[1000] == 327950) {
            AirHelper.getInstance().buildUi(new Air_0270_WC_TuRui(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[120].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[149].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else if (DataCanbus.DATA[1000] == 196878) {
            AirHelper.getInstance().buildUi(new Air_0270_HSY_TuRui(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[120].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[149].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else {
            AirHelper.getInstance().buildUi(new Air_0017_WC2_Golf(LauncherApplication.getInstance()));
        }
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
        DataCanbus.NOTIFY_EVENTS[120].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[149].removeNotify(AirHelper.SHOW_AND_REFRESH);
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
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                default:
                    if (updateCode >= 0 && updateCode < 470) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 82:
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
