package com.syu.remote;

import java.util.BitSet;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public abstract class MessageObserver {
    public final BitSet a = new BitSet();

    public static abstract class ModuleObserver extends MessageObserver {
        protected ModuleManager manager;

        /* JADX INFO: renamed from: module, reason: collision with root package name */
        protected int f5module;

        public ModuleObserver(ModuleManager moduleManager, int i, int... iArr) {
            super(i);
            this.f5module = i;
            this.manager = moduleManager;
            moduleManager.addObserver(this);
            if (iArr == null || iArr.length <= 0) {
                return;
            }
            moduleManager.observeModule(i, iArr);
        }
    }

    public MessageObserver(int... iArr) {
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

    public abstract void onReceiver(Message message);

    public void removeModule(int i) {
        this.a.clear(i);
    }
}
