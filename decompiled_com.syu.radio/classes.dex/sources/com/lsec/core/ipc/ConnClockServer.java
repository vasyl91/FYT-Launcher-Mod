package com.lsec.core.ipc;

import android.content.Context;
import com.lsec.core.util.InterfaceApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ConnClockServer extends Conn_Base {
    public ConnClockServer(InterfaceApp interfaceApp, Context context) {
        super("com.cn.daming.deskclock", "com.syu.app.ToolkitService", interfaceApp, context);
    }
}
