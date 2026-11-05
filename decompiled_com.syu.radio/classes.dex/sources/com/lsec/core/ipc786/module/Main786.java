package com.lsec.core.ipc786.module;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.lsec.core.ipc.Conn_Base;
import com.lsec.core.ipc.IConn;
import com.lsec.core.ipc.module.main.Main;
import com.lsec.core.ipc786.module.cb.Main786_CB;
import com.lsec.core.util.InterfaceApp;
import com.lsec.core.util.IpcUtil;
import com.syu.ipc.ICallback;
import com.syu.ipc.IRegisterCallBack;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Main786 extends IConn {
    public static final String ACTION_MAIN_CONNECT_SERVER = "com.syu.ms.main";
    public static IRegisterCallBack mRegisterCallBack = null;
    public static Main786 hInstance = null;
    private static Runnable_REQEUST REQEUST_APP_ID = null;

    public Main786(InterfaceApp interfaceApp, Context context, IRegisterCallBack registerCallBack) {
        super(interfaceApp, context);
        initAction(ACTION_MAIN_CONNECT_SERVER);
        hInstance = this;
        mRegisterCallBack = registerCallBack;
    }

    @Override // com.lsec.core.ipc.IConn, android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        super.onServiceConnected(name, service);
        ICallback callback = Main786_CB.getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
        } else {
            for (int i = 0; i < 100; i++) {
                switch (i) {
                    case 27:
                    case 41:
                    case 70:
                        registerCallback(callback, i, false);
                        break;
                    default:
                        registerCallback(callback, i, true);
                        break;
                }
            }
        }
        if (IConn.mInterfaceApp != null) {
            IConn.mInterfaceApp.onConnected_Main();
            if (IConn.mInterfaceApp.isAppTop()) {
                IConn.mInterfaceApp.requestAppIdRight();
            }
        }
    }

    public static void cmdStatic(int cmdCode, int[] intData, float[] fltData, String[] strData) {
        if (hInstance != null) {
            hInstance.cmd(cmdCode, intData, fltData, strData);
        }
    }

    public static void requestAppId(int value) {
        Main.sAppIdRequest = value;
        cmdStatic(1, new int[]{value}, null, null);
    }

    public static void requestAppIdByOnTop(int value) {
        if (IConn.mInterfaceApp == null || IConn.mInterfaceApp.isAppTop()) {
            requestAppId(value);
            if (REQEUST_APP_ID != null) {
                REQEUST_APP_ID.stop();
            }
            REQEUST_APP_ID = new Runnable_REQEUST();
            Conn_Base.handler.postDelayed(REQEUST_APP_ID, 300L);
        }
    }

    public static class Runnable_REQEUST implements Runnable {
        public boolean bRunning = true;

        public void stop() {
            this.bRunning = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((IConn.mInterfaceApp == null || IConn.mInterfaceApp.isAppTop()) && Main.DATA[3] != Main.sAppIdRequest) {
                Main786.requestAppId(Main.sAppIdRequest);
                if (this.bRunning) {
                    Conn_Base.handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    public static void update(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            boolean bNoCondition2Handle = false;
            switch (updateCode) {
                case 0:
                case 41:
                    bNoCondition2Handle = true;
                    break;
            }
            if (bNoCondition2Handle || Main.DATA[updateCode] != ints[0]) {
                Main.DATA[updateCode] = ints[0];
                Main.mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }
}
