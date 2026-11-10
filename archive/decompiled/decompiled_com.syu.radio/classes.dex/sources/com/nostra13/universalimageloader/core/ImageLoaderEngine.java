package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ImageLoaderEngine {
    final ImageLoaderConfiguration configuration;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map<Integer, String> cacheKeysForImageAwares = Collections.synchronizedMap(new HashMap());
    private final Map<String, ReentrantLock> uriLocks = new WeakHashMap();
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
    private ExecutorService taskDistributor = Executors.newCachedThreadPool();

    ImageLoaderEngine(ImageLoaderConfiguration configuration) {
        this.configuration = configuration;
        this.taskExecutor = configuration.taskExecutor;
        this.taskExecutorForCachedImages = configuration.taskExecutorForCachedImages;
    }

    void submit(final LoadAndDisplayImageTask task) {
        this.taskDistributor.execute(new Runnable() { // from class: com.nostra13.universalimageloader.core.ImageLoaderEngine.1
            @Override // java.lang.Runnable
            public void run() {
                boolean isImageCachedOnDisc = ImageLoaderEngine.this.configuration.discCache.get(task.getLoadingUri()).exists();
                ImageLoaderEngine.this.initExecutorsIfNeed();
                if (isImageCachedOnDisc) {
                    ImageLoaderEngine.this.taskExecutorForCachedImages.execute(task);
                } else {
                    ImageLoaderEngine.this.taskExecutor.execute(task);
                }
            }
        });
    }

    void submit(ProcessAndDisplayImageTask task) {
        initExecutorsIfNeed();
        this.taskExecutorForCachedImages.execute(task);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExecutorsIfNeed() {
        if (!this.configuration.customExecutor && ((ExecutorService) this.taskExecutor).isShutdown()) {
            this.taskExecutor = createTaskExecutor();
        }
        if (!this.configuration.customExecutorForCachedImages && ((ExecutorService) this.taskExecutorForCachedImages).isShutdown()) {
            this.taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    private Executor createTaskExecutor() {
        return DefaultConfigurationFactory.createExecutor(this.configuration.threadPoolSize, this.configuration.threadPriority, this.configuration.tasksProcessingType);
    }

    String getLoadingUriForView(ImageAware imageAware) {
        return this.cacheKeysForImageAwares.get(Integer.valueOf(imageAware.getId()));
    }

    void prepareDisplayTaskFor(ImageAware imageAware, String memoryCacheKey) {
        this.cacheKeysForImageAwares.put(Integer.valueOf(imageAware.getId()), memoryCacheKey);
    }

    void cancelDisplayTaskFor(ImageAware imageAware) {
        this.cacheKeysForImageAwares.remove(Integer.valueOf(imageAware.getId()));
    }

    void denyNetworkDownloads(boolean denyNetworkDownloads) {
        this.networkDenied.set(denyNetworkDownloads);
    }

    void handleSlowNetwork(boolean handleSlowNetwork) {
        this.slowNetwork.set(handleSlowNetwork);
    }

    void pause() {
        this.paused.set(true);
    }

    void resume() {
        synchronized (this.paused) {
            this.paused.set(false);
            this.paused.notifyAll();
        }
    }

    void stop() {
        if (!this.configuration.customExecutor) {
            ((ExecutorService) this.taskExecutor).shutdownNow();
        }
        if (!this.configuration.customExecutorForCachedImages) {
            ((ExecutorService) this.taskExecutorForCachedImages).shutdownNow();
        }
        this.cacheKeysForImageAwares.clear();
        this.uriLocks.clear();
    }

    ReentrantLock getLockForUri(String uri) {
        ReentrantLock lock = this.uriLocks.get(uri);
        if (lock == null) {
            ReentrantLock lock2 = new ReentrantLock();
            this.uriLocks.put(uri, lock2);
            return lock2;
        }
        return lock;
    }

    AtomicBoolean getPause() {
        return this.paused;
    }

    boolean isNetworkDenied() {
        return this.networkDenied.get();
    }

    boolean isSlowNetwork() {
        return this.slowNetwork.get();
    }
}
