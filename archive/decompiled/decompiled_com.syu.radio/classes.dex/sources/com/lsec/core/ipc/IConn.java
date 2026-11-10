package com.lsec.core.ipc;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import com.lsec.core.util.InterfaceApp;
import com.syu.ipc.ICallback;
import com.syu.ipc.IRemote;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class IConn implements ServiceConnection {
    private static final int MSG_CONNECT = 0;
    public static Handler mHandlerCmd;
    public static HandlerThread mHandlerThreadCmd;
    public static InterfaceApp mInterfaceApp;
    private Context mContext;
    private Intent mIntent;
    protected IRemote mRemoteModule;

    @SuppressLint({"HandlerLeak"})
    private Handler mHandler = new Handler() { // from class: com.lsec.core.ipc.IConn.1
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    removeMessages(0);
                    if (IConn.this.mRemoteModule == null) {
                        IConn.this.mContext.bindService(IConn.this.mIntent, IConn.this.mConn, 1);
                        sendEmptyMessageDelayed(0, 1000L);
                    }
                    break;
            }
        }
    };
    private IConn mConn = this;

    static {
        mHandlerThreadCmd = null;
        mHandlerCmd = null;
        mHandlerThreadCmd = new HandlerThread("IConn-CMD-Thread");
        mHandlerThreadCmd.start();
        mHandlerCmd = new Handler(mHandlerThreadCmd.getLooper());
    }

    public IConn(InterfaceApp interfaceApp, Context context) {
        if (mInterfaceApp == null) {
            mInterfaceApp = interfaceApp;
        }
        connect(context);
    }

    public void initAction(String action) {
        this.mIntent = new Intent(action);
    }

    public void connect(Context context) {
        this.mHandler.sendEmptyMessage(0);
        this.mContext = context.getApplicationContext();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.mRemoteModule = IRemote.Stub.asInterface(service);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        this.mRemoteModule = null;
        connect(this.mContext);
    }

    public void cmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
        if (mHandlerCmd != null) {
            mHandlerCmd.post(new Runnable_Cmd(cmdCode, ints, flts, strs));
        }
    }

    public class Runnable_Cmd implements Runnable {
        int cmdCode;
        float[] flts;
        int[] ints;
        String[] strs;

        public Runnable_Cmd(int cmdCode, int[] ints, float[] flts, String[] strs) {
            this.cmdCode = cmdCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (IConn.this.mRemoteModule != null) {
                    IConn.this.mRemoteModule.cmd(this.cmdCode, this.ints, this.flts, this.strs);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getI(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getI(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public float getF(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getF(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0.0f;
    }

    public String getS(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getS(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int[] getAI(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getAI(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public float[] getAF(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getAF(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String[] getAS(int getCode, int[] ints, float[] flts, String[] strs) {
        if (this.mRemoteModule != null) {
            try {
                return this.mRemoteModule.getAS(getCode, ints, flts, strs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void registerCallback(ICallback cb, int updateCode, boolean cbNow) {
        if (this.mRemoteModule != null) {
            try {
                this.mRemoteModule.registerCallback(cb, updateCode, cbNow);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void unregisterCallback(ICallback cb, int updateCode) {
        if (this.mRemoteModule != null) {
            try {
                this.mRemoteModule.unregisterCallback(cb, updateCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
