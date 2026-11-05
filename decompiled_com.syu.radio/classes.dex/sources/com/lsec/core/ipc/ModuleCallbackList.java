package com.lsec.core.ipc;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import java.util.BitSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ModuleCallbackList extends RemoteCallbackList<IModuleCallback> {
    @Override // android.os.RemoteCallbackList
    public synchronized boolean register(IModuleCallback callback) {
        return super.register(callback);
    }

    @Override // android.os.RemoteCallbackList
    public synchronized boolean unregister(IModuleCallback callback) {
        return super.unregister(callback);
    }

    public synchronized void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        int cnt = beginBroadcast();
        for (int i = 0; i < cnt; i++) {
            if (((BitSet) getBroadcastCookie(i)).get(updateCode)) {
                IModuleCallback callback = getBroadcastItem(i);
                synchronized (callback) {
                    try {
                        callback.update(updateCode, ints, flts, strs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        finishBroadcast();
    }

    public void update(int updateCode, int value) {
        update(updateCode, new int[]{value}, (float[]) null, (String[]) null);
    }

    public static void update(IModuleCallback callback, int updateCode, int value) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, new int[]{value}, null, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(IModuleCallback callback, int updateCode, int value1, int value2) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, new int[]{value1, value2}, null, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(IModuleCallback callback, int updateCode, int[] ints, float[] flts, String[] strs) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, ints, flts, strs);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(IModuleCallback callback, int updateCode, int[] ints) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, ints, null, null);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(IModuleCallback callback, int updateCode, String value) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, null, null, new String[]{value});
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void update(IModuleCallback callback, int updateCode, int intValue, String strValue) {
        if (callback != null) {
            synchronized (callback) {
                try {
                    callback.update(updateCode, new int[]{intValue}, null, new String[]{strValue});
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
