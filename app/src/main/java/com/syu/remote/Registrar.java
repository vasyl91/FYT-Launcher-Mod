package com.syu.remote;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.ModuleObject;
import com.syu.remote.Callback;

/* loaded from: D:\APK\APKRepatcher\Projects\launcher66xda.apk\dexFile\classes.dex */
public abstract class Registrar {
    protected Callback mCallback = new Callback();
    IRemoteModule mModule;
    int[] mRefreshCode;

    abstract void registerCallback();

    final void unRegisterCallback() {
        unRegisterCode();
    }

    void addOnRefreshLisenter(Callback.OnRefreshLisenter lisenter, int... codes) {
        if (codes != null && codes.length != 0) {
            for (int code : codes) {
                if (lisenter != null) {
                    this.mCallback.addOnRefreshLisenter(lisenter, code);
                }
            }
        }
    }

    void removeOnRefreshLisenter(Callback.OnRefreshLisenter lisenter) {
        if (lisenter != null) {
            this.mCallback.removeOnRefreshLisenter(lisenter);
        }
    }

    void registerCallback(IModuleCallback cb, int code, boolean enable) {
        if (this.mModule != null) {
            try {
                this.mModule.register(cb, code, enable ? 1 : 0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    void registerCode(int... codes) {
        if (codes != null) {
            this.mRefreshCode = codes;
            for (int code : codes) {
                registerCallback(this.mCallback, code, true);
            }
        }
    }

    void unRegisterCode() {
        if (this.mRefreshCode != null && this.mRefreshCode.length != 0) {
            for (int code : this.mRefreshCode) {
                unRegisterCallback(this.mCallback, code);
            }
        }
    }

    void notify(int... codes) {
        if (codes != null && codes.length > 0 && this.mModule != null) {
            for (int code : codes) {
                registerCallback(this.mCallback, code, true);
            }
        }
    }

    void unRegisterCallback(IModuleCallback cb, int code) {
        if (this.mModule != null) {
            try {
                this.mModule.unregister(cb, code);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    Callback getCallback() {
        return this.mCallback;
    }

    IRemoteModule getModule() {
        return this.mModule;
    }

    void setModule(IRemoteModule mModule) {
        this.mModule = mModule;
        registerCallback();
    }

    final int getInt(int def, int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            return (object == null || object.ints == null || object.ints.length <= 0) ? def : object.ints[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return def;
        }
    }

    final float getFlt(float def, int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            return (object == null || object.flts == null || object.flts.length <= 0) ? def : object.flts[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return def;
        }
    }

    final String getStr(String def, int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            return (object == null || object.strs == null || object.strs.length <= 0) ? def : object.strs[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return def;
        }
    }

    final int[] getInts(int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            if (object != null) {
                return object.ints;
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    final float[] getFlts(float def, int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            if (object != null) {
                return object.flts;
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    final String[] getStrs(int code, int... params) {
        try {
            ModuleObject object = this.mModule.get(code, params, null, null);
            if (object != null) {
                return object.strs;
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
