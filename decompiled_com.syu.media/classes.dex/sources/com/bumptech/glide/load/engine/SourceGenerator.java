package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";
    private final DataFetcherGenerator.FetcherReadyCallback cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.cb = fetcherReadyCallback;
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public boolean startNext() {
        if (this.dataToCache != null) {
            Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "Failed to properly rewind or write data to cache", e);
                }
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData.get(i);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z = true;
            }
        }
        return z;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() { // from class: com.bumptech.glide.load.engine.SourceGenerator.1
            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void onDataReady(Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData)) {
                    SourceGenerator.this.onDataReadyInternal(loadData, obj);
                }
            }

            @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
            public void onLoadFailed(Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData, exc);
                }
            }
        });
    }

    boolean isCurrentRequest(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        return loadData2 != null && loadData2 == loadData;
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    private boolean cacheData(Object obj) throws Throwable {
        long logTime = LogTime.getLogTime();
        boolean z = false;
        try {
            DataRewinder<T> rewinder = this.helper.getRewinder(obj);
            Object objRewindAndGet = rewinder.rewindAndGet();
            Encoder<X> sourceEncoder = this.helper.getSourceEncoder(objRewindAndGet);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(sourceEncoder, objRewindAndGet, this.helper.getOptions());
            DataCacheKey dataCacheKey = new DataCacheKey(this.loadData.sourceKey, this.helper.getSignature());
            DiskCache diskCache = this.helper.getDiskCache();
            diskCache.put(dataCacheKey, dataCacheWriter);
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Finished encoding source to cache, key: " + dataCacheKey + ", data: " + obj + ", encoder: " + sourceEncoder + ", duration: " + LogTime.getElapsedMillis(logTime));
            }
            if (diskCache.get(dataCacheKey) != null) {
                this.originalKey = dataCacheKey;
                this.sourceCacheGenerator = new DataCacheGenerator(Collections.singletonList(this.loadData.sourceKey), this.helper, this);
                this.loadData.fetcher.cleanup();
                return true;
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Attempt to write: " + this.originalKey + ", data: " + obj + " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly...");
            }
            try {
                this.cb.onDataFetcherReady(this.loadData.sourceKey, rewinder.rewindAndGet(), this.loadData.fetcher, this.loadData.fetcher.getDataSource(), this.loadData.sourceKey);
                return false;
            } catch (Throwable th) {
                th = th;
                z = true;
                if (!z) {
                    this.loadData.fetcher.cleanup();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator
    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.loadData;
        if (loadData != null) {
            loadData.fetcher.cancel();
        }
    }

    void onDataReadyInternal(ModelLoader.LoadData<?> loadData, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj != null && diskCacheStrategy.isDataCacheable(loadData.fetcher.getDataSource())) {
            this.dataToCache = obj;
            this.cb.reschedule();
        } else {
            this.cb.onDataFetcherReady(loadData.sourceKey, obj, loadData.fetcher, loadData.fetcher.getDataSource(), this.originalKey);
        }
    }

    void onLoadFailedInternal(ModelLoader.LoadData<?> loadData, Exception exc) {
        this.cb.onDataFetcherFailed(this.originalKey, exc, loadData.fetcher, loadData.fetcher.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }
}
