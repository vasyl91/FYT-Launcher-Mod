package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
interface DataFetcherGenerator {

    public interface FetcherReadyCallback {
        void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource);

        void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2);

        void reschedule();
    }

    void cancel();

    boolean startNext();
}
