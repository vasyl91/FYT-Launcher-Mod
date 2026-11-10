package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import chip.FinalChip;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.GlideTrace;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    private Key currentSourceKey;
    private Thread currentThread;
    private final DiskCacheProvider diskCacheProvider;
    private DiskCacheStrategy diskCacheStrategy;
    private GlideContext glideContext;
    private int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private boolean isLoadingFromAlternateCacheKey;
    private EngineKey loadKey;
    private Object model;
    private boolean onlyRetrieveFromCache;
    private Options options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private RunReason runReason;
    private Key signature;
    private Stage stage;
    private long startFetchTime;
    private int width;
    private final DecodeHelper<R> decodeHelper = new DecodeHelper<>();
    private final List<Throwable> throwables = new ArrayList();
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private final DeferredEncodeManager<?> deferredEncodeManager = new DeferredEncodeManager<>();
    private final ReleaseManager releaseManager = new ReleaseManager();

    interface Callback<R> {
        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource, boolean z);

        void reschedule(DecodeJob<?> decodeJob);
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider, Pools.Pool<DecodeJob<?>> pool) {
        this.diskCacheProvider = diskCacheProvider;
        this.pool = pool;
    }

    DecodeJob<R> init(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, Callback<R> callback, int i3) {
        this.decodeHelper.init(glideContext, obj, key, i, i2, diskCacheStrategy, cls, cls2, priority, options, map, z, z2, this.diskCacheProvider);
        this.glideContext = glideContext;
        this.signature = key;
        this.priority = priority;
        this.loadKey = engineKey;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy;
        this.onlyRetrieveFromCache = z3;
        this.options = options;
        this.callback = callback;
        this.order = i3;
        this.runReason = RunReason.INITIALIZE;
        this.model = obj;
        return this;
    }

    boolean willDecodeFromCache() {
        Stage nextStage = getNextStage(Stage.INITIALIZE);
        return nextStage == Stage.RESOURCE_CACHE || nextStage == Stage.DATA_CACHE;
    }

    void release(boolean z) {
        if (this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0L;
        this.isCancelled = false;
        this.model = null;
        this.throwables.clear();
        this.pool.release(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(DecodeJob<?> decodeJob) {
        int priority = getPriority() - decodeJob.getPriority();
        return priority == 0 ? this.order - decodeJob.order : priority;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        GlideTrace.beginSectionFormat("DecodeJob#run(reason=%s, model=%s)", this.runReason, this.model);
        DataFetcher<?> dataFetcher = this.currentFetcher;
        try {
            try {
                try {
                    if (this.isCancelled) {
                        notifyFailed();
                        if (dataFetcher != null) {
                            dataFetcher.cleanup();
                        }
                        GlideTrace.endSection();
                        return;
                    }
                    runWrapped();
                    if (dataFetcher != null) {
                        dataFetcher.cleanup();
                    }
                    GlideTrace.endSection();
                } catch (CallbackException e) {
                    throw e;
                }
            } catch (Throwable th) {
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "DecodeJob threw unexpectedly, isCancelled: " + this.isCancelled + ", stage: " + this.stage, th);
                }
                if (this.stage != Stage.ENCODE) {
                    this.throwables.add(th);
                    notifyFailed();
                }
                if (!this.isCancelled) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            GlideTrace.endSection();
            throw th2;
        }
    }

    private void runWrapped() {
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (i == 1) {
            this.stage = getNextStage(Stage.INITIALIZE);
            this.currentGenerator = getNextGenerator();
            runGenerators();
        } else if (i == 2) {
            runGenerators();
        } else {
            if (i == 3) {
                decodeFromRetrievedData();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (i == 1) {
            return new ResourceCacheGenerator(this.decodeHelper, this);
        }
        if (i == 2) {
            return new DataCacheGenerator(this.decodeHelper, this);
        }
        if (i == 3) {
            return new SourceGenerator(this.decodeHelper, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.stage);
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean zStartNext = false;
        while (!this.isCancelled && this.currentGenerator != null && !(zStartNext = this.currentGenerator.startNext())) {
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == Stage.SOURCE) {
                reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.stage == Stage.FINISHED || this.isCancelled) && !zStartNext) {
            notifyFailed();
        }
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        this.callback.onLoadFailed(new GlideException("Failed to load resource", new ArrayList(this.throwables)));
        onLoadFailed();
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource, boolean z) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource, z);
    }

    private void setNotifiedOrThrow() {
        Throwable th;
        this.stateVerifier.throwIfRecycled();
        if (this.isCallbackNotified) {
            if (this.throwables.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.throwables;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.isCallbackNotified = true;
    }

    private Stage getNextStage(Stage stage) {
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage.ordinal()];
        if (i == 1) {
            if (this.diskCacheStrategy.decodeCachedData()) {
                return Stage.DATA_CACHE;
            }
            return getNextStage(Stage.DATA_CACHE);
        }
        if (i == 2) {
            return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
        }
        if (i == 3 || i == 4) {
            return Stage.FINISHED;
        }
        if (i == 5) {
            if (this.diskCacheStrategy.decodeCachedResource()) {
                return Stage.RESOURCE_CACHE;
            }
            return getNextStage(Stage.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + stage);
    }

    private void reschedule(RunReason runReason) {
        this.runReason = runReason;
        this.callback.reschedule(this);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void reschedule() {
        reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        this.isLoadingFromAlternateCacheKey = key != this.decodeHelper.getCacheKeys().get(0);
        if (Thread.currentThread() != this.currentThread) {
            reschedule(RunReason.DECODE_DATA);
            return;
        }
        GlideTrace.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            decodeFromRetrievedData();
        } finally {
            GlideTrace.endSection();
        }
    }

    @Override // com.bumptech.glide.load.engine.DataFetcherGenerator.FetcherReadyCallback
    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(glideException);
        if (Thread.currentThread() != this.currentThread) {
            reschedule(RunReason.SWITCH_TO_SOURCE_SERVICE);
        } else {
            runGenerators();
        }
    }

    private void decodeFromRetrievedData() {
        Resource<R> resourceDecodeFromData;
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Retrieved data", this.startFetchTime, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
        }
        try {
            resourceDecodeFromData = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (GlideException e) {
            e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(e);
            resourceDecodeFromData = null;
        }
        if (resourceDecodeFromData != null) {
            notifyEncodeAndRelease(resourceDecodeFromData, this.currentDataSource, this.isLoadingFromAlternateCacheKey);
        } else {
            runGenerators();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void notifyEncodeAndRelease(Resource<R> resource, DataSource dataSource, boolean z) {
        LockedResource lockedResource;
        GlideTrace.beginSection("DecodeJob.notifyEncodeAndRelease");
        try {
            if (resource instanceof Initializable) {
                ((Initializable) resource).initialize();
            }
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                resource = LockedResource.obtain(resource);
                lockedResource = resource;
            } else {
                lockedResource = 0;
            }
            notifyComplete(resource, dataSource, z);
            this.stage = Stage.ENCODE;
            try {
                if (this.deferredEncodeManager.hasResourceToEncode()) {
                    this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
                }
                if (lockedResource != 0) {
                    lockedResource.unlock();
                }
                onEncodeComplete();
                GlideTrace.endSection();
            } catch (Throwable th) {
                if (lockedResource != 0) {
                    lockedResource.unlock();
                }
                throw th;
            }
        } catch (Throwable th2) {
            GlideTrace.endSection();
            throw th2;
        }
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data != null) {
            try {
                long logTime = LogTime.getLogTime();
                Resource<R> resourceDecodeFromFetcher = decodeFromFetcher(data, dataSource);
                if (Log.isLoggable(TAG, 2)) {
                    logWithTimeAndKey("Decoded result " + resourceDecodeFromFetcher, logTime);
                }
                return resourceDecodeFromFetcher;
            } finally {
                dataFetcher.cleanup();
            }
        }
        dataFetcher.cleanup();
        return null;
    }

    private <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        return runLoadPath(data, dataSource, this.decodeHelper.getLoadPath(data.getClass()));
    }

    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        Options options = this.options;
        boolean z = dataSource == DataSource.RESOURCE_DISK_CACHE || this.decodeHelper.isScaleOnlyOrNoTransform();
        Boolean bool = (Boolean) options.get(Downsampler.ALLOW_HARDWARE_CONFIG);
        if (bool != null && (!bool.booleanValue() || z)) {
            return options;
        }
        Options options2 = new Options();
        options2.putAll(this.options);
        options2.set(Downsampler.ALLOW_HARDWARE_CONFIG, Boolean.valueOf(z));
        return options2;
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
        DataRewinder<Data> rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void logWithTimeAndKey(String str, long j) {
        logWithTimeAndKey(str, j, null);
    }

    private void logWithTimeAndKey(String str, long j, String str2) {
        Log.v(TAG, str + " in " + LogTime.getElapsedMillis(j) + ", load key: " + this.loadKey + (str2 != null ? ", " + str2 : FinalChip.BSP_PLATFORM_Null) + ", thread: " + Thread.currentThread().getName());
    }

    @Override // com.bumptech.glide.util.pool.FactoryPools.Poolable
    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    <Z> Resource<Z> onResourceDecoded(DataSource dataSource, Resource<Z> resource) {
        Resource<Z> resourceTransform;
        Transformation<Z> transformation;
        EncodeStrategy encodeStrategy;
        Key dataCacheKey;
        Class<?> cls = resource.get().getClass();
        ResourceEncoder<Z> resultEncoder = null;
        if (dataSource != DataSource.RESOURCE_DISK_CACHE) {
            Transformation<Z> transformation2 = this.decodeHelper.getTransformation(cls);
            transformation = transformation2;
            resourceTransform = transformation2.transform(this.glideContext, resource, this.width, this.height);
        } else {
            resourceTransform = resource;
            transformation = null;
        }
        if (!resource.equals(resourceTransform)) {
            resource.recycle();
        }
        if (this.decodeHelper.isResourceEncoderAvailable(resourceTransform)) {
            resultEncoder = this.decodeHelper.getResultEncoder(resourceTransform);
            encodeStrategy = resultEncoder.getEncodeStrategy(this.options);
        } else {
            encodeStrategy = EncodeStrategy.NONE;
        }
        ResourceEncoder resourceEncoder = resultEncoder;
        if (!this.diskCacheStrategy.isResourceCacheable(!this.decodeHelper.isSourceKey(this.currentSourceKey), dataSource, encodeStrategy)) {
            return resourceTransform;
        }
        if (resourceEncoder == null) {
            throw new Registry.NoResultEncoderAvailableException(resourceTransform.get().getClass());
        }
        int i = AnonymousClass1.$SwitchMap$com$bumptech$glide$load$EncodeStrategy[encodeStrategy.ordinal()];
        if (i == 1) {
            dataCacheKey = new DataCacheKey(this.currentSourceKey, this.signature);
        } else if (i == 2) {
            dataCacheKey = new ResourceCacheKey(this.decodeHelper.getArrayPool(), this.currentSourceKey, this.signature, this.width, this.height, transformation, cls, this.options);
        } else {
            throw new IllegalArgumentException("Unknown strategy: " + encodeStrategy);
        }
        LockedResource lockedResourceObtain = LockedResource.obtain(resourceTransform);
        this.deferredEncodeManager.init(dataCacheKey, resourceEncoder, lockedResourceObtain);
        return lockedResourceObtain;
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.DecodeJob$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$EncodeStrategy;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason;
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage;

        static {
            int[] iArr = new int[EncodeStrategy.values().length];
            $SwitchMap$com$bumptech$glide$load$EncodeStrategy = iArr;
            try {
                iArr[EncodeStrategy.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$EncodeStrategy[EncodeStrategy.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Stage.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = iArr2;
            try {
                iArr2[Stage.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[Stage.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[RunReason.values().length];
            $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = iArr3;
            try {
                iArr3[RunReason.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[RunReason.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource dataSource;

        DecodeCallback(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override // com.bumptech.glide.load.engine.DecodePath.DecodeCallback
        public Resource<Z> onResourceDecoded(Resource<Z> resource) {
            return DecodeJob.this.onResourceDecoded(this.dataSource, resource);
        }
    }

    private static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        ReleaseManager() {
        }

        synchronized boolean release(boolean z) {
            this.isReleased = true;
            return isComplete(z);
        }

        synchronized boolean onEncodeComplete() {
            this.isEncodeComplete = true;
            return isComplete(false);
        }

        synchronized boolean onFailed() {
            this.isFailed = true;
            return isComplete(false);
        }

        synchronized void reset() {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
        }

        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }
    }

    private static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        DeferredEncodeManager() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        <X> void init(Key key, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.key = key;
            this.encoder = resourceEncoder;
            this.toEncode = lockedResource;
        }

        void encode(DiskCacheProvider diskCacheProvider, Options options) {
            GlideTrace.beginSection("DecodeJob.encode");
            try {
                diskCacheProvider.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options));
            } finally {
                this.toEncode.unlock();
                GlideTrace.endSection();
            }
        }

        boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }
    }
}
