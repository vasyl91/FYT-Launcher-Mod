package com.bumptech.glide.manager;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
final class FirstFrameAndAfterTrimMemoryWaiter implements FrameWaiter, ComponentCallbacks2 {
    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    @Override // com.bumptech.glide.manager.FrameWaiter
    public void registerSelf(Activity activity) {
    }

    FirstFrameAndAfterTrimMemoryWaiter() {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(20);
    }
}
