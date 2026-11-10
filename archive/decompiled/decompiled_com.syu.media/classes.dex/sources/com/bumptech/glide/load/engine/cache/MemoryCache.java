package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(Resource<?> resource);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    Resource<?> put(Key key, Resource<?> resource);

    Resource<?> remove(Key key);

    void setResourceRemovedListener(ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
