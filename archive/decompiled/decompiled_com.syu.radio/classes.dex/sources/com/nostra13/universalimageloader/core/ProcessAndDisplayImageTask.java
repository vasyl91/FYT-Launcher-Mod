package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class ProcessAndDisplayImageTask implements Runnable {
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private final Bitmap bitmap;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    private final ImageLoadingInfo imageLoadingInfo;

    public ProcessAndDisplayImageTask(ImageLoaderEngine engine, Bitmap bitmap, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = engine;
        this.bitmap = bitmap;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.engine.configuration.writeLogs) {
            L.d(LOG_POSTPROCESS_IMAGE, this.imageLoadingInfo.memoryCacheKey);
        }
        BitmapProcessor processor = this.imageLoadingInfo.options.getPostProcessor();
        Bitmap processedBitmap = processor.process(this.bitmap);
        DisplayBitmapTask displayBitmapTask = new DisplayBitmapTask(processedBitmap, this.imageLoadingInfo, this.engine, LoadedFrom.MEMORY_CACHE);
        displayBitmapTask.setLoggingEnabled(this.engine.configuration.writeLogs);
        if (this.imageLoadingInfo.options.isSyncLoading()) {
            displayBitmapTask.run();
        } else {
            this.handler.post(displayBitmapTask);
        }
    }
}
