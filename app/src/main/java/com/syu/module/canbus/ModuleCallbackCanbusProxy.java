package com.syu.module.canbus;

import android.content.Intent;
import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class ModuleCallbackCanbusProxy extends IModuleCallback.Stub {
    private static final ModuleCallbackCanbusProxy INSTANCE = new ModuleCallbackCanbusProxy();
    private CallbackCanbusBase mCallback;

    public static ModuleCallbackCanbusProxy getInstance() {
        return INSTANCE;
    }

    public void setCallbackCanbus(CallbackCanbusBase callback) {
        if (this.mCallback != callback) {
            if (this.mCallback != null) {
                this.mCallback.out();
                DoorHelper.clearDoorUpdateCode();
            }
            this.mCallback = callback;
            if (this.mCallback != null) {
                this.mCallback.in();
            }
        }
    }

    public CallbackCanbusBase getCallbackCanbus() {
        return this.mCallback;
    }

    private ModuleCallbackCanbusProxy() {
    }

    private boolean intsOk(int[] ints, int min) {
        return ints != null && ints.length >= min;
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode < 1000) {
                IModuleCallback callback = this.mCallback;
                if (callback != null) {
                    callback.update(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            switch (updateCode) {
                case 1000:
                    if (intsOk(ints, 1)) {
                        HandlerCanbus.canbusId(updateCode, ints[0]);
                        break;
                    }
                case FinalCanbus.U_AIR_WINDOW_ENABLE /* 1001 */:
                    if (intsOk(ints, 1)) {
                        AirHelper.airWindowEnable(ints[0]);
                        break;
                    }
                case FinalCanbus.U_DOOR_WINDOW_ENABLE /* 1002 */:
                    if (intsOk(ints, 1)) {
                        DoorHelper.doorWindowEnable(ints[0]);
                        break;
                    }
                case FinalCanbus.U_DRIVER_ON_RIGHT /* 1003 */:
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case FinalCanbus.U_SHOW_AIR_WINDOW /* 1008 */:
                    try {
                        Intent intent = new Intent("com.syu.canbus.enter.air");
                        intent.setPackage(LauncherApplication.getInstance().getPackageName());
                        LauncherApplication.getInstance().sendBroadcast(intent);
                        break;
                    } catch (Exception e) {
                        return;
                    }
                case FinalCanbus.U_CAR_BT_ON /* 1015 */:
                    HandlerCanbus.updateCarBt(ints[0]);
                    break;
                case FinalCanbus.U_ORI_CARBACK /* 1021 */:
                    IModuleCallback callback2 = this.mCallback;
                    if (callback2 != null) {
                        callback2.update(updateCode, ints, flts, strs);
                        break;
                    }
            }
        }
    }
}
