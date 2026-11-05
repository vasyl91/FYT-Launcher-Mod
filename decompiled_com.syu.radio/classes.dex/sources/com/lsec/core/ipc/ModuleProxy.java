package com.lsec.core.ipc;

import android.os.Handler;
import android.os.HandlerThread;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.ModuleObject;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ModuleProxy extends IRemoteModule.Stub {
    public static Handler mHandlerCmd;
    public static HandlerThread mHandlerThreadCmd;
    private IRemoteModule mRemoteModule;

    static {
        mHandlerThreadCmd = null;
        mHandlerCmd = null;
        mHandlerThreadCmd = new HandlerThread("ModuleProxy-CMD-Thread");
        mHandlerThreadCmd.start();
        mHandlerCmd = new Handler(mHandlerThreadCmd.getLooper());
    }

    public IRemoteModule getRemoteModule() {
        return this.mRemoteModule;
    }

    public void setRemoteModule(IRemoteModule remoteModule) {
        this.mRemoteModule = remoteModule;
    }

    public class Runnable_Cmd implements Runnable {
        int cmdCode;
        float[] flts;
        int[] ints;
        String[] strs;

        public Runnable_Cmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
            this.cmdCode = cmdCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (ModuleProxy.this.mRemoteModule != null) {
                    ModuleProxy.this.mRemoteModule.cmd(this.cmdCode, this.ints, this.flts, this.strs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.ipc.IRemoteModule
    public void cmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
        if (mHandlerCmd != null) {
            mHandlerCmd.post(new Runnable_Cmd(cmdCode, ints, flts, strs));
        }
    }

    public void cmd(int cmdCode) {
        cmd(cmdCode, (int[]) null, (float[]) null, (String[]) null);
    }

    public void cmd(int cmdCode, int value) {
        cmd(cmdCode, new int[]{value}, (float[]) null, (String[]) null);
    }

    public void cmd(int cmdCode, String value) {
        cmd(cmdCode, (int[]) null, (float[]) null, new String[]{value});
    }

    public void cmd(int cmdCode, int value1, int value2) {
        cmd(cmdCode, new int[]{value1, value2}, (float[]) null, (String[]) null);
    }

    public void cmd(int cmdCode, int value1, int value2, int value3) {
        cmd(cmdCode, new int[]{value1, value2, value3}, (float[]) null, (String[]) null);
    }

    @Override // com.syu.ipc.IRemoteModule
    public ModuleObject get(int getCode, int[] ints, float[] flts, String[] strs) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                return remoteModule.get(getCode, ints, flts, strs);
            } catch (Exception e) {
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
        } catch (Exception e) {
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
            } catch (Exception e) {
                e.printStackTrace();
                return valueIfNotOk;
            }
        }
        return valueIfNotOk;
    }

    public int getI(int getCode, int value, int valueIfNotOk) {
        IRemoteModule remoteModule = this.mRemoteModule;
        if (remoteModule != null) {
            try {
                ModuleObject obj = remoteModule.get(getCode, new int[]{value}, null, null);
                if (obj != null && obj.ints != null && obj.ints.length >= 1) {
                    return obj.ints[0];
                }
                return valueIfNotOk;
            } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
            } catch (Exception e) {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
