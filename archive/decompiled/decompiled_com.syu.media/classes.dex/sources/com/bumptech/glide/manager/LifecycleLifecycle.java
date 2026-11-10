package com.bumptech.glide.manager;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class LifecycleLifecycle implements Lifecycle, LifecycleObserver {
    private final androidx.lifecycle.Lifecycle lifecycle;
    private final Set<LifecycleListener> lifecycleListeners = new HashSet();

    LifecycleLifecycle(androidx.lifecycle.Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START)
    public void onStart(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP)
    public void onStop(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    @OnLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY)
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        Iterator it = Util.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.add(lifecycleListener);
        if (this.lifecycle.getCurrentState() == androidx.lifecycle.Lifecycle.State.DESTROYED) {
            lifecycleListener.onDestroy();
        } else if (this.lifecycle.getCurrentState().isAtLeast(androidx.lifecycle.Lifecycle.State.STARTED)) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(LifecycleListener lifecycleListener) {
        this.lifecycleListeners.remove(lifecycleListener);
    }
}
