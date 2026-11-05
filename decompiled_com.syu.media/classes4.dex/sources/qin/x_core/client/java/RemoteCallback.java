package qin.x_core.client.java;

import android.os.Bundle;
import android.util.SparseArray;
import qin.x_core.aidl.IDataObserver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class RemoteCallback extends IDataObserver.Stub {
    public final int a;
    public OnDataChangListener b;
    public final SparseArray c;

    public interface OnDataChangListener {
        void onDataChanged(int i, Bundle bundle);
    }

    public RemoteCallback(int i) {
        this(i, null);
    }

    public void disEnable(int i) {
        if (this.c.indexOfKey(i) < 0 || !((Boolean) this.c.get(i)).booleanValue()) {
            return;
        }
        this.c.put(i, Boolean.FALSE);
    }

    public void enable(int i) {
        if (((Boolean) this.c.get(i, Boolean.FALSE)).booleanValue()) {
            return;
        }
        this.c.put(i, Boolean.TRUE);
    }

    @Override // qin.x_core.aidl.IDataObserver
    public void onDataChanged(Bundle bundle) {
        int i;
        if (this.b != null && (i = bundle.getInt("cmd_id", -1)) >= 0 && ((Boolean) this.c.get(i, Boolean.FALSE)).booleanValue()) {
            this.b.onDataChanged(this.a, bundle);
        }
    }

    public void setListener(OnDataChangListener onDataChangListener) {
        this.b = onDataChangListener;
    }

    public RemoteCallback(int i, OnDataChangListener onDataChangListener) {
        this.c = new SparseArray();
        this.a = i;
        this.b = onDataChangListener;
    }
}
