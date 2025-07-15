package com.syu.remote;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;

import com.syu.ipc.IRemoteModule;
import com.syu.ipc.IRemoteToolkit;

import java.net.HttpURLConnection;
import java.util.Random;

public class RemoteTools implements ServiceConnection {
    final int CONN_DELAY_TIME_MAX;
    final int CONN_DELAY_TIME_MIN;
    String action;
    boolean autoConn;
    Context mContext;
    Handler mHandler;
    SparseArray<Registrar> mModules;
    IRemoteToolkit mToolkit;
    String pkgName;
    HandlerThread workThread;

    public RemoteTools(Context context, String action, String pkgName) {
        this.CONN_DELAY_TIME_MAX = 1500;
        this.CONN_DELAY_TIME_MIN = HttpURLConnection.HTTP_INTERNAL_ERROR;
        this.mModules = new SparseArray<>();
        this.workThread = new HandlerThread("remote connection");
        this.autoConn = true;
        this.mContext = context.getApplicationContext();
        this.workThread.start();
        this.mHandler = new Handler(this.workThread.getLooper());
        this.action = action;
        this.pkgName = pkgName;
    }

    public RemoteTools(Context context) {
        this(context, null, null);
    }

    public void bind() {
        this.autoConn = true;
        if (this.action == null || this.action.isEmpty()) {
            this.action = "com.syu.ms.toolkit";
        }
        if (this.pkgName == null || this.pkgName.isEmpty()) {
            this.pkgName = "com.syu.ms";
        }
        Intent intent = new Intent(this.action);
        intent.setPackage(this.pkgName);
        this.mContext.bindService(intent, this, 1);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                if (RemoteTools.this.autoConn && RemoteTools.this.mToolkit == null) {
                    RemoteTools.this.bind();
                }
                handler.removeCallbacks(this);
            }
        }, new Random().nextInt(1500) + HttpURLConnection.HTTP_INTERNAL_ERROR);
    }

    public void unBind() {
        this.autoConn = false;
        if (this.mContext != null) {
            this.mContext.unbindService(this);
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        if (service != null) {
            this.mToolkit = IRemoteToolkit.Stub.asInterface(service);
            if (this.mToolkit != null && this.mModules.size() > 0) {
                for (int i = 0; i < this.mModules.size(); i++) {
                    final int module = this.mModules.keyAt(i);
                    this.mHandler.post(new Runnable() { 
                        @Override
                        public void run() {
                            Registrar registrar;
                            if (RemoteTools.this.mToolkit != null) {
                                try {
                                    IRemoteModule sModule = RemoteTools.this.mToolkit.getRemoteModule(module);
                                    if (sModule != null && (registrar = RemoteTools.this.mModules.get(module)) != null) {
                                        registrar.setModule(sModule);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        if (this.autoConn) {
            this.mToolkit = null;
            bind();
        } else if (this.mToolkit != null) {
            if (this.mModules.size() > 0) {
                this.mHandler.post(new Runnable() { 
                    @Override
                    public void run() {
                        for (int i = 0; i < RemoteTools.this.mModules.size(); i++) {
                            int key = RemoteTools.this.mModules.keyAt(i);
                            Registrar registrar = RemoteTools.this.mModules.get(key);
                            if (registrar != null) {
                                registrar.unRegisterCode();
                            }
                        }
                    }
                });
            }
            this.mToolkit = null;
        }
    }

    public boolean connected() {
        return this.mToolkit != null;
    }

    public void notify(int module, final int... codes) {
        if (codes != null) {
            final Registrar registrar = this.mModules.get(module);
            this.mHandler.post(new Runnable() { 
                @Override
                public void run() {
                    if (registrar != null) {
                        for (int code : codes) {
                            registrar.notify(code);
                        }
                    }
                }
            });
        }
    }

    public void enableModule(int module, final int... codes) {
        this.mModules.put(module, new Registrar() { 
            @Override
            public void registerCallback() {
                if (codes != null) {
                    registerCode(codes);
                }
            }
        });
    }

    public void addRefreshLisenter(int module, Callback.OnRefreshLisenter lisenter, int... codes) {
        Registrar sModule = this.mModules.get(module);
        if (sModule != null) {
            sModule.addOnRefreshLisenter(lisenter, codes);
        }
    }

    public void removeRefreshLisenter(int module, Callback.OnRefreshLisenter lisenter) {
        Registrar sModule = this.mModules.get(module);
        if (sModule != null) {
            sModule.removeOnRefreshLisenter(lisenter);
        }
    }

    public void sendInt(int module, int code, int... params) {
        Registrar sModule = this.mModules.get(module);
        if (sModule != null) {
            try {
                IRemoteModule sIRemoteModule = sModule.getModule();
                if (sIRemoteModule != null) {
                    sIRemoteModule.cmd(code, params, null, null);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendStr(int module, int code, String... params) {
        Registrar sModule = this.mModules.get(module);
        if (sModule != null) {
            try {
                IRemoteModule sIRemoteModule = sModule.getModule();
                if (sIRemoteModule != null) {
                    sIRemoteModule.cmd(code, null, null, params);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendFlt(int module, int code, float... params) {
        Registrar sModule = this.mModules.get(module);
        if (sModule != null) {
            try {
                IRemoteModule sIRemoteModule = sModule.getModule();
                if (sIRemoteModule != null) {
                    sIRemoteModule.cmd(code, null, params, null);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public int getInt(int module, int def, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getInt(def, code, params) : def;
    }

    public float getFlt(int module, float def, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getFlt(def, code, params) : def;
    }

    public String getStr(int module, String def, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getStr(def, code, params) : def;
    }

    public int[] getInts(int module, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getInts(code, params) : new int[1];
    }

    public float[] getFlts(int module, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getFlts(code, params) : new float[1];
    }

    public String[] getStrs(int module, int code, int params) {
        Registrar sModule = this.mModules.get(module);
        return sModule != null ? sModule.getStrs(code, params) : new String[1];
    }
}
