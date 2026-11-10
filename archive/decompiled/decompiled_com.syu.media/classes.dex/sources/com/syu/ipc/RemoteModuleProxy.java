package com.syu.ipc;

import android.os.RemoteException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class RemoteModuleProxy extends IRemoteModule.Stub {
    private IRemoteModule mRemoteModule;

    public void cmd(int i) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.cmd(i, null, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public ModuleObject get(int i, int i2) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                return iRemoteModule.get(i, new int[]{i2}, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int getI(int i, int i2) {
        int[] iArr;
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                ModuleObject moduleObject = iRemoteModule.get(i, null, null, null);
                if (moduleObject != null && (iArr = moduleObject.ints) != null && iArr.length >= 1) {
                    return iArr[0];
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return i2;
    }

    public IRemoteModule getRemoteModule() {
        return this.mRemoteModule;
    }

    public String getS(int i, int i2) {
        String[] strArr;
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                ModuleObject moduleObject = iRemoteModule.get(i, new int[]{i2}, null, null);
                if (moduleObject != null && (strArr = moduleObject.strs) != null && strArr.length >= 1) {
                    return strArr[0];
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.syu.ipc.IRemoteModule
    public void register(IModuleCallback iModuleCallback, int i, int i2) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.register(iModuleCallback, i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setRemoteModule(IRemoteModule iRemoteModule) {
        this.mRemoteModule = iRemoteModule;
    }

    @Override // com.syu.ipc.IRemoteModule
    public void unregister(IModuleCallback iModuleCallback, int i) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.unregister(iModuleCallback, i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void cmd(int i, int i2) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.cmd(i, new int[]{i2}, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public ModuleObject get(int i, int[] iArr, float[] fArr, String[] strArr) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule == null) {
            return null;
        }
        try {
            return iRemoteModule.get(i, iArr, fArr, strArr);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getS(int i, int i2, int i3) {
        String[] strArr;
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                ModuleObject moduleObject = iRemoteModule.get(i, new int[]{i2, i3}, null, null);
                if (moduleObject != null && (strArr = moduleObject.strs) != null && strArr.length >= 1) {
                    return strArr[0];
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void cmd(int i, int i2, int i3) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.cmd(i, new int[]{i2, i3}, null, null);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public void cmd(int i, int[] iArr, float[] fArr, String[] strArr) {
        IRemoteModule iRemoteModule = this.mRemoteModule;
        if (iRemoteModule != null) {
            try {
                iRemoteModule.cmd(i, iArr, fArr, strArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
