package com.syu.ipc;

import android.os.RemoteException;
import com.syu.ipc.IRemoteModule;

public class RemoteModuleProxy extends IRemoteModule.Stub {
    private IRemoteModule mRemoteModule;

    public IRemoteModule getRemoteModule() {
        return this.mRemoteModule;
    }

    public void setRemoteModule(IRemoteModule remoteModule) {
        this.mRemoteModule = remoteModule;
    }

    @Override // com.syu.ipc.IRemoteModule
    public void cmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.cmd(cmdCode, ints, flts, strs);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cmd(int cmdCode) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.cmd(cmdCode, null, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cmd(int cmdCode, int value) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.cmd(cmdCode, new int[]{value}, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cmd(int cmdCode, int value1, int value2) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.cmd(cmdCode, new int[]{value1, value2}, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public ModuleObject get(int getCode, int[] ints, float[] flts, String[] strs) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                return remoteModule.get(getCode, ints, flts, strs);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ModuleObject get(int getCode, int value) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule == null) {
            return null;
        }
        try {
            return remoteModule.get(getCode, new int[]{value}, null, null);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getI(int getCode, int valueIfNotOk) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                ModuleObject obj = remoteModule.get(getCode, null, null, null);
                if (obj != null && obj.ints != null && obj.ints.length >= 1) {
                    return obj.ints[0];
                }
                return valueIfNotOk;
            } catch (RemoteException e) {
                e.printStackTrace();
                return valueIfNotOk;
            }
        }
        return valueIfNotOk;
    }

    public String getS(int getCode, int value) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule == null) {
            return null;
        }
        try {
            ModuleObject obj = remoteModule.get(getCode, new int[]{value}, null, null);
            if (obj == null || obj.strs == null || obj.strs.length < 1) {
                return null;
            }
            return obj.strs[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getS(int getCode, int value1, int value2) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule == null) {
            return null;
        }
        try {
            ModuleObject obj = remoteModule.get(getCode, new int[]{value1, value2}, null, null);
            if (obj == null || obj.strs == null || obj.strs.length < 1) {
                return null;
            }
            return obj.strs[0];
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public void register(IModuleCallback callback, int updateCode, int update) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.register(callback, updateCode, update);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public void unregister(IModuleCallback callback, int updateCode) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                remoteModule.unregister(callback, updateCode);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
