package qin.x_core.client.java;

import android.os.Bundle;
import java.util.BitSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes4.dex */
public abstract class DataObserver {
    public final BitSet a = new BitSet();

    public static abstract class ModuleObserver extends DataObserver {
        protected int module;
        protected XCore xCore;

        public ModuleObserver(XCore xCore, int i, int... iArr) {
            super(i);
            this.module = i;
            this.xCore = xCore;
            xCore.addObserver(this);
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            xCore.observeModule(i, iArr);
        }
    }

    public DataObserver(int... iArr) {
        if (iArr.length > 0) {
            for (int i : iArr) {
                addModule(i);
            }
        }
    }

    public void addModule(int i) {
        this.a.set(i);
    }

    public boolean isListening(int i) {
        return this.a.get(i);
    }

    public abstract void onReceiver(Bundle bundle);

    public void removeModule(int i) {
        this.a.clear(i);
    }
}
