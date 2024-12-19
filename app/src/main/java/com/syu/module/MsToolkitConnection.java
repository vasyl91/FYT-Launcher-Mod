package com.syu.module;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class MsToolkitConnection implements ServiceConnection {
    private static final MsToolkitConnection INSTANCE = new MsToolkitConnection();
    static Looper looper;
    private boolean mConnecting;
    private Context mContext;
    private IRemoteToolkit mRemoteToolkit;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private ArrayList<ConnectionObserver> mConnectionObservers = new ArrayList<>();
    private Runnable mRunnableConnect = new Runnable() { // from class: com.syu.module.MsToolkitConnection.1
        @Override // java.lang.Runnable
        public void run() {
            if (MsToolkitConnection.this.mRemoteToolkit != null) {
                MsToolkitConnection.this.mConnecting = false;
                return;
            }
            Intent intent = new Intent("com.syu.ms.toolkit");
            intent.setComponent(new ComponentName("com.syu.ms", "app.ToolkitService"));
            MsToolkitConnection.this.mContext.bindService(intent, MsToolkitConnection.INSTANCE, 1);
            MsToolkitConnection.this.mHandler.postDelayed(this, new Random().nextInt(3000) + 1000);
        }
    };

    static {
        HandlerThread thread = new HandlerThread("ConnectionThread");
        thread.start();
        looper = thread.getLooper();
    }

    public static MsToolkitConnection getInstance() {
        return INSTANCE;
    }

    private MsToolkitConnection() {
    }

    public IRemoteToolkit getRemoteToolkit() {
        return this.mRemoteToolkit;
    }

    public void connect(Context context) {
        connect(context, 0L);
    }

    private synchronized void connect(Context context, long delayMillis) {
        if (!this.mConnecting && this.mRemoteToolkit == null && context != null) {
            this.mContext = context.getApplicationContext();
            this.mConnecting = true;
            this.mHandler.post(this.mRunnableConnect);
        }
    }

    public synchronized void addObserver(ConnectionObserver observer) {
        if (observer != null) {
            if (!this.mConnectionObservers.contains(observer)) {
                this.mConnectionObservers.add(observer);
                if (this.mRemoteToolkit != null) {
                    this.mHandler.post(new OnServiceConnected(this, observer, null));
                }
            }
        }
    }

    public synchronized void removeObserver(ConnectionObserver observer) {
        if (observer != null) {
            this.mConnectionObservers.remove(observer);
        }
        if (this.mRemoteToolkit != null) {
            this.mHandler.post(new OnServiceDisconnected(this, observer, null));
        }
    }

    public synchronized void clearObservers() {
        if (this.mRemoteToolkit != null) {
            Iterator<ConnectionObserver> it = this.mConnectionObservers.iterator();
            while (it.hasNext()) {
                ConnectionObserver observer = it.next();
                this.mHandler.post(new OnServiceDisconnected(this, observer, null));
            }
        }
        this.mConnectionObservers.clear();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName name, IBinder service) {
        this.mRemoteToolkit = IRemoteToolkit.Stub.asInterface(service);
        Iterator<ConnectionObserver> it = this.mConnectionObservers.iterator();
        while (it.hasNext()) {
            ConnectionObserver observer = it.next();
            this.mHandler.post(new OnServiceConnected(this, observer, null));
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName name) {
        this.mRemoteToolkit = null;
        Iterator<ConnectionObserver> it = this.mConnectionObservers.iterator();
        while (it.hasNext()) {
            ConnectionObserver observer = it.next();
            this.mHandler.post(new OnServiceDisconnected(this, observer, null));
        }
        connect(this.mContext, new Random().nextInt(3000) + 1000);
    }

    private class OnServiceConnected implements Runnable {
        private ConnectionObserver observer;

        private OnServiceConnected(ConnectionObserver observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceConnected(MsToolkitConnection msToolkitConnection, ConnectionObserver connectionObserver, OnServiceConnected onServiceConnected) {
            this(connectionObserver);
        }

        @Override // java.lang.Runnable
        public void run() {
            IRemoteToolkit toolkit = MsToolkitConnection.this.mRemoteToolkit;
            if (toolkit != null && this.observer != null) {
                this.observer.onConnected(toolkit);
            }
        }
    }

    private class OnServiceDisconnected implements Runnable {
        private ConnectionObserver observer;

        private OnServiceDisconnected(ConnectionObserver observer) {
            this.observer = observer;
        }

        /* synthetic */ OnServiceDisconnected(MsToolkitConnection msToolkitConnection, ConnectionObserver connectionObserver, OnServiceDisconnected onServiceDisconnected) {
            this(connectionObserver);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.observer != null) {
                this.observer.onDisconnected();
            }
        }
    }
}
