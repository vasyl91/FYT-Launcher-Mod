package qin.x_core.client.java;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import qin.x_core.aidl.IManager;
import qin.x_core.aidl.IModule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class XCoreRemote implements ServiceConnection, IBinder.DeathRecipient, RemoteCallback.OnDataChangListener {
    public final String g;
    public final String h;
    public final String i;
    public final Context j;
    public final OnInitListener k;
    public final SparseArray a = new SparseArray();
    public final ArrayList b = new ArrayList();
    public boolean c = false;
    public IManager d = null;
    public boolean e = false;
    public boolean f = false;
    public final ExecutorService l = Executors.newFixedThreadPool(3);

    public interface OnInitListener {
        void onConnected(String str, Boolean bool);

        void onLicensed(String str, Boolean bool);
    }

    public XCoreRemote(Context context, String str, String str2, String str3, OnInitListener onInitListener) {
        ApplicationInfo applicationInfo = null;
        this.k = null;
        this.j = context;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), STBorder.INT_PALMS_BLACK);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        this.i = (str == null || str.isEmpty()) ? applicationInfo.metaData.getString("xcore_appkey", "") : str;
        this.g = str2 == null ? "qin.x_core" : str2;
        this.h = str3 == null ? "qin.x_core.sdk" : str3;
        this.k = onInitListener;
    }

    public final Proxy a(int i) {
        if (this.a.indexOfKey(i) < 0) {
            try {
                IModule module = this.d.getModule(new XCore.BundleBuilder().putPackage(this.j.getPackageName()).putModule(i).build());
                RemoteCallback remoteCallback = new RemoteCallback(i);
                remoteCallback.setListener(this);
                Proxy proxy = new Proxy(this.j, module, remoteCallback);
                if (module != null) {
                    this.a.put(i, proxy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (Proxy) this.a.get(i, null);
    }

    public void addDataObserver(DataObserver dataObserver) {
        if (this.b.contains(dataObserver)) {
            return;
        }
        this.b.add(dataObserver);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.d.asBinder().unlinkToDeath(this, 0);
        this.d = null;
        this.c = false;
        this.f = false;
        this.a.clear();
        if (this.e) {
            Intent intent = new Intent(this.h);
            intent.setPackage(this.g);
            this.j.bindService(intent, this, 1);
        }
    }

    public void command(int i, int i2, float[] fArr, String[] strArr, byte[] bArr, int[] iArr, ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        Proxy proxyA = a(i);
        if (proxyA != null) {
            proxyA.command(i2, fArr, strArr, bArr, iArr, arrayList, arrayList2);
        }
    }

    public void deinitSdk() {
        this.e = false;
        if (this.c) {
            this.j.unbindService(this);
        }
        this.c = false;
    }

    public void initSdk() {
        this.e = true;
        Intent intent = new Intent(this.h);
        intent.setPackage(this.g);
        this.j.bindService(intent, this, 1);
    }

    public boolean isBound() {
        return this.c;
    }

    public boolean isConnected() {
        return this.d != null;
    }

    public void observe(int i, int... iArr) {
        Proxy proxyA = a(i);
        if (proxyA == null || iArr == null) {
            return;
        }
        for (int i2 : iArr) {
            proxyA.c.enable(i2);
            try {
                Bundle bundleBuild = new XCore.BundleBuilder().putPackage(proxyA.a.getPackageName()).putModule(proxyA.b.id()).putCmdIds(i2).enableAtOnce(true).build();
                Log.e("XCore", "data:" + bundleBuild);
                proxyA.b.register(proxyA.c, bundleBuild);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // qin.x_core.client.java.RemoteCallback.OnDataChangListener
    public void onDataChanged(final int i, final Bundle bundle) {
        this.l.execute(new Runnable() { // from class: qin.x_core.client.java.XCoreRemote.1
            @Override // java.lang.Runnable
            public void run() {
                for (DataObserver dataObserver : XCoreRemote.this.b) {
                    if (dataObserver.isListening(i)) {
                        dataObserver.onReceiver(bundle);
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder != null) {
            this.d = IManager.Stub.asInterface(iBinder);
            try {
                iBinder.linkToDeath(this, 0);
                IManager iManager = this.d;
                this.f = iManager == null ? false : iManager.authorize(this.j.getPackageName(), this.i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        boolean z = this.d != null;
        this.c = z;
        if (z) {
            this.k.onConnected(this.g, Boolean.valueOf(z));
            this.k.onLicensed(this.g, Boolean.valueOf(this.f));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.c = false;
    }

    public void removeDataObserver(DataObserver dataObserver) {
        if (this.b.contains(dataObserver)) {
            this.b.remove(dataObserver);
        }
    }

    public Bundle valueOf(int i, int i2, int... iArr) {
        Proxy proxyA = a(i);
        return proxyA != null ? proxyA.valueOf(i2, Integer.MIN_VALUE, iArr) : new Bundle();
    }
}
