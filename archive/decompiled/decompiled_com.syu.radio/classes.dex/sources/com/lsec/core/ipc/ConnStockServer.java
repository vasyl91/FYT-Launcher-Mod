package com.lsec.core.ipc;

import android.content.Context;
import com.lsec.core.util.InterfaceApp;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ConnStockServer extends Conn_Base {
    public ConnStockServer(InterfaceApp interfaceApp, Context context) {
        super("com.syu.stock", "com.syu.app.ToolkitService", interfaceApp, context);
    }
}
