package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(T t);

        void onLoadFailed(Exception exc);
    }

    void cancel();

    void cleanup();

    Class<T> getDataClass();

    DataSource getDataSource();

    void loadData(Priority priority, DataCallback<? super T> dataCallback);
}
