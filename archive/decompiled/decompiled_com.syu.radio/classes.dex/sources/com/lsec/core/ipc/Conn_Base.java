package com.lsec.core.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.lsec.core.util.InterfaceApp;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;
import java.util.Random;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Conn_Base implements ServiceConnection {
    public static Handler handler;
    static Looper looper;
    public static InterfaceApp mInterfaceApp = null;
    String clsName;
    private boolean mConnecting;
    private Context mContext;
    public Conn_Base mInstance;
    private IRemoteToolkit mRemoteToolkit;
    String pkgName;
    private ArrayList<IConnStateListener> mConnectionObservers = new ArrayList<>();
    private Runnable mRunnableConnect = new Runnable() { // from class: com.lsec.core.ipc.Conn_Base.1
        @Override // java.lang.Runnable
        public void run() {
            if (Conn_Base.this.mRemoteToolkit != null) {
                Conn_Base.this.mConnecting = false;
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(Conn_Base.this.pkgName, Conn_Base.this.clsName);
            Conn_Base.this.mContext.bindService(intent, Conn_Base.this.mInstance, 1);
            Conn_Base.handler.postDelayed(this, new Random().nextInt(3000) + 1000);
        }
    };

    static {
        HandlerThread thread = new HandlerThread("ConnectionThread");
        thread.start();
        looper = thread.getLooper();
        handler = new Handler(looper);
    }

    public Conn_Base(String pkgName, String clsName, InterfaceApp interfaceApp, Context context) {
        this.mInstance = null;
        this.pkgName = pkgName;
        this.clsName = clsName;
        this.mInstance = this;
        if (mInterfaceApp == null) {
            mInterfaceApp = interfaceApp;
        }
        connect(context);
    }

    public IRemoteToolkit getRemoteToolkit() {
        return this.mRemoteToolkit;
    }

    public void connect(Context context) {
        connect(context, 0L);
    }

    private void connect(Context context, long delayMillis) {
        if (!this.mConnecting && this.mRemoteToolkit == null && context != null) {
            this.mContext = context.getApplicationContext();
            this.mConnecting = true;
            handler.post(this.mRunnableConnect);
        }
    }

    public void addObserver(IConnStateListener observer, IRegisterModuleCallBack registerModuleCallBack) {
        if (observer != null && !this.mConnectionObservers.contains(observer)) {
            observer.setRegisterModuleCallBack(registerModuleCallBack);
            this.mConnectionObservers.add(observer);
            if (this.mRemoteToolkit != null) {
                handler.post(new OnServiceConnected(this, observer, null));
            }
        }
    }

    public void removeObserver(IConnStateListener observer) {
        if (observer != null) {
            this.mConnectionObservers.remove(observer);
        }
        if (this.mRemoteToolkit != null) {
            handler.post(new OnServiceDisconnected(this, observer, null));
        }
    }

    public void clearObservers() {
        if (this.mRemoteToolkit != null) {
            for (IConnStateListener observer : this.mConnectionObservers) {
                handler.post(new OnServiceDisconnected(this, observer, null));
            }
        }
        this.mConnectionObservers.clear();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.mRemoteToolkit = IRemoteToolkit.Stub.asInterface(service);
        for (IConnStateListener observer : this.mConnectionObservers) {
            handler.post(new OnServiceConnected(this, observer, null));
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        OnServiceDisconnected onServiceDisconnected = null;
        this.mRemoteToolkit = null;
        for (IConnStateListener observer : this.mConnectionObservers) {
            handler.post(new OnServiceDisconnected(this, observer, onServiceDisconnected));
        }
        connect(this.mContext, new Random().nextInt(3000) + 1000);
    }

    private class OnServiceConnected implements Runnable {
        private IConnStateListener observer;

        private OnServiceConnected(IConnStateListener observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceConnected(Conn_Base conn_Base, IConnStateListener iConnStateListener, OnServiceConnected onServiceConnected) {
            this(iConnStateListener);
        }

        @Override // java.lang.Runnable
        public void run() {
            IRemoteToolkit toolkit = Conn_Base.this.mRemoteToolkit;
            if (toolkit != null && this.observer != null) {
                this.observer.onConnected(toolkit);
            }
        }
    }

    private class OnServiceDisconnected implements Runnable {
        private IConnStateListener observer;

        private OnServiceDisconnected(IConnStateListener observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceDisconnected(Conn_Base conn_Base, IConnStateListener iConnStateListener, OnServiceDisconnected onServiceDisconnected) {
            this(iConnStateListener);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.observer != null) {
                this.observer.onDisconnected();
            }
        }
    }
}
