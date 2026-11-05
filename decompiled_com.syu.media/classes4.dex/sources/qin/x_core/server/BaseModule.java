package qin.x_core.server;

import android.os.Bundle;
import qin.utils.LooperExecutor;
import qin.x_core.aidl.IDataObserver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public abstract class BaseModule extends Module {
    public final LooperExecutor b;
    public final RemoteObserverList c;

    public BaseModule(int i, LooperExecutor looperExecutor) {
        super(i);
        this.b = null;
        this.c = new RemoteObserverList();
        this.b = looperExecutor;
    }

    @Override // qin.x_core.aidl.IModule
    public void command(Bundle bundle) {
        onHandle(bundle);
    }

    public void onDataUpdate(final Bundle bundle) {
        this.b.execute(new Runnable() { // from class: qin.x_core.server.BaseModule.1
            @Override // java.lang.Runnable
            public void run() {
                BaseModule.this.c.update(bundle);
            }
        });
    }

    public abstract void onHandle(Bundle bundle);

    public abstract void onRegister(IDataObserver iDataObserver, int i);

    @Override // qin.x_core.aidl.IModule
    public void register(IDataObserver iDataObserver, Bundle bundle) {
        if (iDataObserver == null || bundle == null) {
            return;
        }
        synchronized (this.c) {
            int i = bundle.getInt("cmd_id", Integer.MIN_VALUE);
            int[] intArray = bundle.getIntArray("cmd_ids");
            int i2 = bundle.getInt("atonce", 0);
            if (i != Integer.MIN_VALUE) {
                this.c.register(iDataObserver, i);
                if (i2 == 1) {
                    onRegister(iDataObserver, i);
                }
            }
            if (intArray != null && intArray.length > 0) {
                for (int i3 = 0; i3 < intArray.length; i3++) {
                    this.c.register(iDataObserver, intArray[i3]);
                    if (i2 == 1) {
                        onRegister(iDataObserver, intArray[i3]);
                    }
                }
            }
        }
    }

    @Override // qin.x_core.aidl.IModule
    public void unregister(IDataObserver iDataObserver, Bundle bundle) {
        if (iDataObserver == null || bundle == null) {
            return;
        }
        synchronized (this.c) {
            int i = bundle.getInt("cmd_id", Integer.MIN_VALUE);
            int[] intArray = bundle.getIntArray("cmd_ids");
            if (i != Integer.MIN_VALUE) {
                this.c.unregister(iDataObserver, i);
            }
            if (intArray != null && intArray.length > 0) {
                for (int i2 : intArray) {
                    this.c.unregister(iDataObserver, i2);
                }
            }
        }
    }
}
