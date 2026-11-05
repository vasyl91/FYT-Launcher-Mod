package com.lsec.core.ipc;

import android.content.Context;
import com.lsec.core.util.InterfaceApp;
import com.lsec.core.util.data.FinalMain;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Conn extends Conn_Base {
    public Conn(InterfaceApp interfaceApp, Context context) {
        super(FinalMain.BROADCAST_MS_ACTION, "app.ToolkitService", interfaceApp, context);
    }
}
