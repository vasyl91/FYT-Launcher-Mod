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

import java.util.HashMap;
import java.util.Random;

import org.apache.http.HttpStatus;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Remote implements ServiceConnection {
    static final HashMap<String, Remote> mTools = new HashMap<>();
    final int CONN_DELAY_TIME_MAX;
    final int CONN_DELAY_TIME_MIN;
    String action;
    boolean autoConn;
    Looper looper;
    Context mContext;
    Handler mHandler;
    SparseArray<Module> mModules;
    IRemoteToolkit mToolkit;
    String pkgName;

    public static Remote getAutoTools(Context mContext) {
        return getAutoTools(mContext, "com.syu.ms.toolkit", "com.syu.ms");
    }

    public static Remote getAutoTools(Context mContext, String action, String pkgName) {
        String key = pkgName + "#" + action;
        if (mTools.containsKey(key)) {
            return mTools.get(key);
        }
        Remote tool = new Remote(mContext, action, pkgName);
        mTools.put(key, tool);
        return tool;
    }

    Remote(Context mContext) {
        this(mContext, "com.syu.ms.toolkit", "com.syu.ms");
    }

    Remote(Context mContext, String action, String pkgName) {
        this.CONN_DELAY_TIME_MAX = 1500;
        this.CONN_DELAY_TIME_MIN = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        this.mModules = new SparseArray<>();
        this.autoConn = true;
        EventBus.getDefault().register(this);
        this.mContext = mContext;
        this.action = action;
        this.pkgName = pkgName;
        HandlerThread workThread = new HandlerThread("remote connection");
        workThread.start();
        this.looper = workThread.getLooper();
        this.mHandler = new Handler(this.looper);
        bind();
    }

    void bind() {
        Intent intent = new Intent(this.action);
        this.autoConn = true;
        intent.setPackage(this.pkgName);
        this.mContext.bindService(intent, this, 1);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { 
            @Override
            public void run() {
                if (Remote.this.autoConn && Remote.this.mToolkit == null) {
                    Remote.this.bind();
                }
                handler.removeCallbacks(this);
            }
        }, new Random().nextInt(1500) + HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    void unbind() {
        this.autoConn = false;
        if (this.mContext != null) {
            this.mContext.unbindService(this);
        }
    }

    Module module(int moduleid) {
        return this.mModules.get(moduleid, null);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        if (service != null) {
            this.mToolkit = IRemoteToolkit.Stub.asInterface(service);
            if (this.mToolkit != null) {
                for (int moduleid = 0; moduleid < 20; moduleid++) {
                    IRemoteModule imodule = null;
                    try {
                        imodule = this.mToolkit.getRemoteModule(moduleid);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    if (imodule != null) {
                        Module module = new Module(imodule, new RemoteCallback(moduleid));
                        this.mModules.put(moduleid, module);
                        module.register();
                    }
                }
                EventBus.getDefault().post(new ConnEvent("conn", true));
            }
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        this.mToolkit = null;
        if (this.autoConn) {
            bind();
        } else {
            EventBus.getDefault().post(new ConnEvent("conn", false));
        }
    }

    public void observe(int module, int... codes) {
        Module tool = module(module);
        if (tool != null) {
            tool.observe(codes);
        }
    }

    public void disobserve(int module, int... codes) {
        Module tool = module(module);
        if (tool != null) {
            tool.disobserve(codes);
        }
    }

    public void command(int module, int cmdid, int[] ints, float[] flts, String[] strs) {
        EventBus.getDefault().post(new Command(module, cmdid, ints, flts, strs));
    }

    public void commad(int module, int cmdid, int... params) {
        EventBus.getDefault().post(new Command(module, cmdid, params, null, null));
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void handCommand(Command command) {
        Module tool = module(command.module);
        if (tool != null) {
            tool.command(command.cmdid, command.ints, command.flts, command.strs);
        }
    }

    public boolean isConnected() {
        return this.mToolkit != null;
    }

    class Command {
        int cmdid;
        float[] flts;
        int[] ints;
        int module;
        String[] strs;

        public Command(int module, int cmdid, int[] ints, float[] flts, String[] strs) {
            this.module = module;
            this.cmdid = cmdid;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }
    }

    class Module {
        RemoteCallback callback;
        IRemoteModule module;

        public Module(IRemoteModule module, RemoteCallback callback) {
            this.module = module;
            this.callback = callback;
        }

        void register() {
            SparseArray<Boolean> maps = this.callback.notifies.clone();
            int size = maps.size();
            for (int index = 0; index < size; index++) {
                int code = maps.keyAt(index);
                boolean notify = maps.valueAt(index).booleanValue();
                try {
                    this.module.register(this.callback, code, notify ? 1 : 0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        void unregister() {
            SparseArray<Boolean> maps = this.callback.notifies.clone();
            int size = maps.size();
            for (int index = 0; index < size; index++) {
                int code = maps.keyAt(index);
                try {
                    this.module.unregister(this.callback, code);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        void observe(int... codes) {
            if (codes != null) {
                for (int code : codes) {
                    this.callback.enable(code);
                    try {
                        this.module.register(this.callback, code, 1);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        void disobserve(int... codes) {
            if (codes != null) {
                for (int code : codes) {
                    this.callback.disEnable(code);
                }
            }
        }

        void command(int cmdid, int[] ints, float[] flts, String[] strs) {
            try {
                this.module.cmd(cmdid, ints, flts, strs);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        void commad(int cmdid, int... params) {
            command(cmdid, params, null, null);
        }
    }
}
