package qin.x_core.server;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import java.util.BitSet;
import qin.x_core.aidl.IDataObserver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class RemoteObserverList extends RemoteCallbackList<IDataObserver> {
    public final Object a = new Object();

    /* JADX WARN: Multi-variable type inference failed */
    public boolean register(IDataObserver iDataObserver, int i) {
        boolean z;
        BitSet bitSet;
        int i2 = 0;
        if (iDataObserver == null) {
            return false;
        }
        synchronized (this.a) {
            IBinder iBinderAsBinder = iDataObserver.asBinder();
            int iBeginBroadcast = beginBroadcast();
            z = 1;
            if (iBeginBroadcast > 0) {
                int i3 = 0;
                while (i2 < iBeginBroadcast) {
                    if (iBinderAsBinder.equals(((IDataObserver) getBroadcastItem(i2)).asBinder()) && (bitSet = (BitSet) getBroadcastCookie(i2)) != null) {
                        bitSet.set(i);
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                i2 = i3;
            }
            if (i2 == 0) {
                BitSet bitSet2 = new BitSet(256);
                bitSet2.set(i);
                register(iDataObserver, bitSet2);
            } else {
                z = i2;
            }
            finishBroadcast();
        }
        return z;
    }

    public void unregister(IDataObserver iDataObserver, int i) {
        if (iDataObserver == null) {
            return;
        }
        synchronized (this.a) {
            IBinder iBinderAsBinder = iDataObserver.asBinder();
            int iBeginBroadcast = beginBroadcast();
            for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                if (iBinderAsBinder == getBroadcastItem(i2).asBinder()) {
                    BitSet bitSet = (BitSet) getBroadcastCookie(i2);
                    if (bitSet.get(i)) {
                        bitSet.clear(i);
                    }
                }
            }
            finishBroadcast();
        }
    }

    public void update(Bundle bundle) {
        int i = bundle.getInt("cmd_id", Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("the 'update' operation cmdId can't be empty!!");
        }
        synchronized (this.a) {
            try {
                try {
                    int iBeginBroadcast = beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
                        if (((BitSet) getBroadcastCookie(i2)).get(i)) {
                            getBroadcastItem(i2).onDataChanged(bundle);
                        }
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    finishBroadcast();
                    throw th;
                }
                finishBroadcast();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
