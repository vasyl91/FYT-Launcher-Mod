package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SyncImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageNonViewAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class ImageLoader {
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = ImageLoader.class.getSimpleName();
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    protected ImageLoader() {
    }

    public synchronized void init(ImageLoaderConfiguration configuration) {
        try {
            if (configuration == null) {
                throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
            }
            if (this.configuration == null) {
                if (configuration.writeLogs) {
                    L.d(LOG_INIT_CONFIG, new Object[0]);
                }
                this.engine = new ImageLoaderEngine(configuration);
                this.configuration = configuration;
            } else {
                L.w(WARNING_RE_INIT_CONFIG, new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean isInited() {
        return this.configuration != null;
    }

    public void displayImage(String uri, ImageAware imageAware) {
        displayImage(uri, imageAware, (DisplayImageOptions) null, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, ImageLoadingListener listener) {
        displayImage(uri, imageAware, (DisplayImageOptions) null, listener);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options) {
        displayImage(uri, imageAware, options, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageAware imageAware, DisplayImageOptions options, ImageLoadingListener listener) {
        checkConfiguration();
        if (imageAware == null) {
            throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
        }
        if (listener == null) {
            listener = this.emptyListener;
        }
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        if (TextUtils.isEmpty(uri)) {
            this.engine.cancelDisplayTaskFor(imageAware);
            listener.onLoadingStarted(uri, imageAware.getWrappedView());
            if (options.shouldShowImageForEmptyUri()) {
                imageAware.setImageDrawable(options.getImageForEmptyUri(this.configuration.resources));
            } else {
                imageAware.setImageDrawable(null);
            }
            listener.onLoadingComplete(uri, imageAware.getWrappedView(), null);
            return;
        }
        ImageSize targetSize = ImageSizeUtils.defineTargetSizeForView(imageAware, this.configuration.getMaxImageSize());
        String memoryCacheKey = MemoryCacheUtil.generateKey(uri, targetSize);
        this.engine.prepareDisplayTaskFor(imageAware, memoryCacheKey);
        listener.onLoadingStarted(uri, imageAware.getWrappedView());
        Bitmap bmp = this.configuration.memoryCache.get(memoryCacheKey);
        if (bmp != null && !bmp.isRecycled()) {
            if (this.configuration.writeLogs) {
                L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, memoryCacheKey);
            }
            if (options.shouldPostProcess()) {
                ImageLoadingInfo imageLoadingInfo = new ImageLoadingInfo(uri, imageAware, targetSize, memoryCacheKey, options, listener, this.engine.getLockForUri(uri));
                ProcessAndDisplayImageTask displayTask = new ProcessAndDisplayImageTask(this.engine, bmp, imageLoadingInfo, options.getHandler());
                if (options.isSyncLoading()) {
                    displayTask.run();
                    return;
                } else {
                    this.engine.submit(displayTask);
                    return;
                }
            }
            listener.onLoadingComplete(uri, imageAware.getWrappedView(), options.getDisplayer().display(bmp, imageAware, LoadedFrom.MEMORY_CACHE));
            return;
        }
        if (options.shouldShowImageOnLoading()) {
            imageAware.setImageDrawable(options.getImageOnLoading(this.configuration.resources));
        } else if (options.isResetViewBeforeLoading()) {
            imageAware.setImageDrawable(null);
        }
        ImageLoadingInfo imageLoadingInfo2 = new ImageLoadingInfo(uri, imageAware, targetSize, memoryCacheKey, options, listener, this.engine.getLockForUri(uri));
        LoadAndDisplayImageTask displayTask2 = new LoadAndDisplayImageTask(this.engine, imageLoadingInfo2, options.getHandler());
        if (options.isSyncLoading()) {
            displayTask2.run();
        } else {
            this.engine.submit(displayTask2);
        }
    }

    public void displayImage(String uri, ImageView imageView) {
        displayImage(uri, new ImageViewAware(imageView), (DisplayImageOptions) null, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options) {
        displayImage(uri, new ImageViewAware(imageView), options, (ImageLoadingListener) null);
    }

    public void displayImage(String uri, ImageView imageView, ImageLoadingListener listener) {
        displayImage(uri, new ImageViewAware(imageView), (DisplayImageOptions) null, listener);
    }

    public void displayImage(String uri, ImageView imageView, DisplayImageOptions options, ImageLoadingListener listener) {
        displayImage(uri, new ImageViewAware(imageView), options, listener);
    }

    public void loadImage(String uri, ImageLoadingListener listener) {
        loadImage(uri, null, null, listener);
    }

    public void loadImage(String uri, ImageSize targetImageSize, ImageLoadingListener listener) {
        loadImage(uri, targetImageSize, null, listener);
    }

    public void loadImage(String uri, DisplayImageOptions options, ImageLoadingListener listener) {
        loadImage(uri, null, options, listener);
    }

    public void loadImage(String uri, ImageSize targetImageSize, DisplayImageOptions options, ImageLoadingListener listener) {
        checkConfiguration();
        if (targetImageSize == null) {
            targetImageSize = this.configuration.getMaxImageSize();
        }
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        ImageNonViewAware imageAware = new ImageNonViewAware(targetImageSize, ViewScaleType.CROP);
        displayImage(uri, imageAware, options, listener);
    }

    public Bitmap loadImageSync(String uri) {
        return loadImageSync(uri, null, null);
    }

    public Bitmap loadImageSync(String uri, DisplayImageOptions options) {
        return loadImageSync(uri, null, options);
    }

    public Bitmap loadImageSync(String uri, ImageSize targetImageSize) {
        return loadImageSync(uri, targetImageSize, null);
    }

    public Bitmap loadImageSync(String uri, ImageSize targetImageSize, DisplayImageOptions options) {
        if (options == null) {
            options = this.configuration.defaultDisplayImageOptions;
        }
        DisplayImageOptions options2 = new DisplayImageOptions.Builder().cloneFrom(options).syncLoading(true).build();
        SyncImageLoadingListener listener = new SyncImageLoadingListener();
        loadImage(uri, targetImageSize, options2, listener);
        return listener.getLoadedBitmap();
    }

    private void checkConfiguration() {
        if (this.configuration == null) {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    public MemoryCacheAware<String, Bitmap> getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    public DiscCacheAware getDiscCache() {
        checkConfiguration();
        return this.configuration.discCache;
    }

    public void clearDiscCache() {
        checkConfiguration();
        this.configuration.discCache.clear();
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        return this.engine.getLoadingUriForView(imageAware);
    }

    public String getLoadingUriForView(ImageView imageView) {
        return this.engine.getLoadingUriForView(new ImageViewAware(imageView));
    }

    public void cancelDisplayTask(ImageAware imageAware) {
        this.engine.cancelDisplayTaskFor(imageAware);
    }

    public void cancelDisplayTask(ImageView imageView) {
        this.engine.cancelDisplayTaskFor(new ImageViewAware(imageView));
    }

    public void denyNetworkDownloads(boolean denyNetworkDownloads) {
        this.engine.denyNetworkDownloads(denyNetworkDownloads);
    }

    public void handleSlowNetwork(boolean handleSlowNetwork) {
        this.engine.handleSlowNetwork(handleSlowNetwork);
    }

    public void pause() {
        this.engine.pause();
    }

    public void resume() {
        this.engine.resume();
    }

    public void stop() {
        this.engine.stop();
    }

    public void destroy() {
        if (this.configuration != null && this.configuration.writeLogs) {
            L.d(LOG_DESTROY, new Object[0]);
        }
        stop();
        this.engine = null;
        this.configuration = null;
    }
}
