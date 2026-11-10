package qin.x_core.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import qin.utils.LooperExecutor;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class RemoteService extends Service {
    protected LooperExecutor mExcuter;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return ModuleManager.manager;
    }

    @Override // android.app.Service
    public void onCreate() {
        this.mExcuter = new LooperExecutor("RemoteService-" + this);
        super.onCreate();
    }
}
