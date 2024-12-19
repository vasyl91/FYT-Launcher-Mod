package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_RZC_Subaru extends CallbackCanbusBase {
    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = ConstRzcAddData.U_CAR_ADD_START; i < 560; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = ConstRzcAddData.U_DOOR_ENGINE_ADD;
        DoorHelper.sUcDoorFl = ConstRzcAddData.U_DOOR_FL_ADD;
        DoorHelper.sUcDoorFr = ConstRzcAddData.U_DOOR_FR_ADD;
        DoorHelper.sUcDoorRl = ConstRzcAddData.U_DOOR_RL_ADD;
        DoorHelper.sUcDoorRr = ConstRzcAddData.U_DOOR_RR_ADD;
        DoorHelper.sUcDoorBack = ConstRzcAddData.U_DOOR_BACK_ADD;
        DoorHelper.getInstance().buildUi();
        for (int i2 = ConstRzcAddData.U_DOOR_ENGINE_ADD; i2 <= 558; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = ConstRzcAddData.U_DOOR_ENGINE_ADD; i <= 558; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
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
    }
}
