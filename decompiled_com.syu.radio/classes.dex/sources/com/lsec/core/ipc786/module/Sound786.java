package com.lsec.core.ipc786.module;

import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import com.lsec.core.ipc.IConn;
import com.lsec.core.ipc786.module.cb.Sound786_CB;
import com.lsec.core.util.InterfaceApp;
import com.syu.ipc.ICallback;
import com.syu.ipc.IRegisterCallBack;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Sound786 extends IConn {
    public static final String ACTION_SOUND_CONNECT_SERVER = "com.syu.ms.sound";
    public static IRegisterCallBack mRegisterCallBack = null;
    public static Sound786 hInstance = null;

    public Sound786(InterfaceApp interfaceApp, Context context, IRegisterCallBack registerCallBack) {
        super(interfaceApp, context);
        initAction(ACTION_SOUND_CONNECT_SERVER);
        hInstance = this;
        mRegisterCallBack = registerCallBack;
    }

    @Override // com.lsec.core.ipc.IConn, android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        super.onServiceConnected(name, service);
        ICallback callback = Sound786_CB.getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
        } else {
            registerCallback(Sound786_CB.getInstance(), 3, true);
            registerCallback(Sound786_CB.getInstance(), 4, true);
        }
    }
}
