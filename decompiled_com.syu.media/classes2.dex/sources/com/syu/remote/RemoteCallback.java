package com.syu.remote;

import android.util.SparseArray;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class RemoteCallback extends IModuleCallback.Stub {
    public final int a;
    public final SparseArray b = new SparseArray();
    public MessageListener c;

    public interface MessageListener {
        void onChanged(int i, Message message);
    }

    public RemoteCallback(int i) {
        this.a = i;
    }

    public void disEnable(int i) {
        if (this.b.indexOfKey(i) < 0 || !((Boolean) this.b.get(i)).booleanValue()) {
            return;
        }
        this.b.put(i, Boolean.FALSE);
    }

    public void enable(int i) {
        if (((Boolean) this.b.get(i, Boolean.FALSE)).booleanValue()) {
            return;
        }
        this.b.put(i, Boolean.TRUE);
    }

    public void setMessageListener(MessageListener messageListener) {
        this.c = messageListener;
    }

    public void update(int i, int[] iArr, float[] fArr, String[] strArr) {
        if (((Boolean) this.b.get(i, Boolean.FALSE)).booleanValue()) {
            Message message = new Message(this.a, i, iArr, fArr, strArr);
            MessageListener messageListener = this.c;
            if (messageListener != null) {
                messageListener.onChanged(this.a, message);
            }
        }
    }
}
