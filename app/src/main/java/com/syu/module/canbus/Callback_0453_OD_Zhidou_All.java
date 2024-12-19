package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_OD_Zhidou_All extends CallbackCanbusBase {
    public static final int U_CARSET_D31_D0_B70 = 7;
    public static final int U_CARSET_D31_D1_B70 = 8;
    public static final int U_CARSET_D31_D2_D3 = 9;
    public static final int U_CARSET_D31_D4_B70 = 10;
    public static final int U_CARSET_D31_D5_B70 = 11;
    public static final int U_CARSET_D31_D6_D7 = 12;
    public static final int U_CARSET_D31_D8_B70 = 13;
    public static final int U_CARSET_D32_D0_B70 = 14;
    public static final int U_CARSET_D32_D1_B70 = 15;
    public static final int U_CARSET_D32_D2_D3 = 16;
    public static final int U_CNT_MAX = 17;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 17; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 17) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
