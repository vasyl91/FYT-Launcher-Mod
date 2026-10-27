package com.syu.module.canbus.up;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.module.canbus.CanbusModuleGuard;

public class ModuleCallbackCanUpProxy extends IModuleCallback.Stub {
    private static final ModuleCallbackCanUpProxy INSTANCE = new ModuleCallbackCanUpProxy();
    private CallbackCanUpBase mCallbackCanUpBase;

    private ModuleCallbackCanUpProxy() {
    }

    public static ModuleCallbackCanUpProxy getInstance() {
        return INSTANCE;
    }

    public void setCallbackCanbus(CallbackCanUpBase callback) {
        if (this.mCallbackCanUpBase != callback) {
            CallbackCanUpBase old = this.mCallbackCanUpBase;
            if (old != null) {
                CanbusModuleGuard.out(old, old::out);
            }
            this.mCallbackCanUpBase = callback;
            if (callback != null) {
                CanbusModuleGuard.in(callback, DataCanUp.DATA[100], callback::in);
            }
        }
    }

    public CallbackCanUpBase getCallbackUpCanbus() {
        return this.mCallbackCanUpBase;
    }

    private boolean intsOk(int[] ints, int min) {
        return ints != null && ints.length >= min;
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode < 100) {
                IModuleCallback callback = this.mCallbackCanUpBase;
                if (callback != null) {
                    try {
                        callback.update(updateCode, ints, flts, strs);
                    } catch (RuntimeException e) {
                        CanbusModuleGuard.failed(callback, "update", e);
                    }
                    return;
                }
                return;
            }
            switch (updateCode) {
                case 100:
                    if (intsOk(ints, 1)) {
                        HandleCanUp.canbusUpId(updateCode, ints[0]);
                        break;
                    }
            }
        }
    }
}
