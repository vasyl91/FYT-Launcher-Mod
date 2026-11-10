package com.lsec.core.ipc;

import android.content.Context;
import com.lsec.core.util.InterfaceApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ConnTBoxServer extends Conn_Base {
    public ConnTBoxServer(InterfaceApp interfaceApp, Context context) {
        super("com.syu.TBoxClient", "com.syu.app.ToolkitService", interfaceApp, context);
    }
}
