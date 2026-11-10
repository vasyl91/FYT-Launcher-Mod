package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class DefaultConfigurationFactory {
    public static Executor createExecutor(int threadPoolSize, int threadPriority, QueueProcessingType tasksProcessingType) {
        boolean lifo = tasksProcessingType == QueueProcessingType.LIFO;
        BlockingQueue<Runnable> taskQueue = lifo ? new LIFOLinkedBlockingDeque<>() : new LinkedBlockingQueue<>();
        return new ThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS, taskQueue, createThreadFactory(threadPriority));
    }

    public static FileNameGenerator createFileNameGenerator() {
        return new HashCodeFileNameGenerator();
    }

    public static DiscCacheAware createDiscCache(Context context, FileNameGenerator discCacheFileNameGenerator, int discCacheSize, int discCacheFileCount) {
        if (discCacheSize > 0) {
            File individualCacheDir = StorageUtils.getIndividualCacheDirectory(context);
            return new TotalSizeLimitedDiscCache(individualCacheDir, discCacheFileNameGenerator, discCacheSize);
        }
        if (discCacheFileCount > 0) {
            File individualCacheDir2 = StorageUtils.getIndividualCacheDirectory(context);
            return new FileCountLimitedDiscCache(individualCacheDir2, discCacheFileNameGenerator, discCacheFileCount);
        }
        File cacheDir = StorageUtils.getCacheDirectory(context);
        return new UnlimitedDiscCache(cacheDir, discCacheFileNameGenerator);
    }

    public static DiscCacheAware createReserveDiscCache(File cacheDir) {
        File individualDir = new File(cacheDir, "uil-images");
        if (individualDir.exists() || individualDir.mkdir()) {
            cacheDir = individualDir;
        }
        return new TotalSizeLimitedDiscCache(cacheDir, AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_END);
    }

    public static MemoryCacheAware<String, Bitmap> createMemoryCache(int memoryCacheSize) {
        if (memoryCacheSize == 0) {
            memoryCacheSize = (int) (Runtime.getRuntime().maxMemory() / 8);
        }
        if (Build.VERSION.SDK_INT >= 9) {
            MemoryCacheAware<String, Bitmap> memoryCache = new LruMemoryCache(memoryCacheSize);
            return memoryCache;
        }
        MemoryCacheAware<String, Bitmap> memoryCache2 = new LRULimitedMemoryCache(memoryCacheSize);
        return memoryCache2;
    }

    public static ImageDownloader createImageDownloader(Context context) {
        return new BaseImageDownloader(context);
    }

    public static ImageDecoder createImageDecoder(boolean loggingEnabled) {
        return new BaseImageDecoder(loggingEnabled);
    }

    public static BitmapDisplayer createBitmapDisplayer() {
        return new SimpleBitmapDisplayer();
    }

    private static ThreadFactory createThreadFactory(int threadPriority) {
        return new DefaultThreadFactory(threadPriority);
    }

    private static class DefaultThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final int threadPriority;

        DefaultThreadFactory(int threadPriority) {
            this.threadPriority = threadPriority;
            SecurityManager s = System.getSecurityManager();
            this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.namePrefix = "uil-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            t.setPriority(this.threadPriority);
            return t;
        }
    }
}
