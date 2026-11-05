package com.syu.remote;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.syu.utils.Utils;
import module.main.FinalMain;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class ModuleManager implements Remote.OnConnectionListener {
    public final String a;
    public final SparseArray b;
    public Handler mHandler;
    public Remote remote;

    public ModuleManager(Context context) {
        this(context, null, null);
    }

    public boolean addObserver(MessageObserver messageObserver) {
        this.remote.addMessageObserver(messageObserver);
        return isConnected();
    }

    public boolean isConnected() {
        Remote remote = this.remote;
        if (remote == null) {
            return false;
        }
        return remote.isConnected();
    }

    public boolean observeModule(int i, int... iArr) {
        this.b.put(i, iArr);
        boolean zIsConnected = isConnected();
        if (zIsConnected) {
            this.remote.observe(i, iArr);
        }
        return zIsConnected;
    }

    @Override // com.syu.remote.Remote.OnConnectionListener
    public void onConnected(String str, boolean z) {
        if (Utils.equals(str, this.a) && z && this.b.size() > 0) {
            for (int i = 0; i < this.b.size(); i++) {
                int iKeyAt = this.b.keyAt(i);
                int[] iArr = (int[]) this.b.get(iKeyAt, null);
                if (iArr != null) {
                    this.remote.observe(iKeyAt, iArr);
                }
            }
        }
    }

    public boolean removeObserver(MessageObserver messageObserver) {
        this.remote.removeMessageObserver(messageObserver);
        return isConnected();
    }

    public ModuleManager(Context context, String str, String str2) {
        this.a = null;
        this.b = new SparseArray();
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread("ModuleManager_thread");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper());
        this.a = Utils.isEmptyStr(str) ? FinalMain.BROADCAST_MS_ACTION : str;
        this.remote = (Utils.isEmptyStr(str) || Utils.isEmptyStr(str2)) ? Remote.getAutoTools(context, this) : Remote.getAutoTools(context, this, str2, str);
    }
}
