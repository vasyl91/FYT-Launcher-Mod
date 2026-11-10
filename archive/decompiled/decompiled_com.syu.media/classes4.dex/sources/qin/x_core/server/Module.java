package qin.x_core.server;

import android.os.Bundle;
import qin.x_core.aidl.IModule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public abstract class Module extends IModule.Stub {
    public final int a;

    public Module(int i) {
        this.a = i;
    }

    @Override // qin.x_core.aidl.IModule
    public int id() {
        return this.a;
    }

    @Override // qin.x_core.aidl.IModule
    public Bundle valueOf(Bundle bundle) {
        return new Bundle();
    }
}
