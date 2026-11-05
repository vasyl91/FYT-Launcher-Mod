package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class GlideExecutor implements ExecutorService {
    static final String DEFAULT_ANIMATION_EXECUTOR_NAME = "animation";
    static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final String DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    public static Builder newDiskCacheBuilder() {
        return new Builder(true).setThreadCount(1).setName(DEFAULT_DISK_CACHE_EXECUTOR_NAME);
    }

    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public static Builder newSourceBuilder() {
        return new Builder(false).setThreadCount(calculateBestThreadCount()).setName(DEFAULT_SOURCE_EXECUTOR_NAME);
    }

    public static GlideExecutor newSourceExecutor() {
        return newSourceBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    @Deprecated
    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceBuilder().setThreadCount(i).setName(str).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(new DefaultPriorityThreadFactory(), DEFAULT_SOURCE_UNLIMITED_EXECUTOR_NAME, UncaughtThrowableStrategy.DEFAULT, false)));
    }

    public static Builder newAnimationBuilder() {
        return new Builder(true).setThreadCount(calculateAnimationExecutorThreadCount()).setName(DEFAULT_ANIMATION_EXECUTOR_NAME);
    }

    static int calculateAnimationExecutorThreadCount() {
        return calculateBestThreadCount() >= 4 ? 2 : 1;
    }

    public static GlideExecutor newAnimationExecutor() {
        return newAnimationBuilder().build();
    }

    @Deprecated
    public static GlideExecutor newAnimationExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newAnimationBuilder().setThreadCount(i).setUncaughtThrowableStrategy(uncaughtThrowableStrategy).build();
    }

    GlideExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.delegate.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegate.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.delegate.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    public String toString() {
        return this.delegate.toString();
    }

    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        }
        return bestThreadCount;
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW;

        void handle(Throwable th);

        static {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void handle(Throwable th) {
                    if (th == null || !Log.isLoggable(GlideExecutor.TAG, 6)) {
                        return;
                    }
                    Log.e(GlideExecutor.TAG, "Request threw uncaught throwable", th);
                }
            };
            LOG = uncaughtThrowableStrategy;
            THROW = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void handle(Throwable th) {
                    if (th != null) {
                        throw new RuntimeException("Request threw uncaught throwable", th);
                    }
                }
            };
            DEFAULT = uncaughtThrowableStrategy;
        }
    }

    private static final class DefaultPriorityThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;

        private DefaultPriorityThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultPriorityThreadFactory.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Process.setThreadPriority(9);
                    super.run();
                }
            };
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private final ThreadFactory delegate;
        private final String name;
        final boolean preventNetworkOperations;
        private final AtomicInteger threadNum = new AtomicInteger();
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        DefaultThreadFactory(ThreadFactory threadFactory, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.delegate = threadFactory;
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
            this.preventNetworkOperations = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable runnable) {
            Thread threadNewThread = this.delegate.newThread(new Runnable() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DefaultThreadFactory.this.preventNetworkOperations) {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th);
                    }
                }
            });
            threadNewThread.setName("glide-" + this.name + "-thread-" + this.threadNum.getAndIncrement());
            return threadNewThread;
        }
    }

    public static final class Builder {
        public static final long NO_THREAD_TIMEOUT = 0;
        private int corePoolSize;
        private int maximumPoolSize;
        private String name;
        private final boolean preventNetworkOperations;
        private long threadTimeoutMillis;
        private final ThreadFactory threadFactory = new DefaultPriorityThreadFactory();
        private UncaughtThrowableStrategy uncaughtThrowableStrategy = UncaughtThrowableStrategy.DEFAULT;

        Builder(boolean z) {
            this.preventNetworkOperations = z;
        }

        public Builder setThreadTimeoutMillis(long j) {
            this.threadTimeoutMillis = j;
            return this;
        }

        public Builder setThreadCount(int i) {
            this.corePoolSize = i;
            this.maximumPoolSize = i;
            return this;
        }

        public Builder setUncaughtThrowableStrategy(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
            return this;
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }

        public GlideExecutor build() {
            if (TextUtils.isEmpty(this.name)) {
                throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.name);
            }
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSize, this.threadTimeoutMillis, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(this.threadFactory, this.name, this.uncaughtThrowableStrategy, this.preventNetworkOperations));
            if (this.threadTimeoutMillis != 0) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
            return new GlideExecutor(threadPoolExecutor);
        }
    }
}
