package com.bumptech.glide.load.data;

import java.io.IOException;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface DataRewinder<T> {

    public interface Factory<T> {
        DataRewinder<T> build(T t);

        Class<T> getDataClass();
    }

    void cleanup();

    T rewindAndGet() throws IOException;
}
