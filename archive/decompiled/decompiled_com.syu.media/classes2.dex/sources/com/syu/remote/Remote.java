package com.syu.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.syu.ipc.IRemoteModule;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import module.main.FinalMain;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class Remote implements ServiceConnection, IBinder.DeathRecipient, RemoteCallback.MessageListener {
    public static final HashMap l = new HashMap();
    public IRemoteToolkit c;
    public final Context d;
    public final Handler e;
    public final String g;
    public final String h;
    public final ArrayList j;
    public final ExecutorService k;
    public final SparseArray a = new SparseArray();
    public final SparseArray b = new SparseArray();
    public boolean f = true;
    public final ArrayList i = new ArrayList();

    public class Command {
        public final int a;
        public final int b;
        public final int[] c;
        public final float[] d;
        public final String[] e;

        public Command(Remote remote, int i, int i2, int[] iArr, float[] fArr, String[] strArr) {
            this.a = i;
            this.b = i2;
            this.c = iArr;
            this.d = fArr;
            this.e = strArr;
        }
    }

    public class Module {
        public final IRemoteModule a;
        public final RemoteCallback b;

        public Module(Remote remote, IRemoteModule iRemoteModule, RemoteCallback remoteCallback) {
            this.a = iRemoteModule;
            this.b = remoteCallback;
        }

        public final void a() {
            SparseArray sparseArrayClone = this.b.b.clone();
            int size = sparseArrayClone.size();
            for (int i = 0; i < size; i++) {
                try {
                    this.a.register(this.b, sparseArrayClone.keyAt(i), ((Boolean) sparseArrayClone.valueAt(i)).booleanValue() ? 1 : 0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface OnConnectionListener {
        void onConnected(String str, boolean z);
    }

    public Remote(Context context, OnConnectionListener onConnectionListener, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        this.j = arrayList;
        this.k = Executors.newFixedThreadPool(2);
        this.d = context;
        this.g = str;
        this.h = str2;
        HandlerThread handlerThread = new HandlerThread("remote connection");
        handlerThread.start();
        this.e = new Handler(handlerThread.getLooper());
        arrayList.add(onConnectionListener);
        a();
    }

    public static Remote getAutoTools(Context context, OnConnectionListener onConnectionListener) {
        return getAutoTools(context, onConnectionListener, "com.syu.ms.toolkit", FinalMain.BROADCAST_MS_ACTION);
    }

    public final void a() {
        Intent intent = new Intent(this.g);
        this.f = true;
        intent.setPackage(this.h);
        Log.e("Remote", "intent: " + intent.toString() + " action: " + this.g + " pkg: " + this.h);
        this.d.bindService(intent, this, 1);
        this.e.postDelayed(new Runnable() { // from class: com.syu.remote.Remote.1
            @Override // java.lang.Runnable
            public void run() {
                Remote remote = Remote.this;
                if (remote.f && remote.c == null) {
                    remote.a();
                }
                Remote.this.e.removeCallbacks(this);
            }
        }, new Random().nextInt(1500) + 500);
    }

    public void addMessageObserver(MessageObserver messageObserver) {
        if (this.i.contains(messageObserver)) {
            return;
        }
        this.i.add(messageObserver);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        IRemoteToolkit iRemoteToolkit = this.c;
        if (iRemoteToolkit != null) {
            iRemoteToolkit.asBinder().unlinkToDeath(this, 0);
        }
        this.a.clear();
        this.c = null;
        if (this.f) {
            a();
        }
    }

    public boolean command(int i, int i2, int... iArr) {
        return handCommand(new Command(this, i, i2, iArr, null, null));
    }

    public void disobserve(int i, int... iArr) {
        Module module2 = (Module) this.a.get(i, null);
        if (module2 == null || iArr == null) {
            return;
        }
        for (int i2 : iArr) {
            module2.b.disEnable(i2);
        }
    }

    public boolean handCommand(final Command command) {
        if (!isConnected()) {
            return false;
        }
        this.k.submit(new Runnable() { // from class: com.syu.remote.Remote.2
            @Override // java.lang.Runnable
            public void run() {
                Remote remote = Remote.this;
                Module module2 = (Module) remote.a.get(command.a, null);
                if (module2 != null) {
                    Command command2 = command;
                    try {
                        module2.a.cmd(command2.b, command2.c, command2.d, command2.e);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return isConnected();
    }

    public boolean isConnected() {
        return this.c != null;
    }

    public void observe(int i, int... iArr) {
        Module module2 = (Module) this.a.get(i, null);
        if (module2 == null || iArr == null) {
            return;
        }
        for (int i2 : iArr) {
            module2.b.enable(i2);
            try {
                module2.a.register(module2.b, i2, 1);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.syu.remote.RemoteCallback.MessageListener
    public void onChanged(int i, Message message) {
        for (MessageObserver messageObserver : this.i) {
            if (messageObserver.isListening(i)) {
                messageObserver.onReceiver(message);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        IRemoteModule remoteModule;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this, 0);
            } catch (RemoteException unused) {
            }
            IRemoteToolkit iRemoteToolkitAsInterface = IRemoteToolkit.Stub.asInterface(iBinder);
            this.c = iRemoteToolkitAsInterface;
            if (iRemoteToolkitAsInterface == null) {
                return;
            }
            for (int i = 0; i < 20; i++) {
                try {
                    remoteModule = this.c.getRemoteModule(i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    remoteModule = null;
                }
                if (remoteModule != null) {
                    RemoteCallback remoteCallback = (RemoteCallback) this.b.get(i, new RemoteCallback(i));
                    remoteCallback.setMessageListener(this);
                    Module module2 = new Module(this, remoteModule, remoteCallback);
                    this.a.put(i, module2);
                    module2.a();
                }
            }
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                ((OnConnectionListener) it.next()).onConnected(this.h, true);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.c = null;
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            ((OnConnectionListener) it.next()).onConnected(this.h, false);
        }
    }

    public void removeMessageObserver(MessageObserver messageObserver) {
        if (this.i.contains(messageObserver)) {
            this.i.remove(messageObserver);
        }
    }

    public static Remote getAutoTools(Context context, OnConnectionListener onConnectionListener, String str, String str2) {
        String str3 = str2 + "#" + str;
        HashMap map = l;
        if (map.containsKey(str3)) {
            return (Remote) map.get(str3);
        }
        Remote remote = new Remote(context, onConnectionListener, str, str2);
        map.put(str3, remote);
        return remote;
    }

    public boolean command(int i, int i2, int[] iArr, float[] fArr, String[] strArr) {
        return handCommand(new Command(this, i, i2, iArr, fArr, strArr));
    }
}
