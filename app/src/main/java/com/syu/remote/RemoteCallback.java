package com.syu.remote;

import android.os.RemoteException;
import android.util.SparseArray;

import com.syu.ipc.IModuleCallback;

import org.greenrobot.eventbus.EventBus;

public class RemoteCallback extends IModuleCallback.Stub {
    int module;
    SparseArray<Boolean> notifies = new SparseArray<>();

    public RemoteCallback(int module) {
        this.module = module;
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        boolean notify = this.notifies.get(updateCode, false).booleanValue();
        if (notify) {
            Message msg = new Message(this.module, updateCode, ints, flts, strs);
            EventBus.getDefault().post(msg);
        }
    }

    protected void enable(int code) {
        boolean notify = this.notifies.get(code, false).booleanValue();
        if (!notify) {
            this.notifies.put(code, true);
        }
    }

    protected void disEnable(int code) {
        if (this.notifies.indexOfKey(code) >= 0) {
            boolean notify = this.notifies.get(code).booleanValue();
            if (notify) {
                this.notifies.put(code, false);
            }
        }
    }
}
