package com.lsec.core.ipc;

import android.os.IBinder;
import com.syu.ipc.IModuleCallback;
import java.util.BitSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class IpcToolkit {
    private static BitSet getBitSet(ModuleCallbackList list, IModuleCallback callback) {
        BitSet bitset = null;
        IBinder binder = callback.asBinder();
        int cnt = list.beginBroadcast();
        for (int i = 0; i < cnt; i++) {
            if (binder.equals(list.getBroadcastItem(i).asBinder())) {
                bitset = (BitSet) list.getBroadcastCookie(i);
                break;
            }
        }
        list.finishBroadcast();
        return bitset;
    }

    public static void register(ModuleCallbackList list, IModuleCallback callback, int updateCode) {
        synchronized (list) {
            BitSet bitset = getBitSet(list, callback);
            if (bitset == null) {
                BitSet bitset2 = new BitSet(128);
                bitset2.set(updateCode);
                list.register(callback, bitset2);
            } else {
                bitset.set(updateCode);
            }
        }
    }

    public static void unregister(ModuleCallbackList list, IModuleCallback callback, int updateCode) {
        synchronized (list) {
            BitSet bitset = getBitSet(list, callback);
            if (bitset != null) {
                bitset.clear(updateCode);
                if (bitset.isEmpty()) {
                    list.unregister(callback);
                }
            }
        }
    }
}
