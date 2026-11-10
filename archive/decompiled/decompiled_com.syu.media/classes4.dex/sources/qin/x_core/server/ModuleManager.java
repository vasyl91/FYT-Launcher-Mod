package qin.x_core.server;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.HashMap;
import qin.x_core.aidl.IManager;
import qin.x_core.aidl.IModule;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public class ModuleManager extends IManager.Stub {
    public static ModuleManager manager = new ModuleManager();
    public final HashMap a = new HashMap();
    public final SparseArray b = new SparseArray();
    public final Object c = new Object();

    public void addModule(BaseModule baseModule) {
        synchronized (this.c) {
            if (this.b.indexOfKey(baseModule.a) < 0) {
                this.b.put(baseModule.a, baseModule);
            }
        }
    }

    @Override // qin.x_core.aidl.IManager
    public boolean authorize(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        if (this.a.containsKey(str)) {
            return ((Boolean) this.a.getOrDefault(str, Boolean.FALSE)).booleanValue();
        }
        this.a.put(str, Boolean.TRUE);
        return true;
    }

    @Override // qin.x_core.aidl.IManager
    public IModule getModule(Bundle bundle) {
        if (bundle != null) {
            int i = bundle.getInt("module_id");
            if (bundle.getString("package") != null && this.b.indexOfKey(i) >= 0) {
                return (BaseModule) this.b.get(i, null);
            }
        }
        return null;
    }

    public void removeModule(BaseModule baseModule) {
        synchronized (this.c) {
            int iIndexOfValue = this.b.indexOfValue(baseModule);
            if (iIndexOfValue >= 0) {
                this.b.remove(iIndexOfValue);
            }
        }
    }
}
