package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0359_XP1_16mairuibao;
import com.syu.ui.air.Air_0359_XP1_16mairuibao_low;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0359_XP1_MaiRuiBao16 extends CallbackCanbusBase {
    public static final int U_AIR_END = 113;
    public static final int U_AIR_SYNC = 112;
    public static final int U_CAR_COMPASS_ANGEL = 128;
    public static final int U_CAR_WIN_LF = 125;
    public static final int U_CAR_WIN_LR = 127;
    public static final int U_CAR_WIN_RF = 124;
    public static final int U_CAR_WIN_RR = 126;
    public static final int U_CNT_MAX = 129;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 113;
        DoorHelper.sUcDoorFl = 114;
        DoorHelper.sUcDoorFr = 115;
        DoorHelper.sUcDoorRl = 116;
        DoorHelper.sUcDoorRr = 117;
        DoorHelper.sUcDoorBack = 118;
        if (DataCanbus.DATA[1000] == 131431 || DataCanbus.DATA[1000] == 65895) {
            AirHelper.getInstance().buildUi(new Air_0359_XP1_16mairuibao(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0359_XP1_16mairuibao_low(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 113; i2 < 119; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 87; i3 < 113; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 113; i < 119; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 113; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 18:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 129) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}