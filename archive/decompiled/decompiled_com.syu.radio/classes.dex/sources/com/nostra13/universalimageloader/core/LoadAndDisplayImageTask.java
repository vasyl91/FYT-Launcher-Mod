package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
final class LoadAndDisplayImageTask implements Runnable {
    private static final int BUFFER_SIZE = 32768;
    private static final String ERROR_POST_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISC_CACHE_NULL = "Bitmap processor for disc cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC = "Process image before cache on disc [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    private final ImageDownloader slowNetworkDownloader;
    private final ImageSize targetSize;
    final String uri;
    private final boolean writeLogs;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private boolean imageAwareCollected = false;

    public LoadAndDisplayImageTask(ImageLoaderEngine engine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = engine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        this.configuration = engine.configuration;
        this.downloader = this.configuration.downloader;
        this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
        this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
        this.decoder = this.configuration.decoder;
        this.writeLogs = this.configuration.writeLogs;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        this.options = imageLoadingInfo.options;
        this.listener = imageLoadingInfo.listener;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (waitIfPaused() || delayIfNeed()) {
            return;
        }
        ReentrantLock loadFromUriLock = this.imageLoadingInfo.loadFromUriLock;
        log(LOG_START_DISPLAY_IMAGE_TASK);
        if (loadFromUriLock.isLocked()) {
            log(LOG_WAITING_FOR_IMAGE_LOADED);
        }
        loadFromUriLock.lock();
        try {
            if (checkTaskIsNotActual()) {
                loadFromUriLock.unlock();
                return;
            }
            Bitmap bmp = this.configuration.memoryCache.get(this.memoryCacheKey);
            if (bmp == null) {
                bmp = tryLoadBitmap();
                if (this.imageAwareCollected) {
                    loadFromUriLock.unlock();
                    return;
                }
                if (bmp == null) {
                    loadFromUriLock.unlock();
                    return;
                }
                if (checkTaskIsNotActual() || checkTaskIsInterrupted()) {
                    loadFromUriLock.unlock();
                    return;
                }
                if (this.options.shouldPreProcess()) {
                    log(LOG_PREPROCESS_IMAGE);
                    bmp = this.options.getPreProcessor().process(bmp);
                    if (bmp == null) {
                        L.e("Pre-processor returned null [%s]", new Object[0]);
                    }
                }
                if (bmp != null && this.options.isCacheInMemory()) {
                    log(LOG_CACHE_IMAGE_IN_MEMORY);
                    this.configuration.memoryCache.put(this.memoryCacheKey, bmp);
                }
            } else {
                this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                log(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING);
            }
            if (bmp != null && this.options.shouldPostProcess()) {
                log(LOG_POSTPROCESS_IMAGE);
                bmp = this.options.getPostProcessor().process(bmp);
                if (bmp == null) {
                    L.e("Pre-processor returned null [%s]", this.memoryCacheKey);
                }
            }
            loadFromUriLock.unlock();
            if (checkTaskIsNotActual() || checkTaskIsInterrupted()) {
                return;
            }
            DisplayBitmapTask displayBitmapTask = new DisplayBitmapTask(bmp, this.imageLoadingInfo, this.engine, this.loadedFrom);
            displayBitmapTask.setLoggingEnabled(this.writeLogs);
            if (this.options.isSyncLoading()) {
                displayBitmapTask.run();
            } else {
                this.handler.post(displayBitmapTask);
            }
        } catch (Throwable th) {
            loadFromUriLock.unlock();
            throw th;
        }
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        synchronized (pause) {
            if (pause.get()) {
                log(LOG_WAITING_FOR_RESUME);
                try {
                    pause.wait();
                    log(LOG_RESUME_AFTER_PAUSE);
                } catch (InterruptedException e) {
                    L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                    return true;
                }
            }
        }
        return checkTaskIsNotActual();
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        log(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            Thread.sleep(this.options.getDelayBeforeLoading());
            return checkTaskIsNotActual();
        } catch (InterruptedException e) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean checkTaskIsNotActual() {
        return checkViewCollected() || checkViewReused();
    }

    private boolean checkViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        this.imageAwareCollected = true;
        log(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED);
        fireCancelEvent();
        return true;
    }

    private boolean checkViewReused() {
        String currentCacheKey = this.engine.getLoadingUriForView(this.imageAware);
        boolean imageAwareWasReused = !this.memoryCacheKey.equals(currentCacheKey);
        if (imageAwareWasReused) {
            log(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED);
            fireCancelEvent();
        }
        return imageAwareWasReused;
    }

    private boolean checkTaskIsInterrupted() {
        boolean interrupted = Thread.interrupted();
        if (interrupted) {
            log(LOG_TASK_INTERRUPTED);
        }
        return interrupted;
    }

    private Bitmap tryLoadBitmap() {
        File imageFile = getImageFileInDiscCache();
        Bitmap bitmap = null;
        try {
            if (imageFile.exists()) {
                log(LOG_LOAD_IMAGE_FROM_DISC_CACHE);
                this.loadedFrom = LoadedFrom.DISC_CACHE;
                bitmap = decodeImage(ImageDownloader.Scheme.FILE.wrap(imageFile.getAbsolutePath()));
                if (this.imageAwareCollected) {
                    return null;
                }
            }
            if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                log(LOG_LOAD_IMAGE_FROM_NETWORK);
                this.loadedFrom = LoadedFrom.NETWORK;
                String imageUriForDecoding = this.options.isCacheOnDisc() ? tryCacheImageOnDisc(imageFile) : this.uri;
                if (!checkTaskIsNotActual()) {
                    bitmap = decodeImage(imageUriForDecoding);
                    if (this.imageAwareCollected) {
                        return null;
                    }
                    if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                        fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
                    }
                }
            }
        } catch (IOException e) {
            L.e(e);
            fireFailEvent(FailReason.FailType.IO_ERROR, e);
            if (imageFile.exists()) {
                imageFile.delete();
            }
        } catch (IllegalStateException e2) {
            fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
        } catch (OutOfMemoryError e3) {
            L.e(e3);
            fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, e3);
        } catch (Throwable e4) {
            L.e(e4);
            fireFailEvent(FailReason.FailType.UNKNOWN, e4);
        }
        return bitmap;
    }

    private File getImageFileInDiscCache() {
        File cacheDir;
        DiscCacheAware discCache = this.configuration.discCache;
        File imageFile = discCache.get(this.uri);
        File cacheDir2 = imageFile.getParentFile();
        if ((cacheDir2 == null || (!cacheDir2.exists() && !cacheDir2.mkdirs())) && (cacheDir = (imageFile = this.configuration.reserveDiscCache.get(this.uri)).getParentFile()) != null && !cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        return imageFile;
    }

    private Bitmap decodeImage(String imageUri) throws IOException {
        ViewScaleType viewScaleType;
        if (checkViewCollected() || (viewScaleType = this.imageAware.getScaleType()) == null) {
            return null;
        }
        ImageDecodingInfo decodingInfo = new ImageDecodingInfo(this.memoryCacheKey, imageUri, this.targetSize, viewScaleType, getDownloader(), this.options);
        return this.decoder.decode(decodingInfo);
    }

    private String tryCacheImageOnDisc(File targetFile) {
        log(LOG_CACHE_IMAGE_ON_DISC);
        try {
            int width = this.configuration.maxImageWidthForDiscCache;
            int height = this.configuration.maxImageHeightForDiscCache;
            boolean saved = false;
            if (width > 0 || height > 0) {
                saved = downloadSizedImage(targetFile, width, height);
            }
            if (!saved) {
                downloadImage(targetFile);
            }
            this.configuration.discCache.put(this.uri, targetFile);
            return ImageDownloader.Scheme.FILE.wrap(targetFile.getAbsolutePath());
        } catch (IOException e) {
            L.e(e);
            if (targetFile.exists()) {
                targetFile.delete();
            }
            return this.uri;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0055 A[PHI: r7
  0x0055: PHI (r7v1 'bmp' android.graphics.Bitmap) = (r7v0 'bmp' android.graphics.Bitmap), (r7v2 'bmp' android.graphics.Bitmap) binds: [B:6:0x0037, B:8:0x0046] A[DONT_GENERATE, DONT_INLINE]] */
    private boolean downloadSizedImage(File targetFile, int maxWidth, int maxHeight) throws IOException {
        OutputStream os;
        boolean zCompress = false;
        ImageSize targetImageSize = new ImageSize(maxWidth, maxHeight);
        DisplayImageOptions specialOptions = new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
        ImageDecodingInfo decodingInfo = new ImageDecodingInfo(this.memoryCacheKey, this.uri, targetImageSize, ViewScaleType.FIT_INSIDE, getDownloader(), specialOptions);
        Bitmap bmp = this.decoder.decode(decodingInfo);
        if (bmp != null) {
            if (this.configuration.processorForDiscCache != null) {
                log(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISC);
                bmp = this.configuration.processorForDiscCache.process(bmp);
                if (bmp == null) {
                    L.e(ERROR_PROCESSOR_FOR_DISC_CACHE_NULL, this.memoryCacheKey);
                } else {
                    os = new BufferedOutputStream(new FileOutputStream(targetFile), 32768);
                    try {
                        zCompress = bmp.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, os);
                        IoUtils.closeSilently(os);
                        bmp.recycle();
                    } catch (Throwable th) {
                        IoUtils.closeSilently(os);
                        throw th;
                    }
                }
            } else {
                os = new BufferedOutputStream(new FileOutputStream(targetFile), 32768);
                zCompress = bmp.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, os);
                IoUtils.closeSilently(os);
                bmp.recycle();
            }
        }
        return zCompress;
    }

    private void downloadImage(File targetFile) throws IOException {
        InputStream is = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        try {
            OutputStream os = new BufferedOutputStream(new FileOutputStream(targetFile), 32768);
            try {
                IoUtils.copyStream(is, os);
                IoUtils.closeSilently(os);
                IoUtils.closeSilently(is);
            } catch (Throwable th) {
                IoUtils.closeSilently(os);
                throw th;
            }
        } catch (Throwable th2) {
            IoUtils.closeSilently(is);
            throw th2;
        }
    }

    private void fireFailEvent(final FailReason.FailType failType, final Throwable failCause) {
        if (!Thread.interrupted()) {
            if (this.options.isSyncLoading()) {
                this.listener.onLoadingFailed(this.uri, this.imageAware.getWrappedView(), new FailReason(failType, failCause));
            } else {
                this.handler.post(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                            LoadAndDisplayImageTask.this.imageAware.setImageDrawable(LoadAndDisplayImageTask.this.options.getImageOnFail(LoadAndDisplayImageTask.this.configuration.resources));
                        }
                        LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView(), new FailReason(failType, failCause));
                    }
                });
            }
        }
    }

    private void fireCancelEvent() {
        if (!Thread.interrupted()) {
            if (this.options.isSyncLoading()) {
                this.listener.onLoadingCancelled(this.uri, this.imageAware.getWrappedView());
            } else {
                this.handler.post(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageAware.getWrappedView());
                    }
                });
            }
        }
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            ImageDownloader d = this.networkDeniedDownloader;
            return d;
        }
        if (this.engine.isSlowNetwork()) {
            ImageDownloader d2 = this.slowNetworkDownloader;
            return d2;
        }
        ImageDownloader d3 = this.downloader;
        return d3;
    }

    String getLoadingUri() {
        return this.uri;
    }

    private void log(String message) {
        if (this.writeLogs) {
            L.d(message, this.memoryCacheKey);
        }
    }

    private void log(String message, Object... args) {
        if (this.writeLogs) {
            L.d(message, args);
        }
    }
}
